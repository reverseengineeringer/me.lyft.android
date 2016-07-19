package me.lyft.android.ui.business.onboard;

import javax.inject.Inject;
import me.lyft.android.common.RxViewController;
import me.lyft.android.controls.Toolbar;
import me.lyft.android.ui.MainScreensRouter;

public class OnboardCompletionController
  extends RxViewController
{
  private final MainScreensRouter mainScreensRouter;
  Toolbar toolbar;
  
  @Inject
  public OnboardCompletionController(MainScreensRouter paramMainScreensRouter)
  {
    mainScreensRouter = paramMainScreensRouter;
  }
  
  protected int layoutId()
  {
    return 2130903067;
  }
  
  public void onAttach()
  {
    super.onAttach();
    toolbar.hideHomeIcon();
  }
  
  void onDoneButtonClick()
  {
    mainScreensRouter.resetToHomeScreen();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.business.onboard.OnboardCompletionController
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */