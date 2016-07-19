package com.appboy.models;

import bo.app.ch;
import bo.app.dd;
import com.appboy.support.AppboyLogger;
import com.appboy.support.StringUtils;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class InAppMessageHtmlBase
  extends InAppMessageBase
  implements IInAppMessageHtml
{
  private String g;
  private String h;
  private boolean i = false;
  
  protected InAppMessageHtmlBase() {}
  
  public InAppMessageHtmlBase(JSONObject paramJSONObject, ch paramch)
  {
    super(paramJSONObject, paramch);
    if (!StringUtils.isNullOrBlank(paramJSONObject.optString("zipped_assets_url"))) {
      g = paramJSONObject.optString("zipped_assets_url");
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
      localJSONObject.putOpt("zipped_assets_url", g);
      return localJSONObject;
    }
    catch (JSONException localJSONException) {}
    return null;
  }
  
  public String getAssetsZipRemoteUrl()
  {
    return g;
  }
  
  public String getLocalAssetsDirectoryUrl()
  {
    return h;
  }
  
  public String getRemoteAssetPathForPrefetch()
  {
    return getAssetsZipRemoteUrl();
  }
  
  public boolean logButtonClick(String paramString)
  {
    if ((StringUtils.isNullOrEmpty(b)) && (StringUtils.isNullOrEmpty(c)) && (StringUtils.isNullOrEmpty(d)))
    {
      paramString = a;
      return false;
    }
    if (StringUtils.isNullOrBlank(paramString))
    {
      AppboyLogger.i(a, "Button Id was null or blank for this html in-app message. Ignoring.");
      return false;
    }
    if (i)
    {
      AppboyLogger.i(a, "Button click already logged for this html in-app message. Ignoring.");
      return false;
    }
    if (f == null)
    {
      AppboyLogger.e(a, "Cannot log an html in-app message button click because the AppboyManager is null.");
      return false;
    }
    try
    {
      paramString = dd.a(b, c, d, paramString);
      f.a(paramString);
      i = true;
      return true;
    }
    catch (JSONException paramString)
    {
      f.a(paramString);
    }
    return false;
  }
  
  public void setAssetsZipRemoteUrl(String paramString)
  {
    g = paramString;
  }
  
  public void setLocalAssetPathForPrefetch(String paramString)
  {
    setLocalAssetsDirectoryUrl(paramString);
  }
  
  public void setLocalAssetsDirectoryUrl(String paramString)
  {
    h = paramString;
  }
}

/* Location:
 * Qualified Name:     com.appboy.models.InAppMessageHtmlBase
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */