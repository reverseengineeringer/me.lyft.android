package com.google.android.gms.measurement.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.google.android.gms.common.internal.zzab;

class zzr
  extends BroadcastReceiver
{
  static final String ad = zzr.class.getName();
  private boolean ae;
  private boolean af;
  private final zzx aja;
  
  zzr(zzx paramzzx)
  {
    zzab.zzaa(paramzzx);
    aja = paramzzx;
  }
  
  private Context getContext()
  {
    return aja.getContext();
  }
  
  private zzp zzbsz()
  {
    return aja.zzbsz();
  }
  
  public boolean isRegistered()
  {
    aja.zzwu();
    return ae;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    aja.zzzg();
    paramContext = paramIntent.getAction();
    zzbsz().zzbty().zzj("NetworkBroadcastReceiver received action", paramContext);
    if ("android.net.conn.CONNECTIVITY_CHANGE".equals(paramContext))
    {
      final boolean bool = aja.zzbuo().zzadj();
      if (af != bool)
      {
        af = bool;
        aja.zzbsy().zzl(new Runnable()
        {
          public void run()
          {
            zzr.zza(zzr.this).zzas(bool);
          }
        });
      }
      return;
    }
    zzbsz().zzbtt().zzj("NetworkBroadcastReceiver received unknown action", paramContext);
  }
  
  public void unregister()
  {
    aja.zzzg();
    aja.zzwu();
    if (!isRegistered()) {
      return;
    }
    zzbsz().zzbty().log("Unregistering connectivity change receiver");
    ae = false;
    af = false;
    Context localContext = getContext();
    try
    {
      localContext.unregisterReceiver(this);
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      zzbsz().zzbtr().zzj("Failed to unregister the network broadcast receiver", localIllegalArgumentException);
    }
  }
  
  public void zzadg()
  {
    aja.zzzg();
    aja.zzwu();
    if (ae) {
      return;
    }
    getContext().registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    af = aja.zzbuo().zzadj();
    zzbsz().zzbty().zzj("Registering connectivity change receiver. Network connected", Boolean.valueOf(af));
    ae = true;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.measurement.internal.zzr
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */