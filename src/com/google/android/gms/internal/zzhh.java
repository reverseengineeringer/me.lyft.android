package com.google.android.gms.internal;

import org.json.JSONException;
import org.json.JSONObject;

@zzir
public class zzhh
{
  private final boolean zzbrb;
  private final boolean zzbrc;
  private final boolean zzbrd;
  private final boolean zzbre;
  private final boolean zzbrf;
  
  private zzhh(zza paramzza)
  {
    zzbrb = zza.zza(paramzza);
    zzbrc = zza.zzb(paramzza);
    zzbrd = zza.zzc(paramzza);
    zzbre = zza.zzd(paramzza);
    zzbrf = zza.zze(paramzza);
  }
  
  public JSONObject toJson()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject().put("sms", zzbrb).put("tel", zzbrc).put("calendar", zzbrd).put("storePicture", zzbre).put("inlineVideo", zzbrf);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      zzkh.zzb("Error occured while obtaining the MRAID capabilities.", localJSONException);
    }
    return null;
  }
  
  public static final class zza
  {
    private boolean zzbrb;
    private boolean zzbrc;
    private boolean zzbrd;
    private boolean zzbre;
    private boolean zzbrf;
    
    public zzhh zzna()
    {
      return new zzhh(this, null);
    }
    
    public zza zzt(boolean paramBoolean)
    {
      zzbrb = paramBoolean;
      return this;
    }
    
    public zza zzu(boolean paramBoolean)
    {
      zzbrc = paramBoolean;
      return this;
    }
    
    public zza zzv(boolean paramBoolean)
    {
      zzbrd = paramBoolean;
      return this;
    }
    
    public zza zzw(boolean paramBoolean)
    {
      zzbre = paramBoolean;
      return this;
    }
    
    public zza zzx(boolean paramBoolean)
    {
      zzbrf = paramBoolean;
      return this;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzhh
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */