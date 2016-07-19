package me.lyft.android.domain.profile;

import java.util.Collections;
import java.util.List;
import me.lyft.android.common.INullable;
import me.lyft.android.common.Objects;
import me.lyft.android.common.Strings;

public class Profile
  implements INullable
{
  private String aboutMe;
  private String additionalMutualFriendsCount;
  private boolean canShowMutualFriends;
  private double driverRating;
  private String favoriteMusic;
  private String firstName;
  private String hometown;
  private String id;
  private String joinDate;
  private List<MutualFriend> mutualFriends;
  private String navigationAppId;
  private String photoUrl;
  private String profileOverride;
  private boolean self;
  
  public static Profile empty()
  {
    return NullProfile.INSTANCE;
  }
  
  public String getAboutMe()
  {
    return Strings.nullToEmpty(aboutMe);
  }
  
  public String getAdditionalMutualFriendsCount()
  {
    return (String)Objects.firstNonNull(additionalMutualFriendsCount, "");
  }
  
  public double getDriverRating()
  {
    return driverRating;
  }
  
  public String getFavoriteMusic()
  {
    return Strings.nullToEmpty(favoriteMusic);
  }
  
  public String getFirstName()
  {
    return firstName;
  }
  
  public String getHometown()
  {
    return Strings.nullToEmpty(hometown);
  }
  
  public String getId()
  {
    return id;
  }
  
  public String getJoinDate()
  {
    return joinDate;
  }
  
  public List<MutualFriend> getMutualFriends()
  {
    return (List)Objects.firstNonNull(mutualFriends, Collections.emptyList());
  }
  
  public String getPhotoUrl()
  {
    return photoUrl;
  }
  
  public String getProfileOverride()
  {
    return profileOverride;
  }
  
  public boolean hasMutualFriends()
  {
    return !getMutualFriends().isEmpty();
  }
  
  public boolean hasProfileOverride()
  {
    return !Strings.isNullOrEmpty(profileOverride);
  }
  
  public boolean isCanShowMutualFriends()
  {
    return canShowMutualFriends;
  }
  
  public boolean isNull()
  {
    return false;
  }
  
  public boolean isSelf()
  {
    return self;
  }
  
  public boolean isUsingWaze()
  {
    return Objects.equals(navigationAppId, "waze");
  }
  
  public void setAboutMe(String paramString)
  {
    aboutMe = paramString;
  }
  
  void setAdditionalMutualFriendsCount(String paramString)
  {
    additionalMutualFriendsCount = paramString;
  }
  
  public void setCanShowMutualFriends(boolean paramBoolean)
  {
    canShowMutualFriends = paramBoolean;
  }
  
  public void setDriverRating(double paramDouble)
  {
    driverRating = paramDouble;
  }
  
  public void setFavoriteMusic(String paramString)
  {
    favoriteMusic = paramString;
  }
  
  void setFirstName(String paramString)
  {
    firstName = paramString;
  }
  
  public void setHometown(String paramString)
  {
    hometown = paramString;
  }
  
  public void setId(String paramString)
  {
    id = paramString;
  }
  
  public void setJoinDate(String paramString)
  {
    joinDate = paramString;
  }
  
  void setMutualFriends(List<MutualFriend> paramList)
  {
    mutualFriends = paramList;
  }
  
  public void setNavigationAppId(String paramString)
  {
    navigationAppId = paramString;
  }
  
  void setPhotoUrl(String paramString)
  {
    photoUrl = paramString;
  }
  
  public void setProfileOverride(String paramString)
  {
    profileOverride = paramString;
  }
  
  void setSelf(boolean paramBoolean)
  {
    self = paramBoolean;
  }
  
  static class NullProfile
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
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.profile.Profile
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */