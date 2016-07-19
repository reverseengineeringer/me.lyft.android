package bo.app;

import android.graphics.Bitmap;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;

public final class ho
  implements hn
{
  private final hn a;
  private final Comparator<String> b;
  
  public ho(hn paramhn, Comparator<String> paramComparator)
  {
    a = paramhn;
    b = paramComparator;
  }
  
  public final Bitmap a(String paramString)
  {
    return a.a(paramString);
  }
  
  public final Collection<String> a()
  {
    return a.a();
  }
  
  public final boolean a(String paramString, Bitmap paramBitmap)
  {
    for (;;)
    {
      synchronized (a)
      {
        Iterator localIterator = a.a().iterator();
        if (localIterator.hasNext())
        {
          str = (String)localIterator.next();
          if (b.compare(paramString, str) != 0) {
            continue;
          }
          if (str != null) {
            a.b(str);
          }
          return a.a(paramString, paramBitmap);
        }
      }
      String str = null;
    }
  }
  
  public final Bitmap b(String paramString)
  {
    return a.b(paramString);
  }
}

/* Location:
 * Qualified Name:     bo.app.ho
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */