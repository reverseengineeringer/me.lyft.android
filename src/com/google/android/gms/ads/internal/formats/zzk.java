package com.google.android.gms.ads.internal.formats;

import android.graphics.Point;
import android.graphics.Rect;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.google.android.gms.ads.internal.client.zzm;
import com.google.android.gms.ads.internal.util.client.zza;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.internal.zzcy;
import com.google.android.gms.internal.zzdc;
import com.google.android.gms.internal.zzdw.zza;
import com.google.android.gms.internal.zzir;
import com.google.android.gms.internal.zzkh;
import com.google.android.gms.internal.zzkl;
import com.google.android.gms.internal.zzlg;
import com.google.android.gms.internal.zzll;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

@zzir
public class zzk
  extends zzdw.zza
  implements View.OnClickListener, View.OnTouchListener, ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener
{
  private final Object zzail = new Object();
  private FrameLayout zzaiz;
  private zzh zzbft;
  private final FrameLayout zzbgx;
  private Map<String, WeakReference<View>> zzbgy = new HashMap();
  private zzb zzbgz;
  boolean zzbha = false;
  int zzbhb;
  int zzbhc;
  
  public zzk(FrameLayout paramFrameLayout1, FrameLayout paramFrameLayout2)
  {
    zzbgx = paramFrameLayout1;
    zzaiz = paramFrameLayout2;
    zzu.zzgk().zza(zzbgx, this);
    zzu.zzgk().zza(zzbgx, this);
    zzbgx.setOnTouchListener(this);
    zzbgx.setOnClickListener(this);
  }
  
  public void destroy()
  {
    synchronized (zzail)
    {
      if (zzaiz != null) {
        zzaiz.removeAllViews();
      }
      zzaiz = null;
      zzbgy = null;
      zzbgz = null;
      zzbft = null;
      return;
    }
  }
  
  int getMeasuredHeight()
  {
    return zzbgx.getMeasuredHeight();
  }
  
  int getMeasuredWidth()
  {
    return zzbgx.getMeasuredWidth();
  }
  
  public void onClick(View paramView)
  {
    JSONObject localJSONObject1;
    Object localObject3;
    for (;;)
    {
      synchronized (zzail)
      {
        if (zzbft == null) {
          return;
        }
        localJSONObject1 = new JSONObject();
        localObject3 = zzbgy.entrySet().iterator();
        if (!((Iterator)localObject3).hasNext()) {
          break;
        }
        localObject1 = (Map.Entry)((Iterator)localObject3).next();
        View localView = (View)((WeakReference)((Map.Entry)localObject1).getValue()).get();
        if (localView == null) {
          continue;
        }
        Point localPoint = zzi(localView);
        JSONObject localJSONObject2 = new JSONObject();
        try
        {
          localJSONObject2.put("width", zzx(localView.getWidth()));
          localJSONObject2.put("height", zzx(localView.getHeight()));
          localJSONObject2.put("x", zzx(x));
          localJSONObject2.put("y", zzx(y));
          localJSONObject1.put((String)((Map.Entry)localObject1).getKey(), localJSONObject2);
        }
        catch (JSONException localJSONException2)
        {
          localObject1 = String.valueOf((String)((Map.Entry)localObject1).getKey());
          if (((String)localObject1).length() == 0) {
            break label231;
          }
        }
        localObject1 = "Unable to get view rectangle for view ".concat((String)localObject1);
        zzkh.zzcy((String)localObject1);
      }
      label231:
      localObject1 = new String("Unable to get view rectangle for view ");
    }
    Object localObject1 = new JSONObject();
    try
    {
      ((JSONObject)localObject1).put("x", zzx(zzbhb));
      ((JSONObject)localObject1).put("y", zzx(zzbhc));
      localObject3 = new JSONObject();
    }
    catch (JSONException localJSONException1)
    {
      try
      {
        ((JSONObject)localObject3).put("width", zzx(getMeasuredWidth()));
        ((JSONObject)localObject3).put("height", zzx(getMeasuredHeight()));
        if ((zzbgz != null) && (zzbgz.zzku().equals(paramView)))
        {
          zzbft.zza("1007", localJSONObject1, (JSONObject)localObject1, (JSONObject)localObject3);
          return;
          localJSONException1 = localJSONException1;
          zzkh.zzcy("Unable to get click location");
        }
      }
      catch (JSONException localJSONException3)
      {
        for (;;)
        {
          zzkh.zzcy("Unable to get native ad view bounding box");
          continue;
          zzbft.zza(paramView, zzbgy, localJSONObject1, (JSONObject)localObject1, localJSONException1);
        }
      }
    }
  }
  
  public void onGlobalLayout()
  {
    synchronized (zzail)
    {
      if (zzbha)
      {
        int i = getMeasuredWidth();
        int j = getMeasuredHeight();
        if ((i != 0) && (j != 0) && (zzaiz != null))
        {
          zzaiz.setLayoutParams(new FrameLayout.LayoutParams(i, j));
          zzbha = false;
        }
      }
      if (zzbft != null) {
        zzbft.zzg(zzbgx);
      }
      return;
    }
  }
  
  public void onScrollChanged()
  {
    synchronized (zzail)
    {
      if (zzbft != null) {
        zzbft.zzg(zzbgx);
      }
      return;
    }
  }
  
  public boolean onTouch(View arg1, MotionEvent paramMotionEvent)
  {
    synchronized (zzail)
    {
      if (zzbft == null) {
        return false;
      }
      Point localPoint = zzc(paramMotionEvent);
      zzbhb = x;
      zzbhc = y;
      paramMotionEvent = MotionEvent.obtain(paramMotionEvent);
      paramMotionEvent.setLocation(x, y);
      zzbft.zzb(paramMotionEvent);
      paramMotionEvent.recycle();
      return false;
    }
  }
  
  public zzd zzap(String paramString)
  {
    synchronized (zzail)
    {
      paramString = (WeakReference)zzbgy.get(paramString);
      if (paramString == null)
      {
        paramString = null;
        paramString = zze.zzae(paramString);
        return paramString;
      }
      paramString = (View)paramString.get();
    }
  }
  
  Point zzc(MotionEvent paramMotionEvent)
  {
    int[] arrayOfInt = new int[2];
    zzbgx.getLocationOnScreen(arrayOfInt);
    float f1 = paramMotionEvent.getRawX();
    float f2 = arrayOfInt[0];
    float f3 = paramMotionEvent.getRawY();
    float f4 = arrayOfInt[1];
    return new Point((int)(f1 - f2), (int)(f3 - f4));
  }
  
  zzb zzc(zzi paramzzi)
  {
    return paramzzi.zza(this);
  }
  
  public void zzc(String paramString, zzd paramzzd)
  {
    View localView = (View)zze.zzad(paramzzd);
    paramzzd = zzail;
    if (localView == null) {}
    for (;;)
    {
      try
      {
        zzbgy.remove(paramString);
        return;
      }
      finally {}
      zzbgy.put(paramString, new WeakReference(localView));
      localView.setOnTouchListener(this);
      localView.setClickable(true);
      localView.setOnClickListener(this);
    }
  }
  
  public void zze(final zzd paramzzd)
  {
    for (;;)
    {
      synchronized (zzail)
      {
        zzh(null);
        paramzzd = zze.zzad(paramzzd);
        if (!(paramzzd instanceof zzi))
        {
          zzkh.zzcy("Not an instance of native engine. This is most likely a transient error");
          return;
        }
        if (zzaiz != null)
        {
          zzaiz.setLayoutParams(new FrameLayout.LayoutParams(0, 0));
          zzbgx.requestLayout();
        }
        zzbha = true;
        paramzzd = (zzi)paramzzd;
        if ((zzbft != null) && (((Boolean)zzdc.zzbcf.get()).booleanValue())) {
          zzbft.zzb(zzbgx, zzbgy);
        }
        if (((zzbft instanceof zzg)) && (((zzg)zzbft).zzlb()))
        {
          ((zzg)zzbft).zzc(paramzzd);
          if (((Boolean)zzdc.zzbcf.get()).booleanValue()) {
            zzaiz.setClickable(false);
          }
          zzaiz.removeAllViews();
          zzbgz = zzc(paramzzd);
          if (zzbgz != null)
          {
            zzbgy.put("1007", new WeakReference(zzbgz.zzku()));
            zzaiz.addView(zzbgz);
          }
          zzkl.zzclg.post(new Runnable()
          {
            public void run()
            {
              zzll localzzll = paramzzd.zzld();
              if ((localzzll != null) && (zzk.zza(zzk.this) != null)) {
                zzk.zza(zzk.this).addView(localzzll.getView());
              }
            }
          });
          paramzzd.zza(zzbgx, zzbgy, this, this);
          zzh(zzbgx);
          return;
        }
      }
      zzbft = paramzzd;
      if ((paramzzd instanceof zzg)) {
        ((zzg)paramzzd).zzc(null);
      }
    }
  }
  
  void zzh(View paramView)
  {
    if (zzbft != null) {
      if (!(zzbft instanceof zzg)) {
        break label40;
      }
    }
    label40:
    for (zzh localzzh = ((zzg)zzbft).zzlc();; localzzh = zzbft)
    {
      if (localzzh != null) {
        localzzh.zzh(paramView);
      }
      return;
    }
  }
  
  Point zzi(View paramView)
  {
    if ((zzbgz != null) && (zzbgz.zzku().equals(paramView)))
    {
      localPoint1 = new Point();
      zzbgx.getGlobalVisibleRect(new Rect(), localPoint1);
      Point localPoint2 = new Point();
      paramView.getGlobalVisibleRect(new Rect(), localPoint2);
      return new Point(x - x, y - y);
    }
    Point localPoint1 = new Point();
    paramView.getGlobalVisibleRect(new Rect(), localPoint1);
    return localPoint1;
  }
  
  int zzx(int paramInt)
  {
    return zzm.zziw().zzb(zzbft.getContext(), paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.formats.zzk
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */