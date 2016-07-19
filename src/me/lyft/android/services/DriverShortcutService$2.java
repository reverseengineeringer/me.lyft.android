package me.lyft.android.services;

import android.content.res.Resources;
import me.lyft.android.application.IUserProvider;
import me.lyft.android.application.payment.IPricingService;
import me.lyft.android.common.Unit;
import me.lyft.android.domain.User;
import me.lyft.android.domain.passenger.ridetypes.Pricing;
import me.lyft.android.ui.driver.shortcut.ChatheadView;
import me.lyft.android.ui.driver.shortcut.FloatingViewManager;
import rx.functions.Action1;

class DriverShortcutService$2
  implements Action1<Unit>
{
  DriverShortcutService$2(DriverShortcutService paramDriverShortcutService) {}
  
  public void call(Unit paramUnit)
  {
    paramUnit = this$0.userProvider.getUser();
    Pricing localPricing = this$0.primeTimeService.getPricing();
    if (paramUnit.isDispatchable())
    {
      DriverShortcutService.access$100(this$0).showDispatchable();
      DriverShortcutService.access$200(this$0).setExtraCenterY(this$0.getResources().getDimension(2131230872));
      return;
    }
    if (localPricing.hasDynamicPricing())
    {
      DriverShortcutService.access$100(this$0).showPrimeTime(this$0.getResources().getString(2131165668, new Object[] { localPricing.getDynamicPricing() }));
      DriverShortcutService.access$200(this$0).setExtraCenterY(this$0.getResources().getDimension(2131230872));
      return;
    }
    DriverShortcutService.access$100(this$0).hidePrimetime();
    DriverShortcutService.access$200(this$0).setExtraCenterY(this$0.getResources().getDimension(2131230855));
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.services.DriverShortcutService.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */