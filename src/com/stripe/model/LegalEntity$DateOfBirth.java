package com.stripe.model;

public class LegalEntity$DateOfBirth
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

/* Location:
 * Qualified Name:     com.stripe.model.LegalEntity.DateOfBirth
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */