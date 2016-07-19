package me.lyft.android.application.driver;

import me.lyft.android.domain.payment.Money;
import rx.Observable;

public abstract interface IDailyTotalsRepository
{
  public abstract Money getDailyTotal();
  
  public abstract Observable<Money> observeDailyTotalChange();
  
  public abstract void updateDailyTotal(Money paramMoney);
}

/* Location:
 * Qualified Name:     me.lyft.android.application.driver.IDailyTotalsRepository
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */