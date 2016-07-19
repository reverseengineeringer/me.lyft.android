package me.lyft.android;

import com.lyft.android.api.dto.RideDTO;

public abstract interface IUserSession
{
  @Deprecated
  public abstract RideDTO getRide();
  
  public abstract void resetAppState();
  
  public abstract void restoreAppState();
}

/* Location:
 * Qualified Name:     me.lyft.android.IUserSession
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */