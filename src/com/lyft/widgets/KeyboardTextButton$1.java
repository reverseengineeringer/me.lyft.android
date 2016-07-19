package com.lyft.widgets;

import android.os.Vibrator;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import rx.functions.Action1;

class KeyboardTextButton$1
  implements View.OnClickListener
{
  KeyboardTextButton$1(KeyboardTextButton paramKeyboardTextButton) {}
  
  public void onClick(View paramView)
  {
    KeyboardTextButton.access$000(this$0).vibrate(5L);
    KeyboardTextButton.access$200(this$0).call(new KeyEvent(0, KeyboardTextButton.access$100(this$0).intValue()));
  }
}

/* Location:
 * Qualified Name:     com.lyft.widgets.KeyboardTextButton.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */