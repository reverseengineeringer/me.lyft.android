package me.lyft.android.analytics.session;

public class AnalyticsSessionInfo
{
  private long last_activity;
  private String session_id;
  
  public AnalyticsSessionInfo(String paramString, long paramLong)
  {
    session_id = paramString;
    last_activity = paramLong;
  }
  
  long getLastActivity()
  {
    return last_activity;
  }
  
  String getSessionId()
  {
    return session_id;
  }
  
  void setLastActivity(long paramLong)
  {
    last_activity = paramLong;
  }
  
  void setSessionId(String paramString)
  {
    session_id = paramString;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.analytics.session.AnalyticsSessionInfo
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */