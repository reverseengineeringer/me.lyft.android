package me.lyft.android.domain;

class User$NullUser
  extends User
{
  private static final User INSTANCE = new NullUser();
  
  static User getInstance()
  {
    return INSTANCE;
  }
  
  public boolean isNull()
  {
    return true;
  }
  
  public boolean isUnauthorized()
  {
    return true;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.User.NullUser
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */