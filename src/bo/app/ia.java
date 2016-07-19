package bo.app;

import java.io.InputStream;

final class ia
  implements jk
{
  private final jk a;
  
  public ia(jk paramjk)
  {
    a = paramjk;
  }
  
  public final InputStream a(String paramString, Object paramObject)
  {
    paramObject = a.a(paramString, paramObject);
    switch (hx.a[jl.a(paramString).ordinal()])
    {
    default: 
      return (InputStream)paramObject;
    }
    return new in((InputStream)paramObject);
  }
}

/* Location:
 * Qualified Name:     bo.app.ia
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */