package io.fabric.sdk.android.services.common;

public abstract class Crash
{
  private final String sessionId;
  
  public Crash(String paramString)
  {
    sessionId = paramString;
  }
  
  public String getSessionId()
  {
    return sessionId;
  }
  
  public static class FatalException
    extends Crash
  {
    public FatalException(String paramString)
    {
      super();
    }
  }
  
  public static class LoggedException
    extends Crash
  {
    public LoggedException(String paramString)
    {
      super();
    }
  }
}

/* Location:
 * Qualified Name:     io.fabric.sdk.android.services.common.Crash
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */