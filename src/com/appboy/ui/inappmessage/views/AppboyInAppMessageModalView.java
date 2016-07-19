package com.appboy.ui.inappmessage.views;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.appboy.ui.R.color;
import com.appboy.ui.R.id;
import com.facebook.drawee.drawable.ScalingUtils.ScaleType;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.ArrayList;
import java.util.List;

public class AppboyInAppMessageModalView
  extends AppboyInAppMessageImmersiveBaseView
{
  private ImageView mImageView;
  private View mSimpleDraweeView;
  
  public AppboyInAppMessageModalView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public Drawable getMessageBackgroundObject()
  {
    return getMessageClickableView().getBackground();
  }
  
  public List<View> getMessageButtonViews()
  {
    ArrayList localArrayList = new ArrayList();
    if (findViewById(R.id.com_appboy_inappmessage_modal_button_one) != null) {
      localArrayList.add(findViewById(R.id.com_appboy_inappmessage_modal_button_one));
    }
    if (findViewById(R.id.com_appboy_inappmessage_modal_button_two) != null) {
      localArrayList.add(findViewById(R.id.com_appboy_inappmessage_modal_button_two));
    }
    return localArrayList;
  }
  
  public View getMessageButtonsView()
  {
    return findViewById(R.id.com_appboy_inappmessage_modal_button_layout);
  }
  
  public View getMessageClickableView()
  {
    return findViewById(R.id.com_appboy_inappmessage_modal);
  }
  
  public View getMessageCloseButtonView()
  {
    return findViewById(R.id.com_appboy_inappmessage_modal_close_button);
  }
  
  public TextView getMessageHeaderTextView()
  {
    return (TextView)findViewById(R.id.com_appboy_inappmessage_modal_header_text);
  }
  
  public TextView getMessageIconView()
  {
    return (TextView)findViewById(R.id.com_appboy_inappmessage_modal_icon);
  }
  
  public ImageView getMessageImageView()
  {
    return mImageView;
  }
  
  public View getMessageSimpleDraweeView()
  {
    return mSimpleDraweeView;
  }
  
  public TextView getMessageTextView()
  {
    return (TextView)findViewById(R.id.com_appboy_inappmessage_modal_message);
  }
  
  public View getModalFrameView()
  {
    return findViewById(R.id.com_appboy_inappmessage_modal_frame);
  }
  
  public void inflateStubViews()
  {
    if (mCanUseFresco)
    {
      mSimpleDraweeView = getProperViewFromInflatedStub(R.id.com_appboy_inappmessage_modal_drawee_stub);
      ((GenericDraweeHierarchy)((SimpleDraweeView)mSimpleDraweeView).getHierarchy()).setActualImageScaleType(ScalingUtils.ScaleType.CENTER_INSIDE);
      return;
    }
    mImageView = ((ImageView)getProperViewFromInflatedStub(R.id.com_appboy_inappmessage_modal_imageview_stub));
  }
  
  public void setMessageBackgroundColor(int paramInt)
  {
    InAppMessageViewUtils.setViewBackgroundColorFilter(findViewById(R.id.com_appboy_inappmessage_modal), paramInt, getContext().getResources().getColor(R.color.com_appboy_inappmessage_background_light));
  }
  
  public void setModalFrameColor(Integer paramInteger)
  {
    InAppMessageViewUtils.setModalFrameColor(getModalFrameView(), paramInteger);
  }
}

/* Location:
 * Qualified Name:     com.appboy.ui.inappmessage.views.AppboyInAppMessageModalView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */