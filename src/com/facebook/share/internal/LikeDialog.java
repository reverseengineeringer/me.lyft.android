package com.facebook.share.internal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.facebook.FacebookCallback;
import com.facebook.internal.AppCall;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.internal.CallbackManagerImpl.Callback;
import com.facebook.internal.CallbackManagerImpl.RequestCodeOffset;
import com.facebook.internal.DialogFeature;
import com.facebook.internal.DialogPresenter;
import com.facebook.internal.DialogPresenter.ParameterProvider;
import com.facebook.internal.FacebookDialogBase;
import com.facebook.internal.FacebookDialogBase.ModeHandler;
import com.facebook.internal.FragmentWrapper;
import java.util.ArrayList;
import java.util.List;

public class LikeDialog
  extends FacebookDialogBase<LikeContent, Result>
{
  private static final int DEFAULT_REQUEST_CODE = CallbackManagerImpl.RequestCodeOffset.Like.toRequestCode();
  private static final String TAG = "LikeDialog";
  
  public LikeDialog(Activity paramActivity)
  {
    super(paramActivity, DEFAULT_REQUEST_CODE);
  }
  
  public LikeDialog(android.app.Fragment paramFragment)
  {
    this(new FragmentWrapper(paramFragment));
  }
  
  public LikeDialog(android.support.v4.app.Fragment paramFragment)
  {
    this(new FragmentWrapper(paramFragment));
  }
  
  public LikeDialog(FragmentWrapper paramFragmentWrapper)
  {
    super(paramFragmentWrapper, DEFAULT_REQUEST_CODE);
  }
  
  public static boolean canShowNativeDialog()
  {
    return DialogPresenter.canPresentNativeDialogWithFeature(getFeature());
  }
  
  public static boolean canShowWebFallback()
  {
    return DialogPresenter.canPresentWebFallbackDialogWithFeature(getFeature());
  }
  
  private static Bundle createParameters(LikeContent paramLikeContent)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("object_id", paramLikeContent.getObjectId());
    localBundle.putString("object_type", paramLikeContent.getObjectType());
    return localBundle;
  }
  
  private static DialogFeature getFeature()
  {
    return LikeDialogFeature.LIKE_DIALOG;
  }
  
  protected AppCall createBaseAppCall()
  {
    return new AppCall(getRequestCode());
  }
  
  protected List<FacebookDialogBase<LikeContent, Result>.FacebookDialogBase.ModeHandler> getOrderedModeHandlers()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new NativeHandler(null));
    localArrayList.add(new WebFallbackHandler(null));
    return localArrayList;
  }
  
  protected void registerCallbackImpl(CallbackManagerImpl paramCallbackManagerImpl, final FacebookCallback<Result> paramFacebookCallback)
  {
    if (paramFacebookCallback == null) {}
    for (paramFacebookCallback = null;; paramFacebookCallback = new ResultProcessor(paramFacebookCallback)
        {
          public void onSuccess(AppCall paramAnonymousAppCall, Bundle paramAnonymousBundle)
          {
            paramFacebookCallback.onSuccess(new LikeDialog.Result(paramAnonymousBundle));
          }
        })
    {
      paramFacebookCallback = new CallbackManagerImpl.Callback()
      {
        public boolean onActivityResult(int paramAnonymousInt, Intent paramAnonymousIntent)
        {
          return ShareInternalUtility.handleActivityResult(getRequestCode(), paramAnonymousInt, paramAnonymousIntent, paramFacebookCallback);
        }
      };
      paramCallbackManagerImpl.registerCallback(getRequestCode(), paramFacebookCallback);
      return;
    }
  }
  
  private class NativeHandler
    extends FacebookDialogBase<LikeContent, LikeDialog.Result>.FacebookDialogBase.ModeHandler
  {
    private NativeHandler()
    {
      super();
    }
    
    public boolean canShow(LikeContent paramLikeContent, boolean paramBoolean)
    {
      return (paramLikeContent != null) && (LikeDialog.canShowNativeDialog());
    }
    
    public AppCall createAppCall(final LikeContent paramLikeContent)
    {
      AppCall localAppCall = createBaseAppCall();
      DialogPresenter.setupAppCallForNativeDialog(localAppCall, new DialogPresenter.ParameterProvider()
      {
        public Bundle getLegacyParameters()
        {
          Log.e("LikeDialog", "Attempting to present the Like Dialog with an outdated Facebook app on the device");
          return new Bundle();
        }
        
        public Bundle getParameters()
        {
          return LikeDialog.createParameters(paramLikeContent);
        }
      }, LikeDialog.access$300());
      return localAppCall;
    }
  }
  
  public static final class Result
  {
    private final Bundle bundle;
    
    public Result(Bundle paramBundle)
    {
      bundle = paramBundle;
    }
    
    public Bundle getData()
    {
      return bundle;
    }
  }
  
  private class WebFallbackHandler
    extends FacebookDialogBase<LikeContent, LikeDialog.Result>.FacebookDialogBase.ModeHandler
  {
    private WebFallbackHandler()
    {
      super();
    }
    
    public boolean canShow(LikeContent paramLikeContent, boolean paramBoolean)
    {
      return (paramLikeContent != null) && (LikeDialog.canShowWebFallback());
    }
    
    public AppCall createAppCall(LikeContent paramLikeContent)
    {
      AppCall localAppCall = createBaseAppCall();
      DialogPresenter.setupAppCallForWebFallbackDialog(localAppCall, LikeDialog.createParameters(paramLikeContent), LikeDialog.access$300());
      return localAppCall;
    }
  }
}

/* Location:
 * Qualified Name:     com.facebook.share.internal.LikeDialog
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */