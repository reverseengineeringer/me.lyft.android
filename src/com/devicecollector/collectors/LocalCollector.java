package com.devicecollector.collectors;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.provider.Settings.Secure;
import android.util.Log;
import com.devicecollector.DataCollection;
import com.devicecollector.DataCollection.PostElement;
import com.devicecollector.util.HashUtils;
import com.devicecollector.util.JSONUtils;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.UUID;

public class LocalCollector
{
  private Context context;
  private DataCollection dataCollection;
  
  public LocalCollector(Activity paramActivity, DataCollection paramDataCollection)
  {
    dataCollection = paramDataCollection;
    context = paramActivity.getApplicationContext();
  }
  
  private String getPersistedDeviceCookies()
  {
    String str = null;
    SharedPreferences localSharedPreferences = context.getSharedPreferences("k_prefs", 0);
    if (localSharedPreferences != null) {
      str = localSharedPreferences.getString("lic", null);
    }
    return str;
  }
  
  @SuppressLint({"NewApi"})
  private HashMap<String, String> getProxyPeircingInfo()
  {
    localHashMap = new HashMap();
    if (Build.VERSION.SDK_INT > 8) {
      Log.d("PROXY_PEIRCE", "[LocalCollector]Newer API...");
    }
    try
    {
      Enumeration localEnumeration = NetworkInterface.getNetworkInterfaces();
      while (localEnumeration.hasMoreElements())
      {
        NetworkInterface localNetworkInterface = (NetworkInterface)localEnumeration.nextElement();
        if (localNetworkInterface.isUp())
        {
          Log.d("NETWORK", "[LocalCollector]NETWORK:" + localNetworkInterface.getName() + ":" + localNetworkInterface.isVirtual());
          byte[] arrayOfByte = localNetworkInterface.getHardwareAddress();
          if (arrayOfByte != null)
          {
            StringBuffer localStringBuffer = new StringBuffer();
            int j = arrayOfByte.length;
            int i = 0;
            while (i < j)
            {
              localStringBuffer.append(String.format("%02X", new Object[] { Byte.valueOf(arrayOfByte[i]) }));
              i += 1;
            }
            localHashMap.put(localNetworkInterface.getName(), localStringBuffer.toString());
          }
        }
      }
      return localHashMap;
    }
    catch (SocketException localSocketException)
    {
      dataCollection.addError(CollectorEnum.MAC_ADDRESS, SoftErrorCode.SERVICE_UNAVAILABLE);
      Log.d("network_mac", "[LocalCollector]Bad socket connection, skipping");
      return localHashMap;
    }
    catch (SecurityException localSecurityException)
    {
      dataCollection.addError(CollectorEnum.MAC_ADDRESS, SoftErrorCode.PERMISSION_DENIED);
      Log.d("network_mac", "[LocalCollector]Permission Denied, skipping");
    }
  }
  
  private HashMap<String, String> getWifiMacInfo()
  {
    HashMap localHashMap = new HashMap();
    try
    {
      WifiInfo localWifiInfo = ((WifiManager)context.getSystemService("wifi")).getConnectionInfo();
      if ((localWifiInfo != null) && (localWifiInfo.getMacAddress() != null))
      {
        localHashMap.put("wifi_mac", localWifiInfo.getMacAddress().replace(":", ""));
        return localHashMap;
      }
      Log.d("wifi_mac", "[LocalCollector]WIFI not enabled, skipping");
      return localHashMap;
    }
    catch (SecurityException localSecurityException)
    {
      Log.d("wifi_mac", "[LocalCollector]WIFI PERMISSION DENIED");
    }
    return localHashMap;
  }
  
  private void saveDeviceCookies(String paramString)
  {
    SharedPreferences.Editor localEditor = context.getSharedPreferences("k_prefs", 0).edit();
    localEditor.putString("lic", paramString);
    localEditor.commit();
  }
  
  @SuppressLint({"NewApi"})
  public void collectDeviceId()
  {
    String str = getPersistedDeviceCookies();
    HashMap localHashMap = new HashMap();
    Object localObject1 = Settings.Secure.getString(context.getContentResolver(), "android_id");
    Log.d("LocalCollector", "ANDROID_ID:" + (String)localObject1);
    localHashMap.put(DeviceIDType.ANDROID_ID.name(), HashUtils.convertToSha256Hash(DeviceIDType.ANDROID_ID.name() + (String)localObject1));
    if (Build.VERSION.SDK_INT > 8) {
      localHashMap.put(DeviceIDType.ANDROID_SERIAL.name(), HashUtils.convertToSha256Hash(DeviceIDType.ANDROID_SERIAL.name() + Build.SERIAL));
    }
    localObject1 = getMacArray();
    if (localObject1 != null) {
      localHashMap.put(DeviceIDType.MAC_HASH.name(), HashUtils.convertToSha256Hash(DeviceIDType.MAC_HASH.name() + (String)localObject1));
    }
    Object localObject3 = null;
    localObject1 = localObject3;
    if (str != null)
    {
      localObject1 = localObject3;
      if (!str.contains(DeviceIDType.UID.name())) {}
    }
    try
    {
      int i = str.indexOf(DeviceIDType.UID.name()) + DeviceIDType.UID.name().length() + 3;
      localObject1 = str.substring(i, str.indexOf('"', i));
      localObject3 = localObject1;
      if (localObject1 == null) {
        localObject3 = HashUtils.convertToSha256Hash(DeviceIDType.UID.name() + UUID.randomUUID().toString());
      }
      localHashMap.put(DeviceIDType.UID.name(), localObject3);
      if (localHashMap.size() == 0)
      {
        dataCollection.addError(CollectorEnum.DEVICE_COOKIE, SoftErrorCode.UNEXPECTED);
        return;
      }
      localObject1 = JSONUtils.JSONifyMap(localHashMap);
      dataCollection.addMobileData(DataCollection.PostElement.DEVICE_COOKIE, (String)localObject1);
      if ((str != null) && (str.length() > 0)) {
        dataCollection.addMobileData(DataCollection.PostElement.OLD_DEVICE_COOKIE, str);
      }
      saveDeviceCookies((String)localObject1);
      return;
    }
    catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
    {
      for (;;)
      {
        Object localObject2 = localObject3;
      }
    }
  }
  
  public void collectOptionalInfo()
  {
    dataCollection.addMobileData(DataCollection.PostElement.OS_VERSION, Build.VERSION.RELEASE);
  }
  
  public void collectRequiredInfo()
  {
    dataCollection.addMobileData(DataCollection.PostElement.SDK_TYPE, "A");
    dataCollection.addMobileData(DataCollection.PostElement.SDK_VERSION, "2.5");
    dataCollection.addMobileData(DataCollection.PostElement.MOBILE_MODEL, Build.FINGERPRINT);
  }
  
  public String getMacArray()
  {
    Object localObject1 = getWifiMacInfo();
    ((HashMap)localObject1).putAll(getProxyPeircingInfo());
    Object localObject2 = new TreeSet(((HashMap)localObject1).values());
    if (((SortedSet)localObject2).size() > 0)
    {
      localObject1 = new StringBuilder("{");
      localObject2 = ((SortedSet)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        String str = (String)((Iterator)localObject2).next();
        ((StringBuilder)localObject1).append(str + ",");
      }
      ((StringBuilder)localObject1).append("}");
      return ((StringBuilder)localObject1).toString();
    }
    return null;
  }
  
  private static enum DeviceIDType
  {
    ANDROID_ID,  ANDROID_SERIAL,  MAC_HASH,  UID;
    
    private DeviceIDType() {}
  }
}

/* Location:
 * Qualified Name:     com.devicecollector.collectors.LocalCollector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */