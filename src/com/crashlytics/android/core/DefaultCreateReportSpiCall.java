package com.crashlytics.android.core;

import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.Kit;
import io.fabric.sdk.android.Logger;
import io.fabric.sdk.android.services.common.AbstractSpiCall;
import io.fabric.sdk.android.services.common.ResponseParser;
import io.fabric.sdk.android.services.network.HttpMethod;
import io.fabric.sdk.android.services.network.HttpRequest;
import io.fabric.sdk.android.services.network.HttpRequestFactory;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class DefaultCreateReportSpiCall
  extends AbstractSpiCall
  implements CreateReportSpiCall
{
  public DefaultCreateReportSpiCall(Kit paramKit, String paramString1, String paramString2, HttpRequestFactory paramHttpRequestFactory)
  {
    super(paramKit, paramString1, paramString2, paramHttpRequestFactory, HttpMethod.POST);
  }
  
  private HttpRequest applyHeadersTo(HttpRequest paramHttpRequest, CreateReportRequest paramCreateReportRequest)
  {
    paramHttpRequest = paramHttpRequest.header("X-CRASHLYTICS-API-KEY", apiKey).header("X-CRASHLYTICS-API-CLIENT-TYPE", "android").header("X-CRASHLYTICS-API-CLIENT-VERSION", CrashlyticsCore.getInstance().getVersion());
    paramCreateReportRequest = report.getCustomHeaders().entrySet().iterator();
    while (paramCreateReportRequest.hasNext()) {
      paramHttpRequest = paramHttpRequest.header((Map.Entry)paramCreateReportRequest.next());
    }
    return paramHttpRequest;
  }
  
  private HttpRequest applyMultipartDataTo(HttpRequest paramHttpRequest, CreateReportRequest paramCreateReportRequest)
  {
    paramCreateReportRequest = report;
    return paramHttpRequest.part("report[file]", paramCreateReportRequest.getFileName(), "application/octet-stream", paramCreateReportRequest.getFile()).part("report[identifier]", paramCreateReportRequest.getIdentifier());
  }
  
  public boolean invoke(CreateReportRequest paramCreateReportRequest)
  {
    paramCreateReportRequest = applyMultipartDataTo(applyHeadersTo(getHttpRequest(), paramCreateReportRequest), paramCreateReportRequest);
    Fabric.getLogger().d("CrashlyticsCore", "Sending report to: " + getUrl());
    int i = paramCreateReportRequest.code();
    Fabric.getLogger().d("CrashlyticsCore", "Create report request ID: " + paramCreateReportRequest.header("X-REQUEST-ID"));
    Fabric.getLogger().d("CrashlyticsCore", "Result was: " + i);
    return ResponseParser.parse(i) == 0;
  }
}

/* Location:
 * Qualified Name:     com.crashlytics.android.core.DefaultCreateReportSpiCall
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */