package me.lyft.android.application.driver;

import me.lyft.android.domain.payment.Money;
import me.lyft.android.domain.payment.NullMoney;
import me.lyft.android.rx.ReactiveProperty;
import rx.Observable;

public class DailyTotalsRepository
  implements IDailyTotalsRepository
{
  private final ReactiveProperty<Money> dailyTotalSubject = ReactiveProperty.create(NullMoney.getInstance());
  
  public Money getDailyTotal()
  {
    return (Money)dailyTotalSubject.get();
  }
  
  public Observable<Money> observeDailyTotalChange()
  {
    return dailyTotalSubject.asObservable();
  }
  
  public void updateDailyTotal(Money paramMoney)
  {
    dailyTotalSubject.onNext(paramMoney);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.driver.DailyTotalsRepository
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */