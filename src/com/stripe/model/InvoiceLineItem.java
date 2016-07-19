package com.stripe.model;

import java.util.Map;

public class InvoiceLineItem
  extends StripeObject
{
  Integer amount;
  String currency;
  String description;
  String id;
  Boolean livemode;
  Map<String, String> metadata;
  InvoiceLineItemPeriod period;
  Plan plan;
  Boolean proration;
  Integer quantity;
  String subscription;
  String type;
  
  public Integer getAmount()
  {
    return amount;
  }
  
  public String getCurrency()
  {
    return currency;
  }
  
  public String getDescription()
  {
    return description;
  }
  
  public String getId()
  {
    return id;
  }
  
  public Boolean getLivemode()
  {
    return livemode;
  }
  
  public Map<String, String> getMetadata()
  {
    return metadata;
  }
  
  public InvoiceLineItemPeriod getPeriod()
  {
    return period;
  }
  
  public Plan getPlan()
  {
    return plan;
  }
  
  public Boolean getProration()
  {
    return proration;
  }
  
  public Integer getQuantity()
  {
    return quantity;
  }
  
  public String getSubscription()
  {
    return subscription;
  }
  
  public String getType()
  {
    return type;
  }
}

/* Location:
 * Qualified Name:     com.stripe.model.InvoiceLineItem
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */