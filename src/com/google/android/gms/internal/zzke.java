package com.google.android.gms.internal;

import android.os.Bundle;
import com.google.android.gms.ads.internal.zzu;

@zzir
public class zzke
{
  private final Object zzail = new Object();
  private final zzkb zzanz;
  private final String zzcix;
  private int zzckl;
  private int zzckm;
  
  zzke(zzkb paramzzkb, String paramString)
  {
    zzanz = paramzzkb;
    zzcix = paramString;
  }
  
  public zzke(String paramString)
  {
    this(zzu.zzft(), paramString);
  }
  
  public Bundle toBundle()
  {
    synchronized (zzail)
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("pmnli", zzckl);
      localBundle.putInt("pmnll", zzckm);
      return localBundle;
    }
  }
  
  public void zzh(int paramInt1, int paramInt2)
  {
    synchronized (zzail)
    {
      zzckl = paramInt1;
      zzckm = paramInt2;
      zzanz.zza(zzcix, this);
      return;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzke
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */