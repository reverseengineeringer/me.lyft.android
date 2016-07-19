package com.appboy;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.net.Uri;
import android.os.Build.VERSION;
import android.widget.ImageView;
import bo.app.a;
import bo.app.ab;
import bo.app.an;
import bo.app.ao;
import bo.app.ap;
import bo.app.aq;
import bo.app.ar;
import bo.app.as;
import bo.app.at;
import bo.app.au;
import bo.app.av;
import bo.app.aw;
import bo.app.ax;
import bo.app.ay;
import bo.app.az;
import bo.app.b;
import bo.app.ba;
import bo.app.bd;
import bo.app.be;
import bo.app.bf;
import bo.app.bi;
import bo.app.bj;
import bo.app.bk;
import bo.app.bl;
import bo.app.bo;
import bo.app.bp;
import bo.app.bu;
import bo.app.bv;
import bo.app.by;
import bo.app.bz;
import bo.app.c;
import bo.app.ca;
import bo.app.cb;
import bo.app.cg;
import bo.app.cj;
import bo.app.cm;
import bo.app.cn;
import bo.app.cx;
import bo.app.db;
import bo.app.dd;
import bo.app.dq;
import bo.app.dr;
import bo.app.dx;
import bo.app.ed;
import bo.app.ev;
import bo.app.ex;
import bo.app.ez;
import bo.app.f;
import bo.app.fb;
import bo.app.fe;
import bo.app.fg;
import bo.app.fj;
import bo.app.fo;
import bo.app.fp;
import bo.app.gt;
import bo.app.hk;
import bo.app.hl;
import bo.app.hm;
import bo.app.ho;
import bo.app.hp;
import bo.app.hq;
import bo.app.hu;
import bo.app.hv;
import bo.app.hw;
import bo.app.hy;
import bo.app.ir;
import bo.app.jb;
import bo.app.ji;
import bo.app.jx;
import bo.app.jz;
import bo.app.l;
import bo.app.n;
import bo.app.y;
import com.amazon.device.messaging.ADM;
import com.appboy.configuration.XmlAppConfigurationProvider;
import com.appboy.enums.SocialNetwork;
import com.appboy.events.FeedUpdatedEvent;
import com.appboy.events.IEventSubscriber;
import com.appboy.events.InAppMessageEvent;
import com.appboy.events.SubmitFeedbackFailed;
import com.appboy.events.SubmitFeedbackSucceeded;
import com.appboy.models.IInAppMessage;
import com.appboy.models.outgoing.AppboyProperties;
import com.appboy.models.outgoing.Feedback;
import com.appboy.support.AppboyLogger;
import com.appboy.support.StringUtils;
import com.appboy.support.ValidationUtils;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class Appboy
  implements IAppboy, IAppboyUnitySupport
{
  private static volatile IAppboyNotificationFactory A;
  private static volatile boolean B = false;
  private static final String f = String.format("%s.%s", new Object[] { Constants.APPBOY_LOG_TAG_PREFIX, Appboy.class.getName() });
  private static final Set<String> g = new HashSet(Arrays.asList(new String[] { "AED", "AFN", "ALL", "AMD", "ANG", "AOA", "ARS", "AUD", "AWG", "AZN", "BAM", "BBD", "BDT", "BGN", "BHD", "BIF", "BMD", "BND", "BOB", "BRL", "BSD", "BTC", "BTN", "BWP", "BYR", "BZD", "CAD", "CDF", "CHF", "CLF", "CLP", "CNY", "COP", "CRC", "CUC", "CUP", "CVE", "CZK", "DJF", "DKK", "DOP", "DZD", "EEK", "EGP", "ERN", "ETB", "EUR", "FJD", "FKP", "GBP", "GEL", "GGP", "GHS", "GIP", "GMD", "GNF", "GTQ", "GYD", "HKD", "HNL", "HRK", "HTG", "HUF", "IDR", "ILS", "IMP", "INR", "IQD", "IRR", "ISK", "JEP", "JMD", "JOD", "JPY", "KES", "KGS", "KHR", "KMF", "KPW", "KRW", "KWD", "KYD", "KZT", "LAK", "LBP", "LKR", "LRD", "LSL", "LTL", "LVL", "LYD", "MAD", "MDL", "MGA", "MKD", "MMK", "MNT", "MOP", "MRO", "MTL", "MUR", "MVR", "MWK", "MXN", "MYR", "MZN", "NAD", "NGN", "NIO", "NOK", "NPR", "NZD", "OMR", "PAB", "PEN", "PGK", "PHP", "PKR", "PLN", "PYG", "QAR", "RON", "RSD", "RUB", "RWF", "SAR", "SBD", "SCR", "SDG", "SEK", "SGD", "SHP", "SLL", "SOS", "SRD", "STD", "SVC", "SYP", "SZL", "THB", "TJS", "TMT", "TND", "TOP", "TRY", "TTD", "TWD", "TZS", "UAH", "UGX", "USD", "UYU", "UZS", "VEF", "VND", "VUV", "WST", "XAF", "XAG", "XAU", "XCD", "XDR", "XOF", "XPD", "XPF", "XPT", "YER", "ZAR", "ZMK", "ZMW", "ZWL" }));
  private static final Set<String> h = new HashSet(Arrays.asList(new String[] { "android.permission.ACCESS_NETWORK_STATE", "android.permission.INTERNET" }));
  private static volatile Appboy i = null;
  private static final Object y = new Object();
  private static volatile IAppboyEndpointProvider z;
  private IAppboyNavigator C;
  volatile fo a;
  public volatile ex b;
  volatile gt c;
  volatile fb d;
  final XmlAppConfigurationProvider e;
  private final Context j;
  private final hv k;
  private final ba l;
  private volatile AppboyUser m;
  private volatile f n;
  private volatile bd o;
  private volatile ThreadPoolExecutor p;
  private volatile by q;
  private final l r;
  private final cm s;
  private final bv t;
  private final cg u;
  private final bu v;
  private final Object w = new Object();
  private final Object x = new Object();
  
  private Appboy(Context paramContext)
  {
    long l1 = System.nanoTime();
    j = paramContext.getApplicationContext();
    r = new l(j);
    e = new XmlAppConfigurationProvider(j);
    t = new bv(j);
    paramContext = new ThreadPoolExecutor(4, 8, 1L, TimeUnit.SECONDS, new LinkedBlockingQueue(10));
    l = new ba(paramContext);
    Object localObject1;
    Object localObject2;
    label448:
    int i2;
    Object localObject3;
    if (!e.getIsUilImageCacheDisabled())
    {
      i1 = Math.min((int)Runtime.getRuntime().maxMemory() / 32, 1048576);
      localObject1 = f;
      String.format("Setting maximum in-memory image cache size to %d bytes.", new Object[] { Integer.valueOf(i1) });
      localObject1 = new hy(j);
      if ((c != null) || (d != null)) {
        jx.c("threadPoolSize(), threadPriority() and tasksProcessingOrder() calls can overlap taskExecutor() and taskExecutorForCachedImages() calls.", new Object[0]);
      }
      h = 3;
      i = true;
      localObject2 = new hm();
      if (o != null) {
        jx.c("diskCache() and diskCacheFileNameGenerator() calls overlap each other", new Object[0]);
      }
      p = ((hk)localObject2);
      if (o != null) {
        jx.c("diskCache(), diskCacheSize() and diskCacheFileCount calls overlap each other", new Object[0]);
      }
      m = 50;
      if (i1 <= 0) {
        throw new IllegalArgumentException("memoryCacheSize must be a positive number");
      }
      if (n != null) {
        jx.c("memoryCache() and memoryCacheSize() calls overlap each other", new Object[0]);
      }
      k = i1;
      i1 = ir.b;
      if ((c != null) || (d != null)) {
        jx.c("threadPoolSize(), threadPriority() and tasksProcessingOrder() calls can overlap taskExecutor() and taskExecutorForCachedImages() calls.", new Object[0]);
      }
      j = i1;
      localObject2 = new hu();
      h = true;
      i = true;
      s = ((hu)localObject2).a();
      if (c == null)
      {
        c = hq.a(g, h, j);
        if (d != null) {
          break label1188;
        }
        d = hq.a(g, h, j);
        if (o == null)
        {
          if (p == null) {
            p = new hl();
          }
          o = hq.a(b, p, l, m);
        }
        if (n == null)
        {
          localObject2 = b;
          i2 = k;
          i1 = i2;
          if (i2 == 0)
          {
            localObject3 = (ActivityManager)((Context)localObject2).getSystemService("activity");
            i2 = ((ActivityManager)localObject3).getMemoryClass();
            if (Build.VERSION.SDK_INT < 11) {
              break label1197;
            }
            i1 = 1;
            label560:
            if (i1 == 0) {
              break label1373;
            }
            if ((getApplicationInfoflags & 0x100000) == 0) {
              break label1202;
            }
            i1 = 1;
            label581:
            if (i1 == 0) {
              break label1373;
            }
          }
        }
      }
    }
    label746:
    label861:
    label996:
    label1188:
    label1197:
    label1202:
    label1317:
    label1357:
    label1365:
    label1373:
    for (int i1 = ((ActivityManager)localObject3).getLargeMemoryClass();; i1 = i2)
    {
      i1 = i1 * 1048576 / 8;
      n = new hp(i1);
      if (i) {
        n = new ho(n, new jz());
      }
      if (q == null) {
        q = new ji(b);
      }
      if (r == null) {
        r = new jb(t);
      }
      if (s == null) {
        s = new hu().a();
      }
      localObject1 = new hw((hy)localObject1, (byte)0);
      k = hv.a();
      k.a((hw)localObject1);
      s = new cn(j, e);
      if (cg.a(j, e))
      {
        AppboyLogger.i(f, "Google Cloud Messaging found.  Setting up Google Cloud Messaging");
        u = new cg(j, s);
        localObject2 = e.getGcmSenderId();
        if ((e.isGcmMessagingRegistrationEnabled()) && (localObject2 != null))
        {
          localObject1 = u;
          if (c.a() != null) {
            AppboyLogger.w(cg.a, "The device is already registered with the GCM server and is eligible to receive GCM messages.");
          }
        }
        else
        {
          if ((!bu.a(j)) || (cg.a(j, e))) {
            break label1357;
          }
          AppboyLogger.i(f, "Amazon Device Messaging found.  Setting up Amazon Device Messaging");
          v = new bu(j, s);
          localObject1 = v;
          if (b.a() == null) {
            break label1317;
          }
          AppboyLogger.i(bu.c, "The device is already registered with the ADM server and is eligible to receive ADM messages.");
          AppboyLogger.i(bu.c, "ADM registration id: " + b.a());
          b.a(b.a());
          if ((u == null) && (v == null)) {
            AppboyLogger.e(f, "Did not find support for Google Cloud Messaging or Amazon Device Messaging");
          }
          Object localObject4 = new fo(j, r, e, l, t, s, B);
          a((fo)localObject4);
          localObject1 = bz.a();
          localObject2 = p;
          localObject3 = i;
          n localn = d;
          localObject4 = e;
          if (b) {
            break label1365;
          }
          ((Executor)localObject2).execute(new ca((bz)localObject1, (ez)localObject3, localn, (by)localObject4));
        }
      }
      for (;;)
      {
        paramContext.execute(new a(this));
        long l2 = System.nanoTime();
        paramContext = f;
        String.format("Appboy loaded in %d ms.", new Object[] { Long.valueOf(TimeUnit.MILLISECONDS.convert(l2 - l1, TimeUnit.NANOSECONDS)) });
        return;
        e = true;
        break;
        f = true;
        break label448;
        i1 = 0;
        break label560;
        i1 = 0;
        break label581;
        k = null;
        break label746;
        localObject3 = cg.a;
        localObject2 = StringUtils.join(new String[] { localObject2 }, ",");
        localObject3 = new Intent("com.google.android.c2dm.intent.REGISTER");
        ((Intent)localObject3).setPackage("com.google.android.gsf");
        ((Intent)localObject3).putExtra("app", PendingIntent.getBroadcast(b, 0, new Intent(), 0));
        ((Intent)localObject3).putExtra("sender", (String)localObject2);
        b.startService((Intent)localObject3);
        break label861;
        u = null;
        break label861;
        localObject1 = new ADM(a);
        if (!((ADM)localObject1).isSupported()) {
          break label996;
        }
        AppboyLogger.i(bu.c, "Registering with ADM server...");
        ((ADM)localObject1).startRegister();
        break label996;
        v = null;
        break label996;
        localObject1 = bz.a;
      }
    }
  }
  
  private void a(fo paramfo)
  {
    synchronized (w)
    {
      synchronized (x)
      {
        a = paramfo;
        n = j;
        q = e;
        d = m;
        m = new AppboyUser(a, e, r.a(), k, d);
        ??? = g;
        Object localObject4 = c;
        ((ba)localObject4).a(new as((an)???), be.class);
        ((ba)localObject4).a(new aw((an)???), bk.class);
        ((ba)localObject4).a(new ax((an)???), bl.class);
        ((ba)localObject4).a(new ay((an)???), bj.class);
        ((ba)localObject4).a(new aq((an)???), Throwable.class);
        ((ba)localObject4).a(new ar((an)???), bp.class);
        ((ba)localObject4).a(new az((an)???), bo.class);
        ((ba)localObject4).a(new ap((an)???), bi.class);
        ((ba)localObject4).a(new ao((an)???), bf.class);
        ((ba)localObject4).a(new av((an)???), dx.class);
        ((ba)localObject4).a(new at((an)???), dr.class);
        ((ba)localObject4).a(new au((an)???), dq.class);
        localObject4 = d;
        synchronized (e)
        {
          if (f)
          {
            localObject4 = n.a;
            o = c;
            p = h;
            b = f;
            c = l;
            return;
          }
          if (g != null) {
            g.start();
          }
          f = true;
        }
      }
    }
  }
  
  private void a(Throwable paramThrowable)
  {
    try
    {
      o.a(paramThrowable, Throwable.class);
      return;
    }
    catch (Exception paramThrowable)
    {
      AppboyLogger.e(f, "Failed to log throwable.", paramThrowable);
    }
  }
  
  public static void clearAppboyEndpointProvider()
  {
    synchronized (y)
    {
      z = null;
      return;
    }
  }
  
  public static boolean configure(Context paramContext, String paramString)
  {
    if (i == null) {
      for (;;)
      {
        try
        {
          if (i != null) {
            break;
          }
          if (paramString == null)
          {
            AppboyLogger.i(f, "Appboy.configure called with a null appboyApiKey; unsetting any cached override api key.");
            paramContext = l.a(paramContext);
            paramContext.remove("com_appboy_api_key");
            paramContext.apply();
            return true;
          }
          if (!paramString.equals(""))
          {
            AppboyLogger.i(f, "Appboy.configure called with an appboyApiKey; caching the api key to override the appboy.xml value when initializing Appboy.");
            paramContext = l.a(paramContext);
            paramContext.putString("com_appboy_api_key", paramString);
            paramContext.apply();
          }
          else
          {
            AppboyLogger.e(f, "Appboy.configure called with an empty string; no action will be taken.  Configure with null to clear an override api key.");
          }
        }
        finally {}
      }
    }
    AppboyLogger.e(f, "The custom Appboy API key was not set by configure since getInstance() has already been called.");
    return false;
  }
  
  public static boolean disableAllAppboyNetworkRequests()
  {
    if (i == null) {
      try
      {
        if (i == null)
        {
          if (B)
          {
            AppboyLogger.i(f, "Appboy network requests already disabled.");
            return true;
          }
          AppboyLogger.i(f, "Appboy network requests now disabled.");
          B = true;
          return true;
        }
      }
      finally {}
    }
    AppboyLogger.e(f, "Attempt to disable network requests will have no effect since getInstance() has already been called.");
    return false;
  }
  
  public static Uri getAppboyApiEndpoint(Uri paramUri)
  {
    synchronized (y)
    {
      Object localObject2 = z;
      if (localObject2 != null) {
        try
        {
          localObject2 = z.getApiEndpoint(paramUri);
          if (localObject2 != null) {
            return (Uri)localObject2;
          }
        }
        catch (Exception localException)
        {
          AppboyLogger.e(f, "Caught exception trying to get an Appboy API endpoint from the AppboyEndpointProvider.  Using the original URI");
        }
      }
      return paramUri;
    }
  }
  
  public static Uri getAppboyResourceEndpoint(Uri paramUri)
  {
    return paramUri;
  }
  
  public static IAppboyNotificationFactory getCustomAppboyNotificationFactory()
  {
    return A;
  }
  
  public static Appboy getInstance(Context paramContext)
  {
    if (i == null) {}
    try
    {
      if (i == null) {
        i = new Appboy(paramContext);
      }
      return i;
    }
    finally {}
  }
  
  public static void setAppboyEndpointProvider(IAppboyEndpointProvider paramIAppboyEndpointProvider)
  {
    synchronized (y)
    {
      z = paramIAppboyEndpointProvider;
      return;
    }
  }
  
  public static void setCustomAppboyNotificationFactory(IAppboyNotificationFactory paramIAppboyNotificationFactory)
  {
    A = paramIAppboyNotificationFactory;
  }
  
  public final AppboyUser changeUser(String paramString)
  {
    label81:
    boolean bool;
    AppboyUser localAppboyUser;
    synchronized (w)
    {
      try
      {
        if (StringUtils.isNullOrEmpty(paramString))
        {
          AppboyLogger.e(f, "ArgumentException: userId passed to changeUser was null or empty.  The current user will remain the active user.");
          localObject2 = m;
          return (AppboyUser)localObject2;
        }
        localObject2 = m.getUserId();
        if (!((String)localObject2).equals(paramString)) {
          break label81;
        }
        AppboyLogger.i(f, String.format("Received request to change current user %s to the same user id. Doing nothing.", new Object[] { paramString }));
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Object localObject2;
          AppboyLogger.w(f, "Failed to set external id to: " + paramString, localException);
          a(localException);
        }
      }
      return m;
      bool = ((String)localObject2).equals("");
      if (!bool) {
        break label480;
      }
      AppboyLogger.i(f, String.format("Changing anonymous user to %s.", new Object[] { paramString }));
      ??? = r;
      StringUtils.checkNotNullOrEmpty(paramString);
      ??? = a.edit();
      ((SharedPreferences.Editor)???).putString("default_user", paramString);
      ((SharedPreferences.Editor)???).putString("last_user", paramString);
      ((SharedPreferences.Editor)???).commit();
      localAppboyUser = m;
      synchronized (a)
      {
        if ((!b.equals("")) && (!b.equals(paramString))) {
          throw new IllegalArgumentException(String.format("setExternalId can not be used to change the external ID of a UserCache from a non-empty value to a new value. Was: [%s], tried to change to: [%s]", new Object[] { b, paramString }));
        }
      }
    }
    b = paramString;
    n.a = paramString;
    label309:
    ??? = q;
    g = null;
    b.e();
    ??? = r;
    StringUtils.checkNotNullOrEmpty(paramString);
    ??? = a.edit();
    ((SharedPreferences.Editor)???).putString("last_user", paramString);
    ((SharedPreferences.Editor)???).commit();
    ??? = a;
    a(new fo(j, r, e, l, t, s, B));
    a.b.c();
    q.a();
    if (bool) {
      q.a(dd.a(paramString));
    }
    for (;;)
    {
      q.a(ab.a);
      h.execute(new fp((fo)???));
      break;
      label480:
      AppboyLogger.i(f, String.format("Changing current user %s to new user %s.", new Object[] { localException, paramString }));
      ??? = new FeedUpdatedEvent(new ArrayList(), paramString, false, fg.a());
      l.a(???, FeedUpdatedEvent.class);
      break label309;
      q.a(dd.a(localException, paramString));
    }
  }
  
  public final boolean closeSession(Activity paramActivity)
  {
    synchronized (x)
    {
      try
      {
        by localby = q;
        if ((g != null) && (!paramActivity.getClass().equals(g))) {
          paramActivity = by.a;
        }
        for (paramActivity = null; paramActivity != null; paramActivity = b.b())
        {
          AppboyLogger.i(f, "Closed session with ID: " + d);
          return true;
        }
        return false;
      }
      catch (Exception paramActivity)
      {
        AppboyLogger.w(f, "Failed to close session.", paramActivity);
        a(paramActivity);
        return false;
      }
    }
  }
  
  public final IInAppMessage deserializeInAppMessageString(String paramString)
  {
    return fj.a(paramString, q);
  }
  
  public final void fetchAndRenderImage(String paramString, ImageView paramImageView)
  {
    fetchAndRenderImage(paramString, paramImageView, false);
  }
  
  public final void fetchAndRenderImage(String paramString, ImageView paramImageView, boolean paramBoolean)
  {
    if (k == null)
    {
      AppboyLogger.w(f, "Uil LRU memory and disc cache unavailable. Could not fetch and render image.");
      return;
    }
    paramImageView.post(new c(this, paramString, paramImageView, paramBoolean));
  }
  
  public final IAppboyNavigator getAppboyNavigator()
  {
    return C;
  }
  
  public final String getAppboyPushMessageRegistrationId()
  {
    try
    {
      String str = s.a();
      return str;
    }
    catch (Exception localException)
    {
      AppboyLogger.w(f, "Failed to get the registration ID.", localException);
      a(localException);
    }
    return null;
  }
  
  public final AppboyUser getCurrentUser()
  {
    synchronized (w)
    {
      AppboyUser localAppboyUser = m;
      return localAppboyUser;
    }
  }
  
  public final String getInstallTrackingId()
  {
    return t.b();
  }
  
  public final boolean logCustomEvent(String paramString)
  {
    synchronized (x)
    {
      boolean bool = logCustomEvent(paramString, null);
      return bool;
    }
  }
  
  /* Error */
  public final boolean logCustomEvent(String paramString, AppboyProperties paramAppboyProperties)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 463	com/appboy/Appboy:x	Ljava/lang/Object;
    //   4: astore 4
    //   6: aload 4
    //   8: monitorenter
    //   9: aload_1
    //   10: astore_3
    //   11: aload_1
    //   12: invokestatic 1314	com/appboy/support/StringUtils:isNullOrBlank	(Ljava/lang/String;)Z
    //   15: ifeq +20 -> 35
    //   18: aload_1
    //   19: astore_3
    //   20: getstatic 87	com/appboy/Appboy:f	Ljava/lang/String;
    //   23: ldc_w 1316
    //   26: invokestatic 742	com/appboy/support/AppboyLogger:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   29: pop
    //   30: aload 4
    //   32: monitorexit
    //   33: iconst_0
    //   34: ireturn
    //   35: aload_1
    //   36: astore_3
    //   37: aload_0
    //   38: getfield 916	com/appboy/Appboy:d	Lbo/app/fb;
    //   41: invokevirtual 1321	bo/app/fb:g	()Ljava/util/Set;
    //   44: aload_1
    //   45: invokeinterface 1324 2 0
    //   50: ifeq +37 -> 87
    //   53: aload_1
    //   54: astore_3
    //   55: getstatic 87	com/appboy/Appboy:f	Ljava/lang/String;
    //   58: ldc_w 1326
    //   61: iconst_1
    //   62: anewarray 4	java/lang/Object
    //   65: dup
    //   66: iconst_0
    //   67: aload_1
    //   68: aastore
    //   69: invokestatic 85	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   72: invokestatic 742	com/appboy/support/AppboyLogger:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   75: pop
    //   76: aload 4
    //   78: monitorexit
    //   79: iconst_0
    //   80: ireturn
    //   81: astore_1
    //   82: aload 4
    //   84: monitorexit
    //   85: aload_1
    //   86: athrow
    //   87: aload_1
    //   88: astore_3
    //   89: aload_1
    //   90: invokestatic 1331	com/appboy/support/ValidationUtils:ensureAppboyFieldLength	(Ljava/lang/String;)Ljava/lang/String;
    //   93: astore_1
    //   94: aload_1
    //   95: astore_3
    //   96: aload_0
    //   97: getfield 912	com/appboy/Appboy:q	Lbo/app/by;
    //   100: aload_1
    //   101: aload_2
    //   102: invokestatic 1334	bo/app/dd:a	(Ljava/lang/String;Lcom/appboy/models/outgoing/AppboyProperties;)Lbo/app/dd;
    //   105: invokevirtual 1219	bo/app/by:a	(Lbo/app/cs;)Z
    //   108: ifeq +25 -> 133
    //   111: aload_1
    //   112: astore_3
    //   113: aload_0
    //   114: getfield 1018	com/appboy/Appboy:c	Lbo/app/gt;
    //   117: new 1336	bo/app/gg
    //   120: dup
    //   121: aload_1
    //   122: invokespecial 1337	bo/app/gg:<init>	(Ljava/lang/String;)V
    //   125: invokevirtual 1342	bo/app/gt:a	(Lbo/app/gh;)V
    //   128: aload 4
    //   130: monitorexit
    //   131: iconst_1
    //   132: ireturn
    //   133: aload 4
    //   135: monitorexit
    //   136: iconst_0
    //   137: ireturn
    //   138: astore_1
    //   139: getstatic 87	com/appboy/Appboy:f	Ljava/lang/String;
    //   142: new 760	java/lang/StringBuilder
    //   145: dup
    //   146: ldc_w 1344
    //   149: invokespecial 763	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   152: aload_3
    //   153: invokevirtual 767	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: invokevirtual 770	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   159: aload_1
    //   160: invokestatic 1184	com/appboy/support/AppboyLogger:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   163: pop
    //   164: aload_0
    //   165: aload_1
    //   166: invokespecial 1186	com/appboy/Appboy:a	(Ljava/lang/Throwable;)V
    //   169: aload 4
    //   171: monitorexit
    //   172: iconst_0
    //   173: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	174	0	this	Appboy
    //   0	174	1	paramString	String
    //   0	174	2	paramAppboyProperties	AppboyProperties
    //   10	143	3	str	String
    //   4	166	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   11	18	81	finally
    //   20	30	81	finally
    //   30	33	81	finally
    //   37	53	81	finally
    //   55	76	81	finally
    //   76	79	81	finally
    //   89	94	81	finally
    //   96	111	81	finally
    //   113	128	81	finally
    //   128	131	81	finally
    //   139	172	81	finally
    //   11	18	138	java/lang/Exception
    //   20	30	138	java/lang/Exception
    //   37	53	138	java/lang/Exception
    //   55	76	138	java/lang/Exception
    //   89	94	138	java/lang/Exception
    //   96	111	138	java/lang/Exception
    //   113	128	138	java/lang/Exception
  }
  
  public final boolean logFeedCardClick(String paramString)
  {
    try
    {
      if (StringUtils.isNullOrBlank(paramString))
      {
        AppboyLogger.e(f, "Card ID cannot be null");
        return false;
      }
      boolean bool = q.a(dd.d(paramString));
      return bool;
    }
    catch (Exception paramString)
    {
      AppboyLogger.w(f, "Failed to log feed card clicked.", paramString);
      a(paramString);
    }
    return false;
  }
  
  public final boolean logFeedCardImpression(String paramString)
  {
    try
    {
      if (StringUtils.isNullOrBlank(paramString))
      {
        AppboyLogger.e(f, "Card ID cannot be null");
        return false;
      }
      boolean bool = q.a(dd.c(paramString));
      b.a(paramString);
      return bool;
    }
    catch (Exception paramString)
    {
      AppboyLogger.w(f, "Failed to log feed card impression.", paramString);
      a(paramString);
    }
    return false;
  }
  
  public final boolean logFeedDisplayed()
  {
    try
    {
      boolean bool = q.a(dd.e());
      return bool;
    }
    catch (Exception localException)
    {
      AppboyLogger.w(f, "Failed to log that the feed was displayed.", localException);
      a(localException);
    }
    return false;
  }
  
  public final boolean logFeedbackDisplayed()
  {
    try
    {
      boolean bool = q.a(dd.f());
      return bool;
    }
    catch (Exception localException)
    {
      AppboyLogger.w(f, "Failed to log that feedback was displayed.", localException);
      a(localException);
    }
    return false;
  }
  
  public final boolean logPurchase(String paramString, int paramInt)
  {
    synchronized (x)
    {
      try
      {
        boolean bool = logPurchase(paramString, "USD", fe.a(paramInt), 1, null);
        return bool;
      }
      catch (Exception localException)
      {
        AppboyLogger.w(f, "Failed to log purchase event of " + paramString, localException);
        a(localException);
        return false;
      }
    }
  }
  
  public final boolean logPurchase(String paramString1, String paramString2, BigDecimal paramBigDecimal)
  {
    return logPurchase(paramString1, paramString2, paramBigDecimal, 1);
  }
  
  public final boolean logPurchase(String paramString1, String paramString2, BigDecimal paramBigDecimal, int paramInt)
  {
    return logPurchase(paramString1, paramString2, paramBigDecimal, paramInt, null);
  }
  
  /* Error */
  public final boolean logPurchase(String paramString1, String paramString2, BigDecimal paramBigDecimal, int paramInt, AppboyProperties paramAppboyProperties)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 463	com/appboy/Appboy:x	Ljava/lang/Object;
    //   4: astore 7
    //   6: aload 7
    //   8: monitorenter
    //   9: aload_1
    //   10: astore 6
    //   12: aload_1
    //   13: invokestatic 1314	com/appboy/support/StringUtils:isNullOrBlank	(Ljava/lang/String;)Z
    //   16: ifeq +21 -> 37
    //   19: aload_1
    //   20: astore 6
    //   22: getstatic 87	com/appboy/Appboy:f	Ljava/lang/String;
    //   25: ldc_w 1388
    //   28: invokestatic 742	com/appboy/support/AppboyLogger:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   31: pop
    //   32: aload 7
    //   34: monitorexit
    //   35: iconst_0
    //   36: ireturn
    //   37: aload_1
    //   38: astore 6
    //   40: aload_0
    //   41: getfield 916	com/appboy/Appboy:d	Lbo/app/fb;
    //   44: invokevirtual 1390	bo/app/fb:i	()Ljava/util/Set;
    //   47: aload_1
    //   48: invokeinterface 1324 2 0
    //   53: ifeq +38 -> 91
    //   56: aload_1
    //   57: astore 6
    //   59: getstatic 87	com/appboy/Appboy:f	Ljava/lang/String;
    //   62: ldc_w 1392
    //   65: iconst_1
    //   66: anewarray 4	java/lang/Object
    //   69: dup
    //   70: iconst_0
    //   71: aload_1
    //   72: aastore
    //   73: invokestatic 85	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   76: invokestatic 742	com/appboy/support/AppboyLogger:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   79: pop
    //   80: aload 7
    //   82: monitorexit
    //   83: iconst_0
    //   84: ireturn
    //   85: astore_1
    //   86: aload 7
    //   88: monitorexit
    //   89: aload_1
    //   90: athrow
    //   91: aload_2
    //   92: ifnonnull +34 -> 126
    //   95: aload_1
    //   96: astore 6
    //   98: getstatic 87	com/appboy/Appboy:f	Ljava/lang/String;
    //   101: ldc_w 1394
    //   104: iconst_1
    //   105: anewarray 4	java/lang/Object
    //   108: dup
    //   109: iconst_0
    //   110: getstatic 443	com/appboy/Appboy:g	Ljava/util/Set;
    //   113: aastore
    //   114: invokestatic 85	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   117: invokestatic 742	com/appboy/support/AppboyLogger:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   120: pop
    //   121: aload 7
    //   123: monitorexit
    //   124: iconst_0
    //   125: ireturn
    //   126: aload_1
    //   127: astore 6
    //   129: aload_2
    //   130: invokevirtual 1397	java/lang/String:trim	()Ljava/lang/String;
    //   133: getstatic 1403	java/util/Locale:US	Ljava/util/Locale;
    //   136: invokevirtual 1407	java/lang/String:toUpperCase	(Ljava/util/Locale;)Ljava/lang/String;
    //   139: astore_2
    //   140: aload_1
    //   141: astore 6
    //   143: getstatic 443	com/appboy/Appboy:g	Ljava/util/Set;
    //   146: aload_2
    //   147: invokeinterface 1324 2 0
    //   152: ifne +34 -> 186
    //   155: aload_1
    //   156: astore 6
    //   158: getstatic 87	com/appboy/Appboy:f	Ljava/lang/String;
    //   161: ldc_w 1409
    //   164: iconst_1
    //   165: anewarray 4	java/lang/Object
    //   168: dup
    //   169: iconst_0
    //   170: getstatic 443	com/appboy/Appboy:g	Ljava/util/Set;
    //   173: aastore
    //   174: invokestatic 85	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   177: invokestatic 742	com/appboy/support/AppboyLogger:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   180: pop
    //   181: aload 7
    //   183: monitorexit
    //   184: iconst_0
    //   185: ireturn
    //   186: aload_3
    //   187: ifnonnull +21 -> 208
    //   190: aload_1
    //   191: astore 6
    //   193: getstatic 87	com/appboy/Appboy:f	Ljava/lang/String;
    //   196: ldc_w 1411
    //   199: invokestatic 742	com/appboy/support/AppboyLogger:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   202: pop
    //   203: aload 7
    //   205: monitorexit
    //   206: iconst_0
    //   207: ireturn
    //   208: aload_1
    //   209: astore 6
    //   211: aload_3
    //   212: getstatic 1417	java/math/BigDecimal:ZERO	Ljava/math/BigDecimal;
    //   215: invokevirtual 1421	java/math/BigDecimal:compareTo	(Ljava/math/BigDecimal;)I
    //   218: iconst_m1
    //   219: if_icmpne +21 -> 240
    //   222: aload_1
    //   223: astore 6
    //   225: getstatic 87	com/appboy/Appboy:f	Ljava/lang/String;
    //   228: ldc_w 1423
    //   231: invokestatic 742	com/appboy/support/AppboyLogger:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   234: pop
    //   235: aload 7
    //   237: monitorexit
    //   238: iconst_0
    //   239: ireturn
    //   240: iload 4
    //   242: ifgt +21 -> 263
    //   245: aload_1
    //   246: astore 6
    //   248: getstatic 87	com/appboy/Appboy:f	Ljava/lang/String;
    //   251: ldc_w 1425
    //   254: invokestatic 742	com/appboy/support/AppboyLogger:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   257: pop
    //   258: aload 7
    //   260: monitorexit
    //   261: iconst_0
    //   262: ireturn
    //   263: iload 4
    //   265: bipush 100
    //   267: if_icmple +21 -> 288
    //   270: aload_1
    //   271: astore 6
    //   273: getstatic 87	com/appboy/Appboy:f	Ljava/lang/String;
    //   276: ldc_w 1427
    //   279: invokestatic 742	com/appboy/support/AppboyLogger:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   282: pop
    //   283: aload 7
    //   285: monitorexit
    //   286: iconst_0
    //   287: ireturn
    //   288: aload_1
    //   289: astore 6
    //   291: aload_1
    //   292: invokestatic 1331	com/appboy/support/ValidationUtils:ensureAppboyFieldLength	(Ljava/lang/String;)Ljava/lang/String;
    //   295: astore_1
    //   296: aload_1
    //   297: astore 6
    //   299: aload_0
    //   300: getfield 912	com/appboy/Appboy:q	Lbo/app/by;
    //   303: aload_1
    //   304: aload_2
    //   305: aload_3
    //   306: iload 4
    //   308: aload 5
    //   310: invokestatic 1430	bo/app/dd:a	(Ljava/lang/String;Ljava/lang/String;Ljava/math/BigDecimal;ILcom/appboy/models/outgoing/AppboyProperties;)Lbo/app/dd;
    //   313: invokevirtual 1219	bo/app/by:a	(Lbo/app/cs;)Z
    //   316: ifeq +26 -> 342
    //   319: aload_1
    //   320: astore 6
    //   322: aload_0
    //   323: getfield 1018	com/appboy/Appboy:c	Lbo/app/gt;
    //   326: new 1432	bo/app/gj
    //   329: dup
    //   330: aload_1
    //   331: invokespecial 1433	bo/app/gj:<init>	(Ljava/lang/String;)V
    //   334: invokevirtual 1342	bo/app/gt:a	(Lbo/app/gh;)V
    //   337: aload 7
    //   339: monitorexit
    //   340: iconst_1
    //   341: ireturn
    //   342: aload 7
    //   344: monitorexit
    //   345: iconst_0
    //   346: ireturn
    //   347: astore_1
    //   348: getstatic 87	com/appboy/Appboy:f	Ljava/lang/String;
    //   351: new 760	java/lang/StringBuilder
    //   354: dup
    //   355: ldc_w 1382
    //   358: invokespecial 763	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   361: aload 6
    //   363: invokevirtual 767	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   366: invokevirtual 770	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   369: aload_1
    //   370: invokestatic 1184	com/appboy/support/AppboyLogger:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   373: pop
    //   374: aload_0
    //   375: aload_1
    //   376: invokespecial 1186	com/appboy/Appboy:a	(Ljava/lang/Throwable;)V
    //   379: aload 7
    //   381: monitorexit
    //   382: iconst_0
    //   383: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	384	0	this	Appboy
    //   0	384	1	paramString1	String
    //   0	384	2	paramString2	String
    //   0	384	3	paramBigDecimal	BigDecimal
    //   0	384	4	paramInt	int
    //   0	384	5	paramAppboyProperties	AppboyProperties
    //   10	352	6	str	String
    //   4	376	7	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   12	19	85	finally
    //   22	32	85	finally
    //   32	35	85	finally
    //   40	56	85	finally
    //   59	80	85	finally
    //   80	83	85	finally
    //   98	121	85	finally
    //   121	124	85	finally
    //   129	140	85	finally
    //   143	155	85	finally
    //   158	181	85	finally
    //   181	184	85	finally
    //   193	203	85	finally
    //   203	206	85	finally
    //   211	222	85	finally
    //   225	235	85	finally
    //   235	238	85	finally
    //   248	258	85	finally
    //   258	261	85	finally
    //   273	283	85	finally
    //   283	286	85	finally
    //   291	296	85	finally
    //   299	319	85	finally
    //   322	337	85	finally
    //   337	340	85	finally
    //   348	382	85	finally
    //   12	19	347	java/lang/Exception
    //   22	32	347	java/lang/Exception
    //   40	56	347	java/lang/Exception
    //   59	80	347	java/lang/Exception
    //   98	121	347	java/lang/Exception
    //   129	140	347	java/lang/Exception
    //   143	155	347	java/lang/Exception
    //   158	181	347	java/lang/Exception
    //   193	203	347	java/lang/Exception
    //   211	222	347	java/lang/Exception
    //   225	235	347	java/lang/Exception
    //   248	258	347	java/lang/Exception
    //   273	283	347	java/lang/Exception
    //   291	296	347	java/lang/Exception
    //   299	319	347	java/lang/Exception
    //   322	337	347	java/lang/Exception
  }
  
  public final boolean logPurchase(String paramString1, String paramString2, BigDecimal paramBigDecimal, AppboyProperties paramAppboyProperties)
  {
    return logPurchase(paramString1, paramString2, paramBigDecimal, 1, paramAppboyProperties);
  }
  
  public final boolean logPushNotificationActionClicked(String paramString1, String paramString2)
  {
    try
    {
      if (StringUtils.isNullOrBlank(paramString1))
      {
        AppboyLogger.w(f, "Campaign ID cannot be null or blank");
        return false;
      }
      if (StringUtils.isNullOrBlank(paramString2))
      {
        AppboyLogger.w(f, "Action ID cannot be null or blank");
        return false;
      }
    }
    catch (Exception paramString1)
    {
      AppboyLogger.w(f, "Failed to log push notification action clicked.", paramString1);
      a(paramString1);
      return false;
    }
    boolean bool = q.a(dd.b(paramString1, paramString2));
    return bool;
  }
  
  public final boolean logPushNotificationOpened(Intent paramIntent)
  {
    boolean bool;
    for (;;)
    {
      try
      {
        String str = paramIntent.getStringExtra("cid");
        if (!StringUtils.isNullOrBlank(str))
        {
          AppboyLogger.i(f, String.format("Logging push click to Appboy. Campaign Id: " + str, new Object[0]));
          bool = logPushNotificationOpened(str);
        }
      }
      catch (Exception paramIntent)
      {
        bool = false;
      }
      try
      {
        if ((paramIntent.hasExtra("ab_push_fetch_test_triggers_key")) && (paramIntent.getStringExtra("ab_push_fetch_test_triggers_key").equals("true")))
        {
          AppboyLogger.i(f, "Push contained key for fetching test triggers, fetching triggers.");
          q.a(ab.d);
        }
        return bool;
      }
      catch (Exception paramIntent)
      {
        for (;;) {}
      }
      AppboyLogger.i(f, String.format("No campaign Id associated with this notification. Not logging push click to Appboy.", new Object[0]));
      bool = false;
    }
    AppboyLogger.w(f, "Error logging push notification", paramIntent);
    return bool;
  }
  
  public final boolean logPushNotificationOpened(String paramString)
  {
    try
    {
      if (StringUtils.isNullOrBlank(paramString))
      {
        AppboyLogger.w(f, "Campaign ID cannot be null or blank");
        return false;
      }
      boolean bool = q.a(dd.b(paramString));
      return bool;
    }
    catch (Exception paramString)
    {
      AppboyLogger.w(f, "Failed to log opened push.", paramString);
      a(paramString);
    }
    return false;
  }
  
  public final boolean logShare(SocialNetwork paramSocialNetwork)
  {
    return false;
  }
  
  public final boolean openSession(Activity paramActivity)
  {
    boolean bool1 = false;
    synchronized (x)
    {
      try
      {
        db localdb = q.b.c();
        by localby = q;
        cx localcx = localby.a();
        g = paramActivity.getClass();
        boolean bool2 = d.equals(localdb);
        if (!bool2) {
          bool1 = true;
        }
        return bool1;
      }
      catch (Exception paramActivity)
      {
        AppboyLogger.w(f, "Failed to open session.", paramActivity);
        a(paramActivity);
        return false;
      }
    }
  }
  
  public final void registerAppboyGcmMessages(String paramString)
  {
    registerAppboyPushMessages(paramString);
  }
  
  public final void registerAppboyPushMessages(String paramString)
  {
    try
    {
      if (StringUtils.isNullOrBlank(paramString))
      {
        AppboyLogger.w(f, "Push registration ID must not be null or blank. Not registering for push messages from Appboy.");
        return;
      }
      s.a(paramString);
      return;
    }
    catch (Exception paramString)
    {
      AppboyLogger.w(f, "Failed to set the registration ID.", paramString);
      a(paramString);
    }
  }
  
  public final <T> void removeSingleSubscription(IEventSubscriber<T> paramIEventSubscriber, Class<T> paramClass)
  {
    try
    {
      l.b(paramIEventSubscriber, paramClass);
      return;
    }
    catch (Exception paramIEventSubscriber)
    {
      AppboyLogger.w(f, "Failed to remove " + paramClass.getName() + " subscriber.", paramIEventSubscriber);
      a(paramIEventSubscriber);
    }
  }
  
  public final void requestFeedRefresh()
  {
    synchronized (x)
    {
      try
      {
        q.a(ab.a);
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          AppboyLogger.w(f, "Failed to request refresh of feed.", localException);
          a(localException);
        }
      }
    }
  }
  
  public final void requestFeedRefreshFromCache()
  {
    p.execute(new b(this));
  }
  
  public final void requestImmediateDataFlush()
  {
    synchronized (x)
    {
      try
      {
        q.a(ab.e);
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          AppboyLogger.w(f, "Failed to request data flush.", localException);
          a(localException);
        }
      }
    }
  }
  
  public final void requestInAppMessageRefresh()
  {
    synchronized (x)
    {
      try
      {
        q.a(ab.b);
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          AppboyLogger.w(f, "Failed to request in-app message refresh.", localException);
          a(localException);
        }
      }
    }
  }
  
  public final void setAppboyNavigator(IAppboyNavigator paramIAppboyNavigator)
  {
    C = paramIAppboyNavigator;
  }
  
  public final boolean submitFeedback(String paramString1, String paramString2, boolean paramBoolean)
  {
    by localby;
    synchronized (x)
    {
      try
      {
        localby = q;
        if ((paramString1 == null) || (!ValidationUtils.isValidEmailAddress(paramString1))) {
          throw new IllegalArgumentException("Reply to email address is invalid");
        }
      }
      catch (Exception paramString1)
      {
        AppboyLogger.w(f, "Failed to submit feedback: " + paramString2, paramString1);
        a(paramString1);
        return false;
      }
      if (StringUtils.isNullOrBlank(paramString2)) {
        throw new IllegalArgumentException("Feedback message cannot be null or blank");
      }
    }
    paramString1 = new Feedback(paramString2, paramString1, paramBoolean, d.d(), d.b());
    c.a(new ed(e.getBaseUrlForRequests(), paramString1));
    return true;
  }
  
  public final void subscribeToFeedUpdates(IEventSubscriber<FeedUpdatedEvent> paramIEventSubscriber)
  {
    try
    {
      l.a(paramIEventSubscriber, FeedUpdatedEvent.class);
      return;
    }
    catch (Exception paramIEventSubscriber)
    {
      AppboyLogger.w(f, "Failed to add subscriber for feed updates.", paramIEventSubscriber);
      a(paramIEventSubscriber);
    }
  }
  
  public final void subscribeToFeedbackRequestEvents(IEventSubscriber<SubmitFeedbackSucceeded> paramIEventSubscriber, IEventSubscriber<SubmitFeedbackFailed> paramIEventSubscriber1)
  {
    if (paramIEventSubscriber != null) {}
    try
    {
      l.a(paramIEventSubscriber, SubmitFeedbackSucceeded.class);
      if (paramIEventSubscriber1 != null) {
        l.a(paramIEventSubscriber1, SubmitFeedbackFailed.class);
      }
      return;
    }
    catch (Exception paramIEventSubscriber)
    {
      AppboyLogger.w(f, "Failed to add subscribers for feedback request events.", paramIEventSubscriber);
      a(paramIEventSubscriber);
    }
  }
  
  public final void subscribeToNewInAppMessages(IEventSubscriber<InAppMessageEvent> paramIEventSubscriber)
  {
    try
    {
      l.a(paramIEventSubscriber, InAppMessageEvent.class);
      return;
    }
    catch (Exception paramIEventSubscriber)
    {
      AppboyLogger.w(f, "Failed to add subscriber to new in-app messages.", paramIEventSubscriber);
      a(paramIEventSubscriber);
    }
  }
  
  public final void unregisterAppboyPushMessages()
  {
    try
    {
      s.b();
      return;
    }
    catch (Exception localException)
    {
      AppboyLogger.w(f, "Failed to unset the registration ID.", localException);
      a(localException);
    }
  }
}

/* Location:
 * Qualified Name:     com.appboy.Appboy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */