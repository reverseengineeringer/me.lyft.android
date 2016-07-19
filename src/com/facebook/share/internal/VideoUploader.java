package com.facebook.share.internal;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.os.ParcelFileDescriptor.AutoCloseInputStream;
import android.text.TextUtils;
import android.util.Log;
import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookGraphResponseException;
import com.facebook.FacebookRequestError;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import com.facebook.internal.WorkQueue;
import com.facebook.internal.WorkQueue.WorkItem;
import com.facebook.share.Sharer.Result;
import com.facebook.share.model.ShareVideo;
import com.facebook.share.model.ShareVideoContent;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class VideoUploader
{
  private static final String ERROR_BAD_SERVER_RESPONSE = "Unexpected error in server response";
  private static final String ERROR_UPLOAD = "Video upload failed";
  private static final int MAX_RETRIES_PER_PHASE = 2;
  private static final String PARAM_DESCRIPTION = "description";
  private static final String PARAM_END_OFFSET = "end_offset";
  private static final String PARAM_FILE_SIZE = "file_size";
  private static final String PARAM_REF = "ref";
  private static final String PARAM_SESSION_ID = "upload_session_id";
  private static final String PARAM_START_OFFSET = "start_offset";
  private static final String PARAM_TITLE = "title";
  private static final String PARAM_UPLOAD_PHASE = "upload_phase";
  private static final String PARAM_VALUE_UPLOAD_FINISH_PHASE = "finish";
  private static final String PARAM_VALUE_UPLOAD_START_PHASE = "start";
  private static final String PARAM_VALUE_UPLOAD_TRANSFER_PHASE = "transfer";
  private static final String PARAM_VIDEO_FILE_CHUNK = "video_file_chunk";
  private static final String PARAM_VIDEO_ID = "video_id";
  private static final int RETRY_DELAY_BACK_OFF_FACTOR = 3;
  private static final int RETRY_DELAY_UNIT_MS = 5000;
  private static final String TAG = "VideoUploader";
  private static final int UPLOAD_QUEUE_MAX_CONCURRENT = 8;
  private static AccessTokenTracker accessTokenTracker;
  private static Handler handler;
  private static boolean initialized;
  private static Set<UploadContext> pendingUploads = new HashSet();
  private static WorkQueue uploadQueue = new WorkQueue(8);
  
  private static void cancelAllRequests()
  {
    try
    {
      Iterator localIterator = pendingUploads.iterator();
      while (localIterator.hasNext()) {
        nextisCanceled = true;
      }
    }
    finally {}
  }
  
  private static void enqueueRequest(UploadContext paramUploadContext, Runnable paramRunnable)
  {
    try
    {
      workItem = uploadQueue.addActiveWorkItem(paramRunnable);
      return;
    }
    finally
    {
      paramUploadContext = finally;
      throw paramUploadContext;
    }
  }
  
  private static void enqueueUploadChunk(UploadContext paramUploadContext, String paramString1, String paramString2, int paramInt)
  {
    enqueueRequest(paramUploadContext, new TransferChunkWorkItem(paramUploadContext, paramString1, paramString2, paramInt));
  }
  
  private static void enqueueUploadFinish(UploadContext paramUploadContext, int paramInt)
  {
    enqueueRequest(paramUploadContext, new FinishUploadWorkItem(paramUploadContext, paramInt));
  }
  
  private static void enqueueUploadStart(UploadContext paramUploadContext, int paramInt)
  {
    enqueueRequest(paramUploadContext, new StartUploadWorkItem(paramUploadContext, paramInt));
  }
  
  private static byte[] getChunk(UploadContext paramUploadContext, String paramString1, String paramString2)
    throws IOException
  {
    if (!Utility.areObjectsEqual(paramString1, chunkStart))
    {
      logError(null, "Error reading video chunk. Expected chunk '%s'. Requested chunk '%s'.", new Object[] { chunkStart, paramString1 });
      return null;
    }
    long l = Long.parseLong(paramString1);
    int i = (int)(Long.parseLong(paramString2) - l);
    paramString1 = new ByteArrayOutputStream();
    byte[] arrayOfByte = new byte[Math.min(8192, i)];
    int k;
    int j;
    do
    {
      k = videoStream.read(arrayOfByte);
      if (k != -1)
      {
        paramString1.write(arrayOfByte, 0, k);
        j = i - k;
        if (j != 0) {}
      }
      else
      {
        chunkStart = paramString2;
        return paramString1.toByteArray();
      }
      i = j;
    } while (j >= 0);
    logError(null, "Error reading video chunk. Expected buffer length - '%d'. Actual - '%d'.", new Object[] { Integer.valueOf(j + k), Integer.valueOf(k) });
    return null;
  }
  
  private static Handler getHandler()
  {
    try
    {
      if (handler == null) {
        handler = new Handler(Looper.getMainLooper());
      }
      Handler localHandler = handler;
      return localHandler;
    }
    finally {}
  }
  
  private static void issueResponse(UploadContext paramUploadContext, FacebookException paramFacebookException, String paramString)
  {
    removePendingUpload(paramUploadContext);
    Utility.closeQuietly(videoStream);
    if (callback != null)
    {
      if (paramFacebookException != null) {
        ShareInternalUtility.invokeOnErrorCallback(callback, paramFacebookException);
      }
    }
    else {
      return;
    }
    if (isCanceled)
    {
      ShareInternalUtility.invokeOnCancelCallback(callback);
      return;
    }
    ShareInternalUtility.invokeOnSuccessCallback(callback, paramString);
  }
  
  private static void logError(Exception paramException, String paramString, Object... paramVarArgs)
  {
    Log.e("VideoUploader", String.format(Locale.ROOT, paramString, paramVarArgs), paramException);
  }
  
  private static void registerAccessTokenTracker()
  {
    accessTokenTracker = new AccessTokenTracker()
    {
      protected void onCurrentAccessTokenChanged(AccessToken paramAnonymousAccessToken1, AccessToken paramAnonymousAccessToken2)
      {
        if (paramAnonymousAccessToken1 == null) {}
        while ((paramAnonymousAccessToken2 != null) && (Utility.areObjectsEqual(paramAnonymousAccessToken2.getUserId(), paramAnonymousAccessToken1.getUserId()))) {
          return;
        }
        VideoUploader.access$200();
      }
    };
  }
  
  private static void removePendingUpload(UploadContext paramUploadContext)
  {
    try
    {
      pendingUploads.remove(paramUploadContext);
      return;
    }
    finally
    {
      paramUploadContext = finally;
      throw paramUploadContext;
    }
  }
  
  public static void uploadAsync(ShareVideoContent paramShareVideoContent, FacebookCallback<Sharer.Result> paramFacebookCallback)
    throws FileNotFoundException
  {
    try
    {
      uploadAsync(paramShareVideoContent, "me", paramFacebookCallback);
      return;
    }
    finally
    {
      paramShareVideoContent = finally;
      throw paramShareVideoContent;
    }
  }
  
  public static void uploadAsync(ShareVideoContent paramShareVideoContent, String paramString, FacebookCallback<Sharer.Result> paramFacebookCallback)
    throws FileNotFoundException
  {
    try
    {
      if (!initialized)
      {
        registerAccessTokenTracker();
        initialized = true;
      }
      Validate.notNull(paramShareVideoContent, "videoContent");
      Validate.notNull(paramString, "graphNode");
      ShareVideo localShareVideo = paramShareVideoContent.getVideo();
      Validate.notNull(localShareVideo, "videoContent.video");
      Validate.notNull(localShareVideo.getLocalUrl(), "videoContent.video.localUrl");
      paramShareVideoContent = new UploadContext(paramShareVideoContent, paramString, paramFacebookCallback, null);
      paramShareVideoContent.initialize();
      pendingUploads.add(paramShareVideoContent);
      enqueueUploadStart(paramShareVideoContent, 0);
      return;
    }
    finally {}
  }
  
  private static class FinishUploadWorkItem
    extends VideoUploader.UploadWorkItemBase
  {
    static final Set<Integer> transientErrorCodes = new HashSet() {};
    
    public FinishUploadWorkItem(VideoUploader.UploadContext paramUploadContext, int paramInt)
    {
      super(paramInt);
    }
    
    protected void enqueueRetry(int paramInt)
    {
      VideoUploader.enqueueUploadFinish(uploadContext, paramInt);
    }
    
    public Bundle getParameters()
    {
      Bundle localBundle = new Bundle();
      if (uploadContext.params != null) {
        localBundle.putAll(uploadContext.params);
      }
      localBundle.putString("upload_phase", "finish");
      localBundle.putString("upload_session_id", uploadContext.sessionId);
      Utility.putNonEmptyString(localBundle, "title", uploadContext.title);
      Utility.putNonEmptyString(localBundle, "description", uploadContext.description);
      Utility.putNonEmptyString(localBundle, "ref", uploadContext.ref);
      return localBundle;
    }
    
    protected Set<Integer> getTransientErrorCodes()
    {
      return transientErrorCodes;
    }
    
    protected void handleError(FacebookException paramFacebookException)
    {
      VideoUploader.logError(paramFacebookException, "Video '%s' failed to finish uploading", new Object[] { uploadContext.videoId });
      endUploadWithFailure(paramFacebookException);
    }
    
    protected void handleSuccess(JSONObject paramJSONObject)
      throws JSONException
    {
      if (paramJSONObject.getBoolean("success"))
      {
        issueResponseOnMainThread(null, uploadContext.videoId);
        return;
      }
      handleError(new FacebookException("Unexpected error in server response"));
    }
  }
  
  private static class StartUploadWorkItem
    extends VideoUploader.UploadWorkItemBase
  {
    static final Set<Integer> transientErrorCodes = new HashSet() {};
    
    public StartUploadWorkItem(VideoUploader.UploadContext paramUploadContext, int paramInt)
    {
      super(paramInt);
    }
    
    protected void enqueueRetry(int paramInt)
    {
      VideoUploader.enqueueUploadStart(uploadContext, paramInt);
    }
    
    public Bundle getParameters()
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("upload_phase", "start");
      localBundle.putLong("file_size", uploadContext.videoSize);
      return localBundle;
    }
    
    protected Set<Integer> getTransientErrorCodes()
    {
      return transientErrorCodes;
    }
    
    protected void handleError(FacebookException paramFacebookException)
    {
      VideoUploader.logError(paramFacebookException, "Error starting video upload", new Object[0]);
      endUploadWithFailure(paramFacebookException);
    }
    
    protected void handleSuccess(JSONObject paramJSONObject)
      throws JSONException
    {
      uploadContext.sessionId = paramJSONObject.getString("upload_session_id");
      uploadContext.videoId = paramJSONObject.getString("video_id");
      String str = paramJSONObject.getString("start_offset");
      paramJSONObject = paramJSONObject.getString("end_offset");
      VideoUploader.enqueueUploadChunk(uploadContext, str, paramJSONObject, 0);
    }
  }
  
  private static class TransferChunkWorkItem
    extends VideoUploader.UploadWorkItemBase
  {
    static final Set<Integer> transientErrorCodes = new HashSet() {};
    private String chunkEnd;
    private String chunkStart;
    
    public TransferChunkWorkItem(VideoUploader.UploadContext paramUploadContext, String paramString1, String paramString2, int paramInt)
    {
      super(paramInt);
      chunkStart = paramString1;
      chunkEnd = paramString2;
    }
    
    protected void enqueueRetry(int paramInt)
    {
      VideoUploader.enqueueUploadChunk(uploadContext, chunkStart, chunkEnd, paramInt);
    }
    
    public Bundle getParameters()
      throws IOException
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("upload_phase", "transfer");
      localBundle.putString("upload_session_id", uploadContext.sessionId);
      localBundle.putString("start_offset", chunkStart);
      byte[] arrayOfByte = VideoUploader.getChunk(uploadContext, chunkStart, chunkEnd);
      if (arrayOfByte != null)
      {
        localBundle.putByteArray("video_file_chunk", arrayOfByte);
        return localBundle;
      }
      throw new FacebookException("Error reading video");
    }
    
    protected Set<Integer> getTransientErrorCodes()
    {
      return transientErrorCodes;
    }
    
    protected void handleError(FacebookException paramFacebookException)
    {
      VideoUploader.logError(paramFacebookException, "Error uploading video '%s'", new Object[] { uploadContext.videoId });
      endUploadWithFailure(paramFacebookException);
    }
    
    protected void handleSuccess(JSONObject paramJSONObject)
      throws JSONException
    {
      String str = paramJSONObject.getString("start_offset");
      paramJSONObject = paramJSONObject.getString("end_offset");
      if (Utility.areObjectsEqual(str, paramJSONObject))
      {
        VideoUploader.enqueueUploadFinish(uploadContext, 0);
        return;
      }
      VideoUploader.enqueueUploadChunk(uploadContext, str, paramJSONObject, 0);
    }
  }
  
  private static class UploadContext
  {
    public final AccessToken accessToken = AccessToken.getCurrentAccessToken();
    public final FacebookCallback<Sharer.Result> callback;
    public String chunkStart = "0";
    public final String description;
    public final String graphNode;
    public boolean isCanceled;
    public Bundle params;
    public final String ref;
    public String sessionId;
    public final String title;
    public String videoId;
    public long videoSize;
    public InputStream videoStream;
    public final Uri videoUri;
    public WorkQueue.WorkItem workItem;
    
    private UploadContext(ShareVideoContent paramShareVideoContent, String paramString, FacebookCallback<Sharer.Result> paramFacebookCallback)
    {
      videoUri = paramShareVideoContent.getVideo().getLocalUrl();
      title = paramShareVideoContent.getContentTitle();
      description = paramShareVideoContent.getContentDescription();
      ref = paramShareVideoContent.getRef();
      graphNode = paramString;
      callback = paramFacebookCallback;
      params = paramShareVideoContent.getVideo().getParameters();
      if (!Utility.isNullOrEmpty(paramShareVideoContent.getPeopleIds())) {
        params.putString("tags", TextUtils.join(", ", paramShareVideoContent.getPeopleIds()));
      }
      if (!Utility.isNullOrEmpty(paramShareVideoContent.getPlaceId())) {
        params.putString("place", paramShareVideoContent.getPlaceId());
      }
      if (!Utility.isNullOrEmpty(paramShareVideoContent.getRef())) {
        params.putString("ref", paramShareVideoContent.getRef());
      }
    }
    
    private void initialize()
      throws FileNotFoundException
    {
      try
      {
        if (Utility.isFileUri(videoUri))
        {
          ParcelFileDescriptor localParcelFileDescriptor = ParcelFileDescriptor.open(new File(videoUri.getPath()), 268435456);
          videoSize = localParcelFileDescriptor.getStatSize();
          videoStream = new ParcelFileDescriptor.AutoCloseInputStream(localParcelFileDescriptor);
          return;
        }
        if (Utility.isContentUri(videoUri))
        {
          videoSize = Utility.getContentSize(videoUri);
          videoStream = FacebookSdk.getApplicationContext().getContentResolver().openInputStream(videoUri);
          return;
        }
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
        Utility.closeQuietly(videoStream);
        throw localFileNotFoundException;
      }
      throw new FacebookException("Uri must be a content:// or file:// uri");
    }
  }
  
  private static abstract class UploadWorkItemBase
    implements Runnable
  {
    protected int completedRetries;
    protected VideoUploader.UploadContext uploadContext;
    
    protected UploadWorkItemBase(VideoUploader.UploadContext paramUploadContext, int paramInt)
    {
      uploadContext = paramUploadContext;
      completedRetries = paramInt;
    }
    
    private boolean attemptRetry(int paramInt)
    {
      if ((completedRetries < 2) && (getTransientErrorCodes().contains(Integer.valueOf(paramInt))))
      {
        paramInt = (int)Math.pow(3.0D, completedRetries);
        VideoUploader.access$800().postDelayed(new Runnable()
        {
          public void run()
          {
            enqueueRetry(completedRetries + 1);
          }
        }, paramInt * 5000);
        return true;
      }
      return false;
    }
    
    protected void endUploadWithFailure(FacebookException paramFacebookException)
    {
      issueResponseOnMainThread(paramFacebookException, null);
    }
    
    protected abstract void enqueueRetry(int paramInt);
    
    protected void executeGraphRequestSynchronously(Bundle paramBundle)
    {
      paramBundle = new GraphRequest(uploadContext.accessToken, String.format(Locale.ROOT, "%s/videos", new Object[] { uploadContext.graphNode }), paramBundle, HttpMethod.POST, null).executeAndWait();
      if (paramBundle != null)
      {
        FacebookRequestError localFacebookRequestError = paramBundle.getError();
        JSONObject localJSONObject = paramBundle.getJSONObject();
        if (localFacebookRequestError != null)
        {
          if (!attemptRetry(localFacebookRequestError.getSubErrorCode())) {
            handleError(new FacebookGraphResponseException(paramBundle, "Video upload failed"));
          }
          return;
        }
        if (localJSONObject != null) {
          try
          {
            handleSuccess(localJSONObject);
            return;
          }
          catch (JSONException paramBundle)
          {
            endUploadWithFailure(new FacebookException("Unexpected error in server response", paramBundle));
            return;
          }
        }
        handleError(new FacebookException("Unexpected error in server response"));
        return;
      }
      handleError(new FacebookException("Unexpected error in server response"));
    }
    
    protected abstract Bundle getParameters()
      throws Exception;
    
    protected abstract Set<Integer> getTransientErrorCodes();
    
    protected abstract void handleError(FacebookException paramFacebookException);
    
    protected abstract void handleSuccess(JSONObject paramJSONObject)
      throws JSONException;
    
    protected void issueResponseOnMainThread(final FacebookException paramFacebookException, final String paramString)
    {
      VideoUploader.access$800().post(new Runnable()
      {
        public void run()
        {
          VideoUploader.issueResponse(uploadContext, paramFacebookException, paramString);
        }
      });
    }
    
    public void run()
    {
      if (!uploadContext.isCanceled) {
        try
        {
          executeGraphRequestSynchronously(getParameters());
          return;
        }
        catch (FacebookException localFacebookException)
        {
          endUploadWithFailure(localFacebookException);
          return;
        }
        catch (Exception localException)
        {
          endUploadWithFailure(new FacebookException("Video upload failed", localException));
          return;
        }
      }
      endUploadWithFailure(null);
    }
  }
}

/* Location:
 * Qualified Name:     com.facebook.share.internal.VideoUploader
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */