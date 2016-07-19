package me.lyft.android.ui.passenger.v2.request.time;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.ButterKnife;
import com.lyft.scoop.HandleBack;
import com.lyft.scoop.dagger.DaggerInjector;
import javax.inject.Inject;
import me.lyft.android.controls.CustomPicker;
import me.lyft.android.domain.passenger.ridetypes.RequestRideType;
import me.lyft.android.domain.time.Time;
import me.lyft.android.ui.HeightObservableLayout;
import rx.Observable;

public class SetFixedTimeRangeView
  extends RelativeLayout
  implements HandleBack, SetFixedTimeRangePresenter.View
{
  View arriveByLabel;
  ImageButton backButton;
  HeightObservableLayout containerBottom;
  HeightObservableLayout containerTop;
  TextView dateLabel;
  View loadingTimesProgressbar;
  @Inject
  SetFixedTimeRangePresenter presenter;
  TextView selectPickupTimeHeaderTextView;
  TextView selectPickupTimeSubtitleTextView;
  Button setTimeButton;
  CustomPicker timePicker;
  
  public SetFixedTimeRangeView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    DaggerInjector.fromView(this).inject(this);
  }
  
  public void clearAvailableTimes()
  {
    timePicker.setVisibility(4);
  }
  
  public void displayAvailableTimes(String[] paramArrayOfString, int paramInt)
  {
    timePicker.setVisibility(0);
    timePicker.updateValues(paramArrayOfString, paramInt);
  }
  
  public void displayScheduledDay(Time paramTime)
  {
    arriveByLabel.setVisibility(0);
    dateLabel.setVisibility(0);
    dateLabel.setText(paramTime.formatDay());
  }
  
  public void enableSetTimeButton(boolean paramBoolean)
  {
    setTimeButton.setEnabled(paramBoolean);
  }
  
  public String getDestinationMarkerLabel()
  {
    return getContext().getString(2131165663);
  }
  
  public String getETALabel(Long paramLong)
  {
    Resources localResources = getResources();
    if (paramLong == null) {
      return localResources.getString(2131166258);
    }
    return localResources.getString(2131166259, new Object[] { paramLong });
  }
  
  public String getPickupPinLabel(Time paramTime)
  {
    return getContext().getString(2131166136, new Object[] { paramTime.formatDay() });
  }
  
  public String getPickupTimeHeaderText(RequestRideType paramRequestRideType)
  {
    Resources localResources = getResources();
    if (paramRequestRideType.isCarpool()) {}
    for (int i = 2131166257;; i = 2131166261) {
      return localResources.getString(i);
    }
  }
  
  public String getPickupTimeSubtitleText(RequestRideType paramRequestRideType)
  {
    Resources localResources = getResources();
    if (paramRequestRideType.isCarpool()) {}
    for (int i = 2131166256;; i = 2131166260) {
      return localResources.getString(i);
    }
  }
  
  public void hideScheduledDay()
  {
    arriveByLabel.setVisibility(8);
    dateLabel.setVisibility(8);
  }
  
  public Observable<Integer> observeBottomContainerHeight()
  {
    return containerBottom.observeHeightChange();
  }
  
  public Observable<Integer> observeTopContainerHeight()
  {
    return containerTop.observeHeightChange();
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (isInEditMode()) {
      return;
    }
    presenter.attachView(this);
  }
  
  public boolean onBack()
  {
    return presenter.onBack();
  }
  
  protected void onDetachedFromWindow()
  {
    presenter.detachView(this);
    super.onDetachedFromWindow();
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    if (isInEditMode()) {
      return;
    }
    ButterKnife.bind(this);
    backButton.setOnClickListener(new SetFixedTimeRangeView.1(this));
    setTimeButton.setOnClickListener(new SetFixedTimeRangeView.2(this));
    timePicker.setOnValueChangedListener(new SetFixedTimeRangeView.3(this));
  }
  
  public void setPickupTimeHeaderText(String paramString)
  {
    selectPickupTimeHeaderTextView.setText(paramString);
  }
  
  public void setPickupTimeSubtitleText(String paramString)
  {
    selectPickupTimeSubtitleTextView.setText(paramString);
  }
  
  public void showProgressBar(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      loadingTimesProgressbar.setVisibility(0);
      setTimeButton.setText("");
      return;
    }
    setTimeButton.setText(2131166292);
    loadingTimesProgressbar.setVisibility(4);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.passenger.v2.request.time.SetFixedTimeRangeView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */