package me.lyft.android.ui.ridehistory;

import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;
import me.lyft.android.application.IUserProvider;
import me.lyft.android.application.ridehistory.IPassengerRideHistoryService;
import me.lyft.android.application.ridehistory.PassengerRideHistoryService;
import me.lyft.android.domain.ridehistory.PassengerRideHistoryMapper;
import me.lyft.android.infrastructure.lyft.ILyftApi;

@Module(complete=false, injects={PassengerRideHistoryListView.class, PassengerRideHistoryDetailedView.class, PassengerRideHistoryItemView.class, PassengerRideHistoryController.class, PassengerRideHistoryListViewV2.class})
public class RideHistoryModule
{
  @Provides
  @Singleton
  IPassengerRideHistoryService providePassengerHistoryService(ILyftApi paramILyftApi, IUserProvider paramIUserProvider)
  {
    return new PassengerRideHistoryService(paramILyftApi, paramIUserProvider, new PassengerRideHistoryMapper());
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.ridehistory.RideHistoryModule
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */