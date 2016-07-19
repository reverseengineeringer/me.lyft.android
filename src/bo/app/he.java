package bo.app;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

final class he
{
  final String a;
  final long[] b;
  boolean c;
  hc d;
  long e;
  
  private he(gz paramgz, String paramString)
  {
    a = paramString;
    b = new long[gz.g(paramgz)];
  }
  
  private static IOException b(String[] paramArrayOfString)
  {
    throw new IOException("unexpected journal line: " + Arrays.toString(paramArrayOfString));
  }
  
  public final File a(int paramInt)
  {
    return new File(gz.h(f), a + "." + paramInt);
  }
  
  public final String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    long[] arrayOfLong = b;
    int j = arrayOfLong.length;
    int i = 0;
    while (i < j)
    {
      long l = arrayOfLong[i];
      localStringBuilder.append(' ').append(l);
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  final void a(String[] paramArrayOfString)
  {
    if (paramArrayOfString.length != gz.g(f)) {
      throw b(paramArrayOfString);
    }
    int i = 0;
    try
    {
      while (i < paramArrayOfString.length)
      {
        b[i] = Long.parseLong(paramArrayOfString[i]);
        i += 1;
      }
      return;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      throw b(paramArrayOfString);
    }
  }
  
  public final File b(int paramInt)
  {
    return new File(gz.h(f), a + "." + paramInt + ".tmp");
  }
}

/* Location:
 * Qualified Name:     bo.app.he
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */