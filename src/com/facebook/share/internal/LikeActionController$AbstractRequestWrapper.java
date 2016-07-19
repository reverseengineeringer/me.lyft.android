package com.facebook.share.internal;

import com.facebook.FacebookRequestError;
import com.facebook.GraphRequest;
import com.facebook.GraphRequest.Callback;
import com.facebook.GraphRequestBatch;
import com.facebook.GraphResponse;
import com.facebook.LoggingBehavior;
import com.facebook.internal.Logger;
import com.facebook.share.widget.LikeView.ObjectType;

abstract class LikeActionController$AbstractRequestWrapper
  implements LikeActionController.RequestWrapper
{
  protected FacebookRequestError error;
  protected String objectId;
  protected LikeView.ObjectType objectType;
  private GraphRequest request;
  
  protected LikeActionController$AbstractRequestWrapper(LikeActionController paramLikeActionController, String paramString, LikeView.ObjectType paramObjectType)
  {
    objectId = paramString;
    objectType = paramObjectType;
  }
  
  public void addToBatch(GraphRequestBatch paramGraphRequestBatch)
  {
    paramGraphRequestBatch.add(request);
  }
  
  public FacebookRequestError getError()
  {
    return error;
  }
  
  protected void processError(FacebookRequestError paramFacebookRequestError)
  {
    Logger.log(LoggingBehavior.REQUESTS, LikeActionController.access$100(), "Error running request for object '%s' with type '%s' : %s", new Object[] { objectId, objectType, paramFacebookRequestError });
  }
  
  protected abstract void processSuccess(GraphResponse paramGraphResponse);
  
  protected void setRequest(GraphRequest paramGraphRequest)
  {
    request = paramGraphRequest;
    paramGraphRequest.setVersion("v2.6");
    paramGraphRequest.setCallback(new GraphRequest.Callback()
    {
      public void onCompleted(GraphResponse paramAnonymousGraphResponse)
      {
        error = paramAnonymousGraphResponse.getError();
        if (error != null)
        {
          processError(error);
          return;
        }
        processSuccess(paramAnonymousGraphResponse);
      }
    });
  }
}

/* Location:
 * Qualified Name:     com.facebook.share.internal.LikeActionController.AbstractRequestWrapper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */