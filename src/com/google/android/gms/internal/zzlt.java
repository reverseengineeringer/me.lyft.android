package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.content.Context;
import android.webkit.WebResourceResponse;
import com.google.android.gms.ads.internal.zzu;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@zzir
@TargetApi(11)
public class zzlt
  extends zzlm
{
  public zzlt(zzll paramzzll, boolean paramBoolean)
  {
    super(paramzzll, paramBoolean);
  }
  
  /* Error */
  public WebResourceResponse shouldInterceptRequest(android.webkit.WebView paramWebView, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 27	com/google/android/gms/internal/zzlt:zzcow	Lcom/google/android/gms/internal/zzjs;
    //   4: ifnull +13 -> 17
    //   7: aload_0
    //   8: getfield 27	com/google/android/gms/internal/zzlt:zzcow	Lcom/google/android/gms/internal/zzjs;
    //   11: aload_2
    //   12: invokeinterface 33 2 0
    //   17: ldc 35
    //   19: new 37	java/io/File
    //   22: dup
    //   23: aload_2
    //   24: invokespecial 39	java/io/File:<init>	(Ljava/lang/String;)V
    //   27: invokevirtual 43	java/io/File:getName	()Ljava/lang/String;
    //   30: invokevirtual 49	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   33: ifne +10 -> 43
    //   36: aload_0
    //   37: aload_1
    //   38: aload_2
    //   39: invokespecial 51	com/google/android/gms/internal/zzlm:shouldInterceptRequest	(Landroid/webkit/WebView;Ljava/lang/String;)Landroid/webkit/WebResourceResponse;
    //   42: areturn
    //   43: aload_1
    //   44: instanceof 53
    //   47: ifne +15 -> 62
    //   50: ldc 55
    //   52: invokestatic 60	com/google/android/gms/internal/zzkh:zzcy	(Ljava/lang/String;)V
    //   55: aload_0
    //   56: aload_1
    //   57: aload_2
    //   58: invokespecial 51	com/google/android/gms/internal/zzlm:shouldInterceptRequest	(Landroid/webkit/WebView;Ljava/lang/String;)Landroid/webkit/WebResourceResponse;
    //   61: areturn
    //   62: aload_1
    //   63: checkcast 53	com/google/android/gms/internal/zzll
    //   66: astore 4
    //   68: aload 4
    //   70: invokeinterface 64 1 0
    //   75: invokevirtual 68	com/google/android/gms/internal/zzlm:zznz	()V
    //   78: aload 4
    //   80: invokeinterface 72 1 0
    //   85: getfield 78	com/google/android/gms/ads/internal/client/AdSizeParcel:zzauq	Z
    //   88: ifeq +75 -> 163
    //   91: getstatic 84	com/google/android/gms/internal/zzdc:zzazb	Lcom/google/android/gms/internal/zzcy;
    //   94: invokevirtual 90	com/google/android/gms/internal/zzcy:get	()Ljava/lang/Object;
    //   97: checkcast 45	java/lang/String
    //   100: astore_3
    //   101: new 92	java/lang/StringBuilder
    //   104: dup
    //   105: aload_3
    //   106: invokestatic 96	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   109: invokevirtual 100	java/lang/String:length	()I
    //   112: bipush 24
    //   114: iadd
    //   115: invokespecial 103	java/lang/StringBuilder:<init>	(I)V
    //   118: ldc 105
    //   120: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: aload_3
    //   124: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: ldc 111
    //   129: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   135: invokestatic 117	com/google/android/gms/internal/zzkh:v	(Ljava/lang/String;)V
    //   138: aload_0
    //   139: aload 4
    //   141: invokeinterface 121 1 0
    //   146: aload_0
    //   147: getfield 125	com/google/android/gms/internal/zzlt:zzbgj	Lcom/google/android/gms/internal/zzll;
    //   150: invokeinterface 129 1 0
    //   155: getfield 135	com/google/android/gms/ads/internal/util/client/VersionInfoParcel:zzcs	Ljava/lang/String;
    //   158: aload_3
    //   159: invokevirtual 139	com/google/android/gms/internal/zzlt:zzd	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Landroid/webkit/WebResourceResponse;
    //   162: areturn
    //   163: aload 4
    //   165: invokeinterface 143 1 0
    //   170: ifeq +16 -> 186
    //   173: getstatic 146	com/google/android/gms/internal/zzdc:zzaza	Lcom/google/android/gms/internal/zzcy;
    //   176: invokevirtual 90	com/google/android/gms/internal/zzcy:get	()Ljava/lang/Object;
    //   179: checkcast 45	java/lang/String
    //   182: astore_3
    //   183: goto -82 -> 101
    //   186: getstatic 149	com/google/android/gms/internal/zzdc:zzayz	Lcom/google/android/gms/internal/zzcy;
    //   189: invokevirtual 90	com/google/android/gms/internal/zzcy:get	()Ljava/lang/Object;
    //   192: checkcast 45	java/lang/String
    //   195: astore_3
    //   196: goto -95 -> 101
    //   199: astore_3
    //   200: aload_3
    //   201: invokevirtual 154	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   204: invokestatic 96	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   207: astore_3
    //   208: aload_3
    //   209: invokevirtual 100	java/lang/String:length	()I
    //   212: ifeq +21 -> 233
    //   215: ldc -100
    //   217: aload_3
    //   218: invokevirtual 160	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   221: astore_3
    //   222: aload_3
    //   223: invokestatic 60	com/google/android/gms/internal/zzkh:zzcy	(Ljava/lang/String;)V
    //   226: aload_0
    //   227: aload_1
    //   228: aload_2
    //   229: invokespecial 51	com/google/android/gms/internal/zzlm:shouldInterceptRequest	(Landroid/webkit/WebView;Ljava/lang/String;)Landroid/webkit/WebResourceResponse;
    //   232: areturn
    //   233: new 45	java/lang/String
    //   236: dup
    //   237: ldc -100
    //   239: invokespecial 161	java/lang/String:<init>	(Ljava/lang/String;)V
    //   242: astore_3
    //   243: goto -21 -> 222
    //   246: astore_3
    //   247: goto -47 -> 200
    //   250: astore_3
    //   251: goto -51 -> 200
    //   254: astore_3
    //   255: goto -55 -> 200
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	258	0	this	zzlt
    //   0	258	1	paramWebView	android.webkit.WebView
    //   0	258	2	paramString	String
    //   100	96	3	str1	String
    //   199	2	3	localInterruptedException	InterruptedException
    //   207	36	3	str2	String
    //   246	1	3	localTimeoutException	TimeoutException
    //   250	1	3	localIOException	IOException
    //   254	1	3	localExecutionException	ExecutionException
    //   66	98	4	localzzll	zzll
    // Exception table:
    //   from	to	target	type
    //   17	43	199	java/lang/InterruptedException
    //   43	62	199	java/lang/InterruptedException
    //   62	101	199	java/lang/InterruptedException
    //   101	163	199	java/lang/InterruptedException
    //   163	183	199	java/lang/InterruptedException
    //   186	196	199	java/lang/InterruptedException
    //   17	43	246	java/util/concurrent/TimeoutException
    //   43	62	246	java/util/concurrent/TimeoutException
    //   62	101	246	java/util/concurrent/TimeoutException
    //   101	163	246	java/util/concurrent/TimeoutException
    //   163	183	246	java/util/concurrent/TimeoutException
    //   186	196	246	java/util/concurrent/TimeoutException
    //   17	43	250	java/io/IOException
    //   43	62	250	java/io/IOException
    //   62	101	250	java/io/IOException
    //   101	163	250	java/io/IOException
    //   163	183	250	java/io/IOException
    //   186	196	250	java/io/IOException
    //   17	43	254	java/util/concurrent/ExecutionException
    //   43	62	254	java/util/concurrent/ExecutionException
    //   62	101	254	java/util/concurrent/ExecutionException
    //   101	163	254	java/util/concurrent/ExecutionException
    //   163	183	254	java/util/concurrent/ExecutionException
    //   186	196	254	java/util/concurrent/ExecutionException
  }
  
  protected WebResourceResponse zzd(Context paramContext, String paramString1, String paramString2)
    throws IOException, ExecutionException, InterruptedException, TimeoutException
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("User-Agent", zzu.zzfq().zzh(paramContext, paramString1));
    localHashMap.put("Cache-Control", "max-stale=3600");
    paramContext = (String)new zzkr(paramContext).zzb(paramString2, localHashMap).get(60L, TimeUnit.SECONDS);
    if (paramContext == null) {
      return null;
    }
    return new WebResourceResponse("application/javascript", "UTF-8", new ByteArrayInputStream(paramContext.getBytes("UTF-8")));
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzlt
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */