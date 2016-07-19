package com.leanplum;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Timer;

final class ac
{
  private aJ a;
  private boolean b;
  private Timer c;
  private boolean d = false;
  private boolean e = false;
  
  public ac()
  {
    try
    {
      a = new aJ(new URI("http://" + g.b + ":" + g.c), new aP(this));
      a();
      c = new Timer();
      c.schedule(new af(this), 0L, 5000L);
      return;
    }
    catch (URISyntaxException localURISyntaxException)
    {
      for (;;)
      {
        localURISyntaxException.printStackTrace();
      }
    }
  }
  
  private void a()
  {
    e = true;
    aJ localaJ = a;
    if (e == null) {
      new aO(localaJ).start();
    }
  }
}

/* Location:
 * Qualified Name:     com.leanplum.ac
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */