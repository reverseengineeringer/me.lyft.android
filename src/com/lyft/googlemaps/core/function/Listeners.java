package com.lyft.googlemaps.core.function;

public class Listeners
{
  private static final Listener<Object, Object> EMPTY_LISTENER = new EmptyListener(null);
  
  public static <A, B> Listener<A, B> empty()
  {
    return EMPTY_LISTENER;
  }
  
  private static class EmptyListener<A, B>
    implements Listener<A, B>
  {
    public B call(A paramA)
    {
      return null;
    }
  }
}

/* Location:
 * Qualified Name:     com.lyft.googlemaps.core.function.Listeners
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */