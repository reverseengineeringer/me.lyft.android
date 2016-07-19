package me.lyft.android.domain.profile;

import me.lyft.android.common.Strings;

public class MutualFriend
{
  private final String name;
  private final String photo;
  
  public MutualFriend(String paramString1, String paramString2)
  {
    name = Strings.nullToEmpty(paramString1);
    photo = Strings.nullToEmpty(paramString2);
  }
  
  public String getName()
  {
    return name;
  }
  
  public String getPhoto()
  {
    return photo;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.profile.MutualFriend
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */