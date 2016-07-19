package me.lyft.android.domain.profile;

import com.lyft.android.api.dto.MutualFriendDTO;
import com.lyft.android.api.dto.PermissionsDTO;
import com.lyft.android.api.dto.PresignedPhotoUrlDTO;
import com.lyft.android.api.dto.RideDTO;
import com.lyft.android.api.dto.RideUserDTO;
import com.lyft.android.api.dto.RouteDTO;
import com.lyft.android.api.dto.UpdateUserRequestBuilder;
import com.lyft.android.api.dto.UpdateUserRequestDTO;
import com.lyft.android.api.dto.UserDTO;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import me.lyft.android.common.Objects;
import me.lyft.android.common.Strings;

public class RideProfileMapper
{
  public static UpdateUserRequestDTO asUserDTOForUpdateProfile(Profile paramProfile, PresignedPhotoUrlDTO paramPresignedPhotoUrlDTO)
  {
    PermissionsDTO localPermissionsDTO = new PermissionsDTO(Boolean.valueOf(paramProfile.isCanShowMutualFriends()));
    ArrayList localArrayList = new ArrayList(3);
    localArrayList.add(0, paramProfile.getHometown());
    localArrayList.add(1, paramProfile.getFavoriteMusic());
    localArrayList.add(2, paramProfile.getAboutMe());
    return new UpdateUserRequestBuilder().withProfileFields(localArrayList).withPermissions(localPermissionsDTO).withImage(paramPresignedPhotoUrlDTO).build();
  }
  
  static List<MutualFriend> fromMutualFriendsDTO(List<MutualFriendDTO> paramList)
  {
    ArrayList localArrayList = new ArrayList(paramList.size());
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      MutualFriendDTO localMutualFriendDTO = (MutualFriendDTO)paramList.next();
      localArrayList.add(new MutualFriend(Strings.nullToEmpty(name), Strings.nullToEmpty(photo)));
    }
    return localArrayList;
  }
  
  public static RideProfiles fromRide(RideDTO paramRideDTO, UserDTO paramUserDTO)
  {
    RideProfiles localRideProfiles = new RideProfiles();
    if ((paramRideDTO == null) || (route == null)) {}
    for (;;)
    {
      return localRideProfiles;
      paramUserDTO = id;
      if (route.driver != null) {
        localRideProfiles.add(fromRideUserDTO(route.driver, "", paramUserDTO));
      }
      if (route.passengers != null)
      {
        paramRideDTO = route.passengers.iterator();
        while (paramRideDTO.hasNext()) {
          localRideProfiles.add(fromRideUserDTO((RideUserDTO)paramRideDTO.next(), "", paramUserDTO));
        }
      }
    }
  }
  
  public static Profile fromRideUserDTO(RideUserDTO paramRideUserDTO, String paramString1, String paramString2)
  {
    if (paramRideUserDTO == null) {
      return Profile.empty();
    }
    Profile localProfile = new Profile();
    localProfile.setId(id);
    localProfile.setSelf(Objects.equals(paramString2, id));
    localProfile.setFirstName(firstName);
    localProfile.setPhotoUrl(userPhoto);
    localProfile.setDriverRating(((Double)Objects.firstNonNull(driverRating, Double.valueOf(0.0D))).doubleValue());
    paramString2 = (List)Objects.firstNonNull(profileFields, Collections.emptyList());
    localProfile.setHometown(ProfileMapper.getProfileValue(paramString2, 0));
    localProfile.setFavoriteMusic(ProfileMapper.getProfileValue(paramString2, 1));
    localProfile.setAboutMe(ProfileMapper.getProfileValue(paramString2, 2));
    localProfile.setJoinDate(joinDate);
    localProfile.setCanShowMutualFriends(((Boolean)Objects.firstNonNull(firstNonNullpermissions, new PermissionsDTO(Boolean.valueOf(false)))).canShowMutualFriends, Boolean.valueOf(false))).booleanValue());
    localProfile.setAdditionalMutualFriendsCount(Strings.nullToEmpty(additionalMutualFriendsCount));
    localProfile.setMutualFriends(fromMutualFriendsDTO((List)Objects.firstNonNull(mutualFriends, Collections.emptyList())));
    localProfile.setNavigationAppId(paramString1);
    localProfile.setProfileOverride(profileOverride);
    return localProfile;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.profile.RideProfileMapper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */