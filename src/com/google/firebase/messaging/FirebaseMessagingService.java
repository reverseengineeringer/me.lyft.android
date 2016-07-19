package com.google.firebase.messaging;

import android.app.PendingIntent;
import android.app.PendingIntent.CanceledException;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.google.firebase.iid.FirebaseInstanceIdInternalReceiver;
import com.google.firebase.iid.FirebaseInstanceIdReceiver;
import java.util.Iterator;
import java.util.Set;

public class FirebaseMessagingService
  extends com.google.firebase.iid.zzb
{
  static void zzab(Bundle paramBundle)
  {
    paramBundle = paramBundle.keySet().iterator();
    while (paramBundle.hasNext())
    {
      String str = (String)paramBundle.next();
      if ((str != null) && (str.startsWith("google.c."))) {
        paramBundle.remove();
      }
    }
  }
  
  private void zzad(Intent paramIntent)
  {
    PendingIntent localPendingIntent = (PendingIntent)paramIntent.getParcelableExtra("pending_intent");
    if (localPendingIntent != null) {}
    try
    {
      localPendingIntent.send();
      if (zzav(paramIntent.getExtras())) {
        zzb.zzm(this, paramIntent);
      }
      return;
    }
    catch (PendingIntent.CanceledException localCanceledException)
    {
      for (;;)
      {
        Log.e("FirebaseMessaging", "Notification pending intent canceled");
      }
    }
  }
  
  private String zzae(Intent paramIntent)
  {
    String str2 = paramIntent.getStringExtra("google.message_id");
    String str1 = str2;
    if (str2 == null) {
      str1 = paramIntent.getStringExtra("message_id");
    }
    return str1;
  }
  
  static boolean zzav(Bundle paramBundle)
  {
    return "1".equals(paramBundle.getString("google.c.a.e"));
  }
  
  private void zzn(Intent paramIntent)
  {
    String str2 = paramIntent.getStringExtra("message_type");
    String str1 = str2;
    if (str2 == null) {
      str1 = "gcm";
    }
    int i = -1;
    switch (str1.hashCode())
    {
    default: 
      switch (i)
      {
      default: 
        paramIntent = String.valueOf(str1);
        if (paramIntent.length() == 0) {}
        break;
      }
      break;
    }
    for (paramIntent = "Received message with unknown type: ".concat(paramIntent);; paramIntent = new String("Received message with unknown type: "))
    {
      Log.w("FirebaseMessaging", paramIntent);
      return;
      if (!str1.equals("gcm")) {
        break;
      }
      i = 0;
      break;
      if (!str1.equals("deleted_messages")) {
        break;
      }
      i = 1;
      break;
      if (!str1.equals("send_event")) {
        break;
      }
      i = 2;
      break;
      if (!str1.equals("send_error")) {
        break;
      }
      i = 3;
      break;
      if (zzav(paramIntent.getExtras())) {
        zzb.zzl(this, paramIntent);
      }
      zzo(paramIntent);
      return;
      onDeletedMessages();
      return;
      onMessageSent(paramIntent.getStringExtra("google.message_id"));
      return;
      onSendError(zzae(paramIntent), new SendException(paramIntent.getStringExtra("error")));
      return;
    }
  }
  
  private void zzo(Intent paramIntent)
  {
    Bundle localBundle = paramIntent.getExtras();
    localBundle.remove("android.support.content.wakelockid");
    if (zza.zzac(localBundle))
    {
      if (!zza.zzdc(this))
      {
        zza.zzeo(this).zzas(localBundle);
        return;
      }
      if (zzav(paramIntent.getExtras())) {
        zzb.zzo(this, paramIntent);
      }
    }
    onMessageReceived(new RemoteMessage(localBundle));
  }
  
  public void onDeletedMessages() {}
  
  public void onMessageReceived(RemoteMessage paramRemoteMessage) {}
  
  public void onMessageSent(String paramString) {}
  
  public void onSendError(String paramString, Exception paramException) {}
  
  protected int zzaa(Intent paramIntent)
  {
    if ("com.google.firebase.messaging.NOTIFICATION_OPEN".equals(paramIntent.getAction()))
    {
      zzad(paramIntent);
      zzbmb();
      FirebaseInstanceIdReceiver.completeWakefulIntent(paramIntent);
      return 3;
    }
    return super.zzaa(paramIntent);
  }
  
  public void zzm(Intent paramIntent)
  {
    for (;;)
    {
      int i;
      try
      {
        str1 = paramIntent.getAction();
        i = -1;
        switch (str1.hashCode())
        {
        case 366519424: 
          str1 = String.valueOf(paramIntent.getAction());
          if (str1.length() == 0) {
            break label137;
          }
          str1 = "Unknown intent action: ".concat(str1);
          Log.d("FirebaseMessaging", str1);
          zzbmb();
          return;
        }
      }
      finally
      {
        String str1;
        FirebaseInstanceIdReceiver.completeWakefulIntent(paramIntent);
      }
      if (str1.equals("com.google.android.c2dm.intent.RECEIVE"))
      {
        i = 0;
        break label150;
        if (str1.equals("com.google.firebase.messaging.NOTIFICATION_DISMISS"))
        {
          i = 1;
          break label150;
          zzn(paramIntent);
          continue;
          if (!zzav(paramIntent.getExtras())) {
            continue;
          }
          zzb.zzn(this, paramIntent);
          continue;
          label137:
          String str2 = new String("Unknown intent action: ");
          continue;
        }
      }
      label150:
      switch (i)
      {
      }
    }
  }
  
  protected Intent zzz(Intent paramIntent)
  {
    return FirebaseInstanceIdInternalReceiver.zzcwz();
  }
}

/* Location:
 * Qualified Name:     com.google.firebase.messaging.FirebaseMessagingService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */