package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.common.util.zze;
import com.google.firebase.iid.zzc;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Locale;

class zzt
  extends zzaa
{
  static final Pair<String, Long> alt = new Pair("", Long.valueOf(0L));
  private SharedPreferences al;
  private String alA;
  private boolean alB;
  private long alC;
  private SecureRandom alD;
  public final zzb alE = new zzb("time_before_start", 10000L);
  public final zzb alF = new zzb("session_timeout", 1800000L);
  public final zza alG = new zza("start_new_session", true);
  public final zzb alH = new zzb("last_pause_time", 0L);
  public final zzb alI = new zzb("time_active", 0L);
  public boolean alJ;
  public final zzc alu = new zzc("health_monitor", zzbtb().zzaci(), null);
  public final zzb alv = new zzb("last_upload", 0L);
  public final zzb alw = new zzb("last_upload_attempt", 0L);
  public final zzb alx = new zzb("backoff", 0L);
  public final zzb aly = new zzb("last_delete_stale", 0L);
  public final zzb alz = new zzb("midnight_offset", 0L);
  
  zzt(zzx paramzzx)
  {
    super(paramzzx);
  }
  
  private SecureRandom zzbua()
  {
    zzwu();
    if (alD == null) {
      alD = new SecureRandom();
    }
    return alD;
  }
  
  private SharedPreferences zzbud()
  {
    zzwu();
    zzzg();
    return al;
  }
  
  void setMeasurementEnabled(boolean paramBoolean)
  {
    zzwu();
    zzbsz().zzbty().zzj("Setting measurementEnabled", Boolean.valueOf(paramBoolean));
    SharedPreferences.Editor localEditor = zzbud().edit();
    localEditor.putBoolean("measurement_enabled", paramBoolean);
    localEditor.apply();
  }
  
  String zzbqq()
  {
    zzwu();
    return zzc.zzcwt().getId();
  }
  
  String zzbub()
  {
    byte[] arrayOfByte = new byte[16];
    zzbua().nextBytes(arrayOfByte);
    return String.format(Locale.US, "%032x", new Object[] { new BigInteger(1, arrayOfByte) });
  }
  
  long zzbuc()
  {
    zzzg();
    zzwu();
    long l2 = alz.get();
    long l1 = l2;
    if (l2 == 0L)
    {
      l1 = zzbua().nextInt(86400000) + 1;
      alz.set(l1);
    }
    return l1;
  }
  
  String zzbue()
  {
    zzwu();
    return zzbud().getString("gmp_app_id", null);
  }
  
  Boolean zzbuf()
  {
    zzwu();
    if (!zzbud().contains("use_service")) {
      return null;
    }
    return Boolean.valueOf(zzbud().getBoolean("use_service", false));
  }
  
  void zzbug()
  {
    boolean bool1 = true;
    zzwu();
    zzbsz().zzbty().log("Clearing collection preferences.");
    boolean bool2 = zzbud().contains("measurement_enabled");
    if (bool2) {
      bool1 = zzcb(true);
    }
    SharedPreferences.Editor localEditor = zzbud().edit();
    localEditor.clear();
    localEditor.apply();
    if (bool2) {
      setMeasurementEnabled(bool1);
    }
  }
  
  protected String zzbuh()
  {
    zzwu();
    String str1 = zzbud().getString("previous_os_version", null);
    String str2 = zzbss().zzbtk();
    if ((!TextUtils.isEmpty(str2)) && (!str2.equals(str1)))
    {
      SharedPreferences.Editor localEditor = zzbud().edit();
      localEditor.putString("previous_os_version", str2);
      localEditor.apply();
    }
    return str1;
  }
  
  void zzca(boolean paramBoolean)
  {
    zzwu();
    zzbsz().zzbty().zzj("Setting useService", Boolean.valueOf(paramBoolean));
    SharedPreferences.Editor localEditor = zzbud().edit();
    localEditor.putBoolean("use_service", paramBoolean);
    localEditor.apply();
  }
  
  boolean zzcb(boolean paramBoolean)
  {
    zzwu();
    return zzbud().getBoolean("measurement_enabled", paramBoolean);
  }
  
  Pair<String, Boolean> zzly(String paramString)
  {
    zzwu();
    long l = zzyw().elapsedRealtime();
    if ((alA != null) && (l < alC)) {
      return new Pair(alA, Boolean.valueOf(alB));
    }
    alC = (l + zzbtb().zzlh(paramString));
    AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(true);
    try
    {
      paramString = AdvertisingIdClient.getAdvertisingIdInfo(getContext());
      alA = paramString.getId();
      if (alA == null) {
        alA = "";
      }
      alB = paramString.isLimitAdTrackingEnabled();
    }
    catch (Throwable paramString)
    {
      for (;;)
      {
        zzbsz().zzbtx().zzj("Unable to get advertising id", paramString);
        alA = "";
      }
    }
    AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(false);
    return new Pair(alA, Boolean.valueOf(alB));
  }
  
  String zzlz(String paramString)
  {
    paramString = (String)zzlyfirst;
    MessageDigest localMessageDigest = zzal.zzfb("MD5");
    if (localMessageDigest == null) {
      return null;
    }
    return String.format(Locale.US, "%032X", new Object[] { new BigInteger(1, localMessageDigest.digest(paramString.getBytes())) });
  }
  
  void zzma(String paramString)
  {
    zzwu();
    SharedPreferences.Editor localEditor = zzbud().edit();
    localEditor.putString("gmp_app_id", paramString);
    localEditor.apply();
  }
  
  protected void zzwv()
  {
    al = getContext().getSharedPreferences("com.google.android.gms.measurement.prefs", 0);
    alJ = al.getBoolean("has_been_opened", false);
    if (!alJ)
    {
      SharedPreferences.Editor localEditor = al.edit();
      localEditor.putBoolean("has_been_opened", true);
      localEditor.apply();
    }
  }
  
  public final class zza
  {
    private final boolean alK;
    private boolean alL;
    private boolean rD;
    private final String zzaxn;
    
    public zza(String paramString, boolean paramBoolean)
    {
      zzab.zzhs(paramString);
      zzaxn = paramString;
      alK = paramBoolean;
    }
    
    private void zzbui()
    {
      if (alL) {
        return;
      }
      alL = true;
      rD = zzt.zza(zzt.this).getBoolean(zzaxn, alK);
    }
    
    public boolean get()
    {
      zzbui();
      return rD;
    }
    
    public void set(boolean paramBoolean)
    {
      SharedPreferences.Editor localEditor = zzt.zza(zzt.this).edit();
      localEditor.putBoolean(zzaxn, paramBoolean);
      localEditor.apply();
      rD = paramBoolean;
    }
  }
  
  public final class zzb
  {
    private boolean alL;
    private final long alN;
    private final String zzaxn;
    private long zzcvh;
    
    public zzb(String paramString, long paramLong)
    {
      zzab.zzhs(paramString);
      zzaxn = paramString;
      alN = paramLong;
    }
    
    private void zzbui()
    {
      if (alL) {
        return;
      }
      alL = true;
      zzcvh = zzt.zza(zzt.this).getLong(zzaxn, alN);
    }
    
    public long get()
    {
      zzbui();
      return zzcvh;
    }
    
    public void set(long paramLong)
    {
      SharedPreferences.Editor localEditor = zzt.zza(zzt.this).edit();
      localEditor.putLong(zzaxn, paramLong);
      localEditor.apply();
      zzcvh = paramLong;
    }
  }
  
  public final class zzc
  {
    final String alO;
    private final String alP;
    private final String alQ;
    private final long ap;
    
    private zzc(String paramString, long paramLong)
    {
      zzab.zzhs(paramString);
      if (paramLong > 0L) {}
      for (boolean bool = true;; bool = false)
      {
        zzab.zzbn(bool);
        alO = String.valueOf(paramString).concat(":start");
        alP = String.valueOf(paramString).concat(":count");
        alQ = String.valueOf(paramString).concat(":value");
        ap = paramLong;
        return;
      }
    }
    
    private void zzadt()
    {
      zzwu();
      long l = zzyw().currentTimeMillis();
      SharedPreferences.Editor localEditor = zzt.zza(zzt.this).edit();
      localEditor.remove(alP);
      localEditor.remove(alQ);
      localEditor.putLong(alO, l);
      localEditor.apply();
    }
    
    private long zzadu()
    {
      zzwu();
      long l = zzadw();
      if (l == 0L)
      {
        zzadt();
        return 0L;
      }
      return Math.abs(l - zzyw().currentTimeMillis());
    }
    
    private long zzadw()
    {
      return zzt.zzc(zzt.this).getLong(alO, 0L);
    }
    
    public Pair<String, Long> zzadv()
    {
      zzwu();
      long l = zzadu();
      if (l < ap) {
        return null;
      }
      if (l > ap * 2L)
      {
        zzadt();
        return null;
      }
      String str = zzt.zzc(zzt.this).getString(alQ, null);
      l = zzt.zzc(zzt.this).getLong(alP, 0L);
      zzadt();
      if ((str == null) || (l <= 0L)) {
        return zzt.alt;
      }
      return new Pair(str, Long.valueOf(l));
    }
    
    public void zzew(String paramString)
    {
      zzg(paramString, 1L);
    }
    
    public void zzg(String paramString, long paramLong)
    {
      zzwu();
      if (zzadw() == 0L) {
        zzadt();
      }
      String str = paramString;
      if (paramString == null) {
        str = "";
      }
      long l = zzt.zza(zzt.this).getLong(alP, 0L);
      if (l <= 0L)
      {
        paramString = zzt.zza(zzt.this).edit();
        paramString.putString(alQ, str);
        paramString.putLong(alP, paramLong);
        paramString.apply();
        return;
      }
      if ((zzt.zzb(zzt.this).nextLong() & 0x7FFFFFFFFFFFFFFF) < Long.MAX_VALUE / (l + paramLong) * paramLong) {}
      for (int i = 1;; i = 0)
      {
        paramString = zzt.zza(zzt.this).edit();
        if (i != 0) {
          paramString.putString(alQ, str);
        }
        paramString.putLong(alP, l + paramLong);
        paramString.apply();
        return;
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.measurement.internal.zzt
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */