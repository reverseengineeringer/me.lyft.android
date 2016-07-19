package com.paypal.android.sdk;

import android.os.Handler;

public final class ag
  extends al
{
  private Handler a;
  private String b;
  private String c;
  private String d;
  private V e;
  
  public ag(String paramString1, String paramString2, String paramString3, V paramV, Handler paramHandler)
  {
    a = paramHandler;
    b = paramString1;
    c = paramString2;
    d = paramString3;
    e = paramV;
  }
  
  /* Error */
  public final void run()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore 4
    //   5: aload_0
    //   6: getfield 19	com/paypal/android/sdk/ag:a	Landroid/os/Handler;
    //   9: ifnonnull +4 -> 13
    //   12: return
    //   13: aload_0
    //   14: getfield 19	com/paypal/android/sdk/ag:a	Landroid/os/Handler;
    //   17: aload_0
    //   18: getfield 19	com/paypal/android/sdk/ag:a	Landroid/os/Handler;
    //   21: bipush 20
    //   23: aload_0
    //   24: getfield 21	com/paypal/android/sdk/ag:b	Ljava/lang/String;
    //   27: invokestatic 37	android/os/Message:obtain	(Landroid/os/Handler;ILjava/lang/Object;)Landroid/os/Message;
    //   30: invokevirtual 43	android/os/Handler:sendMessage	(Landroid/os/Message;)Z
    //   33: pop
    //   34: new 45	org/apache/http/impl/client/DefaultHttpClient
    //   37: dup
    //   38: invokespecial 46	org/apache/http/impl/client/DefaultHttpClient:<init>	()V
    //   41: astore_2
    //   42: aload_2
    //   43: invokeinterface 52 1 0
    //   48: sipush 10000
    //   51: invokestatic 58	org/apache/http/params/HttpConnectionParams:setSoTimeout	(Lorg/apache/http/params/HttpParams;I)V
    //   54: aload_2
    //   55: invokeinterface 52 1 0
    //   60: sipush 10000
    //   63: invokestatic 61	org/apache/http/params/HttpConnectionParams:setConnectionTimeout	(Lorg/apache/http/params/HttpParams;I)V
    //   66: new 63	org/apache/http/client/methods/HttpGet
    //   69: dup
    //   70: aload_0
    //   71: getfield 21	com/paypal/android/sdk/ag:b	Ljava/lang/String;
    //   74: invokespecial 66	org/apache/http/client/methods/HttpGet:<init>	(Ljava/lang/String;)V
    //   77: astore_1
    //   78: aload_1
    //   79: ldc 68
    //   81: ldc 70
    //   83: iconst_4
    //   84: anewarray 72	java/lang/Object
    //   87: dup
    //   88: iconst_0
    //   89: aload_0
    //   90: getfield 27	com/paypal/android/sdk/ag:e	Lcom/paypal/android/sdk/V;
    //   93: invokevirtual 77	com/paypal/android/sdk/V:a	()Ljava/lang/String;
    //   96: aastore
    //   97: dup
    //   98: iconst_1
    //   99: aload_0
    //   100: getfield 27	com/paypal/android/sdk/ag:e	Lcom/paypal/android/sdk/V;
    //   103: invokevirtual 79	com/paypal/android/sdk/V:b	()Ljava/lang/String;
    //   106: aastore
    //   107: dup
    //   108: iconst_2
    //   109: aload_0
    //   110: getfield 25	com/paypal/android/sdk/ag:d	Ljava/lang/String;
    //   113: aastore
    //   114: dup
    //   115: iconst_3
    //   116: aload_0
    //   117: getfield 23	com/paypal/android/sdk/ag:c	Ljava/lang/String;
    //   120: aastore
    //   121: invokestatic 85	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   124: invokevirtual 89	org/apache/http/client/methods/HttpGet:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   127: aload_1
    //   128: ldc 91
    //   130: ldc 93
    //   132: invokevirtual 89	org/apache/http/client/methods/HttpGet:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   135: new 95	java/io/BufferedReader
    //   138: dup
    //   139: new 97	java/io/InputStreamReader
    //   142: dup
    //   143: aload_2
    //   144: aload_1
    //   145: invokeinterface 101 2 0
    //   150: invokeinterface 107 1 0
    //   155: invokeinterface 113 1 0
    //   160: ldc 115
    //   162: invokespecial 118	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   165: invokespecial 121	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   168: astore_1
    //   169: new 123	java/lang/StringBuffer
    //   172: dup
    //   173: invokespecial 124	java/lang/StringBuffer:<init>	()V
    //   176: astore_3
    //   177: aload_1
    //   178: invokevirtual 127	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   181: astore 4
    //   183: aload 4
    //   185: ifnull +59 -> 244
    //   188: aload_3
    //   189: aload 4
    //   191: invokevirtual 131	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   194: pop
    //   195: goto -18 -> 177
    //   198: astore_3
    //   199: aload_0
    //   200: getfield 19	com/paypal/android/sdk/ag:a	Landroid/os/Handler;
    //   203: aload_0
    //   204: getfield 19	com/paypal/android/sdk/ag:a	Landroid/os/Handler;
    //   207: bipush 21
    //   209: aload_3
    //   210: invokestatic 37	android/os/Message:obtain	(Landroid/os/Handler;ILjava/lang/Object;)Landroid/os/Message;
    //   213: invokevirtual 43	android/os/Handler:sendMessage	(Landroid/os/Message;)Z
    //   216: pop
    //   217: aload_1
    //   218: invokestatic 135	com/paypal/android/sdk/R:a	(Ljava/io/Reader;)V
    //   221: aload_2
    //   222: ifnull +14 -> 236
    //   225: aload_2
    //   226: invokeinterface 139 1 0
    //   231: invokeinterface 144 1 0
    //   236: invokestatic 149	com/paypal/android/sdk/an:a	()Lcom/paypal/android/sdk/am;
    //   239: aload_0
    //   240: invokevirtual 154	com/paypal/android/sdk/am:b	(Lcom/paypal/android/sdk/al;)V
    //   243: return
    //   244: aload_0
    //   245: getfield 19	com/paypal/android/sdk/ag:a	Landroid/os/Handler;
    //   248: aload_0
    //   249: getfield 19	com/paypal/android/sdk/ag:a	Landroid/os/Handler;
    //   252: bipush 22
    //   254: aload_3
    //   255: invokevirtual 157	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   258: invokestatic 37	android/os/Message:obtain	(Landroid/os/Handler;ILjava/lang/Object;)Landroid/os/Message;
    //   261: invokevirtual 43	android/os/Handler:sendMessage	(Landroid/os/Message;)Z
    //   264: pop
    //   265: aload_1
    //   266: invokestatic 135	com/paypal/android/sdk/R:a	(Ljava/io/Reader;)V
    //   269: aload_2
    //   270: invokeinterface 139 1 0
    //   275: invokeinterface 144 1 0
    //   280: invokestatic 149	com/paypal/android/sdk/an:a	()Lcom/paypal/android/sdk/am;
    //   283: aload_0
    //   284: invokevirtual 154	com/paypal/android/sdk/am:b	(Lcom/paypal/android/sdk/al;)V
    //   287: return
    //   288: astore_1
    //   289: aconst_null
    //   290: astore_2
    //   291: aload_3
    //   292: invokestatic 135	com/paypal/android/sdk/R:a	(Ljava/io/Reader;)V
    //   295: aload_2
    //   296: ifnull +14 -> 310
    //   299: aload_2
    //   300: invokeinterface 139 1 0
    //   305: invokeinterface 144 1 0
    //   310: invokestatic 149	com/paypal/android/sdk/an:a	()Lcom/paypal/android/sdk/am;
    //   313: aload_0
    //   314: invokevirtual 154	com/paypal/android/sdk/am:b	(Lcom/paypal/android/sdk/al;)V
    //   317: aload_1
    //   318: athrow
    //   319: astore_1
    //   320: goto -29 -> 291
    //   323: astore 4
    //   325: aload_1
    //   326: astore_3
    //   327: aload 4
    //   329: astore_1
    //   330: goto -39 -> 291
    //   333: astore 4
    //   335: aload_1
    //   336: astore_3
    //   337: aload 4
    //   339: astore_1
    //   340: goto -49 -> 291
    //   343: astore_3
    //   344: aconst_null
    //   345: astore_1
    //   346: aload 4
    //   348: astore_2
    //   349: goto -150 -> 199
    //   352: astore_3
    //   353: aconst_null
    //   354: astore_1
    //   355: goto -156 -> 199
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	358	0	this	ag
    //   77	189	1	localObject1	Object
    //   288	30	1	localObject2	Object
    //   319	7	1	localObject3	Object
    //   329	26	1	localObject4	Object
    //   41	308	2	localObject5	Object
    //   1	188	3	localStringBuffer	StringBuffer
    //   198	94	3	localException1	Exception
    //   326	11	3	localObject6	Object
    //   343	1	3	localException2	Exception
    //   352	1	3	localException3	Exception
    //   3	187	4	str	String
    //   323	5	4	localObject7	Object
    //   333	14	4	localObject8	Object
    // Exception table:
    //   from	to	target	type
    //   169	177	198	java/lang/Exception
    //   177	183	198	java/lang/Exception
    //   188	195	198	java/lang/Exception
    //   244	265	198	java/lang/Exception
    //   13	42	288	finally
    //   42	169	319	finally
    //   169	177	323	finally
    //   177	183	323	finally
    //   188	195	323	finally
    //   244	265	323	finally
    //   199	217	333	finally
    //   13	42	343	java/lang/Exception
    //   42	169	352	java/lang/Exception
  }
}

/* Location:
 * Qualified Name:     com.paypal.android.sdk.ag
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */