package com.facebook.internal;

import android.net.Uri;

class ImageDownloader$RequestKey
{
  private static final int HASH_MULTIPLIER = 37;
  private static final int HASH_SEED = 29;
  Object tag;
  Uri uri;
  
  ImageDownloader$RequestKey(Uri paramUri, Object paramObject)
  {
    uri = paramUri;
    tag = paramObject;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramObject != null)
    {
      bool1 = bool2;
      if ((paramObject instanceof RequestKey))
      {
        paramObject = (RequestKey)paramObject;
        if ((uri != uri) || (tag != tag)) {
          break label48;
        }
        bool1 = true;
      }
    }
    return bool1;
    label48:
    return false;
  }
  
  public int hashCode()
  {
    return (uri.hashCode() + 1073) * 37 + tag.hashCode();
  }
}

/* Location:
 * Qualified Name:     com.facebook.internal.ImageDownloader.RequestKey
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */