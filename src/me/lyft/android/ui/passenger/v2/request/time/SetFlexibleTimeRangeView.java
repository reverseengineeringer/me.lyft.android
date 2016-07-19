package me.lyft.android.ui.passenger.v2.request.time;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.ButterKnife;
import com.lyft.scoop.HandleBack;
import com.lyft.scoop.dagger.DaggerInjector;
import javax.inject.Inject;
import me.lyft.android.controls.CustomPicker;
import me.lyft.android.domain.time.Time;
import me.lyft.android.ui.HeightObservableLayout;
import rx.Observable;

public class SetFlexibleTimeRangeView
  extends LinearLayout
  implements HandleBack, SetFlexibleTimeRangePresenter.View
{
  ImageButton backButton;
  HeightObservableLayout containerBottom;
  HeightObservableLayout containerTop;
  TextView dateLabel;
  View loadingTimesProgressbar;
  View pickupLabel;
  @Inject
  SetFlexibleTimeRangePresenter presenter;
  Button setTimeButton;
  CustomPicker timePicker;
  
  public SetFlexibleTimeRangeView(Context paramContext, AttributeSet paramAttributeSet)
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
    pickupLabel.setVisibility(0);
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
  
  public String getPickupPinLabel(Time paramTime)
  {
    return getContext().getString(2131166136, new Object[] { paramTime.formatDay() });
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
    backButton.setOnClickListener(new SetFlexibleTimeRangeView.1(this));
    setTimeButton.setOnClickListener(new SetFlexibleTimeRangeView.2(this));
    timePicker.setOnValueChangedListener(new SetFlexibleTimeRangeView.3(this));
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
 * Qualified Name:     me.lyft.android.ui.passenger.v2.request.time.SetFlexibleTimeRangeView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */