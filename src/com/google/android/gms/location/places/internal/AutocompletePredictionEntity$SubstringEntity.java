package com.google.android.gms.location.places.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.internal.zzaa.zza;

public class AutocompletePredictionEntity$SubstringEntity
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<SubstringEntity> CREATOR = new zzu();
  final int mLength;
  final int mOffset;
  final int mVersionCode;
  
  public AutocompletePredictionEntity$SubstringEntity(int paramInt1, int paramInt2, int paramInt3)
  {
    mVersionCode = paramInt1;
    mOffset = paramInt2;
    mLength = paramInt3;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof SubstringEntity)) {
        return false;
      }
      paramObject = (SubstringEntity)paramObject;
    } while ((zzaa.equal(Integer.valueOf(mOffset), Integer.valueOf(mOffset))) && (zzaa.equal(Integer.valueOf(mLength), Integer.valueOf(mLength))));
    return false;
  }
  
  public int getLength()
  {
    return mLength;
  }
  
  public int getOffset()
  {
    return mOffset;
  }
  
  public int hashCode()
  {
    return zzaa.hashCode(new Object[] { Integer.valueOf(mOffset), Integer.valueOf(mLength) });
  }
  
  public String toString()
  {
    return zzaa.zzz(this).zzg("offset", Integer.valueOf(mOffset)).zzg("length", Integer.valueOf(mLength)).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzu.zza(this, paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.location.places.internal.AutocompletePredictionEntity.SubstringEntity
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */