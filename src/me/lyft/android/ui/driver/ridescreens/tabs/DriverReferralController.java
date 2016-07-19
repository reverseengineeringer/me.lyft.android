package me.lyft.android.ui.driver.ridescreens.tabs;

import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import javax.inject.Inject;
import me.lyft.android.analytics.studies.InviteFriendsAnalytics;
import me.lyft.android.application.IUserProvider;
import me.lyft.android.common.RxViewController;
import me.lyft.android.common.Strings;
import me.lyft.android.controls.DriverBottomNavigationView;
import me.lyft.android.controls.DriverBottomNavigationView.DriverTab;
import me.lyft.android.domain.User;
import me.lyft.android.infrastructure.appboy.IAppboyService;
import me.lyft.android.ui.SlideMenuController;
import me.lyft.android.ui.invites.InviteDispatcher;
import me.lyft.android.ui.invites.InviteFriendsCardView;
import me.lyft.android.ui.invites.InviteFriendsDriverCardDelegate;
import me.lyft.android.ui.invites.InviteFriendsPassengerCardDelegate;

public class DriverReferralController
  extends RxViewController
{
  private final IAppboyService appboyService;
  InviteFriendsCardView bottomCardView;
  DriverBottomNavigationView driverBottomNavigationView;
  @Inject
  InviteDispatcher inviteDispatcher;
  TextView invitePersonalCodeText;
  LinearLayout inviteReferralCodeSelector;
  TextView inviteTermsConditionsText;
  private final SlideMenuController slideMenuController;
  InviteFriendsCardView topCardView;
  private User user;
  private final IUserProvider userProvider;
  
  @Inject
  public DriverReferralController(IUserProvider paramIUserProvider, SlideMenuController paramSlideMenuController, IAppboyService paramIAppboyService)
  {
    userProvider = paramIUserProvider;
    slideMenuController = paramSlideMenuController;
    appboyService = paramIAppboyService;
  }
  
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
    slideMenuController.enableMenu();
    String str = user.getReferralCode();
    if (!Strings.isNullOrEmpty(str)) {
      invitePersonalCodeText.setText(str);
    }
  }
  
  protected int layoutId()
  {
    return 2130903177;
  }
  
  public void onAttach()
  {
    super.onAttach();
    user = userProvider.getUser();
    initializeToolbar();
    driverBottomNavigationView.setCurrentTab(DriverBottomNavigationView.DriverTab.REFERRALS);
    inviteTermsConditionsText.setMovementMethod(LinkMovementMethod.getInstance());
    inviteReferralCodeSelector.setOnClickListener(new DriverReferralController.1(this));
    InviteFriendsAnalytics.displayReferFriends();
    initializeCards();
    appboyService.enableInappNoteDisplay();
  }
  
  public void onDetach()
  {
    super.onDetach();
    slideMenuController.disableMenu();
    appboyService.disableInappNoteDisplay();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.driver.ridescreens.tabs.DriverReferralController
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */