package me.lyft.android.controls;

import android.os.Vibrator;
import android.view.View;
import android.view.View.OnLongClickListener;

class NumericKeyboard$1
  implements View.OnLongClickListener
{
  NumericKeyboard$1(NumericKeyboard paramNumericKeyboard) {}
  
  public boolean onLongClick(View paramView)
  {
    NumericKeyboard.access$000(this$0).vibrate(50L);
    NumericKeyboard.access$100(this$0).onDelLongPressed();
    return false;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.controls.NumericKeyboard.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */