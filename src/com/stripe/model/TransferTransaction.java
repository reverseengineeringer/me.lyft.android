package com.stripe.model;

public class TransferTransaction
  extends StripeObject
{
  Long amount;
  Long created;
  String description;
  Long fee;
  String id;
  Long net;
  String type;
  
  public Long getAmount()
  {
    return amount;
  }
  
  public Long getCreated()
  {
    return created;
  }
  
  public String getDescription()
  {
    return description;
  }
  
  public Long getFee()
  {
    return fee;
  }
  
  public String getId()
  {
    return id;
  }
  
  public Long getNet()
  {
    return net;
  }
  
  public String getType()
  {
    return type;
  }
  
  public void setAmount(Long paramLong)
  {
    amount = paramLong;
  }
  
  public void setCreated(Long paramLong)
  {
    created = paramLong;
  }
  
  public void setDescription(String paramString)
  {
    description = paramString;
  }
  
  public void setFee(Long paramLong)
  {
    fee = paramLong;
  }
  
  public void setId(String paramString)
  {
    id = paramString;
  }
  
  public void setNet(Long paramLong)
  {
    net = paramLong;
  }
  
  public void setType(String paramString)
  {
    type = paramString;
  }
}

/* Location:
 * Qualified Name:     com.stripe.model.TransferTransaction
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */