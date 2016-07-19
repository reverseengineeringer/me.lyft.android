package me.lyft.android.ui.driver;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;
import butterknife.ButterKnife;
import com.lyft.scoop.Screen;
import com.lyft.scoop.dagger.DaggerInjector;
import com.makeramen.roundedimageview.RoundedImageView;
import com.squareup.picasso.RequestCreator;
import javax.inject.Inject;
import me.lyft.android.application.settings.ITrainingRideService;
import me.lyft.android.common.DialogFlow;
import me.lyft.android.infrastructure.location.ILocationService;
import me.lyft.android.managers.ImageLoader;
import me.lyft.android.rx.Binder;
import me.lyft.android.ui.IProgressController;
import me.lyft.android.ui.IViewErrorHandler;
import me.lyft.android.ui.dialogs.DialogContainerView;
import rx.Observable;

public class TrainingRideCompletedDialogView
  extends DialogContainerView
{
  private Binder binder;
  @Inject
  DialogFlow dialogFlow;
  Button dismissButton;
  @Inject
  ImageLoader imageLoader;
  @Inject
  ILocationService locationService;
  private String passengerPhotoUrl;
  @Inject
  IProgressController progressController;
  Button replayWalkthroughButton;
  @Inject
  ITrainingRideService trainingRideService;
  RoundedImageView userImageView;
  @Inject
  IViewErrorHandler viewErrorHandler;
  
  public TrainingRideCompletedDialogView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    DaggerInjector.fromView(this).inject(this);
    passengerPhotoUrl = ((DriverDialogs.TrainingRideCompletedDialog)Screen.fromView(this)).getPassengerPhotoUrl();
  }
  
  private void startTrainingRide()
  {
    progressController.showProgress();
    binder.bind(locationService.getLastLocation().flatMap(new TrainingRideCompletedDialogView.3(this)), new TrainingRideCompletedDialogView.4(this));
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    ButterKnife.bind(this);
    binder = Binder.attach(this);
    imageLoader.load(passengerPhotoUrl).fit().centerCrop().placeholder(2130838447).into(userImageView);
    replayWalkthroughButton.setOnClickListener(new TrainingRideCompletedDialogView.1(this));
    dismissButton.setOnClickListener(new TrainingRideCompletedDialogView.2(this));
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.driver.TrainingRideCompletedDialogView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */