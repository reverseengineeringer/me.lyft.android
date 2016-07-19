package com.braintreepayments.cardform.view;

import android.content.Context;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.util.AttributeSet;
import android.view.View;
import com.braintreepayments.cardform.R.drawable;
import com.braintreepayments.cardform.utils.CardType;

public class CvvEditText
  extends FloatingLabelEditText
{
  private static final int DEFAULT_MAX_LENGTH = 3;
  private boolean mAlwaysDisplayHint = false;
  private CardType mCardType;
  
  public CvvEditText(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public CvvEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public CvvEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private int getSecurityCodeLength()
  {
    if (mCardType == null) {
      return 3;
    }
    return mCardType.getSecurityCodeLength();
  }
  
  private void init()
  {
    setInputType(2);
    setFilters(new InputFilter[] { new InputFilter.LengthFilter(3) });
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    super.afterTextChanged(paramEditable);
    if (mCardType == null) {}
    do
    {
      do
      {
        return;
      } while ((mCardType.getSecurityCodeLength() != paramEditable.length()) || (getSelectionStart() != paramEditable.length()));
      validate();
    } while (!isValid());
    focusNext();
  }
  
  public boolean isValid()
  {
    return getText().toString().length() == getSecurityCodeLength();
  }
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    super.onFocusChange(paramView, paramBoolean);
    int i = 0;
    if ((paramBoolean) || (mAlwaysDisplayHint)) {
      if (mCardType != null) {
        break label46;
      }
    }
    label46:
    for (i = R.drawable.bt_cvv_highlighted; mRightToLeftLanguage; i = mCardType.getSecurityCodeResource())
    {
      setCompoundDrawablesWithIntrinsicBounds(i, 0, 0, 0);
      return;
    }
    setCompoundDrawablesWithIntrinsicBounds(0, 0, i, 0);
  }
  
  public void setAlwaysDisplayHint(boolean paramBoolean)
  {
    mAlwaysDisplayHint = paramBoolean;
    invalidate();
  }
  
  public void setCardType(CardType paramCardType)
  {
    mCardType = paramCardType;
    setFilters(new InputFilter[] { new InputFilter.LengthFilter(paramCardType.getSecurityCodeLength()) });
    invalidate();
  }
}

/* Location:
 * Qualified Name:     com.braintreepayments.cardform.view.CvvEditText
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */