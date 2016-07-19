package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.WorkSource;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public class ActivityRecognitionRequest
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<ActivityRecognitionRequest> CREATOR = new zza();
  private long act;
  private boolean acu;
  private WorkSource acv;
  private int[] acw;
  private boolean acx;
  private String cf;
  private String mTag;
  private final int mVersionCode;
  
  ActivityRecognitionRequest(int paramInt, long paramLong, boolean paramBoolean1, WorkSource paramWorkSource, String paramString1, int[] paramArrayOfInt, boolean paramBoolean2, String paramString2)
  {
    mVersionCode = paramInt;
    act = paramLong;
    acu = paramBoolean1;
    acv = paramWorkSource;
    mTag = paramString1;
    acw = paramArrayOfInt;
    acx = paramBoolean2;
    cf = paramString2;
  }
  
  public String getAccountName()
  {
    return cf;
  }
  
  public long getIntervalMillis()
  {
    return act;
  }
  
  public String getTag()
  {
    return mTag;
  }
  
  int getVersionCode()
  {
    return mVersionCode;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zza.zza(this, paramParcel, paramInt);
  }
  
  public boolean zzbnb()
  {
    return acu;
  }
  
  public WorkSource zzbnc()
  {
    return acv;
  }
  
  public int[] zzbnd()
  {
    return acw;
  }
  
  public boolean zzbne()
  {
    return acx;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.location.ActivityRecognitionRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */