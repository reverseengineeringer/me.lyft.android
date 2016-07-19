package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.List;

public class GetConnectedNodesResponse
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<GetConnectedNodesResponse> CREATOR = new zzaq();
  public final List<NodeParcelable> aKL;
  public final int statusCode;
  public final int versionCode;
  
  GetConnectedNodesResponse(int paramInt1, int paramInt2, List<NodeParcelable> paramList)
  {
    versionCode = paramInt1;
    statusCode = paramInt2;
    aKL = paramList;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzaq.zza(this, paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.wearable.internal.GetConnectedNodesResponse
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */