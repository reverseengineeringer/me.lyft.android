package me.lyft.android.gcm;

import java.util.Map;

public abstract interface IGcmSerializer
{
  public abstract <T> T deserialize(Map<String, String> paramMap, String paramString, Class<T> paramClass, T paramT);
}

/* Location:
 * Qualified Name:     me.lyft.android.gcm.IGcmSerializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */