package com.squareup.picasso;

import android.annotation.TargetApi;
import android.app.ActivityManager;

@TargetApi(11)
class Utils$ActivityManagerHoneycomb
{
  static int getLargeMemoryClass(ActivityManager paramActivityManager)
  {
    return paramActivityManager.getLargeMemoryClass();
  }
}

/* Location:
 * Qualified Name:     com.squareup.picasso.Utils.ActivityManagerHoneycomb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */