package me.lyft.android.application.driver.expresspay;

import me.lyft.android.common.Unit;
import me.lyft.android.domain.payment.ICard;
import rx.Observable;

public abstract interface IExpressPayService
{
  public abstract Observable<Unit> createDebitCard(ICard paramICard);
  
  public abstract Observable<Unit> getExpressPay();
  
  public abstract Observable<Unit> submitPayout();
  
  public abstract Observable<Unit> updateDebitCard(ICard paramICard);
}

/* Location:
 * Qualified Name:     me.lyft.android.application.driver.expresspay.IExpressPayService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */