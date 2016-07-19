package io.fabric.sdk.android;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import io.fabric.sdk.android.services.common.IdManager;
import io.fabric.sdk.android.services.concurrency.PriorityThreadPoolExecutor;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Fabric$Builder
{
  private String appIdentifier;
  private String appInstallIdentifier;
  private final Context context;
  private boolean debuggable;
  private Handler handler;
  private InitializationCallback<Fabric> initializationCallback;
  private Kit[] kits;
  private Logger logger;
  private PriorityThreadPoolExecutor threadPoolExecutor;
  
  public Fabric$Builder(Context paramContext)
  {
    if (paramContext == null) {
      throw new IllegalArgumentException("Context must not be null.");
    }
    context = paramContext.getApplicationContext();
  }
  
  public Fabric build()
  {
    if (threadPoolExecutor == null) {
      threadPoolExecutor = PriorityThreadPoolExecutor.create();
    }
    if (handler == null) {
      handler = new Handler(Looper.getMainLooper());
    }
    if (logger == null)
    {
      if (debuggable) {
        logger = new DefaultLogger(3);
      }
    }
    else
    {
      if (appIdentifier == null) {
        appIdentifier = context.getPackageName();
      }
      if (initializationCallback == null) {
        initializationCallback = InitializationCallback.EMPTY;
      }
      if (kits != null) {
        break label182;
      }
    }
    label182:
    for (Object localObject = new HashMap();; localObject = Fabric.access$000(Arrays.asList(kits)))
    {
      IdManager localIdManager = new IdManager(context, appIdentifier, appInstallIdentifier, ((Map)localObject).values());
      return new Fabric(context, (Map)localObject, threadPoolExecutor, handler, logger, debuggable, initializationCallback, localIdManager);
      logger = new DefaultLogger();
      break;
    }
  }
  
  public Builder kits(Kit... paramVarArgs)
  {
    if (kits != null) {
      throw new IllegalStateException("Kits already set.");
    }
    kits = paramVarArgs;
    return this;
  }
}

/* Location:
 * Qualified Name:     io.fabric.sdk.android.Fabric.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */