package com.google.android.gms.internal;

import android.content.Context;
import android.os.Handler;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@zzir
public class zzgl
  implements zzgc
{
  private final Context mContext;
  private final Object zzail = new Object();
  private final zzdk zzajn;
  private final zzgn zzajz;
  private final boolean zzarj;
  private final boolean zzawl;
  private final zzge zzboi;
  private final AdRequestInfoParcel zzbox;
  private final long zzboy;
  private final long zzboz;
  private boolean zzbpb = false;
  private List<zzgi> zzbpd = new ArrayList();
  private zzgh zzbph;
  
  public zzgl(Context paramContext, AdRequestInfoParcel paramAdRequestInfoParcel, zzgn paramzzgn, zzge paramzzge, boolean paramBoolean1, boolean paramBoolean2, long paramLong1, long paramLong2, zzdk paramzzdk)
  {
    mContext = paramContext;
    zzbox = paramAdRequestInfoParcel;
    zzajz = paramzzgn;
    zzboi = paramzzge;
    zzarj = paramBoolean1;
    zzawl = paramBoolean2;
    zzboy = paramLong1;
    zzboz = paramLong2;
    zzajn = paramzzdk;
  }
  
  public void cancel()
  {
    synchronized (zzail)
    {
      zzbpb = true;
      if (zzbph != null) {
        zzbph.cancel();
      }
      return;
    }
  }
  
  public zzgi zzd(List<zzgd> arg1)
  {
    zzkh.zzcw("Starting mediation.");
    Object localObject = new ArrayList();
    zzdi localzzdi1 = zzajn.zzkg();
    Iterator localIterator1 = ???.iterator();
    label403:
    while (localIterator1.hasNext())
    {
      zzgd localzzgd = (zzgd)localIterator1.next();
      ??? = String.valueOf(zzbmz);
      Iterator localIterator2;
      if (???.length() != 0)
      {
        ??? = "Trying mediation network: ".concat(???);
        zzkh.zzcx(???);
        localIterator2 = zzbna.iterator();
      }
      for (;;)
      {
        if (!localIterator2.hasNext()) {
          break label403;
        }
        String str = (String)localIterator2.next();
        zzdi localzzdi2 = zzajn.zzkg();
        synchronized (zzail)
        {
          if (zzbpb)
          {
            localObject = new zzgi(-1);
            return (zzgi)localObject;
            ??? = new String("Trying mediation network: ");
            break;
          }
          zzbph = new zzgh(mContext, str, zzajz, zzboi, localzzgd, zzbox.zzcav, zzbox.zzaoy, zzbox.zzaou, zzarj, zzawl, zzbox.zzapm, zzbox.zzapq);
          ??? = zzbph.zza(zzboy, zzboz);
          zzbpd.add(???);
          if (zzboq == 0)
          {
            zzkh.zzcw("Adapter succeeded.");
            zzajn.zzh("mediation_network_succeed", str);
            if (!((List)localObject).isEmpty()) {
              zzajn.zzh("mediation_networks_fail", TextUtils.join(",", (Iterable)localObject));
            }
            zzajn.zza(localzzdi2, new String[] { "mls" });
            zzajn.zza(localzzdi1, new String[] { "ttm" });
            return (zzgi)???;
          }
        }
        localIterable.add(str);
        zzajn.zza(localzzdi2, new String[] { "mlf" });
        if (zzbos != null) {
          zzkl.zzclg.post(new Runnable()
          {
            public void run()
            {
              try
              {
                paramListzzbos.destroy();
                return;
              }
              catch (RemoteException localRemoteException)
              {
                zzkh.zzd("Could not destroy mediation adapter.", localRemoteException);
              }
            }
          });
        }
      }
    }
    if (!localIterable.isEmpty()) {
      zzajn.zzh("mediation_networks_fail", TextUtils.join(",", localIterable));
    }
    return new zzgi(1);
  }
  
  public List<zzgi> zzmi()
  {
    return zzbpd;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzgl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */