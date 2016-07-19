package bo.app;

import com.appboy.support.AppboyLogger;

final class o
  implements Runnable
{
  private o(n paramn) {}
  
  public final void run()
  {
    while (n.a(a))
    {
      try
      {
        ee localee = n.b(a).a();
        if ((!localee.f()) && (!n.c(a))) {
          break label81;
        }
        n.d(a).c(localee);
      }
      catch (InterruptedException localInterruptedException)
      {
        AppboyLogger.w(n.a(), String.format("Automatic thread interrupted! [%s]", new Object[] { localInterruptedException.getMessage() }));
      }
      continue;
      label81:
      n.e(a).a(localInterruptedException);
    }
  }
}

/* Location:
 * Qualified Name:     bo.app.o
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */