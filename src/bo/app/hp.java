package bo.app;

import android.graphics.Bitmap;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Set;

public final class hp
  implements hn
{
  private final LinkedHashMap<String, Bitmap> a;
  private final int b;
  private int c;
  
  public hp(int paramInt)
  {
    if (paramInt <= 0) {
      throw new IllegalArgumentException("maxSize <= 0");
    }
    b = paramInt;
    a = new LinkedHashMap(0, 0.75F, true);
  }
  
  private static int a(Bitmap paramBitmap)
  {
    return paramBitmap.getRowBytes() * paramBitmap.getHeight();
  }
  
  private void a(int paramInt)
  {
    try
    {
      if ((c < 0) || ((a.isEmpty()) && (c != 0))) {
        throw new IllegalStateException(getClass().getName() + ".sizeOf() is reporting inconsistent results!");
      }
    }
    finally
    {
      throw ((Throwable)localObject1);
      if ((c <= paramInt) || (a.isEmpty())) {
        return;
      }
      Object localObject2 = (Map.Entry)a.entrySet().iterator().next();
      if (localObject2 == null) {
        return;
      }
      String str = (String)((Map.Entry)localObject2).getKey();
      localObject2 = (Bitmap)((Map.Entry)localObject2).getValue();
      a.remove(str);
      c -= a((Bitmap)localObject2);
    }
  }
  
  public final Bitmap a(String paramString)
  {
    if (paramString == null) {
      throw new NullPointerException("key == null");
    }
    try
    {
      paramString = (Bitmap)a.get(paramString);
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public final Collection<String> a()
  {
    try
    {
      HashSet localHashSet = new HashSet(a.keySet());
      return localHashSet;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final boolean a(String paramString, Bitmap paramBitmap)
  {
    if ((paramString == null) || (paramBitmap == null)) {
      throw new NullPointerException("key == null || value == null");
    }
    try
    {
      c += a(paramBitmap);
      paramString = (Bitmap)a.put(paramString, paramBitmap);
      if (paramString != null) {
        c -= a(paramString);
      }
      a(b);
      return true;
    }
    finally {}
  }
  
  public final Bitmap b(String paramString)
  {
    if (paramString == null) {
      throw new NullPointerException("key == null");
    }
    try
    {
      paramString = (Bitmap)a.remove(paramString);
      if (paramString != null) {
        c -= a(paramString);
      }
      return paramString;
    }
    finally {}
  }
  
  public final String toString()
  {
    try
    {
      String str = String.format("LruCache[maxSize=%d]", new Object[] { Integer.valueOf(b) });
      return str;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
}

/* Location:
 * Qualified Name:     bo.app.hp
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */