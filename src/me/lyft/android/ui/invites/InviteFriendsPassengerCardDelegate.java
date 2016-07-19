package me.lyft.android.ui.invites;

import android.content.Context;
import com.lyft.scoop.dagger.DaggerInjector;
import javax.inject.Inject;
import me.lyft.android.analytics.core.ExperimentAnalytics;
import me.lyft.android.analytics.core.definitions.Experiment;
import me.lyft.android.application.payment.ICouponService;
import me.lyft.android.domain.invite.Invite;
import rx.Observable;

public class InviteFriendsPassengerCardDelegate
  implements IInviteFriendsCardDelegate
{
  @Inject
  ICouponService couponService;
  
  public InviteFriendsPassengerCardDelegate(Context paramContext)
  {
    DaggerInjector.fromContext(paramContext).inject(this);
  }
  
  public int getBottomPaddingDimenId()
  {
    return 2131230856;
  }
  
  public int getButtonTitle()
  {
    return 2131165818;
  }
  
  public int getCardImage()
  {
    return 2130838096;
  }
  
  public InviteType getCardType()
  {
    return InviteType.INVITE_FRIENDS_PASSENGER;
  }
  
  public int getLeftPaddingDimenId()
  {
    return 2131230893;
  }
  
  public int getRightPaddingDimenId()
  {
    return 2131230893;
  }
  
  public int getTitle()
  {
    return 2131165819;
  }
  
  public int getTitleColor()
  {
    return 2131492901;
  }
  
  public int getTitleSize()
  {
    return 2131230906;
  }
  
  public int getTitleStyle()
  {
    return 0;
  }
  
  public int getTopPaddingDimenId()
  {
    return 2131230856;
  }
  
  public boolean hasDividers()
  {
    return true;
  }
  
  public boolean hideAmount()
  {
    return false;
  }
  
  public Observable<Invite> observeCreateInvite(InviteFactory paramInviteFactory)
  {
    ExperimentAnalytics.trackExposure(Experiment.PG_LADA_GIVE_GET);
    return couponService.observeUserCouponInfo().flatMap(new InviteFriendsPassengerCardDelegate.1(this, paramInviteFactory));
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.invites.InviteFriendsPassengerCardDelegate
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */