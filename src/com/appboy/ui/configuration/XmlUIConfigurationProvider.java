package com.appboy.ui.configuration;

import android.content.Context;
import com.appboy.configuration.CachedConfigurationProvider;

public class XmlUIConfigurationProvider
  extends CachedConfigurationProvider
{
  private static final String APPLICATION_ICON_KEY = "application_icon";
  private final Context mContext;
  
  public XmlUIConfigurationProvider(Context paramContext)
  {
    super(paramContext);
    mContext = paramContext;
  }
}

/* Location:
 * Qualified Name:     com.appboy.ui.configuration.XmlUIConfigurationProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */