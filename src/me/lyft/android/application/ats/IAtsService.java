package me.lyft.android.application.ats;

import com.lyft.android.api.dto.PhoneDTO;
import me.lyft.android.domain.ats.DriverApplication;
import me.lyft.android.domain.ats.DriverApplicationData;
import rx.Observable;

public abstract interface IAtsService
{
  public abstract Observable<DriverApplication> getDriverApplication();
  
  public abstract Observable<DriverApplicationData> getDriverApplicationData();
  
  public abstract Observable<DriverApplication> updateDriverApplication(String paramString1, String paramString2, PhoneDTO paramPhoneDTO, String paramString3);
}

/* Location:
 * Qualified Name:     me.lyft.android.application.ats.IAtsService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */