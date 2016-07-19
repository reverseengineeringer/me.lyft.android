package com.braintreepayments.cardform.view;

import android.content.Context;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.util.AttributeSet;

public class PostalCodeEditText
  extends FloatingLabelEditText
{
  public PostalCodeEditText(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public PostalCodeEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public PostalCodeEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private void init()
  {
    setInputType(112);
    setFilters(new InputFilter[] { new InputFilter.LengthFilter(16) });
  }
  
  public boolean isValid()
  {
    return getText().toString().length() > 0;
  }
}

/* Location:
 * Qualified Name:     com.braintreepayments.cardform.view.PostalCodeEditText
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */