package bo.app;

import java.io.FilterInputStream;
import java.io.InputStream;

public final class in
  extends FilterInputStream
{
  public in(InputStream paramInputStream)
  {
    super(paramInputStream);
  }
  
  public final long skip(long paramLong)
  {
    long l2;
    for (long l1 = 0L; l1 < paramLong; l1 = l2 + l1)
    {
      long l3 = in.skip(paramLong - l1);
      l2 = l3;
      if (l3 == 0L)
      {
        if (read() < 0) {
          break;
        }
        l2 = 1L;
      }
    }
    return l1;
  }
}

/* Location:
 * Qualified Name:     bo.app.in
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */