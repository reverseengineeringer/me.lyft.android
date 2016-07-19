package me.lyft.android.application.profile;

import me.lyft.android.domain.profile.Profile;
import me.lyft.android.domain.profile.RideProfiles;
import rx.Observable;

public class RideProfileService
  implements IRideProfileService
{
  private RideProfiles rideProfiles = new RideProfiles();
  
  public Observable<Profile> fetchProfileById(String paramString)
  {
    return Observable.just(rideProfiles.getProfileById(paramString));
  }
  
  public void updateRideProfiles(RideProfiles paramRideProfiles)
  {
    rideProfiles = paramRideProfiles;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.profile.RideProfileService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */