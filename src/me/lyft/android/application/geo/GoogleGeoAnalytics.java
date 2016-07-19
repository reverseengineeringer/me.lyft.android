package me.lyft.android.application.geo;

import me.lyft.android.analytics.core.CallAnalytics;
import me.lyft.android.analytics.core.events.CallEvent.Call;

public class GoogleGeoAnalytics
{
  private static final String ADDRESS_LOOKUP_PARAM = "addressLookup_geocode";
  private static final String DIRECTIONS_PARAM = "directions_geocode";
  private static final String ETA_PARAM = "eta_geocode";
  private static final String REVERSE_GEOCODE_PARAM = "reverse_geocode";
  private CallAnalytics addressLookupAnalytics = new CallAnalytics(CallEvent.Call.GOOGLE_HTTP_REQUEST);
  private CallAnalytics directionsAnalytics = new CallAnalytics(CallEvent.Call.GOOGLE_HTTP_REQUEST);
  private CallAnalytics etaAnalytics = new CallAnalytics(CallEvent.Call.GOOGLE_HTTP_REQUEST);
  private CallAnalytics reverseGeocodeAnalytics = new CallAnalytics(CallEvent.Call.GOOGLE_HTTP_REQUEST);
  
  public void addressLookupInitiation()
  {
    addressLookupAnalytics.setParameter("addressLookup_geocode");
    addressLookupAnalytics.trackInitiation();
  }
  
  public void directionsInitiation()
  {
    directionsAnalytics.setParameter("directions_geocode");
    directionsAnalytics.trackInitiation();
  }
  
  public void etaInitiation()
  {
    etaAnalytics.setParameter("eta_geocode");
    etaAnalytics.trackInitiation();
  }
  
  public void reverseGeocodeInitiation()
  {
    reverseGeocodeAnalytics.setParameter("reverse_geocode");
    reverseGeocodeAnalytics.trackInitiation();
  }
  
  public void trackAddressLookupFailure(Throwable paramThrowable)
  {
    addressLookupAnalytics.trackFailure(paramThrowable);
  }
  
  public void trackAddressLookupSuccess()
  {
    addressLookupAnalytics.trackSuccess();
  }
  
  public void trackDirectionsFailure(Throwable paramThrowable)
  {
    directionsAnalytics.trackFailure(paramThrowable);
  }
  
  public void trackDirectionsSuccess()
  {
    directionsAnalytics.trackSuccess();
  }
  
  public void trackEtaFailure(Throwable paramThrowable)
  {
    etaAnalytics.trackFailure(paramThrowable);
  }
  
  public void trackEtaSuccess()
  {
    etaAnalytics.trackSuccess();
  }
  
  public void trackReverseGeocodeFailure(Throwable paramThrowable)
  {
    reverseGeocodeAnalytics.trackFailure(paramThrowable);
  }
  
  public void trackReverseGeocodeSuccess()
  {
    reverseGeocodeAnalytics.trackSuccess();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.geo.GoogleGeoAnalytics
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */