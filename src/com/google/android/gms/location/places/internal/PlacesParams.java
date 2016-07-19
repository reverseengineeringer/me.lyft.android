package com.google.android.gms.location.places.internal;

import android.annotation.SuppressLint;
import android.os.Parcel;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.internal.zzaa.zza;
import java.util.Locale;

public class PlacesParams
  extends AbstractSafeParcelable
{
  public static final zzs CREATOR = new zzs();
  public static final PlacesParams agc = new PlacesParams("com.google.android.gms", Locale.getDefault(), null);
  public final String DP;
  public final String afc;
  public final String agd;
  public final String age;
  public final int agf;
  public final int agg;
  public final int versionCode;
  
  public PlacesParams(int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt2, int paramInt3)
  {
    versionCode = paramInt1;
    agd = paramString1;
    age = paramString2;
    DP = paramString3;
    afc = paramString4;
    agf = paramInt2;
    agg = paramInt3;
  }
  
  public PlacesParams(String paramString1, Locale paramLocale, String paramString2)
  {
    this(3, paramString1, paramLocale.toString(), paramString2, null, GoogleApiAvailability.GOOGLE_PLAY_SERVICES_VERSION_CODE, 0);
  }
  
  public PlacesParams(String paramString1, Locale paramLocale, String paramString2, String paramString3, int paramInt)
  {
    this(3, paramString1, paramLocale.toString(), paramString2, paramString3, GoogleApiAvailability.GOOGLE_PLAY_SERVICES_VERSION_CODE, paramInt);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (!(paramObject instanceof PlacesParams))) {
        return false;
      }
      paramObject = (PlacesParams)paramObject;
    } while ((agf == agf) && (agg == agg) && (age.equals(age)) && (agd.equals(agd)) && (zzaa.equal(DP, DP)) && (zzaa.equal(afc, afc)));
    return false;
  }
  
  public int hashCode()
  {
    return zzaa.hashCode(new Object[] { agd, age, DP, afc, Integer.valueOf(agf), Integer.valueOf(agg) });
  }
  
  @SuppressLint({"DefaultLocale"})
  public String toString()
  {
    return zzaa.zzz(this).zzg("clientPackageName", agd).zzg("locale", age).zzg("accountName", DP).zzg("gCoreClientName", afc).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzs.zza(this, paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.location.places.internal.PlacesParams
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */