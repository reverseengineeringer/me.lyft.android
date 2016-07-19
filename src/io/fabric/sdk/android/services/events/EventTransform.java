package io.fabric.sdk.android.services.events;

import java.io.IOException;

public abstract interface EventTransform<T>
{
  public abstract byte[] toBytes(T paramT)
    throws IOException;
}

/* Location:
 * Qualified Name:     io.fabric.sdk.android.services.events.EventTransform
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */