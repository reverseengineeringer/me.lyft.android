package bo.app;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

public abstract class gx
  implements gw
{
  public static final Bitmap.CompressFormat a = Bitmap.CompressFormat.PNG;
  protected final File b;
  protected final File c;
  protected final hk d;
  protected int e = 32768;
  protected Bitmap.CompressFormat f = a;
  protected int g = 100;
  
  public gx(File paramFile1, File paramFile2, hk paramhk)
  {
    if (paramFile1 == null) {
      throw new IllegalArgumentException("cacheDir argument must be not null");
    }
    if (paramhk == null) {
      throw new IllegalArgumentException("fileNameGenerator argument must be not null");
    }
    b = paramFile1;
    c = paramFile2;
    d = paramhk;
  }
  
  private File b(String paramString)
  {
    String str = d.a(paramString);
    File localFile = b;
    paramString = localFile;
    if (!b.exists())
    {
      paramString = localFile;
      if (!b.mkdirs())
      {
        paramString = localFile;
        if (c != null) {
          if (!c.exists())
          {
            paramString = localFile;
            if (!c.mkdirs()) {}
          }
          else
          {
            paramString = c;
          }
        }
      }
    }
    return new File(paramString, str);
  }
  
  public final File a(String paramString)
  {
    return b(paramString);
  }
  
  public final boolean a(String paramString, Bitmap paramBitmap)
  {
    File localFile = b(paramString);
    paramString = new File(localFile.getAbsolutePath() + ".tmp");
    BufferedOutputStream localBufferedOutputStream = new BufferedOutputStream(new FileOutputStream(paramString), e);
    try
    {
      boolean bool1 = paramBitmap.compress(f, g, localBufferedOutputStream);
      jv.a(localBufferedOutputStream);
      boolean bool2 = bool1;
      if (bool1)
      {
        bool2 = bool1;
        if (!paramString.renameTo(localFile)) {
          bool2 = false;
        }
      }
      if (!bool2) {
        paramString.delete();
      }
      paramBitmap.recycle();
      return bool2;
    }
    finally
    {
      jv.a(localBufferedOutputStream);
      paramString.delete();
    }
  }
  
  public final boolean a(String paramString, InputStream paramInputStream, jw paramjw)
  {
    File localFile1 = b(paramString);
    File localFile2 = new File(localFile1.getAbsolutePath() + ".tmp");
    boolean bool1;
    boolean bool2;
    try
    {
      paramString = new BufferedOutputStream(new FileOutputStream(localFile2), e);
      try
      {
        bool1 = jv.a(paramInputStream, paramString, paramjw, e);
        paramString = finally;
      }
      finally
      {
        try
        {
          jv.a(paramString);
          bool2 = bool1;
          if (bool1)
          {
            bool2 = bool1;
            if (!localFile2.renameTo(localFile1)) {
              bool2 = false;
            }
          }
          if (!bool2) {
            localFile2.delete();
          }
          return bool2;
        }
        finally {}
        paramInputStream = finally;
        jv.a(paramString);
      }
      bool2 = bool1;
    }
    finally
    {
      bool1 = false;
    }
    if (bool1)
    {
      bool2 = bool1;
      if (!localFile2.renameTo(localFile1)) {
        bool2 = false;
      }
    }
    if (!bool2) {
      localFile2.delete();
    }
    throw paramString;
  }
}

/* Location:
 * Qualified Name:     bo.app.gx
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */