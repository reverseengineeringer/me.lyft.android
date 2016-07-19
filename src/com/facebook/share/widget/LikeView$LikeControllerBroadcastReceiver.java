package com.facebook.share.widget;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;

class LikeView$LikeControllerBroadcastReceiver
  extends BroadcastReceiver
{
  private LikeView$LikeControllerBroadcastReceiver(LikeView paramLikeView) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    paramIntent = paramIntent.getExtras();
    int i = 1;
    if (paramIntent != null)
    {
      String str = paramIntent.getString("com.facebook.sdk.LikeActionController.OBJECT_ID");
      if ((Utility.isNullOrEmpty(str)) || (Utility.areObjectsEqual(LikeView.access$600(this$0), str))) {
        i = 1;
      }
    }
    else
    {
      if (i != 0) {
        break label59;
      }
    }
    label59:
    label112:
    do
    {
      do
      {
        return;
        i = 0;
        break;
        if ("com.facebook.sdk.LikeActionController.UPDATED".equals(paramContext))
        {
          LikeView.access$700(this$0);
          return;
        }
        if (!"com.facebook.sdk.LikeActionController.DID_ERROR".equals(paramContext)) {
          break label112;
        }
      } while (LikeView.access$800(this$0) == null);
      LikeView.access$800(this$0).onError(NativeProtocol.getExceptionFromErrorData(paramIntent));
      return;
    } while (!"com.facebook.sdk.LikeActionController.DID_RESET".equals(paramContext));
    LikeView.access$1000(this$0, LikeView.access$600(this$0), LikeView.access$900(this$0));
    LikeView.access$700(this$0);
  }
}

/* Location:
 * Qualified Name:     com.facebook.share.widget.LikeView.LikeControllerBroadcastReceiver
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */