package me.lyft.android.domain.location;

public class DeepLinkMapper
{
  public static Location toDomainLocation(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = new Location(Double.valueOf(paramString1).doubleValue(), Double.valueOf(paramString2).doubleValue(), "deepLink");
      return paramString1;
    }
    catch (Exception paramString1) {}
    return NullLocation.getInstance();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.location.DeepLinkMapper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */