package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.zzc;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class zzd<T extends IInterface>
{
  public static final String[] xt = { "service_esmobile", "service_googleme" };
  private final Context mContext;
  final Handler mHandler;
  private final zzc tp;
  private int xb;
  private long xc;
  private long xd;
  private int xe;
  private long xf;
  private final zzm xg;
  private final Object xh = new Object();
  private zzu xi;
  private zzf xj;
  private T xk;
  private final ArrayList<zze<?>> xl = new ArrayList();
  private zzh xm;
  private int xn = 1;
  private final zzb xo;
  private final zzc xp;
  private final int xq;
  private final String xr;
  protected AtomicInteger xs = new AtomicInteger(0);
  private final Looper zzahv;
  private final Object zzail = new Object();
  
  protected zzd(Context paramContext, Looper paramLooper, int paramInt, zzb paramzzb, zzc paramzzc, String paramString)
  {
    this(paramContext, paramLooper, zzm.zzce(paramContext), zzc.zzand(), paramInt, (zzb)zzab.zzaa(paramzzb), (zzc)zzab.zzaa(paramzzc), paramString);
  }
  
  protected zzd(Context paramContext, Looper paramLooper, zzm paramzzm, zzc paramzzc, int paramInt, zzb paramzzb, zzc paramzzc1, String paramString)
  {
    mContext = ((Context)zzab.zzb(paramContext, "Context must not be null"));
    zzahv = ((Looper)zzab.zzb(paramLooper, "Looper must not be null"));
    xg = ((zzm)zzab.zzb(paramzzm, "Supervisor must not be null"));
    tp = ((zzc)zzab.zzb(paramzzc, "API availability must not be null"));
    mHandler = new zzd(paramLooper);
    xq = paramInt;
    xo = paramzzb;
    xp = paramzzc1;
    xr = paramString;
  }
  
  private boolean zza(int paramInt1, int paramInt2, T paramT)
  {
    synchronized (zzail)
    {
      if (xn != paramInt1) {
        return false;
      }
      zzb(paramInt2, paramT);
      return true;
    }
  }
  
  private void zzarr()
  {
    String str1;
    String str2;
    if (xm != null)
    {
      str1 = String.valueOf(zzra());
      str2 = String.valueOf(zzarp());
      Log.e("GmsClient", String.valueOf(str1).length() + 70 + String.valueOf(str2).length() + "Calling connect() while still connected, missing disconnect() for " + str1 + " on " + str2);
      xg.zzb(zzra(), zzarp(), xm, zzarq());
      xs.incrementAndGet();
    }
    xm = new zzh(xs.get());
    if (!xg.zza(zzra(), zzarp(), xm, zzarq()))
    {
      str1 = String.valueOf(zzra());
      str2 = String.valueOf(zzarp());
      Log.e("GmsClient", String.valueOf(str1).length() + 34 + String.valueOf(str2).length() + "unable to connect to service: " + str1 + " on " + str2);
      zza(16, null, xs.get());
    }
  }
  
  private void zzars()
  {
    if (xm != null)
    {
      xg.zzb(zzra(), zzarp(), xm, zzarq());
      xm = null;
    }
  }
  
  private void zzb(int paramInt, T paramT)
  {
    boolean bool = true;
    int i;
    int j;
    if (paramInt == 3)
    {
      i = 1;
      if (paramT == null) {
        break label120;
      }
      j = 1;
      label17:
      if (i != j) {
        break label126;
      }
    }
    for (;;)
    {
      zzab.zzbn(bool);
      for (;;)
      {
        synchronized (zzail)
        {
          xn = paramInt;
          xk = paramT;
          zzc(paramInt, paramT);
          switch (paramInt)
          {
          case 2: 
            return;
            zzarr();
          }
        }
        zza(paramT);
        continue;
        zzars();
      }
      i = 0;
      break;
      label120:
      j = 0;
      break label17;
      label126:
      bool = false;
    }
  }
  
  public void disconnect()
  {
    xs.incrementAndGet();
    synchronized (xl)
    {
      int j = xl.size();
      int i = 0;
      while (i < j)
      {
        ((zze)xl.get(i)).zzasc();
        i += 1;
      }
      xl.clear();
    }
    synchronized (xh)
    {
      xi = null;
      zzb(1, null);
      return;
      localObject2 = finally;
      throw ((Throwable)localObject2);
    }
  }
  
  public void dump(String paramString, FileDescriptor arg2, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    for (;;)
    {
      synchronized (zzail)
      {
        int i = xn;
        paramArrayOfString = xk;
        paramPrintWriter.append(paramString).append("mConnectState=");
        switch (i)
        {
        default: 
          paramPrintWriter.print("UNKNOWN");
          paramPrintWriter.append(" mService=");
          if (paramArrayOfString != null) {
            break label482;
          }
          paramPrintWriter.println("null");
          ??? = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.US);
          long l;
          String str;
          if (xd > 0L)
          {
            paramArrayOfString = paramPrintWriter.append(paramString).append("lastConnectedTime=");
            l = xd;
            str = String.valueOf(???.format(new Date(xd)));
            paramArrayOfString.println(String.valueOf(str).length() + 21 + l + " " + str);
          }
          if (xc > 0L) {
            paramPrintWriter.append(paramString).append("lastSuspendedCause=");
          }
          switch (xb)
          {
          default: 
            paramPrintWriter.append(String.valueOf(xb));
            paramArrayOfString = paramPrintWriter.append(" lastSuspendedTime=");
            l = xc;
            str = String.valueOf(???.format(new Date(xc)));
            paramArrayOfString.println(String.valueOf(str).length() + 21 + l + " " + str);
            if (xf > 0L)
            {
              paramPrintWriter.append(paramString).append("lastFailedStatus=").append(CommonStatusCodes.getStatusCodeString(xe));
              paramString = paramPrintWriter.append(" lastFailedTime=");
              l = xf;
              ??? = String.valueOf(???.format(new Date(xf)));
              paramString.println(String.valueOf(???).length() + 21 + l + " " + ???);
            }
            return;
          }
          break;
        }
      }
      paramPrintWriter.print("CONNECTING");
      continue;
      paramPrintWriter.print("CONNECTED");
      continue;
      paramPrintWriter.print("DISCONNECTING");
      continue;
      paramPrintWriter.print("DISCONNECTED");
      continue;
      label482:
      paramPrintWriter.append(zzrb()).append("@").println(Integer.toHexString(System.identityHashCode(paramArrayOfString.asBinder())));
      continue;
      paramPrintWriter.append("CAUSE_SERVICE_DISCONNECTED");
      continue;
      paramPrintWriter.append("CAUSE_NETWORK_LOST");
    }
  }
  
  public Account getAccount()
  {
    return null;
  }
  
  public final Context getContext()
  {
    return mContext;
  }
  
  public boolean isConnected()
  {
    for (;;)
    {
      synchronized (zzail)
      {
        if (xn == 3)
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }
  
  public boolean isConnecting()
  {
    for (;;)
    {
      synchronized (zzail)
      {
        if (xn == 2)
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }
  
  protected void onConnectionFailed(ConnectionResult paramConnectionResult)
  {
    xe = paramConnectionResult.getErrorCode();
    xf = System.currentTimeMillis();
  }
  
  protected void onConnectionSuspended(int paramInt)
  {
    xb = paramInt;
    xc = System.currentTimeMillis();
  }
  
  protected void zza(int paramInt1, Bundle paramBundle, int paramInt2)
  {
    mHandler.sendMessage(mHandler.obtainMessage(5, paramInt2, -1, new zzk(paramInt1, paramBundle)));
  }
  
  protected void zza(int paramInt1, IBinder paramIBinder, Bundle paramBundle, int paramInt2)
  {
    mHandler.sendMessage(mHandler.obtainMessage(1, paramInt2, -1, new zzj(paramInt1, paramIBinder, paramBundle)));
  }
  
  protected void zza(T paramT)
  {
    xd = System.currentTimeMillis();
  }
  
  public void zza(zzf paramzzf)
  {
    xj = ((zzf)zzab.zzb(paramzzf, "Connection progress callbacks cannot be null."));
    zzb(2, null);
  }
  
  public void zza(zzf paramzzf, ConnectionResult paramConnectionResult)
  {
    xj = ((zzf)zzab.zzb(paramzzf, "Connection progress callbacks cannot be null."));
    mHandler.sendMessage(mHandler.obtainMessage(3, xs.get(), paramConnectionResult.getErrorCode(), paramConnectionResult.getResolution()));
  }
  
  public void zza(zzq arg1, Set<Scope> paramSet)
  {
    try
    {
      Object localObject = zzaeu();
      localObject = new GetServiceRequest(xq).zzhm(mContext.getPackageName()).zzn((Bundle)localObject);
      if (paramSet != null) {
        ((GetServiceRequest)localObject).zzf(paramSet);
      }
      if (zzafk()) {
        ((GetServiceRequest)localObject).zzd(zzaru()).zzb(???);
      }
      return;
    }
    catch (DeadObjectException ???)
    {
      synchronized (xh)
      {
        while (xi != null)
        {
          xi.zza(new zzg(this, xs.get()), (GetServiceRequest)localObject);
          return;
          if (zzarx())
          {
            ((GetServiceRequest)localObject).zzd(getAccount());
            continue;
            ??? = ???;
            Log.w("GmsClient", "service died");
            zzfy(1);
            return;
          }
        }
        Log.w("GmsClient", "mServiceBroker is null, client disconnected");
      }
    }
    catch (RemoteException ???)
    {
      Log.w("GmsClient", "Remote exception occurred", ???);
    }
  }
  
  protected Bundle zzaeu()
  {
    return new Bundle();
  }
  
  public boolean zzafk()
  {
    return false;
  }
  
  public boolean zzafz()
  {
    return false;
  }
  
  public Intent zzaga()
  {
    throw new UnsupportedOperationException("Not a sign in API");
  }
  
  public Bundle zzamc()
  {
    return null;
  }
  
  public boolean zzanr()
  {
    return true;
  }
  
  public IBinder zzans()
  {
    synchronized (xh)
    {
      if (xi == null) {
        return null;
      }
      IBinder localIBinder = xi.asBinder();
      return localIBinder;
    }
  }
  
  protected String zzarp()
  {
    return "com.google.android.gms";
  }
  
  protected final String zzarq()
  {
    if (xr == null) {
      return mContext.getClass().getName();
    }
    return xr;
  }
  
  public void zzart()
  {
    int i = tp.isGooglePlayServicesAvailable(mContext);
    if (i != 0)
    {
      zzb(1, null);
      xj = new zzi();
      mHandler.sendMessage(mHandler.obtainMessage(3, xs.get(), i));
      return;
    }
    zza(new zzi());
  }
  
  public final Account zzaru()
  {
    if (getAccount() != null) {
      return getAccount();
    }
    return new Account("<<default account>>", "com.google");
  }
  
  protected final void zzarv()
  {
    if (!isConnected()) {
      throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
    }
  }
  
  public final T zzarw()
    throws DeadObjectException
  {
    synchronized (zzail)
    {
      if (xn == 4) {
        throw new DeadObjectException();
      }
    }
    zzarv();
    if (xk != null) {}
    for (boolean bool = true;; bool = false)
    {
      zzab.zza(bool, "Client is connected but service is null");
      IInterface localIInterface = xk;
      return localIInterface;
    }
  }
  
  public boolean zzarx()
  {
    return false;
  }
  
  protected Set<Scope> zzary()
  {
    return Collections.EMPTY_SET;
  }
  
  protected abstract T zzbb(IBinder paramIBinder);
  
  void zzc(int paramInt, T paramT) {}
  
  public void zzfy(int paramInt)
  {
    mHandler.sendMessage(mHandler.obtainMessage(4, xs.get(), paramInt));
  }
  
  protected abstract String zzra();
  
  protected abstract String zzrb();
  
  private abstract class zza
    extends zzd.zze<Boolean>
  {
    public final int statusCode;
    public final Bundle xu;
    
    protected zza(int paramInt, Bundle paramBundle)
    {
      super(Boolean.valueOf(true));
      statusCode = paramInt;
      xu = paramBundle;
    }
    
    protected abstract boolean zzarz();
    
    protected void zzasa() {}
    
    protected void zzc(Boolean paramBoolean)
    {
      Object localObject = null;
      if (paramBoolean == null) {
        zzd.zza(zzd.this, 1, null);
      }
      do
      {
        return;
        switch (statusCode)
        {
        default: 
          zzd.zza(zzd.this, 1, null);
          paramBoolean = (Boolean)localObject;
          if (xu != null) {
            paramBoolean = (PendingIntent)xu.getParcelable("pendingIntent");
          }
          zzl(new ConnectionResult(statusCode, paramBoolean));
          return;
        }
      } while (zzarz());
      zzd.zza(zzd.this, 1, null);
      zzl(new ConnectionResult(8, null));
      return;
      zzd.zza(zzd.this, 1, null);
      throw new IllegalStateException("A fatal developer error has occurred. Check the logs for further information.");
    }
    
    protected abstract void zzl(ConnectionResult paramConnectionResult);
  }
  
  public static abstract interface zzb
  {
    public abstract void onConnected(Bundle paramBundle);
    
    public abstract void onConnectionSuspended(int paramInt);
  }
  
  public static abstract interface zzc
  {
    public abstract void onConnectionFailed(ConnectionResult paramConnectionResult);
  }
  
  final class zzd
    extends Handler
  {
    public zzd(Looper paramLooper)
    {
      super();
    }
    
    private void zza(Message paramMessage)
    {
      paramMessage = (zzd.zze)obj;
      paramMessage.zzasa();
      paramMessage.unregister();
    }
    
    private boolean zzb(Message paramMessage)
    {
      return (what == 2) || (what == 1) || (what == 5);
    }
    
    public void handleMessage(Message paramMessage)
    {
      PendingIntent localPendingIntent = null;
      if (xs.get() != arg1)
      {
        if (zzb(paramMessage)) {
          zza(paramMessage);
        }
        return;
      }
      if (((what == 1) || (what == 5)) && (!isConnecting()))
      {
        zza(paramMessage);
        return;
      }
      if (what == 3)
      {
        if ((obj instanceof PendingIntent)) {
          localPendingIntent = (PendingIntent)obj;
        }
        paramMessage = new ConnectionResult(arg2, localPendingIntent);
        zzd.zzb(zzd.this).zzh(paramMessage);
        onConnectionFailed(paramMessage);
        return;
      }
      if (what == 4)
      {
        zzd.zza(zzd.this, 4, null);
        if (zzd.zzc(zzd.this) != null) {
          zzd.zzc(zzd.this).onConnectionSuspended(arg2);
        }
        onConnectionSuspended(arg2);
        zzd.zza(zzd.this, 4, 1, null);
        return;
      }
      if ((what == 2) && (!isConnected()))
      {
        zza(paramMessage);
        return;
      }
      if (zzb(paramMessage))
      {
        ((zzd.zze)obj).zzasb();
        return;
      }
      int i = what;
      Log.wtf("GmsClient", 45 + "Don't know how to handle message: " + i, new Exception());
    }
  }
  
  protected abstract class zze<TListener>
  {
    private TListener mListener;
    private boolean xw;
    
    public zze()
    {
      Object localObject;
      mListener = localObject;
      xw = false;
    }
    
    public void unregister()
    {
      zzasc();
      synchronized (zzd.zzd(zzd.this))
      {
        zzd.zzd(zzd.this).remove(this);
        return;
      }
    }
    
    protected abstract void zzasa();
    
    public void zzasb()
    {
      for (;;)
      {
        try
        {
          Object localObject1 = mListener;
          if (xw)
          {
            String str = String.valueOf(this);
            Log.w("GmsClient", String.valueOf(str).length() + 47 + "Callback proxy " + str + " being reused. This is not safe.");
          }
          if (localObject1 != null) {}
          zzasa();
        }
        finally
        {
          try
          {
            zzx(localObject1);
          }
          catch (RuntimeException localRuntimeException)
          {
            zzasa();
            throw localRuntimeException;
          }
          try
          {
            xw = true;
            unregister();
            return;
          }
          finally {}
          localObject2 = finally;
        }
      }
    }
    
    public void zzasc()
    {
      try
      {
        mListener = null;
        return;
      }
      finally {}
    }
    
    protected abstract void zzx(TListener paramTListener);
  }
  
  public static abstract interface zzf
  {
    public abstract void zzh(ConnectionResult paramConnectionResult);
  }
  
  public static final class zzg
    extends zzt.zza
  {
    private zzd xx;
    private final int xy;
    
    public zzg(zzd paramzzd, int paramInt)
    {
      xx = paramzzd;
      xy = paramInt;
    }
    
    private void zzasd()
    {
      xx = null;
    }
    
    public void zza(int paramInt, IBinder paramIBinder, Bundle paramBundle)
    {
      zzab.zzb(xx, "onPostInitComplete can be called only once per call to getRemoteService");
      xx.zza(paramInt, paramIBinder, paramBundle, xy);
      zzasd();
    }
    
    public void zzb(int paramInt, Bundle paramBundle)
    {
      Log.wtf("GmsClient", "received deprecated onAccountValidationComplete callback, ignoring", new Exception());
    }
  }
  
  public final class zzh
    implements ServiceConnection
  {
    private final int xy;
    
    public zzh(int paramInt)
    {
      xy = paramInt;
    }
    
    public void onServiceConnected(ComponentName arg1, IBinder paramIBinder)
    {
      zzab.zzb(paramIBinder, "Expecting a valid IBinder");
      synchronized (zzd.zza(zzd.this))
      {
        zzd.zza(zzd.this, zzu.zza.zzdt(paramIBinder));
        zza(0, null, xy);
        return;
      }
    }
    
    public void onServiceDisconnected(ComponentName arg1)
    {
      synchronized (zzd.zza(zzd.this))
      {
        zzd.zza(zzd.this, null);
        mHandler.sendMessage(mHandler.obtainMessage(4, xy, 1));
        return;
      }
    }
  }
  
  protected class zzi
    implements zzd.zzf
  {
    public zzi() {}
    
    public void zzh(ConnectionResult paramConnectionResult)
    {
      if (paramConnectionResult.isSuccess()) {
        zza(null, zzary());
      }
      while (zzd.zze(zzd.this) == null) {
        return;
      }
      zzd.zze(zzd.this).onConnectionFailed(paramConnectionResult);
    }
  }
  
  protected final class zzj
    extends zzd.zza
  {
    public final IBinder xz;
    
    public zzj(int paramInt, IBinder paramIBinder, Bundle paramBundle)
    {
      super(paramInt, paramBundle);
      xz = paramIBinder;
    }
    
    protected boolean zzarz()
    {
      do
      {
        try
        {
          String str1 = xz.getInterfaceDescriptor();
          if (!zzrb().equals(str1))
          {
            String str2 = String.valueOf(zzrb());
            Log.e("GmsClient", String.valueOf(str2).length() + 34 + String.valueOf(str1).length() + "service descriptor mismatch: " + str2 + " vs. " + str1);
            return false;
          }
        }
        catch (RemoteException localRemoteException)
        {
          Log.w("GmsClient", "service probably died");
          return false;
        }
        localObject = zzbb(xz);
      } while ((localObject == null) || (!zzd.zza(zzd.this, 2, 3, (IInterface)localObject)));
      Object localObject = zzamc();
      if (zzd.zzc(zzd.this) != null) {
        zzd.zzc(zzd.this).onConnected((Bundle)localObject);
      }
      return true;
    }
    
    protected void zzl(ConnectionResult paramConnectionResult)
    {
      if (zzd.zze(zzd.this) != null) {
        zzd.zze(zzd.this).onConnectionFailed(paramConnectionResult);
      }
      onConnectionFailed(paramConnectionResult);
    }
  }
  
  protected final class zzk
    extends zzd.zza
  {
    public zzk(int paramInt, Bundle paramBundle)
    {
      super(paramInt, paramBundle);
    }
    
    protected boolean zzarz()
    {
      zzd.zzb(zzd.this).zzh(ConnectionResult.qR);
      return true;
    }
    
    protected void zzl(ConnectionResult paramConnectionResult)
    {
      zzd.zzb(zzd.this).zzh(paramConnectionResult);
      onConnectionFailed(paramConnectionResult);
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.internal.zzd
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */