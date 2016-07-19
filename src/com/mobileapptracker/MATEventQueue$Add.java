package com.mobileapptracker;

import org.json.JSONObject;

public class MATEventQueue$Add
  implements Runnable
{
  private String data = null;
  private boolean firstSession = false;
  private String link = null;
  private JSONObject postBody = null;
  
  protected MATEventQueue$Add(MATEventQueue paramMATEventQueue, String paramString1, String paramString2, JSONObject paramJSONObject, boolean paramBoolean)
  {
    link = paramString1;
    data = paramString2;
    postBody = paramJSONObject;
    firstSession = paramBoolean;
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 22	com/mobileapptracker/MATEventQueue$Add:this$0	Lcom/mobileapptracker/MATEventQueue;
    //   4: invokestatic 43	com/mobileapptracker/MATEventQueue:access$000	(Lcom/mobileapptracker/MATEventQueue;)Ljava/util/concurrent/Semaphore;
    //   7: invokevirtual 48	java/util/concurrent/Semaphore:acquire	()V
    //   10: new 50	org/json/JSONObject
    //   13: dup
    //   14: invokespecial 51	org/json/JSONObject:<init>	()V
    //   17: astore_2
    //   18: aload_2
    //   19: ldc 52
    //   21: aload_0
    //   22: getfield 27	com/mobileapptracker/MATEventQueue$Add:link	Ljava/lang/String;
    //   25: invokevirtual 56	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   28: pop
    //   29: aload_2
    //   30: ldc 57
    //   32: aload_0
    //   33: getfield 29	com/mobileapptracker/MATEventQueue$Add:data	Ljava/lang/String;
    //   36: invokevirtual 56	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   39: pop
    //   40: aload_2
    //   41: ldc 59
    //   43: aload_0
    //   44: getfield 31	com/mobileapptracker/MATEventQueue$Add:postBody	Lorg/json/JSONObject;
    //   47: invokevirtual 56	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   50: pop
    //   51: aload_2
    //   52: ldc 61
    //   54: aload_0
    //   55: getfield 33	com/mobileapptracker/MATEventQueue$Add:firstSession	Z
    //   58: invokevirtual 64	org/json/JSONObject:put	(Ljava/lang/String;Z)Lorg/json/JSONObject;
    //   61: pop
    //   62: aload_0
    //   63: getfield 22	com/mobileapptracker/MATEventQueue$Add:this$0	Lcom/mobileapptracker/MATEventQueue;
    //   66: invokevirtual 68	com/mobileapptracker/MATEventQueue:getQueueSize	()I
    //   69: iconst_1
    //   70: iadd
    //   71: istore_1
    //   72: aload_0
    //   73: getfield 22	com/mobileapptracker/MATEventQueue$Add:this$0	Lcom/mobileapptracker/MATEventQueue;
    //   76: iload_1
    //   77: invokevirtual 72	com/mobileapptracker/MATEventQueue:setQueueSize	(I)V
    //   80: iload_1
    //   81: invokestatic 78	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   84: astore_3
    //   85: aload_0
    //   86: getfield 22	com/mobileapptracker/MATEventQueue$Add:this$0	Lcom/mobileapptracker/MATEventQueue;
    //   89: aload_2
    //   90: aload_3
    //   91: invokevirtual 82	com/mobileapptracker/MATEventQueue:setQueueItemForKey	(Lorg/json/JSONObject;Ljava/lang/String;)V
    //   94: aload_0
    //   95: getfield 22	com/mobileapptracker/MATEventQueue$Add:this$0	Lcom/mobileapptracker/MATEventQueue;
    //   98: invokestatic 43	com/mobileapptracker/MATEventQueue:access$000	(Lcom/mobileapptracker/MATEventQueue;)Ljava/util/concurrent/Semaphore;
    //   101: invokevirtual 85	java/util/concurrent/Semaphore:release	()V
    //   104: return
    //   105: astore_2
    //   106: ldc 87
    //   108: ldc 89
    //   110: invokestatic 95	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   113: pop
    //   114: aload_2
    //   115: invokevirtual 98	org/json/JSONException:printStackTrace	()V
    //   118: aload_0
    //   119: getfield 22	com/mobileapptracker/MATEventQueue$Add:this$0	Lcom/mobileapptracker/MATEventQueue;
    //   122: invokestatic 43	com/mobileapptracker/MATEventQueue:access$000	(Lcom/mobileapptracker/MATEventQueue;)Ljava/util/concurrent/Semaphore;
    //   125: invokevirtual 85	java/util/concurrent/Semaphore:release	()V
    //   128: return
    //   129: astore_2
    //   130: ldc 87
    //   132: ldc 100
    //   134: invokestatic 95	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   137: pop
    //   138: aload_2
    //   139: invokevirtual 101	java/lang/InterruptedException:printStackTrace	()V
    //   142: aload_0
    //   143: getfield 22	com/mobileapptracker/MATEventQueue$Add:this$0	Lcom/mobileapptracker/MATEventQueue;
    //   146: invokestatic 43	com/mobileapptracker/MATEventQueue:access$000	(Lcom/mobileapptracker/MATEventQueue;)Ljava/util/concurrent/Semaphore;
    //   149: invokevirtual 85	java/util/concurrent/Semaphore:release	()V
    //   152: return
    //   153: astore_2
    //   154: aload_0
    //   155: getfield 22	com/mobileapptracker/MATEventQueue$Add:this$0	Lcom/mobileapptracker/MATEventQueue;
    //   158: invokestatic 43	com/mobileapptracker/MATEventQueue:access$000	(Lcom/mobileapptracker/MATEventQueue;)Ljava/util/concurrent/Semaphore;
    //   161: invokevirtual 85	java/util/concurrent/Semaphore:release	()V
    //   164: aload_2
    //   165: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	166	0	this	Add
    //   71	10	1	i	int
    //   17	73	2	localJSONObject	JSONObject
    //   105	10	2	localJSONException	org.json.JSONException
    //   129	10	2	localInterruptedException	InterruptedException
    //   153	12	2	localObject	Object
    //   84	7	3	str	String
    // Exception table:
    //   from	to	target	type
    //   18	62	105	org/json/JSONException
    //   0	18	129	java/lang/InterruptedException
    //   18	62	129	java/lang/InterruptedException
    //   62	94	129	java/lang/InterruptedException
    //   106	118	129	java/lang/InterruptedException
    //   0	18	153	finally
    //   18	62	153	finally
    //   62	94	153	finally
    //   106	118	153	finally
    //   130	142	153	finally
  }
}

/* Location:
 * Qualified Name:     com.mobileapptracker.MATEventQueue.Add
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */