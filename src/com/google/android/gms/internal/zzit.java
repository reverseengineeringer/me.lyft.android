package com.google.android.gms.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.location.Location;
import android.os.Bundle;
import android.os.Handler;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.ads.internal.request.zzk.zza;
import com.google.android.gms.ads.internal.request.zzl;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.zzu;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONException;
import org.json.JSONObject;

@zzir
public final class zzit
  extends zzk.zza
{
  private static final Object zzamp = new Object();
  private static zzit zzceb;
  private final Context mContext;
  private final zzis zzcec;
  private final zzcv zzced;
  private final zzfw zzcee;
  
  zzit(Context paramContext, zzcv paramzzcv, zzis paramzzis)
  {
    mContext = paramContext;
    zzcec = paramzzis;
    zzced = paramzzcv;
    if (paramContext.getApplicationContext() != null) {
      paramContext = paramContext.getApplicationContext();
    }
    for (;;)
    {
      zzcee = new zzfw(paramContext, new VersionInfoParcel(9256208, 9256208, true), paramzzcv.zzjv(), new zzkp()new zzfw.zzb
      {
        public void zza(zzft paramAnonymouszzft)
        {
          paramAnonymouszzft.zza("/log", zzer.zzbhz);
        }
      }, new zzfw.zzb());
      return;
    }
  }
  
  private static AdResponseParcel zza(final Context paramContext, zzfw paramzzfw, final zzcv paramzzcv, zzis paramzzis, final AdRequestInfoParcel paramAdRequestInfoParcel)
  {
    zzkh.zzcw("Starting ad request from service using: AFMA_getAd");
    zzdc.initialize(paramContext);
    final zzdk localzzdk = new zzdk(((Boolean)zzdc.zzazc.get()).booleanValue(), "load_ad", zzaoy.zzaup);
    if ((versionCode > 10) && (zzcbn != -1L)) {
      localzzdk.zza(localzzdk.zzc(zzcbn), new String[] { "cts" });
    }
    zzdi localzzdi = localzzdk.zzkg();
    if ((versionCode >= 4) && (zzcbc != null)) {}
    label983:
    Object localObject4;
    for (Object localObject3 = zzcbc;; localObject4 = null)
    {
      final Object localObject1;
      if ((((Boolean)zzdc.zzazl.get()).booleanValue()) && (zzcea != null))
      {
        localObject1 = localObject3;
        if (localObject3 == null)
        {
          localObject1 = localObject3;
          if (((Boolean)zzdc.zzazm.get()).booleanValue())
          {
            zzkh.v("contentInfo is not present, but we'll still launch the app index task");
            localObject1 = new Bundle();
          }
        }
        if (localObject1 != null) {
          localObject3 = zzkk.zza(new Callable()
          {
            public Void zzcy()
              throws Exception
            {
              zzcea.zza(paramContext, paramAdRequestInfoParcelzzcaw.packageName, localObject1);
              return null;
            }
          });
        }
      }
      for (;;)
      {
        Object localObject5 = new zzla(null);
        Object localObject6 = zzcav.extras;
        int i;
        if ((localObject6 != null) && (((Bundle)localObject6).getString("_ad") != null))
        {
          i = 1;
          if ((!zzcbu) || (i != 0)) {
            break label983;
          }
          localObject5 = zzcdw.zza(applicationInfo);
        }
        for (;;)
        {
          zziz localzziz = zzu.zzfw().zzy(paramContext);
          if (zzcgt == -1)
          {
            zzkh.zzcw("Device is offline.");
            return new AdResponseParcel(2);
            i = 0;
            break;
          }
          if (versionCode >= 7) {}
          final zziv localzziv;
          for (localObject6 = zzcbk;; localObject6 = UUID.randomUUID().toString())
          {
            localzziv = new zziv((String)localObject6, applicationInfo.packageName);
            if (zzcav.extras == null) {
              break;
            }
            localObject7 = zzcav.extras.getString("_ad");
            if (localObject7 == null) {
              break;
            }
            return zziu.zza(paramContext, paramAdRequestInfoParcel, (String)localObject7);
          }
          Object localObject7 = zzcdu.zza(paramAdRequestInfoParcel);
          String str = zzcdx.zzf(paramAdRequestInfoParcel);
          zzjd.zza localzza = zzcdy.zzz(paramContext);
          if (localObject3 != null) {}
          try
          {
            zzkh.v("Waiting for app index fetching task.");
            ((Future)localObject3).get(((Long)zzdc.zzazn.get()).longValue(), TimeUnit.MILLISECONDS);
            zzkh.v("App index fetching task completed.");
            localObject3 = zzcdt.zzcl(zzcaw.packageName);
            paramzzcv = zziu.zza(paramContext, paramAdRequestInfoParcel, localzziz, localzza, zzb((zzlc)localObject5), paramzzcv, str, (List)localObject7, (Bundle)localObject1, (String)localObject3);
            if (paramzzcv == null) {
              return new AdResponseParcel(0);
            }
          }
          catch (InterruptedException localInterruptedException)
          {
            for (;;)
            {
              zzkh.zzd("Failed to fetch app index signal", localInterruptedException);
            }
          }
          catch (TimeoutException localTimeoutException)
          {
            for (;;)
            {
              zzkh.zzcw("Timed out waiting for app index fetching task");
            }
            if (versionCode < 7) {}
            try
            {
              paramzzcv.put("request_id", localObject6);
              try
              {
                paramzzcv.put("prefetch_mode", "url");
                paramzzcv = paramzzcv.toString();
                localzzdk.zza(localzzdi, new String[] { "arc" });
                localObject1 = localzzdk.zzkg();
                zzkl.zzclg.post(new Runnable()
                {
                  public void run()
                  {
                    zzfw.zzc localzzc = zzmc();
                    localzziv.zzb(localzzc);
                    localzzdk.zza(localObject1, new String[] { "rwc" });
                    localzzc.zza(new zzle.zzc()new zzle.zza
                    {
                      public void zzb(zzfx paramAnonymous2zzfx)
                      {
                        zzakg.zza(zzcel, new String[] { "jsf" });
                        zzakg.zzkh();
                        paramAnonymous2zzfx.zza("/invalidRequest", zzcei.zzcet);
                        paramAnonymous2zzfx.zza("/loadAdURL", zzcei.zzceu);
                        paramAnonymous2zzfx.zza("/loadAd", zzcei.zzcev);
                        try
                        {
                          paramAnonymous2zzfx.zzj("AFMA_getAd", zzcek);
                          return;
                        }
                        catch (Exception paramAnonymous2zzfx)
                        {
                          zzkh.zzb("Error requesting an ad url", paramAnonymous2zzfx);
                        }
                      }
                    }, new zzle.zza()
                    {
                      public void run() {}
                    });
                  }
                });
              }
              catch (JSONException localJSONException1)
              {
                for (;;)
                {
                  try
                  {
                    localObject1 = (zziy)localzziv.zzri().get(10L, TimeUnit.SECONDS);
                    if (localObject1 != null) {
                      continue;
                    }
                    paramzzfw = new AdResponseParcel(0);
                    return paramzzfw;
                  }
                  catch (Exception paramzzfw)
                  {
                    paramzzfw = new AdResponseParcel(0);
                    return paramzzfw;
                    if (localJSONException1.getErrorCode() == -2) {
                      continue;
                    }
                    paramzzfw = new AdResponseParcel(localJSONException1.getErrorCode());
                    return paramzzfw;
                    if (localzzdk.zzkj() == null) {
                      continue;
                    }
                    localzzdk.zza(localzzdk.zzkj(), new String[] { "rur" });
                    paramzzcv = null;
                    if (TextUtils.isEmpty(localJSONException1.zzrn())) {
                      continue;
                    }
                    paramzzcv = zziu.zza(paramContext, paramAdRequestInfoParcel, localJSONException1.zzrn());
                    paramzzfw = paramzzcv;
                    if (paramzzcv != null) {
                      continue;
                    }
                    paramzzfw = paramzzcv;
                    if (TextUtils.isEmpty(localJSONException1.getUrl())) {
                      continue;
                    }
                    paramzzfw = zza(paramAdRequestInfoParcel, paramContext, zzaou.zzcs, localJSONException1.getUrl(), localTimeoutException, localJSONException1, localzzdk, paramzzis);
                    paramzzcv = paramzzfw;
                    if (paramzzfw != null) {
                      continue;
                    }
                    paramzzcv = new AdResponseParcel(0);
                    localzzdk.zza(localzzdi, new String[] { "tts" });
                    zzccp = localzzdk.zzki();
                    return paramzzcv;
                  }
                  finally
                  {
                    zzkl.zzclg.post(new Runnable()
                    {
                      public void run()
                      {
                        zzcdv.zza(paramContext, localzziv, paramAdRequestInfoParcelzzaou);
                      }
                    });
                  }
                  localJSONException1 = localJSONException1;
                  zzkh.zzd("Failed putting prefetch parameters to ad request.", localJSONException1);
                }
              }
            }
            catch (JSONException localJSONException2)
            {
              for (;;) {}
            }
          }
          catch (ExecutionException localExecutionException)
          {
            for (;;) {}
          }
        }
        localObject4 = null;
        continue;
        Object localObject2 = localObject4;
        localObject4 = null;
      }
    }
  }
  
  /* Error */
  public static AdResponseParcel zza(AdRequestInfoParcel paramAdRequestInfoParcel, Context paramContext, String paramString1, String paramString2, String paramString3, zziy paramzziy, zzdk paramzzdk, zzis paramzzis)
  {
    // Byte code:
    //   0: aload 6
    //   2: ifnull +706 -> 708
    //   5: aload 6
    //   7: invokevirtual 166	com/google/android/gms/internal/zzdk:zzkg	()Lcom/google/android/gms/internal/zzdi;
    //   10: astore 12
    //   12: new 459	com/google/android/gms/internal/zziw
    //   15: dup
    //   16: aload_0
    //   17: invokespecial 462	com/google/android/gms/internal/zziw:<init>	(Lcom/google/android/gms/ads/internal/request/AdRequestInfoParcel;)V
    //   20: astore 15
    //   22: aload_3
    //   23: invokestatic 466	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   26: astore 13
    //   28: aload 13
    //   30: invokevirtual 469	java/lang/String:length	()I
    //   33: ifeq +329 -> 362
    //   36: ldc_w 471
    //   39: aload 13
    //   41: invokevirtual 474	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   44: astore 13
    //   46: aload 13
    //   48: invokestatic 100	com/google/android/gms/internal/zzkh:zzcw	(Ljava/lang/String;)V
    //   51: new 476	java/net/URL
    //   54: dup
    //   55: aload_3
    //   56: invokespecial 478	java/net/URL:<init>	(Ljava/lang/String;)V
    //   59: astore_3
    //   60: invokestatic 482	com/google/android/gms/ads/internal/zzu:zzfu	()Lcom/google/android/gms/common/util/zze;
    //   63: invokeinterface 487 1 0
    //   68: lstore 10
    //   70: iconst_0
    //   71: istore 8
    //   73: aload 7
    //   75: ifnull +13 -> 88
    //   78: aload 7
    //   80: getfield 491	com/google/android/gms/internal/zzis:zzcdz	Lcom/google/android/gms/internal/zzjc;
    //   83: invokeinterface 496 1 0
    //   88: aload_3
    //   89: invokevirtual 500	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   92: checkcast 502	java/net/HttpURLConnection
    //   95: astore 14
    //   97: invokestatic 506	com/google/android/gms/ads/internal/zzu:zzfq	()Lcom/google/android/gms/internal/zzkl;
    //   100: aload_1
    //   101: aload_2
    //   102: iconst_0
    //   103: aload 14
    //   105: invokevirtual 509	com/google/android/gms/internal/zzkl:zza	(Landroid/content/Context;Ljava/lang/String;ZLjava/net/HttpURLConnection;)V
    //   108: aload 4
    //   110: invokestatic 434	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   113: ifne +21 -> 134
    //   116: aload 5
    //   118: invokevirtual 512	com/google/android/gms/internal/zziy:zzrm	()Z
    //   121: ifeq +13 -> 134
    //   124: aload 14
    //   126: ldc_w 514
    //   129: aload 4
    //   131: invokevirtual 517	java/net/HttpURLConnection:addRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   134: aload_0
    //   135: getfield 520	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:zzcbv	Ljava/lang/String;
    //   138: astore 13
    //   140: aload 13
    //   142: invokestatic 434	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   145: ifne +19 -> 164
    //   148: ldc_w 522
    //   151: invokestatic 100	com/google/android/gms/internal/zzkh:zzcw	(Ljava/lang/String;)V
    //   154: aload 14
    //   156: ldc_w 524
    //   159: aload 13
    //   161: invokevirtual 517	java/net/HttpURLConnection:addRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   164: aload 5
    //   166: ifnull +64 -> 230
    //   169: aload 5
    //   171: invokevirtual 527	com/google/android/gms/internal/zziy:zzrl	()Ljava/lang/String;
    //   174: invokestatic 434	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   177: ifne +53 -> 230
    //   180: aload 14
    //   182: iconst_1
    //   183: invokevirtual 531	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   186: aload 5
    //   188: invokevirtual 527	com/google/android/gms/internal/zziy:zzrl	()Ljava/lang/String;
    //   191: invokevirtual 535	java/lang/String:getBytes	()[B
    //   194: astore 16
    //   196: aload 14
    //   198: aload 16
    //   200: arraylength
    //   201: invokevirtual 538	java/net/HttpURLConnection:setFixedLengthStreamingMode	(I)V
    //   204: new 540	java/io/BufferedOutputStream
    //   207: dup
    //   208: aload 14
    //   210: invokevirtual 544	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   213: invokespecial 547	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   216: astore 13
    //   218: aload 13
    //   220: aload 16
    //   222: invokevirtual 551	java/io/BufferedOutputStream:write	([B)V
    //   225: aload 13
    //   227: invokestatic 556	com/google/android/gms/common/util/zzo:zzb	(Ljava/io/Closeable;)V
    //   230: aload 14
    //   232: invokevirtual 559	java/net/HttpURLConnection:getResponseCode	()I
    //   235: istore 9
    //   237: aload 14
    //   239: invokevirtual 563	java/net/HttpURLConnection:getHeaderFields	()Ljava/util/Map;
    //   242: astore 13
    //   244: iload 9
    //   246: sipush 200
    //   249: if_icmplt +206 -> 455
    //   252: iload 9
    //   254: sipush 300
    //   257: if_icmpge +198 -> 455
    //   260: aload_3
    //   261: invokevirtual 564	java/net/URL:toString	()Ljava/lang/String;
    //   264: astore_0
    //   265: new 566	java/io/InputStreamReader
    //   268: dup
    //   269: aload 14
    //   271: invokevirtual 570	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   274: invokespecial 573	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   277: astore_1
    //   278: invokestatic 506	com/google/android/gms/ads/internal/zzu:zzfq	()Lcom/google/android/gms/internal/zzkl;
    //   281: aload_1
    //   282: invokevirtual 576	com/google/android/gms/internal/zzkl:zza	(Ljava/io/InputStreamReader;)Ljava/lang/String;
    //   285: astore_2
    //   286: aload_1
    //   287: invokestatic 556	com/google/android/gms/common/util/zzo:zzb	(Ljava/io/Closeable;)V
    //   290: aload_0
    //   291: aload 13
    //   293: aload_2
    //   294: iload 9
    //   296: invokestatic 579	com/google/android/gms/internal/zzit:zza	(Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;I)V
    //   299: aload 15
    //   301: aload_0
    //   302: aload 13
    //   304: aload_2
    //   305: invokevirtual 582	com/google/android/gms/internal/zziw:zzb	(Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;)V
    //   308: aload 6
    //   310: ifnull +21 -> 331
    //   313: aload 6
    //   315: aload 12
    //   317: iconst_1
    //   318: anewarray 157	java/lang/String
    //   321: dup
    //   322: iconst_0
    //   323: ldc_w 584
    //   326: aastore
    //   327: invokevirtual 162	com/google/android/gms/internal/zzdk:zza	(Lcom/google/android/gms/internal/zzdi;[Ljava/lang/String;)Z
    //   330: pop
    //   331: aload 15
    //   333: lload 10
    //   335: invokevirtual 588	com/google/android/gms/internal/zziw:zzj	(J)Lcom/google/android/gms/ads/internal/request/AdResponseParcel;
    //   338: astore_0
    //   339: aload 14
    //   341: invokevirtual 591	java/net/HttpURLConnection:disconnect	()V
    //   344: aload 7
    //   346: ifnull +360 -> 706
    //   349: aload 7
    //   351: getfield 491	com/google/android/gms/internal/zzis:zzcdz	Lcom/google/android/gms/internal/zzjc;
    //   354: invokeinterface 594 1 0
    //   359: goto +347 -> 706
    //   362: new 157	java/lang/String
    //   365: dup
    //   366: ldc_w 471
    //   369: invokespecial 595	java/lang/String:<init>	(Ljava/lang/String;)V
    //   372: astore 13
    //   374: goto -328 -> 46
    //   377: astore_0
    //   378: aload_0
    //   379: invokevirtual 598	java/io/IOException:getMessage	()Ljava/lang/String;
    //   382: invokestatic 466	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   385: astore_0
    //   386: aload_0
    //   387: invokevirtual 469	java/lang/String:length	()I
    //   390: ifeq +291 -> 681
    //   393: ldc_w 600
    //   396: aload_0
    //   397: invokevirtual 474	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   400: astore_0
    //   401: aload_0
    //   402: invokestatic 603	com/google/android/gms/internal/zzkh:zzcy	(Ljava/lang/String;)V
    //   405: new 256	com/google/android/gms/ads/internal/request/AdResponseParcel
    //   408: dup
    //   409: iconst_2
    //   410: invokespecial 259	com/google/android/gms/ads/internal/request/AdResponseParcel:<init>	(I)V
    //   413: areturn
    //   414: astore_0
    //   415: aconst_null
    //   416: astore_1
    //   417: aload_1
    //   418: invokestatic 556	com/google/android/gms/common/util/zzo:zzb	(Ljava/io/Closeable;)V
    //   421: aload_0
    //   422: athrow
    //   423: astore_0
    //   424: aload 14
    //   426: invokevirtual 591	java/net/HttpURLConnection:disconnect	()V
    //   429: aload 7
    //   431: ifnull +13 -> 444
    //   434: aload 7
    //   436: getfield 491	com/google/android/gms/internal/zzis:zzcdz	Lcom/google/android/gms/internal/zzjc;
    //   439: invokeinterface 594 1 0
    //   444: aload_0
    //   445: athrow
    //   446: astore_0
    //   447: aconst_null
    //   448: astore_1
    //   449: aload_1
    //   450: invokestatic 556	com/google/android/gms/common/util/zzo:zzb	(Ljava/io/Closeable;)V
    //   453: aload_0
    //   454: athrow
    //   455: aload_3
    //   456: invokevirtual 564	java/net/URL:toString	()Ljava/lang/String;
    //   459: aload 13
    //   461: aconst_null
    //   462: iload 9
    //   464: invokestatic 579	com/google/android/gms/internal/zzit:zza	(Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;I)V
    //   467: iload 9
    //   469: sipush 300
    //   472: if_icmplt +122 -> 594
    //   475: iload 9
    //   477: sipush 400
    //   480: if_icmpge +114 -> 594
    //   483: aload 14
    //   485: ldc_w 605
    //   488: invokevirtual 608	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   491: astore_3
    //   492: aload_3
    //   493: invokestatic 434	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   496: ifeq +40 -> 536
    //   499: ldc_w 610
    //   502: invokestatic 603	com/google/android/gms/internal/zzkh:zzcy	(Ljava/lang/String;)V
    //   505: new 256	com/google/android/gms/ads/internal/request/AdResponseParcel
    //   508: dup
    //   509: iconst_0
    //   510: invokespecial 259	com/google/android/gms/ads/internal/request/AdResponseParcel:<init>	(I)V
    //   513: astore_0
    //   514: aload 14
    //   516: invokevirtual 591	java/net/HttpURLConnection:disconnect	()V
    //   519: aload 7
    //   521: ifnull +13 -> 534
    //   524: aload 7
    //   526: getfield 491	com/google/android/gms/internal/zzis:zzcdz	Lcom/google/android/gms/internal/zzjc;
    //   529: invokeinterface 594 1 0
    //   534: aload_0
    //   535: areturn
    //   536: new 476	java/net/URL
    //   539: dup
    //   540: aload_3
    //   541: invokespecial 478	java/net/URL:<init>	(Ljava/lang/String;)V
    //   544: astore_3
    //   545: iload 8
    //   547: iconst_1
    //   548: iadd
    //   549: istore 8
    //   551: iload 8
    //   553: iconst_5
    //   554: if_icmple +97 -> 651
    //   557: ldc_w 612
    //   560: invokestatic 603	com/google/android/gms/internal/zzkh:zzcy	(Ljava/lang/String;)V
    //   563: new 256	com/google/android/gms/ads/internal/request/AdResponseParcel
    //   566: dup
    //   567: iconst_0
    //   568: invokespecial 259	com/google/android/gms/ads/internal/request/AdResponseParcel:<init>	(I)V
    //   571: astore_0
    //   572: aload 14
    //   574: invokevirtual 591	java/net/HttpURLConnection:disconnect	()V
    //   577: aload 7
    //   579: ifnull +13 -> 592
    //   582: aload 7
    //   584: getfield 491	com/google/android/gms/internal/zzis:zzcdz	Lcom/google/android/gms/internal/zzjc;
    //   587: invokeinterface 594 1 0
    //   592: aload_0
    //   593: areturn
    //   594: new 614	java/lang/StringBuilder
    //   597: dup
    //   598: bipush 46
    //   600: invokespecial 615	java/lang/StringBuilder:<init>	(I)V
    //   603: ldc_w 617
    //   606: invokevirtual 621	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   609: iload 9
    //   611: invokevirtual 624	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   614: invokevirtual 625	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   617: invokestatic 603	com/google/android/gms/internal/zzkh:zzcy	(Ljava/lang/String;)V
    //   620: new 256	com/google/android/gms/ads/internal/request/AdResponseParcel
    //   623: dup
    //   624: iconst_0
    //   625: invokespecial 259	com/google/android/gms/ads/internal/request/AdResponseParcel:<init>	(I)V
    //   628: astore_0
    //   629: aload 14
    //   631: invokevirtual 591	java/net/HttpURLConnection:disconnect	()V
    //   634: aload 7
    //   636: ifnull +13 -> 649
    //   639: aload 7
    //   641: getfield 491	com/google/android/gms/internal/zzis:zzcdz	Lcom/google/android/gms/internal/zzjc;
    //   644: invokeinterface 594 1 0
    //   649: aload_0
    //   650: areturn
    //   651: aload 15
    //   653: aload 13
    //   655: invokevirtual 628	com/google/android/gms/internal/zziw:zzj	(Ljava/util/Map;)V
    //   658: aload 14
    //   660: invokevirtual 591	java/net/HttpURLConnection:disconnect	()V
    //   663: aload 7
    //   665: ifnull +13 -> 678
    //   668: aload 7
    //   670: getfield 491	com/google/android/gms/internal/zzis:zzcdz	Lcom/google/android/gms/internal/zzjc;
    //   673: invokeinterface 594 1 0
    //   678: goto -605 -> 73
    //   681: new 157	java/lang/String
    //   684: dup
    //   685: ldc_w 600
    //   688: invokespecial 595	java/lang/String:<init>	(Ljava/lang/String;)V
    //   691: astore_0
    //   692: goto -291 -> 401
    //   695: astore_0
    //   696: goto -247 -> 449
    //   699: astore_0
    //   700: aload 13
    //   702: astore_1
    //   703: goto -286 -> 417
    //   706: aload_0
    //   707: areturn
    //   708: aconst_null
    //   709: astore 12
    //   711: goto -699 -> 12
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	714	0	paramAdRequestInfoParcel	AdRequestInfoParcel
    //   0	714	1	paramContext	Context
    //   0	714	2	paramString1	String
    //   0	714	3	paramString2	String
    //   0	714	4	paramString3	String
    //   0	714	5	paramzziy	zziy
    //   0	714	6	paramzzdk	zzdk
    //   0	714	7	paramzzis	zzis
    //   71	484	8	i	int
    //   235	375	9	j	int
    //   68	266	10	l	long
    //   10	700	12	localzzdi	zzdi
    //   26	675	13	localObject	Object
    //   95	564	14	localHttpURLConnection	java.net.HttpURLConnection
    //   20	632	15	localzziw	zziw
    //   194	27	16	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   12	46	377	java/io/IOException
    //   46	70	377	java/io/IOException
    //   78	88	377	java/io/IOException
    //   88	97	377	java/io/IOException
    //   339	344	377	java/io/IOException
    //   349	359	377	java/io/IOException
    //   362	374	377	java/io/IOException
    //   424	429	377	java/io/IOException
    //   434	444	377	java/io/IOException
    //   444	446	377	java/io/IOException
    //   514	519	377	java/io/IOException
    //   524	534	377	java/io/IOException
    //   572	577	377	java/io/IOException
    //   582	592	377	java/io/IOException
    //   629	634	377	java/io/IOException
    //   639	649	377	java/io/IOException
    //   658	663	377	java/io/IOException
    //   668	678	377	java/io/IOException
    //   204	218	414	finally
    //   97	134	423	finally
    //   134	164	423	finally
    //   169	204	423	finally
    //   225	230	423	finally
    //   230	244	423	finally
    //   260	265	423	finally
    //   286	308	423	finally
    //   313	331	423	finally
    //   331	339	423	finally
    //   417	423	423	finally
    //   449	455	423	finally
    //   455	467	423	finally
    //   483	514	423	finally
    //   536	545	423	finally
    //   557	572	423	finally
    //   594	629	423	finally
    //   651	658	423	finally
    //   265	278	446	finally
    //   278	286	695	finally
    //   218	225	699	finally
  }
  
  public static zzit zza(Context paramContext, zzcv paramzzcv, zzis paramzzis)
  {
    synchronized (zzamp)
    {
      if (zzceb == null)
      {
        Context localContext = paramContext;
        if (paramContext.getApplicationContext() != null) {
          localContext = paramContext.getApplicationContext();
        }
        zzceb = new zzit(localContext, paramzzcv, paramzzis);
      }
      paramContext = zzceb;
      return paramContext;
    }
  }
  
  private static void zza(String paramString1, Map<String, List<String>> paramMap, String paramString2, int paramInt)
  {
    if (zzkh.zzaz(2))
    {
      zzkh.v(String.valueOf(paramString1).length() + 39 + "Http Response: {\n  URL:\n    " + paramString1 + "\n  Headers:");
      if (paramMap != null)
      {
        Iterator localIterator1 = paramMap.keySet().iterator();
        if (localIterator1.hasNext())
        {
          paramString1 = (String)localIterator1.next();
          zzkh.v(String.valueOf(paramString1).length() + 5 + "    " + paramString1 + ":");
          Iterator localIterator2 = ((List)paramMap.get(paramString1)).iterator();
          label139:
          if (localIterator2.hasNext())
          {
            paramString1 = String.valueOf((String)localIterator2.next());
            if (paramString1.length() == 0) {
              break label185;
            }
          }
          label185:
          for (paramString1 = "      ".concat(paramString1);; paramString1 = new String("      "))
          {
            zzkh.v(paramString1);
            break label139;
            break;
          }
        }
      }
      zzkh.v("  Body:");
      if (paramString2 != null)
      {
        int i = 0;
        while (i < Math.min(paramString2.length(), 100000))
        {
          zzkh.v(paramString2.substring(i, Math.min(paramString2.length(), i + 1000)));
          i += 1000;
        }
      }
      zzkh.v("    null");
      zzkh.v(34 + "  Response Code:\n    " + paramInt + "\n}");
    }
  }
  
  private static Location zzb(zzlc<Location> paramzzlc)
  {
    try
    {
      paramzzlc = (Location)paramzzlc.get(((Long)zzdc.zzbcn.get()).longValue(), TimeUnit.MILLISECONDS);
      return paramzzlc;
    }
    catch (Exception paramzzlc)
    {
      zzkh.zzd("Exception caught while getting location", paramzzlc);
    }
    return null;
  }
  
  public void zza(final AdRequestInfoParcel paramAdRequestInfoParcel, final zzl paramzzl)
  {
    zzu.zzft().zzb(mContext, zzaou);
    zzkk.zza(new Runnable()
    {
      public void run()
      {
        try
        {
          AdResponseParcel localAdResponseParcel1 = zzd(paramAdRequestInfoParcel);
          localAdResponseParcel2 = localAdResponseParcel1;
          if (localAdResponseParcel1 == null) {
            localAdResponseParcel2 = new AdResponseParcel(0);
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            try
            {
              AdResponseParcel localAdResponseParcel2;
              paramzzl.zzb(localAdResponseParcel2);
              return;
            }
            catch (RemoteException localRemoteException)
            {
              Object localObject;
              zzkh.zzd("Fail to forward ad response.", localRemoteException);
            }
            localException = localException;
            zzu.zzft().zzb(localException, true);
            zzkh.zzd("Could not fetch ad response due to an Exception.", localException);
            localObject = null;
          }
        }
      }
    });
  }
  
  public AdResponseParcel zzd(AdRequestInfoParcel paramAdRequestInfoParcel)
  {
    return zza(mContext, zzcee, zzced, zzcec, paramAdRequestInfoParcel);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzit
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */