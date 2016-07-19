package com.threatmetrix.TrustDefenderMobile;

import android.annotation.TargetApi;
import android.content.Context;
import android.location.Location;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.util.Log;
import android.util.TimingLogger;
import android.view.WindowManager;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@TargetApi(9)
class TrustDefenderMobileCore
{
  private static final String TAG = StringUtils.getLogTag(TrustDefenderMobileCore.class);
  public static String version = "3.2-83";
  ArrayList<String> customAttributes = null;
  String m_HTML5Cookie = null;
  String m_api_key = null;
  String m_app_version_name = null;
  String[] m_applicationHashes = null;
  long m_boot_time = 0L;
  String m_browserStringFromJS = null;
  BrowserInfo m_browser_info = new BrowserInfo();
  TDConfiguration m_config = null;
  Context m_context = null;
  String m_cookie = null;
  String m_deviceFingerprint = null;
  String m_deviceState = null;
  int m_dstDiff = 0;
  String m_flashCookie = null;
  String m_fontCount = null;
  String m_fontHash = null;
  String m_fp_server = null;
  long m_freeSpace = 0L;
  int m_gmtOffset = 0;
  String m_imei = null;
  boolean m_isLocationManual = false;
  String m_language = null;
  String m_locale = null;
  Location m_location = null;
  int m_mockLocationStatus = 0;
  NetworkInfo m_networkInfo = null;
  long m_options = 0L;
  String m_org_id = null;
  long m_prepareRiskTransactionInterval = 0L;
  int m_profilesSinceInitCount = 0;
  long m_programmaticallySetOptions = 0L;
  String m_referrerURL = null;
  int m_screenHeight = 0;
  int m_screenWidth = 0;
  String m_self_hash = null;
  String m_session_id = null;
  String m_source = "";
  CancelState m_state = null;
  volatile THMStatusCode m_status = THMStatusCode.THM_OK;
  TimingLogger m_timings = null;
  String m_url = null;
  
  TrustDefenderMobileCore(String paramString)
  {
    m_source = paramString;
  }
  
  private void addSplitToLogger(String paramString)
  {
    if (m_timings != null) {
      m_timings.addSplit(paramString);
    }
  }
  
  private void checkForInterrupt()
    throws InterruptedException
  {
    if ((m_state != null) && (m_state.isCancelled())) {
      throw new InterruptedException();
    }
  }
  
  private String getLanguage()
  {
    if (m_language == null) {
      m_language = InfoGatherer.getLanguage();
    }
    return m_language;
  }
  
  private String getLocale()
  {
    if (m_locale == null) {
      m_locale = InfoGatherer.getLocale();
    }
    return m_locale;
  }
  
  public String dnsIPHostname()
    throws InterruptedException
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getOrgID()).append("-").append(StringUtils.SHA1(getSessionID())).append("-mob");
    if (localStringBuilder.length() >= 64)
    {
      Log.w(TAG, "combined session id and org id too long for host name fragment");
      return null;
    }
    Log.d(TAG, "Launching DNS profiling request");
    String str = "d";
    if (getFPServer().equals("qa2-h.online-metrix.net")) {
      str = "q";
    }
    return "." + str + ".aa.online-metrix.net";
  }
  
  void gatherInfo()
    throws InterruptedException
  {
    long l = SystemClock.uptimeMillis();
    Log.d(TAG, "Getting timezone info");
    Object localObject1;
    if ((m_options & 0x8) != 0L)
    {
      localObject1 = new InfoGatherer.TZInfo();
      if (InfoGatherer.getTimeZoneInfo((InfoGatherer.TZInfo)localObject1))
      {
        m_dstDiff = dstDiff;
        m_gmtOffset = gmtOffset;
      }
      addSplitToLogger("Get time zone");
    }
    boolean bool;
    if ((m_cookie == null) || (m_flashCookie == null) || (m_HTML5Cookie == null))
    {
      if (((m_options & 0x200) != 0L) && (TDID.isDodgySerial()))
      {
        bool = true;
        localObject1 = null;
        String str = null;
        if (m_cookie == null)
        {
          localObject1 = TDID.getAndroidID(m_context);
          m_cookie = TDID.getCookie((String)localObject1, bool);
        }
        addSplitToLogger("cookie");
        if (m_HTML5Cookie == null)
        {
          str = TDID.getPref(m_context);
          checkForInterrupt();
          m_HTML5Cookie = TDID.getHTML5Cookie(str, bool);
        }
        addSplitToLogger("LSC");
        if (m_imei == null)
        {
          m_imei = TDID.getIMEI(m_context);
          addSplitToLogger("imei");
        }
        if (m_flashCookie == null)
        {
          Object localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = TDID.getAndroidID(m_context);
          }
          localObject1 = str;
          if (str == null) {
            localObject1 = TDID.getPref(m_context);
          }
          checkForInterrupt();
          m_flashCookie = TDID.getFlashCookie(m_context, (String)localObject2, (String)localObject1, m_imei, bool);
        }
        addSplitToLogger("Flash");
      }
    }
    else
    {
      checkForInterrupt();
      if (((m_options & 0x10) != 0L) && ((m_screenHeight == 0) || (m_screenWidth == 0)))
      {
        localObject1 = new DisplayWrapper(((WindowManager)m_context.getSystemService("window")).getDefaultDisplay());
        m_screenWidth = ((DisplayWrapper)localObject1).getWidth();
        m_screenHeight = ((DisplayWrapper)localObject1).getHeight();
      }
      addSplitToLogger("Get screen dimensions");
      checkForInterrupt();
      if (m_deviceFingerprint == null) {
        m_deviceFingerprint = InfoGatherer.getDeviceFingerprint(m_context, m_context);
      }
      addSplitToLogger("Get device fingerprint");
      if (((m_options & 0x800) != 0L) && (m_self_hash == null))
      {
        m_self_hash = ApplicationInfoGatherer.checkThisPackage(m_context);
        addSplitToLogger("Get self hash");
      }
      if ((m_options & 0x3000) != 12288L) {
        break label726;
      }
      m_applicationHashes = NativeGatherer.getInstance().findAllProcs();
    }
    for (;;)
    {
      if ((m_fontCount == null) || (m_fontHash == null))
      {
        localObject1 = new StringBuilder();
        m_fontHash = InfoGatherer.getFontHashAndCount((StringBuilder)localObject1);
        if (m_fontHash != null) {
          m_fontCount = ((StringBuilder)localObject1).toString();
        }
        Log.d(TAG, "Got " + m_fontCount + " fonts gives: " + m_fontHash);
      }
      addSplitToLogger("Get Font list");
      checkForInterrupt();
      if (m_boot_time == 0L)
      {
        m_boot_time = InfoGatherer.getBootTime();
        addSplitToLogger("Get agent boot time");
      }
      checkForInterrupt();
      if (m_app_version_name == null)
      {
        m_app_version_name = InfoGatherer.getAppNameVersion(m_context);
        addSplitToLogger("Get agent name, version");
      }
      checkForInterrupt();
      if (m_freeSpace == 0L)
      {
        m_freeSpace = InfoGatherer.getFreeSpace();
        addSplitToLogger("Get the freeSpace in bytes");
      }
      checkForInterrupt();
      m_deviceState = InfoGatherer.getDeviceState(m_freeSpace, m_boot_time);
      addSplitToLogger("Get device state");
      if ((m_options & 0x8000) != 0L)
      {
        checkForInterrupt();
        m_networkInfo = new NetworkInfo(m_context);
        addSplitToLogger("Get the SSID , BSSID and connection type");
      }
      m_prepareRiskTransactionInterval = (SystemClock.uptimeMillis() - l);
      return;
      bool = false;
      break;
      label726:
      if ((m_options & 0x2000) != 0L) {
        m_applicationHashes = NativeGatherer.getInstance().findRunningProcs();
      } else if ((m_options & 0x1000) != 0L) {
        m_applicationHashes = NativeGatherer.getInstance().findInstalledProcs();
      }
    }
  }
  
  TDConfiguration getConfig()
  {
    return m_config;
  }
  
  Map<String, String> getConfigurationHeaders()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("User-Agent", m_browserStringFromJS);
    localHashMap.put("Accept-Langauge", getLanguage());
    return localHashMap;
  }
  
  HttpParameterMap getConfigurationParams()
  {
    HttpParameterMap localHttpParameterMap = new HttpParameterMap();
    localHttpParameterMap.add("org_id", m_org_id);
    localHttpParameterMap.add("session_id", m_session_id);
    localHttpParameterMap.add("os", "android");
    localHttpParameterMap.add("osVersion", Build.VERSION.RELEASE);
    if ((m_api_key != null) && (!m_api_key.isEmpty())) {
      localHttpParameterMap.add("api_key", m_api_key);
    }
    localHttpParameterMap.add("sdk_version", version);
    return localHttpParameterMap;
  }
  
  String getConfigurationPath()
  {
    return "https://" + m_fp_server + "/fp/mobile/conf";
  }
  
  String getFPServer()
  {
    return m_fp_server;
  }
  
  String getOrgID()
  {
    return m_org_id;
  }
  
  HttpParameterMap getRiskBodyParameterMap()
    throws InterruptedException
  {
    Object localObject3 = "";
    HttpParameterMap localHttpParameterMap = null;
    Object localObject2 = localHttpParameterMap;
    Object localObject1 = localObject3;
    if ((m_options & 0x4000) != 0L)
    {
      localObject4 = InfoGatherer.checkURLs(m_context, m_config.jb_paths);
      localObject2 = localHttpParameterMap;
      localObject1 = localObject3;
      if (m_config.jb_paths.size() > 0)
      {
        localObject1 = String.valueOf(((List)localObject4).size());
        localObject2 = StringUtils.ListToSeparatedString((List)localObject4, ";", true);
      }
    }
    addSplitToLogger("Check URLs");
    localObject3 = "";
    if ((m_config.enableOptions & 0x100) != 0L)
    {
      localObject3 = InfoGatherer.getURLs(m_config.ex_paths);
      addSplitToLogger("Get URLs");
    }
    localHttpParameterMap = new HttpParameterMap();
    localHttpParameterMap.setPostValueLengthLimit(255);
    Object localObject4 = new StringBuilder();
    ((StringBuilder)localObject4).append(m_programmaticallySetOptions).append(":").append(m_options).append(":").append(m_profilesSinceInitCount).append(":").append(m_prepareRiskTransactionInterval);
    localHttpParameterMap.add("mex2", ((StringBuilder)localObject4).toString());
    localHttpParameterMap.add("w", m_config.w);
    localHttpParameterMap.add("c", String.valueOf(m_gmtOffset));
    localHttpParameterMap.add("z", String.valueOf(m_dstDiff));
    localHttpParameterMap.add("f", m_screenWidth + "x" + m_screenHeight);
    localHttpParameterMap.add("lh", m_url, true);
    localHttpParameterMap.add("dr", m_referrerURL, true);
    if (!m_browser_info.getBrowserPluginCount().equals("0"))
    {
      localHttpParameterMap.add("p", m_browser_info.getBrowserPlugins(), true);
      localHttpParameterMap.add("pl", m_browser_info.getBrowserPluginCount(), true);
      localHttpParameterMap.add("ph", m_browser_info.getBrowserPluginsFromJSHash(), true);
    }
    localHttpParameterMap.add("hh", StringUtils.MD5(m_org_id + m_session_id));
    if (m_browser_info.getMimeTypeCount() > 0)
    {
      localHttpParameterMap.add("mt", m_browser_info.getMimeTypesHash());
      localHttpParameterMap.add("mn", String.valueOf(m_browser_info.getMimeTypeCount()));
    }
    localHttpParameterMap.add("mdf", m_deviceFingerprint, true);
    localHttpParameterMap.add("mds", m_deviceState, true);
    localHttpParameterMap.add("imei", m_imei, true);
    if (m_location != null)
    {
      localHttpParameterMap.add("tdlat", String.valueOf(m_location.getLatitude()));
      localHttpParameterMap.add("tdlon", String.valueOf(m_location.getLongitude()));
      localHttpParameterMap.add("tdlacc", String.valueOf(m_location.getAccuracy()));
    }
    int i;
    int j;
    if ((customAttributes != null) && (customAttributes.size() > 0))
    {
      i = 0;
      localObject4 = customAttributes.iterator();
      if (((Iterator)localObject4).hasNext())
      {
        String str = (String)((Iterator)localObject4).next();
        StringBuilder localStringBuilder = new StringBuilder().append("aca");
        j = i + 1;
        localHttpParameterMap.add(i, str, true);
        if (j < 5) {
          break label1356;
        }
      }
    }
    localHttpParameterMap.add("ah", m_self_hash);
    localHttpParameterMap.add("la", m_config.w + m_HTML5Cookie);
    localHttpParameterMap.add("lq", m_browserStringFromJS);
    localHttpParameterMap.add("fc", m_config.w + m_flashCookie);
    localHttpParameterMap.add("ftsn", m_fontCount);
    localHttpParameterMap.add("fts", m_fontHash, true);
    localHttpParameterMap.add("aov", Build.VERSION.RELEASE, true);
    localHttpParameterMap.add("al", getLanguage(), true);
    localHttpParameterMap.add("alo", getLocale(), true);
    localHttpParameterMap.add("ab", Build.BRAND + ", " + Build.MANUFACTURER, true);
    localHttpParameterMap.add("am", Build.MODEL, true);
    localHttpParameterMap.add("aos", "Android", true);
    localHttpParameterMap.add("fg", m_flashCookie);
    localHttpParameterMap.add("ls", m_HTML5Cookie);
    localHttpParameterMap.add("gr", (String)localObject1);
    localHttpParameterMap.add("grr", (String)localObject2, Integer.valueOf(1024));
    localHttpParameterMap.add("at", "agent_mobile");
    localObject2 = new StringBuilder().append(version);
    if (m_source.isEmpty())
    {
      localObject1 = "";
      label1004:
      localHttpParameterMap.add("av", (String)localObject1);
      localHttpParameterMap.add("mex3", (String)localObject3);
      if (InfoGatherer.isMockLocation(m_context)) {
        m_mockLocationStatus |= 0x2;
      }
      if ((m_location != null) && (new LocationWrapper(m_location).isFromMockProvider())) {
        m_mockLocationStatus |= 0x1;
      }
      if (m_isLocationManual) {
        m_mockLocationStatus |= 0x4;
      }
      localHttpParameterMap.add("mex4", String.valueOf(m_mockLocationStatus));
      if (m_boot_time != 0L) {
        break label1388;
      }
      localObject1 = "";
      label1132:
      localHttpParameterMap.add("abt", (String)localObject1);
      localHttpParameterMap.add("anv", m_app_version_name);
      if (m_freeSpace != 0L) {
        break label1399;
      }
      localObject1 = "";
      label1167:
      localHttpParameterMap.add("afs", (String)localObject1);
      if (m_networkInfo != null)
      {
        if (m_networkInfo.getBssid() != null) {
          break label1410;
        }
        localObject1 = "";
        label1197:
        localHttpParameterMap.add("wbs", (String)localObject1);
        if (m_networkInfo.getSsid() != null) {
          break label1421;
        }
        localObject1 = "";
        label1220:
        localHttpParameterMap.add("wss", (String)localObject1);
        if (m_networkInfo.getType() != null) {
          break label1432;
        }
      }
    }
    label1356:
    label1388:
    label1399:
    label1410:
    label1421:
    label1432:
    for (localObject1 = "";; localObject1 = m_networkInfo.getType())
    {
      localHttpParameterMap.add("wc", (String)localObject1);
      localObject1 = new HttpParameterMap();
      ((HttpParameterMap)localObject1).add("org_id", m_org_id);
      ((HttpParameterMap)localObject1).add("session_id", m_session_id);
      if (m_applicationHashes == null) {
        break label1487;
      }
      localObject2 = new StringBuilder();
      localObject3 = m_applicationHashes;
      j = localObject3.length;
      i = 0;
      while (i < j)
      {
        localObject4 = localObject3[i];
        if (((StringBuilder)localObject2).length() > 0) {
          ((StringBuilder)localObject2).append(",");
        }
        ((StringBuilder)localObject2).append((String)localObject4);
        i += 1;
      }
      i = j;
      break;
      localObject1 = " : " + m_source;
      break label1004;
      localObject1 = String.valueOf(m_boot_time);
      break label1132;
      localObject1 = String.valueOf(m_freeSpace);
      break label1167;
      localObject1 = m_networkInfo.getBssid();
      break label1197;
      localObject1 = m_networkInfo.getSsid();
      break label1220;
    }
    Log.d(TAG, "Found: " + ((StringBuilder)localObject2).toString());
    ((HttpParameterMap)localObject1).add("ih", ((StringBuilder)localObject2).toString());
    label1487:
    addSplitToLogger("Params without xor");
    localObject2 = localHttpParameterMap.getUrlEncodedParamString();
    addSplitToLogger("URL encoding");
    Log.d(TAG, "encoded ja = " + localHttpParameterMap);
    ((HttpParameterMap)localObject1).add("ja", StringUtils.xor((String)localObject2, m_session_id));
    ((HttpParameterMap)localObject1).add("h", "0").add("m", "2");
    addSplitToLogger("Params xor'd");
    return (HttpParameterMap)localObject1;
  }
  
  Map<String, String> getRiskDataHeaders()
  {
    HashMap localHashMap = new HashMap();
    if ((m_browserStringFromJS != null) && (!m_browserStringFromJS.isEmpty()))
    {
      Log.d(TAG, "Setting User-Agent to " + m_browserStringFromJS);
      localHashMap.put("User-Agent", m_browserStringFromJS);
    }
    if (m_cookie == null) {
      localHashMap.put("Cookie", "thx_guid=");
    }
    for (;;)
    {
      localHashMap.put("Referer", m_referrerURL);
      localHashMap.put("Content-Type", "application/x-www-form-urlencoded");
      localHashMap.put("Accept-Language", getLanguage());
      return localHashMap;
      localHashMap.put("Cookie", "thx_guid=" + m_cookie);
    }
  }
  
  String getSessionID()
  {
    return m_session_id;
  }
  
  THMStatusCode getStatus()
  {
    Log.d(TAG, "getStatus returns: " + m_status.toString());
    return m_status;
  }
  
  void incrementProfileCount()
  {
    m_profilesSinceInitCount += 1;
  }
  
  void reset()
  {
    m_cookie = null;
    m_gmtOffset = 0;
    m_dstDiff = 0;
    m_deviceState = null;
    m_location = null;
    m_language = null;
    m_locale = null;
    m_config = null;
    m_boot_time = 0L;
    m_freeSpace = 0L;
    m_networkInfo = null;
    m_mockLocationStatus = 0;
    m_isLocationManual = false;
  }
  
  void setApiKey(String paramString)
  {
    m_api_key = paramString;
  }
  
  void setBrowserInfo(BrowserInfo paramBrowserInfo)
  {
    m_browser_info = paramBrowserInfo;
  }
  
  void setCancelObject(CancelState paramCancelState)
  {
    m_state = paramCancelState;
  }
  
  void setConfig(TDConfiguration paramTDConfiguration)
  {
    m_config = paramTDConfiguration;
  }
  
  void setContext(Context paramContext)
  {
    m_context = paramContext;
  }
  
  void setCustomAttributes(List<String> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty()))
    {
      if (customAttributes != null) {
        customAttributes.clear();
      }
      return;
    }
    customAttributes = new ArrayList(paramList);
  }
  
  boolean setFPServer(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "h.online-metrix.net";
    }
    try
    {
      new URL("https://" + str);
      m_fp_server = str;
      return true;
    }
    catch (MalformedURLException paramString)
    {
      Log.e(TAG, "Invalid hostname " + str, paramString);
    }
    return false;
  }
  
  void setLocation(Location paramLocation, boolean paramBoolean)
  {
    m_location = paramLocation;
    m_isLocationManual = paramBoolean;
  }
  
  boolean setOrgID(String paramString)
  {
    if ((paramString == null) || (paramString.length() != 8))
    {
      Log.e(TAG, "Invalid org_id");
      return false;
    }
    m_org_id = paramString;
    return true;
  }
  
  void setProfileOptions(long paramLong)
  {
    m_options = paramLong;
  }
  
  void setProgrammaticallySetOptions(long paramLong)
  {
    m_programmaticallySetOptions = paramLong;
  }
  
  void setSessionID(String paramString)
  {
    m_session_id = paramString;
  }
  
  void setStatus(THMStatusCode paramTHMStatusCode)
  {
    m_status = paramTHMStatusCode;
  }
  
  boolean setURLS(String paramString)
  {
    String str;
    if (paramString != null)
    {
      str = paramString;
      if (!paramString.isEmpty()) {}
    }
    else
    {
      str = "TrustDefenderMobileSDK";
    }
    m_referrerURL = ("http://" + str);
    m_url = ("http://" + str + "/mobile");
    return true;
  }
}

/* Location:
 * Qualified Name:     com.threatmetrix.TrustDefenderMobile.TrustDefenderMobileCore
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */