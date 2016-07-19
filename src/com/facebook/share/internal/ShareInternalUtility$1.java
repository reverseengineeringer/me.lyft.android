package com.facebook.share.internal;

import android.os.Bundle;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.internal.AppCall;

final class ShareInternalUtility$1
  extends ResultProcessor
{
  ShareInternalUtility$1(FacebookCallback paramFacebookCallback1, FacebookCallback paramFacebookCallback2)
  {
    super(paramFacebookCallback1);
  }
  
  public void onCancel(AppCall paramAppCall)
  {
    ShareInternalUtility.invokeOnCancelCallback(val$callback);
  }
  
  public void onError(AppCall paramAppCall, FacebookException paramFacebookException)
  {
    ShareInternalUtility.invokeOnErrorCallback(val$callback, paramFacebookException);
  }
  
  public void onSuccess(AppCall paramAppCall, Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      paramAppCall = ShareInternalUtility.getNativeDialogCompletionGesture(paramBundle);
      if ((paramAppCall == null) || ("post".equalsIgnoreCase(paramAppCall)))
      {
        paramAppCall = ShareInternalUtility.getShareDialogPostId(paramBundle);
        ShareInternalUtility.invokeOnSuccessCallback(val$callback, paramAppCall);
      }
    }
    else
    {
      return;
    }
    if ("cancel".equalsIgnoreCase(paramAppCall))
    {
      ShareInternalUtility.invokeOnCancelCallback(val$callback);
      return;
    }
    ShareInternalUtility.invokeOnErrorCallback(val$callback, new FacebookException("UnknownError"));
  }
}

/* Location:
 * Qualified Name:     com.facebook.share.internal.ShareInternalUtility.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */