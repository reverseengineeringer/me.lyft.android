package me.lyft.android.application.driver;

import com.lyft.android.api.dto.DriverProfileDTO;
import me.lyft.android.common.Unit;
import me.lyft.android.domain.driver.DriverProfile;
import me.lyft.android.domain.driver.DriverProfileMapper;
import me.lyft.android.infrastructure.lyft.ILyftApi;
import me.lyft.android.persistence.ISimpleRepository;
import rx.Observable;
import rx.functions.Func1;

public class DriverProfileService
  implements IDriverProfileService
{
  private final ISimpleRepository<DriverProfile> driverProfileRepository;
  private final ILyftApi lyftApi;
  
  public DriverProfileService(ILyftApi paramILyftApi, ISimpleRepository<DriverProfile> paramISimpleRepository)
  {
    lyftApi = paramILyftApi;
    driverProfileRepository = paramISimpleRepository;
  }
  
  public Observable<DriverProfile> getDriverProfile()
  {
    lyftApi.getDriverProfile().map(new Func1()
    {
      public DriverProfile call(DriverProfileDTO paramAnonymousDriverProfileDTO)
      {
        paramAnonymousDriverProfileDTO = DriverProfileMapper.fromDriverProfileDto(paramAnonymousDriverProfileDTO);
        driverProfileRepository.update(paramAnonymousDriverProfileDTO);
        return paramAnonymousDriverProfileDTO;
      }
    });
  }
  
  public Observable<Unit> updateDriverProfile(final DriverProfile paramDriverProfile)
  {
    DriverProfileDTO localDriverProfileDTO = DriverProfileMapper.toDriverProfileDto(paramDriverProfile);
    lyftApi.updateDriverProfile(localDriverProfileDTO).map(new Func1()
    {
      public Unit call(Unit paramAnonymousUnit)
      {
        driverProfileRepository.update(paramDriverProfile);
        return paramAnonymousUnit;
      }
    });
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.driver.DriverProfileService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */