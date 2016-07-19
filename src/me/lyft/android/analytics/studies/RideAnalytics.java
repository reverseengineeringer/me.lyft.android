package me.lyft.android.analytics.studies;

import me.lyft.android.analytics.core.ActionAnalytics;
import me.lyft.android.analytics.core.SpanningAnalytics;
import me.lyft.android.analytics.core.UxAnalytics;
import me.lyft.android.analytics.core.events.ActionEvent.Action;
import me.lyft.android.analytics.definitions.Category;
import me.lyft.android.analytics.definitions.UiElement;
import me.lyft.android.domain.location.Location;

public final class RideAnalytics
{
  public static ActionAnalytics trackCancelRide(String paramString)
  {
    return (ActionAnalytics)new ActionAnalytics(ActionEvent.Action.CANCEL_RIDE).setParameter(paramString).trackInitiation();
  }
  
  public static void trackClearRequest()
  {
    new ActionAnalytics(ActionEvent.Action.CLEAR_REQUEST).trackInitiation().trackSuccess();
  }
  
  public static void trackContactingDriverSetDestinationTap()
  {
    UxAnalytics.tapped(UiElement.SET_DESTINATION_CLASSIC).setTag(Category.RIDE.toString()).track();
  }
  
  public static void trackPromoBannerTapped(String paramString)
  {
    UxAnalytics.tapped(UiElement.PROMO_BANNER).setParameter(paramString).track();
  }
  
  public static ActionAnalytics trackRateAndPayDriver()
  {
    return (ActionAnalytics)new ActionAnalytics(ActionEvent.Action.RATE_AND_PAY).trackInitiation();
  }
  
  public static void trackRequestPriceEstimate()
  {
    new ActionAnalytics(ActionEvent.Action.REQUEST_PRICE_ESTIMATE).trackInitiation().trackSuccess();
  }
  
  public static ActionAnalytics trackRequestRideAction()
  {
    return (ActionAnalytics)new ActionAnalytics(ActionEvent.Action.REQUEST_RIDE).trackInitiation();
  }
  
  public static void trackSetDestination(Location paramLocation)
  {
    new ActionAnalytics(ActionEvent.Action.SET_DESTINATION).setParameter(paramLocation.getSource()).trackInitiation().trackSuccess();
  }
  
  public static ActionAnalytics trackSetPickup(Location paramLocation)
  {
    return (ActionAnalytics)new ActionAnalytics(ActionEvent.Action.SET_PICKUP).setTag(paramLocation.getSource()).setParameter(paramLocation.toQueryString()).trackInitiation();
  }
  
  public static void trackSetPickupTime()
  {
    new ActionAnalytics(ActionEvent.Action.SET_PICKUP_TIME).trackInitiation().trackSuccess();
  }
  
  public static void trackSetRideType(String paramString)
  {
    new ActionAnalytics(ActionEvent.Action.SET_RIDE_TYPE).setParameter(paramString).trackInitiation().trackSuccess();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.analytics.studies.RideAnalytics
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */