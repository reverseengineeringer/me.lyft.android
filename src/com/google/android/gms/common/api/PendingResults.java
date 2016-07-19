package com.google.android.gms.common.api;

import android.os.Looper;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.internal.zzqz;

public final class PendingResults
{
  public static PendingResult<Status> immediatePendingResult(Status paramStatus)
  {
    zzab.zzb(paramStatus, "Result must not be null");
    zzqz localzzqz = new zzqz(Looper.getMainLooper());
    localzzqz.zzc(paramStatus);
    return localzzqz;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.api.PendingResults
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */