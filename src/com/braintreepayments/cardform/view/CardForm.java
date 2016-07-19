package com.braintreepayments.cardform.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.braintreepayments.cardform.OnCardFormFieldFocusedListener;
import com.braintreepayments.cardform.OnCardFormSubmitListener;
import com.braintreepayments.cardform.OnCardFormValidListener;
import com.braintreepayments.cardform.R.id;
import com.braintreepayments.cardform.R.layout;
import com.braintreepayments.cardform.R.string;
import com.braintreepayments.cardform.utils.CardType;

public class CardForm
  extends LinearLayout
  implements View.OnClickListener, View.OnFocusChangeListener, TextView.OnEditorActionListener, CardEditText.OnCardTypeChangedListener, FloatingLabelEditText.OnTextChangedListener
{
  private static final String EXTRA_CARD_NUMBER_TEXT = "com.braintreepayments.cardform.EXTRA_CARD_NUMBER_TEXT";
  private static final String EXTRA_CVV_TEXT = "com.braintreepayments.cardform.EXTRA_CVV_TEXT";
  private static final String EXTRA_EXPIRATION_TEXT = "com.braintreepayments.cardform.EXTRA_EXPIRATION_TEXT";
  private static final String EXTRA_POSTAL_CODE_TEXT = "com.braintreepayments.cardform.EXTRA_POSTAL_CODE_TEXT";
  private CardEditText mCardNumber;
  private boolean mCardNumberRequired;
  private boolean mCvvRequired;
  private CvvEditText mCvvView;
  private boolean mExpirationRequired;
  private MonthYearEditText mExpirationView;
  private OnCardFormFieldFocusedListener mOnCardFormFieldFocusedListener;
  private OnCardFormSubmitListener mOnCardFormSubmitListener;
  private OnCardFormValidListener mOnCardFormValidListener;
  private PostalCodeEditText mPostalCode;
  private boolean mPostalCodeRequired;
  private boolean mValid = false;
  
  public CardForm(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public CardForm(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  @TargetApi(11)
  public CardForm(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  @TargetApi(21)
  public CardForm(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
    init();
  }
  
  private void init()
  {
    inflate(getContext(), R.layout.bt_card_form_fields, this);
    mCardNumber = ((CardEditText)findViewById(R.id.bt_card_form_card_number));
    mExpirationView = ((MonthYearEditText)findViewById(R.id.bt_card_form_expiration));
    mCvvView = ((CvvEditText)findViewById(R.id.bt_card_form_cvv));
    mPostalCode = ((PostalCodeEditText)findViewById(R.id.bt_card_form_postal_code));
    mCardNumber.setFocusChangeListener(this);
    mExpirationView.setFocusChangeListener(this);
    mCvvView.setFocusChangeListener(this);
    mPostalCode.setFocusChangeListener(this);
    mCardNumber.setOnClickListener(this);
    mExpirationView.setOnClickListener(this);
    mCvvView.setOnClickListener(this);
    mPostalCode.setOnClickListener(this);
    mCardNumber.setOnCardTypeChangedListener(this);
    setRequiredFields(true, true, true, true, getContext().getString(R.string.bt_default_action_label));
  }
  
  private void requestEditTextFocus(EditText paramEditText)
  {
    paramEditText.requestFocus();
    ((InputMethodManager)getContext().getSystemService("input_method")).showSoftInput(paramEditText, 1);
  }
  
  private void restoreText(Bundle paramBundle, TextView paramTextView, String paramString)
  {
    if (paramBundle.containsKey(paramString)) {
      paramTextView.setText(paramBundle.getCharSequence(paramString));
    }
  }
  
  private void setIMEOptionsForLastEditTestField(EditText paramEditText, String paramString)
  {
    paramEditText.setImeOptions(2);
    paramEditText.setImeActionLabel(paramString, 2);
    paramEditText.setOnEditorActionListener(this);
  }
  
  public void closeSoftKeyboard()
  {
    ((InputMethodManager)getContext().getSystemService("input_method")).hideSoftInputFromWindow(getWindowToken(), 0);
  }
  
  public String getCardNumber()
  {
    return mCardNumber.getText().toString();
  }
  
  public String getCvv()
  {
    return mCvvView.getText().toString();
  }
  
  public String getExpirationMonth()
  {
    return mExpirationView.getMonth();
  }
  
  public String getExpirationYear()
  {
    return mExpirationView.getYear();
  }
  
  public String getPostalCode()
  {
    return mPostalCode.getText().toString();
  }
  
  public boolean isValid()
  {
    boolean bool2 = true;
    boolean bool1;
    if (mCardNumberRequired)
    {
      if ((1 != 0) && (mCardNumber.isValid())) {
        bool2 = true;
      }
    }
    else
    {
      bool1 = bool2;
      if (mExpirationRequired)
      {
        if ((!bool2) || (!mExpirationView.isValid())) {
          break label107;
        }
        bool1 = true;
      }
      label50:
      bool2 = bool1;
      if (mCvvRequired) {
        if ((!bool1) || (!mCvvView.isValid())) {
          break label112;
        }
      }
    }
    label107:
    label112:
    for (bool2 = true;; bool2 = false)
    {
      bool1 = bool2;
      if (mPostalCodeRequired)
      {
        if ((!bool2) || (!mPostalCode.isValid())) {
          break label117;
        }
        bool1 = true;
      }
      return bool1;
      bool2 = false;
      break;
      bool1 = false;
      break label50;
    }
    label117:
    return false;
  }
  
  public void onCardTypeChanged(CardType paramCardType)
  {
    mCvvView.setCardType(paramCardType);
  }
  
  public void onClick(View paramView)
  {
    if (mOnCardFormFieldFocusedListener != null) {
      mOnCardFormFieldFocusedListener.onCardFormFieldFocused(paramView);
    }
  }
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 2) && (mOnCardFormSubmitListener != null))
    {
      mOnCardFormSubmitListener.onCardFormSubmit();
      return true;
    }
    return false;
  }
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    if ((paramBoolean) && (mOnCardFormFieldFocusedListener != null)) {
      mOnCardFormFieldFocusedListener.onCardFormFieldFocused(paramView);
    }
  }
  
  public void onRestoreInstanceState(Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      restoreText(paramBundle, mCardNumber, "com.braintreepayments.cardform.EXTRA_CARD_NUMBER_TEXT");
      restoreText(paramBundle, mCvvView, "com.braintreepayments.cardform.EXTRA_CVV_TEXT");
      restoreText(paramBundle, mExpirationView, "com.braintreepayments.cardform.EXTRA_EXPIRATION_TEXT");
      restoreText(paramBundle, mPostalCode, "com.braintreepayments.cardform.EXTRA_POSTAL_CODE_TEXT");
    }
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    paramBundle.putCharSequence("com.braintreepayments.cardform.EXTRA_CARD_NUMBER_TEXT", mCardNumber.getText());
    paramBundle.putCharSequence("com.braintreepayments.cardform.EXTRA_CVV_TEXT", mCvvView.getText());
    paramBundle.putCharSequence("com.braintreepayments.cardform.EXTRA_EXPIRATION_TEXT", mExpirationView.getText());
    paramBundle.putCharSequence("com.braintreepayments.cardform.EXTRA_POSTAL_CODE_TEXT", mPostalCode.getText());
  }
  
  public void onTextChanged(Editable paramEditable)
  {
    boolean bool = isValid();
    if (mValid != bool)
    {
      mValid = bool;
      if (mOnCardFormValidListener != null) {
        mOnCardFormValidListener.onCardFormValid(bool);
      }
    }
  }
  
  public void setCardNumberError()
  {
    if (mCardNumberRequired)
    {
      mCardNumber.setError();
      requestEditTextFocus(mCardNumber);
    }
  }
  
  public void setCvvError()
  {
    if (mCvvRequired)
    {
      mCvvView.setError();
      if (((!mCardNumberRequired) && (!mExpirationRequired)) || ((!mCardNumber.isFocused()) && (!mExpirationView.isFocused()))) {
        requestEditTextFocus(mCvvView);
      }
    }
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    mCardNumber.setEnabled(paramBoolean);
    mExpirationView.setEnabled(paramBoolean);
    mCvvView.setEnabled(paramBoolean);
    mPostalCode.setEnabled(paramBoolean);
  }
  
  public void setExpirationError()
  {
    if (mExpirationRequired)
    {
      mExpirationView.setError();
      if ((!mCardNumberRequired) || (!mCardNumber.isFocused())) {
        requestEditTextFocus(mExpirationView);
      }
    }
  }
  
  public void setOnCardFormSubmitListener(OnCardFormSubmitListener paramOnCardFormSubmitListener)
  {
    mOnCardFormSubmitListener = paramOnCardFormSubmitListener;
  }
  
  public void setOnCardFormValidListener(OnCardFormValidListener paramOnCardFormValidListener)
  {
    mOnCardFormValidListener = paramOnCardFormValidListener;
  }
  
  public void setOnFormFieldFocusedListener(OnCardFormFieldFocusedListener paramOnCardFormFieldFocusedListener)
  {
    mOnCardFormFieldFocusedListener = paramOnCardFormFieldFocusedListener;
  }
  
  public void setPostalCodeError()
  {
    if (mPostalCodeRequired)
    {
      mPostalCode.setError();
      if (((!mCardNumberRequired) && (!mExpirationRequired) && (!mCvvRequired)) || ((!mCardNumber.isFocused()) && (!mExpirationView.isFocused()) && (!mCvvView.isFocused()))) {
        requestEditTextFocus(mPostalCode);
      }
    }
  }
  
  public void setRequiredFields(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, String paramString)
  {
    mCardNumberRequired = paramBoolean1;
    mExpirationRequired = paramBoolean2;
    mCvvRequired = paramBoolean3;
    mPostalCodeRequired = paramBoolean4;
    if (paramBoolean1)
    {
      mCardNumber.setTextChangedListener(this);
      if (!paramBoolean2) {
        break label131;
      }
      mExpirationView.setTextChangedListener(this);
      label45:
      if ((!paramBoolean3) && (!paramBoolean4)) {
        break label143;
      }
      mExpirationView.setImeOptions(5);
      label62:
      if (!paramBoolean3) {
        break label169;
      }
      mCvvView.setTextChangedListener(this);
      if (!paramBoolean4) {
        break label156;
      }
      mCvvView.setImeOptions(5);
      label87:
      if (!paramBoolean4) {
        break label181;
      }
      mPostalCode.setTextChangedListener(this);
      setIMEOptionsForLastEditTestField(mPostalCode, paramString);
    }
    for (;;)
    {
      mCardNumber.setOnCardTypeChangedListener(this);
      return;
      mCardNumber.setVisibility(8);
      break;
      label131:
      mExpirationView.setVisibility(8);
      break label45;
      label143:
      setIMEOptionsForLastEditTestField(mExpirationView, paramString);
      break label62;
      label156:
      setIMEOptionsForLastEditTestField(mCvvView, paramString);
      break label87;
      label169:
      mCvvView.setVisibility(8);
      break label87;
      label181:
      mPostalCode.setVisibility(8);
    }
  }
  
  public void validate()
  {
    if (mCardNumberRequired) {
      mCardNumber.validate();
    }
    if (mExpirationRequired) {
      mExpirationView.validate();
    }
    if (mCvvRequired) {
      mCvvView.validate();
    }
    if (mPostalCodeRequired) {
      mPostalCode.validate();
    }
  }
}

/* Location:
 * Qualified Name:     com.braintreepayments.cardform.view.CardForm
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */