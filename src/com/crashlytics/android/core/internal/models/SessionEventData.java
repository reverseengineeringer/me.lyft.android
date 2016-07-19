package com.crashlytics.android.core.internal.models;

public class SessionEventData
{
  public final BinaryImageData[] binaryImages;
  public final CustomAttributeData[] customAttributes;
  public final DeviceData deviceData;
  public final SignalData signal;
  public final ThreadData[] threads;
  public final long timestamp;
}

/* Location:
 * Qualified Name:     com.crashlytics.android.core.internal.models.SessionEventData
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */