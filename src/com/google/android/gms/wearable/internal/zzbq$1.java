package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.internal.zzqs.zzb;
import com.google.android.gms.wearable.DataApi.DataListener;
import com.google.android.gms.wearable.DataEventBuffer;

final class zzbq$1
  implements zzqs.zzb<DataApi.DataListener>
{
  zzbq$1(DataHolder paramDataHolder) {}
  
  public void zza(DataApi.DataListener paramDataListener)
  {
    try
    {
      paramDataListener.onDataChanged(new DataEventBuffer(aJu));
      return;
    }
    finally
    {
      aJu.close();
    }
  }
  
  public void zzapg()
  {
    aJu.close();
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.wearable.internal.zzbq.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */