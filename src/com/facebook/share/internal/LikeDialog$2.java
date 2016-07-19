package com.facebook.share.internal;

import android.content.Intent;
import com.facebook.internal.CallbackManagerImpl.Callback;

class LikeDialog$2
  implements CallbackManagerImpl.Callback
{
  LikeDialog$2(LikeDialog paramLikeDialog, ResultProcessor paramResultProcessor) {}
  
  public boolean onActivityResult(int paramInt, Intent paramIntent)
  {
    return ShareInternalUtility.handleActivityResult(this$0.getRequestCode(), paramInt, paramIntent, val$resultProcessor);
  }
}

/* Location:
 * Qualified Name:     com.facebook.share.internal.LikeDialog.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */