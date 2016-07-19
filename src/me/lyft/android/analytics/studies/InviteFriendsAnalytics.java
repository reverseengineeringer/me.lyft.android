package me.lyft.android.analytics.studies;

import me.lyft.android.analytics.core.ActionAnalytics;
import me.lyft.android.analytics.core.IntentAnalytics;
import me.lyft.android.analytics.core.SpanningAnalytics;
import me.lyft.android.analytics.core.UxAnalytics;
import me.lyft.android.analytics.core.events.ActionEvent.Action;
import me.lyft.android.analytics.core.events.IntentEvent.Intent;
import me.lyft.android.analytics.definitions.Category;
import me.lyft.android.analytics.definitions.UiElement;

public class InviteFriendsAnalytics
{
  public static final String INVITE_DEEP_LINK = "deep_link";
  private static final String INVITE_FRIENDS_PARENT = "invite_friends_screen";
  private static final String INVITE_FRIENDS_TAG = "invite_friends";
  public static final String INVITE_GIFTBOX = "giftbox";
  public static final String INVITE_GIFTBOX_OVERFLOW = "giftbox_overflow";
  public static final String INVITE_SIDEBAR = "sidebar";
  private static final String SHARE_METHOD_CLIPBOARD = "clipboard";
  private static final String SHARE_METHOD_EMAIL = "email";
  private static final String SHARE_METHOD_SMS = "sms";
  
  public static IntentAnalytics createReferralIntentAnalytics()
  {
    return new IntentAnalytics(IntentEvent.Intent.REFERRAL);
  }
  
  public static IntentAnalytics createShareInvitesIntent()
  {
    return (IntentAnalytics)new IntentAnalytics(IntentEvent.Intent.SHARE_INVITES).setTag("invite_friends");
  }
  
  public static ActionAnalytics createShowInviteFriends(String paramString)
  {
    return (ActionAnalytics)new ActionAnalytics(ActionEvent.Action.SHOW_INVITE_FRIENDS).setTag("invite_friends").setParameter(paramString);
  }
  
  public static void displayDriverInvitesButton()
  {
    UxAnalytics.displayed(UiElement.DRIVER_INVITES_BUTTON).setParent("invite_friends_screen").setTag(Category.INVITE_FRIENDS.toString()).track();
  }
  
  public static void displayPaxInvitesButton()
  {
    UxAnalytics.displayed(UiElement.PAX_INVITES_BUTTON).setParent("invite_friends_screen").setTag(Category.INVITE_FRIENDS.toString()).track();
  }
  
  public static void displayReferFriends()
  {
    UxAnalytics.displayed(UiElement.REFER_FRIENDS_SCREEN).setParent("invite_friends_screen").setTag(Category.INVITE_FRIENDS.toString()).track();
  }
  
  public static void displayShowInviteText()
  {
    UxAnalytics.displayed(UiElement.SHOW_INVITE_TEXT).setParent("invite_friends_screen").setTag(Category.INVITE_FRIENDS.toString()).track();
  }
  
  public static void tapDriverInvitesButton()
  {
    UxAnalytics.tapped(UiElement.DRIVER_INVITES_BUTTON).setParent("invite_friends_screen").track();
  }
  
  public static void tapPaxInvitesButton()
  {
    UxAnalytics.tapped(UiElement.PAX_INVITES_BUTTON).setParent("invite_friends_screen").track();
  }
  
  private static void tapReferFriends(String paramString)
  {
    UxAnalytics.tapped(UiElement.REFER_FRIENDS_SCREEN).setParent("invite_friends_screen").setParameter(paramString).track();
  }
  
  public static void tapReferFriendsDeepLink()
  {
    tapReferFriends("deep_link");
  }
  
  public static void tapReferFriendsGiftbox()
  {
    tapReferFriends("giftbox");
  }
  
  public static void tapReferFriendsGiftboxOverflow()
  {
    tapReferFriends("giftbox_overflow");
  }
  
  public static void tapReferFriendsSidebar()
  {
    tapReferFriends("sidebar");
  }
  
  public static ActionAnalytics trackCopyInviteToClipboard(int paramInt)
  {
    return trackSendInvites(paramInt, "clipboard");
  }
  
  private static void trackInviteDrivers(String paramString)
  {
    new ActionAnalytics(ActionEvent.Action.SEND_DRIVER_INVITE).setTag("invite_friends").setParameter(paramString).trackInitiation().trackSuccess();
  }
  
  public static void trackInviteDriversViaClipboard()
  {
    trackInviteDrivers("clipboard");
  }
  
  public static void trackInviteDriversViaEmail()
  {
    trackInviteDrivers("email");
  }
  
  public static void trackInviteDriversViaSMS()
  {
    trackInviteDrivers("sms");
  }
  
  private static void trackInvitePax(String paramString)
  {
    new ActionAnalytics(ActionEvent.Action.SEND_PAX_INVITE).setTag("invite_friends").setParameter(paramString).trackInitiation().trackSuccess();
  }
  
  public static void trackInvitePaxViaClipboard()
  {
    trackInvitePax("clipboard");
  }
  
  public static void trackInvitePaxViaEmail()
  {
    trackInvitePax("email");
  }
  
  public static void trackInvitePaxViaSMS()
  {
    trackInvitePax("sms");
  }
  
  public static ActionAnalytics trackSendEmailInvites(int paramInt)
  {
    return trackSendInvites(paramInt, "email");
  }
  
  public static ActionAnalytics trackSendInvites(int paramInt, String paramString)
  {
    return (ActionAnalytics)new ActionAnalytics(ActionEvent.Action.SEND_INVITES).setTag("invite_friends").setValue(paramInt).setParameter(paramString).trackInitiation();
  }
  
  public static ActionAnalytics trackSendSMSInvites(int paramInt)
  {
    return trackSendInvites(paramInt, "sms");
  }
  
  public static ActionAnalytics trackShareInvites(String paramString)
  {
    return (ActionAnalytics)new ActionAnalytics(ActionEvent.Action.SHARE_INVITES).setTag("invite_friends").setParameter(paramString).trackInitiation();
  }
  
  public static void trackShowInviteFriendsButton(String paramString)
  {
    UxAnalytics.displayed(UiElement.INVITE_FRIENDS_BUTTON).setTag("invite_friends").setParent(paramString).track();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.analytics.studies.InviteFriendsAnalytics
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */