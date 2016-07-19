package com.appboy.models.cards;

import bo.app.by;
import bo.app.ex;
import bo.app.fl;
import org.json.JSONObject;

public final class CaptionedImageCard
  extends Card
{
  private final String j;
  private final String k;
  private final String l;
  private final String m;
  private final String n;
  private final float o;
  
  public CaptionedImageCard(JSONObject paramJSONObject)
  {
    this(paramJSONObject, null, null);
  }
  
  public CaptionedImageCard(JSONObject paramJSONObject, by paramby, ex paramex)
  {
    super(paramJSONObject, paramby, paramex);
    j = paramJSONObject.getString("image");
    k = paramJSONObject.getString("title");
    l = paramJSONObject.getString("description");
    m = fl.a(paramJSONObject, "url");
    n = fl.a(paramJSONObject, "domain");
    o = ((float)paramJSONObject.optDouble("aspect_ratio", 0.0D));
  }
  
  public final float getAspectRatio()
  {
    return o;
  }
  
  public final String getDescription()
  {
    return l;
  }
  
  public final String getDomain()
  {
    return n;
  }
  
  public final String getImageUrl()
  {
    return j;
  }
  
  public final String getTitle()
  {
    return k;
  }
  
  public final String getUrl()
  {
    return m;
  }
  
  public final String toString()
  {
    return "CaptionedImageCard{mId='" + c + '\'' + ", mViewed='" + d + '\'' + ", mCreated='" + f + '\'' + ", mUpdated='" + g + '\'' + ", mImageUrl='" + j + '\'' + ", mTitle='" + k + '\'' + ", mDescription='" + l + '\'' + ", mUrl='" + m + '\'' + ", mDomain='" + n + '\'' + ", mAspectRatio='" + o + '\'' + "}";
  }
}

/* Location:
 * Qualified Name:     com.appboy.models.cards.CaptionedImageCard
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */