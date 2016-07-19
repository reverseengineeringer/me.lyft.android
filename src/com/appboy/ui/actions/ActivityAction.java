package com.appboy.ui.actions;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.appboy.ui.support.UriUtils;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class ActivityAction
  implements IAction
{
  private final Intent mIntent;
  
  public ActivityAction(Intent paramIntent)
  {
    mIntent = paramIntent;
  }
  
  public ActivityAction(String paramString, Uri paramUri)
  {
    this(paramString, paramUri, null);
  }
  
  public ActivityAction(String paramString, Uri paramUri, Bundle paramBundle)
  {
    this(new Intent());
    mIntent.setClassName(paramString, paramUri.getHost());
    if (paramBundle != null) {
      mIntent.putExtras(paramBundle);
    }
    paramString = UriUtils.getQueryParameters(paramUri).entrySet().iterator();
    while (paramString.hasNext())
    {
      paramUri = (Map.Entry)paramString.next();
      mIntent.putExtra((String)paramUri.getKey(), (String)paramUri.getValue());
    }
  }
  
  public void execute(Context paramContext)
  {
    if (mIntent.resolveActivity(paramContext.getPackageManager()) != null) {
      paramContext.startActivity(mIntent);
    }
  }
}

/* Location:
 * Qualified Name:     com.appboy.ui.actions.ActivityAction
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */