package com.google.android.gms.internal;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@zzir
public class zzcm
{
  private final Object zzail = new Object();
  private int zzasf;
  private List<zzcl> zzasg = new LinkedList();
  
  public boolean zza(zzcl paramzzcl)
  {
    synchronized (zzail)
    {
      return zzasg.contains(paramzzcl);
    }
  }
  
  public boolean zzb(zzcl paramzzcl)
  {
    synchronized (zzail)
    {
      Iterator localIterator = zzasg.iterator();
      while (localIterator.hasNext())
      {
        zzcl localzzcl = (zzcl)localIterator.next();
        if ((paramzzcl != localzzcl) && (localzzcl.zzhr().equals(paramzzcl.zzhr())))
        {
          localIterator.remove();
          return true;
        }
      }
      return false;
    }
  }
  
  public void zzc(zzcl paramzzcl)
  {
    synchronized (zzail)
    {
      if (zzasg.size() >= 10)
      {
        i = zzasg.size();
        zzkh.zzcw(41 + "Queue is full, current size = " + i);
        zzasg.remove(0);
      }
      int i = zzasf;
      zzasf = (i + 1);
      paramzzcl.zzl(i);
      zzasg.add(paramzzcl);
      return;
    }
  }
  
  public zzcl zzhy()
  {
    Object localObject1 = null;
    label146:
    label149:
    for (;;)
    {
      synchronized (zzail)
      {
        if (zzasg.size() == 0)
        {
          zzkh.zzcw("Queue empty");
          return null;
        }
        if (zzasg.size() >= 2)
        {
          int i = Integer.MIN_VALUE;
          Iterator localIterator = zzasg.iterator();
          if (localIterator.hasNext())
          {
            zzcl localzzcl2 = (zzcl)localIterator.next();
            int j = localzzcl2.getScore();
            if (j <= i) {
              break label146;
            }
            localObject1 = localzzcl2;
            i = j;
            break label149;
          }
          zzasg.remove(localObject1);
          return (zzcl)localObject1;
        }
      }
      zzcl localzzcl1 = (zzcl)zzasg.get(0);
      localzzcl1.zzht();
      return localzzcl1;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzcm
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */