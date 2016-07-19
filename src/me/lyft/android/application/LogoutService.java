package me.lyft.android.application;

import android.content.Context;
import java.io.File;
import me.lyft.android.ILyftPreferences;
import me.lyft.android.IUserSession;
import me.lyft.android.analytics.core.ActionAnalytics;
import me.lyft.android.analytics.studies.OnBoardingAnalytics;
import me.lyft.android.application.cleanup.ICleanupRegistry;
import me.lyft.android.application.ride.IRideRequestSession;
import me.lyft.android.common.Unit;
import me.lyft.android.domain.User;
import me.lyft.android.infrastructure.facebook.IFacebookTokenService;
import me.lyft.android.infrastructure.lyft.ILyftApi;
import me.lyft.android.rx.AsyncCall;
import me.lyft.android.utils.FileUtils;
import rx.Observable;

public class LogoutService
  implements ILogoutService
{
  private Context appContext;
  private ICleanupRegistry cleanupRegistry;
  private IFacebookTokenService facebookService;
  private ILyftApi lyftApi;
  private ILyftPreferences preferences;
  private IRideRequestSession rideRequestSession;
  private IUserProvider userProvider;
  private IUserSession userSession;
  
  public LogoutService(Context paramContext, IUserSession paramIUserSession, IRideRequestSession paramIRideRequestSession, ILyftApi paramILyftApi, ILyftPreferences paramILyftPreferences, IFacebookTokenService paramIFacebookTokenService, IUserProvider paramIUserProvider, ICleanupRegistry paramICleanupRegistry)
  {
    appContext = paramContext;
    userSession = paramIUserSession;
    rideRequestSession = paramIRideRequestSession;
    lyftApi = paramILyftApi;
    preferences = paramILyftPreferences;
    facebookService = paramIFacebookTokenService;
    userProvider = paramIUserProvider;
    cleanupRegistry = paramICleanupRegistry;
  }
  
  private void deleteFile(File paramFile)
  {
    if (paramFile != null) {
      paramFile.delete();
    }
  }
  
  private void deleteRegistrationPhotos()
  {
    deleteFile(getTemporaryPictureFile("profile_photo.jpg"));
  }
  
  private File getTemporaryPictureFile(String paramString)
  {
    return new File(FileUtils.getTempDirectoryPath(appContext), paramString);
  }
  
  private void performLogout()
  {
    facebookService.logout();
    preferences.setLyftToken(null);
    softReset();
  }
  
  private void softReset()
  {
    userSession.resetAppState();
    rideRequestSession.resetCurrentRideType();
    rideRequestSession.clearRideRequest();
    preferences.clearRideRequest();
    userProvider.updateUser(User.empty());
    preferences.clearTooltips();
    cleanupRegistry.clearAll();
    deleteRegistrationPhotos();
  }
  
  public void logout(final String paramString)
  {
    paramString = OnBoardingAnalytics.trackLogoutUser(paramString);
    User localUser = userProvider.getUser();
    lyftApi.logout(localUser.getId()).subscribe(new AsyncCall()
    {
      public void onFail(Throwable paramAnonymousThrowable)
      {
        super.onFail(paramAnonymousThrowable);
        paramString.trackFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(Unit paramAnonymousUnit)
      {
        super.onSuccess(paramAnonymousUnit);
        paramString.trackSuccess();
      }
    });
    performLogout();
  }
  
  public void resetCachedState()
  {
    softReset();
  }
  
  public void resetSignUp()
  {
    preferences.setLyftToken(null);
    userSession.resetAppState();
    userProvider.updateUser(User.empty());
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.LogoutService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */