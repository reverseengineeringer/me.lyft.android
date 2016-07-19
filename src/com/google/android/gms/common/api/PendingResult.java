package com.google.android.gms.common.api;

public abstract class PendingResult<R extends Result>
{
  public abstract R await();
  
  public abstract void setResultCallback(ResultCallback<? super R> paramResultCallback);
  
  public void zza(zza paramzza)
  {
    throw new UnsupportedOperationException();
  }
  
  public Integer zzaog()
  {
    throw new UnsupportedOperationException();
  }
  
  public static abstract interface zza
  {
    public abstract void zzv(Status paramStatus);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.api.PendingResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */