package com.facebook.appevents;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.util.Iterator;
import java.util.Set;

class AppEventStore
{
  private static final String PERSISTED_EVENTS_FILENAME = "AppEventsLogger.persistedevents";
  private static final String TAG = AppEventStore.class.getName();
  
  private static void assertIsNotMainThread() {}
  
  /* Error */
  public static void persistEvents(AccessTokenAppIdPair paramAccessTokenAppIdPair, SessionEventsState paramSessionEventsState)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: invokestatic 31	com/facebook/appevents/AppEventStore:assertIsNotMainThread	()V
    //   6: invokestatic 35	com/facebook/appevents/AppEventStore:readAndClearStore	()Lcom/facebook/appevents/PersistedEvents;
    //   9: astore_2
    //   10: aload_2
    //   11: aload_0
    //   12: invokevirtual 41	com/facebook/appevents/PersistedEvents:containsKey	(Ljava/lang/Object;)Z
    //   15: ifeq +29 -> 44
    //   18: aload_2
    //   19: aload_0
    //   20: invokevirtual 45	com/facebook/appevents/PersistedEvents:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   23: checkcast 47	java/util/List
    //   26: aload_1
    //   27: invokevirtual 53	com/facebook/appevents/SessionEventsState:getEventsToPersist	()Ljava/util/List;
    //   30: invokeinterface 57 2 0
    //   35: pop
    //   36: aload_2
    //   37: invokestatic 61	com/facebook/appevents/AppEventStore:saveEventsToDisk	(Lcom/facebook/appevents/PersistedEvents;)V
    //   40: ldc 2
    //   42: monitorexit
    //   43: return
    //   44: aload_2
    //   45: aload_0
    //   46: aload_1
    //   47: invokevirtual 53	com/facebook/appevents/SessionEventsState:getEventsToPersist	()Ljava/util/List;
    //   50: invokevirtual 65	com/facebook/appevents/PersistedEvents:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   53: pop
    //   54: goto -18 -> 36
    //   57: astore_0
    //   58: ldc 2
    //   60: monitorexit
    //   61: aload_0
    //   62: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	63	0	paramAccessTokenAppIdPair	AccessTokenAppIdPair
    //   0	63	1	paramSessionEventsState	SessionEventsState
    //   9	36	2	localPersistedEvents	PersistedEvents
    // Exception table:
    //   from	to	target	type
    //   3	36	57	finally
    //   36	40	57	finally
    //   44	54	57	finally
  }
  
  public static void persistEvents(AppEventCollection paramAppEventCollection)
  {
    try
    {
      assertIsNotMainThread();
      PersistedEvents localPersistedEvents = new PersistedEvents();
      Iterator localIterator = paramAppEventCollection.keySet().iterator();
      while (localIterator.hasNext())
      {
        AccessTokenAppIdPair localAccessTokenAppIdPair = (AccessTokenAppIdPair)localIterator.next();
        localPersistedEvents.put(localAccessTokenAppIdPair, paramAppEventCollection.get(localAccessTokenAppIdPair).getEventsToPersist());
      }
      saveEventsToDisk(localPersistedEvents);
    }
    finally {}
  }
  
  /* Error */
  public static PersistedEvents readAndClearStore()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: invokestatic 31	com/facebook/appevents/AppEventStore:assertIsNotMainThread	()V
    //   6: aconst_null
    //   7: astore 5
    //   9: aconst_null
    //   10: astore_1
    //   11: aconst_null
    //   12: astore_2
    //   13: aconst_null
    //   14: astore_3
    //   15: aconst_null
    //   16: astore 4
    //   18: invokestatic 104	com/facebook/FacebookSdk:getApplicationContext	()Landroid/content/Context;
    //   21: astore 6
    //   23: new 6	com/facebook/appevents/AppEventStore$MovedClassObjectInputStream
    //   26: dup
    //   27: new 106	java/io/BufferedInputStream
    //   30: dup
    //   31: aload 6
    //   33: ldc 11
    //   35: invokevirtual 112	android/content/Context:openFileInput	(Ljava/lang/String;)Ljava/io/FileInputStream;
    //   38: invokespecial 115	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   41: invokespecial 116	com/facebook/appevents/AppEventStore$MovedClassObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   44: astore_0
    //   45: aload_0
    //   46: invokevirtual 119	com/facebook/appevents/AppEventStore$MovedClassObjectInputStream:readObject	()Ljava/lang/Object;
    //   49: checkcast 121	java/util/HashMap
    //   52: astore_1
    //   53: aload_0
    //   54: invokestatic 127	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
    //   57: aload 6
    //   59: ldc 11
    //   61: invokevirtual 131	android/content/Context:getFileStreamPath	(Ljava/lang/String;)Ljava/io/File;
    //   64: invokevirtual 136	java/io/File:delete	()Z
    //   67: pop
    //   68: aload 4
    //   70: astore_0
    //   71: aload_1
    //   72: ifnull +12 -> 84
    //   75: new 37	com/facebook/appevents/PersistedEvents
    //   78: dup
    //   79: aload_1
    //   80: invokespecial 139	com/facebook/appevents/PersistedEvents:<init>	(Ljava/util/HashMap;)V
    //   83: astore_0
    //   84: aload_0
    //   85: astore_1
    //   86: aload_0
    //   87: ifnonnull +11 -> 98
    //   90: new 37	com/facebook/appevents/PersistedEvents
    //   93: dup
    //   94: invokespecial 67	com/facebook/appevents/PersistedEvents:<init>	()V
    //   97: astore_1
    //   98: ldc 2
    //   100: monitorexit
    //   101: aload_1
    //   102: areturn
    //   103: astore_0
    //   104: getstatic 22	com/facebook/appevents/AppEventStore:TAG	Ljava/lang/String;
    //   107: ldc -115
    //   109: aload_0
    //   110: invokestatic 147	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   113: pop
    //   114: aload_3
    //   115: astore_0
    //   116: goto -32 -> 84
    //   119: aload_0
    //   120: invokestatic 127	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
    //   123: aload 6
    //   125: ldc 11
    //   127: invokevirtual 131	android/content/Context:getFileStreamPath	(Ljava/lang/String;)Ljava/io/File;
    //   130: invokevirtual 136	java/io/File:delete	()Z
    //   133: pop
    //   134: aload_3
    //   135: astore_0
    //   136: iconst_0
    //   137: ifeq -53 -> 84
    //   140: new 37	com/facebook/appevents/PersistedEvents
    //   143: dup
    //   144: aconst_null
    //   145: invokespecial 139	com/facebook/appevents/PersistedEvents:<init>	(Ljava/util/HashMap;)V
    //   148: astore_0
    //   149: goto -65 -> 84
    //   152: astore_0
    //   153: getstatic 22	com/facebook/appevents/AppEventStore:TAG	Ljava/lang/String;
    //   156: ldc -115
    //   158: aload_0
    //   159: invokestatic 147	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   162: pop
    //   163: aload_3
    //   164: astore_0
    //   165: goto -81 -> 84
    //   168: astore_0
    //   169: ldc 2
    //   171: monitorexit
    //   172: aload_0
    //   173: athrow
    //   174: astore_2
    //   175: aload 5
    //   177: astore_0
    //   178: aload_0
    //   179: astore_1
    //   180: getstatic 22	com/facebook/appevents/AppEventStore:TAG	Ljava/lang/String;
    //   183: ldc -107
    //   185: aload_2
    //   186: invokestatic 147	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   189: pop
    //   190: aload_0
    //   191: invokestatic 127	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
    //   194: aload 6
    //   196: ldc 11
    //   198: invokevirtual 131	android/content/Context:getFileStreamPath	(Ljava/lang/String;)Ljava/io/File;
    //   201: invokevirtual 136	java/io/File:delete	()Z
    //   204: pop
    //   205: aload_3
    //   206: astore_0
    //   207: iconst_0
    //   208: ifeq -124 -> 84
    //   211: new 37	com/facebook/appevents/PersistedEvents
    //   214: dup
    //   215: aconst_null
    //   216: invokespecial 139	com/facebook/appevents/PersistedEvents:<init>	(Ljava/util/HashMap;)V
    //   219: astore_0
    //   220: goto -136 -> 84
    //   223: astore_0
    //   224: getstatic 22	com/facebook/appevents/AppEventStore:TAG	Ljava/lang/String;
    //   227: ldc -115
    //   229: aload_0
    //   230: invokestatic 147	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   233: pop
    //   234: aload_3
    //   235: astore_0
    //   236: goto -152 -> 84
    //   239: aload_1
    //   240: invokestatic 127	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
    //   243: aload 6
    //   245: ldc 11
    //   247: invokevirtual 131	android/content/Context:getFileStreamPath	(Ljava/lang/String;)Ljava/io/File;
    //   250: invokevirtual 136	java/io/File:delete	()Z
    //   253: pop
    //   254: iconst_0
    //   255: ifeq +12 -> 267
    //   258: new 37	com/facebook/appevents/PersistedEvents
    //   261: dup
    //   262: aconst_null
    //   263: invokespecial 139	com/facebook/appevents/PersistedEvents:<init>	(Ljava/util/HashMap;)V
    //   266: pop
    //   267: aload_0
    //   268: athrow
    //   269: astore_1
    //   270: getstatic 22	com/facebook/appevents/AppEventStore:TAG	Ljava/lang/String;
    //   273: ldc -115
    //   275: aload_1
    //   276: invokestatic 147	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   279: pop
    //   280: goto -13 -> 267
    //   283: astore_2
    //   284: aload_0
    //   285: astore_1
    //   286: aload_2
    //   287: astore_0
    //   288: goto -49 -> 239
    //   291: astore_2
    //   292: goto -114 -> 178
    //   295: astore_1
    //   296: goto -177 -> 119
    //   299: astore_0
    //   300: aload_2
    //   301: astore_0
    //   302: goto -183 -> 119
    //   305: astore_0
    //   306: goto -67 -> 239
    // Local variable table:
    //   start	length	slot	name	signature
    //   44	43	0	localObject1	Object
    //   103	7	0	localException1	Exception
    //   115	34	0	localObject2	Object
    //   152	7	0	localException2	Exception
    //   164	1	0	localObject3	Object
    //   168	5	0	localObject4	Object
    //   177	43	0	localObject5	Object
    //   223	7	0	localException3	Exception
    //   235	53	0	localObject6	Object
    //   299	1	0	localFileNotFoundException1	java.io.FileNotFoundException
    //   301	1	0	localException4	Exception
    //   305	1	0	localObject7	Object
    //   10	230	1	localObject8	Object
    //   269	7	1	localException5	Exception
    //   285	1	1	localObject9	Object
    //   295	1	1	localFileNotFoundException2	java.io.FileNotFoundException
    //   12	1	2	localObject10	Object
    //   174	12	2	localException6	Exception
    //   283	4	2	localObject11	Object
    //   291	10	2	localException7	Exception
    //   14	221	3	localObject12	Object
    //   16	53	4	localObject13	Object
    //   7	169	5	localObject14	Object
    //   21	223	6	localContext	android.content.Context
    // Exception table:
    //   from	to	target	type
    //   57	68	103	java/lang/Exception
    //   75	84	103	java/lang/Exception
    //   123	134	152	java/lang/Exception
    //   140	149	152	java/lang/Exception
    //   3	6	168	finally
    //   18	23	168	finally
    //   53	57	168	finally
    //   57	68	168	finally
    //   75	84	168	finally
    //   90	98	168	finally
    //   104	114	168	finally
    //   119	123	168	finally
    //   123	134	168	finally
    //   140	149	168	finally
    //   153	163	168	finally
    //   190	194	168	finally
    //   194	205	168	finally
    //   211	220	168	finally
    //   224	234	168	finally
    //   239	243	168	finally
    //   243	254	168	finally
    //   258	267	168	finally
    //   267	269	168	finally
    //   270	280	168	finally
    //   23	45	174	java/lang/Exception
    //   194	205	223	java/lang/Exception
    //   211	220	223	java/lang/Exception
    //   243	254	269	java/lang/Exception
    //   258	267	269	java/lang/Exception
    //   45	53	283	finally
    //   45	53	291	java/lang/Exception
    //   45	53	295	java/io/FileNotFoundException
    //   23	45	299	java/io/FileNotFoundException
    //   23	45	305	finally
    //   180	190	305	finally
  }
  
  /* Error */
  private static void saveEventsToDisk(PersistedEvents paramPersistedEvents)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: aconst_null
    //   3: astore_3
    //   4: new 151	java/io/ObjectOutputStream
    //   7: dup
    //   8: new 153	java/io/BufferedOutputStream
    //   11: dup
    //   12: invokestatic 104	com/facebook/FacebookSdk:getApplicationContext	()Landroid/content/Context;
    //   15: ldc 11
    //   17: iconst_0
    //   18: invokevirtual 157	android/content/Context:openFileOutput	(Ljava/lang/String;I)Ljava/io/FileOutputStream;
    //   21: invokespecial 160	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   24: invokespecial 161	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   27: astore_2
    //   28: aload_2
    //   29: aload_0
    //   30: invokevirtual 165	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   33: aload_2
    //   34: invokestatic 127	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
    //   37: return
    //   38: astore_2
    //   39: aload_3
    //   40: astore_0
    //   41: aload_0
    //   42: astore_1
    //   43: getstatic 22	com/facebook/appevents/AppEventStore:TAG	Ljava/lang/String;
    //   46: ldc -89
    //   48: aload_2
    //   49: invokestatic 147	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   52: pop
    //   53: aload_0
    //   54: invokestatic 127	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
    //   57: return
    //   58: astore_0
    //   59: aload_1
    //   60: invokestatic 127	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
    //   63: aload_0
    //   64: athrow
    //   65: astore_0
    //   66: aload_2
    //   67: astore_1
    //   68: goto -9 -> 59
    //   71: astore_1
    //   72: aload_2
    //   73: astore_0
    //   74: aload_1
    //   75: astore_2
    //   76: goto -35 -> 41
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	79	0	paramPersistedEvents	PersistedEvents
    //   1	67	1	localObject1	Object
    //   71	4	1	localException1	Exception
    //   27	7	2	localObjectOutputStream	java.io.ObjectOutputStream
    //   38	35	2	localException2	Exception
    //   75	1	2	localException3	Exception
    //   3	37	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   4	28	38	java/lang/Exception
    //   4	28	58	finally
    //   43	53	58	finally
    //   28	33	65	finally
    //   28	33	71	java/lang/Exception
  }
  
  private static class MovedClassObjectInputStream
    extends ObjectInputStream
  {
    private static final String ACCESS_TOKEN_APP_ID_PAIR_SERIALIZATION_PROXY_V1_CLASS_NAME = "com.facebook.appevents.AppEventsLogger$AccessTokenAppIdPair$SerializationProxyV1";
    private static final String APP_EVENT_SERIALIZATION_PROXY_V1_CLASS_NAME = "com.facebook.appevents.AppEventsLogger$AppEvent$SerializationProxyV1";
    
    public MovedClassObjectInputStream(InputStream paramInputStream)
      throws IOException
    {
      super();
    }
    
    protected ObjectStreamClass readClassDescriptor()
      throws IOException, ClassNotFoundException
    {
      ObjectStreamClass localObjectStreamClass2 = super.readClassDescriptor();
      ObjectStreamClass localObjectStreamClass1;
      if (localObjectStreamClass2.getName().equals("com.facebook.appevents.AppEventsLogger$AccessTokenAppIdPair$SerializationProxyV1")) {
        localObjectStreamClass1 = ObjectStreamClass.lookup(AccessTokenAppIdPair.SerializationProxyV1.class);
      }
      do
      {
        return localObjectStreamClass1;
        localObjectStreamClass1 = localObjectStreamClass2;
      } while (!localObjectStreamClass2.getName().equals("com.facebook.appevents.AppEventsLogger$AppEvent$SerializationProxyV1"));
      return ObjectStreamClass.lookup(AppEvent.SerializationProxyV1.class);
    }
  }
}

/* Location:
 * Qualified Name:     com.facebook.appevents.AppEventStore
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */