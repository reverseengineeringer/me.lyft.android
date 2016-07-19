package bo.app;

import android.graphics.Bitmap;
import android.os.Handler;

public final class ij
  implements Runnable
{
  private final ib a;
  private final Bitmap b;
  private final id c;
  private final Handler d;
  
  public ij(ib paramib, Bitmap paramBitmap, id paramid, Handler paramHandler)
  {
    a = paramib;
    b = paramBitmap;
    c = paramid;
    d = paramHandler;
  }
  
  public final void run()
  {
    jx.a("PostProcess image before displaying [%s]", new Object[] { c.b });
    js localjs = c.e.p;
    Bitmap localBitmap = b;
    ie.a(new hs(localjs.a(), c, a, iq.c), c.e.s, d, a);
  }
}

/* Location:
 * Qualified Name:     bo.app.ij
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */