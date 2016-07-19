package me.lyft.android.ui.invites;

import android.content.Context;
import com.lyft.scoop.dagger.DaggerInjector;
import javax.inject.Inject;
import me.lyft.android.application.invite.IReferralService;
import me.lyft.android.domain.invite.Invite;
import rx.Observable;

public class InviteFriendsDriverCardDelegate
  implements IInviteFriendsCardDelegate
{
  @Inject
  IReferralService referralService;
  
  public InviteFriendsDriverCardDelegate(Context paramContext)
  {
    DaggerInjector.fromContext(paramContext).inject(this);
  }
  
  public int getBottomPaddingDimenId()
  {
    return 2131230856;
  }
  
  public int getButtonTitle()
  {
    return 2131165809;
  }
  
  public int getCardImage()
  {
    return 2130838085;
  }
  
  public InviteType getCardType()
  {
    return InviteType.INVITE_FRIENDS_DRIVER;
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
    return 2131165810;
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
    return referralService.getReferral().onErrorResumeNext(new InviteFriendsDriverCardDelegate.2(this)).flatMap(new InviteFriendsDriverCardDelegate.1(this, paramInviteFactory));
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.invites.InviteFriendsDriverCardDelegate
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */