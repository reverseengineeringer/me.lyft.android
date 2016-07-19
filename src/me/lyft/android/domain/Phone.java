package me.lyft.android.domain;

import me.lyft.android.common.INullable;

public class Phone
  implements INullable
{
  Boolean existingUsersOnly;
  String number;
  Integer verificationCode;
  Boolean verificationNeeded;
  
  public Phone() {}
  
  public Phone(String paramString, Integer paramInteger, Boolean paramBoolean1, Boolean paramBoolean2)
  {
    number = paramString;
    verificationCode = paramInteger;
    verificationNeeded = paramBoolean1;
    existingUsersOnly = paramBoolean2;
  }
  
  public static Phone empty()
  {
    return NullPhone.getInstance();
  }
  
  public Boolean getExistingUsersOnly()
  {
    return existingUsersOnly;
  }
  
  public String getNumber()
  {
    return number;
  }
  
  public Integer getVerificationCode()
  {
    return verificationCode;
  }
  
  public Boolean getVerificationNeeded()
  {
    return verificationNeeded;
  }
  
  public boolean isNull()
  {
    return false;
  }
  
  public boolean isVerificationNeeded()
  {
    if (verificationNeeded == null) {
      return true;
    }
    return verificationNeeded.booleanValue();
  }
  
  public void setExistingUsersOnly(Boolean paramBoolean)
  {
    existingUsersOnly = paramBoolean;
  }
  
  public void setNumber(String paramString)
  {
    number = paramString;
  }
  
  public void setVerificationCode(Integer paramInteger)
  {
    verificationCode = paramInteger;
  }
  
  public void setVerificationNeeded(boolean paramBoolean)
  {
    verificationNeeded = Boolean.valueOf(paramBoolean);
  }
  
  static class NullPhone
    extends Phone
  {
    private static Phone INSTANCE = new NullPhone();
    
    static Phone getInstance()
    {
      return INSTANCE;
    }
    
    public boolean isNull()
    {
      return true;
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.Phone
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */