package me.lyft.android.controls;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;

class FourDigitsInput$1
  implements TextWatcher
{
  FourDigitsInput$1(FourDigitsInput paramFourDigitsInput) {}
  
  public void afterTextChanged(Editable paramEditable) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    char[] arrayOfChar = paramCharSequence.toString().toCharArray();
    paramInt1 = 0;
    if (paramInt1 < this$0.textViewArray.length)
    {
      TextView localTextView = this$0.textViewArray[paramInt1];
      if (paramInt1 < arrayOfChar.length) {}
      for (paramCharSequence = String.valueOf(arrayOfChar[paramInt1]);; paramCharSequence = "")
      {
        localTextView.setText(paramCharSequence);
        paramInt1 += 1;
        break;
      }
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.controls.FourDigitsInput.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */