package com.stripe.model;

public class LegalEntity$Owner
  extends StripeObject
{
  Address address;
  LegalEntity.DateOfBirth dob;
  String firstName;
  String lastName;
  LegalEntity.Verification verification;
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (Owner)paramObject;
    } while ((equals(address, address)) && (equals(dob, dob)) && (equals(firstName, firstName)) && (equals(lastName, lastName)) && (equals(verification, verification)));
    return false;
  }
  
  public Address getAddress()
  {
    return address;
  }
  
  public LegalEntity.DateOfBirth getDob()
  {
    return dob;
  }
  
  public String getFirstName()
  {
    return firstName;
  }
  
  public String getLastName()
  {
    return lastName;
  }
  
  public LegalEntity.Verification getVerification()
  {
    return verification;
  }
}

/* Location:
 * Qualified Name:     com.stripe.model.LegalEntity.Owner
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */