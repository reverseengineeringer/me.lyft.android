package me.lyft.android.application.driver.expresspay;

import me.lyft.android.domain.driver.ExpressPay;
import me.lyft.android.domain.driver.ExpressPayAccount;
import rx.Observable;

public abstract interface IExpressPayRepository
{
  public abstract ExpressPay getExpressPay();
  
  public abstract ExpressPayAccount getExpressPayAccount();
  
  public abstract Observable<ExpressPayAccount> observeExpressPayAccountChange();
  
  public abstract void setExpressAccount(ExpressPayAccount paramExpressPayAccount);
  
  public abstract void setExpressPay(ExpressPay paramExpressPay);
}

/* Location:
 * Qualified Name:     me.lyft.android.application.driver.expresspay.IExpressPayRepository
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */