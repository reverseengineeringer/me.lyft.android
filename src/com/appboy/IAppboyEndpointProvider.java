package com.appboy;

import android.net.Uri;

public abstract interface IAppboyEndpointProvider
{
  public abstract Uri getApiEndpoint(Uri paramUri);
  
  public abstract Uri getResourceEndpoint(Uri paramUri);
}

/* Location:
 * Qualified Name:     com.appboy.IAppboyEndpointProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */