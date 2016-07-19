package me.lyft.android.analytics;

import me.lyft.android.analytics.core.ActionAnalytics;
import me.lyft.android.analytics.core.SpanningAnalytics;
import me.lyft.android.analytics.core.events.ActionEvent.Action;

public class EditPickupAnalytics
{
  private static final String ADDRESS_BAR = "pickup_address";
  private static final String MAP = "map";
  private static final String PIN = "pickup_pin";
  private static final String PLACE_SEARCH = "placeSearch";
  private static final String TOOLTIP = "tooltip";
  private ActionAnalytics pinMovedFromMap;
  private ActionAnalytics pinMovedFromPlaceSearch;
  
  private void trackPinMoveEnded(ActionAnalytics paramActionAnalytics, boolean paramBoolean, int paramInt)
  {
    if (paramActionAnalytics != null)
    {
      paramActionAnalytics.setValue(paramInt);
      if (paramBoolean) {
        paramActionAnalytics.trackSuccess();
      }
    }
    else
    {
      return;
    }
    paramActionAnalytics.trackFailure();
  }
  
  public void trackEditPickupStartedFromAddressBar()
  {
    ((ActionAnalytics)new ActionAnalytics(ActionEvent.Action.BEGIN_PICKUP_ADJUST).setParameter("pickup_address").trackInitiation()).trackSuccess();
  }
  
  public void trackEditPickupStartedFromPin()
  {
    ((ActionAnalytics)new ActionAnalytics(ActionEvent.Action.BEGIN_PICKUP_ADJUST).setParameter("pickup_pin").trackInitiation()).trackSuccess();
  }
  
  public void trackEditPickupStartedFromTooltip()
  {
    ((ActionAnalytics)new ActionAnalytics(ActionEvent.Action.BEGIN_PICKUP_ADJUST).setParameter("tooltip").trackInitiation()).trackSuccess();
  }
  
  public void trackPinMoveEndedFromMap(boolean paramBoolean, int paramInt)
  {
    trackPinMoveEnded(pinMovedFromMap, paramBoolean, paramInt);
  }
  
  public void trackPinMoveEndedFromPlaceSearch(boolean paramBoolean, int paramInt)
  {
    trackPinMoveEnded(pinMovedFromPlaceSearch, paramBoolean, paramInt);
  }
  
  public void trackPinMoveStartedFromMap()
  {
    pinMovedFromMap = ((ActionAnalytics)new ActionAnalytics(ActionEvent.Action.PICKUP_PIN_MOVED).setParameter("map").trackInitiation());
  }
  
  public void trackPinMoveStartedFromPlaceSearch()
  {
    pinMovedFromPlaceSearch = ((ActionAnalytics)new ActionAnalytics(ActionEvent.Action.PICKUP_PIN_MOVED).setParameter("placeSearch").trackInitiation());
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.analytics.EditPickupAnalytics
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */