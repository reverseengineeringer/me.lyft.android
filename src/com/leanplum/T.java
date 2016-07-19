package com.leanplum;

import com.leanplum.callbacks.VariablesChangedCallback;
import java.util.HashMap;
import java.util.Map;

final class t
  extends VariablesChangedCallback
{
  t(String paramString) {}
  
  public final void variablesChanged()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("messageId", a);
    Leanplum.a("Cancel", 0.0D, null, null, localHashMap);
  }
}

/* Location:
 * Qualified Name:     com.leanplum.t
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */