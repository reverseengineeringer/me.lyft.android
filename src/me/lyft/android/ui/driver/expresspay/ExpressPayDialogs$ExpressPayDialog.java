package me.lyft.android.ui.driver.expresspay;

import com.lyft.scoop.Layout;
import com.lyft.scoop.Screen;

@Layout(2130903227)
public class ExpressPayDialogs$ExpressPayDialog
  extends ExpressPayDialogs
{
  private String buttonText;
  private Integer icon;
  private String message;
  private boolean showCloseButton = true;
  private Screen targetScreen;
  private String textUrl;
  private String textUrlLabel;
  private String title;
  private Integer titleIcon;
  
  public ExpressPayDialogs$ExpressPayDialog() {}
  
  public ExpressPayDialogs$ExpressPayDialog(String paramString)
  {
    message = paramString;
  }
  
  public String getButtonText()
  {
    return buttonText;
  }
  
  public Integer getIcon()
  {
    return icon;
  }
  
  public String getMessage()
  {
    return message;
  }
  
  public Screen getTargetScreen()
  {
    return targetScreen;
  }
  
  public String getTextUrl()
  {
    return textUrl;
  }
  
  public String getTextUrlLabel()
  {
    return textUrlLabel;
  }
  
  public String getTitle()
  {
    return title;
  }
  
  public Integer getTitleIcon()
  {
    return titleIcon;
  }
  
  public ExpressPayDialog setButtonText(String paramString)
  {
    buttonText = paramString;
    return this;
  }
  
  public ExpressPayDialog setIcon(Integer paramInteger)
  {
    icon = paramInteger;
    return this;
  }
  
  public ExpressPayDialog setMessage(String paramString)
  {
    message = paramString;
    return this;
  }
  
  public ExpressPayDialog setShowCloseButton(boolean paramBoolean)
  {
    showCloseButton = paramBoolean;
    return this;
  }
  
  public ExpressPayDialog setTargetScreen(Screen paramScreen)
  {
    targetScreen = paramScreen;
    return this;
  }
  
  public ExpressPayDialog setTextUrl(String paramString)
  {
    textUrl = paramString;
    return this;
  }
  
  public ExpressPayDialog setTextUrlLabel(String paramString)
  {
    textUrlLabel = paramString;
    return this;
  }
  
  public ExpressPayDialog setTitle(String paramString)
  {
    title = paramString;
    return this;
  }
  
  public ExpressPayDialog setTitleIcon(Integer paramInteger)
  {
    titleIcon = paramInteger;
    return this;
  }
  
  public boolean showCloseButton()
  {
    return showCloseButton;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.driver.expresspay.ExpressPayDialogs.ExpressPayDialog
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */