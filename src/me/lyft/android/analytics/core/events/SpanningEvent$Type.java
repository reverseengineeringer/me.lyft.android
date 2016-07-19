package me.lyft.android.analytics.core.events;

import me.lyft.android.common.Strings;

public enum SpanningEvent$Type
{
  INITIATION,  RESULT;
  
  private SpanningEvent$Type() {}
  
  public static Type fromString(String paramString)
  {
    return valueOf(Strings.toUpperCaseEnglish(paramString));
  }
  
  public String toString()
  {
    return Strings.toLowerCaseEnglish(name());
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.analytics.core.events.SpanningEvent.Type
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */