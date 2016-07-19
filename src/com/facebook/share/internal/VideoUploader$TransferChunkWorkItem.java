package com.facebook.share.internal;

import android.os.Bundle;
import com.facebook.FacebookException;
import com.facebook.internal.Utility;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

class VideoUploader$TransferChunkWorkItem
  extends VideoUploader.UploadWorkItemBase
{
  static final Set<Integer> transientErrorCodes = new HashSet() {};
  private String chunkEnd;
  private String chunkStart;
  
  public VideoUploader$TransferChunkWorkItem(VideoUploader.UploadContext paramUploadContext, String paramString1, String paramString2, int paramInt)
  {
    super(paramUploadContext, paramInt);
    chunkStart = paramString1;
    chunkEnd = paramString2;
  }
  
  protected void enqueueRetry(int paramInt)
  {
    VideoUploader.access$300(uploadContext, chunkStart, chunkEnd, paramInt);
  }
  
  public Bundle getParameters()
    throws IOException
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("upload_phase", "transfer");
    localBundle.putString("upload_session_id", uploadContext.sessionId);
    localBundle.putString("start_offset", chunkStart);
    byte[] arrayOfByte = VideoUploader.access$600(uploadContext, chunkStart, chunkEnd);
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
    VideoUploader.access$400(paramFacebookException, "Error uploading video '%s'", new Object[] { uploadContext.videoId });
    endUploadWithFailure(paramFacebookException);
  }
  
  protected void handleSuccess(JSONObject paramJSONObject)
    throws JSONException
  {
    String str = paramJSONObject.getString("start_offset");
    paramJSONObject = paramJSONObject.getString("end_offset");
    if (Utility.areObjectsEqual(str, paramJSONObject))
    {
      VideoUploader.access$700(uploadContext, 0);
      return;
    }
    VideoUploader.access$300(uploadContext, str, paramJSONObject, 0);
  }
}

/* Location:
 * Qualified Name:     com.facebook.share.internal.VideoUploader.TransferChunkWorkItem
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */