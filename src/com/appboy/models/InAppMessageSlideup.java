package com.appboy.models;

import bo.app.ch;
import bo.app.fl;
import com.appboy.enums.inappmessage.MessageType;
import com.appboy.enums.inappmessage.SlideFrom;
import org.json.JSONException;
import org.json.JSONObject;

public class InAppMessageSlideup
  extends InAppMessageBase
{
  private SlideFrom g = SlideFrom.BOTTOM;
  private int h;
  
  public InAppMessageSlideup() {}
  
  public InAppMessageSlideup(JSONObject paramJSONObject, ch paramch)
  {
    this(paramJSONObject, paramch, (SlideFrom)fl.a(paramJSONObject, "slide_from", SlideFrom.class, SlideFrom.BOTTOM), paramJSONObject.optInt("close_btn_color"));
  }
  
  private InAppMessageSlideup(JSONObject paramJSONObject, ch paramch, SlideFrom paramSlideFrom, int paramInt)
  {
    super(paramJSONObject, paramch);
    g = paramSlideFrom;
    if (g == null) {
      g = SlideFrom.BOTTOM;
    }
    h = paramInt;
  }
  
  public JSONObject forJsonPut()
  {
    if (e != null) {
      return e;
    }
    try
    {
      JSONObject localJSONObject = super.forJsonPut();
      localJSONObject.putOpt("slide_from", g.toString());
      localJSONObject.put("close_btn_color", h);
      localJSONObject.put("type", MessageType.SLIDEUP.name());
      return localJSONObject;
    }
    catch (JSONException localJSONException) {}
    return null;
  }
  
  public int getChevronColor()
  {
    return h;
  }
  
  public SlideFrom getSlideFrom()
  {
    return g;
  }
  
  public void setChevronColor(int paramInt)
  {
    h = paramInt;
  }
  
  public void setSlideFrom(SlideFrom paramSlideFrom)
  {
    g = paramSlideFrom;
  }
}

/* Location:
 * Qualified Name:     com.appboy.models.InAppMessageSlideup
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */