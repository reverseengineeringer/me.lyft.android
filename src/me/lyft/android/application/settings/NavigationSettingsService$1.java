package me.lyft.android.application.settings;

import com.lyft.android.api.dto.UniversalDTO;
import me.lyft.android.common.Unit;
import rx.Observable;
import rx.functions.Func1;

class NavigationSettingsService$1
  implements Func1<UniversalDTO, Observable<Unit>>
{
  NavigationSettingsService$1(NavigationSettingsService paramNavigationSettingsService) {}
  
  public Observable<Unit> call(UniversalDTO paramUniversalDTO)
  {
    return Unit.just();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.settings.NavigationSettingsService.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */