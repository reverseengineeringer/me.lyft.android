package com.appboy;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

public abstract interface IAppboyNavigator
{
  public abstract void gotoNewsFeed(Context paramContext, Bundle paramBundle);
  
  public abstract void gotoURI(Context paramContext, Uri paramUri, Bundle paramBundle);
}

/* Location:
 * Qualified Name:     com.appboy.IAppboyNavigator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */