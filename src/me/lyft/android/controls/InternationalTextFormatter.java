package me.lyft.android.controls;

import android.text.Editable;
import android.text.TextWatcher;
import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.PhoneNumberUtil.PhoneNumberFormat;
import com.google.i18n.phonenumbers.Phonenumber.PhoneNumber;
import me.lyft.android.common.PhoneUtils;
import me.lyft.android.logging.L;

public class InternationalTextFormatter
  implements TextWatcher
{
  private boolean isInAfterTextChanged;
  PhoneNumberUtil phoneNumberUtil = PhoneNumberUtil.getInstance();
  
  public void afterTextChanged(Editable paramEditable)
  {
    if (!isInAfterTextChanged) {
      isInAfterTextChanged = true;
    }
    try
    {
      Object localObject = phoneNumberUtil.parse(paramEditable.toString(), PhoneUtils.DEFAULT_REGION);
      localObject = phoneNumberUtil.format((Phonenumber.PhoneNumber)localObject, PhoneNumberUtil.PhoneNumberFormat.INTERNATIONAL);
      paramEditable.clear();
      paramEditable.append((CharSequence)localObject);
      isInAfterTextChanged = false;
      return;
    }
    catch (NumberParseException paramEditable)
    {
      for (;;)
      {
        L.e(paramEditable, "", new Object[0]);
      }
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}

/* Location:
 * Qualified Name:     me.lyft.android.controls.InternationalTextFormatter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */