package com.google.android.gms.measurement;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.measurement.internal.zzu;

public final class AppMeasurementReceiver
  extends BroadcastReceiver
{
  private zzu aje;
  
  private zzu zzbql()
  {
    if (aje == null) {
      aje = new zzu();
    }
    return aje;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    zzbql().onReceive(paramContext, paramIntent);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.measurement.AppMeasurementReceiver
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */