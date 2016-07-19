package bo.app;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import com.appboy.Constants;
import com.appboy.events.FeedUpdatedEvent;
import com.appboy.models.cards.Card;
import com.appboy.support.StringUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public class ex
{
  public static final String a = String.format("%s.%s", new Object[] { Constants.APPBOY_LOG_TAG_PREFIX, ex.class.getName() });
  public final SharedPreferences b;
  public final Set<String> c;
  public final Set<String> d;
  public by e;
  
  public ex(Context paramContext, String paramString)
  {
    if (paramString == null) {}
    for (String str = "";; str = "." + paramString)
    {
      b = paramContext.getSharedPreferences("com.appboy.storage.feedstorageprovider" + str, 0);
      c = a(ey.b);
      d = a(ey.a);
      paramContext = b.edit();
      paramContext.putString("uid", paramString);
      paramContext.apply();
      return;
    }
  }
  
  private Set<String> a(ey paramey)
  {
    Object localObject = c;
    String str = d;
    if (Build.VERSION.SDK_INT < 11) {
      return b(b.getString(str, null));
    }
    if (b.contains(str))
    {
      localObject = b(b.getString(str, null));
      SharedPreferences.Editor localEditor = b.edit();
      localEditor.remove(str);
      localEditor.apply();
      a((Set)localObject, paramey);
      return (Set<String>)localObject;
    }
    return b.getStringSet((String)localObject, new HashSet());
  }
  
  public static Set<String> a(JSONArray paramJSONArray)
  {
    HashSet localHashSet = new HashSet();
    if (paramJSONArray != null)
    {
      int i = 0;
      while (i < paramJSONArray.length())
      {
        JSONObject localJSONObject = paramJSONArray.getJSONObject(i);
        if (localJSONObject.has("id")) {
          localHashSet.add(localJSONObject.getString("id"));
        }
        i += 1;
      }
    }
    return localHashSet;
  }
  
  private static Set<String> b(String paramString)
  {
    HashSet localHashSet = new HashSet();
    if (paramString != null) {
      Collections.addAll(localHashSet, paramString.split(";"));
    }
    return localHashSet;
  }
  
  public final FeedUpdatedEvent a(JSONArray paramJSONArray, String paramString, boolean paramBoolean, long paramLong)
  {
    if ((paramJSONArray == null) || (paramJSONArray.length() == 0)) {}
    for (paramJSONArray = new ArrayList();; paramJSONArray = cw.a(paramJSONArray, Card.class, e, this))
    {
      Iterator localIterator = paramJSONArray.iterator();
      while (localIterator.hasNext())
      {
        Card localCard = (Card)localIterator.next();
        if (c.contains(localCard.getId()))
        {
          localCard.setViewed(true);
          localCard.setIsRead(true);
        }
        if (d.contains(localCard.getId())) {
          localCard.setIsRead(true);
        }
      }
    }
    return new FeedUpdatedEvent(paramJSONArray, paramString, paramBoolean, paramLong);
  }
  
  public final void a(String paramString)
  {
    if (c.contains(paramString)) {
      return;
    }
    c.add(paramString);
    a(c, ey.b);
  }
  
  public final void a(Set<String> paramSet, ey paramey)
  {
    String str = c;
    paramey = d;
    SharedPreferences.Editor localEditor = b.edit();
    if (Build.VERSION.SDK_INT < 11) {
      if ((paramSet == null) || (paramSet.isEmpty())) {
        localEditor.remove(paramey);
      }
    }
    for (;;)
    {
      localEditor.apply();
      return;
      localEditor.putString(paramey, StringUtils.join(paramSet, ";"));
      continue;
      if ((paramSet == null) || (paramSet.isEmpty())) {
        localEditor.remove(str);
      } else {
        localEditor.putStringSet(str, paramSet);
      }
    }
  }
}

/* Location:
 * Qualified Name:     bo.app.ex
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */