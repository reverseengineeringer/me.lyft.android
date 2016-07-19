package com.google.android.gms.internal;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.util.ArrayMap;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.WeakHashMap;

public final class zzra
  extends Fragment
  implements zzqp
{
  private static WeakHashMap<FragmentActivity, WeakReference<zzra>> vb = new WeakHashMap();
  private Map<String, zzqo> vc = new ArrayMap();
  private Bundle vd;
  private int zzblz = 0;
  
  public static zzra zza(FragmentActivity paramFragmentActivity)
  {
    Object localObject = (WeakReference)vb.get(paramFragmentActivity);
    if (localObject != null)
    {
      localObject = (zzra)((WeakReference)localObject).get();
      if (localObject != null) {
        return (zzra)localObject;
      }
    }
    try
    {
      zzra localzzra = (zzra)paramFragmentActivity.getSupportFragmentManager().findFragmentByTag("SupportLifecycleFragmentImpl");
      if (localzzra != null)
      {
        localObject = localzzra;
        if (!localzzra.isRemoving()) {}
      }
      else
      {
        localObject = new zzra();
        paramFragmentActivity.getSupportFragmentManager().beginTransaction().add((Fragment)localObject, "SupportLifecycleFragmentImpl").commitAllowingStateLoss();
      }
      vb.put(paramFragmentActivity, new WeakReference(localObject));
      return (zzra)localObject;
    }
    catch (ClassCastException paramFragmentActivity)
    {
      throw new IllegalStateException("Fragment with tag SupportLifecycleFragmentImpl is not a SupportLifecycleFragmentImpl", paramFragmentActivity);
    }
  }
  
  private void zzb(final String paramString, final zzqo paramzzqo)
  {
    if (zzblz > 0) {
      new Handler(Looper.getMainLooper()).post(new Runnable()
      {
        public void run()
        {
          zzqo localzzqo;
          if (zzra.zza(zzra.this) >= 1)
          {
            localzzqo = paramzzqo;
            if (zzra.zzb(zzra.this) == null) {
              break label83;
            }
          }
          label83:
          for (Bundle localBundle = zzra.zzb(zzra.this).getBundle(paramString);; localBundle = null)
          {
            localzzqo.onCreate(localBundle);
            if (zzra.zza(zzra.this) >= 2) {
              paramzzqo.onStart();
            }
            if (zzra.zza(zzra.this) >= 3) {
              paramzzqo.onStop();
            }
            return;
          }
        }
      });
    }
  }
  
  public void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    super.dump(paramString, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    Iterator localIterator = vc.values().iterator();
    while (localIterator.hasNext()) {
      ((zzqo)localIterator.next()).dump(paramString, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    Iterator localIterator = vc.values().iterator();
    while (localIterator.hasNext()) {
      ((zzqo)localIterator.next()).onActivityResult(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    zzblz = 1;
    vd = paramBundle;
    Iterator localIterator = vc.entrySet().iterator();
    if (localIterator.hasNext())
    {
      Object localObject = (Map.Entry)localIterator.next();
      zzqo localzzqo = (zzqo)((Map.Entry)localObject).getValue();
      if (paramBundle != null) {}
      for (localObject = paramBundle.getBundle((String)((Map.Entry)localObject).getKey());; localObject = null)
      {
        localzzqo.onCreate((Bundle)localObject);
        break;
      }
    }
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    if (paramBundle == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = vc.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        Bundle localBundle = new Bundle();
        ((zzqo)localEntry.getValue()).onSaveInstanceState(localBundle);
        paramBundle.putBundle((String)localEntry.getKey(), localBundle);
      }
    }
  }
  
  public void onStart()
  {
    super.onStop();
    zzblz = 2;
    Iterator localIterator = vc.values().iterator();
    while (localIterator.hasNext()) {
      ((zzqo)localIterator.next()).onStart();
    }
  }
  
  public void onStop()
  {
    super.onStop();
    zzblz = 3;
    Iterator localIterator = vc.values().iterator();
    while (localIterator.hasNext()) {
      ((zzqo)localIterator.next()).onStop();
    }
  }
  
  public <T extends zzqo> T zza(String paramString, Class<T> paramClass)
  {
    return (zzqo)paramClass.cast(vc.get(paramString));
  }
  
  public void zza(String paramString, zzqo paramzzqo)
  {
    if (!vc.containsKey(paramString))
    {
      vc.put(paramString, paramzzqo);
      zzb(paramString, paramzzqo);
      return;
    }
    throw new IllegalArgumentException(String.valueOf(paramString).length() + 59 + "LifecycleCallback with tag " + paramString + " already added to this fragment.");
  }
  
  public FragmentActivity zzaqr()
  {
    return getActivity();
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzra
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */