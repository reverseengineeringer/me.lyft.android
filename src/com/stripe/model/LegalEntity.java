package com.stripe.model;

import java.util.List;

public class LegalEntity
  extends StripeObject
{
  List<Owner> additionalOwners;
  Address address;
  String businessName;
  DateOfBirth dob;
  String firstName;
  String lastName;
  Address personalAddress;
  String type;
  Verification verification;
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (LegalEntity)paramObject;
    } while ((equals(type, type)) && (equals(address, address)) && (equals(businessName, businessName)) && (equals(dob, dob)) && (equals(firstName, firstName)) && (equals(lastName, lastName)) && (equals(personalAddress, personalAddress)) && (equals(verification, verification)) && (equals(additionalOwners, additionalOwners)));
    return false;
  }
  
  public List<Owner> getAdditionalOwners()
  {
    return additionalOwners;
  }
  
  public Address getAddress()
  {
    return address;
  }
  
  public String getBusinessName()
  {
    return businessName;
  }
  
  public DateOfBirth getDob()
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
  
  public Address getPersonalAddress()
  {
    return personalAddress;
  }
  
  public String getType()
  {
    return type;
  }
  
  public Verification getVerification()
  {
    return verification;
  }
  
  public static class DateOfBirth
    extends StripeObject
  {
    Integer day;
    Integer month;
    Integer year;
    
    public boolean equals(Object paramObject)
    {
      if (this == paramObject) {}
      do
      {
        return true;
        if ((paramObject == null) || (getClass() != paramObject.getClass())) {
          return false;
        }
        paramObject = (DateOfBirth)paramObject;
      } while ((equals(day, day)) && (equals(month, month)) && (equals(year, year)));
      return false;
    }
    
    public Integer getDay()
    {
      return day;
    }
    
    public Integer getMonth()
    {
      return month;
    }
    
    public Integer getYear()
    {
      return year;
    }
  }
  
  public static class Owner
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
  
  public static class Verification
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
}

/* Location:
 * Qualified Name:     com.stripe.model.LegalEntity
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */