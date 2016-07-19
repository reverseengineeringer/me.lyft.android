package com.braintreepayments.api;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.braintreepayments.api.annotations.Beta;
import com.braintreepayments.api.data.BraintreeData;
import com.braintreepayments.api.data.BraintreeEnvironment;
import com.braintreepayments.api.exceptions.AppSwitchNotAvailableException;
import com.braintreepayments.api.exceptions.AuthenticationException;
import com.braintreepayments.api.exceptions.AuthorizationException;
import com.braintreepayments.api.exceptions.BraintreeException;
import com.braintreepayments.api.exceptions.ConfigurationException;
import com.braintreepayments.api.exceptions.DownForMaintenanceException;
import com.braintreepayments.api.exceptions.ErrorWithResponse;
import com.braintreepayments.api.exceptions.ServerException;
import com.braintreepayments.api.exceptions.UnexpectedException;
import com.braintreepayments.api.exceptions.UpgradeRequiredException;
import com.braintreepayments.api.internal.HttpRequest;
import com.braintreepayments.api.internal.HttpResponse;
import com.braintreepayments.api.models.AnalyticsRequest;
import com.braintreepayments.api.models.PayPalAccount;
import com.braintreepayments.api.models.PayPalAccountBuilder;
import com.braintreepayments.api.models.PaymentMethod;
import com.braintreepayments.api.models.PaymentMethod.Builder;
import com.braintreepayments.api.models.ThreeDSecureLookup;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class BraintreeApi
{
  private static final String PAYMENT_METHOD_ENDPOINT = "payment_methods";
  private BraintreeData mBraintreeData;
  private ClientToken mClientToken;
  private Context mContext;
  private HttpRequest mHttpRequest;
  private VenmoAppSwitch mVenmoAppSwitch;
  
  protected BraintreeApi(Context paramContext, ClientToken paramClientToken)
  {
    this(paramContext, paramClientToken, new HttpRequest(paramClientToken.getAuthorizationFingerprint()));
  }
  
  protected BraintreeApi(Context paramContext, ClientToken paramClientToken, HttpRequest paramHttpRequest)
  {
    mContext = paramContext;
    mClientToken = paramClientToken;
    mHttpRequest = paramHttpRequest;
    mVenmoAppSwitch = new VenmoAppSwitch(paramContext, paramClientToken);
  }
  
  public BraintreeApi(Context paramContext, String paramString)
  {
    this(paramContext, ClientToken.getClientToken(paramString));
  }
  
  private void checkAndThrowErrors(HttpResponse paramHttpResponse)
    throws ErrorWithResponse, BraintreeException
  {
    switch (paramHttpResponse.getResponseCode())
    {
    default: 
      throw new UnexpectedException();
    case 401: 
      throw new AuthenticationException();
    case 403: 
      throw new AuthorizationException();
    case 422: 
      throw new ErrorWithResponse(paramHttpResponse.getResponseCode(), paramHttpResponse.getResponseBody());
    case 426: 
      throw new UpgradeRequiredException();
    case 500: 
      throw new ServerException();
    case 503: 
      throw new DownForMaintenanceException();
    }
  }
  
  private String jsonForType(String paramString1, String paramString2)
    throws ServerException
  {
    try
    {
      paramString1 = new JSONObject(paramString1).getJSONArray(paramString2).get(0).toString();
      return paramString1;
    }
    catch (JSONException paramString1)
    {
      throw new ServerException("Parsing server response failed");
    }
  }
  
  private String versionedUrl(String paramString)
  {
    return mClientToken.getClientApiUrl() + "/v1/" + paramString;
  }
  
  public String collectDeviceData(Activity paramActivity, BraintreeEnvironment paramBraintreeEnvironment)
  {
    return collectDeviceData(paramActivity, paramBraintreeEnvironment.getMerchantId(), paramBraintreeEnvironment.getCollectorUrl());
  }
  
  public String collectDeviceData(Activity paramActivity, String paramString1, String paramString2)
  {
    mBraintreeData = new BraintreeData(paramActivity, paramString1, paramString2);
    return mBraintreeData.collectDeviceData();
  }
  
  public <T extends PaymentMethod> T create(PaymentMethod.Builder<T> paramBuilder)
    throws ErrorWithResponse, BraintreeException
  {
    HttpResponse localHttpResponse = mHttpRequest.post(versionedUrl("payment_methods/" + paramBuilder.getApiPath()), paramBuilder.toJsonString());
    checkAndThrowErrors(localHttpResponse);
    return paramBuilder.fromJson(jsonForType(localHttpResponse.getResponseBody(), paramBuilder.getApiResource()));
  }
  
  public PayPalAccount finishPayWithPayPal(int paramInt, Intent paramIntent)
    throws BraintreeException, ErrorWithResponse
  {
    Object localObject = null;
    PayPalAccountBuilder localPayPalAccountBuilder = handlePayPalResponse(null, paramInt, paramIntent);
    paramIntent = (Intent)localObject;
    if (localPayPalAccountBuilder != null) {
      paramIntent = (PayPalAccount)create(localPayPalAccountBuilder);
    }
    return paramIntent;
  }
  
  public PayPalAccount finishPayWithPayPal(Activity paramActivity, int paramInt, Intent paramIntent)
    throws BraintreeException, ErrorWithResponse
  {
    paramActivity = handlePayPalResponse(paramActivity, paramInt, paramIntent);
    if (paramActivity != null) {
      return (PayPalAccount)create(paramActivity);
    }
    return null;
  }
  
  public String finishPayWithVenmo(int paramInt, Intent paramIntent)
  {
    return mVenmoAppSwitch.handleAppSwitchResponse(paramInt, paramIntent);
  }
  
  protected PaymentMethod getPaymentMethod(String paramString)
    throws ErrorWithResponse, BraintreeException, JSONException
  {
    paramString = mHttpRequest.get(versionedUrl("payment_methods/" + paramString));
    checkAndThrowErrors(paramString);
    paramString = PaymentMethod.parsePaymentMethods(paramString.getResponseBody());
    if (paramString.size() == 1) {
      return (PaymentMethod)paramString.get(0);
    }
    if (paramString.size() > 1) {
      throw new ServerException("Expected one payment method, got multiple payment methods");
    }
    throw new ServerException("No payment methods were found for nonce");
  }
  
  public List<PaymentMethod> getPaymentMethods()
    throws ErrorWithResponse, BraintreeException
  {
    HttpResponse localHttpResponse = mHttpRequest.get(versionedUrl("payment_methods"));
    checkAndThrowErrors(localHttpResponse);
    return PaymentMethod.parsePaymentMethods(localHttpResponse.getResponseBody());
  }
  
  public PayPalAccountBuilder handlePayPalResponse(Activity paramActivity, int paramInt, Intent paramIntent)
    throws ConfigurationException
  {
    PayPalHelper.stopPaypalService(mContext);
    return PayPalHelper.getBuilderFromActivity(paramActivity, paramInt, paramIntent);
  }
  
  public boolean isCvvChallengePresent()
  {
    return mClientToken.isCvvChallengePresent();
  }
  
  public boolean isPayPalEnabled()
  {
    return mClientToken.isPayPalEnabled();
  }
  
  public boolean isPostalCodeChallengePresent()
  {
    return mClientToken.isPostalCodeChallengePresent();
  }
  
  @Beta
  public boolean isThreeDSecureEnabled()
  {
    return mClientToken.isThreeDSecureEnabled();
  }
  
  public boolean isVenmoEnabled()
  {
    return mVenmoAppSwitch.isAvailable();
  }
  
  public void sendAnalyticsEvent(String paramString1, String paramString2)
  {
    if (mClientToken.isAnalyticsEnabled()) {
      paramString1 = new AnalyticsRequest(mContext, paramString1, paramString2);
    }
    try
    {
      mHttpRequest.post(mClientToken.getAnalytics().getUrl(), paramString1.toJson());
      return;
    }
    catch (UnexpectedException paramString1) {}
  }
  
  public void startPayWithPayPal(Activity paramActivity, int paramInt)
  {
    PayPalHelper.startPaypal(paramActivity.getApplicationContext(), mClientToken);
    PayPalHelper.launchPayPal(paramActivity, paramInt, mClientToken);
  }
  
  public void startPayWithVenmo(Activity paramActivity, int paramInt)
    throws AppSwitchNotAvailableException
  {
    mVenmoAppSwitch.launch(paramActivity, paramInt);
  }
  
  @Beta
  public ThreeDSecureLookup threeDSecureLookup(String paramString1, String paramString2)
    throws JSONException, BraintreeException, ErrorWithResponse
  {
    paramString2 = new JSONObject().put("merchantAccountId", mClientToken.getMerchantAccountId()).put("amount", paramString2);
    paramString1 = mHttpRequest.post(versionedUrl("payment_methods/" + paramString1 + "/three_d_secure/lookup"), paramString2.toString());
    checkAndThrowErrors(paramString1);
    return ThreeDSecureLookup.fromJson(paramString1.getResponseBody());
  }
  
  public String tokenize(PaymentMethod.Builder paramBuilder)
    throws BraintreeException, ErrorWithResponse
  {
    return create(paramBuilder.validate(false)).getNonce();
  }
}

/* Location:
 * Qualified Name:     com.braintreepayments.api.BraintreeApi
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */