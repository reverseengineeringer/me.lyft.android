package me.lyft.android.application.landing;

import com.jakewharton.rxrelay.BehaviorRelay;
import me.lyft.android.common.Unit;
import me.lyft.android.domain.Phone;
import rx.Observable;

public class LoginChallengeService
  implements ILoginChallengeService
{
  private String accountOwnerFirstName;
  private boolean forceNewAccount = false;
  private Phone phone;
  private final BehaviorRelay<Unit> retryVerifyPhoneSubject = BehaviorRelay.create();
  
  public String getAccountOwnerFirstName()
  {
    return accountOwnerFirstName;
  }
  
  public Phone getPhone()
  {
    return phone;
  }
  
  public boolean isForceNewAccount()
  {
    return forceNewAccount;
  }
  
  public Observable<Unit> observeRetryVerifyPhoneSubject()
  {
    return retryVerifyPhoneSubject.asObservable();
  }
  
  public void reset()
  {
    phone = Phone.empty();
    accountOwnerFirstName = null;
    forceNewAccount = false;
  }
  
  public void retryVerifyPhone()
  {
    retryVerifyPhoneSubject.call(Unit.create());
  }
  
  public void setAccountOwnerFirstName(String paramString)
  {
    accountOwnerFirstName = paramString;
  }
  
  public void setForceNewAccount(boolean paramBoolean)
  {
    forceNewAccount = paramBoolean;
  }
  
  public void setPhone(Phone paramPhone)
  {
    phone = paramPhone;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.landing.LoginChallengeService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */