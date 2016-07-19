package com.google.android.gms.common.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.util.Log;
import com.google.android.gms.internal.zzqp;

public abstract class zzi
  implements DialogInterface.OnClickListener
{
  public static zzi zza(Activity paramActivity, final Intent paramIntent, final int paramInt)
  {
    new zzi()
    {
      public void zzasn()
      {
        startActivityForResult(paramIntent, paramInt);
      }
    };
  }
  
  public static zzi zza(Fragment paramFragment, final Intent paramIntent, final int paramInt)
  {
    new zzi()
    {
      public void zzasn()
      {
        startActivityForResult(paramIntent, paramInt);
      }
    };
  }
  
  public static zzi zza(zzqp paramzzqp, final Intent paramIntent, final int paramInt)
  {
    new zzi()
    {
      @TargetApi(11)
      public void zzasn()
      {
        startActivityForResult(paramIntent, paramInt);
      }
    };
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    try
    {
      zzasn();
      paramDialogInterface.dismiss();
      return;
    }
    catch (ActivityNotFoundException paramDialogInterface)
    {
      Log.e("DialogRedirect", "Can't redirect to app settings for Google Play services");
    }
  }
  
  public abstract void zzasn();
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.internal.zzi
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */