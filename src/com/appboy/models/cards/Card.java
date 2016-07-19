package com.appboy.models.cards;

import bo.app.ch;
import bo.app.dd;
import bo.app.ex;
import bo.app.ey;
import bo.app.fg;
import bo.app.fl;
import com.appboy.enums.CardCategory;
import com.appboy.models.IPutIntoJson;
import com.appboy.support.AppboyLogger;
import com.appboy.support.StringUtils;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Observable;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public class Card
  extends Observable
  implements IPutIntoJson<JSONObject>
{
  public static final String CATEGORIES = "categories";
  public static final String CREATED = "created";
  public static final long DEFAULT_EXPIRES_AT = -1L;
  public static final String EXPIRES_AT = "expires_at";
  public static final String ID = "id";
  public static final String UPDATED = "updated";
  public static final String VIEWED = "viewed";
  private static final String j = String.format("%s.%s", new Object[] { "Appboy", Card.class.getName() });
  protected final JSONObject a;
  protected final Map<String, String> b;
  protected final String c;
  protected boolean d;
  protected boolean e;
  protected final long f;
  protected final long g;
  protected final long h;
  protected final EnumSet<CardCategory> i;
  private final ch k;
  private final ex l;
  
  public Card(JSONObject paramJSONObject)
  {
    this(paramJSONObject, null, null);
  }
  
  public Card(JSONObject paramJSONObject, ch paramch, ex paramex)
  {
    a = paramJSONObject;
    b = fl.a(paramJSONObject.optJSONObject("extras"), new HashMap());
    k = paramch;
    l = paramex;
    c = paramJSONObject.getString("id");
    d = paramJSONObject.getBoolean("viewed");
    e = d;
    f = paramJSONObject.getLong("created");
    g = paramJSONObject.getLong("updated");
    h = paramJSONObject.optLong("expires_at", -1L);
    paramJSONObject = paramJSONObject.optJSONArray("categories");
    if ((paramJSONObject == null) || (paramJSONObject.length() == 0)) {
      i = EnumSet.of(CardCategory.NO_CATEGORY);
    }
    for (;;)
    {
      return;
      i = EnumSet.noneOf(CardCategory.class);
      int m = 0;
      while (m < paramJSONObject.length())
      {
        paramch = CardCategory.get(paramJSONObject.getString(m));
        if (paramch != null) {
          i.add(paramch);
        }
        m += 1;
      }
    }
  }
  
  private boolean a()
  {
    if (StringUtils.isNullOrBlank(c))
    {
      AppboyLogger.e(j, "Card ID cannot be null");
      return false;
    }
    return true;
  }
  
  public JSONObject forJsonPut()
  {
    return a;
  }
  
  public EnumSet<CardCategory> getCategories()
  {
    return i;
  }
  
  public long getCreated()
  {
    return f;
  }
  
  public long getExpiresAt()
  {
    return h;
  }
  
  public Map<String, String> getExtras()
  {
    return b;
  }
  
  public String getId()
  {
    return c;
  }
  
  public long getUpdated()
  {
    return g;
  }
  
  public boolean getViewed()
  {
    return d;
  }
  
  public boolean isEqualToCard(Card paramCard)
  {
    return (c.equals(paramCard.getId())) && (g == paramCard.getUpdated()) && (k == k);
  }
  
  public boolean isExpired()
  {
    return (getExpiresAt() != -1L) && (getExpiresAt() <= fg.a());
  }
  
  public boolean isInCategorySet(EnumSet<CardCategory> paramEnumSet)
  {
    paramEnumSet = paramEnumSet.iterator();
    while (paramEnumSet.hasNext())
    {
      CardCategory localCardCategory = (CardCategory)paramEnumSet.next();
      if (i.contains(localCardCategory)) {
        return true;
      }
    }
    return false;
  }
  
  public boolean isRead()
  {
    return e;
  }
  
  public boolean logClick()
  {
    try
    {
      if ((k != null) && (a()))
      {
        k.a(dd.d(c));
        return true;
      }
    }
    catch (Exception localException)
    {
      AppboyLogger.w(j, "Failed to log feed card clicked.", localException);
    }
    return false;
  }
  
  public boolean logImpression()
  {
    try
    {
      if ((k != null) && (l != null) && (a()))
      {
        k.a(dd.c(c));
        l.a(c);
        return true;
      }
    }
    catch (Exception localException)
    {
      AppboyLogger.w(j, "Failed to log feed card impression.", localException);
    }
    return false;
  }
  
  public void setIsRead(boolean paramBoolean)
  {
    e = paramBoolean;
    setChanged();
    notifyObservers();
    if (paramBoolean) {}
    try
    {
      ex localex = l;
      String str2 = c;
      if (!d.contains(str2))
      {
        d.add(str2);
        localex.a(d, ey.a);
      }
      return;
    }
    catch (Exception localException)
    {
      String str1 = j;
    }
  }
  
  public void setViewed(boolean paramBoolean)
  {
    d = paramBoolean;
  }
}

/* Location:
 * Qualified Name:     com.appboy.models.cards.Card
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */