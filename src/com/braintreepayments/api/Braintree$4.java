package com.braintreepayments.api;

import android.app.Activity;
import android.content.Intent;
import android.os.Parcelable;
import com.braintreepayments.api.exceptions.BraintreeException;
import com.braintreepayments.api.exceptions.ErrorWithResponse;
import com.braintreepayments.api.models.Card;
import com.braintreepayments.api.models.ThreeDSecureLookup;
import com.braintreepayments.api.threedsecure.ThreeDSecureWebViewActivity;
import org.json.JSONException;

class Braintree$4
  implements Runnable
{
  Braintree$4(Braintree paramBraintree, String paramString1, String paramString2, Activity paramActivity, int paramInt) {}
  
  public void run()
  {
    try
    {
      Object localObject = Braintree.access$000(this$0).threeDSecureLookup(val$nonce, val$amount);
      if (((ThreeDSecureLookup)localObject).getAcsUrl() != null)
      {
        localObject = new Intent(val$activity, ThreeDSecureWebViewActivity.class).putExtra("com.braintreepayments.api.EXTRA_THREE_D_SECURE_LOOKUP", (Parcelable)localObject);
        val$activity.startActivityForResult((Intent)localObject, val$requestCode);
        return;
      }
      Braintree.access$500(this$0, ((ThreeDSecureLookup)localObject).getCard());
      Braintree.access$600(this$0, ((ThreeDSecureLookup)localObject).getCard().getNonce());
      return;
    }
    catch (BraintreeException localBraintreeException)
    {
      this$0.postUnrecoverableErrorToListeners(localBraintreeException);
      return;
    }
    catch (JSONException localJSONException)
    {
      this$0.postUnrecoverableErrorToListeners(localJSONException);
      return;
    }
    catch (ErrorWithResponse localErrorWithResponse)
    {
      Braintree.access$300(this$0, localErrorWithResponse);
    }
  }
}

/* Location:
 * Qualified Name:     com.braintreepayments.api.Braintree.4
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */