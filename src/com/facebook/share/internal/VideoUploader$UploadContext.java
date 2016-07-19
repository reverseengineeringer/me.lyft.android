package com.facebook.share.internal;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.os.ParcelFileDescriptor.AutoCloseInputStream;
import android.text.TextUtils;
import com.facebook.AccessToken;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.internal.Utility;
import com.facebook.internal.WorkQueue.WorkItem;
import com.facebook.share.Sharer.Result;
import com.facebook.share.model.ShareVideo;
import com.facebook.share.model.ShareVideoContent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;

class VideoUploader$UploadContext
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
  
  private VideoUploader$UploadContext(ShareVideoContent paramShareVideoContent, String paramString, FacebookCallback<Sharer.Result> paramFacebookCallback)
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

/* Location:
 * Qualified Name:     com.facebook.share.internal.VideoUploader.UploadContext
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */