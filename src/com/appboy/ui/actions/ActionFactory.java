package com.appboy.ui.actions;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.appboy.support.StringUtils;
import java.util.List;

public class ActionFactory
{
  public static IAction createUriAction(Context paramContext, String paramString)
  {
    return createUriAction(paramContext, paramString, null);
  }
  
  public static IAction createUriAction(Context paramContext, String paramString, Bundle paramBundle)
  {
    if (!StringUtils.isNullOrBlank(paramString))
    {
      Uri localUri = Uri.parse(paramString);
      if (WebAction.getSupportedSchemes().contains(localUri.getScheme())) {
        return new WebAction(paramString, paramBundle);
      }
      if ("intent".equals(localUri.getScheme())) {
        return new ActivityAction(paramContext.getPackageName(), localUri, paramBundle);
      }
      return new ViewAction(localUri, paramBundle);
    }
    return null;
  }
  
  public static IAction createViewUriAction(String paramString, Bundle paramBundle)
  {
    if (!StringUtils.isNullOrBlank(paramString)) {
      return new ViewAction(Uri.parse(paramString), paramBundle);
    }
    return null;
  }
}

/* Location:
 * Qualified Name:     com.appboy.ui.actions.ActionFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */