package me.lyft.android.domain.profile;

import java.util.Collections;
import java.util.List;

class Profile$NullProfile
  extends Profile
{
  public static final NullProfile INSTANCE = new NullProfile();
  
  public String getAboutMe()
  {
    return "";
  }
  
  public String getAdditionalMutualFriendsCount()
  {
    return "";
  }
  
  public String getFavoriteMusic()
  {
    return "";
  }
  
  public String getFirstName()
  {
    return "";
  }
  
  public String getHometown()
  {
    return "";
  }
  
  public String getJoinDate()
  {
    return "";
  }
  
  public List<MutualFriend> getMutualFriends()
  {
    return Collections.emptyList();
  }
  
  public String getPhotoUrl()
  {
    return "";
  }
  
  public boolean hasMutualFriends()
  {
    return false;
  }
  
  public boolean isCanShowMutualFriends()
  {
    return false;
  }
  
  public final boolean isNull()
  {
    return true;
  }
  
  public boolean isSelf()
  {
    return false;
  }
  
  public void setAboutMe(String paramString) {}
  
  void setAdditionalMutualFriendsCount(String paramString) {}
  
  public void setCanShowMutualFriends(boolean paramBoolean) {}
  
  public void setFavoriteMusic(String paramString) {}
  
  void setFirstName(String paramString) {}
  
  public void setHometown(String paramString) {}
  
  public void setJoinDate(String paramString) {}
  
  void setMutualFriends(List<MutualFriend> paramList) {}
  
  void setPhotoUrl(String paramString) {}
  
  void setSelf(boolean paramBoolean) {}
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.profile.Profile.NullProfile
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */