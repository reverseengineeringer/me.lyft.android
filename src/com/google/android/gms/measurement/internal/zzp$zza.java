package com.google.android.gms.measurement.internal;

public class zzp$zza
{
  private final boolean akY;
  private final boolean akZ;
  private final int mPriority;
  
  zzp$zza(zzp paramzzp, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    mPriority = paramInt;
    akY = paramBoolean1;
    akZ = paramBoolean2;
  }
  
  public void log(String paramString)
  {
    akX.zza(mPriority, akY, akZ, paramString, null, null, null);
  }
  
  public void zzd(String paramString, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    akX.zza(mPriority, akY, akZ, paramString, paramObject1, paramObject2, paramObject3);
  }
  
  public void zze(String paramString, Object paramObject1, Object paramObject2)
  {
    akX.zza(mPriority, akY, akZ, paramString, paramObject1, paramObject2, null);
  }
  
  public void zzj(String paramString, Object paramObject)
  {
    akX.zza(mPriority, akY, akZ, paramString, paramObject, null, null);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.measurement.internal.zzp.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */