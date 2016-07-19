package com.appboy.support;

import android.content.Context;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Environment;
import com.appboy.Constants;
import java.io.File;
import java.net.URLConnection;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class AppboyFileUtils
{
  public static final List<String> REMOTE_SCHEMES = Collections.unmodifiableList(Arrays.asList(new String[] { "http", "https", "ftp", "ftps", "about", "javascript" }));
  private static final String a = String.format("%s.%s", new Object[] { Constants.APPBOY_LOG_TAG_PREFIX, AppboyFileUtils.class.getName() });
  
  public static boolean canStoreAssetsLocally(Context paramContext)
  {
    return (Build.VERSION.SDK_INT >= 19) || (PermissionUtils.hasPermission(paramContext, "android.permission.WRITE_EXTERNAL_STORAGE"));
  }
  
  public static void deleteFileOrDirectory(File paramFile)
  {
    if (paramFile != null) {
      try
      {
        if (!paramFile.exists()) {
          return;
        }
        if (paramFile.isDirectory())
        {
          String[] arrayOfString = paramFile.list();
          int j = arrayOfString.length;
          int i = 0;
          while (i < j)
          {
            deleteFileOrDirectory(new File(paramFile, arrayOfString[i]));
            i += 1;
          }
        }
        paramFile.delete();
        return;
      }
      catch (Exception localException)
      {
        AppboyLogger.e(a, "Caught exception while trying to delete file or directory " + paramFile.getName(), localException);
      }
    }
  }
  
  /* Error */
  public static File downloadFileToPath(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aload_0
    //   4: invokestatic 138	com/appboy/support/StringUtils:isNullOrBlank	(Ljava/lang/String;)Z
    //   7: ifeq +14 -> 21
    //   10: getstatic 32	com/appboy/support/AppboyFileUtils:a	Ljava/lang/String;
    //   13: ldc -116
    //   15: invokestatic 144	com/appboy/support/AppboyLogger:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   18: pop
    //   19: aconst_null
    //   20: areturn
    //   21: aload_1
    //   22: invokestatic 138	com/appboy/support/StringUtils:isNullOrBlank	(Ljava/lang/String;)Z
    //   25: ifeq +14 -> 39
    //   28: getstatic 32	com/appboy/support/AppboyFileUtils:a	Ljava/lang/String;
    //   31: ldc -110
    //   33: invokestatic 144	com/appboy/support/AppboyLogger:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   36: pop
    //   37: aconst_null
    //   38: areturn
    //   39: aload_2
    //   40: invokestatic 138	com/appboy/support/StringUtils:isNullOrBlank	(Ljava/lang/String;)Z
    //   43: ifeq +14 -> 57
    //   46: getstatic 32	com/appboy/support/AppboyFileUtils:a	Ljava/lang/String;
    //   49: ldc -108
    //   51: invokestatic 144	com/appboy/support/AppboyLogger:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   54: pop
    //   55: aconst_null
    //   56: areturn
    //   57: new 84	java/io/File
    //   60: dup
    //   61: aload_0
    //   62: invokespecial 149	java/io/File:<init>	(Ljava/lang/String;)V
    //   65: invokevirtual 152	java/io/File:mkdirs	()Z
    //   68: pop
    //   69: aload_2
    //   70: astore 5
    //   72: aload_3
    //   73: invokestatic 138	com/appboy/support/StringUtils:isNullOrBlank	(Ljava/lang/String;)Z
    //   76: ifne +23 -> 99
    //   79: new 105	java/lang/StringBuilder
    //   82: dup
    //   83: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   86: aload_2
    //   87: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: aload_3
    //   91: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   97: astore 5
    //   99: new 84	java/io/File
    //   102: dup
    //   103: aload_0
    //   104: aload 5
    //   106: invokespecial 156	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   109: astore_3
    //   110: new 158	java/net/URL
    //   113: dup
    //   114: aload_1
    //   115: invokespecial 159	java/net/URL:<init>	(Ljava/lang/String;)V
    //   118: astore_2
    //   119: aload_2
    //   120: invokevirtual 163	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   123: checkcast 165	java/net/HttpURLConnection
    //   126: astore_0
    //   127: aload_0
    //   128: invokevirtual 169	java/net/HttpURLConnection:getResponseCode	()I
    //   131: istore 4
    //   133: iload 4
    //   135: sipush 200
    //   138: if_icmpeq +39 -> 177
    //   141: getstatic 32	com/appboy/support/AppboyFileUtils:a	Ljava/lang/String;
    //   144: astore_2
    //   145: ldc -85
    //   147: iconst_2
    //   148: anewarray 4	java/lang/Object
    //   151: dup
    //   152: iconst_0
    //   153: iload 4
    //   155: invokestatic 177	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   158: aastore
    //   159: dup
    //   160: iconst_1
    //   161: aload_1
    //   162: aastore
    //   163: invokestatic 30	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   166: pop
    //   167: aload_0
    //   168: ifnull +7 -> 175
    //   171: aload_0
    //   172: invokevirtual 180	java/net/HttpURLConnection:disconnect	()V
    //   175: aconst_null
    //   176: areturn
    //   177: sipush 8192
    //   180: newarray <illegal type>
    //   182: astore 5
    //   184: new 182	java/io/DataInputStream
    //   187: dup
    //   188: aload_2
    //   189: invokevirtual 186	java/net/URL:openStream	()Ljava/io/InputStream;
    //   192: invokespecial 189	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   195: astore_1
    //   196: new 191	java/io/BufferedOutputStream
    //   199: dup
    //   200: new 193	java/io/FileOutputStream
    //   203: dup
    //   204: aload_3
    //   205: invokespecial 195	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   208: invokespecial 198	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   211: astore_2
    //   212: aload_1
    //   213: aload 5
    //   215: invokevirtual 202	java/io/DataInputStream:read	([B)I
    //   218: istore 4
    //   220: iload 4
    //   222: iconst_m1
    //   223: if_icmpeq +62 -> 285
    //   226: aload_2
    //   227: aload 5
    //   229: iconst_0
    //   230: iload 4
    //   232: invokevirtual 206	java/io/BufferedOutputStream:write	([BII)V
    //   235: goto -23 -> 212
    //   238: astore 5
    //   240: aload_2
    //   241: astore_3
    //   242: aload_0
    //   243: astore_2
    //   244: aload_3
    //   245: astore_0
    //   246: aload 5
    //   248: astore_3
    //   249: getstatic 32	com/appboy/support/AppboyFileUtils:a	Ljava/lang/String;
    //   252: ldc -48
    //   254: aload_3
    //   255: invokestatic 124	com/appboy/support/AppboyLogger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   258: pop
    //   259: aload_2
    //   260: ifnull +7 -> 267
    //   263: aload_2
    //   264: invokevirtual 180	java/net/HttpURLConnection:disconnect	()V
    //   267: aload_1
    //   268: ifnull +7 -> 275
    //   271: aload_1
    //   272: invokevirtual 211	java/io/DataInputStream:close	()V
    //   275: aload_0
    //   276: ifnull +7 -> 283
    //   279: aload_0
    //   280: invokevirtual 212	java/io/BufferedOutputStream:close	()V
    //   283: aconst_null
    //   284: areturn
    //   285: aload_1
    //   286: invokevirtual 211	java/io/DataInputStream:close	()V
    //   289: aload_0
    //   290: invokevirtual 180	java/net/HttpURLConnection:disconnect	()V
    //   293: aload_2
    //   294: invokevirtual 212	java/io/BufferedOutputStream:close	()V
    //   297: aload_0
    //   298: ifnull +7 -> 305
    //   301: aload_0
    //   302: invokevirtual 180	java/net/HttpURLConnection:disconnect	()V
    //   305: aload_1
    //   306: invokevirtual 211	java/io/DataInputStream:close	()V
    //   309: aload_2
    //   310: invokevirtual 212	java/io/BufferedOutputStream:close	()V
    //   313: aload_3
    //   314: areturn
    //   315: astore_0
    //   316: getstatic 32	com/appboy/support/AppboyFileUtils:a	Ljava/lang/String;
    //   319: ldc -42
    //   321: aload_0
    //   322: invokestatic 124	com/appboy/support/AppboyLogger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   325: pop
    //   326: goto -13 -> 313
    //   329: astore_0
    //   330: getstatic 32	com/appboy/support/AppboyFileUtils:a	Ljava/lang/String;
    //   333: ldc -42
    //   335: aload_0
    //   336: invokestatic 124	com/appboy/support/AppboyLogger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   339: pop
    //   340: goto -57 -> 283
    //   343: astore 6
    //   345: aconst_null
    //   346: astore_2
    //   347: aconst_null
    //   348: astore 7
    //   350: aconst_null
    //   351: astore_0
    //   352: aload_0
    //   353: astore_3
    //   354: aload_2
    //   355: astore 5
    //   357: aload 7
    //   359: astore_1
    //   360: getstatic 32	com/appboy/support/AppboyFileUtils:a	Ljava/lang/String;
    //   363: ldc -40
    //   365: aload 6
    //   367: invokestatic 124	com/appboy/support/AppboyLogger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   370: pop
    //   371: aload_0
    //   372: ifnull +7 -> 379
    //   375: aload_0
    //   376: invokevirtual 180	java/net/HttpURLConnection:disconnect	()V
    //   379: aload 7
    //   381: ifnull +8 -> 389
    //   384: aload 7
    //   386: invokevirtual 211	java/io/DataInputStream:close	()V
    //   389: aload_2
    //   390: ifnull +7 -> 397
    //   393: aload_2
    //   394: invokevirtual 212	java/io/BufferedOutputStream:close	()V
    //   397: aconst_null
    //   398: areturn
    //   399: astore_0
    //   400: getstatic 32	com/appboy/support/AppboyFileUtils:a	Ljava/lang/String;
    //   403: ldc -42
    //   405: aload_0
    //   406: invokestatic 124	com/appboy/support/AppboyLogger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   409: pop
    //   410: goto -13 -> 397
    //   413: astore 6
    //   415: aconst_null
    //   416: astore_2
    //   417: aconst_null
    //   418: astore 7
    //   420: aconst_null
    //   421: astore_0
    //   422: aload_0
    //   423: astore_3
    //   424: aload_2
    //   425: astore 5
    //   427: aload 7
    //   429: astore_1
    //   430: getstatic 32	com/appboy/support/AppboyFileUtils:a	Ljava/lang/String;
    //   433: ldc -38
    //   435: aload 6
    //   437: invokestatic 124	com/appboy/support/AppboyLogger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   440: pop
    //   441: aload_0
    //   442: ifnull +7 -> 449
    //   445: aload_0
    //   446: invokevirtual 180	java/net/HttpURLConnection:disconnect	()V
    //   449: aload 7
    //   451: ifnull +8 -> 459
    //   454: aload 7
    //   456: invokevirtual 211	java/io/DataInputStream:close	()V
    //   459: aload_2
    //   460: ifnull +7 -> 467
    //   463: aload_2
    //   464: invokevirtual 212	java/io/BufferedOutputStream:close	()V
    //   467: aconst_null
    //   468: areturn
    //   469: astore_0
    //   470: getstatic 32	com/appboy/support/AppboyFileUtils:a	Ljava/lang/String;
    //   473: ldc -42
    //   475: aload_0
    //   476: invokestatic 124	com/appboy/support/AppboyLogger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   479: pop
    //   480: goto -13 -> 467
    //   483: astore 6
    //   485: aconst_null
    //   486: astore_2
    //   487: aconst_null
    //   488: astore 7
    //   490: aconst_null
    //   491: astore_0
    //   492: aload_0
    //   493: astore_3
    //   494: aload_2
    //   495: astore 5
    //   497: aload 7
    //   499: astore_1
    //   500: getstatic 32	com/appboy/support/AppboyFileUtils:a	Ljava/lang/String;
    //   503: ldc -36
    //   505: aload 6
    //   507: invokestatic 124	com/appboy/support/AppboyLogger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   510: pop
    //   511: aload_0
    //   512: ifnull +7 -> 519
    //   515: aload_0
    //   516: invokevirtual 180	java/net/HttpURLConnection:disconnect	()V
    //   519: aload 7
    //   521: ifnull +8 -> 529
    //   524: aload 7
    //   526: invokevirtual 211	java/io/DataInputStream:close	()V
    //   529: aload_2
    //   530: ifnull +7 -> 537
    //   533: aload_2
    //   534: invokevirtual 212	java/io/BufferedOutputStream:close	()V
    //   537: aconst_null
    //   538: areturn
    //   539: astore_0
    //   540: getstatic 32	com/appboy/support/AppboyFileUtils:a	Ljava/lang/String;
    //   543: ldc -42
    //   545: aload_0
    //   546: invokestatic 124	com/appboy/support/AppboyLogger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   549: pop
    //   550: goto -13 -> 537
    //   553: astore_0
    //   554: aconst_null
    //   555: astore_1
    //   556: aconst_null
    //   557: astore_2
    //   558: aload 6
    //   560: astore 5
    //   562: aload_2
    //   563: ifnull +7 -> 570
    //   566: aload_2
    //   567: invokevirtual 180	java/net/HttpURLConnection:disconnect	()V
    //   570: aload_1
    //   571: ifnull +7 -> 578
    //   574: aload_1
    //   575: invokevirtual 211	java/io/DataInputStream:close	()V
    //   578: aload 5
    //   580: ifnull +8 -> 588
    //   583: aload 5
    //   585: invokevirtual 212	java/io/BufferedOutputStream:close	()V
    //   588: aload_0
    //   589: athrow
    //   590: astore_1
    //   591: getstatic 32	com/appboy/support/AppboyFileUtils:a	Ljava/lang/String;
    //   594: ldc -42
    //   596: aload_1
    //   597: invokestatic 124	com/appboy/support/AppboyLogger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   600: pop
    //   601: goto -13 -> 588
    //   604: astore_3
    //   605: aconst_null
    //   606: astore_1
    //   607: aload_0
    //   608: astore_2
    //   609: aload_3
    //   610: astore_0
    //   611: aload 6
    //   613: astore 5
    //   615: goto -53 -> 562
    //   618: astore_3
    //   619: aload_0
    //   620: astore_2
    //   621: aload_3
    //   622: astore_0
    //   623: aload 6
    //   625: astore 5
    //   627: goto -65 -> 562
    //   630: astore 5
    //   632: aload_0
    //   633: astore_3
    //   634: aload 5
    //   636: astore_0
    //   637: aload_2
    //   638: astore 5
    //   640: aload_3
    //   641: astore_2
    //   642: goto -80 -> 562
    //   645: astore_3
    //   646: aload_0
    //   647: astore 5
    //   649: aload_3
    //   650: astore_0
    //   651: goto -89 -> 562
    //   654: astore_0
    //   655: aload_3
    //   656: astore_2
    //   657: goto -95 -> 562
    //   660: astore 6
    //   662: aconst_null
    //   663: astore_2
    //   664: aconst_null
    //   665: astore 7
    //   667: goto -175 -> 492
    //   670: astore 6
    //   672: aconst_null
    //   673: astore_2
    //   674: aload_1
    //   675: astore 7
    //   677: goto -185 -> 492
    //   680: astore 6
    //   682: aload_1
    //   683: astore 7
    //   685: goto -193 -> 492
    //   688: astore 6
    //   690: aconst_null
    //   691: astore_2
    //   692: aconst_null
    //   693: astore 7
    //   695: goto -273 -> 422
    //   698: astore 6
    //   700: aconst_null
    //   701: astore_2
    //   702: aload_1
    //   703: astore 7
    //   705: goto -283 -> 422
    //   708: astore 6
    //   710: aload_1
    //   711: astore 7
    //   713: goto -291 -> 422
    //   716: astore 6
    //   718: aconst_null
    //   719: astore_2
    //   720: aconst_null
    //   721: astore 7
    //   723: goto -371 -> 352
    //   726: astore 6
    //   728: aconst_null
    //   729: astore_2
    //   730: aload_1
    //   731: astore 7
    //   733: goto -381 -> 352
    //   736: astore 6
    //   738: aload_1
    //   739: astore 7
    //   741: goto -389 -> 352
    //   744: astore_3
    //   745: aconst_null
    //   746: astore_0
    //   747: aconst_null
    //   748: astore_1
    //   749: aconst_null
    //   750: astore_2
    //   751: goto -502 -> 249
    //   754: astore_3
    //   755: aconst_null
    //   756: astore_1
    //   757: aload_0
    //   758: astore_2
    //   759: aconst_null
    //   760: astore_0
    //   761: goto -512 -> 249
    //   764: astore_3
    //   765: aload_0
    //   766: astore_2
    //   767: aconst_null
    //   768: astore_0
    //   769: goto -520 -> 249
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	772	0	paramString1	String
    //   0	772	1	paramString2	String
    //   0	772	2	paramString3	String
    //   0	772	3	paramString4	String
    //   131	100	4	i	int
    //   70	158	5	localObject1	Object
    //   238	9	5	localMalformedURLException	java.net.MalformedURLException
    //   355	271	5	localObject2	Object
    //   630	5	5	localObject3	Object
    //   638	10	5	str1	String
    //   1	1	6	localObject4	Object
    //   343	23	6	localIOException1	java.io.IOException
    //   413	23	6	localException1	Exception
    //   483	141	6	localThrowable1	Throwable
    //   660	1	6	localThrowable2	Throwable
    //   670	1	6	localThrowable3	Throwable
    //   680	1	6	localThrowable4	Throwable
    //   688	1	6	localException2	Exception
    //   698	1	6	localException3	Exception
    //   708	1	6	localException4	Exception
    //   716	1	6	localIOException2	java.io.IOException
    //   726	1	6	localIOException3	java.io.IOException
    //   736	1	6	localIOException4	java.io.IOException
    //   348	392	7	str2	String
    // Exception table:
    //   from	to	target	type
    //   212	220	238	java/net/MalformedURLException
    //   226	235	238	java/net/MalformedURLException
    //   285	297	238	java/net/MalformedURLException
    //   305	313	315	java/io/IOException
    //   271	275	329	java/io/IOException
    //   279	283	329	java/io/IOException
    //   110	127	343	java/io/IOException
    //   384	389	399	java/io/IOException
    //   393	397	399	java/io/IOException
    //   110	127	413	java/lang/Exception
    //   454	459	469	java/io/IOException
    //   463	467	469	java/io/IOException
    //   110	127	483	java/lang/Throwable
    //   524	529	539	java/io/IOException
    //   533	537	539	java/io/IOException
    //   110	127	553	finally
    //   574	578	590	java/io/IOException
    //   583	588	590	java/io/IOException
    //   127	133	604	finally
    //   141	167	604	finally
    //   177	196	604	finally
    //   196	212	618	finally
    //   212	220	630	finally
    //   226	235	630	finally
    //   285	297	630	finally
    //   249	259	645	finally
    //   360	371	654	finally
    //   430	441	654	finally
    //   500	511	654	finally
    //   127	133	660	java/lang/Throwable
    //   141	167	660	java/lang/Throwable
    //   177	196	660	java/lang/Throwable
    //   196	212	670	java/lang/Throwable
    //   212	220	680	java/lang/Throwable
    //   226	235	680	java/lang/Throwable
    //   285	297	680	java/lang/Throwable
    //   127	133	688	java/lang/Exception
    //   141	167	688	java/lang/Exception
    //   177	196	688	java/lang/Exception
    //   196	212	698	java/lang/Exception
    //   212	220	708	java/lang/Exception
    //   226	235	708	java/lang/Exception
    //   285	297	708	java/lang/Exception
    //   127	133	716	java/io/IOException
    //   141	167	716	java/io/IOException
    //   177	196	716	java/io/IOException
    //   196	212	726	java/io/IOException
    //   212	220	736	java/io/IOException
    //   226	235	736	java/io/IOException
    //   285	297	736	java/io/IOException
    //   110	127	744	java/net/MalformedURLException
    //   127	133	754	java/net/MalformedURLException
    //   141	167	754	java/net/MalformedURLException
    //   177	196	754	java/net/MalformedURLException
    //   196	212	764	java/net/MalformedURLException
  }
  
  public static File getApplicationCacheDir(Context paramContext)
  {
    return paramContext.getCacheDir();
  }
  
  public static File getExternalStorage(String paramString)
  {
    String str = Environment.getExternalStorageState();
    if (str.equals("mounted")) {
      return new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/" + paramString);
    }
    AppboyLogger.e(a, "External storage state not mounted. State:" + str);
    return null;
  }
  
  public static String getMimeType(String paramString)
  {
    if (StringUtils.isNullOrBlank(paramString)) {
      return null;
    }
    return URLConnection.guessContentTypeFromName(paramString.split("\\?")[0]);
  }
  
  public static boolean isLocalUri(Uri paramUri)
  {
    if (paramUri == null) {
      AppboyLogger.i(a, "Null Uri received.");
    }
    do
    {
      return false;
      paramUri = paramUri.getScheme();
    } while ((!StringUtils.isNullOrBlank(paramUri)) && (!paramUri.equals("file")));
    return true;
  }
  
  public static boolean isRemoteUri(Uri paramUri)
  {
    if (paramUri == null) {
      AppboyLogger.i(a, "Null Uri received.");
    }
    do
    {
      return false;
      paramUri = paramUri.getScheme();
      if (StringUtils.isNullOrBlank(paramUri))
      {
        AppboyLogger.i(a, "Null or blank Uri scheme.");
        return false;
      }
    } while (!REMOTE_SCHEMES.contains(paramUri));
    return true;
  }
}

/* Location:
 * Qualified Name:     com.appboy.support.AppboyFileUtils
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */