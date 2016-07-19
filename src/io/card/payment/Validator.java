package io.card.payment;

import android.text.InputFilter;
import android.text.TextWatcher;

abstract interface Validator
  extends InputFilter, TextWatcher
{
  public abstract String getValue();
  
  public abstract boolean hasFullLength();
  
  public abstract boolean isValid();
}

/* Location:
 * Qualified Name:     io.card.payment.Validator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */