package io.fabric.sdk.android;

public class KitInfo
{
  private final String buildType;
  private final String identifier;
  private final String version;
  
  public KitInfo(String paramString1, String paramString2, String paramString3)
  {
    identifier = paramString1;
    version = paramString2;
    buildType = paramString3;
  }
  
  public String getBuildType()
  {
    return buildType;
  }
  
  public String getIdentifier()
  {
    return identifier;
  }
  
  public String getVersion()
  {
    return version;
  }
}

/* Location:
 * Qualified Name:     io.fabric.sdk.android.KitInfo
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */