package me.lyft.android.application.features;

import java.util.ArrayList;
import java.util.List;
import me.lyft.android.infrastructure.lyft.features.FeatureFlag;

public class Features
{
  public static final FeatureFlag CARPOOL_DRIVER_SIGNUP_ENABLED;
  public static final FeatureFlag CONFIRM_ACCURACY_ENABLED;
  public static final FeatureFlag DESTINY;
  public static final FeatureFlag DRIVER_SHORTCUT_V2 = createFeatureFlag("dxDriverShortcut", "https://lyftme.atlassian.net/browse/LYFT-58397", "2016/06/21", "Feature flag to enable/disable new driver shortcut.");
  public static final FeatureFlag DX_MODE_TOGGLE;
  public static final FeatureFlag EXPLICIT_PICKUP_STEP_IN_DRIVER_FLOW;
  static final List<FeatureFlag> FEATURE_FLAGS = new ArrayList();
  public static final FeatureFlag GIFTBOX_TOOLTIP_ENABLED;
  public static final FeatureFlag INITIATE_ULU_ON_BOOTSTRAP;
  public static final FeatureFlag OFFLINE_DROP_OFF_ENABLED;
  public static final FeatureFlag PASSENGER_ETD_PIN;
  public static final FeatureFlag PG_NO_FACEBOOK_SIGNUP;
  public static final FeatureFlag PG_PHONE_FIRST_SIGNUP;
  public static final FeatureFlag PREFILL_FORWARD_TO_CONFIRM_STEP;
  public static final FeatureFlag RATE_AND_PAY_V2;
  public static final FeatureFlag RIDE_TYPE_TOOLTIP_ENABLED;
  public static final FeatureFlag ROUTE_CACHE_ENABLED;
  public static final FeatureFlag SHOW_BUSINESS_RIDE_HISTORY;
  public static final FeatureFlag SHOW_DRIVER_EARNINGS_V2;
  public static final FeatureFlag SPLIT_SHARE_TOOLTIP_ENABLED;
  public static final FeatureFlag USE_ANDROID_LOCATION_MANAGER = createFeatureFlag("useAndroidLocationManager", "https://lyftme.atlassian.net/browse/LYFT-58590", "2016/6/13", "For using android location manager instead of fused location api");
  public static final FeatureFlag USE_LOCALE_FOR_ZIP_COUNTRY;
  
  static
  {
    CONFIRM_ACCURACY_ENABLED = createFeatureFlag("confirmPickupLocationAccuracy", "https://lyftme.atlassian.net/browse/LYFT-47007", "2015-12-7", "");
    PREFILL_FORWARD_TO_CONFIRM_STEP = createFeatureFlag("prefillForwardToConfirmStep", "https://lyftme.atlassian.net/browse/LYFT-48431", "2016-1-11", "");
    DESTINY = createFeatureFlag("driverDestinationEnabled", "https://lyftme.atlassian.net/browse/LYFT-39718 ", "2014-12-12", "");
    CARPOOL_DRIVER_SIGNUP_ENABLED = createFeatureFlag("chauffeurDriverSignupEnabled", "https://lyftme.atlassian.net/browse/CHAUF-684", "2016/2/10", "");
    USE_LOCALE_FOR_ZIP_COUNTRY = createFeatureFlag("useLocaleForZipCountry", "https://lyftme.atlassian.net/browse/LYFT-53887", "2016/04/12", false, "");
    SHOW_DRIVER_EARNINGS_V2 = createFeatureFlag("pyDriverEarnings", "https://lyftme.atlassian.net/browse/LYFT-56021", "2016/05/12", false, "");
    SHOW_BUSINESS_RIDE_HISTORY = createFeatureFlag("enShowBusinessRideHistory", "https://lyftme.atlassian.net/browse/LYFT-57388", "2016/06/07", "");
    INITIATE_ULU_ON_BOOTSTRAP = createFeatureFlag("initiateAutoFillUluOnBootstrap", "https://lyftme.atlassian.net/browse/LYFT-51866", "2016/03/07", false, "");
    EXPLICIT_PICKUP_STEP_IN_DRIVER_FLOW = createFeatureFlag("featureDriverPickupFlowEnabled", "https://lyftme.atlassian.net/browse/PXP-947", "2016/04/04", false, "");
    PG_PHONE_FIRST_SIGNUP = createFeatureFlag("pgPhoneFirstSignup", "https://lyftme.atlassian.net/browse/GROW-401", "2016/5/4", "");
    PG_NO_FACEBOOK_SIGNUP = createFeatureFlag("pgNoFacebookSignup", "https://lyftme.atlassian.net/browse/GROW-401", "2016/5/4", "");
    ROUTE_CACHE_ENABLED = createFeatureFlag("routeCacheEnabled", "https://lyftme.atlassian.net/browse/LYFT-53618", "2016/5/8", "");
    SPLIT_SHARE_TOOLTIP_ENABLED = createFeatureFlag("showSplitPayHint", "https://lyftme.atlassian.net/browse/GROW-513", "2016/6/1", "Display a tooltip above Split Fare button in ride mode for every Plus rides and Line rides with 2 passengers");
    GIFTBOX_TOOLTIP_ENABLED = createFeatureFlag("showGiftBoxPromotion", "https://lyftme.atlassian.net/browse/GROW-556", "2016/6/10", "Display a tooltip above Split Fare button in ride mode for every Plus rides and Line rides with 2 passengers");
    RIDE_TYPE_TOOLTIP_ENABLED = createFeatureFlag("showRideTypeHint", "https://lyftme.atlassian.net/browse/LYFT-57624", "2016/6/16", "Display a tooltip above the Ride Type to tell the user to tap for more information.");
    RATE_AND_PAY_V2 = createFeatureFlag("rateAndPayV2", "", "2016/6/1", false, "");
    PASSENGER_ETD_PIN = createFeatureFlag("passengerETDInPinEnabled", "https://lyftme.atlassian.net/browse/LYFT-57611", "2016/6/9", "");
    DX_MODE_TOGGLE = createFeatureFlag("dxModeToggle", "https://lyftme.atlassian.net/browse/LYFT-57043", "2016/6/2", "");
    OFFLINE_DROP_OFF_ENABLED = createFeatureFlag("offlineDropOffEnabled", "https://lyftme.atlassian.net/browse/LYFT-50665", "2016/06/13", "Feature flag to control deferral of drop off and rate calls for drivers.");
  }
  
  static void add(FeatureFlag paramFeatureFlag)
  {
    FEATURE_FLAGS.add(paramFeatureFlag);
  }
  
  public static FeatureFlag createFeatureFlag(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    return createFeatureFlag(paramString1, paramString2, paramString3, false, paramString4);
  }
  
  public static FeatureFlag createFeatureFlag(String paramString1, String paramString2, String paramString3, boolean paramBoolean, String paramString4)
  {
    paramString1 = new FeatureFlag(paramString1, paramString2, paramString3, paramBoolean, paramString4);
    add(paramString1);
    return paramString1;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.features.Features
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */