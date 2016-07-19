package com.leanplum.callbacks;

public abstract class RegisterDeviceCallback
  implements Runnable
{
  private RegisterDeviceCallback.EmailCallback a;
  
  public abstract void onResponse(RegisterDeviceCallback.EmailCallback paramEmailCallback);
  
  public void run()
  {
    onResponse(a);
  }
  
  public void setResponseHandler(RegisterDeviceCallback.EmailCallback paramEmailCallback)
  {
    a = paramEmailCallback;
  }
}

/* Location:
 * Qualified Name:     com.leanplum.callbacks.RegisterDeviceCallback
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */