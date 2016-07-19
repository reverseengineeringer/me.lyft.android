package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import com.google.android.gms.ads.internal.util.client.zza;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.search.SearchAdRequest;
import com.google.android.gms.internal.zzir;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@zzir
public final class zzad
{
  public static final String DEVICE_ID_EMULATOR = zzm.zziw().zzcv("emulator");
  private final boolean zzakp;
  private final int zzaub;
  private final int zzaue;
  private final String zzauf;
  private final String zzauh;
  private final Bundle zzauj;
  private final String zzaul;
  private final boolean zzaun;
  private final Bundle zzavq;
  private final Map<Class<? extends Object>, Object> zzavr;
  private final SearchAdRequest zzavs;
  private final Set<String> zzavt;
  private final Set<String> zzavu;
  private final Date zzfp;
  private final Set<String> zzfr;
  private final Location zzft;
  
  public zzad(zza paramzza)
  {
    this(paramzza, null);
  }
  
  public zzad(zza paramzza, SearchAdRequest paramSearchAdRequest)
  {
    zzfp = zza.zza(paramzza);
    zzauh = zza.zzb(paramzza);
    zzaub = zza.zzc(paramzza);
    zzfr = Collections.unmodifiableSet(zza.zzd(paramzza));
    zzft = zza.zze(paramzza);
    zzakp = zza.zzf(paramzza);
    zzavq = zza.zzg(paramzza);
    zzavr = Collections.unmodifiableMap(zza.zzh(paramzza));
    zzauf = zza.zzi(paramzza);
    zzaul = zza.zzj(paramzza);
    zzavs = paramSearchAdRequest;
    zzaue = zza.zzk(paramzza);
    zzavt = Collections.unmodifiableSet(zza.zzl(paramzza));
    zzauj = zza.zzm(paramzza);
    zzavu = Collections.unmodifiableSet(zza.zzn(paramzza));
    zzaun = zza.zzo(paramzza);
  }
  
  public Date getBirthday()
  {
    return zzfp;
  }
  
  public String getContentUrl()
  {
    return zzauh;
  }
  
  public Bundle getCustomTargeting()
  {
    return zzauj;
  }
  
  public int getGender()
  {
    return zzaub;
  }
  
  public Set<String> getKeywords()
  {
    return zzfr;
  }
  
  public Location getLocation()
  {
    return zzft;
  }
  
  public boolean getManualImpressionsEnabled()
  {
    return zzakp;
  }
  
  public Bundle getNetworkExtrasBundle(Class<? extends MediationAdapter> paramClass)
  {
    return zzavq.getBundle(paramClass.getName());
  }
  
  public String getPublisherProvidedId()
  {
    return zzauf;
  }
  
  public boolean isDesignedForFamilies()
  {
    return zzaun;
  }
  
  public boolean isTestDevice(Context paramContext)
  {
    return zzavt.contains(zzm.zziw().zzaq(paramContext));
  }
  
  public String zzje()
  {
    return zzaul;
  }
  
  public SearchAdRequest zzjf()
  {
    return zzavs;
  }
  
  public Map<Class<? extends Object>, Object> zzjg()
  {
    return zzavr;
  }
  
  public Bundle zzjh()
  {
    return zzavq;
  }
  
  public int zzji()
  {
    return zzaue;
  }
  
  public Set<String> zzjj()
  {
    return zzavu;
  }
  
  public static final class zza
  {
    private boolean zzakp = false;
    private int zzaub = -1;
    private int zzaue = -1;
    private String zzauf;
    private String zzauh;
    private final Bundle zzauj = new Bundle();
    private String zzaul;
    private boolean zzaun;
    private final Bundle zzavq = new Bundle();
    private final HashSet<String> zzavv = new HashSet();
    private final HashMap<Class<? extends Object>, Object> zzavw = new HashMap();
    private final HashSet<String> zzavx = new HashSet();
    private final HashSet<String> zzavy = new HashSet();
    private Date zzfp;
    private Location zzft;
    
    public void zza(Class<? extends MediationAdapter> paramClass, Bundle paramBundle)
    {
      zzavq.putBundle(paramClass.getName(), paramBundle);
    }
    
    public void zza(Date paramDate)
    {
      zzfp = paramDate;
    }
    
    public void zzaf(String paramString)
    {
      zzavv.add(paramString);
    }
    
    public void zzag(String paramString)
    {
      zzavx.add(paramString);
    }
    
    public void zzah(String paramString)
    {
      zzavx.remove(paramString);
    }
    
    public void zzb(Location paramLocation)
    {
      zzft = paramLocation;
    }
    
    public void zzn(boolean paramBoolean)
    {
      if (paramBoolean) {}
      for (int i = 1;; i = 0)
      {
        zzaue = i;
        return;
      }
    }
    
    public void zzo(boolean paramBoolean)
    {
      zzaun = paramBoolean;
    }
    
    public void zzt(int paramInt)
    {
      zzaub = paramInt;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.client.zzad
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */