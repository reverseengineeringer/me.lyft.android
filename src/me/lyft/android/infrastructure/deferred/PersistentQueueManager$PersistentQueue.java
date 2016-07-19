package me.lyft.android.infrastructure.deferred;

import com.squareup.tape.FileObjectQueue;
import com.squareup.tape.FileObjectQueue.Converter;
import java.io.File;
import me.lyft.android.common.Objects;
import me.lyft.android.logging.L;

class PersistentQueueManager$PersistentQueue
{
  private final FileObjectQueue.Converter<IDeferredCall> converter;
  private FileObjectQueue<IDeferredCall> fileObjectQueue;
  final File persistentFile;
  
  PersistentQueueManager$PersistentQueue(File paramFile, FileObjectQueue.Converter<IDeferredCall> paramConverter)
  {
    persistentFile = paramFile;
    converter = paramConverter;
  }
  
  private Throwable attemptToCreateFileObjectQueue()
  {
    try
    {
      fileObjectQueue = new FileObjectQueue(persistentFile, converter);
      return null;
    }
    catch (Throwable localThrowable)
    {
      return localThrowable;
    }
  }
  
  private void ensureFileObjectQueue()
  {
    try
    {
      Object localObject1 = fileObjectQueue;
      if (localObject1 != null) {}
      do
      {
        do
        {
          return;
          localObject1 = attemptToCreateFileObjectQueue();
        } while (localObject1 == null);
        boolean bool = persistentFile.delete();
        L.e((Throwable)localObject1, "Unable to create FileObjectQueue deleted? " + bool, new Object[0]);
        localObject1 = attemptToCreateFileObjectQueue();
      } while (localObject1 == null);
      throw new RuntimeException((Throwable)localObject1);
    }
    finally {}
  }
  
  void add(IDeferredCall paramIDeferredCall)
  {
    try
    {
      ensureFileObjectQueue();
      fileObjectQueue.add(paramIDeferredCall);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        L.e(localException, "Unable to add call " + paramIDeferredCall, new Object[0]);
      }
    }
    finally {}
  }
  
  boolean isEmpty()
  {
    boolean bool = true;
    for (;;)
    {
      try
      {
        ensureFileObjectQueue();
        int i = fileObjectQueue.size();
        if (i >= 1) {
          continue;
        }
      }
      catch (Exception localException)
      {
        L.e(localException, "Unable to get the size of the queue.", new Object[0]);
        continue;
      }
      finally {}
      return bool;
      bool = false;
    }
  }
  
  IDeferredCall peek()
  {
    try
    {
      ensureFileObjectQueue();
      IDeferredCall localIDeferredCall1 = (IDeferredCall)Objects.firstNonNull(fileObjectQueue.peek(), PersistentQueueManager.EMPTY_CALL);
      return localIDeferredCall1;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        L.e(localException, "Unable to peek at the queue.", new Object[0]);
        IDeferredCall localIDeferredCall2 = PersistentQueueManager.EMPTY_CALL;
      }
    }
    finally {}
  }
  
  boolean remove(IDeferredCall paramIDeferredCall)
  {
    try
    {
      boolean bool = remove(paramIDeferredCall, null);
      return bool;
    }
    finally
    {
      paramIDeferredCall = finally;
      throw paramIDeferredCall;
    }
  }
  
  /* Error */
  boolean remove(IDeferredCall paramIDeferredCall, Exception paramException)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: aload_0
    //   3: monitorenter
    //   4: getstatic 103	me/lyft/android/infrastructure/deferred/PersistentQueueManager:EMPTY_CALL	Lme/lyft/android/infrastructure/deferred/IDeferredCall;
    //   7: astore_2
    //   8: aload_1
    //   9: aload_2
    //   10: if_acmpne +7 -> 17
    //   13: aload_0
    //   14: monitorexit
    //   15: iload_3
    //   16: ireturn
    //   17: aload_0
    //   18: invokespecial 79	me/lyft/android/infrastructure/deferred/PersistentQueueManager$PersistentQueue:ensureFileObjectQueue	()V
    //   21: aload_0
    //   22: getfield 37	me/lyft/android/infrastructure/deferred/PersistentQueueManager$PersistentQueue:fileObjectQueue	Lcom/squareup/tape/FileObjectQueue;
    //   25: invokevirtual 120	com/squareup/tape/FileObjectQueue:remove	()V
    //   28: iconst_1
    //   29: istore_3
    //   30: goto -17 -> 13
    //   33: astore_2
    //   34: aload_2
    //   35: new 48	java/lang/StringBuilder
    //   38: dup
    //   39: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   42: ldc 122
    //   44: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: aload_1
    //   48: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   51: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   54: iconst_0
    //   55: anewarray 4	java/lang/Object
    //   58: invokestatic 68	me/lyft/android/logging/L:e	(Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   61: goto -48 -> 13
    //   64: astore_1
    //   65: aload_0
    //   66: monitorexit
    //   67: aload_1
    //   68: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	69	0	this	PersistentQueue
    //   0	69	1	paramIDeferredCall	IDeferredCall
    //   0	69	2	paramException	Exception
    //   1	29	3	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   17	28	33	java/lang/Exception
    //   4	8	64	finally
    //   17	28	64	finally
    //   34	61	64	finally
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.deferred.PersistentQueueManager.PersistentQueue
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */