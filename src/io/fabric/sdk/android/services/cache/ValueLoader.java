package io.fabric.sdk.android.services.cache;

import android.content.Context;

public abstract interface ValueLoader<T>
{
  public abstract T load(Context paramContext)
    throws Exception;
}

/* Location:
 * Qualified Name:     io.fabric.sdk.android.services.cache.ValueLoader
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */