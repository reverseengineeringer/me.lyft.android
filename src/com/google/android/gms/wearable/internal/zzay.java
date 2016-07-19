package com.google.android.gms.wearable.internal;

import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

final class zzay<T>
{
  private final Map<T, zzbq<T>> Py = new HashMap();
  
  public void zzli(IBinder paramIBinder)
  {
    synchronized (Py)
    {
      paramIBinder = zzax.zza.zzlh(paramIBinder);
      zzbo.zzo localzzo = new zzbo.zzo();
      Iterator localIterator = Py.entrySet().iterator();
      for (;;)
      {
        if (localIterator.hasNext())
        {
          Object localObject2 = (Map.Entry)localIterator.next();
          Object localObject1 = (zzbq)((Map.Entry)localObject2).getValue();
          try
          {
            paramIBinder.zza(localzzo, new AddListenerRequest((zzbq)localObject1));
            if (Log.isLoggable("WearableClient", 2))
            {
              String str1 = String.valueOf(((Map.Entry)localObject2).getKey());
              String str2 = String.valueOf(localObject1);
              Log.d("WearableClient", String.valueOf(str1).length() + 27 + String.valueOf(str2).length() + "onPostInitHandler: added: " + str1 + "/" + str2);
            }
          }
          catch (RemoteException localRemoteException)
          {
            localObject2 = String.valueOf(((Map.Entry)localObject2).getKey());
            localObject1 = String.valueOf(localObject1);
            Log.d("WearableClient", String.valueOf(localObject2).length() + 32 + String.valueOf(localObject1).length() + "onPostInitHandler: Didn't add: " + (String)localObject2 + "/" + (String)localObject1);
          }
        }
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.wearable.internal.zzay
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */