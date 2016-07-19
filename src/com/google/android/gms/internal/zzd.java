package com.google.android.gms.internal;

public class zzd
  implements zzo
{
  private int zzn;
  private int zzo;
  private final int zzp;
  private final float zzq;
  
  public zzd()
  {
    this(2500, 1, 1.0F);
  }
  
  public zzd(int paramInt1, int paramInt2, float paramFloat)
  {
    zzn = paramInt1;
    zzp = paramInt2;
    zzq = paramFloat;
  }
  
  public void zza(zzr paramzzr)
    throws zzr
  {
    zzo += 1;
    zzn = ((int)(zzn + zzn * zzq));
    if (!zze()) {
      throw paramzzr;
    }
  }
  
  public int zzc()
  {
    return zzn;
  }
  
  public int zzd()
  {
    return zzo;
  }
  
  protected boolean zze()
  {
    return zzo <= zzp;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzd
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */