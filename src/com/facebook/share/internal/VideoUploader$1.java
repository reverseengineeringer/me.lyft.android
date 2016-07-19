package com.facebook.share.internal;

import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;
import com.facebook.internal.Utility;

final class VideoUploader$1
  extends AccessTokenTracker
{
  protected void onCurrentAccessTokenChanged(AccessToken paramAccessToken1, AccessToken paramAccessToken2)
  {
    if (paramAccessToken1 == null) {}
    while ((paramAccessToken2 != null) && (Utility.areObjectsEqual(paramAccessToken2.getUserId(), paramAccessToken1.getUserId()))) {
      return;
    }
    VideoUploader.access$200();
  }
}

/* Location:
 * Qualified Name:     com.facebook.share.internal.VideoUploader.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */