package io.fabric.sdk.android.services.cache;

import android.content.Context;

public abstract interface ValueCache<T>
{
  public abstract T get(Context paramContext, ValueLoader<T> paramValueLoader)
    throws Exception;
}

/* Location:
 * Qualified Name:     io.fabric.sdk.android.services.cache.ValueCache
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */