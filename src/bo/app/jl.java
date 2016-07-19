package bo.app;

import java.util.Locale;

public enum jl
{
  private String h;
  private String i;
  
  private jl(String paramString)
  {
    h = paramString;
    i = (paramString + "://");
  }
  
  public static jl a(String paramString)
  {
    if (paramString != null)
    {
      jl[] arrayOfjl = values();
      int m = arrayOfjl.length;
      int k = 0;
      while (k < m)
      {
        jl localjl = arrayOfjl[k];
        if (localjl.d(paramString)) {
          return localjl;
        }
        k += 1;
      }
    }
    return g;
  }
  
  private boolean d(String paramString)
  {
    return paramString.toLowerCase(Locale.US).startsWith(i);
  }
  
  public final String b(String paramString)
  {
    return i + paramString;
  }
  
  public final String c(String paramString)
  {
    if (!d(paramString)) {
      throw new IllegalArgumentException(String.format("URI [%1$s] doesn't have expected scheme [%2$s]", new Object[] { paramString, h }));
    }
    return paramString.substring(i.length());
  }
}

/* Location:
 * Qualified Name:     bo.app.jl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */