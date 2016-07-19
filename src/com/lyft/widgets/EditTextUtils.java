package com.lyft.widgets;

import android.text.Editable;
import android.widget.EditText;

public class EditTextUtils
{
  @Deprecated
  public static void setTextAndMoveCursor(EditText paramEditText, String paramString)
  {
    paramEditText.setText(paramString);
    paramEditText.setSelection(paramEditText.getText().length());
  }
}

/* Location:
 * Qualified Name:     com.lyft.widgets.EditTextUtils
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */