package bo.app;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.appboy.Constants;
import com.appboy.configuration.XmlAppConfigurationProvider;
import com.appboy.models.outgoing.Environment;
import com.appboy.support.AppboyLogger;
import com.appboy.support.StringUtils;
import java.util.Locale;
import java.util.TimeZone;

public final class ce
  implements cj
{
  private static final String b = String.format("%s.%s", new Object[] { Constants.APPBOY_LOG_TAG_PREFIX, ce.class.getName() });
  private static boolean l = false;
  final SharedPreferences a;
  private final Context c;
  private final ck d;
  private final cm e;
  private final Environment f;
  private final ev g;
  private final fb h;
  private final ci<dm> i;
  private final bd j;
  private String k;
  
  public ce(Context paramContext, XmlAppConfigurationProvider paramXmlAppConfigurationProvider, String paramString, ck paramck, cm paramcm, ev paramev, fb paramfb, ci<dm> paramci, bd parambd)
  {
    if (paramContext == null) {
      throw new NullPointerException();
    }
    c = paramContext;
    d = paramck;
    e = paramcm;
    g = paramev;
    h = paramfb;
    paramck = c.getPackageName();
    paramcm = a(paramck);
    f = new Environment("1.13.4", versionCode, versionName, paramck, paramfb);
    i = paramci;
    j = parambd;
    a = paramContext.getSharedPreferences("com.appboy.storage.device_ad_info" + StringUtils.getCacheFileSuffix(paramString, paramXmlAppConfigurationProvider.getAppboyApiKey().toString()), 0);
    if ((h != null) && (h.a())) {
      new Thread(new cf(this)).start();
    }
  }
  
  private PackageInfo a(String paramString)
  {
    localObject1 = null;
    try
    {
      localObject2 = c.getPackageManager().getPackageInfo(paramString, 0);
      paramString = (String)localObject2;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      for (;;)
      {
        Object localObject2;
        AppboyLogger.e(b, String.format("Unable to inspect package [%s]", new Object[] { paramString }), localNameNotFoundException);
        paramString = (String)localObject1;
      }
    }
    localObject2 = c.getApplicationInfo();
    localObject1 = paramString;
    if (paramString == null) {
      localObject1 = c.getPackageManager().getPackageArchiveInfo(sourceDir, 0);
    }
    return (PackageInfo)localObject1;
  }
  
  public static boolean a()
  {
    return l;
  }
  
  public final de b()
  {
    Object localObject2 = Locale.getDefault();
    String str1 = null;
    if (e != null) {
      str1 = e.a();
    }
    int m = Build.VERSION.SDK_INT;
    String str2 = Build.CPU_ABI;
    Object localObject1 = (TelephonyManager)c.getSystemService("phone");
    switch (((TelephonyManager)localObject1).getPhoneType())
    {
    default: 
      AppboyLogger.w(b, "Unknown phone type");
      localObject1 = null;
    }
    for (;;)
    {
      String str3 = Build.MODEL;
      String str4 = ((Locale)localObject2).getLanguage();
      localObject2 = ((Locale)localObject2).getCountry();
      String str5 = TimeZone.getDefault().getID();
      DisplayMetrics localDisplayMetrics = new DisplayMetrics();
      ((WindowManager)c.getSystemService("window")).getDefaultDisplay().getMetrics(localDisplayMetrics);
      return new de(Integer.valueOf(m), str2, (String)localObject1, str3, str4, (String)localObject2, str5, new di(widthPixels, heightPixels, xdpi, ydpi, densityDpi), d.a(), str1, i.a());
      localObject1 = null;
      continue;
      localObject1 = ((TelephonyManager)localObject1).getNetworkOperatorName();
    }
  }
  
  public final de c()
  {
    g.b = b();
    return (de)g.b();
  }
  
  public final Environment d()
  {
    return f;
  }
  
  public final String e()
  {
    String str = d.b();
    if (str == null) {
      AppboyLogger.e(b, "Error reading deviceId, received a null value.");
    }
    return str;
  }
  
  public final String f()
  {
    if (k == null) {
      k = a.getString("a", null);
    }
    return k;
  }
}

/* Location:
 * Qualified Name:     bo.app.ce
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */