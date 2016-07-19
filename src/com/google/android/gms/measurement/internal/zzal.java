package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.common.util.zze;
import com.google.android.gms.internal.zzaov;
import com.google.android.gms.internal.zzun.zzb;
import com.google.android.gms.internal.zzun.zzc;
import com.google.android.gms.internal.zzun.zzd;
import com.google.android.gms.internal.zzun.zze;
import com.google.android.gms.internal.zzun.zzf;
import com.google.android.gms.internal.zzup.zza;
import com.google.android.gms.internal.zzup.zzb;
import com.google.android.gms.internal.zzup.zzc;
import com.google.android.gms.internal.zzup.zzd;
import com.google.android.gms.internal.zzup.zze;
import com.google.android.gms.internal.zzup.zzf;
import com.google.android.gms.internal.zzup.zzg;
import com.google.android.gms.measurement.AppMeasurement.zza;
import com.google.android.gms.measurement.AppMeasurement.zze;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.BitSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.zip.GZIPOutputStream;

public class zzal
  extends zzz
{
  zzal(zzx paramzzx)
  {
    super(paramzzx);
  }
  
  private Object zza(int paramInt, Object paramObject, boolean paramBoolean)
  {
    Object localObject;
    if (paramObject == null) {
      localObject = null;
    }
    do
    {
      do
      {
        return localObject;
        localObject = paramObject;
      } while ((paramObject instanceof Long));
      localObject = paramObject;
    } while ((paramObject instanceof Double));
    if ((paramObject instanceof Integer)) {
      return Long.valueOf(((Integer)paramObject).intValue());
    }
    if ((paramObject instanceof Byte)) {
      return Long.valueOf(((Byte)paramObject).byteValue());
    }
    if ((paramObject instanceof Short)) {
      return Long.valueOf(((Short)paramObject).shortValue());
    }
    if ((paramObject instanceof Boolean))
    {
      if (((Boolean)paramObject).booleanValue()) {}
      for (long l = 1L;; l = 0L) {
        return Long.valueOf(l);
      }
    }
    if ((paramObject instanceof Float)) {
      return Double.valueOf(((Float)paramObject).doubleValue());
    }
    if (((paramObject instanceof String)) || ((paramObject instanceof Character)) || ((paramObject instanceof CharSequence))) {
      return zza(String.valueOf(paramObject), paramInt, paramBoolean);
    }
    return null;
  }
  
  public static String zza(zzun.zzb paramzzb)
  {
    int i = 0;
    if (paramzzb == null) {
      return "null";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("\nevent_filter {\n");
    zza(localStringBuilder, 0, "filter_id", aoa);
    zza(localStringBuilder, 0, "event_name", aob);
    zza(localStringBuilder, 1, "event_count_filter", aoe);
    localStringBuilder.append("  filters {\n");
    paramzzb = aoc;
    int j = paramzzb.length;
    while (i < j)
    {
      zza(localStringBuilder, 2, paramzzb[i]);
      i += 1;
    }
    zza(localStringBuilder, 1);
    localStringBuilder.append("}\n}\n");
    return localStringBuilder.toString();
  }
  
  public static String zza(zzun.zze paramzze)
  {
    if (paramzze == null) {
      return "null";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("\nproperty_filter {\n");
    zza(localStringBuilder, 0, "filter_id", aoa);
    zza(localStringBuilder, 0, "property_name", aoq);
    zza(localStringBuilder, 1, aor);
    localStringBuilder.append("}\n");
    return localStringBuilder.toString();
  }
  
  private static void zza(StringBuilder paramStringBuilder, int paramInt)
  {
    int i = 0;
    while (i < paramInt)
    {
      paramStringBuilder.append("  ");
      i += 1;
    }
  }
  
  private static void zza(StringBuilder paramStringBuilder, int paramInt, zzun.zzc paramzzc)
  {
    if (paramzzc == null) {
      return;
    }
    zza(paramStringBuilder, paramInt);
    paramStringBuilder.append("filter {\n");
    zza(paramStringBuilder, paramInt, "complement", aoi);
    zza(paramStringBuilder, paramInt, "param_name", aoj);
    zza(paramStringBuilder, paramInt + 1, "string_filter", aog);
    zza(paramStringBuilder, paramInt + 1, "number_filter", aoh);
    zza(paramStringBuilder, paramInt);
    paramStringBuilder.append("}\n");
  }
  
  private static void zza(StringBuilder paramStringBuilder, int paramInt, zzup.zze paramzze)
  {
    if (paramzze == null) {
      return;
    }
    zza(paramStringBuilder, paramInt);
    paramStringBuilder.append("bundle {\n");
    zza(paramStringBuilder, paramInt, "protocol_version", aoR);
    zza(paramStringBuilder, paramInt, "platform", aoZ);
    zza(paramStringBuilder, paramInt, "gmp_version", apd);
    zza(paramStringBuilder, paramInt, "uploading_gmp_version", ape);
    zza(paramStringBuilder, paramInt, "gmp_app_id", ajz);
    zza(paramStringBuilder, paramInt, "app_id", zzck);
    zza(paramStringBuilder, paramInt, "app_version", abU);
    zza(paramStringBuilder, paramInt, "app_version_major", apm);
    zza(paramStringBuilder, paramInt, "firebase_instance_id", ajH);
    zza(paramStringBuilder, paramInt, "dev_cert_hash", api);
    zza(paramStringBuilder, paramInt, "app_store", ajA);
    zza(paramStringBuilder, paramInt, "upload_timestamp_millis", aoU);
    zza(paramStringBuilder, paramInt, "start_timestamp_millis", aoV);
    zza(paramStringBuilder, paramInt, "end_timestamp_millis", aoW);
    zza(paramStringBuilder, paramInt, "previous_bundle_start_timestamp_millis", aoX);
    zza(paramStringBuilder, paramInt, "previous_bundle_end_timestamp_millis", aoY);
    zza(paramStringBuilder, paramInt, "app_instance_id", aph);
    zza(paramStringBuilder, paramInt, "resettable_device_id", apf);
    zza(paramStringBuilder, paramInt, "device_id", app);
    zza(paramStringBuilder, paramInt, "limited_ad_tracking", apg);
    zza(paramStringBuilder, paramInt, "os_version", zzct);
    zza(paramStringBuilder, paramInt, "device_model", apa);
    zza(paramStringBuilder, paramInt, "user_default_language", apb);
    zza(paramStringBuilder, paramInt, "time_zone_offset_minutes", apc);
    zza(paramStringBuilder, paramInt, "bundle_sequential_index", apj);
    zza(paramStringBuilder, paramInt, "service_upload", apk);
    zza(paramStringBuilder, paramInt, "health_monitor", ajD);
    zza(paramStringBuilder, paramInt, aoT);
    zza(paramStringBuilder, paramInt, apl);
    zza(paramStringBuilder, paramInt, aoS);
    zza(paramStringBuilder, paramInt);
    paramStringBuilder.append("}\n");
  }
  
  private static void zza(StringBuilder paramStringBuilder, int paramInt, String paramString, zzun.zzd paramzzd)
  {
    if (paramzzd == null) {
      return;
    }
    zza(paramStringBuilder, paramInt);
    paramStringBuilder.append(paramString);
    paramStringBuilder.append(" {\n");
    if (aok != null)
    {
      paramString = "UNKNOWN_COMPARISON_TYPE";
      switch (aok.intValue())
      {
      }
    }
    for (;;)
    {
      zza(paramStringBuilder, paramInt, "comparison_type", paramString);
      zza(paramStringBuilder, paramInt, "match_as_float", aol);
      zza(paramStringBuilder, paramInt, "comparison_value", aom);
      zza(paramStringBuilder, paramInt, "min_comparison_value", aon);
      zza(paramStringBuilder, paramInt, "max_comparison_value", aoo);
      zza(paramStringBuilder, paramInt);
      paramStringBuilder.append("}\n");
      return;
      paramString = "LESS_THAN";
      continue;
      paramString = "GREATER_THAN";
      continue;
      paramString = "EQUAL";
      continue;
      paramString = "BETWEEN";
    }
  }
  
  private static void zza(StringBuilder paramStringBuilder, int paramInt, String paramString, zzun.zzf paramzzf)
  {
    if (paramzzf == null) {
      return;
    }
    zza(paramStringBuilder, paramInt);
    paramStringBuilder.append(paramString);
    paramStringBuilder.append(" {\n");
    if (aos != null)
    {
      paramString = "UNKNOWN_MATCH_TYPE";
      switch (aos.intValue())
      {
      }
    }
    for (;;)
    {
      zza(paramStringBuilder, paramInt, "match_type", paramString);
      zza(paramStringBuilder, paramInt, "expression", aot);
      zza(paramStringBuilder, paramInt, "case_sensitive", aou);
      if (aov.length <= 0) {
        break label239;
      }
      zza(paramStringBuilder, paramInt + 1);
      paramStringBuilder.append("expression_list {\n");
      paramString = aov;
      int j = paramString.length;
      int i = 0;
      while (i < j)
      {
        paramzzf = paramString[i];
        zza(paramStringBuilder, paramInt + 2);
        paramStringBuilder.append(paramzzf);
        paramStringBuilder.append("\n");
        i += 1;
      }
      paramString = "REGEXP";
      continue;
      paramString = "BEGINS_WITH";
      continue;
      paramString = "ENDS_WITH";
      continue;
      paramString = "PARTIAL";
      continue;
      paramString = "EXACT";
      continue;
      paramString = "IN_LIST";
    }
    paramStringBuilder.append("}\n");
    label239:
    zza(paramStringBuilder, paramInt);
    paramStringBuilder.append("}\n");
  }
  
  private static void zza(StringBuilder paramStringBuilder, int paramInt, String paramString, zzup.zzf paramzzf)
  {
    int j = 0;
    if (paramzzf == null) {
      return;
    }
    int k = paramInt + 1;
    zza(paramStringBuilder, k);
    paramStringBuilder.append(paramString);
    paramStringBuilder.append(" {\n");
    int m;
    int i;
    long l;
    if (apr != null)
    {
      zza(paramStringBuilder, k + 1);
      paramStringBuilder.append("results: ");
      paramString = apr;
      m = paramString.length;
      i = 0;
      paramInt = 0;
      while (i < m)
      {
        l = paramString[i];
        if (paramInt != 0) {
          paramStringBuilder.append(", ");
        }
        paramStringBuilder.append(Long.valueOf(l));
        i += 1;
        paramInt += 1;
      }
      paramStringBuilder.append('\n');
    }
    if (apq != null)
    {
      zza(paramStringBuilder, k + 1);
      paramStringBuilder.append("status: ");
      paramString = apq;
      m = paramString.length;
      paramInt = 0;
      i = j;
      while (i < m)
      {
        l = paramString[i];
        if (paramInt != 0) {
          paramStringBuilder.append(", ");
        }
        paramStringBuilder.append(Long.valueOf(l));
        i += 1;
        paramInt += 1;
      }
      paramStringBuilder.append('\n');
    }
    zza(paramStringBuilder, k);
    paramStringBuilder.append("}\n");
  }
  
  private static void zza(StringBuilder paramStringBuilder, int paramInt, String paramString, Object paramObject)
  {
    if (paramObject == null) {
      return;
    }
    zza(paramStringBuilder, paramInt + 1);
    paramStringBuilder.append(paramString);
    paramStringBuilder.append(": ");
    paramStringBuilder.append(paramObject);
    paramStringBuilder.append('\n');
  }
  
  private static void zza(StringBuilder paramStringBuilder, int paramInt, zzup.zza[] paramArrayOfzza)
  {
    if (paramArrayOfzza == null) {
      return;
    }
    int i = paramInt + 1;
    int j = paramArrayOfzza.length;
    paramInt = 0;
    label15:
    zzup.zza localzza;
    if (paramInt < j)
    {
      localzza = paramArrayOfzza[paramInt];
      if (localzza != null) {
        break label38;
      }
    }
    for (;;)
    {
      paramInt += 1;
      break label15;
      break;
      label38:
      zza(paramStringBuilder, i);
      paramStringBuilder.append("audience_membership {\n");
      zza(paramStringBuilder, i, "audience_id", anW);
      zza(paramStringBuilder, i, "new_audience", aoI);
      zza(paramStringBuilder, i, "current_data", aoG);
      zza(paramStringBuilder, i, "previous_data", aoH);
      zza(paramStringBuilder, i);
      paramStringBuilder.append("}\n");
    }
  }
  
  private static void zza(StringBuilder paramStringBuilder, int paramInt, zzup.zzb[] paramArrayOfzzb)
  {
    if (paramArrayOfzzb == null) {
      return;
    }
    int i = paramInt + 1;
    int j = paramArrayOfzzb.length;
    paramInt = 0;
    label15:
    zzup.zzb localzzb;
    if (paramInt < j)
    {
      localzzb = paramArrayOfzzb[paramInt];
      if (localzzb != null) {
        break label38;
      }
    }
    for (;;)
    {
      paramInt += 1;
      break label15;
      break;
      label38:
      zza(paramStringBuilder, i);
      paramStringBuilder.append("event {\n");
      zza(paramStringBuilder, i, "name", name);
      zza(paramStringBuilder, i, "timestamp_millis", aoL);
      zza(paramStringBuilder, i, "previous_timestamp_millis", aoM);
      zza(paramStringBuilder, i, "count", count);
      zza(paramStringBuilder, i, aoK);
      zza(paramStringBuilder, i);
      paramStringBuilder.append("}\n");
    }
  }
  
  private static void zza(StringBuilder paramStringBuilder, int paramInt, zzup.zzc[] paramArrayOfzzc)
  {
    if (paramArrayOfzzc == null) {
      return;
    }
    int i = paramInt + 1;
    int j = paramArrayOfzzc.length;
    paramInt = 0;
    label15:
    zzup.zzc localzzc;
    if (paramInt < j)
    {
      localzzc = paramArrayOfzzc[paramInt];
      if (localzzc != null) {
        break label38;
      }
    }
    for (;;)
    {
      paramInt += 1;
      break label15;
      break;
      label38:
      zza(paramStringBuilder, i);
      paramStringBuilder.append("param {\n");
      zza(paramStringBuilder, i, "name", name);
      zza(paramStringBuilder, i, "string_value", zr);
      zza(paramStringBuilder, i, "int_value", aoO);
      zza(paramStringBuilder, i, "double_value", anT);
      zza(paramStringBuilder, i);
      paramStringBuilder.append("}\n");
    }
  }
  
  private static void zza(StringBuilder paramStringBuilder, int paramInt, zzup.zzg[] paramArrayOfzzg)
  {
    if (paramArrayOfzzg == null) {
      return;
    }
    int i = paramInt + 1;
    int j = paramArrayOfzzg.length;
    paramInt = 0;
    label15:
    zzup.zzg localzzg;
    if (paramInt < j)
    {
      localzzg = paramArrayOfzzg[paramInt];
      if (localzzg != null) {
        break label38;
      }
    }
    for (;;)
    {
      paramInt += 1;
      break label15;
      break;
      label38:
      zza(paramStringBuilder, i);
      paramStringBuilder.append("user_property {\n");
      zza(paramStringBuilder, i, "set_timestamp_millis", apt);
      zza(paramStringBuilder, i, "name", name);
      zza(paramStringBuilder, i, "string_value", zr);
      zza(paramStringBuilder, i, "int_value", aoO);
      zza(paramStringBuilder, i, "double_value", anT);
      zza(paramStringBuilder, i);
      paramStringBuilder.append("}\n");
    }
  }
  
  public static boolean zza(long[] paramArrayOfLong, int paramInt)
  {
    if (paramInt >= paramArrayOfLong.length * 64) {}
    while ((paramArrayOfLong[(paramInt / 64)] & 1L << paramInt % 64) == 0L) {
      return false;
    }
    return true;
  }
  
  public static long[] zza(BitSet paramBitSet)
  {
    int k = (paramBitSet.length() + 63) / 64;
    long[] arrayOfLong = new long[k];
    int i = 0;
    if (i < k)
    {
      arrayOfLong[i] = 0L;
      int j = 0;
      for (;;)
      {
        if ((j >= 64) || (i * 64 + j >= paramBitSet.length()))
        {
          i += 1;
          break;
        }
        if (paramBitSet.get(i * 64 + j)) {
          arrayOfLong[i] |= 1L << j;
        }
        j += 1;
      }
    }
    return arrayOfLong;
  }
  
  static long zzac(byte[] paramArrayOfByte)
  {
    int j = 0;
    zzab.zzaa(paramArrayOfByte);
    if (paramArrayOfByte.length > 0) {}
    long l;
    for (boolean bool = true;; bool = false)
    {
      zzab.zzbm(bool);
      l = 0L;
      int i = paramArrayOfByte.length - 1;
      while ((i >= 0) && (i >= paramArrayOfByte.length - 8))
      {
        l += ((paramArrayOfByte[i] & 0xFF) << j);
        j += 8;
        i -= 1;
      }
    }
    return l;
  }
  
  public static boolean zzam(Bundle paramBundle)
  {
    return paramBundle.getLong("_c") == 1L;
  }
  
  public static String zzb(zzup.zzd paramzzd)
  {
    if (paramzzd == null) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("\nbatch {\n");
    if (aoP != null)
    {
      paramzzd = aoP;
      int j = paramzzd.length;
      int i = 0;
      if (i < j)
      {
        zzup.zze localzze = paramzzd[i];
        if (localzze == null) {}
        for (;;)
        {
          i += 1;
          break;
          zza(localStringBuilder, 1, localzze);
        }
      }
    }
    localStringBuilder.append("}\n");
    return localStringBuilder.toString();
  }
  
  public static boolean zzb(Context paramContext, String paramString, boolean paramBoolean)
  {
    try
    {
      paramContext = paramContext.getPackageManager().getReceiverInfo(new ComponentName(paramContext, paramString), 2);
      if ((paramContext != null) && (enabled)) {
        if (paramBoolean)
        {
          paramBoolean = exported;
          if (!paramBoolean) {}
        }
        else
        {
          return true;
        }
      }
    }
    catch (PackageManager.NameNotFoundException paramContext) {}
    return false;
  }
  
  public static boolean zzbb(String paramString1, String paramString2)
  {
    if ((paramString1 == null) && (paramString2 == null)) {
      return true;
    }
    if (paramString1 == null) {
      return false;
    }
    return paramString1.equals(paramString2);
  }
  
  static MessageDigest zzfb(String paramString)
  {
    int i = 0;
    while (i < 2) {
      try
      {
        MessageDigest localMessageDigest = MessageDigest.getInstance(paramString);
        if (localMessageDigest != null) {
          return localMessageDigest;
        }
      }
      catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
      {
        i += 1;
      }
    }
    return null;
  }
  
  public static boolean zzk(Context paramContext, String paramString)
  {
    try
    {
      paramContext = paramContext.getPackageManager().getServiceInfo(new ComponentName(paramContext, paramString), 4);
      if (paramContext != null)
      {
        boolean bool = enabled;
        if (bool) {
          return true;
        }
      }
    }
    catch (PackageManager.NameNotFoundException paramContext) {}
    return false;
  }
  
  static boolean zzmk(String paramString)
  {
    boolean bool = false;
    zzab.zzhs(paramString);
    if (paramString.charAt(0) != '_') {
      bool = true;
    }
    return bool;
  }
  
  private int zzmt(String paramString)
  {
    if ("_ldl".equals(paramString)) {
      return zzbtb().zzbrp();
    }
    return zzbtb().zzbro();
  }
  
  public static boolean zzmu(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && (paramString.startsWith("_"));
  }
  
  public Bundle zza(String paramString, Bundle paramBundle, List<String> paramList, boolean paramBoolean)
  {
    Bundle localBundle = null;
    int m;
    int i;
    String str1;
    int j;
    if (paramBundle != null)
    {
      localBundle = new Bundle(paramBundle);
      m = zzbtb().zzbri();
      Iterator localIterator = paramBundle.keySet().iterator();
      i = 0;
      if (localIterator.hasNext())
      {
        str1 = (String)localIterator.next();
        if ((paramList != null) && (paramList.contains(str1))) {
          break label331;
        }
        if (!paramBoolean) {
          break label325;
        }
        j = zzmp(str1);
        label90:
        k = j;
        if (j != 0) {}
      }
    }
    label325:
    label331:
    for (int k = zzmq(str1);; k = 0)
    {
      if (k != 0)
      {
        if (zzd(localBundle, k)) {
          localBundle.putString("_ev", zza(str1, zzbtb().zzbrl(), true));
        }
        localBundle.remove(str1);
        break;
      }
      if ((!zzk(str1, paramBundle.get(str1))) && (!"_ev".equals(str1)))
      {
        if (zzd(localBundle, 4)) {
          localBundle.putString("_ev", zza(str1, zzbtb().zzbrl(), true));
        }
        localBundle.remove(str1);
        break;
      }
      j = i;
      if (zzmk(str1))
      {
        i += 1;
        j = i;
        if (i > m)
        {
          String str2 = 48 + "Event can't contain more then " + m + " params";
          zzbsz().zzbtr().zze(str2, paramString, paramBundle);
          zzd(localBundle, 5);
          localBundle.remove(str1);
          break;
        }
      }
      i = j;
      break;
      return localBundle;
      j = 0;
      break label90;
    }
  }
  
  public String zza(String paramString, int paramInt, boolean paramBoolean)
  {
    String str = paramString;
    if (paramString.length() > paramInt)
    {
      if (paramBoolean) {
        str = String.valueOf(paramString.substring(0, paramInt)).concat("...");
      }
    }
    else {
      return str;
    }
    return null;
  }
  
  public void zza(Bundle paramBundle, String paramString, Object paramObject)
  {
    if (paramBundle == null) {}
    do
    {
      return;
      if ((paramObject instanceof Long))
      {
        paramBundle.putLong(paramString, ((Long)paramObject).longValue());
        return;
      }
      if ((paramObject instanceof String))
      {
        paramBundle.putString(paramString, String.valueOf(paramObject));
        return;
      }
      if ((paramObject instanceof Double))
      {
        paramBundle.putDouble(paramString, ((Double)paramObject).doubleValue());
        return;
      }
    } while (paramString == null);
    if (paramObject != null) {}
    for (paramBundle = paramObject.getClass().getSimpleName();; paramBundle = null)
    {
      zzbsz().zzbtv().zze("Not putting event parameter. Invalid value type. name, type", paramString, paramBundle);
      return;
    }
  }
  
  public void zza(zzup.zzc paramzzc, Object paramObject)
  {
    zzab.zzaa(paramObject);
    zr = null;
    aoO = null;
    anT = null;
    if ((paramObject instanceof String))
    {
      zr = ((String)paramObject);
      return;
    }
    if ((paramObject instanceof Long))
    {
      aoO = ((Long)paramObject);
      return;
    }
    if ((paramObject instanceof Double))
    {
      anT = ((Double)paramObject);
      return;
    }
    zzbsz().zzbtr().zzj("Ignoring invalid (type) event param value", paramObject);
  }
  
  public void zza(zzup.zzg paramzzg, Object paramObject)
  {
    zzab.zzaa(paramObject);
    zr = null;
    aoO = null;
    anT = null;
    if ((paramObject instanceof String))
    {
      zr = ((String)paramObject);
      return;
    }
    if ((paramObject instanceof Long))
    {
      aoO = ((Long)paramObject);
      return;
    }
    if ((paramObject instanceof Double))
    {
      anT = ((Double)paramObject);
      return;
    }
    zzbsz().zzbtr().zzj("Ignoring invalid (type) user attribute value", paramObject);
  }
  
  boolean zza(String paramString1, String paramString2, int paramInt, Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      do
      {
        return true;
      } while (((paramObject instanceof Long)) || ((paramObject instanceof Float)) || ((paramObject instanceof Integer)) || ((paramObject instanceof Byte)) || ((paramObject instanceof Short)) || ((paramObject instanceof Boolean)) || ((paramObject instanceof Double)));
      if ((!(paramObject instanceof String)) && (!(paramObject instanceof Character)) && (!(paramObject instanceof CharSequence))) {
        break;
      }
      paramObject = String.valueOf(paramObject);
    } while (((String)paramObject).length() <= paramInt);
    zzbsz().zzbtt().zzd("Value is too long; discarded. Value kind, name, value length", paramString1, paramString2, Integer.valueOf(((String)paramObject).length()));
    return false;
    return false;
  }
  
  public byte[] zza(zzup.zzd paramzzd)
  {
    try
    {
      byte[] arrayOfByte = new byte[paramzzd.ao()];
      zzaov localzzaov = zzaov.zzba(arrayOfByte);
      paramzzd.zza(localzzaov);
      localzzaov.ab();
      return arrayOfByte;
    }
    catch (IOException paramzzd)
    {
      zzbsz().zzbtr().zzj("Data loss. Failed to serialize batch", paramzzd);
    }
    return null;
  }
  
  /* Error */
  public byte[] zzab(byte[] paramArrayOfByte)
    throws IOException
  {
    // Byte code:
    //   0: new 844	java/io/ByteArrayInputStream
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 847	java/io/ByteArrayInputStream:<init>	([B)V
    //   8: astore_1
    //   9: new 849	java/util/zip/GZIPInputStream
    //   12: dup
    //   13: aload_1
    //   14: invokespecial 852	java/util/zip/GZIPInputStream:<init>	(Ljava/io/InputStream;)V
    //   17: astore_3
    //   18: new 854	java/io/ByteArrayOutputStream
    //   21: dup
    //   22: invokespecial 855	java/io/ByteArrayOutputStream:<init>	()V
    //   25: astore 4
    //   27: sipush 1024
    //   30: newarray <illegal type>
    //   32: astore 5
    //   34: aload_3
    //   35: aload 5
    //   37: invokevirtual 859	java/util/zip/GZIPInputStream:read	([B)I
    //   40: istore_2
    //   41: iload_2
    //   42: ifgt +17 -> 59
    //   45: aload_3
    //   46: invokevirtual 862	java/util/zip/GZIPInputStream:close	()V
    //   49: aload_1
    //   50: invokevirtual 863	java/io/ByteArrayInputStream:close	()V
    //   53: aload 4
    //   55: invokevirtual 867	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   58: areturn
    //   59: aload 4
    //   61: aload 5
    //   63: iconst_0
    //   64: iload_2
    //   65: invokevirtual 871	java/io/ByteArrayOutputStream:write	([BII)V
    //   68: goto -34 -> 34
    //   71: astore_1
    //   72: aload_0
    //   73: invokevirtual 744	com/google/android/gms/measurement/internal/zzal:zzbsz	()Lcom/google/android/gms/measurement/internal/zzp;
    //   76: invokevirtual 750	com/google/android/gms/measurement/internal/zzp:zzbtr	()Lcom/google/android/gms/measurement/internal/zzp$zza;
    //   79: ldc_w 873
    //   82: aload_1
    //   83: invokevirtual 805	com/google/android/gms/measurement/internal/zzp$zza:zzj	(Ljava/lang/String;Ljava/lang/Object;)V
    //   86: aload_1
    //   87: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	88	0	this	zzal
    //   0	88	1	paramArrayOfByte	byte[]
    //   40	25	2	i	int
    //   17	29	3	localGZIPInputStream	java.util.zip.GZIPInputStream
    //   25	35	4	localByteArrayOutputStream	ByteArrayOutputStream
    //   32	30	5	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   0	34	71	java/io/IOException
    //   34	41	71	java/io/IOException
    //   45	59	71	java/io/IOException
    //   59	68	71	java/io/IOException
  }
  
  public long zzad(byte[] paramArrayOfByte)
  {
    zzab.zzaa(paramArrayOfByte);
    MessageDigest localMessageDigest = zzfb("MD5");
    if (localMessageDigest == null)
    {
      zzbsz().zzbtr().log("Failed to get MD5");
      return 0L;
    }
    return zzac(localMessageDigest.digest(paramArrayOfByte));
  }
  
  boolean zzaz(String paramString1, String paramString2)
  {
    boolean bool2 = true;
    boolean bool1;
    if (paramString2 == null)
    {
      zzbsz().zzbtr().zzj("Name is required and can't be null. Type", paramString1);
      bool1 = false;
      return bool1;
    }
    if (paramString2.length() == 0)
    {
      zzbsz().zzbtr().zzj("Name is required and can't be empty. Type", paramString1);
      return false;
    }
    if (!Character.isLetter(paramString2.charAt(0)))
    {
      zzbsz().zzbtr().zze("Name must start with a letter. Type, name", paramString1, paramString2);
      return false;
    }
    int i = 1;
    for (;;)
    {
      bool1 = bool2;
      if (i >= paramString2.length()) {
        break;
      }
      char c = paramString2.charAt(i);
      if ((c != '_') && (!Character.isLetterOrDigit(c)))
      {
        zzbsz().zzbtr().zze("Name must consist of letters, digits or _ (underscores). Type, name", paramString1, paramString2);
        return false;
      }
      i += 1;
    }
  }
  
  boolean zzba(String paramString1, String paramString2)
  {
    boolean bool2 = true;
    boolean bool1;
    if (paramString2 == null)
    {
      zzbsz().zzbtr().zzj("Name is required and can't be null. Type", paramString1);
      bool1 = false;
      return bool1;
    }
    if (paramString2.length() == 0)
    {
      zzbsz().zzbtr().zzj("Name is required and can't be empty. Type", paramString1);
      return false;
    }
    char c = paramString2.charAt(0);
    if ((!Character.isLetter(c)) && (c != '_'))
    {
      zzbsz().zzbtr().zze("Name must start with a letter or _ (underscores). Type, name", paramString1, paramString2);
      return false;
    }
    int i = 1;
    for (;;)
    {
      bool1 = bool2;
      if (i >= paramString2.length()) {
        break;
      }
      c = paramString2.charAt(i);
      if ((c != '_') && (!Character.isLetterOrDigit(c)))
      {
        zzbsz().zzbtr().zze("Name must start with a letter or _ (underscores). Type, name", paramString1, paramString2);
        return false;
      }
      i += 1;
    }
  }
  
  boolean zzc(String paramString1, int paramInt, String paramString2)
  {
    if (paramString2 == null)
    {
      zzbsz().zzbtr().zzj("Name is required and can't be null. Type", paramString1);
      return false;
    }
    if (paramString2.length() > paramInt)
    {
      zzbsz().zzbtr().zzd("Name is too long. Type, maximum supported length, name", paramString1, Integer.valueOf(paramInt), paramString2);
      return false;
    }
    return true;
  }
  
  boolean zzc(String paramString1, Map<String, String> paramMap, String paramString2)
  {
    if (paramString2 == null)
    {
      zzbsz().zzbtr().zzj("Name is required and can't be null. Type", paramString1);
      return false;
    }
    if (paramString2.startsWith("firebase_"))
    {
      zzbsz().zzbtr().zze("Name starts with reserved prefix. Type, name", paramString1, paramString2);
      return false;
    }
    if ((paramMap != null) && (paramMap.containsKey(paramString2)))
    {
      zzbsz().zzbtr().zze("Name is reserved. Type, name", paramString1, paramString2);
      return false;
    }
    return true;
  }
  
  public boolean zzd(Bundle paramBundle, int paramInt)
  {
    if (paramBundle == null) {}
    while (paramBundle.getLong("_err") != 0L) {
      return false;
    }
    paramBundle.putLong("_err", paramInt);
    return true;
  }
  
  public void zze(int paramInt, String paramString1, String paramString2)
  {
    Bundle localBundle = new Bundle();
    zzd(localBundle, paramInt);
    if (!TextUtils.isEmpty(paramString1)) {
      localBundle.putString(paramString1, paramString2);
    }
    aja.zzbsq().zze("auto", "_err", localBundle);
  }
  
  public boolean zzep(String paramString)
  {
    zzwu();
    if (getContext().checkCallingOrSelfPermission(paramString) == 0) {
      return true;
    }
    zzbsz().zzbtx().zzj("Permission not granted", paramString);
    return false;
  }
  
  public boolean zzg(long paramLong1, long paramLong2)
  {
    if ((paramLong1 == 0L) || (paramLong2 <= 0L)) {}
    while (Math.abs(zzyw().currentTimeMillis() - paramLong1) > paramLong2) {
      return true;
    }
    return false;
  }
  
  public byte[] zzj(byte[] paramArrayOfByte)
    throws IOException
  {
    try
    {
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      GZIPOutputStream localGZIPOutputStream = new GZIPOutputStream(localByteArrayOutputStream);
      localGZIPOutputStream.write(paramArrayOfByte);
      localGZIPOutputStream.close();
      localByteArrayOutputStream.close();
      paramArrayOfByte = localByteArrayOutputStream.toByteArray();
      return paramArrayOfByte;
    }
    catch (IOException paramArrayOfByte)
    {
      zzbsz().zzbtr().zzj("Failed to gzip content", paramArrayOfByte);
      throw paramArrayOfByte;
    }
  }
  
  public boolean zzk(String paramString, Object paramObject)
  {
    if (zzmu(paramString)) {
      return zza("param", paramString, zzbtb().zzbrn(), paramObject);
    }
    return zza("param", paramString, zzbtb().zzbrm(), paramObject);
  }
  
  public Object zzl(String paramString, Object paramObject)
  {
    if ("_ev".equals(paramString)) {
      return zza(zzbtb().zzbrn(), paramObject, true);
    }
    if (zzmu(paramString)) {}
    for (int i = zzbtb().zzbrn();; i = zzbtb().zzbrm()) {
      return zza(i, paramObject, false);
    }
  }
  
  public int zzm(String paramString, Object paramObject)
  {
    if ("_ldl".equals(paramString)) {}
    for (boolean bool = zza("user property referrer", paramString, zzmt(paramString), paramObject); bool; bool = zza("user property", paramString, zzmt(paramString), paramObject)) {
      return 0;
    }
    return 7;
  }
  
  public int zzmm(String paramString)
  {
    if (!zzba("event", paramString)) {}
    do
    {
      return 2;
      if (!zzc("event", AppMeasurement.zza.ajb, paramString)) {
        return 13;
      }
    } while (!zzc("event", zzbtb().zzbrj(), paramString));
    return 0;
  }
  
  public int zzmo(String paramString)
  {
    if (!zzba("user property", paramString)) {}
    do
    {
      return 6;
      if (!zzc("user property", AppMeasurement.zze.ajd, paramString)) {
        return 15;
      }
    } while (!zzc("user property", zzbtb().zzbrk(), paramString));
    return 0;
  }
  
  public int zzmp(String paramString)
  {
    if (!zzaz("event param", paramString)) {}
    do
    {
      return 3;
      if (!zzc("event param", null, paramString)) {
        return 14;
      }
    } while (!zzc("event param", zzbtb().zzbrl(), paramString));
    return 0;
  }
  
  public int zzmq(String paramString)
  {
    if (!zzba("event param", paramString)) {}
    do
    {
      return 3;
      if (!zzc("event param", null, paramString)) {
        return 14;
      }
    } while (!zzc("event param", zzbtb().zzbrl(), paramString));
    return 0;
  }
  
  public boolean zzmr(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      zzbsz().zzbtr().log("Measurement Service called without google_app_id");
      return false;
    }
    if (!paramString.startsWith("1:"))
    {
      zzbsz().zzbtt().zzj("Measurement Service called with unknown id version", paramString);
      return true;
    }
    if (!zzms(paramString))
    {
      zzbsz().zzbtr().zzj("Invalid google_app_id. Firebase Analytics disabled. See", "https://goo.gl/FZRIUV");
      return false;
    }
    return true;
  }
  
  boolean zzms(String paramString)
  {
    zzab.zzaa(paramString);
    return paramString.matches("^1:\\d+:android:[a-f0-9]+$");
  }
  
  public Object zzn(String paramString, Object paramObject)
  {
    if ("_ldl".equals(paramString)) {
      return zza(zzmt(paramString), paramObject, true);
    }
    return zza(zzmt(paramString), paramObject, false);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.measurement.internal.zzal
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */