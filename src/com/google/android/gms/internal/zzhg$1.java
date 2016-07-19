package com.google.android.gms.internal;

import android.app.DownloadManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class zzhg$1
  implements DialogInterface.OnClickListener
{
  zzhg$1(zzhg paramzzhg, String paramString1, String paramString2) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = (DownloadManager)zzhg.zza(zzbra).getSystemService("download");
    try
    {
      paramDialogInterface.enqueue(zzbra.zzk(zzbqy, zzbqz));
      return;
    }
    catch (IllegalStateException paramDialogInterface)
    {
      zzbra.zzbu("Could not store picture.");
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzhg.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */