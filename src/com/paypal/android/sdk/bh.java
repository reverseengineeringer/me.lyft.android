package com.paypal.android.sdk;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.util.Log;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class bH
{
  private static Map a;
  
  static
  {
    bH.class.getSimpleName();
  }
  
  private static String a(Context paramContext)
  {
    try
    {
      paramContext = getPackageManagergetPackageInfogetPackageName128versionName;
      return paramContext;
    }
    catch (PackageManager.NameNotFoundException paramContext) {}
    return "unknown versionName";
  }
  
  public static JSONObject a()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      Iterator localIterator = a.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localJSONObject.put(str, a.get(str));
      }
      return localJSONException;
    }
    catch (JSONException localJSONException)
    {
      Log.e("paypal.sdk", "Error encoding JSON", localJSONException);
      return null;
    }
  }
  
  public static void a(b paramb)
  {
    HashMap localHashMap = new HashMap();
    a = localHashMap;
    localHashMap.put("app_version", a(paramb.f()));
    a.put("app_category", "1");
    if (paramb.b() == 1) {
      a.put("client_platform", "AndroidGSM");
    }
    for (;;)
    {
      a.put("device_app_id", paramb.c());
      return;
      if (paramb.b() == 2) {
        a.put("client_platform", "AndroidCDMA");
      } else {
        a.put("client_platform", "AndroidOther");
      }
    }
  }
  
  public static String b()
  {
    return (String)a.get("device_app_id");
  }
}

/* Location:
 * Qualified Name:     com.paypal.android.sdk.bH
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */