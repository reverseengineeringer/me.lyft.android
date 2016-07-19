package bo.app;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.appboy.Constants;
import com.appboy.enums.Month;
import com.appboy.models.outgoing.AttributionData;
import com.appboy.models.outgoing.FacebookUser;
import com.appboy.models.outgoing.TwitterUser;
import com.appboy.support.AppboyLogger;
import com.appboy.support.StringUtils;
import com.appboy.support.ValidationUtils;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class fd
  extends en<dl>
{
  private static final String a = String.format("%s.%s", new Object[] { Constants.APPBOY_LOG_TAG_PREFIX, fd.class.getName() });
  private static final Set<String> b = new HashSet(Arrays.asList(new String[] { "twitter", "facebook", "ab_install_attribution" }));
  private final SharedPreferences c;
  private final fb d;
  
  public fd(Context paramContext, fb paramfb)
  {
    this(paramContext, null, null, paramfb);
  }
  
  public fd(Context paramContext, String paramString1, String paramString2, fb paramfb)
  {
    c = paramContext.getSharedPreferences("com.appboy.storage.usercache" + StringUtils.getCacheFileSuffix(paramString1, paramString2), 0);
    d = paramfb;
  }
  
  private void a(JSONObject paramJSONObject, String paramString)
  {
    SharedPreferences.Editor localEditor2 = null;
    Object localObject = localEditor2;
    if (c.contains(paramString)) {}
    try
    {
      localObject = new JSONObject(c.getString(paramString, ""));
      localEditor2 = c.edit();
      if ((localObject != null) && (((JSONObject)localObject).length() > 0))
      {
        Iterator localIterator = paramJSONObject.keys();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          try
          {
            ((JSONObject)localObject).put(str, paramJSONObject.get(str));
          }
          catch (JSONException localJSONException2)
          {
            AppboyLogger.w(a, String.format("Failed to fetch value for key [%s], ignoring.", new Object[] { str }));
          }
        }
      }
    }
    catch (JSONException localJSONException1)
    {
      SharedPreferences.Editor localEditor1;
      for (;;)
      {
        AppboyLogger.w(a, String.format("Failed to parse existing value for [%s], continuing without it.", new Object[] { paramString }), localJSONException1);
        localEditor1 = localEditor2;
      }
      localEditor2.putString(paramString, localEditor1.toString());
    }
    for (;;)
    {
      localEditor2.apply();
      return;
      localEditor2.putString(paramString, paramJSONObject.toString());
    }
  }
  
  private dl c()
  {
    JSONObject localJSONObject = new JSONObject(c.getAll());
    Iterator localIterator = localJSONObject.keys();
    String str;
    while (localIterator.hasNext())
    {
      str = (String)localIterator.next();
      try
      {
        if (localJSONObject.get(str).equals("appboy_null_5a8579f5-079b-4681-a046-0f3c46a4ef58")) {
          localJSONObject.put(str, JSONObject.NULL);
        }
        if ((str.equals("piqid")) && (ce.a())) {
          localJSONObject.put("piqid_changed", true);
        }
      }
      catch (JSONException localJSONException1)
      {
        AppboyLogger.w(a, String.format("Failed to check outbound json key %s for null placeholders.", new Object[] { str }));
      }
    }
    localIterator = b.iterator();
    while (localIterator.hasNext())
    {
      str = (String)localIterator.next();
      try
      {
        if (c.contains(str)) {
          localJSONObject.put(str, new JSONObject(c.getString(str, "")));
        }
      }
      catch (JSONException localJSONException2)
      {
        AppboyLogger.w(a, String.format("Failed to properly convert [%s] value to OutboundUser for export.", new Object[] { str }));
      }
    }
    return new dl(localJSONObject);
  }
  
  /* Error */
  public final void a(com.appboy.enums.Gender paramGender)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 94	bo/app/fd:c	Landroid/content/SharedPreferences;
    //   6: invokeinterface 117 1 0
    //   11: astore_2
    //   12: aload_1
    //   13: ifnonnull +22 -> 35
    //   16: aload_2
    //   17: ldc -41
    //   19: aconst_null
    //   20: invokeinterface 163 3 0
    //   25: pop
    //   26: aload_2
    //   27: invokeinterface 166 1 0
    //   32: aload_0
    //   33: monitorexit
    //   34: return
    //   35: aload_2
    //   36: ldc -41
    //   38: aload_1
    //   39: invokevirtual 220	com/appboy/enums/Gender:forJsonPut	()Ljava/lang/String;
    //   42: invokeinterface 163 3 0
    //   47: pop
    //   48: goto -22 -> 26
    //   51: astore_1
    //   52: aload_0
    //   53: monitorexit
    //   54: aload_1
    //   55: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	56	0	this	fd
    //   0	56	1	paramGender	com.appboy.enums.Gender
    //   11	25	2	localEditor	SharedPreferences.Editor
    // Exception table:
    //   from	to	target	type
    //   2	12	51	finally
    //   16	26	51	finally
    //   26	32	51	finally
    //   35	48	51	finally
  }
  
  /* Error */
  public final void a(com.appboy.enums.NotificationSubscriptionType paramNotificationSubscriptionType)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 94	bo/app/fd:c	Landroid/content/SharedPreferences;
    //   6: invokeinterface 117 1 0
    //   11: astore_2
    //   12: aload_1
    //   13: ifnonnull +22 -> 35
    //   16: aload_2
    //   17: ldc -33
    //   19: aconst_null
    //   20: invokeinterface 163 3 0
    //   25: pop
    //   26: aload_2
    //   27: invokeinterface 166 1 0
    //   32: aload_0
    //   33: monitorexit
    //   34: return
    //   35: aload_2
    //   36: ldc -33
    //   38: aload_1
    //   39: invokevirtual 226	com/appboy/enums/NotificationSubscriptionType:forJsonPut	()Ljava/lang/String;
    //   42: invokeinterface 163 3 0
    //   47: pop
    //   48: goto -22 -> 26
    //   51: astore_1
    //   52: aload_0
    //   53: monitorexit
    //   54: aload_1
    //   55: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	56	0	this	fd
    //   0	56	1	paramNotificationSubscriptionType	com.appboy.enums.NotificationSubscriptionType
    //   11	25	2	localEditor	SharedPreferences.Editor
    // Exception table:
    //   from	to	target	type
    //   2	12	51	finally
    //   16	26	51	finally
    //   26	32	51	finally
    //   35	48	51	finally
  }
  
  public final void a(AttributionData paramAttributionData)
  {
    try
    {
      a(paramAttributionData.forJsonPut(), "ab_install_attribution");
      return;
    }
    finally
    {
      paramAttributionData = finally;
      throw paramAttributionData;
    }
  }
  
  public final void a(FacebookUser paramFacebookUser)
  {
    try
    {
      a(paramFacebookUser.forJsonPut(), "facebook");
      return;
    }
    finally
    {
      paramFacebookUser = finally;
      throw paramFacebookUser;
    }
  }
  
  public final void a(TwitterUser paramTwitterUser)
  {
    try
    {
      a(paramTwitterUser.forJsonPut(), "twitter");
      return;
    }
    finally
    {
      paramTwitterUser = finally;
      throw paramTwitterUser;
    }
  }
  
  public final void a(String paramString)
  {
    try
    {
      SharedPreferences.Editor localEditor = c.edit();
      localEditor.putString("first_name", paramString);
      localEditor.apply();
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public final boolean a(int paramInt1, Month paramMonth, int paramInt2)
  {
    if (paramMonth == null) {}
    for (;;)
    {
      try
      {
        AppboyLogger.w(a, "Month cannot be null.");
        bool = false;
        return bool;
      }
      finally {}
      paramMonth = fg.a(fg.a(paramInt1, paramMonth.getValue(), paramInt2), aa.a);
      SharedPreferences.Editor localEditor = c.edit();
      localEditor.putString("dob", paramMonth);
      localEditor.apply();
      boolean bool = true;
    }
  }
  
  public final boolean a(String paramString, long paramLong)
  {
    try
    {
      boolean bool = a(paramString, fg.a(paramLong));
      return bool;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public final boolean a(String paramString, Object paramObject)
  {
    boolean bool2 = false;
    for (;;)
    {
      try
      {
        bool1 = ValidationUtils.isBlacklistedCustomAttributeKey(paramString, d.h());
        if (bool1)
        {
          bool1 = bool2;
          return bool1;
        }
        bool1 = bool2;
        if (!ValidationUtils.isValidCustomAttributeKey(paramString)) {
          continue;
        }
        paramString = ValidationUtils.ensureAppboyFieldLength(paramString);
        if (paramObject == null)
        {
          AppboyLogger.w(a, "Custom attribute value cannot be null.");
          bool1 = bool2;
          continue;
        }
        localEditor = c.edit();
      }
      finally {}
      SharedPreferences.Editor localEditor;
      if ((paramObject instanceof Boolean)) {
        localEditor.putBoolean(paramString, ((Boolean)paramObject).booleanValue());
      }
      for (;;)
      {
        localEditor.apply();
        bool1 = true;
        break;
        if ((paramObject instanceof Integer))
        {
          localEditor.putInt(paramString, ((Integer)paramObject).intValue());
        }
        else if ((paramObject instanceof Float))
        {
          localEditor.putFloat(paramString, ((Float)paramObject).floatValue());
        }
        else if ((paramObject instanceof Long))
        {
          localEditor.putLong(paramString, ((Long)paramObject).longValue());
        }
        else if ((paramObject instanceof String))
        {
          localEditor.putString(paramString, ValidationUtils.ensureAppboyFieldLength((String)paramObject));
        }
        else
        {
          if (!(paramObject instanceof Date)) {
            break label247;
          }
          localEditor.putString(paramString, fg.a((Date)paramObject, aa.b));
        }
      }
      label247:
      AppboyLogger.w(a, "Unsupported custom attribute type");
      boolean bool1 = bool2;
    }
  }
  
  /* Error */
  public final void b(com.appboy.enums.NotificationSubscriptionType paramNotificationSubscriptionType)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 94	bo/app/fd:c	Landroid/content/SharedPreferences;
    //   6: invokeinterface 117 1 0
    //   11: astore_2
    //   12: aload_1
    //   13: ifnonnull +23 -> 36
    //   16: aload_2
    //   17: ldc_w 385
    //   20: aconst_null
    //   21: invokeinterface 163 3 0
    //   26: pop
    //   27: aload_2
    //   28: invokeinterface 166 1 0
    //   33: aload_0
    //   34: monitorexit
    //   35: return
    //   36: aload_2
    //   37: ldc_w 385
    //   40: aload_1
    //   41: invokevirtual 226	com/appboy/enums/NotificationSubscriptionType:forJsonPut	()Ljava/lang/String;
    //   44: invokeinterface 163 3 0
    //   49: pop
    //   50: goto -23 -> 27
    //   53: astore_1
    //   54: aload_0
    //   55: monitorexit
    //   56: aload_1
    //   57: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	58	0	this	fd
    //   0	58	1	paramNotificationSubscriptionType	com.appboy.enums.NotificationSubscriptionType
    //   11	26	2	localEditor	SharedPreferences.Editor
    // Exception table:
    //   from	to	target	type
    //   2	12	53	finally
    //   16	27	53	finally
    //   27	33	53	finally
    //   36	50	53	finally
  }
  
  public final void b(String paramString)
  {
    try
    {
      SharedPreferences.Editor localEditor = c.edit();
      localEditor.putString("last_name", paramString);
      localEditor.apply();
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  /* Error */
  public final boolean c(String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_1
    //   5: astore_3
    //   6: aload_1
    //   7: ifnull +8 -> 15
    //   10: aload_1
    //   11: invokevirtual 390	java/lang/String:trim	()Ljava/lang/String;
    //   14: astore_3
    //   15: aload_3
    //   16: ifnull +10 -> 26
    //   19: aload_3
    //   20: invokestatic 393	com/appboy/support/ValidationUtils:isValidEmailAddress	(Ljava/lang/String;)Z
    //   23: ifeq +36 -> 59
    //   26: aload_0
    //   27: getfield 94	bo/app/fd:c	Landroid/content/SharedPreferences;
    //   30: invokeinterface 117 1 0
    //   35: astore_1
    //   36: aload_1
    //   37: ldc_w 395
    //   40: aload_3
    //   41: invokeinterface 163 3 0
    //   46: pop
    //   47: aload_1
    //   48: invokeinterface 166 1 0
    //   53: iconst_1
    //   54: istore_2
    //   55: aload_0
    //   56: monitorexit
    //   57: iload_2
    //   58: ireturn
    //   59: getstatic 39	bo/app/fd:a	Ljava/lang/String;
    //   62: ldc_w 397
    //   65: iconst_1
    //   66: anewarray 20	java/lang/Object
    //   69: dup
    //   70: iconst_0
    //   71: aload_3
    //   72: aastore
    //   73: invokestatic 37	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   76: invokestatic 151	com/appboy/support/AppboyLogger:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   79: pop
    //   80: goto -25 -> 55
    //   83: astore_1
    //   84: aload_0
    //   85: monitorexit
    //   86: aload_1
    //   87: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	88	0	this	fd
    //   0	88	1	paramString	String
    //   1	57	2	bool	boolean
    //   5	67	3	str	String
    // Exception table:
    //   from	to	target	type
    //   10	15	83	finally
    //   19	26	83	finally
    //   26	53	83	finally
    //   59	80	83	finally
  }
  
  public final void d(String paramString)
  {
    try
    {
      SharedPreferences.Editor localEditor = c.edit();
      localEditor.putString("country", paramString);
      localEditor.apply();
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public final void e(String paramString)
  {
    try
    {
      SharedPreferences.Editor localEditor = c.edit();
      localEditor.putString("home_city", paramString);
      localEditor.apply();
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  /* Error */
  public final boolean f(String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_1
    //   5: astore_3
    //   6: aload_1
    //   7: ifnull +8 -> 15
    //   10: aload_1
    //   11: invokevirtual 390	java/lang/String:trim	()Ljava/lang/String;
    //   14: astore_3
    //   15: aload_3
    //   16: ifnull +10 -> 26
    //   19: aload_3
    //   20: invokestatic 405	com/appboy/support/ValidationUtils:isValidPhoneNumber	(Ljava/lang/String;)Z
    //   23: ifeq +36 -> 59
    //   26: aload_0
    //   27: getfield 94	bo/app/fd:c	Landroid/content/SharedPreferences;
    //   30: invokeinterface 117 1 0
    //   35: astore_1
    //   36: aload_1
    //   37: ldc_w 407
    //   40: aload_3
    //   41: invokeinterface 163 3 0
    //   46: pop
    //   47: aload_1
    //   48: invokeinterface 166 1 0
    //   53: iconst_1
    //   54: istore_2
    //   55: aload_0
    //   56: monitorexit
    //   57: iload_2
    //   58: ireturn
    //   59: getstatic 39	bo/app/fd:a	Ljava/lang/String;
    //   62: ldc_w 409
    //   65: iconst_1
    //   66: anewarray 20	java/lang/Object
    //   69: dup
    //   70: iconst_0
    //   71: aload_3
    //   72: aastore
    //   73: invokestatic 37	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   76: invokestatic 151	com/appboy/support/AppboyLogger:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   79: pop
    //   80: goto -25 -> 55
    //   83: astore_1
    //   84: aload_0
    //   85: monitorexit
    //   86: aload_1
    //   87: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	88	0	this	fd
    //   0	88	1	paramString	String
    //   1	57	2	bool	boolean
    //   5	67	3	str	String
    // Exception table:
    //   from	to	target	type
    //   10	15	83	finally
    //   19	26	83	finally
    //   26	53	83	finally
    //   59	80	83	finally
  }
  
  public final void g(String paramString)
  {
    try
    {
      SharedPreferences.Editor localEditor = c.edit();
      localEditor.putString("image_url", paramString);
      localEditor.apply();
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  /* Error */
  public final void h(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 94	bo/app/fd:c	Landroid/content/SharedPreferences;
    //   6: invokeinterface 117 1 0
    //   11: astore_2
    //   12: aload_1
    //   13: invokestatic 415	com/appboy/support/StringUtils:isNullOrBlank	(Ljava/lang/String;)Z
    //   16: ifeq +21 -> 37
    //   19: aload_2
    //   20: ldc -70
    //   22: invokeinterface 261 2 0
    //   27: pop
    //   28: aload_2
    //   29: invokeinterface 166 1 0
    //   34: aload_0
    //   35: monitorexit
    //   36: return
    //   37: aload_2
    //   38: ldc -70
    //   40: aload_1
    //   41: invokeinterface 163 3 0
    //   46: pop
    //   47: goto -19 -> 28
    //   50: astore_1
    //   51: aload_0
    //   52: monitorexit
    //   53: aload_1
    //   54: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	55	0	this	fd
    //   0	55	1	paramString	String
    //   11	27	2	localEditor	SharedPreferences.Editor
    // Exception table:
    //   from	to	target	type
    //   2	28	50	finally
    //   28	34	50	finally
    //   37	47	50	finally
  }
  
  public final boolean i(String paramString)
  {
    boolean bool = false;
    if (paramString == null) {}
    for (;;)
    {
      try
      {
        AppboyLogger.w(a, "Custom attribute key cannot be null.");
        return bool;
      }
      finally {}
      if (ValidationUtils.isValidCustomAttributeKey(paramString))
      {
        SharedPreferences.Editor localEditor = c.edit();
        localEditor.putString(paramString, "appboy_null_5a8579f5-079b-4681-a046-0f3c46a4ef58");
        localEditor.apply();
        bool = true;
      }
    }
  }
}

/* Location:
 * Qualified Name:     bo.app.fd
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */