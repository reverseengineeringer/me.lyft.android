package me.lyft.android.ui.invites;

import android.content.Context;
import android.content.res.Resources;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.CardView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.ButterKnife;
import com.lyft.scoop.Scoop;
import com.lyft.scoop.dagger.DaggerInjector;
import javax.inject.Inject;
import me.lyft.android.TrackableView;
import me.lyft.android.analytics.core.ExperimentAnalytics;
import me.lyft.android.analytics.core.definitions.Experiment;
import me.lyft.android.analytics.studies.DriverStatsAnalytics;
import me.lyft.android.analytics.studies.InviteFriendsAnalytics;
import me.lyft.android.application.IUserProvider;
import me.lyft.android.application.constants.IConstantsProvider;
import me.lyft.android.application.payment.ICouponService;
import me.lyft.android.common.Strings;
import me.lyft.android.domain.invite.Invite;
import me.lyft.android.rx.RxUIBinder;

public class InviteFriendsCardView
  extends FrameLayout
  implements TrackableView
{
  private RxUIBinder binder;
  private IInviteFriendsCardDelegate cardDelegate;
  @Inject
  IConstantsProvider constantsProvider;
  @Inject
  ICouponService couponService;
  View dividerBottom;
  View dividerTop;
  private Invite invite;
  TextView inviteCardAmountText;
  TextView inviteCardDescriptionText;
  ImageView inviteCardImage;
  TextView inviteCardTitleText;
  @Inject
  InviteDispatcher inviteDispatcher;
  CardView inviteFriendsCardView;
  LinearLayout inviteFriendsContainer;
  private InviteType inviteType;
  @Inject
  ReferralTrackingService referralTrackingService;
  @Inject
  IUserProvider userProvider;
  
  public InviteFriendsCardView(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public InviteFriendsCardView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  private void handleDividers(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      dividerTop.setVisibility(0);
      dividerBottom.setVisibility(0);
      ViewCompat.setElevation(inviteFriendsCardView, 0.0F);
    }
  }
  
  private void hideAmount()
  {
    inviteCardAmountText.setVisibility(8);
  }
  
  private void init()
  {
    Scoop.fromView(this).inflater(getContext()).inflate(2130903255, this, true);
    ButterKnife.bind(this, this);
    DaggerInjector.fromView(this).inject(this);
    binder = new RxUIBinder();
    inviteType = InviteType.NONE;
  }
  
  private void setCardImage(int paramInt)
  {
    inviteCardImage.setImageResource(paramInt);
  }
  
  private void setTitle(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    String str = getResources().getString(paramInt1);
    if (Strings.isNullOrEmpty(str)) {
      inviteCardTitleText.setVisibility(8);
    }
    inviteCardTitleText.setText(str);
    inviteCardTitleText.setTypeface(null, paramInt2);
    inviteCardTitleText.setTextSize(0, getResources().getDimension(paramInt3));
    inviteCardTitleText.setTextColor(getResources().getColor(paramInt4));
  }
  
  private void trackEmailInvite()
  {
    switch (InviteFriendsCardView.2.$SwitchMap$me$lyft$android$ui$invites$InviteType[inviteType.ordinal()])
    {
    default: 
      return;
    case 1: 
      InviteFriendsAnalytics.trackInvitePaxViaEmail();
      referralTrackingService.didShare();
      return;
    case 2: 
      InviteFriendsAnalytics.trackInviteDriversViaEmail();
      referralTrackingService.didShare();
      return;
    }
    DriverStatsAnalytics.trackInviteDriversViaEmail();
  }
  
  private void trackInviteOptionsTap()
  {
    switch (InviteFriendsCardView.2.$SwitchMap$me$lyft$android$ui$invites$InviteType[inviteType.ordinal()])
    {
    default: 
      return;
    case 1: 
      InviteFriendsAnalytics.tapPaxInvitesButton();
      return;
    case 2: 
      InviteFriendsAnalytics.tapDriverInvitesButton();
      return;
    }
    DriverStatsAnalytics.tapDriverInvitesButton();
  }
  
  private void trackSMSInvite()
  {
    switch (InviteFriendsCardView.2.$SwitchMap$me$lyft$android$ui$invites$InviteType[inviteType.ordinal()])
    {
    default: 
      return;
    case 1: 
      InviteFriendsAnalytics.trackInvitePaxViaSMS();
      referralTrackingService.didShare();
      return;
    case 2: 
      InviteFriendsAnalytics.trackInviteDriversViaSMS();
      referralTrackingService.didShare();
      return;
    }
    DriverStatsAnalytics.trackInviteDriversViaSMS();
  }
  
  private void updateCard()
  {
    inviteType = cardDelegate.getCardType();
    setTitle(cardDelegate.getTitle(), cardDelegate.getTitleStyle(), cardDelegate.getTitleSize(), cardDelegate.getTitleColor());
    setCardImage(cardDelegate.getCardImage());
    if (cardDelegate.hideAmount()) {
      hideAmount();
    }
    inviteFriendsContainer.setPadding((int)getResources().getDimension(cardDelegate.getLeftPaddingDimenId()), (int)getResources().getDimension(cardDelegate.getTopPaddingDimenId()), (int)getResources().getDimension(cardDelegate.getRightPaddingDimenId()), (int)getResources().getDimension(cardDelegate.getBottomPaddingDimenId()));
    handleDividers(cardDelegate.hasDividers());
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (isInEditMode()) {
      return;
    }
    if (getVisibility() == 0) {
      trackVisible();
    }
    binder.attach();
    binder.bindAction(cardDelegate.observeCreateInvite(new InviteFactory(getResources(), constantsProvider, userProvider)), new InviteFriendsCardView.1(this));
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    binder.detach();
  }
  
  void sendEmail()
  {
    ExperimentAnalytics.trackExposure(Experiment.PG_INVITE_TEXT_V2);
    InviteFriendsAnalytics.displayShowInviteText();
    trackEmailInvite();
    inviteDispatcher.sendEmail(invite);
  }
  
  void sendSMS()
  {
    ExperimentAnalytics.trackExposure(Experiment.PG_INVITE_TEXT_V2);
    InviteFriendsAnalytics.displayShowInviteText();
    trackSMSInvite();
    inviteDispatcher.sendSMS(invite);
  }
  
  public void setCardDelegate(IInviteFriendsCardDelegate paramIInviteFriendsCardDelegate)
  {
    cardDelegate = paramIInviteFriendsCardDelegate;
    updateCard();
  }
  
  void setInvite(Invite paramInvite)
  {
    invite = paramInvite;
    inviteCardAmountText.setText(paramInvite.getCardTitle());
    inviteCardDescriptionText.setText(paramInvite.getCardDescription());
  }
  
  public void trackVisible()
  {
    switch (InviteFriendsCardView.2.$SwitchMap$me$lyft$android$ui$invites$InviteType[inviteType.ordinal()])
    {
    default: 
      return;
    case 1: 
      InviteFriendsAnalytics.displayPaxInvitesButton();
      return;
    case 2: 
      InviteFriendsAnalytics.displayDriverInvitesButton();
      return;
    }
    DriverStatsAnalytics.displayDriverInvitesButton();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.invites.InviteFriendsCardView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */