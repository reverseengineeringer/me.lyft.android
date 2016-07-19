package me.lyft.android.controls;

import android.content.Context;
import android.os.IBinder;
import android.text.Editable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.inputmethod.InputMethodManager;
import com.lyft.widgets.AdvancedEditText;

public class KeyboardlessEditText
  extends AdvancedEditText
  implements NumericKeyboard.KeyPressListener
{
  private final InputMethodManager inputMethodManager;
  private boolean keyboardEnabled = false;
  
  public KeyboardlessEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    inputMethodManager = ((InputMethodManager)paramContext.getSystemService("input_method"));
  }
  
  private void hideKeyboard()
  {
    IBinder localIBinder = getApplicationWindowToken();
    if ((inputMethodManager != null) && (localIBinder != null)) {
      inputMethodManager.hideSoftInputFromWindow(localIBinder, 0);
    }
  }
  
  public void disableKeyboard()
  {
    keyboardEnabled = false;
  }
  
  public void enableKeyboard()
  {
    keyboardEnabled = true;
  }
  
  public void onDelLongPressed()
  {
    setText("");
  }
  
  public void onKeyPressed(KeyEvent paramKeyEvent)
  {
    dispatchKeyEvent(paramKeyEvent);
  }
  
  protected void onSelectionChanged(int paramInt1, int paramInt2)
  {
    if (keyboardEnabled)
    {
      super.onSelectionChanged(paramInt1, paramInt2);
      return;
    }
    hideKeyboard();
    clearComposingText();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (keyboardEnabled) {
      return super.onTouchEvent(paramMotionEvent);
    }
    boolean bool1 = hasFocus();
    boolean bool2 = super.onTouchEvent(paramMotionEvent);
    if (!bool1) {
      setSelection(getText().length());
    }
    hideKeyboard();
    return bool2;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.controls.KeyboardlessEditText
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */