package bo.app;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

public final class hc
{
  final he a;
  final boolean[] b;
  boolean c;
  private boolean e;
  
  private hc(gz paramgz, he paramhe)
  {
    a = paramhe;
    if (c) {}
    for (paramgz = null;; paramgz = new boolean[gz.g(paramgz)])
    {
      b = paramgz;
      return;
    }
  }
  
  public final OutputStream a()
  {
    synchronized (d)
    {
      if (a.d != this) {
        throw new IllegalStateException();
      }
    }
    if (!a.c) {
      b[0] = true;
    }
    File localFile = a.b(0);
    try
    {
      Object localObject2 = new FileOutputStream(localFile);
      localObject2 = new hd(this, (OutputStream)localObject2, (byte)0);
      return (OutputStream)localObject2;
    }
    catch (FileNotFoundException localFileNotFoundException1)
    {
      for (;;)
      {
        gz.h(d).mkdirs();
        try
        {
          FileOutputStream localFileOutputStream = new FileOutputStream(localFile);
        }
        catch (FileNotFoundException localFileNotFoundException2)
        {
          OutputStream localOutputStream = gz.a();
          return localOutputStream;
        }
      }
    }
  }
  
  public final void b()
  {
    if (c)
    {
      gz.a(d, this, false);
      d.c(a.a);
    }
    for (;;)
    {
      e = true;
      return;
      gz.a(d, this, true);
    }
  }
  
  public final void c()
  {
    gz.a(d, this, false);
  }
}

/* Location:
 * Qualified Name:     bo.app.hc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */