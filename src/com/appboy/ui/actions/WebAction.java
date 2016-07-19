package com.appboy.ui.actions;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.appboy.support.AppboyFileUtils;
import com.appboy.ui.AppboyWebViewActivity;
import java.util.List;

public final class WebAction
  implements IAction
{
  private final Bundle mExtras;
  private final String mTargetUrl;
  
  public WebAction(String paramString)
  {
    this(paramString, null);
  }
  
  public WebAction(String paramString, Bundle paramBundle)
  {
    mTargetUrl = paramString;
    mExtras = paramBundle;
  }
  
  public static List<String> getSupportedSchemes()
  {
    return AppboyFileUtils.REMOTE_SCHEMES;
  }
  
  public void execute(Context paramContext)
  {
    Intent localIntent = new Intent(paramContext, AppboyWebViewActivity.class);
    if (mExtras != null) {
      localIntent.putExtras(mExtras);
    }
    localIntent.putExtra("url", mTargetUrl);
    paramContext.startActivity(localIntent);
  }
}

/* Location:
 * Qualified Name:     com.appboy.ui.actions.WebAction
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */