package com.google.android.gms.internal;

import java.io.IOException;

public abstract interface zzad
{
  public static final class zza
    extends zzaow<zza>
  {
    public String stackTrace = null;
    public String zzck = null;
    public Long zzcl = null;
    public String zzcm = null;
    public String zzcn = null;
    public Long zzco = null;
    public Long zzcp = null;
    public String zzcq = null;
    public Long zzcr = null;
    public String zzcs = null;
    
    public zza()
    {
      bik = -1;
    }
    
    public zza zza(zzaou paramzzaou)
      throws IOException
    {
      for (;;)
      {
        int i = paramzzaou.J();
        switch (i)
        {
        default: 
          if (super.zza(paramzzaou, i)) {}
          break;
        case 0: 
          return this;
        case 10: 
          zzck = paramzzaou.readString();
          break;
        case 16: 
          zzcl = Long.valueOf(paramzzaou.M());
          break;
        case 26: 
          stackTrace = paramzzaou.readString();
          break;
        case 34: 
          zzcm = paramzzaou.readString();
          break;
        case 42: 
          zzcn = paramzzaou.readString();
          break;
        case 48: 
          zzco = Long.valueOf(paramzzaou.M());
          break;
        case 56: 
          zzcp = Long.valueOf(paramzzaou.M());
          break;
        case 66: 
          zzcq = paramzzaou.readString();
          break;
        case 72: 
          zzcr = Long.valueOf(paramzzaou.M());
          break;
        case 82: 
          zzcs = paramzzaou.readString();
        }
      }
    }
    
    public void zza(zzaov paramzzaov)
      throws IOException
    {
      if (zzck != null) {
        paramzzaov.zzr(1, zzck);
      }
      if (zzcl != null) {
        paramzzaov.zzb(2, zzcl.longValue());
      }
      if (stackTrace != null) {
        paramzzaov.zzr(3, stackTrace);
      }
      if (zzcm != null) {
        paramzzaov.zzr(4, zzcm);
      }
      if (zzcn != null) {
        paramzzaov.zzr(5, zzcn);
      }
      if (zzco != null) {
        paramzzaov.zzb(6, zzco.longValue());
      }
      if (zzcp != null) {
        paramzzaov.zzb(7, zzcp.longValue());
      }
      if (zzcq != null) {
        paramzzaov.zzr(8, zzcq);
      }
      if (zzcr != null) {
        paramzzaov.zzb(9, zzcr.longValue());
      }
      if (zzcs != null) {
        paramzzaov.zzr(10, zzcs);
      }
      super.zza(paramzzaov);
    }
    
    protected int zzy()
    {
      int j = super.zzy();
      int i = j;
      if (zzck != null) {
        i = j + zzaov.zzs(1, zzck);
      }
      j = i;
      if (zzcl != null) {
        j = i + zzaov.zze(2, zzcl.longValue());
      }
      i = j;
      if (stackTrace != null) {
        i = j + zzaov.zzs(3, stackTrace);
      }
      j = i;
      if (zzcm != null) {
        j = i + zzaov.zzs(4, zzcm);
      }
      i = j;
      if (zzcn != null) {
        i = j + zzaov.zzs(5, zzcn);
      }
      j = i;
      if (zzco != null) {
        j = i + zzaov.zze(6, zzco.longValue());
      }
      i = j;
      if (zzcp != null) {
        i = j + zzaov.zze(7, zzcp.longValue());
      }
      j = i;
      if (zzcq != null) {
        j = i + zzaov.zzs(8, zzcq);
      }
      i = j;
      if (zzcr != null) {
        i = j + zzaov.zze(9, zzcr.longValue());
      }
      j = i;
      if (zzcs != null) {
        j = i + zzaov.zzs(10, zzcs);
      }
      return j;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzad
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */