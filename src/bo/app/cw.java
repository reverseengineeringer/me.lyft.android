package bo.app;

import com.appboy.Constants;
import com.appboy.models.cards.BannerImageCard;
import com.appboy.models.cards.CaptionedImageCard;
import com.appboy.models.cards.Card;
import com.appboy.models.cards.CrossPromotionSmallCard;
import com.appboy.models.cards.ShortNewsCard;
import com.appboy.models.cards.TextAnnouncementCard;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class cw
{
  private static final String a = String.format("%s.%s", new Object[] { Constants.APPBOY_LOG_TAG_PREFIX, cw.class.getName() });
  
  public static <T> List<T> a(JSONArray paramJSONArray, Class<T> paramClass, by paramby, ex paramex)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    for (;;)
    {
      if (i < paramJSONArray.length())
      {
        String str;
        Object localObject2;
        for (;;)
        {
          try
          {
            Object localObject1 = paramJSONArray.optString(i);
            if (paramClass.equals(String.class))
            {
              localObject1 = ff.a(localObject1, paramClass);
              if (localObject1 == null) {
                break label320;
              }
              localArrayList.add(localObject1);
              break label320;
            }
            if (!paramClass.equals(Card.class)) {
              break label288;
            }
            localObject1 = new JSONObject((String)localObject1);
            str = ((JSONObject)localObject1).getString("type");
            if ("banner_image".equals(str))
            {
              localObject1 = new BannerImageCard((JSONObject)localObject1, paramby, paramex);
              localObject1 = ff.a(localObject1, paramClass);
              continue;
            }
            if ("captioned_image".equals(str))
            {
              localObject1 = new CaptionedImageCard((JSONObject)localObject1, paramby, paramex);
              continue;
            }
            if (!"cross_promotion_small".equals(str)) {
              break label206;
            }
          }
          catch (JSONException localJSONException)
          {
            localObject2 = a;
            String.format("Unable to cast JSON to [%s] in array. Ignoring.", new Object[] { paramClass.getName() });
          }
          localObject2 = new CrossPromotionSmallCard((JSONObject)localObject2, paramby, paramex);
          continue;
          label206:
          if ("short_news".equals(str))
          {
            localObject2 = new ShortNewsCard((JSONObject)localObject2, paramby, paramex);
          }
          else
          {
            if (!"text_announcement".equals(str)) {
              break;
            }
            localObject2 = new TextAnnouncementCard((JSONObject)localObject2, paramby, paramex);
          }
        }
        throw new JSONException(String.format("Failed to construct java object of type %s from JSON [%s]", new Object[] { str, ((JSONObject)localObject2).toString() }));
        label288:
        throw new JSONException(String.format("Failed to construct java object %s, target class %s isn'tString nor Card. Please update the createObject in ModelFactory to handle extra class type.", new Object[] { localObject2, paramClass.toString() }));
      }
      return localArrayList;
      label320:
      i += 1;
    }
  }
}

/* Location:
 * Qualified Name:     bo.app.cw
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */