package com.google.android.gms.wearable;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzf;
import com.google.android.gms.wearable.internal.zzz;

public class DataEventBuffer
  extends zzf<DataEvent>
  implements Result
{
  private final Status cc;
  
  public DataEventBuffer(DataHolder paramDataHolder)
  {
    super(paramDataHolder);
    cc = new Status(paramDataHolder.getStatusCode());
  }
  
  public Status getStatus()
  {
    return cc;
  }
  
  protected String zzarg()
  {
    return "path";
  }
  
  protected DataEvent zzx(int paramInt1, int paramInt2)
  {
    return new zzz(tk, paramInt1, paramInt2);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.wearable.DataEventBuffer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */