package me.lyft.android.common;

import android.text.Spannable;
import android.text.SpannableStringBuilder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Spannables
{
  public static Spannable scanAndSpan(CharSequence paramCharSequence, Pattern paramPattern, Object... paramVarArgs)
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(paramCharSequence);
    paramCharSequence = paramPattern.matcher(paramCharSequence);
    while (paramCharSequence.find())
    {
      int j = paramVarArgs.length;
      int i = 0;
      while (i < j)
      {
        localSpannableStringBuilder.setSpan(paramVarArgs[i], paramCharSequence.start(), paramCharSequence.end(), 18);
        i += 1;
      }
    }
    return localSpannableStringBuilder;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.common.Spannables
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */