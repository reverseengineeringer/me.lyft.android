package com.google.android.gms.internal;

import android.text.TextUtils;
import java.util.Map;

@zzir
public abstract class zzdh
{
  @zzir
  public static final zzdh zzbdw = new zzdh()
  {
    public String zzg(String paramAnonymousString1, String paramAnonymousString2)
    {
      return paramAnonymousString2;
    }
  };
  @zzir
  public static final zzdh zzbdx = new zzdh()
  {
    public String zzg(String paramAnonymousString1, String paramAnonymousString2)
    {
      if (paramAnonymousString1 != null) {
        return paramAnonymousString1;
      }
      return paramAnonymousString2;
    }
  };
  @zzir
  public static final zzdh zzbdy = new zzdh()
  {
    private String zzar(String paramAnonymousString)
    {
      if (TextUtils.isEmpty(paramAnonymousString)) {}
      int i;
      int j;
      do
      {
        return paramAnonymousString;
        i = 0;
        int k = paramAnonymousString.length();
        for (;;)
        {
          j = k;
          if (i >= paramAnonymousString.length()) {
            break;
          }
          j = k;
          if (paramAnonymousString.charAt(i) != ',') {
            break;
          }
          i += 1;
        }
        while ((j > 0) && (paramAnonymousString.charAt(j - 1) == ',')) {
          j -= 1;
        }
      } while ((i == 0) && (j == paramAnonymousString.length()));
      return paramAnonymousString.substring(i, j);
    }
    
    public String zzg(String paramAnonymousString1, String paramAnonymousString2)
    {
      paramAnonymousString1 = zzar(paramAnonymousString1);
      paramAnonymousString2 = zzar(paramAnonymousString2);
      if (TextUtils.isEmpty(paramAnonymousString1)) {
        return paramAnonymousString2;
      }
      if (TextUtils.isEmpty(paramAnonymousString2)) {
        return paramAnonymousString1;
      }
      return String.valueOf(paramAnonymousString1).length() + 1 + String.valueOf(paramAnonymousString2).length() + paramAnonymousString1 + "," + paramAnonymousString2;
    }
  };
  
  public final void zza(Map<String, String> paramMap, String paramString1, String paramString2)
  {
    paramMap.put(paramString1, zzg((String)paramMap.get(paramString1), paramString2));
  }
  
  public abstract String zzg(String paramString1, String paramString2);
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzdh
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */