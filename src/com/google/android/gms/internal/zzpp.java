package com.google.android.gms.internal;

import android.util.Log;
import android.util.SparseArray;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzab;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public class zzpp
  extends zzps
{
  private final SparseArray<zza> ss = new SparseArray();
  
  private zzpp(zzqp paramzzqp)
  {
    super(paramzzqp);
    va.zza("AutoManageHelper", this);
  }
  
  public static zzpp zza(zzqn paramzzqn)
  {
    paramzzqn = zzc(paramzzqn);
    zzpp localzzpp = (zzpp)paramzzqn.zza("AutoManageHelper", zzpp.class);
    if (localzzpp != null) {
      return localzzpp;
    }
    return new zzpp(paramzzqn);
  }
  
  public void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    int i = 0;
    while (i < ss.size())
    {
      ((zza)ss.valueAt(i)).dump(paramString, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
      i += 1;
    }
  }
  
  public void onStart()
  {
    super.onStart();
    boolean bool = mStarted;
    String str = String.valueOf(ss);
    Log.d("AutoManageHelper", String.valueOf(str).length() + 14 + "onStart " + bool + " " + str);
    if (!sB)
    {
      int i = 0;
      while (i < ss.size())
      {
        ss.valueAt(i)).su.connect();
        i += 1;
      }
    }
  }
  
  public void onStop()
  {
    super.onStop();
    int i = 0;
    while (i < ss.size())
    {
      ss.valueAt(i)).su.disconnect();
      i += 1;
    }
  }
  
  public void zza(int paramInt, GoogleApiClient paramGoogleApiClient, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    zzab.zzb(paramGoogleApiClient, "GoogleApiClient instance cannot be null");
    if (ss.indexOfKey(paramInt) < 0) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      zzab.zza(bool1, 54 + "Already managing a GoogleApiClient with id " + paramInt);
      bool1 = mStarted;
      boolean bool2 = sB;
      Log.d("AutoManageHelper", 54 + "starting AutoManage for client " + paramInt + " " + bool1 + " " + bool2);
      paramOnConnectionFailedListener = new zza(paramInt, paramGoogleApiClient, paramOnConnectionFailedListener);
      ss.put(paramInt, paramOnConnectionFailedListener);
      if ((mStarted) && (!sB))
      {
        paramOnConnectionFailedListener = String.valueOf(paramGoogleApiClient);
        Log.d("AutoManageHelper", String.valueOf(paramOnConnectionFailedListener).length() + 11 + "connecting " + paramOnConnectionFailedListener);
        paramGoogleApiClient.connect();
      }
      return;
    }
  }
  
  protected void zza(ConnectionResult paramConnectionResult, int paramInt)
  {
    Log.w("AutoManageHelper", "Unresolved error while connecting client. Stopping auto-manage.");
    if (paramInt < 0) {
      Log.wtf("AutoManageHelper", "AutoManageLifecycleHelper received onErrorResolutionFailed callback but no failing client ID is set", new Exception());
    }
    Object localObject;
    do
    {
      do
      {
        return;
        localObject = (zza)ss.get(paramInt);
      } while (localObject == null);
      zzff(paramInt);
      localObject = sv;
    } while (localObject == null);
    ((GoogleApiClient.OnConnectionFailedListener)localObject).onConnectionFailed(paramConnectionResult);
  }
  
  protected void zzaol()
  {
    int i = 0;
    while (i < ss.size())
    {
      ss.valueAt(i)).su.connect();
      i += 1;
    }
  }
  
  public void zzff(int paramInt)
  {
    zza localzza = (zza)ss.get(paramInt);
    ss.remove(paramInt);
    if (localzza != null) {
      localzza.zzaom();
    }
  }
  
  private class zza
    implements GoogleApiClient.OnConnectionFailedListener
  {
    public final int st;
    public final GoogleApiClient su;
    public final GoogleApiClient.OnConnectionFailedListener sv;
    
    public zza(int paramInt, GoogleApiClient paramGoogleApiClient, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
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
      zzb(paramConnectionResult, st);
    }
    
    public void zzaom()
    {
      su.unregisterConnectionFailedListener(this);
      su.disconnect();
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzpp
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */