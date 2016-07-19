package me.lyft.android.application.shortcuts;

import me.lyft.android.domain.shortcuts.Shortcut;
import rx.functions.Func1;

class ShortcutService$1
  implements Func1<Shortcut, Boolean>
{
  ShortcutService$1(ShortcutService paramShortcutService) {}
  
  public Boolean call(Shortcut paramShortcut)
  {
    return Boolean.valueOf(paramShortcut.isWork());
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.shortcuts.ShortcutService.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */