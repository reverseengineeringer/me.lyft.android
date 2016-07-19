package com.leanplum.messagetemplates;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.util.Log;
import com.leanplum.ActionArgs;
import com.leanplum.ActionContext;
import com.leanplum.utils.BitmapUtil;
import java.io.InputStream;

abstract class BaseMessageOptions
{
  private int acceptButtonBackgroundColor;
  private String acceptButtonText;
  private int acceptButtonTextColor;
  private int backgroundColor;
  private Bitmap backgroundImage;
  private ActionContext context;
  private int messageColor;
  private String messageText;
  private String title;
  private int titleColor;
  
  protected BaseMessageOptions(ActionContext paramActionContext)
  {
    context = paramActionContext;
    setTitle(paramActionContext.stringNamed("Title.Text"));
    setTitleColor(paramActionContext.numberNamed("Title.Color").intValue());
    setMessageText(paramActionContext.stringNamed("Message.Text"));
    setMessageColor(paramActionContext.numberNamed("Message.Color").intValue());
    InputStream localInputStream = paramActionContext.streamNamed("Background image");
    if (localInputStream != null) {}
    try
    {
      setBackgroundImage(BitmapFactory.decodeStream(localInputStream));
      setBackgroundColor(paramActionContext.numberNamed("Background color").intValue());
      setAcceptButtonText(paramActionContext.stringNamed("Accept button.Text"));
      setAcceptButtonBackgroundColor(paramActionContext.numberNamed("Accept button.Background color").intValue());
      setAcceptButtonTextColor(paramActionContext.numberNamed("Accept button.Text color").intValue());
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.e("Leanplum", "Error loading background image", localException);
      }
    }
  }
  
  private void setAcceptButtonBackgroundColor(int paramInt)
  {
    acceptButtonBackgroundColor = paramInt;
  }
  
  private void setAcceptButtonText(String paramString)
  {
    acceptButtonText = paramString;
  }
  
  private void setAcceptButtonTextColor(int paramInt)
  {
    acceptButtonTextColor = paramInt;
  }
  
  private void setBackgroundColor(int paramInt)
  {
    backgroundColor = paramInt;
  }
  
  private void setBackgroundImage(Bitmap paramBitmap)
  {
    backgroundImage = paramBitmap;
  }
  
  private void setMessageColor(int paramInt)
  {
    messageColor = paramInt;
  }
  
  private void setMessageText(String paramString)
  {
    messageText = paramString;
  }
  
  private void setTitle(String paramString)
  {
    title = paramString;
  }
  
  private void setTitleColor(int paramInt)
  {
    titleColor = paramInt;
  }
  
  public static ActionArgs toArgs(Context paramContext)
  {
    return new ActionArgs().with("Title.Text", MessageTemplates.a(paramContext)).withColor("Title.Color", -16777216).with("Message.Text", "Popup message goes here.").withColor("Message.Color", -16777216).withFile("Background image", null).withColor("Background color", -1).with("Accept button.Text", "OK").withColor("Accept button.Background color", -1).withColor("Accept button.Text color", Color.argb(255, 0, 122, 255)).withAction("Accept action", null);
  }
  
  public void accept()
  {
    context.runTrackedActionNamed("Accept action");
  }
  
  public int getAcceptButtonBackgroundColor()
  {
    return acceptButtonBackgroundColor;
  }
  
  public String getAcceptButtonText()
  {
    return acceptButtonText;
  }
  
  public int getAcceptButtonTextColor()
  {
    return acceptButtonTextColor;
  }
  
  public int getBackgroundColor()
  {
    return backgroundColor;
  }
  
  public Bitmap getBackgroundImage()
  {
    return backgroundImage;
  }
  
  public Bitmap getBackgroundImageRounded(int paramInt)
  {
    return BitmapUtil.getRoundedCornerBitmap(backgroundImage, paramInt);
  }
  
  public int getMessageColor()
  {
    return messageColor;
  }
  
  public String getMessageText()
  {
    return messageText;
  }
  
  public String getTitle()
  {
    return title;
  }
  
  public int getTitleColor()
  {
    return titleColor;
  }
}

/* Location:
 * Qualified Name:     com.leanplum.messagetemplates.BaseMessageOptions
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */