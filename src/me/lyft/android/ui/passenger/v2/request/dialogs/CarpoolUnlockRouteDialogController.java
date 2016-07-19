package me.lyft.android.ui.passenger.v2.request.dialogs;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;
import javax.inject.Inject;
import me.lyft.android.ILyftPreferences;
import me.lyft.android.analytics.studies.CarpoolOnboardingAnalytics;
import me.lyft.android.application.IUserProvider;
import me.lyft.android.application.constants.Constants;
import me.lyft.android.application.constants.IConstantsProvider;
import me.lyft.android.common.DialogFlow;
import me.lyft.android.common.Strings;
import me.lyft.android.domain.User;
import me.lyft.android.infrastructure.share.IShareService;
import me.lyft.android.ui.dialogs.StandardDialogController;
import me.lyft.android.ui.onboarding.CarpoolDriverOnboardingRouter;
import me.lyft.android.utils.WebBrowser;

public class CarpoolUnlockRouteDialogController
  extends StandardDialogController
{
  private static final float GRAPHIC_BOTTOM_CROP_PERCENTAGE = 0.2F;
  private static final float GRAPHIC_TOP_CROP_PERCENTAGE = 0.05F;
  private CarpoolDriverOnboardingRouter carpoolDriverOnboardingRouter;
  private IConstantsProvider constantsProvider;
  private ILyftPreferences lyftPreferences;
  private IShareService shareService;
  private IUserProvider userProvider;
  private WebBrowser webBrowser;
  
  @Inject
  public CarpoolUnlockRouteDialogController(DialogFlow paramDialogFlow, ILyftPreferences paramILyftPreferences, IConstantsProvider paramIConstantsProvider, IShareService paramIShareService, IUserProvider paramIUserProvider, WebBrowser paramWebBrowser, CarpoolDriverOnboardingRouter paramCarpoolDriverOnboardingRouter)
  {
    super(paramDialogFlow);
    lyftPreferences = paramILyftPreferences;
    constantsProvider = paramIConstantsProvider;
    shareService = paramIShareService;
    userProvider = paramIUserProvider;
    webBrowser = paramWebBrowser;
    carpoolDriverOnboardingRouter = paramCarpoolDriverOnboardingRouter;
  }
  
  private Bitmap getCroppedGraphic()
  {
    Bitmap localBitmap = BitmapFactory.decodeResource(getResources(), 2130838079);
    int i = (int)(localBitmap.getHeight() * 0.05F);
    int j = (int)(localBitmap.getHeight() * 0.2F);
    return Bitmap.createBitmap(localBitmap, 0, i, localBitmap.getWidth(), localBitmap.getHeight() - i - j);
  }
  
  private void invite()
  {
    dismissDialog();
    CarpoolOnboardingAnalytics.trackCarpoolInviteTapped();
    String str1 = getResources().getString(2131165390);
    String str2 = (String)constantsProvider.get(Constants.CARPOOL_INVITE_TEXT);
    String str3 = lyftPreferences.getLyftWebRoot() + "/carpool";
    String str4 = (String)constantsProvider.get(Constants.CARPOOL_INVITE_REFERRAL_BASE_URL) + userProvider.getUser().getReferralCode();
    str1 = Strings.firstNonEmpty(new String[] { str2, str1 }) + " " + Strings.firstNonEmpty(new String[] { str4, str3 });
    str2 = getResources().getString(2131166324);
    shareService.sharePlainText(str2, str1);
  }
  
  private void learnMore()
  {
    dismissDialog();
    CarpoolOnboardingAnalytics.trackLearnAboutDrivingTapped();
    if (userProvider.getUser().isApprovedDriver())
    {
      webBrowser.open(lyftPreferences.getLyftWebRoot() + "/carpool/about");
      return;
    }
    carpoolDriverOnboardingRouter.goToNextOnboardingScreen();
  }
  
  public void onAttach()
  {
    super.onAttach();
    ((ImageView)addHeaderLayout(2130903236)).setImageBitmap(getCroppedGraphic());
    String str1 = getResources().getString(2131165416);
    String str2 = getResources().getString(2131165415);
    setContentTitle((String)constantsProvider.get(Constants.CARPOOL_ROUTE_UNLOCK_TITLE, str1));
    setContentMessage((CharSequence)constantsProvider.get(Constants.CARPOOL_ROUTE_UNLOCK_BODY, str2));
    addPositiveButton(2130903157, getResources().getString(2131165417), new CarpoolUnlockRouteDialogController.1(this));
    addNeutralButton(2130903153, getResources().getString(2131165418), new CarpoolUnlockRouteDialogController.2(this));
    addNegativeButton(2130903152, getResources().getString(2131165358), getDismissListener());
  }
  
  public int viewId()
  {
    return 2131558416;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.passenger.v2.request.dialogs.CarpoolUnlockRouteDialogController
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */