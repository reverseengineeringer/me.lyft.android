package com.google.android.gms.ads.internal.formats;

import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.zzq;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.internal.zzas;
import com.google.android.gms.internal.zzcy;
import com.google.android.gms.internal.zzdc;
import com.google.android.gms.internal.zzet;
import com.google.android.gms.internal.zzfx;
import com.google.android.gms.internal.zzil;
import com.google.android.gms.internal.zzil.zza;
import com.google.android.gms.internal.zzir;
import com.google.android.gms.internal.zzkh;
import com.google.android.gms.internal.zzll;
import com.google.android.gms.internal.zzlm;
import com.google.android.gms.internal.zzlm.zza;
import com.google.android.gms.internal.zzln;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

@zzir
public class zzi
  implements zzh
{
  private final Context mContext;
  private final Object zzail = new Object();
  private final VersionInfoParcel zzalm;
  private final zzq zzbgb;
  private final JSONObject zzbge;
  private final zzil zzbgf;
  private final zzh.zza zzbgg;
  private final zzas zzbgh;
  private boolean zzbgi;
  private zzll zzbgj;
  private String zzbgk;
  private String zzbgl;
  private WeakReference<View> zzbgm = null;
  
  public zzi(Context paramContext, zzq paramzzq, zzil paramzzil, zzas paramzzas, JSONObject paramJSONObject, zzh.zza paramzza, VersionInfoParcel paramVersionInfoParcel, String paramString)
  {
    mContext = paramContext;
    zzbgb = paramzzq;
    zzbgf = paramzzil;
    zzbgh = paramzzas;
    zzbge = paramJSONObject;
    zzbgg = paramzza;
    zzalm = paramVersionInfoParcel;
    zzbgl = paramString;
  }
  
  public Context getContext()
  {
    return mContext;
  }
  
  public void recordImpression()
  {
    zzab.zzhj("recordImpression must be called on the main UI thread.");
    zzq(true);
    try
    {
      final JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("ad", zzbge);
      localJSONObject.put("ads_id", zzbgl);
      zzbgf.zza(new zzil.zza()
      {
        public void zze(zzfx paramAnonymouszzfx)
        {
          paramAnonymouszzfx.zza("google.afma.nativeAds.handleImpressionPing", localJSONObject);
        }
      });
      zzbgb.zza(this);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        zzkh.zzb("Unable to create impression JSON.", localJSONException);
      }
    }
  }
  
  public zzb zza(View.OnClickListener paramOnClickListener)
  {
    Object localObject = zzbgg.zzkz();
    if (localObject == null) {
      return null;
    }
    localObject = new zzb(mContext, (zza)localObject);
    ((zzb)localObject).setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    ((zzb)localObject).zzku().setOnClickListener(paramOnClickListener);
    ((zzb)localObject).zzku().setContentDescription("Ad attribution icon");
    return (zzb)localObject;
  }
  
  public void zza(View paramView, Map<String, WeakReference<View>> paramMap, View.OnTouchListener paramOnTouchListener, View.OnClickListener paramOnClickListener)
  {
    if (!((Boolean)zzdc.zzbcg.get()).booleanValue()) {}
    for (;;)
    {
      return;
      paramView.setOnTouchListener(paramOnTouchListener);
      paramView.setClickable(true);
      paramView.setOnClickListener(paramOnClickListener);
      paramView = paramMap.entrySet().iterator();
      while (paramView.hasNext())
      {
        paramMap = (View)((WeakReference)((Map.Entry)paramView.next()).getValue()).get();
        if (paramMap != null)
        {
          paramMap.setOnTouchListener(paramOnTouchListener);
          paramMap.setClickable(true);
          paramMap.setOnClickListener(paramOnClickListener);
        }
      }
    }
  }
  
  public void zza(View paramView, Map<String, WeakReference<View>> paramMap, JSONObject paramJSONObject1, JSONObject paramJSONObject2, JSONObject paramJSONObject3)
  {
    zzab.zzhj("performClick must be called on the main UI thread.");
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      if (paramView.equals((View)((WeakReference)localEntry.getValue()).get())) {
        zza((String)localEntry.getKey(), paramJSONObject1, paramJSONObject2, paramJSONObject3);
      }
    }
    do
    {
      return;
      if ("2".equals(zzbgg.zzky()))
      {
        zza("2099", paramJSONObject1, paramJSONObject2, paramJSONObject3);
        return;
      }
    } while (!"1".equals(zzbgg.zzky()));
    zza("1099", paramJSONObject1, paramJSONObject2, paramJSONObject3);
  }
  
  public void zza(final String paramString, JSONObject paramJSONObject1, JSONObject paramJSONObject2, JSONObject paramJSONObject3)
  {
    zzab.zzhj("performClick must be called on the main UI thread.");
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("asset", paramString);
      localJSONObject.put("template", zzbgg.zzky());
      paramString = new JSONObject();
      paramString.put("ad", zzbge);
      paramString.put("click", localJSONObject);
      if (zzbgb.zzv(zzbgg.getCustomTemplateId()) != null) {}
      for (boolean bool = true;; bool = false)
      {
        paramString.put("has_custom_click_handler", bool);
        if (paramJSONObject1 != null) {
          paramString.put("view_rectangles", paramJSONObject1);
        }
        if (paramJSONObject2 != null) {
          paramString.put("click_point", paramJSONObject2);
        }
        if (paramJSONObject3 != null) {
          paramString.put("native_view_rectangle", paramJSONObject3);
        }
        paramString.put("ads_id", zzbgl);
        zzbgf.zza(new zzil.zza()
        {
          public void zze(zzfx paramAnonymouszzfx)
          {
            paramAnonymouszzfx.zza("google.afma.nativeAds.handleClickGmsg", paramString);
          }
        });
        return;
      }
      return;
    }
    catch (JSONException paramString)
    {
      zzkh.zzb("Unable to create click JSON.", paramString);
    }
  }
  
  public void zzb(MotionEvent paramMotionEvent)
  {
    zzbgh.zza(paramMotionEvent);
  }
  
  public void zzb(View paramView, Map<String, WeakReference<View>> paramMap)
  {
    paramView.setOnTouchListener(null);
    paramView.setClickable(false);
    paramView.setOnClickListener(null);
    paramView = paramMap.entrySet().iterator();
    while (paramView.hasNext())
    {
      paramMap = (View)((WeakReference)((Map.Entry)paramView.next()).getValue()).get();
      if (paramMap != null)
      {
        paramMap.setOnTouchListener(null);
        paramMap.setClickable(false);
        paramMap.setOnClickListener(null);
      }
    }
  }
  
  public void zzg(View paramView)
  {
    synchronized (zzail)
    {
      if (zzbgi) {
        return;
      }
      if (!paramView.isShown()) {
        return;
      }
    }
    if (!paramView.getGlobalVisibleRect(new Rect(), null)) {
      return;
    }
    recordImpression();
  }
  
  public void zzh(View paramView)
  {
    zzbgm = new WeakReference(paramView);
  }
  
  public zzll zzld()
  {
    zzbgj = zzlf();
    zzbgj.getView().setVisibility(8);
    zzil.zza local3 = new zzil.zza()
    {
      public void zze(final zzfx paramAnonymouszzfx)
      {
        paramAnonymouszzfx.zza("/loadHtml", new zzet()
        {
          public void zza(zzll paramAnonymous2zzll, final Map<String, String> paramAnonymous2Map)
          {
            zzi.zzb(zzi.this).zzuk().zza(new zzlm.zza()
            {
              public void zza(zzll paramAnonymous3zzll, boolean paramAnonymous3Boolean)
              {
                zzi.zza(zzi.this, (String)paramAnonymous2Map.get("id"));
                paramAnonymous3zzll = new JSONObject();
                try
                {
                  paramAnonymous3zzll.put("messageType", "htmlLoaded");
                  paramAnonymous3zzll.put("id", zzi.zza(zzi.this));
                  zzbgp.zzb("sendMessageToNativeJs", paramAnonymous3zzll);
                  return;
                }
                catch (JSONException paramAnonymous3zzll)
                {
                  zzkh.zzb("Unable to dispatch sendMessageToNativeJs event", paramAnonymous3zzll);
                }
              }
            });
            paramAnonymous2zzll = (String)paramAnonymous2Map.get("overlayHtml");
            paramAnonymous2Map = (String)paramAnonymous2Map.get("baseUrl");
            if (TextUtils.isEmpty(paramAnonymous2Map))
            {
              zzi.zzb(zzi.this).loadData(paramAnonymous2zzll, "text/html", "UTF-8");
              return;
            }
            zzi.zzb(zzi.this).loadDataWithBaseURL(paramAnonymous2Map, paramAnonymous2zzll, "text/html", "UTF-8", null);
          }
        });
        paramAnonymouszzfx.zza("/showOverlay", new zzet()
        {
          public void zza(zzll paramAnonymous2zzll, Map<String, String> paramAnonymous2Map)
          {
            zzi.zzb(zzi.this).getView().setVisibility(0);
          }
        });
        paramAnonymouszzfx.zza("/hideOverlay", new zzet()
        {
          public void zza(zzll paramAnonymous2zzll, Map<String, String> paramAnonymous2Map)
          {
            zzi.zzb(zzi.this).getView().setVisibility(8);
          }
        });
        zzi.zzb(zzi.this).zzuk().zza("/hideOverlay", new zzet()
        {
          public void zza(zzll paramAnonymous2zzll, Map<String, String> paramAnonymous2Map)
          {
            zzi.zzb(zzi.this).getView().setVisibility(8);
          }
        });
        zzi.zzb(zzi.this).zzuk().zza("/sendMessageToSdk", new zzet()
        {
          public void zza(zzll paramAnonymous2zzll, Map<String, String> paramAnonymous2Map)
          {
            paramAnonymous2zzll = new JSONObject();
            try
            {
              Iterator localIterator = paramAnonymous2Map.keySet().iterator();
              while (localIterator.hasNext())
              {
                String str = (String)localIterator.next();
                paramAnonymous2zzll.put(str, paramAnonymous2Map.get(str));
              }
              paramAnonymous2zzll.put("id", zzi.zza(zzi.this));
            }
            catch (JSONException paramAnonymous2zzll)
            {
              zzkh.zzb("Unable to dispatch sendMessageToNativeJs event", paramAnonymous2zzll);
              return;
            }
            paramAnonymouszzfx.zzb("sendMessageToNativeJs", paramAnonymous2zzll);
          }
        });
      }
    };
    zzbgf.zza(local3);
    return zzbgj;
  }
  
  public View zzle()
  {
    if (zzbgm != null) {
      return (View)zzbgm.get();
    }
    return null;
  }
  
  zzll zzlf()
  {
    return zzu.zzfr().zza(mContext, AdSizeParcel.zzk(mContext), false, false, zzbgh, zzalm);
  }
  
  protected void zzq(boolean paramBoolean)
  {
    zzbgi = paramBoolean;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.formats.zzi
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */