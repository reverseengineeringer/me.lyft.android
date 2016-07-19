package com.facebook.share.internal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;
import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookOperationCanceledException;
import com.facebook.FacebookRequestError;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphRequest.Callback;
import com.facebook.GraphRequestBatch;
import com.facebook.GraphRequestBatch.Callback;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.facebook.LoggingBehavior;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.internal.AppCall;
import com.facebook.internal.BundleJSONConverter;
import com.facebook.internal.CallbackManagerImpl.Callback;
import com.facebook.internal.CallbackManagerImpl.RequestCodeOffset;
import com.facebook.internal.FileLruCache;
import com.facebook.internal.FragmentWrapper;
import com.facebook.internal.Logger;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.PlatformServiceClient.CompletedListener;
import com.facebook.internal.Utility;
import com.facebook.internal.WorkQueue;
import com.facebook.share.widget.LikeView.ObjectType;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class LikeActionController
{
  public static final String ACTION_LIKE_ACTION_CONTROLLER_DID_ERROR = "com.facebook.sdk.LikeActionController.DID_ERROR";
  public static final String ACTION_LIKE_ACTION_CONTROLLER_DID_RESET = "com.facebook.sdk.LikeActionController.DID_RESET";
  public static final String ACTION_LIKE_ACTION_CONTROLLER_UPDATED = "com.facebook.sdk.LikeActionController.UPDATED";
  public static final String ACTION_OBJECT_ID_KEY = "com.facebook.sdk.LikeActionController.OBJECT_ID";
  private static final int ERROR_CODE_OBJECT_ALREADY_LIKED = 3501;
  public static final String ERROR_INVALID_OBJECT_ID = "Invalid Object Id";
  public static final String ERROR_PUBLISH_ERROR = "Unable to publish the like/unlike action";
  private static final String JSON_BOOL_IS_OBJECT_LIKED_KEY = "is_object_liked";
  private static final String JSON_BUNDLE_FACEBOOK_DIALOG_ANALYTICS_BUNDLE = "facebook_dialog_analytics_bundle";
  private static final String JSON_INT_OBJECT_TYPE_KEY = "object_type";
  private static final String JSON_INT_VERSION_KEY = "com.facebook.share.internal.LikeActionController.version";
  private static final String JSON_STRING_LIKE_COUNT_WITHOUT_LIKE_KEY = "like_count_string_without_like";
  private static final String JSON_STRING_LIKE_COUNT_WITH_LIKE_KEY = "like_count_string_with_like";
  private static final String JSON_STRING_OBJECT_ID_KEY = "object_id";
  private static final String JSON_STRING_SOCIAL_SENTENCE_WITHOUT_LIKE_KEY = "social_sentence_without_like";
  private static final String JSON_STRING_SOCIAL_SENTENCE_WITH_LIKE_KEY = "social_sentence_with_like";
  private static final String JSON_STRING_UNLIKE_TOKEN_KEY = "unlike_token";
  private static final String LIKE_ACTION_CONTROLLER_STORE = "com.facebook.LikeActionController.CONTROLLER_STORE_KEY";
  private static final String LIKE_ACTION_CONTROLLER_STORE_OBJECT_SUFFIX_KEY = "OBJECT_SUFFIX";
  private static final String LIKE_ACTION_CONTROLLER_STORE_PENDING_OBJECT_ID_KEY = "PENDING_CONTROLLER_KEY";
  private static final int LIKE_ACTION_CONTROLLER_VERSION = 3;
  private static final String LIKE_DIALOG_RESPONSE_LIKE_COUNT_STRING_KEY = "like_count_string";
  private static final String LIKE_DIALOG_RESPONSE_OBJECT_IS_LIKED_KEY = "object_is_liked";
  private static final String LIKE_DIALOG_RESPONSE_SOCIAL_SENTENCE_KEY = "social_sentence";
  private static final String LIKE_DIALOG_RESPONSE_UNLIKE_TOKEN_KEY = "unlike_token";
  private static final int MAX_CACHE_SIZE = 128;
  private static final int MAX_OBJECT_SUFFIX = 1000;
  private static final String TAG = LikeActionController.class.getSimpleName();
  private static AccessTokenTracker accessTokenTracker;
  private static final ConcurrentHashMap<String, LikeActionController> cache = new ConcurrentHashMap();
  private static FileLruCache controllerDiskCache;
  private static WorkQueue diskIOWorkQueue = new WorkQueue(1);
  private static Handler handler;
  private static boolean isInitialized;
  private static WorkQueue mruCacheWorkQueue = new WorkQueue(1);
  private static String objectIdForPendingController;
  private static volatile int objectSuffix;
  private AppEventsLogger appEventsLogger;
  private Bundle facebookDialogAnalyticsBundle;
  private boolean isObjectLiked;
  private boolean isObjectLikedOnServer;
  private boolean isPendingLikeOrUnlike;
  private String likeCountStringWithLike;
  private String likeCountStringWithoutLike;
  private String objectId;
  private boolean objectIsPage;
  private LikeView.ObjectType objectType;
  private String socialSentenceWithLike;
  private String socialSentenceWithoutLike;
  private String unlikeToken;
  private String verifiedObjectId;
  
  private LikeActionController(String paramString, LikeView.ObjectType paramObjectType)
  {
    objectId = paramString;
    objectType = paramObjectType;
  }
  
  private static void broadcastAction(LikeActionController paramLikeActionController, String paramString)
  {
    broadcastAction(paramLikeActionController, paramString, null);
  }
  
  private static void broadcastAction(LikeActionController paramLikeActionController, String paramString, Bundle paramBundle)
  {
    Intent localIntent = new Intent(paramString);
    paramString = paramBundle;
    if (paramLikeActionController != null)
    {
      paramString = paramBundle;
      if (paramBundle == null) {
        paramString = new Bundle();
      }
      paramString.putString("com.facebook.sdk.LikeActionController.OBJECT_ID", paramLikeActionController.getObjectId());
    }
    if (paramString != null) {
      localIntent.putExtras(paramString);
    }
    LocalBroadcastManager.getInstance(FacebookSdk.getApplicationContext()).sendBroadcast(localIntent);
  }
  
  private boolean canUseOGPublish()
  {
    AccessToken localAccessToken = AccessToken.getCurrentAccessToken();
    return (!objectIsPage) && (verifiedObjectId != null) && (localAccessToken != null) && (localAccessToken.getPermissions() != null) && (localAccessToken.getPermissions().contains("publish_actions"));
  }
  
  private void clearState()
  {
    facebookDialogAnalyticsBundle = null;
    storeObjectIdForPendingController(null);
  }
  
  private static void createControllerForObjectIdAndType(String paramString, LikeView.ObjectType paramObjectType, CreationCallback paramCreationCallback)
  {
    Object localObject = getControllerFromInMemoryCache(paramString);
    if (localObject != null)
    {
      verifyControllerAndInvokeCallback((LikeActionController)localObject, paramObjectType, paramCreationCallback);
      return;
    }
    LikeActionController localLikeActionController = deserializeFromDiskSynchronously(paramString);
    localObject = localLikeActionController;
    if (localLikeActionController == null)
    {
      localObject = new LikeActionController(paramString, paramObjectType);
      serializeToDiskAsync((LikeActionController)localObject);
    }
    putControllerInMemoryCache(paramString, (LikeActionController)localObject);
    handler.post(new Runnable()
    {
      public void run()
      {
        val$controllerToRefresh.refreshStatusAsync();
      }
    });
    invokeCallbackWithController(paramCreationCallback, (LikeActionController)localObject, null);
  }
  
  private static LikeActionController deserializeFromDiskSynchronously(String paramString)
  {
    Object localObject2 = null;
    String str = null;
    InputStream localInputStream2 = null;
    localInputStream1 = localInputStream2;
    localObject1 = str;
    try
    {
      paramString = getCacheKeyForObjectId(paramString);
      localInputStream1 = localInputStream2;
      localObject1 = str;
      localInputStream2 = controllerDiskCache.get(paramString);
      paramString = (String)localObject2;
      if (localInputStream2 != null)
      {
        localInputStream1 = localInputStream2;
        localObject1 = localInputStream2;
        str = Utility.readStreamToString(localInputStream2);
        paramString = (String)localObject2;
        localInputStream1 = localInputStream2;
        localObject1 = localInputStream2;
        if (!Utility.isNullOrEmpty(str))
        {
          localInputStream1 = localInputStream2;
          localObject1 = localInputStream2;
          paramString = deserializeFromJson(str);
        }
      }
      localObject1 = paramString;
      if (localInputStream2 != null)
      {
        Utility.closeQuietly(localInputStream2);
        localObject1 = paramString;
      }
    }
    catch (IOException paramString)
    {
      do
      {
        localObject1 = localInputStream1;
        Log.e(TAG, "Unable to deserialize controller from disk", paramString);
        localObject1 = null;
      } while (localInputStream1 == null);
      Utility.closeQuietly(localInputStream1);
      return null;
    }
    finally
    {
      if (localObject1 == null) {
        break label122;
      }
      Utility.closeQuietly((Closeable)localObject1);
    }
    return (LikeActionController)localObject1;
  }
  
  private static LikeActionController deserializeFromJson(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      if (paramString.optInt("com.facebook.share.internal.LikeActionController.version", -1) != 3) {
        return null;
      }
      LikeActionController localLikeActionController = new LikeActionController(paramString.getString("object_id"), LikeView.ObjectType.fromInt(paramString.optInt("object_type", LikeView.ObjectType.UNKNOWN.getValue())));
      likeCountStringWithLike = paramString.optString("like_count_string_with_like", null);
      likeCountStringWithoutLike = paramString.optString("like_count_string_without_like", null);
      socialSentenceWithLike = paramString.optString("social_sentence_with_like", null);
      socialSentenceWithoutLike = paramString.optString("social_sentence_without_like", null);
      isObjectLiked = paramString.optBoolean("is_object_liked");
      unlikeToken = paramString.optString("unlike_token", null);
      JSONObject localJSONObject = paramString.optJSONObject("facebook_dialog_analytics_bundle");
      paramString = localLikeActionController;
      if (localJSONObject != null)
      {
        facebookDialogAnalyticsBundle = BundleJSONConverter.convertToBundle(localJSONObject);
        return localLikeActionController;
      }
    }
    catch (JSONException paramString)
    {
      Log.e(TAG, "Unable to deserialize controller from JSON", paramString);
      paramString = null;
    }
    return paramString;
  }
  
  private void fetchVerifiedObjectId(final RequestCompletionCallback paramRequestCompletionCallback)
  {
    if (!Utility.isNullOrEmpty(verifiedObjectId))
    {
      if (paramRequestCompletionCallback != null) {
        paramRequestCompletionCallback.onComplete();
      }
      return;
    }
    final GetOGObjectIdRequestWrapper localGetOGObjectIdRequestWrapper = new GetOGObjectIdRequestWrapper(objectId, objectType);
    final GetPageIdRequestWrapper localGetPageIdRequestWrapper = new GetPageIdRequestWrapper(objectId, objectType);
    GraphRequestBatch localGraphRequestBatch = new GraphRequestBatch();
    localGetOGObjectIdRequestWrapper.addToBatch(localGraphRequestBatch);
    localGetPageIdRequestWrapper.addToBatch(localGraphRequestBatch);
    localGraphRequestBatch.addCallback(new GraphRequestBatch.Callback()
    {
      public void onBatchCompleted(GraphRequestBatch paramAnonymousGraphRequestBatch)
      {
        LikeActionController.access$1602(LikeActionController.this, localGetOGObjectIdRequestWrapperverifiedObjectId);
        if (Utility.isNullOrEmpty(verifiedObjectId))
        {
          LikeActionController.access$1602(LikeActionController.this, localGetPageIdRequestWrapperverifiedObjectId);
          LikeActionController.access$2302(LikeActionController.this, localGetPageIdRequestWrapperobjectIsPage);
        }
        LikeActionController localLikeActionController;
        if (Utility.isNullOrEmpty(verifiedObjectId))
        {
          Logger.log(LoggingBehavior.DEVELOPER_ERRORS, LikeActionController.TAG, "Unable to verify the FB id for '%s'. Verify that it is a valid FB object or page", new Object[] { objectId });
          localLikeActionController = LikeActionController.this;
          if (localGetPageIdRequestWrapper.getError() == null) {
            break label143;
          }
        }
        label143:
        for (paramAnonymousGraphRequestBatch = localGetPageIdRequestWrapper.getError();; paramAnonymousGraphRequestBatch = localGetOGObjectIdRequestWrapper.getError())
        {
          localLikeActionController.logAppEventForError("get_verified_id", paramAnonymousGraphRequestBatch);
          if (paramRequestCompletionCallback != null) {
            paramRequestCompletionCallback.onComplete();
          }
          return;
        }
      }
    });
    localGraphRequestBatch.executeAsync();
  }
  
  private AppEventsLogger getAppEventsLogger()
  {
    if (appEventsLogger == null) {
      appEventsLogger = AppEventsLogger.newLogger(FacebookSdk.getApplicationContext());
    }
    return appEventsLogger;
  }
  
  private static String getCacheKeyForObjectId(String paramString)
  {
    String str = null;
    Object localObject = AccessToken.getCurrentAccessToken();
    if (localObject != null) {
      str = ((AccessToken)localObject).getToken();
    }
    localObject = str;
    if (str != null) {
      localObject = Utility.md5hash(str);
    }
    return String.format(Locale.ROOT, "%s|%s|com.fb.sdk.like|%d", new Object[] { paramString, Utility.coerceValueIfNullOrEmpty((String)localObject, ""), Integer.valueOf(objectSuffix) });
  }
  
  public static void getControllerForObjectId(String paramString, LikeView.ObjectType paramObjectType, CreationCallback paramCreationCallback)
  {
    if (!isInitialized) {
      performFirstInitialize();
    }
    LikeActionController localLikeActionController = getControllerFromInMemoryCache(paramString);
    if (localLikeActionController != null)
    {
      verifyControllerAndInvokeCallback(localLikeActionController, paramObjectType, paramCreationCallback);
      return;
    }
    diskIOWorkQueue.addActiveWorkItem(new CreateLikeActionControllerWorkItem(paramString, paramObjectType, paramCreationCallback));
  }
  
  private static LikeActionController getControllerFromInMemoryCache(String paramString)
  {
    paramString = getCacheKeyForObjectId(paramString);
    LikeActionController localLikeActionController = (LikeActionController)cache.get(paramString);
    if (localLikeActionController != null) {
      mruCacheWorkQueue.addActiveWorkItem(new MRUCacheWorkItem(paramString, false));
    }
    return localLikeActionController;
  }
  
  private ResultProcessor getResultProcessor(final Bundle paramBundle)
  {
    new ResultProcessor(null)
    {
      public void onCancel(AppCall paramAnonymousAppCall)
      {
        onError(paramAnonymousAppCall, new FacebookOperationCanceledException());
      }
      
      public void onError(AppCall paramAnonymousAppCall, FacebookException paramAnonymousFacebookException)
      {
        Logger.log(LoggingBehavior.REQUESTS, LikeActionController.TAG, "Like Dialog failed with error : %s", new Object[] { paramAnonymousFacebookException });
        if (paramBundle == null) {}
        for (Bundle localBundle = new Bundle();; localBundle = paramBundle)
        {
          localBundle.putString("call_id", paramAnonymousAppCall.getCallId().toString());
          LikeActionController.this.logAppEventForError("present_dialog", localBundle);
          LikeActionController.broadcastAction(LikeActionController.this, "com.facebook.sdk.LikeActionController.DID_ERROR", NativeProtocol.createBundleForException(paramAnonymousFacebookException));
          return;
        }
      }
      
      public void onSuccess(AppCall paramAnonymousAppCall, Bundle paramAnonymousBundle)
      {
        if ((paramAnonymousBundle == null) || (!paramAnonymousBundle.containsKey("object_is_liked"))) {
          return;
        }
        boolean bool = paramAnonymousBundle.getBoolean("object_is_liked");
        String str1 = likeCountStringWithLike;
        String str2 = likeCountStringWithoutLike;
        if (paramAnonymousBundle.containsKey("like_count_string"))
        {
          str1 = paramAnonymousBundle.getString("like_count_string");
          str2 = str1;
        }
        String str3 = socialSentenceWithLike;
        String str4 = socialSentenceWithoutLike;
        if (paramAnonymousBundle.containsKey("social_sentence"))
        {
          str3 = paramAnonymousBundle.getString("social_sentence");
          str4 = str3;
        }
        if (paramAnonymousBundle.containsKey("object_is_liked"))
        {
          paramAnonymousBundle = paramAnonymousBundle.getString("unlike_token");
          if (paramBundle != null) {
            break label189;
          }
        }
        label189:
        for (Bundle localBundle = new Bundle();; localBundle = paramBundle)
        {
          localBundle.putString("call_id", paramAnonymousAppCall.getCallId().toString());
          LikeActionController.this.getAppEventsLogger().logSdkEvent("fb_like_control_dialog_did_succeed", null, localBundle);
          LikeActionController.this.updateState(bool, str1, str2, str3, str4, paramAnonymousBundle);
          return;
          paramAnonymousBundle = unlikeToken;
          break;
        }
      }
    };
  }
  
  public static boolean handleOnActivityResult(int paramInt1, final int paramInt2, final Intent paramIntent)
  {
    if (Utility.isNullOrEmpty(objectIdForPendingController)) {
      objectIdForPendingController = FacebookSdk.getApplicationContext().getSharedPreferences("com.facebook.LikeActionController.CONTROLLER_STORE_KEY", 0).getString("PENDING_CONTROLLER_KEY", null);
    }
    if (Utility.isNullOrEmpty(objectIdForPendingController)) {
      return false;
    }
    getControllerForObjectId(objectIdForPendingController, LikeView.ObjectType.UNKNOWN, new CreationCallback()
    {
      public void onComplete(LikeActionController paramAnonymousLikeActionController, FacebookException paramAnonymousFacebookException)
      {
        if (paramAnonymousFacebookException == null)
        {
          paramAnonymousLikeActionController.onActivityResult(val$requestCode, paramInt2, paramIntent);
          return;
        }
        Utility.logd(LikeActionController.TAG, paramAnonymousFacebookException);
      }
    });
    return true;
  }
  
  private static void invokeCallbackWithController(CreationCallback paramCreationCallback, final LikeActionController paramLikeActionController, final FacebookException paramFacebookException)
  {
    if (paramCreationCallback == null) {
      return;
    }
    handler.post(new Runnable()
    {
      public void run()
      {
        val$callback.onComplete(paramLikeActionController, paramFacebookException);
      }
    });
  }
  
  private void logAppEventForError(String paramString, Bundle paramBundle)
  {
    paramBundle = new Bundle(paramBundle);
    paramBundle.putString("object_id", objectId);
    paramBundle.putString("object_type", objectType.toString());
    paramBundle.putString("current_action", paramString);
    getAppEventsLogger().logSdkEvent("fb_like_control_error", null, paramBundle);
  }
  
  private void logAppEventForError(String paramString, FacebookRequestError paramFacebookRequestError)
  {
    Bundle localBundle = new Bundle();
    if (paramFacebookRequestError != null)
    {
      paramFacebookRequestError = paramFacebookRequestError.getRequestResult();
      if (paramFacebookRequestError != null) {
        localBundle.putString("error", paramFacebookRequestError.toString());
      }
    }
    logAppEventForError(paramString, localBundle);
  }
  
  private void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    ShareInternalUtility.handleActivityResult(paramInt1, paramInt2, paramIntent, getResultProcessor(facebookDialogAnalyticsBundle));
    clearState();
  }
  
  /* Error */
  private static void performFirstInitialize()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 583	com/facebook/share/internal/LikeActionController:isInitialized	Z
    //   6: istore_0
    //   7: iload_0
    //   8: ifeq +7 -> 15
    //   11: ldc 2
    //   13: monitorexit
    //   14: return
    //   15: new 425	android/os/Handler
    //   18: dup
    //   19: invokestatic 661	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   22: invokespecial 664	android/os/Handler:<init>	(Landroid/os/Looper;)V
    //   25: putstatic 421	com/facebook/share/internal/LikeActionController:handler	Landroid/os/Handler;
    //   28: invokestatic 363	com/facebook/FacebookSdk:getApplicationContext	()Landroid/content/Context;
    //   31: ldc -122
    //   33: iconst_0
    //   34: invokevirtual 613	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   37: ldc -119
    //   39: iconst_1
    //   40: invokeinterface 667 3 0
    //   45: putstatic 318	com/facebook/share/internal/LikeActionController:objectSuffix	I
    //   48: new 441	com/facebook/internal/FileLruCache
    //   51: dup
    //   52: getstatic 200	com/facebook/share/internal/LikeActionController:TAG	Ljava/lang/String;
    //   55: new 669	com/facebook/internal/FileLruCache$Limits
    //   58: dup
    //   59: invokespecial 670	com/facebook/internal/FileLruCache$Limits:<init>	()V
    //   62: invokespecial 673	com/facebook/internal/FileLruCache:<init>	(Ljava/lang/String;Lcom/facebook/internal/FileLruCache$Limits;)V
    //   65: putstatic 326	com/facebook/share/internal/LikeActionController:controllerDiskCache	Lcom/facebook/internal/FileLruCache;
    //   68: invokestatic 676	com/facebook/share/internal/LikeActionController:registerAccessTokenTracker	()V
    //   71: getstatic 682	com/facebook/internal/CallbackManagerImpl$RequestCodeOffset:Like	Lcom/facebook/internal/CallbackManagerImpl$RequestCodeOffset;
    //   74: invokevirtual 685	com/facebook/internal/CallbackManagerImpl$RequestCodeOffset:toRequestCode	()I
    //   77: new 16	com/facebook/share/internal/LikeActionController$3
    //   80: dup
    //   81: invokespecial 686	com/facebook/share/internal/LikeActionController$3:<init>	()V
    //   84: invokestatic 692	com/facebook/internal/CallbackManagerImpl:registerStaticCallback	(ILcom/facebook/internal/CallbackManagerImpl$Callback;)V
    //   87: iconst_1
    //   88: putstatic 583	com/facebook/share/internal/LikeActionController:isInitialized	Z
    //   91: goto -80 -> 11
    //   94: astore_1
    //   95: ldc 2
    //   97: monitorexit
    //   98: aload_1
    //   99: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   6	2	0	bool	boolean
    //   94	5	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	7	94	finally
    //   15	91	94	finally
  }
  
  private void presentLikeDialog(Activity paramActivity, FragmentWrapper paramFragmentWrapper, Bundle paramBundle)
  {
    Object localObject = null;
    if (LikeDialog.canShowNativeDialog())
    {
      localObject = "fb_like_control_did_present_dialog";
      if (localObject != null)
      {
        if (objectType == null) {
          break label134;
        }
        localObject = objectType.toString();
        label35:
        localObject = new LikeContent.Builder().setObjectId(objectId).setObjectType((String)localObject).build();
        if (paramFragmentWrapper == null) {
          break label145;
        }
        new LikeDialog(paramFragmentWrapper).show(localObject);
      }
    }
    for (;;)
    {
      saveState(paramBundle);
      getAppEventsLogger().logSdkEvent("fb_like_control_did_present_dialog", null, paramBundle);
      return;
      if (LikeDialog.canShowWebFallback())
      {
        localObject = "fb_like_control_did_present_fallback_dialog";
        break;
      }
      logAppEventForError("present_dialog", paramBundle);
      Utility.logd(TAG, "Cannot show the Like Dialog on this device.");
      broadcastAction(null, "com.facebook.sdk.LikeActionController.UPDATED");
      break;
      label134:
      localObject = LikeView.ObjectType.UNKNOWN.toString();
      break label35;
      label145:
      new LikeDialog(paramActivity).show(localObject);
    }
  }
  
  private void publishAgainIfNeeded(Bundle paramBundle)
  {
    if ((isObjectLiked != isObjectLikedOnServer) && (!publishLikeOrUnlikeAsync(isObjectLiked, paramBundle))) {
      if (isObjectLiked) {
        break label38;
      }
    }
    label38:
    for (boolean bool = true;; bool = false)
    {
      publishDidError(bool);
      return;
    }
  }
  
  private void publishDidError(boolean paramBoolean)
  {
    updateLikeState(paramBoolean);
    Bundle localBundle = new Bundle();
    localBundle.putString("com.facebook.platform.status.ERROR_DESCRIPTION", "Unable to publish the like/unlike action");
    broadcastAction(this, "com.facebook.sdk.LikeActionController.DID_ERROR", localBundle);
  }
  
  private void publishLikeAsync(final Bundle paramBundle)
  {
    isPendingLikeOrUnlike = true;
    fetchVerifiedObjectId(new RequestCompletionCallback()
    {
      public void onComplete()
      {
        if (Utility.isNullOrEmpty(verifiedObjectId))
        {
          localObject = new Bundle();
          ((Bundle)localObject).putString("com.facebook.platform.status.ERROR_DESCRIPTION", "Invalid Object Id");
          LikeActionController.broadcastAction(LikeActionController.this, "com.facebook.sdk.LikeActionController.DID_ERROR", (Bundle)localObject);
          return;
        }
        Object localObject = new GraphRequestBatch();
        final LikeActionController.PublishLikeRequestWrapper localPublishLikeRequestWrapper = new LikeActionController.PublishLikeRequestWrapper(LikeActionController.this, verifiedObjectId, objectType);
        localPublishLikeRequestWrapper.addToBatch((GraphRequestBatch)localObject);
        ((GraphRequestBatch)localObject).addCallback(new GraphRequestBatch.Callback()
        {
          public void onBatchCompleted(GraphRequestBatch paramAnonymous2GraphRequestBatch)
          {
            LikeActionController.access$1802(LikeActionController.this, false);
            if (localPublishLikeRequestWrapper.getError() != null)
            {
              LikeActionController.this.publishDidError(false);
              return;
            }
            LikeActionController.access$1102(LikeActionController.this, Utility.coerceValueIfNullOrEmpty(localPublishLikeRequestWrapperunlikeToken, null));
            LikeActionController.access$2002(LikeActionController.this, true);
            LikeActionController.this.getAppEventsLogger().logSdkEvent("fb_like_control_did_like", null, val$analyticsParameters);
            LikeActionController.this.publishAgainIfNeeded(val$analyticsParameters);
          }
        });
        ((GraphRequestBatch)localObject).executeAsync();
      }
    });
  }
  
  private boolean publishLikeOrUnlikeAsync(boolean paramBoolean, Bundle paramBundle)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (canUseOGPublish())
    {
      if (!paramBoolean) {
        break label26;
      }
      bool1 = true;
      publishLikeAsync(paramBundle);
    }
    label26:
    do
    {
      return bool1;
      bool1 = bool2;
    } while (Utility.isNullOrEmpty(unlikeToken));
    publishUnlikeAsync(paramBundle);
    return true;
  }
  
  private void publishUnlikeAsync(final Bundle paramBundle)
  {
    isPendingLikeOrUnlike = true;
    GraphRequestBatch localGraphRequestBatch = new GraphRequestBatch();
    final PublishUnlikeRequestWrapper localPublishUnlikeRequestWrapper = new PublishUnlikeRequestWrapper(unlikeToken);
    localPublishUnlikeRequestWrapper.addToBatch(localGraphRequestBatch);
    localGraphRequestBatch.addCallback(new GraphRequestBatch.Callback()
    {
      public void onBatchCompleted(GraphRequestBatch paramAnonymousGraphRequestBatch)
      {
        LikeActionController.access$1802(LikeActionController.this, false);
        if (localPublishUnlikeRequestWrapper.getError() != null)
        {
          LikeActionController.this.publishDidError(true);
          return;
        }
        LikeActionController.access$1102(LikeActionController.this, null);
        LikeActionController.access$2002(LikeActionController.this, false);
        LikeActionController.this.getAppEventsLogger().logSdkEvent("fb_like_control_did_unlike", null, paramBundle);
        LikeActionController.this.publishAgainIfNeeded(paramBundle);
      }
    });
    localGraphRequestBatch.executeAsync();
  }
  
  private static void putControllerInMemoryCache(String paramString, LikeActionController paramLikeActionController)
  {
    paramString = getCacheKeyForObjectId(paramString);
    mruCacheWorkQueue.addActiveWorkItem(new MRUCacheWorkItem(paramString, true));
    cache.put(paramString, paramLikeActionController);
  }
  
  private void refreshStatusAsync()
  {
    if (AccessToken.getCurrentAccessToken() == null)
    {
      refreshStatusViaService();
      return;
    }
    fetchVerifiedObjectId(new RequestCompletionCallback()
    {
      public void onComplete()
      {
        switch (LikeActionController.12.$SwitchMap$com$facebook$share$widget$LikeView$ObjectType[objectType.ordinal()])
        {
        }
        for (final Object localObject = new LikeActionController.GetOGObjectLikesRequestWrapper(LikeActionController.this, verifiedObjectId, objectType);; localObject = new LikeActionController.GetPageLikesRequestWrapper(LikeActionController.this, verifiedObjectId))
        {
          final LikeActionController.GetEngagementRequestWrapper localGetEngagementRequestWrapper = new LikeActionController.GetEngagementRequestWrapper(LikeActionController.this, verifiedObjectId, objectType);
          GraphRequestBatch localGraphRequestBatch = new GraphRequestBatch();
          ((LikeActionController.LikeRequestWrapper)localObject).addToBatch(localGraphRequestBatch);
          localGetEngagementRequestWrapper.addToBatch(localGraphRequestBatch);
          localGraphRequestBatch.addCallback(new GraphRequestBatch.Callback()
          {
            public void onBatchCompleted(GraphRequestBatch paramAnonymous2GraphRequestBatch)
            {
              if ((localObject.getError() != null) || (localGetEngagementRequestWrapper.getError() != null))
              {
                Logger.log(LoggingBehavior.REQUESTS, LikeActionController.TAG, "Unable to refresh like state for id: '%s'", new Object[] { objectId });
                return;
              }
              LikeActionController.this.updateState(localObject.isObjectLiked(), localGetEngagementRequestWrapperlikeCountStringWithLike, localGetEngagementRequestWrapperlikeCountStringWithoutLike, localGetEngagementRequestWrappersocialSentenceStringWithLike, localGetEngagementRequestWrappersocialSentenceStringWithoutLike, localObject.getUnlikeToken());
            }
          });
          localGraphRequestBatch.executeAsync();
          return;
        }
      }
    });
  }
  
  private void refreshStatusViaService()
  {
    LikeStatusClient localLikeStatusClient = new LikeStatusClient(FacebookSdk.getApplicationContext(), FacebookSdk.getApplicationId(), objectId);
    if (!localLikeStatusClient.start()) {
      return;
    }
    localLikeStatusClient.setCompletedListener(new PlatformServiceClient.CompletedListener()
    {
      public void completed(Bundle paramAnonymousBundle)
      {
        if ((paramAnonymousBundle == null) || (!paramAnonymousBundle.containsKey("com.facebook.platform.extra.OBJECT_IS_LIKED"))) {
          return;
        }
        boolean bool = paramAnonymousBundle.getBoolean("com.facebook.platform.extra.OBJECT_IS_LIKED");
        String str1;
        String str2;
        label54:
        String str3;
        label71:
        String str4;
        if (paramAnonymousBundle.containsKey("com.facebook.platform.extra.LIKE_COUNT_STRING_WITH_LIKE"))
        {
          str1 = paramAnonymousBundle.getString("com.facebook.platform.extra.LIKE_COUNT_STRING_WITH_LIKE");
          if (!paramAnonymousBundle.containsKey("com.facebook.platform.extra.LIKE_COUNT_STRING_WITHOUT_LIKE")) {
            break label132;
          }
          str2 = paramAnonymousBundle.getString("com.facebook.platform.extra.LIKE_COUNT_STRING_WITHOUT_LIKE");
          if (!paramAnonymousBundle.containsKey("com.facebook.platform.extra.SOCIAL_SENTENCE_WITH_LIKE")) {
            break label144;
          }
          str3 = paramAnonymousBundle.getString("com.facebook.platform.extra.SOCIAL_SENTENCE_WITH_LIKE");
          if (!paramAnonymousBundle.containsKey("com.facebook.platform.extra.SOCIAL_SENTENCE_WITHOUT_LIKE")) {
            break label156;
          }
          str4 = paramAnonymousBundle.getString("com.facebook.platform.extra.SOCIAL_SENTENCE_WITHOUT_LIKE");
          label88:
          if (!paramAnonymousBundle.containsKey("com.facebook.platform.extra.UNLIKE_TOKEN")) {
            break label168;
          }
        }
        label132:
        label144:
        label156:
        label168:
        for (paramAnonymousBundle = paramAnonymousBundle.getString("com.facebook.platform.extra.UNLIKE_TOKEN");; paramAnonymousBundle = unlikeToken)
        {
          LikeActionController.this.updateState(bool, str1, str2, str3, str4, paramAnonymousBundle);
          return;
          str1 = likeCountStringWithLike;
          break;
          str2 = likeCountStringWithoutLike;
          break label54;
          str3 = socialSentenceWithLike;
          break label71;
          str4 = socialSentenceWithoutLike;
          break label88;
        }
      }
    });
  }
  
  private static void registerAccessTokenTracker()
  {
    accessTokenTracker = new AccessTokenTracker()
    {
      protected void onCurrentAccessTokenChanged(AccessToken paramAnonymousAccessToken1, AccessToken paramAnonymousAccessToken2)
      {
        paramAnonymousAccessToken1 = FacebookSdk.getApplicationContext();
        if (paramAnonymousAccessToken2 == null)
        {
          LikeActionController.access$302((LikeActionController.objectSuffix + 1) % 1000);
          paramAnonymousAccessToken1.getSharedPreferences("com.facebook.LikeActionController.CONTROLLER_STORE_KEY", 0).edit().putInt("OBJECT_SUFFIX", LikeActionController.objectSuffix).apply();
          LikeActionController.cache.clear();
          LikeActionController.controllerDiskCache.clearCache();
        }
        LikeActionController.broadcastAction(null, "com.facebook.sdk.LikeActionController.DID_RESET");
      }
    };
  }
  
  private void saveState(Bundle paramBundle)
  {
    storeObjectIdForPendingController(objectId);
    facebookDialogAnalyticsBundle = paramBundle;
    serializeToDiskAsync(this);
  }
  
  private static void serializeToDiskAsync(LikeActionController paramLikeActionController)
  {
    String str = serializeToJson(paramLikeActionController);
    paramLikeActionController = getCacheKeyForObjectId(objectId);
    if ((!Utility.isNullOrEmpty(str)) && (!Utility.isNullOrEmpty(paramLikeActionController))) {
      diskIOWorkQueue.addActiveWorkItem(new SerializeToDiskWorkItem(paramLikeActionController, str));
    }
  }
  
  private static void serializeToDiskSynchronously(String paramString1, String paramString2)
  {
    Object localObject = null;
    String str = null;
    try
    {
      paramString1 = controllerDiskCache.openPutStream(paramString1);
      str = paramString1;
      localObject = paramString1;
      paramString1.write(paramString2.getBytes());
      if (paramString1 != null) {
        Utility.closeQuietly(paramString1);
      }
      return;
    }
    catch (IOException paramString1)
    {
      do
      {
        localObject = str;
        Log.e(TAG, "Unable to serialize controller to disk", paramString1);
      } while (str == null);
      Utility.closeQuietly(str);
      return;
    }
    finally
    {
      if (localObject != null) {
        Utility.closeQuietly((Closeable)localObject);
      }
    }
  }
  
  private static String serializeToJson(LikeActionController paramLikeActionController)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("com.facebook.share.internal.LikeActionController.version", 3);
      localJSONObject.put("object_id", objectId);
      localJSONObject.put("object_type", objectType.getValue());
      localJSONObject.put("like_count_string_with_like", likeCountStringWithLike);
      localJSONObject.put("like_count_string_without_like", likeCountStringWithoutLike);
      localJSONObject.put("social_sentence_with_like", socialSentenceWithLike);
      localJSONObject.put("social_sentence_without_like", socialSentenceWithoutLike);
      localJSONObject.put("is_object_liked", isObjectLiked);
      localJSONObject.put("unlike_token", unlikeToken);
      if (facebookDialogAnalyticsBundle != null)
      {
        paramLikeActionController = BundleJSONConverter.convertToJSON(facebookDialogAnalyticsBundle);
        if (paramLikeActionController != null) {
          localJSONObject.put("facebook_dialog_analytics_bundle", paramLikeActionController);
        }
      }
      return localJSONObject.toString();
    }
    catch (JSONException paramLikeActionController)
    {
      Log.e(TAG, "Unable to serialize controller to JSON", paramLikeActionController);
    }
    return null;
  }
  
  private static void storeObjectIdForPendingController(String paramString)
  {
    objectIdForPendingController = paramString;
    FacebookSdk.getApplicationContext().getSharedPreferences("com.facebook.LikeActionController.CONTROLLER_STORE_KEY", 0).edit().putString("PENDING_CONTROLLER_KEY", objectIdForPendingController).apply();
  }
  
  private void updateLikeState(boolean paramBoolean)
  {
    updateState(paramBoolean, likeCountStringWithLike, likeCountStringWithoutLike, socialSentenceWithLike, socialSentenceWithoutLike, unlikeToken);
  }
  
  private void updateState(boolean paramBoolean, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    paramString1 = Utility.coerceValueIfNullOrEmpty(paramString1, null);
    paramString2 = Utility.coerceValueIfNullOrEmpty(paramString2, null);
    paramString3 = Utility.coerceValueIfNullOrEmpty(paramString3, null);
    paramString4 = Utility.coerceValueIfNullOrEmpty(paramString4, null);
    paramString5 = Utility.coerceValueIfNullOrEmpty(paramString5, null);
    if ((paramBoolean != isObjectLiked) || (!Utility.areObjectsEqual(paramString1, likeCountStringWithLike)) || (!Utility.areObjectsEqual(paramString2, likeCountStringWithoutLike)) || (!Utility.areObjectsEqual(paramString3, socialSentenceWithLike)) || (!Utility.areObjectsEqual(paramString4, socialSentenceWithoutLike)) || (!Utility.areObjectsEqual(paramString5, unlikeToken))) {}
    for (int i = 1; i == 0; i = 0) {
      return;
    }
    isObjectLiked = paramBoolean;
    likeCountStringWithLike = paramString1;
    likeCountStringWithoutLike = paramString2;
    socialSentenceWithLike = paramString3;
    socialSentenceWithoutLike = paramString4;
    unlikeToken = paramString5;
    serializeToDiskAsync(this);
    broadcastAction(this, "com.facebook.sdk.LikeActionController.UPDATED");
  }
  
  private static void verifyControllerAndInvokeCallback(LikeActionController paramLikeActionController, LikeView.ObjectType paramObjectType, CreationCallback paramCreationCallback)
  {
    LikeView.ObjectType localObjectType = ShareInternalUtility.getMostSpecificObjectType(paramObjectType, objectType);
    Object localObject = null;
    if (localObjectType == null)
    {
      paramObjectType = new FacebookException("Object with id:\"%s\" is already marked as type:\"%s\". Cannot change the type to:\"%s\"", new Object[] { objectId, objectType.toString(), paramObjectType.toString() });
      paramLikeActionController = null;
    }
    for (;;)
    {
      invokeCallbackWithController(paramCreationCallback, paramLikeActionController, paramObjectType);
      return;
      objectType = localObjectType;
      paramObjectType = (LikeView.ObjectType)localObject;
    }
  }
  
  public String getLikeCountString()
  {
    if (isObjectLiked) {
      return likeCountStringWithLike;
    }
    return likeCountStringWithoutLike;
  }
  
  public String getObjectId()
  {
    return objectId;
  }
  
  public String getSocialSentence()
  {
    if (isObjectLiked) {
      return socialSentenceWithLike;
    }
    return socialSentenceWithoutLike;
  }
  
  public boolean isObjectLiked()
  {
    return isObjectLiked;
  }
  
  public boolean shouldEnableView()
  {
    if ((LikeDialog.canShowNativeDialog()) || (LikeDialog.canShowWebFallback())) {}
    AccessToken localAccessToken;
    do
    {
      return true;
      if ((objectIsPage) || (objectType == LikeView.ObjectType.PAGE)) {
        return false;
      }
      localAccessToken = AccessToken.getCurrentAccessToken();
    } while ((localAccessToken != null) && (localAccessToken.getPermissions() != null) && (localAccessToken.getPermissions().contains("publish_actions")));
    return false;
  }
  
  public void toggleLike(Activity paramActivity, FragmentWrapper paramFragmentWrapper, Bundle paramBundle)
  {
    boolean bool2 = true;
    if (!isObjectLiked)
    {
      bool1 = true;
      if (!canUseOGPublish()) {
        break label91;
      }
      updateLikeState(bool1);
      if (!isPendingLikeOrUnlike) {
        break label52;
      }
      getAppEventsLogger().logSdkEvent("fb_like_control_did_undo_quickly", null, paramBundle);
    }
    label52:
    while (publishLikeOrUnlikeAsync(bool1, paramBundle))
    {
      return;
      bool1 = false;
      break;
    }
    if (!bool1) {}
    for (boolean bool1 = bool2;; bool1 = false)
    {
      updateLikeState(bool1);
      presentLikeDialog(paramActivity, paramFragmentWrapper, paramBundle);
      return;
    }
    label91:
    presentLikeDialog(paramActivity, paramFragmentWrapper, paramBundle);
  }
  
  private abstract class AbstractRequestWrapper
    implements LikeActionController.RequestWrapper
  {
    protected FacebookRequestError error;
    protected String objectId;
    protected LikeView.ObjectType objectType;
    private GraphRequest request;
    
    protected AbstractRequestWrapper(String paramString, LikeView.ObjectType paramObjectType)
    {
      objectId = paramString;
      objectType = paramObjectType;
    }
    
    public void addToBatch(GraphRequestBatch paramGraphRequestBatch)
    {
      paramGraphRequestBatch.add(request);
    }
    
    public FacebookRequestError getError()
    {
      return error;
    }
    
    protected void processError(FacebookRequestError paramFacebookRequestError)
    {
      Logger.log(LoggingBehavior.REQUESTS, LikeActionController.TAG, "Error running request for object '%s' with type '%s' : %s", new Object[] { objectId, objectType, paramFacebookRequestError });
    }
    
    protected abstract void processSuccess(GraphResponse paramGraphResponse);
    
    protected void setRequest(GraphRequest paramGraphRequest)
    {
      request = paramGraphRequest;
      paramGraphRequest.setVersion("v2.6");
      paramGraphRequest.setCallback(new GraphRequest.Callback()
      {
        public void onCompleted(GraphResponse paramAnonymousGraphResponse)
        {
          error = paramAnonymousGraphResponse.getError();
          if (error != null)
          {
            processError(error);
            return;
          }
          processSuccess(paramAnonymousGraphResponse);
        }
      });
    }
  }
  
  private static class CreateLikeActionControllerWorkItem
    implements Runnable
  {
    private LikeActionController.CreationCallback callback;
    private String objectId;
    private LikeView.ObjectType objectType;
    
    CreateLikeActionControllerWorkItem(String paramString, LikeView.ObjectType paramObjectType, LikeActionController.CreationCallback paramCreationCallback)
    {
      objectId = paramString;
      objectType = paramObjectType;
      callback = paramCreationCallback;
    }
    
    public void run()
    {
      LikeActionController.createControllerForObjectIdAndType(objectId, objectType, callback);
    }
  }
  
  public static abstract interface CreationCallback
  {
    public abstract void onComplete(LikeActionController paramLikeActionController, FacebookException paramFacebookException);
  }
  
  private class GetEngagementRequestWrapper
    extends LikeActionController.AbstractRequestWrapper
  {
    String likeCountStringWithLike = likeCountStringWithLike;
    String likeCountStringWithoutLike = likeCountStringWithoutLike;
    String socialSentenceStringWithLike = socialSentenceWithLike;
    String socialSentenceStringWithoutLike = socialSentenceWithoutLike;
    
    GetEngagementRequestWrapper(String paramString, LikeView.ObjectType paramObjectType)
    {
      super(paramString, paramObjectType);
      this$1 = new Bundle();
      putString("fields", "engagement.fields(count_string_with_like,count_string_without_like,social_sentence_with_like,social_sentence_without_like)");
      putString("locale", Locale.getDefault().toString());
      setRequest(new GraphRequest(AccessToken.getCurrentAccessToken(), paramString, LikeActionController.this, HttpMethod.GET));
    }
    
    protected void processError(FacebookRequestError paramFacebookRequestError)
    {
      Logger.log(LoggingBehavior.REQUESTS, LikeActionController.TAG, "Error fetching engagement for object '%s' with type '%s' : %s", new Object[] { objectId, objectType, paramFacebookRequestError });
      LikeActionController.this.logAppEventForError("get_engagement", paramFacebookRequestError);
    }
    
    protected void processSuccess(GraphResponse paramGraphResponse)
    {
      paramGraphResponse = Utility.tryGetJSONObjectFromResponse(paramGraphResponse.getJSONObject(), "engagement");
      if (paramGraphResponse != null)
      {
        likeCountStringWithLike = paramGraphResponse.optString("count_string_with_like", likeCountStringWithLike);
        likeCountStringWithoutLike = paramGraphResponse.optString("count_string_without_like", likeCountStringWithoutLike);
        socialSentenceStringWithLike = paramGraphResponse.optString("social_sentence_with_like", socialSentenceStringWithLike);
        socialSentenceStringWithoutLike = paramGraphResponse.optString("social_sentence_without_like", socialSentenceStringWithoutLike);
      }
    }
  }
  
  private class GetOGObjectIdRequestWrapper
    extends LikeActionController.AbstractRequestWrapper
  {
    String verifiedObjectId;
    
    GetOGObjectIdRequestWrapper(String paramString, LikeView.ObjectType paramObjectType)
    {
      super(paramString, paramObjectType);
      this$1 = new Bundle();
      putString("fields", "og_object.fields(id)");
      putString("ids", paramString);
      setRequest(new GraphRequest(AccessToken.getCurrentAccessToken(), "", LikeActionController.this, HttpMethod.GET));
    }
    
    protected void processError(FacebookRequestError paramFacebookRequestError)
    {
      if (paramFacebookRequestError.getErrorMessage().contains("og_object"))
      {
        error = null;
        return;
      }
      Logger.log(LoggingBehavior.REQUESTS, LikeActionController.TAG, "Error getting the FB id for object '%s' with type '%s' : %s", new Object[] { objectId, objectType, paramFacebookRequestError });
    }
    
    protected void processSuccess(GraphResponse paramGraphResponse)
    {
      paramGraphResponse = Utility.tryGetJSONObjectFromResponse(paramGraphResponse.getJSONObject(), objectId);
      if (paramGraphResponse != null)
      {
        paramGraphResponse = paramGraphResponse.optJSONObject("og_object");
        if (paramGraphResponse != null) {
          verifiedObjectId = paramGraphResponse.optString("id");
        }
      }
    }
  }
  
  private class GetOGObjectLikesRequestWrapper
    extends LikeActionController.AbstractRequestWrapper
    implements LikeActionController.LikeRequestWrapper
  {
    private final String objectId;
    private boolean objectIsLiked = isObjectLiked;
    private final LikeView.ObjectType objectType;
    private String unlikeToken;
    
    GetOGObjectLikesRequestWrapper(String paramString, LikeView.ObjectType paramObjectType)
    {
      super(paramString, paramObjectType);
      objectId = paramString;
      objectType = paramObjectType;
      this$1 = new Bundle();
      putString("fields", "id,application");
      putString("object", objectId);
      setRequest(new GraphRequest(AccessToken.getCurrentAccessToken(), "me/og.likes", LikeActionController.this, HttpMethod.GET));
    }
    
    public String getUnlikeToken()
    {
      return unlikeToken;
    }
    
    public boolean isObjectLiked()
    {
      return objectIsLiked;
    }
    
    protected void processError(FacebookRequestError paramFacebookRequestError)
    {
      Logger.log(LoggingBehavior.REQUESTS, LikeActionController.TAG, "Error fetching like status for object '%s' with type '%s' : %s", new Object[] { objectId, objectType, paramFacebookRequestError });
      LikeActionController.this.logAppEventForError("get_og_object_like", paramFacebookRequestError);
    }
    
    protected void processSuccess(GraphResponse paramGraphResponse)
    {
      paramGraphResponse = Utility.tryGetJSONArrayFromResponse(paramGraphResponse.getJSONObject(), "data");
      if (paramGraphResponse != null)
      {
        int i = 0;
        while (i < paramGraphResponse.length())
        {
          JSONObject localJSONObject1 = paramGraphResponse.optJSONObject(i);
          if (localJSONObject1 != null)
          {
            objectIsLiked = true;
            JSONObject localJSONObject2 = localJSONObject1.optJSONObject("application");
            AccessToken localAccessToken = AccessToken.getCurrentAccessToken();
            if ((localJSONObject2 != null) && (localAccessToken != null) && (Utility.areObjectsEqual(localAccessToken.getApplicationId(), localJSONObject2.optString("id")))) {
              unlikeToken = localJSONObject1.optString("id");
            }
          }
          i += 1;
        }
      }
    }
  }
  
  private class GetPageIdRequestWrapper
    extends LikeActionController.AbstractRequestWrapper
  {
    boolean objectIsPage;
    String verifiedObjectId;
    
    GetPageIdRequestWrapper(String paramString, LikeView.ObjectType paramObjectType)
    {
      super(paramString, paramObjectType);
      this$1 = new Bundle();
      putString("fields", "id");
      putString("ids", paramString);
      setRequest(new GraphRequest(AccessToken.getCurrentAccessToken(), "", LikeActionController.this, HttpMethod.GET));
    }
    
    protected void processError(FacebookRequestError paramFacebookRequestError)
    {
      Logger.log(LoggingBehavior.REQUESTS, LikeActionController.TAG, "Error getting the FB id for object '%s' with type '%s' : %s", new Object[] { objectId, objectType, paramFacebookRequestError });
    }
    
    protected void processSuccess(GraphResponse paramGraphResponse)
    {
      paramGraphResponse = Utility.tryGetJSONObjectFromResponse(paramGraphResponse.getJSONObject(), objectId);
      if (paramGraphResponse != null)
      {
        verifiedObjectId = paramGraphResponse.optString("id");
        if (Utility.isNullOrEmpty(verifiedObjectId)) {
          break label44;
        }
      }
      label44:
      for (boolean bool = true;; bool = false)
      {
        objectIsPage = bool;
        return;
      }
    }
  }
  
  private class GetPageLikesRequestWrapper
    extends LikeActionController.AbstractRequestWrapper
    implements LikeActionController.LikeRequestWrapper
  {
    private boolean objectIsLiked = isObjectLiked;
    private String pageId;
    
    GetPageLikesRequestWrapper(String paramString)
    {
      super(paramString, LikeView.ObjectType.PAGE);
      pageId = paramString;
      this$1 = new Bundle();
      putString("fields", "id");
      setRequest(new GraphRequest(AccessToken.getCurrentAccessToken(), "me/likes/" + paramString, LikeActionController.this, HttpMethod.GET));
    }
    
    public String getUnlikeToken()
    {
      return null;
    }
    
    public boolean isObjectLiked()
    {
      return objectIsLiked;
    }
    
    protected void processError(FacebookRequestError paramFacebookRequestError)
    {
      Logger.log(LoggingBehavior.REQUESTS, LikeActionController.TAG, "Error fetching like status for page id '%s': %s", new Object[] { pageId, paramFacebookRequestError });
      LikeActionController.this.logAppEventForError("get_page_like", paramFacebookRequestError);
    }
    
    protected void processSuccess(GraphResponse paramGraphResponse)
    {
      paramGraphResponse = Utility.tryGetJSONArrayFromResponse(paramGraphResponse.getJSONObject(), "data");
      if ((paramGraphResponse != null) && (paramGraphResponse.length() > 0)) {
        objectIsLiked = true;
      }
    }
  }
  
  private static abstract interface LikeRequestWrapper
    extends LikeActionController.RequestWrapper
  {
    public abstract String getUnlikeToken();
    
    public abstract boolean isObjectLiked();
  }
  
  private static class MRUCacheWorkItem
    implements Runnable
  {
    private static ArrayList<String> mruCachedItems = new ArrayList();
    private String cacheItem;
    private boolean shouldTrim;
    
    MRUCacheWorkItem(String paramString, boolean paramBoolean)
    {
      cacheItem = paramString;
      shouldTrim = paramBoolean;
    }
    
    public void run()
    {
      if (cacheItem != null)
      {
        mruCachedItems.remove(cacheItem);
        mruCachedItems.add(0, cacheItem);
      }
      if ((shouldTrim) && (mruCachedItems.size() >= 128)) {
        while (64 < mruCachedItems.size())
        {
          String str = (String)mruCachedItems.remove(mruCachedItems.size() - 1);
          LikeActionController.cache.remove(str);
        }
      }
    }
  }
  
  private class PublishLikeRequestWrapper
    extends LikeActionController.AbstractRequestWrapper
  {
    String unlikeToken;
    
    PublishLikeRequestWrapper(String paramString, LikeView.ObjectType paramObjectType)
    {
      super(paramString, paramObjectType);
      this$1 = new Bundle();
      putString("object", paramString);
      setRequest(new GraphRequest(AccessToken.getCurrentAccessToken(), "me/og.likes", LikeActionController.this, HttpMethod.POST));
    }
    
    protected void processError(FacebookRequestError paramFacebookRequestError)
    {
      if (paramFacebookRequestError.getErrorCode() == 3501)
      {
        error = null;
        return;
      }
      Logger.log(LoggingBehavior.REQUESTS, LikeActionController.TAG, "Error liking object '%s' with type '%s' : %s", new Object[] { objectId, objectType, paramFacebookRequestError });
      LikeActionController.this.logAppEventForError("publish_like", paramFacebookRequestError);
    }
    
    protected void processSuccess(GraphResponse paramGraphResponse)
    {
      unlikeToken = Utility.safeGetStringFromResponse(paramGraphResponse.getJSONObject(), "id");
    }
  }
  
  private class PublishUnlikeRequestWrapper
    extends LikeActionController.AbstractRequestWrapper
  {
    private String unlikeToken;
    
    PublishUnlikeRequestWrapper(String paramString)
    {
      super(null, null);
      unlikeToken = paramString;
      setRequest(new GraphRequest(AccessToken.getCurrentAccessToken(), paramString, null, HttpMethod.DELETE));
    }
    
    protected void processError(FacebookRequestError paramFacebookRequestError)
    {
      Logger.log(LoggingBehavior.REQUESTS, LikeActionController.TAG, "Error unliking object with unlike token '%s' : %s", new Object[] { unlikeToken, paramFacebookRequestError });
      LikeActionController.this.logAppEventForError("publish_unlike", paramFacebookRequestError);
    }
    
    protected void processSuccess(GraphResponse paramGraphResponse) {}
  }
  
  private static abstract interface RequestCompletionCallback
  {
    public abstract void onComplete();
  }
  
  private static abstract interface RequestWrapper
  {
    public abstract void addToBatch(GraphRequestBatch paramGraphRequestBatch);
    
    public abstract FacebookRequestError getError();
  }
  
  private static class SerializeToDiskWorkItem
    implements Runnable
  {
    private String cacheKey;
    private String controllerJson;
    
    SerializeToDiskWorkItem(String paramString1, String paramString2)
    {
      cacheKey = paramString1;
      controllerJson = paramString2;
    }
    
    public void run()
    {
      LikeActionController.serializeToDiskSynchronously(cacheKey, controllerJson);
    }
  }
}

/* Location:
 * Qualified Name:     com.facebook.share.internal.LikeActionController
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */