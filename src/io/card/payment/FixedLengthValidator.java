package io.card.payment;

import android.text.Editable;
import android.text.Spanned;

class FixedLengthValidator
  implements Validator
{
  public int requiredLength;
  private String value;
  
  public FixedLengthValidator(int paramInt)
  {
    requiredLength = paramInt;
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    value = paramEditable.toString();
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public CharSequence filter(CharSequence paramCharSequence, int paramInt1, int paramInt2, Spanned paramSpanned, int paramInt3, int paramInt4)
  {
    if ((paramInt2 > 0) && (paramSpanned.length() + paramInt4 - paramInt3 + paramInt2 > requiredLength)) {
      return "";
    }
    return null;
  }
  
  public String getValue()
  {
    return value;
  }
  
  public boolean hasFullLength()
  {
    return isValid();
  }
  
  public boolean isValid()
  {
    return (value != null) && (value.length() == requiredLength);
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}

/* Location:
 * Qualified Name:     io.card.payment.FixedLengthValidator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */