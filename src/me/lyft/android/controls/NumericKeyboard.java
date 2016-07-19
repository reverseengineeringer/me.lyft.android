package me.lyft.android.controls;

import android.content.Context;
import android.os.Vibrator;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.widget.FrameLayout;
import butterknife.ButterKnife;
import com.lyft.widgets.IKeyboardButton;
import com.lyft.widgets.KeyboardImageButton;
import me.lyft.android.utils.Keyboard;
import rx.functions.Action1;

public class NumericKeyboard
  extends FrameLayout
{
  KeyboardImageButton delButton;
  private KeyPressListener listener = new SimpleKeyPressListener();
  private final Action1<KeyEvent> onKeyboardClicked = new Action1()
  {
    public void call(KeyEvent paramAnonymousKeyEvent)
    {
      listener.onKeyPressed(paramAnonymousKeyEvent);
    }
  };
  private Vibrator vibrator;
  
  public NumericKeyboard(Context paramContext)
  {
    super(paramContext);
  }
  
  public NumericKeyboard(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public NumericKeyboard(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void initNumericButton(View paramView, int paramInt1, int paramInt2)
  {
    paramView = (IKeyboardButton)ButterKnife.findById(paramView, paramInt1);
    paramView.setButtonId(Integer.valueOf(paramInt2 + 7));
    paramView.setClickAction(onKeyboardClicked);
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (isInEditMode()) {
      return;
    }
    Keyboard.hideOnStart(this);
  }
  
  protected void onDetachedFromWindow()
  {
    Keyboard.showOnStart(this);
    super.onDetachedFromWindow();
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    View localView = LayoutInflater.from(getContext()).inflate(2130903262, this, true);
    if (isInEditMode()) {
      return;
    }
    ButterKnife.bind(this);
    initNumericButton(localView, 2131559249, 0);
    initNumericButton(localView, 2131559239, 1);
    initNumericButton(localView, 2131559240, 2);
    initNumericButton(localView, 2131559241, 3);
    initNumericButton(localView, 2131559242, 4);
    initNumericButton(localView, 2131559243, 5);
    initNumericButton(localView, 2131559244, 6);
    initNumericButton(localView, 2131559245, 7);
    initNumericButton(localView, 2131559246, 8);
    initNumericButton(localView, 2131559247, 9);
    delButton.setButtonId(Integer.valueOf(67));
    delButton.setClickAction(onKeyboardClicked);
    delButton.setOnLongClickListener(new View.OnLongClickListener()
    {
      public boolean onLongClick(View paramAnonymousView)
      {
        vibrator.vibrate(50L);
        listener.onDelLongPressed();
        return false;
      }
    });
    vibrator = ((Vibrator)getContext().getSystemService("vibrator"));
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    int[] arrayOfInt = new int[10];
    int[] tmp8_6 = arrayOfInt;
    tmp8_6[0] = 2131559249;
    int[] tmp13_8 = tmp8_6;
    tmp13_8[1] = 2131559239;
    int[] tmp18_13 = tmp13_8;
    tmp18_13[2] = 2131559240;
    int[] tmp23_18 = tmp18_13;
    tmp23_18[3] = 2131559241;
    int[] tmp28_23 = tmp23_18;
    tmp28_23[4] = 2131559242;
    int[] tmp33_28 = tmp28_23;
    tmp33_28[5] = 2131559243;
    int[] tmp38_33 = tmp33_28;
    tmp38_33[6] = 2131559244;
    int[] tmp44_38 = tmp38_33;
    tmp44_38[7] = 2131559245;
    int[] tmp50_44 = tmp44_38;
    tmp50_44[8] = 2131559246;
    int[] tmp56_50 = tmp50_44;
    tmp56_50[9] = 2131559247;
    tmp56_50;
    int j = arrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      findViewById(arrayOfInt[i]).setEnabled(paramBoolean);
      i += 1;
    }
    delButton.setEnabled(paramBoolean);
  }
  
  public void setKeyPressListener(KeyPressListener paramKeyPressListener)
  {
    listener = paramKeyPressListener;
  }
  
  public static abstract interface KeyPressListener
  {
    public abstract void onDelLongPressed();
    
    public abstract void onKeyPressed(KeyEvent paramKeyEvent);
  }
  
  public static class SimpleKeyPressListener
    implements NumericKeyboard.KeyPressListener
  {
    public void onDelLongPressed() {}
    
    public void onKeyPressed(KeyEvent paramKeyEvent) {}
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.controls.NumericKeyboard
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */