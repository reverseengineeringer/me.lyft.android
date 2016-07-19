package me.lyft.android.ui.driver.carpool;

import android.content.res.Resources;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.lyft.scoop.Scoop;
import com.lyft.scoop.Screen;
import com.squareup.picasso.RequestCreator;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import me.lyft.android.application.ride.ICancellationOptionsProvider;
import me.lyft.android.application.ride.services.ICarpoolRideService;
import me.lyft.android.common.DialogFlow;
import me.lyft.android.domain.ride.CancellationOption;
import me.lyft.android.managers.ImageLoader;
import me.lyft.android.rx.RxUIBinder;
import me.lyft.android.ui.IViewErrorHandler;
import me.lyft.android.ui.dialogs.StandardDialogController;
import me.lyft.android.ui.driver.DriverDialogs.DeclineRideDialog;

public class DriverDeclineRideDialogController
  extends StandardDialogController
{
  private final ICancellationOptionsProvider cancellationOptionsProvider;
  private final ICarpoolRideService carpoolRideService;
  private final DialogFlow dialogFlow;
  private final ImageLoader imageLoader;
  private DriverDialogs.DeclineRideDialog params;
  private final IViewErrorHandler viewErrorHandler;
  
  @Inject
  public DriverDeclineRideDialogController(DialogFlow paramDialogFlow, ICancellationOptionsProvider paramICancellationOptionsProvider, IViewErrorHandler paramIViewErrorHandler, ImageLoader paramImageLoader, ICarpoolRideService paramICarpoolRideService)
  {
    super(paramDialogFlow);
    dialogFlow = paramDialogFlow;
    cancellationOptionsProvider = paramICancellationOptionsProvider;
    viewErrorHandler = paramIViewErrorHandler;
    imageLoader = paramImageLoader;
    carpoolRideService = paramICarpoolRideService;
  }
  
  private void addCancelReasonButton(CancellationOption paramCancellationOption)
  {
    addPositiveButton(2130903157, paramCancellationOption.getString(), new DriverDeclineRideDialogController.1(this, paramCancellationOption));
  }
  
  private void onDeclineOptionSelected(CancellationOption paramCancellationOption)
  {
    binder.bindAsyncCall(carpoolRideService.declineRides(params.getRideIds(), paramCancellationOption), new DriverDeclineRideDialogController.2(this));
  }
  
  private void setupButtons()
  {
    Iterator localIterator = cancellationOptionsProvider.getCancellationOptions().iterator();
    while (localIterator.hasNext()) {
      addCancelReasonButton((CancellationOption)localIterator.next());
    }
    addNegativeButton(2130903152, getResources().getString(2131165563), getDismissListener());
  }
  
  private void setupContent()
  {
    int i = params.getPassengerPhotoUrls().size();
    setContentTitle(getResources().getQuantityString(2131689477, i, new Object[] { Integer.valueOf(i) }));
    setContentMessage(getResources().getString(2131165536));
  }
  
  private void setupHeader()
  {
    LinearLayout localLinearLayout = (LinearLayout)addHeaderLayout(2130903166);
    Iterator localIterator = params.getPassengerPhotoUrls().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      ImageView localImageView = (ImageView)Scoop.fromView(getView()).inflate(2130903167, localLinearLayout, false);
      localLinearLayout.addView(localImageView);
      imageLoader.load(str).fit().centerCrop().placeholder(2130838447).into(localImageView);
    }
  }
  
  public void onAttach()
  {
    super.onAttach();
    params = ((DriverDialogs.DeclineRideDialog)Screen.fromController(this));
    setupContent();
    setupHeader();
    setupButtons();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.driver.carpool.DriverDeclineRideDialogController
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */