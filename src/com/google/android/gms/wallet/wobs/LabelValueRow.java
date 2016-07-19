package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.util.zzb;
import java.util.ArrayList;

public final class LabelValueRow
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<LabelValueRow> CREATOR = new zzc();
  String aIE;
  String aIF;
  ArrayList<LabelValue> aIG;
  private final int mVersionCode;
  
  LabelValueRow()
  {
    mVersionCode = 1;
    aIG = zzb.zzavf();
  }
  
  LabelValueRow(int paramInt, String paramString1, String paramString2, ArrayList<LabelValue> paramArrayList)
  {
    mVersionCode = paramInt;
    aIE = paramString1;
    aIF = paramString2;
    aIG = paramArrayList;
  }
  
  public int getVersionCode()
  {
    return mVersionCode;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzc.zza(this, paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.wallet.wobs.LabelValueRow
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */