package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.SystemClock;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.zzu;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

@zzir
public class zzjz
{
  private final Object zzail = new Object();
  private final zzkb zzanz;
  private boolean zzcfe = false;
  private final LinkedList<zza> zzciv;
  private final String zzciw;
  private final String zzcix;
  private long zzciy = -1L;
  private long zzciz = -1L;
  private long zzcja = -1L;
  private long zzcjb = 0L;
  private long zzcjc = -1L;
  private long zzcjd = -1L;
  
  public zzjz(zzkb paramzzkb, String paramString1, String paramString2)
  {
    zzanz = paramzzkb;
    zzciw = paramString1;
    zzcix = paramString2;
    zzciv = new LinkedList();
  }
  
  public zzjz(String paramString1, String paramString2)
  {
    this(zzu.zzft(), paramString1, paramString2);
  }
  
  public Bundle toBundle()
  {
    ArrayList localArrayList;
    synchronized (zzail)
    {
      Bundle localBundle1 = new Bundle();
      localBundle1.putString("seq_num", zzciw);
      localBundle1.putString("slotid", zzcix);
      localBundle1.putBoolean("ismediation", zzcfe);
      localBundle1.putLong("treq", zzcjc);
      localBundle1.putLong("tresponse", zzcjd);
      localBundle1.putLong("timp", zzciz);
      localBundle1.putLong("tload", zzcja);
      localBundle1.putLong("pcc", zzcjb);
      localBundle1.putLong("tfetch", zzciy);
      localArrayList = new ArrayList();
      Iterator localIterator = zzciv.iterator();
      if (localIterator.hasNext()) {
        localArrayList.add(((zza)localIterator.next()).toBundle());
      }
    }
    localBundle2.putParcelableArrayList("tclick", localArrayList);
    return localBundle2;
  }
  
  public void zzac(boolean paramBoolean)
  {
    synchronized (zzail)
    {
      if (zzcjd != -1L)
      {
        zzcja = SystemClock.elapsedRealtime();
        if (!paramBoolean)
        {
          zzciz = zzcja;
          zzanz.zza(this);
        }
      }
      return;
    }
  }
  
  public void zzad(boolean paramBoolean)
  {
    synchronized (zzail)
    {
      if (zzcjd != -1L)
      {
        zzcfe = paramBoolean;
        zzanz.zza(this);
      }
      return;
    }
  }
  
  public void zzl(long paramLong)
  {
    synchronized (zzail)
    {
      zzcjd = paramLong;
      if (zzcjd != -1L) {
        zzanz.zza(this);
      }
      return;
    }
  }
  
  public void zzm(long paramLong)
  {
    synchronized (zzail)
    {
      if (zzcjd != -1L)
      {
        zzciy = paramLong;
        zzanz.zza(this);
      }
      return;
    }
  }
  
  public void zzq(AdRequestParcel paramAdRequestParcel)
  {
    synchronized (zzail)
    {
      zzcjc = SystemClock.elapsedRealtime();
      zzanz.zzsl().zzb(paramAdRequestParcel, zzcjc);
      return;
    }
  }
  
  public void zzrz()
  {
    synchronized (zzail)
    {
      if ((zzcjd != -1L) && (zzciz == -1L))
      {
        zzciz = SystemClock.elapsedRealtime();
        zzanz.zza(this);
      }
      zzanz.zzsl().zzrz();
      return;
    }
  }
  
  public void zzsa()
  {
    synchronized (zzail)
    {
      if (zzcjd != -1L)
      {
        zza localzza = new zza();
        localzza.zzse();
        zzciv.add(localzza);
        zzcjb += 1L;
        zzanz.zzsl().zzsa();
        zzanz.zza(this);
      }
      return;
    }
  }
  
  public void zzsb()
  {
    synchronized (zzail)
    {
      if ((zzcjd != -1L) && (!zzciv.isEmpty()))
      {
        zza localzza = (zza)zzciv.getLast();
        if (localzza.zzsc() == -1L)
        {
          localzza.zzsd();
          zzanz.zza(this);
        }
      }
      return;
    }
  }
  
  @zzir
  private static final class zza
  {
    private long zzcje = -1L;
    private long zzcjf = -1L;
    
    public Bundle toBundle()
    {
      Bundle localBundle = new Bundle();
      localBundle.putLong("topen", zzcje);
      localBundle.putLong("tclose", zzcjf);
      return localBundle;
    }
    
    public long zzsc()
    {
      return zzcjf;
    }
    
    public void zzsd()
    {
      zzcjf = SystemClock.elapsedRealtime();
    }
    
    public void zzse()
    {
      zzcje = SystemClock.elapsedRealtime();
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzjz
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */