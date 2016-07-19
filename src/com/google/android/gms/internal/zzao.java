package com.google.android.gms.internal;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Iterator;
import java.util.LinkedList;

public abstract class zzao
  implements zzan
{
  protected MotionEvent zzafd;
  protected LinkedList<MotionEvent> zzafe = new LinkedList();
  protected long zzaff = 0L;
  protected long zzafg = 0L;
  protected long zzafh = 0L;
  protected long zzafi = 0L;
  protected long zzafj = 0L;
  private boolean zzafk = false;
  protected DisplayMetrics zzafl;
  
  protected zzao(Context paramContext)
  {
    zzak.zzas();
    try
    {
      zzafl = paramContext.getResources().getDisplayMetrics();
      return;
    }
    catch (UnsupportedOperationException paramContext)
    {
      zzafl = new DisplayMetrics();
      zzafl.density = 1.0F;
    }
  }
  
  private String zza(Context paramContext, String paramString, boolean paramBoolean)
  {
    boolean bool = true;
    if (paramBoolean) {}
    try
    {
      paramContext = zzd(paramContext);
      zzafk = true;
      while ((paramContext == null) || (paramContext.ao() == 0))
      {
        return Integer.toString(5);
        paramContext = zzc(paramContext);
      }
      if (!zzb(paramBoolean)) {}
      for (paramBoolean = bool;; paramBoolean = false)
      {
        paramContext = zzak.zza(paramContext, paramString, paramBoolean);
        return paramContext;
      }
      return Integer.toString(3);
    }
    catch (NoSuchAlgorithmException paramContext)
    {
      return Integer.toString(7);
    }
    catch (UnsupportedEncodingException paramContext)
    {
      return Integer.toString(7);
    }
    catch (Throwable paramContext) {}
  }
  
  private void zzaw()
  {
    StackTraceElement[] arrayOfStackTraceElement;
    int j;
    int i;
    if (((Boolean)zzdc.zzbbr.get()).booleanValue())
    {
      arrayOfStackTraceElement = new Throwable().getStackTrace();
      j = arrayOfStackTraceElement.length;
      i = 0;
      j -= 1;
    }
    for (;;)
    {
      int k = i;
      if (j >= 0)
      {
        i += 1;
        k = i;
        if (!arrayOfStackTraceElement[j].toString().startsWith("com.google.android.ads."))
        {
          if (!arrayOfStackTraceElement[j].toString().startsWith("com.google.android.gms.")) {
            break label88;
          }
          k = i;
        }
      }
      zzafj = k;
      return;
      label88:
      j -= 1;
    }
  }
  
  private static boolean zzb(boolean paramBoolean)
  {
    if (!((Boolean)zzdc.zzbbj.get()).booleanValue()) {
      return true;
    }
    return (((Boolean)zzdc.zzbbs.get()).booleanValue()) && (paramBoolean);
  }
  
  public void zza(int paramInt1, int paramInt2, int paramInt3)
  {
    if (zzafd != null) {
      zzafd.recycle();
    }
    zzafd = MotionEvent.obtain(0L, paramInt3, 1, paramInt1 * zzafl.density, paramInt2 * zzafl.density, 0.0F, 0.0F, 0, 0.0F, 0.0F, 0, 0);
  }
  
  public void zza(MotionEvent paramMotionEvent)
  {
    if (zzafk)
    {
      zzafi = 0L;
      zzafh = 0L;
      zzafg = 0L;
      zzaff = 0L;
      zzafj = 0L;
      Iterator localIterator = zzafe.iterator();
      while (localIterator.hasNext()) {
        ((MotionEvent)localIterator.next()).recycle();
      }
      zzafe.clear();
      zzafd = null;
      zzafk = false;
    }
    switch (paramMotionEvent.getAction())
    {
    default: 
      return;
    case 1: 
      zzafd = MotionEvent.obtain(paramMotionEvent);
      zzafe.add(zzafd);
      if (zzafe.size() > 6) {
        ((MotionEvent)zzafe.remove()).recycle();
      }
      zzafh += 1L;
      zzaw();
      return;
    case 0: 
      zzaff += 1L;
      return;
    case 3: 
      zzafi += 1L;
      return;
    }
    zzafg += paramMotionEvent.getHistorySize() + 1;
  }
  
  public String zzb(Context paramContext)
  {
    return zza(paramContext, null, false);
  }
  
  public String zzb(Context paramContext, String paramString)
  {
    return zza(paramContext, paramString, true);
  }
  
  protected abstract zzae.zza zzc(Context paramContext);
  
  protected abstract zzae.zza zzd(Context paramContext);
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzao
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */