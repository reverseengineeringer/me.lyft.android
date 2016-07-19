package com.google.android.gms.wearable;

import android.net.Uri;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;

public abstract interface DataApi
{
  public abstract PendingResult<DeleteDataItemsResult> deleteDataItems(GoogleApiClient paramGoogleApiClient, Uri paramUri);
  
  public static abstract interface DataListener
  {
    public abstract void onDataChanged(DataEventBuffer paramDataEventBuffer);
  }
  
  public static abstract interface DeleteDataItemsResult
    extends Result
  {}
}

/* Location:
 * Qualified Name:     com.google.android.gms.wearable.DataApi
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */