package com.facebook.messenger;

import android.net.Uri;

public class ShareToMessengerParamsBuilder
{
  private Uri mExternalUri;
  private String mMetaData;
  private final String mMimeType;
  private final Uri mUri;
  
  ShareToMessengerParamsBuilder(Uri paramUri, String paramString)
  {
    mUri = paramUri;
    mMimeType = paramString;
  }
  
  public ShareToMessengerParams build()
  {
    return new ShareToMessengerParams(this);
  }
  
  public Uri getExternalUri()
  {
    return mExternalUri;
  }
  
  public String getMetaData()
  {
    return mMetaData;
  }
  
  public String getMimeType()
  {
    return mMimeType;
  }
  
  public Uri getUri()
  {
    return mUri;
  }
  
  public ShareToMessengerParamsBuilder setExternalUri(Uri paramUri)
  {
    mExternalUri = paramUri;
    return this;
  }
  
  public ShareToMessengerParamsBuilder setMetaData(String paramString)
  {
    mMetaData = paramString;
    return this;
  }
}

/* Location:
 * Qualified Name:     com.facebook.messenger.ShareToMessengerParamsBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */