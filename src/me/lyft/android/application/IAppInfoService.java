package me.lyft.android.application;

import com.lyft.android.api.dto.AppInfoDTO;
import com.lyft.android.api.dto.RideTypeMetaDTO;
import java.util.List;
import me.lyft.android.common.Unit;
import rx.Observable;

public abstract interface IAppInfoService
{
  public abstract String getAppInfoRevision();
  
  public abstract RideTypeMetaDTO getRideTypeMetaById(String paramString);
  
  public abstract List<RideTypeMetaDTO> getRideTypeMetas();
  
  public abstract Observable<Unit> loadAppInfo(String paramString);
  
  public abstract void updateAppInfo(AppInfoDTO paramAppInfoDTO);
}

/* Location:
 * Qualified Name:     me.lyft.android.application.IAppInfoService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */