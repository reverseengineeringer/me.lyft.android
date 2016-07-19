package me.lyft.android.gcm;

import android.content.Context;
import java.util.Map;

public abstract interface GcmEventHandler
{
  public static final String HIDE_MESSAGE_EVENT = "clear_all_messages";
  public static final String PRICING_UPDATE_EVENT = "pricingUpdate";
  public static final String RIDE_UPDATE_EVENT = "rideUpdate";
  public static final String SHOW_MESSAGE_EVENT = "message";
  public static final String START_SERVICE_EVENT = "start_service";
  
  public abstract void execute(Context paramContext, Map<String, String> paramMap);
  
  public abstract String getEventName();
}

/* Location:
 * Qualified Name:     me.lyft.android.gcm.GcmEventHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */