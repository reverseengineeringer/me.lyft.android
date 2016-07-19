package com.paypal.android.sdk;

import java.util.UUID;

public final class ae
{
  private static String a = null;
  private static long b = 0L;
  private static long c = 0L;
  
  public static void a()
  {
    try
    {
      a = UUID.randomUUID().toString();
      b = System.currentTimeMillis();
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public static void a(long paramLong)
  {
    try
    {
      c = paramLong;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public static String b()
  {
    try
    {
      if (a == null) {
        a();
      }
      String str = a;
      return str;
    }
    finally {}
  }
  
  /* Error */
  public static boolean c()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: invokestatic 34	java/lang/System:currentTimeMillis	()J
    //   6: lstore_0
    //   7: invokestatic 41	com/paypal/android/sdk/ae:d	()J
    //   10: lstore_2
    //   11: getstatic 17	com/paypal/android/sdk/ae:c	J
    //   14: lstore 4
    //   16: lload_0
    //   17: lload_2
    //   18: lsub
    //   19: lload 4
    //   21: lcmp
    //   22: ifgt +12 -> 34
    //   25: iconst_1
    //   26: istore 6
    //   28: ldc 2
    //   30: monitorexit
    //   31: iload 6
    //   33: ireturn
    //   34: iconst_0
    //   35: istore 6
    //   37: goto -9 -> 28
    //   40: astore 7
    //   42: ldc 2
    //   44: monitorexit
    //   45: aload 7
    //   47: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   6	11	0	l1	long
    //   10	8	2	l2	long
    //   14	6	4	l3	long
    //   26	10	6	bool	boolean
    //   40	6	7	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	16	40	finally
  }
  
  private static long d()
  {
    try
    {
      if (b == 0L) {
        a();
      }
      long l = b;
      return l;
    }
    finally {}
  }
}

/* Location:
 * Qualified Name:     com.paypal.android.sdk.ae
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */