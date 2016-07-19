package com.paypal.android.sdk;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class bc
  extends Thread
{
  private static final String a = bc.class.getSimpleName();
  private bh b;
  private String c;
  private List d = Collections.synchronizedList(new LinkedList());
  private boolean e;
  private aW f;
  private aY g;
  
  public bc(String paramString, bh parambh, aW paramaW, aY paramaY)
  {
    c = paramString;
    b = parambh;
    f = paramaW;
    g = paramaY;
    start();
  }
  
  public final void a()
  {
    if (e) {}
    for (;;)
    {
      return;
      g.a();
      e = true;
      synchronized (d)
      {
        d.notifyAll();
        interrupt();
        while (isAlive()) {
          try
          {
            Thread.sleep(10L);
            new StringBuilder("Waiting for ").append(getClass().getSimpleName()).append(" to die");
          }
          catch (InterruptedException localInterruptedException) {}
        }
      }
    }
  }
  
  public final void a(bg parambg)
  {
    synchronized (d)
    {
      d.add(parambg);
      new StringBuilder("Queued ").append(parambg.o());
      d.notifyAll();
      return;
    }
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: new 82	java/lang/StringBuilder
    //   3: dup
    //   4: ldc 118
    //   6: invokespecial 87	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   9: aload_0
    //   10: invokevirtual 91	java/lang/Object:getClass	()Ljava/lang/Class;
    //   13: invokevirtual 25	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   16: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19: pop
    //   20: aload_0
    //   21: getfield 58	com/paypal/android/sdk/bc:e	Z
    //   24: ifne +195 -> 219
    //   27: aload_0
    //   28: getfield 43	com/paypal/android/sdk/bc:d	Ljava/util/List;
    //   31: astore_3
    //   32: aload_3
    //   33: monitorenter
    //   34: aload_0
    //   35: getfield 43	com/paypal/android/sdk/bc:d	Ljava/util/List;
    //   38: invokeinterface 121 1 0
    //   43: istore_1
    //   44: iload_1
    //   45: ifeq +72 -> 117
    //   48: aload_0
    //   49: getfield 43	com/paypal/android/sdk/bc:d	Ljava/util/List;
    //   52: invokevirtual 124	java/lang/Object:wait	()V
    //   55: aconst_null
    //   56: astore_2
    //   57: aload_3
    //   58: monitorexit
    //   59: aload_2
    //   60: ifnull -40 -> 20
    //   63: aload_2
    //   64: aload_2
    //   65: invokevirtual 126	com/paypal/android/sdk/bg:b	()Ljava/lang/String;
    //   68: invokevirtual 128	com/paypal/android/sdk/bg:a	(Ljava/lang/String;)V
    //   71: aload_0
    //   72: getfield 45	com/paypal/android/sdk/bc:c	Ljava/lang/String;
    //   75: ldc -126
    //   77: invokevirtual 135	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   80: ifeq +131 -> 211
    //   83: aload_0
    //   84: getfield 49	com/paypal/android/sdk/bc:f	Lcom/paypal/android/sdk/aW;
    //   87: astore_3
    //   88: aload_3
    //   89: aload_2
    //   90: invokeinterface 140 2 0
    //   95: ifne -75 -> 20
    //   98: aload_0
    //   99: getfield 47	com/paypal/android/sdk/bc:b	Lcom/paypal/android/sdk/bh;
    //   102: aload_2
    //   103: invokeinterface 144 2 0
    //   108: goto -88 -> 20
    //   111: astore_2
    //   112: aconst_null
    //   113: astore_2
    //   114: goto -57 -> 57
    //   117: aload_0
    //   118: getfield 43	com/paypal/android/sdk/bc:d	Ljava/util/List;
    //   121: iconst_0
    //   122: invokeinterface 148 2 0
    //   127: checkcast 108	com/paypal/android/sdk/bg
    //   130: astore_2
    //   131: goto -74 -> 57
    //   134: astore_2
    //   135: aload_3
    //   136: monitorexit
    //   137: aload_2
    //   138: athrow
    //   139: astore_3
    //   140: ldc -106
    //   142: ldc -104
    //   144: aload_3
    //   145: invokestatic 157	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   148: pop
    //   149: aload_2
    //   150: new 159	com/paypal/android/sdk/aB
    //   153: dup
    //   154: getstatic 164	com/paypal/android/sdk/aA:c	Lcom/paypal/android/sdk/aA;
    //   157: invokevirtual 167	com/paypal/android/sdk/aA:toString	()Ljava/lang/String;
    //   160: ldc -87
    //   162: aload_3
    //   163: invokevirtual 172	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   166: invokespecial 175	com/paypal/android/sdk/aB:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   169: invokevirtual 178	com/paypal/android/sdk/bg:a	(Lcom/paypal/android/sdk/az;)V
    //   172: goto -101 -> 71
    //   175: astore_3
    //   176: ldc -106
    //   178: ldc -104
    //   180: aload_3
    //   181: invokestatic 157	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   184: pop
    //   185: aload_2
    //   186: new 159	com/paypal/android/sdk/aB
    //   189: dup
    //   190: getstatic 164	com/paypal/android/sdk/aA:c	Lcom/paypal/android/sdk/aA;
    //   193: invokevirtual 167	com/paypal/android/sdk/aA:toString	()Ljava/lang/String;
    //   196: ldc -76
    //   198: aload_3
    //   199: invokevirtual 181	java/io/UnsupportedEncodingException:getMessage	()Ljava/lang/String;
    //   202: invokespecial 175	com/paypal/android/sdk/aB:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   205: invokevirtual 178	com/paypal/android/sdk/bg:a	(Lcom/paypal/android/sdk/az;)V
    //   208: goto -137 -> 71
    //   211: aload_0
    //   212: getfield 51	com/paypal/android/sdk/bc:g	Lcom/paypal/android/sdk/aY;
    //   215: astore_3
    //   216: goto -128 -> 88
    //   219: new 82	java/lang/StringBuilder
    //   222: dup
    //   223: invokespecial 182	java/lang/StringBuilder:<init>	()V
    //   226: aload_0
    //   227: invokevirtual 91	java/lang/Object:getClass	()Ljava/lang/Class;
    //   230: invokevirtual 25	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   233: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   236: ldc -72
    //   238: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   241: pop
    //   242: aload_0
    //   243: getfield 51	com/paypal/android/sdk/bc:g	Lcom/paypal/android/sdk/aY;
    //   246: invokevirtual 186	com/paypal/android/sdk/aY:b	()V
    //   249: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	250	0	this	bc
    //   43	2	1	bool	boolean
    //   56	47	2	localbg1	bg
    //   111	1	2	localInterruptedException	InterruptedException
    //   113	18	2	localbg2	bg
    //   134	52	2	localObject1	Object
    //   31	105	3	localObject2	Object
    //   139	24	3	localJSONException	org.json.JSONException
    //   175	24	3	localUnsupportedEncodingException	java.io.UnsupportedEncodingException
    //   215	1	3	localaY	aY
    // Exception table:
    //   from	to	target	type
    //   48	55	111	java/lang/InterruptedException
    //   34	44	134	finally
    //   48	55	134	finally
    //   57	59	134	finally
    //   117	131	134	finally
    //   135	137	134	finally
    //   63	71	139	org/json/JSONException
    //   63	71	175	java/io/UnsupportedEncodingException
  }
}

/* Location:
 * Qualified Name:     com.paypal.android.sdk.bc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */