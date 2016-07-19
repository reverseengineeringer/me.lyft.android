package me.lyft.android.ui.driver.vehicles;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.ButterKnife;
import com.lyft.scoop.Scoop;
import com.lyft.scoop.dagger.DaggerInjector;
import com.squareup.picasso.RequestCreator;
import javax.inject.Inject;
import me.lyft.android.common.AppFlow;
import me.lyft.android.domain.driver.Vehicle;
import me.lyft.android.domain.driver.Vehicle.Status;
import me.lyft.android.managers.ImageLoader;
import me.lyft.android.ui.settings.SettingsScreens.CarScreen;

public class DriverVehicleListItemView
  extends LinearLayout
{
  @Inject
  AppFlow appFlow;
  @Inject
  ImageLoader imageLoader;
  TextView licensePlate;
  private final Vehicle vehicle;
  TextView vehicleDisplayName;
  ImageView vehicleImageView;
  TextView vehicleStatus;
  
  public DriverVehicleListItemView(Context paramContext, Vehicle paramVehicle)
  {
    super(paramContext);
    DaggerInjector.fromView(this).inject(this);
    paramContext = Scoop.fromView(this).inflater(paramContext).inflate(2130903200, this, true);
    setClickable(true);
    vehicle = paramVehicle;
    ButterKnife.bind(this, paramContext);
  }
  
  private void setVehicleStatus()
  {
    Vehicle.Status localStatus = vehicle.getStatus();
    switch (DriverVehicleListItemView.1.$SwitchMap$me$lyft$android$domain$driver$Vehicle$Status[localStatus.ordinal()])
    {
    default: 
      return;
    case 1: 
      vehicleStatus.setVisibility(0);
      vehicleStatus.setText(localStatus.getName());
      vehicleStatus.setBackgroundDrawable(getResources().getDrawable(2130837587));
      return;
    case 2: 
      vehicleStatus.setVisibility(0);
      vehicleStatus.setText(localStatus.getName());
      vehicleStatus.setBackgroundDrawable(getResources().getDrawable(2130838498));
    }
    vehicleStatus.setVisibility(0);
    vehicleStatus.setText(localStatus.getName());
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    vehicleDisplayName.setText(vehicle.getDisplayName());
    licensePlate.setText(vehicle.getLicensePlate());
    setVehicleStatus();
    imageLoader.load(vehicle.getPhoto()).fit().placeholder(2130838162).into(vehicleImageView);
  }
  
  public boolean performClick()
  {
    appFlow.goTo(new SettingsScreens.CarScreen(vehicle));
    return true;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.driver.vehicles.DriverVehicleListItemView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */