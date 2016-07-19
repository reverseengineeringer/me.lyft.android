package me.lyft.android.ui.profile;

import android.content.Context;
import android.util.AttributeSet;
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
import me.lyft.android.common.Strings;
import me.lyft.android.domain.driver.Vehicle;
import me.lyft.android.domain.passenger.ride.DriverVehicle;
import me.lyft.android.managers.ImageLoader;

public class DriverProfilePhotoCarWidgetView
  extends LinearLayout
{
  @Inject
  AppFlow appFlow;
  TextView carMakeModelTextView;
  ImageView driverPhotoImageView;
  @Inject
  ImageLoader imageLoader;
  TextView licensePlateTextView;
  TextView nameTextView;
  ImageView photoImageView;
  
  public DriverProfilePhotoCarWidgetView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    DaggerInjector.fromView(this).inject(this);
    Scoop.fromView(this).inflater(paramContext).inflate(2130903403, this, true);
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    if (isInEditMode()) {
      return;
    }
    ButterKnife.bind(this);
  }
  
  public void setCarInfo(Vehicle paramVehicle)
  {
    String str = Strings.joinWithDelimiter(" ", new String[] { paramVehicle.getColor(), paramVehicle.getMake(), paramVehicle.getModel() });
    if (paramVehicle.hasLicensePlate())
    {
      licensePlateTextView.setVisibility(0);
      licensePlateTextView.setText(paramVehicle.getLicensePlate());
    }
    carMakeModelTextView.setText(str);
    imageLoader.load(Strings.nullOrEmptyToDefault(paramVehicle.getTransparentPhoto(), paramVehicle.getPhoto())).fit().centerInside().placeholder(2130838048).into(photoImageView);
  }
  
  public void setCarInfo(DriverVehicle paramDriverVehicle)
  {
    String str = Strings.joinWithDelimiter(" ", new String[] { paramDriverVehicle.getColor(), paramDriverVehicle.getMake(), paramDriverVehicle.getModel() });
    if (paramDriverVehicle.hasLicensePlate())
    {
      licensePlateTextView.setVisibility(0);
      licensePlateTextView.setText(paramDriverVehicle.getLicensePlate());
    }
    carMakeModelTextView.setText(str);
    imageLoader.load(Strings.nullOrEmptyToDefault(paramDriverVehicle.getTransparentPhotoUrl(), paramDriverVehicle.getPhotoUrl())).fit().centerInside().placeholder(2130838048).into(photoImageView);
  }
  
  public void setUserInfo(String paramString1, String paramString2)
  {
    nameTextView.setText(paramString1);
    imageLoader.load(paramString2).fit().centerCrop().placeholder(2130838346).into(driverPhotoImageView);
    driverPhotoImageView.setOnClickListener(new DriverProfilePhotoCarWidgetView.1(this, paramString2));
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.profile.DriverProfilePhotoCarWidgetView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */