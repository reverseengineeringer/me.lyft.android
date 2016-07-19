package me.lyft.android.events;

public class Consumable
{
  private boolean isConsumed = false;
  
  public final boolean consume()
  {
    boolean bool = isConsumed;
    isConsumed = true;
    return bool;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.events.Consumable
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */