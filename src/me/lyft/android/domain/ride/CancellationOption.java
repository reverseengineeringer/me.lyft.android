package me.lyft.android.domain.ride;

public class CancellationOption
{
  private final String id;
  private final String status;
  private final String string;
  
  public CancellationOption(String paramString1, String paramString2, String paramString3)
  {
    id = paramString1;
    string = paramString2;
    status = paramString3;
  }
  
  public String getId()
  {
    return id;
  }
  
  public String getStatus()
  {
    return status;
  }
  
  public String getString()
  {
    return string;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.ride.CancellationOption
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */