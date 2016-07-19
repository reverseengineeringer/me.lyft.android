package com.google.android.gms.ads.internal;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.zzz.zza;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.internal.zzcy;
import com.google.android.gms.internal.zzdc;
import com.google.android.gms.internal.zzir;
import com.google.android.gms.internal.zzkh;

@zzir
public class zzo
  extends zzz.zza
{
  private static final Object zzamp = new Object();
  private static zzo zzamq;
  private final Context mContext;
  private final Object zzail = new Object();
  private boolean zzamr;
  private boolean zzams;
  private float zzamt = -1.0F;
  private VersionInfoParcel zzamu;
  
  zzo(Context paramContext, VersionInfoParcel paramVersionInfoParcel)
  {
    mContext = paramContext;
    zzamu = paramVersionInfoParcel;
    zzamr = false;
  }
  
  public static zzo zza(Context paramContext, VersionInfoParcel paramVersionInfoParcel)
  {
    synchronized (zzamp)
    {
      if (zzamq == null) {
        zzamq = new zzo(paramContext.getApplicationContext(), paramVersionInfoParcel);
      }
      paramContext = zzamq;
      return paramContext;
    }
  }
  
  public static zzo zzex()
  {
    synchronized (zzamp)
    {
      zzo localzzo = zzamq;
      return localzzo;
    }
  }
  
  public void initialize()
  {
    synchronized (zzamp)
    {
      if (zzamr)
      {
        zzkh.zzcy("Mobile ads is initialized already.");
        return;
      }
      zzamr = true;
      return;
    }
  }
  
  public void setAppMuted(boolean paramBoolean)
  {
    synchronized (zzail)
    {
      zzams = paramBoolean;
      return;
    }
  }
  
  public void setAppVolume(float paramFloat)
  {
    synchronized (zzail)
    {
      zzamt = paramFloat;
      return;
    }
  }
  
  public float zzey()
  {
    synchronized (zzail)
    {
      float f = zzamt;
      return f;
    }
  }
  
  public boolean zzez()
  {
    for (;;)
    {
      synchronized (zzail)
      {
        if (zzamt >= 0.0F)
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }
  
  public boolean zzfa()
  {
    synchronized (zzail)
    {
      boolean bool = zzams;
      return bool;
    }
  }
  
  public void zzu(String paramString)
  {
    zzdc.initialize(mContext);
    if ((!TextUtils.isEmpty(paramString)) && (((Boolean)zzdc.zzbcr.get()).booleanValue())) {
      zzu.zzgi().zza(mContext, zzamu, true, null, paramString, null);
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.zzo
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */