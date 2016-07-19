package com.squareup.picasso;

public abstract interface Callback
{
  public abstract void onError();
  
  public abstract void onSuccess();
  
  public static class EmptyCallback
    implements Callback
  {
    public void onError() {}
    
    public void onSuccess() {}
  }
}

/* Location:
 * Qualified Name:     com.squareup.picasso.Callback
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */