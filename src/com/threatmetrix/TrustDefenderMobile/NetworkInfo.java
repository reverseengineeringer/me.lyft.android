package com.threatmetrix.TrustDefenderMobile;

import android.content.Context;
import android.telephony.TelephonyManager;

public class NetworkInfo
{
  private String bssid = null;
  private String ssid = null;
  private String type = null;
  
  public NetworkInfo(Context paramContext)
    throws InterruptedException
  {
    String[] arrayOfString = NativeGatherer.getInstance().getNetworkInfo();
    if ((arrayOfString != null) && (arrayOfString.length >= 2))
    {
      setBssid(arrayOfString[0]);
      setSsid(arrayOfString[1]);
      setType("wifi");
    }
    int i;
    do
    {
      return;
      arrayOfString = InfoGatherer.getNetworkInfo(paramContext);
      if (arrayOfString != null)
      {
        setBssid(arrayOfString[0]);
        setSsid(arrayOfString[1]);
        setType("wifi");
        return;
      }
      i = ((TelephonyManager)paramContext.getSystemService("phone")).getDataState();
    } while ((i != 2) && (i != 1) && (i != 3));
    setType("cellular");
  }
  
  String getBssid()
  {
    return bssid;
  }
  
  String getSsid()
  {
    return ssid;
  }
  
  String getType()
  {
    return type;
  }
  
  void setBssid(String paramString)
  {
    bssid = paramString;
  }
  
  void setSsid(String paramString)
  {
    ssid = paramString;
  }
  
  void setType(String paramString)
  {
    type = paramString;
  }
}

/* Location:
 * Qualified Name:     com.threatmetrix.TrustDefenderMobile.NetworkInfo
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */