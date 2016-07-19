package com.leanplum;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import com.leanplum.callbacks.ActionCallback;
import com.leanplum.callbacks.RegisterDeviceCallback;
import com.leanplum.callbacks.RegisterDeviceFinishedCallback;
import com.leanplum.callbacks.StartCallback;
import com.leanplum.callbacks.VariablesChangedCallback;
import com.leanplum.messagetemplates.MessageTemplates;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public class Leanplum
{
  public static int ACTION_KIND_ACTION = 0;
  public static int ACTION_KIND_MESSAGE = 1;
  public static final String PURCHASE_EVENT_NAME = "Purchase";
  static boolean a;
  static boolean b = false;
  static boolean c;
  private static ArrayList<StartCallback> d;
  private static ArrayList<VariablesChangedCallback> e;
  private static ArrayList<VariablesChangedCallback> f;
  private static ArrayList<VariablesChangedCallback> g;
  private static Map<String, List<ActionCallback>> h;
  private static RegisterDeviceCallback i;
  private static RegisterDeviceFinishedCallback j;
  private static c k;
  private static boolean l;
  private static boolean m;
  private static boolean n;
  private static LeanplumDeviceIdMode o = LeanplumDeviceIdMode.MD5_MAC_ADDRESS;
  private static String p;
  private static boolean q;
  private static boolean r = false;
  private static boolean s;
  private static Object t = new Object();
  private static ScheduledExecutorService u;
  private static Context v;
  private static Queue<Map<String, ?>> w = new ConcurrentLinkedQueue();
  private static StartCallback x;
  
  static
  {
    ACTION_KIND_ACTION = 2;
    d = new ArrayList();
    e = new ArrayList();
    f = new ArrayList();
    g = new ArrayList();
    h = new HashMap();
  }
  
  private static void A()
  {
    T.b("resumeState", new HashMap()).e();
  }
  
  static Context a()
  {
    if (v == null) {
      Log.e("Leanplum", "Your application context is not set. You should call Leanplum.setApplicationContext(this) or LeanplumActivityHelper.enableLifecycleCallbacks(this) in your application's onCreate method, or have your application extend LeanplumApplication.");
    }
    return v;
  }
  
  private static <T> Map<String, T> a(Map<String, T> paramMap, String paramString, boolean paramBoolean)
  {
    if (paramMap == null) {
      return null;
    }
    HashMap localHashMap = new HashMap();
    Iterator localIterator = paramMap.keySet().iterator();
    String str;
    Object localObject2;
    do
    {
      if (!localIterator.hasNext()) {
        return localHashMap;
      }
      str = (String)localIterator.next();
      localObject2 = paramMap.get(str);
    } while (localObject2 == null);
    Object localObject1;
    label92:
    int i1;
    if ((paramBoolean) && ((localObject2 instanceof Iterable)))
    {
      localObject1 = ((Iterable)localObject2).iterator();
      if (!((Iterator)localObject1).hasNext())
      {
        i1 = 1;
        label104:
        if (i1 == 0) {
          break label144;
        }
        localObject1 = localObject2;
      }
    }
    for (;;)
    {
      localHashMap.put(str, localObject1);
      break;
      if (a(((Iterator)localObject1).next(), paramString)) {
        break label92;
      }
      i1 = 0;
      break label104;
      label144:
      break;
      localObject1 = localObject2;
      if ((localObject2 instanceof Date)) {
        localObject1 = Long.valueOf(((Date)localObject2).getTime());
      }
      if (!a(localObject1, paramString)) {
        break;
      }
    }
  }
  
  private static void a(Context paramContext, String paramString, Map<String, ?> paramMap, StartCallback paramStartCallback, Boolean paramBoolean)
  {
    for (;;)
    {
      boolean bool;
      try
      {
        N.a();
        if ((paramContext instanceof Activity)) {
          LeanplumActivityHelper.b = (Activity)paramContext;
        }
        if ((LeanplumActivityHelper.b != null) && (!LeanplumActivityHelper.a))
        {
          bool = false;
          if (g.a())
          {
            l = true;
            m = true;
            d(true);
            w();
            x();
            aU.a(new HashMap(), new HashMap(), new HashMap(), new ArrayList());
          }
        }
        else
        {
          bool = true;
          continue;
        }
        if (paramStartCallback != null) {
          addStartResponseHandler(paramStartCallback);
        }
        if (paramContext != null) {
          setApplicationContext(paramContext.getApplicationContext());
        }
        if (!a) {
          break label164;
        }
        if ((!bool) && (c))
        {
          c = false;
          r();
          continue;
        }
        Log.i("Leanplum", "Already called start");
      }
      finally {}
      continue;
      label164:
      r = true;
      MessageTemplates.register(a());
      c = bool;
      paramMap = a(paramMap, "userAttributes", true);
      a = true;
      if (paramMap != null) {
        w.add(paramMap);
      }
      k = c.a();
      aU.a(true);
      aU.d();
      aU.a(false);
      aU.a(new aV());
      T.a(new aa());
      if ((p == null) && (o.equals(LeanplumDeviceIdMode.ADVERTISING_ID))) {
        Util.a(new E(paramContext, paramString, paramMap, bool), new Void[0]);
      } else {
        b(paramContext, paramString, paramMap, bool);
      }
    }
  }
  
  static void a(ActionContext paramActionContext)
  {
    a(paramActionContext, null);
  }
  
  private static void a(ActionContext paramActionContext, VariablesChangedCallback paramVariablesChangedCallback)
  {
    synchronized (h)
    {
      Object localObject2 = (List)h.get(paramActionContext.actionName());
      if (localObject2 == null)
      {
        if (paramVariablesChangedCallback != null) {
          paramVariablesChangedCallback.variablesChanged();
        }
        return;
      }
      localObject2 = new ArrayList((Collection)localObject2);
      ??? = new AtomicBoolean(false);
      localObject2 = ((List)localObject2).iterator();
      if (((Iterator)localObject2).hasNext())
      {
        ActionCallback localActionCallback = (ActionCallback)((Iterator)localObject2).next();
        N.a().a(new s(localActionCallback, paramActionContext, paramVariablesChangedCallback, (AtomicBoolean)???));
      }
    }
  }
  
  static void a(RuntimeException paramRuntimeException)
  {
    if (g.k) {
      throw paramRuntimeException;
    }
    Log.e("Leanplum", paramRuntimeException.getMessage() + " This error is only thrown in development mode.", paramRuntimeException);
  }
  
  static void a(String paramString)
  {
    if (g.a()) {
      return;
    }
    paramString = new w(paramString);
    x = paramString;
    addStartResponseHandler(paramString);
  }
  
  static void a(String paramString1, double paramDouble, String paramString2, Map<String, ?> paramMap, Map<String, String> paramMap1)
  {
    if (g.a()) {
      return;
    }
    if (!a)
    {
      Log.e("Leanplum", "You cannot call track before calling start");
      return;
    }
    HashMap localHashMap = new HashMap();
    if (paramMap1 != null) {
      localHashMap.putAll(paramMap1);
    }
    localHashMap.put("value", paramDouble);
    localHashMap.put("info", paramString2);
    if (paramString1 != null) {
      localHashMap.put("event", paramString1);
    }
    paramString2 = paramMap;
    if (paramMap != null)
    {
      paramString2 = a(paramMap, "params", false);
      localHashMap.put("params", a.a(paramString2));
    }
    if ((!s) || (LeanplumActivityHelper.a)) {
      localHashMap.put("allowOffline", Boolean.TRUE.toString());
    }
    if (l)
    {
      c(paramString1, paramString2, localHashMap);
      return;
    }
    addStartResponseHandler(new y(paramString1, paramString2, localHashMap));
  }
  
  private static void a(String paramString, int paramInt, ActionArgs paramActionArgs, Map<String, Object> paramMap, ActionCallback paramActionCallback)
  {
    paramMap = a();
    if (!r)
    {
      r = true;
      MessageTemplates.register(paramMap);
    }
    paramMap = new HashMap();
    h.remove(paramString);
    aU.a(paramString, paramInt, paramActionArgs.a(), paramMap);
    if (paramActionCallback != null) {
      onAction(paramString, paramActionCallback);
    }
  }
  
  static void a(String paramString1, String paramString2)
  {
    Map localMap = aU.l();
    if (localMap == null) {}
    do
    {
      return;
      localMap = (Map)localMap.get(paramString2);
    } while (localMap == null);
    new ActionContext(localMap.get("action").toString(), (Map)localMap.get("vars"), paramString2).runTrackedActionNamed(paramString1);
  }
  
  static void a(String paramString1, String paramString2, int paramInt, String paramString3, b paramb)
  {
    a(new String[] { paramString1 }, paramString2, paramInt, paramString3, paramb);
  }
  
  private static void a(String[] paramArrayOfString, String paramString1, int paramInt, String paramString2, b paramb)
  {
    Map localMap = aU.l();
    if (localMap == null) {
      return;
    }
    Iterator localIterator = localMap.keySet().iterator();
    label25:
    String str;
    Object localObject1;
    Object localObject2;
    int i1;
    label112:
    int i2;
    while (localIterator.hasNext())
    {
      str = (String)localIterator.next();
      if ((str == null) || (!str.equals(paramString2)))
      {
        localObject1 = (Map)localMap.get(str);
        localObject2 = (String)((Map)localObject1).get("action");
        if ((localObject2 instanceof String))
        {
          if (!((String)localObject2).equals("__Push Notification")) {
            break label293;
          }
          i1 = 0;
          if ((i1 != 0) && ((paramInt & 0x1) == 0)) {
            break label297;
          }
          localObject2 = new f();
          i2 = paramArrayOfString.length;
          i1 = 0;
        }
      }
    }
    for (;;)
    {
      if (i1 >= i2)
      {
        if (b) {
          a(new ActionContext("__Cancel" + ((Map)localObject1).get("action"), new HashMap(), str), new t(str));
        }
        if (!a) {
          break label25;
        }
        k.a(str);
        if (!c) {
          break label25;
        }
        localObject1 = new ActionContext(((Map)localObject1).get("action").toString(), (Map)((Map)localObject1).get("vars"), str);
        ((ActionContext)localObject1).a(paramb);
        a((ActionContext)localObject1, new u(str));
        break label25;
        break;
        label293:
        i1 = 1;
        break label112;
        label297:
        break label25;
      }
      Object localObject3 = paramArrayOfString[i1];
      localObject3 = k.a(str, (Map)localObject1, (String)localObject3, paramString1, paramb);
      a |= a;
      b |= b;
      boolean bool = c;
      c |= bool;
      i1 += 1;
    }
  }
  
  private static boolean a(Object paramObject, String paramString)
  {
    if ((!(paramObject instanceof Number)) && (!(paramObject instanceof String)) && (!(paramObject instanceof Boolean)))
    {
      a(new LeanplumException(paramString + " values must be of type String, Number, or Boolean."));
      return false;
    }
    return true;
  }
  
  public static void addOnceVariablesChangedAndNoDownloadsPendingHandler(VariablesChangedCallback paramVariablesChangedCallback)
  {
    if ((aU.c()) && (T.i() == 0))
    {
      paramVariablesChangedCallback.variablesChanged();
      return;
    }
    synchronized (g)
    {
      g.add(paramVariablesChangedCallback);
      return;
    }
  }
  
  public static void addStartResponseHandler(StartCallback paramStartCallback)
  {
    if (l)
    {
      paramStartCallback.setSuccess(m);
      paramStartCallback.run();
      return;
    }
    synchronized (d)
    {
      if (d.indexOf(paramStartCallback) == -1) {
        d.add(paramStartCallback);
      }
      return;
    }
  }
  
  public static void addVariablesChangedAndNoDownloadsPendingHandler(VariablesChangedCallback paramVariablesChangedCallback)
  {
    synchronized (f)
    {
      f.add(paramVariablesChangedCallback);
      if ((aU.c()) && (T.i() == 0)) {
        paramVariablesChangedCallback.variablesChanged();
      }
      return;
    }
  }
  
  public static void addVariablesChangedHandler(VariablesChangedCallback paramVariablesChangedCallback)
  {
    synchronized (e)
    {
      e.add(paramVariablesChangedCallback);
      if (aU.c()) {
        paramVariablesChangedCallback.variablesChanged();
      }
      return;
    }
  }
  
  public static void advanceTo(String paramString)
  {
    advanceTo(paramString, "", null);
  }
  
  public static void advanceTo(String paramString1, String paramString2)
  {
    advanceTo(paramString1, paramString2, null);
  }
  
  public static void advanceTo(String paramString1, String paramString2, Map<String, ?> paramMap)
  {
    if (g.a()) {
      return;
    }
    if (!a)
    {
      Log.e("Leanplum", "You cannot call advanceTo before calling start");
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("info", paramString2);
    localHashMap.put("state", paramString1);
    if (paramMap != null)
    {
      paramString2 = a(paramMap, "params", false);
      localHashMap.put("params", a.a(paramString2));
    }
    while (l)
    {
      d(paramString1, paramString2, localHashMap);
      return;
      paramString2 = null;
    }
    addStartResponseHandler(new z(paramString1, paramString2, localHashMap));
  }
  
  public static void advanceTo(String paramString, Map<String, ?> paramMap)
  {
    advanceTo(paramString, "", paramMap);
  }
  
  static void b()
  {
    if (g.a()) {
      return;
    }
    if (!a)
    {
      Log.e("Leanplum", "You cannot call pause before calling start");
      return;
    }
    b = true;
    if (l)
    {
      s();
      return;
    }
    addStartResponseHandler(new K());
  }
  
  private static void b(Context paramContext, String paramString, Map<String, ?> paramMap, boolean paramBoolean)
  {
    LeanplumPushService.b();
    Object localObject2 = null;
    HashMap localHashMap = null;
    Object localObject1;
    if (T.c() == null)
    {
      if ((q) || (g.i == null)) {
        break label411;
      }
      localObject1 = g.i;
      localObject2 = localHashMap;
    }
    for (;;)
    {
      T.a((String)localObject1);
      localObject1 = paramString;
      if (paramString == null)
      {
        paramString = T.d();
        localObject1 = paramString;
        if (paramString == null) {
          localObject1 = T.c();
        }
      }
      T.b((String)localObject1);
      localObject1 = Util.a();
      paramString = (String)localObject1;
      if (localObject1 == null) {
        paramString = "";
      }
      localObject1 = TimeZone.getDefault();
      int i1 = ((TimeZone)localObject1).getOffset(new Date().getTime()) / 1000;
      localHashMap = new HashMap();
      localHashMap.put("includeDefaults", "false");
      if (paramBoolean) {
        localHashMap.put("background", Boolean.toString(true));
      }
      localHashMap.put("versionName", paramString);
      localHashMap.put("deviceName", Util.f());
      localHashMap.put("deviceModel", Util.b());
      localHashMap.put("systemName", Util.c());
      localHashMap.put("systemVersion", Util.d());
      localHashMap.put("timezone", ((TimeZone)localObject1).getID());
      localHashMap.put("timezoneOffsetSeconds", i1);
      localHashMap.put("locale", Util.g());
      localHashMap.put("country", "(detect)");
      localHashMap.put("region", "(detect)");
      localHashMap.put("city", "(detect)");
      localHashMap.put("location", "(detect)");
      if (Boolean.TRUE.equals(localObject2)) {
        localHashMap.put("limitTracking", ((Boolean)localObject2).toString());
      }
      if (paramMap != null) {
        localHashMap.put("userAttributes", a.a(paramMap));
      }
      if (g.k) {
        localHashMap.put("devMode", Boolean.TRUE.toString());
      }
      Util.a(localHashMap);
      paramString = T.b("start", localHashMap);
      paramString.a(new F(paramContext, paramBoolean));
      paramString.a(new J());
      paramString.h();
      return;
      label411:
      if (p != null)
      {
        localObject1 = p;
        localObject2 = localHashMap;
      }
      else
      {
        localObject2 = Util.a(o);
        localObject1 = a;
        localObject2 = Boolean.valueOf(b);
      }
    }
  }
  
  private static void b(String paramString, HashMap<String, String> paramHashMap)
  {
    T.b("setUserAttributes", paramHashMap).e();
    if ((paramString != null) && (paramString.length() > 0))
    {
      T.b(paramString);
      if (l) {
        aU.e();
      }
    }
    y();
  }
  
  private static void b(HashMap<String, String> paramHashMap)
  {
    T.b("setTrafficSourceInfo", paramHashMap).e();
  }
  
  static void c()
  {
    if (g.a()) {
      return;
    }
    if (!a)
    {
      Log.e("Leanplum", "You cannot call resume before calling start");
      return;
    }
    b = false;
    if (l)
    {
      t();
      return;
    }
    addStartResponseHandler(new L());
  }
  
  private static void c(String paramString, Map<String, ?> paramMap, Map<String, String> paramMap1)
  {
    T.b("track", paramMap1).e();
    String str = (String)paramMap1.get("messageId");
    paramMap1 = paramString;
    if (str != null)
    {
      paramMap1 = ".m" + str;
      if ((paramString == null) || (paramString.length() <= 0)) {
        break label107;
      }
      paramMap1 = paramMap1 + " " + paramString;
    }
    label107:
    for (;;)
    {
      paramString = new b();
      a = paramMap;
      a("event", paramMap1, 3, str, paramString);
      return;
    }
  }
  
  static void d()
  {
    synchronized (FileManager.b)
    {
      if (FileManager.a())
      {
        FileManager.a(new l());
        return;
      }
      v();
    }
  }
  
  private static void d(String paramString, Map<String, ?> paramMap, Map<String, String> paramMap1)
  {
    T.b("advance", paramMap1).e();
    paramMap1 = new b();
    a = paramMap;
    a("state", paramString, 3, null, paramMap1);
  }
  
  private static void d(boolean paramBoolean)
  {
    synchronized (d)
    {
      Iterator localIterator = d.iterator();
      if (!localIterator.hasNext())
      {
        d.clear();
        return;
      }
      StartCallback localStartCallback = (StartCallback)localIterator.next();
      localStartCallback.setSuccess(paramBoolean);
      N.a().a(localStartCallback);
    }
  }
  
  public static void defineAction(String paramString, int paramInt, ActionArgs paramActionArgs)
  {
    a(paramString, paramInt, paramActionArgs, null, null);
  }
  
  public static void defineAction(String paramString, int paramInt, ActionArgs paramActionArgs, ActionCallback paramActionCallback)
  {
    a(paramString, paramInt, paramActionArgs, null, paramActionCallback);
  }
  
  public static void enableTestMode()
  {
    g.l = true;
  }
  
  public static void enableVerboseLoggingInDevelopmentMode()
  {
    g.m = true;
  }
  
  public static void forceContentUpdate()
  {
    forceContentUpdate(null);
  }
  
  public static void forceContentUpdate(VariablesChangedCallback paramVariablesChangedCallback)
  {
    if (g.a())
    {
      if (paramVariablesChangedCallback != null) {
        N.a().a(paramVariablesChangedCallback);
      }
      return;
    }
    Object localObject = new HashMap();
    ((Map)localObject).put("includeDefaults", "false");
    localObject = T.b("getVars", (Map)localObject);
    ((T)localObject).a(new C(paramVariablesChangedCallback));
    ((T)localObject).a(new D(paramVariablesChangedCallback));
    ((T)localObject).h();
  }
  
  public static boolean hasStarted()
  {
    return l;
  }
  
  public static boolean hasStartedAndRegisteredAsDeveloper()
  {
    return n;
  }
  
  public static boolean isTestModeEnabled()
  {
    return g.l;
  }
  
  public static Object objectForKeyPath(Object... paramVarArgs)
  {
    return aU.a(paramVarArgs);
  }
  
  public static Object objectForKeyPathComponents(Object[] paramArrayOfObject)
  {
    return aU.a(paramArrayOfObject);
  }
  
  public static void onAction(String paramString, ActionCallback paramActionCallback)
  {
    if (h == null) {
      h = new HashMap();
    }
    List localList = (List)h.get(paramString);
    Object localObject = localList;
    if (localList == null)
    {
      localObject = new ArrayList();
      h.put(paramString, localObject);
    }
    ((List)localObject).add(paramActionCallback);
  }
  
  public static String pathForResource(String paramString)
  {
    return Var.defineFile(paramString, paramString).fileValue();
  }
  
  public static void pauseState()
  {
    if (g.a()) {
      return;
    }
    if (!a)
    {
      Log.e("Leanplum", "You cannot call pauseState before calling start");
      return;
    }
    if (l)
    {
      z();
      return;
    }
    addStartResponseHandler(new A());
  }
  
  private static void r()
  {
    synchronized (t)
    {
      if (s) {
        return;
      }
      s = true;
      if ((g.k) && (!g.a())) {
        new ac();
      }
      a(new String[] { "start", "resume" }, null, 3, null, null);
      y();
      return;
    }
  }
  
  public static void removeOnceVariablesChangedAndNoDownloadsPendingHandler(VariablesChangedCallback paramVariablesChangedCallback)
  {
    synchronized (g)
    {
      g.remove(paramVariablesChangedCallback);
      return;
    }
  }
  
  public static void removeStartResponseHandler(StartCallback paramStartCallback)
  {
    synchronized (d)
    {
      d.remove(paramStartCallback);
      return;
    }
  }
  
  public static void removeVariablesChangedAndNoDownloadsPendingHandler(VariablesChangedCallback paramVariablesChangedCallback)
  {
    synchronized (f)
    {
      f.remove(paramVariablesChangedCallback);
      return;
    }
  }
  
  public static void removeVariablesChangedHandler(VariablesChangedCallback paramVariablesChangedCallback)
  {
    synchronized (e)
    {
      e.remove(paramVariablesChangedCallback);
      return;
    }
  }
  
  static void reset()
  {
    a = false;
    l = false;
    n = false;
    m = false;
    d.clear();
    e.clear();
    f.clear();
    g.clear();
    h.clear();
    w.clear();
  }
  
  public static void resumeState()
  {
    if (g.a()) {
      return;
    }
    if (!a)
    {
      Log.e("Leanplum", "You cannot call resumeState before calling start");
      return;
    }
    if (l)
    {
      A();
      return;
    }
    addStartResponseHandler(new B());
  }
  
  private static void s()
  {
    T.b("pauseSession", null).h();
    if (u != null) {
      u.shutdown();
    }
  }
  
  public static void setApiConnectionSettings(String paramString1, String paramString2, boolean paramBoolean)
  {
    g.a = paramString1;
    g.q = paramString2;
    g.d = paramBoolean;
  }
  
  public static void setAppIdForDevelopmentMode(String paramString1, String paramString2)
  {
    g.k = true;
    T.a(paramString1, paramString2);
  }
  
  public static void setAppIdForProductionMode(String paramString1, String paramString2)
  {
    g.k = false;
    T.a(paramString1, paramString2);
  }
  
  public static void setApplicationContext(Context paramContext)
  {
    v = paramContext;
  }
  
  public static void setCanDownloadContentMidSessionInProductionMode(boolean paramBoolean)
  {
    g.o = paramBoolean;
  }
  
  static void setClient(String paramString1, String paramString2, String paramString3)
  {
    g.h = paramString1;
    g.g = paramString2;
    g.i = paramString3;
  }
  
  public static void setDeviceId(String paramString)
  {
    p = paramString;
    q = true;
  }
  
  public static void setDeviceIdMode(LeanplumDeviceIdMode paramLeanplumDeviceIdMode)
  {
    o = paramLeanplumDeviceIdMode;
    q = true;
  }
  
  public static void setFileHashingEnabledInDevelopmentMode(boolean paramBoolean)
  {
    g.j = paramBoolean;
  }
  
  public static void setFileUploadingEnabledInDevelopmentMode(boolean paramBoolean)
  {
    g.n = paramBoolean;
  }
  
  public static void setIsTestModeEnabled(boolean paramBoolean)
  {
    g.l = paramBoolean;
  }
  
  public static void setNetworkTimeout(int paramInt1, int paramInt2)
  {
    g.e = paramInt1;
    g.f = paramInt2;
  }
  
  @Deprecated
  public static void setRegisterDeviceHandler(RegisterDeviceCallback paramRegisterDeviceCallback, RegisterDeviceFinishedCallback paramRegisterDeviceFinishedCallback)
  {
    i = paramRegisterDeviceCallback;
    j = paramRegisterDeviceFinishedCallback;
  }
  
  public static void setSocketConnectionSettings(String paramString, int paramInt)
  {
    g.b = paramString;
    g.c = paramInt;
  }
  
  public static void setTrafficSourceInfo(Map<String, String> paramMap)
  {
    if (g.a()) {
      return;
    }
    if (!a)
    {
      Log.e("Leanplum", "You cannot call setTrafficSourceInfo before calling start");
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("trafficSource", a.a(a(paramMap, "info", false)));
    if (l)
    {
      b(localHashMap);
      return;
    }
    addStartResponseHandler(new x(localHashMap));
  }
  
  public static void setUserAttributes(String paramString, Map<String, ?> paramMap)
  {
    if (g.a()) {
      return;
    }
    if (!a)
    {
      Log.e("Leanplum", "You cannot call setUserAttributes before calling start");
      return;
    }
    HashMap localHashMap = new HashMap();
    if (paramString != null) {
      localHashMap.put("newUserId", paramString);
    }
    if (paramMap != null)
    {
      paramMap = a(paramMap, "userAttributes", true);
      localHashMap.put("userAttributes", a.a(paramMap));
      w.add(paramMap);
    }
    if (l)
    {
      b(paramString, localHashMap);
      return;
    }
    addStartResponseHandler(new v(paramString, localHashMap));
  }
  
  public static void setUserAttributes(Map<String, Object> paramMap)
  {
    setUserAttributes(null, paramMap);
  }
  
  public static void setUserId(String paramString)
  {
    setUserAttributes(paramString, null);
  }
  
  public static void start(Context paramContext)
  {
    a(paramContext, null, null, null, null);
  }
  
  public static void start(Context paramContext, StartCallback paramStartCallback)
  {
    a(paramContext, null, null, paramStartCallback, null);
  }
  
  public static void start(Context paramContext, String paramString)
  {
    a(paramContext, paramString, null, null, null);
  }
  
  public static void start(Context paramContext, String paramString, StartCallback paramStartCallback)
  {
    a(paramContext, paramString, null, paramStartCallback, null);
  }
  
  public static void start(Context paramContext, String paramString, Map<String, ?> paramMap)
  {
    a(paramContext, paramString, paramMap, null, null);
  }
  
  public static void start(Context paramContext, String paramString, Map<String, ?> paramMap, StartCallback paramStartCallback)
  {
    try
    {
      a(paramContext, paramString, paramMap, paramStartCallback, null);
      return;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  public static void start(Context paramContext, Map<String, ?> paramMap)
  {
    a(paramContext, null, paramMap, null, null);
  }
  
  public static void syncResources()
  {
    if (g.a()) {
      return;
    }
    FileManager.a(null, null, false);
  }
  
  public static void syncResources(List<String> paramList1, List<String> paramList2)
  {
    FileManager.a(paramList1, paramList2, false);
  }
  
  public static void syncResourcesAsync()
  {
    if (g.a()) {
      return;
    }
    FileManager.a(null, null, true);
  }
  
  public static void syncResourcesAsync(List<String> paramList1, List<String> paramList2)
  {
    FileManager.a(paramList1, paramList2, true);
  }
  
  private static void t()
  {
    T localT = T.b("resumeSession", null);
    if (c)
    {
      c = false;
      localT.e();
      r();
    }
    for (;;)
    {
      u();
      return;
      localT.f();
      a("resume", null, 3, null, null);
    }
  }
  
  public static void track(String paramString)
  {
    track(paramString, 0.0D, "", null);
  }
  
  public static void track(String paramString, double paramDouble)
  {
    track(paramString, paramDouble, "", null);
  }
  
  public static void track(String paramString1, double paramDouble, String paramString2)
  {
    track(paramString1, paramDouble, paramString2, null);
  }
  
  public static void track(String paramString1, double paramDouble, String paramString2, Map<String, ?> paramMap)
  {
    a(paramString1, paramDouble, paramString2, paramMap, null);
  }
  
  public static void track(String paramString, double paramDouble, Map<String, ?> paramMap)
  {
    track(paramString, paramDouble, "", paramMap);
  }
  
  public static void track(String paramString1, String paramString2)
  {
    track(paramString1, 0.0D, paramString2, null);
  }
  
  public static void track(String paramString, Map<String, ?> paramMap)
  {
    track(paramString, 0.0D, "", paramMap);
  }
  
  public static void trackGooglePlayPurchase(String paramString1, long paramLong, String paramString2, String paramString3, String paramString4)
  {
    trackGooglePlayPurchase("Purchase", paramString1, paramLong, paramString2, paramString3, paramString4, null);
  }
  
  public static void trackGooglePlayPurchase(String paramString1, long paramLong, String paramString2, String paramString3, String paramString4, Map<String, ?> paramMap)
  {
    trackGooglePlayPurchase("Purchase", paramString1, paramLong, paramString2, paramString3, paramString4, paramMap);
  }
  
  public static void trackGooglePlayPurchase(String paramString1, String paramString2, long paramLong, String paramString3, String paramString4, String paramString5, Map<String, ?> paramMap)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("googlePlayPurchaseData", paramString4);
    localHashMap.put("googlePlayPurchaseDataSignature", paramString5);
    localHashMap.put("currencyCode", paramString3);
    if (paramMap == null) {}
    for (paramString3 = new HashMap();; paramString3 = new HashMap(paramMap))
    {
      paramString3.put("item", paramString2);
      a(paramString1, paramLong / 1000000.0D, null, paramString3, localHashMap);
      return;
    }
  }
  
  private static void u()
  {
    ScheduledExecutorService localScheduledExecutorService = Executors.newScheduledThreadPool(1);
    u = localScheduledExecutorService;
    localScheduledExecutorService.scheduleAtFixedRate(new M(), 15L, 15L, TimeUnit.MINUTES);
  }
  
  private static void v()
  {
    if (!n)
    {
      n = true;
      aU.g();
      aU.h();
    }
  }
  
  public static List<Map<String, Object>> variants()
  {
    List localList = aU.j();
    Object localObject = localList;
    if (localList == null) {
      localObject = new ArrayList();
    }
    return (List<Map<String, Object>>)localObject;
  }
  
  private static void w()
  {
    synchronized (e)
    {
      Iterator localIterator = e.iterator();
      if (!localIterator.hasNext()) {
        return;
      }
      VariablesChangedCallback localVariablesChangedCallback = (VariablesChangedCallback)localIterator.next();
      N.a().a(localVariablesChangedCallback);
    }
  }
  
  private static void x()
  {
    for (;;)
    {
      Iterator localIterator;
      synchronized (f)
      {
        localIterator = f.iterator();
        if (localIterator.hasNext()) {}
      }
      synchronized (g)
      {
        localIterator = g.iterator();
        if (!localIterator.hasNext())
        {
          g.clear();
          return;
          localVariablesChangedCallback = (VariablesChangedCallback)localIterator.next();
          N.a().a(localVariablesChangedCallback);
          continue;
          localObject1 = finally;
          throw ((Throwable)localObject1);
        }
        VariablesChangedCallback localVariablesChangedCallback = (VariablesChangedCallback)((Iterator)localObject1).next();
        N.a().a(localVariablesChangedCallback);
      }
    }
  }
  
  private static void y()
  {
    Iterator localIterator1 = w.iterator();
    int i1 = 0;
    for (;;)
    {
      if (!localIterator1.hasNext())
      {
        w.clear();
        if (i1 != 0) {
          aU.n();
        }
        return;
      }
      Map localMap1 = (Map)localIterator1.next();
      Map localMap2 = aU.m();
      Iterator localIterator2 = localMap1.keySet().iterator();
      while (localIterator2.hasNext())
      {
        String str = (String)localIterator2.next();
        Object localObject1 = localMap2.get(str);
        Object localObject2 = localMap1.get(str);
        if (((localObject1 == null) && (localObject2 != null)) || ((localObject1 != null) && (!localObject1.equals(localObject2))))
        {
          b localb = new b();
          b = localObject1;
          c = localObject2;
          localMap2.put(str, localObject2);
          a("userAttribute", str, 3, null, localb);
          i1 = 1;
        }
      }
    }
  }
  
  private static void z()
  {
    T.b("pauseState", new HashMap()).e();
  }
}

/* Location:
 * Qualified Name:     com.leanplum.Leanplum
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */