package bo.app;

import java.io.Closeable;
import java.io.File;
import java.io.InputStream;

public final class hf
  implements Closeable
{
  File[] a;
  private final String c;
  private final long d;
  private final InputStream[] e;
  private final long[] f;
  
  private hf(gz paramgz, String paramString, long paramLong, File[] paramArrayOfFile, InputStream[] paramArrayOfInputStream, long[] paramArrayOfLong)
  {
    c = paramString;
    d = paramLong;
    a = paramArrayOfFile;
    e = paramArrayOfInputStream;
    f = paramArrayOfLong;
  }
  
  public final void close()
  {
    InputStream[] arrayOfInputStream = e;
    int j = arrayOfInputStream.length;
    int i = 0;
    while (i < j)
    {
      hj.a(arrayOfInputStream[i]);
      i += 1;
    }
  }
}

/* Location:
 * Qualified Name:     bo.app.hf
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */