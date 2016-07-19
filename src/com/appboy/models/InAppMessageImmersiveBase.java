package com.appboy.models;

import bo.app.ch;
import bo.app.dd;
import com.appboy.support.AppboyLogger;
import com.appboy.support.StringUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class InAppMessageImmersiveBase
  extends InAppMessageBase
  implements IInAppMessageImmersive
{
  private String g;
  private int h = 0;
  private int i = 0;
  private boolean j;
  private List<MessageButton> k;
  
  protected InAppMessageImmersiveBase() {}
  
  public InAppMessageImmersiveBase(JSONObject paramJSONObject, ch paramch)
  {
    this(paramJSONObject, paramch, paramJSONObject.optString("header"), paramJSONObject.optInt("header_text_color"), paramJSONObject.optInt("close_btn_color"));
    if (paramJSONObject.optJSONArray("btns") != null)
    {
      paramch = new ArrayList();
      paramJSONObject = paramJSONObject.optJSONArray("btns");
      int m = 0;
      while (m < paramJSONObject.length())
      {
        paramch.add(new MessageButton(paramJSONObject.optJSONObject(m)));
        m += 1;
      }
      setMessageButtons(paramch);
    }
  }
  
  private InAppMessageImmersiveBase(JSONObject paramJSONObject, ch paramch, String paramString, int paramInt1, int paramInt2)
  {
    super(paramJSONObject, paramch);
    g = paramString;
    h = paramInt1;
    i = paramInt2;
  }
  
  public JSONObject forJsonPut()
  {
    if (e != null) {
      return e;
    }
    try
    {
      JSONObject localJSONObject = super.forJsonPut();
      localJSONObject.putOpt("header", g);
      localJSONObject.put("header_text_color", h);
      localJSONObject.put("close_btn_color", i);
      if (k != null)
      {
        JSONArray localJSONArray = new JSONArray();
        Iterator localIterator = k.iterator();
        while (localIterator.hasNext()) {
          localJSONArray.put(((MessageButton)localIterator.next()).forJsonPut());
        }
        localJSONObject.put("btns", localJSONArray);
      }
      return localJSONObject;
    }
    catch (JSONException localJSONException) {}
    return null;
  }
  
  public int getCloseButtonColor()
  {
    return i;
  }
  
  public String getHeader()
  {
    return g;
  }
  
  public int getHeaderTextColor()
  {
    return h;
  }
  
  public List<MessageButton> getMessageButtons()
  {
    return k;
  }
  
  public boolean logButtonClick(MessageButton paramMessageButton)
  {
    if ((StringUtils.isNullOrEmpty(b)) && (StringUtils.isNullOrEmpty(c)) && (StringUtils.isNullOrEmpty(d)))
    {
      paramMessageButton = a;
      return false;
    }
    if (paramMessageButton == null)
    {
      AppboyLogger.w(a, "Message button was null. Ignoring button click.");
      return false;
    }
    if (j)
    {
      AppboyLogger.i(a, "Button click already logged for this message. Ignoring.");
      return false;
    }
    if (f == null)
    {
      AppboyLogger.e(a, "Cannot log a button click because the AppboyManager is null.");
      return false;
    }
    try
    {
      paramMessageButton = dd.a(b, c, d, paramMessageButton);
      f.a(paramMessageButton);
      j = true;
      return true;
    }
    catch (JSONException paramMessageButton)
    {
      f.a(paramMessageButton);
    }
    return false;
  }
  
  public void setCloseButtonColor(int paramInt)
  {
    i = paramInt;
  }
  
  public void setHeader(String paramString)
  {
    g = paramString;
  }
  
  public void setHeaderTextColor(int paramInt)
  {
    h = paramInt;
  }
  
  public void setMessageButtons(List<MessageButton> paramList)
  {
    k = paramList;
  }
}

/* Location:
 * Qualified Name:     com.appboy.models.InAppMessageImmersiveBase
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */