package com.google.android.gms.location.places;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.internal.zzaa.zza;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.maps.model.LatLng;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class AddPlaceRequest
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<AddPlaceRequest> CREATOR = new zzb();
  private final String MA;
  private final LatLng aeg;
  private final List<Integer> aeh;
  private final String aei;
  private final Uri aej;
  private final String mName;
  final int mVersionCode;
  
  AddPlaceRequest(int paramInt, String paramString1, LatLng paramLatLng, String paramString2, List<Integer> paramList, String paramString3, Uri paramUri)
  {
    mVersionCode = paramInt;
    mName = zzab.zzhs(paramString1);
    aeg = ((LatLng)zzab.zzaa(paramLatLng));
    MA = zzab.zzhs(paramString2);
    aeh = new ArrayList((Collection)zzab.zzaa(paramList));
    if (!aeh.isEmpty()) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      zzab.zzb(bool1, "At least one place type should be provided.");
      if (TextUtils.isEmpty(paramString3))
      {
        bool1 = bool2;
        if (paramUri == null) {}
      }
      else
      {
        bool1 = true;
      }
      zzab.zzb(bool1, "One of phone number or URI should be provided.");
      aei = paramString3;
      aej = paramUri;
      return;
    }
  }
  
  public String getAddress()
  {
    return MA;
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
  
  public Uri getWebsiteUri()
  {
    return aej;
  }
  
  public String toString()
  {
    return zzaa.zzz(this).zzg("name", mName).zzg("latLng", aeg).zzg("address", MA).zzg("placeTypes", aeh).zzg("phoneNumer", aei).zzg("websiteUri", aej).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzb.zza(this, paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.location.places.AddPlaceRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */