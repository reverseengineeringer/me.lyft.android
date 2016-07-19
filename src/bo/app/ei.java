package bo.app;

import com.appboy.Constants;
import com.appboy.enums.ErrorType;
import com.appboy.models.ResponseError;
import com.appboy.support.AppboyLogger;
import java.net.URI;
import java.util.Map;

public final class ei
  implements Runnable
{
  private static final String a = String.format("%s.%s", new Object[] { Constants.APPBOY_LOG_TAG_PREFIX, ei.class.getName() });
  private final du b;
  private final bd c;
  private final bd d;
  private final Map<String, String> e;
  private final h f;
  
  public ei(du paramdu, i parami, h paramh, bd parambd1, bd parambd2)
  {
    b = paramdu;
    c = parambd1;
    d = parambd2;
    e = parami.a();
    f = paramh;
  }
  
  public final void run()
  {
    for (;;)
    {
      try
      {
        localObject1 = fi.a(b.b());
        Object localObject3 = ej.a;
        du localdu = b;
        switch (localObject3[af.a.ordinal()])
        {
        case 1: 
          localObject1 = a;
          localObject3 = b;
          AppboyLogger.w((String)localObject1, String.format("Received a PlaceIQ request with an unknown Http verb: [%s]", new Object[] { af.a }));
          localObject1 = null;
          if (localObject1 == null) {
            break label209;
          }
          localObject3 = b;
          localObject3 = d;
          c.a(new dr(b, (dw)localObject1), dr.class);
          localObject1 = b;
          localObject1 = c;
          return;
        }
      }
      catch (Exception localException)
      {
        Object localObject1;
        AppboyLogger.w(a, "Experienced exception processing request response. Failing task.", localException);
        Object localObject2 = b;
        localObject2 = d;
        new ResponseError(ErrorType.UNRECOGNIZED_ERROR, "An error occurred during request processing, resulting in no valid response being received. Check the error log for more details.");
        c.a(new dq(b), dq.class);
        return;
      }
      localObject1 = new dw(f.a((URI)localObject1, e));
      continue;
      label209:
      AppboyLogger.w(a, "Request response was null, failing task.");
    }
  }
}

/* Location:
 * Qualified Name:     bo.app.ei
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */