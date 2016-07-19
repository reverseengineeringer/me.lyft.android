package com.stripe.model;

public final class Address
  extends StripeObject
{
  protected String city;
  protected String country;
  protected String line1;
  protected String line2;
  protected String postalCode;
  protected String state;
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (Address)paramObject;
      if (city != null)
      {
        if (city.equals(city)) {}
      }
      else {
        while (city != null) {
          return false;
        }
      }
      if (country != null)
      {
        if (country.equals(country)) {}
      }
      else {
        while (country != null) {
          return false;
        }
      }
      if (line1 != null)
      {
        if (line1.equals(line1)) {}
      }
      else {
        while (line1 != null) {
          return false;
        }
      }
      if (line2 != null)
      {
        if (line2.equals(line2)) {}
      }
      else {
        while (line2 != null) {
          return false;
        }
      }
      if (postalCode != null)
      {
        if (postalCode.equals(postalCode)) {}
      }
      else {
        while (postalCode != null) {
          return false;
        }
      }
      if (state == null) {
        break;
      }
    } while (state.equals(state));
    for (;;)
    {
      return false;
      if (state == null) {
        break;
      }
    }
  }
  
  public String getCity()
  {
    return city;
  }
  
  public String getCountry()
  {
    return country;
  }
  
  public String getLine1()
  {
    return line1;
  }
  
  public String getLine2()
  {
    return line2;
  }
  
  public String getPostalCode()
  {
    return postalCode;
  }
  
  public String getState()
  {
    return state;
  }
  
  public int hashCode()
  {
    int i1 = 0;
    int i;
    int j;
    label33:
    int k;
    label48:
    int m;
    if (line1 != null)
    {
      i = line1.hashCode();
      if (city == null) {
        break label131;
      }
      j = city.hashCode();
      if (country == null) {
        break label136;
      }
      k = country.hashCode();
      if (line2 == null) {
        break label141;
      }
      m = line2.hashCode();
      label64:
      if (postalCode == null) {
        break label147;
      }
    }
    label131:
    label136:
    label141:
    label147:
    for (int n = postalCode.hashCode();; n = 0)
    {
      if (state != null) {
        i1 = state.hashCode();
      }
      return ((((i * 31 + j) * 31 + k) * 31 + m) * 31 + n) * 31 + i1;
      i = 0;
      break;
      j = 0;
      break label33;
      k = 0;
      break label48;
      m = 0;
      break label64;
    }
  }
  
  public Address setCity(String paramString)
  {
    city = paramString;
    return this;
  }
  
  public Address setCountry(String paramString)
  {
    country = paramString;
    return this;
  }
  
  public Address setLine1(String paramString)
  {
    line1 = paramString;
    return this;
  }
  
  public Address setLine2(String paramString)
  {
    line2 = paramString;
    return this;
  }
  
  public Address setPostalCode(String paramString)
  {
    postalCode = paramString;
    return this;
  }
  
  public Address setState(String paramString)
  {
    state = paramString;
    return this;
  }
}

/* Location:
 * Qualified Name:     com.stripe.model.Address
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */