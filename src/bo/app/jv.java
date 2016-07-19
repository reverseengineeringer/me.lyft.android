package bo.app;

import java.io.Closeable;
import java.io.InputStream;
import java.io.OutputStream;

public final class jv
{
  public static void a(Closeable paramCloseable)
  {
    if (paramCloseable != null) {}
    try
    {
      paramCloseable.close();
      return;
    }
    catch (Exception paramCloseable) {}
  }
  
  private static boolean a(jw paramjw, int paramInt1, int paramInt2)
  {
    return (paramjw != null) && (!paramjw.a(paramInt1, paramInt2)) && (paramInt1 * 100 / paramInt2 < 75);
  }
  
  public static boolean a(InputStream paramInputStream, OutputStream paramOutputStream, jw paramjw, int paramInt)
  {
    int j = paramInputStream.available();
    int i = j;
    if (j <= 0) {
      i = 512000;
    }
    byte[] arrayOfByte = new byte[paramInt];
    if (a(paramjw, 0, i)) {
      return false;
    }
    j = 0;
    int k;
    do
    {
      k = paramInputStream.read(arrayOfByte, 0, paramInt);
      if (k == -1) {
        break;
      }
      paramOutputStream.write(arrayOfByte, 0, k);
      k = j + k;
      j = k;
    } while (!a(paramjw, k, i));
    return false;
    paramOutputStream.flush();
    return true;
  }
}

/* Location:
 * Qualified Name:     bo.app.jv
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */