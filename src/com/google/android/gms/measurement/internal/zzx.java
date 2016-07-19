package com.google.android.gms.measurement.internal;

import android.app.Application;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.provider.Settings.Secure;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.internal.zzaov;
import com.google.android.gms.internal.zzup.zza;
import com.google.android.gms.internal.zzup.zzb;
import com.google.android.gms.internal.zzup.zzc;
import com.google.android.gms.internal.zzup.zzd;
import com.google.android.gms.internal.zzup.zze;
import com.google.android.gms.internal.zzup.zzg;
import com.google.android.gms.measurement.AppMeasurement;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class zzx
{
  private static volatile zzx amm;
  private final zzn amA;
  private final zzr amB;
  private final zzai amC;
  private final zzc amD;
  public final FirebaseAnalytics amE;
  private boolean amF;
  private Boolean amG;
  private FileLock amH;
  private FileChannel amI;
  private List<Long> amJ;
  private int amK;
  private int amL;
  private final zzd amn;
  private final zzt amo;
  private final zzp amp;
  private final zzw amq;
  private final zzaf amr;
  private final zzv ams;
  private final AppMeasurement amt;
  private final zzal amu;
  private final zze amv;
  private final zzq amw;
  private final zzad amx;
  private final zzg amy;
  private final zzac amz;
  private final Context mContext;
  private final com.google.android.gms.common.util.zze zzaoa;
  private final boolean zzcwt;
  
  zzx(zzab paramzzab)
  {
    com.google.android.gms.common.internal.zzab.zzaa(paramzzab);
    mContext = mContext;
    zzaoa = paramzzab.zzl(this);
    amn = paramzzab.zza(this);
    Object localObject = paramzzab.zzb(this);
    ((zzt)localObject).initialize();
    amo = ((zzt)localObject);
    localObject = paramzzab.zzc(this);
    ((zzp)localObject).initialize();
    amp = ((zzp)localObject);
    zzbsz().zzbtw().zzj("App measurement is starting up, version", Long.valueOf(zzbtb().zzbqv()));
    zzbsz().zzbtw().log("To enable debug logging run: adb shell setprop log.tag.FA VERBOSE");
    zzbsz().zzbtx().log("Debug logging enabled");
    zzbsz().zzbtx().zzj("AppMeasurement singleton hash", Integer.valueOf(System.identityHashCode(this)));
    amu = paramzzab.zzi(this);
    localObject = paramzzab.zzn(this);
    ((zzg)localObject).initialize();
    amy = ((zzg)localObject);
    localObject = paramzzab.zzo(this);
    ((zzn)localObject).initialize();
    amA = ((zzn)localObject);
    localObject = paramzzab.zzj(this);
    ((zze)localObject).initialize();
    amv = ((zze)localObject);
    localObject = paramzzab.zzr(this);
    ((zzc)localObject).initialize();
    amD = ((zzc)localObject);
    localObject = paramzzab.zzk(this);
    ((zzq)localObject).initialize();
    amw = ((zzq)localObject);
    localObject = paramzzab.zzm(this);
    ((zzad)localObject).initialize();
    amx = ((zzad)localObject);
    localObject = paramzzab.zzh(this);
    ((zzac)localObject).initialize();
    amz = ((zzac)localObject);
    localObject = paramzzab.zzq(this);
    ((zzai)localObject).initialize();
    amC = ((zzai)localObject);
    amB = paramzzab.zzp(this);
    amt = paramzzab.zzg(this);
    amE = new FirebaseAnalytics(this);
    localObject = paramzzab.zze(this);
    ((zzaf)localObject).initialize();
    amr = ((zzaf)localObject);
    localObject = paramzzab.zzf(this);
    ((zzv)localObject).initialize();
    ams = ((zzv)localObject);
    paramzzab = paramzzab.zzd(this);
    paramzzab.initialize();
    amq = paramzzab;
    if (amK != amL) {
      zzbsz().zzbtr().zze("Not all components initialized", Integer.valueOf(amK), Integer.valueOf(amL));
    }
    zzcwt = true;
    if ((!amn.zzabc()) && (!zzbuu()))
    {
      if (!(mContext.getApplicationContext() instanceof Application)) {
        break label454;
      }
      if (Build.VERSION.SDK_INT < 14) {
        break label438;
      }
      zzbsq().zzbvj();
    }
    for (;;)
    {
      amq.zzl(new Runnable()
      {
        public void run()
        {
          start();
        }
      });
      return;
      label438:
      zzbsz().zzbtx().log("Not tracking deep linking pre-ICS");
      continue;
      label454:
      zzbsz().zzbtt().log("Application context is not an Application");
    }
  }
  
  private void zza(int paramInt, Throwable paramThrowable, byte[] paramArrayOfByte)
  {
    int i = 0;
    zzwu();
    zzzg();
    byte[] arrayOfByte = paramArrayOfByte;
    if (paramArrayOfByte == null) {
      arrayOfByte = new byte[0];
    }
    paramArrayOfByte = amJ;
    amJ = null;
    if (((paramInt == 200) || (paramInt == 204)) && (paramThrowable == null))
    {
      zzbtaalv.set(zzyw().currentTimeMillis());
      zzbtaalw.set(0L);
      zzbva();
      zzbsz().zzbty().zze("Successful upload. Got network response. code, size", Integer.valueOf(paramInt), Integer.valueOf(arrayOfByte.length));
      zzbsu().beginTransaction();
      try
      {
        paramThrowable = paramArrayOfByte.iterator();
        while (paramThrowable.hasNext())
        {
          paramArrayOfByte = (Long)paramThrowable.next();
          zzbsu().zzbg(paramArrayOfByte.longValue());
        }
      }
      finally
      {
        zzbsu().endTransaction();
      }
      zzbsu().endTransaction();
      if ((zzbuo().zzadj()) && (zzbuz()))
      {
        zzbuy();
        return;
      }
      zzbva();
      return;
    }
    zzbsz().zzbty().zze("Network upload failed. Will retry later. code, error", Integer.valueOf(paramInt), paramThrowable);
    zzbtaalw.set(zzyw().currentTimeMillis());
    if ((paramInt == 503) || (paramInt == 429)) {
      i = 1;
    }
    if (i != 0) {
      zzbtaalx.set(zzyw().currentTimeMillis());
    }
    zzbva();
  }
  
  private void zza(zzaa paramzzaa)
  {
    if (paramzzaa == null) {
      throw new IllegalStateException("Component not created");
    }
    if (!paramzzaa.isInitialized()) {
      throw new IllegalStateException("Component not initialized");
    }
  }
  
  private void zza(zzz paramzzz)
  {
    if (paramzzz == null) {
      throw new IllegalStateException("Component not created");
    }
  }
  
  private zzup.zza[] zza(String paramString, zzup.zzg[] paramArrayOfzzg, zzup.zzb[] paramArrayOfzzb)
  {
    com.google.android.gms.common.internal.zzab.zzhs(paramString);
    return zzbsp().zza(paramString, paramArrayOfzzb, paramArrayOfzzg);
  }
  
  private void zzad(List<Long> paramList)
  {
    if (!paramList.isEmpty()) {}
    for (boolean bool = true;; bool = false)
    {
      com.google.android.gms.common.internal.zzab.zzbn(bool);
      if (amJ == null) {
        break;
      }
      zzbsz().zzbtr().log("Set uploading progress before finishing the previous upload");
      return;
    }
    amJ = new ArrayList(paramList);
  }
  
  private boolean zzbux()
  {
    zzwu();
    return amJ != null;
  }
  
  private boolean zzbuz()
  {
    zzwu();
    zzzg();
    return (zzbsu().zzbth()) || (!TextUtils.isEmpty(zzbsu().zzbtc()));
  }
  
  private void zzbva()
  {
    zzwu();
    zzzg();
    if (!zzbve()) {
      return;
    }
    if ((!zzbuk()) || (!zzbuz()))
    {
      zzbup().unregister();
      zzbuq().cancel();
      return;
    }
    long l2 = zzbvb();
    if (l2 == 0L)
    {
      zzbup().unregister();
      zzbuq().cancel();
      return;
    }
    if (!zzbuo().zzadj())
    {
      zzbup().zzadg();
      zzbuq().cancel();
      return;
    }
    long l3 = zzbtaalx.get();
    long l4 = zzbtb().zzbsi();
    long l1 = l2;
    if (!zzbsv().zzg(l3, l4)) {
      l1 = Math.max(l2, l3 + l4);
    }
    zzbup().unregister();
    l1 -= zzyw().currentTimeMillis();
    if (l1 <= 0L)
    {
      zzbuq().zzv(1L);
      return;
    }
    zzbsz().zzbty().zzj("Upload scheduled in approximately ms", Long.valueOf(l1));
    zzbuq().zzv(l1);
  }
  
  private long zzbvb()
  {
    long l5 = zzyw().currentTimeMillis();
    long l1 = zzbtb().zzbsl();
    long l2 = zzbtb().zzbsj();
    long l6 = zzbtaalv.get();
    long l4 = zzbtaalw.get();
    long l3 = Math.max(zzbsu().zzbtf(), zzbsu().zzbtg());
    if (l3 == 0L) {
      l2 = 0L;
    }
    do
    {
      do
      {
        return l2;
        l3 = l5 - Math.abs(l3 - l5);
        l6 = Math.abs(l6 - l5);
        l4 = l5 - Math.abs(l4 - l5);
        l5 = Math.max(l5 - l6, l4);
        l1 += l3;
        if (!zzbsv().zzg(l5, l2)) {
          l1 = l5 + l2;
        }
        l2 = l1;
      } while (l4 == 0L);
      l2 = l1;
    } while (l4 < l3);
    int i = 0;
    for (;;)
    {
      if (i >= zzbtb().zzbsn()) {
        break label223;
      }
      l1 += (1 << i) * zzbtb().zzbsm();
      l2 = l1;
      if (l1 > l4) {
        break;
      }
      i += 1;
    }
    label223:
    return 0L;
  }
  
  public static zzx zzdo(Context paramContext)
  {
    com.google.android.gms.common.internal.zzab.zzaa(paramContext);
    com.google.android.gms.common.internal.zzab.zzaa(paramContext.getApplicationContext());
    if (amm == null) {}
    try
    {
      if (amm == null) {
        amm = new zzab(paramContext).zzbvi();
      }
      return amm;
    }
    finally {}
  }
  
  private void zze(AppMetadata paramAppMetadata)
  {
    int k = 1;
    zzwu();
    zzzg();
    com.google.android.gms.common.internal.zzab.zzaa(paramAppMetadata);
    com.google.android.gms.common.internal.zzab.zzhs(packageName);
    zza localzza2 = zzbsu().zzlo(packageName);
    String str = zzbta().zzlz(packageName);
    int i = 0;
    zza localzza1;
    int j;
    if (localzza2 == null)
    {
      localzza1 = new zza(this, packageName);
      localzza1.zzkz(zzbta().zzbub());
      localzza1.zzlb(str);
      i = 1;
      j = i;
      if (!TextUtils.isEmpty(ajz))
      {
        j = i;
        if (!ajz.equals(localzza1.zzbqo()))
        {
          localzza1.zzla(ajz);
          j = 1;
        }
      }
      i = j;
      if (!TextUtils.isEmpty(ajH))
      {
        i = j;
        if (!ajH.equals(localzza1.zzbqq()))
        {
          localzza1.zzlc(ajH);
          i = 1;
        }
      }
      j = i;
      if (ajB != 0L)
      {
        j = i;
        if (ajB != localzza1.zzbqv())
        {
          localzza1.zzaw(ajB);
          j = 1;
        }
      }
      i = j;
      if (!TextUtils.isEmpty(abU))
      {
        i = j;
        if (!abU.equals(localzza1.zzxc()))
        {
          localzza1.setAppVersion(abU);
          i = 1;
        }
      }
      if (ajG != localzza1.zzbqt())
      {
        localzza1.zzav(ajG);
        i = 1;
      }
      j = i;
      if (!TextUtils.isEmpty(ajA))
      {
        j = i;
        if (!ajA.equals(localzza1.zzbqu()))
        {
          localzza1.zzld(ajA);
          j = 1;
        }
      }
      if (ajC != localzza1.zzbqw())
      {
        localzza1.zzax(ajC);
        j = 1;
      }
      if (ajE == localzza1.zzbqx()) {
        break label420;
      }
      localzza1.setMeasurementEnabled(ajE);
    }
    label420:
    for (i = k;; i = j)
    {
      if (i != 0) {
        zzbsu().zza(localzza1);
      }
      return;
      localzza1 = localzza2;
      if (str.equals(localzza2.zzbqp())) {
        break;
      }
      localzza2.zzlb(str);
      localzza2.zzkz(zzbta().zzbub());
      i = 1;
      localzza1 = localzza2;
      break;
    }
  }
  
  private boolean zzh(String paramString, long paramLong)
  {
    zzbsu().beginTransaction();
    zza localzza;
    zzup.zze localzze;
    int j;
    int k;
    int m;
    label292:
    Object localObject1;
    label331:
    Object localObject2;
    zzup.zzc[] arrayOfzzc;
    int n;
    label605:
    int i1;
    for (;;)
    {
      try
      {
        localzza = new zza(null);
        zzbsu().zza(paramString, paramLong, localzza);
        if (localzza.isEmpty()) {
          break label1187;
        }
        localzze = amN;
        aoS = new zzup.zzb[zzala.size()];
        j = 0;
        k = 0;
        if (k >= zzala.size()) {
          break;
        }
        if (zzbsw().zzax(amN.zzck, zzala.get(k)).name))
        {
          zzbsz().zzbtt().zzj("Dropping blacklisted raw event", zzala.get(k)).name);
          zzbsv().zze(11, "_ev", zzala.get(k)).name);
          i = j;
          break label1221;
        }
        if (zzbsw().zzay(amN.zzck, zzala.get(k)).name))
        {
          if (zzala.get(k)).aoK == null) {
            zzala.get(k)).aoK = new zzup.zzc[0];
          }
          paramString = zzala.get(k)).aoK;
          m = paramString.length;
          i = 0;
          if (i >= m) {
            break label1215;
          }
          localObject1 = paramString[i];
          if (!"_c".equals(name)) {
            break label1243;
          }
          aoO = Long.valueOf(1L);
          i = 1;
          if (i == 0)
          {
            zzbsz().zzbty().zzj("Marking event as conversion", zzala.get(k)).name);
            paramString = (zzup.zzc[])Arrays.copyOf(zzala.get(k)).aoK, zzala.get(k)).aoK.length + 1);
            localObject1 = new zzup.zzc();
            name = "_c";
            aoO = Long.valueOf(1L);
            paramString[(paramString.length - 1)] = localObject1;
            zzala.get(k)).aoK = paramString;
          }
          boolean bool = zzal.zzmk(zzala.get(k)).name);
          if ((bool) && (zzbsuzzazzbuvamN.zzck, false, bool, false).ajO - zzbtb().zzlg(amN.zzck) > 0L))
          {
            zzbsz().zzbtt().log("Too many conversions. Not logging as conversion.");
            localObject2 = (zzup.zzb)zzala.get(k);
            i = 0;
            paramString = null;
            arrayOfzzc = zzala.get(k)).aoK;
            n = arrayOfzzc.length;
            m = 0;
            if (m < n)
            {
              localObject1 = arrayOfzzc[m];
              if ("_c".equals(name))
              {
                paramString = (String)localObject1;
                break label1234;
              }
              if (!"_err".equals(name)) {
                break label1212;
              }
              i = 1;
              break label1234;
            }
            if ((i == 0) || (paramString == null)) {
              continue;
            }
            localObject1 = new zzup.zzc[aoK.length - 1];
            i = 0;
            localObject2 = aoK;
            i1 = localObject2.length;
            m = 0;
            break label1252;
            label702:
            zzala.get(k)).aoK = ((zzup.zzc[])localObject1);
          }
        }
        aoS[j] = ((zzup.zzb)zzala.get(k));
        i = j + 1;
        break label1221;
        if (paramString != null)
        {
          name = "_err";
          aoO = Long.valueOf(10L);
        }
        else
        {
          zzbsz().zzbtr().log("Did not find conversion parameter. Error not tracked");
        }
      }
      finally
      {
        zzbsu().endTransaction();
      }
    }
    if (j < zzala.size()) {
      aoS = ((zzup.zzb[])Arrays.copyOf(aoS, j));
    }
    apl = zza(amN.zzck, amN.aoT, aoS);
    aoV = aoS[0].aoL;
    aoW = aoS[0].aoL;
    int i = 1;
    label900:
    label1018:
    label1093:
    long l;
    if (i < aoS.length)
    {
      paramString = aoS[i];
      if (aoL.longValue() < aoV.longValue()) {
        aoV = aoL;
      }
      if (aoL.longValue() > aoW.longValue()) {
        aoW = aoL;
      }
    }
    else
    {
      localObject1 = amN.zzck;
      localObject2 = zzbsu().zzlo((String)localObject1);
      if (localObject2 == null)
      {
        zzbsz().zzbtr().log("Bundling raw events w/o app info");
        ajD = zzbsz().zzbtz();
        zzbsu().zza(localzze);
        zzbsu().zzac(amO);
        zzbsu().zzlu((String)localObject1);
        zzbsu().setTransactionSuccessful();
        zzbsu().endTransaction();
        return true;
      }
      paramLong = ((zza)localObject2).zzbqs();
      if (paramLong == 0L) {
        break label1307;
      }
      paramString = Long.valueOf(paramLong);
      aoY = paramString;
      l = ((zza)localObject2).zzbqr();
      if (l == 0L) {
        label1113:
        if (paramLong == 0L) {
          break label1312;
        }
      }
    }
    label1187:
    label1212:
    label1215:
    label1221:
    label1234:
    label1243:
    label1252:
    label1289:
    label1296:
    label1307:
    label1312:
    for (paramString = Long.valueOf(paramLong);; paramString = null)
    {
      aoX = paramString;
      ((zza)localObject2).zzbrb();
      apj = Integer.valueOf((int)((zza)localObject2).zzbqy());
      ((zza)localObject2).zzat(aoV.longValue());
      ((zza)localObject2).zzau(aoW.longValue());
      zzbsu().zza((zza)localObject2);
      break label1018;
      zzbsu().setTransactionSuccessful();
      zzbsu().endTransaction();
      return false;
      paramLong = l;
      break label1113;
      break label1289;
      break label1234;
      i = 0;
      break label331;
      k += 1;
      j = i;
      break;
      m += 1;
      break label605;
      i += 1;
      break label292;
      for (;;)
      {
        if (m >= i1) {
          break label1296;
        }
        arrayOfzzc = localObject2[m];
        if (arrayOfzzc == paramString) {
          break;
        }
        n = i + 1;
        localObject1[i] = arrayOfzzc;
        i = n;
        m += 1;
      }
      break label702;
      i += 1;
      break label900;
      paramString = null;
      break label1093;
    }
  }
  
  public Context getContext()
  {
    return mContext;
  }
  
  public boolean isEnabled()
  {
    boolean bool = false;
    zzwu();
    zzzg();
    if (zzbtb().zzbrz()) {
      return false;
    }
    Boolean localBoolean = zzbtb().zzbsa();
    if (localBoolean != null) {
      bool = localBoolean.booleanValue();
    }
    for (;;)
    {
      return zzbta().zzcb(bool);
      if (!zzbtb().zzaql()) {
        bool = true;
      }
    }
  }
  
  protected void start()
  {
    zzwu();
    if ((zzbuu()) && ((!amq.isInitialized()) || (amq.zzbvh())))
    {
      zzbsz().zzbtr().log("Scheduler shutting down before Scion.start() called");
      return;
    }
    zzbsu().zzbtd();
    if (!zzbuk()) {
      if (isEnabled())
      {
        if (!zzbsv().zzep("android.permission.INTERNET")) {
          zzbsz().zzbtr().log("App is missing INTERNET permission");
        }
        if (!zzbsv().zzep("android.permission.ACCESS_NETWORK_STATE")) {
          zzbsz().zzbtr().log("App is missing ACCESS_NETWORK_STATE permission");
        }
        if (!zzu.zzav(getContext())) {
          zzbsz().zzbtr().log("AppMeasurementReceiver not registered/enabled");
        }
        if (!zzae.zzaw(getContext())) {
          zzbsz().zzbtr().log("AppMeasurementService not registered/enabled");
        }
        zzbsz().zzbtr().log("Uploading is not possible. App measurement disabled");
      }
    }
    label271:
    label334:
    for (;;)
    {
      zzbva();
      return;
      String str;
      if ((!zzbtb().zzabc()) && (!TextUtils.isEmpty(zzbsr().zzbqo())))
      {
        str = zzbta().zzbue();
        if (str != null) {
          break label271;
        }
        zzbta().zzma(zzbsr().zzbqo());
      }
      for (;;)
      {
        if ((zzbtb().zzabc()) || (zzbuu()) || (TextUtils.isEmpty(zzbsr().zzbqo()))) {
          break label334;
        }
        zzbsq().zzbvk();
        break;
        if (!str.equals(zzbsr().zzbqo()))
        {
          zzbsz().zzbtw().log("Rechecking which service to use due to a GMP App Id change");
          zzbta().zzbug();
          amx.disconnect();
          amx.zzaai();
          zzbta().zzma(zzbsr().zzbqo());
        }
      }
    }
  }
  
  int zza(FileChannel paramFileChannel)
  {
    zzwu();
    if ((paramFileChannel == null) || (!paramFileChannel.isOpen()))
    {
      zzbsz().zzbtr().log("Bad chanel to read from");
      return 0;
    }
    ByteBuffer localByteBuffer = ByteBuffer.allocate(4);
    try
    {
      paramFileChannel.position(0L);
      i = paramFileChannel.read(localByteBuffer);
      if (i != 4)
      {
        zzbsz().zzbtt().zzj("Unexpected data length or empty data in channel. Bytes read", Integer.valueOf(i));
        return 0;
      }
    }
    catch (IOException paramFileChannel)
    {
      zzbsz().zzbtr().zzj("Failed to read from channel", paramFileChannel);
      return 0;
    }
    localByteBuffer.flip();
    int i = localByteBuffer.getInt();
    return i;
  }
  
  void zza(AppMetadata paramAppMetadata, long paramLong)
  {
    Object localObject2 = zzbsu().zzlo(packageName);
    Object localObject1 = localObject2;
    if (localObject2 != null)
    {
      localObject1 = localObject2;
      if (((zza)localObject2).zzbqo() != null)
      {
        localObject1 = localObject2;
        if (!((zza)localObject2).zzbqo().equals(ajz))
        {
          zzbsz().zzbtt().log("New GMP App Id passed in. Removing cached database data.");
          zzbsu().zzlt(((zza)localObject2).zzsi());
          localObject1 = null;
        }
      }
    }
    if ((localObject1 != null) && (((zza)localObject1).zzxc() != null) && (!((zza)localObject1).zzxc().equals(abU)))
    {
      localObject2 = new Bundle();
      ((Bundle)localObject2).putString("_pv", ((zza)localObject1).zzxc());
      zzb(new EventParcel("_au", new EventParams((Bundle)localObject2), "auto", paramLong), paramAppMetadata);
    }
  }
  
  void zza(zzh paramzzh, AppMetadata paramAppMetadata)
  {
    zzwu();
    zzzg();
    com.google.android.gms.common.internal.zzab.zzaa(paramzzh);
    com.google.android.gms.common.internal.zzab.zzaa(paramAppMetadata);
    com.google.android.gms.common.internal.zzab.zzhs(zzcjj);
    com.google.android.gms.common.internal.zzab.zzbn(zzcjj.equals(packageName));
    zzup.zze localzze = new zzup.zze();
    aoR = Integer.valueOf(1);
    aoZ = "android";
    zzck = packageName;
    ajA = ajA;
    abU = abU;
    apm = Integer.valueOf((int)ajG);
    apd = Long.valueOf(ajB);
    ajz = ajz;
    Object localObject1;
    if (ajC == 0L)
    {
      localObject1 = null;
      api = ((Long)localObject1);
      localObject1 = zzbta().zzly(packageName);
      if ((localObject1 == null) || (TextUtils.isEmpty((CharSequence)first))) {
        break label599;
      }
      apf = ((String)first);
      apg = ((Boolean)second);
    }
    label599:
    while (zzbss().zzdn(mContext))
    {
      apa = zzbss().zzth();
      zzct = zzbss().zzbtk();
      apc = Integer.valueOf((int)zzbss().zzbtl());
      apb = zzbss().zzbtm();
      ape = null;
      aoU = null;
      aoV = null;
      aoW = null;
      localObject2 = zzbsu().zzlo(packageName);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new zza(this, packageName);
        ((zza)localObject1).zzkz(zzbta().zzbub());
        ((zza)localObject1).zzlc(ajH);
        ((zza)localObject1).zzla(ajz);
        ((zza)localObject1).zzlb(zzbta().zzlz(packageName));
        ((zza)localObject1).zzay(0L);
        ((zza)localObject1).zzat(0L);
        ((zza)localObject1).zzau(0L);
        ((zza)localObject1).setAppVersion(abU);
        ((zza)localObject1).zzav(ajG);
        ((zza)localObject1).zzld(ajA);
        ((zza)localObject1).zzaw(ajB);
        ((zza)localObject1).zzax(ajC);
        ((zza)localObject1).setMeasurementEnabled(ajE);
        zzbsu().zza((zza)localObject1);
      }
      aph = ((zza)localObject1).zzawj();
      ajH = ((zza)localObject1).zzbqq();
      paramAppMetadata = zzbsu().zzln(packageName);
      aoT = new zzup.zzg[paramAppMetadata.size()];
      int i = 0;
      while (i < paramAppMetadata.size())
      {
        localObject1 = new zzup.zzg();
        aoT[i] = localObject1;
        name = getmName;
        apt = Long.valueOf(getanU);
        zzbsv().zza((zzup.zzg)localObject1, getzzcnr);
        i += 1;
      }
      localObject1 = Long.valueOf(ajC);
      break;
    }
    Object localObject2 = Settings.Secure.getString(mContext.getContentResolver(), "android_id");
    if (localObject2 == null)
    {
      zzbsz().zzbtt().log("null secure ID");
      localObject1 = "null";
    }
    for (;;)
    {
      app = ((String)localObject1);
      break;
      localObject1 = localObject2;
      if (((String)localObject2).isEmpty())
      {
        zzbsz().zzbtt().log("empty secure ID");
        localObject1 = localObject2;
      }
    }
    try
    {
      long l = zzbsu().zzb(localzze);
      zzbsu().zza(paramzzh, l);
      return;
    }
    catch (IOException paramzzh)
    {
      zzbsz().zzbtr().zzj("Data loss. Failed to insert raw event metadata", paramzzh);
    }
  }
  
  boolean zza(int paramInt, FileChannel paramFileChannel)
  {
    boolean bool = true;
    zzwu();
    if ((paramFileChannel == null) || (!paramFileChannel.isOpen()))
    {
      zzbsz().zzbtr().log("Bad chanel to read from");
      bool = false;
    }
    for (;;)
    {
      return bool;
      ByteBuffer localByteBuffer = ByteBuffer.allocate(4);
      localByteBuffer.putInt(paramInt);
      localByteBuffer.flip();
      try
      {
        paramFileChannel.truncate(0L);
        paramFileChannel.write(localByteBuffer);
        paramFileChannel.force(true);
        if (paramFileChannel.size() != 4L)
        {
          zzbsz().zzbtr().zzj("Error writing to channel. Bytes written", Long.valueOf(paramFileChannel.size()));
          return true;
        }
      }
      catch (IOException paramFileChannel)
      {
        zzbsz().zzbtr().zzj("Failed to write to channel", paramFileChannel);
      }
    }
    return false;
  }
  
  public byte[] zza(EventParcel paramEventParcel, String paramString)
  {
    zzzg();
    zzwu();
    zzbuw();
    com.google.android.gms.common.internal.zzab.zzaa(paramEventParcel);
    com.google.android.gms.common.internal.zzab.zzhs(paramString);
    zzup.zzd localzzd = new zzup.zzd();
    zzbsu().beginTransaction();
    zza localzza;
    zzup.zze localzze;
    try
    {
      localzza = zzbsu().zzlo(paramString);
      if (localzza == null)
      {
        zzbsz().zzbtx().zzj("Log and bundle not available. package_name", paramString);
        return new byte[0];
      }
      if (!localzza.zzbqx())
      {
        zzbsz().zzbtx().zzj("Log and bundle disabled. package_name", paramString);
        return new byte[0];
      }
      localzze = new zzup.zze();
      aoP = new zzup.zze[] { localzze };
      aoR = Integer.valueOf(1);
      aoZ = "android";
      zzck = localzza.zzsi();
      ajA = localzza.zzbqu();
      abU = localzza.zzxc();
      apm = Integer.valueOf((int)localzza.zzbqt());
      apd = Long.valueOf(localzza.zzbqv());
      ajz = localzza.zzbqo();
      api = Long.valueOf(localzza.zzbqw());
      Object localObject1 = zzbta().zzly(localzza.zzsi());
      if ((localObject1 != null) && (!TextUtils.isEmpty((CharSequence)first)))
      {
        apf = ((String)first);
        apg = ((Boolean)second);
      }
      apa = zzbss().zzth();
      zzct = zzbss().zzbtk();
      apc = Integer.valueOf((int)zzbss().zzbtl());
      apb = zzbss().zzbtm();
      aph = localzza.zzawj();
      ajH = localzza.zzbqq();
      localObject1 = zzbsu().zzln(localzza.zzsi());
      aoT = new zzup.zzg[((List)localObject1).size()];
      int i = 0;
      while (i < ((List)localObject1).size())
      {
        localObject2 = new zzup.zzg();
        aoT[i] = localObject2;
        name = getmName;
        apt = Long.valueOf(getanU);
        zzbsv().zza((zzup.zzg)localObject2, getzzcnr);
        i += 1;
      }
      localObject1 = akf.zzbto();
      if ("_iap".equals(name)) {
        ((Bundle)localObject1).putLong("_c", 1L);
      }
      ((Bundle)localObject1).putString("_o", akg);
      Object localObject2 = zzbsu().zzaq(paramString, name);
      if (localObject2 == null)
      {
        localObject2 = new zzi(paramString, name, 1L, 0L, akh);
        zzbsu().zza((zzi)localObject2);
        l1 = 0L;
      }
      for (;;)
      {
        paramEventParcel = new zzh(this, akg, paramString, name, akh, l1, (Bundle)localObject1);
        paramString = new zzup.zzb();
        aoS = new zzup.zzb[] { paramString };
        aoL = Long.valueOf(pz);
        name = mName;
        aoM = Long.valueOf(ajX);
        aoK = new zzup.zzc[ajY.size()];
        localObject1 = ajY.iterator();
        i = 0;
        while (((Iterator)localObject1).hasNext())
        {
          Object localObject3 = (String)((Iterator)localObject1).next();
          localObject2 = new zzup.zzc();
          aoK[i] = localObject2;
          name = ((String)localObject3);
          localObject3 = ajY.get((String)localObject3);
          zzbsv().zza((zzup.zzc)localObject2, localObject3);
          i += 1;
        }
        l1 = akb;
        localObject2 = ((zzi)localObject2).zzbi(akh).zzbtn();
        zzbsu().zza((zzi)localObject2);
      }
      apl = zza(localzza.zzsi(), aoT, aoS);
    }
    finally
    {
      zzbsu().endTransaction();
    }
    aoV = aoL;
    aoW = aoL;
    long l1 = localzza.zzbqs();
    long l2;
    if (l1 != 0L)
    {
      paramEventParcel = Long.valueOf(l1);
      aoY = paramEventParcel;
      l2 = localzza.zzbqr();
      if (l2 != 0L) {
        break label1077;
      }
    }
    for (;;)
    {
      if (l1 != 0L) {}
      for (paramEventParcel = Long.valueOf(l1);; paramEventParcel = null)
      {
        aoX = paramEventParcel;
        localzza.zzbrb();
        apj = Integer.valueOf((int)localzza.zzbqy());
        ape = Long.valueOf(zzbtb().zzbqv());
        aoU = Long.valueOf(zzyw().currentTimeMillis());
        apk = Boolean.TRUE;
        localzza.zzat(aoV.longValue());
        localzza.zzau(aoW.longValue());
        zzbsu().zza(localzza);
        zzbsu().setTransactionSuccessful();
        zzbsu().endTransaction();
        try
        {
          paramEventParcel = new byte[localzzd.ao()];
          paramString = zzaov.zzba(paramEventParcel);
          localzzd.zza(paramString);
          paramString.ab();
          paramEventParcel = zzbsv().zzj(paramEventParcel);
          return paramEventParcel;
        }
        catch (IOException paramEventParcel)
        {
          zzbsz().zzbtr().zzj("Data loss. Failed to bundle and serialize", paramEventParcel);
          return null;
        }
        paramEventParcel = null;
        break;
      }
      label1077:
      l1 = l2;
    }
  }
  
  public void zzas(boolean paramBoolean)
  {
    zzbva();
  }
  
  void zzb(AppMetadata paramAppMetadata, long paramLong)
  {
    Bundle localBundle = new Bundle();
    localBundle.putLong("_c", 1L);
    zzb(new EventParcel("_f", new EventParams(localBundle), "auto", paramLong), paramAppMetadata);
  }
  
  void zzb(EventParcel paramEventParcel, AppMetadata paramAppMetadata)
  {
    long l2 = System.nanoTime();
    zzwu();
    zzzg();
    String str = packageName;
    com.google.android.gms.common.internal.zzab.zzhs(str);
    if (TextUtils.isEmpty(ajz)) {
      return;
    }
    if (!ajE)
    {
      zze(paramAppMetadata);
      return;
    }
    if (zzbsw().zzax(str, name))
    {
      zzbsz().zzbtt().zzj("Dropping blacklisted event", name);
      zzbsv().zze(11, "_ev", name);
      return;
    }
    if (zzbsz().zzaz(2)) {
      zzbsz().zzbty().zzj("Logging event", paramEventParcel);
    }
    zzbsu().beginTransaction();
    Bundle localBundle;
    boolean bool1;
    boolean bool2;
    for (;;)
    {
      try
      {
        localBundle = akf.zzbto();
        zze(paramAppMetadata);
        double d1;
        Object localObject2;
        if (("_iap".equals(name)) || ("ecommerce_purchase".equals(name)))
        {
          localObject1 = localBundle.getString("currency");
          if (!"ecommerce_purchase".equals(name)) {
            continue;
          }
          double d2 = localBundle.getDouble("value") * 1000000.0D;
          d1 = d2;
          if (d2 == 0.0D) {
            d1 = localBundle.getLong("value") * 1000000.0D;
          }
          if ((d1 > 9.223372036854776E18D) || (d1 < -9.223372036854776E18D)) {
            continue;
          }
          l1 = Math.round(d1);
          if (!TextUtils.isEmpty((CharSequence)localObject1))
          {
            localObject2 = ((String)localObject1).toUpperCase(Locale.US);
            if (((String)localObject2).matches("[A-Z]{3}"))
            {
              localObject1 = String.valueOf("_ltv_");
              localObject2 = String.valueOf(localObject2);
              if (((String)localObject2).length() == 0) {
                continue;
              }
              localObject1 = ((String)localObject1).concat((String)localObject2);
              localObject2 = zzbsu().zzas(str, (String)localObject1);
              if ((localObject2 != null) && ((zzcnr instanceof Long))) {
                break label638;
              }
              zzbsu().zzy(str, zzbtb().zzli(str) - 1);
              localObject1 = new zzak(str, (String)localObject1, zzyw().currentTimeMillis(), Long.valueOf(l1));
              if (!zzbsu().zza((zzak)localObject1))
              {
                zzbsz().zzbtr().zze("Too many unique user properties are set. Ignoring user property.", mName, zzcnr);
                zzbsv().zze(9, null, null);
              }
            }
          }
        }
        bool1 = zzal.zzmk(name);
        zzal.zzam(localBundle);
        bool2 = "_err".equals(name);
        localObject1 = zzbsu().zza(zzbuv(), str, bool1, false, bool2);
        l1 = ajN - zzbtb().zzbrr();
        if (l1 <= 0L) {
          break;
        }
        if (l1 % 1000L == 1L) {
          zzbsz().zzbtr().zzj("Data loss. Too many events logged. count", Long.valueOf(ajN));
        }
        zzbsv().zze(16, "_ev", name);
        zzbsu().setTransactionSuccessful();
        return;
        zzbsz().zzbtt().zzj("Data lost. Currency value is too big", Double.valueOf(d1));
        zzbsu().setTransactionSuccessful();
        return;
        l1 = localBundle.getLong("value");
        continue;
        localObject1 = new String((String)localObject1);
        continue;
        l3 = ((Long)zzcnr).longValue();
      }
      finally
      {
        zzbsu().endTransaction();
      }
      label638:
      long l3;
      localObject1 = new zzak(str, (String)localObject1, zzyw().currentTimeMillis(), Long.valueOf(l1 + l3));
    }
    if (bool1)
    {
      l1 = ajM - zzbtb().zzbrs();
      if (l1 > 0L)
      {
        if (l1 % 1000L == 1L) {
          zzbsz().zzbtr().zzj("Data loss. Too many public events logged. count", Long.valueOf(ajM));
        }
        zzbsv().zze(16, "_ev", name);
        zzbsu().setTransactionSuccessful();
        zzbsu().endTransaction();
        return;
      }
    }
    if (bool2)
    {
      l1 = ajP - zzbtb().zzbrt();
      if (l1 > 0L)
      {
        if (l1 == 1L) {
          zzbsz().zzbtr().zzj("Too many error events logged. count", Long.valueOf(ajP));
        }
        zzbsu().setTransactionSuccessful();
        zzbsu().endTransaction();
        return;
      }
    }
    zzbsv().zza(localBundle, "_o", akg);
    long l1 = zzbsu().zzlp(str);
    if (l1 > 0L) {
      zzbsz().zzbtt().zzj("Data lost. Too many events stored on disk, deleted", Long.valueOf(l1));
    }
    paramEventParcel = new zzh(this, akg, str, name, akh, 0L, localBundle);
    Object localObject1 = zzbsu().zzaq(str, mName);
    if (localObject1 == null) {
      if (zzbsu().zzlv(str) >= zzbtb().zzbrq())
      {
        zzbsz().zzbtr().zze("Too many event names used, ignoring event. name, supported count", mName, Integer.valueOf(zzbtb().zzbrq()));
        zzbsv().zze(8, null, null);
        zzbsu().endTransaction();
        return;
      }
    }
    for (localObject1 = new zzi(str, mName, 0L, 0L, pz);; localObject1 = ((zzi)localObject1).zzbi(pz))
    {
      zzbsu().zza((zzi)localObject1);
      zza(paramEventParcel, paramAppMetadata);
      zzbsu().setTransactionSuccessful();
      if (zzbsz().zzaz(2)) {
        zzbsz().zzbty().zzj("Event recorded", paramEventParcel);
      }
      zzbsu().endTransaction();
      zzbva();
      zzbsz().zzbty().zzj("Background event processing time, ms", Long.valueOf((System.nanoTime() - l2 + 500000L) / 1000000L));
      return;
      paramEventParcel = paramEventParcel.zza(this, akb);
    }
  }
  
  void zzb(EventParcel paramEventParcel, String paramString)
  {
    zza localzza = zzbsu().zzlo(paramString);
    if ((localzza == null) || (TextUtils.isEmpty(localzza.zzxc())))
    {
      zzbsz().zzbtx().zzj("No app data available; dropping event", paramString);
      return;
    }
    try
    {
      String str = getContextgetPackageManagergetPackageInfo0versionName;
      if ((localzza.zzxc() != null) && (!localzza.zzxc().equals(str)))
      {
        zzbsz().zzbtt().zzj("App version does not match; dropping event", paramString);
        return;
      }
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      if (!"_ui".equals(name)) {
        zzbsz().zzbtt().zzj("Could not find package", paramString);
      }
      zzb(paramEventParcel, new AppMetadata(paramString, localzza.zzbqo(), localzza.zzxc(), localzza.zzbqt(), localzza.zzbqu(), localzza.zzbqv(), localzza.zzbqw(), null, localzza.zzbqx(), false, localzza.zzbqq()));
    }
  }
  
  /* Error */
  void zzb(UserAttributeParcel paramUserAttributeParcel, AppMetadata paramAppMetadata)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 353	com/google/android/gms/measurement/internal/zzx:zzwu	()V
    //   4: aload_0
    //   5: invokevirtual 356	com/google/android/gms/measurement/internal/zzx:zzzg	()V
    //   8: aload_2
    //   9: getfield 624	com/google/android/gms/measurement/internal/AppMetadata:ajz	Ljava/lang/String;
    //   12: invokestatic 505	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   15: ifeq +4 -> 19
    //   18: return
    //   19: aload_2
    //   20: getfield 692	com/google/android/gms/measurement/internal/AppMetadata:ajE	Z
    //   23: ifne +9 -> 32
    //   26: aload_0
    //   27: aload_2
    //   28: invokespecial 1320	com/google/android/gms/measurement/internal/zzx:zze	(Lcom/google/android/gms/measurement/internal/AppMetadata;)V
    //   31: return
    //   32: aload_0
    //   33: invokevirtual 543	com/google/android/gms/measurement/internal/zzx:zzbsv	()Lcom/google/android/gms/measurement/internal/zzal;
    //   36: aload_1
    //   37: getfield 1498	com/google/android/gms/measurement/internal/UserAttributeParcel:name	Ljava/lang/String;
    //   40: invokevirtual 1501	com/google/android/gms/measurement/internal/zzal:zzmo	(Ljava/lang/String;)I
    //   43: istore_3
    //   44: iload_3
    //   45: ifeq +36 -> 81
    //   48: aload_0
    //   49: invokevirtual 543	com/google/android/gms/measurement/internal/zzx:zzbsv	()Lcom/google/android/gms/measurement/internal/zzal;
    //   52: aload_1
    //   53: getfield 1498	com/google/android/gms/measurement/internal/UserAttributeParcel:name	Ljava/lang/String;
    //   56: aload_0
    //   57: invokevirtual 131	com/google/android/gms/measurement/internal/zzx:zzbtb	()Lcom/google/android/gms/measurement/internal/zzd;
    //   60: invokevirtual 1504	com/google/android/gms/measurement/internal/zzd:zzbrk	()I
    //   63: iconst_1
    //   64: invokevirtual 1507	com/google/android/gms/measurement/internal/zzal:zza	(Ljava/lang/String;IZ)Ljava/lang/String;
    //   67: astore_1
    //   68: aload_0
    //   69: invokevirtual 543	com/google/android/gms/measurement/internal/zzx:zzbsv	()Lcom/google/android/gms/measurement/internal/zzal;
    //   72: iload_3
    //   73: ldc_w 750
    //   76: aload_1
    //   77: invokevirtual 753	com/google/android/gms/measurement/internal/zzal:zze	(ILjava/lang/String;Ljava/lang/String;)V
    //   80: return
    //   81: aload_0
    //   82: invokevirtual 543	com/google/android/gms/measurement/internal/zzx:zzbsv	()Lcom/google/android/gms/measurement/internal/zzal;
    //   85: aload_1
    //   86: getfield 1498	com/google/android/gms/measurement/internal/UserAttributeParcel:name	Ljava/lang/String;
    //   89: aload_1
    //   90: invokevirtual 1510	com/google/android/gms/measurement/internal/UserAttributeParcel:getValue	()Ljava/lang/Object;
    //   93: invokevirtual 1513	com/google/android/gms/measurement/internal/zzal:zzm	(Ljava/lang/String;Ljava/lang/Object;)I
    //   96: istore_3
    //   97: iload_3
    //   98: ifeq +36 -> 134
    //   101: aload_0
    //   102: invokevirtual 543	com/google/android/gms/measurement/internal/zzx:zzbsv	()Lcom/google/android/gms/measurement/internal/zzal;
    //   105: aload_1
    //   106: getfield 1498	com/google/android/gms/measurement/internal/UserAttributeParcel:name	Ljava/lang/String;
    //   109: aload_0
    //   110: invokevirtual 131	com/google/android/gms/measurement/internal/zzx:zzbtb	()Lcom/google/android/gms/measurement/internal/zzd;
    //   113: invokevirtual 1504	com/google/android/gms/measurement/internal/zzd:zzbrk	()I
    //   116: iconst_1
    //   117: invokevirtual 1507	com/google/android/gms/measurement/internal/zzal:zza	(Ljava/lang/String;IZ)Ljava/lang/String;
    //   120: astore_1
    //   121: aload_0
    //   122: invokevirtual 543	com/google/android/gms/measurement/internal/zzx:zzbsv	()Lcom/google/android/gms/measurement/internal/zzal;
    //   125: iload_3
    //   126: ldc_w 750
    //   129: aload_1
    //   130: invokevirtual 753	com/google/android/gms/measurement/internal/zzal:zze	(ILjava/lang/String;Ljava/lang/String;)V
    //   133: return
    //   134: aload_0
    //   135: invokevirtual 543	com/google/android/gms/measurement/internal/zzx:zzbsv	()Lcom/google/android/gms/measurement/internal/zzal;
    //   138: aload_1
    //   139: getfield 1498	com/google/android/gms/measurement/internal/UserAttributeParcel:name	Ljava/lang/String;
    //   142: aload_1
    //   143: invokevirtual 1510	com/google/android/gms/measurement/internal/UserAttributeParcel:getValue	()Ljava/lang/Object;
    //   146: invokevirtual 1516	com/google/android/gms/measurement/internal/zzal:zzn	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   149: astore 5
    //   151: aload 5
    //   153: ifnull -135 -> 18
    //   156: new 1130	com/google/android/gms/measurement/internal/zzak
    //   159: dup
    //   160: aload_2
    //   161: getfield 600	com/google/android/gms/measurement/internal/AppMetadata:packageName	Ljava/lang/String;
    //   164: aload_1
    //   165: getfield 1498	com/google/android/gms/measurement/internal/UserAttributeParcel:name	Ljava/lang/String;
    //   168: aload_1
    //   169: getfield 1519	com/google/android/gms/measurement/internal/UserAttributeParcel:anQ	J
    //   172: aload 5
    //   174: invokespecial 1393	com/google/android/gms/measurement/internal/zzak:<init>	(Ljava/lang/String;Ljava/lang/String;JLjava/lang/Object;)V
    //   177: astore_1
    //   178: aload_0
    //   179: invokevirtual 121	com/google/android/gms/measurement/internal/zzx:zzbsz	()Lcom/google/android/gms/measurement/internal/zzp;
    //   182: invokevirtual 158	com/google/android/gms/measurement/internal/zzp:zzbtx	()Lcom/google/android/gms/measurement/internal/zzp$zza;
    //   185: ldc_w 1521
    //   188: aload_1
    //   189: getfield 1133	com/google/android/gms/measurement/internal/zzak:mName	Ljava/lang/String;
    //   192: aload 5
    //   194: invokevirtual 308	com/google/android/gms/measurement/internal/zzp$zza:zze	(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
    //   197: aload_0
    //   198: invokevirtual 396	com/google/android/gms/measurement/internal/zzx:zzbsu	()Lcom/google/android/gms/measurement/internal/zze;
    //   201: invokevirtual 399	com/google/android/gms/measurement/internal/zze:beginTransaction	()V
    //   204: aload_0
    //   205: aload_2
    //   206: invokespecial 1320	com/google/android/gms/measurement/internal/zzx:zze	(Lcom/google/android/gms/measurement/internal/AppMetadata;)V
    //   209: aload_0
    //   210: invokevirtual 396	com/google/android/gms/measurement/internal/zzx:zzbsu	()Lcom/google/android/gms/measurement/internal/zze;
    //   213: aload_1
    //   214: invokevirtual 1396	com/google/android/gms/measurement/internal/zze:zza	(Lcom/google/android/gms/measurement/internal/zzak;)Z
    //   217: istore 4
    //   219: aload_0
    //   220: invokevirtual 396	com/google/android/gms/measurement/internal/zzx:zzbsu	()Lcom/google/android/gms/measurement/internal/zze;
    //   223: invokevirtual 426	com/google/android/gms/measurement/internal/zze:setTransactionSuccessful	()V
    //   226: iload 4
    //   228: ifeq +32 -> 260
    //   231: aload_0
    //   232: invokevirtual 121	com/google/android/gms/measurement/internal/zzx:zzbsz	()Lcom/google/android/gms/measurement/internal/zzp;
    //   235: invokevirtual 158	com/google/android/gms/measurement/internal/zzp:zzbtx	()Lcom/google/android/gms/measurement/internal/zzp$zza;
    //   238: ldc_w 1523
    //   241: aload_1
    //   242: getfield 1133	com/google/android/gms/measurement/internal/zzak:mName	Ljava/lang/String;
    //   245: aload_1
    //   246: getfield 1143	com/google/android/gms/measurement/internal/zzak:zzcnr	Ljava/lang/Object;
    //   249: invokevirtual 308	com/google/android/gms/measurement/internal/zzp$zza:zze	(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
    //   252: aload_0
    //   253: invokevirtual 396	com/google/android/gms/measurement/internal/zzx:zzbsu	()Lcom/google/android/gms/measurement/internal/zze;
    //   256: invokevirtual 423	com/google/android/gms/measurement/internal/zze:endTransaction	()V
    //   259: return
    //   260: aload_0
    //   261: invokevirtual 121	com/google/android/gms/measurement/internal/zzx:zzbsz	()Lcom/google/android/gms/measurement/internal/zzp;
    //   264: invokevirtual 303	com/google/android/gms/measurement/internal/zzp:zzbtr	()Lcom/google/android/gms/measurement/internal/zzp$zza;
    //   267: ldc_w 1398
    //   270: aload_1
    //   271: getfield 1133	com/google/android/gms/measurement/internal/zzak:mName	Ljava/lang/String;
    //   274: aload_1
    //   275: getfield 1143	com/google/android/gms/measurement/internal/zzak:zzcnr	Ljava/lang/Object;
    //   278: invokevirtual 308	com/google/android/gms/measurement/internal/zzp$zza:zze	(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
    //   281: aload_0
    //   282: invokevirtual 543	com/google/android/gms/measurement/internal/zzx:zzbsv	()Lcom/google/android/gms/measurement/internal/zzal;
    //   285: bipush 9
    //   287: aconst_null
    //   288: aconst_null
    //   289: invokevirtual 753	com/google/android/gms/measurement/internal/zzal:zze	(ILjava/lang/String;Ljava/lang/String;)V
    //   292: goto -40 -> 252
    //   295: astore_1
    //   296: aload_0
    //   297: invokevirtual 396	com/google/android/gms/measurement/internal/zzx:zzbsu	()Lcom/google/android/gms/measurement/internal/zze;
    //   300: invokevirtual 423	com/google/android/gms/measurement/internal/zze:endTransaction	()V
    //   303: aload_1
    //   304: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	305	0	this	zzx
    //   0	305	1	paramUserAttributeParcel	UserAttributeParcel
    //   0	305	2	paramAppMetadata	AppMetadata
    //   43	83	3	i	int
    //   217	10	4	bool	boolean
    //   149	44	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   204	226	295	finally
    //   231	252	295	finally
    //   260	292	295	finally
  }
  
  void zzb(zzaa paramzzaa)
  {
    amK += 1;
  }
  
  void zzb(String paramString, int paramInt, Throwable paramThrowable, byte[] paramArrayOfByte, Map<String, List<String>> paramMap)
  {
    int j = 0;
    zzwu();
    zzzg();
    com.google.android.gms.common.internal.zzab.zzhs(paramString);
    byte[] arrayOfByte = paramArrayOfByte;
    if (paramArrayOfByte == null) {
      arrayOfByte = new byte[0];
    }
    zzbsu().beginTransaction();
    label90:
    label105:
    int i;
    for (;;)
    {
      try
      {
        paramArrayOfByte = zzbsu().zzlo(paramString);
        if ((paramInt == 200) || (paramInt == 204)) {
          break label471;
        }
        if (paramInt == 304)
        {
          break label471;
          if (paramArrayOfByte == null)
          {
            zzbsz().zzbtt().zzj("App does not exist in onConfigFetched", paramString);
            zzbsu().setTransactionSuccessful();
          }
        }
        else
        {
          i = 0;
          continue;
        }
        if ((i == 0) && (paramInt != 404)) {
          break;
        }
        if (paramMap != null)
        {
          paramThrowable = (List)paramMap.get("Last-Modified");
          if ((paramThrowable != null) && (paramThrowable.size() > 0))
          {
            paramThrowable = (String)paramThrowable.get(0);
            break label481;
            label169:
            if (zzbsw().zzmc(paramString) != null) {
              continue;
            }
            bool = zzbsw().zzb(paramString, null, null);
            if (bool) {
              continue;
            }
          }
        }
        else
        {
          paramThrowable = null;
          continue;
        }
        paramThrowable = null;
        break label481;
        label215:
        boolean bool = zzbsw().zzb(paramString, arrayOfByte, paramThrowable);
        if (!bool) {
          return;
        }
        paramArrayOfByte.zzaz(zzyw().currentTimeMillis());
        zzbsu().zza(paramArrayOfByte);
        if (paramInt == 404)
        {
          zzbsz().zzbtt().log("Config not found. Using empty config");
          if ((!zzbuo().zzadj()) || (!zzbuz())) {
            break label344;
          }
          zzbuy();
          continue;
        }
        zzbsz().zzbty().zze("Successfully fetched config. Got network response. code, size", Integer.valueOf(paramInt), Integer.valueOf(arrayOfByte.length));
      }
      finally
      {
        zzbsu().endTransaction();
      }
      continue;
      label344:
      zzbva();
    }
    paramArrayOfByte.zzba(zzyw().currentTimeMillis());
    zzbsu().zza(paramArrayOfByte);
    zzbsz().zzbty().zze("Fetching config failed. code, error", Integer.valueOf(paramInt), paramThrowable);
    zzbsw().zzme(paramString);
    zzbtaalw.set(zzyw().currentTimeMillis());
    if (paramInt != 503)
    {
      i = j;
      if (paramInt == 429) {}
    }
    for (;;)
    {
      if (i != 0) {
        zzbtaalx.set(zzyw().currentTimeMillis());
      }
      zzbva();
      break label90;
      label471:
      if (paramThrowable != null) {
        break label105;
      }
      i = 1;
      break;
      label481:
      if (paramInt == 404) {
        break label169;
      }
      if (paramInt != 304) {
        break label215;
      }
      break label169;
      i = 1;
    }
  }
  
  boolean zzbk(long paramLong)
  {
    return zzh(null, paramLong);
  }
  
  public zzc zzbsp()
  {
    zza(amD);
    return amD;
  }
  
  public zzac zzbsq()
  {
    zza(amz);
    return amz;
  }
  
  public zzn zzbsr()
  {
    zza(amA);
    return amA;
  }
  
  public zzg zzbss()
  {
    zza(amy);
    return amy;
  }
  
  public zzad zzbst()
  {
    zza(amx);
    return amx;
  }
  
  public zze zzbsu()
  {
    zza(amv);
    return amv;
  }
  
  public zzal zzbsv()
  {
    zza(amu);
    return amu;
  }
  
  public zzv zzbsw()
  {
    zza(ams);
    return ams;
  }
  
  public zzaf zzbsx()
  {
    zza(amr);
    return amr;
  }
  
  public zzw zzbsy()
  {
    zza(amq);
    return amq;
  }
  
  public zzp zzbsz()
  {
    zza(amp);
    return amp;
  }
  
  public zzt zzbta()
  {
    zza(amo);
    return amo;
  }
  
  public zzd zzbtb()
  {
    return amn;
  }
  
  protected boolean zzbuk()
  {
    zzzg();
    zzwu();
    if (amG == null) {
      if ((!zzbsv().zzep("android.permission.INTERNET")) || (!zzbsv().zzep("android.permission.ACCESS_NETWORK_STATE")) || (!zzu.zzav(getContext())) || (!zzae.zzaw(getContext()))) {
        break label120;
      }
    }
    label120:
    for (boolean bool = true;; bool = false)
    {
      amG = Boolean.valueOf(bool);
      if ((amG.booleanValue()) && (!zzbtb().zzabc())) {
        amG = Boolean.valueOf(zzbsv().zzmr(zzbsr().zzbqo()));
      }
      return amG.booleanValue();
    }
  }
  
  public zzp zzbul()
  {
    if ((amp != null) && (amp.isInitialized())) {
      return amp;
    }
    return null;
  }
  
  zzw zzbum()
  {
    return amq;
  }
  
  public AppMeasurement zzbun()
  {
    return amt;
  }
  
  public zzq zzbuo()
  {
    zza(amw);
    return amw;
  }
  
  public zzr zzbup()
  {
    if (amB == null) {
      throw new IllegalStateException("Network broadcast receiver not created");
    }
    return amB;
  }
  
  public zzai zzbuq()
  {
    zza(amC);
    return amC;
  }
  
  FileChannel zzbur()
  {
    return amI;
  }
  
  void zzbus()
  {
    zzwu();
    zzzg();
    if ((zzbve()) && (zzbut())) {
      zzu(zza(zzbur()), zzbsr().zzbtp());
    }
  }
  
  boolean zzbut()
  {
    zzwu();
    Object localObject = amv.zzaab();
    localObject = new File(getContext().getFilesDir(), (String)localObject);
    try
    {
      amI = new RandomAccessFile((File)localObject, "rw").getChannel();
      amH = amI.tryLock();
      if (amH != null)
      {
        zzbsz().zzbty().log("Storage concurrent access okay");
        return true;
      }
      zzbsz().zzbtr().log("Storage concurrent data access panic");
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      for (;;)
      {
        zzbsz().zzbtr().zzj("Failed to acquire storage lock", localFileNotFoundException);
      }
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        zzbsz().zzbtr().zzj("Failed to access storage lock file", localIOException);
      }
    }
    return false;
  }
  
  protected boolean zzbuu()
  {
    return false;
  }
  
  long zzbuv()
  {
    return (zzyw().currentTimeMillis() + zzbta().zzbuc()) / 1000L / 60L / 60L / 24L;
  }
  
  void zzbuw()
  {
    if (!zzbtb().zzabc()) {
      throw new IllegalStateException("Unexpected call on client side");
    }
  }
  
  public void zzbuy()
  {
    Object localObject4 = null;
    int j = 0;
    zzwu();
    zzzg();
    if (!zzbtb().zzabc())
    {
      localObject1 = zzbta().zzbuf();
      if (localObject1 == null) {
        zzbsz().zzbtt().log("Upload data called on the client side before use of service was decided");
      }
    }
    long l1;
    String str;
    int i;
    do
    {
      return;
      if (((Boolean)localObject1).booleanValue())
      {
        zzbsz().zzbtr().log("Upload called in the client side when service should be used");
        return;
      }
      if (zzbux())
      {
        zzbsz().zzbtt().log("Uploading requested multiple times");
        return;
      }
      if (!zzbuo().zzadj())
      {
        zzbsz().zzbtt().log("Network not connected, ignoring upload request");
        zzbva();
        return;
      }
      l1 = zzyw().currentTimeMillis();
      zzbk(l1 - zzbtb().zzbsh());
      long l2 = zzbtaalv.get();
      if (l2 != 0L) {
        zzbsz().zzbtx().zzj("Uploading events. Elapsed time since last upload attempt (ms)", Long.valueOf(Math.abs(l1 - l2)));
      }
      str = zzbsu().zzbtc();
      if (TextUtils.isEmpty(str)) {
        break;
      }
      i = zzbtb().zzlk(str);
      int k = zzbtb().zzll(str);
      localObject4 = zzbsu().zzn(str, i, k);
    } while (((List)localObject4).isEmpty());
    Object localObject1 = ((List)localObject4).iterator();
    Object localObject5;
    do
    {
      if (!((Iterator)localObject1).hasNext()) {
        break;
      }
      localObject5 = (zzup.zze)nextfirst;
    } while (TextUtils.isEmpty(apf));
    Object localObject3;
    for (localObject1 = apf;; localObject3 = null)
    {
      if (localObject1 != null)
      {
        i = 0;
        if (i < ((List)localObject4).size())
        {
          localObject5 = (zzup.zze)getfirst;
          if (TextUtils.isEmpty(apf)) {}
          while (apf.equals(localObject1))
          {
            i += 1;
            break;
          }
        }
      }
      for (localObject1 = ((List)localObject4).subList(0, i);; localObject3 = localObject4)
      {
        localObject5 = new zzup.zzd();
        aoP = new zzup.zze[((List)localObject1).size()];
        localObject4 = new ArrayList(((List)localObject1).size());
        i = j;
        while (i < aoP.length)
        {
          aoP[i] = ((zzup.zze)getfirst);
          ((List)localObject4).add((Long)getsecond);
          aoP[i].ape = Long.valueOf(zzbtb().zzbqv());
          aoP[i].aoU = Long.valueOf(l1);
          aoP[i].apk = Boolean.valueOf(zzbtb().zzabc());
          i += 1;
        }
        if (zzbsz().zzaz(2)) {}
        for (localObject1 = zzal.zzb((zzup.zzd)localObject5);; localObject3 = null)
        {
          Object localObject7 = zzbsv().zza((zzup.zzd)localObject5);
          Object localObject6 = zzbtb().zzbsg();
          Object localObject8;
          try
          {
            localObject8 = new URL((String)localObject6);
            zzad((List)localObject4);
            zzbtaalw.set(l1);
            localObject4 = "?";
            if (aoP.length > 0) {
              localObject4 = aoP[0].zzck;
            }
            zzbsz().zzbty().zzd("Uploading data. app, uncompressed size, data", localObject4, Integer.valueOf(localObject7.length), localObject1);
            zzbuo().zza(str, (URL)localObject8, (byte[])localObject7, null, new zzq.zza()
            {
              public void zza(String paramAnonymousString, int paramAnonymousInt, Throwable paramAnonymousThrowable, byte[] paramAnonymousArrayOfByte, Map<String, List<String>> paramAnonymousMap)
              {
                zzx.zza(zzx.this, paramAnonymousInt, paramAnonymousThrowable, paramAnonymousArrayOfByte);
              }
            });
            return;
          }
          catch (MalformedURLException localMalformedURLException1)
          {
            zzbsz().zzbtr().zzj("Failed to parse upload URL. Not uploading", localObject6);
            return;
          }
          localObject5 = zzbsu().zzbh(l1 - zzbtb().zzbsh());
          if (TextUtils.isEmpty((CharSequence)localObject5)) {
            break;
          }
          Object localObject2 = zzbsu().zzlo((String)localObject5);
          if (localObject2 == null) {
            break;
          }
          str = zzbtb().zzap(((zza)localObject2).zzbqo(), ((zza)localObject2).zzawj());
          try
          {
            localObject6 = new URL(str);
            zzbsz().zzbty().zzj("Fetching remote configuration", ((zza)localObject2).zzsi());
            localObject7 = zzbsw().zzmc(((zza)localObject2).zzsi());
            localObject8 = zzbsw().zzmd(((zza)localObject2).zzsi());
            localObject2 = localObject4;
            if (localObject7 != null)
            {
              localObject2 = localObject4;
              if (!TextUtils.isEmpty((CharSequence)localObject8))
              {
                localObject2 = new ArrayMap();
                ((Map)localObject2).put("If-Modified-Since", localObject8);
              }
            }
            zzbuo().zza((String)localObject5, (URL)localObject6, (Map)localObject2, new zzq.zza()
            {
              public void zza(String paramAnonymousString, int paramAnonymousInt, Throwable paramAnonymousThrowable, byte[] paramAnonymousArrayOfByte, Map<String, List<String>> paramAnonymousMap)
              {
                zzb(paramAnonymousString, paramAnonymousInt, paramAnonymousThrowable, paramAnonymousArrayOfByte, paramAnonymousMap);
              }
            });
            return;
          }
          catch (MalformedURLException localMalformedURLException2)
          {
            zzbsz().zzbtr().zzj("Failed to parse config URL. Not fetching", str);
            return;
          }
        }
      }
    }
  }
  
  void zzbvc()
  {
    amL += 1;
  }
  
  void zzbvd()
  {
    zzwu();
    zzzg();
    if (!amF)
    {
      zzbsz().zzbtw().log("This instance being marked as an uploader");
      zzbus();
    }
    amF = true;
  }
  
  boolean zzbve()
  {
    zzwu();
    zzzg();
    return (amF) || (zzbuu());
  }
  
  void zzc(AppMetadata paramAppMetadata)
  {
    zzwu();
    zzzg();
    com.google.android.gms.common.internal.zzab.zzhs(packageName);
    zze(paramAppMetadata);
  }
  
  void zzc(AppMetadata paramAppMetadata, long paramLong)
  {
    Bundle localBundle = new Bundle();
    localBundle.putLong("_et", 1L);
    zzb(new EventParcel("_e", new EventParams(localBundle), "auto", paramLong), paramAppMetadata);
  }
  
  void zzc(UserAttributeParcel paramUserAttributeParcel, AppMetadata paramAppMetadata)
  {
    zzwu();
    zzzg();
    if (TextUtils.isEmpty(ajz)) {
      return;
    }
    if (!ajE)
    {
      zze(paramAppMetadata);
      return;
    }
    zzbsz().zzbtx().zzj("Removing user property", name);
    zzbsu().beginTransaction();
    try
    {
      zze(paramAppMetadata);
      zzbsu().zzar(packageName, name);
      zzbsu().setTransactionSuccessful();
      zzbsz().zzbtx().zzj("User property removed", name);
      return;
    }
    finally
    {
      zzbsu().endTransaction();
    }
  }
  
  /* Error */
  public void zzd(AppMetadata paramAppMetadata)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 353	com/google/android/gms/measurement/internal/zzx:zzwu	()V
    //   4: aload_0
    //   5: invokevirtual 356	com/google/android/gms/measurement/internal/zzx:zzzg	()V
    //   8: aload_1
    //   9: invokestatic 81	com/google/android/gms/common/internal/zzab:zzaa	(Ljava/lang/Object;)Ljava/lang/Object;
    //   12: pop
    //   13: aload_1
    //   14: getfield 600	com/google/android/gms/measurement/internal/AppMetadata:packageName	Ljava/lang/String;
    //   17: invokestatic 467	com/google/android/gms/common/internal/zzab:zzhs	(Ljava/lang/String;)Ljava/lang/String;
    //   20: pop
    //   21: aload_1
    //   22: getfield 624	com/google/android/gms/measurement/internal/AppMetadata:ajz	Ljava/lang/String;
    //   25: invokestatic 505	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   28: ifeq +4 -> 32
    //   31: return
    //   32: aload_1
    //   33: getfield 692	com/google/android/gms/measurement/internal/AppMetadata:ajE	Z
    //   36: ifne +9 -> 45
    //   39: aload_0
    //   40: aload_1
    //   41: invokespecial 1320	com/google/android/gms/measurement/internal/zzx:zze	(Lcom/google/android/gms/measurement/internal/AppMetadata;)V
    //   44: return
    //   45: aload_0
    //   46: invokevirtual 370	com/google/android/gms/measurement/internal/zzx:zzyw	()Lcom/google/android/gms/common/util/zze;
    //   49: invokeinterface 375 1 0
    //   54: lstore_2
    //   55: aload_0
    //   56: invokevirtual 396	com/google/android/gms/measurement/internal/zzx:zzbsu	()Lcom/google/android/gms/measurement/internal/zze;
    //   59: invokevirtual 399	com/google/android/gms/measurement/internal/zze:beginTransaction	()V
    //   62: aload_0
    //   63: aload_1
    //   64: lload_2
    //   65: invokevirtual 1763	com/google/android/gms/measurement/internal/zzx:zza	(Lcom/google/android/gms/measurement/internal/AppMetadata;J)V
    //   68: aload_0
    //   69: aload_1
    //   70: invokespecial 1320	com/google/android/gms/measurement/internal/zzx:zze	(Lcom/google/android/gms/measurement/internal/AppMetadata;)V
    //   73: aload_0
    //   74: invokevirtual 396	com/google/android/gms/measurement/internal/zzx:zzbsu	()Lcom/google/android/gms/measurement/internal/zze;
    //   77: aload_1
    //   78: getfield 600	com/google/android/gms/measurement/internal/AppMetadata:packageName	Ljava/lang/String;
    //   81: ldc_w 1315
    //   84: invokevirtual 1239	com/google/android/gms/measurement/internal/zze:zzaq	(Ljava/lang/String;Ljava/lang/String;)Lcom/google/android/gms/measurement/internal/zzi;
    //   87: ifnonnull +63 -> 150
    //   90: aload_0
    //   91: new 1497	com/google/android/gms/measurement/internal/UserAttributeParcel
    //   94: dup
    //   95: ldc_w 1765
    //   98: lload_2
    //   99: lconst_1
    //   100: lload_2
    //   101: ldc2_w 1766
    //   104: ldiv
    //   105: ladd
    //   106: ldc2_w 1766
    //   109: lmul
    //   110: invokestatic 143	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   113: ldc_w 1024
    //   116: invokespecial 1770	com/google/android/gms/measurement/internal/UserAttributeParcel:<init>	(Ljava/lang/String;JLjava/lang/Object;Ljava/lang/String;)V
    //   119: aload_1
    //   120: invokevirtual 1772	com/google/android/gms/measurement/internal/zzx:zzb	(Lcom/google/android/gms/measurement/internal/UserAttributeParcel;Lcom/google/android/gms/measurement/internal/AppMetadata;)V
    //   123: aload_0
    //   124: aload_1
    //   125: lload_2
    //   126: invokevirtual 1774	com/google/android/gms/measurement/internal/zzx:zzb	(Lcom/google/android/gms/measurement/internal/AppMetadata;J)V
    //   129: aload_0
    //   130: aload_1
    //   131: lload_2
    //   132: invokevirtual 1776	com/google/android/gms/measurement/internal/zzx:zzc	(Lcom/google/android/gms/measurement/internal/AppMetadata;J)V
    //   135: aload_0
    //   136: invokevirtual 396	com/google/android/gms/measurement/internal/zzx:zzbsu	()Lcom/google/android/gms/measurement/internal/zze;
    //   139: invokevirtual 426	com/google/android/gms/measurement/internal/zze:setTransactionSuccessful	()V
    //   142: aload_0
    //   143: invokevirtual 396	com/google/android/gms/measurement/internal/zzx:zzbsu	()Lcom/google/android/gms/measurement/internal/zze;
    //   146: invokevirtual 423	com/google/android/gms/measurement/internal/zze:endTransaction	()V
    //   149: return
    //   150: aload_1
    //   151: getfield 1779	com/google/android/gms/measurement/internal/AppMetadata:ajF	Z
    //   154: ifeq -19 -> 135
    //   157: aload_0
    //   158: aload_1
    //   159: lload_2
    //   160: invokevirtual 1781	com/google/android/gms/measurement/internal/zzx:zzd	(Lcom/google/android/gms/measurement/internal/AppMetadata;J)V
    //   163: goto -28 -> 135
    //   166: astore_1
    //   167: aload_0
    //   168: invokevirtual 396	com/google/android/gms/measurement/internal/zzx:zzbsu	()Lcom/google/android/gms/measurement/internal/zze;
    //   171: invokevirtual 423	com/google/android/gms/measurement/internal/zze:endTransaction	()V
    //   174: aload_1
    //   175: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	176	0	this	zzx
    //   0	176	1	paramAppMetadata	AppMetadata
    //   54	106	2	l	long
    // Exception table:
    //   from	to	target	type
    //   62	135	166	finally
    //   135	142	166	finally
    //   150	163	166	finally
  }
  
  void zzd(AppMetadata paramAppMetadata, long paramLong)
  {
    zzb(new EventParcel("_cd", new EventParams(new Bundle()), "auto", paramLong), paramAppMetadata);
  }
  
  boolean zzu(int paramInt1, int paramInt2)
  {
    zzwu();
    if (paramInt1 > paramInt2)
    {
      zzbsz().zzbtr().zze("Panic: can't downgrade version. Previous, current version", Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
      return false;
    }
    if (paramInt1 < paramInt2)
    {
      if (zza(paramInt2, zzbur())) {
        zzbsz().zzbty().zze("Storage version upgraded. Previous, current version", Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
      }
    }
    else {
      return true;
    }
    zzbsz().zzbtr().zze("Storage version upgrade failed. Previous, current version", Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
    return false;
  }
  
  public void zzwu()
  {
    zzbsy().zzwu();
  }
  
  void zzyv()
  {
    if (zzbtb().zzabc()) {
      throw new IllegalStateException("Unexpected call on package side");
    }
  }
  
  public com.google.android.gms.common.util.zze zzyw()
  {
    return zzaoa;
  }
  
  void zzzg()
  {
    if (!zzcwt) {
      throw new IllegalStateException("AppMeasurement is not initialized");
    }
  }
  
  private class zza
    implements zze.zzb
  {
    zzup.zze amN;
    List<Long> amO;
    long amP;
    List<zzup.zzb> zzala;
    
    private zza() {}
    
    private long zza(zzup.zzb paramzzb)
    {
      return aoL.longValue() / 1000L / 60L / 60L;
    }
    
    boolean isEmpty()
    {
      return (zzala == null) || (zzala.isEmpty());
    }
    
    public boolean zza(long paramLong, zzup.zzb paramzzb)
    {
      com.google.android.gms.common.internal.zzab.zzaa(paramzzb);
      if (zzala == null) {
        zzala = new ArrayList();
      }
      if (amO == null) {
        amO = new ArrayList();
      }
      if ((zzala.size() > 0) && (zza((zzup.zzb)zzala.get(0)) != zza(paramzzb))) {
        return false;
      }
      long l = amP + paramzzb.ao();
      if (l >= zzbtb().zzbse()) {
        return false;
      }
      amP = l;
      zzala.add(paramzzb);
      amO.add(Long.valueOf(paramLong));
      return zzala.size() < zzbtb().zzbsf();
    }
    
    public void zzc(zzup.zze paramzze)
    {
      com.google.android.gms.common.internal.zzab.zzaa(paramzze);
      amN = paramzze;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.measurement.internal.zzx
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */