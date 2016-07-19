package com.leanplum;

import android.os.Bundle;
import android.support.v4.app.NotificationCompat.Builder;

public abstract interface LeanplumPushNotificationCustomizer
{
  public abstract void customize(NotificationCompat.Builder paramBuilder, Bundle paramBundle);
}

/* Location:
 * Qualified Name:     com.leanplum.LeanplumPushNotificationCustomizer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */