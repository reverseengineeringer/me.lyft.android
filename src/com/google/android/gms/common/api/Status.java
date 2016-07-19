package com.google.android.gms.common.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.IntentSender.SendIntentException;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.internal.zzaa.zza;

public final class Status
  extends AbstractSafeParcelable
  implements Result
{
  public static final Parcelable.Creator<Status> CREATOR = new zzf();
  public static final Status sg = new Status(0);
  public static final Status sh = new Status(14);
  public static final Status si = new Status(8);
  public static final Status sj = new Status(15);
  public static final Status sk = new Status(16);
  public static final Status sl = new Status(17);
  public static final Status sm = new Status(18);
  private final PendingIntent mPendingIntent;
  private final int mVersionCode;
  private final int ob;
  private final String qS;
  
  public Status(int paramInt)
  {
    this(paramInt, null);
  }
  
  Status(int paramInt1, int paramInt2, String paramString, PendingIntent paramPendingIntent)
  {
    mVersionCode = paramInt1;
    ob = paramInt2;
    qS = paramString;
    mPendingIntent = paramPendingIntent;
  }
  
  public Status(int paramInt, String paramString)
  {
    this(1, paramInt, paramString, null);
  }
  
  public Status(int paramInt, String paramString, PendingIntent paramPendingIntent)
  {
    this(1, paramInt, paramString, paramPendingIntent);
  }
  
  private String zzaoj()
  {
    if (qS != null) {
      return qS;
    }
    return CommonStatusCodes.getStatusCodeString(ob);
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof Status)) {}
    do
    {
      return false;
      paramObject = (Status)paramObject;
    } while ((mVersionCode != mVersionCode) || (ob != ob) || (!zzaa.equal(qS, qS)) || (!zzaa.equal(mPendingIntent, mPendingIntent)));
    return true;
  }
  
  public Status getStatus()
  {
    return this;
  }
  
  public int getStatusCode()
  {
    return ob;
  }
  
  public String getStatusMessage()
  {
    return qS;
  }
  
  int getVersionCode()
  {
    return mVersionCode;
  }
  
  public boolean hasResolution()
  {
    return mPendingIntent != null;
  }
  
  public int hashCode()
  {
    return zzaa.hashCode(new Object[] { Integer.valueOf(mVersionCode), Integer.valueOf(ob), qS, mPendingIntent });
  }
  
  public boolean isSuccess()
  {
    return ob <= 0;
  }
  
  public void startResolutionForResult(Activity paramActivity, int paramInt)
    throws IntentSender.SendIntentException
  {
    if (!hasResolution()) {
      return;
    }
    paramActivity.startIntentSenderForResult(mPendingIntent.getIntentSender(), paramInt, null, 0, 0, 0);
  }
  
  public String toString()
  {
    return zzaa.zzz(this).zzg("statusCode", zzaoj()).zzg("resolution", mPendingIntent).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzf.zza(this, paramParcel, paramInt);
  }
  
  PendingIntent zzaoi()
  {
    return mPendingIntent;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.api.Status
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */