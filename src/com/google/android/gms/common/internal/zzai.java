package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.res.Resources;
import com.google.android.gms.R.string;

public class zzai
{
  private final Resources zc;
  private final String zd;
  
  public zzai(Context paramContext)
  {
    zzab.zzaa(paramContext);
    zc = paramContext.getResources();
    zd = zc.getResourcePackageName(R.string.common_google_play_services_unknown_issue);
  }
  
  public String getString(String paramString)
  {
    int i = zc.getIdentifier(paramString, "string", zd);
    if (i == 0) {
      return null;
    }
    return zc.getString(i);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.internal.zzai
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */