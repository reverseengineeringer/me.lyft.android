package me.lyft.android.controls;

import android.text.Spanned;
import android.text.TextUtils;
import android.text.method.NumberKeyListener;

class CustomPicker$InputTextFilter
  extends NumberKeyListener
{
  CustomPicker$InputTextFilter(CustomPicker paramCustomPicker) {}
  
  public CharSequence filter(CharSequence paramCharSequence, int paramInt1, int paramInt2, Spanned paramSpanned, int paramInt3, int paramInt4)
  {
    CharSequence localCharSequence1;
    if (CustomPicker.access$200(this$0) == null)
    {
      CharSequence localCharSequence2 = super.filter(paramCharSequence, paramInt1, paramInt2, paramSpanned, paramInt3, paramInt4);
      localCharSequence1 = localCharSequence2;
      if (localCharSequence2 == null) {
        localCharSequence1 = paramCharSequence.subSequence(paramInt1, paramInt2);
      }
      paramCharSequence = String.valueOf(paramSpanned.subSequence(0, paramInt3)) + localCharSequence1 + paramSpanned.subSequence(paramInt4, paramSpanned.length());
      if ("".equals(paramCharSequence)) {
        return paramCharSequence;
      }
      if ((CustomPicker.access$300(this$0, paramCharSequence) > CustomPicker.access$400(this$0)) || (paramCharSequence.length() > String.valueOf(CustomPicker.access$400(this$0)).length())) {
        return "";
      }
      return localCharSequence1;
    }
    paramCharSequence = String.valueOf(paramCharSequence.subSequence(paramInt1, paramInt2));
    if (TextUtils.isEmpty(paramCharSequence)) {
      return "";
    }
    paramCharSequence = String.valueOf(String.valueOf(paramSpanned.subSequence(0, paramInt3)) + paramCharSequence + paramSpanned.subSequence(paramInt4, paramSpanned.length())).toLowerCase();
    paramSpanned = CustomPicker.access$200(this$0);
    paramInt2 = paramSpanned.length;
    paramInt1 = 0;
    while (paramInt1 < paramInt2)
    {
      localCharSequence1 = paramSpanned[paramInt1];
      if (localCharSequence1.toLowerCase().startsWith(paramCharSequence)) {
        return localCharSequence1.subSequence(paramInt3, localCharSequence1.length());
      }
      paramInt1 += 1;
    }
    return "";
  }
  
  protected char[] getAcceptedChars()
  {
    return CustomPicker.access$100();
  }
  
  public int getInputType()
  {
    return 1;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.controls.CustomPicker.InputTextFilter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */