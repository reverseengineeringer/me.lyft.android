package com.facebook.share.widget;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.FacebookCallback;
import com.facebook.internal.AppCall;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.internal.CallbackManagerImpl.Callback;
import com.facebook.internal.CallbackManagerImpl.RequestCodeOffset;
import com.facebook.internal.DialogPresenter;
import com.facebook.internal.FacebookDialogBase;
import com.facebook.internal.FacebookDialogBase.ModeHandler;
import com.facebook.internal.FragmentWrapper;
import com.facebook.share.internal.ResultProcessor;
import com.facebook.share.internal.ShareInternalUtility;
import com.facebook.share.internal.WebDialogParameters;
import com.facebook.share.model.AppGroupCreationContent;
import java.util.ArrayList;
import java.util.List;

public class CreateAppGroupDialog
  extends FacebookDialogBase<AppGroupCreationContent, Result>
{
  private static final int DEFAULT_REQUEST_CODE = CallbackManagerImpl.RequestCodeOffset.AppGroupCreate.toRequestCode();
  private static final String GAME_GROUP_CREATION_DIALOG = "game_group_create";
  
  public CreateAppGroupDialog(Activity paramActivity)
  {
    super(paramActivity, DEFAULT_REQUEST_CODE);
  }
  
  public CreateAppGroupDialog(android.app.Fragment paramFragment)
  {
    this(new FragmentWrapper(paramFragment));
  }
  
  public CreateAppGroupDialog(android.support.v4.app.Fragment paramFragment)
  {
    this(new FragmentWrapper(paramFragment));
  }
  
  private CreateAppGroupDialog(FragmentWrapper paramFragmentWrapper)
  {
    super(paramFragmentWrapper, DEFAULT_REQUEST_CODE);
  }
  
  public static boolean canShow()
  {
    return true;
  }
  
  public static void show(Activity paramActivity, AppGroupCreationContent paramAppGroupCreationContent)
  {
    new CreateAppGroupDialog(paramActivity).show(paramAppGroupCreationContent);
  }
  
  public static void show(android.app.Fragment paramFragment, AppGroupCreationContent paramAppGroupCreationContent)
  {
    show(new FragmentWrapper(paramFragment), paramAppGroupCreationContent);
  }
  
  public static void show(android.support.v4.app.Fragment paramFragment, AppGroupCreationContent paramAppGroupCreationContent)
  {
    show(new FragmentWrapper(paramFragment), paramAppGroupCreationContent);
  }
  
  private static void show(FragmentWrapper paramFragmentWrapper, AppGroupCreationContent paramAppGroupCreationContent)
  {
    new CreateAppGroupDialog(paramFragmentWrapper).show(paramAppGroupCreationContent);
  }
  
  protected AppCall createBaseAppCall()
  {
    return new AppCall(getRequestCode());
  }
  
  protected List<FacebookDialogBase<AppGroupCreationContent, Result>.FacebookDialogBase.ModeHandler> getOrderedModeHandlers()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new WebHandler(null));
    return localArrayList;
  }
  
  protected void registerCallbackImpl(CallbackManagerImpl paramCallbackManagerImpl, final FacebookCallback<Result> paramFacebookCallback)
  {
    if (paramFacebookCallback == null) {}
    for (paramFacebookCallback = null;; paramFacebookCallback = new ResultProcessor(paramFacebookCallback)
        {
          public void onSuccess(AppCall paramAnonymousAppCall, Bundle paramAnonymousBundle)
          {
            paramFacebookCallback.onSuccess(new CreateAppGroupDialog.Result(paramAnonymousBundle.getString("id"), null));
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
  
  public static final class Result
  {
    private final String id;
    
    private Result(String paramString)
    {
      id = paramString;
    }
    
    public String getId()
    {
      return id;
    }
  }
  
  private class WebHandler
    extends FacebookDialogBase<AppGroupCreationContent, CreateAppGroupDialog.Result>.FacebookDialogBase.ModeHandler
  {
    private WebHandler()
    {
      super();
    }
    
    public boolean canShow(AppGroupCreationContent paramAppGroupCreationContent, boolean paramBoolean)
    {
      return true;
    }
    
    public AppCall createAppCall(AppGroupCreationContent paramAppGroupCreationContent)
    {
      AppCall localAppCall = createBaseAppCall();
      DialogPresenter.setupAppCallForWebDialog(localAppCall, "game_group_create", WebDialogParameters.create(paramAppGroupCreationContent));
      return localAppCall;
    }
  }
}

/* Location:
 * Qualified Name:     com.facebook.share.widget.CreateAppGroupDialog
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */