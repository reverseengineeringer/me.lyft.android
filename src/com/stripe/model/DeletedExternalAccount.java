package com.stripe.model;

public class DeletedExternalAccount
  extends StripeObject
  implements DeletedStripeObject
{
  Boolean deleted;
  String id;
  
  public Boolean getDeleted()
  {
    return deleted;
  }
  
  public String getId()
  {
    return id;
  }
  
  public void setDeleted(Boolean paramBoolean)
  {
    deleted = paramBoolean;
  }
  
  public void setId(String paramString)
  {
    id = paramString;
  }
}

/* Location:
 * Qualified Name:     com.stripe.model.DeletedExternalAccount
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */