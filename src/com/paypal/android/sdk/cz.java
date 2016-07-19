package com.paypal.android.sdk;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public final class cz
{
  private Context a;
  
  public cz(Context paramContext)
  {
    a = paramContext;
  }
  
  public final void a(Collection paramCollection)
  {
    try
    {
      paramCollection = new HashSet(paramCollection);
      ActivityInfo[] arrayOfActivityInfo = a.getPackageManager().getPackageInfo(a.getPackageName(), 1).activities;
      if (arrayOfActivityInfo != null)
      {
        int j = arrayOfActivityInfo.length;
        int i = 0;
        while (i < j)
        {
          paramCollection.remove(name);
          i += 1;
        }
      }
      if (!paramCollection.isEmpty()) {
        throw new RuntimeException("Missing required activities in manifest:" + paramCollection);
      }
    }
    catch (PackageManager.NameNotFoundException paramCollection)
    {
      throw new RuntimeException("Exception loading manifest" + paramCollection.getMessage());
    }
  }
}

/* Location:
 * Qualified Name:     com.paypal.android.sdk.cz
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */