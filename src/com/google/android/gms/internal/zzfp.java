package com.google.android.gms.internal;

import android.location.Location;
import android.os.Bundle;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

@zzir
class zzfp
{
  private final Object[] mParams;
  
  zzfp(AdRequestParcel paramAdRequestParcel, String paramString, int paramInt)
  {
    mParams = zza(paramAdRequestParcel, paramString, paramInt);
  }
  
  private static Object[] zza(AdRequestParcel paramAdRequestParcel, String paramString, int paramInt)
  {
    HashSet localHashSet = new HashSet(Arrays.asList(((String)zzdc.zzbae.get()).split(",")));
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramString);
    if (localHashSet.contains("networkType")) {
      localArrayList.add(Integer.valueOf(paramInt));
    }
    if (localHashSet.contains("birthday")) {
      localArrayList.add(Long.valueOf(zzatk));
    }
    if (localHashSet.contains("extras")) {
      localArrayList.add(zzd(extras));
    }
    if (localHashSet.contains("gender")) {
      localArrayList.add(Integer.valueOf(zzatl));
    }
    if (localHashSet.contains("keywords"))
    {
      if (zzatm != null) {
        localArrayList.add(zzatm.toString());
      }
    }
    else
    {
      if (localHashSet.contains("isTestDevice")) {
        localArrayList.add(Boolean.valueOf(zzatn));
      }
      if (localHashSet.contains("tagForChildDirectedTreatment")) {
        localArrayList.add(Integer.valueOf(zzato));
      }
      if (localHashSet.contains("manualImpressionsEnabled")) {
        localArrayList.add(Boolean.valueOf(zzatp));
      }
      if (localHashSet.contains("publisherProvidedId")) {
        localArrayList.add(zzatq);
      }
      if (localHashSet.contains("location"))
      {
        if (zzats == null) {
          break label447;
        }
        localArrayList.add(zzats.toString());
      }
      label289:
      if (localHashSet.contains("contentUrl")) {
        localArrayList.add(zzatt);
      }
      if (localHashSet.contains("networkExtras")) {
        localArrayList.add(zzd(zzatu));
      }
      if (localHashSet.contains("customTargeting")) {
        localArrayList.add(zzd(zzatv));
      }
      if (localHashSet.contains("categoryExclusions"))
      {
        if (zzatw == null) {
          break label457;
        }
        localArrayList.add(zzatw.toString());
      }
    }
    for (;;)
    {
      if (localHashSet.contains("requestAgent")) {
        localArrayList.add(zzatx);
      }
      if (localHashSet.contains("requestPackage")) {
        localArrayList.add(zzaty);
      }
      return localArrayList.toArray();
      localArrayList.add(null);
      break;
      label447:
      localArrayList.add(null);
      break label289;
      label457:
      localArrayList.add(null);
    }
  }
  
  private static String zzd(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    Collections.sort(new ArrayList(paramBundle.keySet()));
    Iterator localIterator = paramBundle.keySet().iterator();
    if (localIterator.hasNext())
    {
      Object localObject = paramBundle.get((String)localIterator.next());
      if (localObject == null) {
        localObject = "null";
      }
      for (;;)
      {
        localStringBuilder.append((String)localObject);
        break;
        if ((localObject instanceof Bundle)) {
          localObject = zzd((Bundle)localObject);
        } else {
          localObject = localObject.toString();
        }
      }
    }
    return localStringBuilder.toString();
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof zzfp)) {
      return false;
    }
    paramObject = (zzfp)paramObject;
    return Arrays.equals(mParams, mParams);
  }
  
  public int hashCode()
  {
    return Arrays.hashCode(mParams);
  }
  
  public String toString()
  {
    String str = String.valueOf(Arrays.toString(mParams));
    return String.valueOf(str).length() + 24 + "[InterstitialAdPoolKey " + str + "]";
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzfp
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */