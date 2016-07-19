package com.google.android.gms.internal;

import com.google.android.gms.signin.internal.SignInResponse;
import com.google.android.gms.signin.internal.zzb;
import java.lang.ref.WeakReference;

class zzqb$zzd
  extends zzb
{
  private final WeakReference<zzqb> tH;
  
  zzqb$zzd(zzqb paramzzqb)
  {
    tH = new WeakReference(paramzzqb);
  }
  
  public void zzb(final SignInResponse paramSignInResponse)
  {
    final zzqb localzzqb = (zzqb)tH.get();
    if (localzzqb == null) {
      return;
    }
    zzqb.zzd(localzzqb).zza(new zzqf.zza(localzzqb)
    {
      public void zzapi()
      {
        zzqb.zza(localzzqb, paramSignInResponse);
      }
    });
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzqb.zzd
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */