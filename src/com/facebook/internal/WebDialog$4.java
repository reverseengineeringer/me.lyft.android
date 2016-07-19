package com.facebook.internal;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class WebDialog$4
  implements View.OnTouchListener
{
  WebDialog$4(WebDialog paramWebDialog) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (!paramView.hasFocus()) {
      paramView.requestFocus();
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     com.facebook.internal.WebDialog.4
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */