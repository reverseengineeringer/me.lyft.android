package io.fabric.sdk.android.services.common;

import io.fabric.sdk.android.Kit;
import io.fabric.sdk.android.services.network.HttpMethod;
import io.fabric.sdk.android.services.network.HttpRequest;
import io.fabric.sdk.android.services.network.HttpRequestFactory;
import java.util.Collections;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class AbstractSpiCall
{
  private static final Pattern PROTOCOL_AND_HOST_PATTERN = Pattern.compile("http(s?)://[^\\/]+", 2);
  protected final Kit kit;
  private final HttpMethod method;
  private final String protocolAndHostOverride;
  private final HttpRequestFactory requestFactory;
  private final String url;
  
  public AbstractSpiCall(Kit paramKit, String paramString1, String paramString2, HttpRequestFactory paramHttpRequestFactory, HttpMethod paramHttpMethod)
  {
    if (paramString2 == null) {
      throw new IllegalArgumentException("url must not be null.");
    }
    if (paramHttpRequestFactory == null) {
      throw new IllegalArgumentException("requestFactory must not be null.");
    }
    kit = paramKit;
    protocolAndHostOverride = paramString1;
    url = overrideProtocolAndHost(paramString2);
    requestFactory = paramHttpRequestFactory;
    method = paramHttpMethod;
  }
  
  private String overrideProtocolAndHost(String paramString)
  {
    String str = paramString;
    if (!CommonUtils.isNullOrEmpty(protocolAndHostOverride)) {
      str = PROTOCOL_AND_HOST_PATTERN.matcher(paramString).replaceFirst(protocolAndHostOverride);
    }
    return str;
  }
  
  protected HttpRequest getHttpRequest()
  {
    return getHttpRequest(Collections.emptyMap());
  }
  
  protected HttpRequest getHttpRequest(Map<String, String> paramMap)
  {
    return requestFactory.buildHttpRequest(method, getUrl(), paramMap).useCaches(false).connectTimeout(10000).header("User-Agent", "Crashlytics Android SDK/" + kit.getVersion()).header("X-CRASHLYTICS-DEVELOPER-TOKEN", "470fa2b4ae81cd56ecbcda9735803434cec591fa");
  }
  
  protected String getUrl()
  {
    return url;
  }
}

/* Location:
 * Qualified Name:     io.fabric.sdk.android.services.common.AbstractSpiCall
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */