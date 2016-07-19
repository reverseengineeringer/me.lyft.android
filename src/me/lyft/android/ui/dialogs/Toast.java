package me.lyft.android.ui.dialogs;

import com.lyft.scoop.Controller;
import com.lyft.scoop.EnterTransition;
import com.lyft.scoop.ExitTransition;
import me.lyft.android.ui.Dialogs;

@Controller(ToastController.class)
@EnterTransition(ZoomInTransition.class)
@ExitTransition(ZoomOutTransition.class)
public class Toast
  extends Dialogs
{
  private int bottomPadding;
  private Integer icon;
  private String message;
  
  public Toast(String paramString)
  {
    message = paramString;
  }
  
  public Toast(String paramString, Integer paramInteger)
  {
    message = paramString;
    icon = paramInteger;
  }
  
  public int getBottomPadding()
  {
    return bottomPadding;
  }
  
  public Integer getIcon()
  {
    return icon;
  }
  
  public String getMessage()
  {
    return message;
  }
  
  public void setBottomPadding(int paramInt)
  {
    bottomPadding = paramInt;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.dialogs.Toast
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */