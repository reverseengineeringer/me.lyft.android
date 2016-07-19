package io.fabric.sdk.android.services.common;

import java.util.Map;

public abstract interface DeviceIdentifierProvider
{
  public abstract Map<IdManager.DeviceIdentifierType, String> getDeviceIdentifiers();
}

/* Location:
 * Qualified Name:     io.fabric.sdk.android.services.common.DeviceIdentifierProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */