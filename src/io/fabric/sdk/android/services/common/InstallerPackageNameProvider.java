package io.fabric.sdk.android.services.common;

import android.content.Context;
import android.content.pm.PackageManager;
import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.Logger;
import io.fabric.sdk.android.services.cache.MemoryValueCache;
import io.fabric.sdk.android.services.cache.ValueLoader;

public class InstallerPackageNameProvider
{
  private final MemoryValueCache<String> installerPackageNameCache = new MemoryValueCache();
  private final ValueLoader<String> installerPackageNameLoader = new ValueLoader()
  {
    public String load(Context paramAnonymousContext)
      throws Exception
    {
      String str = paramAnonymousContext.getPackageManager().getInstallerPackageName(paramAnonymousContext.getPackageName());
      paramAnonymousContext = str;
      if (str == null) {
        paramAnonymousContext = "";
      }
      return paramAnonymousContext;
    }
  };
  
  public String getInstallerPackageName(Context paramContext)
  {
    try
    {
      paramContext = (String)installerPackageNameCache.get(paramContext, installerPackageNameLoader);
      boolean bool = "".equals(paramContext);
      if (bool) {
        paramContext = null;
      }
      return paramContext;
    }
    catch (Exception paramContext)
    {
      Fabric.getLogger().e("Fabric", "Failed to determine installer package name", paramContext);
    }
    return null;
  }
}

/* Location:
 * Qualified Name:     io.fabric.sdk.android.services.common.InstallerPackageNameProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */