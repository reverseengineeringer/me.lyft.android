package com.facebook.share.internal;

import android.os.Bundle;
import android.os.Handler;
import com.facebook.FacebookException;
import com.facebook.FacebookGraphResponseException;
import com.facebook.FacebookRequestError;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import java.util.Locale;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

abstract class VideoUploader$UploadWorkItemBase
  implements Runnable
{
  protected int completedRetries;
  protected VideoUploader.UploadContext uploadContext;
  
  protected VideoUploader$UploadWorkItemBase(VideoUploader.UploadContext paramUploadContext, int paramInt)
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
        VideoUploader.access$900(uploadContext, paramFacebookException, paramString);
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

/* Location:
 * Qualified Name:     com.facebook.share.internal.VideoUploader.UploadWorkItemBase
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */