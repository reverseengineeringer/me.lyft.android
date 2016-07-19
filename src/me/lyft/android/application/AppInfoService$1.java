package me.lyft.android.application;

import com.lyft.android.api.dto.AppInfoDTO;
import me.lyft.android.ILyftPreferences;
import rx.functions.Action1;

class AppInfoService$1
  implements Action1<AppInfoDTO>
{
  AppInfoService$1(AppInfoService paramAppInfoService) {}
  
  public void call(AppInfoDTO paramAppInfoDTO)
  {
    this$0.updateAppInfo(paramAppInfoDTO);
    AppInfoService.access$000(this$0).setInstallReferrer(null);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.AppInfoService.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */