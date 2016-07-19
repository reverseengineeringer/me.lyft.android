package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.KeyguardManager;
import android.content.Context;
import android.graphics.Rect;
import android.os.PowerManager;
import android.os.Process;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.webkit.ValueCallback;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.TextView;
import com.google.android.gms.common.util.zzs;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

@zzir
@TargetApi(14)
public class zzco
  extends Thread
{
  private boolean mStarted = false;
  private final Object zzail;
  private final int zzart;
  private final int zzarv;
  private boolean zzash = false;
  private final zzcn zzasi;
  private final zzcm zzasj;
  private final zziq zzask;
  private final int zzasl;
  private final int zzasm;
  private final int zzasn;
  private boolean zzbl = false;
  
  public zzco(zzcn paramzzcn, zzcm paramzzcm, zziq paramzziq)
  {
    zzasi = paramzzcn;
    zzasj = paramzzcm;
    zzask = paramzziq;
    zzail = new Object();
    zzart = ((Integer)zzdc.zzazg.get()).intValue();
    zzasm = ((Integer)zzdc.zzazh.get()).intValue();
    zzarv = ((Integer)zzdc.zzazi.get()).intValue();
    zzasn = ((Integer)zzdc.zzazj.get()).intValue();
    zzasl = ((Integer)zzdc.zzazk.get()).intValue();
    setName("ContentFetchTask");
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 113	com/google/android/gms/internal/zzco:zzia	()Z
    //   4: ifeq +98 -> 102
    //   7: aload_0
    //   8: getfield 48	com/google/android/gms/internal/zzco:zzasi	Lcom/google/android/gms/internal/zzcn;
    //   11: invokevirtual 119	com/google/android/gms/internal/zzcn:getActivity	()Landroid/app/Activity;
    //   14: astore_2
    //   15: aload_2
    //   16: ifnonnull +59 -> 75
    //   19: ldc 121
    //   21: invokestatic 126	com/google/android/gms/internal/zzkh:zzcw	(Ljava/lang/String;)V
    //   24: aload_0
    //   25: invokevirtual 129	com/google/android/gms/internal/zzco:zzic	()V
    //   28: aload_0
    //   29: getfield 97	com/google/android/gms/internal/zzco:zzasl	I
    //   32: sipush 1000
    //   35: imul
    //   36: i2l
    //   37: invokestatic 133	java/lang/Thread:sleep	(J)V
    //   40: aload_0
    //   41: getfield 57	com/google/android/gms/internal/zzco:zzail	Ljava/lang/Object;
    //   44: astore_2
    //   45: aload_2
    //   46: monitorenter
    //   47: aload_0
    //   48: getfield 44	com/google/android/gms/internal/zzco:zzash	Z
    //   51: istore_1
    //   52: iload_1
    //   53: ifeq +61 -> 114
    //   56: ldc -121
    //   58: invokestatic 126	com/google/android/gms/internal/zzkh:zzcw	(Ljava/lang/String;)V
    //   61: aload_0
    //   62: getfield 57	com/google/android/gms/internal/zzco:zzail	Ljava/lang/Object;
    //   65: invokevirtual 138	java/lang/Object:wait	()V
    //   68: goto -21 -> 47
    //   71: astore_3
    //   72: goto -25 -> 47
    //   75: aload_0
    //   76: aload_2
    //   77: invokevirtual 141	com/google/android/gms/internal/zzco:zza	(Landroid/app/Activity;)V
    //   80: goto -52 -> 28
    //   83: astore_2
    //   84: ldc -113
    //   86: aload_2
    //   87: invokestatic 147	com/google/android/gms/internal/zzkh:zzb	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   90: aload_0
    //   91: getfield 52	com/google/android/gms/internal/zzco:zzask	Lcom/google/android/gms/internal/zziq;
    //   94: aload_2
    //   95: iconst_1
    //   96: invokevirtual 152	com/google/android/gms/internal/zziq:zza	(Ljava/lang/Throwable;Z)V
    //   99: goto -59 -> 40
    //   102: ldc -102
    //   104: invokestatic 126	com/google/android/gms/internal/zzkh:zzcw	(Ljava/lang/String;)V
    //   107: aload_0
    //   108: invokevirtual 129	com/google/android/gms/internal/zzco:zzic	()V
    //   111: goto -83 -> 28
    //   114: aload_2
    //   115: monitorexit
    //   116: goto -116 -> 0
    //   119: astore_3
    //   120: aload_2
    //   121: monitorexit
    //   122: aload_3
    //   123: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	124	0	this	zzco
    //   51	2	1	bool	boolean
    //   83	38	2	localThrowable	Throwable
    //   71	1	3	localInterruptedException	InterruptedException
    //   119	4	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   56	68	71	java/lang/InterruptedException
    //   0	15	83	java/lang/Throwable
    //   19	28	83	java/lang/Throwable
    //   28	40	83	java/lang/Throwable
    //   75	80	83	java/lang/Throwable
    //   102	111	83	java/lang/Throwable
    //   47	52	119	finally
    //   56	68	119	finally
    //   114	116	119	finally
    //   120	122	119	finally
  }
  
  public void wakeup()
  {
    synchronized (zzail)
    {
      zzash = false;
      zzail.notifyAll();
      zzkh.zzcw("ContentFetchThread: wakeup");
      return;
    }
  }
  
  zza zza(View paramView, zzcl paramzzcl)
  {
    int i = 0;
    if (paramView == null) {
      return new zza(0, 0);
    }
    boolean bool = paramView.getGlobalVisibleRect(new Rect());
    if (((paramView instanceof TextView)) && (!(paramView instanceof EditText)))
    {
      paramView = ((TextView)paramView).getText();
      if (!TextUtils.isEmpty(paramView))
      {
        paramzzcl.zze(paramView.toString(), bool);
        return new zza(1, 0);
      }
      return new zza(0, 0);
    }
    if (((paramView instanceof WebView)) && (!(paramView instanceof zzll)))
    {
      paramzzcl.zzhv();
      if (zza((WebView)paramView, paramzzcl, bool)) {
        return new zza(0, 1);
      }
      return new zza(0, 0);
    }
    if ((paramView instanceof ViewGroup))
    {
      paramView = (ViewGroup)paramView;
      int j = 0;
      int k = 0;
      while (i < paramView.getChildCount())
      {
        zza localzza = zza(paramView.getChildAt(i), paramzzcl);
        k += zzasv;
        j += zzasw;
        i += 1;
      }
      return new zza(k, j);
    }
    return new zza(0, 0);
  }
  
  void zza(Activity paramActivity)
  {
    if (paramActivity == null) {}
    do
    {
      return;
      Object localObject2 = null;
      Object localObject1 = localObject2;
      try
      {
        if (paramActivity.getWindow() != null)
        {
          localObject1 = localObject2;
          if (paramActivity.getWindow().getDecorView() != null) {
            localObject1 = paramActivity.getWindow().getDecorView().findViewById(16908290);
          }
        }
      }
      catch (Throwable paramActivity)
      {
        for (;;)
        {
          zzkh.zzcw("Failed getting root view of activity. Content not extracted.");
          localObject1 = localObject2;
        }
      }
    } while (localObject1 == null);
    zze((View)localObject1);
  }
  
  void zza(zzcl paramzzcl, WebView paramWebView, String paramString, boolean paramBoolean)
  {
    paramzzcl.zzhu();
    try
    {
      if (!TextUtils.isEmpty(paramString))
      {
        paramString = new JSONObject(paramString).optString("text");
        if (TextUtils.isEmpty(paramWebView.getTitle())) {
          break label108;
        }
        paramWebView = String.valueOf(paramWebView.getTitle());
        paramzzcl.zzd(String.valueOf(paramWebView).length() + 1 + String.valueOf(paramString).length() + paramWebView + "\n" + paramString, paramBoolean);
      }
      while (paramzzcl.zzhq())
      {
        zzasj.zzb(paramzzcl);
        return;
        label108:
        paramzzcl.zzd(paramString, paramBoolean);
      }
      return;
    }
    catch (JSONException paramzzcl)
    {
      zzkh.zzcw("Json string may be malformed.");
      return;
    }
    catch (Throwable paramzzcl)
    {
      zzkh.zza("Failed to get webview content.", paramzzcl);
      zzask.zza(paramzzcl, true);
    }
  }
  
  boolean zza(ActivityManager.RunningAppProcessInfo paramRunningAppProcessInfo)
  {
    return importance == 100;
  }
  
  @TargetApi(19)
  boolean zza(final WebView paramWebView, final zzcl paramzzcl, final boolean paramBoolean)
  {
    if (!zzs.zzavq()) {
      return false;
    }
    paramzzcl.zzhv();
    paramWebView.post(new Runnable()
    {
      ValueCallback<String> zzasq = new ValueCallback()
      {
        public void zzz(String paramAnonymous2String)
        {
          zza(zzasr, zzass, paramAnonymous2String, zzast);
        }
      };
      
      public void run()
      {
        if (paramWebView.getSettings().getJavaScriptEnabled()) {}
        try
        {
          paramWebView.evaluateJavascript("(function() { return  {text:document.body.innerText}})();", zzasq);
          return;
        }
        catch (Throwable localThrowable)
        {
          zzasq.onReceiveValue("");
        }
      }
    });
    return true;
  }
  
  boolean zze(final View paramView)
  {
    if (paramView == null) {
      return false;
    }
    paramView.post(new Runnable()
    {
      public void run()
      {
        zzf(paramView);
      }
    });
    return true;
  }
  
  void zzf(View paramView)
  {
    try
    {
      zzcl localzzcl = new zzcl(zzart, zzasm, zzarv, zzasn);
      paramView = zza(paramView, localzzcl);
      localzzcl.zzhw();
      if ((zzasv == 0) && (zzasw == 0)) {
        return;
      }
      if (((zzasw != 0) || (localzzcl.zzhx() != 0)) && ((zzasw != 0) || (!zzasj.zza(localzzcl))))
      {
        zzasj.zzc(localzzcl);
        return;
      }
    }
    catch (Exception paramView)
    {
      zzkh.zzb("Exception in fetchContentOnUIThread", paramView);
      zzask.zza(paramView, true);
    }
  }
  
  public void zzhz()
  {
    synchronized (zzail)
    {
      if (mStarted)
      {
        zzkh.zzcw("Content hash thread already started, quiting...");
        return;
      }
      mStarted = true;
      start();
      return;
    }
  }
  
  boolean zzia()
  {
    try
    {
      Context localContext = zzasi.getContext();
      if (localContext == null) {
        return false;
      }
      Object localObject = (ActivityManager)localContext.getSystemService("activity");
      KeyguardManager localKeyguardManager = (KeyguardManager)localContext.getSystemService("keyguard");
      if ((localObject != null) && (localKeyguardManager != null))
      {
        localObject = ((ActivityManager)localObject).getRunningAppProcesses();
        if (localObject == null) {
          return false;
        }
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject).next();
          if (Process.myPid() == pid) {
            if ((zza(localRunningAppProcessInfo)) && (!localKeyguardManager.inKeyguardRestrictedInputMode()))
            {
              boolean bool = zzj(localContext);
              if (bool) {
                return true;
              }
            }
          }
        }
        return false;
      }
    }
    catch (Throwable localThrowable)
    {
      return false;
    }
    return false;
  }
  
  public zzcl zzib()
  {
    return zzasj.zzhy();
  }
  
  public void zzic()
  {
    synchronized (zzail)
    {
      zzash = true;
      boolean bool = zzash;
      zzkh.zzcw(42 + "ContentFetchThread: paused, mPause = " + bool);
      return;
    }
  }
  
  public boolean zzid()
  {
    return zzash;
  }
  
  boolean zzj(Context paramContext)
  {
    paramContext = (PowerManager)paramContext.getSystemService("power");
    if (paramContext == null) {
      return false;
    }
    return paramContext.isScreenOn();
  }
  
  @zzir
  class zza
  {
    final int zzasv;
    final int zzasw;
    
    zza(int paramInt1, int paramInt2)
    {
      zzasv = paramInt1;
      zzasw = paramInt2;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzco
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */