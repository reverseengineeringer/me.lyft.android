package me.lyft.android.deeplinks;

public abstract interface DeepLinks
{
  public static abstract interface BusinessProfile
  {
    public static final String BUSINESS = "business";
    public static final String PARAM_COMPLETED = "completed";
    public static final String WORKPERKS = "workperks";
  }
  
  public static abstract interface CarpoolDriverOnboarding
  {
    public static final String ACTION = "carpooldriveronboarding";
    public static final String PARAM_ENABLE_LOCATIONS = "enableLocations";
    public static final String PARAM_IN_APP_ONBOARDING = "inAppOnboarding";
    public static final String PARAM_STEP = "step";
  }
  
  public static abstract interface Concur
  {
    public static final String ACTION = "concur";
    public static final String PARAM_ENABLED = "enabled";
  }
  
  public static abstract interface Drive
  {
    public static final String ACTION = "drive";
  }
  
  public static abstract interface DriveMode
  {
    public static final String ACTION = "drivemode";
  }
  
  public static abstract interface DriverStats
  {
    public static final String ACTION = "driver_stats";
  }
  
  public static abstract interface EditProfile
  {
    public static final String ACTION = "editprofile";
  }
  
  public static abstract interface Help
  {
    public static final String ACTION = "help";
  }
  
  public static abstract interface Note
  {
    public static final String ACTION = "note";
    public static final String PARAM_URL = "url";
  }
  
  public static abstract interface OfflineMode
  {
    public static final String ACTION = "offlinemode";
  }
  
  public static abstract interface Payment
  {
    public static final String ACTION = "payment";
    public static final String PARAM_CREDITS = "credits";
  }
  
  public static abstract interface Profile
  {
    public static final String ACTION = "profile";
  }
  
  public static abstract interface Proxy
  {
    public static final String ACTION = "proxy";
    public static final String PARAM_PROXY_IP = "ip";
  }
  
  public static abstract interface Referrals
  {
    public static final String ACTION = "referral";
  }
  
  public static abstract interface RideScreen
  {
    public static final String ACTION = "ride_screen";
  }
  
  public static abstract interface RideTypes
  {
    public static final String ACTION = "ridetype";
    public static final String PARAM_DESTINATION_LAT = "destination[latitude]";
    public static final String PARAM_DESTINATION_LONG = "destination[longitude]";
    public static final String PARAM_PICKUP_LAT = "pickup[latitude]";
    public static final String PARAM_PICKUP_LONG = "pickup[longitude]";
    public static final String PARAM_RIDE_TYPE_ID = "id";
  }
  
  public static abstract interface Settings
  {
    public static final String ACTION = "settings";
  }
  
  public static abstract interface ShareRoute
  {
    public static final String ACTION = "share_route";
  }
  
  public static abstract interface SplitFare
  {
    public static final String ACTION = "split_payment";
  }
  
  public static abstract interface TrainingRide
  {
    public static final String ACTION = "app-walkthrough";
  }
  
  public static abstract interface Vehicles
  {
    public static final String ACTION = "vehicles";
    public static final String PARAM_VEHICLE_ID = "id";
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.deeplinks.DeepLinks
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */