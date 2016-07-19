package bo.app;

import com.appboy.Constants;
import com.appboy.models.MessageButton;
import com.appboy.models.outgoing.AppboyProperties;
import com.appboy.support.AppboyLogger;
import com.appboy.support.StringUtils;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.math.BigDecimal;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class dd
  implements cs
{
  private static final String a = String.format("%s.%s", new Object[] { Constants.APPBOY_LOG_TAG_PREFIX, dd.class.getName() });
  private final ad b;
  private final JSONObject c;
  private final double d;
  
  private dd(ad paramad, JSONObject paramJSONObject)
  {
    this(paramad, paramJSONObject, fg.b());
  }
  
  private dd(ad paramad, JSONObject paramJSONObject, double paramDouble)
  {
    if ((s == null) || (paramJSONObject == null)) {
      throw new NullPointerException();
    }
    b = paramad;
    c = paramJSONObject;
    d = paramDouble;
  }
  
  public static dd a(bp parambp, db paramdb)
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("nop", true);
    paramdb = b(parambp, paramdb);
    parambp = a(parambp);
    localJSONObject.put("e", paramdb + "\n" + parambp);
    return new dd(ad.g, localJSONObject);
  }
  
  public static dd a(dj paramdj)
  {
    return new dd(ad.a, paramdj.a());
  }
  
  public static dd a(String paramString)
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("new", paramString);
    return new dd(ad.j, localJSONObject);
  }
  
  public static dd a(String paramString, int paramInt)
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("key", paramString);
    localJSONObject.put("value", paramInt);
    return new dd(ad.k, localJSONObject);
  }
  
  public static dd a(String paramString, AppboyProperties paramAppboyProperties)
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("n", StringUtils.checkNotNullOrEmpty(paramString));
    if ((paramAppboyProperties != null) && (paramAppboyProperties.size() > 0)) {
      localJSONObject.put("p", paramAppboyProperties.forJsonPut());
    }
    return new dd(ad.b, localJSONObject);
  }
  
  public static dd a(String paramString1, String paramString2)
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("old", paramString1);
    localJSONObject.put("new", paramString2);
    return new dd(ad.j, localJSONObject);
  }
  
  public static dd a(String paramString1, String paramString2, double paramDouble)
  {
    ad localad = ad.a(paramString1);
    if (localad == null) {
      throw new IllegalArgumentException(String.format("Cannot parse eventType %s", new Object[] { paramString1 }));
    }
    return new dd(localad, new JSONObject(paramString2), paramDouble);
  }
  
  public static dd a(String paramString1, String paramString2, String paramString3)
  {
    return new dd(ad.p, b(paramString1, paramString2, paramString3, null));
  }
  
  public static dd a(String paramString1, String paramString2, String paramString3, MessageButton paramMessageButton)
  {
    ad localad = ad.r;
    if (paramMessageButton != null) {}
    for (paramMessageButton = String.valueOf(paramMessageButton.getId());; paramMessageButton = null) {
      return new dd(localad, b(paramString1, paramString2, paramString3, paramMessageButton));
    }
  }
  
  public static dd a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    return new dd(ad.r, b(paramString1, paramString2, paramString3, paramString4));
  }
  
  public static dd a(String paramString1, String paramString2, BigDecimal paramBigDecimal, int paramInt, AppboyProperties paramAppboyProperties)
  {
    paramBigDecimal = fe.a(paramBigDecimal);
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("pid", paramString1);
    localJSONObject.put("c", paramString2);
    localJSONObject.put("p", paramBigDecimal.doubleValue());
    localJSONObject.put("q", paramInt);
    if ((paramAppboyProperties != null) && (paramAppboyProperties.size() > 0)) {
      localJSONObject.put("pr", paramAppboyProperties.forJsonPut());
    }
    return new dd(ad.c, localJSONObject);
  }
  
  public static dd a(String paramString, String[] paramArrayOfString)
  {
    if (paramArrayOfString == null) {}
    for (JSONArray localJSONArray = null; paramArrayOfString != null; localJSONArray = new JSONArray())
    {
      int j = paramArrayOfString.length;
      int i = 0;
      while (i < j)
      {
        localJSONArray.put(paramArrayOfString[i]);
        i += 1;
      }
    }
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("key", paramString);
    if (paramArrayOfString == null) {
      localJSONObject.put("value", JSONObject.NULL);
    }
    for (;;)
    {
      return new dd(ad.n, localJSONObject);
      localJSONObject.put("value", localJSONArray);
    }
  }
  
  public static dd a(Throwable paramThrowable, db paramdb)
  {
    paramdb = b(paramThrowable, paramdb);
    paramThrowable = a(paramThrowable);
    paramThrowable = new StringBuilder(paramdb).append("\n").append(paramThrowable);
    paramdb = new JSONObject();
    paramdb.put("e", paramThrowable.toString());
    return new dd(ad.g, paramdb);
  }
  
  public static dd a(JSONObject paramJSONObject)
  {
    String str = paramJSONObject.getString("n");
    ad localad = ad.a(paramJSONObject.getString("n"));
    if (localad == null) {
      throw new IllegalArgumentException(String.format("Cannot parse eventType %s", new Object[] { str }));
    }
    return new dd(localad, paramJSONObject.getJSONObject("d"), paramJSONObject.getDouble("t"));
  }
  
  private static String a(Throwable paramThrowable)
  {
    Object localObject = new StringWriter();
    paramThrowable.printStackTrace(new PrintWriter((Writer)localObject));
    localObject = localObject.toString();
    paramThrowable = (Throwable)localObject;
    if (((String)localObject).length() > 5000) {
      paramThrowable = ((String)localObject).substring(0, 5000);
    }
    return paramThrowable;
  }
  
  public static boolean a(cs paramcs)
  {
    return (paramcs.b() == ad.g) && (paramcs.c().optBoolean("nop", false) == true);
  }
  
  public static dd b(String paramString)
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("cid", paramString);
    return new dd(ad.d, localJSONObject);
  }
  
  public static dd b(String paramString1, String paramString2)
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("cid", paramString1);
    localJSONObject.put("a", paramString2);
    return new dd(ad.e, localJSONObject);
  }
  
  public static dd b(String paramString1, String paramString2, String paramString3)
  {
    return new dd(ad.o, b(paramString1, paramString2, paramString3, null));
  }
  
  private static String b(Throwable paramThrowable, db paramdb)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject = paramThrowable.toString();
    paramThrowable = (Throwable)localObject;
    if (((String)localObject).length() > 5000) {
      paramThrowable = ((String)localObject).substring(0, 5000);
    }
    localStringBuilder.append("exception_class: ").append(paramThrowable).append(",");
    localObject = localStringBuilder.append("session_id: ");
    if (paramdb != null) {}
    for (paramThrowable = paramdb.toString();; paramThrowable = null)
    {
      ((StringBuilder)localObject).append(paramThrowable);
      return localStringBuilder.toString();
    }
  }
  
  private static JSONObject b(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    JSONObject localJSONObject = new JSONObject();
    if (!StringUtils.isNullOrEmpty(paramString1))
    {
      JSONArray localJSONArray = new JSONArray();
      localJSONArray.put(paramString1);
      localJSONObject.put("campaign_ids", localJSONArray);
    }
    if (!StringUtils.isNullOrEmpty(paramString2))
    {
      paramString1 = new JSONArray();
      paramString1.put(paramString2);
      localJSONObject.put("card_ids", paramString1);
    }
    if (!StringUtils.isNullOrEmpty(paramString3))
    {
      paramString1 = new JSONArray();
      paramString1.put(paramString3);
      localJSONObject.put("trigger_ids", paramString1);
    }
    if (!StringUtils.isNullOrEmpty(paramString4)) {
      localJSONObject.put("bid", paramString4);
    }
    return localJSONObject;
  }
  
  public static dd c(String paramString)
  {
    JSONObject localJSONObject = new JSONObject();
    JSONArray localJSONArray = new JSONArray();
    localJSONArray.put(paramString);
    localJSONObject.put("ids", localJSONArray);
    return new dd(ad.h, localJSONObject);
  }
  
  public static dd c(String paramString1, String paramString2)
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("key", paramString1);
    localJSONObject.put("value", paramString2);
    return new dd(ad.l, localJSONObject);
  }
  
  public static dd c(String paramString1, String paramString2, String paramString3)
  {
    return new dd(ad.q, b(paramString1, paramString2, paramString3, null));
  }
  
  public static dd d(String paramString)
  {
    JSONObject localJSONObject = new JSONObject();
    JSONArray localJSONArray = new JSONArray();
    localJSONArray.put(paramString);
    localJSONObject.put("ids", localJSONArray);
    return new dd(ad.i, localJSONObject);
  }
  
  public static dd d(String paramString1, String paramString2)
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("key", paramString1);
    localJSONObject.put("value", paramString2);
    return new dd(ad.m, localJSONObject);
  }
  
  public static dd e()
  {
    return e("feed_displayed");
  }
  
  private static dd e(String paramString)
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("n", paramString);
    return new dd(ad.f, localJSONObject);
  }
  
  public static dd f()
  {
    return e("feedback_displayed");
  }
  
  private JSONObject g()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("n", b.s);
      localJSONObject.put("d", c);
      localJSONObject.put("t", d);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      AppboyLogger.e(a, "Caught exception creating Appboy event Json.", localJSONException);
    }
    return localJSONObject;
  }
  
  public final double a()
  {
    return d;
  }
  
  public final ad b()
  {
    return b;
  }
  
  public final JSONObject c()
  {
    return c;
  }
  
  public final String d()
  {
    return g().toString();
  }
}

/* Location:
 * Qualified Name:     bo.app.dd
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */