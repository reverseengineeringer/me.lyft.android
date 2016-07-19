package com.facebook.share.internal;

import com.facebook.GraphRequest.Callback;
import com.facebook.GraphResponse;

class LikeActionController$AbstractRequestWrapper$1
  implements GraphRequest.Callback
{
  LikeActionController$AbstractRequestWrapper$1(LikeActionController.AbstractRequestWrapper paramAbstractRequestWrapper) {}
  
  public void onCompleted(GraphResponse paramGraphResponse)
  {
    this$1.error = paramGraphResponse.getError();
    if (this$1.error != null)
    {
      this$1.processError(this$1.error);
      return;
    }
    this$1.processSuccess(paramGraphResponse);
  }
}

/* Location:
 * Qualified Name:     com.facebook.share.internal.LikeActionController.AbstractRequestWrapper.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */