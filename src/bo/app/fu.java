package bo.app;

import android.content.Context;
import com.appboy.Appboy;
import com.appboy.AppboyUser;
import com.appboy.events.InAppMessageEvent;
import com.appboy.models.IInAppMessage;
import com.appboy.support.StringUtils;
import org.json.JSONObject;

final class fu
  implements Runnable
{
  fu(ft paramft, JSONObject paramJSONObject, bd parambd, Context paramContext) {}
  
  public final void run()
  {
    ft.f();
    String.format("Attempting to publish in-app message after delay of %d seconds.", new Object[] { Integer.valueOf(d.b.d()) });
    IInAppMessage localIInAppMessage = fj.a(a, ft.a(d));
    if (!StringUtils.isNullOrBlank(ft.b(d))) {
      localIInAppMessage.setLocalAssetPathForPrefetch(ft.b(d));
    }
    b.a(new InAppMessageEvent(localIInAppMessage, Appboy.getInstance(c).getCurrentUser().getUserId()), InAppMessageEvent.class);
  }
}

/* Location:
 * Qualified Name:     bo.app.fu
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */