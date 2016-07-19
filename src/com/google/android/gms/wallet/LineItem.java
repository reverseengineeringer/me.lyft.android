package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public final class LineItem
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<LineItem> CREATOR = new zzj();
  String aGG;
  String aGH;
  int aGI;
  String aGc;
  String aGd;
  String description;
  private final int mVersionCode;
  
  LineItem()
  {
    mVersionCode = 1;
    aGI = 0;
  }
  
  LineItem(int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt2, String paramString5)
  {
    mVersionCode = paramInt1;
    description = paramString1;
    aGG = paramString2;
    aGH = paramString3;
    aGc = paramString4;
    aGI = paramInt2;
    aGd = paramString5;
  }
  
  public int getVersionCode()
  {
    return mVersionCode;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzj.zza(this, paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.wallet.LineItem
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */