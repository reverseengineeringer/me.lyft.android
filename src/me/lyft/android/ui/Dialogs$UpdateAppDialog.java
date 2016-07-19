package me.lyft.android.ui;

import com.lyft.scoop.Layout;
import me.lyft.android.common.SingleInstance;

@Layout(2130903491)
@SingleInstance
public class Dialogs$UpdateAppDialog
  extends Dialogs
{
  String message;
  
  public Dialogs$UpdateAppDialog(String paramString)
  {
    message = paramString;
  }
  
  public String getMessage()
  {
    return message;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.Dialogs.UpdateAppDialog
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */