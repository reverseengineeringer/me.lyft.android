package com.leanplum;

import android.os.Bundle;
import com.leanplum.callbacks.VariablesChangedCallback;
import java.util.HashMap;
import java.util.Map;

final class m
  extends VariablesChangedCallback
{
  m(GcmBroadcastReceiver paramGcmBroadcastReceiver, Bundle paramBundle) {}
  
  public final void variablesChanged()
  {
    Object localObject = LeanplumPushService.b(a);
    if (localObject != null)
    {
      if (LeanplumPushService.a(a))
      {
        HashMap localHashMap = new HashMap();
        localHashMap.put("Open action", a.a(a.getString("_lpx")));
        localObject = new ActionContext(c.a, localHashMap, (String)localObject);
        ((ActionContext)localObject).a();
        ((ActionContext)localObject).runTrackedActionNamed("Open action");
        return;
      }
      Leanplum.addOnceVariablesChangedAndNoDownloadsPendingHandler(new n(this, (String)localObject));
      return;
    }
    Leanplum.a("Open action", (String)localObject);
  }
}

/* Location:
 * Qualified Name:     com.leanplum.m
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */