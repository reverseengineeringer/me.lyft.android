package me.lyft.android.navigation;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import dagger.Lazy;
import java.util.List;
import me.lyft.android.application.constants.Constants;
import me.lyft.android.application.constants.IConstantsProvider;
import me.lyft.android.domain.location.Location;

public class WazeNavigation
  implements Navigator
{
  public static final String WAZE_URI = "market://details?id=com.waze";
  private IConstantsProvider constantsProvider;
  private Context context;
  private Lazy<WazeIntentNavigation> wazeIntentNavigationLazy;
  private Lazy<WazeSDK> wazeSDK;
  
  public WazeNavigation(Context paramContext, IConstantsProvider paramIConstantsProvider, Lazy<WazeSDK> paramLazy, Lazy<WazeIntentNavigation> paramLazy1)
  {
    context = paramContext;
    constantsProvider = paramIConstantsProvider;
    wazeSDK = paramLazy;
    wazeIntentNavigationLazy = paramLazy1;
  }
  
  public void install()
  {
    Intent localIntent = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=com.waze"));
    localIntent.addFlags(268435456);
    context.startActivity(localIntent);
  }
  
  public boolean isInstalled()
  {
    Intent localIntent = new Intent("android.intent.action.VIEW", Uri.parse("waze://?z=8"));
    return !context.getPackageManager().queryIntentActivities(localIntent, 65536).isEmpty();
  }
  
  public void navigate(Location paramLocation)
  {
    if (((Boolean)constantsProvider.get(Constants.WAZE_SDK_ENABLED)).booleanValue())
    {
      ((WazeSDK)wazeSDK.get()).navigate(paramLocation);
      return;
    }
    ((WazeIntentNavigation)wazeIntentNavigationLazy.get()).navigate(paramLocation);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.navigation.WazeNavigation
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */