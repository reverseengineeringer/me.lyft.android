package com.appboy.ui.inappmessage.views;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.appboy.support.StringUtils;
import com.appboy.ui.R.id;
import com.appboy.ui.inappmessage.IInAppMessageView;
import com.appboy.ui.support.FrescoLibraryUtils;
import com.appboy.ui.support.ViewUtils;
import com.facebook.drawee.view.SimpleDraweeView;

public abstract class AppboyInAppMessageBaseView
  extends RelativeLayout
  implements IInAppMessageView
{
  final boolean mCanUseFresco;
  
  public AppboyInAppMessageBaseView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    mCanUseFresco = FrescoLibraryUtils.canUseFresco(paramContext);
  }
  
  public abstract Object getMessageBackgroundObject();
  
  public View getMessageClickableView()
  {
    return this;
  }
  
  public abstract TextView getMessageIconView();
  
  public abstract ImageView getMessageImageView();
  
  public abstract View getMessageSimpleDraweeView();
  
  public abstract TextView getMessageTextView();
  
  View getProperViewFromInflatedStub(int paramInt)
  {
    ((ViewStub)findViewById(paramInt)).inflate();
    if (mCanUseFresco) {
      return findViewById(R.id.com_appboy_stubbed_inappmessage_drawee_view);
    }
    return findViewById(R.id.com_appboy_stubbed_inappmessage_image_view);
  }
  
  @Deprecated
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
    Object localObject;
    RelativeLayout localRelativeLayout;
    if (mCanUseFresco)
    {
      localObject = getMessageSimpleDraweeView();
      localRelativeLayout = (RelativeLayout)findViewById(R.id.com_appboy_stubbed_inappmessage_drawee_view_parent);
      if (localObject != null)
      {
        if (paramBoolean) {
          break label93;
        }
        ViewUtils.removeViewFromParent((View)localObject);
        if (localRelativeLayout != null) {
          ViewUtils.removeViewFromParent(localRelativeLayout);
        }
      }
    }
    for (;;)
    {
      if ((getMessageIconView() != null) && (StringUtils.isNullOrBlank((String)getMessageIconView().getText()))) {
        ViewUtils.removeViewFromParent(getMessageIconView());
      }
      return;
      localObject = getMessageImageView();
      localRelativeLayout = (RelativeLayout)findViewById(R.id.com_appboy_stubbed_inappmessage_image_view_parent);
      break;
      label93:
      ViewUtils.removeViewFromParent(getMessageIconView());
    }
  }
  
  public void setMessage(String paramString)
  {
    getMessageTextView().setText(paramString);
  }
  
  public void setMessageBackgroundColor(int paramInt)
  {
    InAppMessageViewUtils.setViewBackgroundColor((View)getMessageBackgroundObject(), paramInt);
  }
  
  public void setMessageIcon(String paramString, int paramInt1, int paramInt2)
  {
    InAppMessageViewUtils.setIcon(getContext(), paramString, paramInt1, paramInt2, getMessageIconView());
  }
  
  public void setMessageImageView(Bitmap paramBitmap)
  {
    InAppMessageViewUtils.setImage(paramBitmap, getMessageImageView());
  }
  
  public void setMessageSimpleDrawee(String paramString)
  {
    FrescoLibraryUtils.setDraweeControllerHelper((SimpleDraweeView)getMessageSimpleDraweeView(), paramString, 0.0F, false);
  }
  
  public void setMessageTextColor(int paramInt)
  {
    InAppMessageViewUtils.setTextViewColor(getMessageTextView(), paramInt);
  }
}

/* Location:
 * Qualified Name:     com.appboy.ui.inappmessage.views.AppboyInAppMessageBaseView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */