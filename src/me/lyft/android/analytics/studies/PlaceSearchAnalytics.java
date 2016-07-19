package me.lyft.android.analytics.studies;

import me.lyft.android.analytics.core.ActionAnalytics;
import me.lyft.android.analytics.core.SpanningAnalytics;
import me.lyft.android.analytics.core.events.ActionEvent.Action;

public class PlaceSearchAnalytics
{
  public static final String SOURCE_CITY = "city";
  public static final String SOURCE_DESTINATION = "destination";
  public static final String SOURCE_DESTINY = "destiny";
  public static final String SOURCE_EDIT_PICKUP = "editPickup";
  public static final String SOURCE_PICKUP = "pickup";
  public static final String SOURCE_SHORTCUT = "shortcut";
  private static final ActionAnalytics analytics = new ActionAnalytics(ActionEvent.Action.SEARCH_PLACES);
  
  public static void trackCancel()
  {
    analytics.trackCanceled();
  }
  
  public static void trackFailure(Throwable paramThrowable)
  {
    analytics.trackFailure(paramThrowable);
  }
  
  public static void trackSearchPlaces(String paramString)
  {
    analytics.setParameter(paramString).trackInitiation();
  }
  
  public static void trackSuccess(String paramString)
  {
    analytics.trackSuccess(paramString);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.analytics.studies.PlaceSearchAnalytics
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */