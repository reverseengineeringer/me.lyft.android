package me.lyft.android.services;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class LyftDriverToggleService$7
  extends BroadcastReceiver
{
  LyftDriverToggleService$7(LyftDriverToggleService paramLyftDriverToggleService) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    LyftDriverToggleService.stopService(paramContext);
    LyftDriverToggleService.startService(paramContext);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.services.LyftDriverToggleService.7
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */