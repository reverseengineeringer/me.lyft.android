package com.crashlytics.android.beta;

import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.Kit;
import io.fabric.sdk.android.Logger;
import io.fabric.sdk.android.services.common.AbstractSpiCall;
import io.fabric.sdk.android.services.network.HttpMethod;
import io.fabric.sdk.android.services.network.HttpRequest;
import io.fabric.sdk.android.services.network.HttpRequestFactory;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

class CheckForUpdatesRequest
  extends AbstractSpiCall
{
  private final CheckForUpdatesResponseTransform responseTransform;
  
  public CheckForUpdatesRequest(Kit paramKit, String paramString1, String paramString2, HttpRequestFactory paramHttpRequestFactory, CheckForUpdatesResponseTransform paramCheckForUpdatesResponseTransform)
  {
    super(paramKit, paramString1, paramString2, paramHttpRequestFactory, HttpMethod.GET);
    responseTransform = paramCheckForUpdatesResponseTransform;
  }
  
  private HttpRequest applyHeadersTo(HttpRequest paramHttpRequest, String paramString1, String paramString2)
  {
    return paramHttpRequest.header("Accept", "application/json").header("User-Agent", "Crashlytics Android SDK/" + kit.getVersion()).header("X-CRASHLYTICS-DEVELOPER-TOKEN", "470fa2b4ae81cd56ecbcda9735803434cec591fa").header("X-CRASHLYTICS-API-CLIENT-TYPE", "android").header("X-CRASHLYTICS-API-CLIENT-VERSION", kit.getVersion()).header("X-CRASHLYTICS-API-KEY", paramString1).header("X-CRASHLYTICS-BETA-TOKEN", createBetaTokenHeaderValueFor(paramString2));
  }
  
  static String createBetaTokenHeaderValueFor(String paramString)
  {
    return "3:" + paramString;
  }
  
  private Map<String, String> getQueryParamsFor(BuildProperties paramBuildProperties)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("build_version", versionCode);
    localHashMap.put("display_version", versionName);
    localHashMap.put("instance", buildId);
    localHashMap.put("source", "3");
    return localHashMap;
  }
  
  public CheckForUpdatesResponse invoke(String paramString1, String paramString2, BuildProperties paramBuildProperties)
  {
    Object localObject4 = null;
    Object localObject3 = null;
    localObject2 = localObject3;
    localObject1 = localObject4;
    try
    {
      Map localMap = getQueryParamsFor(paramBuildProperties);
      localObject2 = localObject3;
      localObject1 = localObject4;
      paramBuildProperties = getHttpRequest(localMap);
      localObject2 = paramBuildProperties;
      localObject1 = paramBuildProperties;
      paramString1 = applyHeadersTo(paramBuildProperties, paramString1, paramString2);
      localObject2 = paramString1;
      localObject1 = paramString1;
      Fabric.getLogger().d("Beta", "Checking for updates from " + getUrl());
      localObject2 = paramString1;
      localObject1 = paramString1;
      Fabric.getLogger().d("Beta", "Checking for updates query params are: " + localMap);
      localObject2 = paramString1;
      localObject1 = paramString1;
      if (paramString1.ok())
      {
        localObject2 = paramString1;
        localObject1 = paramString1;
        Fabric.getLogger().d("Beta", "Checking for updates was successful");
        localObject2 = paramString1;
        localObject1 = paramString1;
        paramString2 = new JSONObject(paramString1.body());
        localObject2 = paramString1;
        localObject1 = paramString1;
        paramString2 = responseTransform.fromJson(paramString2);
        if (paramString1 != null)
        {
          paramString1 = paramString1.header("X-REQUEST-ID");
          Fabric.getLogger().d("Fabric", "Checking for updates request ID: " + paramString1);
        }
        return paramString2;
      }
      localObject2 = paramString1;
      localObject1 = paramString1;
      Fabric.getLogger().e("Beta", "Checking for updates failed. Response code: " + paramString1.code());
      if (paramString1 != null)
      {
        paramString1 = paramString1.header("X-REQUEST-ID");
        Fabric.getLogger().d("Fabric", "Checking for updates request ID: " + paramString1);
      }
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        localObject1 = localObject2;
        Fabric.getLogger().e("Beta", "Error while checking for updates from " + getUrl(), paramString1);
        if (localObject2 != null)
        {
          paramString1 = ((HttpRequest)localObject2).header("X-REQUEST-ID");
          Fabric.getLogger().d("Fabric", "Checking for updates request ID: " + paramString1);
        }
      }
    }
    finally
    {
      if (localObject1 == null) {
        break label436;
      }
      paramString2 = ((HttpRequest)localObject1).header("X-REQUEST-ID");
      Fabric.getLogger().d("Fabric", "Checking for updates request ID: " + paramString2);
    }
    return null;
  }
}

/* Location:
 * Qualified Name:     com.crashlytics.android.beta.CheckForUpdatesRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */