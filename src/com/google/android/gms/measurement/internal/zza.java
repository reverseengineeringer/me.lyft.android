package com.google.android.gms.measurement.internal;

import android.text.TextUtils;
import com.google.android.gms.common.internal.zzab;

class zza
{
  private String By;
  private final zzx aja;
  private String ajg;
  private String ajh;
  private String aji;
  private long ajj;
  private long ajk;
  private long ajl;
  private long ajm;
  private String ajn;
  private long ajo;
  private long ajp;
  private boolean ajq;
  private long ajr;
  private long ajs;
  private long ajt;
  private long aju;
  private long ajv;
  private boolean ajw;
  private long ajx;
  private long ajy;
  private final String zzcjj;
  private String zzcuq;
  
  zza(zzx paramzzx, String paramString)
  {
    zzab.zzaa(paramzzx);
    zzab.zzhs(paramString);
    aja = paramzzx;
    zzcjj = paramString;
    aja.zzwu();
  }
  
  public void setAppVersion(String paramString)
  {
    aja.zzwu();
    boolean bool2 = ajw;
    if (!zzal.zzbb(zzcuq, paramString)) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      ajw = (bool1 | bool2);
      zzcuq = paramString;
      return;
    }
  }
  
  public void setMeasurementEnabled(boolean paramBoolean)
  {
    aja.zzwu();
    boolean bool2 = ajw;
    if (ajq != paramBoolean) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      ajw = (bool1 | bool2);
      ajq = paramBoolean;
      return;
    }
  }
  
  public void zzat(long paramLong)
  {
    aja.zzwu();
    boolean bool2 = ajw;
    if (ajk != paramLong) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      ajw = (bool1 | bool2);
      ajk = paramLong;
      return;
    }
  }
  
  public void zzau(long paramLong)
  {
    aja.zzwu();
    boolean bool2 = ajw;
    if (ajl != paramLong) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      ajw = (bool1 | bool2);
      ajl = paramLong;
      return;
    }
  }
  
  public void zzav(long paramLong)
  {
    aja.zzwu();
    boolean bool2 = ajw;
    if (ajm != paramLong) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      ajw = (bool1 | bool2);
      ajm = paramLong;
      return;
    }
  }
  
  public void zzaw(long paramLong)
  {
    aja.zzwu();
    boolean bool2 = ajw;
    if (ajo != paramLong) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      ajw = (bool1 | bool2);
      ajo = paramLong;
      return;
    }
  }
  
  public String zzawj()
  {
    aja.zzwu();
    return By;
  }
  
  public void zzax(long paramLong)
  {
    aja.zzwu();
    boolean bool2 = ajw;
    if (ajp != paramLong) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      ajw = (bool1 | bool2);
      ajp = paramLong;
      return;
    }
  }
  
  public void zzay(long paramLong)
  {
    boolean bool1 = true;
    boolean bool2;
    if (paramLong >= 0L)
    {
      bool2 = true;
      zzab.zzbn(bool2);
      aja.zzwu();
      bool2 = ajw;
      if (ajj == paramLong) {
        break label58;
      }
    }
    for (;;)
    {
      ajw = (bool2 | bool1);
      ajj = paramLong;
      return;
      bool2 = false;
      break;
      label58:
      bool1 = false;
    }
  }
  
  public void zzaz(long paramLong)
  {
    aja.zzwu();
    boolean bool2 = ajw;
    if (ajx != paramLong) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      ajw = (bool1 | bool2);
      ajx = paramLong;
      return;
    }
  }
  
  public void zzba(long paramLong)
  {
    aja.zzwu();
    boolean bool2 = ajw;
    if (ajy != paramLong) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      ajw = (bool1 | bool2);
      ajy = paramLong;
      return;
    }
  }
  
  public void zzbb(long paramLong)
  {
    aja.zzwu();
    boolean bool2 = ajw;
    if (ajr != paramLong) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      ajw = (bool1 | bool2);
      ajr = paramLong;
      return;
    }
  }
  
  public void zzbc(long paramLong)
  {
    aja.zzwu();
    boolean bool2 = ajw;
    if (ajs != paramLong) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      ajw = (bool1 | bool2);
      ajs = paramLong;
      return;
    }
  }
  
  public void zzbd(long paramLong)
  {
    aja.zzwu();
    boolean bool2 = ajw;
    if (ajt != paramLong) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      ajw = (bool1 | bool2);
      ajt = paramLong;
      return;
    }
  }
  
  public void zzbe(long paramLong)
  {
    aja.zzwu();
    boolean bool2 = ajw;
    if (aju != paramLong) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      ajw = (bool1 | bool2);
      aju = paramLong;
      return;
    }
  }
  
  public void zzbf(long paramLong)
  {
    aja.zzwu();
    boolean bool2 = ajw;
    if (ajv != paramLong) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      ajw = (bool1 | bool2);
      ajv = paramLong;
      return;
    }
  }
  
  public void zzbqn()
  {
    aja.zzwu();
    ajw = false;
  }
  
  public String zzbqo()
  {
    aja.zzwu();
    return ajg;
  }
  
  public String zzbqp()
  {
    aja.zzwu();
    return ajh;
  }
  
  public String zzbqq()
  {
    aja.zzwu();
    return aji;
  }
  
  public long zzbqr()
  {
    aja.zzwu();
    return ajk;
  }
  
  public long zzbqs()
  {
    aja.zzwu();
    return ajl;
  }
  
  public long zzbqt()
  {
    aja.zzwu();
    return ajm;
  }
  
  public String zzbqu()
  {
    aja.zzwu();
    return ajn;
  }
  
  public long zzbqv()
  {
    aja.zzwu();
    return ajo;
  }
  
  public long zzbqw()
  {
    aja.zzwu();
    return ajp;
  }
  
  public boolean zzbqx()
  {
    aja.zzwu();
    return ajq;
  }
  
  public long zzbqy()
  {
    aja.zzwu();
    return ajj;
  }
  
  public long zzbqz()
  {
    aja.zzwu();
    return ajx;
  }
  
  public long zzbra()
  {
    aja.zzwu();
    return ajy;
  }
  
  public void zzbrb()
  {
    aja.zzwu();
    long l2 = ajj + 1L;
    long l1 = l2;
    if (l2 > 2147483647L)
    {
      aja.zzbsz().zzbtt().log("Bundle index overflow");
      l1 = 0L;
    }
    ajw = true;
    ajj = l1;
  }
  
  public long zzbrc()
  {
    aja.zzwu();
    return ajr;
  }
  
  public long zzbrd()
  {
    aja.zzwu();
    return ajs;
  }
  
  public long zzbre()
  {
    aja.zzwu();
    return ajt;
  }
  
  public long zzbrf()
  {
    aja.zzwu();
    return aju;
  }
  
  public long zzbrg()
  {
    aja.zzwu();
    return ajv;
  }
  
  public void zzkz(String paramString)
  {
    aja.zzwu();
    boolean bool2 = ajw;
    if (!zzal.zzbb(By, paramString)) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      ajw = (bool1 | bool2);
      By = paramString;
      return;
    }
  }
  
  public void zzla(String paramString)
  {
    aja.zzwu();
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = null;
    }
    boolean bool2 = ajw;
    if (!zzal.zzbb(ajg, str)) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      ajw = (bool1 | bool2);
      ajg = str;
      return;
    }
  }
  
  public void zzlb(String paramString)
  {
    aja.zzwu();
    boolean bool2 = ajw;
    if (!zzal.zzbb(ajh, paramString)) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      ajw = (bool1 | bool2);
      ajh = paramString;
      return;
    }
  }
  
  public void zzlc(String paramString)
  {
    aja.zzwu();
    boolean bool2 = ajw;
    if (!zzal.zzbb(aji, paramString)) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      ajw = (bool1 | bool2);
      aji = paramString;
      return;
    }
  }
  
  public void zzld(String paramString)
  {
    aja.zzwu();
    boolean bool2 = ajw;
    if (!zzal.zzbb(ajn, paramString)) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      ajw = (bool1 | bool2);
      ajn = paramString;
      return;
    }
  }
  
  public String zzsi()
  {
    aja.zzwu();
    return zzcjj;
  }
  
  public String zzxc()
  {
    aja.zzwu();
    return zzcuq;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.measurement.internal.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */