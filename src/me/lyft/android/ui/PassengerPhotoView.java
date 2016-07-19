package me.lyft.android.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.ButterKnife;
import com.lyft.scoop.Scoop;
import com.lyft.scoop.dagger.DaggerInjector;
import javax.inject.Inject;
import me.lyft.android.domain.driver.ride.DriverRidePassenger;
import me.lyft.android.flows.ProfileFlow;

public class PassengerPhotoView
  extends LinearLayout
{
  final View.OnClickListener onClickListener = new PassengerPhotoView.1(this);
  private String passengerId;
  TextView passengerName;
  UserImageView passengerPhotoImageView;
  @Inject
  ProfileFlow profileFlow;
  
  public PassengerPhotoView(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public PassengerPhotoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public PassengerPhotoView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  @TargetApi(21)
  public PassengerPhotoView(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
    init();
  }
  
  public static PassengerPhotoView forPassenger(DriverRidePassenger paramDriverRidePassenger, Context paramContext)
  {
    if (paramDriverRidePassenger.isSelf()) {}
    for (paramContext = new PassengerMyPhotoView(paramContext);; paramContext = new PassengerPhotoView(paramContext))
    {
      paramContext.setPassengerId(paramDriverRidePassenger.getId());
      paramContext.loadPhoto(paramDriverRidePassenger.getPhotoUrl());
      paramContext.setPartySize(Integer.valueOf(paramDriverRidePassenger.getPartySize()));
      paramContext.setPassengerName(paramDriverRidePassenger.getFirstName());
      return paramContext;
    }
  }
  
  private void init()
  {
    setOrientation(1);
    setGravity(17);
    DaggerInjector.fromView(this).inject(this);
    Scoop.fromView(this).inflater(getContext()).inflate(2130903313, this, true);
    ButterKnife.bind(this);
    setOnClickListener(onClickListener);
  }
  
  protected void loadPhoto(String paramString)
  {
    passengerPhotoImageView.loadPhoto(paramString);
  }
  
  protected void setPartySize(Integer paramInteger)
  {
    passengerPhotoImageView.setUserPartySize(paramInteger);
  }
  
  protected void setPassengerId(String paramString)
  {
    passengerId = paramString;
  }
  
  protected void setPassengerName(String paramString)
  {
    passengerName.setText(paramString);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.PassengerPhotoView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */