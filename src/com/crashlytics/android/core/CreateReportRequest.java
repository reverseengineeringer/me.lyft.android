package com.crashlytics.android.core;

class CreateReportRequest
{
  public final String apiKey;
  public final Report report;
  
  public CreateReportRequest(String paramString, Report paramReport)
  {
    apiKey = paramString;
    report = paramReport;
  }
}

/* Location:
 * Qualified Name:     com.crashlytics.android.core.CreateReportRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */