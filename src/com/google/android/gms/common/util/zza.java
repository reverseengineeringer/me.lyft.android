package com.google.android.gms.common.util;

import android.support.v4.util.ArrayMap;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public class zza<E>
  extends AbstractSet<E>
{
  private final ArrayMap<E, E> AJ;
  
  public zza()
  {
    AJ = new ArrayMap();
  }
  
  public zza(int paramInt)
  {
    AJ = new ArrayMap(paramInt);
  }
  
  public zza(Collection<E> paramCollection)
  {
    this(paramCollection.size());
    addAll(paramCollection);
  }
  
  public boolean add(E paramE)
  {
    if (AJ.containsKey(paramE)) {
      return false;
    }
    AJ.put(paramE, paramE);
    return true;
  }
  
  public boolean addAll(Collection<? extends E> paramCollection)
  {
    if ((paramCollection instanceof zza)) {
      return zza((zza)paramCollection);
    }
    return super.addAll(paramCollection);
  }
  
  public void clear()
  {
    AJ.clear();
  }
  
  public boolean contains(Object paramObject)
  {
    return AJ.containsKey(paramObject);
  }
  
  public Iterator<E> iterator()
  {
    return AJ.keySet().iterator();
  }
  
  public boolean remove(Object paramObject)
  {
    if (!AJ.containsKey(paramObject)) {
      return false;
    }
    AJ.remove(paramObject);
    return true;
  }
  
  public int size()
  {
    return AJ.size();
  }
  
  public boolean zza(zza<? extends E> paramzza)
  {
    int i = size();
    AJ.putAll(AJ);
    return size() > i;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.util.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */