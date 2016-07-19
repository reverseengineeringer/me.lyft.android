package com.google.android.gms.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Parcel;
import android.util.Base64;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.zzg;
import com.google.android.gms.ads.internal.zzl;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.common.util.zze;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Pattern;

@zzir
public class zzfo
{
  private final Map<zzfp, zzfq> zzbks = new HashMap();
  private final LinkedList<zzfp> zzbkt = new LinkedList();
  private zzfl zzbku;
  
  private static void zza(String paramString, zzfp paramzzfp)
  {
    if (zzkh.zzaz(2)) {
      zzkh.v(String.format(paramString, new Object[] { paramzzfp }));
    }
  }
  
  private String[] zzbf(String paramString)
  {
    try
    {
      String[] arrayOfString = paramString.split("\000");
      int i = 0;
      for (;;)
      {
        paramString = arrayOfString;
        if (i >= arrayOfString.length) {
          break;
        }
        arrayOfString[i] = new String(Base64.decode(arrayOfString[i], 0), "UTF-8");
        i += 1;
      }
      return paramString;
    }
    catch (UnsupportedEncodingException paramString)
    {
      paramString = new String[0];
    }
  }
  
  private boolean zzbg(String paramString)
  {
    try
    {
      boolean bool = Pattern.matches((String)zzdc.zzbaj.get(), paramString);
      return bool;
    }
    catch (RuntimeException paramString)
    {
      zzu.zzft().zzb(paramString, true);
    }
    return false;
  }
  
  private static void zzc(Bundle paramBundle, String paramString)
  {
    paramString = paramString.split("/", 2);
    if (paramString.length == 0) {}
    do
    {
      return;
      String str = paramString[0];
      if (paramString.length == 1)
      {
        paramBundle.remove(str);
        return;
      }
      paramBundle = paramBundle.getBundle(str);
    } while (paramBundle == null);
    zzc(paramBundle, paramString[1]);
  }
  
  static Bundle zzi(AdRequestParcel paramAdRequestParcel)
  {
    paramAdRequestParcel = zzatu;
    if (paramAdRequestParcel == null) {
      return null;
    }
    return paramAdRequestParcel.getBundle("com.google.ads.mediation.admob.AdMobAdapter");
  }
  
  static AdRequestParcel zzj(AdRequestParcel paramAdRequestParcel)
  {
    Object localObject = Parcel.obtain();
    paramAdRequestParcel.writeToParcel((Parcel)localObject, 0);
    ((Parcel)localObject).setDataPosition(0);
    AdRequestParcel localAdRequestParcel = (AdRequestParcel)AdRequestParcel.CREATOR.createFromParcel((Parcel)localObject);
    ((Parcel)localObject).recycle();
    localObject = zzi(localAdRequestParcel);
    paramAdRequestParcel = (AdRequestParcel)localObject;
    if (localObject == null)
    {
      paramAdRequestParcel = new Bundle();
      zzatu.putBundle("com.google.ads.mediation.admob.AdMobAdapter", paramAdRequestParcel);
    }
    paramAdRequestParcel.putBoolean("_skipMediation", true);
    return localAdRequestParcel;
  }
  
  static boolean zzk(AdRequestParcel paramAdRequestParcel)
  {
    paramAdRequestParcel = zzatu;
    if (paramAdRequestParcel == null) {}
    do
    {
      return false;
      paramAdRequestParcel = paramAdRequestParcel.getBundle("com.google.ads.mediation.admob.AdMobAdapter");
    } while ((paramAdRequestParcel == null) || (!paramAdRequestParcel.containsKey("_skipMediation")));
    return true;
  }
  
  private static AdRequestParcel zzl(AdRequestParcel paramAdRequestParcel)
  {
    Object localObject = Parcel.obtain();
    paramAdRequestParcel.writeToParcel((Parcel)localObject, 0);
    ((Parcel)localObject).setDataPosition(0);
    paramAdRequestParcel = (AdRequestParcel)AdRequestParcel.CREATOR.createFromParcel((Parcel)localObject);
    ((Parcel)localObject).recycle();
    localObject = ((String)zzdc.zzbaf.get()).split(",");
    int j = localObject.length;
    int i = 0;
    while (i < j)
    {
      String str = localObject[i];
      zzc(zzatu, str);
      i += 1;
    }
    return paramAdRequestParcel;
  }
  
  private String zzlr()
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      Iterator localIterator = zzbkt.iterator();
      while (localIterator.hasNext())
      {
        localStringBuilder.append(Base64.encodeToString(((zzfp)localIterator.next()).toString().getBytes("UTF-8"), 0));
        if (localIterator.hasNext()) {
          localStringBuilder.append("\000");
        }
      }
      str = localUnsupportedEncodingException.toString();
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      return "";
    }
    String str;
    return str;
  }
  
  void flush()
  {
    while (zzbkt.size() > 0)
    {
      zzfp localzzfp = (zzfp)zzbkt.remove();
      zzfq localzzfq = (zzfq)zzbks.get(localzzfp);
      zza("Flushing interstitial queue for %s.", localzzfp);
      while (localzzfq.size() > 0) {
        zzmzzbkz.zzeu();
      }
      zzbks.remove(localzzfp);
    }
  }
  
  void restore()
  {
    if (zzbku == null) {}
    for (;;)
    {
      return;
      Object localObject2 = zzbku.getApplicationContext().getSharedPreferences("com.google.android.gms.ads.internal.interstitial.InterstitialAdPool", 0);
      flush();
      HashMap localHashMap = new HashMap();
      Iterator localIterator = ((SharedPreferences)localObject2).getAll().entrySet().iterator();
      label56:
      Object localObject1;
      if (localIterator.hasNext()) {
        localObject1 = (Map.Entry)localIterator.next();
      }
      try
      {
        if (((String)((Map.Entry)localObject1).getKey()).equals("PoolKeys")) {
          break label56;
        }
        Object localObject3 = new zzfs((String)((Map.Entry)localObject1).getValue());
        localObject1 = new zzfp(zzana, zzall, zzbkx);
        if (zzbks.containsKey(localObject1)) {
          break label56;
        }
        localObject3 = new zzfq(zzana, zzall, zzbkx);
        zzbks.put(localObject1, localObject3);
        localHashMap.put(((zzfp)localObject1).toString(), localObject1);
        zza("Restored interstitial queue for %s.", (zzfp)localObject1);
      }
      catch (IOException localIOException)
      {
        zzkh.zzd("Malformed preferences value for InterstitialAdPool.", localIOException);
        break label56;
        String[] arrayOfString = zzbf(((SharedPreferences)localObject2).getString("PoolKeys", ""));
        int j = arrayOfString.length;
        int i = 0;
        while (i < j)
        {
          localObject2 = (zzfp)localHashMap.get(arrayOfString[i]);
          if (zzbks.containsKey(localObject2)) {
            zzbkt.add(localObject2);
          }
          i += 1;
        }
      }
      catch (ClassCastException localClassCastException)
      {
        for (;;) {}
      }
    }
  }
  
  void save()
  {
    if (zzbku == null) {
      return;
    }
    SharedPreferences.Editor localEditor = zzbku.getApplicationContext().getSharedPreferences("com.google.android.gms.ads.internal.interstitial.InterstitialAdPool", 0).edit();
    localEditor.clear();
    Iterator localIterator = zzbks.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Map.Entry)localIterator.next();
      zzfp localzzfp = (zzfp)((Map.Entry)localObject).getKey();
      localObject = (zzfq)((Map.Entry)localObject).getValue();
      if (((zzfq)localObject).zzlw())
      {
        localObject = new zzfs((zzfq)localObject).zzlz();
        localEditor.putString(localzzfp.toString(), (String)localObject);
        zza("Saved interstitial queue for %s.", localzzfp);
      }
    }
    localEditor.putString("PoolKeys", zzlr());
    localEditor.apply();
  }
  
  zzfq.zza zza(AdRequestParcel paramAdRequestParcel, String paramString)
  {
    if (zzbg(paramString)) {
      return null;
    }
    int i = zziz.zzazzbku.getApplicationContext()).zzro().zzcgt;
    AdRequestParcel localAdRequestParcel = zzl(paramAdRequestParcel);
    zzfp localzzfp = new zzfp(localAdRequestParcel, paramString, i);
    paramAdRequestParcel = (zzfq)zzbks.get(localzzfp);
    if (paramAdRequestParcel == null)
    {
      zza("Interstitial pool created at %s.", localzzfp);
      paramAdRequestParcel = new zzfq(localAdRequestParcel, paramString, i);
      zzbks.put(localzzfp, paramAdRequestParcel);
    }
    for (;;)
    {
      zzbkt.remove(localzzfp);
      zzbkt.add(localzzfp);
      paramAdRequestParcel.zzlv();
      while (zzbkt.size() > ((Integer)zzdc.zzbag.get()).intValue())
      {
        paramString = (zzfp)zzbkt.remove();
        zzfq localzzfq = (zzfq)zzbks.get(paramString);
        zza("Evicting interstitial queue for %s.", paramString);
        while (localzzfq.size() > 0) {
          zzmzzbkz.zzeu();
        }
        zzbks.remove(paramString);
      }
      while (paramAdRequestParcel.size() > 0)
      {
        paramString = paramAdRequestParcel.zzm(localAdRequestParcel);
        if ((zzbld) && (zzu.zzfu().currentTimeMillis() - zzblc > 1000L * ((Integer)zzdc.zzbai.get()).intValue()))
        {
          zza("Expired interstitial at %s.", localzzfp);
        }
        else
        {
          if (zzbla != null) {}
          for (paramAdRequestParcel = " (inline) ";; paramAdRequestParcel = " ")
          {
            zza(String.valueOf(paramAdRequestParcel).length() + 34 + "Pooled interstitial" + paramAdRequestParcel + "returned at %s.", localzzfp);
            return paramString;
          }
        }
      }
      return null;
    }
  }
  
  void zza(zzfl paramzzfl)
  {
    if (zzbku == null)
    {
      zzbku = paramzzfl.zzlp();
      restore();
    }
  }
  
  void zzb(AdRequestParcel paramAdRequestParcel, String paramString)
  {
    if (zzbku == null) {
      return;
    }
    int i = zziz.zzazzbku.getApplicationContext()).zzro().zzcgt;
    AdRequestParcel localAdRequestParcel = zzl(paramAdRequestParcel);
    zzfp localzzfp = new zzfp(localAdRequestParcel, paramString, i);
    zzfq localzzfq2 = (zzfq)zzbks.get(localzzfp);
    zzfq localzzfq1 = localzzfq2;
    if (localzzfq2 == null)
    {
      zza("Interstitial pool created at %s.", localzzfp);
      localzzfq1 = new zzfq(localAdRequestParcel, paramString, i);
      zzbks.put(localzzfp, localzzfq1);
    }
    localzzfq1.zza(zzbku, paramAdRequestParcel);
    localzzfq1.zzlv();
    zza("Inline entry added to the queue at %s.", localzzfp);
  }
  
  void zzlq()
  {
    if (zzbku == null) {
      return;
    }
    Iterator localIterator = zzbks.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Map.Entry)localIterator.next();
      zzfp localzzfp = (zzfp)((Map.Entry)localObject).getKey();
      localObject = (zzfq)((Map.Entry)localObject).getValue();
      if (zzkh.zzaz(2))
      {
        int i = ((zzfq)localObject).size();
        int j = ((zzfq)localObject).zzlt();
        if (j < i) {
          zzkh.v(String.format("Loading %s/%s pooled interstitials for %s.", new Object[] { Integer.valueOf(i - j), Integer.valueOf(i), localzzfp }));
        }
      }
      ((zzfq)localObject).zzlu();
      while (((zzfq)localObject).size() < ((Integer)zzdc.zzbah.get()).intValue())
      {
        zza("Pooling and loading one new interstitial for %s.", localzzfp);
        ((zzfq)localObject).zzb(zzbku);
      }
    }
    save();
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzfo
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */