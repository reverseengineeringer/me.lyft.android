package com.squareup.picasso;

import java.io.IOException;

public class Downloader$ResponseException
  extends IOException
{
  final boolean localCacheOnly;
  final int responseCode;
  
  public Downloader$ResponseException(String paramString, int paramInt1, int paramInt2)
  {
    super(paramString);
    localCacheOnly = NetworkPolicy.isOfflineOnly(paramInt1);
    responseCode = paramInt2;
  }
}

/* Location:
 * Qualified Name:     com.squareup.picasso.Downloader.ResponseException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */