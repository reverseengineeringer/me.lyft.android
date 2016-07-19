package com.crashlytics.android.core;

public class UserMetaData
{
  public static final UserMetaData EMPTY = new UserMetaData();
  public final String email;
  public final String id;
  public final String name;
  
  public UserMetaData()
  {
    this(null, null, null);
  }
  
  public UserMetaData(String paramString1, String paramString2, String paramString3)
  {
    id = paramString1;
    name = paramString2;
    email = paramString3;
  }
  
  public boolean isEmpty()
  {
    return (id == null) && (name == null) && (email == null);
  }
}

/* Location:
 * Qualified Name:     com.crashlytics.android.core.UserMetaData
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */