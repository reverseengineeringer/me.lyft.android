package com.google.android.gms.internal;

import android.app.DownloadManager;
import android.app.DownloadManager.Request;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.os.Environment;
import android.text.TextUtils;
import com.google.android.gms.common.util.zzh;
import com.google.android.gms.common.util.zzs;
import java.io.File;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@zzir
public class zzdt
{
  private static final Object zzamp = new Object();
  private static AtomicInteger zzbeu = new AtomicInteger();
  private static zzdt zzbev;
  
  public static zzdt zzkq()
  {
    synchronized (zzamp)
    {
      if (zzbev == null) {
        zzbev = new zzdt();
      }
      zzdt localzzdt = zzbev;
      return localzzdt;
    }
  }
  
  protected DownloadManager.Request zza(Context paramContext, DownloadManager.Request paramRequest, String paramString)
  {
    String str1 = String.valueOf(Environment.getExternalStorageDirectory().toString());
    String str2 = String.valueOf("/directappinstall/");
    if (str2.length() != 0) {}
    for (str1 = str1.concat(str2);; str1 = new String(str1))
    {
      paramRequest.setDestinationInExternalFilesDir(paramContext, str1, paramString).setVisibleInDownloadsUi(true).setAllowedNetworkTypes(3);
      if (!zzs.zzavj()) {
        break;
      }
      return paramRequest.setNotificationVisibility(1);
    }
    return paramRequest.setShowRunningNotification(true);
  }
  
  public void zza(Context paramContext, Map<String, String> paramMap)
  {
    Object localObject = (String)paramMap.get("url");
    String str = (String)paramMap.get("package_name");
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      zzkh.e("Download URL provided by creative is null or empty.");
      return;
    }
    try
    {
      DownloadManager.Request localRequest = zza(paramContext, new DownloadManager.Request(Uri.parse((String)localObject)), str);
      paramMap = (String)paramMap.get("tracking_url");
      zzkh.zzcw(String.valueOf(str).length() + 32 + String.valueOf(localObject).length() + "Start downloading package " + str + " from " + (String)localObject);
      localObject = (DownloadManager)paramContext.getSystemService("download");
      zzds.zza(paramContext, zzh.zzavi()).zza(((DownloadManager)localObject).enqueue(localRequest), str, paramMap);
      return;
    }
    catch (IllegalArgumentException paramContext)
    {
      zzkh.zzb("Download URL is not a valid HTTP/HTTPS URI. Abort downloading task.", paramContext);
    }
  }
  
  public String zzb(Context paramContext, Map<String, String> paramMap)
  {
    String str = (String)paramMap.get("package_name");
    paramContext = paramContext.getPackageManager();
    try
    {
      paramContext = paramContext.getPackageInfo(str, 1);
      paramMap = (String)paramMap.get("app_version");
      if (TextUtils.isEmpty(paramMap))
      {
        zzkh.e("No app version provided by creative.");
        return "installed_unknown_version";
      }
      try
      {
        int i = Integer.parseInt(paramMap);
        if (i > versionCode)
        {
          zzkh.zzcw(String.valueOf(str).length() + 34 + "App " + str + " installed but need an update.");
          return "installed_older_version";
        }
      }
      catch (NumberFormatException paramContext)
      {
        zzkh.e("Malformated app version is provided by creative.");
        return "installed_unknown_version";
      }
      zzkh.zzcw(String.valueOf(str).length() + 52 + "App " + str + " already installed with current / newer version.");
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      zzkh.zzcw(String.valueOf(str).length() + 19 + "App " + str + " not installed.");
      return "not_installed";
    }
    return "installed_given_version";
  }
  
  public void zzd(Context paramContext, String paramString)
  {
    Object localObject = String.valueOf(paramString);
    if (((String)localObject).length() != 0)
    {
      localObject = "Deleting downloaded file: ".concat((String)localObject);
      zzkh.zzcw((String)localObject);
      localObject = new File(paramString);
      if (!((File)localObject).exists()) {
        break label152;
      }
      ((File)localObject).delete();
      if (((File)localObject).exists()) {
        break label113;
      }
      localObject = String.valueOf(paramString);
      if (((String)localObject).length() == 0) {
        break label100;
      }
      localObject = "File deleted successfully from path: ".concat((String)localObject);
      label70:
      zzkh.zzcw((String)localObject);
    }
    for (;;)
    {
      zzds.zza(paramContext, zzh.zzavi()).zzat(paramString);
      return;
      localObject = new String("Deleting downloaded file: ");
      break;
      label100:
      localObject = new String("File deleted successfully from path: ");
      break label70;
      label113:
      localObject = String.valueOf(paramString);
      if (((String)localObject).length() != 0) {}
      for (localObject = "Error deleting file: ".concat((String)localObject);; localObject = new String("Error deleting file: "))
      {
        zzkh.zzcw((String)localObject);
        break;
      }
      label152:
      zzkh.zzcw(String.valueOf(paramString).length() + 21 + "File: " + paramString + " doesn't exist!");
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzdt
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */