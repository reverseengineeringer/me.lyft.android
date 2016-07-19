package com.appboy.models;

import android.graphics.Bitmap;
import android.net.Uri;
import bo.app.ch;
import bo.app.cs;
import bo.app.dd;
import bo.app.fl;
import com.appboy.Constants;
import com.appboy.enums.inappmessage.ClickAction;
import com.appboy.enums.inappmessage.DismissType;
import com.appboy.support.AppboyLogger;
import com.appboy.support.StringUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class InAppMessageBase
  implements IInAppMessage
{
  public static final int INAPP_MESSAGE_DURATION_DEFAULT_MILLIS = 5000;
  public static final int INAPP_MESSAGE_DURATION_MIN_MILLIS = 999;
  public static final String TYPE = "type";
  public static final String a = String.format("%s.%s", new Object[] { Constants.APPBOY_LOG_TAG_PREFIX, InAppMessageBase.class.getName() });
  public String b;
  public String c;
  public String d;
  protected JSONObject e;
  public ch f;
  private String g;
  private Map<String, String> h;
  private boolean i = true;
  private boolean j = true;
  private ClickAction k = ClickAction.NONE;
  private Uri l;
  private DismissType m = DismissType.AUTO_DISMISS;
  private int n = 5000;
  private boolean o = false;
  private boolean p = false;
  private int q = 0;
  private int r = 0;
  private int s = 0;
  private int t = 0;
  private String u;
  private String v;
  private Bitmap w;
  private boolean x = false;
  private String y;
  
  protected InAppMessageBase() {}
  
  private InAppMessageBase(String paramString1, Map<String, String> paramMap, ClickAction paramClickAction, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString3, String paramString4, DismissType paramDismissType, int paramInt5, String paramString5, String paramString6, String paramString7, JSONObject paramJSONObject, ch paramch)
  {
    g = paramString1;
    h = paramMap;
    i = true;
    j = true;
    k = paramClickAction;
    if ((k == ClickAction.URI) && (!StringUtils.isNullOrBlank(paramString2))) {
      l = Uri.parse(paramString2);
    }
    if (paramDismissType == DismissType.SWIPE) {}
    for (m = DismissType.MANUAL;; m = paramDismissType)
    {
      setDurationInMilliseconds(paramInt5);
      q = paramInt1;
      s = paramInt2;
      t = paramInt3;
      r = paramInt4;
      u = paramString3;
      v = paramString4;
      b = paramString5;
      c = paramString6;
      d = paramString7;
      o = false;
      p = false;
      e = paramJSONObject;
      f = paramch;
      return;
    }
  }
  
  public InAppMessageBase(JSONObject paramJSONObject, ch paramch)
  {
    this(paramJSONObject.optString("message"), fl.a(paramJSONObject.optJSONObject("extras"), new HashMap()), (ClickAction)fl.a(paramJSONObject, "click_action", ClickAction.class, ClickAction.NONE), paramJSONObject.optString("uri"), paramJSONObject.optInt("bg_color"), paramJSONObject.optInt("icon_color"), paramJSONObject.optInt("icon_bg_color"), paramJSONObject.optInt("text_color"), paramJSONObject.optString("icon"), paramJSONObject.optString("image_url"), (DismissType)fl.a(paramJSONObject, "message_close", DismissType.class, DismissType.AUTO_DISMISS), paramJSONObject.optInt("duration"), paramJSONObject.optString("campaign_id"), paramJSONObject.optString("card_id"), paramJSONObject.optString("trigger_id"), paramJSONObject, paramch);
  }
  
  public JSONObject forJsonPut()
  {
    if (e != null) {
      return e;
    }
    try
    {
      JSONObject localJSONObject1 = new JSONObject();
      localJSONObject1.putOpt("message", g);
      localJSONObject1.put("duration", n);
      localJSONObject1.putOpt("campaign_id", b);
      localJSONObject1.putOpt("card_id", c);
      localJSONObject1.putOpt("trigger_id", d);
      localJSONObject1.putOpt("click_action", k.toString());
      localJSONObject1.putOpt("message_close", m.toString());
      if (l != null) {
        localJSONObject1.put("uri", l.toString());
      }
      localJSONObject1.put("bg_color", q);
      localJSONObject1.put("text_color", r);
      localJSONObject1.put("icon_color", s);
      localJSONObject1.put("icon_bg_color", t);
      localJSONObject1.putOpt("icon", u);
      localJSONObject1.putOpt("image_url", v);
      if (h != null)
      {
        JSONObject localJSONObject2 = new JSONObject();
        Iterator localIterator = h.keySet().iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          localJSONObject2.put(str, h.get(str));
        }
        localJSONObject1.put("extras", localJSONObject2);
      }
      return localJSONObject1;
    }
    catch (JSONException localJSONException) {}
    return null;
  }
  
  public boolean getAnimateIn()
  {
    return i;
  }
  
  public boolean getAnimateOut()
  {
    return j;
  }
  
  public int getBackgroundColor()
  {
    return q;
  }
  
  public Bitmap getBitmap()
  {
    return w;
  }
  
  public String getCampaignId()
  {
    return b;
  }
  
  public String getCardId()
  {
    return c;
  }
  
  public ClickAction getClickAction()
  {
    return k;
  }
  
  public DismissType getDismissType()
  {
    return m;
  }
  
  public int getDurationInMilliseconds()
  {
    return n;
  }
  
  public Map<String, String> getExtras()
  {
    return h;
  }
  
  public String getIcon()
  {
    return u;
  }
  
  public int getIconBackgroundColor()
  {
    return t;
  }
  
  public int getIconColor()
  {
    return s;
  }
  
  public boolean getImageDownloadSuccessful()
  {
    return x;
  }
  
  public String getImageUrl()
  {
    return getRemoteImageUrl();
  }
  
  public String getLocalImageUrl()
  {
    return y;
  }
  
  public String getMessage()
  {
    return g;
  }
  
  public int getMessageTextColor()
  {
    return r;
  }
  
  public String getRemoteAssetPathForPrefetch()
  {
    return getRemoteImageUrl();
  }
  
  public String getRemoteImageUrl()
  {
    return v;
  }
  
  public String getTriggerId()
  {
    return d;
  }
  
  public Uri getUri()
  {
    return l;
  }
  
  public boolean logClick()
  {
    Object localObject;
    if ((StringUtils.isNullOrEmpty(b)) && (StringUtils.isNullOrEmpty(c)) && (StringUtils.isNullOrEmpty(d)))
    {
      localObject = a;
      return false;
    }
    if (p)
    {
      AppboyLogger.i(a, "Click already logged for this in-app message. Ignoring.");
      return false;
    }
    if (f == null)
    {
      AppboyLogger.e(a, "Cannot log an in-app message click because the AppboyManager is null.");
      return false;
    }
    try
    {
      localObject = dd.c(b, c, d);
      f.a((cs)localObject);
      p = true;
      return true;
    }
    catch (JSONException localJSONException)
    {
      f.a(localJSONException);
    }
    return false;
  }
  
  public boolean logImpression()
  {
    Object localObject;
    if ((StringUtils.isNullOrEmpty(b)) && (StringUtils.isNullOrEmpty(c)) && (StringUtils.isNullOrEmpty(d)))
    {
      localObject = a;
      return false;
    }
    if (o)
    {
      AppboyLogger.i(a, "Impression already logged for this in-app message. Ignoring.");
      return false;
    }
    if (f == null)
    {
      AppboyLogger.e(a, "Cannot log an in-app message impression because the AppboyManager is null.");
      return false;
    }
    try
    {
      localObject = dd.b(b, c, d);
      f.a((cs)localObject);
      o = true;
      return true;
    }
    catch (JSONException localJSONException)
    {
      f.a(localJSONException);
    }
    return false;
  }
  
  public void setAnimateIn(boolean paramBoolean)
  {
    i = paramBoolean;
  }
  
  public void setAnimateOut(boolean paramBoolean)
  {
    j = paramBoolean;
  }
  
  public void setBackgroundColor(int paramInt)
  {
    q = paramInt;
  }
  
  public void setBitmap(Bitmap paramBitmap)
  {
    w = paramBitmap;
  }
  
  public boolean setClickAction(ClickAction paramClickAction)
  {
    if (paramClickAction != ClickAction.URI)
    {
      k = paramClickAction;
      l = null;
      return true;
    }
    AppboyLogger.e(a, "A non-null URI is required in order to set the message ClickAction to URI.");
    return false;
  }
  
  public boolean setClickAction(ClickAction paramClickAction, Uri paramUri)
  {
    if ((paramUri == null) && (paramClickAction == ClickAction.URI))
    {
      AppboyLogger.e(a, "A non-null URI is required in order to set the message ClickAction to URI.");
      return false;
    }
    if ((paramUri != null) && (paramClickAction == ClickAction.URI))
    {
      k = paramClickAction;
      l = paramUri;
      return true;
    }
    return setClickAction(paramClickAction);
  }
  
  public void setDismissType(DismissType paramDismissType)
  {
    m = paramDismissType;
  }
  
  public void setDurationInMilliseconds(int paramInt)
  {
    if (paramInt < 999)
    {
      n = 5000;
      AppboyLogger.w(a, "Requested in-app message duration " + paramInt + " is lower than the minimum of 999. Defaulting to " + n + " milliseconds.");
      return;
    }
    n = paramInt;
    String str = a;
    new StringBuilder("Set in-app message duration to ").append(n).append(" milliseconds.");
  }
  
  public void setIcon(String paramString)
  {
    u = paramString;
  }
  
  public void setIconBackgroundColor(int paramInt)
  {
    t = paramInt;
  }
  
  public void setIconColor(int paramInt)
  {
    s = paramInt;
  }
  
  public void setImageDownloadSuccessful(boolean paramBoolean)
  {
    x = paramBoolean;
  }
  
  public void setImageUrl(String paramString)
  {
    setRemoteImageUrl(paramString);
  }
  
  public void setLocalAssetPathForPrefetch(String paramString)
  {
    setLocalImageUrl(paramString);
  }
  
  public void setLocalImageUrl(String paramString)
  {
    y = paramString;
  }
  
  public void setMessage(String paramString)
  {
    g = paramString;
  }
  
  public void setMessageTextColor(int paramInt)
  {
    r = paramInt;
  }
  
  public void setRemoteImageUrl(String paramString)
  {
    v = paramString;
  }
}

/* Location:
 * Qualified Name:     com.appboy.models.InAppMessageBase
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */