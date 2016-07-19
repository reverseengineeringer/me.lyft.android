package com.squareup.tape;

public abstract interface ObjectQueue<T>
{
  public static abstract interface Listener<T>
  {
    public abstract void onAdd(ObjectQueue<T> paramObjectQueue, T paramT);
    
    public abstract void onRemove(ObjectQueue<T> paramObjectQueue);
  }
}

/* Location:
 * Qualified Name:     com.squareup.tape.ObjectQueue
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */