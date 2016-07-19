package com.threatmetrix.TrustDefenderMobile;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

class BrowserInfoGatherer
  extends BrowserInfo
{
  private static final String TAG = StringUtils.getLogTag(BrowserInfoGatherer.class);
  private CountDownLatch m_browser_info_latch = null;
  private Context m_context = null;
  private JSExecutor m_jsExec = null;
  private JavaScriptInterface m_jsInterface = null;
  private boolean m_jsProblem = false;
  private boolean m_needWebView = false;
  private long m_options = 0L;
  
  private static HashMap<String, String> checkPlugin(ArrayList<HashMap<String, String>> paramArrayList, String paramString)
  {
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      HashMap localHashMap = (HashMap)paramArrayList.next();
      String str = (String)localHashMap.get("name");
      if ((str != null) && (str.toLowerCase(Locale.US).contains(paramString.toLowerCase(Locale.US)))) {
        return localHashMap;
      }
    }
    return null;
  }
  
  private static String containsPluginNamed(String paramString1, String paramString2, ArrayList<HashMap<String, String>> paramArrayList)
  {
    String str = "false";
    paramArrayList = checkPlugin(paramArrayList, paramString1);
    paramString1 = str;
    if (paramArrayList != null)
    {
      paramArrayList = (String)paramArrayList.get("name");
      paramString1 = str;
      if (paramArrayList != null)
      {
        paramArrayList = paramArrayList.replace("[abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXY -]", "");
        paramString1 = paramArrayList;
        if (!paramArrayList.isEmpty()) {
          paramString1 = "true";
        }
      }
    }
    return paramString2 + "^" + paramString1 + "!";
  }
  
  private void getBrowserInfo()
    throws InterruptedException
  {
    if (Thread.currentThread().isInterrupted()) {}
    do
    {
      return;
      if ((m_options & 0x20) != 0L)
      {
        str = m_jsExec.getJSResult("(function () { var plugins_string='', i=0; for (p=navigator.plugins[0]; i< navigator.plugins.length;p=navigator.plugins[i++]) {  plugins_string += p.name + '<FIELD_SEP>' + p.description + '<FIELD_SEP>' + p.filename + '<FIELD_SEP>' + p.length.toString() + '<REC_SEP>'; } return plugins_string;})();");
        if (str != null) {
          parseBrowserInfo_Plugins(str);
        }
      }
    } while ((Thread.currentThread().isInterrupted()) || ((m_options & 0x4) == 0L));
    String str = m_jsExec.getJSResult("navigator.mimeTypes.length");
    if (str != null) {}
    try
    {
      m_mimeTypeCount = Integer.parseInt(str);
      m_mimeTypes = m_jsExec.getJSResult("(function () { var mime_string='', i=0; for (var m=navigator.mimeTypes[0]; i< navigator.mimeTypes.length;m=navigator.mimeTypes[i++]) {  mime_string += m.type; } return mime_string;})();");
      if (m_mimeTypes != null)
      {
        m_mimeTypesHash = StringUtils.MD5(m_mimeTypes);
        Log.d(TAG, "Got:" + m_mimeTypes);
        return;
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        Log.e(TAG, "failed to convert", localNumberFormatException);
      }
      m_mimeTypesHash = "";
    }
  }
  
  private void parseBrowserInfo()
    throws InterruptedException
  {
    int j = 0;
    int i = j;
    String str1;
    if ((m_options & 0x20) != 0L)
    {
      i = j;
      if (m_jsInterface.returnedValues.size() > 0)
      {
        str1 = (String)m_jsInterface.returnedValues.get(0);
        i = 0 + 1;
        if ((str1 == null) || (str1.isEmpty())) {
          break label286;
        }
        parseBrowserInfo_Plugins(str1);
      }
    }
    if ((!Thread.currentThread().isInterrupted()) && ((m_options & 0x4) != 0L) && (m_jsInterface.returnedValues.size() > i))
    {
      str1 = (String)m_jsInterface.returnedValues.get(i);
      i += 1;
      if ((str1 == null) || (str1.isEmpty())) {
        break label314;
      }
    }
    for (;;)
    {
      try
      {
        m_mimeTypeCount = Integer.parseInt(str1);
        if ((m_mimeTypeCount > 0) && (m_jsInterface.returnedValues.size() > i)) {
          m_mimeTypes = ((String)m_jsInterface.returnedValues.get(i));
        }
        if (m_mimeTypes == null) {
          break label322;
        }
        m_mimeTypesHash = StringUtils.MD5(m_mimeTypes);
        Log.d(TAG, "Got:" + m_mimeTypes);
        String str3 = TAG;
        StringBuilder localStringBuilder = new StringBuilder().append("Got mime ").append(m_mimeTypeCount).append(":");
        if (m_mimeTypes == null) {
          break label331;
        }
        str1 = m_mimeTypes;
        Log.d(str3, str1);
        return;
        label286:
        m_browserPluginsFromJSHash = "";
      }
      catch (NumberFormatException localNumberFormatException)
      {
        Log.e(TAG, "failed to convert", localNumberFormatException);
        m_mimeTypeCount = 0;
        continue;
      }
      label314:
      m_mimeTypeCount = 0;
      continue;
      label322:
      m_mimeTypesHash = "";
      continue;
      label331:
      String str2 = "";
    }
  }
  
  private void parseBrowserInfo_Plugins(String paramString)
    throws InterruptedException
  {
    m_browserPluginsFromJS = paramString.replaceAll("(<FIELD_SEP>|<REC_SEP>)", "");
    m_browserPluginsFromJSHash = StringUtils.MD5(m_browserPluginsFromJS);
    Object localObject1 = new ArrayList();
    paramString = paramString.split("<REC_SEP>");
    int j = paramString.length;
    int i = 0;
    while (i < j)
    {
      String[] arrayOfString = paramString[i];
      if (Thread.currentThread().isInterrupted()) {
        return;
      }
      localObject2 = new HashMap();
      arrayOfString = arrayOfString.split("<FIELD_SEP>");
      if (arrayOfString.length == 4)
      {
        ((HashMap)localObject2).put("name", arrayOfString[0]);
        ((HashMap)localObject2).put("description", arrayOfString[1]);
        ((HashMap)localObject2).put("filename", arrayOfString[2]);
        ((HashMap)localObject2).put("length", arrayOfString[3]);
        ((ArrayList)localObject1).add(localObject2);
      }
      i += 1;
    }
    m_browserPluginCount = Integer.toString(((ArrayList)localObject1).size());
    paramString = new StringBuilder();
    paramString.append(containsPluginNamed("QuickTime Plug-in", "plugin_quicktime", (ArrayList)localObject1));
    paramString.append(containsPluginNamed("Adobe Acrobat", "plugin_adobe_acrobat", (ArrayList)localObject1));
    paramString.append(containsPluginNamed("Java", "plugin_java", (ArrayList)localObject1));
    paramString.append(containsPluginNamed("SVG Viewer", "plugin_svg_viewer", (ArrayList)localObject1));
    paramString.append(containsPluginNamed("Flash", "plugin_flash", (ArrayList)localObject1));
    paramString.append(containsPluginNamed("Windows Media Player", "plugin_windows_media_player", (ArrayList)localObject1));
    paramString.append(containsPluginNamed("Silverlight", "plugin_silverlight", (ArrayList)localObject1));
    paramString.append(containsPluginNamed("Real Player", "plugin_realplayer", (ArrayList)localObject1));
    paramString.append(containsPluginNamed("ShockWave Director", "plugin_shockwave", (ArrayList)localObject1));
    paramString.append(containsPluginNamed("VLC", "plugin_vlc_player", (ArrayList)localObject1));
    paramString.append(containsPluginNamed("DevalVR", "plugin_devalvr", (ArrayList)localObject1));
    m_browserPlugins = paramString.toString();
    localObject1 = TAG;
    Object localObject2 = new StringBuilder().append("Got").append(m_browserPluginCount).append(":");
    if (m_browserPlugins != null) {}
    for (paramString = m_browserPlugins;; paramString = "")
    {
      Log.d((String)localObject1, paramString);
      return;
    }
  }
  
  void getBrowserInfoHelper()
  {
    int k;
    Handler localHandler;
    JavaScriptInterface localJavaScriptInterface;
    if ((JSExecutor.isBrokenJSInterface()) || (JSExecutor.hasAsyncInterface()))
    {
      k = 1;
      int i = 1;
      int j = 1;
      if (k != 0)
      {
        if ((m_options & 0x20) != 0L) {
          j = 1 + 1;
        }
        i = j;
        if ((m_options & 0x4) != 0L) {
          i = j + 2;
        }
      }
      m_browser_info_latch = new CountDownLatch(i);
      localHandler = new Handler(Looper.getMainLooper());
      Log.d(TAG, "Firing off getBrowserInfo on UI thread using latch: " + m_browser_info_latch.hashCode() + " with count: " + i);
      localJavaScriptInterface = m_jsInterface;
      if (k == 0) {
        break label173;
      }
    }
    label173:
    for (CountDownLatch localCountDownLatch = m_browser_info_latch;; localCountDownLatch = null)
    {
      localJavaScriptInterface.setLatch(localCountDownLatch);
      localHandler.post(new CompleteBrowserInfoRequest(this, m_browser_info_latch)
      {
        public void run()
        {
          try
          {
            Log.d(BrowserInfoGatherer.TAG, "Calling getBrowserInfo() - on UI thread");
            m_info.getBrowserInfo();
            if (m_latch != null)
            {
              Log.d(BrowserInfoGatherer.TAG, "getBrowserInfo countdown using latch: " + m_latch.hashCode() + " with count: " + m_latch.getCount());
              m_latch.countDown();
            }
            return;
          }
          catch (InterruptedException localInterruptedException)
          {
            for (;;)
            {
              Log.d(BrowserInfoGatherer.TAG, "getBrowserInfo interrupted", localInterruptedException);
            }
          }
        }
      });
      return;
      k = 0;
      break;
    }
  }
  
  public String getBrowserStringFromJS()
  {
    if (m_browserPluginsFromJS == null) {
      if ((m_jsExec != null) && (!m_jsProblem)) {
        break label33;
      }
    }
    label33:
    for (m_browserStringFromJS = JSExecutor.getUserAgentString();; m_browserStringFromJS = m_jsExec.getUserAgentString(m_context)) {
      return m_browserStringFromJS;
    }
  }
  
  boolean initJSExecutor(Context paramContext, boolean paramBoolean, long paramLong)
  {
    m_context = paramContext;
    m_needWebView = paramBoolean;
    m_options = paramLong;
    if (!m_needWebView) {
      return false;
    }
    Object localObject1 = TAG;
    Object localObject2 = new StringBuilder().append("initJSExecutor: jsProblem = ").append(m_jsProblem).append(", jsExec = ").append(m_jsExec).append(", hasBadOptions = ");
    int i;
    if (m_jsExec != null)
    {
      paramContext = Boolean.valueOf(m_jsExec.hasBadOptions(paramBoolean));
      Log.d((String)localObject1, paramContext);
      if (((m_jsProblem) || (m_jsExec != null)) && ((m_jsExec == null) || (!m_jsExec.hasBadOptions(m_needWebView)))) {
        break label354;
      }
      localObject1 = new CountDownLatch(1);
      localObject2 = new Handler(Looper.getMainLooper());
      if ((!JSExecutor.isBrokenJSInterface()) && (!JSExecutor.hasAsyncInterface())) {
        break label343;
      }
      i = 1;
      label176:
      if (i == 0) {
        break label349;
      }
    }
    label343:
    label349:
    for (paramContext = (Context)localObject1;; paramContext = null)
    {
      m_jsInterface = new JavaScriptInterface(paramContext);
      Log.d(TAG, "Firing off initJSExecutor on UI thread using latch: " + localObject1.hashCode() + " with count: " + ((CountDownLatch)localObject1).getCount());
      ((Handler)localObject2).post(new CompleteBrowserInfoRequest(this, (CountDownLatch)localObject1)
      {
        public void run()
        {
          Log.d(BrowserInfoGatherer.TAG, "Calling initJSExecutor() - on UI thread");
          BrowserInfoGatherer.access$102(m_info, new JSExecutor(m_context, m_jsInterface, m_needWebView));
          try
          {
            m_info.m_jsExec.init();
            Log.d(BrowserInfoGatherer.TAG, "js exec init complete");
            if (m_latch != null)
            {
              Log.d(BrowserInfoGatherer.TAG, "js exec init countdown using latch: " + m_latch.hashCode() + " with count: " + m_latch.getCount());
              m_latch.countDown();
            }
            return;
          }
          catch (InterruptedException localInterruptedException)
          {
            for (;;)
            {
              Log.e(BrowserInfoGatherer.TAG, "Interrupted initing js engine");
            }
          }
        }
      });
      try
      {
        if (((CountDownLatch)localObject1).await(10L, TimeUnit.SECONDS)) {
          break label364;
        }
        m_jsProblem = true;
        Log.e(TAG, "initJSExecutor no response from UI thread before timeout using init latch: " + localObject1.hashCode() + " with count: " + ((CountDownLatch)localObject1).getCount());
        return false;
      }
      catch (InterruptedException paramContext)
      {
        Log.e(TAG, "Interrupted initing js engine");
        return false;
      }
      paramContext = "true";
      break;
      i = 0;
      break label176;
    }
    label354:
    Log.d(TAG, "reused JS Interface");
    label364:
    return true;
  }
  
  boolean shouldCallBrowserInfoHelper()
  {
    return (webViewOkay()) && (m_needWebView);
  }
  
  void waitForBrowserInfoHelper(boolean paramBoolean)
  {
    if (m_browser_info_latch != null) {
      try
      {
        Log.d(TAG, "waiting for getBrowserInfo to finished, latch: " + m_browser_info_latch.getCount() + " - " + m_browser_info_latch.hashCode());
        if (m_browser_info_latch.await(10L, TimeUnit.SECONDS))
        {
          if ((paramBoolean) && ((JSExecutor.isBrokenJSInterface()) || (JSExecutor.hasAsyncInterface()))) {
            parseBrowserInfo();
          }
        }
        else
        {
          Log.e(TAG, "getBrowserInfo no response from UI thread before timeout using latch: " + m_browser_info_latch.hashCode() + " with count: " + m_browser_info_latch.getCount());
          m_jsProblem = true;
          return;
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        Log.e(TAG, "getBrowserInfo interrupted", localInterruptedException);
      }
    }
  }
  
  boolean webViewOkay()
  {
    return (m_jsExec != null) && (!m_jsProblem);
  }
  
  static class CompleteBrowserInfoRequest
    implements Runnable
  {
    BrowserInfoGatherer m_info = null;
    CountDownLatch m_latch = null;
    
    public CompleteBrowserInfoRequest(BrowserInfoGatherer paramBrowserInfoGatherer, CountDownLatch paramCountDownLatch)
    {
      m_info = paramBrowserInfoGatherer;
      m_latch = paramCountDownLatch;
    }
    
    public void run()
    {
      throw new NoSuchMethodError();
    }
  }
}

/* Location:
 * Qualified Name:     com.threatmetrix.TrustDefenderMobile.BrowserInfoGatherer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */