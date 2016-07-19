package com.google.firebase.iid;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import com.google.firebase.FirebaseApp;
import java.io.IOException;

public class FirebaseInstanceIdService
  extends zzb
{
  private static BroadcastReceiver baK;
  private static final Object baL = new Object();
  private static boolean baM = false;
  private boolean baN = false;
  
  static void zza(Context paramContext, FirebaseInstanceId paramFirebaseInstanceId)
  {
    synchronized (baL)
    {
      if (baM) {
        return;
      }
      if ((paramFirebaseInstanceId.zzcwv() == null) || (paramFirebaseInstanceId.zzcwx().zzcxc() != null))
      {
        zzek(paramContext);
        return;
      }
    }
  }
  
  private void zza(Intent paramIntent, boolean paramBoolean)
  {
    zze localzze;
    synchronized (baL)
    {
      baM = false;
      ??? = FirebaseInstanceId.getInstance();
      localzze = ((FirebaseInstanceId)???).zzcwx();
      if (((FirebaseInstanceId)???).zzcwv() != null) {
        break label107;
      }
    }
    try
    {
      if (((FirebaseInstanceId)???).zzcww() != null)
      {
        if (baN) {
          Log.d("FirebaseInstanceId", "get master token succeeded");
        }
        zza(this, (FirebaseInstanceId)???);
        onTokenRefresh();
        return;
        paramIntent = finally;
        throw paramIntent;
      }
      zzd(paramIntent, "returned token is null");
      return;
    }
    catch (IOException localIOException1)
    {
      zzd(paramIntent, localIOException1.getMessage());
      return;
    }
    catch (SecurityException paramIntent)
    {
      Log.e("FirebaseInstanceId", "Unable to get master token", paramIntent);
      return;
    }
    label107:
    String str = localzze.zzcxc();
    if (str != null)
    {
      Object localObject3 = str.split("!");
      Object localObject2;
      int j;
      if (localObject3.length == 2)
      {
        localObject2 = localObject3[0];
        localObject3 = localObject3[1];
        j = -1;
      }
      for (;;)
      {
        try
        {
          int k = ((String)localObject2).hashCode();
          int i = j;
          switch (k)
          {
          default: 
            i = j;
          case 84: 
            switch (i)
            {
            default: 
              localzze.zzsj(str);
              str = localzze.zzcxc();
            }
            break;
          case 83: 
            i = j;
            if (!((String)localObject2).equals("S")) {
              continue;
            }
            i = 0;
            break;
          case 85: 
            i = j;
            if (!((String)localObject2).equals("U")) {
              continue;
            }
            i = 1;
            continue;
            FirebaseInstanceId.getInstance().zzsg((String)localObject3);
            if (!baN) {
              continue;
            }
            Log.d("FirebaseInstanceId", "subscribe operation succeeded");
            continue;
            FirebaseInstanceId.getInstance().zzsh((String)localObject3);
          }
        }
        catch (IOException localIOException2)
        {
          zzd(paramIntent, localIOException2.getMessage());
          return;
        }
        if (baN) {
          Log.d("FirebaseInstanceId", "unsubscribe operation succeeded");
        }
      }
    }
    Log.d("FirebaseInstanceId", "topic sync succeeded");
  }
  
  private String zzac(Intent paramIntent)
  {
    String str = paramIntent.getStringExtra("subtype");
    paramIntent = str;
    if (str == null) {
      paramIntent = "";
    }
    return paramIntent;
  }
  
  private static Intent zzadr(int paramInt)
  {
    Context localContext = FirebaseApp.getInstance().getApplicationContext();
    Intent localIntent = new Intent("ACTION_TOKEN_REFRESH_RETRY");
    localIntent.putExtra("next_retry_delay_in_seconds", paramInt);
    return FirebaseInstanceIdInternalReceiver.zzh(localContext, localIntent);
  }
  
  private void zzads(int paramInt)
  {
    AlarmManager localAlarmManager = (AlarmManager)getSystemService("alarm");
    PendingIntent localPendingIntent = PendingIntent.getBroadcast(this, 0, zzadr(paramInt * 2), 268435456);
    localAlarmManager.set(3, SystemClock.elapsedRealtime() + paramInt * 1000, localPendingIntent);
  }
  
  private int zzb(Intent paramIntent, boolean paramBoolean)
  {
    int j = 10;
    int i;
    if (paramIntent == null)
    {
      i = 10;
      if ((i >= 10) || (paramBoolean)) {
        break label39;
      }
      j = 30;
    }
    label39:
    while (i < 10)
    {
      return j;
      i = paramIntent.getIntExtra("next_retry_delay_in_seconds", 0);
      break;
    }
    if (i > 28800) {
      return 28800;
    }
    return i;
  }
  
  private void zzd(Intent arg1, String paramString)
  {
    boolean bool = zzel(this);
    final int i = zzb(???, bool);
    Log.d("FirebaseInstanceId", String.valueOf(paramString).length() + 47 + "background sync failed: " + paramString + ", retry in " + i + "s");
    synchronized (baL)
    {
      zzads(i);
      baM = true;
      if (!bool)
      {
        if (baN) {
          Log.d("FirebaseInstanceId", "device not connected. Connectivity change received registered");
        }
        if (baK == null) {
          baK = new BroadcastReceiver()
          {
            public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
            {
              if (FirebaseInstanceIdService.zzem(paramAnonymousContext))
              {
                if (FirebaseInstanceIdService.zza(FirebaseInstanceIdService.this)) {
                  Log.d("FirebaseInstanceId", "connectivity changed. starting background sync.");
                }
                getApplicationContext().unregisterReceiver(this);
                paramAnonymousContext.sendBroadcast(FirebaseInstanceIdService.zzadt(i));
              }
            }
          };
        }
        getApplicationContext().registerReceiver(baK, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
      }
      return;
    }
  }
  
  static void zzek(Context paramContext)
  {
    synchronized (baL)
    {
      if (!baM)
      {
        paramContext.sendBroadcast(zzadr(0));
        baM = true;
      }
      return;
    }
  }
  
  private static boolean zzel(Context paramContext)
  {
    paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
    return (paramContext != null) && (paramContext.isConnected());
  }
  
  private zzd zzsi(String paramString)
  {
    if (paramString == null) {
      return zzd.zzb(this, null);
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("subtype", paramString);
    return zzd.zzb(this, localBundle);
  }
  
  public void onTokenRefresh() {}
  
  protected int zzaa(Intent paramIntent)
  {
    baN = Log.isLoggable("FirebaseInstanceId", 3);
    if ((paramIntent.getStringExtra("error") != null) || (paramIntent.getStringExtra("registration_id") != null))
    {
      String str2 = zzac(paramIntent);
      if (baN)
      {
        str1 = String.valueOf(str2);
        if (str1.length() == 0) {
          break label88;
        }
      }
      label88:
      for (String str1 = "Register result in service ".concat(str1);; str1 = new String("Register result in service "))
      {
        Log.d("FirebaseInstanceId", str1);
        zzsi(str2).zzcxb().zzu(paramIntent);
        zzbmb();
        return 2;
      }
    }
    return super.zzaa(paramIntent);
  }
  
  public void zzab(Intent paramIntent)
  {
    String str2 = zzac(paramIntent);
    zzd localzzd = zzsi(str2);
    String str1 = paramIntent.getStringExtra("CMD");
    Object localObject;
    if (baN)
    {
      localObject = String.valueOf(paramIntent.getExtras());
      Log.d("FirebaseInstanceId", String.valueOf(str2).length() + 18 + String.valueOf(str1).length() + String.valueOf(localObject).length() + "Service command " + str2 + " " + str1 + " " + (String)localObject);
    }
    if (paramIntent.getStringExtra("unregistered") != null)
    {
      localObject = localzzd.zzcxa();
      str1 = str2;
      if (str2 == null) {
        str1 = "";
      }
      ((zzg)localObject).zzkk(str1);
      localzzd.zzcxb().zzu(paramIntent);
    }
    do
    {
      do
      {
        return;
        if ("gcm.googleapis.com/refresh".equals(paramIntent.getStringExtra("from")))
        {
          localzzd.zzcxa().zzkk(str2);
          zza(paramIntent, false);
          return;
        }
        if ("RST".equals(str1))
        {
          localzzd.zzbmu();
          zza(paramIntent, true);
          return;
        }
        if (!"RST_FULL".equals(str1)) {
          break;
        }
      } while (localzzd.zzcxa().isEmpty());
      localzzd.zzcxa().zzbna();
      zza(paramIntent, true);
      return;
      if ("SYNC".equals(str1))
      {
        localzzd.zzcxa().zzkk(str2);
        zza(paramIntent, false);
        return;
      }
    } while (!"PING".equals(str1));
  }
  
  public void zzm(Intent paramIntent)
  {
    String str2 = paramIntent.getAction();
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    switch (str1.hashCode())
    {
    }
    label40:
    for (int i = -1;; i = 0) {
      switch (i)
      {
      default: 
        zzab(paramIntent);
        return;
        if (!str1.equals("ACTION_TOKEN_REFRESH_RETRY")) {
          break label40;
        }
      }
    }
    zza(paramIntent, false);
  }
  
  protected Intent zzz(Intent paramIntent)
  {
    return FirebaseInstanceIdInternalReceiver.zzcwy();
  }
}

/* Location:
 * Qualified Name:     com.google.firebase.iid.FirebaseInstanceIdService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */