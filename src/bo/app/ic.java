package bo.app;

import java.io.File;
import java.util.concurrent.Executor;

public final class ic
  implements Runnable
{
  public ic(ib paramib, ie paramie) {}
  
  public final void run()
  {
    File localFile = b.a.o.a(a.b);
    if ((localFile != null) && (localFile.exists())) {}
    for (int i = 1;; i = 0)
    {
      b.a();
      if (i == 0) {
        break;
      }
      b.c.execute(a);
      return;
    }
    b.b.execute(a);
  }
}

/* Location:
 * Qualified Name:     bo.app.ic
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */