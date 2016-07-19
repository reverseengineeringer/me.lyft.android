package com.braintreepayments.api.data;

import android.app.Activity;
import android.content.Context;
import com.devicecollector.DeviceCollector;
import java.lang.reflect.Method;
import java.util.UUID;

public final class BraintreeData
{
  private DeviceCollector deviceCollector;
  private String mCorrelationId;
  private String mDeviceSessionId;
  private String mFraudMerchantId;
  
  public BraintreeData(Activity paramActivity, BraintreeEnvironment paramBraintreeEnvironment)
  {
    this(paramActivity, paramBraintreeEnvironment.getMerchantId(), paramBraintreeEnvironment.getCollectorUrl());
  }
  
  public BraintreeData(Activity paramActivity, String paramString1, String paramString2)
  {
    mFraudMerchantId = paramString1;
    mCorrelationId = getCorrelationId(paramActivity);
    deviceCollector = new DeviceCollector(paramActivity);
    deviceCollector.setMerchantId(mFraudMerchantId);
    deviceCollector.setCollectorUrl(paramString2);
  }
  
  private String getCorrelationId(Activity paramActivity)
  {
    try
    {
      paramActivity = (String)getClass().getClassLoader().loadClass("com.paypal.android.sdk.payments.PayPalConfiguration").getMethod("getClientMetadataId", new Class[] { Context.class }).invoke(null, new Object[] { paramActivity });
      return paramActivity;
    }
    catch (Exception paramActivity) {}
    return null;
  }
  
  public String collectDeviceData()
  {
    if (mDeviceSessionId == null)
    {
      mDeviceSessionId = UUID.randomUUID().toString().replace("-", "");
      deviceCollector.collect(mDeviceSessionId);
    }
    String str = "{\"device_session_id\":\"" + mDeviceSessionId + "\"," + "\"fraud_merchant_id\":\"" + mFraudMerchantId + "\"";
    if (mCorrelationId != null) {
      return str + ",\"correlation_id\": \"" + mCorrelationId + "\"}";
    }
    return str + "}";
  }
}

/* Location:
 * Qualified Name:     com.braintreepayments.api.data.BraintreeData
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */