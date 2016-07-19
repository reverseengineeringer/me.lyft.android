package me.lyft.android.ui;

import com.lyft.scoop.Layout;

@Layout(2130903143)
public class Dialogs$DatePickerDialog
  extends Dialogs
{
  public int day;
  public boolean disablePastDate;
  public int month;
  public int year;
  
  public Dialogs$DatePickerDialog(int paramInt1, int paramInt2, int paramInt3)
  {
    year = paramInt1;
    month = paramInt2;
    day = paramInt3;
  }
  
  public void setDisablePastDate(boolean paramBoolean)
  {
    disablePastDate = paramBoolean;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.Dialogs.DatePickerDialog
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */