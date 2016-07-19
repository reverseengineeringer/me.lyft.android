package com.google.android.gms.internal;

import com.google.ads.AdRequest.ErrorCode;
import com.google.ads.AdRequest.Gender;
import com.google.ads.AdSize;
import com.google.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.zza;
import java.util.Date;
import java.util.HashSet;

@zzir
public final class zzhb
{
  public static int zza(AdRequest.ErrorCode paramErrorCode)
  {
    switch (1.zzbpx[paramErrorCode.ordinal()])
    {
    default: 
      return 0;
    case 2: 
      return 1;
    case 3: 
      return 2;
    }
    return 3;
  }
  
  public static AdRequest.Gender zzab(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return AdRequest.Gender.UNKNOWN;
    case 2: 
      return AdRequest.Gender.FEMALE;
    }
    return AdRequest.Gender.MALE;
  }
  
  public static AdSize zzc(AdSizeParcel paramAdSizeParcel)
  {
    int i = 0;
    AdSize[] arrayOfAdSize = new AdSize[6];
    arrayOfAdSize[0] = AdSize.SMART_BANNER;
    arrayOfAdSize[1] = AdSize.BANNER;
    arrayOfAdSize[2] = AdSize.IAB_MRECT;
    arrayOfAdSize[3] = AdSize.IAB_BANNER;
    arrayOfAdSize[4] = AdSize.IAB_LEADERBOARD;
    arrayOfAdSize[5] = AdSize.IAB_WIDE_SKYSCRAPER;
    while (i < 6)
    {
      if ((arrayOfAdSize[i].getWidth() == width) && (arrayOfAdSize[i].getHeight() == height)) {
        return arrayOfAdSize[i];
      }
      i += 1;
    }
    return new AdSize(zza.zza(width, height, zzaup));
  }
  
  public static MediationAdRequest zzp(AdRequestParcel paramAdRequestParcel)
  {
    if (zzatm != null) {}
    for (HashSet localHashSet = new HashSet(zzatm);; localHashSet = null) {
      return new MediationAdRequest(new Date(zzatk), zzab(zzatl), localHashSet, zzatn, zzats);
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzhb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */