package com.braintreepayments.cardform.view;

import android.content.Context;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.util.AttributeSet;
import com.braintreepayments.cardform.utils.DateValidator;

public class MonthYearEditText
  extends FloatingLabelEditText
{
  private boolean mChangeWasAddition;
  
  public MonthYearEditText(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public MonthYearEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public MonthYearEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private void addDateSlash(Editable paramEditable)
  {
    if (2 <= paramEditable.length()) {
      paramEditable.setSpan(new SlashSpan(), 1, 2, 33);
    }
  }
  
  private String getString()
  {
    Editable localEditable = getText();
    if (localEditable != null) {
      return localEditable.toString();
    }
    return "";
  }
  
  private void init()
  {
    setInputType(2);
    setFilters(new InputFilter[] { new InputFilter.LengthFilter(6) });
  }
  
  private void prependLeadingZero(Editable paramEditable)
  {
    char c = paramEditable.charAt(0);
    paramEditable.replace(0, 1, "0").append(c);
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    if ((mChangeWasAddition) && (paramEditable.length() == 1) && (Character.getNumericValue(paramEditable.charAt(0)) >= 2)) {
      prependLeadingZero(paramEditable);
    }
    Object[] arrayOfObject = paramEditable.getSpans(0, paramEditable.length(), SlashSpan.class);
    int j = arrayOfObject.length;
    int i = 0;
    while (i < j)
    {
      paramEditable.removeSpan(arrayOfObject[i]);
      i += 1;
    }
    if (!mRightToLeftLanguage) {
      addDateSlash(paramEditable);
    }
    super.afterTextChanged(paramEditable);
    if (((getSelectionStart() == 4) && (!paramEditable.toString().endsWith("20"))) || (getSelectionStart() == 6)) {
      focusNext();
    }
  }
  
  public String getMonth()
  {
    if (getString().length() < 2) {
      return "";
    }
    return getString().substring(0, 2);
  }
  
  public String getYear()
  {
    String str = getString();
    if ((str.length() == 4) || (str.length() == 6)) {
      return getString().substring(2);
    }
    return "";
  }
  
  public boolean isValid()
  {
    return DateValidator.isValid(getMonth(), getYear());
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    super.onTextChanged(paramCharSequence, paramInt1, paramInt2, paramInt3);
    if (paramInt3 > paramInt2) {}
    for (boolean bool = true;; bool = false)
    {
      mChangeWasAddition = bool;
      return;
    }
  }
}

/* Location:
 * Qualified Name:     com.braintreepayments.cardform.view.MonthYearEditText
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */