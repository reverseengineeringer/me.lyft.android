package com.google.android.gms.ads.internal;

import android.os.Build.VERSION;
import com.google.android.gms.ads.internal.overlay.zzq;
import com.google.android.gms.ads.internal.overlay.zzr;
import com.google.android.gms.ads.internal.purchase.zzi;
import com.google.android.gms.common.util.zzh;
import com.google.android.gms.internal.zzcz;
import com.google.android.gms.internal.zzda;
import com.google.android.gms.internal.zzdb;
import com.google.android.gms.internal.zzdf;
import com.google.android.gms.internal.zzfg;
import com.google.android.gms.internal.zzfo;
import com.google.android.gms.internal.zzgj;
import com.google.android.gms.internal.zzig;
import com.google.android.gms.internal.zzir;
import com.google.android.gms.internal.zzja;
import com.google.android.gms.internal.zzkb;
import com.google.android.gms.internal.zzkl;
import com.google.android.gms.internal.zzkm;
import com.google.android.gms.internal.zzks;
import com.google.android.gms.internal.zzkt;
import com.google.android.gms.internal.zzlg;
import com.google.android.gms.internal.zzln;

@zzir
public class zzu
{
  private static final Object zzamp = new Object();
  private static zzu zzanr;
  private final com.google.android.gms.ads.internal.request.zza zzans = new com.google.android.gms.ads.internal.request.zza();
  private final com.google.android.gms.ads.internal.overlay.zza zzant = new com.google.android.gms.ads.internal.overlay.zza();
  private final com.google.android.gms.ads.internal.overlay.zze zzanu = new com.google.android.gms.ads.internal.overlay.zze();
  private final zzig zzanv = new zzig();
  private final zzkl zzanw = new zzkl();
  private final zzln zzanx = new zzln();
  private final zzkm zzany = zzkm.zzay(Build.VERSION.SDK_INT);
  private final zzkb zzanz = new zzkb(zzanw);
  private final com.google.android.gms.common.util.zze zzaoa = new zzh();
  private final zzdf zzaob = new zzdf();
  private final zzja zzaoc = new zzja();
  private final zzda zzaod = new zzda();
  private final zzcz zzaoe = new zzcz();
  private final zzdb zzaof = new zzdb();
  private final zzi zzaog = new zzi();
  private final zzfo zzaoh = new zzfo();
  private final zzks zzaoi = new zzks();
  private final zzq zzaoj = new zzq();
  private final zzr zzaok = new zzr();
  private final zzgj zzaol = new zzgj();
  private final zzkt zzaom = new zzkt();
  private final zzg zzaon = new zzg();
  private final zzp zzaoo = new zzp();
  private final zzfg zzaop = new zzfg();
  private final zzlg zzaoq = new zzlg();
  
  static
  {
    zza(new zzu());
  }
  
  protected static void zza(zzu paramzzu)
  {
    synchronized (zzamp)
    {
      zzanr = paramzzu;
      return;
    }
  }
  
  private static zzu zzfl()
  {
    synchronized (zzamp)
    {
      zzu localzzu = zzanr;
      return localzzu;
    }
  }
  
  public static com.google.android.gms.ads.internal.request.zza zzfm()
  {
    return zzflzzans;
  }
  
  public static com.google.android.gms.ads.internal.overlay.zza zzfn()
  {
    return zzflzzant;
  }
  
  public static com.google.android.gms.ads.internal.overlay.zze zzfo()
  {
    return zzflzzanu;
  }
  
  public static zzig zzfp()
  {
    return zzflzzanv;
  }
  
  public static zzkl zzfq()
  {
    return zzflzzanw;
  }
  
  public static zzln zzfr()
  {
    return zzflzzanx;
  }
  
  public static zzkm zzfs()
  {
    return zzflzzany;
  }
  
  public static zzkb zzft()
  {
    return zzflzzanz;
  }
  
  public static com.google.android.gms.common.util.zze zzfu()
  {
    return zzflzzaoa;
  }
  
  public static zzdf zzfv()
  {
    return zzflzzaob;
  }
  
  public static zzja zzfw()
  {
    return zzflzzaoc;
  }
  
  public static zzda zzfx()
  {
    return zzflzzaod;
  }
  
  public static zzcz zzfy()
  {
    return zzflzzaoe;
  }
  
  public static zzdb zzfz()
  {
    return zzflzzaof;
  }
  
  public static zzi zzga()
  {
    return zzflzzaog;
  }
  
  public static zzfo zzgb()
  {
    return zzflzzaoh;
  }
  
  public static zzks zzgc()
  {
    return zzflzzaoi;
  }
  
  public static zzq zzgd()
  {
    return zzflzzaoj;
  }
  
  public static zzr zzge()
  {
    return zzflzzaok;
  }
  
  public static zzgj zzgf()
  {
    return zzflzzaol;
  }
  
  public static zzp zzgg()
  {
    return zzflzzaoo;
  }
  
  public static zzkt zzgh()
  {
    return zzflzzaom;
  }
  
  public static zzg zzgi()
  {
    return zzflzzaon;
  }
  
  public static zzfg zzgj()
  {
    return zzflzzaop;
  }
  
  public static zzlg zzgk()
  {
    return zzflzzaoq;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.zzu
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */