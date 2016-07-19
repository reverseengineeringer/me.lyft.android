package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.dynamic.zze;
import java.lang.reflect.Field;

public final class zzsj
{
  private static zzsk Me;
  private static final zzsj.zzb.zza Mf = new zzsj.zzb.zza()
  {
    public int zzd(Context paramAnonymousContext, String paramAnonymousString, boolean paramAnonymousBoolean)
    {
      return zzsj.zzd(paramAnonymousContext, paramAnonymousString, paramAnonymousBoolean);
    }
    
    public int zzt(Context paramAnonymousContext, String paramAnonymousString)
    {
      return zzsj.zzt(paramAnonymousContext, paramAnonymousString);
    }
  };
  public static final zzb Mg = new zzb()
  {
    public zzsj.zzb.zzb zza(Context paramAnonymousContext, String paramAnonymousString, zzsj.zzb.zza paramAnonymouszza)
    {
      zzsj.zzb.zzb localzzb = new zzsj.zzb.zzb();
      Mo = paramAnonymouszza.zzd(paramAnonymousContext, paramAnonymousString, true);
      if (Mo != 0) {
        Mp = 1;
      }
      do
      {
        return localzzb;
        Mn = paramAnonymouszza.zzt(paramAnonymousContext, paramAnonymousString);
      } while (Mn == 0);
      Mp = -1;
      return localzzb;
    }
  };
  public static final zzb Mh = new zzb()
  {
    public zzsj.zzb.zzb zza(Context paramAnonymousContext, String paramAnonymousString, zzsj.zzb.zza paramAnonymouszza)
    {
      zzsj.zzb.zzb localzzb = new zzsj.zzb.zzb();
      Mn = paramAnonymouszza.zzt(paramAnonymousContext, paramAnonymousString);
      if (Mn != 0) {
        Mp = -1;
      }
      do
      {
        return localzzb;
        Mo = paramAnonymouszza.zzd(paramAnonymousContext, paramAnonymousString, true);
      } while (Mo == 0);
      Mp = 1;
      return localzzb;
    }
  };
  public static final zzb Mi = new zzb()
  {
    public zzsj.zzb.zzb zza(Context paramAnonymousContext, String paramAnonymousString, zzsj.zzb.zza paramAnonymouszza)
    {
      zzsj.zzb.zzb localzzb = new zzsj.zzb.zzb();
      Mn = paramAnonymouszza.zzt(paramAnonymousContext, paramAnonymousString);
      Mo = paramAnonymouszza.zzd(paramAnonymousContext, paramAnonymousString, true);
      if ((Mn == 0) && (Mo == 0))
      {
        Mp = 0;
        return localzzb;
      }
      if (Mn >= Mo)
      {
        Mp = -1;
        return localzzb;
      }
      Mp = 1;
      return localzzb;
    }
  };
  public static final zzb Mj = new zzb()
  {
    public zzsj.zzb.zzb zza(Context paramAnonymousContext, String paramAnonymousString, zzsj.zzb.zza paramAnonymouszza)
    {
      zzsj.zzb.zzb localzzb = new zzsj.zzb.zzb();
      Mn = paramAnonymouszza.zzt(paramAnonymousContext, paramAnonymousString);
      Mo = paramAnonymouszza.zzd(paramAnonymousContext, paramAnonymousString, true);
      if ((Mn == 0) && (Mo == 0))
      {
        Mp = 0;
        return localzzb;
      }
      if (Mo >= Mn)
      {
        Mp = 1;
        return localzzb;
      }
      Mp = -1;
      return localzzb;
    }
  };
  public static final zzb Mk = new zzb()
  {
    public zzsj.zzb.zzb zza(Context paramAnonymousContext, String paramAnonymousString, zzsj.zzb.zza paramAnonymouszza)
    {
      zzsj.zzb.zzb localzzb = new zzsj.zzb.zzb();
      Mn = paramAnonymouszza.zzt(paramAnonymousContext, paramAnonymousString);
      if (Mn != 0) {}
      for (Mo = paramAnonymouszza.zzd(paramAnonymousContext, paramAnonymousString, false); (Mn == 0) && (Mo == 0); Mo = paramAnonymouszza.zzd(paramAnonymousContext, paramAnonymousString, true))
      {
        Mp = 0;
        return localzzb;
      }
      if (Mo >= Mn)
      {
        Mp = 1;
        return localzzb;
      }
      Mp = -1;
      return localzzb;
    }
  };
  private final Context Ml;
  
  private zzsj(Context paramContext)
  {
    Ml = ((Context)zzab.zzaa(paramContext));
  }
  
  public static zzsj zza(Context paramContext, zzb paramzzb, String paramString)
    throws zzsj.zza
  {
    zzsj.zzb.zzb localzzb = paramzzb.zza(paramContext, paramString, Mf);
    int i = Mn;
    int j = Mo;
    Log.i("DynamiteModule", String.valueOf(paramString).length() + 68 + String.valueOf(paramString).length() + "Considering local module " + paramString + ":" + i + " and remote module " + paramString + ":" + j);
    if ((Mp == 0) || ((Mp == -1) && (Mn == 0)) || ((Mp == 1) && (Mo == 0)))
    {
      i = Mn;
      j = Mo;
      throw new zza(91 + "No acceptable module found. Local version is " + i + " and remote version is " + j + ".", null);
    }
    if (Mp == -1) {
      return zzv(paramContext, paramString);
    }
    if (Mp == 1) {
      try
      {
        localObject = zza(paramContext, paramString, Mo);
        return (zzsj)localObject;
      }
      catch (zza localzza)
      {
        Object localObject = String.valueOf(localzza.getMessage());
        if (((String)localObject).length() != 0) {}
        for (localObject = "Failed to load remote module: ".concat((String)localObject);; localObject = new String("Failed to load remote module: "))
        {
          Log.w("DynamiteModule", (String)localObject);
          if ((Mn == 0) || (
          {
            public int zzd(Context paramAnonymousContext, String paramAnonymousString, boolean paramAnonymousBoolean)
            {
              return 0;
            }
            
            public int zzt(Context paramAnonymousContext, String paramAnonymousString)
            {
              return Mm;
            }
          } != -1)) {
            break;
          }
          return zzv(paramContext, paramString);
        }
        throw new zza("Remote load failed. No local fallback found.", localzza, null);
      }
    }
    i = Mp;
    throw new zza(47 + "VersionPolicy returned invalid code:" + i, null);
  }
  
  private static zzsj zza(Context paramContext, String paramString, int paramInt)
    throws zzsj.zza
  {
    Log.i("DynamiteModule", String.valueOf(paramString).length() + 51 + "Selected remote version of " + paramString + ", version >= " + paramInt);
    zzsk localzzsk = zzcs(paramContext);
    if (localzzsk == null) {
      throw new zza("Failed to create IDynamiteLoader.", null);
    }
    try
    {
      paramContext = localzzsk.zza(zze.zzae(paramContext), paramString, paramInt);
      if (zze.zzad(paramContext) == null) {
        throw new zza("Failed to load remote module.", null);
      }
    }
    catch (RemoteException paramContext)
    {
      throw new zza("Failed to load remote module.", paramContext, null);
    }
    return new zzsj((Context)zze.zzad(paramContext));
  }
  
  /* Error */
  private static zzsk zzcs(Context paramContext)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 204	com/google/android/gms/internal/zzsj:Me	Lcom/google/android/gms/internal/zzsk;
    //   6: ifnull +12 -> 18
    //   9: getstatic 204	com/google/android/gms/internal/zzsj:Me	Lcom/google/android/gms/internal/zzsk;
    //   12: astore_0
    //   13: ldc 2
    //   15: monitorexit
    //   16: aload_0
    //   17: areturn
    //   18: invokestatic 210	com/google/android/gms/common/zzc:zzand	()Lcom/google/android/gms/common/zzc;
    //   21: aload_0
    //   22: invokevirtual 214	com/google/android/gms/common/zzc:isGooglePlayServicesAvailable	(Landroid/content/Context;)I
    //   25: ifeq +8 -> 33
    //   28: ldc 2
    //   30: monitorexit
    //   31: aconst_null
    //   32: areturn
    //   33: aload_0
    //   34: ldc -40
    //   36: iconst_3
    //   37: invokevirtual 220	android/content/Context:createPackageContext	(Ljava/lang/String;I)Landroid/content/Context;
    //   40: invokevirtual 224	android/content/Context:getClassLoader	()Ljava/lang/ClassLoader;
    //   43: ldc -30
    //   45: invokevirtual 232	java/lang/ClassLoader:loadClass	(Ljava/lang/String;)Ljava/lang/Class;
    //   48: invokevirtual 238	java/lang/Class:newInstance	()Ljava/lang/Object;
    //   51: checkcast 240	android/os/IBinder
    //   54: invokestatic 246	com/google/android/gms/internal/zzsk$zza:zzfd	(Landroid/os/IBinder;)Lcom/google/android/gms/internal/zzsk;
    //   57: astore_0
    //   58: aload_0
    //   59: ifnull +48 -> 107
    //   62: aload_0
    //   63: putstatic 204	com/google/android/gms/internal/zzsj:Me	Lcom/google/android/gms/internal/zzsk;
    //   66: ldc 2
    //   68: monitorexit
    //   69: aload_0
    //   70: areturn
    //   71: astore_0
    //   72: ldc 2
    //   74: monitorexit
    //   75: aload_0
    //   76: athrow
    //   77: astore_0
    //   78: aload_0
    //   79: invokevirtual 247	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   82: invokestatic 96	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   85: astore_0
    //   86: aload_0
    //   87: invokevirtual 100	java/lang/String:length	()I
    //   90: ifeq +22 -> 112
    //   93: ldc -7
    //   95: aload_0
    //   96: invokevirtual 154	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   99: astore_0
    //   100: ldc 88
    //   102: aload_0
    //   103: invokestatic 252	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   106: pop
    //   107: ldc 2
    //   109: monitorexit
    //   110: aconst_null
    //   111: areturn
    //   112: new 92	java/lang/String
    //   115: dup
    //   116: ldc -7
    //   118: invokespecial 161	java/lang/String:<init>	(Ljava/lang/String;)V
    //   121: astore_0
    //   122: goto -22 -> 100
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	125	0	paramContext	Context
    // Exception table:
    //   from	to	target	type
    //   3	16	71	finally
    //   18	31	71	finally
    //   33	58	71	finally
    //   62	66	71	finally
    //   66	69	71	finally
    //   72	75	71	finally
    //   78	100	71	finally
    //   100	107	71	finally
    //   107	110	71	finally
    //   112	122	71	finally
    //   33	58	77	java/lang/Exception
    //   62	66	77	java/lang/Exception
  }
  
  public static int zzd(Context paramContext, String paramString, boolean paramBoolean)
  {
    zzsk localzzsk = zzcs(paramContext);
    if (localzzsk == null) {
      return 0;
    }
    try
    {
      int i = localzzsk.zza(zze.zzae(paramContext), paramString, paramBoolean);
      return i;
    }
    catch (RemoteException paramContext)
    {
      paramContext = String.valueOf(paramContext.getMessage());
      if (paramContext.length() == 0) {}
    }
    for (paramContext = "Failed to retrieve remote module version: ".concat(paramContext);; paramContext = new String("Failed to retrieve remote module version: "))
    {
      Log.w("DynamiteModule", paramContext);
      return 0;
    }
  }
  
  public static int zzt(Context paramContext, String paramString)
  {
    try
    {
      paramContext = paramContext.getApplicationContext().getClassLoader();
      Object localObject = String.valueOf("com.google.android.gms.dynamite.descriptors.");
      String str = String.valueOf("ModuleDescriptor");
      localObject = paramContext.loadClass(String.valueOf(localObject).length() + 1 + String.valueOf(paramString).length() + String.valueOf(str).length() + (String)localObject + paramString + "." + str);
      paramContext = ((Class)localObject).getDeclaredField("MODULE_ID");
      localObject = ((Class)localObject).getDeclaredField("MODULE_VERSION");
      if (!paramContext.get(null).equals(paramString))
      {
        paramContext = String.valueOf(paramContext.get(null));
        Log.e("DynamiteModule", String.valueOf(paramContext).length() + 51 + String.valueOf(paramString).length() + "Module descriptor id '" + paramContext + "' didn't match expected id '" + paramString + "'");
        return 0;
      }
      int i = ((Field)localObject).getInt(null);
      return i;
    }
    catch (ClassNotFoundException paramContext)
    {
      Log.w("DynamiteModule", String.valueOf(paramString).length() + 45 + "Local module descriptor class for " + paramString + " not found.");
      return 0;
    }
    catch (Exception paramContext)
    {
      paramContext = String.valueOf(paramContext.getMessage());
      if (paramContext.length() == 0) {}
    }
    for (paramContext = "Failed to load module descriptor class: ".concat(paramContext);; paramContext = new String("Failed to load module descriptor class: "))
    {
      Log.e("DynamiteModule", paramContext);
      break;
    }
  }
  
  private static zzsj zzv(Context paramContext, String paramString)
  {
    paramString = String.valueOf(paramString);
    if (paramString.length() != 0) {}
    for (paramString = "Selected local version of ".concat(paramString);; paramString = new String("Selected local version of "))
    {
      Log.i("DynamiteModule", paramString);
      return new zzsj(paramContext.getApplicationContext());
    }
  }
  
  public Context zzbcw()
  {
    return Ml;
  }
  
  public IBinder zziv(String paramString)
    throws zzsj.zza
  {
    try
    {
      IBinder localIBinder = (IBinder)Ml.getClassLoader().loadClass(paramString).newInstance();
      return localIBinder;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      paramString = String.valueOf(paramString);
      if (paramString.length() != 0) {}
      for (paramString = "Failed to instantiate module class: ".concat(paramString);; paramString = new String("Failed to instantiate module class: ")) {
        throw new zza(paramString, localClassNotFoundException, null);
      }
    }
    catch (InstantiationException localInstantiationException)
    {
      for (;;) {}
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      for (;;) {}
    }
  }
  
  public static class zza
    extends Exception
  {
    private zza(String paramString)
    {
      super();
    }
    
    private zza(String paramString, Throwable paramThrowable)
    {
      super(paramThrowable);
    }
  }
  
  public static abstract interface zzb
  {
    public abstract zzb zza(Context paramContext, String paramString, zza paramzza);
    
    public static abstract interface zza
    {
      public abstract int zzd(Context paramContext, String paramString, boolean paramBoolean);
      
      public abstract int zzt(Context paramContext, String paramString);
    }
    
    public static class zzb
    {
      public int Mn = 0;
      public int Mo = 0;
      public int Mp = 0;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzsj
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */