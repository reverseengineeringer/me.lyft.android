package bo.app;

import java.io.InputStream;

public final class ik
  extends InputStream
{
  private final InputStream a;
  private final int b;
  
  public ik(InputStream paramInputStream, int paramInt)
  {
    a = paramInputStream;
    b = paramInt;
  }
  
  public final int available()
  {
    return b;
  }
  
  public final void close()
  {
    a.close();
  }
  
  public final void mark(int paramInt)
  {
    a.mark(paramInt);
  }
  
  public final boolean markSupported()
  {
    return a.markSupported();
  }
  
  public final int read()
  {
    return a.read();
  }
  
  public final int read(byte[] paramArrayOfByte)
  {
    return a.read(paramArrayOfByte);
  }
  
  public final int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return a.read(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public final void reset()
  {
    a.reset();
  }
  
  public final long skip(long paramLong)
  {
    return a.skip(paramLong);
  }
}

/* Location:
 * Qualified Name:     bo.app.ik
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */