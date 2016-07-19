package com.lyft.googlemaps.core.callback;

public class Callbacks
{
  private static final EmptyCallback EMPTY_CALLBACK = new EmptyCallback(null);
  
  public static <T> EmptyCallback<T> empty()
  {
    return EMPTY_CALLBACK;
  }
  
  private static class EmptyCallback<T>
    implements Callback0, Callback1<T>
  {
    public void call() {}
    
    public void call(T paramT) {}
  }
}

/* Location:
 * Qualified Name:     com.lyft.googlemaps.core.callback.Callbacks
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */