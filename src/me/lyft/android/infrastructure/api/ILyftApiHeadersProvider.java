package me.lyft.android.infrastructure.api;

import java.util.Map;

public abstract interface ILyftApiHeadersProvider
{
  public abstract Map<String, String> getHeaders();
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.api.ILyftApiHeadersProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */