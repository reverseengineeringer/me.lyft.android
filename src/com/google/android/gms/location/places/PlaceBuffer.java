package com.google.android.gms.location.places;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.AbstractDataBuffer;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.location.places.internal.zzr;

public class PlaceBuffer
  extends AbstractDataBuffer<Place>
  implements Result
{
  private final String aeC;
  private final Status cc;
  private final Context mContext;
  
  public PlaceBuffer(DataHolder paramDataHolder, Context paramContext)
  {
    super(paramDataHolder);
    mContext = paramContext;
    cc = PlacesStatusCodes.zzgz(paramDataHolder.getStatusCode());
    if ((paramDataHolder != null) && (paramDataHolder.zzaqy() != null))
    {
      aeC = paramDataHolder.zzaqy().getString("com.google.android.gms.location.places.PlaceBuffer.ATTRIBUTIONS_EXTRA_KEY");
      return;
    }
    aeC = null;
  }
  
  public Place get(int paramInt)
  {
    return new zzr(tk, paramInt, mContext);
  }
  
  public Status getStatus()
  {
    return cc;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.location.places.PlaceBuffer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */