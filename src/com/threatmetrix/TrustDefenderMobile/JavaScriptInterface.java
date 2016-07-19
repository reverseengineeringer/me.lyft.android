package com.threatmetrix.TrustDefenderMobile;

import android.util.Log;
import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;

class JavaScriptInterface
  implements ValueCallback<String>
{
  private static final String TAG = StringUtils.getLogTag(JavaScriptInterface.class);
  CountDownLatch latch = null;
  public String returnedValue;
  public final ArrayList<String> returnedValues = new ArrayList();
  
  JavaScriptInterface(CountDownLatch paramCountDownLatch)
  {
    setLatch(paramCountDownLatch);
  }
  
  private void callback(String paramString1, String paramString2)
  {
    CountDownLatch localCountDownLatch;
    try
    {
      localCountDownLatch = latch;
      localObject1 = paramString1;
      Object localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = "null";
      }
      long l = 0L;
      if (localCountDownLatch != null) {
        l = localCountDownLatch.getCount();
      }
      Log.d(TAG, "in " + paramString2 + "(" + (String)localObject2 + ") count = " + l);
      returnedValue = paramString1;
      if (paramString1 == null) {
        returnedValues.add("");
      }
      for (;;)
      {
        if (localCountDownLatch == null) {
          break label289;
        }
        Log.d(TAG, "countdown latch: " + localCountDownLatch.hashCode() + " with count: " + localCountDownLatch.getCount());
        localCountDownLatch.countDown();
        paramString1 = paramString2;
        if (paramString2 == null) {
          paramString1 = "null";
        }
        if (localCountDownLatch != null) {
          break;
        }
        Log.d(TAG, "in " + paramString1 + "() with null latch");
        return;
        returnedValues.add(paramString1);
      }
      paramString2 = TAG;
    }
    catch (Exception paramString1)
    {
      Log.d(TAG, "Swallowing: ", paramString1);
      return;
    }
    Object localObject1 = new StringBuilder().append("in ").append(paramString1).append("() count = ").append(localCountDownLatch.getCount()).append(" and ");
    if (localCountDownLatch == latch) {}
    for (paramString1 = "latch constant";; paramString1 = "latch changed")
    {
      Log.d(paramString2, paramString1);
      return;
      label289:
      Log.e(TAG, "in " + paramString2 + "() latch == null");
      return;
    }
  }
  
  @JavascriptInterface
  public void getString(String paramString)
  {
    callback(paramString, "getString");
  }
  
  public void onReceiveValue(String paramString)
  {
    String str = paramString;
    if (paramString != null)
    {
      if ((paramString.length() != 2) || (!paramString.equals("\"\""))) {
        break label34;
      }
      str = "";
    }
    for (;;)
    {
      callback(str, "onReceiveValue");
      return;
      label34:
      str = paramString;
      if (paramString.length() > 1) {
        str = paramString.substring(1, paramString.length() - 1);
      }
    }
  }
  
  public void setLatch(CountDownLatch paramCountDownLatch)
  {
    if (latch != null)
    {
      Log.d(TAG, "existing latch: " + latch.hashCode() + " with count: " + latch.getCount());
      Log.d(TAG, "Setting latch when latch already has non-null value");
    }
    latch = paramCountDownLatch;
    if (latch != null) {
      Log.d(TAG, "new latch: " + paramCountDownLatch.hashCode() + " with count: " + paramCountDownLatch.getCount());
    }
  }
}

/* Location:
 * Qualified Name:     com.threatmetrix.TrustDefenderMobile.JavaScriptInterface
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */