package com.google.android.gms.internal;

import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import java.io.FileDescriptor;
import java.io.PrintWriter;

class zzpp$zza
  implements GoogleApiClient.OnConnectionFailedListener
{
  public final int st;
  public final GoogleApiClient su;
  public final GoogleApiClient.OnConnectionFailedListener sv;
  
  public zzpp$zza(zzpp paramzzpp, int paramInt, GoogleApiClient paramGoogleApiClient, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    st = paramInt;
    su = paramGoogleApiClient;
    sv = paramOnConnectionFailedListener;
    paramGoogleApiClient.registerConnectionFailedListener(this);
  }
  
  public void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    paramPrintWriter.append(paramString).append("GoogleApiClient #").print(st);
    paramPrintWriter.println(":");
    su.dump(String.valueOf(paramString).concat("  "), paramFileDescriptor, paramPrintWriter, paramArrayOfString);
  }
  
  public void onConnectionFailed(ConnectionResult paramConnectionResult)
  {
    String str = String.valueOf(paramConnectionResult);
    Log.d("AutoManageHelper", String.valueOf(str).length() + 27 + "beginFailureResolution for " + str);
    sw.zzb(paramConnectionResult, st);
  }
  
  public void zzaom()
  {
    su.unregisterConnectionFailedListener(this);
    su.disconnect();
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzpp.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */