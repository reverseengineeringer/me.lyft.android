package me.lyft.android.infrastructure.deferred;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import me.lyft.android.infrastructure.deferred.deferredcalls.DropOffDeferredCall;
import me.lyft.android.infrastructure.deferred.deferredcalls.RateDeferredCall;
import me.lyft.android.infrastructure.json.IJsonSerializer;
import rx.Scheduler;
import rx.Scheduler.Worker;
import rx.functions.Action0;

public class DeferredCallService
  implements IDeferredCallService
{
  static final Map<String, Class<? extends IDeferredCall>> KNOWN_MAPPINGS = new HashMap() {};
  private final IDeferredSyncService deferredSyncService;
  private final PersistentQueueManager persistentQueueManager;
  private final Scheduler scheduler;
  
  public DeferredCallService(Scheduler paramScheduler, File paramFile, ICallDependencyFactory paramICallDependencyFactory, IJsonSerializer paramIJsonSerializer, IDeferredSyncService paramIDeferredSyncService)
  {
    scheduler = paramScheduler;
    deferredSyncService = paramIDeferredSyncService;
    persistentQueueManager = new PersistentQueueManager(paramFile, paramICallDependencyFactory, new CallFactory(KNOWN_MAPPINGS, paramIJsonSerializer));
  }
  
  public void add(final IDeferredCall paramIDeferredCall)
  {
    final Scheduler.Worker localWorker = scheduler.createWorker();
    localWorker.schedule(new Action0()
    {
      public void call()
      {
        if (localWorker.isUnsubscribed()) {
          return;
        }
        persistentQueueManager.add(paramIDeferredCall);
        deferredSyncService.scheduleSync();
        sync();
        localWorker.unsubscribe();
      }
    });
  }
  
  public boolean hasPendingCall()
  {
    return persistentQueueManager.hasPendingCall();
  }
  
  public void sync()
  {
    for (boolean bool = persistentQueueManager.hasPendingCall(); bool; bool = persistentQueueManager.executeNext()) {}
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.deferred.DeferredCallService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */