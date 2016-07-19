package me.lyft.android;

import com.google.gson.annotations.SerializedName;

public class RideFlags
{
  @SerializedName("dropoff_message_shown")
  boolean dropoffMessageShown;
  @SerializedName("has_auto_switched_back")
  boolean hasAutoSwitchedback;
  @SerializedName("pickup_confirmation_dialog_shown")
  boolean pickupConfirmationDialogShown;
  @SerializedName("pickup_message_shown")
  boolean pickupMessageShown;
  
  public boolean hasAutoSwitchedBack()
  {
    return hasAutoSwitchedback;
  }
  
  public boolean isDropoffMessageShown()
  {
    return dropoffMessageShown;
  }
  
  public boolean isPickupConfirmationDialogShown()
  {
    return pickupConfirmationDialogShown;
  }
  
  public boolean isPickupMessageShown()
  {
    return pickupMessageShown;
  }
  
  public void setDropoffMessageShown(boolean paramBoolean)
  {
    dropoffMessageShown = paramBoolean;
  }
  
  public void setHasAutoSwitchedback(boolean paramBoolean)
  {
    hasAutoSwitchedback = paramBoolean;
  }
  
  public void setPickupConfirmationDialogShown(boolean paramBoolean)
  {
    pickupConfirmationDialogShown = paramBoolean;
  }
  
  public void setPickupMessageShown(boolean paramBoolean)
  {
    pickupMessageShown = paramBoolean;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.RideFlags
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */