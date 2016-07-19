package com.braintreepayments.cardform.view;

import android.content.Context;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.util.AttributeSet;
import com.braintreepayments.cardform.R.drawable;
import com.braintreepayments.cardform.utils.CardType;

public class CardEditText
  extends FloatingLabelEditText
{
  private CardType mCardType = CardType.UNKNOWN;
  private OnCardTypeChangedListener mOnCardTypeChangedListener;
  
  public CardEditText(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public CardEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public CardEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private void addSpans(Editable paramEditable, int[] paramArrayOfInt)
  {
    int j = paramEditable.length();
    int k = paramArrayOfInt.length;
    int i = 0;
    while (i < k)
    {
      int m = paramArrayOfInt[i];
      if (m <= j) {
        paramEditable.setSpan(new SpaceSpan(), m - 1, m, 33);
      }
      i += 1;
    }
  }
  
  private void init()
  {
    setInputType(2);
    setCardIcon(R.drawable.bt_card_highlighted);
  }
  
  private void setCardIcon(int paramInt)
  {
    if (mRightToLeftLanguage)
    {
      setCompoundDrawablesWithIntrinsicBounds(paramInt, 0, 0, 0);
      return;
    }
    setCompoundDrawablesWithIntrinsicBounds(0, 0, paramInt, 0);
  }
  
  private void updateCardType()
  {
    CardType localCardType = CardType.forCardNumber(getText().toString());
    if (mCardType != localCardType)
    {
      mCardType = localCardType;
      setFilters(new InputFilter[] { new InputFilter.LengthFilter(mCardType.getMaxCardLength()) });
      invalidate();
      if (mOnCardTypeChangedListener != null) {
        mOnCardTypeChangedListener.onCardTypeChanged(mCardType);
      }
    }
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    Object[] arrayOfObject = paramEditable.getSpans(0, paramEditable.length(), SpaceSpan.class);
    int j = arrayOfObject.length;
    int i = 0;
    while (i < j)
    {
      paramEditable.removeSpan(arrayOfObject[i]);
      i += 1;
    }
    updateCardType();
    setCardIcon(mCardType.getFrontResource());
    if (!mRightToLeftLanguage) {
      addSpans(paramEditable, mCardType.getSpaceIndices());
    }
    super.afterTextChanged(paramEditable);
    if (mCardType.getMaxCardLength() == getSelectionStart())
    {
      validate();
      if (isValid()) {
        focusNext();
      }
    }
  }
  
  public CardType getCardType()
  {
    return mCardType;
  }
  
  public boolean isValid()
  {
    return mCardType.validate(getText().toString());
  }
  
  public void setOnCardTypeChangedListener(OnCardTypeChangedListener paramOnCardTypeChangedListener)
  {
    mOnCardTypeChangedListener = paramOnCardTypeChangedListener;
  }
  
  public static abstract interface OnCardTypeChangedListener
  {
    public abstract void onCardTypeChanged(CardType paramCardType);
  }
}

/* Location:
 * Qualified Name:     com.braintreepayments.cardform.view.CardEditText
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */