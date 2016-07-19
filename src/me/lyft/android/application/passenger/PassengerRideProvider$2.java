package me.lyft.android.application.passenger;

import me.lyft.android.common.Strings;
import me.lyft.android.domain.passenger.ride.Driver;
import me.lyft.android.rx.ReactiveProperty.EqualityComparator;

class PassengerRideProvider$2
  implements ReactiveProperty.EqualityComparator<Driver>
{
  PassengerRideProvider$2(PassengerRideProvider paramPassengerRideProvider) {}
  
  public boolean equals(Driver paramDriver1, Driver paramDriver2)
  {
    return Strings.equalsIgnoreCase(paramDriver1.getId(), paramDriver2.getId());
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.passenger.PassengerRideProvider.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */