package com.google.android.gms.clearcut;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Looper;
import android.util.Log;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.Api.zza;
import com.google.android.gms.common.api.Api.zzf;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.PendingResults;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.common.internal.zzg;
import com.google.android.gms.common.util.zze;
import com.google.android.gms.common.util.zzh;
import com.google.android.gms.internal.zzapg.zzd;
import com.google.android.gms.internal.zzpg;
import com.google.android.gms.internal.zzph;
import com.google.android.gms.internal.zzpl;
import com.google.android.gms.playlog.internal.PlayLoggerContext;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.TimeZone;

public final class zzb
{
  public static final Api<Api.ApiOptions.NoOptions> API = new Api("ClearcutLogger.API", bO, bN);
  public static final Api.zzf<zzph> bN = new Api.zzf();
  public static final Api.zza<zzph, Api.ApiOptions.NoOptions> bO = new Api.zza()
  {
    public zzph zze(Context paramAnonymousContext, Looper paramAnonymousLooper, zzg paramAnonymouszzg, Api.ApiOptions.NoOptions paramAnonymousNoOptions, GoogleApiClient.ConnectionCallbacks paramAnonymousConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramAnonymousOnConnectionFailedListener)
    {
      return new zzph(paramAnonymousContext, paramAnonymousLooper, paramAnonymouszzg, paramAnonymousConnectionCallbacks, paramAnonymousOnConnectionFailedListener);
    }
  };
  public static final zzc pP = new zzpg();
  private final String aQ;
  private final Context mContext;
  private final int pQ;
  private String pR;
  private int pS = -1;
  private String pT;
  private String pU;
  private final boolean pV;
  private int pW = 0;
  private final zzc pX;
  private final zza pY;
  private zzd pZ;
  private final zzb qa;
  private final zze zzaoa;
  
  public zzb(Context paramContext, int paramInt, String paramString1, String paramString2, String paramString3, boolean paramBoolean, zzc paramzzc, zze paramzze, zzd paramzzd, zza paramzza, zzb paramzzb)
  {
    Context localContext = paramContext.getApplicationContext();
    if (localContext != null)
    {
      mContext = localContext;
      aQ = paramContext.getPackageName();
      pQ = zzbl(paramContext);
      pS = paramInt;
      pR = paramString1;
      pT = paramString2;
      pU = paramString3;
      pV = paramBoolean;
      pX = paramzzc;
      zzaoa = paramzze;
      if (paramzzd == null) {
        break label147;
      }
      label93:
      pZ = paramzzd;
      pY = paramzza;
      pW = 0;
      qa = paramzzb;
      if (pV) {
        if (pT != null) {
          break label159;
        }
      }
    }
    label147:
    label159:
    for (paramBoolean = true;; paramBoolean = false)
    {
      zzab.zzb(paramBoolean, "can't be anonymous with an upload account");
      return;
      localContext = paramContext;
      break;
      paramzzd = new zzd();
      break label93;
    }
  }
  
  public zzb(Context paramContext, String paramString1, String paramString2)
  {
    this(paramContext, -1, paramString1, paramString2, null, false, pP, zzh.zzavi(), null, zza.pO, new zzpl(paramContext));
  }
  
  private static int[] zzb(ArrayList<Integer> paramArrayList)
  {
    if (paramArrayList == null) {
      return null;
    }
    int[] arrayOfInt = new int[paramArrayList.size()];
    paramArrayList = paramArrayList.iterator();
    int i = 0;
    while (paramArrayList.hasNext())
    {
      arrayOfInt[i] = ((Integer)paramArrayList.next()).intValue();
      i += 1;
    }
    return arrayOfInt;
  }
  
  private int zzbl(Context paramContext)
  {
    try
    {
      int i = getPackageManagergetPackageInfogetPackageName0versionCode;
      return i;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      Log.wtf("ClearcutLogger", "This can't happen.");
    }
    return 0;
  }
  
  private static String[] zzc(ArrayList<String> paramArrayList)
  {
    if (paramArrayList == null) {
      return null;
    }
    return (String[])paramArrayList.toArray(new String[0]);
  }
  
  private static byte[][] zzd(ArrayList<byte[]> paramArrayList)
  {
    if (paramArrayList == null) {
      return null;
    }
    return (byte[][])paramArrayList.toArray(new byte[0][]);
  }
  
  public zza zzl(byte[] paramArrayOfByte)
  {
    return new zza(paramArrayOfByte, null);
  }
  
  public class zza
  {
    private String pR = zzb.zzb(zzb.this);
    private int pS = zzb.zza(zzb.this);
    private String pT = zzb.zzc(zzb.this);
    private String pU = zzb.zzd(zzb.this);
    private int pW = zzb.zze(zzb.this);
    private final zzb.zzc qb;
    private ArrayList<Integer> qc = null;
    private ArrayList<String> qd = null;
    private ArrayList<Integer> qe = null;
    private ArrayList<byte[]> qf = null;
    private boolean qg = true;
    private final zzapg.zzd qh = new zzapg.zzd();
    private boolean qi = false;
    
    private zza(byte[] paramArrayOfByte)
    {
      this(paramArrayOfByte, null);
    }
    
    private zza(byte[] paramArrayOfByte, zzb.zzc paramzzc)
    {
      qh.biF = zzb.zzf(zzb.this).currentTimeMillis();
      qh.biG = zzb.zzf(zzb.this).elapsedRealtime();
      qh.biX = zzb.zzh(zzb.this).zzbk(zzb.zzg(zzb.this));
      qh.biR = zzb.zzi(zzb.this).zzae(qh.biF);
      if (paramArrayOfByte != null) {
        qh.biM = paramArrayOfByte;
      }
      qb = paramzzc;
    }
    
    public LogEventParcelable zzamv()
    {
      return new LogEventParcelable(new PlayLoggerContext(zzb.zzk(zzb.this), zzb.zzl(zzb.this), pS, pR, pT, pU, zzb.zzj(zzb.this), pW), qh, qb, null, zzb.zze(null), zzb.zzf(null), zzb.zze(null), zzb.zzg(null), qg);
    }
    
    public PendingResult<Status> zze(GoogleApiClient paramGoogleApiClient)
    {
      if (qi) {
        throw new IllegalStateException("do not reuse LogEventBuilder");
      }
      qi = true;
      PlayLoggerContext localPlayLoggerContext = zzamvqk;
      if (zzb.zzm(zzb.this).zzg(asm, asi)) {
        return zzb.zzn(zzb.this).zza(paramGoogleApiClient, zzamv());
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
  
  public static abstract interface zzb
  {
    public abstract boolean zzg(String paramString, int paramInt);
  }
  
  public static abstract interface zzc
  {
    public abstract byte[] zzamw();
  }
  
  public static class zzd
  {
    public long zzae(long paramLong)
    {
      return TimeZone.getDefault().getOffset(paramLong) / 1000;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.clearcut.zzb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */