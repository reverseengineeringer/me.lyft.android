package me.lyft.android.utils;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.IBinder;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import java.security.InvalidParameterException;

public final class Keyboard
{
  private static InputMethodManager getInputManager(Context paramContext)
  {
    return (InputMethodManager)paramContext.getSystemService("input_method");
  }
  
  private static Window getWindow(Context paramContext)
  {
    if ((paramContext instanceof Activity)) {
      return ((Activity)paramContext).getWindow();
    }
    if ((paramContext instanceof ContextWrapper)) {
      return getWindow(((ContextWrapper)paramContext).getBaseContext());
    }
    throw new InvalidParameterException("Cannot find activity context");
  }
  
  private static void hideKeyboard(Context paramContext, IBinder paramIBinder)
  {
    getInputManager(paramContext).hideSoftInputFromWindow(paramIBinder, 0);
  }
  
  public static void hideKeyboard(View paramView)
  {
    hideKeyboard(paramView.getContext(), paramView.getWindowToken());
  }
  
  public static void hideOnStart(View paramView)
  {
    setSoftInputMode(paramView, 51);
  }
  
  private static void setSoftInputMode(View paramView, int paramInt)
  {
    getWindow(paramView.getContext()).setSoftInputMode(paramInt);
  }
  
  public static void showKeyboard(View paramView)
  {
    paramView.requestFocus();
    paramView.post(new Keyboard.1(paramView));
  }
  
  public static void showOnStart(View paramView)
  {
    setSoftInputMode(paramView, 16);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.utils.Keyboard
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */