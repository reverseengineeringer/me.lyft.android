package me.lyft.android.services;

import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import me.lyft.android.application.IUserProvider;
import me.lyft.android.application.ride.IDriverRideProvider;
import me.lyft.android.domain.User;
import me.lyft.android.domain.driver.ride.DriverRide;
import rx.functions.Action0;

class LyftDriverToggleService$3
  implements Action0
{
  LyftDriverToggleService$3(LyftDriverToggleService paramLyftDriverToggleService) {}
  
  public void call()
  {
    LyftDriverToggleService.access$200(this$0).setVisibility(0);
    LyftDriverToggleService.access$300(this$0).setVisibility(0);
    int i;
    if (this$0.driverRideProvider.getDriverRide().isInProgress()) {
      i = 2131165718;
    }
    for (;;)
    {
      LyftDriverToggleService.access$400(this$0).setText(i);
      if (LyftDriverToggleService.access$500(this$0) != 242) {
        LyftDriverToggleService.access$600(this$0, LyftDriverToggleService.access$100(this$0), LyftDriverToggleService.access$500(this$0), 242);
      }
      if (LyftDriverToggleService.access$700(this$0) != null) {
        LyftDriverToggleService.access$700(this$0).cancel();
      }
      if ((LyftDriverToggleService.access$400(this$0).getVisibility() != 0) || (LyftDriverToggleService.access$800(this$0).getAlpha() != 1.0F))
      {
        LyftDriverToggleService.access$400(this$0).setAlpha(0.0F);
        LyftDriverToggleService.access$400(this$0).setVisibility(0);
        LyftDriverToggleService.access$702(this$0, LyftDriverToggleService.access$400(this$0).animate().alpha(1.0F).setDuration(325L).setListener(null));
      }
      return;
      if (this$0.userProvider.getUser().isDispatchable()) {
        i = 2131165719;
      } else {
        i = 2131165720;
      }
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.services.LyftDriverToggleService.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */