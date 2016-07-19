package me.lyft.android.locationproviders.fused;

public abstract interface LocationConnection
{
  public static final String CONNECTION_FAILURE_REASON = "connection_failure";
  public static final String SUSPENSION_MESSAGE_REASON = "suspension";
  
  public abstract void connect();
  
  public abstract void disconnect();
}

/* Location:
 * Qualified Name:     me.lyft.android.locationproviders.fused.LocationConnection
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */