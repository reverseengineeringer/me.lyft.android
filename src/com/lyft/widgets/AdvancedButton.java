package com.lyft.widgets;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.widget.TextView;
import me.lyft.android.common.Strings;

public class AdvancedButton
  extends TextView
  implements ViewWithErrorState
{
  private static final int[] STATE_ERROR = { R.attr.state_error };
  private final Context context;
  private int originalAdvancedGreyButtonTextColor;
  private String validationErrorMessage;
  private TextView validationMessageView;
  
  public AdvancedButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    context = paramContext;
    originalAdvancedGreyButtonTextColor = getCurrentTextColor();
  }
  
  private void setValidationErrorMessage(String paramString)
  {
    validationErrorMessage = paramString;
    showValidationMessage();
    refreshDrawableState();
  }
  
  public boolean hasValidationError()
  {
    return validationErrorMessage != null;
  }
  
  protected int[] onCreateDrawableState(int paramInt)
  {
    int[] arrayOfInt = super.onCreateDrawableState(paramInt + 1);
    if (hasValidationError()) {
      mergeDrawableStates(arrayOfInt, STATE_ERROR);
    }
    return arrayOfInt;
  }
  
  public void setValidationErrorId(Integer paramInteger)
  {
    if (paramInteger == null)
    {
      setValidationErrorMessage("");
      return;
    }
    setValidationErrorMessage(context.getString(paramInteger.intValue()));
  }
  
  public void setValidationMessageView(TextView paramTextView)
  {
    validationMessageView = paramTextView;
    paramTextView = paramTextView.getText().toString().trim();
    if (!Strings.isNullOrEmpty(paramTextView)) {
      setValidationErrorMessage(paramTextView);
    }
  }
  
  public void showValidationMessage()
  {
    if ((validationMessageView != null) && (validationErrorMessage != null))
    {
      validationMessageView.setVisibility(0);
      validationMessageView.setText(validationErrorMessage);
      setTextColor(getResources().getColor(R.color.red_1));
    }
  }
}

/* Location:
 * Qualified Name:     com.lyft.widgets.AdvancedButton
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */