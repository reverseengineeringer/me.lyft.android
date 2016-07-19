package com.google.android.gms.internal;

import android.content.Context;
import android.os.Handler;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.ads.internal.util.client.zza;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Future;
import org.json.JSONException;
import org.json.JSONObject;

@zzir
public class zzjp
  extends zzkg
  implements zzjo
{
  private final Context mContext;
  private final Object zzail = new Object();
  private final zzjy.zza zzbxv;
  private final ArrayList<Future> zzcia = new ArrayList();
  private final ArrayList<String> zzcib = new ArrayList();
  private final HashSet<String> zzcic = new HashSet();
  private final zzjj zzcid;
  
  public zzjp(Context paramContext, zzjy.zza paramzza, zzjj paramzzjj)
  {
    mContext = paramContext;
    zzbxv = paramzza;
    zzcid = paramzzjj;
  }
  
  private zzjy zza(int paramInt, String paramString, zzgd paramzzgd)
  {
    return new zzjy(zzbxv.zzcit.zzcav, null, zzbxv.zzciu.zzbnq, paramInt, zzbxv.zzciu.zzbnr, zzbxv.zzciu.zzcce, zzbxv.zzciu.orientation, zzbxv.zzciu.zzbnw, zzbxv.zzcit.zzcay, zzbxv.zzciu.zzccc, paramzzgd, null, paramString, zzbxv.zzcik, null, zzbxv.zzciu.zzccd, zzbxv.zzaoy, zzbxv.zzciu.zzccb, zzbxv.zzcio, zzbxv.zzciu.zzccg, zzbxv.zzciu.zzcch, zzbxv.zzcii, null, zzbxv.zzciu.zzccr, zzbxv.zzciu.zzccs, zzbxv.zzciu.zzcct, zzbxv.zzciu.zzccu, zzbxv.zzciu.zzccv, null, zzbxv.zzciu.zzbnt);
  }
  
  private zzjy zza(String paramString, zzgd paramzzgd)
  {
    return zza(-2, paramString, paramzzgd);
  }
  
  private void zzd(String paramString1, String paramString2, String paramString3)
  {
    synchronized (zzail)
    {
      zzjq localzzjq = zzcid.zzcg(paramString1);
      if ((localzzjq == null) || (localzzjq.zzrw() == null) || (localzzjq.zzrv() == null)) {
        return;
      }
      paramString2 = zza(paramString1, paramString2, paramString3, localzzjq);
      zzcia.add((Future)paramString2.zzpz());
      zzcib.add(paramString1);
      return;
    }
  }
  
  private zzjy zzru()
  {
    return zza(3, null, null);
  }
  
  public void onStop() {}
  
  protected zzjk zza(String paramString1, String paramString2, String paramString3, zzjq paramzzjq)
  {
    return new zzjk(mContext, paramString1, paramString2, paramString3, zzbxv, paramzzjq, this);
  }
  
  public void zza(String paramString, int paramInt) {}
  
  public void zzch(String paramString)
  {
    synchronized (zzail)
    {
      zzcic.add(paramString);
      return;
    }
  }
  
  public void zzew()
  {
    Iterator localIterator1 = zzbxv.zzcik.zzbno.iterator();
    final Object localObject3;
    while (localIterator1.hasNext())
    {
      zzgd localzzgd = (zzgd)localIterator1.next();
      String str = zzbng;
      Iterator localIterator2 = zzbna.iterator();
      while (localIterator2.hasNext())
      {
        localObject3 = (String)localIterator2.next();
        Object localObject1 = localObject3;
        if ("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter".equals(localObject3)) {}
        try
        {
          localObject1 = new JSONObject(str).getString("class_name");
          zzd((String)localObject1, str, zzbmy);
        }
        catch (JSONException localJSONException)
        {
          zzkh.zzb("Unable to determine custom event class name, skipping...", localJSONException);
        }
      }
    }
    int i = 0;
    for (;;)
    {
      if (i < zzcia.size()) {}
      try
      {
        ((Future)zzcia.get(i)).get();
        synchronized (zzail)
        {
          if (zzcic.contains(zzcib.get(i)))
          {
            localObject3 = zza((String)zzcib.get(i), (zzgd)zzbxv.zzcik.zzbno.get(i));
            zza.zzcnf.post(new Runnable()
            {
              public void run()
              {
                zzjp.zza(zzjp.this).zzb(localObject3);
              }
            });
            return;
          }
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        final zzjy localzzjy = zzru();
        zza.zzcnf.post(new Runnable()
        {
          public void run()
          {
            zzjp.zza(zzjp.this).zzb(localzzjy);
          }
        });
        return;
      }
      catch (Exception localException)
      {
        i += 1;
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzjp
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */