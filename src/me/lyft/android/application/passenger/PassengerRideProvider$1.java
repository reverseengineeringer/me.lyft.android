package me.lyft.android.application.passenger;

import java.util.List;
import me.lyft.android.common.Objects;
import me.lyft.android.domain.passenger.ride.PassengerRidePassenger;
import me.lyft.android.rx.ReactiveProperty.EqualityComparator;

class PassengerRideProvider$1
  implements ReactiveProperty.EqualityComparator<List<PassengerRidePassenger>>
{
  PassengerRideProvider$1(PassengerRideProvider paramPassengerRideProvider) {}
  
  public boolean equals(List<PassengerRidePassenger> paramList1, List<PassengerRidePassenger> paramList2)
  {
    return Objects.equals(PassengerRideProvider.access$000(this$0, paramList1), PassengerRideProvider.access$000(this$0, paramList2));
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.passenger.PassengerRideProvider.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */