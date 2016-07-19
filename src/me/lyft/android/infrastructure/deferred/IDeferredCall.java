package me.lyft.android.infrastructure.deferred;

public abstract interface IDeferredCall
{
  public abstract void callUsing(ICallDependencyFactory paramICallDependencyFactory)
    throws Exception;
  
  public abstract boolean needToRetry(Exception paramException);
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.deferred.IDeferredCall
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */