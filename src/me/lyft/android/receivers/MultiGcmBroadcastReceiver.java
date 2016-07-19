package me.lyft.android.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.appboy.AppboyGcmReceiver;

public class MultiGcmBroadcastReceiver
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    new AppboyGcmReceiver().onReceive(paramContext, paramIntent);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.receivers.MultiGcmBroadcastReceiver
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */