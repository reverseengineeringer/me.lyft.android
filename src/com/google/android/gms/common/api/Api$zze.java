package com.google.android.gms.common.api;

import android.content.Intent;
import android.os.IBinder;
import com.google.android.gms.common.internal.zzd.zzf;
import com.google.android.gms.common.internal.zzq;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Set;

public abstract interface Api$zze
  extends Api.zzb
{
  public abstract void disconnect();
  
  public abstract void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString);
  
  public abstract boolean isConnected();
  
  public abstract boolean isConnecting();
  
  public abstract void zza(zzd.zzf paramzzf);
  
  public abstract void zza(zzq paramzzq, Set<Scope> paramSet);
  
  public abstract boolean zzafk();
  
  public abstract boolean zzafz();
  
  public abstract Intent zzaga();
  
  public abstract boolean zzanr();
  
  public abstract IBinder zzans();
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.api.Api.zze
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */