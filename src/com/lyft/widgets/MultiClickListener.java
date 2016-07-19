package com.lyft.widgets;

import android.content.Context;
import android.os.Vibrator;
import android.view.View;
import android.view.View.OnClickListener;

public abstract class MultiClickListener
  implements View.OnClickListener
{
  private long startTimer = 0L;
  private int tapCount = 0;
  
  private void vibrate(View paramView)
  {
    ((Vibrator)paramView.getContext().getSystemService("vibrator")).vibrate(200L);
  }
  
  public void onClick(View paramView)
  {
    long l = System.currentTimeMillis();
    if ((startTimer == 0L) || (l - startTimer > 250L)) {}
    for (tapCount = 1;; tapCount += 1)
    {
      startTimer = l;
      if (tapCount == 5)
      {
        vibrate(paramView);
        onMultiClick();
      }
      return;
    }
  }
  
  public abstract void onMultiClick();
}

/* Location:
 * Qualified Name:     com.lyft.widgets.MultiClickListener
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */