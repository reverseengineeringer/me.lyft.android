package bo.app;

import com.appboy.AppboyUser;
import com.appboy.Constants;
import com.appboy.IAppboy;
import com.appboy.enums.Gender;
import com.appboy.enums.Month;
import com.appboy.models.outgoing.AppboyProperties;
import com.appboy.support.AppboyLogger;
import com.google.android.gms.wearable.DataMap;
import java.math.BigDecimal;
import org.json.JSONException;
import org.json.JSONObject;

public class fq
{
  private static final String a = String.format("%s.%s", new Object[] { Constants.APPBOY_LOG_TAG_PREFIX, fq.class.getName() });
  
  public static dm a(DataMap paramDataMap)
  {
    dm localdm = null;
    if (b(paramDataMap) == am.w) {}
    try
    {
      localdm = dm.a(new JSONObject(paramDataMap.getString("v0")));
      return localdm;
    }
    catch (JSONException paramDataMap)
    {
      AppboyLogger.e(a, "Wear device couldn't be recreated.", paramDataMap);
    }
    return null;
  }
  
  private static AppboyProperties a(String paramString)
  {
    try
    {
      AppboyProperties localAppboyProperties = new AppboyProperties(new JSONObject(paramString));
      return localAppboyProperties;
    }
    catch (JSONException localJSONException)
    {
      AppboyLogger.e(a, "Failed to create properties object from string: " + paramString, localJSONException);
    }
    return null;
  }
  
  public static boolean a(DataMap paramDataMap, IAppboy paramIAppboy)
  {
    Object localObject2 = b(paramDataMap);
    boolean bool = paramDataMap.getBoolean("h");
    if (bool) {}
    for (Object localObject1 = a(paramDataMap.getString("p"));; localObject1 = null)
    {
      int i;
      double d1;
      double d2;
      switch (fr.a[localObject2.ordinal()])
      {
      default: 
        AppboyLogger.i(a, "No current implementation for action in DataMap: " + paramDataMap.toString());
        return false;
      case 1: 
        paramDataMap = paramDataMap.getString("v0");
        if ((bool) && (localObject1 != null)) {
          return paramIAppboy.logCustomEvent(paramDataMap, (AppboyProperties)localObject1);
        }
        return paramIAppboy.logCustomEvent(paramDataMap);
      case 2: 
        localObject2 = paramDataMap.getString("v0");
        String str = paramDataMap.getString("v1");
        paramDataMap = new BigDecimal(paramDataMap.getString("v2"));
        if ((bool) && (localObject1 != null)) {
          return paramIAppboy.logPurchase((String)localObject2, str, paramDataMap, (AppboyProperties)localObject1);
        }
        return paramIAppboy.logPurchase((String)localObject2, str, paramDataMap);
      case 3: 
        return paramIAppboy.logPushNotificationOpened(paramDataMap.getString("v0"));
      case 4: 
        return paramIAppboy.submitFeedback(paramDataMap.getString("v0"), paramDataMap.getString("v1"), paramDataMap.getBoolean("v2"));
      case 5: 
        localObject1 = paramDataMap.getString("k");
        paramDataMap = paramDataMap.getString("v0");
        return paramIAppboy.getCurrentUser().addToCustomAttributeArray((String)localObject1, paramDataMap);
      case 6: 
        localObject1 = paramDataMap.getString("k");
        i = paramDataMap.getInt("v0");
        return paramIAppboy.getCurrentUser().incrementCustomUserAttribute((String)localObject1, i);
      case 7: 
        localObject1 = paramDataMap.getString("k");
        paramDataMap = paramDataMap.getStringArray("v0");
        return paramIAppboy.getCurrentUser().setCustomAttributeArray((String)localObject1, paramDataMap);
      case 8: 
        localObject1 = paramDataMap.getString("k");
        i = paramDataMap.getInt("v1");
        if (i == 1) {
          return paramIAppboy.getCurrentUser().setCustomUserAttribute((String)localObject1, paramDataMap.getBoolean("v0"));
        }
        if (i == 3) {
          return paramIAppboy.getCurrentUser().setCustomUserAttribute((String)localObject1, paramDataMap.getFloat("v0"));
        }
        if (i == 4) {
          return paramIAppboy.getCurrentUser().setCustomUserAttribute((String)localObject1, paramDataMap.getInt("v0"));
        }
        if (i == 5) {
          return paramIAppboy.getCurrentUser().setCustomUserAttribute((String)localObject1, paramDataMap.getLong("v0"));
        }
        if (i == 2) {
          return paramIAppboy.getCurrentUser().setCustomUserAttribute((String)localObject1, paramDataMap.getString("v0"));
        }
        break;
      case 9: 
        paramDataMap = paramDataMap.getString("k");
        return paramIAppboy.getCurrentUser().setCustomUserAttributeToNow(paramDataMap);
      case 10: 
        paramDataMap = paramDataMap.getString("k");
        return paramIAppboy.getCurrentUser().unsetCustomUserAttribute(paramDataMap);
      case 11: 
        localObject1 = paramDataMap.getString("k");
        long l = paramDataMap.getLong("v0");
        return paramIAppboy.getCurrentUser().setCustomUserAttributeToSecondsFromEpoch((String)localObject1, l);
      case 12: 
        d1 = paramDataMap.getDouble("v0");
        d2 = paramDataMap.getDouble("v1");
        if (!paramDataMap.containsKey("v2")) {}
        break;
      }
      for (localObject1 = Double.valueOf(paramDataMap.getDouble("v2"));; localObject1 = null)
      {
        if (paramDataMap.containsKey("v3")) {}
        for (paramDataMap = Double.valueOf(paramDataMap.getDouble("v3"));; paramDataMap = null)
        {
          paramIAppboy.getCurrentUser().setLastKnownLocation(d1, d2, paramDataMap, (Double)localObject1);
          return true;
          return paramIAppboy.getCurrentUser().setAvatarImageUrl(paramDataMap.getString("v0"));
          return paramIAppboy.getCurrentUser().setCountry(paramDataMap.getString("v0"));
          return paramIAppboy.getCurrentUser().setEmail(paramDataMap.getString("v0"));
          return paramIAppboy.getCurrentUser().setFirstName(paramDataMap.getString("v0"));
          return paramIAppboy.getCurrentUser().setHomeCity(paramDataMap.getString("v0"));
          return paramIAppboy.getCurrentUser().setLastName(paramDataMap.getString("v0"));
          return paramIAppboy.getCurrentUser().setPhoneNumber(paramDataMap.getString("v0"));
          paramDataMap = Gender.valueOf(paramDataMap.getString("v0"));
          return paramIAppboy.getCurrentUser().setGender(paramDataMap);
          i = paramDataMap.getInt("v0");
          localObject1 = Month.valueOf(paramDataMap.getString("v1"));
          int j = paramDataMap.getInt("v2");
          return paramIAppboy.getCurrentUser().setDateOfBirth(i, (Month)localObject1, j);
          AppboyLogger.i(a, "Got an unsupported wearable sdk action. DataMap: " + paramDataMap.toString());
          return false;
          return false;
        }
      }
    }
  }
  
  public static am b(DataMap paramDataMap)
  {
    return am.a(paramDataMap.getString("t"));
  }
}

/* Location:
 * Qualified Name:     bo.app.fq
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */