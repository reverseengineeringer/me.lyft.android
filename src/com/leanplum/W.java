package com.leanplum;

import com.leanplum.callbacks.StartCallback;
import java.util.HashMap;

final class w
  extends StartCallback
{
  w(String paramString) {}
  
  public final void onResponse(boolean paramBoolean)
  {
    if (g.a()) {
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("gcmRegistrationId", a);
    T.b("setDeviceAttributes", localHashMap).e();
    Leanplum.removeStartResponseHandler(Leanplum.o());
  }
}

/* Location:
 * Qualified Name:     com.leanplum.w
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */