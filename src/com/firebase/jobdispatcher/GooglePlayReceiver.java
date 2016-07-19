package com.firebase.jobdispatcher;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v4.util.SimpleArrayMap;
import android.util.Log;

public final class GooglePlayReceiver
  extends ExternalReceiver
{
  private GooglePlayCallbackExtractor callbackExtractor = new GooglePlayCallbackExtractor();
  private SimpleArrayMap<String, SimpleArrayMap<String, JobCallback>> callbacks = new SimpleArrayMap(1);
  private final JobCoder prefixedCoder = new JobCoder("com.firebase.jobdispatcher.", true);
  
  private JobParameters prepareJob(Intent paramIntent)
  {
    paramIntent = paramIntent.getExtras();
    if (paramIntent == null)
    {
      Log.e("FJD.GooglePlayReceiver", "No data provided, terminating");
      return null;
    }
    JobCallback localJobCallback = callbackExtractor.extractCallback(paramIntent);
    if (localJobCallback == null)
    {
      Log.i("FJD.GooglePlayReceiver", "no callback found");
      return null;
    }
    paramIntent = paramIntent.getBundle("extras");
    if (paramIntent == null)
    {
      Log.i("FJD.GooglePlayReceiver", "no 'extras' bundle found");
      sendResultSafely(localJobCallback, 2);
      return null;
    }
    JobInvocation localJobInvocation = prefixedCoder.decode(paramIntent);
    if (localJobInvocation == null)
    {
      Log.i("FJD.GooglePlayReceiver", "unable to decode job from extras");
      sendResultSafely(localJobCallback, 2);
      return null;
    }
    localJobInvocation.getExtras().putAll(paramIntent);
    try
    {
      SimpleArrayMap localSimpleArrayMap = (SimpleArrayMap)callbacks.get(localJobInvocation.getService());
      paramIntent = localSimpleArrayMap;
      if (localSimpleArrayMap == null)
      {
        paramIntent = new SimpleArrayMap(1);
        callbacks.put(localJobInvocation.getService(), paramIntent);
      }
      paramIntent.put(localJobInvocation.getTag(), localJobCallback);
      return localJobInvocation;
    }
    finally {}
  }
  
  private static void sendResultSafely(JobCallback paramJobCallback, int paramInt)
  {
    try
    {
      paramJobCallback.jobFinished(paramInt);
      return;
    }
    catch (Throwable paramJobCallback)
    {
      Log.e("FJD.GooglePlayReceiver", "Encountered error running callback", paramJobCallback.getCause());
    }
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    return null;
  }
  
  protected void onJobFinished(JobParameters paramJobParameters, int paramInt)
  {
    try
    {
      SimpleArrayMap localSimpleArrayMap = (SimpleArrayMap)callbacks.get(paramJobParameters.getService());
      if (localSimpleArrayMap == null) {
        return;
      }
      JobCallback localJobCallback = (JobCallback)localSimpleArrayMap.remove(paramJobParameters.getTag());
      if (localJobCallback != null)
      {
        Log.i("FJD.GooglePlayReceiver", "sending jobFinished for " + paramJobParameters.getTag() + " = " + paramInt);
        localJobCallback.jobFinished(paramInt);
      }
      if (localSimpleArrayMap.isEmpty()) {
        callbacks.remove(paramJobParameters.getService());
      }
      return;
    }
    finally {}
  }
  
  /* Error */
  public final int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: iload_2
    //   3: iload_3
    //   4: invokespecial 158	com/firebase/jobdispatcher/ExternalReceiver:onStartCommand	(Landroid/content/Intent;II)I
    //   7: pop
    //   8: aload_1
    //   9: ifnonnull +37 -> 46
    //   12: ldc 47
    //   14: ldc -96
    //   16: invokestatic 163	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   19: pop
    //   20: aload_0
    //   21: monitorenter
    //   22: aload_0
    //   23: getfield 36	com/firebase/jobdispatcher/GooglePlayReceiver:callbacks	Landroid/support/v4/util/SimpleArrayMap;
    //   26: invokevirtual 154	android/support/v4/util/SimpleArrayMap:isEmpty	()Z
    //   29: ifeq +8 -> 37
    //   32: aload_0
    //   33: iload_3
    //   34: invokevirtual 166	com/firebase/jobdispatcher/GooglePlayReceiver:stopSelf	(I)V
    //   37: aload_0
    //   38: monitorexit
    //   39: iconst_2
    //   40: ireturn
    //   41: astore_1
    //   42: aload_0
    //   43: monitorexit
    //   44: aload_1
    //   45: athrow
    //   46: aload_1
    //   47: invokevirtual 169	android/content/Intent:getAction	()Ljava/lang/String;
    //   50: astore 5
    //   52: ldc -85
    //   54: aload 5
    //   56: invokevirtual 177	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   59: ifeq +39 -> 98
    //   62: aload_0
    //   63: aload_0
    //   64: aload_1
    //   65: invokespecial 179	com/firebase/jobdispatcher/GooglePlayReceiver:prepareJob	(Landroid/content/Intent;)Lcom/firebase/jobdispatcher/JobParameters;
    //   68: invokevirtual 183	com/firebase/jobdispatcher/GooglePlayReceiver:executeJob	(Lcom/firebase/jobdispatcher/JobParameters;)Z
    //   71: pop
    //   72: aload_0
    //   73: monitorenter
    //   74: aload_0
    //   75: getfield 36	com/firebase/jobdispatcher/GooglePlayReceiver:callbacks	Landroid/support/v4/util/SimpleArrayMap;
    //   78: invokevirtual 154	android/support/v4/util/SimpleArrayMap:isEmpty	()Z
    //   81: ifeq +8 -> 89
    //   84: aload_0
    //   85: iload_3
    //   86: invokevirtual 166	com/firebase/jobdispatcher/GooglePlayReceiver:stopSelf	(I)V
    //   89: aload_0
    //   90: monitorexit
    //   91: iconst_2
    //   92: ireturn
    //   93: astore_1
    //   94: aload_0
    //   95: monitorexit
    //   96: aload_1
    //   97: athrow
    //   98: ldc -71
    //   100: aload 5
    //   102: invokevirtual 177	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   105: istore 4
    //   107: iload 4
    //   109: ifeq +29 -> 138
    //   112: aload_0
    //   113: monitorenter
    //   114: aload_0
    //   115: getfield 36	com/firebase/jobdispatcher/GooglePlayReceiver:callbacks	Landroid/support/v4/util/SimpleArrayMap;
    //   118: invokevirtual 154	android/support/v4/util/SimpleArrayMap:isEmpty	()Z
    //   121: ifeq +8 -> 129
    //   124: aload_0
    //   125: iload_3
    //   126: invokevirtual 166	com/firebase/jobdispatcher/GooglePlayReceiver:stopSelf	(I)V
    //   129: aload_0
    //   130: monitorexit
    //   131: iconst_2
    //   132: ireturn
    //   133: astore_1
    //   134: aload_0
    //   135: monitorexit
    //   136: aload_1
    //   137: athrow
    //   138: ldc 47
    //   140: ldc -69
    //   142: invokestatic 55	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   145: pop
    //   146: aload_0
    //   147: monitorenter
    //   148: aload_0
    //   149: getfield 36	com/firebase/jobdispatcher/GooglePlayReceiver:callbacks	Landroid/support/v4/util/SimpleArrayMap;
    //   152: invokevirtual 154	android/support/v4/util/SimpleArrayMap:isEmpty	()Z
    //   155: ifeq +8 -> 163
    //   158: aload_0
    //   159: iload_3
    //   160: invokevirtual 166	com/firebase/jobdispatcher/GooglePlayReceiver:stopSelf	(I)V
    //   163: aload_0
    //   164: monitorexit
    //   165: iconst_2
    //   166: ireturn
    //   167: astore_1
    //   168: aload_0
    //   169: monitorexit
    //   170: aload_1
    //   171: athrow
    //   172: astore_1
    //   173: aload_0
    //   174: monitorenter
    //   175: aload_0
    //   176: getfield 36	com/firebase/jobdispatcher/GooglePlayReceiver:callbacks	Landroid/support/v4/util/SimpleArrayMap;
    //   179: invokevirtual 154	android/support/v4/util/SimpleArrayMap:isEmpty	()Z
    //   182: ifeq +8 -> 190
    //   185: aload_0
    //   186: iload_3
    //   187: invokevirtual 166	com/firebase/jobdispatcher/GooglePlayReceiver:stopSelf	(I)V
    //   190: aload_0
    //   191: monitorexit
    //   192: aload_1
    //   193: athrow
    //   194: astore_1
    //   195: aload_0
    //   196: monitorexit
    //   197: aload_1
    //   198: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	199	0	this	GooglePlayReceiver
    //   0	199	1	paramIntent	Intent
    //   0	199	2	paramInt1	int
    //   0	199	3	paramInt2	int
    //   105	3	4	bool	boolean
    //   50	51	5	str	String
    // Exception table:
    //   from	to	target	type
    //   22	37	41	finally
    //   37	39	41	finally
    //   42	44	41	finally
    //   74	89	93	finally
    //   89	91	93	finally
    //   94	96	93	finally
    //   114	129	133	finally
    //   129	131	133	finally
    //   134	136	133	finally
    //   148	163	167	finally
    //   163	165	167	finally
    //   168	170	167	finally
    //   0	8	172	finally
    //   12	20	172	finally
    //   46	72	172	finally
    //   98	107	172	finally
    //   138	146	172	finally
    //   175	190	194	finally
    //   190	192	194	finally
    //   195	197	194	finally
  }
}

/* Location:
 * Qualified Name:     com.firebase.jobdispatcher.GooglePlayReceiver
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */