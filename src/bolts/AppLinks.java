package bolts;

import android.content.Intent;
import android.os.Bundle;

public final class AppLinks
{
  public static Bundle getAppLinkData(Intent paramIntent)
  {
    return paramIntent.getBundleExtra("al_applink_data");
  }
  
  public static Bundle getAppLinkExtras(Intent paramIntent)
  {
    paramIntent = getAppLinkData(paramIntent);
    if (paramIntent == null) {
      return null;
    }
    return paramIntent.getBundle("extras");
  }
}

/* Location:
 * Qualified Name:     bolts.AppLinks
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */