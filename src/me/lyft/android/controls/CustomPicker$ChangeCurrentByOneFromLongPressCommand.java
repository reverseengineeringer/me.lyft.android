package me.lyft.android.controls;

class CustomPicker$ChangeCurrentByOneFromLongPressCommand
  implements Runnable
{
  private boolean mIncrement;
  
  CustomPicker$ChangeCurrentByOneFromLongPressCommand(CustomPicker paramCustomPicker) {}
  
  private void setStep(boolean paramBoolean)
  {
    mIncrement = paramBoolean;
  }
  
  public void run()
  {
    CustomPicker.access$900(this$0, mIncrement);
    this$0.postDelayed(this, CustomPicker.access$1000(this$0));
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.controls.CustomPicker.ChangeCurrentByOneFromLongPressCommand
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */