package com.braintreepayments.api;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.braintreepayments.api.exceptions.ConfigurationException;
import com.braintreepayments.api.models.PayPalAccountBuilder;
import com.paypal.android.sdk.payments.PayPalAuthorization;
import com.paypal.android.sdk.payments.PayPalConfiguration;
import com.paypal.android.sdk.payments.PayPalOAuthScopes;
import com.paypal.android.sdk.payments.PayPalProfileSharingActivity;
import com.paypal.android.sdk.payments.PayPalService;
import com.paypal.android.sdk.payments.PayPalTouch;
import com.paypal.android.sdk.payments.PayPalTouchActivity;
import com.paypal.android.sdk.payments.PayPalTouchConfirmation;
import java.util.Arrays;
import java.util.HashSet;
import org.json.JSONException;
import org.json.JSONObject;

public class PayPalHelper
{
  private static final String OFFLINE = "offline";
  protected static boolean sEnableSignatureVerification = true;
  
  private PayPalHelper()
  {
    throw new IllegalStateException("Non-instantiable class.");
  }
  
  protected static PayPalConfiguration buildPayPalConfiguration(ClientToken paramClientToken)
  {
    PayPalConfiguration localPayPalConfiguration = new PayPalConfiguration();
    paramClientToken = paramClientToken.getPayPal();
    if (paramClientToken.getEnvironment().equals("live")) {
      localPayPalConfiguration.environment("live");
    }
    for (;;)
    {
      return localPayPalConfiguration.clientId(paramClientToken.getClientId()).merchantName(paramClientToken.getDisplayName()).merchantUserAgreementUri(Uri.parse(paramClientToken.getUserAgreementUrl())).merchantPrivacyPolicyUri(Uri.parse(paramClientToken.getPrivacyUrl()));
      if (paramClientToken.getEnvironment().equals("offline")) {
        localPayPalConfiguration.environment("mock");
      } else {
        localPayPalConfiguration.environment(paramClientToken.getEnvironment());
      }
    }
  }
  
  protected static Intent buildPayPalServiceIntent(Context paramContext, ClientToken paramClientToken)
  {
    paramContext = new Intent(paramContext, PayPalService.class);
    paramContext.putExtra("com.paypal.android.sdk.paypalConfiguration", buildPayPalConfiguration(paramClientToken));
    paramContext.putExtra("com.paypal.android.sdk.enableAuthenticatorSecurity", sEnableSignatureVerification);
    if (paramClientToken.getPayPal().getEnvironment().equals("custom"))
    {
      paramContext.putExtra("com.paypal.android.sdk.baseEnvironmentUrl", paramClientToken.getPayPal().getDirectBaseUrl());
      paramContext.putExtra("com.paypal.android.sdk.enableStageSsl", false);
    }
    return paramContext;
  }
  
  public static PayPalAccountBuilder getBuilderFromActivity(Activity paramActivity, int paramInt, Intent paramIntent)
    throws ConfigurationException
  {
    if (paramInt == -1)
    {
      PayPalAccountBuilder localPayPalAccountBuilder = new PayPalAccountBuilder();
      if (paramActivity != null) {
        localPayPalAccountBuilder.correlationId(PayPalConfiguration.getClientMetadataId(paramActivity));
      }
      paramActivity = (PayPalTouchConfirmation)paramIntent.getParcelableExtra("com.paypal.android.sdk.loginConfirmation");
      if (paramActivity != null) {
        try
        {
          paramActivity = paramActivity.toJSONObject().getJSONObject("response");
          localPayPalAccountBuilder.authorizationCode(paramActivity.optString("authorization_code")).source("paypal-app");
          localPayPalAccountBuilder.email(paramActivity.optString("email"));
          return localPayPalAccountBuilder;
        }
        catch (JSONException paramActivity)
        {
          return null;
        }
      }
      paramActivity = (PayPalAuthorization)paramIntent.getParcelableExtra("com.paypal.android.sdk.authorization");
      localPayPalAccountBuilder.authorizationCode(paramActivity.getAuthorizationCode()).source("paypal-sdk");
      try
      {
        localPayPalAccountBuilder.email(paramActivity.toJSONObject().getJSONObject("user").getString("display_string"));
        return localPayPalAccountBuilder;
      }
      catch (JSONException paramActivity)
      {
        return localPayPalAccountBuilder;
      }
    }
    if (paramInt == 2) {
      throw new ConfigurationException();
    }
    return null;
  }
  
  public static boolean isPayPalIntent(Intent paramIntent)
  {
    return (paramIntent.getParcelableExtra("com.paypal.android.sdk.loginConfirmation") != null) || (paramIntent.getParcelableExtra("com.paypal.android.sdk.authorization") != null);
  }
  
  protected static void launchPayPal(Activity paramActivity, int paramInt, ClientToken paramClientToken)
  {
    if ((PayPalTouch.available(paramActivity.getBaseContext(), sEnableSignatureVerification)) && (!paramClientToken.getPayPal().getEnvironment().equals("offline")) && (!paramClientToken.getPayPal().getTouchDisabled())) {}
    for (Object localObject = PayPalTouchActivity.class;; localObject = PayPalProfileSharingActivity.class)
    {
      localObject = new Intent(paramActivity, (Class)localObject);
      ((Intent)localObject).putExtra("com.paypal.android.sdk.requested_scopes", new PayPalOAuthScopes(new HashSet(Arrays.asList(new String[] { PayPalOAuthScopes.PAYPAL_SCOPE_EMAIL, PayPalOAuthScopes.PAYPAL_SCOPE_FUTURE_PAYMENTS }))));
      ((Intent)localObject).putExtra("com.paypal.android.sdk.paypalConfiguration", buildPayPalConfiguration(paramClientToken));
      paramActivity.startActivityForResult((Intent)localObject, paramInt);
      return;
    }
  }
  
  protected static void startPaypal(Context paramContext, ClientToken paramClientToken)
  {
    stopPaypalService(paramContext);
    paramContext.startService(buildPayPalServiceIntent(paramContext, paramClientToken));
  }
  
  protected static void stopPaypalService(Context paramContext)
  {
    paramContext.stopService(new Intent(paramContext, PayPalService.class));
  }
}

/* Location:
 * Qualified Name:     com.braintreepayments.api.PayPalHelper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */