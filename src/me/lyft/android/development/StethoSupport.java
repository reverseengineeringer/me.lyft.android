package me.lyft.android.development;

import android.app.Application;
import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.OkHttpClient;
import java.lang.reflect.Method;
import java.util.List;

public class StethoSupport
{
  public static void addStethoInterceptor(OkHttpClient paramOkHttpClient)
  {
    try
    {
      Interceptor localInterceptor = (Interceptor)getStethoProxyClass().getMethod("createNetworkInterceptor", new Class[0]).invoke(null, new Object[0]);
      paramOkHttpClient.networkInterceptors().add(localInterceptor);
      return;
    }
    catch (Throwable paramOkHttpClient) {}
  }
  
  private static Class<?> getStethoProxyClass()
    throws ClassNotFoundException
  {
    return Class.forName("me.lyft.android.development.proxies.StethoProxy");
  }
  
  public static void initStethoIfPresent(Application paramApplication)
  {
    try
    {
      getStethoProxyClass().getMethod("init", new Class[] { Application.class }).invoke(null, new Object[] { paramApplication });
      return;
    }
    catch (Throwable paramApplication) {}
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.development.StethoSupport
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */