package com.leanplum.callbacks;

public abstract class RegisterDeviceCallback$EmailCallback
  implements Runnable
{
  private String a;
  
  public abstract void onResponse(String paramString);
  
  public void run()
  {
    onResponse(a);
  }
  
  public void setResponseHandler(String paramString)
  {
    a = paramString;
  }
}

/* Location:
 * Qualified Name:     com.leanplum.callbacks.RegisterDeviceCallback.EmailCallback
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */