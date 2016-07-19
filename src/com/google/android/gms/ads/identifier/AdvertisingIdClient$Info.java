package com.google.android.gms.ads.identifier;

public final class AdvertisingIdClient$Info
{
  private final String zzajl;
  private final boolean zzajm;
  
  public AdvertisingIdClient$Info(String paramString, boolean paramBoolean)
  {
    zzajl = paramString;
    zzajm = paramBoolean;
  }
  
  public String getId()
  {
    return zzajl;
  }
  
  public boolean isLimitAdTrackingEnabled()
  {
    return zzajm;
  }
  
  public String toString()
  {
    String str = zzajl;
    boolean bool = zzajm;
    return String.valueOf(str).length() + 7 + "{" + str + "}" + bool;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.identifier.AdvertisingIdClient.Info
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */