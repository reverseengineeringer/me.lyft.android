package bo.app;

import android.os.Handler;
import android.os.Looper;

public class hv
{
  public static final String a = hv.class.getSimpleName();
  private static volatile hv e;
  public hw b;
  public ib c;
  public jp d = new jr();
  
  public static Handler a(ht paramht)
  {
    Handler localHandler = r;
    if (s) {
      paramht = null;
    }
    do
    {
      do
      {
        return paramht;
        paramht = localHandler;
      } while (localHandler != null);
      paramht = localHandler;
    } while (Looper.myLooper() != Looper.getMainLooper());
    return new Handler();
  }
  
  public static hv a()
  {
    if (e == null) {}
    try
    {
      if (e == null) {
        e = new hv();
      }
      return e;
    }
    finally {}
  }
  
  /* Error */
  public final void a(hw paramhw)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 63	bo/app/hv:b	Lbo/app/hw;
    //   6: ifnonnull +32 -> 38
    //   9: ldc 65
    //   11: iconst_0
    //   12: anewarray 4	java/lang/Object
    //   15: invokestatic 70	bo/app/jx:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   18: aload_0
    //   19: new 72	bo/app/ib
    //   22: dup
    //   23: aload_1
    //   24: invokespecial 74	bo/app/ib:<init>	(Lbo/app/hw;)V
    //   27: putfield 76	bo/app/hv:c	Lbo/app/ib;
    //   30: aload_0
    //   31: aload_1
    //   32: putfield 63	bo/app/hv:b	Lbo/app/hw;
    //   35: aload_0
    //   36: monitorexit
    //   37: return
    //   38: ldc 78
    //   40: iconst_0
    //   41: anewarray 4	java/lang/Object
    //   44: invokestatic 80	bo/app/jx:c	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   47: goto -12 -> 35
    //   50: astore_1
    //   51: aload_0
    //   52: monitorexit
    //   53: aload_1
    //   54: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	55	0	this	hv
    //   0	55	1	paramhw	hw
    // Exception table:
    //   from	to	target	type
    //   2	35	50	finally
    //   38	47	50	finally
  }
}

/* Location:
 * Qualified Name:     bo.app.hv
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */