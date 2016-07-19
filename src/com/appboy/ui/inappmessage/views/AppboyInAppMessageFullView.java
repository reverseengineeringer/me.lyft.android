package com.appboy.ui.inappmessage.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.appboy.ui.R.id;
import com.facebook.drawee.drawable.ScalingUtils.ScaleType;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.ArrayList;
import java.util.List;

public class AppboyInAppMessageFullView
  extends AppboyInAppMessageImmersiveBaseView
{
  private ImageView mImageView;
  private View mSimpleDraweeView;
  
  public AppboyInAppMessageFullView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public Object getMessageBackgroundObject()
  {
    return findViewById(R.id.com_appboy_inappmessage_full);
  }
  
  public List<View> getMessageButtonViews()
  {
    ArrayList localArrayList = new ArrayList();
    if (findViewById(R.id.com_appboy_inappmessage_full_button_one) != null) {
      localArrayList.add(findViewById(R.id.com_appboy_inappmessage_full_button_one));
    }
    if (findViewById(R.id.com_appboy_inappmessage_full_button_two) != null) {
      localArrayList.add(findViewById(R.id.com_appboy_inappmessage_full_button_two));
    }
    return localArrayList;
  }
  
  public View getMessageButtonsView()
  {
    return findViewById(R.id.com_appboy_inappmessage_full_button_layout);
  }
  
  public View getMessageCloseButtonView()
  {
    return findViewById(R.id.com_appboy_inappmessage_full_close_button);
  }
  
  public TextView getMessageHeaderTextView()
  {
    return (TextView)findViewById(R.id.com_appboy_inappmessage_full_header_text);
  }
  
  public TextView getMessageIconView()
  {
    return null;
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
    return (TextView)findViewById(R.id.com_appboy_inappmessage_full_message);
  }
  
  public void inflateStubViews()
  {
    if (mCanUseFresco)
    {
      mSimpleDraweeView = getProperViewFromInflatedStub(R.id.com_appboy_inappmessage_full_drawee_stub);
      ((GenericDraweeHierarchy)((SimpleDraweeView)mSimpleDraweeView).getHierarchy()).setActualImageScaleType(ScalingUtils.ScaleType.FIT_CENTER);
      return;
    }
    mImageView = ((ImageView)getProperViewFromInflatedStub(R.id.com_appboy_inappmessage_full_imageview_stub));
    mImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
    mImageView.setAdjustViewBounds(true);
  }
}

/* Location:
 * Qualified Name:     com.appboy.ui.inappmessage.views.AppboyInAppMessageFullView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */