package com.braintreepayments.cardform.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.EditText;
import com.braintreepayments.cardform.R.drawable;

public class ErrorEditText
  extends EditText
{
  private boolean mError = false;
  
  public ErrorEditText(Context paramContext)
  {
    super(paramContext);
  }
  
  public ErrorEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ErrorEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void setBackground(int paramInt)
  {
    int i = getPaddingBottom();
    int j = getPaddingLeft();
    int k = getPaddingRight();
    int m = getPaddingTop();
    setBackgroundResource(paramInt);
    setPadding(j, m, k, i);
  }
  
  public void clearError()
  {
    mError = false;
    setBackground(R.drawable.bt_field_selector);
  }
  
  public boolean isError()
  {
    return mError;
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    super.onTextChanged(paramCharSequence, paramInt1, paramInt2, paramInt3);
    clearError();
  }
  
  public void setError()
  {
    mError = true;
    setBackground(R.drawable.bt_field_error_selector);
  }
}

/* Location:
 * Qualified Name:     com.braintreepayments.cardform.view.ErrorEditText
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */