package com.google.ads;

@Deprecated
public final class AdSize
{
  public static final AdSize BANNER;
  public static final AdSize IAB_BANNER = new AdSize(468, 60, "as");
  public static final AdSize IAB_LEADERBOARD = new AdSize(728, 90, "as");
  public static final AdSize IAB_MRECT;
  public static final AdSize IAB_WIDE_SKYSCRAPER = new AdSize(160, 600, "as");
  public static final AdSize SMART_BANNER = new AdSize(-1, -2, "mb");
  private final com.google.android.gms.ads.AdSize zzcj;
  
  static
  {
    BANNER = new AdSize(320, 50, "mb");
    IAB_MRECT = new AdSize(300, 250, "as");
  }
  
  private AdSize(int paramInt1, int paramInt2, String paramString)
  {
    this(new com.google.android.gms.ads.AdSize(paramInt1, paramInt2));
  }
  
  public AdSize(com.google.android.gms.ads.AdSize paramAdSize)
  {
    zzcj = paramAdSize;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof AdSize)) {
      return false;
    }
    paramObject = (AdSize)paramObject;
    return zzcj.equals(zzcj);
  }
  
  public int getHeight()
  {
    return zzcj.getHeight();
  }
  
  public int getWidth()
  {
    return zzcj.getWidth();
  }
  
  public int hashCode()
  {
    return zzcj.hashCode();
  }
  
  public String toString()
  {
    return zzcj.toString();
  }
}

/* Location:
 * Qualified Name:     com.google.ads.AdSize
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */