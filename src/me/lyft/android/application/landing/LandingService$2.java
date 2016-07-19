package me.lyft.android.application.landing;

import com.lyft.android.api.dto.PhoneDTO;
import me.lyft.android.application.landing.exceptions.AdditionalAuthRequiredException;
import me.lyft.android.common.Unit;
import me.lyft.android.infrastructure.lyft.PhoneLoginErrorParser;
import me.lyft.android.persistence.landing.SignupUser;
import rx.Observable;
import rx.functions.Func1;

class LandingService$2
  implements Func1<Throwable, Observable<? extends Unit>>
{
  LandingService$2(LandingService paramLandingService, SignupUser paramSignupUser, PhoneDTO paramPhoneDTO) {}
  
  public Observable<? extends Unit> call(Throwable paramThrowable)
  {
    if ((PhoneLoginErrorParser.parse(paramThrowable) instanceof AdditionalAuthRequiredException)) {
      LandingService.access$000(this$0, val$signupUser, val$phoneDTO);
    }
    return Observable.error(PhoneLoginErrorParser.parse(paramThrowable));
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.landing.LandingService.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */