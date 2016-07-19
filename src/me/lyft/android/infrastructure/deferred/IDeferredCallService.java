package me.lyft.android.infrastructure.deferred;

public abstract interface IDeferredCallService
{
  public abstract void add(IDeferredCall paramIDeferredCall);
  
  public abstract boolean hasPendingCall();
  
  public abstract void sync();
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.deferred.IDeferredCallService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */