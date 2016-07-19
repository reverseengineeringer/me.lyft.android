package me.lyft.android.services;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class LyftDriverToggleService$8
  extends BroadcastReceiver
{
  LyftDriverToggleService$8(LyftDriverToggleService paramLyftDriverToggleService) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent.getAction().equals("android.intent.action.SCREEN_OFF")) {
      LyftDriverToggleService.access$1400(this$0);
    }
    while (!paramIntent.getAction().equals("android.intent.action.USER_PRESENT")) {
      return;
    }
    LyftDriverToggleService.access$1500(this$0);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.services.LyftDriverToggleService.8
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */