package me.lyft.android.gcm.commands;

import android.content.Context;
import java.util.Map;
import me.lyft.android.gcm.GcmEventHandler;
import me.lyft.android.services.AppService;

public class StartServiceGcmEventHandler
  implements GcmEventHandler
{
  public void execute(Context paramContext, Map<String, String> paramMap)
  {
    AppService.start(paramContext);
  }
  
  public String getEventName()
  {
    return "start_service";
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.gcm.commands.StartServiceGcmEventHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */