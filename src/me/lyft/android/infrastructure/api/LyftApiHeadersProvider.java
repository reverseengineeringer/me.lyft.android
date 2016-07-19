package me.lyft.android.infrastructure.api;

import java.util.LinkedHashMap;
import java.util.Map;
import me.lyft.android.ILyftPreferences;
import me.lyft.android.common.Strings;
import me.lyft.android.infrastructure.device.IDevice;
import me.lyft.android.infrastructure.json.IJsonSerializer;
import me.lyft.android.infrastructure.lyft.XSession;
import me.lyft.android.logging.L;
import okio.ByteString;

public class LyftApiHeadersProvider
  implements ILyftApiHeadersProvider
{
  private static final String ACCEPT_HEADER = "Accept";
  private static final String ACCEPT_LANGUAGE_HEADER = "Accept-Language";
  private static final String AUTHORIZATION_HEADER = "Authorization";
  private static final String MOCK_RESPONSE_HEADER = "X-Mock-Response";
  private static final String USER_AGENT_HEADER = "User-Agent";
  private static final String USER_DEVICE_HEADER = "User-Device";
  private static final String X_CARRIER_HEADER = "X-Carrier";
  private static final String X_SESSION_HEADER = "X-Session";
  private final IDevice device;
  private final IJsonSerializer jsonSerializer;
  private final ILyftPreferences preferences;
  
  public LyftApiHeadersProvider(IDevice paramIDevice, ILyftPreferences paramILyftPreferences, IJsonSerializer paramIJsonSerializer)
  {
    device = paramIDevice;
    preferences = paramILyftPreferences;
    jsonSerializer = paramIJsonSerializer;
  }
  
  private String createXSessionHeader()
  {
    Object localObject = device.getAndroidId();
    String str = preferences.getAdvertisingId();
    if (!preferences.getLimitAdvertisingId()) {}
    for (boolean bool = true;; bool = false)
    {
      localObject = new XSession((String)localObject, str, bool);
      try
      {
        localObject = ByteString.encodeUtf8(jsonSerializer.toJson(localObject)).base64();
        return (String)localObject;
      }
      catch (Exception localException)
      {
        L.e(localException, "getXSession", new Object[0]);
      }
    }
    return "";
  }
  
  public Map<String, String> getHeaders()
  {
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    localLinkedHashMap.put("Accept-Language", device.getDeviceLocale());
    localLinkedHashMap.put("Accept", "application/vnd.lyft.app+json;version=42");
    localLinkedHashMap.put("User-Agent", device.getUserAgent());
    localLinkedHashMap.put("User-Device", device.getDeviceName());
    localLinkedHashMap.put("X-Carrier", device.getOperatorName());
    localLinkedHashMap.put("X-Session", createXSessionHeader());
    if (!Strings.isNullOrEmpty(preferences.getLyftToken())) {
      localLinkedHashMap.put("Authorization", "lyftToken " + preferences.getLyftToken());
    }
    if ((preferences.isDeveloperMode()) && (preferences.getIncludeMockHttpHeader())) {
      localLinkedHashMap.put("X-Mock-Response", "true");
    }
    return localLinkedHashMap;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.api.LyftApiHeadersProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */