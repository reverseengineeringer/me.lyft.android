package com.threatmetrix.TrustDefenderMobile;

public class ProfilingResult
{
  private String sessionID;
  private THMStatusCode status;
  
  ProfilingResult(String paramString, THMStatusCode paramTHMStatusCode)
  {
    sessionID = paramString;
    status = paramTHMStatusCode;
  }
  
  public String getSessionID()
  {
    return sessionID;
  }
  
  public THMStatusCode getStatus()
  {
    return status;
  }
}

/* Location:
 * Qualified Name:     com.threatmetrix.TrustDefenderMobile.ProfilingResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */