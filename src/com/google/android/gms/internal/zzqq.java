package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
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

@TargetApi(11)
public final class zzqq
  extends Fragment
  implements zzqp
{
  private static WeakHashMap<Activity, WeakReference<zzqq>> vb = new WeakHashMap();
  private Map<String, zzqo> vc = new ArrayMap();
  private Bundle vd;
  private int zzblz = 0;
  
  private void zzb(final String paramString, final zzqo paramzzqo)
  {
    if (zzblz > 0) {
      new Handler(Looper.getMainLooper()).post(new Runnable()
      {
        public void run()
        {
          zzqo localzzqo;
          if (zzqq.zza(zzqq.this) >= 1)
          {
            localzzqo = paramzzqo;
            if (zzqq.zzb(zzqq.this) == null) {
              break label83;
            }
          }
          label83:
          for (Bundle localBundle = zzqq.zzb(zzqq.this).getBundle(paramString);; localBundle = null)
          {
            localzzqo.onCreate(localBundle);
            if (zzqq.zza(zzqq.this) >= 2) {
              paramzzqo.onStart();
            }
            if (zzqq.zza(zzqq.this) >= 3) {
              paramzzqo.onStop();
            }
            return;
          }
        }
      });
    }
  }
  
  public static zzqq zzt(Activity paramActivity)
  {
    Object localObject = (WeakReference)vb.get(paramActivity);
    if (localObject != null)
    {
      localObject = (zzqq)((WeakReference)localObject).get();
      if (localObject != null) {
        return (zzqq)localObject;
      }
    }
    try
    {
      zzqq localzzqq = (zzqq)paramActivity.getFragmentManager().findFragmentByTag("LifecycleFragmentImpl");
      if (localzzqq != null)
      {
        localObject = localzzqq;
        if (!localzzqq.isRemoving()) {}
      }
      else
      {
        localObject = new zzqq();
        paramActivity.getFragmentManager().beginTransaction().add((Fragment)localObject, "LifecycleFragmentImpl").commitAllowingStateLoss();
      }
      vb.put(paramActivity, new WeakReference(localObject));
      return (zzqq)localObject;
    }
    catch (ClassCastException paramActivity)
    {
      throw new IllegalStateException("Fragment with tag LifecycleFragmentImpl is not a LifecycleFragmentImpl", paramActivity);
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
  
  public Activity zzaqp()
  {
    return getActivity();
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzqq
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */