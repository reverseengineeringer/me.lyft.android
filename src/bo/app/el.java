package bo.app;

import java.util.concurrent.Executor;

public final class el
  implements eg
{
  public ch a;
  private final f b;
  private final h c;
  private final bd d;
  private final bd e;
  private final Executor f;
  private final ex g;
  private final fb h;
  
  public el(f paramf, h paramh, bd parambd1, bd parambd2, Executor paramExecutor, ex paramex, fb paramfb)
  {
    b = paramf;
    c = paramh;
    d = parambd1;
    e = parambd2;
    f = paramExecutor;
    g = paramex;
    h = paramfb;
  }
  
  public final void a(ef paramef)
  {
    if ((paramef instanceof ee))
    {
      paramef = (ee)paramef;
      f.execute(new dz(paramef, b, c, d, e, g, a, h));
    }
    while (!(paramef instanceof du)) {
      return;
    }
    paramef = (du)paramef;
    f.execute(new ei(paramef, new dv(), c, d, e));
  }
  
  public final void b(ef paramef)
  {
    if ((paramef instanceof ee)) {
      new dz((ee)paramef, b, c, d, e, g, a, h).run();
    }
    while (!(paramef instanceof du)) {
      return;
    }
    new ei((du)paramef, new dv(), c, d, e).run();
  }
}

/* Location:
 * Qualified Name:     bo.app.el
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */