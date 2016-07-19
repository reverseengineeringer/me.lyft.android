package com.google.android.gms.internal;

import android.content.Context;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Map;

@zzir
public class zzkr
{
  private static zzl zzcmg;
  private static final Object zzcmh = new Object();
  public static final zza<Void> zzcmi = new zza()
  {
    public Void zzi(InputStream paramAnonymousInputStream)
    {
      return null;
    }
    
    public Void zztq()
    {
      return null;
    }
  };
  
  public zzkr(Context paramContext)
  {
    zzap(paramContext);
  }
  
  private static zzl zzap(Context paramContext)
  {
    synchronized (zzcmh)
    {
      if (zzcmg == null) {
        zzcmg = zzac.zza(paramContext.getApplicationContext());
      }
      paramContext = zzcmg;
      return paramContext;
    }
  }
  
  public zzlc<String> zza(int paramInt, final String paramString, final Map<String, String> paramMap, final byte[] paramArrayOfByte)
  {
    final zzc localzzc = new zzc(null);
    paramString = new zzab(paramInt, paramString, localzzc, new zzm.zza()
    {
      public void zze(zzr paramAnonymouszzr)
      {
        String str = paramString;
        paramAnonymouszzr = String.valueOf(paramAnonymouszzr.toString());
        zzkh.zzcy(String.valueOf(str).length() + 21 + String.valueOf(paramAnonymouszzr).length() + "Failed to load URL: " + str + "\n" + paramAnonymouszzr);
        localzzc.zzb(null);
      }
    })
    {
      public Map<String, String> getHeaders()
        throws zza
      {
        if (paramMap == null) {
          return super.getHeaders();
        }
        return paramMap;
      }
      
      public byte[] zzp()
        throws zza
      {
        if (paramArrayOfByte == null) {
          return super.zzp();
        }
        return paramArrayOfByte;
      }
    };
    zzcmg.zze(paramString);
    return localzzc;
  }
  
  public <T> zzlc<T> zza(String paramString, zza<T> paramzza)
  {
    zzc localzzc = new zzc(null);
    zzcmg.zze(new zzb(paramString, paramzza, localzzc));
    return localzzc;
  }
  
  public zzlc<String> zzb(String paramString, Map<String, String> paramMap)
  {
    return zza(0, paramString, paramMap, null);
  }
  
  public static abstract interface zza<T>
  {
    public abstract T zzh(InputStream paramInputStream);
    
    public abstract T zzqv();
  }
  
  private static class zzb<T>
    extends zzk<InputStream>
  {
    private final zzm.zzb<T> zzcg;
    private final zzkr.zza<T> zzcmn;
    
    public zzb(String paramString, final zzkr.zza<T> paramzza, zzm.zzb<T> paramzzb)
    {
      super(paramString, new zzm.zza()
      {
        public void zze(zzr paramAnonymouszzr)
        {
          zzb(paramzza.zzqv());
        }
      });
      zzcmn = paramzza;
      zzcg = paramzzb;
    }
    
    protected zzm<InputStream> zza(zzi paramzzi)
    {
      return zzm.zza(new ByteArrayInputStream(data), zzx.zzb(paramzzi));
    }
    
    protected void zzj(InputStream paramInputStream)
    {
      zzcg.zzb(zzcmn.zzh(paramInputStream));
    }
  }
  
  private class zzc<T>
    extends zzkz<T>
    implements zzm.zzb<T>
  {
    private zzc() {}
    
    public void zzb(T paramT)
    {
      super.zzi(paramT);
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzkr
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */