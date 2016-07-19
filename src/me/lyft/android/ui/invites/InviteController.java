package me.lyft.android.ui.invites;

import android.content.res.Resources;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewPropertyAnimator;
import android.view.animation.Interpolator;
import android.widget.AbsListView.LayoutParams;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.lyft.scoop.Screen;
import com.lyft.widgets.recyclerview.RecyclerItemClickListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import me.lyft.android.adapters.ContactSelectionManager;
import me.lyft.android.adapters.ContactsRecyclerViewAdapter;
import me.lyft.android.analytics.core.ActionAnalytics;
import me.lyft.android.analytics.core.ExperimentAnalytics;
import me.lyft.android.analytics.core.definitions.Experiment;
import me.lyft.android.analytics.studies.InviteFriendsAnalytics;
import me.lyft.android.application.IUserProvider;
import me.lyft.android.application.constants.Constants;
import me.lyft.android.application.constants.IConstantsProvider;
import me.lyft.android.application.invite.InviteService;
import me.lyft.android.application.invite.ReferralUrlBuilder;
import me.lyft.android.application.payment.ICouponService;
import me.lyft.android.common.ActivityController;
import me.lyft.android.common.DialogFlow;
import me.lyft.android.common.Objects;
import me.lyft.android.common.RxViewController;
import me.lyft.android.common.Strings;
import me.lyft.android.common.Unit;
import me.lyft.android.controls.MenuButtonToolbar;
import me.lyft.android.controls.Toolbar;
import me.lyft.android.domain.User;
import me.lyft.android.domain.contacts.UserContact;
import me.lyft.android.infrastructure.contacts.IAndroidContactsProvider;
import me.lyft.android.rx.RxUIBinder;
import me.lyft.android.ui.IProgressController;
import me.lyft.android.ui.IViewErrorHandler;
import me.lyft.android.ui.SlideMenuController;
import me.lyft.android.ui.dialogs.Toast;
import rx.functions.Action1;

public class InviteController
  extends RxViewController
{
  private static final int ANIMATION_DURATION = 250;
  private static final String EMAIL = "email";
  private static final String PHONE = "phone";
  private static final int SMS_INTENT_DELAY = 250;
  @Inject
  ActivityController activityController;
  final Interpolator animationInterpolator;
  RecyclerItemClickListener clickListener;
  @Inject
  IConstantsProvider constantsProvider;
  RecyclerView contactRecyclerView;
  ContactSelectionManager contactSelectionManager;
  LinearLayout contactsListEmptyView;
  ContactsRecyclerViewAdapter contactsRecyclerViewAdapter;
  @Inject
  ICouponService couponService;
  @Inject
  DialogFlow dialogFlow;
  final Handler handler;
  FrameLayout headerView;
  View heroContainer;
  private int heroContainerHeight;
  @Inject
  IAndroidContactsProvider infrastructureContactsProvider;
  @Inject
  InviteService inviteService;
  View invitesHeaderContainer;
  TextView invitesHeaderText;
  TextView invitesReferralCodeText;
  boolean isShowingSearch;
  final View.OnClickListener onCopyReferralCodeClicked;
  final Action1<Unit> onMeasureAction;
  private int overallYScroll;
  @Inject
  IProgressController progressController;
  @Inject
  ReferralTrackingService referralTrackingService;
  View sendInvitesButton;
  private final String separator;
  ShareItemProvider shareItemProvider;
  private ActionAnalytics showInvitesAnalytics;
  @Inject
  SlideMenuController slideMenuController;
  @Inject
  SocialIntentProvider socialIntentProvider;
  MenuButtonToolbar toolbar;
  final Action1<Integer> toolbarItemAction;
  @Inject
  IUserProvider userProvider;
  @Inject
  IViewErrorHandler viewErrorHandler;
  
  public InviteController()
  {
    if (Build.MANUFACTURER.toLowerCase().contains("samsung")) {}
    for (String str = ", ";; str = "; ")
    {
      separator = str;
      handler = new Handler(Looper.getMainLooper());
      isShowingSearch = false;
      overallYScroll = 0;
      onMeasureAction = new InviteController.10(this);
      onCopyReferralCodeClicked = new InviteController.11(this);
      toolbarItemAction = new InviteController.12(this);
      animationInterpolator = new InviteController.13(this);
      return;
    }
  }
  
  private void addHeaderView()
  {
    headerView = new FrameLayout(getView().getContext());
    headerView.setLayoutParams(new AbsListView.LayoutParams(-1, 0));
    heroContainer.setOnClickListener(onCopyReferralCodeClicked);
  }
  
  private void bindViews()
  {
    binder.bindAction(toolbar.observeItemClick(), toolbarItemAction);
    binder.bindAction(dialogFlow.observeDialogChange(), new InviteController.5(this));
    binder.bindAction(clickListener.observeClickEvents(), new InviteController.6(this));
  }
  
  private void copyReferralUrlToClipboard(String paramString)
  {
    InviteFriendsAnalytics.trackShareInvites("copy_to_clipboard").trackSuccess();
    ClipboardUtil.copyToClipboard(getView().getContext(), paramString);
    dialogFlow.show(new Toast(getResources().getString(2131165476)));
    referralTrackingService.didShare();
  }
  
  private String createPhoneList(List<UserContact> paramList)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      UserContact localUserContact = (UserContact)paramList.next();
      if (localUserContact != null)
      {
        if (localStringBuilder.length() > 0) {
          localStringBuilder.append(separator);
        }
        localStringBuilder.append(localUserContact.getPhoneNumber());
      }
    }
    return localStringBuilder.toString();
  }
  
  private void initContactsAdapter()
  {
    contactRecyclerView.setHasFixedSize(true);
    LinearLayoutManager localLinearLayoutManager = new LinearLayoutManager(getView().getContext());
    contactRecyclerView.setLayoutManager(localLinearLayoutManager);
    contactSelectionManager = new ContactSelectionManager();
    contactsRecyclerViewAdapter = new ContactsRecyclerViewAdapter(contactSelectionManager);
    contactRecyclerView.setAdapter(contactsRecyclerViewAdapter);
    contactRecyclerView.addOnScrollListener(new InviteController.1(this));
    contactRecyclerView.setOnTouchListener(new InviteController.2(this));
    clickListener = new RecyclerItemClickListener(getView().getContext());
    contactRecyclerView.addOnItemTouchListener(clickListener);
    binder.bindAction(contactSelectionManager.observeSelection(), new InviteController.3(this));
  }
  
  private void initInviteAnalytics()
  {
    Object localObject = (InvitesScreens.InviteScreen)Screen.fromController(this);
    showInvitesAnalytics = InviteFriendsAnalytics.createShowInviteFriends(((InvitesScreens.InviteScreen)localObject).getSource().getName());
    referralTrackingService.startTracking();
    localObject = ((InvitesScreens.InviteScreen)localObject).getSource();
    if (localObject != null) {
      referralTrackingService.setSource(((InvitesScreens.InviteSource)localObject).getName());
    }
  }
  
  private void initReferralHeaderText()
  {
    ExperimentAnalytics.trackExposure(Experiment.PG_LADA_GIVE_GET);
    invitesHeaderText.setText(2131166235);
    binder.bindAsyncCall(couponService.observeUserCouponInfo(), new InviteController.4(this));
  }
  
  private void initSocialIntentProvider()
  {
    shareItemProvider = new ShareItemProvider.Builder().build(getResources(), userProvider, constantsProvider);
  }
  
  private void initToolbar()
  {
    toolbar.clearItems().setTitle(getResources().getString(2131165830)).addItem(2131558459, 2130838342);
  }
  
  private HashMap<String, List<UserContact>> separateEmailAndPhoneInvites(List<UserContact> paramList)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    HashMap localHashMap = new HashMap();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      UserContact localUserContact = (UserContact)paramList.next();
      if (!Strings.isNullOrBlank(localUserContact.getEmail())) {
        localArrayList2.add(localUserContact);
      } else if (!Strings.isNullOrBlank(localUserContact.getPhoneNumber())) {
        localArrayList1.add(localUserContact);
      }
    }
    localHashMap.put("phone", localArrayList1);
    localHashMap.put("email", localArrayList2);
    return localHashMap;
  }
  
  private void styleReferralCode()
  {
    String str = userProvider.getUser().getReferralCode();
    if (!Strings.isNullOrEmpty(str)) {
      invitesReferralCodeText.setText(str);
    }
  }
  
  private void updateButtonAndTextStates()
  {
    updateButtonAndTextStates(250);
  }
  
  protected int layoutId()
  {
    return 2130903300;
  }
  
  void loadContacts()
  {
    binder.bindAsyncCall(infrastructureContactsProvider.getPhonesAndEmailsObservable(), new InviteController.9(this));
  }
  
  public void onAttach()
  {
    super.onAttach();
    initInviteAnalytics();
    initToolbar();
    initSocialIntentProvider();
    addHeaderView();
    initContactsAdapter();
    initReferralHeaderText();
    styleReferralCode();
    showInvitesAnalytics.trackInitiation();
    bindViews();
    slideMenuController.enableMenu();
    loadContacts();
  }
  
  public void onDetach()
  {
    super.onDetach();
    handler.removeCallbacksAndMessages(null);
    sendInvitesButton.animate().cancel();
    slideMenuController.disableMenu();
    referralTrackingService.completeTracking();
  }
  
  void sendInvites()
  {
    Object localObject = separateEmailAndPhoneInvites(contactSelectionManager.getSelectedContacts());
    List localList = (List)((HashMap)localObject).get("phone");
    localObject = (List)((HashMap)localObject).get("email");
    int i = localList.size();
    int j = ((List)localObject).size();
    if ((i == 0) && (j == 0)) {
      return;
    }
    ExperimentAnalytics.trackExposure(Experiment.PG_INVITE_TEXT_V2);
    InviteFriendsAnalytics.displayShowInviteText();
    ActionAnalytics localActionAnalytics1 = InviteFriendsAnalytics.trackSendEmailInvites(j);
    ActionAnalytics localActionAnalytics2 = InviteFriendsAnalytics.trackSendSMSInvites(i);
    progressController.disableUI();
    progressController.showProgress();
    binder.bindAsyncCall(inviteService.sendInvites(localList, (List)localObject, separator), new InviteController.7(this, localActionAnalytics1, localActionAnalytics2, localList, j, i));
  }
  
  void setScaleAndAlpha(View paramView, float paramFloat)
  {
    float f = paramFloat;
    if (paramFloat > 1.0D) {
      f = 1.0F;
    }
    paramView.setScaleX(f);
    paramView.setScaleY(f);
    paramView.setAlpha(f);
  }
  
  void shareWithEmail()
  {
    startActivityOrShowErrorToast(shareItemProvider.getGmailShareItem(), 2131166375);
  }
  
  void shareWithFacebook()
  {
    startActivityOrShowErrorToast(shareItemProvider.getFacebookShareItem(), 2131166374);
  }
  
  void shareWithSms()
  {
    startActivityOrShowErrorToast(shareItemProvider.getHangoutsShareItem(), 2131166376);
  }
  
  void shareWithTwitter()
  {
    startActivityOrShowErrorToast(shareItemProvider.getTwitterShareItem(), 2131166377);
  }
  
  void showBottomSheet()
  {
    dialogFlow.show(new InviteDialogs.SocialSheet());
  }
  
  void startActivityOrShowErrorToast(ShareItemProvider.ShareItem paramShareItem, int paramInt)
  {
    ActionAnalytics localActionAnalytics = InviteFriendsAnalytics.trackShareInvites(name);
    paramShareItem = socialIntentProvider.createShareIntent(paramShareItem);
    if (paramShareItem != null)
    {
      ExperimentAnalytics.trackExposure(Experiment.PG_INVITE_TEXT_V2);
      InviteFriendsAnalytics.displayShowInviteText();
      localActionAnalytics.trackSuccess();
      activityController.startActivity(paramShareItem);
      referralTrackingService.didShare();
      return;
    }
    paramShareItem = getResources().getString(paramInt);
    localActionAnalytics.trackFailure(paramShareItem);
    dialogFlow.show(new Toast(paramShareItem));
  }
  
  void startGroupSmsIntent(String paramString)
  {
    String str1 = (String)Objects.firstNonNull(constantsProvider.get(Constants.SMS_INVITE_TEXT), getResources().getString(2131165539));
    String str2 = ReferralUrlBuilder.buildUrl((String)constantsProvider.get(Constants.SMS_REFERRAL_BASE_URL), userProvider.getUser().getReferralCode());
    str1 = str1 + " " + str2;
    paramString = socialIntentProvider.createSmsIntent(paramString, str1);
    if (paramString != null) {
      activityController.startActivity(paramString);
    }
  }
  
  void startGroupSmsIntentWithDelay(String paramString, int paramInt)
  {
    handler.postDelayed(new InviteController.8(this, paramString), paramInt);
  }
  
  void updateButtonAndTextStates(int paramInt)
  {
    int i = contactSelectionManager.getSelectedCount();
    if (i > 0)
    {
      toolbar.hideItem(2131558459);
      if ((i <= 0) || (isShowingSearch)) {
        break label105;
      }
      i = 1;
      label36:
      if (i == 0) {
        break label110;
      }
    }
    label105:
    label110:
    for (float f = 0.0F;; f = sendInvitesButton.getHeight())
    {
      if (f != sendInvitesButton.getTranslationY())
      {
        sendInvitesButton.animate().cancel();
        sendInvitesButton.animate().translationY(f).setDuration(paramInt).setInterpolator(animationInterpolator).start();
      }
      return;
      toolbar.showItem(2131558459);
      break;
      i = 0;
      break label36;
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.invites.InviteController
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */