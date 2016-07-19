package com.google.firebase.iid;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

class FirebaseInstanceIdService$1
  extends BroadcastReceiver
{
  FirebaseInstanceIdService$1(FirebaseInstanceIdService paramFirebaseInstanceIdService, int paramInt) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (FirebaseInstanceIdService.zzem(paramContext))
    {
      if (FirebaseInstanceIdService.zza(baP)) {
        Log.d("FirebaseInstanceId", "connectivity changed. starting background sync.");
      }
      baP.getApplicationContext().unregisterReceiver(this);
      paramContext.sendBroadcast(FirebaseInstanceIdService.zzadt(baO));
    }
  }
}

/* Location:
 * Qualified Name:     com.google.firebase.iid.FirebaseInstanceIdService.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */