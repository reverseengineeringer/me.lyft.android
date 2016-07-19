package bo.app;

public final class ip
{
  public final int a;
  public final int b;
  
  public ip(int paramInt1, int paramInt2)
  {
    a = paramInt1;
    b = paramInt2;
  }
  
  public ip(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt3 % 180 == 0)
    {
      a = paramInt1;
      b = paramInt2;
      return;
    }
    a = paramInt2;
    b = paramInt1;
  }
  
  public final String toString()
  {
    return 9 + a + "x" + b;
  }
}

/* Location:
 * Qualified Name:     bo.app.ip
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */