package com.leanplum;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.util.Log;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

final class FileManager
{
  static Var<HashMap<String, Object>> a = null;
  public static final Object b = new Object();
  private static l c;
  private static boolean d = false;
  private static boolean e = false;
  
  public static int a(String paramString)
  {
    return (int)new File(paramString).length();
  }
  
  public static FileManager.DownloadFileResult a(boolean paramBoolean, String paramString1, String paramString2, Runnable paramRunnable)
  {
    if ((paramString1 != null) && (!paramString1.equals(paramString2)) && ((!paramBoolean) || (aU.c(paramString1) == 0))) {
      try
      {
        if (Leanplum.a().getResources().getAssets().open(paramString1) != null)
        {
          paramString2 = FileManager.DownloadFileResult.EXISTS_IN_ASSETS;
          return paramString2;
        }
      }
      catch (IOException paramString2)
      {
        if ((!d(b(paramString1))) && (!d(c(paramString1))))
        {
          paramString2 = T.a("downloadFile", null);
          paramString2.a(new h(paramRunnable));
          paramString2.a(new i(paramRunnable));
          paramString2.d(paramString1);
          return FileManager.DownloadFileResult.DOWNLOADING;
        }
      }
    }
    return FileManager.DownloadFileResult.NONE;
  }
  
  /* Error */
  public static k a(InputStream paramInputStream)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: ldc 122
    //   4: invokestatic 128	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   7: astore 5
    //   9: new 130	java/security/DigestInputStream
    //   12: dup
    //   13: aload_0
    //   14: aload 5
    //   16: invokespecial 133	java/security/DigestInputStream:<init>	(Ljava/io/InputStream;Ljava/security/MessageDigest;)V
    //   19: astore 4
    //   21: sipush 8192
    //   24: newarray <illegal type>
    //   26: astore_0
    //   27: iconst_0
    //   28: istore_1
    //   29: aload 4
    //   31: aload_0
    //   32: invokevirtual 139	java/io/InputStream:read	([B)I
    //   35: istore_3
    //   36: iload_3
    //   37: iconst_m1
    //   38: if_icmpne +120 -> 158
    //   41: aload 4
    //   43: invokevirtual 142	java/io/InputStream:close	()V
    //   46: aload 5
    //   48: invokevirtual 146	java/security/MessageDigest:digest	()[B
    //   51: astore_0
    //   52: new 148	java/lang/StringBuffer
    //   55: dup
    //   56: invokespecial 149	java/lang/StringBuffer:<init>	()V
    //   59: astore 4
    //   61: iload_2
    //   62: aload_0
    //   63: arraylength
    //   64: if_icmplt +31 -> 95
    //   67: new 151	com/leanplum/k
    //   70: dup
    //   71: aload 4
    //   73: invokevirtual 155	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   76: iload_1
    //   77: invokespecial 158	com/leanplum/k:<init>	(Ljava/lang/String;I)V
    //   80: areturn
    //   81: aload_0
    //   82: invokevirtual 142	java/io/InputStream:close	()V
    //   85: aload 4
    //   87: athrow
    //   88: astore_0
    //   89: aload_0
    //   90: invokevirtual 161	java/security/NoSuchAlgorithmException:printStackTrace	()V
    //   93: aconst_null
    //   94: areturn
    //   95: aload_0
    //   96: iload_2
    //   97: baload
    //   98: sipush 255
    //   101: iand
    //   102: invokestatic 167	java/lang/Integer:toHexString	(I)Ljava/lang/String;
    //   105: astore 5
    //   107: aload 5
    //   109: invokevirtual 170	java/lang/String:length	()I
    //   112: iconst_1
    //   113: if_icmpne +11 -> 124
    //   116: aload 4
    //   118: bipush 48
    //   120: invokevirtual 174	java/lang/StringBuffer:append	(C)Ljava/lang/StringBuffer;
    //   123: pop
    //   124: aload 4
    //   126: aload 5
    //   128: invokevirtual 177	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   131: pop
    //   132: iload_2
    //   133: iconst_1
    //   134: iadd
    //   135: istore_2
    //   136: goto -75 -> 61
    //   139: astore_0
    //   140: aload_0
    //   141: invokevirtual 178	java/io/IOException:printStackTrace	()V
    //   144: aconst_null
    //   145: areturn
    //   146: astore 5
    //   148: aload 4
    //   150: astore_0
    //   151: aload 5
    //   153: astore 4
    //   155: goto -74 -> 81
    //   158: iload_1
    //   159: iload_3
    //   160: iadd
    //   161: istore_1
    //   162: goto -133 -> 29
    //   165: astore 4
    //   167: goto -86 -> 81
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	170	0	paramInputStream	InputStream
    //   28	134	1	i	int
    //   1	135	2	j	int
    //   35	126	3	k	int
    //   19	135	4	localObject1	Object
    //   165	1	4	localObject2	Object
    //   7	120	5	localObject3	Object
    //   146	6	5	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   2	9	88	java/security/NoSuchAlgorithmException
    //   41	61	88	java/security/NoSuchAlgorithmException
    //   61	81	88	java/security/NoSuchAlgorithmException
    //   81	88	88	java/security/NoSuchAlgorithmException
    //   95	124	88	java/security/NoSuchAlgorithmException
    //   124	132	88	java/security/NoSuchAlgorithmException
    //   2	9	139	java/io/IOException
    //   41	61	139	java/io/IOException
    //   61	81	139	java/io/IOException
    //   81	88	139	java/io/IOException
    //   95	124	139	java/io/IOException
    //   124	132	139	java/io/IOException
    //   21	27	146	finally
    //   29	36	146	finally
    //   9	21	165	finally
  }
  
  static InputStream a(boolean paramBoolean, Boolean paramBoolean1, Boolean paramBoolean2, String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    if ((paramString1 == null) || (paramString1.equals(""))) {
      return null;
    }
    if (paramBoolean) {
      try
      {
        if (paramString1.equals(paramString2))
        {
          paramBoolean1 = new ByteArrayInputStream(paramArrayOfByte);
          return paramBoolean1;
        }
      }
      catch (IOException paramBoolean1)
      {
        Log.e("Leanplum", "Error loading stream", paramBoolean1);
        return null;
      }
    }
    paramArrayOfByte = Leanplum.a();
    if (paramBoolean2 == null) {}
    try
    {
      paramBoolean1 = paramArrayOfByte.getAssets().open(paramString1);
      return paramBoolean1;
    }
    catch (IOException paramBoolean1)
    {
      for (;;) {}
    }
    if ((paramBoolean2.booleanValue()) || ((paramBoolean1.booleanValue()) && (paramString1.equals(paramString2)))) {
      return paramArrayOfByte.getAssets().open(paramString1);
    }
    paramBoolean1 = new FileInputStream(new File(paramString1));
    return paramBoolean1;
  }
  
  private static String a(String paramString1, String paramString2)
  {
    return paramString1 + "/" + paramString2;
  }
  
  public static String a(String paramString1, String paramString2, Boolean paramBoolean)
  {
    String str;
    if (paramString1.equals(paramString2))
    {
      str = b(paramString2.toString());
      if (d(str)) {
        return str;
      }
    }
    if (paramBoolean == null) {
      try
      {
        Leanplum.a().getAssets().open(paramString1);
        return paramString1;
      }
      catch (IOException paramBoolean) {}
    }
    while (!paramBoolean.booleanValue())
    {
      str = e(paramString1);
      paramBoolean = str;
      if (d(str)) {
        break;
      }
      str = c(paramString1);
      paramBoolean = str;
      if (d(str)) {
        break;
      }
      paramString1 = b(paramString1);
      paramBoolean = paramString1;
      if (d(paramString1)) {
        break;
      }
      paramString1 = e(paramString2.toString());
      paramBoolean = paramString1;
      if (d(paramString1)) {
        break;
      }
      paramString1 = b(paramString2.toString());
      paramBoolean = paramString1;
      if (d(paramString1)) {
        break;
      }
      return paramString2.toString();
    }
    return paramString1;
    return paramBoolean;
  }
  
  public static void a(l paraml)
  {
    c = paraml;
  }
  
  public static void a(List<String> paramList1, List<String> paramList2, boolean paramBoolean)
  {
    e = true;
    if (d) {
      return;
    }
    if (paramBoolean)
    {
      Util.a(new j(paramList1, paramList2), new Void[0]);
      return;
    }
    b(paramList1, paramList2);
  }
  
  public static boolean a()
  {
    return e;
  }
  
  public static boolean a(Map<String, Object> paramMap1, Map<String, Object> paramMap2)
  {
    if (paramMap2 == null) {
      return true;
    }
    String str1 = (String)paramMap1.get("hash");
    String str2 = (String)paramMap2.get("hash");
    paramMap1 = (Integer)paramMap1.get("size");
    paramMap2 = (Integer)paramMap2.get("size");
    if ((paramMap2 == null) || (!paramMap1.equals(paramMap2))) {
      return true;
    }
    return (str1 != null) && ((str2 == null) || (!str1.equals(str2)));
  }
  
  public static String b(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    return a("", paramString);
  }
  
  /* Error */
  private static void b(List<String> arg0, List<String> paramList2)
  {
    // Byte code:
    //   0: ldc_w 262
    //   3: new 264	java/util/HashMap
    //   6: dup
    //   7: invokespecial 265	java/util/HashMap:<init>	()V
    //   10: invokestatic 271	com/leanplum/Var:define	(Ljava/lang/String;Ljava/lang/Object;)Lcom/leanplum/Var;
    //   13: putstatic 18	com/leanplum/FileManager:a	Lcom/leanplum/Var;
    //   16: invokestatic 56	com/leanplum/Leanplum:a	()Landroid/content/Context;
    //   19: astore 4
    //   21: new 273	java/util/zip/ZipInputStream
    //   24: dup
    //   25: new 204	java/io/FileInputStream
    //   28: dup
    //   29: aload 4
    //   31: invokevirtual 276	android/content/Context:getPackageResourcePath	()Ljava/lang/String;
    //   34: invokespecial 277	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   37: invokespecial 280	java/util/zip/ZipInputStream:<init>	(Ljava/io/InputStream;)V
    //   40: astore 5
    //   42: aload 5
    //   44: astore 4
    //   46: aload 5
    //   48: invokevirtual 284	java/util/zip/ZipInputStream:getNextEntry	()Ljava/util/zip/ZipEntry;
    //   51: astore 8
    //   53: aload 8
    //   55: ifnonnull +37 -> 92
    //   58: aload 5
    //   60: invokevirtual 285	java/util/zip/ZipInputStream:close	()V
    //   63: iconst_1
    //   64: putstatic 20	com/leanplum/FileManager:d	Z
    //   67: getstatic 27	com/leanplum/FileManager:b	Ljava/lang/Object;
    //   70: astore_0
    //   71: aload_0
    //   72: monitorenter
    //   73: iconst_0
    //   74: putstatic 22	com/leanplum/FileManager:e	Z
    //   77: getstatic 228	com/leanplum/FileManager:c	Lcom/leanplum/l;
    //   80: ifnull +9 -> 89
    //   83: getstatic 228	com/leanplum/FileManager:c	Lcom/leanplum/l;
    //   86: invokevirtual 289	com/leanplum/l:a	()V
    //   89: aload_0
    //   90: monitorexit
    //   91: return
    //   92: aload 5
    //   94: astore 4
    //   96: aload 8
    //   98: invokevirtual 294	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   101: astore 6
    //   103: aload 5
    //   105: astore 4
    //   107: aload 6
    //   109: ldc_w 296
    //   112: invokevirtual 299	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   115: ifne +18 -> 133
    //   118: aload 5
    //   120: astore 4
    //   122: aload 6
    //   124: ldc_w 301
    //   127: invokevirtual 299	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   130: ifeq -88 -> 42
    //   133: aload 5
    //   135: astore 4
    //   137: aload 6
    //   139: iconst_4
    //   140: invokevirtual 304	java/lang/String:substring	(I)Ljava/lang/String;
    //   143: astore 7
    //   145: aload_0
    //   146: ifnull +47 -> 193
    //   149: aload 5
    //   151: astore 4
    //   153: aload_0
    //   154: invokeinterface 308 1 0
    //   159: ifle +34 -> 193
    //   162: aload 5
    //   164: astore 4
    //   166: aload_0
    //   167: invokeinterface 312 1 0
    //   172: astore 9
    //   174: aload 5
    //   176: astore 4
    //   178: aload 9
    //   180: invokeinterface 317 1 0
    //   185: ifne +222 -> 407
    //   188: iconst_0
    //   189: istore_2
    //   190: goto +352 -> 542
    //   193: aload_1
    //   194: ifnull +34 -> 228
    //   197: aload 5
    //   199: astore 4
    //   201: aload_1
    //   202: invokeinterface 312 1 0
    //   207: astore 9
    //   209: aload 5
    //   211: astore 4
    //   213: aload 9
    //   215: invokeinterface 317 1 0
    //   220: ifne +214 -> 434
    //   223: iconst_0
    //   224: istore_2
    //   225: goto +324 -> 549
    //   228: aload 5
    //   230: astore 4
    //   232: new 319	java/io/ByteArrayOutputStream
    //   235: dup
    //   236: invokespecial 320	java/io/ByteArrayOutputStream:<init>	()V
    //   239: astore 9
    //   241: aload 5
    //   243: astore 4
    //   245: sipush 8192
    //   248: newarray <illegal type>
    //   250: astore 10
    //   252: iconst_0
    //   253: istore_2
    //   254: aload 5
    //   256: astore 4
    //   258: aload 5
    //   260: aload 10
    //   262: invokevirtual 321	java/util/zip/ZipInputStream:read	([B)I
    //   265: istore_3
    //   266: iload_3
    //   267: iconst_m1
    //   268: if_icmpne +193 -> 461
    //   271: aload 5
    //   273: astore 4
    //   275: aload 5
    //   277: invokevirtual 324	java/util/zip/ZipInputStream:closeEntry	()V
    //   280: aload 5
    //   282: astore 4
    //   284: new 210	java/lang/StringBuilder
    //   287: dup
    //   288: invokespecial 325	java/lang/StringBuilder:<init>	()V
    //   291: aload 8
    //   293: invokevirtual 328	java/util/zip/ZipEntry:getTime	()J
    //   296: invokevirtual 331	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   299: iload_2
    //   300: invokevirtual 334	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   303: invokevirtual 221	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   306: astore 8
    //   308: aload 5
    //   310: astore 4
    //   312: new 210	java/lang/StringBuilder
    //   315: dup
    //   316: ldc_w 336
    //   319: invokespecial 215	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   322: aload 7
    //   324: ldc_w 338
    //   327: ldc_w 340
    //   330: invokevirtual 344	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   333: bipush 47
    //   335: bipush 46
    //   337: invokevirtual 347	java/lang/String:replace	(CC)Ljava/lang/String;
    //   340: invokevirtual 220	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   343: invokevirtual 221	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   346: aload 6
    //   348: iload_2
    //   349: aload 8
    //   351: aload 9
    //   353: invokevirtual 350	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   356: invokestatic 353	com/leanplum/Var:a	(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;[B)Lcom/leanplum/Var;
    //   359: pop
    //   360: goto -318 -> 42
    //   363: astore_1
    //   364: aload 5
    //   366: astore_0
    //   367: aload_0
    //   368: astore 4
    //   370: ldc_w 355
    //   373: ldc_w 357
    //   376: aload_1
    //   377: invokestatic 195	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   380: pop
    //   381: aload_0
    //   382: ifnull -319 -> 63
    //   385: aload_0
    //   386: invokevirtual 285	java/util/zip/ZipInputStream:close	()V
    //   389: goto -326 -> 63
    //   392: astore_0
    //   393: ldc_w 355
    //   396: ldc_w 357
    //   399: aload_0
    //   400: invokestatic 195	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   403: pop
    //   404: goto -341 -> 63
    //   407: aload 5
    //   409: astore 4
    //   411: aload 7
    //   413: aload 9
    //   415: invokeinterface 361 1 0
    //   420: checkcast 43	java/lang/String
    //   423: invokevirtual 364	java/lang/String:matches	(Ljava/lang/String;)Z
    //   426: ifeq -252 -> 174
    //   429: iconst_1
    //   430: istore_2
    //   431: goto +111 -> 542
    //   434: aload 5
    //   436: astore 4
    //   438: aload 7
    //   440: aload 9
    //   442: invokeinterface 361 1 0
    //   447: checkcast 43	java/lang/String
    //   450: invokevirtual 364	java/lang/String:matches	(Ljava/lang/String;)Z
    //   453: ifeq -244 -> 209
    //   456: iconst_1
    //   457: istore_2
    //   458: goto +91 -> 549
    //   461: aload 5
    //   463: astore 4
    //   465: aload 9
    //   467: aload 10
    //   469: iconst_0
    //   470: iload_3
    //   471: invokevirtual 368	java/io/ByteArrayOutputStream:write	([BII)V
    //   474: iload_2
    //   475: iload_3
    //   476: iadd
    //   477: istore_2
    //   478: goto -224 -> 254
    //   481: astore_0
    //   482: aconst_null
    //   483: astore 4
    //   485: aload 4
    //   487: ifnull +8 -> 495
    //   490: aload 4
    //   492: invokevirtual 285	java/util/zip/ZipInputStream:close	()V
    //   495: aload_0
    //   496: athrow
    //   497: astore_1
    //   498: ldc_w 355
    //   501: ldc_w 357
    //   504: aload_1
    //   505: invokestatic 195	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   508: pop
    //   509: goto -14 -> 495
    //   512: astore_0
    //   513: ldc_w 355
    //   516: ldc_w 357
    //   519: aload_0
    //   520: invokestatic 195	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   523: pop
    //   524: goto -461 -> 63
    //   527: astore_1
    //   528: aload_0
    //   529: monitorexit
    //   530: aload_1
    //   531: athrow
    //   532: astore_0
    //   533: goto -48 -> 485
    //   536: astore_1
    //   537: aconst_null
    //   538: astore_0
    //   539: goto -172 -> 367
    //   542: iload_2
    //   543: ifeq -501 -> 42
    //   546: goto -353 -> 193
    //   549: iload_2
    //   550: ifne -508 -> 42
    //   553: goto -325 -> 228
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	556	1	paramList2	List<String>
    //   189	361	2	i	int
    //   265	212	3	j	int
    //   19	472	4	localObject1	Object
    //   40	422	5	localZipInputStream	java.util.zip.ZipInputStream
    //   101	246	6	str1	String
    //   143	296	7	str2	String
    //   51	299	8	localObject2	Object
    //   172	294	9	localObject3	Object
    //   250	218	10	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   46	53	363	java/io/IOException
    //   96	103	363	java/io/IOException
    //   107	118	363	java/io/IOException
    //   122	133	363	java/io/IOException
    //   137	145	363	java/io/IOException
    //   153	162	363	java/io/IOException
    //   166	174	363	java/io/IOException
    //   178	188	363	java/io/IOException
    //   201	209	363	java/io/IOException
    //   213	223	363	java/io/IOException
    //   232	241	363	java/io/IOException
    //   245	252	363	java/io/IOException
    //   258	266	363	java/io/IOException
    //   275	280	363	java/io/IOException
    //   284	308	363	java/io/IOException
    //   312	360	363	java/io/IOException
    //   411	429	363	java/io/IOException
    //   438	456	363	java/io/IOException
    //   465	474	363	java/io/IOException
    //   385	389	392	java/io/IOException
    //   21	42	481	finally
    //   490	495	497	java/io/IOException
    //   58	63	512	java/io/IOException
    //   73	89	527	finally
    //   89	91	527	finally
    //   46	53	532	finally
    //   96	103	532	finally
    //   107	118	532	finally
    //   122	133	532	finally
    //   137	145	532	finally
    //   153	162	532	finally
    //   166	174	532	finally
    //   178	188	532	finally
    //   201	209	532	finally
    //   213	223	532	finally
    //   232	241	532	finally
    //   245	252	532	finally
    //   258	266	532	finally
    //   275	280	532	finally
    //   284	308	532	finally
    //   312	360	532	finally
    //   370	381	532	finally
    //   411	429	532	finally
    //   438	456	532	finally
    //   465	474	532	finally
    //   21	42	536	java/io/IOException
  }
  
  public static String c(String paramString)
  {
    return a(Leanplum.a().getDir("Leanplum_Documents", 0).getAbsolutePath(), paramString);
  }
  
  private static boolean d(String paramString)
  {
    return new File(paramString).exists();
  }
  
  private static String e(String paramString)
  {
    return a(Leanplum.a().getDir("Leanplum_Bundle", 0).getAbsolutePath(), paramString);
  }
}

/* Location:
 * Qualified Name:     com.leanplum.FileManager
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */