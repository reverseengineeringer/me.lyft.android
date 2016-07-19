package me.lyft.android.ui.passenger;

import android.content.res.Resources;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.lyft.scoop.Screen;
import javax.inject.Inject;
import me.lyft.android.analytics.core.ActionAnalytics;
import me.lyft.android.analytics.core.ExperimentAnalytics;
import me.lyft.android.analytics.core.definitions.Experiment;
import me.lyft.android.analytics.studies.InviteFriendsAnalytics;
import me.lyft.android.application.IUserProvider;
import me.lyft.android.application.constants.Constants;
import me.lyft.android.application.constants.IConstantsProvider;
import me.lyft.android.application.invite.ReferralUrlBuilder;
import me.lyft.android.application.payment.ICouponService;
import me.lyft.android.common.ActivityController;
import me.lyft.android.common.AppFlow;
import me.lyft.android.common.DialogFlow;
import me.lyft.android.common.Objects;
import me.lyft.android.common.RxViewController;
import me.lyft.android.domain.User;
import me.lyft.android.rx.RxUIBinder;
import me.lyft.android.ui.dialogs.Toast;
import me.lyft.android.ui.invites.InvitesScreens.InviteScreen;
import me.lyft.android.ui.invites.InvitesScreens.InviteSource;
import me.lyft.android.ui.invites.ShareItemProvider;
import me.lyft.android.ui.invites.ShareItemProvider.Builder;
import me.lyft.android.ui.invites.ShareItemProvider.ShareItem;
import me.lyft.android.ui.invites.SocialIntentProvider;

public class PostRideSocialDialogController
  extends RxViewController
{
  private final ActivityController activityController;
  private final AppFlow appFlow;
  private final IConstantsProvider constantsProvider;
  private final ICouponService couponService;
  private final DialogFlow dialogFlow;
  View inviteContacts;
  View inviteFacebook;
  View inviteTwitter;
  ImageView mainImage;
  private ShareItemProvider shareItemProvider;
  private final SocialIntentProvider socialIntentProvider;
  TextView subtitleText;
  TextView titleText;
  private final IUserProvider userProvider;
  
  @Inject
  public PostRideSocialDialogController(IUserProvider paramIUserProvider, IConstantsProvider paramIConstantsProvider, DialogFlow paramDialogFlow, AppFlow paramAppFlow, ActivityController paramActivityController, SocialIntentProvider paramSocialIntentProvider, ICouponService paramICouponService)
  {
    userProvider = paramIUserProvider;
    constantsProvider = paramIConstantsProvider;
    dialogFlow = paramDialogFlow;
    appFlow = paramAppFlow;
    activityController = paramActivityController;
    socialIntentProvider = paramSocialIntentProvider;
    couponService = paramICouponService;
  }
  
  private void initSubtitleText()
  {
    ExperimentAnalytics.trackExposure(Experiment.PG_LADA_GIVE_GET);
    subtitleText.setText(2131166235);
    binder.bindAsyncCall(couponService.observeUserCouponInfo(), new PostRideSocialDialogController.1(this));
  }
  
  private void setTitleText(boolean paramBoolean)
  {
    TextView localTextView = titleText;
    if (paramBoolean) {}
    for (int i = 2131165833;; i = 2131166333)
    {
      localTextView.setText(i);
      return;
    }
  }
  
  private void updateShareButton(View paramView, int paramInt1, int paramInt2)
  {
    ((ImageView)paramView.findViewById(2131559753)).setImageResource(paramInt1);
    ((TextView)paramView.findViewById(2131559754)).setText(paramInt2);
  }
  
  void cancelDialog()
  {
    dialogFlow.dismiss();
  }
  
  String getTwitterShareText()
  {
    String str1 = (String)Objects.firstNonNull(constantsProvider.get(Constants.TWITTER_INVITE_TEXT), getResources().getString(2131166147));
    String str2 = ReferralUrlBuilder.buildUrl((String)constantsProvider.get(Constants.TWITTER_REFERRAL_BASE_URL), userProvider.getUser().getReferralCode());
    return str1 + " " + str2;
  }
  
  protected int layoutId()
  {
    return 2130903457;
  }
  
  public void onAttach()
  {
    super.onAttach();
    shareItemProvider = new ShareItemProvider.Builder().twitter(getTwitterShareText()).facebook(ReferralUrlBuilder.buildUrl((String)constantsProvider.get(Constants.FACEBOOK_REFERRAL_BASE_URL), userProvider.getUser().getReferralCode())).build(getResources(), userProvider, constantsProvider);
    InviteFriendsAnalytics.trackShowInviteFriendsButton("post_ride_share_modal");
    boolean bool = ((PassengerDialogs.PostRideSocialShareDialog)Screen.fromController(this)).isInvitesSentDialog();
    ImageView localImageView = mainImage;
    if (bool) {}
    for (int i = 2130838329;; i = 2130838330)
    {
      localImageView.setImageResource(i);
      setTitleText(bool);
      initSubtitleText();
      updateShareButton(inviteFacebook, 2130838215, 2131165705);
      updateShareButton(inviteTwitter, 2130838373, 2131166391);
      updateShareButton(inviteContacts, 2130838302, 2131165473);
      return;
    }
  }
  
  void onCancelClicked()
  {
    cancelDialog();
  }
  
  void onContactsClicked()
  {
    shareWithContacts();
  }
  
  void onFacebookClicked()
  {
    shareWithFacebook();
    cancelDialog();
  }
  
  void onTwitterClicked()
  {
    shareWithTwitter();
    cancelDialog();
  }
  
  void shareWithContacts()
  {
    dialogFlow.dismiss();
    appFlow.goTo(new InvitesScreens.InviteScreen(InvitesScreens.InviteSource.SOCIAL_PROMPT));
  }
  
  void shareWithFacebook()
  {
    startActivityOrShowErrorToast(shareItemProvider.getFacebookShareItem(), 2131166374);
  }
  
  void shareWithTwitter()
  {
    startActivityOrShowErrorToast(shareItemProvider.getTwitterShareItem(), 2131166377);
  }
  
  void startActivityOrShowErrorToast(ShareItemProvider.ShareItem paramShareItem, int paramInt)
  {
    ActionAnalytics localActionAnalytics = InviteFriendsAnalytics.trackShareInvites(paramShareItem.getName());
    paramShareItem = socialIntentProvider.createShareIntent(paramShareItem);
    if (paramShareItem != null)
    {
      ExperimentAnalytics.trackExposure(Experiment.PG_INVITE_TEXT_V2);
      InviteFriendsAnalytics.displayShowInviteText();
      localActionAnalytics.trackSuccess();
      activityController.startActivity(paramShareItem);
      return;
    }
    paramShareItem = getResources().getString(paramInt);
    localActionAnalytics.trackFailure(paramShareItem);
    dialogFlow.show(new Toast(paramShareItem));
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.passenger.PostRideSocialDialogController
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */