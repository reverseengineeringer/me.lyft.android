package com.google.android.gms.measurement.internal;

abstract class zzaa
  extends zzz
{
  private boolean zzcwt;
  
  zzaa(zzx paramzzx)
  {
    super(paramzzx);
    aja.zzb(this);
  }
  
  public final void initialize()
  {
    if (zzcwt) {
      throw new IllegalStateException("Can't initialize twice");
    }
    zzwv();
    aja.zzbvc();
    zzcwt = true;
  }
  
  boolean isInitialized()
  {
    return zzcwt;
  }
  
  boolean zzbvh()
  {
    return false;
  }
  
  protected abstract void zzwv();
  
  protected void zzzg()
  {
    if (!isInitialized()) {
      throw new IllegalStateException("Not initialized");
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.measurement.internal.zzaa
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */