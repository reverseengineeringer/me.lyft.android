package com.google.android.gms.common.data;

import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.internal.zzab;

public abstract class zzc
{
  protected final DataHolder tk;
  protected int vK;
  private int vL;
  
  public zzc(DataHolder paramDataHolder, int paramInt)
  {
    tk = ((DataHolder)zzab.zzaa(paramDataHolder));
    zzfm(paramInt);
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramObject instanceof zzc))
    {
      paramObject = (zzc)paramObject;
      bool1 = bool2;
      if (zzaa.equal(Integer.valueOf(vK), Integer.valueOf(vK)))
      {
        bool1 = bool2;
        if (zzaa.equal(Integer.valueOf(vL), Integer.valueOf(vL)))
        {
          bool1 = bool2;
          if (tk == tk) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  protected boolean getBoolean(String paramString)
  {
    return tk.zze(paramString, vK, vL);
  }
  
  protected byte[] getByteArray(String paramString)
  {
    return tk.zzg(paramString, vK, vL);
  }
  
  protected float getFloat(String paramString)
  {
    return tk.zzf(paramString, vK, vL);
  }
  
  protected int getInteger(String paramString)
  {
    return tk.zzc(paramString, vK, vL);
  }
  
  protected String getString(String paramString)
  {
    return tk.zzd(paramString, vK, vL);
  }
  
  public int hashCode()
  {
    return zzaa.hashCode(new Object[] { Integer.valueOf(vK), Integer.valueOf(vL), tk });
  }
  
  protected void zzfm(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < tk.getCount())) {}
    for (boolean bool = true;; bool = false)
    {
      zzab.zzbm(bool);
      vK = paramInt;
      vL = tk.zzfo(vK);
      return;
    }
  }
  
  public boolean zzhf(String paramString)
  {
    return tk.zzhf(paramString);
  }
  
  protected boolean zzhh(String paramString)
  {
    return tk.zzi(paramString, vK, vL);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.data.zzc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */