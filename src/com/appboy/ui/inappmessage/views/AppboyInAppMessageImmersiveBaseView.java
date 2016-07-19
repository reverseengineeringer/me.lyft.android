package com.appboy.ui.inappmessage.views;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.appboy.models.MessageButton;
import com.appboy.support.StringUtils;
import com.appboy.ui.R.color;
import com.appboy.ui.inappmessage.IInAppMessageImmersiveView;
import com.appboy.ui.support.ViewUtils;
import java.util.List;

public abstract class AppboyInAppMessageImmersiveBaseView
  extends AppboyInAppMessageBaseView
  implements IInAppMessageImmersiveView
{
  public AppboyInAppMessageImmersiveBaseView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public abstract List<View> getMessageButtonViews();
  
  public abstract View getMessageButtonsView();
  
  public abstract TextView getMessageHeaderTextView();
  
  public abstract TextView getMessageTextView();
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      InAppMessageViewUtils.closeInAppMessageOnKeycodeBack();
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public void resetMessageMargins()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (getMessageImageView() != null)
    {
      bool1 = bool2;
      if (getMessageImageView().getDrawable() != null) {
        bool1 = true;
      }
    }
    resetMessageMargins(bool1);
  }
  
  public void resetMessageMargins(boolean paramBoolean)
  {
    super.resetMessageMargins(paramBoolean);
    if (StringUtils.isNullOrBlank(getMessageTextView().getText().toString())) {
      ViewUtils.removeViewFromParent(getMessageTextView());
    }
    if (StringUtils.isNullOrBlank(getMessageHeaderTextView().getText().toString())) {
      ViewUtils.removeViewFromParent(getMessageHeaderTextView());
    }
    InAppMessageViewUtils.resetMessageMarginsIfNecessary(getMessageTextView(), getMessageHeaderTextView());
  }
  
  public void setMessageButtons(List<MessageButton> paramList)
  {
    View localView = getMessageButtonsView();
    int i = getContext().getResources().getColor(R.color.com_appboy_inappmessage_button_bg_light);
    InAppMessageViewUtils.setButtons(getMessageButtonViews(), localView, i, paramList);
    InAppMessageViewUtils.resetButtonSizesIfNecessary(getMessageButtonViews(), paramList);
  }
  
  public void setMessageCloseButtonColor(int paramInt)
  {
    InAppMessageViewUtils.setViewBackgroundColorFilter(getMessageCloseButtonView(), paramInt, getContext().getResources().getColor(R.color.com_appboy_inappmessage_button_close_light));
  }
  
  public void setMessageHeaderText(String paramString)
  {
    getMessageHeaderTextView().setText(paramString);
  }
  
  public void setMessageHeaderTextColor(int paramInt)
  {
    InAppMessageViewUtils.setTextViewColor(getMessageHeaderTextView(), paramInt);
  }
}

/* Location:
 * Qualified Name:     com.appboy.ui.inappmessage.views.AppboyInAppMessageImmersiveBaseView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */