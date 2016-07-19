package com.google.android.gms.internal;

import android.content.Context;
import com.google.firebase.FirebaseApp;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;

public class zzals
{
  private static final AtomicReference<zzals> baW = new AtomicReference();
  
  zzals(Context paramContext) {}
  
  public static zzals zzcxe()
  {
    return (zzals)baW.get();
  }
  
  public static zzals zzen(Context paramContext)
  {
    baW.compareAndSet(null, new zzals(paramContext));
    return (zzals)baW.get();
  }
  
  public Set<String> zzcxf()
  {
    return Collections.emptySet();
  }
  
  public void zzf(FirebaseApp paramFirebaseApp) {}
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzals
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */