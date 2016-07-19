package me.lyft.android.domain;

class Phone$NullPhone
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

/* Location:
 * Qualified Name:     me.lyft.android.domain.Phone.NullPhone
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */