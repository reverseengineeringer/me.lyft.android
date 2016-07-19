package bo.app;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

final class hd
  extends FilterOutputStream
{
  private hd(hc paramhc, OutputStream paramOutputStream)
  {
    super(paramOutputStream);
  }
  
  public final void close()
  {
    try
    {
      out.close();
      return;
    }
    catch (IOException localIOException)
    {
      a.c = true;
    }
  }
  
  public final void flush()
  {
    try
    {
      out.flush();
      return;
    }
    catch (IOException localIOException)
    {
      a.c = true;
    }
  }
  
  public final void write(int paramInt)
  {
    try
    {
      out.write(paramInt);
      return;
    }
    catch (IOException localIOException)
    {
      a.c = true;
    }
  }
  
  public final void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    try
    {
      out.write(paramArrayOfByte, paramInt1, paramInt2);
      return;
    }
    catch (IOException paramArrayOfByte)
    {
      a.c = true;
    }
  }
}

/* Location:
 * Qualified Name:     bo.app.hd
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */