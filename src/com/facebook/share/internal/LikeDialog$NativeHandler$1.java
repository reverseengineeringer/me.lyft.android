package com.facebook.share.internal;

import android.os.Bundle;
import android.util.Log;
import com.facebook.internal.DialogPresenter.ParameterProvider;

class LikeDialog$NativeHandler$1
  implements DialogPresenter.ParameterProvider
{
  LikeDialog$NativeHandler$1(LikeDialog.NativeHandler paramNativeHandler, LikeContent paramLikeContent) {}
  
  public Bundle getLegacyParameters()
  {
    Log.e("LikeDialog", "Attempting to present the Like Dialog with an outdated Facebook app on the device");
    return new Bundle();
  }
  
  public Bundle getParameters()
  {
    return LikeDialog.access$200(val$content);
  }
}

/* Location:
 * Qualified Name:     com.facebook.share.internal.LikeDialog.NativeHandler.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */