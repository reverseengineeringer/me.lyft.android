package com.google.android.gms.internal;

import android.graphics.Color;
import android.location.Location;
import android.os.Bundle;
import android.os.Debug.MemoryInfo;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.SearchAdRequestParcel;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.ads.internal.reward.mediation.client.RewardItemParcel;
import com.google.android.gms.ads.internal.zzu;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zzir
public final class zziu
{
  private static final SimpleDateFormat zzcep = new SimpleDateFormat("yyyyMMdd", Locale.US);
  
  /* Error */
  public static AdResponseParcel zza(android.content.Context paramContext, com.google.android.gms.ads.internal.request.AdRequestInfoParcel paramAdRequestInfoParcel, String paramString)
  {
    // Byte code:
    //   0: new 32	org/json/JSONObject
    //   3: dup
    //   4: aload_2
    //   5: invokespecial 35	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   8: astore 28
    //   10: aload 28
    //   12: ldc 37
    //   14: aconst_null
    //   15: invokevirtual 41	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   18: astore 24
    //   20: aload 28
    //   22: ldc 43
    //   24: aconst_null
    //   25: invokevirtual 41	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   28: astore 25
    //   30: aload 28
    //   32: ldc 45
    //   34: aconst_null
    //   35: invokevirtual 41	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   38: astore 29
    //   40: aload 28
    //   42: ldc 47
    //   44: aload 29
    //   46: invokevirtual 41	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   49: astore 30
    //   51: aload_1
    //   52: ifnull +770 -> 822
    //   55: aload_1
    //   56: getfield 53	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:zzcbb	I
    //   59: ifeq +763 -> 822
    //   62: iconst_1
    //   63: istore 5
    //   65: aload 28
    //   67: ldc 55
    //   69: aconst_null
    //   70: invokevirtual 41	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   73: astore_2
    //   74: aload_2
    //   75: astore 23
    //   77: aload_2
    //   78: ifnonnull +13 -> 91
    //   81: aload 28
    //   83: ldc 57
    //   85: aconst_null
    //   86: invokevirtual 41	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   89: astore 23
    //   91: aload 23
    //   93: astore_2
    //   94: aload 23
    //   96: ifnonnull +12 -> 108
    //   99: aload 28
    //   101: ldc 59
    //   103: aconst_null
    //   104: invokevirtual 41	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   107: astore_2
    //   108: ldc2_w 60
    //   111: lstore 17
    //   113: aload 28
    //   115: ldc 63
    //   117: aconst_null
    //   118: invokevirtual 41	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   121: astore 31
    //   123: aload 28
    //   125: ldc 65
    //   127: invokevirtual 69	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   130: ifeq +698 -> 828
    //   133: aload 28
    //   135: ldc 65
    //   137: invokevirtual 73	org/json/JSONObject:getDouble	(Ljava/lang/String;)D
    //   140: ldc2_w 74
    //   143: dmul
    //   144: d2l
    //   145: lstore 15
    //   147: aload 28
    //   149: ldc 77
    //   151: aconst_null
    //   152: invokevirtual 41	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   155: astore 23
    //   157: iconst_m1
    //   158: istore_3
    //   159: ldc 79
    //   161: aload 23
    //   163: invokevirtual 85	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   166: ifeq +82 -> 248
    //   169: invokestatic 91	com/google/android/gms/ads/internal/zzu:zzfs	()Lcom/google/android/gms/internal/zzkm;
    //   172: invokevirtual 97	com/google/android/gms/internal/zzkm:zztl	()I
    //   175: istore_3
    //   176: aconst_null
    //   177: astore 26
    //   179: aload_2
    //   180: invokestatic 103	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   183: ifeq +630 -> 813
    //   186: aload 25
    //   188: invokestatic 103	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   191: ifne +622 -> 813
    //   194: aload_1
    //   195: aload_0
    //   196: aload_1
    //   197: getfield 107	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:zzaou	Lcom/google/android/gms/ads/internal/util/client/VersionInfoParcel;
    //   200: getfield 113	com/google/android/gms/ads/internal/util/client/VersionInfoParcel:zzcs	Ljava/lang/String;
    //   203: aload 25
    //   205: aconst_null
    //   206: aconst_null
    //   207: aconst_null
    //   208: aconst_null
    //   209: invokestatic 118	com/google/android/gms/internal/zzit:zza	(Lcom/google/android/gms/ads/internal/request/AdRequestInfoParcel;Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/google/android/gms/internal/zziy;Lcom/google/android/gms/internal/zzdk;Lcom/google/android/gms/internal/zzis;)Lcom/google/android/gms/ads/internal/request/AdResponseParcel;
    //   212: astore 26
    //   214: aload 26
    //   216: getfield 123	com/google/android/gms/ads/internal/request/AdResponseParcel:zzbts	Ljava/lang/String;
    //   219: astore_2
    //   220: aload 26
    //   222: getfield 125	com/google/android/gms/ads/internal/request/AdResponseParcel:body	Ljava/lang/String;
    //   225: astore 23
    //   227: aload 26
    //   229: getfield 129	com/google/android/gms/ads/internal/request/AdResponseParcel:zzccg	J
    //   232: lstore 17
    //   234: aload 23
    //   236: ifnonnull +32 -> 268
    //   239: new 120	com/google/android/gms/ads/internal/request/AdResponseParcel
    //   242: dup
    //   243: iconst_0
    //   244: invokespecial 132	com/google/android/gms/ads/internal/request/AdResponseParcel:<init>	(I)V
    //   247: areturn
    //   248: ldc -122
    //   250: aload 23
    //   252: invokevirtual 85	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   255: ifeq -79 -> 176
    //   258: invokestatic 91	com/google/android/gms/ads/internal/zzu:zzfs	()Lcom/google/android/gms/internal/zzkm;
    //   261: invokevirtual 137	com/google/android/gms/internal/zzkm:zztk	()I
    //   264: istore_3
    //   265: goto -89 -> 176
    //   268: aload 28
    //   270: ldc -117
    //   272: invokevirtual 143	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   275: astore 25
    //   277: aload 26
    //   279: ifnonnull +488 -> 767
    //   282: aconst_null
    //   283: astore_0
    //   284: aload_0
    //   285: astore 24
    //   287: aload 25
    //   289: ifnull +11 -> 300
    //   292: aload 25
    //   294: aload_0
    //   295: invokestatic 146	com/google/android/gms/internal/zziu:zza	(Lorg/json/JSONArray;Ljava/util/List;)Ljava/util/List;
    //   298: astore 24
    //   300: aload 28
    //   302: ldc -108
    //   304: invokevirtual 143	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   307: astore 27
    //   309: aload 26
    //   311: ifnonnull +465 -> 776
    //   314: aconst_null
    //   315: astore_0
    //   316: aload_0
    //   317: astore 25
    //   319: aload 27
    //   321: ifnull +11 -> 332
    //   324: aload 27
    //   326: aload_0
    //   327: invokestatic 146	com/google/android/gms/internal/zziu:zza	(Lorg/json/JSONArray;Ljava/util/List;)Ljava/util/List;
    //   330: astore 25
    //   332: aload 28
    //   334: ldc -106
    //   336: invokevirtual 143	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   339: astore 32
    //   341: aload 26
    //   343: ifnonnull +442 -> 785
    //   346: aconst_null
    //   347: astore_0
    //   348: aload_0
    //   349: astore 27
    //   351: aload 32
    //   353: ifnull +11 -> 364
    //   356: aload 32
    //   358: aload_0
    //   359: invokestatic 146	com/google/android/gms/internal/zziu:zza	(Lorg/json/JSONArray;Ljava/util/List;)Ljava/util/List;
    //   362: astore 27
    //   364: iload_3
    //   365: istore 4
    //   367: aload 26
    //   369: ifnull +438 -> 807
    //   372: aload 26
    //   374: getfield 152	com/google/android/gms/ads/internal/request/AdResponseParcel:orientation	I
    //   377: iconst_m1
    //   378: if_icmpeq +9 -> 387
    //   381: aload 26
    //   383: getfield 152	com/google/android/gms/ads/internal/request/AdResponseParcel:orientation	I
    //   386: istore_3
    //   387: iload_3
    //   388: istore 4
    //   390: aload 26
    //   392: getfield 155	com/google/android/gms/ads/internal/request/AdResponseParcel:zzccb	J
    //   395: lconst_0
    //   396: lcmp
    //   397: ifle +410 -> 807
    //   400: aload 26
    //   402: getfield 155	com/google/android/gms/ads/internal/request/AdResponseParcel:zzccb	J
    //   405: lstore 15
    //   407: aload 28
    //   409: ldc -99
    //   411: invokevirtual 160	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   414: astore 26
    //   416: aconst_null
    //   417: astore_0
    //   418: aload 28
    //   420: ldc -94
    //   422: iconst_0
    //   423: invokevirtual 166	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   426: istore 6
    //   428: iload 6
    //   430: ifeq +12 -> 442
    //   433: aload 28
    //   435: ldc -88
    //   437: aconst_null
    //   438: invokevirtual 41	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   441: astore_0
    //   442: aload 28
    //   444: ldc -86
    //   446: iconst_0
    //   447: invokevirtual 166	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   450: istore 7
    //   452: aload 28
    //   454: ldc -84
    //   456: iconst_0
    //   457: invokevirtual 166	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   460: istore 8
    //   462: aload 28
    //   464: ldc -82
    //   466: iconst_1
    //   467: invokevirtual 166	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   470: istore 9
    //   472: aload 28
    //   474: ldc -80
    //   476: iconst_0
    //   477: invokevirtual 166	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   480: istore 10
    //   482: aload 28
    //   484: ldc -78
    //   486: ldc2_w 60
    //   489: invokevirtual 182	org/json/JSONObject:optLong	(Ljava/lang/String;J)J
    //   492: lstore 19
    //   494: aload 28
    //   496: ldc -72
    //   498: ldc2_w 60
    //   501: invokevirtual 182	org/json/JSONObject:optLong	(Ljava/lang/String;J)J
    //   504: lstore 21
    //   506: aload 28
    //   508: ldc -70
    //   510: ldc -68
    //   512: invokevirtual 41	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   515: astore 32
    //   517: ldc -66
    //   519: aload 28
    //   521: ldc -64
    //   523: ldc -68
    //   525: invokevirtual 41	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   528: invokevirtual 85	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   531: istore 11
    //   533: aload 28
    //   535: ldc -62
    //   537: iconst_0
    //   538: invokevirtual 166	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   541: istore 12
    //   543: aload 28
    //   545: ldc -60
    //   547: invokevirtual 143	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   550: aconst_null
    //   551: invokestatic 146	com/google/android/gms/internal/zziu:zza	(Lorg/json/JSONArray;Ljava/util/List;)Ljava/util/List;
    //   554: astore 33
    //   556: aload 28
    //   558: ldc -58
    //   560: invokevirtual 143	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   563: aconst_null
    //   564: invokestatic 146	com/google/android/gms/internal/zziu:zza	(Lorg/json/JSONArray;Ljava/util/List;)Ljava/util/List;
    //   567: astore 34
    //   569: aload 28
    //   571: ldc -56
    //   573: invokevirtual 143	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   576: invokestatic 205	com/google/android/gms/ads/internal/reward/mediation/client/RewardItemParcel:zza	(Lorg/json/JSONArray;)Lcom/google/android/gms/ads/internal/reward/mediation/client/RewardItemParcel;
    //   579: astore 35
    //   581: aload 28
    //   583: ldc -49
    //   585: iconst_0
    //   586: invokevirtual 166	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   589: istore 13
    //   591: aload 28
    //   593: ldc -47
    //   595: invokevirtual 213	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   598: invokestatic 219	com/google/android/gms/ads/internal/request/AutoClickProtectionConfigurationParcel:zzh	(Lorg/json/JSONObject;)Lcom/google/android/gms/ads/internal/request/AutoClickProtectionConfigurationParcel;
    //   601: astore 36
    //   603: aload 28
    //   605: ldc -35
    //   607: ldc -68
    //   609: invokevirtual 41	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   612: astore 37
    //   614: aload 28
    //   616: ldc -33
    //   618: invokevirtual 143	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   621: aconst_null
    //   622: invokestatic 146	com/google/android/gms/internal/zziu:zza	(Lorg/json/JSONArray;Ljava/util/List;)Ljava/util/List;
    //   625: astore 38
    //   627: aload 28
    //   629: ldc -31
    //   631: invokevirtual 160	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   634: astore 39
    //   636: aload 28
    //   638: ldc -29
    //   640: aload_1
    //   641: getfield 231	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:zzbnu	Z
    //   644: invokevirtual 166	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   647: istore 14
    //   649: new 120	com/google/android/gms/ads/internal/request/AdResponseParcel
    //   652: dup
    //   653: aload_1
    //   654: aload_2
    //   655: aload 23
    //   657: aload 24
    //   659: aload 25
    //   661: lload 15
    //   663: iload 7
    //   665: lload 21
    //   667: aload 27
    //   669: lload 19
    //   671: iload_3
    //   672: aload 29
    //   674: lload 17
    //   676: aload 31
    //   678: iload 6
    //   680: aload_0
    //   681: aload 26
    //   683: iload 8
    //   685: iload 5
    //   687: aload_1
    //   688: getfield 234	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:zzcbd	Z
    //   691: iload 9
    //   693: iload 10
    //   695: aload 32
    //   697: iload 11
    //   699: iload 12
    //   701: aload 35
    //   703: aload 33
    //   705: aload 34
    //   707: iload 13
    //   709: aload 36
    //   711: aload_1
    //   712: getfield 237	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:zzcbu	Z
    //   715: aload 37
    //   717: aload 38
    //   719: aload 39
    //   721: iload 14
    //   723: aload 30
    //   725: invokespecial 240	com/google/android/gms/ads/internal/request/AdResponseParcel:<init>	(Lcom/google/android/gms/ads/internal/request/AdRequestInfoParcel;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;JZJLjava/util/List;JILjava/lang/String;JLjava/lang/String;ZLjava/lang/String;Ljava/lang/String;ZZZZZLjava/lang/String;ZZLcom/google/android/gms/ads/internal/reward/mediation/client/RewardItemParcel;Ljava/util/List;Ljava/util/List;ZLcom/google/android/gms/ads/internal/request/AutoClickProtectionConfigurationParcel;ZLjava/lang/String;Ljava/util/List;Ljava/lang/String;ZLjava/lang/String;)V
    //   728: astore_0
    //   729: aload_0
    //   730: areturn
    //   731: astore_0
    //   732: aload_0
    //   733: invokevirtual 244	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   736: invokestatic 248	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   739: astore_0
    //   740: aload_0
    //   741: invokevirtual 251	java/lang/String:length	()I
    //   744: ifeq +50 -> 794
    //   747: ldc -3
    //   749: aload_0
    //   750: invokevirtual 256	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   753: astore_0
    //   754: aload_0
    //   755: invokestatic 261	com/google/android/gms/internal/zzkh:zzcy	(Ljava/lang/String;)V
    //   758: new 120	com/google/android/gms/ads/internal/request/AdResponseParcel
    //   761: dup
    //   762: iconst_0
    //   763: invokespecial 132	com/google/android/gms/ads/internal/request/AdResponseParcel:<init>	(I)V
    //   766: areturn
    //   767: aload 26
    //   769: getfield 265	com/google/android/gms/ads/internal/request/AdResponseParcel:zzbnq	Ljava/util/List;
    //   772: astore_0
    //   773: goto -489 -> 284
    //   776: aload 26
    //   778: getfield 268	com/google/android/gms/ads/internal/request/AdResponseParcel:zzbnr	Ljava/util/List;
    //   781: astore_0
    //   782: goto -466 -> 316
    //   785: aload 26
    //   787: getfield 271	com/google/android/gms/ads/internal/request/AdResponseParcel:zzcce	Ljava/util/List;
    //   790: astore_0
    //   791: goto -443 -> 348
    //   794: new 81	java/lang/String
    //   797: dup
    //   798: ldc -3
    //   800: invokespecial 272	java/lang/String:<init>	(Ljava/lang/String;)V
    //   803: astore_0
    //   804: goto -50 -> 754
    //   807: iload 4
    //   809: istore_3
    //   810: goto -403 -> 407
    //   813: aload_2
    //   814: astore 23
    //   816: aload 24
    //   818: astore_2
    //   819: goto -585 -> 234
    //   822: iconst_0
    //   823: istore 5
    //   825: goto -760 -> 65
    //   828: ldc2_w 60
    //   831: lstore 15
    //   833: goto -686 -> 147
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	836	0	paramContext	android.content.Context
    //   0	836	1	paramAdRequestInfoParcel	com.google.android.gms.ads.internal.request.AdRequestInfoParcel
    //   0	836	2	paramString	String
    //   158	652	3	i	int
    //   365	443	4	j	int
    //   63	761	5	bool1	boolean
    //   426	253	6	bool2	boolean
    //   450	214	7	bool3	boolean
    //   460	224	8	bool4	boolean
    //   470	222	9	bool5	boolean
    //   480	214	10	bool6	boolean
    //   531	167	11	bool7	boolean
    //   541	159	12	bool8	boolean
    //   589	119	13	bool9	boolean
    //   647	75	14	bool10	boolean
    //   145	687	15	l1	long
    //   111	564	17	l2	long
    //   492	178	19	l3	long
    //   504	162	21	l4	long
    //   75	740	23	str1	String
    //   18	799	24	localObject1	Object
    //   28	632	25	localObject2	Object
    //   177	609	26	localObject3	Object
    //   307	361	27	localObject4	Object
    //   8	629	28	localJSONObject	JSONObject
    //   38	635	29	str2	String
    //   49	675	30	str3	String
    //   121	556	31	str4	String
    //   339	357	32	localObject5	Object
    //   554	150	33	localList1	List
    //   567	139	34	localList2	List
    //   579	123	35	localRewardItemParcel	RewardItemParcel
    //   601	109	36	localAutoClickProtectionConfigurationParcel	com.google.android.gms.ads.internal.request.AutoClickProtectionConfigurationParcel
    //   612	104	37	str5	String
    //   625	93	38	localList3	List
    //   634	86	39	str6	String
    // Exception table:
    //   from	to	target	type
    //   0	51	731	org/json/JSONException
    //   55	62	731	org/json/JSONException
    //   65	74	731	org/json/JSONException
    //   81	91	731	org/json/JSONException
    //   99	108	731	org/json/JSONException
    //   113	147	731	org/json/JSONException
    //   147	157	731	org/json/JSONException
    //   159	176	731	org/json/JSONException
    //   179	234	731	org/json/JSONException
    //   239	248	731	org/json/JSONException
    //   248	265	731	org/json/JSONException
    //   268	277	731	org/json/JSONException
    //   292	300	731	org/json/JSONException
    //   300	309	731	org/json/JSONException
    //   324	332	731	org/json/JSONException
    //   332	341	731	org/json/JSONException
    //   356	364	731	org/json/JSONException
    //   372	387	731	org/json/JSONException
    //   390	407	731	org/json/JSONException
    //   407	416	731	org/json/JSONException
    //   418	428	731	org/json/JSONException
    //   433	442	731	org/json/JSONException
    //   442	729	731	org/json/JSONException
    //   767	773	731	org/json/JSONException
    //   776	782	731	org/json/JSONException
    //   785	791	731	org/json/JSONException
  }
  
  private static List<String> zza(JSONArray paramJSONArray, List<String> paramList)
    throws JSONException
  {
    if (paramJSONArray == null)
    {
      paramList = null;
      return paramList;
    }
    Object localObject = paramList;
    if (paramList == null) {
      localObject = new LinkedList();
    }
    int i = 0;
    for (;;)
    {
      paramList = (List<String>)localObject;
      if (i >= paramJSONArray.length()) {
        break;
      }
      ((List)localObject).add(paramJSONArray.getString(i));
      i += 1;
    }
  }
  
  /* Error */
  public static JSONObject zza(android.content.Context paramContext, com.google.android.gms.ads.internal.request.AdRequestInfoParcel paramAdRequestInfoParcel, zziz paramzziz, zzjd.zza paramzza, Location paramLocation, zzcv paramzzcv, String paramString1, List<String> paramList, Bundle paramBundle, String paramString2)
  {
    // Byte code:
    //   0: new 294	java/util/HashMap
    //   3: dup
    //   4: invokespecial 295	java/util/HashMap:<init>	()V
    //   7: astore 5
    //   9: aload 7
    //   11: invokeinterface 298 1 0
    //   16: ifle +20 -> 36
    //   19: aload 5
    //   21: ldc_w 300
    //   24: ldc_w 302
    //   27: aload 7
    //   29: invokestatic 306	android/text/TextUtils:join	(Ljava/lang/CharSequence;Ljava/lang/Iterable;)Ljava/lang/String;
    //   32: invokevirtual 310	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   35: pop
    //   36: aload_1
    //   37: getfield 314	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:zzcau	Landroid/os/Bundle;
    //   40: ifnull +16 -> 56
    //   43: aload 5
    //   45: ldc_w 316
    //   48: aload_1
    //   49: getfield 314	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:zzcau	Landroid/os/Bundle;
    //   52: invokevirtual 310	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   55: pop
    //   56: aload 5
    //   58: aload_1
    //   59: getfield 320	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:zzcav	Lcom/google/android/gms/ads/internal/client/AdRequestParcel;
    //   62: invokestatic 323	com/google/android/gms/internal/zziu:zza	(Ljava/util/HashMap;Lcom/google/android/gms/ads/internal/client/AdRequestParcel;)V
    //   65: aload 5
    //   67: ldc_w 325
    //   70: aload_1
    //   71: getfield 329	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:zzaoy	Lcom/google/android/gms/ads/internal/client/AdSizeParcel;
    //   74: getfield 334	com/google/android/gms/ads/internal/client/AdSizeParcel:zzaup	Ljava/lang/String;
    //   77: invokevirtual 310	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   80: pop
    //   81: aload_1
    //   82: getfield 329	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:zzaoy	Lcom/google/android/gms/ads/internal/client/AdSizeParcel;
    //   85: getfield 337	com/google/android/gms/ads/internal/client/AdSizeParcel:width	I
    //   88: iconst_m1
    //   89: if_icmpne +15 -> 104
    //   92: aload 5
    //   94: ldc_w 339
    //   97: ldc_w 341
    //   100: invokevirtual 310	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   103: pop
    //   104: aload_1
    //   105: getfield 329	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:zzaoy	Lcom/google/android/gms/ads/internal/client/AdSizeParcel;
    //   108: getfield 343	com/google/android/gms/ads/internal/client/AdSizeParcel:height	I
    //   111: bipush -2
    //   113: if_icmpne +15 -> 128
    //   116: aload 5
    //   118: ldc_w 345
    //   121: ldc_w 347
    //   124: invokevirtual 310	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   127: pop
    //   128: aload_1
    //   129: getfield 329	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:zzaoy	Lcom/google/android/gms/ads/internal/client/AdSizeParcel;
    //   132: getfield 350	com/google/android/gms/ads/internal/client/AdSizeParcel:zzaut	Z
    //   135: ifeq +13 -> 148
    //   138: aload 5
    //   140: ldc -64
    //   142: ldc -66
    //   144: invokevirtual 310	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   147: pop
    //   148: aload_1
    //   149: getfield 329	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:zzaoy	Lcom/google/android/gms/ads/internal/client/AdSizeParcel;
    //   152: getfield 354	com/google/android/gms/ads/internal/client/AdSizeParcel:zzaur	[Lcom/google/android/gms/ads/internal/client/AdSizeParcel;
    //   155: ifnull +165 -> 320
    //   158: new 356	java/lang/StringBuilder
    //   161: dup
    //   162: invokespecial 357	java/lang/StringBuilder:<init>	()V
    //   165: astore_0
    //   166: aload_1
    //   167: getfield 329	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:zzaoy	Lcom/google/android/gms/ads/internal/client/AdSizeParcel;
    //   170: getfield 354	com/google/android/gms/ads/internal/client/AdSizeParcel:zzaur	[Lcom/google/android/gms/ads/internal/client/AdSizeParcel;
    //   173: astore 7
    //   175: aload 7
    //   177: arraylength
    //   178: istore 12
    //   180: iconst_0
    //   181: istore 10
    //   183: iload 10
    //   185: iload 12
    //   187: if_icmpge +123 -> 310
    //   190: aload 7
    //   192: iload 10
    //   194: aaload
    //   195: astore 14
    //   197: aload_0
    //   198: invokevirtual 358	java/lang/StringBuilder:length	()I
    //   201: ifeq +11 -> 212
    //   204: aload_0
    //   205: ldc_w 360
    //   208: invokevirtual 364	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   211: pop
    //   212: aload 14
    //   214: getfield 337	com/google/android/gms/ads/internal/client/AdSizeParcel:width	I
    //   217: iconst_m1
    //   218: if_icmpne +72 -> 290
    //   221: aload 14
    //   223: getfield 367	com/google/android/gms/ads/internal/client/AdSizeParcel:widthPixels	I
    //   226: i2f
    //   227: aload_2
    //   228: getfield 373	com/google/android/gms/internal/zziz:zzcbh	F
    //   231: fdiv
    //   232: f2i
    //   233: istore 11
    //   235: aload_0
    //   236: iload 11
    //   238: invokevirtual 376	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   241: pop
    //   242: aload_0
    //   243: ldc_w 378
    //   246: invokevirtual 364	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   249: pop
    //   250: aload 14
    //   252: getfield 343	com/google/android/gms/ads/internal/client/AdSizeParcel:height	I
    //   255: bipush -2
    //   257: if_icmpne +43 -> 300
    //   260: aload 14
    //   262: getfield 381	com/google/android/gms/ads/internal/client/AdSizeParcel:heightPixels	I
    //   265: i2f
    //   266: aload_2
    //   267: getfield 373	com/google/android/gms/internal/zziz:zzcbh	F
    //   270: fdiv
    //   271: f2i
    //   272: istore 11
    //   274: aload_0
    //   275: iload 11
    //   277: invokevirtual 376	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   280: pop
    //   281: iload 10
    //   283: iconst_1
    //   284: iadd
    //   285: istore 10
    //   287: goto -104 -> 183
    //   290: aload 14
    //   292: getfield 337	com/google/android/gms/ads/internal/client/AdSizeParcel:width	I
    //   295: istore 11
    //   297: goto -62 -> 235
    //   300: aload 14
    //   302: getfield 343	com/google/android/gms/ads/internal/client/AdSizeParcel:height	I
    //   305: istore 11
    //   307: goto -33 -> 274
    //   310: aload 5
    //   312: ldc_w 383
    //   315: aload_0
    //   316: invokevirtual 310	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   319: pop
    //   320: aload_1
    //   321: getfield 53	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:zzcbb	I
    //   324: ifeq +83 -> 407
    //   327: aload 5
    //   329: ldc_w 385
    //   332: aload_1
    //   333: getfield 53	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:zzcbb	I
    //   336: invokestatic 390	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   339: invokevirtual 310	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   342: pop
    //   343: aload_1
    //   344: getfield 329	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:zzaoy	Lcom/google/android/gms/ads/internal/client/AdSizeParcel;
    //   347: getfield 393	com/google/android/gms/ads/internal/client/AdSizeParcel:zzauu	Z
    //   350: ifne +57 -> 407
    //   353: aload 5
    //   355: ldc_w 395
    //   358: aload_1
    //   359: getfield 398	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:zzapq	Ljava/util/List;
    //   362: invokevirtual 310	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   365: pop
    //   366: aload 5
    //   368: ldc_w 400
    //   371: aload_1
    //   372: getfield 404	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:zzapm	Lcom/google/android/gms/ads/internal/formats/NativeAdOptionsParcel;
    //   375: invokestatic 408	com/google/android/gms/internal/zziu:zzc	(Lcom/google/android/gms/ads/internal/formats/NativeAdOptionsParcel;)Ljava/lang/String;
    //   378: invokevirtual 310	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   381: pop
    //   382: aload_1
    //   383: getfield 411	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:zzcbm	Ljava/util/List;
    //   386: invokeinterface 414 1 0
    //   391: ifne +16 -> 407
    //   394: aload 5
    //   396: ldc_w 416
    //   399: aload_1
    //   400: getfield 411	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:zzcbm	Ljava/util/List;
    //   403: invokevirtual 310	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   406: pop
    //   407: aload 5
    //   409: ldc_w 418
    //   412: aload_1
    //   413: getfield 421	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:zzaos	Ljava/lang/String;
    //   416: invokevirtual 310	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   419: pop
    //   420: aload 5
    //   422: ldc_w 423
    //   425: aload_1
    //   426: getfield 427	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:applicationInfo	Landroid/content/pm/ApplicationInfo;
    //   429: getfield 432	android/content/pm/ApplicationInfo:packageName	Ljava/lang/String;
    //   432: invokevirtual 310	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   435: pop
    //   436: aload_1
    //   437: getfield 436	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:zzcaw	Landroid/content/pm/PackageInfo;
    //   440: ifnull +22 -> 462
    //   443: aload 5
    //   445: ldc_w 438
    //   448: aload_1
    //   449: getfield 436	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:zzcaw	Landroid/content/pm/PackageInfo;
    //   452: getfield 443	android/content/pm/PackageInfo:versionCode	I
    //   455: invokestatic 390	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   458: invokevirtual 310	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   461: pop
    //   462: aload 5
    //   464: ldc_w 445
    //   467: aload 6
    //   469: invokevirtual 310	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   472: pop
    //   473: aload 5
    //   475: ldc_w 447
    //   478: aload_1
    //   479: getfield 450	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:zzcay	Ljava/lang/String;
    //   482: invokevirtual 310	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   485: pop
    //   486: aload 5
    //   488: ldc_w 452
    //   491: aload_1
    //   492: getfield 455	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:zzcaz	Ljava/lang/String;
    //   495: invokevirtual 310	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   498: pop
    //   499: aload 5
    //   501: ldc_w 457
    //   504: aload_1
    //   505: getfield 107	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:zzaou	Lcom/google/android/gms/ads/internal/util/client/VersionInfoParcel;
    //   508: getfield 113	com/google/android/gms/ads/internal/util/client/VersionInfoParcel:zzcs	Ljava/lang/String;
    //   511: invokevirtual 310	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   514: pop
    //   515: aload 5
    //   517: aload_2
    //   518: aload_3
    //   519: aload_1
    //   520: getfield 460	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:zzcbz	Landroid/os/Bundle;
    //   523: invokestatic 463	com/google/android/gms/internal/zziu:zza	(Ljava/util/HashMap;Lcom/google/android/gms/internal/zziz;Lcom/google/android/gms/internal/zzjd$zza;Landroid/os/Bundle;)V
    //   526: aload 5
    //   528: aload 9
    //   530: invokestatic 466	com/google/android/gms/internal/zziu:zza	(Ljava/util/HashMap;Ljava/lang/String;)V
    //   533: aload 5
    //   535: ldc_w 468
    //   538: getstatic 473	android/os/Build:MANUFACTURER	Ljava/lang/String;
    //   541: invokevirtual 310	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   544: pop
    //   545: aload 5
    //   547: ldc_w 475
    //   550: getstatic 478	android/os/Build:MODEL	Ljava/lang/String;
    //   553: invokevirtual 310	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   556: pop
    //   557: aload 4
    //   559: ifnull +554 -> 1113
    //   562: aload 5
    //   564: aload 4
    //   566: invokestatic 481	com/google/android/gms/internal/zziu:zza	(Ljava/util/HashMap;Landroid/location/Location;)V
    //   569: aload_1
    //   570: getfield 482	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:versionCode	I
    //   573: iconst_2
    //   574: if_icmplt +16 -> 590
    //   577: aload 5
    //   579: ldc_w 484
    //   582: aload_1
    //   583: getfield 487	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:zzcba	Landroid/os/Bundle;
    //   586: invokevirtual 310	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   589: pop
    //   590: aload_1
    //   591: getfield 482	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:versionCode	I
    //   594: iconst_4
    //   595: if_icmplt +26 -> 621
    //   598: aload_1
    //   599: getfield 234	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:zzcbd	Z
    //   602: ifeq +19 -> 621
    //   605: aload 5
    //   607: ldc_w 489
    //   610: aload_1
    //   611: getfield 234	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:zzcbd	Z
    //   614: invokestatic 494	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   617: invokevirtual 310	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   620: pop
    //   621: aload 8
    //   623: ifnull +14 -> 637
    //   626: aload 5
    //   628: ldc_w 496
    //   631: aload 8
    //   633: invokevirtual 310	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   636: pop
    //   637: aload_1
    //   638: getfield 482	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:versionCode	I
    //   641: iconst_5
    //   642: if_icmplt +537 -> 1179
    //   645: aload 5
    //   647: ldc_w 498
    //   650: aload_1
    //   651: getfield 499	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:zzcbh	F
    //   654: invokestatic 504	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   657: invokevirtual 310	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   660: pop
    //   661: aload 5
    //   663: ldc_w 506
    //   666: aload_1
    //   667: getfield 509	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:zzcbg	I
    //   670: invokestatic 390	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   673: invokevirtual 310	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   676: pop
    //   677: aload 5
    //   679: ldc_w 511
    //   682: aload_1
    //   683: getfield 514	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:zzcbf	I
    //   686: invokestatic 390	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   689: invokevirtual 310	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   692: pop
    //   693: aload_1
    //   694: getfield 482	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:versionCode	I
    //   697: bipush 6
    //   699: if_icmplt +53 -> 752
    //   702: aload_1
    //   703: getfield 517	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:zzcbi	Ljava/lang/String;
    //   706: invokestatic 103	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   709: istore 13
    //   711: iload 13
    //   713: ifne +23 -> 736
    //   716: aload 5
    //   718: ldc_w 519
    //   721: new 32	org/json/JSONObject
    //   724: dup
    //   725: aload_1
    //   726: getfield 517	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:zzcbi	Ljava/lang/String;
    //   729: invokespecial 35	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   732: invokevirtual 310	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   735: pop
    //   736: aload 5
    //   738: ldc_w 521
    //   741: aload_1
    //   742: getfield 524	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:zzcbj	J
    //   745: invokestatic 529	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   748: invokevirtual 310	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   751: pop
    //   752: aload_1
    //   753: getfield 482	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:versionCode	I
    //   756: bipush 7
    //   758: if_icmplt +16 -> 774
    //   761: aload 5
    //   763: ldc_w 531
    //   766: aload_1
    //   767: getfield 534	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:zzcbk	Ljava/lang/String;
    //   770: invokevirtual 310	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   773: pop
    //   774: aload_1
    //   775: getfield 482	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:versionCode	I
    //   778: bipush 11
    //   780: if_icmplt +26 -> 806
    //   783: aload_1
    //   784: getfield 538	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:zzcbo	Lcom/google/android/gms/ads/internal/request/CapabilityParcel;
    //   787: ifnull +19 -> 806
    //   790: aload 5
    //   792: ldc_w 540
    //   795: aload_1
    //   796: getfield 538	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:zzcbo	Lcom/google/android/gms/ads/internal/request/CapabilityParcel;
    //   799: invokevirtual 546	com/google/android/gms/ads/internal/request/CapabilityParcel:toBundle	()Landroid/os/Bundle;
    //   802: invokevirtual 310	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   805: pop
    //   806: aload_1
    //   807: getfield 482	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:versionCode	I
    //   810: bipush 12
    //   812: if_icmplt +26 -> 838
    //   815: aload_1
    //   816: getfield 549	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:zzcbp	Ljava/lang/String;
    //   819: invokestatic 103	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   822: ifne +16 -> 838
    //   825: aload 5
    //   827: ldc_w 551
    //   830: aload_1
    //   831: getfield 549	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:zzcbp	Ljava/lang/String;
    //   834: invokevirtual 310	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   837: pop
    //   838: aload_1
    //   839: getfield 482	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:versionCode	I
    //   842: bipush 13
    //   844: if_icmplt +19 -> 863
    //   847: aload 5
    //   849: ldc_w 553
    //   852: aload_1
    //   853: getfield 556	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:zzcbq	F
    //   856: invokestatic 504	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   859: invokevirtual 310	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   862: pop
    //   863: aload_1
    //   864: getfield 482	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:versionCode	I
    //   867: bipush 18
    //   869: if_icmplt +19 -> 888
    //   872: aload 5
    //   874: ldc_w 558
    //   877: aload_1
    //   878: getfield 561	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:zzcbw	Z
    //   881: invokestatic 494	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   884: invokevirtual 310	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   887: pop
    //   888: aload_1
    //   889: getfield 482	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:versionCode	I
    //   892: bipush 14
    //   894: if_icmplt +26 -> 920
    //   897: aload_1
    //   898: getfield 564	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:zzcbr	I
    //   901: ifle +19 -> 920
    //   904: aload 5
    //   906: ldc_w 566
    //   909: aload_1
    //   910: getfield 564	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:zzcbr	I
    //   913: invokestatic 390	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   916: invokevirtual 310	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   919: pop
    //   920: aload_1
    //   921: getfield 482	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:versionCode	I
    //   924: bipush 15
    //   926: if_icmplt +28 -> 954
    //   929: aload_1
    //   930: getfield 569	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:zzcbs	I
    //   933: iconst_m1
    //   934: if_icmpne +307 -> 1241
    //   937: iconst_m1
    //   938: istore 10
    //   940: aload 5
    //   942: ldc_w 571
    //   945: iload 10
    //   947: invokestatic 390	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   950: invokevirtual 310	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   953: pop
    //   954: aload_1
    //   955: getfield 482	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:versionCode	I
    //   958: bipush 16
    //   960: if_icmplt +19 -> 979
    //   963: aload 5
    //   965: ldc_w 573
    //   968: aload_1
    //   969: getfield 576	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:zzcbt	Z
    //   972: invokestatic 494	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   975: invokevirtual 310	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   978: pop
    //   979: aload_1
    //   980: getfield 482	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:versionCode	I
    //   983: bipush 18
    //   985: if_icmplt +52 -> 1037
    //   988: aload_1
    //   989: getfield 579	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:zzcbx	Ljava/lang/String;
    //   992: invokestatic 103	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   995: istore 13
    //   997: iload 13
    //   999: ifne +23 -> 1022
    //   1002: aload 5
    //   1004: ldc_w 581
    //   1007: new 32	org/json/JSONObject
    //   1010: dup
    //   1011: aload_1
    //   1012: getfield 579	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:zzcbx	Ljava/lang/String;
    //   1015: invokespecial 35	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1018: invokevirtual 310	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1021: pop
    //   1022: aload 5
    //   1024: ldc -29
    //   1026: aload_1
    //   1027: getfield 231	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:zzbnu	Z
    //   1030: invokestatic 494	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1033: invokevirtual 310	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1036: pop
    //   1037: aload_1
    //   1038: getfield 482	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:versionCode	I
    //   1041: bipush 18
    //   1043: if_icmplt +19 -> 1062
    //   1046: aload 5
    //   1048: ldc_w 583
    //   1051: aload_1
    //   1052: getfield 586	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:zzcby	I
    //   1055: invokestatic 390	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1058: invokevirtual 310	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1061: pop
    //   1062: iconst_2
    //   1063: invokestatic 590	com/google/android/gms/internal/zzkh:zzaz	(I)Z
    //   1066: ifeq +38 -> 1104
    //   1069: invokestatic 594	com/google/android/gms/ads/internal/zzu:zzfq	()Lcom/google/android/gms/internal/zzkl;
    //   1072: aload 5
    //   1074: invokevirtual 600	com/google/android/gms/internal/zzkl:zzam	(Ljava/util/Map;)Lorg/json/JSONObject;
    //   1077: iconst_2
    //   1078: invokevirtual 603	org/json/JSONObject:toString	(I)Ljava/lang/String;
    //   1081: invokestatic 248	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   1084: astore_0
    //   1085: aload_0
    //   1086: invokevirtual 251	java/lang/String:length	()I
    //   1089: ifeq +172 -> 1261
    //   1092: ldc_w 605
    //   1095: aload_0
    //   1096: invokevirtual 256	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   1099: astore_0
    //   1100: aload_0
    //   1101: invokestatic 608	com/google/android/gms/internal/zzkh:v	(Ljava/lang/String;)V
    //   1104: invokestatic 594	com/google/android/gms/ads/internal/zzu:zzfq	()Lcom/google/android/gms/internal/zzkl;
    //   1107: aload 5
    //   1109: invokevirtual 600	com/google/android/gms/internal/zzkl:zzam	(Ljava/util/Map;)Lorg/json/JSONObject;
    //   1112: areturn
    //   1113: aload_1
    //   1114: getfield 320	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:zzcav	Lcom/google/android/gms/ads/internal/client/AdRequestParcel;
    //   1117: getfield 611	com/google/android/gms/ads/internal/client/AdRequestParcel:versionCode	I
    //   1120: iconst_2
    //   1121: if_icmplt -552 -> 569
    //   1124: aload_1
    //   1125: getfield 320	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:zzcav	Lcom/google/android/gms/ads/internal/client/AdRequestParcel;
    //   1128: getfield 615	com/google/android/gms/ads/internal/client/AdRequestParcel:zzats	Landroid/location/Location;
    //   1131: ifnull -562 -> 569
    //   1134: aload 5
    //   1136: aload_1
    //   1137: getfield 320	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:zzcav	Lcom/google/android/gms/ads/internal/client/AdRequestParcel;
    //   1140: getfield 615	com/google/android/gms/ads/internal/client/AdRequestParcel:zzats	Landroid/location/Location;
    //   1143: invokestatic 481	com/google/android/gms/internal/zziu:zza	(Ljava/util/HashMap;Landroid/location/Location;)V
    //   1146: goto -577 -> 569
    //   1149: astore_0
    //   1150: aload_0
    //   1151: invokevirtual 244	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   1154: invokestatic 248	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   1157: astore_0
    //   1158: aload_0
    //   1159: invokevirtual 251	java/lang/String:length	()I
    //   1162: ifeq +113 -> 1275
    //   1165: ldc_w 617
    //   1168: aload_0
    //   1169: invokevirtual 256	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   1172: astore_0
    //   1173: aload_0
    //   1174: invokestatic 261	com/google/android/gms/internal/zzkh:zzcy	(Ljava/lang/String;)V
    //   1177: aconst_null
    //   1178: areturn
    //   1179: aload 5
    //   1181: ldc_w 498
    //   1184: aload_2
    //   1185: getfield 373	com/google/android/gms/internal/zziz:zzcbh	F
    //   1188: invokestatic 504	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   1191: invokevirtual 310	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1194: pop
    //   1195: aload 5
    //   1197: ldc_w 506
    //   1200: aload_2
    //   1201: getfield 618	com/google/android/gms/internal/zziz:zzcbg	I
    //   1204: invokestatic 390	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1207: invokevirtual 310	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1210: pop
    //   1211: aload 5
    //   1213: ldc_w 511
    //   1216: aload_2
    //   1217: getfield 619	com/google/android/gms/internal/zziz:zzcbf	I
    //   1220: invokestatic 390	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1223: invokevirtual 310	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1226: pop
    //   1227: goto -534 -> 693
    //   1230: astore_0
    //   1231: ldc_w 621
    //   1234: aload_0
    //   1235: invokestatic 625	com/google/android/gms/internal/zzkh:zzd	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1238: goto -502 -> 736
    //   1241: aload_1
    //   1242: getfield 569	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:zzcbs	I
    //   1245: istore 10
    //   1247: goto -307 -> 940
    //   1250: astore_0
    //   1251: ldc_w 627
    //   1254: aload_0
    //   1255: invokestatic 625	com/google/android/gms/internal/zzkh:zzd	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1258: goto -236 -> 1022
    //   1261: new 81	java/lang/String
    //   1264: dup
    //   1265: ldc_w 605
    //   1268: invokespecial 272	java/lang/String:<init>	(Ljava/lang/String;)V
    //   1271: astore_0
    //   1272: goto -172 -> 1100
    //   1275: new 81	java/lang/String
    //   1278: dup
    //   1279: ldc_w 617
    //   1282: invokespecial 272	java/lang/String:<init>	(Ljava/lang/String;)V
    //   1285: astore_0
    //   1286: goto -113 -> 1173
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1289	0	paramContext	android.content.Context
    //   0	1289	1	paramAdRequestInfoParcel	com.google.android.gms.ads.internal.request.AdRequestInfoParcel
    //   0	1289	2	paramzziz	zziz
    //   0	1289	3	paramzza	zzjd.zza
    //   0	1289	4	paramLocation	Location
    //   0	1289	5	paramzzcv	zzcv
    //   0	1289	6	paramString1	String
    //   0	1289	7	paramList	List<String>
    //   0	1289	8	paramBundle	Bundle
    //   0	1289	9	paramString2	String
    //   181	1065	10	i	int
    //   233	73	11	j	int
    //   178	10	12	k	int
    //   709	289	13	bool	boolean
    //   195	106	14	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   0	36	1149	org/json/JSONException
    //   36	56	1149	org/json/JSONException
    //   56	104	1149	org/json/JSONException
    //   104	128	1149	org/json/JSONException
    //   128	148	1149	org/json/JSONException
    //   148	180	1149	org/json/JSONException
    //   197	212	1149	org/json/JSONException
    //   212	235	1149	org/json/JSONException
    //   235	274	1149	org/json/JSONException
    //   274	281	1149	org/json/JSONException
    //   290	297	1149	org/json/JSONException
    //   300	307	1149	org/json/JSONException
    //   310	320	1149	org/json/JSONException
    //   320	407	1149	org/json/JSONException
    //   407	462	1149	org/json/JSONException
    //   462	557	1149	org/json/JSONException
    //   562	569	1149	org/json/JSONException
    //   569	590	1149	org/json/JSONException
    //   590	621	1149	org/json/JSONException
    //   626	637	1149	org/json/JSONException
    //   637	693	1149	org/json/JSONException
    //   693	711	1149	org/json/JSONException
    //   736	752	1149	org/json/JSONException
    //   752	774	1149	org/json/JSONException
    //   774	806	1149	org/json/JSONException
    //   806	838	1149	org/json/JSONException
    //   838	863	1149	org/json/JSONException
    //   863	888	1149	org/json/JSONException
    //   888	920	1149	org/json/JSONException
    //   920	937	1149	org/json/JSONException
    //   940	954	1149	org/json/JSONException
    //   954	979	1149	org/json/JSONException
    //   979	997	1149	org/json/JSONException
    //   1022	1037	1149	org/json/JSONException
    //   1037	1062	1149	org/json/JSONException
    //   1062	1100	1149	org/json/JSONException
    //   1100	1104	1149	org/json/JSONException
    //   1104	1113	1149	org/json/JSONException
    //   1113	1146	1149	org/json/JSONException
    //   1179	1227	1149	org/json/JSONException
    //   1231	1238	1149	org/json/JSONException
    //   1241	1247	1149	org/json/JSONException
    //   1251	1258	1149	org/json/JSONException
    //   1261	1272	1149	org/json/JSONException
    //   716	736	1230	org/json/JSONException
    //   1002	1022	1250	org/json/JSONException
  }
  
  private static void zza(HashMap<String, Object> paramHashMap, Location paramLocation)
  {
    HashMap localHashMap = new HashMap();
    float f = paramLocation.getAccuracy();
    long l1 = paramLocation.getTime();
    long l2 = (paramLocation.getLatitude() * 1.0E7D);
    long l3 = (paramLocation.getLongitude() * 1.0E7D);
    localHashMap.put("radius", Float.valueOf(f * 1000.0F));
    localHashMap.put("lat", Long.valueOf(l2));
    localHashMap.put("long", Long.valueOf(l3));
    localHashMap.put("time", Long.valueOf(l1 * 1000L));
    paramHashMap.put("uule", localHashMap);
  }
  
  private static void zza(HashMap<String, Object> paramHashMap, AdRequestParcel paramAdRequestParcel)
  {
    String str = zzkf.zzsz();
    if (str != null) {
      paramHashMap.put("abf", str);
    }
    if (zzatk != -1L) {
      paramHashMap.put("cust_age", zzcep.format(new Date(zzatk)));
    }
    if (extras != null) {
      paramHashMap.put("extras", extras);
    }
    if (zzatl != -1) {
      paramHashMap.put("cust_gender", Integer.valueOf(zzatl));
    }
    if (zzatm != null) {
      paramHashMap.put("kw", zzatm);
    }
    if (zzato != -1) {
      paramHashMap.put("tag_for_child_directed_treatment", Integer.valueOf(zzato));
    }
    if (zzatn) {
      paramHashMap.put("adtest", "on");
    }
    if (versionCode >= 2)
    {
      if (zzatp) {
        paramHashMap.put("d_imp_hdr", Integer.valueOf(1));
      }
      if (!TextUtils.isEmpty(zzatq)) {
        paramHashMap.put("ppid", zzatq);
      }
      if (zzatr != null) {
        zza(paramHashMap, zzatr);
      }
    }
    if ((versionCode >= 3) && (zzatt != null)) {
      paramHashMap.put("url", zzatt);
    }
    if (versionCode >= 5)
    {
      if (zzatv != null) {
        paramHashMap.put("custom_targeting", zzatv);
      }
      if (zzatw != null) {
        paramHashMap.put("category_exclusions", zzatw);
      }
      if (zzatx != null) {
        paramHashMap.put("request_agent", zzatx);
      }
    }
    if ((versionCode >= 6) && (zzaty != null)) {
      paramHashMap.put("request_pkg", zzaty);
    }
    if (versionCode >= 7) {
      paramHashMap.put("is_designed_for_families", Boolean.valueOf(zzatz));
    }
  }
  
  private static void zza(HashMap<String, Object> paramHashMap, SearchAdRequestParcel paramSearchAdRequestParcel)
  {
    Object localObject2 = null;
    if (Color.alpha(zzawx) != 0) {
      paramHashMap.put("acolor", zzau(zzawx));
    }
    if (Color.alpha(backgroundColor) != 0) {
      paramHashMap.put("bgcolor", zzau(backgroundColor));
    }
    if ((Color.alpha(zzawy) != 0) && (Color.alpha(zzawz) != 0))
    {
      paramHashMap.put("gradientto", zzau(zzawy));
      paramHashMap.put("gradientfrom", zzau(zzawz));
    }
    if (Color.alpha(zzaxa) != 0) {
      paramHashMap.put("bcolor", zzau(zzaxa));
    }
    paramHashMap.put("bthick", Integer.toString(zzaxb));
    Object localObject1;
    switch (zzaxc)
    {
    default: 
      localObject1 = null;
      if (localObject1 != null) {
        paramHashMap.put("btype", localObject1);
      }
      switch (zzaxd)
      {
      default: 
        localObject1 = localObject2;
      }
      break;
    }
    for (;;)
    {
      if (localObject1 != null) {
        paramHashMap.put("callbuttoncolor", localObject1);
      }
      if (zzaxe != null) {
        paramHashMap.put("channel", zzaxe);
      }
      if (Color.alpha(zzaxf) != 0) {
        paramHashMap.put("dcolor", zzau(zzaxf));
      }
      if (zzaxg != null) {
        paramHashMap.put("font", zzaxg);
      }
      if (Color.alpha(zzaxh) != 0) {
        paramHashMap.put("hcolor", zzau(zzaxh));
      }
      paramHashMap.put("headersize", Integer.toString(zzaxi));
      if (zzaxj != null) {
        paramHashMap.put("q", zzaxj);
      }
      return;
      localObject1 = "none";
      break;
      localObject1 = "dashed";
      break;
      localObject1 = "dotted";
      break;
      localObject1 = "solid";
      break;
      localObject1 = "dark";
      continue;
      localObject1 = "light";
      continue;
      localObject1 = "medium";
    }
  }
  
  private static void zza(HashMap<String, Object> paramHashMap, zziz paramzziz, zzjd.zza paramzza, Bundle paramBundle)
  {
    paramHashMap.put("am", Integer.valueOf(zzcgh));
    paramHashMap.put("cog", zzab(zzcgi));
    paramHashMap.put("coh", zzab(zzcgj));
    if (!TextUtils.isEmpty(zzcgk)) {
      paramHashMap.put("carrier", zzcgk);
    }
    paramHashMap.put("gl", zzcgl);
    if (zzcgm) {
      paramHashMap.put("simulator", Integer.valueOf(1));
    }
    if (zzcgn) {
      paramHashMap.put("is_sidewinder", Integer.valueOf(1));
    }
    paramHashMap.put("ma", zzab(zzcgo));
    paramHashMap.put("sp", zzab(zzcgp));
    paramHashMap.put("hl", zzcgq);
    if (!TextUtils.isEmpty(zzcgr)) {
      paramHashMap.put("mv", zzcgr);
    }
    paramHashMap.put("muv", Integer.valueOf(zzcgs));
    if (zzcgt != -2) {
      paramHashMap.put("cnt", Integer.valueOf(zzcgt));
    }
    paramHashMap.put("gnt", Integer.valueOf(zzcgu));
    paramHashMap.put("pt", Integer.valueOf(zzcgv));
    paramHashMap.put("rm", Integer.valueOf(zzcgw));
    paramHashMap.put("riv", Integer.valueOf(zzcgx));
    Bundle localBundle1 = new Bundle();
    localBundle1.putString("build", zzchc);
    Bundle localBundle2 = new Bundle();
    localBundle2.putBoolean("is_charging", zzcgz);
    localBundle2.putDouble("battery_level", zzcgy);
    localBundle1.putBundle("battery", localBundle2);
    localBundle2 = new Bundle();
    localBundle2.putInt("active_network_state", zzchb);
    localBundle2.putBoolean("active_network_metered", zzcha);
    if (paramzza != null)
    {
      paramzza = new Bundle();
      paramzza.putInt("predicted_latency_micros", 0);
      paramzza.putLong("predicted_down_throughput_bps", 0L);
      paramzza.putLong("predicted_up_throughput_bps", 0L);
      localBundle2.putBundle("predictions", paramzza);
    }
    localBundle1.putBundle("network", localBundle2);
    paramzza = new Bundle();
    paramzza.putBoolean("is_browser_custom_tabs_capable", zzchd);
    localBundle1.putBundle("browser", paramzza);
    if (paramBundle != null) {
      localBundle1.putBundle("android_mem_info", zzf(paramBundle));
    }
    paramHashMap.put("device", localBundle1);
  }
  
  private static void zza(HashMap<String, Object> paramHashMap, String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("doritos", paramString);
    paramHashMap.put("pii", localBundle);
  }
  
  private static Integer zzab(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 1;; i = 0) {
      return Integer.valueOf(i);
    }
  }
  
  private static String zzau(int paramInt)
  {
    return String.format(Locale.US, "#%06x", new Object[] { Integer.valueOf(0xFFFFFF & paramInt) });
  }
  
  private static String zzc(NativeAdOptionsParcel paramNativeAdOptionsParcel)
  {
    if (paramNativeAdOptionsParcel != null) {}
    for (int i = zzbgu;; i = 0) {
      switch (i)
      {
      default: 
        return "any";
      }
    }
    return "portrait";
    return "landscape";
  }
  
  public static JSONObject zzc(AdResponseParcel paramAdResponseParcel)
    throws JSONException
  {
    JSONObject localJSONObject = new JSONObject();
    if (zzbts != null) {
      localJSONObject.put("ad_base_url", zzbts);
    }
    if (zzccf != null) {
      localJSONObject.put("ad_size", zzccf);
    }
    localJSONObject.put("native", zzaus);
    if (zzaus)
    {
      localJSONObject.put("ad_json", body);
      if (zzcch != null) {
        localJSONObject.put("debug_dialog", zzcch);
      }
      if (zzccb != -1L) {
        localJSONObject.put("interstitial_timeout", zzccb / 1000.0D);
      }
      if (orientation != zzu.zzfs().zztl()) {
        break label501;
      }
      localJSONObject.put("orientation", "portrait");
      label141:
      if (zzbnq != null) {
        localJSONObject.put("click_urls", zzk(zzbnq));
      }
      if (zzbnr != null) {
        localJSONObject.put("impression_urls", zzk(zzbnr));
      }
      if (zzcce != null) {
        localJSONObject.put("manual_impression_urls", zzk(zzcce));
      }
      if (zzcck != null) {
        localJSONObject.put("active_view", zzcck);
      }
      localJSONObject.put("ad_is_javascript", zzcci);
      if (zzccj != null) {
        localJSONObject.put("ad_passback_url", zzccj);
      }
      localJSONObject.put("mediation", zzccc);
      localJSONObject.put("custom_render_allowed", zzccl);
      localJSONObject.put("content_url_opted_out", zzccm);
      localJSONObject.put("prefetch", zzccn);
      if (zzbnw != -1L) {
        localJSONObject.put("refresh_interval_milliseconds", zzbnw);
      }
      if (zzccd != -1L) {
        localJSONObject.put("mediation_config_cache_time_milliseconds", zzccd);
      }
      if (!TextUtils.isEmpty(zzccq)) {
        localJSONObject.put("gws_query_id", zzccq);
      }
      if (!zzaut) {
        break label526;
      }
    }
    label501:
    label526:
    for (String str = "height";; str = "")
    {
      localJSONObject.put("fluid", str);
      localJSONObject.put("native_express", zzauu);
      if (zzccs != null) {
        localJSONObject.put("video_start_urls", zzk(zzccs));
      }
      if (zzcct != null) {
        localJSONObject.put("video_complete_urls", zzk(zzcct));
      }
      if (zzccr != null) {
        localJSONObject.put("rewards", zzccr.zzrx());
      }
      localJSONObject.put("use_displayed_impression", zzccu);
      localJSONObject.put("auto_protection_configuration", zzccv);
      localJSONObject.put("render_in_browser", zzbnu);
      return localJSONObject;
      localJSONObject.put("ad_html", body);
      break;
      if (orientation != zzu.zzfs().zztk()) {
        break label141;
      }
      localJSONObject.put("orientation", "landscape");
      break label141;
    }
  }
  
  private static Bundle zzf(Bundle paramBundle)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("runtime_free", Long.toString(paramBundle.getLong("runtime_free_memory", -1L)));
    localBundle.putString("runtime_max", Long.toString(paramBundle.getLong("runtime_max_memory", -1L)));
    localBundle.putString("runtime_total", Long.toString(paramBundle.getLong("runtime_total_memory", -1L)));
    paramBundle = (Debug.MemoryInfo)paramBundle.getParcelable("debug_memory_info");
    if (paramBundle != null)
    {
      localBundle.putString("debug_info_dalvik_private_dirty", Integer.toString(dalvikPrivateDirty));
      localBundle.putString("debug_info_dalvik_pss", Integer.toString(dalvikPss));
      localBundle.putString("debug_info_dalvik_shared_dirty", Integer.toString(dalvikSharedDirty));
      localBundle.putString("debug_info_native_private_dirty", Integer.toString(nativePrivateDirty));
      localBundle.putString("debug_info_native_pss", Integer.toString(nativePss));
      localBundle.putString("debug_info_native_shared_dirty", Integer.toString(nativeSharedDirty));
      localBundle.putString("debug_info_other_private_dirty", Integer.toString(otherPrivateDirty));
      localBundle.putString("debug_info_other_pss", Integer.toString(otherPss));
      localBundle.putString("debug_info_other_shared_dirty", Integer.toString(otherSharedDirty));
    }
    return localBundle;
  }
  
  static JSONArray zzk(List<String> paramList)
    throws JSONException
  {
    JSONArray localJSONArray = new JSONArray();
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localJSONArray.put((String)paramList.next());
    }
    return localJSONArray;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zziu
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */