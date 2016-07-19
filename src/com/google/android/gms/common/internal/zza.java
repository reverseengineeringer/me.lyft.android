package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Binder;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.zze;

public class zza
  extends zzq.zza
{
  int wX;
  
  public static Account zza(zzq paramzzq)
  {
    Account localAccount = null;
    long l;
    if (paramzzq != null) {
      l = Binder.clearCallingIdentity();
    }
    try
    {
      localAccount = paramzzq.getAccount();
      return localAccount;
    }
    catch (RemoteException paramzzq)
    {
      Log.w("AccountAccessor", "Remote account accessor probably died");
      return null;
    }
    finally
    {
      Binder.restoreCallingIdentity(l);
    }
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof zza)) {
      return false;
    }
    paramObject = (zza)paramObject;
    throw new NullPointerException();
  }
  
  public Account getAccount()
  {
    int i = Binder.getCallingUid();
    if (i == wX) {
      return null;
    }
    if (zze.zze(null, i))
    {
      wX = i;
      return null;
    }
    throw new SecurityException("Caller is not GooglePlayServices");
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.internal.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */