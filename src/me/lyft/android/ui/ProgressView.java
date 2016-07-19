package me.lyft.android.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import android.widget.TextView;
import butterknife.ButterKnife;
import me.lyft.android.common.Strings;

public class ProgressView
  extends FrameLayout
{
  TextView progressMessageTextView;
  
  public ProgressView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    ButterKnife.bind(this);
  }
  
  public void setMessage(String paramString)
  {
    if (Strings.isNullOrEmpty(paramString))
    {
      progressMessageTextView.setVisibility(8);
      return;
    }
    progressMessageTextView.setVisibility(0);
    progressMessageTextView.setText(paramString);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.ProgressView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */