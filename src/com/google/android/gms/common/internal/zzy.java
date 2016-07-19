package com.google.android.gms.common.internal;

import java.util.Iterator;

public class zzy
{
  private final String separator;
  
  private zzy(String paramString)
  {
    separator = paramString;
  }
  
  public static zzy zzhr(String paramString)
  {
    return new zzy(paramString);
  }
  
  public final String zza(Iterable<?> paramIterable)
  {
    return zza(new StringBuilder(), paramIterable).toString();
  }
  
  public final StringBuilder zza(StringBuilder paramStringBuilder, Iterable<?> paramIterable)
  {
    paramIterable = paramIterable.iterator();
    if (paramIterable.hasNext())
    {
      paramStringBuilder.append(zzy(paramIterable.next()));
      while (paramIterable.hasNext())
      {
        paramStringBuilder.append(separator);
        paramStringBuilder.append(zzy(paramIterable.next()));
      }
    }
    return paramStringBuilder;
  }
  
  CharSequence zzy(Object paramObject)
  {
    if ((paramObject instanceof CharSequence)) {
      return (CharSequence)paramObject;
    }
    return paramObject.toString();
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.internal.zzy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */