package me.lyft.android.domain.profile;

import com.lyft.android.api.dto.PermissionsDTO;
import com.lyft.android.api.dto.UserDTO;
import java.util.Collections;
import java.util.List;
import me.lyft.android.common.Objects;

public class ProfileMapper
{
  public static final int ABOUT_INDEX = 2;
  public static final int HOMETOWN_INDEX = 0;
  public static final int MUSIC_INDEX = 1;
  
  public static Profile fromUserDTO(UserDTO paramUserDTO)
  {
    if (paramUserDTO == null) {
      return Profile.empty();
    }
    Profile localProfile = new Profile();
    localProfile.setId(id);
    localProfile.setSelf(true);
    localProfile.setFirstName(firstName);
    localProfile.setPhotoUrl(userPhoto);
    localProfile.setDriverRating(((Double)Objects.firstNonNull(driverRating, Double.valueOf(0.0D))).doubleValue());
    List localList = (List)Objects.firstNonNull(profileFields, Collections.emptyList());
    localProfile.setHometown(getProfileValue(localList, 0));
    localProfile.setFavoriteMusic(getProfileValue(localList, 1));
    localProfile.setAboutMe(getProfileValue(localList, 2));
    localProfile.setJoinDate(joinDate);
    if (permissions != null) {
      localProfile.setCanShowMutualFriends(permissions.canShowMutualFriends.booleanValue());
    }
    localProfile.setMutualFriends(Collections.emptyList());
    return localProfile;
  }
  
  public static String getProfileValue(List<String> paramList, int paramInt)
  {
    if (paramList == null) {
      return "";
    }
    if (paramList.size() > paramInt) {
      return (String)paramList.get(paramInt);
    }
    return "";
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.profile.ProfileMapper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */