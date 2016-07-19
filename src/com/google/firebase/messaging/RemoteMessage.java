package com.google.firebase.messaging;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.util.ArrayMap;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class RemoteMessage
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<RemoteMessage> CREATOR = new zzc();
  Bundle bM;
  final int mVersionCode;
  private Map<String, String> zzctg;
  
  RemoteMessage(int paramInt, Bundle paramBundle)
  {
    mVersionCode = paramInt;
    bM = paramBundle;
  }
  
  RemoteMessage(Bundle paramBundle)
  {
    this(1, paramBundle);
  }
  
  public Map<String, String> getData()
  {
    if (zzctg == null)
    {
      zzctg = new ArrayMap();
      Iterator localIterator = bM.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        Object localObject = bM.get(str);
        if ((localObject instanceof String))
        {
          localObject = (String)localObject;
          if ((!str.startsWith("google.")) && (!str.startsWith("gcm.")) && (!str.equals("from")) && (!str.equals("message_type")) && (!str.equals("collapse_key"))) {
            zzctg.put(str, localObject);
          }
        }
      }
    }
    return zzctg;
  }
  
  public String getFrom()
  {
    return bM.getString("from");
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzc.zza(this, paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.firebase.messaging.RemoteMessage
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */