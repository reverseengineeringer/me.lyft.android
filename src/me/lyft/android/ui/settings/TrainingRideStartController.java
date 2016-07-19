package me.lyft.android.ui.settings;

import android.content.res.Resources;
import android.widget.Button;
import javax.inject.Inject;
import me.lyft.android.application.settings.ITrainingRideService;
import me.lyft.android.common.RxViewController;
import me.lyft.android.controls.Toolbar;
import me.lyft.android.infrastructure.location.ILocationService;
import me.lyft.android.rx.RxUIBinder;
import me.lyft.android.ui.IProgressController;
import me.lyft.android.ui.IViewErrorHandler;
import me.lyft.android.ui.MainScreensRouter;
import rx.Observable;

public class TrainingRideStartController
  extends RxViewController
{
  private final ILocationService locationService;
  private final MainScreensRouter mainScreensRouter;
  private final IProgressController progressController;
  Button startPracticeRideButton;
  Toolbar toolbar;
  private final ITrainingRideService trainingRideService;
  private final IViewErrorHandler viewErrorHandler;
  
  @Inject
  public TrainingRideStartController(ITrainingRideService paramITrainingRideService, ILocationService paramILocationService, IProgressController paramIProgressController, MainScreensRouter paramMainScreensRouter, IViewErrorHandler paramIViewErrorHandler)
  {
    trainingRideService = paramITrainingRideService;
    locationService = paramILocationService;
    progressController = paramIProgressController;
    mainScreensRouter = paramMainScreensRouter;
    viewErrorHandler = paramIViewErrorHandler;
  }
  
  private void startTrainingRide()
  {
    progressController.showProgress();
    binder.bindAsyncCall(locationService.getLastLocation().flatMap(new TrainingRideStartController.2(this)), new TrainingRideStartController.3(this));
  }
  
  protected int layoutId()
  {
    return 2130903450;
  }
  
  public void onAttach()
  {
    super.onAttach();
    toolbar.setTitle(getResources().getString(2131166388));
    startPracticeRideButton.setOnClickListener(new TrainingRideStartController.1(this));
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.settings.TrainingRideStartController
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */