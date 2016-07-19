package com.google.android.gms.ads.internal.client;

import android.location.Location;
import android.os.Bundle;
import com.google.android.gms.internal.zzir;
import java.util.ArrayList;
import java.util.List;

@zzir
public final class zzf
{
  private Bundle mExtras;
  private boolean zzakp;
  private long zzaua;
  private int zzaub;
  private List<String> zzauc;
  private boolean zzaud;
  private int zzaue;
  private String zzauf;
  private SearchAdRequestParcel zzaug;
  private String zzauh;
  private Bundle zzaui;
  private Bundle zzauj;
  private List<String> zzauk;
  private String zzaul;
  private String zzaum;
  private boolean zzaun;
  private Location zzft;
  
  public zzf()
  {
    zzaua = -1L;
    mExtras = new Bundle();
    zzaub = -1;
    zzauc = new ArrayList();
    zzaud = false;
    zzaue = -1;
    zzakp = false;
    zzauf = null;
    zzaug = null;
    zzft = null;
    zzauh = null;
    zzaui = new Bundle();
    zzauj = new Bundle();
    zzauk = new ArrayList();
    zzaul = null;
    zzaum = null;
    zzaun = false;
  }
  
  public zzf(AdRequestParcel paramAdRequestParcel)
  {
    zzaua = zzatk;
    mExtras = extras;
    zzaub = zzatl;
    zzauc = zzatm;
    zzaud = zzatn;
    zzaue = zzato;
    zzakp = zzatp;
    zzauf = zzatq;
    zzaug = zzatr;
    zzft = zzats;
    zzauh = zzatt;
    zzaui = zzatu;
    zzauj = zzatv;
    zzauk = zzatw;
    zzaul = zzatx;
    zzaum = zzaty;
  }
  
  public zzf zza(Location paramLocation)
  {
    zzft = paramLocation;
    return this;
  }
  
  public zzf zzc(Bundle paramBundle)
  {
    zzaui = paramBundle;
    return this;
  }
  
  public AdRequestParcel zzig()
  {
    return new AdRequestParcel(7, zzaua, mExtras, zzaub, zzauc, zzaud, zzaue, zzakp, zzauf, zzaug, zzft, zzauh, zzaui, zzauj, zzauk, zzaul, zzaum, false);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.client.zzf
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */