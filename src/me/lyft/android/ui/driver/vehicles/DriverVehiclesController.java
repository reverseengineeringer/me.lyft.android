package me.lyft.android.ui.driver.vehicles;

import android.content.res.Resources;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import me.lyft.android.ILyftPreferences;
import me.lyft.android.application.driver.IVehicleService;
import me.lyft.android.common.RxViewController;
import me.lyft.android.controls.Toolbar;
import me.lyft.android.domain.driver.Vehicle;
import me.lyft.android.rx.RxUIBinder;
import me.lyft.android.ui.IProgressController;
import me.lyft.android.utils.WebBrowser;

public class DriverVehiclesController
  extends RxViewController
{
  Button addVehicleButton;
  @Inject
  ILyftPreferences lyftPreferences;
  @Inject
  IProgressController progressController;
  FrameLayout progressView;
  LinearLayout retryView;
  Toolbar toolbar;
  LinearLayout vehicleList;
  @Inject
  IVehicleService vehicleService;
  @Inject
  WebBrowser webBrowser;
  
  private void loadVehicles()
  {
    progressView.setVisibility(0);
    progressController.disableUI();
    binder.bindAsyncCall(vehicleService.getDriverVehicles(), new DriverVehiclesController.3(this));
  }
  
  private void refreshVehicleList(List<Vehicle> paramList, View paramView)
  {
    vehicleList.removeAllViews();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Vehicle localVehicle = (Vehicle)paramList.next();
      vehicleList.addView(new DriverVehicleListItemView(paramView.getContext(), localVehicle));
    }
  }
  
  protected int layoutId()
  {
    return 2130903201;
  }
  
  public void onAttach()
  {
    super.onAttach();
    toolbar.showTitle().setTitle(getResources().getString(2131166413));
    addVehicleButton.setOnClickListener(new DriverVehiclesController.1(this));
    retryView.setOnClickListener(new DriverVehiclesController.2(this));
    loadVehicles();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.driver.vehicles.DriverVehiclesController
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */