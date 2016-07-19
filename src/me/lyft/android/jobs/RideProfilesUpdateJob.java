package me.lyft.android.jobs;

import com.lyft.android.api.dto.RideDTO;
import com.lyft.android.api.dto.UserDTO;
import javax.inject.Inject;
import me.lyft.android.application.profile.IRideProfileService;
import me.lyft.android.domain.profile.RideProfileMapper;
import me.lyft.android.domain.profile.RideProfiles;

public class RideProfilesUpdateJob
  implements Job
{
  private RideDTO rideDTO;
  @Inject
  IRideProfileService rideProfileService;
  private UserDTO userDTO;
  
  public RideProfilesUpdateJob(RideDTO paramRideDTO, UserDTO paramUserDTO)
  {
    userDTO = paramUserDTO;
    rideDTO = paramRideDTO;
  }
  
  public void execute()
    throws Throwable
  {
    RideProfiles localRideProfiles = RideProfileMapper.fromRide(rideDTO, userDTO);
    rideProfileService.updateRideProfiles(localRideProfiles);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.jobs.RideProfilesUpdateJob
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */