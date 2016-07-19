package com.facebook.share.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.CallbackManager;
import com.facebook.FacebookButtonBase;
import com.facebook.FacebookCallback;
import com.facebook.FacebookSdk;
import com.facebook.R.style;
import com.facebook.internal.CallbackManagerImpl.RequestCodeOffset;
import com.facebook.share.DeviceShareDialog;
import com.facebook.share.DeviceShareDialog.Result;
import com.facebook.share.model.ShareContent;

public final class DeviceShareButton
  extends FacebookButtonBase
{
  private DeviceShareDialog dialog = null;
  private boolean enabledExplicitlySet = false;
  private int requestCode = 0;
  private ShareContent shareContent;
  
  public DeviceShareButton(Context paramContext)
  {
    this(paramContext, null, 0);
  }
  
  public DeviceShareButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  private DeviceShareButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt, 0, "fb_device_share_button_create", "fb_device_share_button_did_tap");
    if (isInEditMode()) {}
    for (paramInt = 0;; paramInt = getDefaultRequestCode())
    {
      requestCode = paramInt;
      internalSetEnabled(false);
      return;
    }
  }
  
  private boolean canShare()
  {
    return new DeviceShareDialog(getActivity()).canShow(getShareContent());
  }
  
  private DeviceShareDialog getDialog()
  {
    if (dialog != null) {
      return dialog;
    }
    if (getFragment() != null) {
      dialog = new DeviceShareDialog(getFragment());
    }
    for (;;)
    {
      return dialog;
      if (getNativeFragment() != null) {
        dialog = new DeviceShareDialog(getNativeFragment());
      } else {
        dialog = new DeviceShareDialog(getActivity());
      }
    }
  }
  
  private void internalSetEnabled(boolean paramBoolean)
  {
    setEnabled(paramBoolean);
    enabledExplicitlySet = false;
  }
  
  private void setRequestCode(int paramInt)
  {
    if (FacebookSdk.isFacebookRequestCode(paramInt)) {
      throw new IllegalArgumentException("Request code " + paramInt + " cannot be within the range reserved by the Facebook SDK.");
    }
    requestCode = paramInt;
  }
  
  protected void configureButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super.configureButton(paramContext, paramAttributeSet, paramInt1, paramInt2);
    setInternalOnClickListener(getShareOnClickListener());
  }
  
  protected int getDefaultRequestCode()
  {
    return CallbackManagerImpl.RequestCodeOffset.Share.toRequestCode();
  }
  
  protected int getDefaultStyleResource()
  {
    return R.style.com_facebook_button_share;
  }
  
  public int getRequestCode()
  {
    return requestCode;
  }
  
  public ShareContent getShareContent()
  {
    return shareContent;
  }
  
  protected View.OnClickListener getShareOnClickListener()
  {
    new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        callExternalOnClickListener(paramAnonymousView);
        DeviceShareButton.this.getDialog().show(getShareContent());
      }
    };
  }
  
  public void registerCallback(CallbackManager paramCallbackManager, FacebookCallback<DeviceShareDialog.Result> paramFacebookCallback)
  {
    getDialog().registerCallback(paramCallbackManager, paramFacebookCallback);
  }
  
  public void registerCallback(CallbackManager paramCallbackManager, FacebookCallback<DeviceShareDialog.Result> paramFacebookCallback, int paramInt)
  {
    setRequestCode(paramInt);
    getDialog().registerCallback(paramCallbackManager, paramFacebookCallback, paramInt);
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    super.setEnabled(paramBoolean);
    enabledExplicitlySet = true;
  }
  
  public void setShareContent(ShareContent paramShareContent)
  {
    shareContent = paramShareContent;
    if (!enabledExplicitlySet) {
      internalSetEnabled(canShare());
    }
  }
}

/* Location:
 * Qualified Name:     com.facebook.share.widget.DeviceShareButton
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */