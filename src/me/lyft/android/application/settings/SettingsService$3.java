package me.lyft.android.application.settings;

import com.lyft.android.api.dto.UniversalDTO;
import me.lyft.android.common.Unit;
import rx.Observable;
import rx.functions.Func1;

class SettingsService$3
  implements Func1<UniversalDTO, Observable<Unit>>
{
  SettingsService$3(SettingsService paramSettingsService) {}
  
  public Observable<Unit> call(UniversalDTO paramUniversalDTO)
  {
    return Unit.just();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.settings.SettingsService.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */