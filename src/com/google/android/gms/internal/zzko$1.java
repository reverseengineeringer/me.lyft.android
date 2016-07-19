package com.google.android.gms.internal;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.google.android.gms.ads.internal.zzu;

class zzko$1
  implements DialogInterface.OnClickListener
{
  zzko$1(zzko paramzzko, String paramString) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    zzu.zzfq().zzb(zzko.zza(zzclu), Intent.createChooser(new Intent("android.intent.action.SEND").setType("text/plain").putExtra("android.intent.extra.TEXT", zzclt), "Share via"));
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzko.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */