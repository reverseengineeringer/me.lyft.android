package com.facebook;

import android.content.ContentResolver;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.location.Location;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.ParcelFileDescriptor.AutoCloseInputStream;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.facebook.internal.AttributionIdentifiers;
import com.facebook.internal.InternalSettings;
import com.facebook.internal.Logger;
import com.facebook.internal.ServerProtocol;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import com.facebook.share.internal.OpenGraphJSONUtility;
import com.facebook.share.internal.OpenGraphJSONUtility.PhotoJSONProcessor;
import com.facebook.share.model.ShareOpenGraphObject;
import com.facebook.share.model.SharePhoto;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.GZIPOutputStream;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class GraphRequest
{
  private static final String ACCEPT_LANGUAGE_HEADER = "Accept-Language";
  public static final String ACCESS_TOKEN_PARAM = "access_token";
  private static final String ATTACHED_FILES_PARAM = "attached_files";
  private static final String ATTACHMENT_FILENAME_PREFIX = "file";
  private static final String BATCH_APP_ID_PARAM = "batch_app_id";
  private static final String BATCH_BODY_PARAM = "body";
  private static final String BATCH_ENTRY_DEPENDS_ON_PARAM = "depends_on";
  private static final String BATCH_ENTRY_NAME_PARAM = "name";
  private static final String BATCH_ENTRY_OMIT_RESPONSE_ON_SUCCESS_PARAM = "omit_response_on_success";
  private static final String BATCH_METHOD_PARAM = "method";
  private static final String BATCH_PARAM = "batch";
  private static final String BATCH_RELATIVE_URL_PARAM = "relative_url";
  private static final String CAPTION_PARAM = "caption";
  private static final String CONTENT_ENCODING_HEADER = "Content-Encoding";
  private static final String CONTENT_TYPE_HEADER = "Content-Type";
  private static final String DEBUG_KEY = "__debug__";
  private static final String DEBUG_MESSAGES_KEY = "messages";
  private static final String DEBUG_MESSAGE_KEY = "message";
  private static final String DEBUG_MESSAGE_LINK_KEY = "link";
  private static final String DEBUG_MESSAGE_TYPE_KEY = "type";
  private static final String DEBUG_PARAM = "debug";
  private static final String DEBUG_SEVERITY_INFO = "info";
  private static final String DEBUG_SEVERITY_WARNING = "warning";
  public static final String FIELDS_PARAM = "fields";
  private static final String FORMAT_JSON = "json";
  private static final String FORMAT_PARAM = "format";
  private static final String GRAPH_PATH_FORMAT = "%s/%s";
  private static final String ISO_8601_FORMAT_STRING = "yyyy-MM-dd'T'HH:mm:ssZ";
  public static final int MAXIMUM_BATCH_SIZE = 50;
  private static final String ME = "me";
  private static final String MIME_BOUNDARY = "3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f";
  private static final String MY_FRIENDS = "me/friends";
  private static final String MY_PHOTOS = "me/photos";
  private static final String PICTURE_PARAM = "picture";
  private static final String SDK_ANDROID = "android";
  private static final String SDK_PARAM = "sdk";
  private static final String SEARCH = "search";
  public static final String TAG = GraphRequest.class.getSimpleName();
  private static final String USER_AGENT_BASE = "FBAndroidSDK";
  private static final String USER_AGENT_HEADER = "User-Agent";
  private static final String VIDEOS_SUFFIX = "/videos";
  private static String defaultBatchApplicationId;
  private static volatile String userAgent;
  private static Pattern versionPattern = Pattern.compile("^/?v\\d+\\.\\d+/(.*)");
  private AccessToken accessToken;
  private String batchEntryDependsOn;
  private String batchEntryName;
  private boolean batchEntryOmitResultOnSuccess = true;
  private Callback callback;
  private JSONObject graphObject;
  private String graphPath;
  private HttpMethod httpMethod;
  private String overriddenURL;
  private Bundle parameters;
  private boolean skipClientToken = false;
  private Object tag;
  private String version;
  
  public GraphRequest()
  {
    this(null, null, null, null, null);
  }
  
  public GraphRequest(AccessToken paramAccessToken, String paramString)
  {
    this(paramAccessToken, paramString, null, null, null);
  }
  
  public GraphRequest(AccessToken paramAccessToken, String paramString, Bundle paramBundle, HttpMethod paramHttpMethod)
  {
    this(paramAccessToken, paramString, paramBundle, paramHttpMethod, null);
  }
  
  public GraphRequest(AccessToken paramAccessToken, String paramString, Bundle paramBundle, HttpMethod paramHttpMethod, Callback paramCallback)
  {
    this(paramAccessToken, paramString, paramBundle, paramHttpMethod, paramCallback, null);
  }
  
  public GraphRequest(AccessToken paramAccessToken, String paramString1, Bundle paramBundle, HttpMethod paramHttpMethod, Callback paramCallback, String paramString2)
  {
    accessToken = paramAccessToken;
    graphPath = paramString1;
    version = paramString2;
    setCallback(paramCallback);
    setHttpMethod(paramHttpMethod);
    if (paramBundle != null) {}
    for (parameters = new Bundle(paramBundle);; parameters = new Bundle())
    {
      if (version == null) {
        version = ServerProtocol.getAPIVersion();
      }
      return;
    }
  }
  
  GraphRequest(AccessToken paramAccessToken, URL paramURL)
  {
    accessToken = paramAccessToken;
    overriddenURL = paramURL.toString();
    setHttpMethod(HttpMethod.GET);
    parameters = new Bundle();
  }
  
  private void addCommonParameters()
  {
    String str1;
    if (accessToken != null) {
      if (!parameters.containsKey("access_token"))
      {
        str1 = accessToken.getToken();
        Logger.registerAccessToken(str1);
        parameters.putString("access_token", str1);
      }
    }
    do
    {
      for (;;)
      {
        parameters.putString("sdk", "android");
        parameters.putString("format", "json");
        if (!FacebookSdk.isLoggingBehaviorEnabled(LoggingBehavior.GRAPH_API_DEBUG_INFO)) {
          break;
        }
        parameters.putString("debug", "info");
        return;
        if ((!skipClientToken) && (!parameters.containsKey("access_token")))
        {
          str1 = FacebookSdk.getApplicationId();
          String str2 = FacebookSdk.getClientToken();
          if ((!Utility.isNullOrEmpty(str1)) && (!Utility.isNullOrEmpty(str2)))
          {
            str1 = str1 + "|" + str2;
            parameters.putString("access_token", str1);
          }
          else
          {
            Log.d(TAG, "Warning: Request without access token missing application ID or client token.");
          }
        }
      }
    } while (!FacebookSdk.isLoggingBehaviorEnabled(LoggingBehavior.GRAPH_API_DEBUG_WARNING));
    parameters.putString("debug", "warning");
  }
  
  private String appendParametersToBaseUrl(String paramString)
  {
    Uri.Builder localBuilder = new Uri.Builder().encodedPath(paramString);
    Iterator localIterator = parameters.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      Object localObject = parameters.get(str);
      paramString = (String)localObject;
      if (localObject == null) {
        paramString = "";
      }
      if (isSupportedParameterType(paramString)) {
        localBuilder.appendQueryParameter(str, parameterToString(paramString).toString());
      } else if (httpMethod == HttpMethod.GET) {
        throw new IllegalArgumentException(String.format(Locale.US, "Unsupported parameter type for GET request: %s", new Object[] { paramString.getClass().getSimpleName() }));
      }
    }
    return localBuilder.toString();
  }
  
  private static HttpURLConnection createConnection(URL paramURL)
    throws IOException
  {
    paramURL = (HttpURLConnection)paramURL.openConnection();
    paramURL.setRequestProperty("User-Agent", getUserAgent());
    paramURL.setRequestProperty("Accept-Language", Locale.getDefault().toString());
    paramURL.setChunkedStreamingMode(0);
    return paramURL;
  }
  
  public static GraphRequest createOpenGraphObject(ShareOpenGraphObject paramShareOpenGraphObject)
    throws FacebookException
  {
    Object localObject2 = paramShareOpenGraphObject.getString("type");
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = paramShareOpenGraphObject.getString("og:type");
    }
    if (localObject1 == null) {
      throw new FacebookException("Open graph object type cannot be null");
    }
    try
    {
      localObject2 = (JSONObject)OpenGraphJSONUtility.toJSONValue(paramShareOpenGraphObject, new OpenGraphJSONUtility.PhotoJSONProcessor()
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
          catch (Exception paramAnonymousSharePhoto)
          {
            throw new FacebookException("Unable to attach images", paramAnonymousSharePhoto);
          }
        }
      });
      paramShareOpenGraphObject = new Bundle();
      paramShareOpenGraphObject.putString("object", ((JSONObject)localObject2).toString());
      localObject1 = String.format(Locale.ROOT, "%s/%s", new Object[] { "me", "objects/" + (String)localObject1 });
      paramShareOpenGraphObject = new GraphRequest(AccessToken.getCurrentAccessToken(), (String)localObject1, paramShareOpenGraphObject, HttpMethod.POST);
      return paramShareOpenGraphObject;
    }
    catch (JSONException paramShareOpenGraphObject)
    {
      throw new FacebookException(paramShareOpenGraphObject.getMessage());
    }
  }
  
  public static GraphResponse executeAndWait(GraphRequest paramGraphRequest)
  {
    paramGraphRequest = executeBatchAndWait(new GraphRequest[] { paramGraphRequest });
    if ((paramGraphRequest == null) || (paramGraphRequest.size() != 1)) {
      throw new FacebookException("invalid state: expected a single response");
    }
    return (GraphResponse)paramGraphRequest.get(0);
  }
  
  public static List<GraphResponse> executeBatchAndWait(GraphRequestBatch paramGraphRequestBatch)
  {
    Validate.notEmptyAndContainsNoNulls(paramGraphRequestBatch, "requests");
    Object localObject2 = null;
    Object localObject1 = localObject2;
    try
    {
      HttpURLConnection localHttpURLConnection = toHttpConnection(paramGraphRequestBatch);
      localObject2 = localHttpURLConnection;
      localObject1 = localObject2;
      paramGraphRequestBatch = executeConnectionAndWait((HttpURLConnection)localObject2, paramGraphRequestBatch);
      return paramGraphRequestBatch;
    }
    catch (Exception localException)
    {
      localObject1 = localObject2;
      List localList = GraphResponse.constructErrorResponses(paramGraphRequestBatch.getRequests(), null, new FacebookException(localException));
      localObject1 = localObject2;
      runCallbacks(paramGraphRequestBatch, localList);
      Utility.disconnectQuietly(null);
      return localList;
    }
    finally
    {
      Utility.disconnectQuietly((URLConnection)localObject1);
    }
  }
  
  public static List<GraphResponse> executeBatchAndWait(Collection<GraphRequest> paramCollection)
  {
    return executeBatchAndWait(new GraphRequestBatch(paramCollection));
  }
  
  public static List<GraphResponse> executeBatchAndWait(GraphRequest... paramVarArgs)
  {
    Validate.notNull(paramVarArgs, "requests");
    return executeBatchAndWait(Arrays.asList(paramVarArgs));
  }
  
  public static GraphRequestAsyncTask executeBatchAsync(GraphRequestBatch paramGraphRequestBatch)
  {
    Validate.notEmptyAndContainsNoNulls(paramGraphRequestBatch, "requests");
    paramGraphRequestBatch = new GraphRequestAsyncTask(paramGraphRequestBatch);
    paramGraphRequestBatch.executeOnExecutor(FacebookSdk.getExecutor(), new Void[0]);
    return paramGraphRequestBatch;
  }
  
  public static GraphRequestAsyncTask executeBatchAsync(Collection<GraphRequest> paramCollection)
  {
    return executeBatchAsync(new GraphRequestBatch(paramCollection));
  }
  
  public static GraphRequestAsyncTask executeBatchAsync(GraphRequest... paramVarArgs)
  {
    Validate.notNull(paramVarArgs, "requests");
    return executeBatchAsync(Arrays.asList(paramVarArgs));
  }
  
  public static List<GraphResponse> executeConnectionAndWait(HttpURLConnection paramHttpURLConnection, GraphRequestBatch paramGraphRequestBatch)
  {
    List localList = GraphResponse.fromHttpConnection(paramHttpURLConnection, paramGraphRequestBatch);
    Utility.disconnectQuietly(paramHttpURLConnection);
    int i = paramGraphRequestBatch.size();
    if (i != localList.size()) {
      throw new FacebookException(String.format(Locale.US, "Received %d responses while expecting %d", new Object[] { Integer.valueOf(localList.size()), Integer.valueOf(i) }));
    }
    runCallbacks(paramGraphRequestBatch, localList);
    AccessTokenManager.getInstance().extendAccessTokenIfNeeded();
    return localList;
  }
  
  public static List<GraphResponse> executeConnectionAndWait(HttpURLConnection paramHttpURLConnection, Collection<GraphRequest> paramCollection)
  {
    return executeConnectionAndWait(paramHttpURLConnection, new GraphRequestBatch(paramCollection));
  }
  
  public static GraphRequestAsyncTask executeConnectionAsync(Handler paramHandler, HttpURLConnection paramHttpURLConnection, GraphRequestBatch paramGraphRequestBatch)
  {
    Validate.notNull(paramHttpURLConnection, "connection");
    paramHttpURLConnection = new GraphRequestAsyncTask(paramHttpURLConnection, paramGraphRequestBatch);
    paramGraphRequestBatch.setCallbackHandler(paramHandler);
    paramHttpURLConnection.executeOnExecutor(FacebookSdk.getExecutor(), new Void[0]);
    return paramHttpURLConnection;
  }
  
  public static GraphRequestAsyncTask executeConnectionAsync(HttpURLConnection paramHttpURLConnection, GraphRequestBatch paramGraphRequestBatch)
  {
    return executeConnectionAsync(null, paramHttpURLConnection, paramGraphRequestBatch);
  }
  
  private static String getBatchAppId(GraphRequestBatch paramGraphRequestBatch)
  {
    if (!Utility.isNullOrEmpty(paramGraphRequestBatch.getBatchApplicationId())) {
      return paramGraphRequestBatch.getBatchApplicationId();
    }
    paramGraphRequestBatch = paramGraphRequestBatch.iterator();
    while (paramGraphRequestBatch.hasNext())
    {
      Object localObject = nextaccessToken;
      if (localObject != null)
      {
        localObject = ((AccessToken)localObject).getApplicationId();
        if (localObject != null) {
          return (String)localObject;
        }
      }
    }
    if (!Utility.isNullOrEmpty(defaultBatchApplicationId)) {
      return defaultBatchApplicationId;
    }
    return FacebookSdk.getApplicationId();
  }
  
  public static final String getDefaultBatchApplicationId()
  {
    return defaultBatchApplicationId;
  }
  
  private static String getDefaultPhotoPathIfNull(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "me/photos";
    }
    return str;
  }
  
  private String getGraphPathWithVersion()
  {
    if (versionPattern.matcher(graphPath).matches()) {
      return graphPath;
    }
    return String.format("%s/%s", new Object[] { version, graphPath });
  }
  
  private static String getMimeContentType()
  {
    return String.format("multipart/form-data; boundary=%s", new Object[] { "3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f" });
  }
  
  private static String getUserAgent()
  {
    if (userAgent == null)
    {
      userAgent = String.format("%s.%s", new Object[] { "FBAndroidSDK", "4.13.1" });
      String str = InternalSettings.getCustomUserAgent();
      if (!Utility.isNullOrEmpty(str)) {
        userAgent = String.format(Locale.ROOT, "%s/%s", new Object[] { userAgent, str });
      }
    }
    return userAgent;
  }
  
  private static boolean hasOnProgressCallbacks(GraphRequestBatch paramGraphRequestBatch)
  {
    Iterator localIterator = paramGraphRequestBatch.getCallbacks().iterator();
    while (localIterator.hasNext()) {
      if (((GraphRequestBatch.Callback)localIterator.next() instanceof GraphRequestBatch.OnProgressCallback)) {
        return true;
      }
    }
    paramGraphRequestBatch = paramGraphRequestBatch.iterator();
    while (paramGraphRequestBatch.hasNext()) {
      if ((((GraphRequest)paramGraphRequestBatch.next()).getCallback() instanceof OnProgressCallback)) {
        return true;
      }
    }
    return false;
  }
  
  private static boolean isGzipCompressible(GraphRequestBatch paramGraphRequestBatch)
  {
    GraphRequest localGraphRequest;
    String str;
    do
    {
      paramGraphRequestBatch = paramGraphRequestBatch.iterator();
      Iterator localIterator;
      while (!localIterator.hasNext())
      {
        if (!paramGraphRequestBatch.hasNext()) {
          break;
        }
        localGraphRequest = (GraphRequest)paramGraphRequestBatch.next();
        localIterator = parameters.keySet().iterator();
      }
      str = (String)localIterator.next();
    } while (!isSupportedAttachmentType(parameters.get(str)));
    return false;
    return true;
  }
  
  private static boolean isMeRequest(String paramString)
  {
    Matcher localMatcher = versionPattern.matcher(paramString);
    if (localMatcher.matches()) {
      paramString = localMatcher.group(1);
    }
    return (paramString.startsWith("me/")) || (paramString.startsWith("/me/"));
  }
  
  private static boolean isSupportedAttachmentType(Object paramObject)
  {
    return ((paramObject instanceof Bitmap)) || ((paramObject instanceof byte[])) || ((paramObject instanceof Uri)) || ((paramObject instanceof ParcelFileDescriptor)) || ((paramObject instanceof ParcelableResourceWithMimeType));
  }
  
  private static boolean isSupportedParameterType(Object paramObject)
  {
    return ((paramObject instanceof String)) || ((paramObject instanceof Boolean)) || ((paramObject instanceof Number)) || ((paramObject instanceof Date));
  }
  
  public static GraphRequest newCustomAudienceThirdPartyIdRequest(AccessToken paramAccessToken, Context paramContext, Callback paramCallback)
  {
    return newCustomAudienceThirdPartyIdRequest(paramAccessToken, paramContext, null, paramCallback);
  }
  
  public static GraphRequest newCustomAudienceThirdPartyIdRequest(AccessToken paramAccessToken, Context paramContext, String paramString, Callback paramCallback)
  {
    String str = paramString;
    if (paramString == null)
    {
      str = paramString;
      if (paramAccessToken != null) {
        str = paramAccessToken.getApplicationId();
      }
    }
    paramString = str;
    if (str == null) {
      paramString = Utility.getMetadataApplicationId(paramContext);
    }
    if (paramString == null) {
      throw new FacebookException("Facebook App ID cannot be determined");
    }
    str = paramString + "/custom_audience_third_party_id";
    AttributionIdentifiers localAttributionIdentifiers = AttributionIdentifiers.getAttributionIdentifiers(paramContext);
    Bundle localBundle = new Bundle();
    if (paramAccessToken == null)
    {
      if (localAttributionIdentifiers == null) {
        throw new FacebookException("There is no access token and attribution identifiers could not be retrieved");
      }
      if (localAttributionIdentifiers.getAttributionId() == null) {
        break label184;
      }
    }
    label184:
    for (paramString = localAttributionIdentifiers.getAttributionId();; paramString = localAttributionIdentifiers.getAndroidAdvertiserId())
    {
      if (localAttributionIdentifiers.getAttributionId() != null) {
        localBundle.putString("udid", paramString);
      }
      if ((FacebookSdk.getLimitEventAndDataUsage(paramContext)) || ((localAttributionIdentifiers != null) && (localAttributionIdentifiers.isTrackingLimited()))) {
        localBundle.putString("limit_event_usage", "1");
      }
      return new GraphRequest(paramAccessToken, str, localBundle, HttpMethod.GET, paramCallback);
    }
  }
  
  public static GraphRequest newDeleteObjectRequest(AccessToken paramAccessToken, String paramString, Callback paramCallback)
  {
    return new GraphRequest(paramAccessToken, paramString, null, HttpMethod.DELETE, paramCallback);
  }
  
  public static GraphRequest newGraphPathRequest(AccessToken paramAccessToken, String paramString, Callback paramCallback)
  {
    return new GraphRequest(paramAccessToken, paramString, null, null, paramCallback);
  }
  
  public static GraphRequest newMeRequest(AccessToken paramAccessToken, GraphJSONObjectCallback paramGraphJSONObjectCallback)
  {
    new GraphRequest(paramAccessToken, "me", null, null, new Callback()
    {
      public void onCompleted(GraphResponse paramAnonymousGraphResponse)
      {
        if (val$callback != null) {
          val$callback.onCompleted(paramAnonymousGraphResponse.getJSONObject(), paramAnonymousGraphResponse);
        }
      }
    });
  }
  
  public static GraphRequest newMyFriendsRequest(AccessToken paramAccessToken, GraphJSONArrayCallback paramGraphJSONArrayCallback)
  {
    new GraphRequest(paramAccessToken, "me/friends", null, null, new Callback()
    {
      public void onCompleted(GraphResponse paramAnonymousGraphResponse)
      {
        if (val$callback != null)
        {
          localObject = paramAnonymousGraphResponse.getJSONObject();
          if (localObject == null) {
            break label35;
          }
        }
        label35:
        for (Object localObject = ((JSONObject)localObject).optJSONArray("data");; localObject = null)
        {
          val$callback.onCompleted((JSONArray)localObject, paramAnonymousGraphResponse);
          return;
        }
      }
    });
  }
  
  public static GraphRequest newPlacesSearchRequest(AccessToken paramAccessToken, Location paramLocation, int paramInt1, int paramInt2, String paramString, GraphJSONArrayCallback paramGraphJSONArrayCallback)
  {
    if ((paramLocation == null) && (Utility.isNullOrEmpty(paramString))) {
      throw new FacebookException("Either location or searchText must be specified.");
    }
    Bundle localBundle = new Bundle(5);
    localBundle.putString("type", "place");
    localBundle.putInt("limit", paramInt2);
    if (paramLocation != null)
    {
      localBundle.putString("center", String.format(Locale.US, "%f,%f", new Object[] { Double.valueOf(paramLocation.getLatitude()), Double.valueOf(paramLocation.getLongitude()) }));
      localBundle.putInt("distance", paramInt1);
    }
    if (!Utility.isNullOrEmpty(paramString)) {
      localBundle.putString("q", paramString);
    }
    paramLocation = new Callback()
    {
      public void onCompleted(GraphResponse paramAnonymousGraphResponse)
      {
        if (val$callback != null)
        {
          localObject = paramAnonymousGraphResponse.getJSONObject();
          if (localObject == null) {
            break label35;
          }
        }
        label35:
        for (Object localObject = ((JSONObject)localObject).optJSONArray("data");; localObject = null)
        {
          val$callback.onCompleted((JSONArray)localObject, paramAnonymousGraphResponse);
          return;
        }
      }
    };
    return new GraphRequest(paramAccessToken, "search", localBundle, HttpMethod.GET, paramLocation);
  }
  
  public static GraphRequest newPostRequest(AccessToken paramAccessToken, String paramString, JSONObject paramJSONObject, Callback paramCallback)
  {
    paramAccessToken = new GraphRequest(paramAccessToken, paramString, null, HttpMethod.POST, paramCallback);
    paramAccessToken.setGraphObject(paramJSONObject);
    return paramAccessToken;
  }
  
  public static GraphRequest newUploadPhotoRequest(AccessToken paramAccessToken, String paramString1, Bitmap paramBitmap, String paramString2, Bundle paramBundle, Callback paramCallback)
  {
    paramString1 = getDefaultPhotoPathIfNull(paramString1);
    Bundle localBundle = new Bundle();
    if (paramBundle != null) {
      localBundle.putAll(paramBundle);
    }
    localBundle.putParcelable("picture", paramBitmap);
    if ((paramString2 != null) && (!paramString2.isEmpty())) {
      localBundle.putString("caption", paramString2);
    }
    return new GraphRequest(paramAccessToken, paramString1, localBundle, HttpMethod.POST, paramCallback);
  }
  
  public static GraphRequest newUploadPhotoRequest(AccessToken paramAccessToken, String paramString1, Uri paramUri, String paramString2, Bundle paramBundle, Callback paramCallback)
    throws FileNotFoundException
  {
    paramString1 = getDefaultPhotoPathIfNull(paramString1);
    if (Utility.isFileUri(paramUri)) {
      return newUploadPhotoRequest(paramAccessToken, paramString1, new File(paramUri.getPath()), paramString2, paramBundle, paramCallback);
    }
    if (!Utility.isContentUri(paramUri)) {
      throw new FacebookException("The photo Uri must be either a file:// or content:// Uri");
    }
    paramString2 = new Bundle();
    if (paramBundle != null) {
      paramString2.putAll(paramBundle);
    }
    paramString2.putParcelable("picture", paramUri);
    return new GraphRequest(paramAccessToken, paramString1, paramString2, HttpMethod.POST, paramCallback);
  }
  
  public static GraphRequest newUploadPhotoRequest(AccessToken paramAccessToken, String paramString1, File paramFile, String paramString2, Bundle paramBundle, Callback paramCallback)
    throws FileNotFoundException
  {
    paramString1 = getDefaultPhotoPathIfNull(paramString1);
    paramFile = ParcelFileDescriptor.open(paramFile, 268435456);
    Bundle localBundle = new Bundle();
    if (paramBundle != null) {
      localBundle.putAll(paramBundle);
    }
    localBundle.putParcelable("picture", paramFile);
    if ((paramString2 != null) && (!paramString2.isEmpty())) {
      localBundle.putString("caption", paramString2);
    }
    return new GraphRequest(paramAccessToken, paramString1, localBundle, HttpMethod.POST, paramCallback);
  }
  
  private static String parameterToString(Object paramObject)
  {
    if ((paramObject instanceof String)) {
      return (String)paramObject;
    }
    if (((paramObject instanceof Boolean)) || ((paramObject instanceof Number))) {
      return paramObject.toString();
    }
    if ((paramObject instanceof Date)) {
      return new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ", Locale.US).format(paramObject);
    }
    throw new IllegalArgumentException("Unsupported parameter type.");
  }
  
  private static void processGraphObject(JSONObject paramJSONObject, String paramString, KeyValueSerializer paramKeyValueSerializer)
    throws IOException
  {
    int i = 0;
    label50:
    String str;
    Object localObject;
    if (isMeRequest(paramString))
    {
      i = paramString.indexOf(":");
      int j = paramString.indexOf("?");
      if ((i > 3) && ((j == -1) || (i < j))) {
        i = 1;
      }
    }
    else
    {
      paramString = paramJSONObject.keys();
      if (!paramString.hasNext()) {
        return;
      }
      str = (String)paramString.next();
      localObject = paramJSONObject.opt(str);
      if ((i == 0) || (!str.equalsIgnoreCase("image"))) {
        break label114;
      }
    }
    label114:
    for (boolean bool = true;; bool = false)
    {
      processGraphObjectProperty(str, localObject, paramKeyValueSerializer, bool);
      break label50;
      i = 0;
      break;
    }
  }
  
  private static void processGraphObjectProperty(String paramString, Object paramObject, KeyValueSerializer paramKeyValueSerializer, boolean paramBoolean)
    throws IOException
  {
    Object localObject = paramObject.getClass();
    if (JSONObject.class.isAssignableFrom((Class)localObject))
    {
      paramObject = (JSONObject)paramObject;
      if (paramBoolean)
      {
        localObject = ((JSONObject)paramObject).keys();
        while (((Iterator)localObject).hasNext())
        {
          String str = (String)((Iterator)localObject).next();
          processGraphObjectProperty(String.format("%s[%s]", new Object[] { paramString, str }), ((JSONObject)paramObject).opt(str), paramKeyValueSerializer, paramBoolean);
        }
      }
      if (((JSONObject)paramObject).has("id")) {
        processGraphObjectProperty(paramString, ((JSONObject)paramObject).optString("id"), paramKeyValueSerializer, paramBoolean);
      }
    }
    do
    {
      for (;;)
      {
        return;
        if (((JSONObject)paramObject).has("url"))
        {
          processGraphObjectProperty(paramString, ((JSONObject)paramObject).optString("url"), paramKeyValueSerializer, paramBoolean);
          return;
        }
        if (((JSONObject)paramObject).has("fbsdk:create_object"))
        {
          processGraphObjectProperty(paramString, ((JSONObject)paramObject).toString(), paramKeyValueSerializer, paramBoolean);
          return;
          if (!JSONArray.class.isAssignableFrom((Class)localObject)) {
            break;
          }
          paramObject = (JSONArray)paramObject;
          int j = ((JSONArray)paramObject).length();
          int i = 0;
          while (i < j)
          {
            processGraphObjectProperty(String.format(Locale.ROOT, "%s[%d]", new Object[] { paramString, Integer.valueOf(i) }), ((JSONArray)paramObject).opt(i), paramKeyValueSerializer, paramBoolean);
            i += 1;
          }
        }
      }
      if ((String.class.isAssignableFrom((Class)localObject)) || (Number.class.isAssignableFrom((Class)localObject)) || (Boolean.class.isAssignableFrom((Class)localObject)))
      {
        paramKeyValueSerializer.writeString(paramString, paramObject.toString());
        return;
      }
    } while (!Date.class.isAssignableFrom((Class)localObject));
    paramObject = (Date)paramObject;
    paramKeyValueSerializer.writeString(paramString, new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ", Locale.US).format((Date)paramObject));
  }
  
  private static void processRequest(GraphRequestBatch paramGraphRequestBatch, Logger paramLogger, int paramInt, URL paramURL, OutputStream paramOutputStream, boolean paramBoolean)
    throws IOException, JSONException
  {
    paramOutputStream = new Serializer(paramOutputStream, paramLogger, paramBoolean);
    if (paramInt == 1)
    {
      paramGraphRequestBatch = paramGraphRequestBatch.get(0);
      HashMap localHashMap = new HashMap();
      Iterator localIterator = parameters.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        Object localObject = parameters.get(str);
        if (isSupportedAttachmentType(localObject)) {
          localHashMap.put(str, new Attachment(paramGraphRequestBatch, localObject));
        }
      }
      if (paramLogger != null) {
        paramLogger.append("  Parameters:\n");
      }
      serializeParameters(parameters, paramOutputStream, paramGraphRequestBatch);
      if (paramLogger != null) {
        paramLogger.append("  Attachments:\n");
      }
      serializeAttachments(localHashMap, paramOutputStream);
      if (graphObject != null) {
        processGraphObject(graphObject, paramURL.getPath(), paramOutputStream);
      }
      return;
    }
    paramURL = getBatchAppId(paramGraphRequestBatch);
    if (Utility.isNullOrEmpty(paramURL)) {
      throw new FacebookException("App ID was not specified at the request or Settings.");
    }
    paramOutputStream.writeString("batch_app_id", paramURL);
    paramURL = new HashMap();
    serializeRequestsAsJSON(paramOutputStream, paramGraphRequestBatch, paramURL);
    if (paramLogger != null) {
      paramLogger.append("  Attachments:\n");
    }
    serializeAttachments(paramURL, paramOutputStream);
  }
  
  static void runCallbacks(final GraphRequestBatch paramGraphRequestBatch, List<GraphResponse> paramList)
  {
    int j = paramGraphRequestBatch.size();
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < j)
    {
      GraphRequest localGraphRequest = paramGraphRequestBatch.get(i);
      if (callback != null) {
        localArrayList.add(new Pair(callback, paramList.get(i)));
      }
      i += 1;
    }
    if (localArrayList.size() > 0)
    {
      paramList = new Runnable()
      {
        public void run()
        {
          Iterator localIterator = val$callbacks.iterator();
          while (localIterator.hasNext())
          {
            Pair localPair = (Pair)localIterator.next();
            ((GraphRequest.Callback)first).onCompleted((GraphResponse)second);
          }
          localIterator = paramGraphRequestBatch.getCallbacks().iterator();
          while (localIterator.hasNext()) {
            ((GraphRequestBatch.Callback)localIterator.next()).onBatchCompleted(paramGraphRequestBatch);
          }
        }
      };
      paramGraphRequestBatch = paramGraphRequestBatch.getCallbackHandler();
      if (paramGraphRequestBatch == null) {
        paramList.run();
      }
    }
    else
    {
      return;
    }
    paramGraphRequestBatch.post(paramList);
  }
  
  private static void serializeAttachments(Map<String, Attachment> paramMap, Serializer paramSerializer)
    throws IOException
  {
    Iterator localIterator = paramMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      Attachment localAttachment = (Attachment)paramMap.get(str);
      if (isSupportedAttachmentType(localAttachment.getValue())) {
        paramSerializer.writeObject(str, localAttachment.getValue(), localAttachment.getRequest());
      }
    }
  }
  
  private static void serializeParameters(Bundle paramBundle, Serializer paramSerializer, GraphRequest paramGraphRequest)
    throws IOException
  {
    Iterator localIterator = paramBundle.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      Object localObject = paramBundle.get(str);
      if (isSupportedParameterType(localObject)) {
        paramSerializer.writeObject(str, localObject, paramGraphRequest);
      }
    }
  }
  
  private static void serializeRequestsAsJSON(Serializer paramSerializer, Collection<GraphRequest> paramCollection, Map<String, Attachment> paramMap)
    throws JSONException, IOException
  {
    JSONArray localJSONArray = new JSONArray();
    Iterator localIterator = paramCollection.iterator();
    while (localIterator.hasNext()) {
      ((GraphRequest)localIterator.next()).serializeToBatch(localJSONArray, paramMap);
    }
    paramSerializer.writeRequestsAsJson("batch", localJSONArray, paramCollection);
  }
  
  private void serializeToBatch(JSONArray paramJSONArray, final Map<String, Attachment> paramMap)
    throws JSONException, IOException
  {
    JSONObject localJSONObject = new JSONObject();
    if (batchEntryName != null)
    {
      localJSONObject.put("name", batchEntryName);
      localJSONObject.put("omit_response_on_success", batchEntryOmitResultOnSuccess);
    }
    if (batchEntryDependsOn != null) {
      localJSONObject.put("depends_on", batchEntryDependsOn);
    }
    String str1 = getUrlForBatchedRequest();
    localJSONObject.put("relative_url", str1);
    localJSONObject.put("method", httpMethod);
    if (accessToken != null) {
      Logger.registerAccessToken(accessToken.getToken());
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = parameters.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = parameters.get((String)localObject);
      if (isSupportedAttachmentType(localObject))
      {
        String str2 = String.format(Locale.ROOT, "%s%d", new Object[] { "file", Integer.valueOf(paramMap.size()) });
        localArrayList.add(str2);
        paramMap.put(str2, new Attachment(this, localObject));
      }
    }
    if (!localArrayList.isEmpty()) {
      localJSONObject.put("attached_files", TextUtils.join(",", localArrayList));
    }
    if (graphObject != null)
    {
      paramMap = new ArrayList();
      processGraphObject(graphObject, str1, new KeyValueSerializer()
      {
        public void writeString(String paramAnonymousString1, String paramAnonymousString2)
          throws IOException
        {
          paramMap.add(String.format(Locale.US, "%s=%s", new Object[] { paramAnonymousString1, URLEncoder.encode(paramAnonymousString2, "UTF-8") }));
        }
      });
      localJSONObject.put("body", TextUtils.join("&", paramMap));
    }
    paramJSONArray.put(localJSONObject);
  }
  
  static final void serializeToUrlConnection(GraphRequestBatch paramGraphRequestBatch, HttpURLConnection paramHttpURLConnection)
    throws IOException, JSONException
  {
    Logger localLogger = new Logger(LoggingBehavior.REQUESTS, "Request");
    int j = paramGraphRequestBatch.size();
    boolean bool = isGzipCompressible(paramGraphRequestBatch);
    URL localURL;
    if (j == 1)
    {
      localObject1 = get0httpMethod;
      paramHttpURLConnection.setRequestMethod(((HttpMethod)localObject1).name());
      setConnectionContentType(paramHttpURLConnection, bool);
      localURL = paramHttpURLConnection.getURL();
      localLogger.append("Request:\n");
      localLogger.appendKeyValue("Id", paramGraphRequestBatch.getId());
      localLogger.appendKeyValue("URL", localURL);
      localLogger.appendKeyValue("Method", paramHttpURLConnection.getRequestMethod());
      localLogger.appendKeyValue("User-Agent", paramHttpURLConnection.getRequestProperty("User-Agent"));
      localLogger.appendKeyValue("Content-Type", paramHttpURLConnection.getRequestProperty("Content-Type"));
      paramHttpURLConnection.setConnectTimeout(paramGraphRequestBatch.getTimeout());
      paramHttpURLConnection.setReadTimeout(paramGraphRequestBatch.getTimeout());
      if (localObject1 != HttpMethod.POST) {
        break label174;
      }
    }
    label174:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        break label179;
      }
      localLogger.log();
      return;
      localObject1 = HttpMethod.POST;
      break;
    }
    label179:
    paramHttpURLConnection.setDoOutput(true);
    localObject1 = null;
    try
    {
      localObject2 = new BufferedOutputStream(paramHttpURLConnection.getOutputStream());
      paramHttpURLConnection = (HttpURLConnection)localObject2;
      if (bool) {
        localObject1 = localObject2;
      }
    }
    finally
    {
      Object localObject2;
      label292:
      if (localObject1 != null) {
        ((OutputStream)localObject1).close();
      }
    }
    try
    {
      paramHttpURLConnection = new GZIPOutputStream((OutputStream)localObject2);
      localObject1 = paramHttpURLConnection;
      if (!hasOnProgressCallbacks(paramGraphRequestBatch)) {
        break label338;
      }
      localObject1 = paramHttpURLConnection;
      localObject2 = new ProgressNoopOutputStream(paramGraphRequestBatch.getCallbackHandler());
      localObject1 = paramHttpURLConnection;
      processRequest(paramGraphRequestBatch, null, j, localURL, (OutputStream)localObject2, bool);
      localObject1 = paramHttpURLConnection;
      i = ((ProgressNoopOutputStream)localObject2).getMaxProgress();
      localObject1 = paramHttpURLConnection;
      paramHttpURLConnection = new ProgressOutputStream(paramHttpURLConnection, paramGraphRequestBatch, ((ProgressNoopOutputStream)localObject2).getProgressMap(), i);
    }
    finally
    {
      break label322;
      break label292;
    }
    localObject1 = paramHttpURLConnection;
    processRequest(paramGraphRequestBatch, localLogger, j, localURL, paramHttpURLConnection, bool);
    if (paramHttpURLConnection != null) {
      paramHttpURLConnection.close();
    }
    localLogger.log();
  }
  
  private static void setConnectionContentType(HttpURLConnection paramHttpURLConnection, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      paramHttpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
      paramHttpURLConnection.setRequestProperty("Content-Encoding", "gzip");
      return;
    }
    paramHttpURLConnection.setRequestProperty("Content-Type", getMimeContentType());
  }
  
  public static final void setDefaultBatchApplicationId(String paramString)
  {
    defaultBatchApplicationId = paramString;
  }
  
  static final boolean shouldWarnOnMissingFieldsParam(GraphRequest paramGraphRequest)
  {
    boolean bool2 = false;
    String str = paramGraphRequest.getVersion();
    if (Utility.isNullOrEmpty(str)) {
      return true;
    }
    paramGraphRequest = str;
    if (str.startsWith("v")) {
      paramGraphRequest = str.substring(1);
    }
    paramGraphRequest = paramGraphRequest.split("\\.");
    boolean bool1;
    if ((paramGraphRequest.length < 2) || (Integer.parseInt(paramGraphRequest[0]) <= 2))
    {
      bool1 = bool2;
      if (Integer.parseInt(paramGraphRequest[0]) >= 2)
      {
        bool1 = bool2;
        if (Integer.parseInt(paramGraphRequest[1]) < 4) {}
      }
    }
    else
    {
      bool1 = true;
    }
    return bool1;
  }
  
  public static HttpURLConnection toHttpConnection(GraphRequestBatch paramGraphRequestBatch)
  {
    validateFieldsParamForGetRequests(paramGraphRequestBatch);
    for (;;)
    {
      try
      {
        if (paramGraphRequestBatch.size() == 1)
        {
          localObject3 = new URL(paramGraphRequestBatch.get(0).getUrlForSingleRequest());
          localObject2 = null;
          localObject1 = null;
        }
      }
      catch (MalformedURLException paramGraphRequestBatch)
      {
        Object localObject3;
        throw new FacebookException("could not construct URL for request", paramGraphRequestBatch);
      }
      try
      {
        localObject3 = createConnection((URL)localObject3);
        localObject1 = localObject3;
        localObject2 = localObject3;
        serializeToUrlConnection(paramGraphRequestBatch, (HttpURLConnection)localObject3);
        return (HttpURLConnection)localObject3;
      }
      catch (JSONException paramGraphRequestBatch)
      {
        Utility.disconnectQuietly((URLConnection)localObject1);
        throw new FacebookException("could not construct request body", paramGraphRequestBatch);
      }
      catch (IOException paramGraphRequestBatch)
      {
        for (;;)
        {
          localObject1 = localObject2;
        }
      }
      localObject3 = new URL(ServerProtocol.getGraphUrlBase());
    }
  }
  
  public static HttpURLConnection toHttpConnection(Collection<GraphRequest> paramCollection)
  {
    Validate.notEmptyAndContainsNoNulls(paramCollection, "requests");
    return toHttpConnection(new GraphRequestBatch(paramCollection));
  }
  
  public static HttpURLConnection toHttpConnection(GraphRequest... paramVarArgs)
  {
    return toHttpConnection(Arrays.asList(paramVarArgs));
  }
  
  static final void validateFieldsParamForGetRequests(GraphRequestBatch paramGraphRequestBatch)
  {
    paramGraphRequestBatch = paramGraphRequestBatch.iterator();
    while (paramGraphRequestBatch.hasNext())
    {
      GraphRequest localGraphRequest = (GraphRequest)paramGraphRequestBatch.next();
      if ((HttpMethod.GET.equals(localGraphRequest.getHttpMethod())) && (shouldWarnOnMissingFieldsParam(localGraphRequest)))
      {
        Bundle localBundle = localGraphRequest.getParameters();
        if ((!localBundle.containsKey("fields")) || (Utility.isNullOrEmpty(localBundle.getString("fields")))) {
          Logger.log(LoggingBehavior.DEVELOPER_ERRORS, 5, "Request", "starting with Graph API v2.4, GET requests for /%s should contain an explicit \"fields\" parameter.", new Object[] { localGraphRequest.getGraphPath() });
        }
      }
    }
  }
  
  public final GraphResponse executeAndWait()
  {
    return executeAndWait(this);
  }
  
  public final GraphRequestAsyncTask executeAsync()
  {
    return executeBatchAsync(new GraphRequest[] { this });
  }
  
  public final AccessToken getAccessToken()
  {
    return accessToken;
  }
  
  public final String getBatchEntryDependsOn()
  {
    return batchEntryDependsOn;
  }
  
  public final String getBatchEntryName()
  {
    return batchEntryName;
  }
  
  public final boolean getBatchEntryOmitResultOnSuccess()
  {
    return batchEntryOmitResultOnSuccess;
  }
  
  public final Callback getCallback()
  {
    return callback;
  }
  
  public final JSONObject getGraphObject()
  {
    return graphObject;
  }
  
  public final String getGraphPath()
  {
    return graphPath;
  }
  
  public final HttpMethod getHttpMethod()
  {
    return httpMethod;
  }
  
  public final Bundle getParameters()
  {
    return parameters;
  }
  
  public final Object getTag()
  {
    return tag;
  }
  
  final String getUrlForBatchedRequest()
  {
    if (overriddenURL != null) {
      throw new FacebookException("Can't override URL for a batch request");
    }
    String str = getGraphPathWithVersion();
    addCommonParameters();
    return appendParametersToBaseUrl(str);
  }
  
  final String getUrlForSingleRequest()
  {
    if (overriddenURL != null) {
      return overriddenURL.toString();
    }
    if ((getHttpMethod() == HttpMethod.POST) && (graphPath != null) && (graphPath.endsWith("/videos"))) {}
    for (String str = ServerProtocol.getGraphVideoUrlBase();; str = ServerProtocol.getGraphUrlBase())
    {
      str = String.format("%s/%s", new Object[] { str, getGraphPathWithVersion() });
      addCommonParameters();
      return appendParametersToBaseUrl(str);
    }
  }
  
  public final String getVersion()
  {
    return version;
  }
  
  public final void setAccessToken(AccessToken paramAccessToken)
  {
    accessToken = paramAccessToken;
  }
  
  public final void setBatchEntryDependsOn(String paramString)
  {
    batchEntryDependsOn = paramString;
  }
  
  public final void setBatchEntryName(String paramString)
  {
    batchEntryName = paramString;
  }
  
  public final void setBatchEntryOmitResultOnSuccess(boolean paramBoolean)
  {
    batchEntryOmitResultOnSuccess = paramBoolean;
  }
  
  public final void setCallback(final Callback paramCallback)
  {
    if ((FacebookSdk.isLoggingBehaviorEnabled(LoggingBehavior.GRAPH_API_DEBUG_INFO)) || (FacebookSdk.isLoggingBehaviorEnabled(LoggingBehavior.GRAPH_API_DEBUG_WARNING)))
    {
      callback = new Callback()
      {
        public void onCompleted(GraphResponse paramAnonymousGraphResponse)
        {
          Object localObject1 = paramAnonymousGraphResponse.getJSONObject();
          JSONArray localJSONArray;
          label28:
          int i;
          label35:
          label65:
          Object localObject2;
          if (localObject1 != null)
          {
            localObject1 = ((JSONObject)localObject1).optJSONObject("__debug__");
            if (localObject1 == null) {
              break label181;
            }
            localJSONArray = ((JSONObject)localObject1).optJSONArray("messages");
            if (localJSONArray == null) {
              break label204;
            }
            i = 0;
            if (i >= localJSONArray.length()) {
              break label204;
            }
            localObject3 = localJSONArray.optJSONObject(i);
            if (localObject3 == null) {
              break label187;
            }
            localObject1 = ((JSONObject)localObject3).optString("message");
            if (localObject3 == null) {
              break label192;
            }
            localObject2 = ((JSONObject)localObject3).optString("type");
            label79:
            if (localObject3 == null) {
              break label198;
            }
          }
          label181:
          label187:
          label192:
          label198:
          for (Object localObject3 = ((JSONObject)localObject3).optString("link");; localObject3 = null)
          {
            if ((localObject1 != null) && (localObject2 != null))
            {
              LoggingBehavior localLoggingBehavior = LoggingBehavior.GRAPH_API_DEBUG_INFO;
              if (((String)localObject2).equals("warning")) {
                localLoggingBehavior = LoggingBehavior.GRAPH_API_DEBUG_WARNING;
              }
              localObject2 = localObject1;
              if (!Utility.isNullOrEmpty((String)localObject3)) {
                localObject2 = (String)localObject1 + " Link: " + (String)localObject3;
              }
              Logger.log(localLoggingBehavior, GraphRequest.TAG, (String)localObject2);
            }
            i += 1;
            break label35;
            localObject1 = null;
            break;
            localJSONArray = null;
            break label28;
            localObject1 = null;
            break label65;
            localObject2 = null;
            break label79;
          }
          label204:
          if (paramCallback != null) {
            paramCallback.onCompleted(paramAnonymousGraphResponse);
          }
        }
      };
      return;
    }
    callback = paramCallback;
  }
  
  public final void setGraphObject(JSONObject paramJSONObject)
  {
    graphObject = paramJSONObject;
  }
  
  public final void setGraphPath(String paramString)
  {
    graphPath = paramString;
  }
  
  public final void setHttpMethod(HttpMethod paramHttpMethod)
  {
    if ((overriddenURL != null) && (paramHttpMethod != HttpMethod.GET)) {
      throw new FacebookException("Can't change HTTP method on request with overridden URL.");
    }
    if (paramHttpMethod != null) {}
    for (;;)
    {
      httpMethod = paramHttpMethod;
      return;
      paramHttpMethod = HttpMethod.GET;
    }
  }
  
  public final void setParameters(Bundle paramBundle)
  {
    parameters = paramBundle;
  }
  
  public final void setSkipClientToken(boolean paramBoolean)
  {
    skipClientToken = paramBoolean;
  }
  
  public final void setTag(Object paramObject)
  {
    tag = paramObject;
  }
  
  public final void setVersion(String paramString)
  {
    version = paramString;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("{Request: ").append(" accessToken: ");
    if (accessToken == null) {}
    for (Object localObject = "null";; localObject = accessToken) {
      return localObject + ", graphPath: " + graphPath + ", graphObject: " + graphObject + ", httpMethod: " + httpMethod + ", parameters: " + parameters + "}";
    }
  }
  
  private static class Attachment
  {
    private final GraphRequest request;
    private final Object value;
    
    public Attachment(GraphRequest paramGraphRequest, Object paramObject)
    {
      request = paramGraphRequest;
      value = paramObject;
    }
    
    public GraphRequest getRequest()
    {
      return request;
    }
    
    public Object getValue()
    {
      return value;
    }
  }
  
  public static abstract interface Callback
  {
    public abstract void onCompleted(GraphResponse paramGraphResponse);
  }
  
  public static abstract interface GraphJSONArrayCallback
  {
    public abstract void onCompleted(JSONArray paramJSONArray, GraphResponse paramGraphResponse);
  }
  
  public static abstract interface GraphJSONObjectCallback
  {
    public abstract void onCompleted(JSONObject paramJSONObject, GraphResponse paramGraphResponse);
  }
  
  private static abstract interface KeyValueSerializer
  {
    public abstract void writeString(String paramString1, String paramString2)
      throws IOException;
  }
  
  public static abstract interface OnProgressCallback
    extends GraphRequest.Callback
  {
    public abstract void onProgress(long paramLong1, long paramLong2);
  }
  
  public static class ParcelableResourceWithMimeType<RESOURCE extends Parcelable>
    implements Parcelable
  {
    public static final Parcelable.Creator<ParcelableResourceWithMimeType> CREATOR = new Parcelable.Creator()
    {
      public GraphRequest.ParcelableResourceWithMimeType createFromParcel(Parcel paramAnonymousParcel)
      {
        return new GraphRequest.ParcelableResourceWithMimeType(paramAnonymousParcel, null);
      }
      
      public GraphRequest.ParcelableResourceWithMimeType[] newArray(int paramAnonymousInt)
      {
        return new GraphRequest.ParcelableResourceWithMimeType[paramAnonymousInt];
      }
    };
    private final String mimeType;
    private final RESOURCE resource;
    
    private ParcelableResourceWithMimeType(Parcel paramParcel)
    {
      mimeType = paramParcel.readString();
      resource = paramParcel.readParcelable(FacebookSdk.getApplicationContext().getClassLoader());
    }
    
    public ParcelableResourceWithMimeType(RESOURCE paramRESOURCE, String paramString)
    {
      mimeType = paramString;
      resource = paramRESOURCE;
    }
    
    public int describeContents()
    {
      return 1;
    }
    
    public String getMimeType()
    {
      return mimeType;
    }
    
    public RESOURCE getResource()
    {
      return resource;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeString(mimeType);
      paramParcel.writeParcelable(resource, paramInt);
    }
  }
  
  private static class Serializer
    implements GraphRequest.KeyValueSerializer
  {
    private boolean firstWrite = true;
    private final Logger logger;
    private final OutputStream outputStream;
    private boolean useUrlEncode = false;
    
    public Serializer(OutputStream paramOutputStream, Logger paramLogger, boolean paramBoolean)
    {
      outputStream = paramOutputStream;
      logger = paramLogger;
      useUrlEncode = paramBoolean;
    }
    
    private RuntimeException getInvalidTypeError()
    {
      return new IllegalArgumentException("value is not a supported type.");
    }
    
    public void write(String paramString, Object... paramVarArgs)
      throws IOException
    {
      if (!useUrlEncode)
      {
        if (firstWrite)
        {
          outputStream.write("--".getBytes());
          outputStream.write("3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f".getBytes());
          outputStream.write("\r\n".getBytes());
          firstWrite = false;
        }
        outputStream.write(String.format(paramString, paramVarArgs).getBytes());
        return;
      }
      outputStream.write(URLEncoder.encode(String.format(Locale.US, paramString, paramVarArgs), "UTF-8").getBytes());
    }
    
    public void writeBitmap(String paramString, Bitmap paramBitmap)
      throws IOException
    {
      writeContentDisposition(paramString, paramString, "image/png");
      paramBitmap.compress(Bitmap.CompressFormat.PNG, 100, outputStream);
      writeLine("", new Object[0]);
      writeRecordBoundary();
      if (logger != null) {
        logger.appendKeyValue("    " + paramString, "<Image>");
      }
    }
    
    public void writeBytes(String paramString, byte[] paramArrayOfByte)
      throws IOException
    {
      writeContentDisposition(paramString, paramString, "content/unknown");
      outputStream.write(paramArrayOfByte);
      writeLine("", new Object[0]);
      writeRecordBoundary();
      if (logger != null) {
        logger.appendKeyValue("    " + paramString, String.format(Locale.ROOT, "<Data: %d>", new Object[] { Integer.valueOf(paramArrayOfByte.length) }));
      }
    }
    
    public void writeContentDisposition(String paramString1, String paramString2, String paramString3)
      throws IOException
    {
      if (!useUrlEncode)
      {
        write("Content-Disposition: form-data; name=\"%s\"", new Object[] { paramString1 });
        if (paramString2 != null) {
          write("; filename=\"%s\"", new Object[] { paramString2 });
        }
        writeLine("", new Object[0]);
        if (paramString3 != null) {
          writeLine("%s: %s", new Object[] { "Content-Type", paramString3 });
        }
        writeLine("", new Object[0]);
        return;
      }
      outputStream.write(String.format("%s=", new Object[] { paramString1 }).getBytes());
    }
    
    public void writeContentUri(String paramString1, Uri paramUri, String paramString2)
      throws IOException
    {
      String str = paramString2;
      if (paramString2 == null) {
        str = "content/unknown";
      }
      writeContentDisposition(paramString1, paramString1, str);
      int i = 0;
      if ((outputStream instanceof ProgressNoopOutputStream))
      {
        long l = Utility.getContentSize(paramUri);
        ((ProgressNoopOutputStream)outputStream).addProgress(l);
      }
      for (;;)
      {
        writeLine("", new Object[0]);
        writeRecordBoundary();
        if (logger != null) {
          logger.appendKeyValue("    " + paramString1, String.format(Locale.ROOT, "<Data: %d>", new Object[] { Integer.valueOf(i) }));
        }
        return;
        i = 0 + Utility.copyAndCloseInputStream(FacebookSdk.getApplicationContext().getContentResolver().openInputStream(paramUri), outputStream);
      }
    }
    
    public void writeFile(String paramString1, ParcelFileDescriptor paramParcelFileDescriptor, String paramString2)
      throws IOException
    {
      String str = paramString2;
      if (paramString2 == null) {
        str = "content/unknown";
      }
      writeContentDisposition(paramString1, paramString1, str);
      int i = 0;
      if ((outputStream instanceof ProgressNoopOutputStream)) {
        ((ProgressNoopOutputStream)outputStream).addProgress(paramParcelFileDescriptor.getStatSize());
      }
      for (;;)
      {
        writeLine("", new Object[0]);
        writeRecordBoundary();
        if (logger != null) {
          logger.appendKeyValue("    " + paramString1, String.format(Locale.ROOT, "<Data: %d>", new Object[] { Integer.valueOf(i) }));
        }
        return;
        i = 0 + Utility.copyAndCloseInputStream(new ParcelFileDescriptor.AutoCloseInputStream(paramParcelFileDescriptor), outputStream);
      }
    }
    
    public void writeLine(String paramString, Object... paramVarArgs)
      throws IOException
    {
      write(paramString, paramVarArgs);
      if (!useUrlEncode) {
        write("\r\n", new Object[0]);
      }
    }
    
    public void writeObject(String paramString, Object paramObject, GraphRequest paramGraphRequest)
      throws IOException
    {
      if ((outputStream instanceof RequestOutputStream)) {
        ((RequestOutputStream)outputStream).setCurrentRequest(paramGraphRequest);
      }
      if (GraphRequest.isSupportedParameterType(paramObject))
      {
        writeString(paramString, GraphRequest.parameterToString(paramObject));
        return;
      }
      if ((paramObject instanceof Bitmap))
      {
        writeBitmap(paramString, (Bitmap)paramObject);
        return;
      }
      if ((paramObject instanceof byte[]))
      {
        writeBytes(paramString, (byte[])paramObject);
        return;
      }
      if ((paramObject instanceof Uri))
      {
        writeContentUri(paramString, (Uri)paramObject, null);
        return;
      }
      if ((paramObject instanceof ParcelFileDescriptor))
      {
        writeFile(paramString, (ParcelFileDescriptor)paramObject, null);
        return;
      }
      if ((paramObject instanceof GraphRequest.ParcelableResourceWithMimeType))
      {
        paramGraphRequest = (GraphRequest.ParcelableResourceWithMimeType)paramObject;
        paramObject = paramGraphRequest.getResource();
        paramGraphRequest = paramGraphRequest.getMimeType();
        if ((paramObject instanceof ParcelFileDescriptor))
        {
          writeFile(paramString, (ParcelFileDescriptor)paramObject, paramGraphRequest);
          return;
        }
        if ((paramObject instanceof Uri))
        {
          writeContentUri(paramString, (Uri)paramObject, paramGraphRequest);
          return;
        }
        throw getInvalidTypeError();
      }
      throw getInvalidTypeError();
    }
    
    public void writeRecordBoundary()
      throws IOException
    {
      if (!useUrlEncode)
      {
        writeLine("--%s", new Object[] { "3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f" });
        return;
      }
      outputStream.write("&".getBytes());
    }
    
    public void writeRequestsAsJson(String paramString, JSONArray paramJSONArray, Collection<GraphRequest> paramCollection)
      throws IOException, JSONException
    {
      if (!(outputStream instanceof RequestOutputStream)) {
        writeString(paramString, paramJSONArray.toString());
      }
      do
      {
        return;
        RequestOutputStream localRequestOutputStream = (RequestOutputStream)outputStream;
        writeContentDisposition(paramString, null, null);
        write("[", new Object[0]);
        int i = 0;
        paramCollection = paramCollection.iterator();
        if (paramCollection.hasNext())
        {
          GraphRequest localGraphRequest = (GraphRequest)paramCollection.next();
          JSONObject localJSONObject = paramJSONArray.getJSONObject(i);
          localRequestOutputStream.setCurrentRequest(localGraphRequest);
          if (i > 0) {
            write(",%s", new Object[] { localJSONObject.toString() });
          }
          for (;;)
          {
            i += 1;
            break;
            write("%s", new Object[] { localJSONObject.toString() });
          }
        }
        write("]", new Object[0]);
      } while (logger == null);
      logger.appendKeyValue("    " + paramString, paramJSONArray.toString());
    }
    
    public void writeString(String paramString1, String paramString2)
      throws IOException
    {
      writeContentDisposition(paramString1, null, null);
      writeLine("%s", new Object[] { paramString2 });
      writeRecordBoundary();
      if (logger != null) {
        logger.appendKeyValue("    " + paramString1, paramString2);
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.facebook.GraphRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */