package com.google.android.gms.wearable;

import com.google.android.gms.common.api.CommonStatusCodes;

public final class WearableStatusCodes
  extends CommonStatusCodes
{
  public static String getStatusCodeString(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return CommonStatusCodes.getStatusCodeString(paramInt);
    case 4000: 
      return "TARGET_NODE_NOT_CONNECTED";
    case 4001: 
      return "DUPLICATE_LISTENER";
    case 4002: 
      return "UNKNOWN_LISTENER";
    case 4003: 
      return "DATA_ITEM_TOO_LARGE";
    case 4004: 
      return "INVALID_TARGET_NODE";
    }
    return "ASSET_UNAVAILABLE";
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.wearable.WearableStatusCodes
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */