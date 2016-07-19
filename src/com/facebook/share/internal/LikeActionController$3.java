package com.facebook.share.internal;

import android.content.Intent;
import com.facebook.internal.CallbackManagerImpl.Callback;
import com.facebook.internal.CallbackManagerImpl.RequestCodeOffset;

final class LikeActionController$3
  implements CallbackManagerImpl.Callback
{
  public boolean onActivityResult(int paramInt, Intent paramIntent)
  {
    return LikeActionController.handleOnActivityResult(CallbackManagerImpl.RequestCodeOffset.Like.toRequestCode(), paramInt, paramIntent);
  }
}

/* Location:
 * Qualified Name:     com.facebook.share.internal.LikeActionController.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */