package com.lyft.widgets;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View.BaseSavedState;
import android.widget.AutoCompleteTextView;
import me.lyft.android.logging.L;

public class CrashLessEditText
  extends AutoCompleteTextView
{
  public CrashLessEditText(Context paramContext)
  {
    super(paramContext);
  }
  
  public CrashLessEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public CrashLessEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  @TargetApi(21)
  public CrashLessEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
  }
  
  public Parcelable onSaveInstanceState()
  {
    try
    {
      Parcelable localParcelable = super.onSaveInstanceState();
      return localParcelable;
    }
    catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
    {
      L.e(localIndexOutOfBoundsException, "Unable to save state on view with ID %s.", new Object[] { Integer.valueOf(getId()) });
    }
    return View.BaseSavedState.EMPTY_STATE;
  }
}

/* Location:
 * Qualified Name:     com.lyft.widgets.CrashLessEditText
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */