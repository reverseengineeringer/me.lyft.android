package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zzab;
import java.util.Iterator;
import java.util.Set;

public class EventParams
  extends AbstractSafeParcelable
  implements Iterable<String>
{
  public static final zzj CREATOR = new zzj();
  private final Bundle akc;
  public final int versionCode;
  
  EventParams(int paramInt, Bundle paramBundle)
  {
    versionCode = paramInt;
    akc = paramBundle;
  }
  
  EventParams(Bundle paramBundle)
  {
    zzab.zzaa(paramBundle);
    akc = paramBundle;
    versionCode = 1;
  }
  
  Object get(String paramString)
  {
    return akc.get(paramString);
  }
  
  public Iterator<String> iterator()
  {
    new Iterator()
    {
      Iterator<String> akd = EventParams.zza(EventParams.this).keySet().iterator();
      
      public boolean hasNext()
      {
        return akd.hasNext();
      }
      
      public String next()
      {
        return (String)akd.next();
      }
      
      public void remove()
      {
        throw new UnsupportedOperationException("Remove not supported");
      }
    };
  }
  
  public int size()
  {
    return akc.size();
  }
  
  public String toString()
  {
    return akc.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzj.zza(this, paramParcel, paramInt);
  }
  
  public Bundle zzbto()
  {
    return new Bundle(akc);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.measurement.internal.EventParams
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */