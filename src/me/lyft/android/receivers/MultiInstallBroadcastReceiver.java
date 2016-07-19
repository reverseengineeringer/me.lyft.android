package me.lyft.android.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.mobileapptracker.Tracker;

public class MultiInstallBroadcastReceiver
  extends BroadcastReceiver
{
  final BroadcastReceiver[] receivers = { new ReferrerBroadcastReceiver(), new Tracker() };
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    BroadcastReceiver[] arrayOfBroadcastReceiver = receivers;
    int j = arrayOfBroadcastReceiver.length;
    int i = 0;
    while (i < j)
    {
      arrayOfBroadcastReceiver[i].onReceive(paramContext, paramIntent);
      i += 1;
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.receivers.MultiInstallBroadcastReceiver
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */