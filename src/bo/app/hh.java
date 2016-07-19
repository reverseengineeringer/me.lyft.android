package bo.app;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

final class hh
  implements Closeable
{
  final Charset a;
  private final InputStream b;
  private byte[] c;
  private int d;
  private int e;
  
  public hh(InputStream paramInputStream, Charset paramCharset)
  {
    this(paramInputStream, paramCharset, (byte)0);
  }
  
  private hh(InputStream paramInputStream, Charset paramCharset, byte paramByte)
  {
    if ((paramInputStream == null) || (paramCharset == null)) {
      throw new NullPointerException();
    }
    if (!paramCharset.equals(hj.a)) {
      throw new IllegalArgumentException("Unsupported encoding");
    }
    b = paramInputStream;
    a = paramCharset;
    c = new byte[' '];
  }
  
  private void b()
  {
    int i = b.read(c, 0, c.length);
    if (i == -1) {
      throw new EOFException();
    }
    d = 0;
    e = i;
  }
  
  public final String a()
  {
    synchronized (b)
    {
      if (c == null) {
        throw new IOException("LineReader is closed");
      }
    }
    if (d >= e) {
      b();
    }
    int i = d;
    for (;;)
    {
      if (i != e)
      {
        if (c[i] != 10) {
          break label272;
        }
        if ((i == d) || (c[(i - 1)] != 13)) {
          break label267;
        }
      }
      label267:
      for (int j = i - 1;; j = i)
      {
        Object localObject2 = new String(c, d, j - d, a.name());
        d = (i + 1);
        return (String)localObject2;
        localObject2 = new hi(this, e - d + 80);
        for (;;)
        {
          ((ByteArrayOutputStream)localObject2).write(c, d, e - d);
          e = -1;
          b();
          i = d;
          while (i != e)
          {
            if (c[i] == 10)
            {
              if (i != d) {
                ((ByteArrayOutputStream)localObject2).write(c, d, i - d);
              }
              d = (i + 1);
              localObject2 = ((ByteArrayOutputStream)localObject2).toString();
              return (String)localObject2;
            }
            i += 1;
          }
        }
      }
      label272:
      i += 1;
    }
  }
  
  public final void close()
  {
    synchronized (b)
    {
      if (c != null)
      {
        c = null;
        b.close();
      }
      return;
    }
  }
}

/* Location:
 * Qualified Name:     bo.app.hh
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */