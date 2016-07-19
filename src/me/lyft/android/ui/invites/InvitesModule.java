package me.lyft.android.ui.invites;

import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;
import me.lyft.android.application.invite.InviteService;
import me.lyft.android.common.ActivityController;
import me.lyft.android.common.DialogFlow;
import me.lyft.android.infrastructure.lyft.ILyftApi;

@Module(complete=false, injects={InviteController.class, InviteControllerV2.class, InviteFriendsSlidableItem.class, InviteFriendsCardView.class, InviteFriendsDriverCardDelegate.class, InviteFriendsPassengerCardDelegate.class, DriverAchievementCardDelegate.class, BottomSheetDialogView.class, InviteFriendsSlidableDialogView.class})
public class InvitesModule
{
  @Provides
  @Singleton
  InviteDispatcher provideInviteDispatcher(ActivityController paramActivityController, SocialIntentProvider paramSocialIntentProvider, DialogFlow paramDialogFlow)
  {
    return new InviteDispatcher(paramActivityController, paramSocialIntentProvider, paramDialogFlow);
  }
  
  @Provides
  @Singleton
  InviteService provideInviteService(ILyftApi paramILyftApi)
  {
    return new InviteService(paramILyftApi);
  }
  
  @Provides
  @Singleton
  ReferralTrackingService provideReferralTrackingService()
  {
    return new ReferralTrackingService();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.invites.InvitesModule
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */