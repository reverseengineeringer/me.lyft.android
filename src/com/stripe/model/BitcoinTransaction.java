package com.stripe.model;

import com.stripe.net.APIResource;

public class BitcoinTransaction
  extends APIResource
{
  Integer amount;
  Integer bitcoinAmount;
  Long created;
  String currency;
  String customer;
  String id;
  String receiver;
  
  public Integer getAmount()
  {
    return amount;
  }
  
  public Integer getBitcoinAmount()
  {
    return bitcoinAmount;
  }
  
  public Long getCreated()
  {
    return created;
  }
  
  public String getCurrency()
  {
    return currency;
  }
  
  public String getCustomer()
  {
    return customer;
  }
  
  public String getId()
  {
    return id;
  }
  
  public String getReceiver()
  {
    return receiver;
  }
  
  public void setAmount(Integer paramInteger)
  {
    amount = paramInteger;
  }
  
  public void setBitcoinAmount(Integer paramInteger)
  {
    bitcoinAmount = paramInteger;
  }
  
  public void setCreated(Long paramLong)
  {
    created = paramLong;
  }
  
  public void setCurrency(String paramString)
  {
    currency = paramString;
  }
  
  public void setCustomer(String paramString)
  {
    customer = paramString;
  }
  
  public void setId(String paramString)
  {
    id = paramString;
  }
  
  public void setReceiver(String paramString)
  {
    receiver = paramString;
  }
}

/* Location:
 * Qualified Name:     com.stripe.model.BitcoinTransaction
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */