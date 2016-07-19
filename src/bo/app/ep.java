package bo.app;

import java.util.Collection;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public final class ep
  implements ez
{
  final ez a;
  private final bt b;
  
  public ep(ez paramez, bt parambt)
  {
    a = paramez;
    b = parambt;
  }
  
  public final cx a()
  {
    try
    {
      cx localcx = (cx)b.submit(new er(this)).get(5000L, TimeUnit.MILLISECONDS);
      return localcx;
    }
    catch (Exception localException)
    {
      throw new RuntimeException("Error while trying to asynchronously get stored open sessions.", localException);
    }
    finally {}
  }
  
  public final void a(cx paramcx)
  {
    try
    {
      b.execute(new eq(this, paramcx));
      return;
    }
    finally
    {
      paramcx = finally;
      throw paramcx;
    }
  }
  
  public final void a(cx paramcx, cs paramcs)
  {
    b.execute(new eu(this, paramcx, paramcs));
  }
  
  public final Collection<cx> b()
  {
    try
    {
      Collection localCollection = (Collection)b.submit(new et(this)).get(5000L, TimeUnit.MILLISECONDS);
      return localCollection;
    }
    catch (Exception localException)
    {
      throw new RuntimeException("Error while trying to asynchronously get sealed sessions.", localException);
    }
    finally {}
  }
  
  public final void b(cx paramcx)
  {
    try
    {
      c(paramcx);
      return;
    }
    finally
    {
      paramcx = finally;
      throw paramcx;
    }
  }
  
  public final Future<?> c(cx paramcx)
  {
    try
    {
      paramcx = b.submit(new es(this, paramcx));
      return paramcx;
    }
    finally
    {
      paramcx = finally;
      throw paramcx;
    }
  }
}

/* Location:
 * Qualified Name:     bo.app.ep
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */