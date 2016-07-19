package com.squareup.picasso;

import android.graphics.Bitmap;
import java.io.InputStream;

public final class RequestHandler$Result
{
  private final Bitmap bitmap;
  private final int exifOrientation;
  private final Picasso.LoadedFrom loadedFrom;
  private final InputStream stream;
  
  public RequestHandler$Result(Bitmap paramBitmap, Picasso.LoadedFrom paramLoadedFrom)
  {
    this((Bitmap)Utils.checkNotNull(paramBitmap, "bitmap == null"), null, paramLoadedFrom, 0);
  }
  
  RequestHandler$Result(Bitmap paramBitmap, InputStream paramInputStream, Picasso.LoadedFrom paramLoadedFrom, int paramInt)
  {
    int i;
    if (paramBitmap != null)
    {
      i = 1;
      if (paramInputStream == null) {
        break label40;
      }
    }
    for (;;)
    {
      if ((j ^ i) != 0) {
        break label46;
      }
      throw new AssertionError();
      i = 0;
      break;
      label40:
      j = 0;
    }
    label46:
    bitmap = paramBitmap;
    stream = paramInputStream;
    loadedFrom = ((Picasso.LoadedFrom)Utils.checkNotNull(paramLoadedFrom, "loadedFrom == null"));
    exifOrientation = paramInt;
  }
  
  public RequestHandler$Result(InputStream paramInputStream, Picasso.LoadedFrom paramLoadedFrom)
  {
    this(null, (InputStream)Utils.checkNotNull(paramInputStream, "stream == null"), paramLoadedFrom, 0);
  }
  
  public Bitmap getBitmap()
  {
    return bitmap;
  }
  
  int getExifOrientation()
  {
    return exifOrientation;
  }
  
  public Picasso.LoadedFrom getLoadedFrom()
  {
    return loadedFrom;
  }
  
  public InputStream getStream()
  {
    return stream;
  }
}

/* Location:
 * Qualified Name:     com.squareup.picasso.RequestHandler.Result
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */