package com.stripe.model;

public final class ShippingDetails
  extends StripeObject
{
  protected Address address;
  protected String name;
  protected String phone;
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (ShippingDetails)paramObject;
      if (address != null)
      {
        if (address.equals(address)) {}
      }
      else {
        while (address != null) {
          return false;
        }
      }
      if (name != null)
      {
        if (name.equals(name)) {}
      }
      else {
        while (name != null) {
          return false;
        }
      }
      if (phone == null) {
        break;
      }
    } while (phone.equals(phone));
    for (;;)
    {
      return false;
      if (phone == null) {
        break;
      }
    }
  }
  
  public Address getAddress()
  {
    return address;
  }
  
  public String getName()
  {
    return name;
  }
  
  public String getPhone()
  {
    return phone;
  }
  
  public int hashCode()
  {
    int k = 0;
    int i;
    if (address != null)
    {
      i = address.hashCode();
      if (name == null) {
        break label64;
      }
    }
    label64:
    for (int j = name.hashCode();; j = 0)
    {
      if (phone != null) {
        k = phone.hashCode();
      }
      return (i * 31 + j) * 31 + k;
      i = 0;
      break;
    }
  }
  
  public void setAddress(Address paramAddress)
  {
    address = paramAddress;
  }
  
  public void setName(String paramString)
  {
    name = paramString;
  }
  
  public void setPhone(String paramString)
  {
    phone = paramString;
  }
}

/* Location:
 * Qualified Name:     com.stripe.model.ShippingDetails
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */