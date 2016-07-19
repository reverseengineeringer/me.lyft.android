package me.lyft.android.application.ats;

import com.lyft.android.api.dto.DriverApplicationDTO;
import com.lyft.android.api.dto.DriverApplicationDataDTO;
import com.lyft.android.api.dto.PhoneDTO;
import me.lyft.android.domain.ats.DriverApplication;
import me.lyft.android.domain.ats.DriverApplicationData;
import me.lyft.android.domain.ats.DriverApplicationDataMapper;
import me.lyft.android.domain.ats.DriverApplicationMapper;
import me.lyft.android.infrastructure.lyft.ILyftApi;
import rx.Observable;
import rx.functions.Func1;

public class AtsService
  implements IAtsService
{
  private ILyftApi lyftApi;
  
  public AtsService(ILyftApi paramILyftApi)
  {
    lyftApi = paramILyftApi;
  }
  
  public Observable<DriverApplication> getDriverApplication()
  {
    lyftApi.getDriverApplication().map(new Func1()
    {
      public DriverApplication call(DriverApplicationDTO paramAnonymousDriverApplicationDTO)
      {
        return DriverApplicationMapper.fromDriverApplicationDto(paramAnonymousDriverApplicationDTO);
      }
    });
  }
  
  public Observable<DriverApplicationData> getDriverApplicationData()
  {
    lyftApi.getDriverApplicationData().map(new Func1()
    {
      public DriverApplicationData call(DriverApplicationDataDTO paramAnonymousDriverApplicationDataDTO)
      {
        return DriverApplicationDataMapper.fromDriverApplicationDataDto(paramAnonymousDriverApplicationDataDTO);
      }
    });
  }
  
  public Observable<DriverApplication> updateDriverApplication(String paramString1, String paramString2, PhoneDTO paramPhoneDTO, String paramString3)
  {
    paramString1 = DriverApplicationMapper.toDriverApplicationDto(paramString1, paramString2, paramPhoneDTO, paramString3);
    lyftApi.updateDriverApplication(paramString1).map(new Func1()
    {
      public DriverApplication call(DriverApplicationDTO paramAnonymousDriverApplicationDTO)
      {
        return DriverApplicationMapper.fromDriverApplicationDto(paramAnonymousDriverApplicationDTO);
      }
    });
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.ats.AtsService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */