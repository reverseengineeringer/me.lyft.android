package com.google.firebase;

import android.annotation.TargetApi;
import android.app.Application;
import android.content.Context;
import android.support.v4.util.ArrayMap;
import android.util.Log;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.internal.zzaa.zza;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.common.internal.zzy;
import com.google.android.gms.common.util.zza;
import com.google.android.gms.common.util.zzs;
import com.google.android.gms.internal.zzalr;
import com.google.android.gms.internal.zzals;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

public class FirebaseApp
{
  private static final List<String> aML = Arrays.asList(new String[] { "com.google.firebase.auth.FirebaseAuth", "com.google.firebase.iid.FirebaseInstanceId" });
  private static final List<String> aMM = Collections.singletonList("com.google.firebase.crash.FirebaseCrash");
  private static final List<String> aMN = Arrays.asList(new String[] { "com.google.android.gms.measurement.AppMeasurement" });
  private static final Set<String> aMO = Collections.emptySet();
  static final Map<String, FirebaseApp> abO = new ArrayMap();
  private static final Object zzamp = new Object();
  private final FirebaseOptions aMP;
  private final AtomicBoolean aMQ = new AtomicBoolean(true);
  private final AtomicBoolean aMR = new AtomicBoolean();
  private final List<Object> aMS = new CopyOnWriteArrayList();
  private final List<zzb> aMT = new CopyOnWriteArrayList();
  private final List<Object> aMU = new CopyOnWriteArrayList();
  private final String mName;
  private final Context zzaqj;
  
  protected FirebaseApp(Context paramContext, String paramString, FirebaseOptions paramFirebaseOptions)
  {
    zzaqj = ((Context)zzab.zzaa(paramContext));
    mName = zzab.zzhs(paramString);
    aMP = ((FirebaseOptions)zzab.zzaa(paramFirebaseOptions));
  }
  
  public static FirebaseApp getInstance()
  {
    return getInstance("[DEFAULT]");
  }
  
  public static FirebaseApp getInstance(String paramString)
  {
    for (;;)
    {
      synchronized (zzamp)
      {
        localObject1 = (FirebaseApp)abO.get(zzqk(paramString));
        if (localObject1 != null) {
          return (FirebaseApp)localObject1;
        }
        localObject1 = zzckd();
        if (((List)localObject1).isEmpty())
        {
          localObject1 = "";
          throw new IllegalStateException(String.format("FirebaseApp with name %s doesn't exist. %s", new Object[] { paramString, localObject1 }));
        }
      }
      Object localObject1 = String.valueOf(zzy.zzhr(", ").zza((Iterable)localObject1));
      if (((String)localObject1).length() != 0) {
        localObject1 = "Available app names: ".concat((String)localObject1);
      } else {
        localObject1 = new String("Available app names: ");
      }
    }
  }
  
  public static FirebaseApp initializeApp(Context paramContext, FirebaseOptions paramFirebaseOptions)
  {
    return initializeApp(paramContext, paramFirebaseOptions, "[DEFAULT]");
  }
  
  public static FirebaseApp initializeApp(Context arg0, FirebaseOptions paramFirebaseOptions, String paramString)
  {
    zzals localzzals = zzals.zzen(???);
    zzei(???);
    paramString = zzqk(paramString);
    Context localContext = ???.getApplicationContext();
    synchronized (zzamp)
    {
      if (!abO.containsKey(paramString))
      {
        bool = true;
        zzab.zza(bool, String.valueOf(paramString).length() + 33 + "FirebaseApp name " + paramString + " already exists!");
        zzab.zzb(localContext, "Application context cannot be null.");
        paramFirebaseOptions = new FirebaseApp(localContext, paramString, paramFirebaseOptions);
        abO.put(paramString, paramFirebaseOptions);
        localzzals.zzf(paramFirebaseOptions);
        zza(FirebaseApp.class, paramFirebaseOptions, aML);
        if (paramFirebaseOptions.zzckb())
        {
          zza(FirebaseApp.class, paramFirebaseOptions, aMM);
          zza(Context.class, paramFirebaseOptions.getApplicationContext(), aMN);
        }
        return paramFirebaseOptions;
      }
      boolean bool = false;
    }
  }
  
  private static <T> void zza(Class<T> paramClass, T paramT, Iterable<String> paramIterable)
  {
    Iterator localIterator = paramIterable.iterator();
    for (;;)
    {
      if (localIterator.hasNext())
      {
        paramIterable = (String)localIterator.next();
        try
        {
          Method localMethod = Class.forName(paramIterable).getMethod("getInstance", new Class[] { paramClass });
          int i = localMethod.getModifiers();
          if ((Modifier.isPublic(i)) && (Modifier.isStatic(i))) {
            localMethod.invoke(null, new Object[] { paramT });
          }
        }
        catch (ClassNotFoundException localClassNotFoundException)
        {
          if (aMO.contains(paramIterable)) {
            throw new IllegalStateException(String.valueOf(paramIterable).concat(" is missing, but is required. Check if it has been removed by Proguard."));
          }
          Log.d("FirebaseApp", String.valueOf(paramIterable).concat(" is not linked. Skipping initialization."));
        }
        catch (NoSuchMethodException paramClass)
        {
          throw new IllegalStateException(String.valueOf(paramIterable).concat("#getInstance has been removed by Proguard. Add keep rule to prevent it."));
        }
        catch (InvocationTargetException paramIterable)
        {
          Log.wtf("FirebaseApp", "Firebase API initialization failure.", paramIterable);
        }
        catch (IllegalAccessException localIllegalAccessException)
        {
          paramIterable = String.valueOf(paramIterable);
          if (paramIterable.length() != 0) {}
          for (paramIterable = "Failed to initialize ".concat(paramIterable);; paramIterable = new String("Failed to initialize "))
          {
            Log.wtf("FirebaseApp", paramIterable, localIllegalAccessException);
            break;
          }
        }
      }
    }
  }
  
  public static void zzck(boolean paramBoolean)
  {
    synchronized (zzamp)
    {
      Iterator localIterator = new ArrayList(abO.values()).iterator();
      while (localIterator.hasNext())
      {
        FirebaseApp localFirebaseApp = (FirebaseApp)localIterator.next();
        if (aMQ.get()) {
          localFirebaseApp.zzcl(paramBoolean);
        }
      }
    }
  }
  
  private void zzcka()
  {
    if (!aMR.get()) {}
    for (boolean bool = true;; bool = false)
    {
      zzab.zza(bool, "FirebaseApp was deleted");
      return;
    }
  }
  
  private static List<String> zzckd()
  {
    zza localzza = new zza();
    synchronized (zzamp)
    {
      localObject2 = abO.values().iterator();
      if (((Iterator)localObject2).hasNext()) {
        localzza.add(((FirebaseApp)((Iterator)localObject2).next()).getName());
      }
    }
    Object localObject2 = zzals.zzcxe();
    if (localObject2 != null) {
      localCollection.addAll(((zzals)localObject2).zzcxf());
    }
    ??? = new ArrayList(localCollection);
    Collections.sort((List)???);
    return (List<String>)???;
  }
  
  private void zzcl(boolean paramBoolean)
  {
    Log.d("FirebaseApp", "Notifying background state change listeners.");
    Iterator localIterator = aMT.iterator();
    while (localIterator.hasNext()) {
      ((zzb)localIterator.next()).zzck(paramBoolean);
    }
  }
  
  public static FirebaseApp zzeh(Context paramContext)
  {
    FirebaseOptions localFirebaseOptions = FirebaseOptions.fromResource(paramContext);
    if (localFirebaseOptions == null) {
      return null;
    }
    return initializeApp(paramContext, localFirebaseOptions);
  }
  
  @TargetApi(14)
  private static void zzei(Context paramContext)
  {
    if ((zzs.zzavm()) && ((paramContext.getApplicationContext() instanceof Application))) {
      zzalr.zza((Application)paramContext.getApplicationContext());
    }
  }
  
  private static String zzqk(String paramString)
  {
    return paramString.trim();
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof FirebaseApp)) {
      return false;
    }
    return mName.equals(((FirebaseApp)paramObject).getName());
  }
  
  public Context getApplicationContext()
  {
    zzcka();
    return zzaqj;
  }
  
  public String getName()
  {
    zzcka();
    return mName;
  }
  
  public FirebaseOptions getOptions()
  {
    zzcka();
    return aMP;
  }
  
  public int hashCode()
  {
    return mName.hashCode();
  }
  
  public String toString()
  {
    return zzaa.zzz(this).zzg("name", mName).zzg("options", aMP).toString();
  }
  
  public boolean zzckb()
  {
    return "[DEFAULT]".equals(getName());
  }
  
  public static abstract interface zzb
  {
    public abstract void zzck(boolean paramBoolean);
  }
}

/* Location:
 * Qualified Name:     com.google.firebase.FirebaseApp
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */