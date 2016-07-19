package com.appboy.support;

import android.content.Context;
import com.appboy.Constants;
import java.io.File;

public class WebContentUtils
{
  private static final String a = String.format("%s.%s", new Object[] { Constants.APPBOY_LOG_TAG_PREFIX, WebContentUtils.class.getName() });
  
  /* Error */
  private static boolean a(String paramString, File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 11
    //   3: aconst_null
    //   4: astore 4
    //   6: aconst_null
    //   7: astore 5
    //   9: aconst_null
    //   10: astore 6
    //   12: aconst_null
    //   13: astore 7
    //   15: aconst_null
    //   16: astore 10
    //   18: aconst_null
    //   19: astore 9
    //   21: aconst_null
    //   22: astore 8
    //   24: aconst_null
    //   25: astore_3
    //   26: aload_0
    //   27: invokestatic 46	com/appboy/support/StringUtils:isNullOrBlank	(Ljava/lang/String;)Z
    //   30: ifeq +14 -> 44
    //   33: getstatic 29	com/appboy/support/WebContentUtils:a	Ljava/lang/String;
    //   36: ldc 48
    //   38: invokestatic 54	com/appboy/support/AppboyLogger:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   41: pop
    //   42: iconst_0
    //   43: ireturn
    //   44: aload_1
    //   45: ifnonnull +14 -> 59
    //   48: getstatic 29	com/appboy/support/WebContentUtils:a	Ljava/lang/String;
    //   51: ldc 56
    //   53: invokestatic 54	com/appboy/support/AppboyLogger:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   56: pop
    //   57: iconst_0
    //   58: ireturn
    //   59: new 58	java/io/File
    //   62: dup
    //   63: aload_0
    //   64: invokespecial 61	java/io/File:<init>	(Ljava/lang/String;)V
    //   67: invokevirtual 65	java/io/File:mkdirs	()Z
    //   70: pop
    //   71: new 67	java/util/zip/ZipInputStream
    //   74: dup
    //   75: new 69	java/io/BufferedInputStream
    //   78: dup
    //   79: new 71	java/io/FileInputStream
    //   82: dup
    //   83: aload_1
    //   84: invokespecial 74	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   87: invokespecial 77	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   90: invokespecial 78	java/util/zip/ZipInputStream:<init>	(Ljava/io/InputStream;)V
    //   93: astore_1
    //   94: aload 11
    //   96: astore 6
    //   98: aload 10
    //   100: astore 4
    //   102: aload_1
    //   103: astore 5
    //   105: aload 9
    //   107: astore 7
    //   109: sipush 8192
    //   112: newarray <illegal type>
    //   114: astore 9
    //   116: aload_3
    //   117: astore 6
    //   119: aload_3
    //   120: astore 4
    //   122: aload_1
    //   123: astore 5
    //   125: aload_3
    //   126: astore 7
    //   128: aload_3
    //   129: astore 8
    //   131: aload_1
    //   132: invokevirtual 82	java/util/zip/ZipInputStream:getNextEntry	()Ljava/util/zip/ZipEntry;
    //   135: astore 10
    //   137: aload 10
    //   139: ifnull +261 -> 400
    //   142: aload_3
    //   143: astore 6
    //   145: aload_3
    //   146: astore 4
    //   148: aload_1
    //   149: astore 5
    //   151: aload_3
    //   152: astore 7
    //   154: aload_3
    //   155: astore 8
    //   157: aload 10
    //   159: invokevirtual 85	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   162: astore 11
    //   164: aload_3
    //   165: astore 6
    //   167: aload_3
    //   168: astore 4
    //   170: aload_1
    //   171: astore 5
    //   173: aload_3
    //   174: astore 7
    //   176: aload_3
    //   177: astore 8
    //   179: aload 11
    //   181: invokevirtual 88	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   184: ldc 90
    //   186: invokevirtual 93	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   189: ifne -73 -> 116
    //   192: aload_3
    //   193: astore 6
    //   195: aload_3
    //   196: astore 4
    //   198: aload_1
    //   199: astore 5
    //   201: aload_3
    //   202: astore 7
    //   204: aload_3
    //   205: astore 8
    //   207: new 95	java/lang/StringBuilder
    //   210: dup
    //   211: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   214: aload_0
    //   215: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   218: ldc 102
    //   220: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   223: aload 11
    //   225: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   228: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   231: astore 11
    //   233: aload_3
    //   234: astore 6
    //   236: aload_3
    //   237: astore 4
    //   239: aload_1
    //   240: astore 5
    //   242: aload_3
    //   243: astore 7
    //   245: aload_3
    //   246: astore 8
    //   248: aload 10
    //   250: invokevirtual 108	java/util/zip/ZipEntry:isDirectory	()Z
    //   253: ifeq +81 -> 334
    //   256: aload_3
    //   257: astore 6
    //   259: aload_3
    //   260: astore 4
    //   262: aload_1
    //   263: astore 5
    //   265: aload_3
    //   266: astore 7
    //   268: aload_3
    //   269: astore 8
    //   271: new 58	java/io/File
    //   274: dup
    //   275: aload 11
    //   277: invokespecial 61	java/io/File:<init>	(Ljava/lang/String;)V
    //   280: invokevirtual 65	java/io/File:mkdirs	()Z
    //   283: pop
    //   284: goto -168 -> 116
    //   287: astore_3
    //   288: aload_1
    //   289: astore_0
    //   290: aload 6
    //   292: astore_1
    //   293: getstatic 29	com/appboy/support/WebContentUtils:a	Ljava/lang/String;
    //   296: ldc 110
    //   298: aload_3
    //   299: invokestatic 114	com/appboy/support/AppboyLogger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   302: pop
    //   303: aload_0
    //   304: ifnull +7 -> 311
    //   307: aload_0
    //   308: invokevirtual 117	java/util/zip/ZipInputStream:close	()V
    //   311: aload_1
    //   312: ifnull -270 -> 42
    //   315: aload_1
    //   316: invokevirtual 120	java/io/BufferedOutputStream:close	()V
    //   319: iconst_0
    //   320: ireturn
    //   321: astore_0
    //   322: getstatic 29	com/appboy/support/WebContentUtils:a	Ljava/lang/String;
    //   325: ldc 122
    //   327: aload_0
    //   328: invokestatic 114	com/appboy/support/AppboyLogger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   331: pop
    //   332: iconst_0
    //   333: ireturn
    //   334: aload_3
    //   335: astore 6
    //   337: aload_3
    //   338: astore 4
    //   340: aload_1
    //   341: astore 5
    //   343: aload_3
    //   344: astore 7
    //   346: aload_3
    //   347: astore 8
    //   349: new 119	java/io/BufferedOutputStream
    //   352: dup
    //   353: new 124	java/io/FileOutputStream
    //   356: dup
    //   357: aload 11
    //   359: invokespecial 125	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   362: invokespecial 128	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   365: astore_3
    //   366: aload_1
    //   367: aload 9
    //   369: invokevirtual 132	java/util/zip/ZipInputStream:read	([B)I
    //   372: istore_2
    //   373: iload_2
    //   374: iconst_m1
    //   375: if_icmpeq +14 -> 389
    //   378: aload_3
    //   379: aload 9
    //   381: iconst_0
    //   382: iload_2
    //   383: invokevirtual 136	java/io/BufferedOutputStream:write	([BII)V
    //   386: goto -20 -> 366
    //   389: aload_3
    //   390: invokevirtual 120	java/io/BufferedOutputStream:close	()V
    //   393: aload_1
    //   394: invokevirtual 139	java/util/zip/ZipInputStream:closeEntry	()V
    //   397: goto -281 -> 116
    //   400: aload_3
    //   401: astore 6
    //   403: aload_3
    //   404: astore 4
    //   406: aload_1
    //   407: astore 5
    //   409: aload_3
    //   410: astore 7
    //   412: aload_3
    //   413: astore 8
    //   415: aload_1
    //   416: invokevirtual 117	java/util/zip/ZipInputStream:close	()V
    //   419: aload_1
    //   420: invokevirtual 117	java/util/zip/ZipInputStream:close	()V
    //   423: aload_3
    //   424: ifnull +7 -> 431
    //   427: aload_3
    //   428: invokevirtual 120	java/io/BufferedOutputStream:close	()V
    //   431: iconst_1
    //   432: ireturn
    //   433: astore_0
    //   434: getstatic 29	com/appboy/support/WebContentUtils:a	Ljava/lang/String;
    //   437: ldc 122
    //   439: aload_0
    //   440: invokestatic 114	com/appboy/support/AppboyLogger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   443: pop
    //   444: goto -13 -> 431
    //   447: astore_3
    //   448: aconst_null
    //   449: astore_1
    //   450: aload 5
    //   452: astore_0
    //   453: aload_0
    //   454: astore 4
    //   456: aload_1
    //   457: astore 5
    //   459: getstatic 29	com/appboy/support/WebContentUtils:a	Ljava/lang/String;
    //   462: ldc -115
    //   464: aload_3
    //   465: invokestatic 114	com/appboy/support/AppboyLogger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   468: pop
    //   469: aload_1
    //   470: ifnull +7 -> 477
    //   473: aload_1
    //   474: invokevirtual 117	java/util/zip/ZipInputStream:close	()V
    //   477: aload_0
    //   478: ifnull -436 -> 42
    //   481: aload_0
    //   482: invokevirtual 120	java/io/BufferedOutputStream:close	()V
    //   485: iconst_0
    //   486: ireturn
    //   487: astore_0
    //   488: getstatic 29	com/appboy/support/WebContentUtils:a	Ljava/lang/String;
    //   491: ldc 122
    //   493: aload_0
    //   494: invokestatic 114	com/appboy/support/AppboyLogger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   497: pop
    //   498: iconst_0
    //   499: ireturn
    //   500: astore_3
    //   501: aconst_null
    //   502: astore_1
    //   503: aload 6
    //   505: astore_0
    //   506: aload_0
    //   507: astore 4
    //   509: aload_1
    //   510: astore 5
    //   512: getstatic 29	com/appboy/support/WebContentUtils:a	Ljava/lang/String;
    //   515: ldc -113
    //   517: aload_3
    //   518: invokestatic 114	com/appboy/support/AppboyLogger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   521: pop
    //   522: aload_1
    //   523: ifnull +7 -> 530
    //   526: aload_1
    //   527: invokevirtual 117	java/util/zip/ZipInputStream:close	()V
    //   530: aload_0
    //   531: ifnull -489 -> 42
    //   534: aload_0
    //   535: invokevirtual 120	java/io/BufferedOutputStream:close	()V
    //   538: iconst_0
    //   539: ireturn
    //   540: astore_0
    //   541: getstatic 29	com/appboy/support/WebContentUtils:a	Ljava/lang/String;
    //   544: ldc 122
    //   546: aload_0
    //   547: invokestatic 114	com/appboy/support/AppboyLogger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   550: pop
    //   551: iconst_0
    //   552: ireturn
    //   553: astore_0
    //   554: aconst_null
    //   555: astore_1
    //   556: aload 7
    //   558: astore 4
    //   560: aload_1
    //   561: ifnull +7 -> 568
    //   564: aload_1
    //   565: invokevirtual 117	java/util/zip/ZipInputStream:close	()V
    //   568: aload 4
    //   570: ifnull +8 -> 578
    //   573: aload 4
    //   575: invokevirtual 120	java/io/BufferedOutputStream:close	()V
    //   578: aload_0
    //   579: athrow
    //   580: astore_1
    //   581: getstatic 29	com/appboy/support/WebContentUtils:a	Ljava/lang/String;
    //   584: ldc 122
    //   586: aload_1
    //   587: invokestatic 114	com/appboy/support/AppboyLogger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   590: pop
    //   591: goto -13 -> 578
    //   594: astore_0
    //   595: aload 5
    //   597: astore_1
    //   598: goto -38 -> 560
    //   601: astore_0
    //   602: aload_3
    //   603: astore 4
    //   605: goto -45 -> 560
    //   608: astore 4
    //   610: aload_0
    //   611: astore_3
    //   612: aload 4
    //   614: astore_0
    //   615: aload_1
    //   616: astore 4
    //   618: aload_3
    //   619: astore_1
    //   620: goto -60 -> 560
    //   623: astore_3
    //   624: aload 7
    //   626: astore_0
    //   627: goto -121 -> 506
    //   630: astore 4
    //   632: aload_3
    //   633: astore_0
    //   634: aload 4
    //   636: astore_3
    //   637: goto -131 -> 506
    //   640: astore_3
    //   641: aload 8
    //   643: astore_0
    //   644: goto -191 -> 453
    //   647: astore 4
    //   649: aload_3
    //   650: astore_0
    //   651: aload 4
    //   653: astore_3
    //   654: goto -201 -> 453
    //   657: astore_3
    //   658: aconst_null
    //   659: astore_0
    //   660: aload 4
    //   662: astore_1
    //   663: goto -370 -> 293
    //   666: astore 5
    //   668: aload_3
    //   669: astore_0
    //   670: aload_1
    //   671: astore 4
    //   673: aload 5
    //   675: astore_3
    //   676: aload_0
    //   677: astore_1
    //   678: aload 4
    //   680: astore_0
    //   681: goto -388 -> 293
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	684	0	paramString	String
    //   0	684	1	paramFile	File
    //   372	11	2	i	int
    //   25	244	3	localObject1	Object
    //   287	60	3	localFileNotFoundException1	java.io.FileNotFoundException
    //   365	63	3	localBufferedOutputStream	java.io.BufferedOutputStream
    //   447	18	3	localIOException1	java.io.IOException
    //   500	103	3	localException1	Exception
    //   611	8	3	str1	String
    //   623	10	3	localException2	Exception
    //   636	1	3	localException3	Exception
    //   640	10	3	localIOException2	java.io.IOException
    //   653	1	3	localIOException3	java.io.IOException
    //   657	12	3	localFileNotFoundException2	java.io.FileNotFoundException
    //   675	1	3	localFileNotFoundException3	java.io.FileNotFoundException
    //   4	600	4	localObject2	Object
    //   608	5	4	localObject3	Object
    //   616	1	4	localFile1	File
    //   630	5	4	localException4	Exception
    //   647	14	4	localIOException4	java.io.IOException
    //   671	8	4	localFile2	File
    //   7	589	5	localFile3	File
    //   666	8	5	localFileNotFoundException4	java.io.FileNotFoundException
    //   10	494	6	localObject4	Object
    //   13	612	7	localObject5	Object
    //   22	620	8	localObject6	Object
    //   19	361	9	arrayOfByte	byte[]
    //   16	233	10	localZipEntry	java.util.zip.ZipEntry
    //   1	357	11	str2	String
    // Exception table:
    //   from	to	target	type
    //   109	116	287	java/io/FileNotFoundException
    //   131	137	287	java/io/FileNotFoundException
    //   157	164	287	java/io/FileNotFoundException
    //   179	192	287	java/io/FileNotFoundException
    //   207	233	287	java/io/FileNotFoundException
    //   248	256	287	java/io/FileNotFoundException
    //   271	284	287	java/io/FileNotFoundException
    //   349	366	287	java/io/FileNotFoundException
    //   415	419	287	java/io/FileNotFoundException
    //   307	311	321	java/io/IOException
    //   315	319	321	java/io/IOException
    //   419	423	433	java/io/IOException
    //   427	431	433	java/io/IOException
    //   71	94	447	java/io/IOException
    //   473	477	487	java/io/IOException
    //   481	485	487	java/io/IOException
    //   71	94	500	java/lang/Exception
    //   526	530	540	java/io/IOException
    //   534	538	540	java/io/IOException
    //   71	94	553	finally
    //   564	568	580	java/io/IOException
    //   573	578	580	java/io/IOException
    //   109	116	594	finally
    //   131	137	594	finally
    //   157	164	594	finally
    //   179	192	594	finally
    //   207	233	594	finally
    //   248	256	594	finally
    //   271	284	594	finally
    //   349	366	594	finally
    //   415	419	594	finally
    //   459	469	594	finally
    //   512	522	594	finally
    //   366	373	601	finally
    //   378	386	601	finally
    //   389	397	601	finally
    //   293	303	608	finally
    //   109	116	623	java/lang/Exception
    //   131	137	623	java/lang/Exception
    //   157	164	623	java/lang/Exception
    //   179	192	623	java/lang/Exception
    //   207	233	623	java/lang/Exception
    //   248	256	623	java/lang/Exception
    //   271	284	623	java/lang/Exception
    //   349	366	623	java/lang/Exception
    //   415	419	623	java/lang/Exception
    //   366	373	630	java/lang/Exception
    //   378	386	630	java/lang/Exception
    //   389	397	630	java/lang/Exception
    //   109	116	640	java/io/IOException
    //   131	137	640	java/io/IOException
    //   157	164	640	java/io/IOException
    //   179	192	640	java/io/IOException
    //   207	233	640	java/io/IOException
    //   248	256	640	java/io/IOException
    //   271	284	640	java/io/IOException
    //   349	366	640	java/io/IOException
    //   415	419	640	java/io/IOException
    //   366	373	647	java/io/IOException
    //   378	386	647	java/io/IOException
    //   389	397	647	java/io/IOException
    //   71	94	657	java/io/FileNotFoundException
    //   366	373	666	java/io/FileNotFoundException
    //   378	386	666	java/io/FileNotFoundException
    //   389	397	666	java/io/FileNotFoundException
  }
  
  public static File getHtmlInAppMessageAssetCacheDirectory(Context paramContext)
  {
    return new File(paramContext.getCacheDir().getPath() + "/appboy-html-inapp-messages");
  }
  
  public static String getLocalHtmlUrlFromRemoteUrl(File paramFile, String paramString)
  {
    if (paramFile == null)
    {
      AppboyLogger.w(a, "Internal cache directory is null. No local URL will be created.");
      return null;
    }
    if (StringUtils.isNullOrBlank(paramString))
    {
      AppboyLogger.w(a, "Remote zip url is null or empty. No local URL will be created.");
      return null;
    }
    paramFile = paramFile.getAbsolutePath();
    String str1 = String.valueOf(IntentUtils.getRequestCode());
    paramFile = paramFile + "/" + str1;
    String str2 = a;
    paramString = AppboyFileUtils.downloadFileToPath(paramFile, paramString, str1, ".zip");
    if (paramString == null)
    {
      paramString = a;
      AppboyFileUtils.deleteFileOrDirectory(new File(paramFile));
      return null;
    }
    str1 = a;
    if (!a(paramFile, paramString))
    {
      AppboyLogger.w(a, "Error during the zip unpack.");
      AppboyFileUtils.deleteFileOrDirectory(new File(paramFile));
      return null;
    }
    paramString = a;
    return paramFile;
  }
}

/* Location:
 * Qualified Name:     com.appboy.support.WebContentUtils
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */