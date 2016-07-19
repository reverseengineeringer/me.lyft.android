package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzc;
import com.google.android.gms.wearable.DataEvent;
import com.google.android.gms.wearable.DataItem;

public final class zzz
  extends zzc
  implements DataEvent
{
  private final int Sq;
  
  public zzz(DataHolder paramDataHolder, int paramInt1, int paramInt2)
  {
    super(paramDataHolder, paramInt1);
    Sq = paramInt2;
  }
  
  public DataItem getDataItem()
  {
    return new zzaf(tk, vK, Sq);
  }
  
  public int getType()
  {
    return getInteger("event_type");
  }
  
  public String toString()
  {
    String str1;
    if (getType() == 1) {
      str1 = "changed";
    }
    for (;;)
    {
      String str2 = String.valueOf(getDataItem());
      return String.valueOf(str1).length() + 32 + String.valueOf(str2).length() + "DataEventRef{ type=" + str1 + ", dataitem=" + str2 + " }";
      if (getType() == 2) {
        str1 = "deleted";
      } else {
        str1 = "unknown";
      }
    }
  }
  
  public DataEvent zzciz()
  {
    return new zzy(this);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.wearable.internal.zzz
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */