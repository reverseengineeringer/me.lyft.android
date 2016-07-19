package com.appboy.ui.actions;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

public class ViewAction
  implements IAction
{
  private final Intent mIntent = new Intent("android.intent.action.VIEW");
  
  public ViewAction(Uri paramUri)
  {
    this(paramUri, null);
  }
  
  public ViewAction(Uri paramUri, Bundle paramBundle)
  {
    mIntent.setData(paramUri);
    if (paramBundle != null) {
      mIntent.putExtras(paramBundle);
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
 * Qualified Name:     com.appboy.ui.actions.ViewAction
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */