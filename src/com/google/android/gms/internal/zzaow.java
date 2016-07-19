package com.google.android.gms.internal;

import java.io.IOException;

public abstract class zzaow<M extends zzaow<M>>
  extends zzapc
{
  protected zzaoy bib;
  
  public M ac()
    throws CloneNotSupportedException
  {
    zzaow localzzaow = (zzaow)super.ad();
    zzapa.zza(this, localzzaow);
    return localzzaow;
  }
  
  public void zza(zzaov paramzzaov)
    throws IOException
  {
    if (bib == null) {}
    for (;;)
    {
      return;
      int i = 0;
      while (i < bib.size())
      {
        bib.zzaex(i).zza(paramzzaov);
        i += 1;
      }
    }
  }
  
  protected final boolean zza(zzaou paramzzaou, int paramInt)
    throws IOException
  {
    int i = paramzzaou.getPosition();
    if (!paramzzaou.zzaeg(paramInt)) {
      return false;
    }
    int j = zzapf.zzafa(paramInt);
    zzape localzzape = new zzape(paramInt, paramzzaou.zzad(i, paramzzaou.getPosition() - i));
    paramzzaou = null;
    if (bib == null) {
      bib = new zzaoy();
    }
    for (;;)
    {
      Object localObject = paramzzaou;
      if (paramzzaou == null)
      {
        localObject = new zzaoz();
        bib.zza(j, (zzaoz)localObject);
      }
      ((zzaoz)localObject).zza(localzzape);
      return true;
      paramzzaou = bib.zzaew(j);
    }
  }
  
  protected int zzy()
  {
    int j = 0;
    if (bib != null)
    {
      int i = 0;
      for (;;)
      {
        k = i;
        if (j >= bib.size()) {
          break;
        }
        i += bib.zzaex(j).zzy();
        j += 1;
      }
    }
    int k = 0;
    return k;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzaow
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */