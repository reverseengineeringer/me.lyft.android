package com.appboy.models.cards;

import bo.app.by;
import bo.app.ex;
import bo.app.fl;
import org.json.JSONObject;

public final class ShortNewsCard
  extends Card
{
  private final String j;
  private final String k;
  private final String l;
  private final String m;
  private final String n;
  
  public ShortNewsCard(JSONObject paramJSONObject)
  {
    this(paramJSONObject, null, null);
  }
  
  public ShortNewsCard(JSONObject paramJSONObject, by paramby, ex paramex)
  {
    super(paramJSONObject, paramby, paramex);
    j = paramJSONObject.getString("description");
    k = paramJSONObject.getString("image");
    l = fl.a(paramJSONObject, "title");
    m = fl.a(paramJSONObject, "url");
    n = fl.a(paramJSONObject, "domain");
  }
  
  public final String getDescription()
  {
    return j;
  }
  
  public final String getDomain()
  {
    return n;
  }
  
  public final String getImageUrl()
  {
    return k;
  }
  
  public final String getTitle()
  {
    return l;
  }
  
  public final String getUrl()
  {
    return m;
  }
  
  public final String toString()
  {
    return "ShortNewsCard{mId='" + c + '\'' + ", mViewed='" + d + '\'' + ", mCreated='" + f + '\'' + ", mUpdated='" + g + '\'' + ", mDescription='" + j + '\'' + ", mImageUrl='" + k + '\'' + ", mTitle='" + l + '\'' + ", mUrl='" + m + '\'' + ", mDomain='" + n + '\'' + "}";
  }
}

/* Location:
 * Qualified Name:     com.appboy.models.cards.ShortNewsCard
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */