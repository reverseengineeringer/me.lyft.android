package com.facebook.share;

import android.app.Activity;
import android.content.Intent;
import com.facebook.FacebookActivity;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookRequestError;
import com.facebook.FacebookSdk;
import com.facebook.internal.AppCall;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.internal.CallbackManagerImpl.Callback;
import com.facebook.internal.CallbackManagerImpl.RequestCodeOffset;
import com.facebook.internal.FacebookDialogBase;
import com.facebook.internal.FragmentWrapper;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.ShareOpenGraphContent;
import java.util.List;

public class DeviceShareDialog
  extends FacebookDialogBase<ShareContent, Result>
{
  private static final int DEFAULT_REQUEST_CODE = CallbackManagerImpl.RequestCodeOffset.DeviceShare.toRequestCode();
  
  public DeviceShareDialog(Activity paramActivity)
  {
    super(paramActivity, DEFAULT_REQUEST_CODE);
  }
  
  public DeviceShareDialog(android.app.Fragment paramFragment)
  {
    super(new FragmentWrapper(paramFragment), DEFAULT_REQUEST_CODE);
  }
  
  public DeviceShareDialog(android.support.v4.app.Fragment paramFragment)
  {
    super(new FragmentWrapper(paramFragment), DEFAULT_REQUEST_CODE);
  }
  
  protected boolean canShowImpl(ShareContent paramShareContent, Object paramObject)
  {
    return ((paramShareContent instanceof ShareLinkContent)) || ((paramShareContent instanceof ShareOpenGraphContent));
  }
  
  protected AppCall createBaseAppCall()
  {
    return null;
  }
  
  protected List<FacebookDialogBase<ShareContent, Result>.com.facebook.internal.FacebookDialogBase.ModeHandler> getOrderedModeHandlers()
  {
    return null;
  }
  
  protected void registerCallbackImpl(CallbackManagerImpl paramCallbackManagerImpl, final FacebookCallback<Result> paramFacebookCallback)
  {
    paramCallbackManagerImpl.registerCallback(getRequestCode(), new CallbackManagerImpl.Callback()
    {
      public boolean onActivityResult(int paramAnonymousInt, Intent paramAnonymousIntent)
      {
        paramAnonymousIntent.getExtras();
        if (paramAnonymousIntent.hasExtra("error"))
        {
          paramAnonymousIntent = (FacebookRequestError)paramAnonymousIntent.getParcelableExtra("error");
          paramFacebookCallback.onError(paramAnonymousIntent.getException());
          return true;
        }
        paramFacebookCallback.onSuccess(new DeviceShareDialog.Result());
        return true;
      }
    });
  }
  
  protected void showImpl(ShareContent paramShareContent, Object paramObject)
  {
    if (paramShareContent == null) {
      throw new FacebookException("Must provide non-null content to share");
    }
    if ((!(paramShareContent instanceof ShareLinkContent)) && (!(paramShareContent instanceof ShareOpenGraphContent))) {
      throw new FacebookException(getClass().getSimpleName() + " only supports ShareLinkContent or ShareOpenGraphContent");
    }
    paramObject = new Intent();
    ((Intent)paramObject).setClass(FacebookSdk.getApplicationContext(), FacebookActivity.class);
    ((Intent)paramObject).setAction("DeviceShareDialogFragment");
    ((Intent)paramObject).putExtra("content", paramShareContent);
    startActivityForResult((Intent)paramObject, getRequestCode());
  }
  
  public static class Result {}
}

/* Location:
 * Qualified Name:     com.facebook.share.DeviceShareDialog
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */