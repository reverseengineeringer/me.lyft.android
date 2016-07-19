package com.stripe.model;

import java.util.List;

public class Account$Verification
  extends StripeObject
{
  Boolean contacted;
  Long dueBy;
  List<String> fieldsNeeded;
  
  public Boolean getContacted()
  {
    return contacted;
  }
  
  public Long getDueBy()
  {
    return dueBy;
  }
  
  public List<String> getFieldsNeeded()
  {
    return fieldsNeeded;
  }
}

/* Location:
 * Qualified Name:     com.stripe.model.Account.Verification
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */