package com.firebase.jobdispatcher;

import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.gcm.PendingCallback;

final class GooglePlayCallbackExtractor
{
  public JobCallback extractCallback(Bundle paramBundle)
  {
    if (paramBundle == null)
    {
      Log.e("FJD.GooglePlayReceiver", "No callback received, terminating");
      return null;
    }
    paramBundle.setClassLoader(PendingCallback.class.getClassLoader());
    paramBundle = paramBundle.getParcelable("callback");
    if (paramBundle == null)
    {
      Log.e("FJD.GooglePlayReceiver", "No callback received, terminating");
      return null;
    }
    if (!(paramBundle instanceof PendingCallback))
    {
      Log.e("FJD.GooglePlayReceiver", "Bad callback received, terminating");
      return null;
    }
    return new GooglePlayJobCallback(((PendingCallback)paramBundle).getIBinder());
  }
}

/* Location:
 * Qualified Name:     com.firebase.jobdispatcher.GooglePlayCallbackExtractor
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */