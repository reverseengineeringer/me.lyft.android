package bo.app;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.SystemClock;
import com.appboy.Constants;
import com.appboy.support.AppboyLogger;
import java.util.HashSet;

public final class cb
{
  private static final String a = String.format("%s.%s", new Object[] { Constants.APPBOY_LOG_TAG_PREFIX, cb.class.getName() });
  private final Object b = new Object();
  private final ez c;
  private final bd d;
  private final Context e;
  private final AlarmManager f;
  private final int g;
  private final String h;
  private final fb i;
  private volatile cx j;
  private volatile boolean k = false;
  
  public cb(ez paramez, bd parambd, Context paramContext, AlarmManager paramAlarmManager, int paramInt, fb paramfb)
  {
    c = paramez;
    d = parambd;
    e = paramContext;
    f = paramAlarmManager;
    g = paramInt;
    i = paramfb;
    paramez = new cc(this);
    h = (paramContext.getPackageName() + ".intent.APPBOY_SESSION_SHOULD_SEAL");
    paramContext.registerReceiver(paramez, new IntentFilter(h));
  }
  
  private boolean g()
  {
    synchronized (b)
    {
      h();
      if ((j == null) || (j.c()))
      {
        cx localcx = j;
        Object localObject3 = new cx(db.a(), fg.b());
        i.a(true);
        d.a(bk.a, bk.class);
        AppboyLogger.i(a, "New session created with ID: " + d);
        j = ((cx)localObject3);
        if ((localcx != null) && (localcx.g()))
        {
          localObject3 = a;
          String.format("Clearing completely dispatched sealed session %s", new Object[] { d });
          c.b(localcx);
        }
        return true;
      }
      if (j.a() != null)
      {
        j.a(null);
        return true;
      }
    }
    return false;
  }
  
  private void h()
  {
    synchronized (b)
    {
      if ((j == null) && (!k))
      {
        j = c.a();
        if (j != null)
        {
          String str = a;
          String.format("Restored session from offline storage: %s", new Object[] { j.d.toString() });
        }
      }
      k = true;
      if ((j != null) && (j.a() != null) && (!j.c()) && ((j.a().doubleValue() + g) * 1000.0D <= fg.c()))
      {
        AppboyLogger.i(a, String.format("Session [%s] being sealed because its end time is over the grace period.", new Object[] { j.d }));
        e();
      }
      return;
    }
  }
  
  public final cx a()
  {
    synchronized (b)
    {
      if (g()) {
        c.a(j);
      }
      Object localObject2 = new Intent(h);
      ((Intent)localObject2).putExtra("session_id", j.toString());
      localObject2 = PendingIntent.getBroadcast(e, 0, (Intent)localObject2, 1073741824);
      f.cancel((PendingIntent)localObject2);
      d.a(bm.a, bm.class);
      localObject2 = j;
      return (cx)localObject2;
    }
  }
  
  public final cx a(cs paramcs)
  {
    synchronized (b)
    {
      h();
      if (j != null)
      {
        j.a(paramcs);
        c.a(j, paramcs);
        paramcs = j;
        return paramcs;
      }
    }
    synchronized (ae)
    {
      if (ab)
      {
        localObject3 = ac;
        if (localObject3 != null)
        {
          ((cx)localObject3).a(paramcs);
          c.a((cx)localObject3, paramcs);
          return (cx)localObject3;
          paramcs = finally;
          throw paramcs;
        }
        AppboyLogger.w(a, "Could not access a stored session.  Dropping event");
        return null;
      }
      bz localbz = bz.a();
      Object localObject3 = e;
      if (paramcs != null) {}
      try
      {
        AppboyLogger.i(bz.a, "Queued event because no session exists.");
        d.add(paramcs);
        return null;
      }
      finally {}
    }
  }
  
  public final cx b()
  {
    synchronized (b)
    {
      g();
      j.a(Double.valueOf(fg.b()));
      c.a(j);
      Object localObject2 = new Intent(h);
      ((Intent)localObject2).putExtra("session_id", j.toString());
      localObject2 = PendingIntent.getBroadcast(e, 0, (Intent)localObject2, 1073741824);
      f.set(2, SystemClock.elapsedRealtime() + g * 1000, (PendingIntent)localObject2);
      d.a(bn.a, bn.class);
      localObject2 = j;
      return (cx)localObject2;
    }
  }
  
  public final db c()
  {
    synchronized (b)
    {
      h();
      if (j == null) {
        return null;
      }
      db localdb = j.d;
      return localdb;
    }
  }
  
  public final boolean d()
  {
    synchronized (b)
    {
      if (j == null) {
        return false;
      }
      boolean bool = j.c();
      return bool;
    }
  }
  
  public final void e()
  {
    synchronized (b)
    {
      cx localcx;
      if (j != null) {
        localcx = j;
      }
      synchronized (i)
      {
        h = true;
        localcx.a(Double.valueOf(fg.b()));
        c.a(j);
        d.a(new bl(j), bl.class);
        return;
      }
    }
  }
}

/* Location:
 * Qualified Name:     bo.app.cb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */