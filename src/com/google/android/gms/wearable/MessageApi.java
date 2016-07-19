package com.google.android.gms.wearable;

public abstract interface MessageApi
{
  public static abstract interface MessageListener
  {
    public abstract void onMessageReceived(MessageEvent paramMessageEvent);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.wearable.MessageApi
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */