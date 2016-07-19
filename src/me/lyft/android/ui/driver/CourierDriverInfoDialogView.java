package me.lyft.android.ui.driver;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.ImageView;
import butterknife.ButterKnife;
import com.lyft.rx.MessageBus;
import com.lyft.scoop.dagger.DaggerInjector;
import javax.inject.Inject;
import me.lyft.android.common.DialogFlow;
import me.lyft.android.ui.dialogs.DialogContainerView;

public class CourierDriverInfoDialogView
  extends DialogContainerView
{
  @Inject
  MessageBus bus;
  @Inject
  DialogFlow dialogFlow;
  ImageView infoDialogHeader;
  Button okButton;
  
  public CourierDriverInfoDialogView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    DaggerInjector.fromView(this).inject(this);
  }
  
  public int getImageResource()
  {
    return 2130838029;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    ButterKnife.bind(this);
    infoDialogHeader.setImageResource(getImageResource());
    infoDialogHeader.setBackgroundColor(getResources().getColor(2131492975));
    okButton.setOnClickListener(new CourierDriverInfoDialogView.1(this));
    setOkButtonStyle();
  }
  
  protected void setOkButtonStyle()
  {
    okButton.setTextColor(getResources().getColorStateList(2131493092));
    okButton.setBackgroundDrawable(getResources().getDrawable(2130837606));
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.driver.CourierDriverInfoDialogView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */