package bo.app;

import android.content.SharedPreferences;
import com.appboy.Appboy;
import com.appboy.events.FeedUpdatedEvent;
import com.appboy.support.AppboyLogger;
import org.json.JSONArray;
import org.json.JSONException;

public final class b
  implements Runnable
{
  public b(Appboy paramAppboy) {}
  
  public final void run()
  {
    try
    {
      ba localba = Appboy.b(a);
      ex localex = a.b;
      String str = b.getString("uid", "");
      localba.a(localex.a(new JSONArray(b.getString("cards", "[]")), str, true, b.getLong("cards_timestamp", -1L)), FeedUpdatedEvent.class);
      return;
    }
    catch (JSONException localJSONException)
    {
      AppboyLogger.w(Appboy.a(), "Failed to retrieve and publish feed from offline cache.", localJSONException);
    }
  }
}

/* Location:
 * Qualified Name:     bo.app.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */