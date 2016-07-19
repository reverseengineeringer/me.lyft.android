package com.lyft.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;
import me.lyft.android.common.Strings;

public class FlashButton
  extends Button
{
  private static final int[] STATE_AUTO_FLASH = { R.attr.state_auto_flash };
  private static final int[] STATE_FLASH_OFF = { R.attr.state_flash_off };
  private static final int[] STATE_FLASH_ON = { R.attr.state_flash_on };
  private String flashMode;
  
  public FlashButton(Context paramContext)
  {
    super(paramContext);
  }
  
  public FlashButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public FlashButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public String getFlashMode()
  {
    if (Strings.isNullOrEmpty(flashMode)) {
      return "auto";
    }
    return flashMode;
  }
  
  protected int[] onCreateDrawableState(int paramInt)
  {
    int[] arrayOfInt = super.onCreateDrawableState(paramInt + 2);
    if (getFlashMode().equals("auto")) {
      mergeDrawableStates(arrayOfInt, STATE_AUTO_FLASH);
    }
    do
    {
      return arrayOfInt;
      if (getFlashMode().equals("on"))
      {
        mergeDrawableStates(arrayOfInt, STATE_FLASH_ON);
        return arrayOfInt;
      }
    } while (!getFlashMode().equals("off"));
    mergeDrawableStates(arrayOfInt, STATE_FLASH_OFF);
    return arrayOfInt;
  }
  
  public void setFlashMode(String paramString)
  {
    flashMode = paramString;
    refreshDrawableState();
  }
}

/* Location:
 * Qualified Name:     com.lyft.widgets.FlashButton
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */