package bo.app;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Matrix;
import android.media.ExifInterface;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;

public final class jb
  implements je
{
  protected final boolean a;
  
  public jb(boolean paramBoolean)
  {
    a = paramBoolean;
  }
  
  private static jc a(String paramString)
  {
    int j = 0;
    boolean bool2 = true;
    boolean bool3 = true;
    boolean bool4 = true;
    boolean bool1 = true;
    try
    {
      int k = new ExifInterface(jl.c.c(paramString)).getAttributeInt("Orientation", 1);
      i = j;
      switch (k)
      {
      }
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        int i;
        jx.c("Can't read EXIF tags from file [%s]", new Object[] { paramString });
      }
    }
    bool1 = false;
    i = j;
    for (;;)
    {
      return new jc(i, bool1);
      bool2 = false;
      i = 90;
      bool1 = bool2;
      continue;
      bool3 = false;
      i = 180;
      bool1 = bool3;
      continue;
      bool4 = false;
      i = 270;
      bool1 = bool4;
    }
  }
  
  private static InputStream a(InputStream paramInputStream, jf paramjf)
  {
    try
    {
      paramInputStream.reset();
      return paramInputStream;
    }
    catch (IOException localIOException)
    {
      jv.a(paramInputStream);
    }
    return b(paramjf);
  }
  
  private static InputStream b(jf paramjf)
  {
    return f.a(b, g);
  }
  
  public final Bitmap a(jf paramjf)
  {
    Object localObject3 = b(paramjf);
    if (localObject3 == null)
    {
      jx.d("No stream for image [%s]", new Object[] { a });
      return null;
    }
    Object localObject1 = localObject3;
    Object localObject4;
    Object localObject2;
    for (;;)
    {
      try
      {
        localObject4 = new BitmapFactory.Options();
        localObject1 = localObject3;
        inJustDecodeBounds = true;
        localObject1 = localObject3;
        BitmapFactory.decodeStream((InputStream)localObject3, null, (BitmapFactory.Options)localObject4);
        localObject1 = localObject3;
        localObject2 = b;
        localObject1 = localObject3;
        if (h)
        {
          localObject1 = localObject3;
          if ("image/jpeg".equalsIgnoreCase(outMimeType))
          {
            localObject1 = localObject3;
            if (jl.a((String)localObject2) == jl.c)
            {
              i = 1;
              if (i == 0) {
                continue;
              }
              localObject1 = localObject3;
              localObject2 = a((String)localObject2);
              localObject1 = localObject3;
              localObject4 = new jd(new ip(outWidth, outHeight, a), (jc)localObject2);
              localObject1 = localObject3;
              localObject2 = a((InputStream)localObject3, paramjf);
              localObject1 = localObject2;
              localObject3 = a;
              localObject1 = localObject2;
              i = d;
              localObject1 = localObject2;
              if (i != io.a) {
                break label381;
              }
              i = 1;
              if (i > 1)
              {
                localObject1 = localObject2;
                if (a)
                {
                  localObject1 = localObject2;
                  jx.a("Subsample original image (%1$s) to %2$s (scale = %3$d) [%4$s]", new Object[] { localObject3, new ip(a / i, b / i), Integer.valueOf(i), a });
                }
              }
              localObject1 = localObject2;
              localObject3 = i;
              localObject1 = localObject2;
              inSampleSize = i;
              localObject1 = localObject2;
              localObject3 = BitmapFactory.decodeStream((InputStream)localObject2, null, (BitmapFactory.Options)localObject3);
              jv.a((Closeable)localObject2);
              if (localObject3 != null) {
                break label456;
              }
              jx.d("Image can't be decoded [%s]", new Object[] { a });
              return (Bitmap)localObject3;
            }
          }
          i = 0;
          continue;
        }
        localObject1 = localObject3;
        localObject2 = new jc();
        continue;
        localObject1 = localObject2;
      }
      finally
      {
        jv.a((Closeable)localObject1);
      }
      label381:
      if (i != io.b) {
        break;
      }
      localObject1 = localObject2;
      i = jt.a((ip)localObject3);
    }
    localObject1 = localObject2;
    ip localip = c;
    localObject1 = localObject2;
    if (i == io.c) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      localObject1 = localObject2;
      i = jt.a((ip)localObject3, localip, e, bool1);
      break;
    }
    label456:
    int i = b.a;
    boolean bool2 = b.b;
    localObject1 = new Matrix();
    int j = d;
    int k;
    if ((j == io.e) || (j == io.f))
    {
      localObject2 = new ip(((Bitmap)localObject3).getWidth(), ((Bitmap)localObject3).getHeight(), i);
      localObject4 = c;
      k = e;
      if (j != io.f) {
        break label752;
      }
    }
    label752:
    for (bool1 = true;; bool1 = false)
    {
      float f = jt.b((ip)localObject2, (ip)localObject4, k, bool1);
      if (Float.compare(f, 1.0F) != 0)
      {
        ((Matrix)localObject1).setScale(f, f);
        if (a) {
          jx.a("Scale subsampled image (%1$s) to %2$s (scale = %3$.5f) [%4$s]", new Object[] { localObject2, new ip((int)(a * f), (int)(b * f)), Float.valueOf(f), a });
        }
      }
      if (bool2)
      {
        ((Matrix)localObject1).postScale(-1.0F, 1.0F);
        if (a) {
          jx.a("Flip image horizontally [%s]", new Object[] { a });
        }
      }
      if (i != 0)
      {
        ((Matrix)localObject1).postRotate(i);
        if (a) {
          jx.a("Rotate image on %1$d° [%2$s]", new Object[] { Integer.valueOf(i), a });
        }
      }
      paramjf = Bitmap.createBitmap((Bitmap)localObject3, 0, 0, ((Bitmap)localObject3).getWidth(), ((Bitmap)localObject3).getHeight(), (Matrix)localObject1, true);
      if (paramjf != localObject3) {
        ((Bitmap)localObject3).recycle();
      }
      return paramjf;
    }
  }
}

/* Location:
 * Qualified Name:     bo.app.jb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */