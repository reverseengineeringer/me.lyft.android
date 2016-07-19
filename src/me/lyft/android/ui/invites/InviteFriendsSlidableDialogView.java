package me.lyft.android.ui.invites;

import android.content.Context;
import android.content.res.Resources;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import butterknife.ButterKnife;
import com.lyft.scoop.HandleBack;
import com.lyft.scoop.Screen;
import com.lyft.scoop.dagger.DaggerInjector;
import javax.inject.Inject;
import me.lyft.android.analytics.studies.InviteFriendsAnalytics;
import me.lyft.android.common.DialogFlow;
import me.lyft.android.domain.invite.Invite;
import me.lyft.android.rx.Binder;
import me.lyft.android.rx.ViewExtensions;

public class InviteFriendsSlidableDialogView
  extends RelativeLayout
  implements HandleBack
{
  private static final int ANIM_IN_DURATION = 350;
  private static final int ANIM_OUT_DURATION = 350;
  private static final float CONTAINER_BACKGROUND_ALPHA = 0.2F;
  private static final int DRAWER_CONTAINER_OFFSET_PX = 200;
  private final Interpolator attachInterpolator = new OvershootInterpolator();
  private Binder binder;
  View bottomSheetBackground;
  private final Interpolator detachInterpolator = new DecelerateInterpolator();
  @Inject
  DialogFlow dialogFlow;
  private Invite invite;
  @Inject
  InviteDispatcher inviteDispatcher;
  private InviteType inviteType;
  private boolean isAddedToWindow = false;
  private boolean isRemoving = false;
  private final InviteDialogs.InviteFriendsSlidableDialog params;
  @Inject
  ReferralTrackingService referralTrackingService;
  InviteFriendsSlidableItem slidableItemClipboard;
  InviteFriendsSlidableItem slidableItemEmail;
  InviteFriendsSlidableItem slidableItemSms;
  LinearLayout slidableView;
  
  public InviteFriendsSlidableDialogView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    DaggerInjector.fromView(this).inject(this);
    params = ((InviteDialogs.InviteFriendsSlidableDialog)Screen.fromView(this));
    invite = params.getInvite();
    inviteType = params.getInviteType();
  }
  
  private void dismissInviteDialog()
  {
    animateOut();
  }
  
  private void trackClipboardInvite()
  {
    switch (InviteFriendsSlidableDialogView.7.$SwitchMap$me$lyft$android$ui$invites$InviteType[inviteType.ordinal()])
    {
    default: 
      return;
    case 1: 
      InviteFriendsAnalytics.trackInvitePaxViaClipboard();
      referralTrackingService.didShare();
      return;
    }
    InviteFriendsAnalytics.trackInviteDriversViaClipboard();
  }
  
  private void trackEmailInvite()
  {
    switch (InviteFriendsSlidableDialogView.7.$SwitchMap$me$lyft$android$ui$invites$InviteType[inviteType.ordinal()])
    {
    default: 
      return;
    case 1: 
      InviteFriendsAnalytics.trackInvitePaxViaEmail();
      referralTrackingService.didShare();
      return;
    }
    InviteFriendsAnalytics.trackInviteDriversViaEmail();
  }
  
  private void trackSMSInvite()
  {
    switch (InviteFriendsSlidableDialogView.7.$SwitchMap$me$lyft$android$ui$invites$InviteType[inviteType.ordinal()])
    {
    default: 
      return;
    case 1: 
      InviteFriendsAnalytics.trackInvitePaxViaSMS();
      referralTrackingService.didShare();
      return;
    }
    InviteFriendsAnalytics.trackInviteDriversViaSMS();
  }
  
  void animateOut()
  {
    if ((isAddedToWindow) && (!isRemoving))
    {
      isRemoving = true;
      ViewCompat.animate(bottomSheetBackground).alpha(0.0F).setDuration(350L).start();
      ViewCompat.animate(slidableView).translationY(ViewCompat.getTranslationY(slidableView) + slidableView.getHeight() - 200.0F).setDuration(350L).setInterpolator(detachInterpolator).setListener(new InviteFriendsSlidableDialogView.6(this)).start();
    }
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    binder = Binder.attach(this);
    binder.bind(ViewExtensions.onLoadedObservable(slidableView), new InviteFriendsSlidableDialogView.5(this));
  }
  
  public boolean onBack()
  {
    animateOut();
    return true;
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    if (isInEditMode()) {
      return;
    }
    ButterKnife.bind(this);
    setOnClickListener(new InviteFriendsSlidableDialogView.1(this));
    slidableItemSms.initializeSlidableItem(2130838281, getResources().getString(2131165814), new InviteFriendsSlidableDialogView.2(this));
    slidableItemEmail.initializeSlidableItem(2130838212, getResources().getString(2131165813), new InviteFriendsSlidableDialogView.3(this));
    slidableItemClipboard.initializeSlidableItem(2130838172, getResources().getString(2131165812), new InviteFriendsSlidableDialogView.4(this));
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.invites.InviteFriendsSlidableDialogView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */