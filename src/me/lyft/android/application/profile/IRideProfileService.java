package me.lyft.android.application.profile;

import me.lyft.android.domain.profile.Profile;
import me.lyft.android.domain.profile.RideProfiles;
import rx.Observable;

public abstract interface IRideProfileService
{
  public abstract Observable<Profile> fetchProfileById(String paramString);
  
  public abstract void updateRideProfiles(RideProfiles paramRideProfiles);
}

/* Location:
 * Qualified Name:     me.lyft.android.application.profile.IRideProfileService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */