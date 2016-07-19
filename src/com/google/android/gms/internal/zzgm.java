package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.ads.mediation.AdUrlAdapter;
import com.google.ads.mediation.MediationServerParameters;
import com.google.ads.mediation.NetworkExtras;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.mediation.customevent.CustomEvent;
import com.google.android.gms.ads.mediation.customevent.CustomEventExtras;
import java.util.Map;

@zzir
public final class zzgm
  extends zzgn.zza
{
  private Map<Class<? extends Object>, Object> zzbpk;
  
  private <NETWORK_EXTRAS extends NetworkExtras, SERVER_PARAMETERS extends MediationServerParameters> zzgo zzbp(String paramString)
    throws RemoteException
  {
    try
    {
      Object localObject = Class.forName(paramString, false, zzgm.class.getClassLoader());
      if (com.google.ads.mediation.MediationAdapter.class.isAssignableFrom((Class)localObject))
      {
        localObject = (com.google.ads.mediation.MediationAdapter)((Class)localObject).newInstance();
        return new zzgz((com.google.ads.mediation.MediationAdapter)localObject, (NetworkExtras)zzbpk.get(((com.google.ads.mediation.MediationAdapter)localObject).getAdditionalParametersType()));
      }
      if (com.google.android.gms.ads.mediation.MediationAdapter.class.isAssignableFrom((Class)localObject)) {
        return new zzgu((com.google.android.gms.ads.mediation.MediationAdapter)((Class)localObject).newInstance());
      }
      zzb.zzcy(String.valueOf(paramString).length() + 64 + "Could not instantiate mediation adapter: " + paramString + " (not a valid adapter).");
      throw new RemoteException();
    }
    catch (Throwable localThrowable) {}
    return zzbq(paramString);
  }
  
  private zzgo zzbq(String paramString)
    throws RemoteException
  {
    do
    {
      try
      {
        zzb.zzcw("Reflection failed, retrying using direct instantiation");
        if ("com.google.ads.mediation.admob.AdMobAdapter".equals(paramString)) {
          return new zzgu(new AdMobAdapter());
        }
        if ("com.google.ads.mediation.AdUrlAdapter".equals(paramString))
        {
          zzgu localzzgu = new zzgu(new AdUrlAdapter());
          return localzzgu;
        }
      }
      catch (Throwable localThrowable)
      {
        zzb.zzd(String.valueOf(paramString).length() + 43 + "Could not instantiate mediation adapter: " + paramString + ". ", localThrowable);
        throw new RemoteException();
      }
      if ("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter".equals(paramString)) {
        return new zzgu(new com.google.android.gms.ads.mediation.customevent.CustomEventAdapter());
      }
    } while (!"com.google.ads.mediation.customevent.CustomEventAdapter".equals(paramString));
    Object localObject = new com.google.ads.mediation.customevent.CustomEventAdapter();
    localObject = new zzgz((com.google.ads.mediation.MediationAdapter)localObject, (CustomEventExtras)zzbpk.get(((com.google.ads.mediation.customevent.CustomEventAdapter)localObject).getAdditionalParametersType()));
    return (zzgo)localObject;
  }
  
  public zzgo zzbn(String paramString)
    throws RemoteException
  {
    return zzbp(paramString);
  }
  
  public boolean zzbo(String paramString)
    throws RemoteException
  {
    try
    {
      boolean bool = CustomEvent.class.isAssignableFrom(Class.forName(paramString, false, zzgm.class.getClassLoader()));
      return bool;
    }
    catch (Throwable localThrowable)
    {
      zzb.zzcy(String.valueOf(paramString).length() + 80 + "Could not load custom event implementation class: " + paramString + ", assuming old implementation.");
    }
    return false;
  }
  
  public void zzh(Map<Class<? extends Object>, Object> paramMap)
  {
    zzbpk = paramMap;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzgm
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */