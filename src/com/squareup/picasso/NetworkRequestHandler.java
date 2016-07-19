package com.squareup.picasso;

import android.graphics.Bitmap;
import android.net.NetworkInfo;
import android.net.Uri;
import java.io.IOException;
import java.io.InputStream;

class NetworkRequestHandler
  extends RequestHandler
{
  static final int RETRY_COUNT = 2;
  private static final String SCHEME_HTTP = "http";
  private static final String SCHEME_HTTPS = "https";
  private final Downloader downloader;
  private final Stats stats;
  
  public NetworkRequestHandler(Downloader paramDownloader, Stats paramStats)
  {
    downloader = paramDownloader;
    stats = paramStats;
  }
  
  public boolean canHandleRequest(Request paramRequest)
  {
    paramRequest = uri.getScheme();
    return ("http".equals(paramRequest)) || ("https".equals(paramRequest));
  }
  
  int getRetryCount()
  {
    return 2;
  }
  
  public RequestHandler.Result load(Request paramRequest, int paramInt)
    throws IOException
  {
    Downloader.Response localResponse = downloader.load(uri, networkPolicy);
    if (localResponse == null) {}
    Object localObject;
    do
    {
      return null;
      if (cached) {}
      for (paramRequest = Picasso.LoadedFrom.DISK;; paramRequest = Picasso.LoadedFrom.NETWORK)
      {
        localObject = localResponse.getBitmap();
        if (localObject == null) {
          break;
        }
        return new RequestHandler.Result((Bitmap)localObject, paramRequest);
      }
      localObject = localResponse.getInputStream();
    } while (localObject == null);
    if ((paramRequest == Picasso.LoadedFrom.DISK) && (localResponse.getContentLength() == 0L))
    {
      Utils.closeQuietly((InputStream)localObject);
      throw new ContentLengthException("Received response with 0 content-length header.");
    }
    if ((paramRequest == Picasso.LoadedFrom.NETWORK) && (localResponse.getContentLength() > 0L)) {
      stats.dispatchDownloadFinished(localResponse.getContentLength());
    }
    return new RequestHandler.Result((InputStream)localObject, paramRequest);
  }
  
  boolean shouldRetry(boolean paramBoolean, NetworkInfo paramNetworkInfo)
  {
    return (paramNetworkInfo == null) || (paramNetworkInfo.isConnected());
  }
  
  boolean supportsReplay()
  {
    return true;
  }
  
  static class ContentLengthException
    extends IOException
  {
    public ContentLengthException(String paramString)
    {
      super();
    }
  }
}

/* Location:
 * Qualified Name:     com.squareup.picasso.NetworkRequestHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */