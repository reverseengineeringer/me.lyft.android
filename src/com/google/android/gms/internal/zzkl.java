package com.google.android.gms.internal;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.ActivityManager.RunningTaskInfo;
import android.app.AlertDialog.Builder;
import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.media.AudioManager;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Debug;
import android.os.Debug.MemoryInfo;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.os.PowerManager;
import android.os.Process;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.PopupWindow;
import com.google.android.gms.ads.internal.ClientApi;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.zzm;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zza;
import com.google.android.gms.ads.internal.util.client.zza.zza;
import com.google.android.gms.ads.internal.zzo;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.ads.internal.zzu;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.Future;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zzir
public class zzkl
{
  public static final Handler zzclg = new zzki(Looper.getMainLooper());
  private final Object zzail = new Object();
  private String zzbjj;
  private zzfw zzcee;
  private boolean zzclh = true;
  private boolean zzcli = false;
  
  private JSONArray zza(Collection<?> paramCollection)
    throws JSONException
  {
    JSONArray localJSONArray = new JSONArray();
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext()) {
      zza(localJSONArray, paramCollection.next());
    }
    return localJSONArray;
  }
  
  private void zza(JSONArray paramJSONArray, Object paramObject)
    throws JSONException
  {
    if ((paramObject instanceof Bundle))
    {
      paramJSONArray.put(zzh((Bundle)paramObject));
      return;
    }
    if ((paramObject instanceof Map))
    {
      paramJSONArray.put(zzam((Map)paramObject));
      return;
    }
    if ((paramObject instanceof Collection))
    {
      paramJSONArray.put(zza((Collection)paramObject));
      return;
    }
    if ((paramObject instanceof Object[]))
    {
      paramJSONArray.put(zza((Object[])paramObject));
      return;
    }
    paramJSONArray.put(paramObject);
  }
  
  private void zza(JSONObject paramJSONObject, String paramString, Object paramObject)
    throws JSONException
  {
    if ((paramObject instanceof Bundle))
    {
      paramJSONObject.put(paramString, zzh((Bundle)paramObject));
      return;
    }
    if ((paramObject instanceof Map))
    {
      paramJSONObject.put(paramString, zzam((Map)paramObject));
      return;
    }
    if ((paramObject instanceof Collection))
    {
      if (paramString != null) {}
      for (;;)
      {
        paramJSONObject.put(paramString, zza((Collection)paramObject));
        return;
        paramString = "null";
      }
    }
    if ((paramObject instanceof Object[]))
    {
      paramJSONObject.put(paramString, zza(Arrays.asList((Object[])paramObject)));
      return;
    }
    paramJSONObject.put(paramString, paramObject);
  }
  
  private boolean zza(KeyguardManager paramKeyguardManager)
  {
    if (paramKeyguardManager == null) {
      return false;
    }
    return paramKeyguardManager.inKeyguardRestrictedInputMode();
  }
  
  private boolean zza(PowerManager paramPowerManager)
  {
    return (paramPowerManager == null) || (paramPowerManager.isScreenOn());
  }
  
  private JSONObject zzh(Bundle paramBundle)
    throws JSONException
  {
    JSONObject localJSONObject = new JSONObject();
    Iterator localIterator = paramBundle.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      zza(localJSONObject, str, paramBundle.get(str));
    }
    return localJSONObject;
  }
  
  private boolean zzj(Context paramContext)
  {
    paramContext = (PowerManager)paramContext.getSystemService("power");
    if (paramContext == null) {
      return false;
    }
    return paramContext.isScreenOn();
  }
  
  private Bitmap zzl(View paramView)
  {
    try
    {
      int i = paramView.getWidth();
      int j = paramView.getHeight();
      if ((i == 0) || (j == 0))
      {
        zzkh.zzcy("Width or height of view is zero");
        return null;
      }
      Bitmap localBitmap = Bitmap.createBitmap(paramView.getWidth(), paramView.getHeight(), Bitmap.Config.RGB_565);
      Canvas localCanvas = new Canvas(localBitmap);
      paramView.layout(0, 0, i, j);
      paramView.draw(localCanvas);
      return localBitmap;
    }
    catch (RuntimeException paramView)
    {
      zzkh.zzb("Fail to capture the webview", paramView);
    }
    return null;
  }
  
  /* Error */
  private Bitmap zzm(View paramView)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 213	android/view/View:isDrawingCacheEnabled	()Z
    //   4: istore_2
    //   5: aload_1
    //   6: iconst_1
    //   7: invokevirtual 217	android/view/View:setDrawingCacheEnabled	(Z)V
    //   10: aload_1
    //   11: invokevirtual 221	android/view/View:getDrawingCache	()Landroid/graphics/Bitmap;
    //   14: astore_3
    //   15: aload_3
    //   16: ifnull +30 -> 46
    //   19: aload_3
    //   20: invokestatic 224	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;)Landroid/graphics/Bitmap;
    //   23: astore_3
    //   24: aload_1
    //   25: iload_2
    //   26: invokevirtual 217	android/view/View:setDrawingCacheEnabled	(Z)V
    //   29: aload_3
    //   30: areturn
    //   31: astore_1
    //   32: aconst_null
    //   33: astore_3
    //   34: ldc -30
    //   36: aload_1
    //   37: invokestatic 209	com/google/android/gms/internal/zzkh:zzb	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   40: aload_3
    //   41: areturn
    //   42: astore_1
    //   43: goto -9 -> 34
    //   46: aconst_null
    //   47: astore_3
    //   48: goto -24 -> 24
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	51	0	this	zzkl
    //   0	51	1	paramView	View
    //   4	22	2	bool	boolean
    //   14	34	3	localBitmap	Bitmap
    // Exception table:
    //   from	to	target	type
    //   0	15	31	java/lang/RuntimeException
    //   19	24	31	java/lang/RuntimeException
    //   24	29	42	java/lang/RuntimeException
  }
  
  public void runOnUiThread(Runnable paramRunnable)
  {
    if (Looper.getMainLooper().getThread() == Thread.currentThread())
    {
      paramRunnable.run();
      return;
    }
    zzclg.post(paramRunnable);
  }
  
  public DisplayMetrics zza(WindowManager paramWindowManager)
  {
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    paramWindowManager.getDefaultDisplay().getMetrics(localDisplayMetrics);
    return localDisplayMetrics;
  }
  
  public PopupWindow zza(View paramView, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    return new PopupWindow(paramView, paramInt1, paramInt2, paramBoolean);
  }
  
  public String zza(Context paramContext, View paramView, AdSizeParcel paramAdSizeParcel)
  {
    if (!((Boolean)zzdc.zzazv.get()).booleanValue()) {
      return null;
    }
    try
    {
      JSONObject localJSONObject1 = new JSONObject();
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("width", width);
      localJSONObject2.put("height", height);
      localJSONObject1.put("size", localJSONObject2);
      localJSONObject1.put("activity", zzah(paramContext));
      if (!zzauq)
      {
        paramAdSizeParcel = new JSONArray();
        if (paramView != null)
        {
          paramContext = paramView.getParent();
          if (paramContext != null)
          {
            int i = -1;
            if ((paramContext instanceof ViewGroup)) {
              i = ((ViewGroup)paramContext).indexOfChild(paramView);
            }
            paramView = new JSONObject();
            paramView.put("type", paramContext.getClass().getName());
            paramView.put("index_of_child", i);
            paramAdSizeParcel.put(paramView);
          }
          if ((paramContext == null) || (!(paramContext instanceof View))) {
            break label232;
          }
          paramContext = (View)paramContext;
          break label227;
        }
        if (paramAdSizeParcel.length() > 0) {
          localJSONObject1.put("parents", paramAdSizeParcel);
        }
      }
      paramContext = localJSONObject1.toString();
      return paramContext;
    }
    catch (JSONException paramContext)
    {
      zzkh.zzd("Fail to get view hierarchy json", paramContext);
      return null;
    }
    for (;;)
    {
      label227:
      paramView = paramContext;
      break;
      label232:
      paramContext = null;
    }
  }
  
  public String zza(Context paramContext, zzas paramzzas, String paramString)
  {
    if (paramzzas == null) {
      return paramString;
    }
    try
    {
      Uri localUri2 = Uri.parse(paramString);
      Uri localUri1 = localUri2;
      if (paramzzas.zzd(localUri2)) {
        localUri1 = paramzzas.zzb(localUri2, paramContext);
      }
      paramContext = localUri1.toString();
      return paramContext;
    }
    catch (Exception paramContext) {}
    return paramString;
  }
  
  public String zza(zzll paramzzll, String paramString)
  {
    return zza(paramzzll.getContext(), paramzzll.zzum(), paramString);
  }
  
  public String zza(InputStreamReader paramInputStreamReader)
    throws IOException
  {
    StringBuilder localStringBuilder = new StringBuilder(8192);
    char[] arrayOfChar = new char['ࠀ'];
    for (;;)
    {
      int i = paramInputStreamReader.read(arrayOfChar);
      if (i == -1) {
        break;
      }
      localStringBuilder.append(arrayOfChar, 0, i);
    }
    return localStringBuilder.toString();
  }
  
  JSONArray zza(Object[] paramArrayOfObject)
    throws JSONException
  {
    JSONArray localJSONArray = new JSONArray();
    int j = paramArrayOfObject.length;
    int i = 0;
    while (i < j)
    {
      zza(localJSONArray, paramArrayOfObject[i]);
      i += 1;
    }
    return localJSONArray;
  }
  
  public void zza(Activity paramActivity, ViewTreeObserver.OnGlobalLayoutListener paramOnGlobalLayoutListener)
  {
    paramActivity = paramActivity.getWindow();
    if ((paramActivity != null) && (paramActivity.getDecorView() != null) && (paramActivity.getDecorView().getViewTreeObserver() != null)) {
      paramActivity.getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(paramOnGlobalLayoutListener);
    }
  }
  
  public void zza(Activity paramActivity, ViewTreeObserver.OnScrollChangedListener paramOnScrollChangedListener)
  {
    paramActivity = paramActivity.getWindow();
    if ((paramActivity != null) && (paramActivity.getDecorView() != null) && (paramActivity.getDecorView().getViewTreeObserver() != null)) {
      paramActivity.getDecorView().getViewTreeObserver().addOnScrollChangedListener(paramOnScrollChangedListener);
    }
  }
  
  public void zza(Context paramContext, String paramString, WebSettings paramWebSettings)
  {
    paramWebSettings.setUserAgentString(zzh(paramContext, paramString));
  }
  
  public void zza(final Context paramContext, final String paramString1, String paramString2, Bundle paramBundle, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      paramBundle.putString("device", zzu.zzfq().zzth());
      paramBundle.putString("eids", TextUtils.join(",", zzdc.zzjx()));
    }
    zzm.zziw().zza(paramContext, paramString1, paramString2, paramBundle, paramBoolean, new zza.zza()
    {
      public void zzcs(String paramAnonymousString)
      {
        zzu.zzfq().zzc(paramContext, paramString1, paramAnonymousString);
      }
    });
  }
  
  public void zza(Context paramContext, String paramString, List<String> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      Future localFuture = (Future)new zzku(paramContext, paramString, (String)paramList.next()).zzpz();
    }
  }
  
  public void zza(Context paramContext, String paramString, boolean paramBoolean, HttpURLConnection paramHttpURLConnection)
  {
    zza(paramContext, paramString, paramBoolean, paramHttpURLConnection, false);
  }
  
  public void zza(Context paramContext, String paramString, boolean paramBoolean1, HttpURLConnection paramHttpURLConnection, boolean paramBoolean2)
  {
    paramHttpURLConnection.setConnectTimeout(60000);
    paramHttpURLConnection.setInstanceFollowRedirects(paramBoolean1);
    paramHttpURLConnection.setReadTimeout(60000);
    paramHttpURLConnection.setRequestProperty("User-Agent", zzh(paramContext, paramString));
    paramHttpURLConnection.setUseCaches(paramBoolean2);
  }
  
  public void zza(final Context paramContext, final List<String> paramList)
  {
    if (!(paramContext instanceof Activity)) {}
    while (TextUtils.isEmpty(zzaph.zzeu((Activity)paramContext))) {
      return;
    }
    if (paramList == null)
    {
      zzkh.v("Cannot ping urls: empty list.");
      return;
    }
    if (!zzdq.zzo(paramContext))
    {
      zzkh.v("Cannot ping url because custom tabs is not supported");
      return;
    }
    final zzdq localzzdq = new zzdq();
    localzzdq.zza(new zzdq.zza()
    {
      public void zzkn()
      {
        Iterator localIterator = paramList.iterator();
        if (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          Object localObject = String.valueOf(str);
          if (((String)localObject).length() != 0) {}
          for (localObject = "Pinging url: ".concat((String)localObject);; localObject = new String("Pinging url: "))
          {
            zzkh.zzcx((String)localObject);
            localObject = Uri.parse(str);
            localzzdq.mayLaunchUrl((Uri)localObject, null, null);
            break;
          }
        }
        localzzdq.zzd((Activity)paramContext);
      }
      
      public void zzko() {}
    });
    localzzdq.zze((Activity)paramContext);
  }
  
  public void zza(List<String> paramList, String paramString)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      Future localFuture = (Future)new zzku((String)paramList.next(), paramString).zzpz();
    }
  }
  
  public boolean zza(PackageManager paramPackageManager, String paramString1, String paramString2)
  {
    return paramPackageManager.checkPermission(paramString2, paramString1) == 0;
  }
  
  public boolean zza(View paramView, Context paramContext)
  {
    Object localObject2 = null;
    Object localObject1 = paramContext.getApplicationContext();
    if (localObject1 != null) {}
    for (localObject1 = (PowerManager)((Context)localObject1).getSystemService("power");; localObject1 = null)
    {
      Object localObject3 = paramContext.getSystemService("keyguard");
      paramContext = (Context)localObject2;
      if (localObject3 != null)
      {
        paramContext = (Context)localObject2;
        if ((localObject3 instanceof KeyguardManager)) {
          paramContext = (KeyguardManager)localObject3;
        }
      }
      return zza(paramView, (PowerManager)localObject1, paramContext);
    }
  }
  
  public boolean zza(View paramView, PowerManager paramPowerManager, KeyguardManager paramKeyguardManager)
  {
    if ((zzu.zzfq().zztd()) || (!zza(paramKeyguardManager))) {}
    for (int i = 1; (paramView.getVisibility() == 0) && (paramView.isShown()) && (zza(paramPowerManager)) && (i != 0) && ((!((Boolean)zzdc.zzbao.get()).booleanValue()) || (paramView.getLocalVisibleRect(new Rect())) || (paramView.getGlobalVisibleRect(new Rect()))); i = 0) {
      return true;
    }
    return false;
  }
  
  public boolean zza(ClassLoader paramClassLoader, Class<?> paramClass, String paramString)
  {
    try
    {
      boolean bool = paramClass.isAssignableFrom(Class.forName(paramString, false, paramClassLoader));
      return bool;
    }
    catch (Throwable paramClassLoader) {}
    return false;
  }
  
  public boolean zzac(Context paramContext)
  {
    Intent localIntent = new Intent();
    localIntent.setClassName(paramContext, "com.google.android.gms.ads.AdActivity");
    paramContext = paramContext.getPackageManager().resolveActivity(localIntent, 65536);
    if ((paramContext == null) || (activityInfo == null))
    {
      zzkh.zzcy("Could not find com.google.android.gms.ads.AdActivity, please make sure it is declared in AndroidManifest.xml.");
      return false;
    }
    if ((activityInfo.configChanges & 0x10) == 0) {
      zzkh.zzcy(String.format("com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".", new Object[] { "keyboard" }));
    }
    for (boolean bool = false;; bool = true)
    {
      if ((activityInfo.configChanges & 0x20) == 0)
      {
        zzkh.zzcy(String.format("com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".", new Object[] { "keyboardHidden" }));
        bool = false;
      }
      if ((activityInfo.configChanges & 0x80) == 0)
      {
        zzkh.zzcy(String.format("com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".", new Object[] { "orientation" }));
        bool = false;
      }
      if ((activityInfo.configChanges & 0x100) == 0)
      {
        zzkh.zzcy(String.format("com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".", new Object[] { "screenLayout" }));
        bool = false;
      }
      if ((activityInfo.configChanges & 0x200) == 0)
      {
        zzkh.zzcy(String.format("com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".", new Object[] { "uiMode" }));
        bool = false;
      }
      if ((activityInfo.configChanges & 0x400) == 0)
      {
        zzkh.zzcy(String.format("com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".", new Object[] { "screenSize" }));
        bool = false;
      }
      if ((activityInfo.configChanges & 0x800) == 0)
      {
        zzkh.zzcy(String.format("com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".", new Object[] { "smallestScreenSize" }));
        return false;
      }
      return bool;
    }
  }
  
  public boolean zzad(Context paramContext)
  {
    if (zzcli) {
      return false;
    }
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.intent.action.USER_PRESENT");
    localIntentFilter.addAction("android.intent.action.SCREEN_OFF");
    paramContext.getApplicationContext().registerReceiver(new zza(null), localIntentFilter);
    zzcli = true;
    return true;
  }
  
  protected String zzae(Context paramContext)
  {
    return new WebView(paramContext).getSettings().getUserAgentString();
  }
  
  public AlertDialog.Builder zzaf(Context paramContext)
  {
    return new AlertDialog.Builder(paramContext);
  }
  
  public zzcu zzag(Context paramContext)
  {
    return new zzcu(paramContext);
  }
  
  public String zzah(Context paramContext)
  {
    try
    {
      paramContext = (ActivityManager)paramContext.getSystemService("activity");
      if (paramContext == null) {
        return null;
      }
      paramContext = paramContext.getRunningTasks(1);
      if ((paramContext != null) && (!paramContext.isEmpty()))
      {
        paramContext = (ActivityManager.RunningTaskInfo)paramContext.get(0);
        if ((paramContext != null) && (topActivity != null))
        {
          paramContext = topActivity.getClassName();
          return paramContext;
        }
      }
    }
    catch (Exception paramContext) {}
    return null;
  }
  
  public boolean zzai(Context paramContext)
  {
    try
    {
      Object localObject = (ActivityManager)paramContext.getSystemService("activity");
      KeyguardManager localKeyguardManager = (KeyguardManager)paramContext.getSystemService("keyguard");
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
            if ((importance == 100) && (!localKeyguardManager.inKeyguardRestrictedInputMode()))
            {
              boolean bool = zzj(paramContext);
              if (bool) {
                return true;
              }
            }
          }
        }
        return false;
      }
    }
    catch (Throwable paramContext)
    {
      return false;
    }
    return false;
  }
  
  public Bitmap zzaj(Context paramContext)
  {
    if (!(paramContext instanceof Activity)) {
      return null;
    }
    try
    {
      if (((Boolean)zzdc.zzbbz.get()).booleanValue())
      {
        paramContext = ((Activity)paramContext).getWindow();
        if (paramContext != null) {
          return zzm(paramContext.getDecorView().getRootView());
        }
      }
      else
      {
        paramContext = zzl(((Activity)paramContext).getWindow().getDecorView());
      }
    }
    catch (RuntimeException paramContext)
    {
      zzkh.zzb("Fail to capture screen shot", paramContext);
      paramContext = null;
    }
    return paramContext;
  }
  
  public AudioManager zzak(Context paramContext)
  {
    return (AudioManager)paramContext.getSystemService("audio");
  }
  
  public float zzal(Context paramContext)
  {
    paramContext = zzak(paramContext);
    if (paramContext == null) {}
    int i;
    int j;
    do
    {
      return 0.0F;
      i = paramContext.getStreamMaxVolume(3);
      j = paramContext.getStreamVolume(3);
    } while (i == 0);
    return j / i;
  }
  
  public int zzam(Context paramContext)
  {
    paramContext = paramContext.getApplicationInfo();
    if (paramContext == null) {
      return 0;
    }
    return targetSdkVersion;
  }
  
  public JSONObject zzam(Map<String, ?> paramMap)
    throws JSONException
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      Iterator localIterator = paramMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        zza(localJSONObject, str, paramMap.get(str));
      }
      return localJSONObject;
    }
    catch (ClassCastException paramMap)
    {
      paramMap = String.valueOf(paramMap.getMessage());
      if (paramMap.length() != 0) {}
      for (paramMap = "Could not convert map to JSON: ".concat(paramMap);; paramMap = new String("Could not convert map to JSON: ")) {
        throw new JSONException(paramMap);
      }
    }
  }
  
  public boolean zzan(Context paramContext)
  {
    try
    {
      paramContext.getClassLoader().loadClass(ClientApi.class.getName());
      return false;
    }
    catch (ClassNotFoundException paramContext) {}
    return true;
  }
  
  public void zzb(Activity paramActivity, ViewTreeObserver.OnScrollChangedListener paramOnScrollChangedListener)
  {
    paramActivity = paramActivity.getWindow();
    if ((paramActivity != null) && (paramActivity.getDecorView() != null) && (paramActivity.getDecorView().getViewTreeObserver() != null)) {
      paramActivity.getDecorView().getViewTreeObserver().removeOnScrollChangedListener(paramOnScrollChangedListener);
    }
  }
  
  public void zzb(Context paramContext, Intent paramIntent)
  {
    try
    {
      paramContext.startActivity(paramIntent);
      return;
    }
    catch (Throwable localThrowable)
    {
      paramIntent.addFlags(268435456);
      paramContext.startActivity(paramIntent);
    }
  }
  
  public void zzb(Context paramContext, String paramString1, String paramString2, Bundle paramBundle, boolean paramBoolean)
  {
    if (((Boolean)zzdc.zzbas.get()).booleanValue()) {
      zza(paramContext, paramString1, paramString2, paramBundle, paramBoolean);
    }
  }
  
  public zzfw zzc(Context paramContext, VersionInfoParcel paramVersionInfoParcel)
  {
    synchronized (zzail)
    {
      if (zzcee == null)
      {
        Context localContext = paramContext;
        if (paramContext.getApplicationContext() != null) {
          localContext = paramContext.getApplicationContext();
        }
        zzcee = new zzfw(localContext, paramVersionInfoParcel, (String)zzdc.zzaxw.get());
      }
      paramContext = zzcee;
      return paramContext;
    }
  }
  
  public void zzc(Context paramContext, String paramString1, String paramString2)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramString2);
    zza(paramContext, paramString1, localArrayList);
  }
  
  public String zzcp(String paramString)
  {
    return Uri.parse(paramString).buildUpon().query(null).build().toString();
  }
  
  public int zzcq(String paramString)
  {
    try
    {
      int i = Integer.parseInt(paramString);
      return i;
    }
    catch (NumberFormatException paramString)
    {
      paramString = String.valueOf(paramString);
      zzkh.zzcy(String.valueOf(paramString).length() + 22 + "Could not parse value:" + paramString);
    }
    return 0;
  }
  
  public boolean zzcr(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return paramString.matches("([^\\s]+(\\.(?i)(jpg|png|gif|bmp|webp))$)");
  }
  
  public float zzey()
  {
    zzo localzzo = zzu.zzgg().zzex();
    if ((localzzo != null) && (localzzo.zzez())) {
      return localzzo.zzey();
    }
    return 1.0F;
  }
  
  public Map<String, String> zzf(Uri paramUri)
  {
    if (paramUri == null) {
      return null;
    }
    HashMap localHashMap = new HashMap();
    Iterator localIterator = zzu.zzfs().zzg(paramUri).iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localHashMap.put(str, paramUri.getQueryParameter(str));
    }
    return localHashMap;
  }
  
  public boolean zzfa()
  {
    zzo localzzo = zzu.zzgg().zzex();
    if (localzzo != null) {
      return localzzo.zzfa();
    }
    return false;
  }
  
  public String zzh(final Context paramContext, String paramString)
  {
    synchronized (zzail)
    {
      if (zzbjj != null)
      {
        paramContext = zzbjj;
        return paramContext;
      }
    }
    try
    {
      zzbjj = zzu.zzfs().getDefaultUserAgent(paramContext);
      if (TextUtils.isEmpty(zzbjj)) {
        if (!zzm.zziw().zzty())
        {
          zzbjj = null;
          zzclg.post(new Runnable()
          {
            public void run()
            {
              synchronized (zzkl.zza(zzkl.this))
              {
                zzkl.zza(zzkl.this, zzae(paramContext));
                zzkl.zza(zzkl.this).notifyAll();
                return;
              }
            }
          });
          for (;;)
          {
            paramContext = zzbjj;
            if (paramContext != null) {
              break label160;
            }
            try
            {
              zzail.wait();
            }
            catch (InterruptedException paramContext)
            {
              zzbjj = zzte();
              paramContext = String.valueOf(zzbjj);
              if (paramContext.length() == 0) {}
            }
          }
          for (paramContext = "Interrupted, use default user agent: ".concat(paramContext);; paramContext = new String("Interrupted, use default user agent: "))
          {
            zzkh.zzcy(paramContext);
            break;
            paramContext = finally;
            throw paramContext;
          }
        }
      }
      try
      {
        zzbjj = zzae(paramContext);
        label160:
        paramContext = String.valueOf(zzbjj);
        zzbjj = (String.valueOf(paramContext).length() + 11 + String.valueOf(paramString).length() + paramContext + " (Mobile; " + paramString + ")");
        paramContext = zzbjj;
        return paramContext;
      }
      catch (Exception paramContext)
      {
        for (;;)
        {
          zzbjj = zzte();
        }
      }
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  public int[] zzh(Activity paramActivity)
  {
    paramActivity = paramActivity.getWindow();
    if (paramActivity != null)
    {
      paramActivity = paramActivity.findViewById(16908290);
      if (paramActivity != null) {
        return new int[] { paramActivity.getWidth(), paramActivity.getHeight() };
      }
    }
    return zzti();
  }
  
  public int[] zzi(Activity paramActivity)
  {
    int[] arrayOfInt = zzh(paramActivity);
    return new int[] { zzm.zziw().zzb(paramActivity, arrayOfInt[0]), zzm.zziw().zzb(paramActivity, arrayOfInt[1]) };
  }
  
  public int[] zzj(Activity paramActivity)
  {
    paramActivity = paramActivity.getWindow();
    if (paramActivity != null)
    {
      paramActivity = paramActivity.findViewById(16908290);
      if (paramActivity != null) {
        return new int[] { paramActivity.getTop(), paramActivity.getBottom() };
      }
    }
    return zzti();
  }
  
  public Bitmap zzk(View paramView)
  {
    paramView.setDrawingCacheEnabled(true);
    Bitmap localBitmap = Bitmap.createBitmap(paramView.getDrawingCache());
    paramView.setDrawingCacheEnabled(false);
    return localBitmap;
  }
  
  public int[] zzk(Activity paramActivity)
  {
    int[] arrayOfInt = zzj(paramActivity);
    return new int[] { zzm.zziw().zzb(paramActivity, arrayOfInt[0]), zzm.zziw().zzb(paramActivity, arrayOfInt[1]) };
  }
  
  public int zzn(View paramView)
  {
    if (paramView == null) {
      return -1;
    }
    for (ViewParent localViewParent = paramView.getParent(); (localViewParent != null) && (!(localViewParent instanceof AdapterView)); localViewParent = localViewParent.getParent()) {}
    if (localViewParent == null) {
      return -1;
    }
    return ((AdapterView)localViewParent).getPositionForView(paramView);
  }
  
  public boolean zztd()
  {
    return zzclh;
  }
  
  String zzte()
  {
    StringBuffer localStringBuffer = new StringBuffer(256);
    localStringBuffer.append("Mozilla/5.0 (Linux; U; Android");
    if (Build.VERSION.RELEASE != null) {
      localStringBuffer.append(" ").append(Build.VERSION.RELEASE);
    }
    localStringBuffer.append("; ").append(Locale.getDefault());
    if (Build.DEVICE != null)
    {
      localStringBuffer.append("; ").append(Build.DEVICE);
      if (Build.DISPLAY != null) {
        localStringBuffer.append(" Build/").append(Build.DISPLAY);
      }
    }
    localStringBuffer.append(") AppleWebKit/533 Version/4.0 Safari/533");
    return localStringBuffer.toString();
  }
  
  public String zztf()
  {
    return UUID.randomUUID().toString();
  }
  
  public String zztg()
  {
    Object localObject1 = UUID.randomUUID();
    byte[] arrayOfByte1 = BigInteger.valueOf(((UUID)localObject1).getLeastSignificantBits()).toByteArray();
    byte[] arrayOfByte2 = BigInteger.valueOf(((UUID)localObject1).getMostSignificantBits()).toByteArray();
    localObject1 = new BigInteger(1, arrayOfByte1).toString();
    int i = 0;
    while (i < 2)
    {
      try
      {
        Object localObject2 = MessageDigest.getInstance("MD5");
        ((MessageDigest)localObject2).update(arrayOfByte1);
        ((MessageDigest)localObject2).update(arrayOfByte2);
        byte[] arrayOfByte3 = new byte[8];
        System.arraycopy(((MessageDigest)localObject2).digest(), 0, arrayOfByte3, 0, 8);
        localObject2 = new BigInteger(1, arrayOfByte3).toString();
        localObject1 = localObject2;
      }
      catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
      {
        for (;;) {}
      }
      i += 1;
    }
    return (String)localObject1;
  }
  
  public String zzth()
  {
    String str1 = Build.MANUFACTURER;
    String str2 = Build.MODEL;
    if (str2.startsWith(str1)) {
      return str2;
    }
    return String.valueOf(str1).length() + 1 + String.valueOf(str2).length() + str1 + " " + str2;
  }
  
  protected int[] zzti()
  {
    return new int[] { 0, 0 };
  }
  
  public Bundle zztj()
  {
    Bundle localBundle = new Bundle();
    try
    {
      Object localObject = new Debug.MemoryInfo();
      Debug.getMemoryInfo((Debug.MemoryInfo)localObject);
      localBundle.putParcelable("debug_memory_info", (Parcelable)localObject);
      localObject = Runtime.getRuntime();
      localBundle.putLong("runtime_free_memory", ((Runtime)localObject).freeMemory());
      localBundle.putLong("runtime_max_memory", ((Runtime)localObject).maxMemory());
      localBundle.putLong("runtime_total_memory", ((Runtime)localObject).totalMemory());
      return localBundle;
    }
    catch (Exception localException)
    {
      zzkh.zzd("Unable to gather memory stats", localException);
    }
    return localBundle;
  }
  
  private final class zza
    extends BroadcastReceiver
  {
    private zza() {}
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      if ("android.intent.action.USER_PRESENT".equals(paramIntent.getAction())) {
        zzkl.zza(zzkl.this, true);
      }
      while (!"android.intent.action.SCREEN_OFF".equals(paramIntent.getAction())) {
        return;
      }
      zzkl.zza(zzkl.this, false);
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzkl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */