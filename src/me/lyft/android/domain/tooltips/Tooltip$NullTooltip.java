package me.lyft.android.domain.tooltips;

public class Tooltip$NullTooltip
  extends Tooltip
{
  private static Tooltip instance = new NullTooltip();
  
  public boolean isNull()
  {
    return true;
  }
  
  public boolean shouldShow()
  {
    return false;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.tooltips.Tooltip.NullTooltip
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */