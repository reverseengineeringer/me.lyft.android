package com.google.android.gms.internal;

import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.WeakHashMap;

public class zzqt
{
  private final Set<zzqs<?>> mg = Collections.newSetFromMap(new WeakHashMap());
  
  public void release()
  {
    Iterator localIterator = mg.iterator();
    while (localIterator.hasNext()) {
      ((zzqs)localIterator.next()).clear();
    }
    mg.clear();
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzqt
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */