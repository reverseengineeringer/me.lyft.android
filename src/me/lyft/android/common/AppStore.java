package me.lyft.android.common;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;

public class AppStore
  implements IAppStore
{
  private static final String GALAXY_APPS_PACKAGE = "com.sec.android.app.samsungapps";
  private static final String PLAY_STORE_URL = "market://details?id=me.lyft.android";
  private static final String SAMSUNG_STORE_URL = "http://www.samsungapps.com/appquery/appDetail.as?appId=me.lyft.android&hl=en";
  private Context context;
  
  public AppStore(Context paramContext)
  {
    context = paramContext;
  }
  
  private String getInstallerPackage()
  {
    return context.getPackageManager().getInstallerPackageName("me.lyft.android");
  }
  
  public String getAppStoreSource()
  {
    if (wasInstalledFromSamsungStore()) {
      return "samsung";
    }
    return "google";
  }
  
  public void openInstallingStore()
  {
    String str = "market://details?id=me.lyft.android";
    if (wasInstalledFromSamsungStore()) {
      str = "http://www.samsungapps.com/appquery/appDetail.as?appId=me.lyft.android&hl=en";
    }
    Intent localIntent = new Intent("android.intent.action.VIEW");
    localIntent.setData(Uri.parse(str));
    localIntent.addFlags(268435456);
    context.startActivity(localIntent);
  }
  
  public boolean wasInstalledFromSamsungStore()
  {
    return "com.sec.android.app.samsungapps".equalsIgnoreCase(getInstallerPackage());
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.common.AppStore
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */