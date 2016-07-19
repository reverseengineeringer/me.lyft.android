package me.lyft.android.ui;

import com.appboy.models.IInAppMessage;
import com.appboy.models.InAppMessageImmersiveBase;
import com.appboy.models.MessageButton;
import com.lyft.scoop.Layout;
import java.util.ArrayList;
import java.util.List;

@Layout(2130903140)
public class AppboyScreens$AppBoyInappDialog
  extends Dialogs
{
  private static final String EMPTY_STRING = "";
  private IInAppMessage appboyMessage;
  
  public AppboyScreens$AppBoyInappDialog(IInAppMessage paramIInAppMessage)
  {
    appboyMessage = paramIInAppMessage;
  }
  
  public IInAppMessage getAppboyMessage()
  {
    return appboyMessage;
  }
  
  public int getBackgroundColor()
  {
    return appboyMessage.getBackgroundColor();
  }
  
  public List<MessageButton> getButtons()
  {
    ArrayList localArrayList = new ArrayList();
    if ((appboyMessage instanceof InAppMessageImmersiveBase))
    {
      List localList = ((InAppMessageImmersiveBase)appboyMessage).getMessageButtons();
      if (localList != null) {
        return localList;
      }
    }
    return localArrayList;
  }
  
  public String getHeader()
  {
    if ((appboyMessage instanceof InAppMessageImmersiveBase)) {
      return ((InAppMessageImmersiveBase)appboyMessage).getHeader();
    }
    return "";
  }
  
  public int getTitleColor()
  {
    if ((appboyMessage instanceof InAppMessageImmersiveBase)) {
      return ((InAppMessageImmersiveBase)appboyMessage).getHeaderTextColor();
    }
    return 2131493083;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.AppboyScreens.AppBoyInappDialog
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */