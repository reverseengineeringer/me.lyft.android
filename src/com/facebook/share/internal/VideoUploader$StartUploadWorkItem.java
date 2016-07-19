package com.facebook.share.internal;

import android.os.Bundle;
import com.facebook.FacebookException;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

class VideoUploader$StartUploadWorkItem
  extends VideoUploader.UploadWorkItemBase
{
  static final Set<Integer> transientErrorCodes = new HashSet() {};
  
  public VideoUploader$StartUploadWorkItem(VideoUploader.UploadContext paramUploadContext, int paramInt)
  {
    super(paramUploadContext, paramInt);
  }
  
  protected void enqueueRetry(int paramInt)
  {
    VideoUploader.access$500(uploadContext, paramInt);
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
    VideoUploader.access$400(paramFacebookException, "Error starting video upload", new Object[0]);
    endUploadWithFailure(paramFacebookException);
  }
  
  protected void handleSuccess(JSONObject paramJSONObject)
    throws JSONException
  {
    uploadContext.sessionId = paramJSONObject.getString("upload_session_id");
    uploadContext.videoId = paramJSONObject.getString("video_id");
    String str = paramJSONObject.getString("start_offset");
    paramJSONObject = paramJSONObject.getString("end_offset");
    VideoUploader.access$300(uploadContext, str, paramJSONObject, 0);
  }
}

/* Location:
 * Qualified Name:     com.facebook.share.internal.VideoUploader.StartUploadWorkItem
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */