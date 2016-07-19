package com.squareup.picasso;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

class ContentStreamRequestHandler
  extends RequestHandler
{
  final Context context;
  
  ContentStreamRequestHandler(Context paramContext)
  {
    context = paramContext;
  }
  
  public boolean canHandleRequest(Request paramRequest)
  {
    return "content".equals(uri.getScheme());
  }
  
  InputStream getInputStream(Request paramRequest)
    throws FileNotFoundException
  {
    return context.getContentResolver().openInputStream(uri);
  }
  
  public RequestHandler.Result load(Request paramRequest, int paramInt)
    throws IOException
  {
    return new RequestHandler.Result(getInputStream(paramRequest), Picasso.LoadedFrom.DISK);
  }
}

/* Location:
 * Qualified Name:     com.squareup.picasso.ContentStreamRequestHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */