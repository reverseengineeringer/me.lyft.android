package com.lyft.android.api.dto;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class UniversalDTO
{
  @SerializedName("appInfo")
  public final AppInfoDTO appInfo;
  @SerializedName("banners")
  public final List<BannerDTO> banners;
  @SerializedName("contributorRequests")
  public final List<ContributorRequestDTO> contributorRequests;
  @SerializedName("preDispatchTimestamp")
  public final Long preDispatchTimestamp;
  @SerializedName("prefillLocations")
  public final PrefillLocationsDTO prefillLocations;
  @SerializedName("ride")
  public final RideDTO ride;
  @SerializedName("rideTypes")
  public final List<Object> rideTypes;
  @SerializedName("timestamp")
  public final Long timestamp;
  @SerializedName("user")
  public final UserDTO user;
  
  public UniversalDTO(Long paramLong1, Long paramLong2, UserDTO paramUserDTO, RideDTO paramRideDTO, AppInfoDTO paramAppInfoDTO, List<BannerDTO> paramList, List<Object> paramList1, List<ContributorRequestDTO> paramList2, PrefillLocationsDTO paramPrefillLocationsDTO)
  {
    timestamp = paramLong1;
    preDispatchTimestamp = paramLong2;
    user = paramUserDTO;
    ride = paramRideDTO;
    appInfo = paramAppInfoDTO;
    banners = paramList;
    rideTypes = paramList1;
    contributorRequests = paramList2;
    prefillLocations = paramPrefillLocationsDTO;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("class UniversalDTO {\n");
    localStringBuilder.append("  timestamp: ").append(timestamp).append("\n");
    localStringBuilder.append("  preDispatchTimestamp: ").append(preDispatchTimestamp).append("\n");
    localStringBuilder.append("  user: ").append(user).append("\n");
    localStringBuilder.append("  ride: ").append(ride).append("\n");
    localStringBuilder.append("  appInfo: ").append(appInfo).append("\n");
    localStringBuilder.append("  banners: ").append(banners).append("\n");
    localStringBuilder.append("  rideTypes: ").append(rideTypes).append("\n");
    localStringBuilder.append("  contributorRequests: ").append(contributorRequests).append("\n");
    localStringBuilder.append("  prefillLocations: ").append(prefillLocations).append("\n");
    localStringBuilder.append("}\n");
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     com.lyft.android.api.dto.UniversalDTO
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */