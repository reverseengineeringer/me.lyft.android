package com.google.android.gms.maps;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.internal.zza;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;

public final class StreetViewPanoramaOptions
  implements SafeParcelable
{
  public static final zzb CREATOR = new zzb();
  private Boolean agW;
  private StreetViewPanoramaCamera ahI;
  private String ahJ;
  private LatLng ahK;
  private Integer ahL;
  private Boolean ahM = Boolean.valueOf(true);
  private Boolean ahN = Boolean.valueOf(true);
  private Boolean ahO = Boolean.valueOf(true);
  private Boolean ahc = Boolean.valueOf(true);
  private final int mVersionCode;
  
  public StreetViewPanoramaOptions()
  {
    mVersionCode = 1;
  }
  
  StreetViewPanoramaOptions(int paramInt, StreetViewPanoramaCamera paramStreetViewPanoramaCamera, String paramString, LatLng paramLatLng, Integer paramInteger, byte paramByte1, byte paramByte2, byte paramByte3, byte paramByte4, byte paramByte5)
  {
    mVersionCode = paramInt;
    ahI = paramStreetViewPanoramaCamera;
    ahK = paramLatLng;
    ahL = paramInteger;
    ahJ = paramString;
    ahM = zza.zza(paramByte1);
    ahc = zza.zza(paramByte2);
    ahN = zza.zza(paramByte3);
    ahO = zza.zza(paramByte4);
    agW = zza.zza(paramByte5);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getPanoramaId()
  {
    return ahJ;
  }
  
  public LatLng getPosition()
  {
    return ahK;
  }
  
  public Integer getRadius()
  {
    return ahL;
  }
  
  public StreetViewPanoramaCamera getStreetViewPanoramaCamera()
  {
    return ahI;
  }
  
  int getVersionCode()
  {
    return mVersionCode;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzb.zza(this, paramParcel, paramInt);
  }
  
  byte zzbpj()
  {
    return zza.zze(agW);
  }
  
  byte zzbpn()
  {
    return zza.zze(ahc);
  }
  
  byte zzbpx()
  {
    return zza.zze(ahM);
  }
  
  byte zzbpy()
  {
    return zza.zze(ahN);
  }
  
  byte zzbpz()
  {
    return zza.zze(ahO);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.maps.StreetViewPanoramaOptions
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */