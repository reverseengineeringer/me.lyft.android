package bo.app;

import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

final class hi
  extends ByteArrayOutputStream
{
  hi(hh paramhh, int paramInt)
  {
    super(paramInt);
  }
  
  public final String toString()
  {
    if ((count > 0) && (buf[(count - 1)] == 13)) {}
    for (int i = count - 1;; i = count) {
      try
      {
        String str = new String(buf, 0, i, a.a.name());
        return str;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        throw new AssertionError(localUnsupportedEncodingException);
      }
    }
  }
}

/* Location:
 * Qualified Name:     bo.app.hi
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */