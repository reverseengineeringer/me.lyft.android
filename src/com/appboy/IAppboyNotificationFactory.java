package com.appboy;

import android.app.Notification;
import android.content.Context;
import android.os.Bundle;
import com.appboy.configuration.XmlAppConfigurationProvider;

public abstract interface IAppboyNotificationFactory
{
  public abstract Notification createNotification(XmlAppConfigurationProvider paramXmlAppConfigurationProvider, Context paramContext, Bundle paramBundle1, Bundle paramBundle2);
}

/* Location:
 * Qualified Name:     com.appboy.IAppboyNotificationFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */