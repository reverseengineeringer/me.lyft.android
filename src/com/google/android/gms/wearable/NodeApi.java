package com.google.android.gms.wearable;

public abstract interface NodeApi
{
  @Deprecated
  public static abstract interface NodeListener
  {
    @Deprecated
    public abstract void onPeerConnected(Node paramNode);
    
    @Deprecated
    public abstract void onPeerDisconnected(Node paramNode);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.wearable.NodeApi
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */