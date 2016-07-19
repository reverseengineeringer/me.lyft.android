package me.lyft.android.application.driver.expresspay;

import me.lyft.android.domain.driver.ExpressPay;
import me.lyft.android.domain.driver.ExpressPayAccount;
import rx.Observable;
import rx.subjects.BehaviorSubject;

public class ExpressPayRepository
  implements IExpressPayRepository
{
  private ExpressPay expressPay = ExpressPay.empty();
  BehaviorSubject<ExpressPayAccount> expressPayAccountSubject = BehaviorSubject.create(ExpressPayAccount.empty());
  
  public ExpressPay getExpressPay()
  {
    return expressPay;
  }
  
  public ExpressPayAccount getExpressPayAccount()
  {
    return (ExpressPayAccount)expressPayAccountSubject.getValue();
  }
  
  public Observable<ExpressPayAccount> observeExpressPayAccountChange()
  {
    return expressPayAccountSubject.asObservable();
  }
  
  public void setExpressAccount(ExpressPayAccount paramExpressPayAccount)
  {
    expressPayAccountSubject.onNext(paramExpressPayAccount);
  }
  
  public void setExpressPay(ExpressPay paramExpressPay)
  {
    expressPay = paramExpressPay;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.driver.expresspay.ExpressPayRepository
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */