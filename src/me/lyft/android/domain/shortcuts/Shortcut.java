package me.lyft.android.domain.shortcuts;

import me.lyft.android.domain.location.Location;

public final class Shortcut
{
  private Location location;
  private ShortcutType type;
  
  private Shortcut(ShortcutType paramShortcutType, Location paramLocation)
  {
    type = paramShortcutType;
    location = paramLocation;
  }
  
  public static Shortcut create(ShortcutType paramShortcutType, Location paramLocation)
  {
    return new Shortcut(paramShortcutType, paramLocation);
  }
  
  public Location getLocation()
  {
    return location;
  }
  
  public ShortcutType getType()
  {
    return type;
  }
  
  public boolean isHome()
  {
    return type == ShortcutType.HOME;
  }
  
  public boolean isWork()
  {
    return type == ShortcutType.WORK;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.shortcuts.Shortcut
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */