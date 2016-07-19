package com.facebook.share.internal;

import android.os.Bundle;
import com.facebook.FacebookException;
import com.facebook.internal.Utility;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

class VideoUploader$FinishUploadWorkItem
  extends VideoUploader.UploadWorkItemBase
{
  static final Set<Integer> transientErrorCodes = new HashSet() {};
  
  public VideoUploader$FinishUploadWorkItem(VideoUploader.UploadContext paramUploadContext, int paramInt)
  {
    super(paramUploadContext, paramInt);
  }
  
  protected void enqueueRetry(int paramInt)
  {
    VideoUploader.access$700(uploadContext, paramInt);
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
    VideoUploader.access$400(paramFacebookException, "Video '%s' failed to finish uploading", new Object[] { uploadContext.videoId });
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

/* Location:
 * Qualified Name:     com.facebook.share.internal.VideoUploader.FinishUploadWorkItem
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */