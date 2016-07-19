package com.google.android.gms.ads.internal.overlay;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.internal.zzir;
import com.google.android.gms.internal.zzkh;
import com.google.android.gms.internal.zzkl;

@zzir
public class zza
{
  public boolean zza(Context paramContext, Intent paramIntent, zzp paramzzp)
  {
    try
    {
      String str = String.valueOf(paramIntent.toURI());
      if (str.length() != 0) {}
      for (str = "Launching an intent: ".concat(str);; str = new String("Launching an intent: "))
      {
        zzkh.v(str);
        zzu.zzfq().zzb(paramContext, paramIntent);
        if (paramzzp == null) {
          break;
        }
        paramzzp.zzdp();
        break;
      }
      return true;
    }
    catch (ActivityNotFoundException paramContext)
    {
      zzkh.zzcy(paramContext.getMessage());
      return false;
    }
  }
  
  public boolean zza(Context paramContext, AdLauncherIntentInfoParcel paramAdLauncherIntentInfoParcel, zzp paramzzp)
  {
    if (paramAdLauncherIntentInfoParcel == null)
    {
      zzkh.zzcy("No intent data for launcher overlay.");
      return false;
    }
    if (intent != null) {
      return zza(paramContext, intent, paramzzp);
    }
    Intent localIntent = new Intent();
    if (TextUtils.isEmpty(url))
    {
      zzkh.zzcy("Open GMSG did not contain a URL.");
      return false;
    }
    String[] arrayOfString;
    if (!TextUtils.isEmpty(mimeType))
    {
      localIntent.setDataAndType(Uri.parse(url), mimeType);
      localIntent.setAction("android.intent.action.VIEW");
      if (!TextUtils.isEmpty(packageName)) {
        localIntent.setPackage(packageName);
      }
      if (TextUtils.isEmpty(zzbrs)) {
        break label210;
      }
      arrayOfString = zzbrs.split("/", 2);
      if (arrayOfString.length >= 2) {
        break label196;
      }
      paramContext = String.valueOf(zzbrs);
      if (paramContext.length() == 0) {
        break label183;
      }
    }
    label183:
    for (paramContext = "Could not parse component name from open GMSG: ".concat(paramContext);; paramContext = new String("Could not parse component name from open GMSG: "))
    {
      zzkh.zzcy(paramContext);
      return false;
      localIntent.setData(Uri.parse(url));
      break;
    }
    label196:
    localIntent.setClassName(arrayOfString[0], arrayOfString[1]);
    label210:
    paramAdLauncherIntentInfoParcel = zzbrt;
    if (!TextUtils.isEmpty(paramAdLauncherIntentInfoParcel)) {}
    try
    {
      i = Integer.parseInt(paramAdLauncherIntentInfoParcel);
      localIntent.addFlags(i);
      return zza(paramContext, localIntent, paramzzp);
    }
    catch (NumberFormatException paramAdLauncherIntentInfoParcel)
    {
      for (;;)
      {
        zzkh.zzcy("Could not parse intent flags.");
        int i = 0;
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.overlay.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */