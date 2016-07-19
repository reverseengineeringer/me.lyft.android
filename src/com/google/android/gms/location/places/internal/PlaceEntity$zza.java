package com.google.android.gms.location.places.internal;

import android.net.Uri;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import java.util.Collections;
import java.util.List;

public class PlaceEntity$zza
{
  private String MA;
  private LatLng aeg;
  private String aei;
  private Uri aej;
  private float afF;
  private LatLngBounds afG;
  private boolean afI;
  private float afJ;
  private int afK;
  private List<String> afO;
  private List<Integer> afR;
  private String mName;
  private int mVersionCode = 0;
  private String zzbgk;
  
  public zza zza(LatLng paramLatLng)
  {
    aeg = paramLatLng;
    return this;
  }
  
  public zza zza(LatLngBounds paramLatLngBounds)
  {
    afG = paramLatLngBounds;
    return this;
  }
  
  public zza zzaa(List<Integer> paramList)
  {
    afR = paramList;
    return this;
  }
  
  public zza zzab(List<String> paramList)
  {
    afO = paramList;
    return this;
  }
  
  public PlaceEntity zzbow()
  {
    return new PlaceEntity(0, zzbgk, afR, Collections.emptyList(), null, mName, MA, aei, null, afO, aeg, afF, afG, null, aej, afI, afJ, afK, 0L, PlaceLocalization.zza(mName, MA, aei, null, afO));
  }
  
  public zza zzby(boolean paramBoolean)
  {
    afI = paramBoolean;
    return this;
  }
  
  public zza zzg(float paramFloat)
  {
    afF = paramFloat;
    return this;
  }
  
  public zza zzh(float paramFloat)
  {
    afJ = paramFloat;
    return this;
  }
  
  public zza zzkr(String paramString)
  {
    zzbgk = paramString;
    return this;
  }
  
  public zza zzks(String paramString)
  {
    mName = paramString;
    return this;
  }
  
  public zza zzkt(String paramString)
  {
    MA = paramString;
    return this;
  }
  
  public zza zzku(String paramString)
  {
    aei = paramString;
    return this;
  }
  
  public zza zzr(Uri paramUri)
  {
    aej = paramUri;
    return this;
  }
  
  public zza zzua(int paramInt)
  {
    afK = paramInt;
    return this;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.location.places.internal.PlaceEntity.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */