package com.facebook.share.widget;

import android.content.Intent;
import com.facebook.internal.CallbackManagerImpl.Callback;
import com.facebook.share.internal.ResultProcessor;
import com.facebook.share.internal.ShareInternalUtility;

class CreateAppGroupDialog$2
  implements CallbackManagerImpl.Callback
{
  CreateAppGroupDialog$2(CreateAppGroupDialog paramCreateAppGroupDialog, ResultProcessor paramResultProcessor) {}
  
  public boolean onActivityResult(int paramInt, Intent paramIntent)
  {
    return ShareInternalUtility.handleActivityResult(this$0.getRequestCode(), paramInt, paramIntent, val$resultProcessor);
  }
}

/* Location:
 * Qualified Name:     com.facebook.share.widget.CreateAppGroupDialog.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */