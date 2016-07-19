package me.lyft.android.ui.payment;

import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;
import me.lyft.android.rx.RxBinder;
import me.lyft.android.rx.RxUIBinder;
import me.lyft.android.ui.MainActivityModule;

@Module(addsTo=MainActivityModule.class, injects={PaymentScreenController.class})
public class PaymentScreenModule
{
  @Provides
  @Singleton
  RxBinder provideBinder()
  {
    return new RxUIBinder();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.payment.PaymentScreenModule
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */