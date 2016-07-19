package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import java.util.Iterator;
import java.util.Set;

class EventParams$1
  implements Iterator<String>
{
  Iterator<String> akd = EventParams.zza(ake).keySet().iterator();
  
  EventParams$1(EventParams paramEventParams) {}
  
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
}

/* Location:
 * Qualified Name:     com.google.android.gms.measurement.internal.EventParams.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */