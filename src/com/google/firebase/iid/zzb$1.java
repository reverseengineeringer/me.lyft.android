package com.google.firebase.iid;

import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.iid.MessengerCompat;

class zzb$1
  extends Handler
{
  zzb$1(zzb paramzzb, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    int i = MessengerCompat.zzc(paramMessage);
    zzf.zzdi(baC);
    baC.getPackageManager();
    if ((i != zzf.ach) && (i != zzf.acg))
    {
      int j = zzf.acg;
      int k = zzf.ach;
      Log.w("FirebaseInstanceId", 77 + "Message from unexpected caller " + i + " mine=" + j + " appid=" + k);
      return;
    }
    baC.zzm((Intent)obj);
  }
}

/* Location:
 * Qualified Name:     com.google.firebase.iid.zzb.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */