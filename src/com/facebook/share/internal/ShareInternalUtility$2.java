package com.facebook.share.internal;

import android.content.Intent;
import com.facebook.internal.CallbackManagerImpl.Callback;

final class ShareInternalUtility$2
  implements CallbackManagerImpl.Callback
{
  ShareInternalUtility$2(int paramInt) {}
  
  public boolean onActivityResult(int paramInt, Intent paramIntent)
  {
    return ShareInternalUtility.handleActivityResult(val$requestCode, paramInt, paramIntent, ShareInternalUtility.getShareResultProcessor(null));
  }
}

/* Location:
 * Qualified Name:     com.facebook.share.internal.ShareInternalUtility.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */