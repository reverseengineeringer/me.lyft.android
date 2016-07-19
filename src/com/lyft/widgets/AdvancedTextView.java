package com.lyft.widgets;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.TextView;

public class AdvancedTextView
  extends TextView
  implements ViewWithErrorState
{
  private static final int[] STATE_ERROR = { R.attr.state_error };
  private final Context context;
  private int originalValidationViewColor;
  private String originalValidationViewMessage;
  private String validationErrorMessage;
  private TextView validationMessageView;
  
  public AdvancedTextView(Context paramContext)
  {
    super(paramContext);
    context = paramContext;
  }
  
  public AdvancedTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    context = paramContext;
  }
  
  public AdvancedTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    context = paramContext;
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
  
  protected void onFocusChanged(boolean paramBoolean, int paramInt, Rect paramRect)
  {
    super.onFocusChanged(paramBoolean, paramInt, paramRect);
    if (paramBoolean) {
      showValidationMessage();
    }
  }
  
  protected void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    super.onTextChanged(paramCharSequence, paramInt1, paramInt2, paramInt3);
    validationErrorMessage = null;
    showValidationMessage();
    refreshDrawableState();
  }
  
  public void setValidationErrorId(Integer paramInteger)
  {
    if (paramInteger == null)
    {
      setValidationErrorMessage(null);
      return;
    }
    setValidationErrorMessage(context.getString(paramInteger.intValue()));
  }
  
  public void setValidationErrorMessage(String paramString)
  {
    validationErrorMessage = paramString;
    if (hasFocus()) {
      showValidationMessage();
    }
    refreshDrawableState();
  }
  
  public void setValidationMessageView(TextView paramTextView)
  {
    validationMessageView = paramTextView;
    originalValidationViewMessage = paramTextView.getText().toString();
    originalValidationViewColor = paramTextView.getCurrentTextColor();
  }
  
  public void showValidationMessage()
  {
    if (validationMessageView != null)
    {
      if (validationErrorMessage != null)
      {
        validationMessageView.setText(validationErrorMessage);
        validationMessageView.setTextColor(getResources().getColor(R.color.red_1));
      }
    }
    else {
      return;
    }
    validationMessageView.setText(originalValidationViewMessage);
    validationMessageView.setTextColor(originalValidationViewColor);
  }
}

/* Location:
 * Qualified Name:     com.lyft.widgets.AdvancedTextView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */