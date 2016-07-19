package com.paypal.android.sdk;

import android.os.Handler;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.conn.ssl.SSLSocketFactory;

public final class ak
  extends al
{
  private String a;
  private List b;
  private List c;
  private Handler d;
  private boolean e;
  private SSLSocketFactory f;
  
  public ak(String paramString, List paramList, Handler paramHandler, boolean paramBoolean, SSLSocketFactory paramSSLSocketFactory)
  {
    a = paramString;
    b = paramList;
    c = new ArrayList();
    d = paramHandler;
    e = paramBoolean;
    f = paramSSLSocketFactory;
  }
  
  /* Error */
  public final void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 31	com/paypal/android/sdk/ak:d	Landroid/os/Handler;
    //   4: ifnonnull +4 -> 8
    //   7: return
    //   8: aconst_null
    //   9: astore 7
    //   11: aconst_null
    //   12: astore 8
    //   14: aconst_null
    //   15: astore_3
    //   16: aconst_null
    //   17: astore 6
    //   19: aconst_null
    //   20: astore 9
    //   22: aconst_null
    //   23: astore 4
    //   25: aconst_null
    //   26: astore 5
    //   28: aload 9
    //   30: astore_1
    //   31: aload 8
    //   33: astore_2
    //   34: aload_0
    //   35: getfield 31	com/paypal/android/sdk/ak:d	Landroid/os/Handler;
    //   38: aload_0
    //   39: getfield 31	com/paypal/android/sdk/ak:d	Landroid/os/Handler;
    //   42: iconst_0
    //   43: aload_0
    //   44: getfield 22	com/paypal/android/sdk/ak:a	Ljava/lang/String;
    //   47: invokestatic 47	android/os/Message:obtain	(Landroid/os/Handler;ILjava/lang/Object;)Landroid/os/Message;
    //   50: invokevirtual 53	android/os/Handler:sendMessage	(Landroid/os/Message;)Z
    //   53: pop
    //   54: aload 9
    //   56: astore_1
    //   57: aload 8
    //   59: astore_2
    //   60: aload_0
    //   61: getfield 33	com/paypal/android/sdk/ak:e	Z
    //   64: ifne +30 -> 94
    //   67: aload 9
    //   69: astore_1
    //   70: aload 8
    //   72: astore_2
    //   73: aload_0
    //   74: getfield 29	com/paypal/android/sdk/ak:c	Ljava/util/List;
    //   77: new 55	org/apache/http/message/BasicNameValuePair
    //   80: dup
    //   81: ldc 57
    //   83: ldc 59
    //   85: invokespecial 62	org/apache/http/message/BasicNameValuePair:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   88: invokeinterface 68 2 0
    //   93: pop
    //   94: aload 9
    //   96: astore_1
    //   97: aload 8
    //   99: astore_2
    //   100: aload_0
    //   101: getfield 29	com/paypal/android/sdk/ak:c	Ljava/util/List;
    //   104: new 55	org/apache/http/message/BasicNameValuePair
    //   107: dup
    //   108: ldc 70
    //   110: ldc 72
    //   112: invokespecial 62	org/apache/http/message/BasicNameValuePair:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   115: invokeinterface 68 2 0
    //   120: pop
    //   121: aload 9
    //   123: astore_1
    //   124: aload 8
    //   126: astore_2
    //   127: aload_0
    //   128: getfield 29	com/paypal/android/sdk/ak:c	Ljava/util/List;
    //   131: new 55	org/apache/http/message/BasicNameValuePair
    //   134: dup
    //   135: ldc 74
    //   137: ldc 72
    //   139: invokespecial 62	org/apache/http/message/BasicNameValuePair:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   142: invokeinterface 68 2 0
    //   147: pop
    //   148: aload 9
    //   150: astore_1
    //   151: aload 8
    //   153: astore_2
    //   154: aload_0
    //   155: getfield 29	com/paypal/android/sdk/ak:c	Ljava/util/List;
    //   158: new 55	org/apache/http/message/BasicNameValuePair
    //   161: dup
    //   162: ldc 76
    //   164: ldc 78
    //   166: invokespecial 62	org/apache/http/message/BasicNameValuePair:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   169: invokeinterface 68 2 0
    //   174: pop
    //   175: aload 9
    //   177: astore_1
    //   178: aload 8
    //   180: astore_2
    //   181: aload_0
    //   182: getfield 33	com/paypal/android/sdk/ak:e	Z
    //   185: ifeq +163 -> 348
    //   188: aload 9
    //   190: astore_1
    //   191: aload 8
    //   193: astore_2
    //   194: new 80	org/apache/http/impl/client/DefaultHttpClient
    //   197: dup
    //   198: invokespecial 81	org/apache/http/impl/client/DefaultHttpClient:<init>	()V
    //   201: astore 8
    //   203: aload 8
    //   205: astore_1
    //   206: aload_1
    //   207: invokeinterface 87 1 0
    //   212: sipush 10000
    //   215: invokestatic 93	org/apache/http/params/HttpConnectionParams:setSoTimeout	(Lorg/apache/http/params/HttpParams;I)V
    //   218: aload_1
    //   219: invokeinterface 87 1 0
    //   224: sipush 10000
    //   227: invokestatic 96	org/apache/http/params/HttpConnectionParams:setConnectionTimeout	(Lorg/apache/http/params/HttpParams;I)V
    //   230: new 98	org/apache/http/client/methods/HttpPost
    //   233: dup
    //   234: aload_0
    //   235: getfield 22	com/paypal/android/sdk/ak:a	Ljava/lang/String;
    //   238: invokespecial 101	org/apache/http/client/methods/HttpPost:<init>	(Ljava/lang/String;)V
    //   241: astore_2
    //   242: aload_0
    //   243: getfield 29	com/paypal/android/sdk/ak:c	Ljava/util/List;
    //   246: invokeinterface 105 1 0
    //   251: astore_3
    //   252: aload_3
    //   253: invokeinterface 111 1 0
    //   258: ifeq +395 -> 653
    //   261: aload_3
    //   262: invokeinterface 115 1 0
    //   267: checkcast 117	org/apache/http/NameValuePair
    //   270: astore 7
    //   272: aload_2
    //   273: aload 7
    //   275: invokeinterface 121 1 0
    //   280: aload 7
    //   282: invokeinterface 124 1 0
    //   287: invokevirtual 127	org/apache/http/client/methods/HttpPost:addHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   290: goto -38 -> 252
    //   293: astore 4
    //   295: aload_1
    //   296: astore_3
    //   297: aload 5
    //   299: astore_1
    //   300: aload_3
    //   301: astore_2
    //   302: aload_0
    //   303: getfield 31	com/paypal/android/sdk/ak:d	Landroid/os/Handler;
    //   306: aload_0
    //   307: getfield 31	com/paypal/android/sdk/ak:d	Landroid/os/Handler;
    //   310: iconst_1
    //   311: aload 4
    //   313: invokestatic 47	android/os/Message:obtain	(Landroid/os/Handler;ILjava/lang/Object;)Landroid/os/Message;
    //   316: invokevirtual 53	android/os/Handler:sendMessage	(Landroid/os/Message;)Z
    //   319: pop
    //   320: aload 5
    //   322: invokestatic 132	com/paypal/android/sdk/R:a	(Ljava/io/Reader;)V
    //   325: aload_3
    //   326: ifnull +14 -> 340
    //   329: aload_3
    //   330: invokeinterface 136 1 0
    //   335: invokeinterface 141 1 0
    //   340: invokestatic 146	com/paypal/android/sdk/an:a	()Lcom/paypal/android/sdk/am;
    //   343: aload_0
    //   344: invokevirtual 151	com/paypal/android/sdk/am:b	(Lcom/paypal/android/sdk/al;)V
    //   347: return
    //   348: aload 9
    //   350: astore_1
    //   351: aload 8
    //   353: astore_2
    //   354: new 153	org/apache/http/conn/scheme/SchemeRegistry
    //   357: dup
    //   358: invokespecial 154	org/apache/http/conn/scheme/SchemeRegistry:<init>	()V
    //   361: astore 10
    //   363: aload 9
    //   365: astore_1
    //   366: aload 8
    //   368: astore_2
    //   369: aload 10
    //   371: new 156	org/apache/http/conn/scheme/Scheme
    //   374: dup
    //   375: ldc -98
    //   377: invokestatic 164	org/apache/http/conn/scheme/PlainSocketFactory:getSocketFactory	()Lorg/apache/http/conn/scheme/PlainSocketFactory;
    //   380: bipush 80
    //   382: invokespecial 167	org/apache/http/conn/scheme/Scheme:<init>	(Ljava/lang/String;Lorg/apache/http/conn/scheme/SocketFactory;I)V
    //   385: invokevirtual 171	org/apache/http/conn/scheme/SchemeRegistry:register	(Lorg/apache/http/conn/scheme/Scheme;)Lorg/apache/http/conn/scheme/Scheme;
    //   388: pop
    //   389: aload 9
    //   391: astore_1
    //   392: aload 8
    //   394: astore_2
    //   395: aload_0
    //   396: getfield 35	com/paypal/android/sdk/ak:f	Lorg/apache/http/conn/ssl/SSLSocketFactory;
    //   399: ifnonnull +163 -> 562
    //   402: aload 9
    //   404: astore_1
    //   405: aload 8
    //   407: astore_2
    //   408: aload 10
    //   410: new 156	org/apache/http/conn/scheme/Scheme
    //   413: dup
    //   414: ldc -83
    //   416: new 175	com/paypal/android/sdk/ah
    //   419: dup
    //   420: invokespecial 176	com/paypal/android/sdk/ah:<init>	()V
    //   423: sipush 443
    //   426: invokespecial 167	org/apache/http/conn/scheme/Scheme:<init>	(Ljava/lang/String;Lorg/apache/http/conn/scheme/SocketFactory;I)V
    //   429: invokevirtual 171	org/apache/http/conn/scheme/SchemeRegistry:register	(Lorg/apache/http/conn/scheme/Scheme;)Lorg/apache/http/conn/scheme/Scheme;
    //   432: pop
    //   433: aload 9
    //   435: astore_1
    //   436: aload 8
    //   438: astore_2
    //   439: new 178	org/apache/http/params/BasicHttpParams
    //   442: dup
    //   443: invokespecial 179	org/apache/http/params/BasicHttpParams:<init>	()V
    //   446: astore 11
    //   448: aload 9
    //   450: astore_1
    //   451: aload 8
    //   453: astore_2
    //   454: aload 11
    //   456: ldc -75
    //   458: bipush 30
    //   460: invokestatic 187	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   463: invokeinterface 193 3 0
    //   468: pop
    //   469: aload 9
    //   471: astore_1
    //   472: aload 8
    //   474: astore_2
    //   475: aload 11
    //   477: ldc -61
    //   479: new 197	org/apache/http/conn/params/ConnPerRouteBean
    //   482: dup
    //   483: bipush 30
    //   485: invokespecial 200	org/apache/http/conn/params/ConnPerRouteBean:<init>	(I)V
    //   488: invokeinterface 193 3 0
    //   493: pop
    //   494: aload 9
    //   496: astore_1
    //   497: aload 8
    //   499: astore_2
    //   500: aload 11
    //   502: ldc -54
    //   504: iconst_0
    //   505: invokestatic 207	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   508: invokeinterface 193 3 0
    //   513: pop
    //   514: aload 9
    //   516: astore_1
    //   517: aload 8
    //   519: astore_2
    //   520: aload 11
    //   522: getstatic 213	org/apache/http/HttpVersion:HTTP_1_1	Lorg/apache/http/HttpVersion;
    //   525: invokestatic 219	org/apache/http/params/HttpProtocolParams:setVersion	(Lorg/apache/http/params/HttpParams;Lorg/apache/http/ProtocolVersion;)V
    //   528: aload 9
    //   530: astore_1
    //   531: aload 8
    //   533: astore_2
    //   534: new 80	org/apache/http/impl/client/DefaultHttpClient
    //   537: dup
    //   538: new 221	org/apache/http/impl/conn/tsccm/ThreadSafeClientConnManager
    //   541: dup
    //   542: aload 11
    //   544: aload 10
    //   546: invokespecial 224	org/apache/http/impl/conn/tsccm/ThreadSafeClientConnManager:<init>	(Lorg/apache/http/params/HttpParams;Lorg/apache/http/conn/scheme/SchemeRegistry;)V
    //   549: aload 11
    //   551: invokespecial 227	org/apache/http/impl/client/DefaultHttpClient:<init>	(Lorg/apache/http/conn/ClientConnectionManager;Lorg/apache/http/params/HttpParams;)V
    //   554: astore 8
    //   556: aload 8
    //   558: astore_1
    //   559: goto -353 -> 206
    //   562: aload 9
    //   564: astore_1
    //   565: aload 8
    //   567: astore_2
    //   568: aload 10
    //   570: new 156	org/apache/http/conn/scheme/Scheme
    //   573: dup
    //   574: ldc -83
    //   576: aload_0
    //   577: getfield 35	com/paypal/android/sdk/ak:f	Lorg/apache/http/conn/ssl/SSLSocketFactory;
    //   580: sipush 443
    //   583: invokespecial 167	org/apache/http/conn/scheme/Scheme:<init>	(Ljava/lang/String;Lorg/apache/http/conn/scheme/SocketFactory;I)V
    //   586: invokevirtual 171	org/apache/http/conn/scheme/SchemeRegistry:register	(Lorg/apache/http/conn/scheme/Scheme;)Lorg/apache/http/conn/scheme/Scheme;
    //   589: pop
    //   590: goto -157 -> 433
    //   593: astore 4
    //   595: aload 7
    //   597: astore_3
    //   598: aload 6
    //   600: astore 5
    //   602: aload 5
    //   604: astore_1
    //   605: aload_3
    //   606: astore_2
    //   607: aload_0
    //   608: getfield 31	com/paypal/android/sdk/ak:d	Landroid/os/Handler;
    //   611: aload_0
    //   612: getfield 31	com/paypal/android/sdk/ak:d	Landroid/os/Handler;
    //   615: iconst_1
    //   616: aload 4
    //   618: invokestatic 47	android/os/Message:obtain	(Landroid/os/Handler;ILjava/lang/Object;)Landroid/os/Message;
    //   621: invokevirtual 53	android/os/Handler:sendMessage	(Landroid/os/Message;)Z
    //   624: pop
    //   625: aload 5
    //   627: invokestatic 132	com/paypal/android/sdk/R:a	(Ljava/io/Reader;)V
    //   630: aload_3
    //   631: ifnull +14 -> 645
    //   634: aload_3
    //   635: invokeinterface 136 1 0
    //   640: invokeinterface 141 1 0
    //   645: invokestatic 146	com/paypal/android/sdk/an:a	()Lcom/paypal/android/sdk/am;
    //   648: aload_0
    //   649: invokevirtual 151	com/paypal/android/sdk/am:b	(Lcom/paypal/android/sdk/al;)V
    //   652: return
    //   653: aload_2
    //   654: new 229	org/apache/http/client/entity/UrlEncodedFormEntity
    //   657: dup
    //   658: aload_0
    //   659: getfield 24	com/paypal/android/sdk/ak:b	Ljava/util/List;
    //   662: ldc -25
    //   664: invokespecial 234	org/apache/http/client/entity/UrlEncodedFormEntity:<init>	(Ljava/util/List;Ljava/lang/String;)V
    //   667: invokevirtual 238	org/apache/http/client/methods/HttpPost:setEntity	(Lorg/apache/http/HttpEntity;)V
    //   670: new 240	java/io/BufferedReader
    //   673: dup
    //   674: new 242	java/io/InputStreamReader
    //   677: dup
    //   678: aload_1
    //   679: aload_2
    //   680: invokeinterface 246 2 0
    //   685: invokeinterface 252 1 0
    //   690: invokeinterface 258 1 0
    //   695: ldc -25
    //   697: invokespecial 261	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   700: invokespecial 263	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   703: astore_2
    //   704: new 265	java/lang/StringBuffer
    //   707: dup
    //   708: invokespecial 266	java/lang/StringBuffer:<init>	()V
    //   711: astore_3
    //   712: aload_2
    //   713: invokevirtual 269	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   716: astore 4
    //   718: aload 4
    //   720: ifnull +13 -> 733
    //   723: aload_3
    //   724: aload 4
    //   726: invokevirtual 273	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   729: pop
    //   730: goto -18 -> 712
    //   733: aload_0
    //   734: getfield 31	com/paypal/android/sdk/ak:d	Landroid/os/Handler;
    //   737: aload_0
    //   738: getfield 31	com/paypal/android/sdk/ak:d	Landroid/os/Handler;
    //   741: iconst_2
    //   742: aload_3
    //   743: invokevirtual 276	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   746: invokestatic 47	android/os/Message:obtain	(Landroid/os/Handler;ILjava/lang/Object;)Landroid/os/Message;
    //   749: invokevirtual 53	android/os/Handler:sendMessage	(Landroid/os/Message;)Z
    //   752: pop
    //   753: aload_2
    //   754: invokestatic 132	com/paypal/android/sdk/R:a	(Ljava/io/Reader;)V
    //   757: aload_1
    //   758: invokeinterface 136 1 0
    //   763: invokeinterface 141 1 0
    //   768: invokestatic 146	com/paypal/android/sdk/an:a	()Lcom/paypal/android/sdk/am;
    //   771: aload_0
    //   772: invokevirtual 151	com/paypal/android/sdk/am:b	(Lcom/paypal/android/sdk/al;)V
    //   775: return
    //   776: astore 4
    //   778: aload_2
    //   779: astore_3
    //   780: aload_1
    //   781: astore_2
    //   782: aload 4
    //   784: astore_1
    //   785: aload_2
    //   786: invokestatic 132	com/paypal/android/sdk/R:a	(Ljava/io/Reader;)V
    //   789: aload_3
    //   790: ifnull +14 -> 804
    //   793: aload_3
    //   794: invokeinterface 136 1 0
    //   799: invokeinterface 141 1 0
    //   804: invokestatic 146	com/paypal/android/sdk/an:a	()Lcom/paypal/android/sdk/am;
    //   807: aload_0
    //   808: invokevirtual 151	com/paypal/android/sdk/am:b	(Lcom/paypal/android/sdk/al;)V
    //   811: aload_1
    //   812: athrow
    //   813: astore_2
    //   814: aload_1
    //   815: astore_3
    //   816: aload_2
    //   817: astore_1
    //   818: aload 4
    //   820: astore_2
    //   821: goto -36 -> 785
    //   824: astore 4
    //   826: aload_1
    //   827: astore_3
    //   828: aload 4
    //   830: astore_1
    //   831: goto -46 -> 785
    //   834: astore 4
    //   836: aload 6
    //   838: astore 5
    //   840: aload_1
    //   841: astore_3
    //   842: goto -240 -> 602
    //   845: astore 4
    //   847: aload_2
    //   848: astore 5
    //   850: aload_1
    //   851: astore_3
    //   852: goto -250 -> 602
    //   855: astore 4
    //   857: goto -560 -> 297
    //   860: astore 4
    //   862: aload_2
    //   863: astore 5
    //   865: aload_1
    //   866: astore_3
    //   867: goto -570 -> 297
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	870	0	this	ak
    //   30	836	1	localObject1	Object
    //   33	753	2	localObject2	Object
    //   813	4	2	localObject3	Object
    //   820	43	2	localObject4	Object
    //   15	852	3	localObject5	Object
    //   23	1	4	localObject6	Object
    //   293	19	4	localRuntimeException1	RuntimeException
    //   593	24	4	localException1	Exception
    //   716	9	4	str	String
    //   776	43	4	localObject7	Object
    //   824	5	4	localObject8	Object
    //   834	1	4	localException2	Exception
    //   845	1	4	localException3	Exception
    //   855	1	4	localRuntimeException2	RuntimeException
    //   860	1	4	localRuntimeException3	RuntimeException
    //   26	838	5	localObject9	Object
    //   17	820	6	localObject10	Object
    //   9	587	7	localNameValuePair	org.apache.http.NameValuePair
    //   12	554	8	localDefaultHttpClient	org.apache.http.impl.client.DefaultHttpClient
    //   20	543	9	localObject11	Object
    //   361	208	10	localSchemeRegistry	org.apache.http.conn.scheme.SchemeRegistry
    //   446	104	11	localBasicHttpParams	org.apache.http.params.BasicHttpParams
    // Exception table:
    //   from	to	target	type
    //   206	252	293	java/lang/RuntimeException
    //   252	290	293	java/lang/RuntimeException
    //   653	704	293	java/lang/RuntimeException
    //   34	54	593	java/lang/Exception
    //   60	67	593	java/lang/Exception
    //   73	94	593	java/lang/Exception
    //   100	121	593	java/lang/Exception
    //   127	148	593	java/lang/Exception
    //   154	175	593	java/lang/Exception
    //   181	188	593	java/lang/Exception
    //   194	203	593	java/lang/Exception
    //   354	363	593	java/lang/Exception
    //   369	389	593	java/lang/Exception
    //   395	402	593	java/lang/Exception
    //   408	433	593	java/lang/Exception
    //   439	448	593	java/lang/Exception
    //   454	469	593	java/lang/Exception
    //   475	494	593	java/lang/Exception
    //   500	514	593	java/lang/Exception
    //   520	528	593	java/lang/Exception
    //   534	556	593	java/lang/Exception
    //   568	590	593	java/lang/Exception
    //   34	54	776	finally
    //   60	67	776	finally
    //   73	94	776	finally
    //   100	121	776	finally
    //   127	148	776	finally
    //   154	175	776	finally
    //   181	188	776	finally
    //   194	203	776	finally
    //   302	320	776	finally
    //   354	363	776	finally
    //   369	389	776	finally
    //   395	402	776	finally
    //   408	433	776	finally
    //   439	448	776	finally
    //   454	469	776	finally
    //   475	494	776	finally
    //   500	514	776	finally
    //   520	528	776	finally
    //   534	556	776	finally
    //   568	590	776	finally
    //   607	625	776	finally
    //   206	252	813	finally
    //   252	290	813	finally
    //   653	704	813	finally
    //   704	712	824	finally
    //   712	718	824	finally
    //   723	730	824	finally
    //   733	753	824	finally
    //   206	252	834	java/lang/Exception
    //   252	290	834	java/lang/Exception
    //   653	704	834	java/lang/Exception
    //   704	712	845	java/lang/Exception
    //   712	718	845	java/lang/Exception
    //   723	730	845	java/lang/Exception
    //   733	753	845	java/lang/Exception
    //   34	54	855	java/lang/RuntimeException
    //   60	67	855	java/lang/RuntimeException
    //   73	94	855	java/lang/RuntimeException
    //   100	121	855	java/lang/RuntimeException
    //   127	148	855	java/lang/RuntimeException
    //   154	175	855	java/lang/RuntimeException
    //   181	188	855	java/lang/RuntimeException
    //   194	203	855	java/lang/RuntimeException
    //   354	363	855	java/lang/RuntimeException
    //   369	389	855	java/lang/RuntimeException
    //   395	402	855	java/lang/RuntimeException
    //   408	433	855	java/lang/RuntimeException
    //   439	448	855	java/lang/RuntimeException
    //   454	469	855	java/lang/RuntimeException
    //   475	494	855	java/lang/RuntimeException
    //   500	514	855	java/lang/RuntimeException
    //   520	528	855	java/lang/RuntimeException
    //   534	556	855	java/lang/RuntimeException
    //   568	590	855	java/lang/RuntimeException
    //   704	712	860	java/lang/RuntimeException
    //   712	718	860	java/lang/RuntimeException
    //   723	730	860	java/lang/RuntimeException
    //   733	753	860	java/lang/RuntimeException
  }
}

/* Location:
 * Qualified Name:     com.paypal.android.sdk.ak
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */