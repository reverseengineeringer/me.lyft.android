package com.google.android.gms.signin.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.ResolveAccountRequest;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.common.internal.zzd.zzi;
import com.google.android.gms.common.internal.zzq;
import com.google.android.gms.internal.zzvx;
import com.google.android.gms.internal.zzvy;

public class zzg
  extends com.google.android.gms.common.internal.zzk<zze>
  implements zzvx
{
  private final boolean auv;
  private final Bundle auw;
  private final com.google.android.gms.common.internal.zzg tD;
  private Integer yb;
  
  public zzg(Context paramContext, Looper paramLooper, boolean paramBoolean, com.google.android.gms.common.internal.zzg paramzzg, Bundle paramBundle, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    super(paramContext, paramLooper, 44, paramzzg, paramConnectionCallbacks, paramOnConnectionFailedListener);
    auv = paramBoolean;
    tD = paramzzg;
    auw = paramBundle;
    yb = paramzzg.zzasm();
  }
  
  public zzg(Context paramContext, Looper paramLooper, boolean paramBoolean, com.google.android.gms.common.internal.zzg paramzzg, zzvy paramzzvy, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    this(paramContext, paramLooper, paramBoolean, paramzzg, zza(paramzzg), paramConnectionCallbacks, paramOnConnectionFailedListener);
  }
  
  public static Bundle zza(com.google.android.gms.common.internal.zzg paramzzg)
  {
    zzvy localzzvy = paramzzg.zzasl();
    Integer localInteger = paramzzg.zzasm();
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("com.google.android.gms.signin.internal.clientRequestedAccount", paramzzg.getAccount());
    if (localInteger != null) {
      localBundle.putInt("com.google.android.gms.common.internal.ClientSettings.sessionId", localInteger.intValue());
    }
    if (localzzvy != null)
    {
      localBundle.putBoolean("com.google.android.gms.signin.internal.offlineAccessRequested", localzzvy.zzbzl());
      localBundle.putBoolean("com.google.android.gms.signin.internal.idTokenRequested", localzzvy.zzafr());
      localBundle.putString("com.google.android.gms.signin.internal.serverClientId", localzzvy.zzafu());
      localBundle.putBoolean("com.google.android.gms.signin.internal.usePromptModeForAuthCode", true);
      localBundle.putBoolean("com.google.android.gms.signin.internal.forceCodeForRefreshToken", localzzvy.zzaft());
      localBundle.putString("com.google.android.gms.signin.internal.hostedDomain", localzzvy.zzafv());
      localBundle.putBoolean("com.google.android.gms.signin.internal.waitForAccessTokenRefresh", localzzvy.zzbzm());
      if (localzzvy.zzbzn() != null) {
        localBundle.putLong("com.google.android.gms.signin.internal.authApiSignInModuleVersion", localzzvy.zzbzn().longValue());
      }
      if (localzzvy.zzbzo() != null) {
        localBundle.putLong("com.google.android.gms.signin.internal.realClientLibraryVersion", localzzvy.zzbzo().longValue());
      }
    }
    return localBundle;
  }
  
  private ResolveAccountRequest zzbzt()
  {
    Account localAccount = tD.zzaru();
    GoogleSignInAccount localGoogleSignInAccount = null;
    if ("<<default account>>".equals(name)) {
      localGoogleSignInAccount = com.google.android.gms.auth.api.signin.internal.zzk.zzbc(getContext()).zzagj();
    }
    return new ResolveAccountRequest(localAccount, yb.intValue(), localGoogleSignInAccount);
  }
  
  public void connect()
  {
    zza(new zzd.zzi(this));
  }
  
  public void zza(zzq paramzzq, boolean paramBoolean)
  {
    try
    {
      ((zze)zzarw()).zza(paramzzq, yb.intValue(), paramBoolean);
      return;
    }
    catch (RemoteException paramzzq)
    {
      Log.w("SignInClientImpl", "Remote service probably died when saveDefaultAccount is called");
    }
  }
  
  public void zza(zzd paramzzd)
  {
    zzab.zzb(paramzzd, "Expecting a valid ISignInCallbacks");
    try
    {
      ResolveAccountRequest localResolveAccountRequest = zzbzt();
      ((zze)zzarw()).zza(new SignInRequest(localResolveAccountRequest), paramzzd);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      Log.w("SignInClientImpl", "Remote service probably died when signIn is called");
      try
      {
        paramzzd.zzb(new SignInResponse(8));
        return;
      }
      catch (RemoteException paramzzd)
      {
        Log.wtf("SignInClientImpl", "ISignInCallbacks#onSignInComplete should be executed from the same process, unexpected RemoteException.", localRemoteException);
      }
    }
  }
  
  protected Bundle zzaeu()
  {
    String str = tD.zzasi();
    if (!getContext().getPackageName().equals(str)) {
      auw.putString("com.google.android.gms.signin.internal.realClientPackageName", tD.zzasi());
    }
    return auw;
  }
  
  public boolean zzafk()
  {
    return auv;
  }
  
  public void zzbzk()
  {
    try
    {
      ((zze)zzarw()).zzxs(yb.intValue());
      return;
    }
    catch (RemoteException localRemoteException)
    {
      Log.w("SignInClientImpl", "Remote service probably died when clearAccountFromSessionStore is called");
    }
  }
  
  protected zze zzkj(IBinder paramIBinder)
  {
    return zze.zza.zzki(paramIBinder);
  }
  
  protected String zzra()
  {
    return "com.google.android.gms.signin.service.START";
  }
  
  protected String zzrb()
  {
    return "com.google.android.gms.signin.internal.ISignInService";
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.signin.internal.zzg
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */