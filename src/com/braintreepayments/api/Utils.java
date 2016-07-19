package com.braintreepayments.api;

import com.google.gson.Gson;

public class Utils
{
  private static Gson gson;
  
  private Utils()
  {
    throw new IllegalStateException("Non-instantiable class.");
  }
  
  public static Gson getGson()
  {
    if (gson == null) {
      gson = new Gson();
    }
    return gson;
  }
}

/* Location:
 * Qualified Name:     com.braintreepayments.api.Utils
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */