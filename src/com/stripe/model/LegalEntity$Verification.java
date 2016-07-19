package com.stripe.model;

public class LegalEntity$Verification
  extends StripeObject
{
  String details;
  String document;
  String status;
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (Verification)paramObject;
    } while ((equals(status, status)) && (equals(document, document)) && (equals(details, details)));
    return false;
  }
  
  public String getDetails()
  {
    return details;
  }
  
  public String getDocument()
  {
    return document;
  }
  
  public String getStatus()
  {
    return status;
  }
}

/* Location:
 * Qualified Name:     com.stripe.model.LegalEntity.Verification
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */