package com.google.android.gms.ads.internal.formats;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import com.google.android.gms.internal.zzir;
import java.lang.ref.WeakReference;
import java.util.Map;
import org.json.JSONObject;

@zzir
public abstract interface zzh
{
  public abstract Context getContext();
  
  public abstract void recordImpression();
  
  public abstract void zza(View paramView, Map<String, WeakReference<View>> paramMap, JSONObject paramJSONObject1, JSONObject paramJSONObject2, JSONObject paramJSONObject3);
  
  public abstract void zza(String paramString, JSONObject paramJSONObject1, JSONObject paramJSONObject2, JSONObject paramJSONObject3);
  
  public abstract void zzb(MotionEvent paramMotionEvent);
  
  public abstract void zzb(View paramView, Map<String, WeakReference<View>> paramMap);
  
  public abstract void zzg(View paramView);
  
  public abstract void zzh(View paramView);
  
  public abstract View zzle();
  
  public static abstract interface zza
  {
    public abstract String getCustomTemplateId();
    
    public abstract void zzb(zzh paramzzh);
    
    public abstract String zzky();
    
    public abstract zza zzkz();
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.formats.zzh
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */