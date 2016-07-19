package me.lyft.android.ui.passenger.v2.pending;

import dagger.Module;
import me.lyft.android.ui.ride.PassengerRideModule;

@Module(addsTo=PassengerRideModule.class, injects={CourierMatchingView.class, ClassicMatchingView.class, CarpoolMatchingView.class, MatchingPlaceholderRideTypeView.class, MatchingFooterView.class})
public class PendingModule {}

/* Location:
 * Qualified Name:     me.lyft.android.ui.passenger.v2.pending.PendingModule
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */