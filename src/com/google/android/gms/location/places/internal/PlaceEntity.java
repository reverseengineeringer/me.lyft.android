package com.google.android.gms.location.places.internal;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.internal.zzaa.zza;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

public final class PlaceEntity
  implements SafeParcelable, Place
{
  public static final zzl CREATOR = new zzl();
  private final String MA;
  private final LatLng aeg;
  private final List<Integer> aeh;
  private final String aei;
  private final Uri aej;
  private final Bundle afD;
  @Deprecated
  private final PlaceLocalization afE;
  private final float afF;
  private final LatLngBounds afG;
  private final String afH;
  private final boolean afI;
  private final float afJ;
  private final int afK;
  private final long afL;
  private final List<Integer> afM;
  private final String afN;
  private final List<String> afO;
  private final Map<Integer, String> afP;
  private final TimeZone afQ;
  private Locale afz;
  private final String mName;
  final int mVersionCode;
  private final String zzbgk;
  
  PlaceEntity(int paramInt1, String paramString1, List<Integer> paramList1, List<Integer> paramList2, Bundle paramBundle, String paramString2, String paramString3, String paramString4, String paramString5, List<String> paramList, LatLng paramLatLng, float paramFloat1, LatLngBounds paramLatLngBounds, String paramString6, Uri paramUri, boolean paramBoolean, float paramFloat2, int paramInt2, long paramLong, PlaceLocalization paramPlaceLocalization)
  {
    mVersionCode = paramInt1;
    zzbgk = paramString1;
    aeh = Collections.unmodifiableList(paramList1);
    afM = paramList2;
    if (paramBundle != null)
    {
      afD = paramBundle;
      mName = paramString2;
      MA = paramString3;
      aei = paramString4;
      afN = paramString5;
      if (paramList == null) {
        break label176;
      }
      label68:
      afO = paramList;
      aeg = paramLatLng;
      afF = paramFloat1;
      afG = paramLatLngBounds;
      if (paramString6 == null) {
        break label184;
      }
    }
    for (;;)
    {
      afH = paramString6;
      aej = paramUri;
      afI = paramBoolean;
      afJ = paramFloat2;
      afK = paramInt2;
      afL = paramLong;
      afP = Collections.unmodifiableMap(new HashMap());
      afQ = null;
      afz = null;
      afE = paramPlaceLocalization;
      return;
      paramBundle = new Bundle();
      break;
      label176:
      paramList = Collections.emptyList();
      break label68;
      label184:
      paramString6 = "UTC";
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof PlaceEntity)) {
        return false;
      }
      paramObject = (PlaceEntity)paramObject;
    } while ((zzbgk.equals(zzbgk)) && (zzaa.equal(afz, afz)) && (afL == afL));
    return false;
  }
  
  public String getAddress()
  {
    return MA;
  }
  
  public String getId()
  {
    return zzbgk;
  }
  
  public LatLng getLatLng()
  {
    return aeg;
  }
  
  public String getName()
  {
    return mName;
  }
  
  public String getPhoneNumber()
  {
    return aei;
  }
  
  public List<Integer> getPlaceTypes()
  {
    return aeh;
  }
  
  public int getPriceLevel()
  {
    return afK;
  }
  
  public float getRating()
  {
    return afJ;
  }
  
  public LatLngBounds getViewport()
  {
    return afG;
  }
  
  public Uri getWebsiteUri()
  {
    return aej;
  }
  
  public int hashCode()
  {
    return zzaa.hashCode(new Object[] { zzbgk, afz, Long.valueOf(afL) });
  }
  
  public void setLocale(Locale paramLocale)
  {
    afz = paramLocale;
  }
  
  @SuppressLint({"DefaultLocale"})
  public String toString()
  {
    return zzaa.zzz(this).zzg("id", zzbgk).zzg("placeTypes", aeh).zzg("locale", afz).zzg("name", mName).zzg("address", MA).zzg("phoneNumber", aei).zzg("latlng", aeg).zzg("viewport", afG).zzg("websiteUri", aej).zzg("isPermanentlyClosed", Boolean.valueOf(afI)).zzg("priceLevel", Integer.valueOf(afK)).zzg("timestampSecs", Long.valueOf(afL)).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzl.zza(this, paramParcel, paramInt);
  }
  
  public List<Integer> zzbom()
  {
    return afM;
  }
  
  public float zzbon()
  {
    return afF;
  }
  
  public String zzboo()
  {
    return afN;
  }
  
  public List<String> zzbop()
  {
    return afO;
  }
  
  public boolean zzboq()
  {
    return afI;
  }
  
  public long zzbor()
  {
    return afL;
  }
  
  public Bundle zzbos()
  {
    return afD;
  }
  
  public String zzbot()
  {
    return afH;
  }
  
  @Deprecated
  public PlaceLocalization zzbou()
  {
    return afE;
  }
  
  public Place zzbov()
  {
    return this;
  }
  
  public static class zza
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
}

/* Location:
 * Qualified Name:     com.google.android.gms.location.places.internal.PlaceEntity
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */