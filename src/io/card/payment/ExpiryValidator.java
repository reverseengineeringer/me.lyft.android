package io.card.payment;

import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import java.util.Date;

class ExpiryValidator
  implements Validator
{
  private final String TAG = getClass().getName();
  private boolean fullLength;
  public int month;
  public int year;
  
  public ExpiryValidator() {}
  
  public ExpiryValidator(int paramInt1, int paramInt2)
  {
    month = paramInt1;
    year = paramInt2;
    if ((month > 0) && (year > 0)) {}
    for (boolean bool = true;; bool = false)
    {
      fullLength = bool;
      if (year < 2000) {
        year += 2000;
      }
      return;
    }
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    boolean bool;
    if (paramEditable.length() >= 5)
    {
      bool = true;
      fullLength = bool;
      paramEditable = paramEditable.toString();
      if (paramEditable != null) {
        break label32;
      }
    }
    label32:
    do
    {
      do
      {
        return;
        bool = false;
        break;
        paramEditable = CreditCardNumber.getDateForString(paramEditable);
      } while (paramEditable == null);
      month = (paramEditable.getMonth() + 1);
      year = paramEditable.getYear();
    } while (year >= 1900);
    year += 1900;
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    month = 0;
    year = 0;
    fullLength = false;
  }
  
  public CharSequence filter(CharSequence paramCharSequence, int paramInt1, int paramInt2, Spanned paramSpanned, int paramInt3, int paramInt4)
  {
    paramCharSequence = new SpannableStringBuilder(paramCharSequence);
    int i = paramInt2;
    if (paramInt3 == 0)
    {
      i = paramInt2;
      if (paramCharSequence.length() > 0)
      {
        i = paramInt2;
        if ('1' < paramCharSequence.charAt(0))
        {
          i = paramInt2;
          if (paramCharSequence.charAt(0) <= '9')
          {
            paramCharSequence.insert(0, "0");
            i = paramInt2 + 1;
          }
        }
      }
    }
    int j = paramInt4 - paramInt3;
    paramInt2 = i;
    if (paramInt3 - j <= 2)
    {
      paramInt2 = i;
      if (paramInt3 + i - j >= 2)
      {
        j = 2 - paramInt3;
        if (j != i)
        {
          paramInt2 = i;
          if (j >= 0)
          {
            paramInt2 = i;
            if (j < i)
            {
              paramInt2 = i;
              if (paramCharSequence.charAt(j) == '/') {}
            }
          }
        }
        else
        {
          paramCharSequence.insert(j, "/");
          paramInt2 = i + 1;
        }
      }
    }
    paramSpanned = new SpannableStringBuilder(paramSpanned).replace(paramInt3, paramInt4, paramCharSequence, paramInt1, paramInt2).toString();
    if ((paramSpanned.length() >= 1) && ((paramSpanned.charAt(0) < '0') || ('1' < paramSpanned.charAt(0)))) {
      paramCharSequence = "";
    }
    do
    {
      return paramCharSequence;
      if (paramSpanned.length() >= 2)
      {
        if ((paramSpanned.charAt(0) != '0') && (paramSpanned.charAt(1) > '2')) {
          return "";
        }
        if ((paramSpanned.charAt(0) == '0') && (paramSpanned.charAt(1) == '0')) {
          return "";
        }
      }
    } while (paramSpanned.length() <= 5);
    return "";
  }
  
  public String getValue()
  {
    return String.format("%02d/%02d", new Object[] { Integer.valueOf(month), Integer.valueOf(year % 100) });
  }
  
  public boolean hasFullLength()
  {
    return fullLength;
  }
  
  public boolean isValid()
  {
    if ((month < 1) || (12 < month)) {}
    Date localDate;
    do
    {
      return false;
      localDate = new Date();
    } while ((year > localDate.getYear() + 1900 + 15) || ((year <= localDate.getYear() + 1900) && ((year != localDate.getYear() + 1900) || (month < localDate.getMonth() + 1))));
    return true;
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}

/* Location:
 * Qualified Name:     io.card.payment.ExpiryValidator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */