package bo.app;

import android.app.AlarmManager;
import android.content.Context;
import com.appboy.Constants;
import com.appboy.configuration.XmlAppConfigurationProvider;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class fo
{
  private static final String n = String.format("%s.%s", new Object[] { Constants.APPBOY_LOG_TAG_PREFIX, fo.class.getName() });
  private static final int o;
  private static final int p;
  private static final int q = o * 4;
  public final fd a;
  public final ev b;
  public final ba c;
  public final n d;
  public final by e;
  public final ex f;
  public final an g;
  public final ThreadPoolExecutor h;
  public final ez i;
  public final f j;
  public final cl k;
  public final gt l;
  public final fb m;
  private final w r;
  private final fa s;
  private final r t;
  private final cb u;
  private final ci<dm> v;
  
  static
  {
    int i1 = Runtime.getRuntime().availableProcessors();
    o = i1;
    p = i1 * 2;
  }
  
  public fo(Context paramContext, l paraml, XmlAppConfigurationProvider paramXmlAppConfigurationProvider, bd parambd, bv parambv, cm paramcm, boolean paramBoolean)
  {
    String str = paraml.a();
    br localbr = new br();
    h = new ThreadPoolExecutor(p, q, 1L, TimeUnit.SECONDS, new LinkedBlockingQueue(64), localbr);
    c = new ba(h);
    m = new fb(paramContext, paramXmlAppConfigurationProvider.getAppboyApiKey().toString(), c);
    if (str.equals(""))
    {
      a = new fd(paramContext, m);
      b = new ev(paramContext);
    }
    for (paraml = eo.a(paramContext, null);; paraml = eo.a(paramContext, str))
    {
      v = new cd(paramContext);
      v.b();
      parambv = new ce(paramContext, paramXmlAppConfigurationProvider, str, parambv, paramcm, b, m, v, c);
      j = new f(paramXmlAppConfigurationProvider, parambv);
      j.a = str;
      r = new w(a, parambv);
      paramcm = new bt(localbr);
      a = new bs(c);
      s = new fa(paraml);
      paraml = new ep(s, paramcm);
      i = new ew(paraml, c);
      Object localObject = (AlarmManager)paramContext.getSystemService("alarm");
      u = new cb(i, c, paramContext, (AlarmManager)localObject, paramXmlAppConfigurationProvider.getSessionTimeoutSeconds(), m);
      f = new ex(paramContext, str);
      paramcm = new el(j, new j(new k(new g())), c, parambd, h, f, m);
      t = new r(paramContext, c, new p(), (AlarmManager)localObject, new q(paramContext));
      localObject = t;
      ba localba = c;
      localba.a(new t((r)localObject), bm.class);
      localba.a(new u((r)localObject), bn.class);
      t.a();
      d = new n(paramXmlAppConfigurationProvider, c, paramcm, r, localbr, paramBoolean);
      e = new by(u, d, c, parambv, paramXmlAppConfigurationProvider, paramContext, paramcm);
      l = new gt(paramContext, e, h, parambd, paramXmlAppConfigurationProvider, str, paramXmlAppConfigurationProvider.getAppboyApiKey().toString());
      if (!paramBoolean) {
        a = e;
      }
      f.e = e;
      r.b = e;
      k = new bw(paramContext, e, paramXmlAppConfigurationProvider, m);
      paramXmlAppConfigurationProvider = new ds(paramContext, paramXmlAppConfigurationProvider.getAppboyApiKey().toString(), e);
      g = new an(k, paraml, d, u, e, paramContext, a, b, m, l, paramXmlAppConfigurationProvider);
      return;
      a = new fd(paramContext, str, paramXmlAppConfigurationProvider.getAppboyApiKey().toString(), m);
      b = new ev(paramContext, str, paramXmlAppConfigurationProvider.getAppboyApiKey().toString());
    }
  }
}

/* Location:
 * Qualified Name:     bo.app.fo
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */