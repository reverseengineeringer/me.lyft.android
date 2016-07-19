package com.google.android.gms.ads.internal;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.os.RemoteException;
import android.support.v4.util.SimpleArrayMap;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.widget.ViewSwitcher;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.VideoOptionsParcel;
import com.google.android.gms.ads.internal.client.zzm;
import com.google.android.gms.ads.internal.client.zzp;
import com.google.android.gms.ads.internal.client.zzq;
import com.google.android.gms.ads.internal.client.zzw;
import com.google.android.gms.ads.internal.client.zzy;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.internal.purchase.zzk;
import com.google.android.gms.ads.internal.reward.client.zzd;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zza;
import com.google.android.gms.internal.zzas;
import com.google.android.gms.internal.zzdc;
import com.google.android.gms.internal.zzde;
import com.google.android.gms.internal.zzdo;
import com.google.android.gms.internal.zzee;
import com.google.android.gms.internal.zzef;
import com.google.android.gms.internal.zzeg;
import com.google.android.gms.internal.zzeh;
import com.google.android.gms.internal.zzgo;
import com.google.android.gms.internal.zzhs;
import com.google.android.gms.internal.zzhw;
import com.google.android.gms.internal.zzir;
import com.google.android.gms.internal.zzjy;
import com.google.android.gms.internal.zzjy.zza;
import com.google.android.gms.internal.zzjz;
import com.google.android.gms.internal.zzkb;
import com.google.android.gms.internal.zzke;
import com.google.android.gms.internal.zzkg;
import com.google.android.gms.internal.zzkh;
import com.google.android.gms.internal.zzkn;
import com.google.android.gms.internal.zzko;
import com.google.android.gms.internal.zzkv;
import com.google.android.gms.internal.zzky;
import com.google.android.gms.internal.zzll;
import com.google.android.gms.internal.zzlm;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

@zzir
public final class zzv
  implements ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener
{
  public final Context zzagf;
  boolean zzamc = false;
  final String zzaor;
  public String zzaos;
  final zzas zzaot;
  public final VersionInfoParcel zzaou;
  zza zzaov;
  public zzkg zzaow;
  public zzkn zzaox;
  public AdSizeParcel zzaoy;
  public zzjy zzaoz;
  public zzjy.zza zzapa;
  public zzjz zzapb;
  zzp zzapc;
  zzq zzapd;
  zzw zzape;
  zzy zzapf;
  zzhs zzapg;
  zzhw zzaph;
  zzee zzapi;
  zzef zzapj;
  SimpleArrayMap<String, zzeg> zzapk;
  SimpleArrayMap<String, zzeh> zzapl;
  NativeAdOptionsParcel zzapm;
  VideoOptionsParcel zzapn;
  zzdo zzapo;
  zzd zzapp;
  List<String> zzapq;
  zzk zzapr;
  public zzke zzaps = null;
  View zzapt = null;
  public int zzapu = 0;
  boolean zzapv = false;
  private HashSet<zzjz> zzapw = null;
  private int zzapx = -1;
  private int zzapy = -1;
  private zzkv zzapz;
  private boolean zzaqa = true;
  private boolean zzaqb = true;
  private boolean zzaqc = false;
  
  public zzv(Context paramContext, AdSizeParcel paramAdSizeParcel, String paramString, VersionInfoParcel paramVersionInfoParcel)
  {
    this(paramContext, paramAdSizeParcel, paramString, paramVersionInfoParcel, null);
  }
  
  zzv(Context paramContext, AdSizeParcel paramAdSizeParcel, String paramString, VersionInfoParcel paramVersionInfoParcel, zzas paramzzas)
  {
    zzdc.initialize(paramContext);
    if (zzu.zzft().zzsm() != null)
    {
      List localList = zzdc.zzjy();
      if (zzcno != 0) {
        localList.add(Integer.toString(zzcno));
      }
      zzu.zzft().zzsm().zzc(localList);
    }
    zzaor = UUID.randomUUID().toString();
    if ((zzauq) || (zzaus))
    {
      zzaov = null;
      zzaoy = paramAdSizeParcel;
      zzaos = paramString;
      zzagf = paramContext;
      zzaou = paramVersionInfoParcel;
      if (paramzzas == null) {
        break label246;
      }
    }
    for (;;)
    {
      zzaot = paramzzas;
      zzapz = new zzkv(200L);
      zzapl = new SimpleArrayMap();
      return;
      zzaov = new zza(paramContext, this, this);
      zzaov.setMinimumWidth(widthPixels);
      zzaov.setMinimumHeight(heightPixels);
      zzaov.setVisibility(4);
      break;
      label246:
      paramzzas = new zzas(new zzi(this));
    }
  }
  
  private void zzgs()
  {
    View localView = zzaov.getRootView().findViewById(16908290);
    if (localView == null) {}
    Rect localRect1;
    Rect localRect2;
    do
    {
      return;
      localRect1 = new Rect();
      localRect2 = new Rect();
      zzaov.getGlobalVisibleRect(localRect1);
      localView.getGlobalVisibleRect(localRect2);
      if (top != top) {
        zzaqa = false;
      }
    } while (bottom == bottom);
    zzaqb = false;
  }
  
  private void zzh(boolean paramBoolean)
  {
    boolean bool = true;
    if ((zzaov == null) || (zzaoz == null) || (zzaoz.zzbtq == null)) {}
    while ((paramBoolean) && (!zzapz.tryAcquire())) {
      return;
    }
    Object localObject;
    int i;
    int j;
    if (zzaoz.zzbtq.zzuk().zzho())
    {
      localObject = new int[2];
      zzaov.getLocationOnScreen((int[])localObject);
      i = zzm.zziw().zzb(zzagf, localObject[0]);
      j = zzm.zziw().zzb(zzagf, localObject[1]);
      if ((i != zzapx) || (j != zzapy))
      {
        zzapx = i;
        zzapy = j;
        localObject = zzaoz.zzbtq.zzuk();
        i = zzapx;
        j = zzapy;
        if (paramBoolean) {
          break label174;
        }
      }
    }
    label174:
    for (paramBoolean = bool;; paramBoolean = false)
    {
      ((zzlm)localObject).zza(i, j, paramBoolean);
      zzgs();
      return;
    }
  }
  
  public void destroy()
  {
    zzgr();
    zzapd = null;
    zzape = null;
    zzaph = null;
    zzapg = null;
    zzapo = null;
    zzapf = null;
    zzi(false);
    if (zzaov != null) {
      zzaov.removeAllViews();
    }
    zzgm();
    zzgo();
    zzaoz = null;
  }
  
  public void onGlobalLayout()
  {
    zzh(false);
  }
  
  public void onScrollChanged()
  {
    zzh(true);
    zzaqc = true;
  }
  
  public void zza(HashSet<zzjz> paramHashSet)
  {
    zzapw = paramHashSet;
  }
  
  public HashSet<zzjz> zzgl()
  {
    return zzapw;
  }
  
  public void zzgm()
  {
    if ((zzaoz != null) && (zzaoz.zzbtq != null)) {
      zzaoz.zzbtq.destroy();
    }
  }
  
  public void zzgn()
  {
    if ((zzaoz != null) && (zzaoz.zzbtq != null)) {
      zzaoz.zzbtq.stopLoading();
    }
  }
  
  public void zzgo()
  {
    if ((zzaoz != null) && (zzaoz.zzbos != null)) {}
    try
    {
      zzaoz.zzbos.destroy();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzkh.zzcy("Could not destroy mediation adapter.");
    }
  }
  
  public boolean zzgp()
  {
    return zzapu == 0;
  }
  
  public boolean zzgq()
  {
    return zzapu == 1;
  }
  
  public void zzgr()
  {
    if (zzaov != null) {
      zzaov.zzgr();
    }
  }
  
  public String zzgt()
  {
    if ((zzaqa) && (zzaqb)) {
      return "";
    }
    if (zzaqa)
    {
      if (zzaqc) {
        return "top-scrollable";
      }
      return "top-locked";
    }
    if (zzaqb)
    {
      if (zzaqc) {
        return "bottom-scrollable";
      }
      return "bottom-locked";
    }
    return "";
  }
  
  public void zzgu()
  {
    zzapb.zzl(zzaoz.zzcio);
    zzapb.zzm(zzaoz.zzcip);
    zzapb.zzac(zzaoy.zzauq);
    zzapb.zzad(zzaoz.zzccc);
  }
  
  public void zzi(boolean paramBoolean)
  {
    if (zzapu == 0) {
      zzgn();
    }
    if (zzaow != null) {
      zzaow.cancel();
    }
    if (zzaox != null) {
      zzaox.cancel();
    }
    if (paramBoolean) {
      zzaoz = null;
    }
  }
  
  public static class zza
    extends ViewSwitcher
  {
    private final zzko zzaqd;
    private final zzky zzaqe;
    
    public zza(Context paramContext, ViewTreeObserver.OnGlobalLayoutListener paramOnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener paramOnScrollChangedListener)
    {
      super();
      zzaqd = new zzko(paramContext);
      if ((paramContext instanceof Activity)) {}
      for (zzaqe = new zzky((Activity)paramContext, this, paramOnGlobalLayoutListener, paramOnScrollChangedListener);; zzaqe = new zzky(null, this, paramOnGlobalLayoutListener, paramOnScrollChangedListener))
      {
        zzaqe.zztt();
        return;
      }
    }
    
    protected void onAttachedToWindow()
    {
      super.onAttachedToWindow();
      if (zzaqe != null) {
        zzaqe.onAttachedToWindow();
      }
    }
    
    protected void onDetachedFromWindow()
    {
      super.onDetachedFromWindow();
      if (zzaqe != null) {
        zzaqe.onDetachedFromWindow();
      }
    }
    
    public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
    {
      zzaqd.zze(paramMotionEvent);
      return false;
    }
    
    public void removeAllViews()
    {
      Object localObject = new ArrayList();
      int i = 0;
      while (i < getChildCount())
      {
        View localView = getChildAt(i);
        if ((localView != null) && ((localView instanceof zzll))) {
          ((List)localObject).add((zzll)localView);
        }
        i += 1;
      }
      super.removeAllViews();
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((zzll)((Iterator)localObject).next()).destroy();
      }
    }
    
    public void zzgr()
    {
      zzkh.v("Disable position monitoring on adFrame.");
      if (zzaqe != null) {
        zzaqe.zztu();
      }
    }
    
    public zzko zzgv()
    {
      return zzaqd;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.zzv
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */