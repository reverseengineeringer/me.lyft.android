package me.lyft.android.ui.dialogs;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.DatePicker.OnDateChangedListener;
import butterknife.ButterKnife;
import com.lyft.rx.MessageBus;
import com.lyft.scoop.Screen;
import com.lyft.scoop.dagger.DaggerInjector;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import me.lyft.android.common.DateUtils;
import me.lyft.android.ui.Dialogs.DatePickerDialog;

public class DatePickerDialogView
  extends DialogContainerView
  implements DatePicker.OnDateChangedListener
{
  @Inject
  MessageBus bus;
  DatePicker datePicker;
  Button okButton;
  Dialogs.DatePickerDialog params;
  
  public DatePickerDialogView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    DaggerInjector.fromView(this).inject(this);
    params = ((Dialogs.DatePickerDialog)Screen.fromView(this));
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    datePicker.init(params.year, params.month, params.day, this);
    if (params.disablePastDate)
    {
      Date localDate = DateUtils.createDate(params.year, params.month, params.day);
      datePicker.setMinDate(localDate.getTime() - TimeUnit.HOURS.toMillis(1L));
    }
  }
  
  public void onDateChanged(DatePicker paramDatePicker, int paramInt1, int paramInt2, int paramInt3)
  {
    datePicker.init(paramInt1, paramInt2, paramInt3, this);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    ButterKnife.bind(this);
    okButton.setOnClickListener(new DatePickerDialogView.1(this));
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.dialogs.DatePickerDialogView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */