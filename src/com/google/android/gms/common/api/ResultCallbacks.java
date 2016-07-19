package com.google.android.gms.common.api;

public abstract class ResultCallbacks<R extends Result>
  implements ResultCallback<R>
{
  public abstract void onFailure(Status paramStatus);
  
  public abstract void onSuccess(R paramR);
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.api.ResultCallbacks
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */