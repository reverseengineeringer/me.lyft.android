package io.fabric.sdk.android.services.network;

import java.util.Map;

public abstract interface HttpRequestFactory
{
  public abstract HttpRequest buildHttpRequest(HttpMethod paramHttpMethod, String paramString, Map<String, String> paramMap);
  
  public abstract void setPinningInfoProvider(PinningInfoProvider paramPinningInfoProvider);
}

/* Location:
 * Qualified Name:     io.fabric.sdk.android.services.network.HttpRequestFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */