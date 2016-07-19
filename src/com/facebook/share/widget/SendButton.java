package com.facebook.share.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.facebook.R.style;
import com.facebook.internal.CallbackManagerImpl.RequestCodeOffset;
import com.facebook.internal.FacebookDialogBase;
import com.facebook.share.Sharer.Result;
import com.facebook.share.model.ShareContent;

public final class SendButton
  extends ShareButtonBase
{
  public SendButton(Context paramContext)
  {
    super(paramContext, null, 0, "fb_send_button_create", "fb_send_button_did_tap");
  }
  
  public SendButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet, 0, "fb_send_button_create", "fb_send_button_did_tap");
  }
  
  public SendButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt, "fb_send_button_create", "fb_send_button_did_tap");
  }
  
  protected int getDefaultRequestCode()
  {
    return CallbackManagerImpl.RequestCodeOffset.Message.toRequestCode();
  }
  
  protected int getDefaultStyleResource()
  {
    return R.style.com_facebook_button_send;
  }
  
  protected FacebookDialogBase<ShareContent, Sharer.Result> getDialog()
  {
    if (getFragment() != null) {
      return new MessageDialog(getFragment(), getRequestCode());
    }
    if (getNativeFragment() != null) {
      return new MessageDialog(getNativeFragment(), getRequestCode());
    }
    return new MessageDialog(getActivity(), getRequestCode());
  }
}

/* Location:
 * Qualified Name:     com.facebook.share.widget.SendButton
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */