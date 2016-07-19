package com.google.android.gms.internal;

import android.os.Bundle;
import com.google.android.gms.common.api.BooleanResult;
import com.google.android.gms.common.api.Status;

class zzael$zzb
  extends zzael.zza
{
  private final zzpr.zzb<BooleanResult> zj;
  
  public zzael$zzb(zzpr.zzb<BooleanResult> paramzzb)
  {
    super(null);
    zj = paramzzb;
  }
  
  public void zza(Status paramStatus, boolean paramBoolean, Bundle paramBundle)
  {
    zj.setResult(new BooleanResult(paramStatus, paramBoolean));
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzael.zzb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */