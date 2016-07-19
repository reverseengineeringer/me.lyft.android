package com.squareup.picasso;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;

class Dispatcher$NetworkBroadcastReceiver
  extends BroadcastReceiver
{
  static final String EXTRA_AIRPLANE_STATE = "state";
  private final Dispatcher dispatcher;
  
  Dispatcher$NetworkBroadcastReceiver(Dispatcher paramDispatcher)
  {
    dispatcher = paramDispatcher;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null) {}
    String str;
    do
    {
      do
      {
        return;
        str = paramIntent.getAction();
        if (!"android.intent.action.AIRPLANE_MODE".equals(str)) {
          break;
        }
      } while (!paramIntent.hasExtra("state"));
      dispatcher.dispatchAirplaneModeChange(paramIntent.getBooleanExtra("state", false));
      return;
    } while (!"android.net.conn.CONNECTIVITY_CHANGE".equals(str));
    paramContext = (ConnectivityManager)Utils.getService(paramContext, "connectivity");
    dispatcher.dispatchNetworkStateChange(paramContext.getActiveNetworkInfo());
  }
  
  void register()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.intent.action.AIRPLANE_MODE");
    if (dispatcher.scansNetworkChanges) {
      localIntentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
    }
    dispatcher.context.registerReceiver(this, localIntentFilter);
  }
  
  void unregister()
  {
    dispatcher.context.unregisterReceiver(this);
  }
}

/* Location:
 * Qualified Name:     com.squareup.picasso.Dispatcher.NetworkBroadcastReceiver
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */