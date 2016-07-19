package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.zzd;
import com.google.android.gms.ads.internal.zzl;

@zzir
public class zzfl
{
  private Context mContext;
  private final zzd zzajv;
  private final zzgn zzajz;
  private final VersionInfoParcel zzalm;
  
  zzfl(Context paramContext, zzgn paramzzgn, VersionInfoParcel paramVersionInfoParcel, zzd paramzzd)
  {
    mContext = paramContext;
    zzajz = paramzzgn;
    zzalm = paramVersionInfoParcel;
    zzajv = paramzzd;
  }
  
  public Context getApplicationContext()
  {
    return mContext.getApplicationContext();
  }
  
  public zzl zzbd(String paramString)
  {
    return new zzl(mContext, new AdSizeParcel(), paramString, zzajz, zzalm, zzajv);
  }
  
  public zzl zzbe(String paramString)
  {
    return new zzl(mContext.getApplicationContext(), new AdSizeParcel(), paramString, zzajz, zzalm, zzajv);
  }
  
  public zzfl zzlp()
  {
    return new zzfl(getApplicationContext(), zzajz, zzalm, zzajv);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzfl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */