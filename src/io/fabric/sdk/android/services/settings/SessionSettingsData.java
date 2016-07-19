package io.fabric.sdk.android.services.settings;

public class SessionSettingsData
{
  public final int identifierMask;
  public final int logBufferSize;
  public final int maxChainedExceptionDepth;
  public final int maxCustomExceptionEvents;
  public final int maxCustomKeyValuePairs;
  public final boolean sendSessionWithoutCrash;
  
  public SessionSettingsData(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean)
  {
    logBufferSize = paramInt1;
    maxChainedExceptionDepth = paramInt2;
    maxCustomExceptionEvents = paramInt3;
    maxCustomKeyValuePairs = paramInt4;
    identifierMask = paramInt5;
    sendSessionWithoutCrash = paramBoolean;
  }
}

/* Location:
 * Qualified Name:     io.fabric.sdk.android.services.settings.SessionSettingsData
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */