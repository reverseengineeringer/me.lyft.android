package me.lyft.android.gcm.commands;

import android.content.Context;
import java.util.Map;
import me.lyft.android.gcm.GcmEventHandler;
import me.lyft.android.notifications.IStatusBarNotificationsService;

public class HideMessageGcmEventHandler
  implements GcmEventHandler
{
  private final IStatusBarNotificationsService statusBarNotificationsService;
  
  public HideMessageGcmEventHandler(IStatusBarNotificationsService paramIStatusBarNotificationsService)
  {
    statusBarNotificationsService = paramIStatusBarNotificationsService;
  }
  
  public void execute(Context paramContext, Map<String, String> paramMap)
  {
    statusBarNotificationsService.hideMessage(paramMap);
  }
  
  public String getEventName()
  {
    return "clear_all_messages";
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.gcm.commands.HideMessageGcmEventHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */