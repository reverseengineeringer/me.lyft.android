package com.google.android.gms.common.data;

import java.util.ArrayList;

public abstract class zzf<T>
  extends AbstractDataBuffer<T>
{
  private boolean wc = false;
  private ArrayList<Integer> wd;
  
  protected zzf(DataHolder paramDataHolder)
  {
    super(paramDataHolder);
  }
  
  private void zzarh()
  {
    for (;;)
    {
      int i;
      String str2;
      try
      {
        if (wc) {
          break label204;
        }
        int j = tk.getCount();
        wd = new ArrayList();
        if (j <= 0) {
          break label199;
        }
        wd.add(Integer.valueOf(0));
        String str3 = zzarg();
        i = tk.zzfo(0);
        String str1 = tk.zzd(str3, 0, i);
        i = 1;
        if (i >= j) {
          break label199;
        }
        int k = tk.zzfo(i);
        str2 = tk.zzd(str3, i, k);
        if (str2 == null) {
          throw new NullPointerException(String.valueOf(str3).length() + 78 + "Missing value for markerColumn: " + str3 + ", at row: " + i + ", for window: " + k);
        }
      }
      finally {}
      if (!str2.equals(localObject1))
      {
        wd.add(Integer.valueOf(i));
        Object localObject2 = str2;
        break label207;
        label199:
        wc = true;
        label204:
        return;
      }
      label207:
      i += 1;
    }
  }
  
  public final T get(int paramInt)
  {
    zzarh();
    return (T)zzl(zzfs(paramInt), zzft(paramInt));
  }
  
  public int getCount()
  {
    zzarh();
    return wd.size();
  }
  
  protected abstract String zzarg();
  
  protected String zzari()
  {
    return null;
  }
  
  int zzfs(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= wd.size())) {
      throw new IllegalArgumentException(53 + "Position " + paramInt + " is out of bounds for this buffer");
    }
    return ((Integer)wd.get(paramInt)).intValue();
  }
  
  protected int zzft(int paramInt)
  {
    int j;
    if ((paramInt < 0) || (paramInt == wd.size()))
    {
      j = 0;
      return j;
    }
    if (paramInt == wd.size() - 1) {}
    for (int i = tk.getCount() - ((Integer)wd.get(paramInt)).intValue();; i = ((Integer)wd.get(paramInt + 1)).intValue() - ((Integer)wd.get(paramInt)).intValue())
    {
      j = i;
      if (i != 1) {
        break;
      }
      paramInt = zzfs(paramInt);
      int k = tk.zzfo(paramInt);
      String str = zzari();
      j = i;
      if (str == null) {
        break;
      }
      j = i;
      if (tk.zzd(str, paramInt, k) != null) {
        break;
      }
      return 0;
    }
  }
  
  protected abstract T zzl(int paramInt1, int paramInt2);
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.data.zzf
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */