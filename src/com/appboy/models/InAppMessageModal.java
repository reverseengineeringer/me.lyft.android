package com.appboy.models;

import bo.app.ch;
import com.appboy.enums.inappmessage.MessageType;
import com.appboy.support.StringUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class InAppMessageModal
  extends InAppMessageImmersiveBase
{
  private Integer g = null;
  
  public InAppMessageModal() {}
  
  public InAppMessageModal(JSONObject paramJSONObject, ch paramch)
  {
    super(paramJSONObject, paramch);
    paramJSONObject = paramJSONObject.optString("modal_frame_color", null);
    if (!StringUtils.isNullOrBlank(paramJSONObject)) {
      g = new Integer(paramJSONObject);
    }
  }
  
  public JSONObject forJsonPut()
  {
    if (e != null) {
      return e;
    }
    try
    {
      JSONObject localJSONObject = super.forJsonPut();
      if (g != null) {
        localJSONObject.put("modal_frame_color", g.toString());
      }
      localJSONObject.put("type", MessageType.MODAL.name());
      return localJSONObject;
    }
    catch (JSONException localJSONException) {}
    return null;
  }
  
  public Integer getModalFrameColor()
  {
    return g;
  }
  
  public void setModalFrameColor(Integer paramInteger)
  {
    g = paramInteger;
  }
}

/* Location:
 * Qualified Name:     com.appboy.models.InAppMessageModal
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */