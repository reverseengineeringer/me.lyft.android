package io.fabric.sdk.android.services.common;

class AdvertisingInfo
{
  public final String advertisingId;
  public final boolean limitAdTrackingEnabled;
  
  AdvertisingInfo(String paramString, boolean paramBoolean)
  {
    advertisingId = paramString;
    limitAdTrackingEnabled = paramBoolean;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (AdvertisingInfo)paramObject;
      if (limitAdTrackingEnabled != limitAdTrackingEnabled) {
        return false;
      }
      if (advertisingId == null) {
        break;
      }
    } while (advertisingId.equals(advertisingId));
    for (;;)
    {
      return false;
      if (advertisingId == null) {
        break;
      }
    }
  }
  
  public int hashCode()
  {
    int j = 0;
    if (advertisingId != null) {}
    for (int i = advertisingId.hashCode();; i = 0)
    {
      if (limitAdTrackingEnabled) {
        j = 1;
      }
      return i * 31 + j;
    }
  }
}

/* Location:
 * Qualified Name:     io.fabric.sdk.android.services.common.AdvertisingInfo
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */