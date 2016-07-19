package me.lyft.android.domain.ridehistory;

import java.util.Collections;
import java.util.List;
import me.lyft.android.common.Objects;

public class PassengerRideHistoryDetails
{
  private String cancelPenaltyReason;
  private String distance;
  private String driverName;
  private String driverPhotoUrl;
  private String dropoffAddress;
  private String dropoffTime;
  private String duration;
  private final List<RideHistoryFeature> features;
  private String mapImageUrl;
  private List<PaymentBreakdown> paymentsBreakdown;
  private String pickupAddress;
  private String pickupDateTime;
  private String pickupTime;
  private final String pricingUrl;
  private String region;
  private String rideFinalState;
  private String rideTotal;
  private String rideTypeLabel;
  
  public PassengerRideHistoryDetails(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13, List<PaymentBreakdown> paramList, String paramString14, String paramString15, List<RideHistoryFeature> paramList1, String paramString16)
  {
    mapImageUrl = paramString1;
    distance = paramString2;
    duration = paramString3;
    rideTypeLabel = paramString4;
    pickupAddress = paramString5;
    dropoffAddress = paramString6;
    pickupTime = paramString7;
    dropoffTime = paramString8;
    pickupDateTime = paramString9;
    driverPhotoUrl = paramString10;
    driverName = paramString11;
    rideTotal = paramString12;
    region = paramString13;
    paymentsBreakdown = paramList;
    rideFinalState = paramString14;
    cancelPenaltyReason = paramString15;
    features = ((List)Objects.firstNonNull(paramList1, Collections.emptyList()));
    pricingUrl = paramString16;
  }
  
  public PassengerRideHistoryDetails(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, List<PaymentBreakdown> paramList, String paramString10, String paramString11, List<RideHistoryFeature> paramList1, String paramString12)
  {
    this(paramString1, "", "", paramString2, paramString3, "", paramString4, "", paramString5, paramString6, paramString7, paramString8, paramString9, paramList, paramString10, paramString11, paramList1, paramString12);
  }
  
  public String getCancelPenaltyReason()
  {
    return cancelPenaltyReason;
  }
  
  public String getDistance()
  {
    return distance;
  }
  
  public String getDriverName()
  {
    return driverName;
  }
  
  public String getDriverPhotoUrl()
  {
    return driverPhotoUrl;
  }
  
  public String getDropoffAddress()
  {
    return dropoffAddress;
  }
  
  public String getDropoffTime()
  {
    return dropoffTime;
  }
  
  public String getDuration()
  {
    return duration;
  }
  
  public String getMapImageUrl()
  {
    return mapImageUrl;
  }
  
  public List<PaymentBreakdown> getPaymentsBreakdown()
  {
    return paymentsBreakdown;
  }
  
  public String getPickupAddress()
  {
    return pickupAddress;
  }
  
  public String getPickupDateTime()
  {
    return pickupDateTime;
  }
  
  public String getPickupTime()
  {
    return pickupTime;
  }
  
  public String getPricingUrl()
  {
    return pricingUrl;
  }
  
  public String getRegion()
  {
    return region;
  }
  
  public String getRideFinalState()
  {
    return rideFinalState;
  }
  
  public String getRideTotal()
  {
    return rideTotal;
  }
  
  public String getRideTypeLabel()
  {
    return rideTypeLabel;
  }
  
  public boolean hasFeatures()
  {
    return !features.isEmpty();
  }
  
  public boolean isFeatureEnabled(RideHistoryFeature paramRideHistoryFeature)
  {
    return features.contains(paramRideHistoryFeature);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.ridehistory.PassengerRideHistoryDetails
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */