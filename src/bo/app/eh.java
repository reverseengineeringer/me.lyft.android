package bo.app;

import com.appboy.Constants;
import com.appboy.support.AppboyLogger;

public class eh
  implements eg
{
  private static final String a = String.format("%s.%s", new Object[] { Constants.APPBOY_LOG_TAG_PREFIX, eh.class.getName() });
  private final bd b;
  
  public eh(bd parambd)
  {
    b = parambd;
  }
  
  public final void a(ef paramef)
  {
    c(paramef);
  }
  
  public final void b(ef paramef)
  {
    c(paramef);
  }
  
  public final void c(ef paramef)
  {
    AppboyLogger.i(a, "Short circuiting execution of network request and immediately marking it as succeeded.");
    paramef.a(b);
    paramef.b(b);
    if ((paramef instanceof ee)) {
      b.a(new bf((ee)paramef), bf.class);
    }
    while (!(paramef instanceof du)) {
      return;
    }
    b.a(new dr((du)paramef, null), dr.class);
  }
}

/* Location:
 * Qualified Name:     bo.app.eh
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */