package me.lyft.android.errorhandling;

import me.lyft.android.application.ApplicationServiceException;
import me.lyft.android.application.ILogoutService;
import me.lyft.android.common.AppFlow;
import me.lyft.android.common.DialogFlow;
import me.lyft.android.common.ExceptionUtils;
import me.lyft.android.infrastructure.lyft.LyftApiException;
import me.lyft.android.logging.L;
import me.lyft.android.ui.Dialogs.UpdateAppDialog;
import me.lyft.android.ui.landing.LandingScreens.IntroductionScreen;

public class DefaultErrorHandler
  implements IDefaultErrorHandler
{
  private final AppFlow appFlow;
  private final DialogFlow dialogFlow;
  private final ILogoutService logoutService;
  
  public DefaultErrorHandler(AppFlow paramAppFlow, DialogFlow paramDialogFlow, ILogoutService paramILogoutService)
  {
    appFlow = paramAppFlow;
    dialogFlow = paramDialogFlow;
    logoutService = paramILogoutService;
  }
  
  private static void logException(Throwable paramThrowable)
  {
    boolean bool1 = ExceptionUtils.isInterruptedException(paramThrowable);
    boolean bool2 = ExceptionUtils.isNetworkException(paramThrowable);
    boolean bool3 = ExceptionUtils.isAssignableFrom(paramThrowable, new Class[] { ApplicationServiceException.class });
    if ((bool1) || (bool2) || (bool3))
    {
      L.w(paramThrowable, "handleError", new Object[0]);
      return;
    }
    L.e(paramThrowable, "handleError", new Object[0]);
  }
  
  public boolean handle(Throwable paramThrowable)
  {
    if ((paramThrowable instanceof LyftApiException))
    {
      LyftApiException localLyftApiException = (LyftApiException)paramThrowable;
      if (localLyftApiException.getStatusCode() == 401)
      {
        logoutService.logout(localLyftApiException.getReason());
        appFlow.resetTo(new LandingScreens.IntroductionScreen());
        return true;
      }
      if (localLyftApiException.getStatusCode() == 426)
      {
        paramThrowable = localLyftApiException.getLyftErrorMessage();
        dialogFlow.show(new Dialogs.UpdateAppDialog(paramThrowable));
        return true;
      }
    }
    logException(paramThrowable);
    return false;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.errorhandling.DefaultErrorHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */