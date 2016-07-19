package me.lyft.android.controls;

import android.view.ViewConfiguration;

class CustomPicker$PressedStateHelper
  implements Runnable
{
  public static final int BUTTON_DECREMENT = 2;
  public static final int BUTTON_INCREMENT = 1;
  private final int MODE_PRESS = 1;
  private final int MODE_TAPPED = 2;
  private int mManagedButton;
  private int mMode;
  
  CustomPicker$PressedStateHelper(CustomPicker paramCustomPicker) {}
  
  public void buttonPressDelayed(int paramInt)
  {
    cancel();
    mMode = 1;
    mManagedButton = paramInt;
    this$0.postDelayed(this, ViewConfiguration.getTapTimeout());
  }
  
  public void buttonTapped(int paramInt)
  {
    cancel();
    mMode = 2;
    mManagedButton = paramInt;
    this$0.post(this);
  }
  
  public void cancel()
  {
    mMode = 0;
    mManagedButton = 0;
    this$0.removeCallbacks(this);
    if (CustomPicker.access$500(this$0))
    {
      CustomPicker.access$502(this$0, false);
      this$0.invalidate(0, CustomPicker.access$600(this$0), this$0.getRight(), this$0.getBottom());
    }
    CustomPicker.access$702(this$0, false);
    if (CustomPicker.access$700(this$0)) {
      this$0.invalidate(0, 0, this$0.getRight(), CustomPicker.access$800(this$0));
    }
  }
  
  public void run()
  {
    switch (mMode)
    {
    default: 
      return;
    case 1: 
      switch (mManagedButton)
      {
      default: 
        return;
      case 1: 
        CustomPicker.access$502(this$0, true);
        this$0.invalidate(0, CustomPicker.access$600(this$0), this$0.getRight(), this$0.getBottom());
        return;
      }
      CustomPicker.access$702(this$0, true);
      this$0.invalidate(0, 0, this$0.getRight(), CustomPicker.access$800(this$0));
      return;
    }
    switch (mManagedButton)
    {
    default: 
      return;
    case 1: 
      if (!CustomPicker.access$500(this$0)) {
        this$0.postDelayed(this, ViewConfiguration.getPressedStateDuration());
      }
      CustomPicker.access$580(this$0, 1);
      this$0.invalidate(0, CustomPicker.access$600(this$0), this$0.getRight(), this$0.getBottom());
      return;
    }
    if (!CustomPicker.access$700(this$0)) {
      this$0.postDelayed(this, ViewConfiguration.getPressedStateDuration());
    }
    CustomPicker.access$780(this$0, 1);
    this$0.invalidate(0, 0, this$0.getRight(), CustomPicker.access$800(this$0));
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.controls.CustomPicker.PressedStateHelper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */