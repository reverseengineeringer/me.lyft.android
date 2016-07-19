package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzab.zza;
import com.google.android.gms.ads.internal.client.zzac;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.common.util.zzf;
import java.util.HashMap;
import java.util.Map;

@zzir
public class zzlq
  extends zzab.zza
{
  private final Object zzail = new Object();
  private boolean zzaio = true;
  private final zzll zzbgj;
  private final float zzcqb;
  private int zzcqc;
  private zzac zzcqd;
  private boolean zzcqe;
  private boolean zzcqf;
  private float zzcqg;
  
  public zzlq(zzll paramzzll, float paramFloat)
  {
    zzbgj = paramzzll;
    zzcqb = paramFloat;
  }
  
  private void zzc(String paramString, final Map<String, String> paramMap)
  {
    if (paramMap == null) {}
    for (paramMap = new HashMap();; paramMap = new HashMap(paramMap))
    {
      paramMap.put("action", paramString);
      zzu.zzfq().runOnUiThread(new Runnable()
      {
        public void run()
        {
          zzlq.zzb(zzlq.this).zza("pubVideoCmd", paramMap);
        }
      });
      return;
    }
  }
  
  private void zzde(String paramString)
  {
    zzc(paramString, null);
  }
  
  private void zzi(final int paramInt1, final int paramInt2)
  {
    zzu.zzfq().runOnUiThread(new Runnable()
    {
      public void run()
      {
        label48:
        label62:
        label77:
        label141:
        label146:
        label151:
        label157:
        label162:
        label287:
        for (boolean bool = false;; bool = true)
        {
          int j;
          int k;
          int m;
          synchronized (zzlq.zzc(zzlq.this))
          {
            int i;
            if (paramInt1 != paramInt2)
            {
              j = 1;
              if ((zzlq.zzd(zzlq.this)) || (paramInt2 != 1)) {
                break label141;
              }
              i = 1;
              if ((j == 0) || (paramInt2 != 1)) {
                break label146;
              }
              k = 1;
              if ((j == 0) || (paramInt2 != 2)) {
                break label151;
              }
              m = 1;
              if ((j == 0) || (paramInt2 != 3)) {
                break label157;
              }
            }
            for (j = 1;; j = 0)
            {
              zzlq localzzlq = zzlq.this;
              if ((zzlq.zzd(zzlq.this)) || (i != 0)) {
                break label287;
              }
              zzlq.zza(localzzlq, bool);
              if (zzlq.zze(zzlq.this) != null) {
                break label162;
              }
              return;
              j = 0;
              break;
              i = 0;
              break label48;
              k = 0;
              break label62;
              m = 0;
              break label77;
            }
            if (i == 0) {}
          }
          try
          {
            zzlq.zze(zzlq.this).zzjb();
            if (k == 0) {}
          }
          catch (RemoteException localRemoteException3)
          {
            try
            {
              zzlq.zze(zzlq.this).zzjc();
              if (m == 0) {}
            }
            catch (RemoteException localRemoteException3)
            {
              try
              {
                zzlq.zze(zzlq.this).zzjd();
                if (j == 0) {}
              }
              catch (RemoteException localRemoteException3)
              {
                try
                {
                  for (;;)
                  {
                    zzlq.zze(zzlq.this).onVideoEnd();
                    return;
                    localObject2 = finally;
                    throw ((Throwable)localObject2);
                    localRemoteException1 = localRemoteException1;
                    zzkh.zzd("Unable to call onVideoStart()", localRemoteException1);
                    continue;
                    localRemoteException2 = localRemoteException2;
                    zzkh.zzd("Unable to call onVideoPlay()", localRemoteException2);
                  }
                  localRemoteException3 = localRemoteException3;
                  zzkh.zzd("Unable to call onVideoPause()", localRemoteException3);
                }
                catch (RemoteException localRemoteException4)
                {
                  for (;;)
                  {
                    zzkh.zzd("Unable to call onVideoEnd()", localRemoteException4);
                  }
                }
              }
            }
          }
        }
      }
    });
  }
  
  public int getPlaybackState()
  {
    synchronized (zzail)
    {
      int i = zzcqc;
      return i;
    }
  }
  
  public boolean isMuted()
  {
    synchronized (zzail)
    {
      boolean bool = zzcqf;
      return bool;
    }
  }
  
  public void pause()
  {
    zzde("pause");
  }
  
  public void play()
  {
    zzde("play");
  }
  
  public void zza(float paramFloat, int paramInt, boolean paramBoolean)
  {
    synchronized (zzail)
    {
      zzcqg = paramFloat;
      zzcqf = paramBoolean;
      int i = zzcqc;
      zzcqc = paramInt;
      zzi(i, paramInt);
      return;
    }
  }
  
  public void zza(zzac paramzzac)
  {
    synchronized (zzail)
    {
      zzcqd = paramzzac;
      return;
    }
  }
  
  public void zzam(boolean paramBoolean)
  {
    for (;;)
    {
      synchronized (zzail)
      {
        zzaio = paramBoolean;
        if (paramBoolean)
        {
          ??? = "1";
          zzc("initialState", zzf.zze("muteStart", ???));
          return;
        }
      }
      ??? = "0";
    }
  }
  
  public float zziz()
  {
    return zzcqb;
  }
  
  public float zzja()
  {
    synchronized (zzail)
    {
      float f = zzcqg;
      return f;
    }
  }
  
  public void zzm(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (String str = "mute";; str = "unmute")
    {
      zzde(str);
      return;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzlq
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */