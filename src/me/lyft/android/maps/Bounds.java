package me.lyft.android.maps;

public class Bounds
{
  public final int bottom;
  public final int left;
  public final int right;
  public final int top;
  
  public Bounds(int paramInt)
  {
    left = paramInt;
    top = paramInt;
    right = paramInt;
    bottom = paramInt;
  }
  
  public Bounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    left = paramInt1;
    top = paramInt2;
    right = paramInt3;
    bottom = paramInt4;
  }
  
  public String toString()
  {
    return "Padding{left=" + left + ", top=" + top + ", right=" + right + ", bottom=" + bottom + '}';
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.maps.Bounds
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */