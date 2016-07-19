package com.google.android.gms.wearable;

public abstract interface CapabilityApi
{
  public static abstract interface CapabilityListener
  {
    public abstract void onCapabilityChanged(CapabilityInfo paramCapabilityInfo);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.wearable.CapabilityApi
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */