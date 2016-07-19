package me.lyft.android.jobs;

import com.squareup.okhttp.OkHttpClient;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;
import javax.inject.Inject;
import me.lyft.android.ILyftPreferences;
import me.lyft.android.common.Strings;

public class ConfigureProxyJob
  implements Job
{
  private String ip;
  @Inject
  ILyftPreferences lyftPreferences;
  @Inject
  OkHttpClient okHttpClient;
  
  public ConfigureProxyJob(String paramString)
  {
    ip = paramString;
  }
  
  public void execute()
    throws Throwable
  {
    if (Strings.isNullOrEmpty(ip))
    {
      okHttpClient.setProxy(Proxy.NO_PROXY);
      lyftPreferences.setProxyEnabled(Boolean.valueOf(false));
      return;
    }
    okHttpClient.setProxy(new Proxy(Proxy.Type.HTTP, new InetSocketAddress(ip, 8888)));
    lyftPreferences.setProxyEnabled(Boolean.valueOf(true));
    lyftPreferences.setProxyIpAddress(ip);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.jobs.ConfigureProxyJob
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */