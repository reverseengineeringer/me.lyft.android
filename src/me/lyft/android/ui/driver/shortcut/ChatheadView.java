package me.lyft.android.ui.driver.shortcut;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.ButterKnife;

public class ChatheadView
  extends FrameLayout
{
  ImageView chathead;
  FrameLayout chatheadExtraContent;
  ImageView driverIconView;
  TextView primeTimeTextView;
  
  public ChatheadView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void hidePrimetime()
  {
    chathead.setVisibility(0);
    chatheadExtraContent.setVisibility(8);
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    ButterKnife.bind(this);
  }
  
  public void showDispatchable()
  {
    chatheadExtraContent.setVisibility(0);
    driverIconView.setVisibility(0);
    primeTimeTextView.setVisibility(8);
    chathead.setVisibility(8);
  }
  
  public void showPrimeTime(String paramString)
  {
    primeTimeTextView.setText(paramString);
    primeTimeTextView.setVisibility(0);
    chatheadExtraContent.setVisibility(0);
    driverIconView.setVisibility(8);
    chathead.setVisibility(8);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.driver.shortcut.ChatheadView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */