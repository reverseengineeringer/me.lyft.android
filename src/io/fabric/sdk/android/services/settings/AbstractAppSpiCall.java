package io.fabric.sdk.android.services.settings;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.Kit;
import io.fabric.sdk.android.KitInfo;
import io.fabric.sdk.android.Logger;
import io.fabric.sdk.android.services.common.AbstractSpiCall;
import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.common.ResponseParser;
import io.fabric.sdk.android.services.network.HttpMethod;
import io.fabric.sdk.android.services.network.HttpRequest;
import io.fabric.sdk.android.services.network.HttpRequestFactory;
import java.io.Closeable;
import java.io.InputStream;
import java.util.Collection;
import java.util.Iterator;
import java.util.Locale;

abstract class AbstractAppSpiCall
  extends AbstractSpiCall
{
  public AbstractAppSpiCall(Kit paramKit, String paramString1, String paramString2, HttpRequestFactory paramHttpRequestFactory, HttpMethod paramHttpMethod)
  {
    super(paramKit, paramString1, paramString2, paramHttpRequestFactory, paramHttpMethod);
  }
  
  private HttpRequest applyHeadersTo(HttpRequest paramHttpRequest, AppRequestData paramAppRequestData)
  {
    return paramHttpRequest.header("X-CRASHLYTICS-API-KEY", apiKey).header("X-CRASHLYTICS-API-CLIENT-TYPE", "android").header("X-CRASHLYTICS-API-CLIENT-VERSION", kit.getVersion());
  }
  
  private HttpRequest applyMultipartDataTo(HttpRequest paramHttpRequest, AppRequestData paramAppRequestData)
  {
    HttpRequest localHttpRequest = paramHttpRequest.part("app[identifier]", appId).part("app[name]", name).part("app[display_version]", displayVersion).part("app[build_version]", buildVersion).part("app[source]", Integer.valueOf(source)).part("app[minimum_sdk_version]", minSdkVersion).part("app[built_sdk_version]", builtSdkVersion);
    if (!CommonUtils.isNullOrEmpty(instanceIdentifier)) {
      localHttpRequest.part("app[instance_identifier]", instanceIdentifier);
    }
    Object localObject;
    if (icon != null)
    {
      localObject = null;
      paramHttpRequest = null;
    }
    try
    {
      InputStream localInputStream = kit.getContext().getResources().openRawResource(icon.iconResourceId);
      paramHttpRequest = localInputStream;
      localObject = localInputStream;
      localHttpRequest.part("app[icon][hash]", icon.hash).part("app[icon][data]", "icon.png", "application/octet-stream", localInputStream).part("app[icon][width]", Integer.valueOf(icon.width)).part("app[icon][height]", Integer.valueOf(icon.height));
      CommonUtils.closeOrLog(localInputStream, "Failed to close app icon InputStream.");
    }
    catch (Resources.NotFoundException localNotFoundException)
    {
      for (;;)
      {
        localObject = paramHttpRequest;
        Fabric.getLogger().e("Fabric", "Failed to find app icon with resource ID: " + icon.iconResourceId, localNotFoundException);
        CommonUtils.closeOrLog(paramHttpRequest, "Failed to close app icon InputStream.");
      }
    }
    finally
    {
      CommonUtils.closeOrLog((Closeable)localObject, "Failed to close app icon InputStream.");
    }
    if (sdkKits != null)
    {
      paramHttpRequest = sdkKits.iterator();
      while (paramHttpRequest.hasNext())
      {
        paramAppRequestData = (KitInfo)paramHttpRequest.next();
        localHttpRequest.part(getKitVersionKey(paramAppRequestData), paramAppRequestData.getVersion());
        localHttpRequest.part(getKitBuildTypeKey(paramAppRequestData), paramAppRequestData.getBuildType());
      }
    }
    return localHttpRequest;
  }
  
  String getKitBuildTypeKey(KitInfo paramKitInfo)
  {
    return String.format(Locale.US, "app[build][libraries][%s][type]", new Object[] { paramKitInfo.getIdentifier() });
  }
  
  String getKitVersionKey(KitInfo paramKitInfo)
  {
    return String.format(Locale.US, "app[build][libraries][%s][version]", new Object[] { paramKitInfo.getIdentifier() });
  }
  
  public boolean invoke(AppRequestData paramAppRequestData)
  {
    HttpRequest localHttpRequest = applyMultipartDataTo(applyHeadersTo(getHttpRequest(), paramAppRequestData), paramAppRequestData);
    Fabric.getLogger().d("Fabric", "Sending app info to " + getUrl());
    if (icon != null)
    {
      Fabric.getLogger().d("Fabric", "App icon hash is " + icon.hash);
      Fabric.getLogger().d("Fabric", "App icon size is " + icon.width + "x" + icon.height);
    }
    int i = localHttpRequest.code();
    if ("POST".equals(localHttpRequest.method())) {}
    for (paramAppRequestData = "Create";; paramAppRequestData = "Update")
    {
      Fabric.getLogger().d("Fabric", paramAppRequestData + " app request ID: " + localHttpRequest.header("X-REQUEST-ID"));
      Fabric.getLogger().d("Fabric", "Result was " + i);
      if (ResponseParser.parse(i) != 0) {
        break;
      }
      return true;
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     io.fabric.sdk.android.services.settings.AbstractAppSpiCall
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */