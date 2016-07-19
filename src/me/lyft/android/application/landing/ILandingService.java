package me.lyft.android.application.landing;

import me.lyft.android.common.Unit;
import me.lyft.android.domain.Phone;
import me.lyft.android.infrastructure.facebook.FacebookLoginResult;
import me.lyft.android.persistence.landing.SignupUser;
import rx.Observable;

public abstract interface ILandingService
{
  public abstract Observable<Unit> createFacebookUser(FacebookLoginResult paramFacebookLoginResult);
  
  public abstract Observable<Unit> createUser(SignupUser paramSignupUser);
  
  public abstract Observable<Unit> loadUser();
  
  public abstract Observable<Unit> requestVerificationCode(String paramString);
  
  public abstract Observable<Unit> updateExistingUser(SignupUser paramSignupUser);
  
  public abstract Observable<Unit> verifyCreditCard(Phone paramPhone, String paramString);
  
  public abstract Observable<Unit> verifyDriverLicense(Phone paramPhone, String paramString);
  
  public abstract Observable<Unit> verifyPhone(String paramString1, String paramString2, boolean paramBoolean);
}

/* Location:
 * Qualified Name:     me.lyft.android.application.landing.ILandingService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */