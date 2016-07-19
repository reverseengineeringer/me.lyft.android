package com.facebook.internal;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.content.pm.Signature;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.facebook.FacebookException;
import com.facebook.FacebookOperationCanceledException;
import com.facebook.FacebookSdk;
import com.facebook.login.DefaultAudience;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.UUID;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

public final class NativeProtocol
{
  public static final String ACTION_APPINVITE_DIALOG = "com.facebook.platform.action.request.APPINVITES_DIALOG";
  public static final String ACTION_FEED_DIALOG = "com.facebook.platform.action.request.FEED_DIALOG";
  public static final String ACTION_LIKE_DIALOG = "com.facebook.platform.action.request.LIKE_DIALOG";
  public static final String ACTION_MESSAGE_DIALOG = "com.facebook.platform.action.request.MESSAGE_DIALOG";
  public static final String ACTION_OGACTIONPUBLISH_DIALOG = "com.facebook.platform.action.request.OGACTIONPUBLISH_DIALOG";
  public static final String ACTION_OGMESSAGEPUBLISH_DIALOG = "com.facebook.platform.action.request.OGMESSAGEPUBLISH_DIALOG";
  public static final String AUDIENCE_EVERYONE = "everyone";
  public static final String AUDIENCE_FRIENDS = "friends";
  public static final String AUDIENCE_ME = "only_me";
  public static final String BRIDGE_ARG_ACTION_ID_STRING = "action_id";
  public static final String BRIDGE_ARG_APP_NAME_STRING = "app_name";
  public static final String BRIDGE_ARG_ERROR_BUNDLE = "error";
  public static final String BRIDGE_ARG_ERROR_CODE = "error_code";
  public static final String BRIDGE_ARG_ERROR_DESCRIPTION = "error_description";
  public static final String BRIDGE_ARG_ERROR_JSON = "error_json";
  public static final String BRIDGE_ARG_ERROR_SUBCODE = "error_subcode";
  public static final String BRIDGE_ARG_ERROR_TYPE = "error_type";
  private static final String CONTENT_SCHEME = "content://";
  public static final String ERROR_APPLICATION_ERROR = "ApplicationError";
  public static final String ERROR_NETWORK_ERROR = "NetworkError";
  public static final String ERROR_PERMISSION_DENIED = "PermissionDenied";
  public static final String ERROR_PROTOCOL_ERROR = "ProtocolError";
  public static final String ERROR_SERVICE_DISABLED = "ServiceDisabled";
  public static final String ERROR_UNKNOWN_ERROR = "UnknownError";
  public static final String ERROR_USER_CANCELED = "UserCanceled";
  public static final String EXTRA_ACCESS_TOKEN = "com.facebook.platform.extra.ACCESS_TOKEN";
  public static final String EXTRA_APPLICATION_ID = "com.facebook.platform.extra.APPLICATION_ID";
  public static final String EXTRA_APPLICATION_NAME = "com.facebook.platform.extra.APPLICATION_NAME";
  public static final String EXTRA_DIALOG_COMPLETE_KEY = "com.facebook.platform.extra.DID_COMPLETE";
  public static final String EXTRA_DIALOG_COMPLETION_GESTURE_KEY = "com.facebook.platform.extra.COMPLETION_GESTURE";
  public static final String EXTRA_EXPIRES_SECONDS_SINCE_EPOCH = "com.facebook.platform.extra.EXPIRES_SECONDS_SINCE_EPOCH";
  public static final String EXTRA_GET_INSTALL_DATA_PACKAGE = "com.facebook.platform.extra.INSTALLDATA_PACKAGE";
  public static final String EXTRA_PERMISSIONS = "com.facebook.platform.extra.PERMISSIONS";
  public static final String EXTRA_PROTOCOL_ACTION = "com.facebook.platform.protocol.PROTOCOL_ACTION";
  public static final String EXTRA_PROTOCOL_BRIDGE_ARGS = "com.facebook.platform.protocol.BRIDGE_ARGS";
  public static final String EXTRA_PROTOCOL_CALL_ID = "com.facebook.platform.protocol.CALL_ID";
  public static final String EXTRA_PROTOCOL_METHOD_ARGS = "com.facebook.platform.protocol.METHOD_ARGS";
  public static final String EXTRA_PROTOCOL_METHOD_RESULTS = "com.facebook.platform.protocol.RESULT_ARGS";
  public static final String EXTRA_PROTOCOL_VERSION = "com.facebook.platform.protocol.PROTOCOL_VERSION";
  static final String EXTRA_PROTOCOL_VERSIONS = "com.facebook.platform.extra.PROTOCOL_VERSIONS";
  public static final String EXTRA_USER_ID = "com.facebook.platform.extra.USER_ID";
  private static final String FACEBOOK_PROXY_AUTH_ACTIVITY = "com.facebook.katana.ProxyAuth";
  public static final String FACEBOOK_PROXY_AUTH_APP_ID_KEY = "client_id";
  public static final String FACEBOOK_PROXY_AUTH_E2E_KEY = "e2e";
  public static final String FACEBOOK_PROXY_AUTH_PERMISSIONS_KEY = "scope";
  private static final String FACEBOOK_TOKEN_REFRESH_ACTIVITY = "com.facebook.katana.platform.TokenRefreshService";
  public static final String IMAGE_URL_KEY = "url";
  public static final String IMAGE_USER_GENERATED_KEY = "user_generated";
  static final String INTENT_ACTION_PLATFORM_ACTIVITY = "com.facebook.platform.PLATFORM_ACTIVITY";
  static final String INTENT_ACTION_PLATFORM_SERVICE = "com.facebook.platform.PLATFORM_SERVICE";
  private static final List<Integer> KNOWN_PROTOCOL_VERSIONS = Arrays.asList(new Integer[] { Integer.valueOf(20160327), Integer.valueOf(20141218), Integer.valueOf(20141107), Integer.valueOf(20141028), Integer.valueOf(20141001), Integer.valueOf(20140701), Integer.valueOf(20140324), Integer.valueOf(20140204), Integer.valueOf(20131107), Integer.valueOf(20130618), Integer.valueOf(20130502), Integer.valueOf(20121101) });
  public static final int MESSAGE_GET_ACCESS_TOKEN_REPLY = 65537;
  public static final int MESSAGE_GET_ACCESS_TOKEN_REQUEST = 65536;
  public static final int MESSAGE_GET_INSTALL_DATA_REPLY = 65541;
  public static final int MESSAGE_GET_INSTALL_DATA_REQUEST = 65540;
  public static final int MESSAGE_GET_LIKE_STATUS_REPLY = 65543;
  public static final int MESSAGE_GET_LIKE_STATUS_REQUEST = 65542;
  static final int MESSAGE_GET_PROTOCOL_VERSIONS_REPLY = 65539;
  static final int MESSAGE_GET_PROTOCOL_VERSIONS_REQUEST = 65538;
  public static final int NO_PROTOCOL_AVAILABLE = -1;
  public static final String OPEN_GRAPH_CREATE_OBJECT_KEY = "fbsdk:create_object";
  private static final String PLATFORM_PROVIDER = ".provider.PlatformProvider";
  private static final String PLATFORM_PROVIDER_VERSIONS = ".provider.PlatformProvider/versions";
  private static final String PLATFORM_PROVIDER_VERSION_COLUMN = "version";
  public static final int PROTOCOL_VERSION_20121101 = 20121101;
  public static final int PROTOCOL_VERSION_20130502 = 20130502;
  public static final int PROTOCOL_VERSION_20130618 = 20130618;
  public static final int PROTOCOL_VERSION_20131107 = 20131107;
  public static final int PROTOCOL_VERSION_20140204 = 20140204;
  public static final int PROTOCOL_VERSION_20140324 = 20140324;
  public static final int PROTOCOL_VERSION_20140701 = 20140701;
  public static final int PROTOCOL_VERSION_20141001 = 20141001;
  public static final int PROTOCOL_VERSION_20141028 = 20141028;
  public static final int PROTOCOL_VERSION_20141107 = 20141107;
  public static final int PROTOCOL_VERSION_20141218 = 20141218;
  public static final int PROTOCOL_VERSION_20160327 = 20160327;
  public static final String RESULT_ARGS_ACCESS_TOKEN = "access_token";
  public static final String RESULT_ARGS_DIALOG_COMPLETE_KEY = "didComplete";
  public static final String RESULT_ARGS_DIALOG_COMPLETION_GESTURE_KEY = "completionGesture";
  public static final String RESULT_ARGS_EXPIRES_SECONDS_SINCE_EPOCH = "expires_seconds_since_epoch";
  public static final String RESULT_ARGS_PERMISSIONS = "permissions";
  public static final String STATUS_ERROR_CODE = "com.facebook.platform.status.ERROR_CODE";
  public static final String STATUS_ERROR_DESCRIPTION = "com.facebook.platform.status.ERROR_DESCRIPTION";
  public static final String STATUS_ERROR_JSON = "com.facebook.platform.status.ERROR_JSON";
  public static final String STATUS_ERROR_SUBCODE = "com.facebook.platform.status.ERROR_SUBCODE";
  public static final String STATUS_ERROR_TYPE = "com.facebook.platform.status.ERROR_TYPE";
  private static final String TAG = NativeProtocol.class.getName();
  public static final String WEB_DIALOG_ACTION = "action";
  public static final String WEB_DIALOG_IS_FALLBACK = "is_fallback";
  public static final String WEB_DIALOG_PARAMS = "params";
  public static final String WEB_DIALOG_URL = "url";
  private static Map<String, List<NativeAppInfo>> actionToAppInfoMap;
  private static List<NativeAppInfo> facebookAppInfoList = buildFacebookAppList();
  private static AtomicBoolean protocolVersionsAsyncUpdating;
  
  static
  {
    actionToAppInfoMap = buildActionToAppInfoMap();
    protocolVersionsAsyncUpdating = new AtomicBoolean(false);
  }
  
  private static Map<String, List<NativeAppInfo>> buildActionToAppInfoMap()
  {
    HashMap localHashMap = new HashMap();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new MessengerAppInfo(null));
    localHashMap.put("com.facebook.platform.action.request.OGACTIONPUBLISH_DIALOG", facebookAppInfoList);
    localHashMap.put("com.facebook.platform.action.request.FEED_DIALOG", facebookAppInfoList);
    localHashMap.put("com.facebook.platform.action.request.LIKE_DIALOG", facebookAppInfoList);
    localHashMap.put("com.facebook.platform.action.request.APPINVITES_DIALOG", facebookAppInfoList);
    localHashMap.put("com.facebook.platform.action.request.MESSAGE_DIALOG", localArrayList);
    localHashMap.put("com.facebook.platform.action.request.OGMESSAGEPUBLISH_DIALOG", localArrayList);
    return localHashMap;
  }
  
  private static List<NativeAppInfo> buildFacebookAppList()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new KatanaAppInfo(null));
    localArrayList.add(new WakizashiAppInfo(null));
    return localArrayList;
  }
  
  private static Uri buildPlatformProviderVersionURI(NativeAppInfo paramNativeAppInfo)
  {
    return Uri.parse("content://" + paramNativeAppInfo.getPackage() + ".provider.PlatformProvider/versions");
  }
  
  public static int computeLatestAvailableVersionFromVersionSpec(TreeSet<Integer> paramTreeSet, int paramInt, int[] paramArrayOfInt)
  {
    int i = paramArrayOfInt.length - 1;
    paramTreeSet = paramTreeSet.descendingIterator();
    int j = -1;
    int n;
    int m;
    int k;
    do
    {
      if (paramTreeSet.hasNext())
      {
        n = ((Integer)paramTreeSet.next()).intValue();
        m = Math.max(j, n);
        k = i;
        while ((k >= 0) && (paramArrayOfInt[k] > n)) {
          k -= 1;
        }
        if (k >= 0) {}
      }
      else
      {
        return -1;
      }
      j = m;
      i = k;
    } while (paramArrayOfInt[k] != n);
    if (k % 2 == 0) {}
    for (paramInt = Math.min(m, paramInt);; paramInt = -1) {
      return paramInt;
    }
  }
  
  public static Bundle createBundleForException(FacebookException paramFacebookException)
  {
    Object localObject;
    if (paramFacebookException == null) {
      localObject = null;
    }
    Bundle localBundle;
    do
    {
      return (Bundle)localObject;
      localBundle = new Bundle();
      localBundle.putString("error_description", paramFacebookException.toString());
      localObject = localBundle;
    } while (!(paramFacebookException instanceof FacebookOperationCanceledException));
    localBundle.putString("error_type", "UserCanceled");
    return localBundle;
  }
  
  public static Intent createPlatformActivityIntent(Context paramContext, String paramString1, String paramString2, int paramInt, Bundle paramBundle)
  {
    paramContext = findActivityIntent(paramContext, "com.facebook.platform.PLATFORM_ACTIVITY", paramString2);
    if (paramContext == null) {
      return null;
    }
    setupProtocolRequestIntent(paramContext, paramString1, paramString2, paramInt, paramBundle);
    return paramContext;
  }
  
  public static Intent createPlatformServiceIntent(Context paramContext)
  {
    Iterator localIterator = facebookAppInfoList.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (NativeAppInfo)localIterator.next();
      localObject = validateServiceIntent(paramContext, new Intent("com.facebook.platform.PLATFORM_SERVICE").setPackage(((NativeAppInfo)localObject).getPackage()).addCategory("android.intent.category.DEFAULT"), (NativeAppInfo)localObject);
      if (localObject != null) {
        return (Intent)localObject;
      }
    }
    return null;
  }
  
  public static Intent createProtocolResultIntent(Intent paramIntent, Bundle paramBundle, FacebookException paramFacebookException)
  {
    UUID localUUID = getCallIdFromIntent(paramIntent);
    if (localUUID == null) {
      paramIntent = null;
    }
    Intent localIntent;
    do
    {
      return paramIntent;
      localIntent = new Intent();
      localIntent.putExtra("com.facebook.platform.protocol.PROTOCOL_VERSION", getProtocolVersionFromIntent(paramIntent));
      paramIntent = new Bundle();
      paramIntent.putString("action_id", localUUID.toString());
      if (paramFacebookException != null) {
        paramIntent.putBundle("error", createBundleForException(paramFacebookException));
      }
      localIntent.putExtra("com.facebook.platform.protocol.BRIDGE_ARGS", paramIntent);
      paramIntent = localIntent;
    } while (paramBundle == null);
    localIntent.putExtra("com.facebook.platform.protocol.RESULT_ARGS", paramBundle);
    return localIntent;
  }
  
  public static Intent createProxyAuthIntent(Context paramContext, String paramString1, Collection<String> paramCollection, String paramString2, boolean paramBoolean1, boolean paramBoolean2, DefaultAudience paramDefaultAudience, String paramString3)
  {
    Iterator localIterator = facebookAppInfoList.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (NativeAppInfo)localIterator.next();
      Intent localIntent = new Intent().setClassName(((NativeAppInfo)localObject).getPackage(), "com.facebook.katana.ProxyAuth").putExtra("client_id", paramString1);
      if (!Utility.isNullOrEmpty(paramCollection)) {
        localIntent.putExtra("scope", TextUtils.join(",", paramCollection));
      }
      if (!Utility.isNullOrEmpty(paramString2)) {
        localIntent.putExtra("e2e", paramString2);
      }
      localIntent.putExtra("state", paramString3);
      localIntent.putExtra("response_type", "token,signed_request");
      localIntent.putExtra("return_scopes", "true");
      if (paramBoolean2) {
        localIntent.putExtra("default_audience", paramDefaultAudience.getNativeProtocolAudience());
      }
      localIntent.putExtra("legacy_override", "v2.6");
      if (paramBoolean1) {
        localIntent.putExtra("auth_type", "rerequest");
      }
      localObject = validateActivityIntent(paramContext, localIntent, (NativeAppInfo)localObject);
      if (localObject != null) {
        return (Intent)localObject;
      }
    }
    return null;
  }
  
  public static Intent createTokenRefreshIntent(Context paramContext)
  {
    Iterator localIterator = facebookAppInfoList.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (NativeAppInfo)localIterator.next();
      localObject = validateServiceIntent(paramContext, new Intent().setClassName(((NativeAppInfo)localObject).getPackage(), "com.facebook.katana.platform.TokenRefreshService"), (NativeAppInfo)localObject);
      if (localObject != null) {
        return (Intent)localObject;
      }
    }
    return null;
  }
  
  /* Error */
  private static TreeSet<Integer> fetchAllAvailableProtocolVersionsForAppInfo(NativeAppInfo paramNativeAppInfo)
  {
    // Byte code:
    //   0: new 382	java/util/TreeSet
    //   3: dup
    //   4: invokespecial 544	java/util/TreeSet:<init>	()V
    //   7: astore 4
    //   9: invokestatic 550	com/facebook/FacebookSdk:getApplicationContext	()Landroid/content/Context;
    //   12: invokevirtual 556	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   15: astore 5
    //   17: aload_0
    //   18: invokestatic 558	com/facebook/internal/NativeProtocol:buildPlatformProviderVersionURI	(Lcom/facebook/internal/NativeProtocol$NativeAppInfo;)Landroid/net/Uri;
    //   21: astore 6
    //   23: aconst_null
    //   24: astore_2
    //   25: aconst_null
    //   26: astore_3
    //   27: aload_3
    //   28: astore_1
    //   29: invokestatic 550	com/facebook/FacebookSdk:getApplicationContext	()Landroid/content/Context;
    //   32: invokevirtual 562	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   35: new 361	java/lang/StringBuilder
    //   38: dup
    //   39: invokespecial 362	java/lang/StringBuilder:<init>	()V
    //   42: aload_0
    //   43: invokevirtual 369	com/facebook/internal/NativeProtocol$NativeAppInfo:getPackage	()Ljava/lang/String;
    //   46: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: ldc -59
    //   51: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: invokevirtual 372	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   57: iconst_0
    //   58: invokevirtual 568	android/content/pm/PackageManager:resolveContentProvider	(Ljava/lang/String;I)Landroid/content/pm/ProviderInfo;
    //   61: astore_0
    //   62: aload_0
    //   63: ifnull +103 -> 166
    //   66: aload_3
    //   67: astore_1
    //   68: aload 5
    //   70: aload 6
    //   72: iconst_1
    //   73: anewarray 570	java/lang/String
    //   76: dup
    //   77: iconst_0
    //   78: ldc -53
    //   80: aastore
    //   81: aconst_null
    //   82: aconst_null
    //   83: aconst_null
    //   84: invokevirtual 576	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   87: astore_0
    //   88: aload_0
    //   89: astore_2
    //   90: aload_0
    //   91: ifnull +75 -> 166
    //   94: aload_0
    //   95: astore_1
    //   96: aload_0
    //   97: astore_2
    //   98: aload_0
    //   99: invokeinterface 581 1 0
    //   104: ifeq +62 -> 166
    //   107: aload_0
    //   108: astore_1
    //   109: aload 4
    //   111: aload_0
    //   112: aload_0
    //   113: ldc -53
    //   115: invokeinterface 585 2 0
    //   120: invokeinterface 589 2 0
    //   125: invokestatic 311	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   128: invokevirtual 590	java/util/TreeSet:add	(Ljava/lang/Object;)Z
    //   131: pop
    //   132: goto -38 -> 94
    //   135: astore_0
    //   136: aload_1
    //   137: ifnull +9 -> 146
    //   140: aload_1
    //   141: invokeinterface 593 1 0
    //   146: aload_0
    //   147: athrow
    //   148: astore_0
    //   149: aload_3
    //   150: astore_1
    //   151: getstatic 285	com/facebook/internal/NativeProtocol:TAG	Ljava/lang/String;
    //   154: ldc_w 595
    //   157: invokestatic 601	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   160: pop
    //   161: aconst_null
    //   162: astore_0
    //   163: goto -75 -> 88
    //   166: aload_2
    //   167: ifnull +9 -> 176
    //   170: aload_2
    //   171: invokeinterface 593 1 0
    //   176: aload 4
    //   178: areturn
    //   179: astore_0
    //   180: goto -31 -> 149
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	183	0	paramNativeAppInfo	NativeAppInfo
    //   28	123	1	localObject1	Object
    //   24	147	2	localNativeAppInfo	NativeAppInfo
    //   26	124	3	localObject2	Object
    //   7	170	4	localTreeSet	TreeSet
    //   15	54	5	localContentResolver	android.content.ContentResolver
    //   21	50	6	localUri	Uri
    // Exception table:
    //   from	to	target	type
    //   29	62	135	finally
    //   68	88	135	finally
    //   98	107	135	finally
    //   109	132	135	finally
    //   151	161	135	finally
    //   68	88	148	java/lang/NullPointerException
    //   68	88	179	java/lang/SecurityException
  }
  
  private static Intent findActivityIntent(Context paramContext, String paramString1, String paramString2)
  {
    Object localObject = (List)actionToAppInfoMap.get(paramString2);
    if (localObject == null) {}
    do
    {
      paramString2 = null;
      Iterator localIterator;
      while (!localIterator.hasNext())
      {
        return paramString2;
        paramString2 = null;
        localIterator = ((List)localObject).iterator();
      }
      paramString2 = (NativeAppInfo)localIterator.next();
      localObject = validateActivityIntent(paramContext, new Intent().setAction(paramString1).setPackage(paramString2.getPackage()).addCategory("android.intent.category.DEFAULT"), paramString2);
      paramString2 = (String)localObject;
    } while (localObject == null);
    return (Intent)localObject;
  }
  
  public static Bundle getBridgeArgumentsFromIntent(Intent paramIntent)
  {
    if (!isVersionCompatibleWithBucketedIntent(getProtocolVersionFromIntent(paramIntent))) {
      return null;
    }
    return paramIntent.getBundleExtra("com.facebook.platform.protocol.BRIDGE_ARGS");
  }
  
  public static UUID getCallIdFromIntent(Intent paramIntent)
  {
    if (paramIntent == null) {}
    for (;;)
    {
      return null;
      int i = getProtocolVersionFromIntent(paramIntent);
      Object localObject = null;
      Bundle localBundle;
      if (isVersionCompatibleWithBucketedIntent(i))
      {
        localBundle = paramIntent.getBundleExtra("com.facebook.platform.protocol.BRIDGE_ARGS");
        paramIntent = (Intent)localObject;
        if (localBundle == null) {}
      }
      for (paramIntent = localBundle.getString("action_id"); paramIntent != null; paramIntent = paramIntent.getStringExtra("com.facebook.platform.protocol.CALL_ID")) {
        try
        {
          paramIntent = UUID.fromString(paramIntent);
          return paramIntent;
        }
        catch (IllegalArgumentException paramIntent) {}
      }
    }
    return null;
  }
  
  public static Bundle getErrorDataFromResultIntent(Intent paramIntent)
  {
    if (!isErrorResult(paramIntent)) {
      return null;
    }
    Bundle localBundle = getBridgeArgumentsFromIntent(paramIntent);
    if (localBundle != null) {
      return localBundle.getBundle("error");
    }
    return paramIntent.getExtras();
  }
  
  public static FacebookException getExceptionFromErrorData(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return null;
    }
    Object localObject2 = paramBundle.getString("error_type");
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = paramBundle.getString("com.facebook.platform.status.ERROR_TYPE");
    }
    String str = paramBundle.getString("error_description");
    localObject2 = str;
    if (str == null) {
      localObject2 = paramBundle.getString("com.facebook.platform.status.ERROR_DESCRIPTION");
    }
    if ((localObject1 != null) && (((String)localObject1).equalsIgnoreCase("UserCanceled"))) {
      return new FacebookOperationCanceledException((String)localObject2);
    }
    return new FacebookException((String)localObject2);
  }
  
  public static int getLatestAvailableProtocolVersionForAction(String paramString, int[] paramArrayOfInt)
  {
    return getLatestAvailableProtocolVersionForAppInfoList((List)actionToAppInfoMap.get(paramString), paramArrayOfInt);
  }
  
  private static int getLatestAvailableProtocolVersionForAppInfoList(List<NativeAppInfo> paramList, int[] paramArrayOfInt)
  {
    
    if (paramList == null) {
      return -1;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      int i = computeLatestAvailableVersionFromVersionSpec(((NativeAppInfo)paramList.next()).getAvailableVersions(), getLatestKnownVersion(), paramArrayOfInt);
      if (i != -1) {
        return i;
      }
    }
    return -1;
  }
  
  public static int getLatestAvailableProtocolVersionForService(int paramInt)
  {
    return getLatestAvailableProtocolVersionForAppInfoList(facebookAppInfoList, new int[] { paramInt });
  }
  
  public static final int getLatestKnownVersion()
  {
    return ((Integer)KNOWN_PROTOCOL_VERSIONS.get(0)).intValue();
  }
  
  public static Bundle getMethodArgumentsFromIntent(Intent paramIntent)
  {
    if (!isVersionCompatibleWithBucketedIntent(getProtocolVersionFromIntent(paramIntent))) {
      return paramIntent.getExtras();
    }
    return paramIntent.getBundleExtra("com.facebook.platform.protocol.METHOD_ARGS");
  }
  
  public static int getProtocolVersionFromIntent(Intent paramIntent)
  {
    return paramIntent.getIntExtra("com.facebook.platform.protocol.PROTOCOL_VERSION", 0);
  }
  
  public static Bundle getSuccessResultsFromIntent(Intent paramIntent)
  {
    int i = getProtocolVersionFromIntent(paramIntent);
    paramIntent = paramIntent.getExtras();
    if ((!isVersionCompatibleWithBucketedIntent(i)) || (paramIntent == null)) {
      return paramIntent;
    }
    return paramIntent.getBundle("com.facebook.platform.protocol.RESULT_ARGS");
  }
  
  public static boolean isErrorResult(Intent paramIntent)
  {
    Bundle localBundle = getBridgeArgumentsFromIntent(paramIntent);
    if (localBundle != null) {
      return localBundle.containsKey("error");
    }
    return paramIntent.hasExtra("com.facebook.platform.status.ERROR_TYPE");
  }
  
  public static boolean isVersionCompatibleWithBucketedIntent(int paramInt)
  {
    return (KNOWN_PROTOCOL_VERSIONS.contains(Integer.valueOf(paramInt))) && (paramInt >= 20140701);
  }
  
  public static void setupProtocolRequestIntent(Intent paramIntent, String paramString1, String paramString2, int paramInt, Bundle paramBundle)
  {
    String str2 = FacebookSdk.getApplicationId();
    String str1 = FacebookSdk.getApplicationName();
    paramIntent.putExtra("com.facebook.platform.protocol.PROTOCOL_VERSION", paramInt).putExtra("com.facebook.platform.protocol.PROTOCOL_ACTION", paramString2).putExtra("com.facebook.platform.extra.APPLICATION_ID", str2);
    if (isVersionCompatibleWithBucketedIntent(paramInt))
    {
      paramString2 = new Bundle();
      paramString2.putString("action_id", paramString1);
      Utility.putNonEmptyString(paramString2, "app_name", str1);
      paramIntent.putExtra("com.facebook.platform.protocol.BRIDGE_ARGS", paramString2);
      if (paramBundle == null) {}
      for (paramString1 = new Bundle();; paramString1 = paramBundle)
      {
        paramIntent.putExtra("com.facebook.platform.protocol.METHOD_ARGS", paramString1);
        return;
      }
    }
    paramIntent.putExtra("com.facebook.platform.protocol.CALL_ID", paramString1);
    if (!Utility.isNullOrEmpty(str1)) {
      paramIntent.putExtra("com.facebook.platform.extra.APPLICATION_NAME", str1);
    }
    paramIntent.putExtras(paramBundle);
  }
  
  public static void updateAllAvailableProtocolVersionsAsync()
  {
    if (!protocolVersionsAsyncUpdating.compareAndSet(false, true)) {
      return;
    }
    FacebookSdk.getExecutor().execute(new Runnable()
    {
      public void run()
      {
        try
        {
          Iterator localIterator = NativeProtocol.facebookAppInfoList.iterator();
          while (localIterator.hasNext()) {
            NativeProtocol.NativeAppInfo.access$600((NativeProtocol.NativeAppInfo)localIterator.next(), true);
          }
        }
        finally
        {
          NativeProtocol.protocolVersionsAsyncUpdating.set(false);
        }
      }
    });
  }
  
  static Intent validateActivityIntent(Context paramContext, Intent paramIntent, NativeAppInfo paramNativeAppInfo)
  {
    if (paramIntent == null) {
      paramIntent = null;
    }
    ResolveInfo localResolveInfo;
    do
    {
      return paramIntent;
      localResolveInfo = paramContext.getPackageManager().resolveActivity(paramIntent, 0);
      if (localResolveInfo == null) {
        return null;
      }
    } while (paramNativeAppInfo.validateSignature(paramContext, activityInfo.packageName));
    return null;
  }
  
  static Intent validateServiceIntent(Context paramContext, Intent paramIntent, NativeAppInfo paramNativeAppInfo)
  {
    if (paramIntent == null) {
      paramIntent = null;
    }
    ResolveInfo localResolveInfo;
    do
    {
      return paramIntent;
      localResolveInfo = paramContext.getPackageManager().resolveService(paramIntent, 0);
      if (localResolveInfo == null) {
        return null;
      }
    } while (paramNativeAppInfo.validateSignature(paramContext, serviceInfo.packageName));
    return null;
  }
  
  private static class KatanaAppInfo
    extends NativeProtocol.NativeAppInfo
  {
    static final String KATANA_PACKAGE = "com.facebook.katana";
    
    private KatanaAppInfo()
    {
      super();
    }
    
    protected String getPackage()
    {
      return "com.facebook.katana";
    }
  }
  
  private static class MessengerAppInfo
    extends NativeProtocol.NativeAppInfo
  {
    static final String MESSENGER_PACKAGE = "com.facebook.orca";
    
    private MessengerAppInfo()
    {
      super();
    }
    
    protected String getPackage()
    {
      return "com.facebook.orca";
    }
  }
  
  private static abstract class NativeAppInfo
  {
    private static final String FBI_HASH = "a4b7452e2ed8f5f191058ca7bbfd26b0d3214bfc";
    private static final String FBL_HASH = "5e8f16062ea3cd2c4a0d547876baa6f38cabf625";
    private static final String FBR_HASH = "8a3c4b262d721acd49a4bf97d5213199c86fa2b9";
    private static final HashSet<String> validAppSignatureHashes = ;
    private TreeSet<Integer> availableVersions;
    
    private static HashSet<String> buildAppSignatureHashes()
    {
      HashSet localHashSet = new HashSet();
      localHashSet.add("8a3c4b262d721acd49a4bf97d5213199c86fa2b9");
      localHashSet.add("a4b7452e2ed8f5f191058ca7bbfd26b0d3214bfc");
      localHashSet.add("5e8f16062ea3cd2c4a0d547876baa6f38cabf625");
      return localHashSet;
    }
    
    private void fetchAvailableVersions(boolean paramBoolean)
    {
      if (!paramBoolean) {}
      try
      {
        if (availableVersions == null) {
          availableVersions = NativeProtocol.fetchAllAvailableProtocolVersionsForAppInfo(this);
        }
        return;
      }
      finally {}
    }
    
    public TreeSet<Integer> getAvailableVersions()
    {
      if (availableVersions == null) {
        fetchAvailableVersions(false);
      }
      return availableVersions;
    }
    
    protected abstract String getPackage();
    
    public boolean validateSignature(Context paramContext, String paramString)
    {
      String str = Build.BRAND;
      int i = getApplicationInfoflags;
      if ((str.startsWith("generic")) && ((i & 0x2) != 0)) {}
      for (;;)
      {
        return true;
        try
        {
          paramContext = paramContext.getPackageManager().getPackageInfo(paramString, 64);
          if ((signatures == null) || (signatures.length <= 0)) {
            return false;
          }
        }
        catch (PackageManager.NameNotFoundException paramContext)
        {
          return false;
        }
        paramContext = signatures;
        int j = paramContext.length;
        i = 0;
        while (i < j)
        {
          paramString = Utility.sha1hash(paramContext[i].toByteArray());
          if (!validAppSignatureHashes.contains(paramString)) {
            return false;
          }
          i += 1;
        }
      }
    }
  }
  
  private static class WakizashiAppInfo
    extends NativeProtocol.NativeAppInfo
  {
    static final String WAKIZASHI_PACKAGE = "com.facebook.wakizashi";
    
    private WakizashiAppInfo()
    {
      super();
    }
    
    protected String getPackage()
    {
      return "com.facebook.wakizashi";
    }
  }
}

/* Location:
 * Qualified Name:     com.facebook.internal.NativeProtocol
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */