package com.lyft.widgets;

import android.view.KeyEvent;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;

class AdvancedEditText$CustomInputConnectionWrapper
  extends InputConnectionWrapper
{
  public AdvancedEditText$CustomInputConnectionWrapper(AdvancedEditText paramAdvancedEditText, InputConnection paramInputConnection, boolean paramBoolean)
  {
    super(paramInputConnection, paramBoolean);
  }
  
  public boolean deleteSurroundingText(int paramInt1, int paramInt2)
  {
    boolean bool = super.deleteSurroundingText(paramInt1, paramInt2);
    if ((bool) && (this$0.isCursorAtStart())) {
      sendKeyEvent(new KeyEvent(0, 67));
    }
    return bool;
  }
}

/* Location:
 * Qualified Name:     com.lyft.widgets.AdvancedEditText.CustomInputConnectionWrapper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */