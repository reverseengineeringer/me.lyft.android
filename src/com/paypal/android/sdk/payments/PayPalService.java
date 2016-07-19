package com.paypal.android.sdk.payments;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;
import com.paypal.android.sdk.aY;
import com.paypal.android.sdk.aq;
import com.paypal.android.sdk.ar;
import com.paypal.android.sdk.au;
import com.paypal.android.sdk.av;
import com.paypal.android.sdk.b;
import com.paypal.android.sdk.bE;
import com.paypal.android.sdk.bG;
import com.paypal.android.sdk.bH;
import com.paypal.android.sdk.bK;
import com.paypal.android.sdk.bM;
import com.paypal.android.sdk.bX;
import com.paypal.android.sdk.bc;
import com.paypal.android.sdk.be;
import com.paypal.android.sdk.bg;
import com.paypal.android.sdk.bl;
import com.paypal.android.sdk.bn;
import com.paypal.android.sdk.bo;
import com.paypal.android.sdk.bp;
import com.paypal.android.sdk.bq;
import com.paypal.android.sdk.bu;
import com.paypal.android.sdk.bx;
import com.paypal.android.sdk.bz;
import com.paypal.android.sdk.c;
import com.paypal.android.sdk.cB;
import com.paypal.android.sdk.ca;
import com.paypal.android.sdk.cb;
import com.paypal.android.sdk.cc;
import com.paypal.android.sdk.cd;
import com.paypal.android.sdk.ce;
import com.paypal.android.sdk.ci;
import com.paypal.android.sdk.cj;
import com.paypal.android.sdk.cl;
import com.paypal.android.sdk.cp;
import com.paypal.android.sdk.cq;
import com.paypal.android.sdk.h;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class PayPalService
  extends Service
{
  public static final String EXTRA_PAYPAL_CONFIGURATION = "com.paypal.android.sdk.paypalConfiguration";
  private static final String b = PayPalService.class.getSimpleName();
  private static Intent s;
  bu a;
  private c c;
  private bn d;
  private PayPalConfiguration e;
  private boolean f;
  private a g = new a();
  private a h = new a();
  private k i = new d(this);
  private String j;
  private ar k;
  private aA l;
  private b m;
  private h n;
  private bp o;
  private List p = new ArrayList();
  private boolean q = true;
  private boolean r = true;
  private final BroadcastReceiver t = new aw(this);
  private final IBinder u = new az(this);
  
  private void A()
  {
    a(new bq());
  }
  
  private static aq a(String paramString1, String paramString2)
  {
    aq localaq = new aq();
    localaq.a(paramString1);
    localaq.b(paramString2);
    localaq.a(new HashMap());
    if (paramString2 != null)
    {
      if (!paramString2.startsWith("https://")) {
        throw new RuntimeException(paramString2 + " does not start with 'https://', ignoring " + paramString1);
      }
      paramString1 = paramString2;
      if (!paramString2.endsWith("/"))
      {
        Log.w(b, paramString2 + " does not end with a slash, adding one.");
        paramString1 = paramString2 + "/";
      }
      paramString2 = bl.d().iterator();
      while (paramString2.hasNext())
      {
        be localbe = (be)paramString2.next();
        localaq.c().put(localbe.a(), paramString1 + localbe.c());
      }
    }
    return localaq;
  }
  
  private void a(Intent paramIntent)
  {
    s = paramIntent;
    new StringBuilder("init:").append(b(paramIntent));
    if (e == null)
    {
      e = ((PayPalConfiguration)paramIntent.getParcelableExtra("com.paypal.android.sdk.paypalConfiguration"));
      if (e == null) {
        throw new RuntimeException("Missing EXTRA_PAYPAL_CONFIGURATION. To avoid this error, set EXTRA_PAYPAL_CONFIGURATION in both PayPalService, and the initializing activity.");
      }
    }
    if (!e.n()) {
      throw new RuntimeException("Service extras invalid.  Please check the docs.");
    }
    String str = e.b();
    Object localObject;
    int i1;
    label168:
    boolean bool1;
    label192:
    int i2;
    if (str.equals("live"))
    {
      localObject = "https://api-m.paypal.com/v1/";
      o = new bp(m, e.b(), n);
      localObject = a(str, (String)localObject);
      if (k == null)
      {
        if ((!w()) || (!paramIntent.hasExtra("com.paypal.android.sdk.mockNetworkDelay"))) {
          break label582;
        }
        i1 = paramIntent.getIntExtra("com.paypal.android.sdk.mockNetworkDelay", 500);
        if ((!w()) || (!paramIntent.hasExtra("com.paypal.android.sdk.mockEnable2fa"))) {
          break label589;
        }
        bool1 = paramIntent.getBooleanExtra("com.paypal.android.sdk.mockEnable2fa", false);
        if ((!w()) || (!paramIntent.hasExtra("com.paypal.android.sdk.mock2faPhoneNumberCount"))) {
          break label595;
        }
        i2 = paramIntent.getIntExtra("com.paypal.android.sdk.mock2faPhoneNumberCount", 1);
        label217:
        q = true;
        if ((w()) && (paramIntent.hasExtra("com.paypal.android.sdk.enableAuthenticator"))) {
          q = paramIntent.getBooleanExtra("com.paypal.android.sdk.enableAuthenticator", true);
        }
        if ((w()) && (paramIntent.hasExtra("com.paypal.android.sdk.enableAuthenticatorSecurity"))) {
          r = paramIntent.getBooleanExtra("com.paypal.android.sdk.enableAuthenticatorSecurity", true);
        }
        if ((!w()) || (!paramIntent.hasExtra("com.paypal.android.sdk.enableStageSsl"))) {
          break label600;
        }
      }
    }
    label582:
    label589:
    label595:
    label600:
    for (boolean bool2 = paramIntent.getBooleanExtra("com.paypal.android.sdk.enableStageSsl", true);; bool2 = true)
    {
      k = new ar(m, (aq)localObject, b());
      k.a(new bG(new aC(this, (byte)0)));
      paramIntent = new cl(k, i1, bool1, i2);
      localObject = new aY(m, e.b(), b(), k, 90000, b().b(), av.a(b()), bool2);
      paramIntent = new bc(e.b(), k, paramIntent, (aY)localObject);
      k.a(paramIntent);
      cq.b(e.a());
      if (d == null) {
        d = y();
      }
      if (!e.i()) {
        clearAllUserData(m.f());
      }
      z();
      return;
      if (str.startsWith("sandbox"))
      {
        localObject = "https://api-m.sandbox.paypal.com/v1/";
        break;
      }
      if (str.equals("mock"))
      {
        localObject = null;
        break;
      }
      if ((w()) && (paramIntent.hasExtra("com.paypal.android.sdk.baseEnvironmentUrl")))
      {
        localObject = paramIntent.getStringExtra("com.paypal.android.sdk.baseEnvironmentUrl");
        break;
      }
      throw new RuntimeException("Invalid environment selected:" + str);
      i1 = 500;
      break label168;
      bool1 = false;
      break label192;
      i2 = 1;
      break label217;
    }
  }
  
  private void a(bg parambg)
  {
    k.b(parambg);
  }
  
  private void a(bq parambq)
  {
    o.a(parambq);
  }
  
  private void a(cp paramcp, boolean paramBoolean, String paramString1, String paramString2, String paramString3)
  {
    i.a(paramcp, paramBoolean, paramString1, paramString2, paramString3);
  }
  
  private aB b(bg parambg)
  {
    return new aB(this, parambg.q().b(), parambg.s(), parambg.q().a());
  }
  
  private static String b(Intent paramIntent)
  {
    if (paramIntent == null) {
      return "Intent = null";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Intent{");
    localStringBuilder.append("action:" + paramIntent.getAction());
    localStringBuilder.append(", cmp:" + paramIntent.getComponent() + ", ");
    if (paramIntent.getExtras() == null) {
      localStringBuilder.append("null extras");
    }
    for (;;)
    {
      localStringBuilder.append("}");
      return localStringBuilder.toString();
      localStringBuilder.append("extras:");
      Iterator localIterator = paramIntent.getExtras().keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localStringBuilder.append("(" + str + ":" + paramIntent.getExtras().get(str) + ")");
      }
    }
  }
  
  private void b(cp paramcp, String paramString1, String paramString2)
  {
    a(paramcp, false, paramString1, paramString2, null);
  }
  
  public static void clearAllUserData(Context paramContext)
  {
    Intent localIntent = new Intent("com.paypal.android.sdk.clearAllUserData");
    try
    {
      LocalBroadcastManager.getInstance(paramContext).sendBroadcast(localIntent);
      return;
    }
    catch (Throwable paramContext)
    {
      new StringBuilder("ignoring:").append(paramContext.getMessage());
    }
  }
  
  private static boolean w()
  {
    return true;
  }
  
  private boolean x()
  {
    return (e != null) && (d != null);
  }
  
  private static bn y()
  {
    return new bn();
  }
  
  private void z()
  {
    a(new ax(this), false);
  }
  
  protected final String a()
  {
    return k.e();
  }
  
  final void a(int paramInt)
  {
    k.b(new cd(k, b(), k.c(), e.j(), d.j, (String)new ArrayList(d.g.a.keySet()).get(paramInt)));
  }
  
  final void a(bM parambM, String paramString1, boolean paramBoolean1, String paramString2, boolean paramBoolean2, String paramString3)
  {
    k.b(new ce(k, b(), k.c(), e.j(), parambM, paramString1, d.j, paramBoolean1, paramString2, paramBoolean2, paramString3));
  }
  
  final void a(bM parambM, boolean paramBoolean1, String paramString1, boolean paramBoolean2, String paramString2)
  {
    k.b(new ce(k, b(), k.c(), e.j(), parambM, paramBoolean1, paramString1, paramBoolean2, paramString2));
  }
  
  final void a(cp paramcp)
  {
    a(paramcp, false, null, null, null);
  }
  
  final void a(cp paramcp, Boolean paramBoolean)
  {
    a(paramcp, paramBoolean.booleanValue(), null, null, null);
  }
  
  final void a(cp paramcp, Boolean paramBoolean, String paramString)
  {
    a(paramcp, paramBoolean.booleanValue(), null, paramString, null);
  }
  
  final void a(cp paramcp, String paramString)
  {
    a(paramcp, false, null, paramString, null);
  }
  
  final void a(cp paramcp, String paramString1, String paramString2)
  {
    a(paramcp, false, null, paramString1, paramString2);
  }
  
  final void a(aA paramaA, boolean paramBoolean)
  {
    if (paramBoolean) {
      d.c = null;
    }
    l = paramaA;
    if (f) {}
    while (d.a()) {
      return;
    }
    f = true;
    a(cp.b);
    k.b(new ci(e.b(), k, b(), e.j()));
  }
  
  final void a(ay paramay)
  {
    g.a(paramay);
  }
  
  final void a(List paramList)
  {
    k.b(new bX(k, b(), k.c(), e.j(), d.f.b(), d.j, paramList));
  }
  
  protected final boolean a(aD paramaD)
  {
    if (x()) {
      return true;
    }
    p.add(paramaD);
    return false;
  }
  
  final c b()
  {
    if (c == null) {
      c = new l();
    }
    return c;
  }
  
  final void b(ay paramay)
  {
    h.a(paramay);
  }
  
  protected final ar c()
  {
    return k;
  }
  
  protected final bn d()
  {
    return d;
  }
  
  public final void doDeleteTokenizedCreditCard(String paramString1, String paramString2)
  {
    a(new ca(k, b(), paramString1, paramString2));
  }
  
  public final void doTrackingRequest(au paramau, String paramString)
  {
    if (e)
    {
      a(new cj(k, b(), paramau));
      return;
    }
    a(new cb(k, b(), paramau, paramString));
  }
  
  final PayPalConfiguration e()
  {
    return e;
  }
  
  protected final String f()
  {
    return e.b();
  }
  
  protected final String g()
  {
    return e.j();
  }
  
  final void h()
  {
    q();
    i();
    A();
  }
  
  final void i()
  {
    d.h = null;
    bo.a(e.b());
    d.e = null;
    d.d = null;
  }
  
  final boolean j()
  {
    return d.a();
  }
  
  final boolean k()
  {
    bn localbn = d;
    return (h != null) && (h.b());
  }
  
  final boolean l()
  {
    return d.f != null;
  }
  
  final void m()
  {
    h.b();
  }
  
  final void n()
  {
    g.b();
  }
  
  final void o()
  {
    l = null;
  }
  
  public final IBinder onBind(Intent paramIntent)
  {
    new StringBuilder("onBind(").append(b(paramIntent)).append(")");
    if (!x())
    {
      if (s != null) {
        break label47;
      }
      a(paramIntent);
    }
    for (;;)
    {
      return u;
      label47:
      a(s);
    }
  }
  
  public final void onCreate()
  {
    Log.w("paypal.sdk", PayPalService.class.getSimpleName() + " created. " + b().b());
    new l();
    m = new b(this, "AndroidBasePrefs");
    bH.a(m);
    bK.a(m);
    n = new h(bK.b(m) + bH.b());
    com.paypal.android.sdk.d.a(this, m, "2.9.0");
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("com.paypal.android.sdk.clearAllUserData");
    try
    {
      LocalBroadcastManager.getInstance(this).registerReceiver(t, localIntentFilter);
      return;
    }
    catch (Throwable localThrowable)
    {
      new StringBuilder("ignoring:").append(localThrowable.getMessage());
    }
  }
  
  public final void onDestroy()
  {
    if (k != null)
    {
      k.a();
      k.b();
      k = null;
    }
    try
    {
      LocalBroadcastManager.getInstance(this).unregisterReceiver(t);
      new StringBuilder("service destroyed: ").append(this);
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        new StringBuilder("ignoring:").append(localThrowable.getMessage());
      }
    }
  }
  
  public final void onRebind(Intent paramIntent)
  {
    super.onRebind(paramIntent);
    new StringBuilder("onRebind(").append(b(paramIntent)).append(")");
  }
  
  public final int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    new StringBuilder("onStartCommand(").append(b(paramIntent)).append(", ").append(paramInt1).append(", ").append(paramInt2).append(")");
    new cB(this).a();
    if ((paramIntent == null) || (paramIntent.getExtras() == null)) {
      throw new RuntimeException("Service extras required. Please see the docs.");
    }
    if (!x()) {
      a(paramIntent);
    }
    j = paramIntent.getComponent().getPackageName();
    a(cp.a);
    if (p.size() > 0)
    {
      paramIntent = p.iterator();
      while (paramIntent.hasNext()) {
        ((aD)paramIntent.next()).a();
      }
      p.clear();
    }
    return 3;
  }
  
  public final boolean onUnbind(Intent paramIntent)
  {
    new StringBuilder("onUnbind(").append(b(paramIntent)).append(")");
    return true;
  }
  
  final void p()
  {
    k.b(new cc(k, b(), k.c(), d.c.a(), e.j()));
  }
  
  final void q()
  {
    a = o.a(e.j());
    o.a(new bu(), null);
    if ((a != null) && (d.c != null))
    {
      doDeleteTokenizedCreditCard(d.c.a(), a.e());
      a = null;
    }
  }
  
  final void r()
  {
    if ((e != null) && (e.n()))
    {
      d = y();
      z();
    }
  }
  
  protected final String s()
  {
    return j;
  }
  
  final boolean t()
  {
    return q;
  }
  
  final boolean u()
  {
    return r;
  }
}

/* Location:
 * Qualified Name:     com.paypal.android.sdk.payments.PayPalService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */