package com.google.android.gms.common.util;

import com.google.android.gms.common.internal.zzf;
import java.util.regex.Pattern;

public class zzw
{
  private static final Pattern AZ = Pattern.compile("\\$\\{(.*?)\\}");
  
  public static boolean zzic(String paramString)
  {
    return (paramString == null) || (zzf.xC.zzb(paramString));
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.util.zzw
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */