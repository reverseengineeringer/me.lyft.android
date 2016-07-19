package me.lyft.android.application.landing;

import com.lyft.android.api.dto.AdditionalAuthMethodDTO;
import com.lyft.android.api.dto.LocationDTO;
import com.lyft.android.api.dto.LoginRequestDTO;
import com.lyft.android.api.dto.PhoneDTO;
import com.lyft.android.api.dto.UniversalDTO;
import me.lyft.android.ILyftPreferences;
import me.lyft.android.common.IAppStore;
import me.lyft.android.domain.location.Location;
import me.lyft.android.domain.location.LocationMapper;
import me.lyft.android.infrastructure.lyft.ILyftApi;
import me.lyft.android.persistence.landing.SignupUser;
import rx.Observable;
import rx.functions.Func1;

class LandingService$9
  implements Func1<Location, Observable<UniversalDTO>>
{
  LandingService$9(LandingService paramLandingService, SignupUser paramSignupUser, PhoneDTO paramPhoneDTO, AdditionalAuthMethodDTO paramAdditionalAuthMethodDTO, Boolean paramBoolean, String paramString) {}
  
  public Observable<UniversalDTO> call(Location paramLocation)
  {
    LocationDTO localLocationDTO = LocationMapper.toLocationDTO(paramLocation);
    paramLocation = null;
    String str1 = null;
    String str2 = null;
    Boolean localBoolean = null;
    if (val$signupUser != null)
    {
      paramLocation = val$signupUser.getFirstName().trim();
      str1 = val$signupUser.getLastName().trim();
      str2 = val$signupUser.getEmail().trim();
      localBoolean = Boolean.valueOf(val$signupUser.hasAgreedToS());
    }
    paramLocation = new LoginRequestDTO(paramLocation, str1, str2, LandingService.access$100(this$0).getInstallReferrer(), val$phone, LandingService.access$100(this$0).getMatId(), localBoolean, localLocationDTO, "returnappinfo", LandingService.access$200(this$0).getAppStoreSource(), val$additionalAuthMethod, val$forceNewAccount);
    return LandingService.access$300(this$0).createUser(val$facebookToken, paramLocation);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.landing.LandingService.9
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */