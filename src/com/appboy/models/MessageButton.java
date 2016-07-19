package com.appboy.models;

import android.net.Uri;
import bo.app.fl;
import com.appboy.Constants;
import com.appboy.enums.inappmessage.ClickAction;
import com.appboy.support.AppboyLogger;
import com.appboy.support.StringUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class MessageButton
  implements IPutIntoJson<JSONObject>
{
  private static final String a = String.format("%s.%s", new Object[] { Constants.APPBOY_LOG_TAG_PREFIX, MessageButton.class.getName() });
  private JSONObject b;
  private int c = -1;
  private ClickAction d = ClickAction.NONE;
  private Uri e;
  private String f;
  private int g = 0;
  private int h = 0;
  
  public MessageButton() {}
  
  public MessageButton(JSONObject paramJSONObject)
  {
    this(paramJSONObject, paramJSONObject.optInt("id", -1), (ClickAction)fl.a(paramJSONObject, "click_action", ClickAction.class, ClickAction.NEWS_FEED), paramJSONObject.optString("uri"), paramJSONObject.optString("text"), paramJSONObject.optInt("bg_color"), paramJSONObject.optInt("text_color"));
  }
  
  private MessageButton(JSONObject paramJSONObject, int paramInt1, ClickAction paramClickAction, String paramString1, String paramString2, int paramInt2, int paramInt3)
  {
    b = paramJSONObject;
    c = paramInt1;
    d = paramClickAction;
    if ((d == ClickAction.URI) && (!StringUtils.isNullOrBlank(paramString1))) {
      e = Uri.parse(paramString1);
    }
    f = paramString2;
    g = paramInt2;
    h = paramInt3;
  }
  
  public JSONObject forJsonPut()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("id", c);
      localJSONObject.put("click_action", d.toString());
      if (e != null) {
        localJSONObject.put("uri", e.toString());
      }
      localJSONObject.putOpt("text", f);
      localJSONObject.put("bg_color", g);
      localJSONObject.put("text_color", h);
      return localJSONObject;
    }
    catch (JSONException localJSONException) {}
    return b;
  }
  
  public int getBackgroundColor()
  {
    return g;
  }
  
  public ClickAction getClickAction()
  {
    return d;
  }
  
  public int getId()
  {
    return c;
  }
  
  public String getText()
  {
    return f;
  }
  
  public int getTextColor()
  {
    return h;
  }
  
  public Uri getUri()
  {
    return e;
  }
  
  public void setBackgroundColor(int paramInt)
  {
    g = paramInt;
  }
  
  public boolean setClickAction(ClickAction paramClickAction)
  {
    if (paramClickAction != ClickAction.URI)
    {
      d = paramClickAction;
      e = null;
      return true;
    }
    AppboyLogger.e(a, "A non-null URI is required in order to set the button ClickAction to URI.");
    return false;
  }
  
  public boolean setClickAction(ClickAction paramClickAction, Uri paramUri)
  {
    if ((paramUri == null) && (paramClickAction == ClickAction.URI))
    {
      AppboyLogger.e(a, "A non-null URI is required in order to set the button ClickAction to URI.");
      return false;
    }
    if ((paramUri != null) && (paramClickAction == ClickAction.URI))
    {
      d = paramClickAction;
      e = paramUri;
      return true;
    }
    return setClickAction(paramClickAction);
  }
  
  public void setText(String paramString)
  {
    f = paramString;
  }
  
  public void setTextColor(int paramInt)
  {
    h = paramInt;
  }
}

/* Location:
 * Qualified Name:     com.appboy.models.MessageButton
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */