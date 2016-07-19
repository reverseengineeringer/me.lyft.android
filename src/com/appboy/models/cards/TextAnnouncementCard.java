package com.appboy.models.cards;

import bo.app.by;
import bo.app.ex;
import bo.app.fl;
import org.json.JSONObject;

public final class TextAnnouncementCard
  extends Card
{
  private final String j;
  private final String k;
  private final String l;
  private final String m;
  
  public TextAnnouncementCard(JSONObject paramJSONObject)
  {
    this(paramJSONObject, null, null);
  }
  
  public TextAnnouncementCard(JSONObject paramJSONObject, by paramby, ex paramex)
  {
    super(paramJSONObject, paramby, paramex);
    k = fl.a(paramJSONObject, "title");
    j = paramJSONObject.getString("description");
    l = fl.a(paramJSONObject, "url");
    m = fl.a(paramJSONObject, "domain");
  }
  
  public final String getDescription()
  {
    return j;
  }
  
  public final String getDomain()
  {
    return m;
  }
  
  public final String getTitle()
  {
    return k;
  }
  
  public final String getUrl()
  {
    return l;
  }
  
  public final String toString()
  {
    return "TextAnnouncementCard{mId='" + c + '\'' + ", mViewed='" + d + '\'' + ", mCreated='" + f + '\'' + ", mUpdated='" + g + '\'' + ", mDescription='" + j + '\'' + ", mTitle='" + k + '\'' + ", mUrl='" + l + '\'' + ", mDomain='" + m + '\'' + "}";
  }
}

/* Location:
 * Qualified Name:     com.appboy.models.cards.TextAnnouncementCard
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */