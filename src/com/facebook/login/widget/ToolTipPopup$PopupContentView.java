package com.facebook.login.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.facebook.R.id;
import com.facebook.R.layout;

class ToolTipPopup$PopupContentView
  extends FrameLayout
{
  private View bodyFrame;
  private ImageView bottomArrow;
  private ImageView topArrow;
  private ImageView xOut;
  
  public ToolTipPopup$PopupContentView(ToolTipPopup paramToolTipPopup, Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  private void init()
  {
    LayoutInflater.from(getContext()).inflate(R.layout.com_facebook_tooltip_bubble, this);
    topArrow = ((ImageView)findViewById(R.id.com_facebook_tooltip_bubble_view_top_pointer));
    bottomArrow = ((ImageView)findViewById(R.id.com_facebook_tooltip_bubble_view_bottom_pointer));
    bodyFrame = findViewById(R.id.com_facebook_body_frame);
    xOut = ((ImageView)findViewById(R.id.com_facebook_button_xout));
  }
  
  public void showBottomArrow()
  {
    topArrow.setVisibility(4);
    bottomArrow.setVisibility(0);
  }
  
  public void showTopArrow()
  {
    topArrow.setVisibility(0);
    bottomArrow.setVisibility(4);
  }
}

/* Location:
 * Qualified Name:     com.facebook.login.widget.ToolTipPopup.PopupContentView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */