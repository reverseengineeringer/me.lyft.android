package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.internal.util.client.zza;
import com.google.android.gms.ads.search.SearchAdRequest;
import com.google.android.gms.internal.zzir;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Set;

@zzir
public class zzh
{
  public static final zzh zzauo = new zzh();
  
  public static zzh zzih()
  {
    return zzauo;
  }
  
  public AdRequestParcel zza(Context paramContext, zzad paramzzad)
  {
    Object localObject1 = paramzzad.getBirthday();
    long l;
    String str1;
    int i;
    label59:
    boolean bool1;
    int j;
    Location localLocation;
    Bundle localBundle;
    boolean bool2;
    String str2;
    if (localObject1 != null)
    {
      l = ((Date)localObject1).getTime();
      str1 = paramzzad.getContentUrl();
      i = paramzzad.getGender();
      localObject1 = paramzzad.getKeywords();
      if (((Set)localObject1).isEmpty()) {
        break label231;
      }
      localObject1 = Collections.unmodifiableList(new ArrayList((Collection)localObject1));
      bool1 = paramzzad.isTestDevice(paramContext);
      j = paramzzad.zzji();
      localLocation = paramzzad.getLocation();
      localBundle = paramzzad.getNetworkExtrasBundle(AdMobAdapter.class);
      bool2 = paramzzad.getManualImpressionsEnabled();
      str2 = paramzzad.getPublisherProvidedId();
      localObject2 = paramzzad.zzjf();
      if (localObject2 == null) {
        break label237;
      }
    }
    label231:
    label237:
    for (Object localObject2 = new SearchAdRequestParcel((SearchAdRequest)localObject2);; localObject2 = null)
    {
      Object localObject3 = null;
      Context localContext = paramContext.getApplicationContext();
      paramContext = (Context)localObject3;
      if (localContext != null)
      {
        paramContext = localContext.getPackageName();
        paramContext = zzm.zziw().zza(Thread.currentThread().getStackTrace(), paramContext);
      }
      boolean bool3 = paramzzad.isDesignedForFamilies();
      return new AdRequestParcel(7, l, localBundle, i, (List)localObject1, bool1, j, bool2, str2, (SearchAdRequestParcel)localObject2, localLocation, str1, paramzzad.zzjh(), paramzzad.getCustomTargeting(), Collections.unmodifiableList(new ArrayList(paramzzad.zzjj())), paramzzad.zzje(), paramContext, bool3);
      l = -1L;
      break;
      localObject1 = null;
      break label59;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.client.zzh
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */