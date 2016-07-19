package com.braintreepayments.api.models;

import java.util.Map;

public abstract interface PaymentMethod$Builder<T extends PaymentMethod>
{
  public static final String METADATA_KEY = "_meta";
  
  public abstract T build();
  
  public abstract T fromJson(String paramString);
  
  public abstract String getApiPath();
  
  public abstract String getApiResource();
  
  public abstract Builder<T> integration(String paramString);
  
  public abstract Builder<T> source(String paramString);
  
  @Deprecated
  public abstract Map<String, Object> toJson();
  
  public abstract String toJsonString();
  
  public abstract Builder<T> validate(boolean paramBoolean);
}

/* Location:
 * Qualified Name:     com.braintreepayments.api.models.PaymentMethod.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */