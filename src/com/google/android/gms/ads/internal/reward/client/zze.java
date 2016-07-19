package com.google.android.gms.ads.internal.reward.client;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.internal.zzir;

@zzir
public class zze
  implements RewardItem
{
  private final zza zzcho;
  
  public zze(zza paramzza)
  {
    zzcho = paramzza;
  }
  
  public int getAmount()
  {
    if (zzcho == null) {
      return 0;
    }
    try
    {
      int i = zzcho.getAmount();
      return i;
    }
    catch (RemoteException localRemoteException)
    {
      zzb.zzd("Could not forward getAmount to RewardItem", localRemoteException);
    }
    return 0;
  }
  
  public String getType()
  {
    if (zzcho == null) {
      return null;
    }
    try
    {
      String str = zzcho.getType();
      return str;
    }
    catch (RemoteException localRemoteException)
    {
      zzb.zzd("Could not forward getType to RewardItem", localRemoteException);
    }
    return null;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.reward.client.zze
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */