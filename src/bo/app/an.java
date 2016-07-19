package bo.app;

import android.content.Context;
import android.content.Intent;
import com.appboy.Constants;
import java.util.concurrent.atomic.AtomicBoolean;

public class an
{
  private static final String a = String.format("%s.%s", new Object[] { Constants.APPBOY_LOG_TAG_PREFIX, an.class.getName() });
  private final cl b;
  private final ep c;
  private final y d;
  private final cb e;
  private final ch f;
  private final Context g;
  private final fd h;
  private final Intent i;
  private final ev j;
  private final fb k;
  private final go l;
  private final ds m;
  private AtomicBoolean n = new AtomicBoolean(false);
  
  public an(cl paramcl, ep paramep, y paramy, cb paramcb, by paramby, Context paramContext, fd paramfd, ev paramev, fb paramfb, go paramgo, ds paramds)
  {
    b = paramcl;
    c = paramep;
    d = paramy;
    e = paramcb;
    f = paramby;
    g = paramContext;
    h = paramfd;
    i = new Intent(paramContext.getPackageName() + ".intent.APPBOY_DISPATCH_ALARM_EXPIRED");
    j = paramev;
    k = paramfb;
    l = paramgo;
    m = paramds;
  }
}

/* Location:
 * Qualified Name:     bo.app.an
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */