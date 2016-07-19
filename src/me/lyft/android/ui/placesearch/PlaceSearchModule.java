package me.lyft.android.ui.placesearch;

import android.content.res.Resources;
import dagger.Module;
import dagger.Provides;
import me.lyft.android.application.constants.IConstantsProvider;
import me.lyft.android.application.ride.IRideRequestSession;
import me.lyft.android.application.shortcuts.IShortcutService;
import me.lyft.android.application.topdestinations.ITopDestinationsService;
import me.lyft.android.common.AppFlow;
import me.lyft.android.infrastructure.googleplaces.IGooglePlaceService;
import me.lyft.android.infrastructure.location.ILocationService;
import me.lyft.android.infrastructure.lyft.ILyftApi;
import me.lyft.android.infrastructure.placesearch.IPlaceSearchService;
import me.lyft.android.infrastructure.placesearch.PlaceSearchService;
import me.lyft.android.ui.MainScreensRouter;

@Module(complete=false, injects={PassengerSetDropoffSearchView.class, DriverSetDropoffSearchView.class, EditShortcutView.class, PlaceSearchView.class, PlaceSearchToolbar.class, HometownSearchView.class, PickupPlaceSearchView.class, DestinationPlaceSearchView.class, DestinySearchView.class, EditPickupPlaceSearchView.class})
public class PlaceSearchModule
{
  @Provides
  IPlaceSearchPresenter providePlaceSearchPresenter(IGooglePlaceService paramIGooglePlaceService, ILocationService paramILocationService, IShortcutService paramIShortcutService, ITopDestinationsService paramITopDestinationsService, IPlaceSearchService paramIPlaceSearchService, IRideRequestSession paramIRideRequestSession, AppFlow paramAppFlow, Resources paramResources, IConstantsProvider paramIConstantsProvider, MainScreensRouter paramMainScreensRouter)
  {
    return new PlaceSearchPresenter(paramIGooglePlaceService, paramILocationService, paramIShortcutService, paramITopDestinationsService, paramIPlaceSearchService, paramIRideRequestSession, paramAppFlow, paramResources, paramIConstantsProvider, paramMainScreensRouter);
  }
  
  @Provides
  IPlaceSearchService providePlaceSearchService(ILyftApi paramILyftApi, ILocationService paramILocationService)
  {
    return new PlaceSearchService(paramILyftApi, paramILocationService);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.placesearch.PlaceSearchModule
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */