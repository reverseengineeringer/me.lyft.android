package com.stripe.model;

import com.stripe.net.APIResource;

public class Fee
  extends APIResource
{
  Integer amount;
  String application;
  String currency;
  String description;
  String type;
  
  public Integer getAmount()
  {
    return amount;
  }
  
  public String getApplication()
  {
    return application;
  }
  
  public String getCurrency()
  {
    return currency;
  }
  
  public String getDescription()
  {
    return description;
  }
  
  public String getType()
  {
    return type;
  }
  
  public void setAmount(Integer paramInteger)
  {
    amount = paramInteger;
  }
  
  public void setApplication(String paramString)
  {
    application = paramString;
  }
  
  public void setCurrency(String paramString)
  {
    currency = paramString;
  }
  
  public void setDescription(String paramString)
  {
    description = paramString;
  }
  
  public void setType(String paramString)
  {
    type = paramString;
  }
}

/* Location:
 * Qualified Name:     com.stripe.model.Fee
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */