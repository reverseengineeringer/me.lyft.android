package com.appboy.ui.inappmessage.views;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.appboy.enums.inappmessage.ClickAction;
import com.appboy.ui.R.color;
import com.appboy.ui.R.id;
import com.facebook.drawee.drawable.ScalingUtils.ScaleType;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.view.SimpleDraweeView;

public class AppboyInAppMessageSlideupView
  extends AppboyInAppMessageBaseView
{
  private ImageView mImageView;
  private View mSimpleDraweeView;
  
  public AppboyInAppMessageSlideupView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public View getMessageBackgroundObject()
  {
    return findViewById(R.id.com_appboy_inappmessage_slideup);
  }
  
  public View getMessageChevronView()
  {
    return findViewById(R.id.com_appboy_inappmessage_slideup_chevron);
  }
  
  public TextView getMessageIconView()
  {
    return (TextView)findViewById(R.id.com_appboy_inappmessage_slideup_icon);
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
    return (TextView)findViewById(R.id.com_appboy_inappmessage_slideup_message);
  }
  
  public void inflateStubViews()
  {
    if (mCanUseFresco)
    {
      mSimpleDraweeView = getProperViewFromInflatedStub(R.id.com_appboy_inappmessage_slideup_drawee_stub);
      ((GenericDraweeHierarchy)((SimpleDraweeView)mSimpleDraweeView).getHierarchy()).setActualImageScaleType(ScalingUtils.ScaleType.FIT_CENTER);
      return;
    }
    mImageView = ((ImageView)getProperViewFromInflatedStub(R.id.com_appboy_inappmessage_slideup_imageview_stub));
  }
  
  public void setMessageChevron(int paramInt, ClickAction paramClickAction)
  {
    switch (paramClickAction)
    {
    default: 
      InAppMessageViewUtils.setViewBackgroundColorFilter(getMessageChevronView(), paramInt, getContext().getResources().getColor(R.color.com_appboy_inappmessage_chevron));
      return;
    }
    getMessageChevronView().setVisibility(8);
  }
}

/* Location:
 * Qualified Name:     com.appboy.ui.inappmessage.views.AppboyInAppMessageSlideupView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */