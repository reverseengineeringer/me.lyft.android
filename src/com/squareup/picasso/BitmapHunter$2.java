package com.squareup.picasso;

import java.io.IOException;

final class BitmapHunter$2
  extends RequestHandler
{
  public boolean canHandleRequest(Request paramRequest)
  {
    return true;
  }
  
  public RequestHandler.Result load(Request paramRequest, int paramInt)
    throws IOException
  {
    throw new IllegalStateException("Unrecognized type of request: " + paramRequest);
  }
}

/* Location:
 * Qualified Name:     com.squareup.picasso.BitmapHunter.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */