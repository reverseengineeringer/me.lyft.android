package com.google.android.gms.location.places;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.AbstractDataBuffer;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.internal.zzaa.zza;
import com.google.android.gms.location.places.internal.zzn;

public class PlaceLikelihoodBuffer
  extends AbstractDataBuffer<PlaceLikelihood>
  implements Result
{
  private final String aeC;
  private final Status cc;
  private final Context mContext;
  private final int zzaxm;
  
  public PlaceLikelihoodBuffer(DataHolder paramDataHolder, int paramInt, Context paramContext)
  {
    super(paramDataHolder);
    mContext = paramContext;
    cc = PlacesStatusCodes.zzgz(paramDataHolder.getStatusCode());
    zzaxm = zza.zztt(paramInt);
    if ((paramDataHolder != null) && (paramDataHolder.zzaqy() != null))
    {
      aeC = paramDataHolder.zzaqy().getString("com.google.android.gms.location.places.PlaceLikelihoodBuffer.ATTRIBUTIONS_EXTRA_KEY");
      return;
    }
    aeC = null;
  }
  
  public static int zzak(Bundle paramBundle)
  {
    return paramBundle.getInt("com.google.android.gms.location.places.PlaceLikelihoodBuffer.SOURCE_EXTRA_KEY");
  }
  
  public PlaceLikelihood get(int paramInt)
  {
    return new zzn(tk, paramInt, mContext);
  }
  
  public Status getStatus()
  {
    return cc;
  }
  
  public String toString()
  {
    return zzaa.zzz(this).zzg("status", getStatus()).zzg("attributions", aeC).toString();
  }
  
  public static class zza
  {
    static int zztt(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        throw new IllegalArgumentException(27 + "invalid source: " + paramInt);
      }
      return paramInt;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.location.places.PlaceLikelihoodBuffer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */