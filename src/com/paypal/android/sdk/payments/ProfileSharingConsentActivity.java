package com.paypal.android.sdk.payments;

import android.app.Activity;
import android.content.Intent;

public final class ProfileSharingConsentActivity
  extends p
{
  private static final String d = ProfileSharingConsentActivity.class.getSimpleName();
  
  static void a(Activity paramActivity, int paramInt, PayPalConfiguration paramPayPalConfiguration)
  {
    Intent localIntent = new Intent(paramActivity, ProfileSharingConsentActivity.class);
    localIntent.putExtras(paramActivity.getIntent());
    localIntent.putExtra("com.paypal.android.sdk.paypalConfiguration", paramPayPalConfiguration);
    paramActivity.startActivityForResult(localIntent, 1);
  }
  
  protected final void a()
  {
    b = ((PayPalOAuthScopes)getIntent().getParcelableExtra("com.paypal.android.sdk.requested_scopes"));
  }
}

/* Location:
 * Qualified Name:     com.paypal.android.sdk.payments.ProfileSharingConsentActivity
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */