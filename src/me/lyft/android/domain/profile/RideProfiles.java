package me.lyft.android.domain.profile;

import java.util.HashMap;
import java.util.Map;
import me.lyft.android.common.Objects;

public class RideProfiles
{
  private Map<String, Profile> rideProfiles = new HashMap();
  
  public void add(Profile paramProfile)
  {
    rideProfiles.put(paramProfile.getId(), paramProfile);
  }
  
  public void clear()
  {
    rideProfiles.clear();
  }
  
  public Profile getProfileById(String paramString)
  {
    return (Profile)Objects.firstNonNull(rideProfiles.get(paramString), Profile.empty());
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.profile.RideProfiles
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */