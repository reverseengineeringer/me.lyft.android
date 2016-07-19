package me.lyft.android.application.shortcuts;

import java.util.List;
import me.lyft.android.common.Unit;
import me.lyft.android.domain.location.Location;
import me.lyft.android.domain.shortcuts.Shortcut;
import me.lyft.android.domain.shortcuts.ShortcutType;
import rx.Observable;

public abstract interface IShortcutService
{
  public abstract List<Shortcut> getShortcuts();
  
  public abstract Observable<Unit> saveShortcut(ShortcutType paramShortcutType, Location paramLocation);
  
  public abstract void updateShortcuts(List<Shortcut> paramList);
}

/* Location:
 * Qualified Name:     me.lyft.android.application.shortcuts.IShortcutService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */