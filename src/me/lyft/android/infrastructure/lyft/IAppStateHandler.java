package me.lyft.android.infrastructure.lyft;

import com.lyft.android.api.dto.RideDTO;
import com.lyft.android.api.dto.UniversalDTO;

public abstract interface IAppStateHandler
{
  public abstract void setAppState(UniversalDTO paramUniversalDTO);
  
  public abstract void setRide(Long paramLong, RideDTO paramRideDTO);
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.lyft.IAppStateHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */