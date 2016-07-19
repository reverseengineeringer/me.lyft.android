package me.lyft.android.application;

import com.lyft.android.api.dto.AppInfoDTO;
import me.lyft.android.domain.location.Location;
import me.lyft.android.infrastructure.lyft.ILyftApi;
import rx.Observable;
import rx.functions.Func1;

class AppInfoService$2
  implements Func1<Location, Observable<AppInfoDTO>>
{
  AppInfoService$2(AppInfoService paramAppInfoService, String paramString) {}
  
  public Observable<AppInfoDTO> call(Location paramLocation)
  {
    return AppInfoService.access$100(this$0).getAppInfo(paramLocation.getLat(), paramLocation.getLng(), val$deepLink);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.AppInfoService.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */