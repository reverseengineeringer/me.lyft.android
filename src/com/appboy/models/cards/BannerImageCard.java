package com.appboy.models.cards;

import bo.app.by;
import bo.app.ex;
import bo.app.fl;
import org.json.JSONObject;

public final class BannerImageCard
  extends Card
{
  private final String j;
  private final String k;
  private final String l;
  private final float m;
  
  public BannerImageCard(JSONObject paramJSONObject)
  {
    this(paramJSONObject, null, null);
  }
  
  public BannerImageCard(JSONObject paramJSONObject, by paramby, ex paramex)
  {
    super(paramJSONObject, paramby, paramex);
    j = paramJSONObject.getString("image");
    k = fl.a(paramJSONObject, "url");
    l = fl.a(paramJSONObject, "domain");
    m = ((float)paramJSONObject.optDouble("aspect_ratio", 0.0D));
  }
  
  public final float getAspectRatio()
  {
    return m;
  }
  
  public final String getDomain()
  {
    return l;
  }
  
  public final String getImageUrl()
  {
    return j;
  }
  
  public final String getUrl()
  {
    return k;
  }
  
  public final String toString()
  {
    return "BannerImageCard{mId='" + c + '\'' + ", mViewed='" + d + '\'' + ", mCreated='" + f + '\'' + ", mUpdated='" + g + '\'' + ", mImageUrl='" + j + '\'' + ", mUrl='" + k + '\'' + ", mDomain='" + l + '\'' + ", mAspectRatio='" + m + '\'' + "}";
  }
}

/* Location:
 * Qualified Name:     com.appboy.models.cards.BannerImageCard
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */