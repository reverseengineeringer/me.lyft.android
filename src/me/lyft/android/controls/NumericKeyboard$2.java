package me.lyft.android.controls;

import android.view.KeyEvent;
import rx.functions.Action1;

class NumericKeyboard$2
  implements Action1<KeyEvent>
{
  NumericKeyboard$2(NumericKeyboard paramNumericKeyboard) {}
  
  public void call(KeyEvent paramKeyEvent)
  {
    NumericKeyboard.access$100(this$0).onKeyPressed(paramKeyEvent);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.controls.NumericKeyboard.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */