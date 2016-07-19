package com.facebook.share.internal;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.util.Pair;
import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookGraphResponseException;
import com.facebook.FacebookOperationCanceledException;
import com.facebook.FacebookRequestError;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphRequest.Callback;
import com.facebook.GraphRequest.ParcelableResourceWithMimeType;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.internal.AppCall;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.internal.CallbackManagerImpl.Callback;
import com.facebook.internal.NativeAppCallAttachmentStore;
import com.facebook.internal.NativeAppCallAttachmentStore.Attachment;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.facebook.internal.Utility.Mapper;
import com.facebook.share.Sharer.Result;
import com.facebook.share.model.ShareMedia;
import com.facebook.share.model.ShareMedia.Type;
import com.facebook.share.model.ShareMediaContent;
import com.facebook.share.model.ShareOpenGraphAction;
import com.facebook.share.model.ShareOpenGraphContent;
import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.model.ShareVideo;
import com.facebook.share.model.ShareVideoContent;
import com.facebook.share.widget.LikeView.ObjectType;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class ShareInternalUtility
{
  public static final String MY_PHOTOS = "me/photos";
  private static final String MY_STAGING_RESOURCES = "me/staging_resources";
  private static final String STAGING_PARAM = "file";
  
  private static AppCall getAppCallFromActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    paramIntent = NativeProtocol.getCallIdFromIntent(paramIntent);
    if (paramIntent == null) {
      return null;
    }
    return AppCall.finishPendingCall(paramIntent, paramInt1);
  }
  
  private static NativeAppCallAttachmentStore.Attachment getAttachment(UUID paramUUID, ShareMedia paramShareMedia)
  {
    Object localObject2 = null;
    Uri localUri = null;
    Object localObject1;
    if ((paramShareMedia instanceof SharePhoto))
    {
      paramShareMedia = (SharePhoto)paramShareMedia;
      localObject1 = paramShareMedia.getBitmap();
      localUri = paramShareMedia.getImageUrl();
      paramShareMedia = null;
      if (localObject1 == null) {
        break label65;
      }
      paramShareMedia = NativeAppCallAttachmentStore.createAttachment(paramUUID, (Bitmap)localObject1);
    }
    label65:
    while (localUri == null)
    {
      return paramShareMedia;
      localObject1 = localObject2;
      if (!(paramShareMedia instanceof ShareVideo)) {
        break;
      }
      localUri = ((ShareVideo)paramShareMedia).getLocalUrl();
      localObject1 = localObject2;
      break;
    }
    return NativeAppCallAttachmentStore.createAttachment(paramUUID, localUri);
  }
  
  public static Pair<String, String> getFieldNameAndNamespaceFromFullName(String paramString)
  {
    String str = null;
    int i = paramString.indexOf(':');
    if ((i != -1) && (paramString.length() > i + 1))
    {
      str = paramString.substring(0, i);
      paramString = paramString.substring(i + 1);
    }
    for (;;)
    {
      return new Pair(str, paramString);
    }
  }
  
  public static List<Bundle> getMediaInfos(final ShareMediaContent paramShareMediaContent, UUID paramUUID)
  {
    List localList;
    if (paramShareMediaContent != null)
    {
      localList = paramShareMediaContent.getMedia();
      if (localList != null) {}
    }
    else
    {
      return null;
    }
    paramShareMediaContent = new ArrayList();
    paramUUID = Utility.map(localList, new Utility.Mapper()
    {
      public Bundle apply(ShareMedia paramAnonymousShareMedia)
      {
        NativeAppCallAttachmentStore.Attachment localAttachment = ShareInternalUtility.getAttachment(val$appCallId, paramAnonymousShareMedia);
        paramShareMediaContent.add(localAttachment);
        Bundle localBundle = new Bundle();
        localBundle.putString("type", paramAnonymousShareMedia.getMediaType().name());
        localBundle.putString("uri", localAttachment.getAttachmentUrl());
        return localBundle;
      }
    });
    NativeAppCallAttachmentStore.addAttachments(paramShareMediaContent);
    return paramUUID;
  }
  
  public static LikeView.ObjectType getMostSpecificObjectType(LikeView.ObjectType paramObjectType1, LikeView.ObjectType paramObjectType2)
  {
    if (paramObjectType1 == paramObjectType2) {}
    do
    {
      return paramObjectType1;
      if (paramObjectType1 == LikeView.ObjectType.UNKNOWN) {
        return paramObjectType2;
      }
    } while (paramObjectType2 == LikeView.ObjectType.UNKNOWN);
    return null;
  }
  
  public static String getNativeDialogCompletionGesture(Bundle paramBundle)
  {
    if (paramBundle.containsKey("completionGesture")) {
      return paramBundle.getString("completionGesture");
    }
    return paramBundle.getString("com.facebook.platform.extra.COMPLETION_GESTURE");
  }
  
  public static List<String> getPhotoUrls(SharePhotoContent paramSharePhotoContent, UUID paramUUID)
  {
    if (paramSharePhotoContent != null)
    {
      paramSharePhotoContent = paramSharePhotoContent.getPhotos();
      if (paramSharePhotoContent != null) {}
    }
    else
    {
      return null;
    }
    paramSharePhotoContent = Utility.map(paramSharePhotoContent, new Utility.Mapper()
    {
      public NativeAppCallAttachmentStore.Attachment apply(SharePhoto paramAnonymousSharePhoto)
      {
        return ShareInternalUtility.getAttachment(val$appCallId, paramAnonymousSharePhoto);
      }
    });
    paramUUID = Utility.map(paramSharePhotoContent, new Utility.Mapper()
    {
      public String apply(NativeAppCallAttachmentStore.Attachment paramAnonymousAttachment)
      {
        return paramAnonymousAttachment.getAttachmentUrl();
      }
    });
    NativeAppCallAttachmentStore.addAttachments(paramSharePhotoContent);
    return paramUUID;
  }
  
  public static String getShareDialogPostId(Bundle paramBundle)
  {
    if (paramBundle.containsKey("postId")) {
      return paramBundle.getString("postId");
    }
    if (paramBundle.containsKey("com.facebook.platform.extra.POST_ID")) {
      return paramBundle.getString("com.facebook.platform.extra.POST_ID");
    }
    return paramBundle.getString("post_id");
  }
  
  public static ResultProcessor getShareResultProcessor(final FacebookCallback<Sharer.Result> paramFacebookCallback)
  {
    new ResultProcessor(paramFacebookCallback)
    {
      public void onCancel(AppCall paramAnonymousAppCall)
      {
        ShareInternalUtility.invokeOnCancelCallback(paramFacebookCallback);
      }
      
      public void onError(AppCall paramAnonymousAppCall, FacebookException paramAnonymousFacebookException)
      {
        ShareInternalUtility.invokeOnErrorCallback(paramFacebookCallback, paramAnonymousFacebookException);
      }
      
      public void onSuccess(AppCall paramAnonymousAppCall, Bundle paramAnonymousBundle)
      {
        if (paramAnonymousBundle != null)
        {
          paramAnonymousAppCall = ShareInternalUtility.getNativeDialogCompletionGesture(paramAnonymousBundle);
          if ((paramAnonymousAppCall == null) || ("post".equalsIgnoreCase(paramAnonymousAppCall)))
          {
            paramAnonymousAppCall = ShareInternalUtility.getShareDialogPostId(paramAnonymousBundle);
            ShareInternalUtility.invokeOnSuccessCallback(paramFacebookCallback, paramAnonymousAppCall);
          }
        }
        else
        {
          return;
        }
        if ("cancel".equalsIgnoreCase(paramAnonymousAppCall))
        {
          ShareInternalUtility.invokeOnCancelCallback(paramFacebookCallback);
          return;
        }
        ShareInternalUtility.invokeOnErrorCallback(paramFacebookCallback, new FacebookException("UnknownError"));
      }
    };
  }
  
  public static String getVideoUrl(ShareVideoContent paramShareVideoContent, UUID paramUUID)
  {
    if ((paramShareVideoContent == null) || (paramShareVideoContent.getVideo() == null)) {
      return null;
    }
    paramShareVideoContent = NativeAppCallAttachmentStore.createAttachment(paramUUID, paramShareVideoContent.getVideo().getLocalUrl());
    paramUUID = new ArrayList(1);
    paramUUID.add(paramShareVideoContent);
    NativeAppCallAttachmentStore.addAttachments(paramUUID);
    return paramShareVideoContent.getAttachmentUrl();
  }
  
  public static boolean handleActivityResult(int paramInt1, int paramInt2, Intent paramIntent, ResultProcessor paramResultProcessor)
  {
    boolean bool = true;
    AppCall localAppCall = getAppCallFromActivityResult(paramInt1, paramInt2, paramIntent);
    if (localAppCall == null) {
      bool = false;
    }
    do
    {
      return bool;
      NativeAppCallAttachmentStore.cleanupAttachmentsForCall(localAppCall.getCallId());
    } while (paramResultProcessor == null);
    FacebookException localFacebookException = NativeProtocol.getExceptionFromErrorData(NativeProtocol.getErrorDataFromResultIntent(paramIntent));
    if (localFacebookException != null)
    {
      if ((localFacebookException instanceof FacebookOperationCanceledException))
      {
        paramResultProcessor.onCancel(localAppCall);
        return true;
      }
      paramResultProcessor.onError(localAppCall, localFacebookException);
      return true;
    }
    paramResultProcessor.onSuccess(localAppCall, NativeProtocol.getSuccessResultsFromIntent(paramIntent));
    return true;
  }
  
  public static void invokeCallbackWithError(FacebookCallback<Sharer.Result> paramFacebookCallback, String paramString)
  {
    invokeOnErrorCallback(paramFacebookCallback, paramString);
  }
  
  public static void invokeCallbackWithException(FacebookCallback<Sharer.Result> paramFacebookCallback, Exception paramException)
  {
    if ((paramException instanceof FacebookException))
    {
      invokeOnErrorCallback(paramFacebookCallback, (FacebookException)paramException);
      return;
    }
    invokeCallbackWithError(paramFacebookCallback, "Error preparing share content: " + paramException.getLocalizedMessage());
  }
  
  public static void invokeCallbackWithResults(FacebookCallback<Sharer.Result> paramFacebookCallback, String paramString, GraphResponse paramGraphResponse)
  {
    Object localObject = paramGraphResponse.getError();
    if (localObject != null)
    {
      localObject = ((FacebookRequestError)localObject).getErrorMessage();
      paramString = (String)localObject;
      if (Utility.isNullOrEmpty((String)localObject)) {
        paramString = "Unexpected error sharing.";
      }
      invokeOnErrorCallback(paramFacebookCallback, paramGraphResponse, paramString);
      return;
    }
    invokeOnSuccessCallback(paramFacebookCallback, paramString);
  }
  
  static void invokeOnCancelCallback(FacebookCallback<Sharer.Result> paramFacebookCallback)
  {
    logShareResult("cancelled", null);
    if (paramFacebookCallback != null) {
      paramFacebookCallback.onCancel();
    }
  }
  
  static void invokeOnErrorCallback(FacebookCallback<Sharer.Result> paramFacebookCallback, FacebookException paramFacebookException)
  {
    logShareResult("error", paramFacebookException.getMessage());
    if (paramFacebookCallback != null) {
      paramFacebookCallback.onError(paramFacebookException);
    }
  }
  
  static void invokeOnErrorCallback(FacebookCallback<Sharer.Result> paramFacebookCallback, GraphResponse paramGraphResponse, String paramString)
  {
    logShareResult("error", paramString);
    if (paramFacebookCallback != null) {
      paramFacebookCallback.onError(new FacebookGraphResponseException(paramGraphResponse, paramString));
    }
  }
  
  static void invokeOnErrorCallback(FacebookCallback<Sharer.Result> paramFacebookCallback, String paramString)
  {
    logShareResult("error", paramString);
    if (paramFacebookCallback != null) {
      paramFacebookCallback.onError(new FacebookException(paramString));
    }
  }
  
  static void invokeOnSuccessCallback(FacebookCallback<Sharer.Result> paramFacebookCallback, String paramString)
  {
    logShareResult("succeeded", null);
    if (paramFacebookCallback != null) {
      paramFacebookCallback.onSuccess(new Sharer.Result(paramString));
    }
  }
  
  private static void logShareResult(String paramString1, String paramString2)
  {
    AppEventsLogger localAppEventsLogger = AppEventsLogger.newLogger(FacebookSdk.getApplicationContext());
    Bundle localBundle = new Bundle();
    localBundle.putString("fb_share_dialog_outcome", paramString1);
    if (paramString2 != null) {
      localBundle.putString("error_message", paramString2);
    }
    localAppEventsLogger.logSdkEvent("fb_share_dialog_result", null, localBundle);
  }
  
  public static GraphRequest newUploadStagingResourceWithImageRequest(AccessToken paramAccessToken, Bitmap paramBitmap, GraphRequest.Callback paramCallback)
  {
    Bundle localBundle = new Bundle(1);
    localBundle.putParcelable("file", paramBitmap);
    return new GraphRequest(paramAccessToken, "me/staging_resources", localBundle, HttpMethod.POST, paramCallback);
  }
  
  public static GraphRequest newUploadStagingResourceWithImageRequest(AccessToken paramAccessToken, Uri paramUri, GraphRequest.Callback paramCallback)
    throws FileNotFoundException
  {
    if (Utility.isFileUri(paramUri)) {
      return newUploadStagingResourceWithImageRequest(paramAccessToken, new File(paramUri.getPath()), paramCallback);
    }
    if (!Utility.isContentUri(paramUri)) {
      throw new FacebookException("The image Uri must be either a file:// or content:// Uri");
    }
    paramUri = new GraphRequest.ParcelableResourceWithMimeType(paramUri, "image/png");
    Bundle localBundle = new Bundle(1);
    localBundle.putParcelable("file", paramUri);
    return new GraphRequest(paramAccessToken, "me/staging_resources", localBundle, HttpMethod.POST, paramCallback);
  }
  
  public static GraphRequest newUploadStagingResourceWithImageRequest(AccessToken paramAccessToken, File paramFile, GraphRequest.Callback paramCallback)
    throws FileNotFoundException
  {
    paramFile = new GraphRequest.ParcelableResourceWithMimeType(ParcelFileDescriptor.open(paramFile, 268435456), "image/png");
    Bundle localBundle = new Bundle(1);
    localBundle.putParcelable("file", paramFile);
    return new GraphRequest(paramAccessToken, "me/staging_resources", localBundle, HttpMethod.POST, paramCallback);
  }
  
  public static void registerSharerCallback(int paramInt, CallbackManager paramCallbackManager, final FacebookCallback<Sharer.Result> paramFacebookCallback)
  {
    if (!(paramCallbackManager instanceof CallbackManagerImpl)) {
      throw new FacebookException("Unexpected CallbackManager, please use the provided Factory.");
    }
    ((CallbackManagerImpl)paramCallbackManager).registerCallback(paramInt, new CallbackManagerImpl.Callback()
    {
      public boolean onActivityResult(int paramAnonymousInt, Intent paramAnonymousIntent)
      {
        return ShareInternalUtility.handleActivityResult(val$requestCode, paramAnonymousInt, paramAnonymousIntent, ShareInternalUtility.getShareResultProcessor(paramFacebookCallback));
      }
    });
  }
  
  public static void registerStaticShareCallback(int paramInt)
  {
    CallbackManagerImpl.registerStaticCallback(paramInt, new CallbackManagerImpl.Callback()
    {
      public boolean onActivityResult(int paramAnonymousInt, Intent paramAnonymousIntent)
      {
        return ShareInternalUtility.handleActivityResult(val$requestCode, paramAnonymousInt, paramAnonymousIntent, ShareInternalUtility.getShareResultProcessor(null));
      }
    });
  }
  
  public static JSONArray removeNamespacesFromOGJsonArray(JSONArray paramJSONArray, boolean paramBoolean)
    throws JSONException
  {
    JSONArray localJSONArray = new JSONArray();
    int i = 0;
    if (i < paramJSONArray.length())
    {
      Object localObject2 = paramJSONArray.get(i);
      Object localObject1;
      if ((localObject2 instanceof JSONArray)) {
        localObject1 = removeNamespacesFromOGJsonArray((JSONArray)localObject2, paramBoolean);
      }
      for (;;)
      {
        localJSONArray.put(localObject1);
        i += 1;
        break;
        localObject1 = localObject2;
        if ((localObject2 instanceof JSONObject)) {
          localObject1 = removeNamespacesFromOGJsonObject((JSONObject)localObject2, paramBoolean);
        }
      }
    }
    return localJSONArray;
  }
  
  public static JSONObject removeNamespacesFromOGJsonObject(JSONObject paramJSONObject, boolean paramBoolean)
  {
    if (paramJSONObject == null)
    {
      paramJSONObject = null;
      return paramJSONObject;
    }
    for (;;)
    {
      JSONObject localJSONObject1;
      JSONObject localJSONObject2;
      int i;
      String str;
      Object localObject2;
      Object localObject1;
      Object localObject3;
      try
      {
        localJSONObject1 = new JSONObject();
        localJSONObject2 = new JSONObject();
        JSONArray localJSONArray = paramJSONObject.names();
        i = 0;
        if (i >= localJSONArray.length()) {
          break label252;
        }
        str = localJSONArray.getString(i);
        localObject2 = paramJSONObject.get(str);
        if ((localObject2 instanceof JSONObject))
        {
          localObject1 = removeNamespacesFromOGJsonObject((JSONObject)localObject2, true);
          localObject3 = getFieldNameAndNamespaceFromFullName(str);
          localObject2 = (String)first;
          localObject3 = (String)second;
          if (!paramBoolean) {
            break label212;
          }
          if ((localObject2 != null) && (((String)localObject2).equals("fbsdk")))
          {
            localJSONObject1.put(str, localObject1);
            break label277;
          }
        }
        else
        {
          localObject1 = localObject2;
          if (!(localObject2 instanceof JSONArray)) {
            continue;
          }
          localObject1 = removeNamespacesFromOGJsonArray((JSONArray)localObject2, true);
          continue;
        }
        if ((localObject2 == null) || (((String)localObject2).equals("og"))) {
          localJSONObject1.put((String)localObject3, localObject1);
        }
      }
      catch (JSONException paramJSONObject)
      {
        throw new FacebookException("Failed to create json object from share content");
      }
      localJSONObject2.put((String)localObject3, localObject1);
      break label277;
      label212:
      if ((localObject2 != null) && (((String)localObject2).equals("fb")))
      {
        localJSONObject1.put(str, localObject1);
      }
      else
      {
        localJSONObject1.put((String)localObject3, localObject1);
        break label277;
        label252:
        paramJSONObject = localJSONObject1;
        if (localJSONObject2.length() <= 0) {
          break;
        }
        localJSONObject1.put("data", localJSONObject2);
        return localJSONObject1;
      }
      label277:
      i += 1;
    }
  }
  
  public static JSONObject toJSONObjectForCall(UUID paramUUID, ShareOpenGraphContent paramShareOpenGraphContent)
    throws JSONException
  {
    Object localObject = paramShareOpenGraphContent.getAction();
    final ArrayList localArrayList = new ArrayList();
    localObject = OpenGraphJSONUtility.toJSONObject((ShareOpenGraphAction)localObject, new OpenGraphJSONUtility.PhotoJSONProcessor()
    {
      public JSONObject toJSONObject(SharePhoto paramAnonymousSharePhoto)
      {
        Object localObject = ShareInternalUtility.getAttachment(val$callId, paramAnonymousSharePhoto);
        if (localObject == null) {
          localObject = null;
        }
        for (;;)
        {
          return (JSONObject)localObject;
          localArrayList.add(localObject);
          JSONObject localJSONObject = new JSONObject();
          try
          {
            localJSONObject.put("url", ((NativeAppCallAttachmentStore.Attachment)localObject).getAttachmentUrl());
            localObject = localJSONObject;
            if (!paramAnonymousSharePhoto.getUserGenerated()) {
              continue;
            }
            localJSONObject.put("user_generated", true);
            return localJSONObject;
          }
          catch (JSONException paramAnonymousSharePhoto)
          {
            throw new FacebookException("Unable to attach images", paramAnonymousSharePhoto);
          }
        }
      }
    });
    NativeAppCallAttachmentStore.addAttachments(localArrayList);
    if ((paramShareOpenGraphContent.getPlaceId() != null) && (Utility.isNullOrEmpty(((JSONObject)localObject).optString("place")))) {
      ((JSONObject)localObject).put("place", paramShareOpenGraphContent.getPlaceId());
    }
    if (paramShareOpenGraphContent.getPeopleIds() != null)
    {
      paramUUID = ((JSONObject)localObject).optJSONArray("tags");
      if (paramUUID == null) {}
      for (paramUUID = new HashSet();; paramUUID = Utility.jsonArrayToSet(paramUUID))
      {
        paramShareOpenGraphContent = paramShareOpenGraphContent.getPeopleIds().iterator();
        while (paramShareOpenGraphContent.hasNext()) {
          paramUUID.add((String)paramShareOpenGraphContent.next());
        }
      }
      ((JSONObject)localObject).put("tags", new ArrayList(paramUUID));
    }
    return (JSONObject)localObject;
  }
  
  public static JSONObject toJSONObjectForWeb(ShareOpenGraphContent paramShareOpenGraphContent)
    throws JSONException
  {
    OpenGraphJSONUtility.toJSONObject(paramShareOpenGraphContent.getAction(), new OpenGraphJSONUtility.PhotoJSONProcessor()
    {
      public JSONObject toJSONObject(SharePhoto paramAnonymousSharePhoto)
      {
        paramAnonymousSharePhoto = paramAnonymousSharePhoto.getImageUrl();
        JSONObject localJSONObject = new JSONObject();
        try
        {
          localJSONObject.put("url", paramAnonymousSharePhoto.toString());
          return localJSONObject;
        }
        catch (JSONException paramAnonymousSharePhoto)
        {
          throw new FacebookException("Unable to attach images", paramAnonymousSharePhoto);
        }
      }
    });
  }
}

/* Location:
 * Qualified Name:     com.facebook.share.internal.ShareInternalUtility
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */