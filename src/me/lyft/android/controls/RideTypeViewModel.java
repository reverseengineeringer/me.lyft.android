package me.lyft.android.controls;

import com.lyft.widgets.ISwitcherItem;
import me.lyft.android.common.Objects;
import me.lyft.android.domain.ride.RideType;

public class RideTypeViewModel
  implements ISwitcherItem
{
  final Long eta;
  final boolean hasPrimeTime;
  final String icon;
  final String label;
  final String pickupColor;
  final String requestColor;
  final RideType rideType;
  boolean selected;
  final String subLabel;
  
  public RideTypeViewModel(RideType paramRideType, String paramString1, String paramString2, boolean paramBoolean1, String paramString3, boolean paramBoolean2, Long paramLong, String paramString4, String paramString5)
  {
    rideType = paramRideType;
    label = paramString1;
    selected = paramBoolean1;
    icon = paramString3;
    hasPrimeTime = paramBoolean2;
    subLabel = paramString2;
    eta = paramLong;
    pickupColor = paramString4;
    requestColor = paramString5;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof RideTypeViewModel)) {}
    do
    {
      return false;
      paramObject = (RideTypeViewModel)paramObject;
    } while ((!Objects.equals(getId(), ((RideTypeViewModel)paramObject).getId())) || (!Objects.equals(label, ((RideTypeViewModel)paramObject).getLabel())) || (!Objects.equals(subLabel, ((RideTypeViewModel)paramObject).getSubLabel())) || (!Objects.equals(icon, ((RideTypeViewModel)paramObject).getIcon())) || (!Objects.equals(eta, ((RideTypeViewModel)paramObject).getEta())) || (!Objects.equals(Boolean.valueOf(hasPrimeTime), Boolean.valueOf(((RideTypeViewModel)paramObject).hasPrimeTime()))));
    return true;
  }
  
  public Long getEta()
  {
    return eta;
  }
  
  public String getIcon()
  {
    return icon;
  }
  
  public String getId()
  {
    return rideType.getType();
  }
  
  public String getLabel()
  {
    return label;
  }
  
  public String getPickupColor()
  {
    return pickupColor;
  }
  
  public String getRequestColor()
  {
    return requestColor;
  }
  
  public RideType getRideType()
  {
    return rideType;
  }
  
  public String getSubLabel()
  {
    return subLabel;
  }
  
  public boolean hasPrimeTime()
  {
    return hasPrimeTime;
  }
  
  public boolean isSelected()
  {
    return selected;
  }
  
  public void setSelected(boolean paramBoolean)
  {
    selected = paramBoolean;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.controls.RideTypeViewModel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */