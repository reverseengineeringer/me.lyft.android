package com.lyft.android.api.dto;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class RideUserDTO
{
  @SerializedName("additionalMutualFriendsCount")
  public final String additionalMutualFriendsCount;
  @SerializedName("driverRating")
  public final Double driverRating;
  @SerializedName("firstName")
  public final String firstName;
  @SerializedName("id")
  public final String id;
  @SerializedName("joinDate")
  public final String joinDate;
  @SerializedName("lastName")
  public final String lastName;
  @SerializedName("location")
  public final LocationDTO location;
  @SerializedName("mutualFriends")
  public final List<MutualFriendDTO> mutualFriends;
  @SerializedName("partySize")
  public final Integer partySize;
  @SerializedName("passengerRating")
  public final Double passengerRating;
  @SerializedName("permissions")
  public final PermissionsDTO permissions;
  @SerializedName("phone")
  public final PhoneDTO phone;
  @SerializedName("profileFields")
  public final List<String> profileFields;
  @SerializedName("profileOverride")
  public final String profileOverride;
  @SerializedName("ratingCompleted")
  public final Boolean ratingCompleted;
  @SerializedName("recentLocations")
  public final List<LocationDTO> recentLocations;
  @SerializedName("userPhoto")
  public final String userPhoto;
  @SerializedName("vehicle")
  public final RideVehicleDTO vehicle;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("class RideUserDTO {\n");
    localStringBuilder.append("  id: ").append(id).append("\n");
    localStringBuilder.append("  firstName: ").append(firstName).append("\n");
    localStringBuilder.append("  lastName: ").append(lastName).append("\n");
    localStringBuilder.append("  userPhoto: ").append(userPhoto).append("\n");
    localStringBuilder.append("  phone: ").append(phone).append("\n");
    localStringBuilder.append("  partySize: ").append(partySize).append("\n");
    localStringBuilder.append("  driverRating: ").append(driverRating).append("\n");
    localStringBuilder.append("  passengerRating: ").append(passengerRating).append("\n");
    localStringBuilder.append("  ratingCompleted: ").append(ratingCompleted).append("\n");
    localStringBuilder.append("  recentLocations: ").append(recentLocations).append("\n");
    localStringBuilder.append("  additionalMutualFriendsCount: ").append(additionalMutualFriendsCount).append("\n");
    localStringBuilder.append("  mutualFriends: ").append(mutualFriends).append("\n");
    localStringBuilder.append("  vehicle: ").append(vehicle).append("\n");
    localStringBuilder.append("  location: ").append(location).append("\n");
    localStringBuilder.append("  joinDate: ").append(joinDate).append("\n");
    localStringBuilder.append("  profileFields: ").append(profileFields).append("\n");
    localStringBuilder.append("  profileOverride: ").append(profileOverride).append("\n");
    localStringBuilder.append("  permissions: ").append(permissions).append("\n");
    localStringBuilder.append("}\n");
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     com.lyft.android.api.dto.RideUserDTO
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */