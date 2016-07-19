package me.lyft.android.application.shortcuts;

import com.lyft.android.api.dto.ShortcutDTO;
import java.util.ArrayList;
import java.util.List;
import me.lyft.android.application.IUserProvider;
import me.lyft.android.common.Iterables;
import me.lyft.android.common.Unit;
import me.lyft.android.domain.User;
import me.lyft.android.domain.location.Location;
import me.lyft.android.domain.location.LocationMapper;
import me.lyft.android.domain.location.NullLocation;
import me.lyft.android.domain.shortcuts.Shortcut;
import me.lyft.android.domain.shortcuts.ShortcutMapper;
import me.lyft.android.domain.shortcuts.ShortcutType;
import me.lyft.android.infrastructure.lyft.ILyftApi;
import rx.Observable;
import rx.functions.Func1;

public class ShortcutService
  implements IShortcutService
{
  private final ILyftApi lyftApi;
  private List<Shortcut> shortcuts = new ArrayList();
  private final IUserProvider userProvider;
  
  public ShortcutService(IUserProvider paramIUserProvider, ILyftApi paramILyftApi)
  {
    userProvider = paramIUserProvider;
    lyftApi = paramILyftApi;
  }
  
  public List<Shortcut> getShortcuts()
  {
    if (!Iterables.contains(shortcuts, new Func1()
    {
      public Boolean call(Shortcut paramAnonymousShortcut)
      {
        return Boolean.valueOf(paramAnonymousShortcut.isWork());
      }
    })) {
      shortcuts.add(Shortcut.create(ShortcutType.WORK, NullLocation.getInstance()));
    }
    if (!Iterables.contains(shortcuts, new Func1()
    {
      public Boolean call(Shortcut paramAnonymousShortcut)
      {
        return Boolean.valueOf(paramAnonymousShortcut.isHome());
      }
    })) {
      shortcuts.add(Shortcut.create(ShortcutType.HOME, NullLocation.getInstance()));
    }
    return shortcuts;
  }
  
  public Observable<Unit> saveShortcut(ShortcutType paramShortcutType, Location paramLocation)
  {
    paramShortcutType = new ShortcutDTO(ShortcutMapper.mapToShortcutLabel(paramShortcutType), LocationMapper.toDeprecatedPlaceDTO(paramLocation));
    return lyftApi.createUserShortcut(userProvider.getUser().getId(), paramShortcutType).map(Unit.func1());
  }
  
  public void updateShortcuts(List<Shortcut> paramList)
  {
    shortcuts = paramList;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.shortcuts.ShortcutService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */