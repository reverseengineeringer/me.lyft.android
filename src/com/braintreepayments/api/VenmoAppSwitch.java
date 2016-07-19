package com.braintreepayments.api;

import android.content.Context;
import android.content.Intent;

public class VenmoAppSwitch
  extends AppSwitch
{
  public static final String VENMO_SOURCE = "venmo-app";
  
  public VenmoAppSwitch(Context paramContext, ClientToken paramClientToken)
  {
    super(paramContext, paramClientToken);
  }
  
  protected String getAppSwitchActivity()
  {
    return "CardChooserActivity";
  }
  
  protected String getCertificateIssuer()
  {
    return "CN=Andrew Kortina,OU=Engineering,O=Venmo,L=Philadelphia,ST=PA,C=US";
  }
  
  protected String getCertificateSubject()
  {
    return "CN=Andrew Kortina,OU=Engineering,O=Venmo,L=Philadelphia,ST=PA,C=US";
  }
  
  protected Intent getLaunchIntent()
  {
    Intent localIntent = super.getLaunchIntent().putExtra("com.braintreepayments.api.MERCHANT_ID", mClientToken.getMerchantId());
    if (mClientToken.getVenmoState().equals("offline")) {
      localIntent.putExtra("com.braintreepayments.api.OFFLINE", true);
    }
    while (!mClientToken.getVenmoState().equals("live")) {
      return localIntent;
    }
    localIntent.putExtra("com.braintreepayments.api.OFFLINE", false);
    return localIntent;
  }
  
  protected String getPackage()
  {
    return "com.venmo";
  }
  
  protected int getPublicKeyHashCode()
  {
    return -129711843;
  }
  
  protected String handleAppSwitchResponse(int paramInt, Intent paramIntent)
  {
    if (paramInt == -1) {
      return paramIntent.getStringExtra("com.braintreepayments.api.EXTRA_PAYMENT_METHOD_NONCE");
    }
    return null;
  }
  
  protected boolean isAvailable()
  {
    return (super.isAvailable()) && (!mClientToken.getVenmoState().equals("off"));
  }
}

/* Location:
 * Qualified Name:     com.braintreepayments.api.VenmoAppSwitch
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */