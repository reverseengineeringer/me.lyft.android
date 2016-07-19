package me.lyft.android.gcm;

import android.content.Context;
import java.util.Map;

public abstract interface IGcmEventExecutor
{
  public abstract void handleEvent(Context paramContext, Map<String, String> paramMap);
}

/* Location:
 * Qualified Name:     me.lyft.android.gcm.IGcmEventExecutor
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */