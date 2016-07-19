package com.braintreepayments.api;

import android.os.Handler;
import com.braintreepayments.api.exceptions.ErrorWithResponse;
import java.util.Iterator;
import java.util.Set;

class Braintree$12
  implements Braintree.ListenerCallback
{
  Braintree$12(Braintree paramBraintree, ErrorWithResponse paramErrorWithResponse) {}
  
  public void execute()
  {
    Iterator localIterator = Braintree.access$1100(this$0).iterator();
    while (localIterator.hasNext())
    {
      final Braintree.ErrorListener localErrorListener = (Braintree.ErrorListener)localIterator.next();
      Braintree.access$800(this$0).post(new Runnable()
      {
        public void run()
        {
          localErrorListener.onRecoverableError(val$error);
        }
      });
    }
  }
  
  public boolean hasListeners()
  {
    return !Braintree.access$1100(this$0).isEmpty();
  }
}

/* Location:
 * Qualified Name:     com.braintreepayments.api.Braintree.12
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */