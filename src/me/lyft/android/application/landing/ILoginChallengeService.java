package me.lyft.android.application.landing;

import me.lyft.android.common.Unit;
import me.lyft.android.domain.Phone;
import rx.Observable;

public abstract interface ILoginChallengeService
{
  public abstract String getAccountOwnerFirstName();
  
  public abstract Phone getPhone();
  
  public abstract boolean isForceNewAccount();
  
  public abstract Observable<Unit> observeRetryVerifyPhoneSubject();
  
  public abstract void reset();
  
  public abstract void retryVerifyPhone();
  
  public abstract void setAccountOwnerFirstName(String paramString);
  
  public abstract void setForceNewAccount(boolean paramBoolean);
  
  public abstract void setPhone(Phone paramPhone);
}

/* Location:
 * Qualified Name:     me.lyft.android.application.landing.ILoginChallengeService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */