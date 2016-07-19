package io.fabric.sdk.android.services.common;

import android.content.Context;
import android.content.pm.PackageManager;
import io.fabric.sdk.android.services.cache.ValueLoader;

class InstallerPackageNameProvider$1
  implements ValueLoader<String>
{
  InstallerPackageNameProvider$1(InstallerPackageNameProvider paramInstallerPackageNameProvider) {}
  
  public String load(Context paramContext)
    throws Exception
  {
    String str = paramContext.getPackageManager().getInstallerPackageName(paramContext.getPackageName());
    paramContext = str;
    if (str == null) {
      paramContext = "";
    }
    return paramContext;
  }
}

/* Location:
 * Qualified Name:     io.fabric.sdk.android.services.common.InstallerPackageNameProvider.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */