package com.lyft.widgets;

import android.text.Editable;
import android.text.TextWatcher;
import com.google.i18n.phonenumbers.AsYouTypeFormatter;
import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import me.lyft.android.logging.L;

public class InternationalTextWatcher
  implements TextWatcher
{
  private AsYouTypeFormatter asYouTypeFormatter;
  private boolean isInAfterTextChanged;
  
  public InternationalTextWatcher(AsYouTypeFormatter paramAsYouTypeFormatter)
  {
    asYouTypeFormatter = paramAsYouTypeFormatter;
  }
  
  private void inferFormatterFromPhoneNumber(String paramString)
  {
    PhoneNumberUtil localPhoneNumberUtil = PhoneNumberUtil.getInstance();
    try
    {
      asYouTypeFormatter = localPhoneNumberUtil.getAsYouTypeFormatter(localPhoneNumberUtil.getRegionCodeForNumber(localPhoneNumberUtil.parse(paramString, "US")));
      return;
    }
    catch (NumberParseException paramString)
    {
      L.e(paramString, "", new Object[0]);
      asYouTypeFormatter = localPhoneNumberUtil.getAsYouTypeFormatter("ZZ");
    }
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    if (asYouTypeFormatter == null) {
      inferFormatterFromPhoneNumber(paramEditable.toString());
    }
    if (!isInAfterTextChanged)
    {
      isInAfterTextChanged = true;
      if (paramEditable.length() > 0)
      {
        String str1 = "";
        String str2 = paramEditable.toString().replaceAll("[^\\d.]", "");
        int i = 0;
        while (i < str2.length())
        {
          str1 = asYouTypeFormatter.inputDigit(str2.charAt(i));
          i += 1;
        }
        paramEditable.clear();
        paramEditable.append(str1);
        asYouTypeFormatter.clear();
      }
      isInAfterTextChanged = false;
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void updateAsYouTypeFormatter(AsYouTypeFormatter paramAsYouTypeFormatter)
  {
    asYouTypeFormatter = paramAsYouTypeFormatter;
  }
}

/* Location:
 * Qualified Name:     com.lyft.widgets.InternationalTextWatcher
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */