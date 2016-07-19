package com.google.android.gms.internal;

import android.content.Context;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@zzir
public class zzfk
  extends zzfh
{
  private static final Set<String> zzbjt = Collections.synchronizedSet(new HashSet());
  private static final DecimalFormat zzbju = new DecimalFormat("#,###");
  private File zzbjv;
  private boolean zzbjw;
  
  public zzfk(zzll paramzzll)
  {
    super(paramzzll);
    paramzzll = mContext.getCacheDir();
    if (paramzzll == null) {
      zzkh.zzcy("Context.getCacheDir() returned null");
    }
    do
    {
      return;
      zzbjv = new File(paramzzll, "admobVideoStreams");
      if ((!zzbjv.isDirectory()) && (!zzbjv.mkdirs()))
      {
        paramzzll = String.valueOf(zzbjv.getAbsolutePath());
        if (paramzzll.length() != 0) {}
        for (paramzzll = "Could not create preload cache directory at ".concat(paramzzll);; paramzzll = new String("Could not create preload cache directory at "))
        {
          zzkh.zzcy(paramzzll);
          zzbjv = null;
          return;
        }
      }
    } while ((zzbjv.setReadable(true, false)) && (zzbjv.setExecutable(true, false)));
    paramzzll = String.valueOf(zzbjv.getAbsolutePath());
    if (paramzzll.length() != 0) {}
    for (paramzzll = "Could not set cache file permissions at ".concat(paramzzll);; paramzzll = new String("Could not set cache file permissions at "))
    {
      zzkh.zzcy(paramzzll);
      zzbjv = null;
      return;
    }
  }
  
  private File zzb(File paramFile)
  {
    return new File(zzbjv, String.valueOf(paramFile.getName()).concat(".done"));
  }
  
  private static void zzc(File paramFile)
  {
    if (paramFile.isFile())
    {
      paramFile.setLastModified(System.currentTimeMillis());
      return;
    }
    try
    {
      paramFile.createNewFile();
      return;
    }
    catch (IOException paramFile) {}
  }
  
  public void abort()
  {
    zzbjw = true;
  }
  
  /* Error */
  public boolean zzba(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 68	com/google/android/gms/internal/zzfk:zzbjv	Ljava/io/File;
    //   4: ifnonnull +14 -> 18
    //   7: aload_0
    //   8: aload_1
    //   9: aconst_null
    //   10: ldc -113
    //   12: aconst_null
    //   13: invokevirtual 147	com/google/android/gms/internal/zzfk:zza	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   16: iconst_0
    //   17: ireturn
    //   18: aload_0
    //   19: invokevirtual 150	com/google/android/gms/internal/zzfk:zzln	()I
    //   22: getstatic 156	com/google/android/gms/internal/zzdc:zzayk	Lcom/google/android/gms/internal/zzcy;
    //   25: invokevirtual 162	com/google/android/gms/internal/zzcy:get	()Ljava/lang/Object;
    //   28: checkcast 164	java/lang/Integer
    //   31: invokevirtual 167	java/lang/Integer:intValue	()I
    //   34: if_icmple +26 -> 60
    //   37: aload_0
    //   38: invokevirtual 170	com/google/android/gms/internal/zzfk:zzlo	()Z
    //   41: ifne -23 -> 18
    //   44: ldc -84
    //   46: invokestatic 59	com/google/android/gms/internal/zzkh:zzcy	(Ljava/lang/String;)V
    //   49: aload_0
    //   50: aload_1
    //   51: aconst_null
    //   52: ldc -82
    //   54: aconst_null
    //   55: invokevirtual 147	com/google/android/gms/internal/zzfk:zza	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   58: iconst_0
    //   59: ireturn
    //   60: aload_0
    //   61: aload_1
    //   62: invokevirtual 177	com/google/android/gms/internal/zzfk:zzbb	(Ljava/lang/String;)Ljava/lang/String;
    //   65: astore 10
    //   67: new 61	java/io/File
    //   70: dup
    //   71: aload_0
    //   72: getfield 68	com/google/android/gms/internal/zzfk:zzbjv	Ljava/io/File;
    //   75: aload 10
    //   77: invokespecial 66	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   80: astore 17
    //   82: aload_0
    //   83: aload 17
    //   85: invokespecial 179	com/google/android/gms/internal/zzfk:zzb	(Ljava/io/File;)Ljava/io/File;
    //   88: astore 11
    //   90: aload 17
    //   92: invokevirtual 119	java/io/File:isFile	()Z
    //   95: ifeq +73 -> 168
    //   98: aload 11
    //   100: invokevirtual 119	java/io/File:isFile	()Z
    //   103: ifeq +65 -> 168
    //   106: aload 17
    //   108: invokevirtual 181	java/io/File:length	()J
    //   111: l2i
    //   112: istore_2
    //   113: aload_1
    //   114: invokestatic 85	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   117: astore 10
    //   119: aload 10
    //   121: invokevirtual 89	java/lang/String:length	()I
    //   124: ifeq +30 -> 154
    //   127: ldc -73
    //   129: aload 10
    //   131: invokevirtual 95	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   134: astore 10
    //   136: aload 10
    //   138: invokestatic 186	com/google/android/gms/internal/zzkh:zzcw	(Ljava/lang/String;)V
    //   141: aload_0
    //   142: aload_1
    //   143: aload 17
    //   145: invokevirtual 79	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   148: iload_2
    //   149: invokevirtual 189	com/google/android/gms/internal/zzfk:zza	(Ljava/lang/String;Ljava/lang/String;I)V
    //   152: iconst_1
    //   153: ireturn
    //   154: new 81	java/lang/String
    //   157: dup
    //   158: ldc -73
    //   160: invokespecial 96	java/lang/String:<init>	(Ljava/lang/String;)V
    //   163: astore 10
    //   165: goto -29 -> 136
    //   168: aload_0
    //   169: getfield 68	com/google/android/gms/internal/zzfk:zzbjv	Ljava/io/File;
    //   172: invokevirtual 79	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   175: invokestatic 85	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   178: astore 10
    //   180: aload_1
    //   181: invokestatic 85	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   184: astore 12
    //   186: aload 12
    //   188: invokevirtual 89	java/lang/String:length	()I
    //   191: ifeq +85 -> 276
    //   194: aload 10
    //   196: aload 12
    //   198: invokevirtual 95	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   201: astore 16
    //   203: getstatic 29	com/google/android/gms/internal/zzfk:zzbjt	Ljava/util/Set;
    //   206: astore 12
    //   208: aload 12
    //   210: monitorenter
    //   211: getstatic 29	com/google/android/gms/internal/zzfk:zzbjt	Ljava/util/Set;
    //   214: aload 16
    //   216: invokeinterface 195 2 0
    //   221: ifeq +83 -> 304
    //   224: aload_1
    //   225: invokestatic 85	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   228: astore 10
    //   230: aload 10
    //   232: invokevirtual 89	java/lang/String:length	()I
    //   235: ifeq +55 -> 290
    //   238: ldc -59
    //   240: aload 10
    //   242: invokevirtual 95	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   245: astore 10
    //   247: aload 10
    //   249: invokestatic 59	com/google/android/gms/internal/zzkh:zzcy	(Ljava/lang/String;)V
    //   252: aload_0
    //   253: aload_1
    //   254: aload 17
    //   256: invokevirtual 79	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   259: ldc -57
    //   261: aconst_null
    //   262: invokevirtual 147	com/google/android/gms/internal/zzfk:zza	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   265: aload 12
    //   267: monitorexit
    //   268: iconst_0
    //   269: ireturn
    //   270: astore_1
    //   271: aload 12
    //   273: monitorexit
    //   274: aload_1
    //   275: athrow
    //   276: new 81	java/lang/String
    //   279: dup
    //   280: aload 10
    //   282: invokespecial 96	java/lang/String:<init>	(Ljava/lang/String;)V
    //   285: astore 16
    //   287: goto -84 -> 203
    //   290: new 81	java/lang/String
    //   293: dup
    //   294: ldc -59
    //   296: invokespecial 96	java/lang/String:<init>	(Ljava/lang/String;)V
    //   299: astore 10
    //   301: goto -54 -> 247
    //   304: getstatic 29	com/google/android/gms/internal/zzfk:zzbjt	Ljava/util/Set;
    //   307: aload 16
    //   309: invokeinterface 202 2 0
    //   314: pop
    //   315: aload 12
    //   317: monitorexit
    //   318: aconst_null
    //   319: astore 13
    //   321: new 204	java/net/URL
    //   324: dup
    //   325: aload_1
    //   326: invokespecial 205	java/net/URL:<init>	(Ljava/lang/String;)V
    //   329: invokevirtual 209	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   332: astore 10
    //   334: getstatic 212	com/google/android/gms/internal/zzdc:zzayp	Lcom/google/android/gms/internal/zzcy;
    //   337: invokevirtual 162	com/google/android/gms/internal/zzcy:get	()Ljava/lang/Object;
    //   340: checkcast 164	java/lang/Integer
    //   343: invokevirtual 167	java/lang/Integer:intValue	()I
    //   346: istore_2
    //   347: aload 10
    //   349: iload_2
    //   350: invokevirtual 218	java/net/URLConnection:setConnectTimeout	(I)V
    //   353: aload 10
    //   355: iload_2
    //   356: invokevirtual 221	java/net/URLConnection:setReadTimeout	(I)V
    //   359: aload 10
    //   361: instanceof 223
    //   364: ifeq +263 -> 627
    //   367: aload 10
    //   369: checkcast 223	java/net/HttpURLConnection
    //   372: invokevirtual 226	java/net/HttpURLConnection:getResponseCode	()I
    //   375: istore_2
    //   376: iload_2
    //   377: sipush 400
    //   380: if_icmplt +247 -> 627
    //   383: ldc -28
    //   385: astore 12
    //   387: iload_2
    //   388: invokestatic 232	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   391: invokestatic 85	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   394: astore 10
    //   396: aload 10
    //   398: invokevirtual 89	java/lang/String:length	()I
    //   401: ifeq +204 -> 605
    //   404: ldc -22
    //   406: aload 10
    //   408: invokevirtual 95	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   411: astore 11
    //   413: new 116	java/io/IOException
    //   416: dup
    //   417: new 236	java/lang/StringBuilder
    //   420: dup
    //   421: aload_1
    //   422: invokestatic 85	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   425: invokevirtual 89	java/lang/String:length	()I
    //   428: bipush 32
    //   430: iadd
    //   431: invokespecial 238	java/lang/StringBuilder:<init>	(I)V
    //   434: ldc -16
    //   436: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   439: iload_2
    //   440: invokevirtual 247	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   443: ldc -7
    //   445: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   448: aload_1
    //   449: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   452: invokevirtual 251	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   455: invokespecial 252	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   458: athrow
    //   459: astore 10
    //   461: aload 10
    //   463: instanceof 139
    //   466: ifeq +12 -> 478
    //   469: invokestatic 258	com/google/android/gms/ads/internal/zzu:zzft	()Lcom/google/android/gms/internal/zzkb;
    //   472: aload 10
    //   474: iconst_1
    //   475: invokevirtual 263	com/google/android/gms/internal/zzkb:zzb	(Ljava/lang/Throwable;Z)V
    //   478: aload 13
    //   480: invokevirtual 268	java/io/FileOutputStream:close	()V
    //   483: aload_0
    //   484: getfield 135	com/google/android/gms/internal/zzfk:zzbjw	Z
    //   487: ifeq +1044 -> 1531
    //   490: new 236	java/lang/StringBuilder
    //   493: dup
    //   494: aload_1
    //   495: invokestatic 85	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   498: invokevirtual 89	java/lang/String:length	()I
    //   501: bipush 26
    //   503: iadd
    //   504: invokespecial 238	java/lang/StringBuilder:<init>	(I)V
    //   507: ldc_w 270
    //   510: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   513: aload_1
    //   514: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   517: ldc_w 272
    //   520: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   523: invokevirtual 251	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   526: invokestatic 275	com/google/android/gms/internal/zzkh:zzcx	(Ljava/lang/String;)V
    //   529: aload 17
    //   531: invokevirtual 278	java/io/File:exists	()Z
    //   534: ifeq +44 -> 578
    //   537: aload 17
    //   539: invokevirtual 281	java/io/File:delete	()Z
    //   542: ifne +36 -> 578
    //   545: aload 17
    //   547: invokevirtual 79	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   550: invokestatic 85	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   553: astore 10
    //   555: aload 10
    //   557: invokevirtual 89	java/lang/String:length	()I
    //   560: ifeq +1015 -> 1575
    //   563: ldc_w 283
    //   566: aload 10
    //   568: invokevirtual 95	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   571: astore 10
    //   573: aload 10
    //   575: invokestatic 59	com/google/android/gms/internal/zzkh:zzcy	(Ljava/lang/String;)V
    //   578: aload_0
    //   579: aload_1
    //   580: aload 17
    //   582: invokevirtual 79	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   585: aload 12
    //   587: aload 11
    //   589: invokevirtual 147	com/google/android/gms/internal/zzfk:zza	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   592: getstatic 29	com/google/android/gms/internal/zzfk:zzbjt	Ljava/util/Set;
    //   595: aload 16
    //   597: invokeinterface 286 2 0
    //   602: pop
    //   603: iconst_0
    //   604: ireturn
    //   605: new 81	java/lang/String
    //   608: dup
    //   609: ldc -22
    //   611: invokespecial 96	java/lang/String:<init>	(Ljava/lang/String;)V
    //   614: astore 11
    //   616: goto -203 -> 413
    //   619: astore 10
    //   621: aconst_null
    //   622: astore 11
    //   624: goto -163 -> 461
    //   627: aload 10
    //   629: invokevirtual 289	java/net/URLConnection:getContentLength	()I
    //   632: istore 4
    //   634: iload 4
    //   636: ifge +74 -> 710
    //   639: aload_1
    //   640: invokestatic 85	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   643: astore 10
    //   645: aload 10
    //   647: invokevirtual 89	java/lang/String:length	()I
    //   650: ifeq +45 -> 695
    //   653: ldc_w 291
    //   656: aload 10
    //   658: invokevirtual 95	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   661: astore 10
    //   663: aload 10
    //   665: invokestatic 59	com/google/android/gms/internal/zzkh:zzcy	(Ljava/lang/String;)V
    //   668: aload_0
    //   669: aload_1
    //   670: aload 17
    //   672: invokevirtual 79	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   675: ldc_w 293
    //   678: aconst_null
    //   679: invokevirtual 147	com/google/android/gms/internal/zzfk:zza	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   682: getstatic 29	com/google/android/gms/internal/zzfk:zzbjt	Ljava/util/Set;
    //   685: aload 16
    //   687: invokeinterface 286 2 0
    //   692: pop
    //   693: iconst_0
    //   694: ireturn
    //   695: new 81	java/lang/String
    //   698: dup
    //   699: ldc_w 291
    //   702: invokespecial 96	java/lang/String:<init>	(Ljava/lang/String;)V
    //   705: astore 10
    //   707: goto -44 -> 663
    //   710: getstatic 38	com/google/android/gms/internal/zzfk:zzbju	Ljava/text/DecimalFormat;
    //   713: iload 4
    //   715: i2l
    //   716: invokevirtual 297	java/text/DecimalFormat:format	(J)Ljava/lang/String;
    //   719: astore 12
    //   721: getstatic 300	com/google/android/gms/internal/zzdc:zzayl	Lcom/google/android/gms/internal/zzcy;
    //   724: invokevirtual 162	com/google/android/gms/internal/zzcy:get	()Ljava/lang/Object;
    //   727: checkcast 164	java/lang/Integer
    //   730: invokevirtual 167	java/lang/Integer:intValue	()I
    //   733: istore 5
    //   735: iload 4
    //   737: iload 5
    //   739: if_icmple +124 -> 863
    //   742: new 236	java/lang/StringBuilder
    //   745: dup
    //   746: aload 12
    //   748: invokestatic 85	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   751: invokevirtual 89	java/lang/String:length	()I
    //   754: bipush 33
    //   756: iadd
    //   757: aload_1
    //   758: invokestatic 85	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   761: invokevirtual 89	java/lang/String:length	()I
    //   764: iadd
    //   765: invokespecial 238	java/lang/StringBuilder:<init>	(I)V
    //   768: ldc_w 302
    //   771: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   774: aload 12
    //   776: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   779: ldc_w 304
    //   782: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   785: aload_1
    //   786: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   789: invokevirtual 251	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   792: invokestatic 59	com/google/android/gms/internal/zzkh:zzcy	(Ljava/lang/String;)V
    //   795: aload 12
    //   797: invokestatic 85	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   800: astore 10
    //   802: aload 10
    //   804: invokevirtual 89	java/lang/String:length	()I
    //   807: ifeq +41 -> 848
    //   810: ldc_w 306
    //   813: aload 10
    //   815: invokevirtual 95	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   818: astore 10
    //   820: aload_0
    //   821: aload_1
    //   822: aload 17
    //   824: invokevirtual 79	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   827: ldc_w 308
    //   830: aload 10
    //   832: invokevirtual 147	com/google/android/gms/internal/zzfk:zza	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   835: getstatic 29	com/google/android/gms/internal/zzfk:zzbjt	Ljava/util/Set;
    //   838: aload 16
    //   840: invokeinterface 286 2 0
    //   845: pop
    //   846: iconst_0
    //   847: ireturn
    //   848: new 81	java/lang/String
    //   851: dup
    //   852: ldc_w 306
    //   855: invokespecial 96	java/lang/String:<init>	(Ljava/lang/String;)V
    //   858: astore 10
    //   860: goto -40 -> 820
    //   863: new 236	java/lang/StringBuilder
    //   866: dup
    //   867: aload 12
    //   869: invokestatic 85	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   872: invokevirtual 89	java/lang/String:length	()I
    //   875: bipush 20
    //   877: iadd
    //   878: aload_1
    //   879: invokestatic 85	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   882: invokevirtual 89	java/lang/String:length	()I
    //   885: iadd
    //   886: invokespecial 238	java/lang/StringBuilder:<init>	(I)V
    //   889: ldc_w 310
    //   892: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   895: aload 12
    //   897: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   900: ldc_w 312
    //   903: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   906: aload_1
    //   907: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   910: invokevirtual 251	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   913: invokestatic 186	com/google/android/gms/internal/zzkh:zzcw	(Ljava/lang/String;)V
    //   916: aload 10
    //   918: invokevirtual 316	java/net/URLConnection:getInputStream	()Ljava/io/InputStream;
    //   921: invokestatic 322	java/nio/channels/Channels:newChannel	(Ljava/io/InputStream;)Ljava/nio/channels/ReadableByteChannel;
    //   924: astore 12
    //   926: new 265	java/io/FileOutputStream
    //   929: dup
    //   930: aload 17
    //   932: invokespecial 324	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   935: astore 10
    //   937: aload 10
    //   939: invokevirtual 328	java/io/FileOutputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   942: astore 13
    //   944: ldc_w 329
    //   947: invokestatic 335	java/nio/ByteBuffer:allocate	(I)Ljava/nio/ByteBuffer;
    //   950: astore 14
    //   952: invokestatic 339	com/google/android/gms/ads/internal/zzu:zzfu	()Lcom/google/android/gms/common/util/zze;
    //   955: astore 15
    //   957: iconst_0
    //   958: istore_2
    //   959: aload 15
    //   961: invokeinterface 342 1 0
    //   966: lstore 6
    //   968: new 344	com/google/android/gms/internal/zzkv
    //   971: dup
    //   972: getstatic 347	com/google/android/gms/internal/zzdc:zzayo	Lcom/google/android/gms/internal/zzcy;
    //   975: invokevirtual 162	com/google/android/gms/internal/zzcy:get	()Ljava/lang/Object;
    //   978: checkcast 349	java/lang/Long
    //   981: invokevirtual 352	java/lang/Long:longValue	()J
    //   984: invokespecial 355	com/google/android/gms/internal/zzkv:<init>	(J)V
    //   987: astore 18
    //   989: getstatic 358	com/google/android/gms/internal/zzdc:zzayn	Lcom/google/android/gms/internal/zzcy;
    //   992: invokevirtual 162	com/google/android/gms/internal/zzcy:get	()Ljava/lang/Object;
    //   995: checkcast 349	java/lang/Long
    //   998: invokevirtual 352	java/lang/Long:longValue	()J
    //   1001: lstore 8
    //   1003: aload 12
    //   1005: aload 14
    //   1007: invokeinterface 364 2 0
    //   1012: istore_3
    //   1013: iload_3
    //   1014: iflt +405 -> 1419
    //   1017: iload_2
    //   1018: iload_3
    //   1019: iadd
    //   1020: istore_3
    //   1021: iload_3
    //   1022: iload 5
    //   1024: if_icmple +154 -> 1178
    //   1027: ldc_w 308
    //   1030: astore 11
    //   1032: aload 11
    //   1034: astore 12
    //   1036: aload 11
    //   1038: astore 13
    //   1040: iload_3
    //   1041: invokestatic 232	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   1044: invokestatic 85	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   1047: astore 14
    //   1049: aload 11
    //   1051: astore 12
    //   1053: aload 11
    //   1055: astore 13
    //   1057: aload 14
    //   1059: invokevirtual 89	java/lang/String:length	()I
    //   1062: ifeq +73 -> 1135
    //   1065: aload 11
    //   1067: astore 12
    //   1069: aload 11
    //   1071: astore 13
    //   1073: ldc_w 306
    //   1076: aload 14
    //   1078: invokevirtual 95	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   1081: astore 14
    //   1083: aload 14
    //   1085: astore 12
    //   1087: aload 12
    //   1089: astore 14
    //   1091: aload 11
    //   1093: astore 13
    //   1095: aload 11
    //   1097: astore 15
    //   1099: new 116	java/io/IOException
    //   1102: dup
    //   1103: ldc_w 366
    //   1106: invokespecial 252	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   1109: athrow
    //   1110: astore 11
    //   1112: aload 10
    //   1114: astore 15
    //   1116: aload 11
    //   1118: astore 10
    //   1120: aload 14
    //   1122: astore 11
    //   1124: aload 13
    //   1126: astore 12
    //   1128: aload 15
    //   1130: astore 13
    //   1132: goto -671 -> 461
    //   1135: aload 11
    //   1137: astore 12
    //   1139: aload 11
    //   1141: astore 13
    //   1143: new 81	java/lang/String
    //   1146: dup
    //   1147: ldc_w 306
    //   1150: invokespecial 96	java/lang/String:<init>	(Ljava/lang/String;)V
    //   1153: astore 14
    //   1155: aload 14
    //   1157: astore 12
    //   1159: goto -72 -> 1087
    //   1162: astore 14
    //   1164: aconst_null
    //   1165: astore 11
    //   1167: aload 10
    //   1169: astore 13
    //   1171: aload 14
    //   1173: astore 10
    //   1175: goto -714 -> 461
    //   1178: aload 14
    //   1180: invokevirtual 370	java/nio/ByteBuffer:flip	()Ljava/nio/Buffer;
    //   1183: pop
    //   1184: aload 13
    //   1186: aload 14
    //   1188: invokevirtual 375	java/nio/channels/FileChannel:write	(Ljava/nio/ByteBuffer;)I
    //   1191: ifgt -7 -> 1184
    //   1194: aload 14
    //   1196: invokevirtual 378	java/nio/ByteBuffer:clear	()Ljava/nio/Buffer;
    //   1199: pop
    //   1200: aload 15
    //   1202: invokeinterface 342 1 0
    //   1207: lload 6
    //   1209: lsub
    //   1210: ldc2_w 379
    //   1213: lload 8
    //   1215: lmul
    //   1216: lcmp
    //   1217: ifle +122 -> 1339
    //   1220: ldc_w 382
    //   1223: astore 11
    //   1225: aload 11
    //   1227: astore 12
    //   1229: aload 11
    //   1231: astore 13
    //   1233: lload 8
    //   1235: invokestatic 384	java/lang/Long:toString	(J)Ljava/lang/String;
    //   1238: invokestatic 85	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   1241: astore 14
    //   1243: aload 11
    //   1245: astore 12
    //   1247: aload 11
    //   1249: astore 13
    //   1251: new 236	java/lang/StringBuilder
    //   1254: dup
    //   1255: aload 14
    //   1257: invokestatic 85	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   1260: invokevirtual 89	java/lang/String:length	()I
    //   1263: bipush 29
    //   1265: iadd
    //   1266: invokespecial 238	java/lang/StringBuilder:<init>	(I)V
    //   1269: ldc_w 386
    //   1272: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1275: aload 14
    //   1277: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1280: ldc_w 388
    //   1283: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1286: invokevirtual 251	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1289: astore 14
    //   1291: aload 14
    //   1293: astore 12
    //   1295: aload 12
    //   1297: astore 14
    //   1299: aload 11
    //   1301: astore 13
    //   1303: aload 11
    //   1305: astore 15
    //   1307: new 116	java/io/IOException
    //   1310: dup
    //   1311: ldc_w 390
    //   1314: invokespecial 252	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   1317: athrow
    //   1318: astore 11
    //   1320: aload 10
    //   1322: astore 13
    //   1324: aload 11
    //   1326: astore 10
    //   1328: aload 12
    //   1330: astore 11
    //   1332: aload 15
    //   1334: astore 12
    //   1336: goto -875 -> 461
    //   1339: aload_0
    //   1340: getfield 135	com/google/android/gms/internal/zzfk:zzbjw	Z
    //   1343: ifeq +47 -> 1390
    //   1346: ldc_w 392
    //   1349: astore 13
    //   1351: aload 13
    //   1353: astore 12
    //   1355: new 116	java/io/IOException
    //   1358: dup
    //   1359: ldc_w 394
    //   1362: invokespecial 252	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   1365: athrow
    //   1366: astore 12
    //   1368: aconst_null
    //   1369: astore 11
    //   1371: aload 10
    //   1373: astore 14
    //   1375: aload 12
    //   1377: astore 10
    //   1379: aload 13
    //   1381: astore 12
    //   1383: aload 14
    //   1385: astore 13
    //   1387: goto -926 -> 461
    //   1390: iload_3
    //   1391: istore_2
    //   1392: aload 18
    //   1394: invokevirtual 397	com/google/android/gms/internal/zzkv:tryAcquire	()Z
    //   1397: ifeq -394 -> 1003
    //   1400: aload_0
    //   1401: aload_1
    //   1402: aload 17
    //   1404: invokevirtual 79	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1407: iload_3
    //   1408: iload 4
    //   1410: iconst_0
    //   1411: invokevirtual 400	com/google/android/gms/internal/zzfk:zza	(Ljava/lang/String;Ljava/lang/String;IIZ)V
    //   1414: iload_3
    //   1415: istore_2
    //   1416: goto -413 -> 1003
    //   1419: aload 10
    //   1421: invokevirtual 268	java/io/FileOutputStream:close	()V
    //   1424: iconst_3
    //   1425: invokestatic 404	com/google/android/gms/internal/zzkh:zzaz	(I)Z
    //   1428: ifeq +66 -> 1494
    //   1431: getstatic 38	com/google/android/gms/internal/zzfk:zzbju	Ljava/text/DecimalFormat;
    //   1434: iload_2
    //   1435: i2l
    //   1436: invokevirtual 297	java/text/DecimalFormat:format	(J)Ljava/lang/String;
    //   1439: astore 12
    //   1441: new 236	java/lang/StringBuilder
    //   1444: dup
    //   1445: aload 12
    //   1447: invokestatic 85	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   1450: invokevirtual 89	java/lang/String:length	()I
    //   1453: bipush 22
    //   1455: iadd
    //   1456: aload_1
    //   1457: invokestatic 85	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   1460: invokevirtual 89	java/lang/String:length	()I
    //   1463: iadd
    //   1464: invokespecial 238	java/lang/StringBuilder:<init>	(I)V
    //   1467: ldc_w 406
    //   1470: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1473: aload 12
    //   1475: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1478: ldc_w 312
    //   1481: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1484: aload_1
    //   1485: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1488: invokevirtual 251	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1491: invokestatic 186	com/google/android/gms/internal/zzkh:zzcw	(Ljava/lang/String;)V
    //   1494: aload 17
    //   1496: iconst_1
    //   1497: iconst_0
    //   1498: invokevirtual 100	java/io/File:setReadable	(ZZ)Z
    //   1501: pop
    //   1502: aload 11
    //   1504: invokestatic 408	com/google/android/gms/internal/zzfk:zzc	(Ljava/io/File;)V
    //   1507: aload_0
    //   1508: aload_1
    //   1509: aload 17
    //   1511: invokevirtual 79	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1514: iload_2
    //   1515: invokevirtual 189	com/google/android/gms/internal/zzfk:zza	(Ljava/lang/String;Ljava/lang/String;I)V
    //   1518: getstatic 29	com/google/android/gms/internal/zzfk:zzbjt	Ljava/util/Set;
    //   1521: aload 16
    //   1523: invokeinterface 286 2 0
    //   1528: pop
    //   1529: iconst_1
    //   1530: ireturn
    //   1531: new 236	java/lang/StringBuilder
    //   1534: dup
    //   1535: aload_1
    //   1536: invokestatic 85	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   1539: invokevirtual 89	java/lang/String:length	()I
    //   1542: bipush 25
    //   1544: iadd
    //   1545: invokespecial 238	java/lang/StringBuilder:<init>	(I)V
    //   1548: ldc_w 410
    //   1551: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1554: aload_1
    //   1555: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1558: ldc_w 272
    //   1561: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1564: invokevirtual 251	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1567: aload 10
    //   1569: invokestatic 414	com/google/android/gms/internal/zzkh:zzd	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1572: goto -1043 -> 529
    //   1575: new 81	java/lang/String
    //   1578: dup
    //   1579: ldc_w 283
    //   1582: invokespecial 96	java/lang/String:<init>	(Ljava/lang/String;)V
    //   1585: astore 10
    //   1587: goto -1014 -> 573
    //   1590: astore 13
    //   1592: goto -1109 -> 483
    //   1595: astore 13
    //   1597: goto -1114 -> 483
    //   1600: astore 10
    //   1602: aconst_null
    //   1603: astore 11
    //   1605: goto -1144 -> 461
    //   1608: astore 10
    //   1610: goto -1149 -> 461
    //   1613: astore 14
    //   1615: aconst_null
    //   1616: astore 11
    //   1618: ldc_w 416
    //   1621: astore 12
    //   1623: aload 10
    //   1625: astore 13
    //   1627: aload 14
    //   1629: astore 10
    //   1631: goto -1170 -> 461
    //   1634: astore 10
    //   1636: aconst_null
    //   1637: astore 11
    //   1639: ldc_w 416
    //   1642: astore 12
    //   1644: goto -1183 -> 461
    //   1647: astore 10
    //   1649: aconst_null
    //   1650: astore 11
    //   1652: ldc_w 416
    //   1655: astore 12
    //   1657: goto -1196 -> 461
    //   1660: astore 14
    //   1662: aconst_null
    //   1663: astore 11
    //   1665: ldc_w 416
    //   1668: astore 12
    //   1670: aload 10
    //   1672: astore 13
    //   1674: aload 14
    //   1676: astore 10
    //   1678: goto -1217 -> 461
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1681	0	this	zzfk
    //   0	1681	1	paramString	String
    //   112	1403	2	i	int
    //   1012	403	3	j	int
    //   632	777	4	k	int
    //   733	292	5	m	int
    //   966	242	6	l1	long
    //   1001	233	8	l2	long
    //   65	342	10	localObject1	Object
    //   459	14	10	localIOException1	IOException
    //   553	21	10	str1	String
    //   619	9	10	localIOException2	IOException
    //   643	943	10	localObject2	Object
    //   1600	1	10	localRuntimeException1	RuntimeException
    //   1608	16	10	localRuntimeException2	RuntimeException
    //   1629	1	10	localObject3	Object
    //   1634	1	10	localIOException3	IOException
    //   1647	24	10	localRuntimeException3	RuntimeException
    //   1676	1	10	localObject4	Object
    //   88	1008	11	localObject5	Object
    //   1110	7	11	localIOException4	IOException
    //   1122	182	11	localObject6	Object
    //   1318	7	11	localRuntimeException4	RuntimeException
    //   1330	334	11	localObject7	Object
    //   184	1170	12	localObject8	Object
    //   1366	10	12	localRuntimeException5	RuntimeException
    //   1381	288	12	localObject9	Object
    //   319	1067	13	localObject10	Object
    //   1590	1	13	localIOException5	IOException
    //   1595	1	13	localNullPointerException	NullPointerException
    //   1625	48	13	localRuntimeException6	RuntimeException
    //   950	206	14	localObject11	Object
    //   1162	33	14	localIOException6	IOException
    //   1241	143	14	localObject12	Object
    //   1613	15	14	localRuntimeException7	RuntimeException
    //   1660	15	14	localIOException7	IOException
    //   955	378	15	localObject13	Object
    //   201	1321	16	str2	String
    //   80	1430	17	localFile	File
    //   987	406	18	localzzkv	zzkv
    // Exception table:
    //   from	to	target	type
    //   211	247	270	finally
    //   247	268	270	finally
    //   271	274	270	finally
    //   290	301	270	finally
    //   304	318	270	finally
    //   413	459	459	java/io/IOException
    //   387	413	619	java/io/IOException
    //   605	616	619	java/io/IOException
    //   1099	1110	1110	java/io/IOException
    //   1307	1318	1110	java/io/IOException
    //   1040	1049	1162	java/io/IOException
    //   1057	1065	1162	java/io/IOException
    //   1073	1083	1162	java/io/IOException
    //   1143	1155	1162	java/io/IOException
    //   1233	1243	1162	java/io/IOException
    //   1251	1291	1162	java/io/IOException
    //   1355	1366	1162	java/io/IOException
    //   1099	1110	1318	java/lang/RuntimeException
    //   1307	1318	1318	java/lang/RuntimeException
    //   1040	1049	1366	java/lang/RuntimeException
    //   1057	1065	1366	java/lang/RuntimeException
    //   1073	1083	1366	java/lang/RuntimeException
    //   1143	1155	1366	java/lang/RuntimeException
    //   1233	1243	1366	java/lang/RuntimeException
    //   1251	1291	1366	java/lang/RuntimeException
    //   1355	1366	1366	java/lang/RuntimeException
    //   478	483	1590	java/io/IOException
    //   478	483	1595	java/lang/NullPointerException
    //   387	413	1600	java/lang/RuntimeException
    //   605	616	1600	java/lang/RuntimeException
    //   413	459	1608	java/lang/RuntimeException
    //   937	957	1613	java/lang/RuntimeException
    //   959	1003	1613	java/lang/RuntimeException
    //   1003	1013	1613	java/lang/RuntimeException
    //   1178	1184	1613	java/lang/RuntimeException
    //   1184	1220	1613	java/lang/RuntimeException
    //   1339	1346	1613	java/lang/RuntimeException
    //   1392	1414	1613	java/lang/RuntimeException
    //   1419	1494	1613	java/lang/RuntimeException
    //   1494	1529	1613	java/lang/RuntimeException
    //   321	376	1634	java/io/IOException
    //   627	634	1634	java/io/IOException
    //   639	663	1634	java/io/IOException
    //   663	693	1634	java/io/IOException
    //   695	707	1634	java/io/IOException
    //   710	735	1634	java/io/IOException
    //   742	820	1634	java/io/IOException
    //   820	846	1634	java/io/IOException
    //   848	860	1634	java/io/IOException
    //   863	937	1634	java/io/IOException
    //   321	376	1647	java/lang/RuntimeException
    //   627	634	1647	java/lang/RuntimeException
    //   639	663	1647	java/lang/RuntimeException
    //   663	693	1647	java/lang/RuntimeException
    //   695	707	1647	java/lang/RuntimeException
    //   710	735	1647	java/lang/RuntimeException
    //   742	820	1647	java/lang/RuntimeException
    //   820	846	1647	java/lang/RuntimeException
    //   848	860	1647	java/lang/RuntimeException
    //   863	937	1647	java/lang/RuntimeException
    //   937	957	1660	java/io/IOException
    //   959	1003	1660	java/io/IOException
    //   1003	1013	1660	java/io/IOException
    //   1178	1184	1660	java/io/IOException
    //   1184	1220	1660	java/io/IOException
    //   1339	1346	1660	java/io/IOException
    //   1392	1414	1660	java/io/IOException
    //   1419	1494	1660	java/io/IOException
    //   1494	1529	1660	java/io/IOException
  }
  
  public int zzln()
  {
    int i = 0;
    int k = 0;
    if (zzbjv == null) {
      return k;
    }
    File[] arrayOfFile = zzbjv.listFiles();
    int m = arrayOfFile.length;
    int j = 0;
    for (;;)
    {
      k = i;
      if (j >= m) {
        break;
      }
      k = i;
      if (!arrayOfFile[j].getName().endsWith(".done")) {
        k = i + 1;
      }
      j += 1;
      i = k;
    }
  }
  
  public boolean zzlo()
  {
    if (zzbjv == null) {
      return false;
    }
    Object localObject = null;
    long l1 = Long.MAX_VALUE;
    File[] arrayOfFile = zzbjv.listFiles();
    int j = arrayOfFile.length;
    int i = 0;
    if (i < j)
    {
      File localFile = arrayOfFile[i];
      if (localFile.getName().endsWith(".done")) {
        break label134;
      }
      long l2 = localFile.lastModified();
      if (l2 >= l1) {
        break label134;
      }
      localObject = localFile;
      l1 = l2;
    }
    label134:
    for (;;)
    {
      i += 1;
      break;
      boolean bool2;
      if (localObject != null)
      {
        bool2 = ((File)localObject).delete();
        localObject = zzb((File)localObject);
        bool1 = bool2;
        if (!((File)localObject).isFile()) {}
      }
      for (boolean bool1 = bool2 & ((File)localObject).delete();; bool1 = false) {
        return bool1;
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzfk
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */