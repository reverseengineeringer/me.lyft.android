package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public class zzqo
{
  protected final zzqp va;
  
  protected zzqo(zzqp paramzzqp)
  {
    va = paramzzqp;
  }
  
  protected static zzqp zzc(zzqn paramzzqn)
  {
    if (paramzzqn.zzaqm()) {
      return zzra.zza(paramzzqn.zzaqo());
    }
    return zzqq.zzt(paramzzqn.zzaqn());
  }
  
  public void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString) {}
  
  public Activity getActivity()
  {
    return va.zzaqp();
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void onCreate(Bundle paramBundle) {}
  
  public void onSaveInstanceState(Bundle paramBundle) {}
  
  public void onStart() {}
  
  public void onStop() {}
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzqo
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */