package com.lyft.widgets;

import android.content.Context;
import android.os.Vibrator;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import rx.functions.Action1;

public class KeyboardImageButton
  extends ImageView
  implements IKeyboardButton
{
  private Integer buttonId;
  private Action1<KeyEvent> listener;
  private Vibrator vibrator;
  
  public KeyboardImageButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    if (isInEditMode()) {
      return;
    }
    vibrator = ((Vibrator)getContext().getSystemService("vibrator"));
    setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        vibrator.vibrate(5L);
        listener.call(new KeyEvent(0, buttonId.intValue()));
      }
    });
  }
  
  public void setButtonId(Integer paramInteger)
  {
    buttonId = paramInteger;
  }
  
  public void setClickAction(Action1<KeyEvent> paramAction1)
  {
    listener = paramAction1;
  }
}

/* Location:
 * Qualified Name:     com.lyft.widgets.KeyboardImageButton
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */