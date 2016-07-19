package me.lyft.android.domain.passenger.ridetypes;

import java.util.Collections;

public class NullRequestRideType
  extends RequestRideType
{
  private static final NullRequestRideType INSTANCE = new NullRequestRideType();
  
  private NullRequestRideType()
  {
    super("lyft", "", "", Pricing.empty(), "", "", "", "", "", "", "", "", "", false, false, -1, Collections.emptyList());
  }
  
  public static RequestRideType getInstance()
  {
    return INSTANCE;
  }
  
  public boolean isNull()
  {
    return true;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.passenger.ridetypes.NullRequestRideType
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */