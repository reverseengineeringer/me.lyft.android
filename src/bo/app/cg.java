package bo.app;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;
import com.appboy.Constants;
import com.appboy.configuration.XmlAppConfigurationProvider;
import com.appboy.support.AppboyLogger;
import com.appboy.support.PermissionUtils;

public class cg
{
  public static final String a = String.format("%s.%s", new Object[] { Constants.APPBOY_LOG_TAG_PREFIX, cg.class.getName() });
  public final Context b;
  public final cm c;
  
  public cg(Context paramContext, cm paramcm)
  {
    b = paramContext;
    c = paramcm;
  }
  
  private static boolean a(Context paramContext)
  {
    try
    {
      paramContext.getPackageManager().getPackageInfo("com.google.android.gsf", 0);
      return true;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      AppboyLogger.e(a, "GCM requires the Google Play store installed.");
      return false;
    }
    catch (Exception paramContext)
    {
      AppboyLogger.e(a, String.format("Unexpected exception while checking for %s.", new Object[] { "com.google.android.gsf" }));
    }
    return false;
  }
  
  public static boolean a(Context paramContext, XmlAppConfigurationProvider paramXmlAppConfigurationProvider)
  {
    return (a(paramContext)) && (b(paramContext, paramXmlAppConfigurationProvider));
  }
  
  private static boolean b(Context paramContext, XmlAppConfigurationProvider paramXmlAppConfigurationProvider)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject = paramContext.getPackageManager();
    String str = paramContext.getPackageName();
    str = str + ".permission.C2D_MESSAGE";
    try
    {
      ((PackageManager)localObject).getPermissionInfo(str, 4096);
      if (!PermissionUtils.hasPermission(paramContext, "android.permission.INTERNET"))
      {
        localStringBuilder.append(String.format("Missing permission. The %s permission must be set so that the Android application can send the registration ID to the 3rd party server.", new Object[] { "android.permission.INTERNET" }));
        if (!PermissionUtils.hasPermission(paramContext, "android.permission.GET_ACCOUNTS"))
        {
          if (Build.VERSION.SDK_INT < 16) {
            break label318;
          }
          AppboyLogger.i(a, String.format("Missing permission. The %s permission is recommended to be set so that pre-Jelly Bean Android devices can register with the GCM server.", new Object[] { "android.permission.GET_ACCOUNTS" }));
        }
        if (!PermissionUtils.hasPermission(paramContext, "android.permission.WAKE_LOCK")) {
          AppboyLogger.i(a, String.format("Missing permission. The %s permission is recommended be set so that the GCM receiver can notify users by waking the phone when a message is received.", new Object[] { "android.permission.WAKE_LOCK" }));
        }
        paramContext = new ComponentName(paramContext, "com.appboy.AppboyGcmReceiver");
      }
      try
      {
        localObject = ((PackageManager)localObject).getReceiverInfo(paramContext, 2);
        if ((localObject == null) || (!enabled)) {
          localStringBuilder.append(String.format("The %s broadcast receiver is either not found or is disabled", new Object[] { paramContext.getClassName() }));
        }
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException1)
      {
        for (;;)
        {
          localStringBuilder.append(String.format("No %s broadcast receiver is registered in the manifest.", new Object[] { paramContext.getClassName() }));
        }
        AppboyLogger.e(a, localStringBuilder.toString());
      }
      if (paramXmlAppConfigurationProvider.getGcmSenderId() == null) {
        localStringBuilder.append(String.format("Cannot find the Google Cloud Messaging sender ID attribute %s in res/values/appboy.xml.", new Object[] { "com.appboy.GCM_SENDER_ID" }));
      }
      if (localStringBuilder.length() == 0) {
        return true;
      }
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException2)
    {
      for (;;)
      {
        localStringBuilder.append(String.format("The manifest does not define the %s permission.", new Object[] { str }));
        continue;
        if (!PermissionUtils.hasPermission(paramContext, "com.google.android.c2dm.permission.RECEIVE"))
        {
          localStringBuilder.append(String.format("Missing permission. The %s permission must be set so that the Android application can register and receive messages.", new Object[] { "com.google.android.c2dm.permission.RECEIVE" }));
        }
        else if (!PermissionUtils.hasPermission(paramContext, str))
        {
          localStringBuilder.append(String.format("Missing permission. The %s permission must be set so that ONLY this Android application can register and receive GCM messages.", new Object[] { str }));
          continue;
          label318:
          localStringBuilder.append(String.format("Missing permission. The %s permission must be set so that this pre-Jelly Bean Android device can register with the GCM server.", new Object[] { "android.permission.GET_ACCOUNTS" }));
        }
      }
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     bo.app.cg
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */