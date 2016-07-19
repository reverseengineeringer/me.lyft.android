package com.threatmetrix.TrustDefenderMobile;

import android.util.Log;
import java.net.InetAddress;
import java.net.UnknownHostException;

class DNSLookup
  implements Runnable
{
  private static final String TAG = StringUtils.getLogTag(DNSLookup.class);
  private final String domain;
  private InetAddress inetAddr;
  
  public DNSLookup(String paramString)
  {
    domain = paramString;
  }
  
  public void run()
  {
    try
    {
      Log.d(TAG, "Starting DNS lookup");
      InetAddress localInetAddress = InetAddress.getByName(domain);
      Log.d(TAG, "DNS lookup complete");
      set(localInetAddress);
      return;
    }
    catch (UnknownHostException localUnknownHostException)
    {
      Log.d(TAG, "Failed DNS lookup");
    }
  }
  
  void set(InetAddress paramInetAddress)
  {
    try
    {
      inetAddr = paramInetAddress;
      return;
    }
    finally
    {
      paramInetAddress = finally;
      throw paramInetAddress;
    }
  }
}

/* Location:
 * Qualified Name:     com.threatmetrix.TrustDefenderMobile.DNSLookup
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */