package com.google.android.gms.internal;

import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.PowerManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.view.WindowManager;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.formats.zzh;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.common.util.zze;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zzir
public abstract class zzcd
  implements ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener
{
  protected final Object zzail = new Object();
  private boolean zzanc = false;
  private zzkv zzapz;
  private final WeakReference<zzjy> zzaqf;
  private WeakReference<ViewTreeObserver> zzaqg;
  private final zzck zzaqh;
  protected final zzcf zzaqi;
  private final Context zzaqj;
  private final WindowManager zzaqk;
  private final PowerManager zzaql;
  private final KeyguardManager zzaqm;
  private zzch zzaqn;
  private boolean zzaqo;
  private boolean zzaqp = false;
  private boolean zzaqq;
  private boolean zzaqr;
  private boolean zzaqs;
  BroadcastReceiver zzaqt;
  private final HashSet<zzce> zzaqu = new HashSet();
  private final zzet zzaqv = new zzet()
  {
    public void zza(zzll paramAnonymouszzll, Map<String, String> paramAnonymousMap)
    {
      if (!zzb(paramAnonymousMap)) {
        return;
      }
      zza(paramAnonymouszzll.getView(), paramAnonymousMap);
    }
  };
  private final zzet zzaqw = new zzet()
  {
    public void zza(zzll paramAnonymouszzll, Map<String, String> paramAnonymousMap)
    {
      if (!zzb(paramAnonymousMap)) {
        return;
      }
      paramAnonymouszzll = String.valueOf(zzaqi.zzhn());
      if (paramAnonymouszzll.length() != 0) {}
      for (paramAnonymouszzll = "Received request to untrack: ".concat(paramAnonymouszzll);; paramAnonymouszzll = new String("Received request to untrack: "))
      {
        zzkh.zzcw(paramAnonymouszzll);
        destroy();
        return;
      }
    }
  };
  private final zzet zzaqx = new zzet()
  {
    public void zza(zzll paramAnonymouszzll, Map<String, String> paramAnonymousMap)
    {
      if (!zzb(paramAnonymousMap)) {}
      while (!paramAnonymousMap.containsKey("isVisible")) {
        return;
      }
      if (("1".equals(paramAnonymousMap.get("isVisible"))) || ("true".equals(paramAnonymousMap.get("isVisible")))) {}
      for (boolean bool = true;; bool = false)
      {
        zzj(Boolean.valueOf(bool).booleanValue());
        return;
      }
    }
  };
  
  public zzcd(Context paramContext, AdSizeParcel paramAdSizeParcel, zzjy paramzzjy, VersionInfoParcel paramVersionInfoParcel, zzck paramzzck)
  {
    zzaqf = new WeakReference(paramzzjy);
    zzaqh = paramzzck;
    zzaqg = new WeakReference(null);
    zzaqq = true;
    zzaqs = false;
    zzapz = new zzkv(200L);
    zzaqi = new zzcf(UUID.randomUUID().toString(), paramVersionInfoParcel, zzaup, zzcii, paramzzjy.zzho(), zzaus);
    zzaqk = ((WindowManager)paramContext.getSystemService("window"));
    zzaql = ((PowerManager)paramContext.getApplicationContext().getSystemService("power"));
    zzaqm = ((KeyguardManager)paramContext.getSystemService("keyguard"));
    zzaqj = paramContext;
  }
  
  protected void destroy()
  {
    synchronized (zzail)
    {
      zzhc();
      zzgx();
      zzaqq = false;
      zzgz();
      return;
    }
  }
  
  boolean isScreenOn()
  {
    return zzaql.isScreenOn();
  }
  
  public void onGlobalLayout()
  {
    zzk(2);
  }
  
  public void onScrollChanged()
  {
    zzk(1);
  }
  
  public void pause()
  {
    synchronized (zzail)
    {
      zzanc = true;
      zzk(3);
      return;
    }
  }
  
  public void resume()
  {
    synchronized (zzail)
    {
      zzanc = false;
      zzk(3);
      return;
    }
  }
  
  public void stop()
  {
    synchronized (zzail)
    {
      zzaqp = true;
      zzk(3);
      return;
    }
  }
  
  protected int zza(int paramInt, DisplayMetrics paramDisplayMetrics)
  {
    float f = density;
    return (int)(paramInt / f);
  }
  
  protected void zza(View paramView, Map<String, String> paramMap)
  {
    zzk(3);
  }
  
  public void zza(zzce paramzzce)
  {
    zzaqu.add(paramzzce);
  }
  
  public void zza(zzch paramzzch)
  {
    synchronized (zzail)
    {
      zzaqn = paramzzch;
      return;
    }
  }
  
  protected void zza(JSONObject paramJSONObject)
  {
    try
    {
      JSONArray localJSONArray = new JSONArray();
      JSONObject localJSONObject = new JSONObject();
      localJSONArray.put(paramJSONObject);
      localJSONObject.put("units", localJSONArray);
      zzb(localJSONObject);
      return;
    }
    catch (Throwable paramJSONObject)
    {
      zzkh.zzb("Skipping active view message.", paramJSONObject);
    }
  }
  
  protected abstract void zzb(JSONObject paramJSONObject);
  
  protected boolean zzb(Map<String, String> paramMap)
  {
    if (paramMap == null) {
      return false;
    }
    paramMap = (String)paramMap.get("hashCode");
    if ((!TextUtils.isEmpty(paramMap)) && (paramMap.equals(zzaqi.zzhn()))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  protected void zzc(zzfx paramzzfx)
  {
    paramzzfx.zza("/updateActiveView", zzaqv);
    paramzzfx.zza("/untrackActiveViewUnit", zzaqw);
    paramzzfx.zza("/visibilityChanged", zzaqx);
  }
  
  protected JSONObject zzd(View paramView)
    throws JSONException
  {
    if (paramView == null) {
      return zzhf();
    }
    boolean bool1 = zzu.zzfs().isAttachedToWindow(paramView);
    Object localObject2 = new int[2];
    Object localObject1 = new int[2];
    try
    {
      paramView.getLocationOnScreen((int[])localObject2);
      paramView.getLocationInWindow((int[])localObject1);
      localObject1 = paramView.getContext().getResources().getDisplayMetrics();
      Rect localRect1 = new Rect();
      left = localObject2[0];
      top = localObject2[1];
      right = (left + paramView.getWidth());
      bottom = (top + paramView.getHeight());
      localObject2 = new Rect();
      right = zzaqk.getDefaultDisplay().getWidth();
      bottom = zzaqk.getDefaultDisplay().getHeight();
      Rect localRect2 = new Rect();
      boolean bool2 = paramView.getGlobalVisibleRect(localRect2, null);
      Rect localRect3 = new Rect();
      boolean bool3 = paramView.getLocalVisibleRect(localRect3);
      Rect localRect4 = new Rect();
      paramView.getHitRect(localRect4);
      JSONObject localJSONObject = zzhd();
      localJSONObject.put("windowVisibility", paramView.getWindowVisibility()).put("isAttachedToWindow", bool1).put("viewBox", new JSONObject().put("top", zza(top, (DisplayMetrics)localObject1)).put("bottom", zza(bottom, (DisplayMetrics)localObject1)).put("left", zza(left, (DisplayMetrics)localObject1)).put("right", zza(right, (DisplayMetrics)localObject1))).put("adBox", new JSONObject().put("top", zza(top, (DisplayMetrics)localObject1)).put("bottom", zza(bottom, (DisplayMetrics)localObject1)).put("left", zza(left, (DisplayMetrics)localObject1)).put("right", zza(right, (DisplayMetrics)localObject1))).put("globalVisibleBox", new JSONObject().put("top", zza(top, (DisplayMetrics)localObject1)).put("bottom", zza(bottom, (DisplayMetrics)localObject1)).put("left", zza(left, (DisplayMetrics)localObject1)).put("right", zza(right, (DisplayMetrics)localObject1))).put("globalVisibleBoxVisible", bool2).put("localVisibleBox", new JSONObject().put("top", zza(top, (DisplayMetrics)localObject1)).put("bottom", zza(bottom, (DisplayMetrics)localObject1)).put("left", zza(left, (DisplayMetrics)localObject1)).put("right", zza(right, (DisplayMetrics)localObject1))).put("localVisibleBoxVisible", bool3).put("hitBox", new JSONObject().put("top", zza(top, (DisplayMetrics)localObject1)).put("bottom", zza(bottom, (DisplayMetrics)localObject1)).put("left", zza(left, (DisplayMetrics)localObject1)).put("right", zza(right, (DisplayMetrics)localObject1))).put("screenDensity", density).put("isVisible", zzu.zzfq().zza(paramView, zzaql, zzaqm));
      return localJSONObject;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        zzkh.zzb("Failure getting view location.", localException);
      }
    }
  }
  
  protected void zzd(zzfx paramzzfx)
  {
    paramzzfx.zzb("/visibilityChanged", zzaqx);
    paramzzfx.zzb("/untrackActiveViewUnit", zzaqw);
    paramzzfx.zzb("/updateActiveView", zzaqv);
  }
  
  protected void zzgw()
  {
    synchronized (zzail)
    {
      if (zzaqt != null) {
        return;
      }
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.intent.action.SCREEN_ON");
      localIntentFilter.addAction("android.intent.action.SCREEN_OFF");
      zzaqt = new BroadcastReceiver()
      {
        public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
        {
          zzk(3);
        }
      };
      zzaqj.registerReceiver(zzaqt, localIntentFilter);
      return;
    }
  }
  
  protected void zzgx()
  {
    synchronized (zzail)
    {
      BroadcastReceiver localBroadcastReceiver = zzaqt;
      if (localBroadcastReceiver == null) {}
    }
    try
    {
      zzaqj.unregisterReceiver(zzaqt);
      zzaqt = null;
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      for (;;)
      {
        zzkh.zzb("Failed trying to unregister the receiver", localIllegalStateException);
      }
      localObject2 = finally;
      throw ((Throwable)localObject2);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        zzu.zzft().zzb(localException, true);
      }
    }
  }
  
  public void zzgy()
  {
    synchronized (zzail)
    {
      if (zzaqq) {
        zzaqr = true;
      }
    }
    try
    {
      zza(zzhg());
      String str1 = String.valueOf(zzaqi.zzhn());
      if (str1.length() != 0)
      {
        str1 = "Untracking ad unit: ".concat(str1);
        zzkh.zzcw(str1);
        return;
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        zzkh.zzb("JSON failure while processing active view data.", localJSONException);
      }
      localObject1 = finally;
      throw ((Throwable)localObject1);
    }
    catch (RuntimeException localRuntimeException)
    {
      for (;;)
      {
        zzkh.zzb("Failure while processing active view data.", localRuntimeException);
        continue;
        String str2 = new String("Untracking ad unit: ");
      }
    }
  }
  
  protected void zzgz()
  {
    if (zzaqn != null) {
      zzaqn.zza(this);
    }
  }
  
  public boolean zzha()
  {
    synchronized (zzail)
    {
      boolean bool = zzaqq;
      return bool;
    }
  }
  
  protected void zzhb()
  {
    Object localObject = zzaqh.zzhj().zzhh();
    if (localObject == null) {}
    ViewTreeObserver localViewTreeObserver;
    do
    {
      return;
      localViewTreeObserver = (ViewTreeObserver)zzaqg.get();
      localObject = ((View)localObject).getViewTreeObserver();
    } while (localObject == localViewTreeObserver);
    zzhc();
    if ((!zzaqo) || ((localViewTreeObserver != null) && (localViewTreeObserver.isAlive())))
    {
      zzaqo = true;
      ((ViewTreeObserver)localObject).addOnScrollChangedListener(this);
      ((ViewTreeObserver)localObject).addOnGlobalLayoutListener(this);
    }
    zzaqg = new WeakReference(localObject);
  }
  
  protected void zzhc()
  {
    ViewTreeObserver localViewTreeObserver = (ViewTreeObserver)zzaqg.get();
    if ((localViewTreeObserver == null) || (!localViewTreeObserver.isAlive())) {
      return;
    }
    localViewTreeObserver.removeOnScrollChangedListener(this);
    localViewTreeObserver.removeGlobalOnLayoutListener(this);
  }
  
  protected JSONObject zzhd()
    throws JSONException
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("afmaVersion", zzaqi.zzhl()).put("activeViewJSON", zzaqi.zzhm()).put("timestamp", zzu.zzfu().elapsedRealtime()).put("adFormat", zzaqi.zzhk()).put("hashCode", zzaqi.zzhn()).put("isMraid", zzaqi.zzho()).put("isStopped", zzaqp).put("isPaused", zzanc).put("isScreenOn", isScreenOn()).put("isNative", zzaqi.zzhp());
    return localJSONObject;
  }
  
  protected abstract boolean zzhe();
  
  protected JSONObject zzhf()
    throws JSONException
  {
    return zzhd().put("isAttachedToWindow", false).put("isScreenOn", isScreenOn()).put("isVisible", false);
  }
  
  protected JSONObject zzhg()
    throws JSONException
  {
    JSONObject localJSONObject = zzhd();
    localJSONObject.put("doneReasonCode", "u");
    return localJSONObject;
  }
  
  protected void zzj(boolean paramBoolean)
  {
    Iterator localIterator = zzaqu.iterator();
    while (localIterator.hasNext()) {
      ((zzce)localIterator.next()).zza(this, paramBoolean);
    }
  }
  
  protected void zzk(int paramInt)
  {
    int i = 0;
    boolean bool;
    for (;;)
    {
      synchronized (zzail)
      {
        if ((!zzhe()) || (!zzaqq)) {
          return;
        }
        View localView1 = zzaqh.zzhh();
        if ((localView1 != null) && (zzu.zzfq().zza(localView1, zzaql, zzaqm)) && (localView1.getGlobalVisibleRect(new Rect(), null)))
        {
          bool = true;
          zzaqs = bool;
          if (!zzaqh.zzhi()) {
            break;
          }
          zzgy();
          return;
        }
      }
      bool = false;
    }
    if (paramInt == 1) {
      i = 1;
    }
    if ((i != 0) && (!zzapz.tryAcquire()) && (bool == zzaqs)) {
      return;
    }
    if ((!bool) && (!zzaqs) && (paramInt == 1)) {
      return;
    }
    for (;;)
    {
      try
      {
        zza(zzd(localView2));
        zzhb();
        zzgz();
        return;
      }
      catch (RuntimeException localRuntimeException)
      {
        continue;
      }
      catch (JSONException localJSONException)
      {
        continue;
      }
      zzkh.zza("Active view update failed.", localView2);
    }
  }
  
  public static class zza
    implements zzck
  {
    private WeakReference<zzh> zzaqz;
    
    public zza(zzh paramzzh)
    {
      zzaqz = new WeakReference(paramzzh);
    }
    
    public View zzhh()
    {
      zzh localzzh = (zzh)zzaqz.get();
      if (localzzh != null) {
        return localzzh.zzle();
      }
      return null;
    }
    
    public boolean zzhi()
    {
      return zzaqz.get() == null;
    }
    
    public zzck zzhj()
    {
      return new zzcd.zzb((zzh)zzaqz.get());
    }
  }
  
  public static class zzb
    implements zzck
  {
    private zzh zzara;
    
    public zzb(zzh paramzzh)
    {
      zzara = paramzzh;
    }
    
    public View zzhh()
    {
      return zzara.zzle();
    }
    
    public boolean zzhi()
    {
      return zzara == null;
    }
    
    public zzck zzhj()
    {
      return this;
    }
  }
  
  public static class zzc
    implements zzck
  {
    private final View mView;
    private final zzjy zzarb;
    
    public zzc(View paramView, zzjy paramzzjy)
    {
      mView = paramView;
      zzarb = paramzzjy;
    }
    
    public View zzhh()
    {
      return mView;
    }
    
    public boolean zzhi()
    {
      return (zzarb == null) || (mView == null);
    }
    
    public zzck zzhj()
    {
      return this;
    }
  }
  
  public static class zzd
    implements zzck
  {
    private final WeakReference<View> zzarc;
    private final WeakReference<zzjy> zzard;
    
    public zzd(View paramView, zzjy paramzzjy)
    {
      zzarc = new WeakReference(paramView);
      zzard = new WeakReference(paramzzjy);
    }
    
    public View zzhh()
    {
      return (View)zzarc.get();
    }
    
    public boolean zzhi()
    {
      return (zzarc.get() == null) || (zzard.get() == null);
    }
    
    public zzck zzhj()
    {
      return new zzcd.zzc((View)zzarc.get(), (zzjy)zzard.get());
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzcd
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */