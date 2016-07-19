package com.google.android.gms.wearable;

public abstract interface ChannelApi
{
  public static abstract interface ChannelListener
  {
    public abstract void onChannelClosed(Channel paramChannel, int paramInt1, int paramInt2);
    
    public abstract void onChannelOpened(Channel paramChannel);
    
    public abstract void onInputClosed(Channel paramChannel, int paramInt1, int paramInt2);
    
    public abstract void onOutputClosed(Channel paramChannel, int paramInt1, int paramInt2);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.wearable.ChannelApi
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */