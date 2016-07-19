package me.lyft.android.ui.invites;

import android.content.res.Resources;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.lyft.scoop.Screen;
import javax.inject.Inject;
import me.lyft.android.analytics.studies.InviteFriendsAnalytics;
import me.lyft.android.application.IUserProvider;
import me.lyft.android.common.RxViewController;
import me.lyft.android.common.Strings;
import me.lyft.android.controls.MenuButtonToolbar;
import me.lyft.android.domain.User;
import me.lyft.android.ui.SlideMenuController;

public class InviteControllerV2
  extends RxViewController
{
  InviteFriendsCardView bottomCardView;
  @Inject
  InviteDispatcher inviteDispatcher;
  TextView invitePersonalCodeText;
  LinearLayout inviteReferralCodeSelector;
  TextView inviteTermsConditionsText;
  @Inject
  ReferralTrackingService referralTrackingService;
  @Inject
  SlideMenuController slideMenuController;
  MenuButtonToolbar toolbar;
  InviteFriendsCardView topCardView;
  private User user;
  @Inject
  IUserProvider userProvider;
  
  private void initializeCards()
  {
    if (userProvider.getUser().isApprovedDriver())
    {
      initializeDriverCard(topCardView);
      initializePassengerCard(bottomCardView);
      return;
    }
    initializePassengerCard(topCardView);
    initializeDriverCard(bottomCardView);
  }
  
  private void initializeDriverCard(InviteFriendsCardView paramInviteFriendsCardView)
  {
    paramInviteFriendsCardView.setCardDelegate(new InviteFriendsDriverCardDelegate(getView().getContext()));
  }
  
  private void initializePassengerCard(InviteFriendsCardView paramInviteFriendsCardView)
  {
    paramInviteFriendsCardView.setCardDelegate(new InviteFriendsPassengerCardDelegate(getView().getContext()));
  }
  
  private void initializeToolbar()
  {
    toolbar.setTitle(getResources().getString(2131165817));
    slideMenuController.enableMenu();
    String str = user.getReferralCode();
    if (!Strings.isNullOrEmpty(str)) {
      invitePersonalCodeText.setText(str);
    }
  }
  
  protected int layoutId()
  {
    return 2130903258;
  }
  
  public void onAttach()
  {
    super.onAttach();
    user = userProvider.getUser();
    initializeToolbar();
    inviteTermsConditionsText.setMovementMethod(LinkMovementMethod.getInstance());
    inviteReferralCodeSelector.setOnClickListener(new InviteControllerV2.1(this));
    InviteFriendsAnalytics.displayReferFriends();
    initializeCards();
    Object localObject = (InvitesScreens.InviteFriendsScreen)Screen.fromController(this);
    referralTrackingService.startTracking();
    localObject = ((InvitesScreens.InviteFriendsScreen)localObject).getSource();
    if (localObject != null) {
      referralTrackingService.setSource(((InvitesScreens.InviteSource)localObject).getName());
    }
  }
  
  public void onDetach()
  {
    super.onDetach();
    slideMenuController.disableMenu();
    referralTrackingService.completeTracking();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.invites.InviteControllerV2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */