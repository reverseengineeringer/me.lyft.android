package com.stripe.model;

public abstract interface DeletedStripeObject
{
  public abstract Boolean getDeleted();
  
  public abstract String getId();
  
  public abstract void setDeleted(Boolean paramBoolean);
  
  public abstract void setId(String paramString);
}

/* Location:
 * Qualified Name:     com.stripe.model.DeletedStripeObject
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */