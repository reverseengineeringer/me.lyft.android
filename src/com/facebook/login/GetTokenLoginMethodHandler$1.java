package com.facebook.login;

import android.os.Bundle;
import com.facebook.internal.PlatformServiceClient.CompletedListener;

class GetTokenLoginMethodHandler$1
  implements PlatformServiceClient.CompletedListener
{
  GetTokenLoginMethodHandler$1(GetTokenLoginMethodHandler paramGetTokenLoginMethodHandler, LoginClient.Request paramRequest) {}
  
  public void completed(Bundle paramBundle)
  {
    this$0.getTokenCompleted(val$request, paramBundle);
  }
}

/* Location:
 * Qualified Name:     com.facebook.login.GetTokenLoginMethodHandler.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */