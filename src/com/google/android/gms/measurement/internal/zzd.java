package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.common.zzc;
import com.google.android.gms.internal.zzqk;

public class zzd
  extends zzz
{
  static final String ajI = String.valueOf(zzc.GOOGLE_PLAY_SERVICES_VERSION_CODE / 1000).replaceAll("(\\d+)(\\d)(\\d\\d)", "$1.$2.$3");
  private Boolean zzczf;
  
  zzd(zzx paramzzx)
  {
    super(paramzzx);
  }
  
  private Boolean zzlj(String paramString)
  {
    Boolean localBoolean = null;
    zzab.zzhs(paramString);
    Object localObject;
    try
    {
      localObject = getContext().getPackageManager();
      if (localObject == null)
      {
        zzbsz().zzbtr().log("Failed to load metadata: PackageManager is null");
        return null;
      }
      localObject = ((PackageManager)localObject).getApplicationInfo(getContext().getPackageName(), 128);
      if (localObject == null)
      {
        zzbsz().zzbtr().log("Failed to load metadata: ApplicationInfo is null");
        return null;
      }
    }
    catch (PackageManager.NameNotFoundException paramString)
    {
      zzbsz().zzbtr().zzj("Failed to load metadata: Package name not found", paramString);
      return null;
    }
    if (metaData == null)
    {
      zzbsz().zzbtr().log("Failed to load metadata: Metadata bundle is null");
      return null;
    }
    if (metaData.containsKey(paramString))
    {
      boolean bool = metaData.getBoolean(paramString);
      localBoolean = Boolean.valueOf(bool);
    }
    return localBoolean;
  }
  
  public long zza(String paramString, zzl.zza<Long> paramzza)
  {
    if (paramString == null) {
      return ((Long)paramzza.get()).longValue();
    }
    paramString = zzbsw().zzaw(paramString, paramzza.getKey());
    if (TextUtils.isEmpty(paramString)) {
      return ((Long)paramzza.get()).longValue();
    }
    try
    {
      long l = ((Long)paramzza.get(Long.valueOf(Long.valueOf(paramString).longValue()))).longValue();
      return l;
    }
    catch (NumberFormatException paramString) {}
    return ((Long)paramzza.get()).longValue();
  }
  
  public boolean zzabc()
  {
    return false;
  }
  
  /* Error */
  public boolean zzabd()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 166	com/google/android/gms/measurement/internal/zzd:zzczf	Ljava/lang/Boolean;
    //   4: ifnonnull +83 -> 87
    //   7: aload_0
    //   8: monitorenter
    //   9: aload_0
    //   10: getfield 166	com/google/android/gms/measurement/internal/zzd:zzczf	Ljava/lang/Boolean;
    //   13: ifnonnull +72 -> 85
    //   16: aload_0
    //   17: invokevirtual 51	com/google/android/gms/measurement/internal/zzd:getContext	()Landroid/content/Context;
    //   20: invokevirtual 169	android/content/Context:getApplicationInfo	()Landroid/content/pm/ApplicationInfo;
    //   23: astore_3
    //   24: invokestatic 174	com/google/android/gms/common/util/zzt:zzavv	()Ljava/lang/String;
    //   27: astore_2
    //   28: aload_3
    //   29: ifnull +30 -> 59
    //   32: aload_3
    //   33: getfield 177	android/content/pm/ApplicationInfo:processName	Ljava/lang/String;
    //   36: astore_3
    //   37: aload_3
    //   38: ifnull +57 -> 95
    //   41: aload_3
    //   42: aload_2
    //   43: invokevirtual 181	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   46: ifeq +49 -> 95
    //   49: iconst_1
    //   50: istore_1
    //   51: aload_0
    //   52: iload_1
    //   53: invokestatic 115	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   56: putfield 166	com/google/android/gms/measurement/internal/zzd:zzczf	Ljava/lang/Boolean;
    //   59: aload_0
    //   60: getfield 166	com/google/android/gms/measurement/internal/zzd:zzczf	Ljava/lang/Boolean;
    //   63: ifnonnull +22 -> 85
    //   66: aload_0
    //   67: getstatic 184	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   70: putfield 166	com/google/android/gms/measurement/internal/zzd:zzczf	Ljava/lang/Boolean;
    //   73: aload_0
    //   74: invokevirtual 61	com/google/android/gms/measurement/internal/zzd:zzbsz	()Lcom/google/android/gms/measurement/internal/zzp;
    //   77: invokevirtual 67	com/google/android/gms/measurement/internal/zzp:zzbtr	()Lcom/google/android/gms/measurement/internal/zzp$zza;
    //   80: ldc -70
    //   82: invokevirtual 75	com/google/android/gms/measurement/internal/zzp$zza:log	(Ljava/lang/String;)V
    //   85: aload_0
    //   86: monitorexit
    //   87: aload_0
    //   88: getfield 166	com/google/android/gms/measurement/internal/zzd:zzczf	Ljava/lang/Boolean;
    //   91: invokevirtual 189	java/lang/Boolean:booleanValue	()Z
    //   94: ireturn
    //   95: iconst_0
    //   96: istore_1
    //   97: goto -46 -> 51
    //   100: astore_2
    //   101: aload_0
    //   102: monitorexit
    //   103: aload_2
    //   104: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	105	0	this	zzd
    //   50	47	1	bool	boolean
    //   27	16	2	str	String
    //   100	4	2	localObject1	Object
    //   23	19	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   9	28	100	finally
    //   32	37	100	finally
    //   41	49	100	finally
    //   51	59	100	finally
    //   59	85	100	finally
    //   85	87	100	finally
    //   101	103	100	finally
  }
  
  long zzabx()
  {
    return ((Long)zzl.akI.get()).longValue();
  }
  
  public String zzacc()
  {
    return "google_app_measurement.db";
  }
  
  public String zzacd()
  {
    return "google_app_measurement2.db";
  }
  
  public long zzaci()
  {
    return Math.max(0L, ((Long)zzl.akm.get()).longValue());
  }
  
  public String zzap(String paramString1, String paramString2)
  {
    Uri.Builder localBuilder1 = new Uri.Builder();
    Uri.Builder localBuilder2 = localBuilder1.scheme((String)zzl.ako.get()).encodedAuthority((String)zzl.akp.get());
    paramString1 = String.valueOf(paramString1);
    if (paramString1.length() != 0) {}
    for (paramString1 = "config/app/".concat(paramString1);; paramString1 = new String("config/app/"))
    {
      localBuilder2.path(paramString1).appendQueryParameter("app_instance_id", paramString2).appendQueryParameter("platform", "android").appendQueryParameter("gmp_version", String.valueOf(zzbqv()));
      return localBuilder1.build().toString();
    }
  }
  
  public boolean zzaql()
  {
    return zzqk.zzaql();
  }
  
  public int zzb(String paramString, zzl.zza<Integer> paramzza)
  {
    if (paramString == null) {
      return ((Integer)paramzza.get()).intValue();
    }
    paramString = zzbsw().zzaw(paramString, paramzza.getKey());
    if (TextUtils.isEmpty(paramString)) {
      return ((Integer)paramzza.get()).intValue();
    }
    try
    {
      int i = ((Integer)paramzza.get(Integer.valueOf(Integer.valueOf(paramString).intValue()))).intValue();
      return i;
    }
    catch (NumberFormatException paramString) {}
    return ((Integer)paramzza.get()).intValue();
  }
  
  public long zzbqv()
  {
    return 9256L;
  }
  
  String zzbrh()
  {
    return (String)zzl.akk.get();
  }
  
  public int zzbri()
  {
    return 25;
  }
  
  public int zzbrj()
  {
    return 32;
  }
  
  public int zzbrk()
  {
    return 24;
  }
  
  int zzbrl()
  {
    return 24;
  }
  
  int zzbrm()
  {
    return 36;
  }
  
  int zzbrn()
  {
    return 256;
  }
  
  public int zzbro()
  {
    return 36;
  }
  
  public int zzbrp()
  {
    return 2048;
  }
  
  int zzbrq()
  {
    return 500;
  }
  
  public long zzbrr()
  {
    return ((Integer)zzl.aku.get()).intValue();
  }
  
  public long zzbrs()
  {
    return ((Integer)zzl.akv.get()).intValue();
  }
  
  public long zzbrt()
  {
    return 1000L;
  }
  
  int zzbru()
  {
    return 25;
  }
  
  int zzbrv()
  {
    return 50;
  }
  
  long zzbrw()
  {
    return 3600000L;
  }
  
  long zzbrx()
  {
    return 60000L;
  }
  
  long zzbry()
  {
    return 61000L;
  }
  
  public boolean zzbrz()
  {
    if (zzabc()) {}
    Boolean localBoolean;
    do
    {
      return false;
      localBoolean = zzlj("firebase_analytics_collection_deactivated");
    } while ((localBoolean == null) || (localBoolean.booleanValue()));
    return true;
  }
  
  public Boolean zzbsa()
  {
    if (zzabc()) {
      return null;
    }
    return zzlj("firebase_analytics_collection_enabled");
  }
  
  public long zzbsb()
  {
    return ((Long)zzl.akG.get()).longValue();
  }
  
  public long zzbsc()
  {
    return ((Long)zzl.akC.get()).longValue();
  }
  
  public long zzbsd()
  {
    return 1000L;
  }
  
  public int zzbse()
  {
    return Math.max(0, ((Integer)zzl.aks.get()).intValue());
  }
  
  public int zzbsf()
  {
    return Math.max(1, ((Integer)zzl.akt.get()).intValue());
  }
  
  public String zzbsg()
  {
    return (String)zzl.aky.get();
  }
  
  public long zzbsh()
  {
    return ((Long)zzl.akn.get()).longValue();
  }
  
  public long zzbsi()
  {
    return Math.max(0L, ((Long)zzl.akz.get()).longValue());
  }
  
  public long zzbsj()
  {
    return Math.max(0L, ((Long)zzl.akB.get()).longValue());
  }
  
  public long zzbsk()
  {
    return ((Long)zzl.akA.get()).longValue();
  }
  
  public long zzbsl()
  {
    return Math.max(0L, ((Long)zzl.akD.get()).longValue());
  }
  
  public long zzbsm()
  {
    return Math.max(0L, ((Long)zzl.akE.get()).longValue());
  }
  
  public int zzbsn()
  {
    return Math.min(20, Math.max(0, ((Integer)zzl.akF.get()).intValue()));
  }
  
  public int zzlg(String paramString)
  {
    return zzb(paramString, zzl.akw);
  }
  
  long zzlh(String paramString)
  {
    return zza(paramString, zzl.akl);
  }
  
  int zzli(String paramString)
  {
    return zzb(paramString, zzl.akH);
  }
  
  public int zzlk(String paramString)
  {
    return zzb(paramString, zzl.akq);
  }
  
  public int zzll(String paramString)
  {
    return Math.max(0, zzb(paramString, zzl.akr));
  }
  
  public int zzlm(String paramString)
  {
    return Math.max(0, Math.min(1000000, zzb(paramString, zzl.akx)));
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.measurement.internal.zzd
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */