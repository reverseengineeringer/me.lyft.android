package com.lyft.widgets;

import android.os.Vibrator;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import rx.functions.Action1;

class KeyboardImageButton$1
  implements View.OnClickListener
{
  KeyboardImageButton$1(KeyboardImageButton paramKeyboardImageButton) {}
  
  public void onClick(View paramView)
  {
    KeyboardImageButton.access$000(this$0).vibrate(5L);
    KeyboardImageButton.access$200(this$0).call(new KeyEvent(0, KeyboardImageButton.access$100(this$0).intValue()));
  }
}

/* Location:
 * Qualified Name:     com.lyft.widgets.KeyboardImageButton.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */