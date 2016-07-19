package com.stripe.model;

import com.stripe.exception.APIConnectionException;
import com.stripe.exception.APIException;
import com.stripe.exception.AuthenticationException;
import com.stripe.exception.CardException;
import com.stripe.exception.InvalidRequestException;
import com.stripe.net.RequestOptions;
import java.util.Map;

public abstract interface MetadataStore<T>
{
  public abstract Map<String, String> getMetadata();
  
  public abstract MetadataStore<T> update(Map<String, Object> paramMap)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException;
  
  public abstract MetadataStore<T> update(Map<String, Object> paramMap, RequestOptions paramRequestOptions)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException;
}

/* Location:
 * Qualified Name:     com.stripe.model.MetadataStore
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */