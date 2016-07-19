package com.stripe.model;

import java.util.Map;

public class EventData
  extends StripeObject
{
  StripeObject object;
  Map<String, Object> previousAttributes;
  
  public StripeObject getObject()
  {
    return object;
  }
  
  public Map<String, Object> getPreviousAttributes()
  {
    return previousAttributes;
  }
  
  public void setObject(StripeObject paramStripeObject)
  {
    object = paramStripeObject;
  }
  
  public void setPreviousAttributes(Map<String, Object> paramMap)
  {
    previousAttributes = paramMap;
  }
}

/* Location:
 * Qualified Name:     com.stripe.model.EventData
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */