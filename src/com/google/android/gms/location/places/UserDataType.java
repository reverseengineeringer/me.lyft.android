package com.google.android.gms.location.places;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.common.util.zzf;
import java.util.Set;

public final class UserDataType
  extends AbstractSafeParcelable
{
  public static final zzm CREATOR = new zzm();
  public static final UserDataType afe = zzw("test_type", 1);
  public static final UserDataType aff = zzw("labeled_place", 6);
  public static final UserDataType afg = zzw("here_content", 7);
  public static final Set<UserDataType> afh = zzf.zza(afe, aff, afg);
  final int afi;
  final int mVersionCode;
  final String zzcgd;
  
  UserDataType(int paramInt1, String paramString, int paramInt2)
  {
    zzab.zzhs(paramString);
    mVersionCode = paramInt1;
    zzcgd = paramString;
    afi = paramInt2;
  }
  
  private static UserDataType zzw(String paramString, int paramInt)
  {
    return new UserDataType(0, paramString, paramInt);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof UserDataType)) {
        return false;
      }
      paramObject = (UserDataType)paramObject;
    } while ((zzcgd.equals(zzcgd)) && (afi == afi));
    return false;
  }
  
  public int hashCode()
  {
    return zzcgd.hashCode();
  }
  
  public String toString()
  {
    return zzcgd;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzm.zza(this, paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.location.places.UserDataType
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */