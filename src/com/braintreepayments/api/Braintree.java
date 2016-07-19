package com.braintreepayments.api;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import com.braintreepayments.api.annotations.Beta;
import com.braintreepayments.api.data.BraintreeEnvironment;
import com.braintreepayments.api.exceptions.AppSwitchNotAvailableException;
import com.braintreepayments.api.exceptions.BraintreeException;
import com.braintreepayments.api.exceptions.ConfigurationException;
import com.braintreepayments.api.exceptions.ErrorWithResponse;
import com.braintreepayments.api.models.Card;
import com.braintreepayments.api.models.CardBuilder;
import com.braintreepayments.api.models.PayPalAccountBuilder;
import com.braintreepayments.api.models.PaymentMethod;
import com.braintreepayments.api.models.PaymentMethod.Builder;
import com.braintreepayments.api.models.ThreeDSecureAuthenticationResponse;
import com.braintreepayments.api.models.ThreeDSecureLookup;
import com.braintreepayments.api.threedsecure.ThreeDSecureWebViewActivity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import org.json.JSONException;

public class Braintree
{
  protected static final String INTEGRATION_DROPIN = "dropin";
  protected static final Map<String, Braintree> sInstances = new HashMap();
  private final BraintreeApi mBraintreeApi;
  private List<PaymentMethod> mCachedPaymentMethods;
  private final List<ListenerCallback> mCallbackQueue = new LinkedList();
  private final Set<PaymentMethodCreatedListener> mCreatedListeners = new HashSet();
  private final Set<ErrorListener> mErrorListeners = new HashSet();
  private final ExecutorService mExecutorService;
  private String mIntegrationType;
  private final Handler mListenerHandler = new Handler(Looper.getMainLooper());
  private boolean mListenersLocked = false;
  private final Set<PaymentMethodNonceListener> mNonceListeners = new HashSet();
  private final Set<PaymentMethodsUpdatedListener> mUpdatedListeners = new HashSet();
  
  protected Braintree(String paramString, BraintreeApi paramBraintreeApi)
  {
    mBraintreeApi = paramBraintreeApi;
    mExecutorService = Executors.newSingleThreadExecutor();
    mIntegrationType = "custom";
    sInstances.put(paramString, this);
  }
  
  private void addPaymentMethodToCache(PaymentMethod paramPaymentMethod)
  {
    if (mCachedPaymentMethods == null) {
      mCachedPaymentMethods = new ArrayList();
    }
    mCachedPaymentMethods.add(0, paramPaymentMethod);
  }
  
  public static Braintree getInstance(Context paramContext, String paramString)
  {
    if (sInstances.containsKey(paramString)) {
      return (Braintree)sInstances.get(paramString);
    }
    return new Braintree(paramString, new BraintreeApi(paramContext.getApplicationContext(), paramString));
  }
  
  private void postCreatedMethodToListeners(final PaymentMethod paramPaymentMethod)
  {
    try
    {
      postOrQueueCallback(new ListenerCallback()
      {
        public void execute()
        {
          Iterator localIterator = mCreatedListeners.iterator();
          while (localIterator.hasNext())
          {
            final Braintree.PaymentMethodCreatedListener localPaymentMethodCreatedListener = (Braintree.PaymentMethodCreatedListener)localIterator.next();
            mListenerHandler.post(new Runnable()
            {
              public void run()
              {
                localPaymentMethodCreatedListener.onPaymentMethodCreated(val$paymentMethod);
              }
            });
          }
        }
        
        public boolean hasListeners()
        {
          return !mCreatedListeners.isEmpty();
        }
      });
      return;
    }
    finally
    {
      paramPaymentMethod = finally;
      throw paramPaymentMethod;
    }
  }
  
  private void postCreatedNonceToListeners(final String paramString)
  {
    try
    {
      postOrQueueCallback(new ListenerCallback()
      {
        public void execute()
        {
          Iterator localIterator = mNonceListeners.iterator();
          while (localIterator.hasNext())
          {
            final Braintree.PaymentMethodNonceListener localPaymentMethodNonceListener = (Braintree.PaymentMethodNonceListener)localIterator.next();
            mListenerHandler.post(new Runnable()
            {
              public void run()
              {
                localPaymentMethodNonceListener.onPaymentMethodNonce(val$nonce);
              }
            });
          }
        }
        
        public boolean hasListeners()
        {
          return !mNonceListeners.isEmpty();
        }
      });
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  private void postPaymentMethodsToListeners(List<PaymentMethod> paramList)
  {
    try
    {
      postOrQueueCallback(new ListenerCallback()
      {
        public void execute()
        {
          Iterator localIterator = mUpdatedListeners.iterator();
          while (localIterator.hasNext())
          {
            final Braintree.PaymentMethodsUpdatedListener localPaymentMethodsUpdatedListener = (Braintree.PaymentMethodsUpdatedListener)localIterator.next();
            mListenerHandler.post(new Runnable()
            {
              public void run()
              {
                localPaymentMethodsUpdatedListener.onPaymentMethodsUpdated(val$paymentMethodsSafe);
              }
            });
          }
        }
        
        public boolean hasListeners()
        {
          return !mUpdatedListeners.isEmpty();
        }
      });
      return;
    }
    finally
    {
      paramList = finally;
      throw paramList;
    }
  }
  
  private void postRecoverableErrorToListeners(final ErrorWithResponse paramErrorWithResponse)
  {
    try
    {
      postOrQueueCallback(new ListenerCallback()
      {
        public void execute()
        {
          Iterator localIterator = mErrorListeners.iterator();
          while (localIterator.hasNext())
          {
            final Braintree.ErrorListener localErrorListener = (Braintree.ErrorListener)localIterator.next();
            mListenerHandler.post(new Runnable()
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
          return !mErrorListeners.isEmpty();
        }
      });
      return;
    }
    finally
    {
      paramErrorWithResponse = finally;
      throw paramErrorWithResponse;
    }
  }
  
  public static void reset()
  {
    sInstances.clear();
  }
  
  public <T extends Listener> void addListener(T paramT)
  {
    try
    {
      if ((paramT instanceof PaymentMethodsUpdatedListener)) {
        mUpdatedListeners.add((PaymentMethodsUpdatedListener)paramT);
      }
      if ((paramT instanceof PaymentMethodCreatedListener)) {
        mCreatedListeners.add((PaymentMethodCreatedListener)paramT);
      }
      if ((paramT instanceof PaymentMethodNonceListener)) {
        mNonceListeners.add((PaymentMethodNonceListener)paramT);
      }
      if ((paramT instanceof ErrorListener)) {
        mErrorListeners.add((ErrorListener)paramT);
      }
      return;
    }
    finally {}
  }
  
  protected String analyticsPrefix()
  {
    return mIntegrationType + ".android";
  }
  
  public String collectDeviceData(Activity paramActivity, BraintreeEnvironment paramBraintreeEnvironment)
  {
    return mBraintreeApi.collectDeviceData(paramActivity, paramBraintreeEnvironment);
  }
  
  public String collectDeviceData(Activity paramActivity, String paramString1, String paramString2)
  {
    return mBraintreeApi.collectDeviceData(paramActivity, paramString1, paramString2);
  }
  
  public <T extends PaymentMethod> void create(PaymentMethod.Builder<T> paramBuilder)
  {
    try
    {
      createHelper(paramBuilder);
      return;
    }
    finally
    {
      paramBuilder = finally;
      throw paramBuilder;
    }
  }
  
  protected <T extends PaymentMethod> Future<?> createHelper(final PaymentMethod.Builder<T> paramBuilder)
  {
    try
    {
      paramBuilder = mExecutorService.submit(new Runnable()
      {
        public void run()
        {
          try
          {
            PaymentMethod localPaymentMethod = mBraintreeApi.create(paramBuilder);
            Braintree.this.addPaymentMethodToCache(localPaymentMethod);
            Braintree.this.postCreatedMethodToListeners(localPaymentMethod);
            Braintree.this.postCreatedNonceToListeners(localPaymentMethod.getNonce());
            return;
          }
          catch (BraintreeException localBraintreeException)
          {
            postUnrecoverableErrorToListeners(localBraintreeException);
            return;
          }
          catch (ErrorWithResponse localErrorWithResponse)
          {
            Braintree.this.postRecoverableErrorToListeners(localErrorWithResponse);
          }
        }
      });
      return paramBuilder;
    }
    finally
    {
      paramBuilder = finally;
      throw paramBuilder;
    }
  }
  
  public void finishPayWithPayPal(int paramInt, Intent paramIntent)
  {
    try
    {
      paramIntent = mBraintreeApi.handlePayPalResponse(null, paramInt, paramIntent);
      if (paramIntent != null) {
        create(paramIntent);
      }
    }
    catch (ConfigurationException paramIntent)
    {
      for (;;)
      {
        postUnrecoverableErrorToListeners(paramIntent);
      }
    }
    finally {}
  }
  
  public void finishPayWithPayPal(Activity paramActivity, int paramInt, Intent paramIntent)
  {
    try
    {
      paramActivity = mBraintreeApi.handlePayPalResponse(paramActivity, paramInt, paramIntent);
      if (paramActivity != null) {
        create(paramActivity);
      }
    }
    catch (ConfigurationException paramActivity)
    {
      for (;;)
      {
        postUnrecoverableErrorToListeners(paramActivity);
      }
    }
    finally {}
  }
  
  /* Error */
  public void finishPayWithVenmo(int paramInt, final Intent paramIntent)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 131	com/braintreepayments/api/Braintree:mBraintreeApi	Lcom/braintreepayments/api/BraintreeApi;
    //   6: iload_1
    //   7: aload_2
    //   8: invokevirtual 310	com/braintreepayments/api/BraintreeApi:finishPayWithVenmo	(ILandroid/content/Intent;)Ljava/lang/String;
    //   11: astore_2
    //   12: aload_2
    //   13: invokestatic 316	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   16: ifne +25 -> 41
    //   19: aload_0
    //   20: getfield 139	com/braintreepayments/api/Braintree:mExecutorService	Ljava/util/concurrent/ExecutorService;
    //   23: new 20	com/braintreepayments/api/Braintree$2
    //   26: dup
    //   27: aload_0
    //   28: aload_2
    //   29: invokespecial 317	com/braintreepayments/api/Braintree$2:<init>	(Lcom/braintreepayments/api/Braintree;Ljava/lang/String;)V
    //   32: invokeinterface 290 2 0
    //   37: pop
    //   38: aload_0
    //   39: monitorexit
    //   40: return
    //   41: aload_0
    //   42: ldc_w 319
    //   45: invokevirtual 322	com/braintreepayments/api/Braintree:sendAnalyticsEvent	(Ljava/lang/String;)V
    //   48: goto -10 -> 38
    //   51: astore_2
    //   52: aload_0
    //   53: monitorexit
    //   54: aload_2
    //   55: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	56	0	this	Braintree
    //   0	56	1	paramInt	int
    //   0	56	2	paramIntent	Intent
    // Exception table:
    //   from	to	target	type
    //   2	38	51	finally
    //   41	48	51	finally
  }
  
  @Beta
  public void finishThreeDSecureVerification(int paramInt, Intent paramIntent)
  {
    if (paramInt == -1) {}
    for (;;)
    {
      try
      {
        paramIntent = (ThreeDSecureAuthenticationResponse)paramIntent.getParcelableExtra("com.braintreepayments.api.EXTRA_THREE_D_SECURE_RESULT");
        if (paramIntent.isSuccess())
        {
          postCreatedMethodToListeners(paramIntent.getCard());
          postCreatedNonceToListeners(paramIntent.getCard().getNonce());
          return;
        }
        if (paramIntent.getException() != null) {
          postUnrecoverableErrorToListeners(new BraintreeException(paramIntent.getException()));
        } else {
          postRecoverableErrorToListeners(new ErrorWithResponse(422, paramIntent.getErrors()));
        }
      }
      finally {}
    }
  }
  
  /* Error */
  public List<PaymentMethod> getCachedPaymentMethods()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 157	com/braintreepayments/api/Braintree:mCachedPaymentMethods	Ljava/util/List;
    //   6: ifnonnull +11 -> 17
    //   9: invokestatic 369	java/util/Collections:emptyList	()Ljava/util/List;
    //   12: astore_1
    //   13: aload_0
    //   14: monitorexit
    //   15: aload_1
    //   16: areturn
    //   17: aload_0
    //   18: getfield 157	com/braintreepayments/api/Braintree:mCachedPaymentMethods	Ljava/util/List;
    //   21: invokestatic 236	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   24: astore_1
    //   25: goto -12 -> 13
    //   28: astore_1
    //   29: aload_0
    //   30: monitorexit
    //   31: aload_1
    //   32: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	33	0	this	Braintree
    //   12	13	1	localList	List
    //   28	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	13	28	finally
    //   17	25	28	finally
  }
  
  protected String getIntegrationType()
  {
    return mIntegrationType;
  }
  
  public void getPaymentMethods()
  {
    try
    {
      getPaymentMethodsHelper();
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  protected Future<?> getPaymentMethodsHelper()
  {
    try
    {
      Future localFuture = mExecutorService.submit(new Runnable()
      {
        public void run()
        {
          try
          {
            List localList = mBraintreeApi.getPaymentMethods();
            Braintree.access$102(Braintree.this, localList);
            Braintree.this.postPaymentMethodsToListeners(localList);
            return;
          }
          catch (BraintreeException localBraintreeException)
          {
            postUnrecoverableErrorToListeners(localBraintreeException);
            return;
          }
          catch (ErrorWithResponse localErrorWithResponse)
          {
            Braintree.this.postRecoverableErrorToListeners(localErrorWithResponse);
          }
        }
      });
      return localFuture;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public PayPalAccountBuilder handlePayPalResponse(Activity paramActivity, int paramInt, Intent paramIntent)
  {
    try
    {
      paramActivity = mBraintreeApi.handlePayPalResponse(paramActivity, paramInt, paramIntent);
      return paramActivity;
    }
    catch (ConfigurationException paramActivity)
    {
      postUnrecoverableErrorToListeners(paramActivity);
    }
    return null;
  }
  
  /* Error */
  public boolean hasCachedCards()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 157	com/braintreepayments/api/Braintree:mCachedPaymentMethods	Ljava/util/List;
    //   6: astore_2
    //   7: aload_2
    //   8: ifnull +9 -> 17
    //   11: iconst_1
    //   12: istore_1
    //   13: aload_0
    //   14: monitorexit
    //   15: iload_1
    //   16: ireturn
    //   17: iconst_0
    //   18: istore_1
    //   19: goto -6 -> 13
    //   22: astore_2
    //   23: aload_0
    //   24: monitorexit
    //   25: aload_2
    //   26: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	27	0	this	Braintree
    //   12	7	1	bool	boolean
    //   6	2	2	localList	List
    //   22	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	22	finally
  }
  
  public boolean isCvvChallenegePresent()
  {
    return mBraintreeApi.isCvvChallengePresent();
  }
  
  public boolean isPayPalEnabled()
  {
    return mBraintreeApi.isPayPalEnabled();
  }
  
  public boolean isPostalCodeChallengePresent()
  {
    return mBraintreeApi.isPostalCodeChallengePresent();
  }
  
  @Beta
  public boolean isThreeDSecureEnabled()
  {
    return mBraintreeApi.isThreeDSecureEnabled();
  }
  
  public boolean isVenmoEnabled()
  {
    return mBraintreeApi.isVenmoEnabled();
  }
  
  public void lockListeners()
  {
    try
    {
      mListenersLocked = true;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  protected void postOrQueueCallback(ListenerCallback paramListenerCallback)
  {
    if ((mListenersLocked) || (!paramListenerCallback.hasListeners()))
    {
      mCallbackQueue.add(paramListenerCallback);
      return;
    }
    paramListenerCallback.execute();
  }
  
  protected void postUnrecoverableErrorToListeners(final Throwable paramThrowable)
  {
    try
    {
      postOrQueueCallback(new ListenerCallback()
      {
        public void execute()
        {
          Iterator localIterator = mErrorListeners.iterator();
          while (localIterator.hasNext())
          {
            final Braintree.ErrorListener localErrorListener = (Braintree.ErrorListener)localIterator.next();
            mListenerHandler.post(new Runnable()
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
          return !mErrorListeners.isEmpty();
        }
      });
      return;
    }
    finally
    {
      paramThrowable = finally;
      throw paramThrowable;
    }
  }
  
  public <T extends Listener> void removeListener(T paramT)
  {
    try
    {
      if ((paramT instanceof PaymentMethodsUpdatedListener)) {
        mUpdatedListeners.remove(paramT);
      }
      if ((paramT instanceof PaymentMethodCreatedListener)) {
        mCreatedListeners.remove(paramT);
      }
      if ((paramT instanceof PaymentMethodNonceListener)) {
        mNonceListeners.remove(paramT);
      }
      if ((paramT instanceof ErrorListener)) {
        mErrorListeners.remove(paramT);
      }
      return;
    }
    finally {}
  }
  
  public void sendAnalyticsEvent(String paramString)
  {
    try
    {
      sendAnalyticsEventHelper(analyticsPrefix() + "." + paramString, getIntegrationType());
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void sendAnalyticsEvent(String paramString1, String paramString2)
  {
    try
    {
      sendAnalyticsEventHelper(paramString1, paramString2);
      return;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  protected Future<?> sendAnalyticsEventHelper(final String paramString1, final String paramString2)
  {
    try
    {
      paramString1 = mExecutorService.submit(new Runnable()
      {
        public void run()
        {
          mBraintreeApi.sendAnalyticsEvent(paramString1, paramString2);
        }
      });
      return paramString1;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  public void setIntegrationDropin()
  {
    mIntegrationType = "dropin";
  }
  
  public void startPayWithPayPal(Activity paramActivity, int paramInt)
  {
    sendAnalyticsEvent("add-paypal.start");
    mBraintreeApi.startPayWithPayPal(paramActivity, paramInt);
  }
  
  public void startPayWithVenmo(Activity paramActivity, int paramInt)
  {
    try
    {
      mBraintreeApi.startPayWithVenmo(paramActivity, paramInt);
      sendAnalyticsEvent("add-venmo.start");
      return;
    }
    catch (AppSwitchNotAvailableException paramActivity)
    {
      sendAnalyticsEvent("add-venmo.unavailable");
      postUnrecoverableErrorToListeners(paramActivity);
    }
  }
  
  @Beta
  public void startThreeDSecureVerification(final Activity paramActivity, final int paramInt, final CardBuilder paramCardBuilder, final String paramString)
  {
    try
    {
      mExecutorService.submit(new Runnable()
      {
        public void run()
        {
          try
          {
            String str = mBraintreeApi.tokenize(paramCardBuilder);
            startThreeDSecureVerification(paramActivity, paramInt, str, paramString);
            return;
          }
          catch (BraintreeException localBraintreeException)
          {
            postUnrecoverableErrorToListeners(localBraintreeException);
            return;
          }
          catch (ErrorWithResponse localErrorWithResponse)
          {
            Braintree.this.postRecoverableErrorToListeners(localErrorWithResponse);
          }
        }
      });
      return;
    }
    finally
    {
      paramActivity = finally;
      throw paramActivity;
    }
  }
  
  @Beta
  public void startThreeDSecureVerification(final Activity paramActivity, final int paramInt, final String paramString1, final String paramString2)
  {
    try
    {
      mExecutorService.submit(new Runnable()
      {
        public void run()
        {
          try
          {
            Object localObject = mBraintreeApi.threeDSecureLookup(paramString1, paramString2);
            if (((ThreeDSecureLookup)localObject).getAcsUrl() != null)
            {
              localObject = new Intent(paramActivity, ThreeDSecureWebViewActivity.class).putExtra("com.braintreepayments.api.EXTRA_THREE_D_SECURE_LOOKUP", (Parcelable)localObject);
              paramActivity.startActivityForResult((Intent)localObject, paramInt);
              return;
            }
            Braintree.this.postCreatedMethodToListeners(((ThreeDSecureLookup)localObject).getCard());
            Braintree.this.postCreatedNonceToListeners(((ThreeDSecureLookup)localObject).getCard().getNonce());
            return;
          }
          catch (BraintreeException localBraintreeException)
          {
            postUnrecoverableErrorToListeners(localBraintreeException);
            return;
          }
          catch (JSONException localJSONException)
          {
            postUnrecoverableErrorToListeners(localJSONException);
            return;
          }
          catch (ErrorWithResponse localErrorWithResponse)
          {
            Braintree.this.postRecoverableErrorToListeners(localErrorWithResponse);
          }
        }
      });
      return;
    }
    finally
    {
      paramActivity = finally;
      throw paramActivity;
    }
  }
  
  public <T extends PaymentMethod> void tokenize(PaymentMethod.Builder<T> paramBuilder)
  {
    try
    {
      tokenizeHelper(paramBuilder);
      return;
    }
    finally
    {
      paramBuilder = finally;
      throw paramBuilder;
    }
  }
  
  protected <T extends PaymentMethod> Future<?> tokenizeHelper(final PaymentMethod.Builder<T> paramBuilder)
  {
    try
    {
      paramBuilder = mExecutorService.submit(new Runnable()
      {
        public void run()
        {
          try
          {
            String str = mBraintreeApi.tokenize(paramBuilder);
            Braintree.this.postCreatedNonceToListeners(str);
            return;
          }
          catch (BraintreeException localBraintreeException)
          {
            postUnrecoverableErrorToListeners(localBraintreeException);
            return;
          }
          catch (ErrorWithResponse localErrorWithResponse)
          {
            Braintree.this.postRecoverableErrorToListeners(localErrorWithResponse);
          }
        }
      });
      return paramBuilder;
    }
    finally
    {
      paramBuilder = finally;
      throw paramBuilder;
    }
  }
  
  public void unlockListeners()
  {
    try
    {
      mListenersLocked = false;
      Object localObject1 = new ArrayList();
      ((List)localObject1).addAll(mCallbackQueue);
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        ListenerCallback localListenerCallback = (ListenerCallback)((Iterator)localObject1).next();
        if (localListenerCallback.hasListeners())
        {
          localListenerCallback.execute();
          mCallbackQueue.remove(localListenerCallback);
        }
      }
    }
    finally {}
  }
  
  public static abstract interface ErrorListener
    extends Braintree.Listener
  {
    public abstract void onRecoverableError(ErrorWithResponse paramErrorWithResponse);
    
    public abstract void onUnrecoverableError(Throwable paramThrowable);
  }
  
  private static abstract interface Listener {}
  
  protected static abstract interface ListenerCallback
  {
    public abstract void execute();
    
    public abstract boolean hasListeners();
  }
  
  public static abstract interface PaymentMethodCreatedListener
    extends Braintree.Listener
  {
    public abstract void onPaymentMethodCreated(PaymentMethod paramPaymentMethod);
  }
  
  public static abstract interface PaymentMethodNonceListener
    extends Braintree.Listener
  {
    public abstract void onPaymentMethodNonce(String paramString);
  }
  
  public static abstract interface PaymentMethodsUpdatedListener
    extends Braintree.Listener
  {
    public abstract void onPaymentMethodsUpdated(List<PaymentMethod> paramList);
  }
}

/* Location:
 * Qualified Name:     com.braintreepayments.api.Braintree
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */