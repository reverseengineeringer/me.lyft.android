package bo.app;

import com.appboy.Constants;
import com.appboy.configuration.XmlAppConfigurationProvider;
import java.util.concurrent.ThreadFactory;

public class n
  implements y
{
  public static final String a = String.format("%s.%s", new Object[] { Constants.APPBOY_LOG_TAG_PREFIX, n.class.getName() });
  public final XmlAppConfigurationProvider b;
  public final eg c;
  public final w d;
  public final Object e = new Object();
  public volatile boolean f = false;
  public volatile Thread g;
  public volatile boolean h = true;
  private eh i;
  private boolean j = false;
  
  public n(XmlAppConfigurationProvider paramXmlAppConfigurationProvider, bd parambd, eg parameg, w paramw, ThreadFactory paramThreadFactory, boolean paramBoolean)
  {
    b = paramXmlAppConfigurationProvider;
    c = parameg;
    d = paramw;
    g = paramThreadFactory.newThread(new o(this, (byte)0));
    i = new eh(parambd);
    j = paramBoolean;
  }
  
  public final void a(cx paramcx)
  {
    d.a(paramcx);
  }
  
  public final void a(ee paramee)
  {
    d.a(paramee);
  }
}

/* Location:
 * Qualified Name:     bo.app.n
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */