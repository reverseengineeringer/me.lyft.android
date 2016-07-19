package me.lyft.android.jobs;

import com.lyft.android.api.dto.RideDTO;
import javax.inject.Inject;
import me.lyft.android.domain.passenger.ride.PassengerRideReceipt;
import me.lyft.android.domain.passenger.ride.PassengerRideReceiptMapper;
import me.lyft.android.persistence.ride.IPassengerRideReceiptService;

public class UpdatePassengerRideReceiptJob
  implements Job
{
  final RideDTO ride;
  @Inject
  IPassengerRideReceiptService rideFareRepository;
  
  public UpdatePassengerRideReceiptJob(RideDTO paramRideDTO)
  {
    ride = paramRideDTO;
  }
  
  public void execute()
    throws Throwable
  {
    if (ride == null) {
      return;
    }
    PassengerRideReceipt localPassengerRideReceipt = PassengerRideReceiptMapper.from(ride);
    rideFareRepository.update(localPassengerRideReceipt);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.jobs.UpdatePassengerRideReceiptJob
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */