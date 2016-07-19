package bo.app;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;

final class ig
  implements Runnable
{
  ig(ie paramie, int paramInt, Throwable paramThrowable) {}
  
  public final void run()
  {
    Object localObject = c.d;
    int i;
    jm localjm;
    Resources localResources;
    if ((f != null) || (c != 0))
    {
      i = 1;
      if (i != 0)
      {
        localjm = c.c;
        localObject = c.d;
        localResources = c.a.a;
        if (c == 0) {
          break label132;
        }
      }
    }
    label132:
    for (localObject = localResources.getDrawable(c);; localObject = f)
    {
      localjm.a((Drawable)localObject);
      localObject = c.e;
      localObject = c.b;
      c.c.d();
      new il(a, b);
      return;
      i = 0;
      break;
    }
  }
}

/* Location:
 * Qualified Name:     bo.app.ig
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */