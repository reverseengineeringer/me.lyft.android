package com.lyft.widgets;

import android.view.KeyEvent;
import rx.functions.Action1;

public abstract interface IKeyboardButton
{
  public abstract void setButtonId(Integer paramInteger);
  
  public abstract void setClickAction(Action1<KeyEvent> paramAction1);
}

/* Location:
 * Qualified Name:     com.lyft.widgets.IKeyboardButton
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */