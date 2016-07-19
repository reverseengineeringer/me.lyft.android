package com.google.android.gms.wearable.internal;

import android.net.Uri;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.wearable.DataApi;
import com.google.android.gms.wearable.DataApi.DeleteDataItemsResult;

public final class zzx
  implements DataApi
{
  public PendingResult<DataApi.DeleteDataItemsResult> deleteDataItems(GoogleApiClient paramGoogleApiClient, Uri paramUri)
  {
    return deleteDataItems(paramGoogleApiClient, paramUri, 0);
  }
  
  public PendingResult<DataApi.DeleteDataItemsResult> deleteDataItems(GoogleApiClient paramGoogleApiClient, final Uri paramUri, final int paramInt)
  {
    boolean bool2 = false;
    if (paramUri != null) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      zzab.zzb(bool1, "uri must not be null");
      if (paramInt != 0)
      {
        bool1 = bool2;
        if (paramInt != 1) {}
      }
      else
      {
        bool1 = true;
      }
      zzab.zzb(bool1, "invalid filter type");
      paramGoogleApiClient.zzc(new zzi(paramGoogleApiClient)
      {
        protected void zza(zzbp paramAnonymouszzbp)
          throws RemoteException
        {
          paramAnonymouszzbp.zzb(this, paramUri, paramInt);
        }
        
        protected DataApi.DeleteDataItemsResult zzen(Status paramAnonymousStatus)
        {
          return new zzx.zzb(paramAnonymousStatus, 0);
        }
      });
    }
  }
  
  public static class zzb
    implements DataApi.DeleteDataItemsResult
  {
    private final int aKz;
    private final Status cc;
    
    public zzb(Status paramStatus, int paramInt)
    {
      cc = paramStatus;
      aKz = paramInt;
    }
    
    public Status getStatus()
    {
      return cc;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.wearable.internal.zzx
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */