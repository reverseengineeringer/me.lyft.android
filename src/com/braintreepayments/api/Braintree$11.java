package com.braintreepayments.api;

import android.os.Handler;
import java.util.Iterator;
import java.util.Set;

class Braintree$11
  implements Braintree.ListenerCallback
{
  Braintree$11(Braintree paramBraintree, Throwable paramThrowable) {}
  
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
          localErrorListener.onUnrecoverableError(val$throwable);
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
 * Qualified Name:     com.braintreepayments.api.Braintree.11
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */