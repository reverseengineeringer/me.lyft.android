package com.google.android.gms.common;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

class GooglePlayServicesUtil$zza
  extends Handler
{
  private final Context zzaqj;
  
  GooglePlayServicesUtil$zza(Context paramContext) {}
  
  public void handleMessage(Message paramMessage)
  {
    int i;
    switch (what)
    {
    default: 
      i = what;
      Log.w("GooglePlayServicesUtil", 50 + "Don't know how to handle this message: " + i);
    }
    do
    {
      return;
      i = GooglePlayServicesUtil.isGooglePlayServicesAvailable(zzaqj);
    } while (!GooglePlayServicesUtil.isUserRecoverableError(i));
    GooglePlayServicesUtil.zzb(i, zzaqj);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.GooglePlayServicesUtil.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */