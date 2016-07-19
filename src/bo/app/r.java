package bo.app;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.appboy.Constants;
import com.appboy.services.AppboyDataSyncService;
import com.appboy.support.AppboyLogger;

public final class r
{
  private static final String a = String.format("%s.%s", new Object[] { Constants.APPBOY_LOG_TAG_PREFIX, r.class.getName() });
  private final Context b;
  private final x c;
  private final AlarmManager d;
  private final q e;
  private final BroadcastReceiver f;
  private final PendingIntent g;
  private int h;
  private long i;
  private volatile boolean j = false;
  
  public r(Context paramContext, bd parambd, x paramx, AlarmManager paramAlarmManager, q paramq)
  {
    b = paramContext;
    c = paramx;
    d = paramAlarmManager;
    e = paramq;
    h = aj.b;
    i = -1L;
    if (!fn.a(b, AppboyDataSyncService.class)) {
      AppboyLogger.e(a, String.format("Appboy periodic data flushing is not available. Declare <service android:name=\"com.appboy.services.AppboyDataSyncService\"/> in your AndroidManifest.xml to enable Appboy periodic data flushing.", new Object[0]));
    }
    paramContext = new Intent(paramContext.getApplicationContext().getPackageName() + ".REQUEST_DATA_SYNC").setClass(paramContext, AppboyDataSyncService.class);
    g = PendingIntent.getService(b, 0, paramContext, 134217728);
    f = new s(this, parambd);
    paramContext = a;
  }
  
  private void a(long paramLong)
  {
    String str;
    if (d == null)
    {
      str = a;
      return;
    }
    if (i <= 0L)
    {
      str = a;
      e();
      return;
    }
    long l1 = fg.c();
    long l2 = i;
    d.setInexactRepeating(1, l1 + paramLong, l2, g);
  }
  
  private void e()
  {
    d.cancel(g);
  }
  
  /* Error */
  public final boolean a()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_1
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 54	bo/app/r:j	Z
    //   8: ifeq +13 -> 21
    //   11: getstatic 47	bo/app/r:a	Ljava/lang/String;
    //   14: astore_2
    //   15: iconst_0
    //   16: istore_1
    //   17: aload_0
    //   18: monitorexit
    //   19: iload_1
    //   20: ireturn
    //   21: new 170	android/content/IntentFilter
    //   24: dup
    //   25: ldc -84
    //   27: invokespecial 173	android/content/IntentFilter:<init>	(Ljava/lang/String;)V
    //   30: astore_2
    //   31: aload_0
    //   32: getfield 56	bo/app/r:b	Landroid/content/Context;
    //   35: aload_0
    //   36: getfield 132	bo/app/r:f	Landroid/content/BroadcastReceiver;
    //   39: aload_2
    //   40: invokevirtual 177	android/content/Context:registerReceiver	(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;
    //   43: pop
    //   44: aload_0
    //   45: ldc2_w 178
    //   48: invokespecial 181	bo/app/r:a	(J)V
    //   51: aload_0
    //   52: iconst_1
    //   53: putfield 54	bo/app/r:j	Z
    //   56: goto -39 -> 17
    //   59: astore_2
    //   60: aload_0
    //   61: monitorexit
    //   62: aload_2
    //   63: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	64	0	this	r
    //   1	19	1	bool	boolean
    //   14	26	2	localObject1	Object
    //   59	4	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   4	15	59	finally
    //   21	56	59	finally
  }
  
  /* Error */
  public final boolean b()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 54	bo/app/r:j	Z
    //   8: ifne +11 -> 19
    //   11: getstatic 47	bo/app/r:a	Ljava/lang/String;
    //   14: astore_2
    //   15: aload_0
    //   16: monitorexit
    //   17: iload_1
    //   18: ireturn
    //   19: aload_0
    //   20: invokespecial 137	bo/app/r:e	()V
    //   23: aload_0
    //   24: getfield 56	bo/app/r:b	Landroid/content/Context;
    //   27: aload_0
    //   28: getfield 132	bo/app/r:f	Landroid/content/BroadcastReceiver;
    //   31: invokevirtual 185	android/content/Context:unregisterReceiver	(Landroid/content/BroadcastReceiver;)V
    //   34: aload_0
    //   35: iconst_0
    //   36: putfield 54	bo/app/r:j	Z
    //   39: iconst_1
    //   40: istore_1
    //   41: goto -26 -> 15
    //   44: astore_2
    //   45: aload_0
    //   46: monitorexit
    //   47: aload_2
    //   48: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	49	0	this	r
    //   1	40	1	bool	boolean
    //   14	1	2	str	String
    //   44	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   4	15	44	finally
    //   19	39	44	finally
  }
  
  final void c()
  {
    long l = i;
    switch (v.a[c.a().ordinal()])
    {
    default: 
      i = (e.getIntValue("com_appboy_data_flush_interval_good_network", 30) * 1000);
    }
    for (;;)
    {
      if (h == aj.b) {
        i = -1L;
      }
      if (l != i)
      {
        a(i);
        String str = a;
        String.format("Dispatch state has changed from %d to %d.", new Object[] { Long.valueOf(l), Long.valueOf(i) });
      }
      return;
      i = -1L;
      continue;
      i = (e.getIntValue("com_appboy_data_flush_interval_bad_network", 60) * 1000);
      continue;
      i = (e.getIntValue("com_appboy_data_flush_interval_great_network", 10) * 1000);
    }
  }
}

/* Location:
 * Qualified Name:     bo.app.r
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */