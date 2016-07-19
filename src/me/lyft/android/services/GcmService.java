package me.lyft.android.services;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.inject.Inject;
import me.lyft.android.LyftApplication;
import me.lyft.android.development.IDeveloperTools;
import me.lyft.android.gcm.IGcmEventExecutor;
import me.lyft.android.logging.L;
import rx.Scheduler;
import rx.Scheduler.Worker;
import rx.functions.Action0;
import rx.schedulers.Schedulers;

public class GcmService
  extends FirebaseMessagingService
{
  @Inject
  IDeveloperTools developerTools;
  @Inject
  IGcmEventExecutor gcmEventExecutor;
  
  private void handleMessage(String paramString, Map<String, String> paramMap)
  {
    Object localObject = paramMap.keySet();
    if (developerTools.isDeveloperMode())
    {
      paramString = new StringBuilder();
      localObject = ((Set)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str1 = (String)((Iterator)localObject).next();
        String str2 = ((String)paramMap.get(str1)).toString();
        paramString.append(" ").append(str1).append(": ").append(str2);
      }
      L.d("onMessage: " + paramString.toString(), new Object[0]);
    }
    gcmEventExecutor.handleEvent(this, paramMap);
  }
  
  public LyftApplication getLyftApplication()
  {
    return (LyftApplication)getApplicationContext();
  }
  
  public void onCreate()
  {
    super.onCreate();
    getLyftApplication().inject(this);
  }
  
  public void onMessageReceived(final RemoteMessage paramRemoteMessage)
  {
    super.onMessageReceived(paramRemoteMessage);
    L.d("onMessageReceived", new Object[0]);
    if (paramRemoteMessage.getData().isEmpty()) {
      return;
    }
    final Scheduler.Worker localWorker = Schedulers.io().createWorker();
    localWorker.schedule(new Action0()
    {
      public void call()
      {
        GcmService.this.handleMessage(paramRemoteMessage.getFrom(), paramRemoteMessage.getData());
        localWorker.unsubscribe();
      }
    });
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.services.GcmService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */