package bo.app;

import android.graphics.Bitmap;

final class hs
  implements Runnable
{
  private final Bitmap a;
  private final String b;
  private final jm c;
  private final String d;
  private final jg e;
  private final jp f;
  private final ib g;
  private final iq h;
  
  public hs(Bitmap paramBitmap, id paramid, ib paramib, iq paramiq)
  {
    a = paramBitmap;
    b = a;
    c = c;
    d = b;
    e = e.q;
    f = f;
    g = paramib;
    h = paramiq;
  }
  
  public final void run()
  {
    if (c.e())
    {
      jx.a("ImageAware was collected by GC. Task is cancelled. [%s]", new Object[] { d });
      localObject = f;
      localObject = b;
      c.d();
      return;
    }
    Object localObject = g.a(c);
    if (!d.equals(localObject)) {}
    for (int i = 1; i != 0; i = 0)
    {
      jx.a("ImageAware is reused for another image. Task is cancelled. [%s]", new Object[] { d });
      localObject = f;
      localObject = b;
      c.d();
      return;
    }
    jx.a("Display image in ImageAware (loaded from %1$s) [%2$s]", new Object[] { h, d });
    localObject = e;
    Bitmap localBitmap = a;
    jm localjm = c;
    iq localiq = h;
    ((jg)localObject).a(localBitmap, localjm);
    g.b(c);
    f.a(b, c.d(), a);
  }
}

/* Location:
 * Qualified Name:     bo.app.hs
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */