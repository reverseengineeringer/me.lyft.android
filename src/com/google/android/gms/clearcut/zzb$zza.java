package com.google.android.gms.clearcut;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.PendingResults;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.util.zze;
import com.google.android.gms.internal.zzapg.zzd;
import com.google.android.gms.playlog.internal.PlayLoggerContext;
import java.util.ArrayList;

public class zzb$zza
{
  private String pR = zzb.zzb(qj);
  private int pS = zzb.zza(qj);
  private String pT = zzb.zzc(qj);
  private String pU = zzb.zzd(qj);
  private int pW = zzb.zze(qj);
  private final zzb.zzc qb;
  private ArrayList<Integer> qc = null;
  private ArrayList<String> qd = null;
  private ArrayList<Integer> qe = null;
  private ArrayList<byte[]> qf = null;
  private boolean qg = true;
  private final zzapg.zzd qh = new zzapg.zzd();
  private boolean qi = false;
  
  private zzb$zza(zzb paramzzb, byte[] paramArrayOfByte)
  {
    this(paramzzb, paramArrayOfByte, null);
  }
  
  private zzb$zza(zzb paramzzb, byte[] paramArrayOfByte, zzb.zzc paramzzc)
  {
    pT = zzb.zzc(paramzzb);
    pU = zzb.zzd(paramzzb);
    qh.biF = zzb.zzf(paramzzb).currentTimeMillis();
    qh.biG = zzb.zzf(paramzzb).elapsedRealtime();
    qh.biX = zzb.zzh(paramzzb).zzbk(zzb.zzg(paramzzb));
    qh.biR = zzb.zzi(paramzzb).zzae(qh.biF);
    if (paramArrayOfByte != null) {
      qh.biM = paramArrayOfByte;
    }
    qb = paramzzc;
  }
  
  public LogEventParcelable zzamv()
  {
    return new LogEventParcelable(new PlayLoggerContext(zzb.zzk(qj), zzb.zzl(qj), pS, pR, pT, pU, zzb.zzj(qj), pW), qh, qb, null, zzb.zze(null), zzb.zzf(null), zzb.zze(null), zzb.zzg(null), qg);
  }
  
  public PendingResult<Status> zze(GoogleApiClient paramGoogleApiClient)
  {
    if (qi) {
      throw new IllegalStateException("do not reuse LogEventBuilder");
    }
    qi = true;
    PlayLoggerContext localPlayLoggerContext = zzamvqk;
    if (zzb.zzm(qj).zzg(asm, asi)) {
      return zzb.zzn(qj).zza(paramGoogleApiClient, zzamv());
    }
    return PendingResults.immediatePendingResult(Status.sg);
  }
  
  public zza zzew(int paramInt)
  {
    qh.biI = paramInt;
    return this;
  }
  
  public zza zzex(int paramInt)
  {
    qh.zzahl = paramInt;
    return this;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.clearcut.zzb.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */