package com.lyft.widgets;

import android.text.Editable;
import android.text.TextWatcher;

public class LowerCaseTextWatcher
  implements TextWatcher
{
  boolean formatting = false;
  
  public void afterTextChanged(Editable paramEditable)
  {
    if (!formatting)
    {
      String str = paramEditable.toString().toLowerCase();
      if (!paramEditable.toString().equals(str))
      {
        formatting = true;
        paramEditable.replace(0, paramEditable.length(), str);
        formatting = false;
      }
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}

/* Location:
 * Qualified Name:     com.lyft.widgets.LowerCaseTextWatcher
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */