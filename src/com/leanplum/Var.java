package com.leanplum;

import android.util.Log;
import com.leanplum.callbacks.VariableCallback;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Var<T>
{
  private static boolean t;
  String a;
  boolean b;
  int c;
  String d;
  private String e;
  private String[] f;
  private Double g;
  private T h;
  private T i;
  private String j;
  private List<VariableCallback<T>> k = new ArrayList();
  private List<VariableCallback<T>> l = new ArrayList();
  private boolean m;
  private boolean n;
  private boolean o;
  private byte[] p;
  private boolean q = false;
  private boolean r;
  private int s;
  
  private static <T> Var<T> a(String paramString1, T paramT, String paramString2, aT<T> paramaT)
  {
    if ((Leanplum.a) && (!paramString1.startsWith("__Android Resources"))) {
      Log.w("Leanplum", "You should not create new variables after calling start (name=" + paramString1 + ")");
    }
    Var localVar = aU.b(paramString1);
    if (localVar != null) {
      return localVar;
    }
    localVar = new Var();
    e = paramString1;
    f = aU.a(paramString1);
    h = paramT;
    i = paramT;
    j = paramString2;
    if (paramString1.startsWith("__Android Resources")) {
      r = true;
    }
    if (paramaT != null) {
      paramaT.a(localVar);
    }
    localVar.c();
    aU.a(localVar);
    if (j.equals("file")) {
      aU.a(a, localVar.defaultValue().toString(), localVar.defaultStream(), b, d, c);
    }
    localVar.a();
    return localVar;
  }
  
  static Var<String> a(String paramString1, String paramString2, int paramInt, String paramString3, byte[] paramArrayOfByte)
  {
    return a(paramString1, paramString2, "file", new aR(paramInt, paramString3, paramArrayOfByte));
  }
  
  private void b()
  {
    if ((!r) && (!Leanplum.hasStarted()) && (!t))
    {
      Log.w("Leanplum", "Leanplum hasn't finished retrieving values from the server. You should use a callback to make sure the value for '" + e + "' is ready. Otherwise, your app may not use the most up-to-date value.");
      t = true;
    }
  }
  
  private void c()
  {
    if ((i instanceof String)) {
      a = ((String)i);
    }
    do
    {
      try
      {
        g = Double.valueOf(a);
        return;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        g = null;
        return;
      }
      if (!(i instanceof Number)) {
        break;
      }
      a = i;
      g = Double.valueOf(((Number)i).doubleValue());
      if ((h instanceof Byte))
      {
        i = Byte.valueOf(((Number)i).byteValue());
        return;
      }
      if ((h instanceof Short))
      {
        i = Short.valueOf(((Number)i).shortValue());
        return;
      }
      if ((h instanceof Integer))
      {
        i = Integer.valueOf(((Number)i).intValue());
        return;
      }
      if ((h instanceof Long))
      {
        i = Long.valueOf(((Number)i).longValue());
        return;
      }
      if ((h instanceof Float))
      {
        i = Float.valueOf(((Number)i).floatValue());
        return;
      }
      if ((h instanceof Double))
      {
        i = Double.valueOf(((Number)i).doubleValue());
        return;
      }
    } while (!(h instanceof Character));
    i = Character.valueOf((char)((Number)i).intValue());
    return;
    if ((i != null) && (!(i instanceof Iterable)) && (!(i instanceof Map)))
    {
      a = i.toString();
      g = null;
      return;
    }
    a = null;
    g = null;
  }
  
  private void d()
  {
    Iterator localIterator = l.iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return;
      }
      VariableCallback localVariableCallback = (VariableCallback)localIterator.next();
      localVariableCallback.setVariable(this);
      N.a().a(localVariableCallback);
    }
  }
  
  public static <T> Var<T> define(String paramString, T paramT)
  {
    return a(paramString, paramT, aU.a(paramT), null);
  }
  
  public static <T> Var<T> define(String paramString1, T paramT, String paramString2)
  {
    return a(paramString1, paramT, paramString2, null);
  }
  
  public static Var<String> defineAsset(String paramString1, String paramString2)
  {
    return a(paramString1, paramString2, "file", new aQ());
  }
  
  public static Var<Integer> defineColor(String paramString, int paramInt)
  {
    return a(paramString, Integer.valueOf(paramInt), "color", null);
  }
  
  public static Var<String> defineFile(String paramString1, String paramString2)
  {
    return a(paramString1, paramString2, "file", null);
  }
  
  private void e()
  {
    m = false;
    Iterator localIterator = k.iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return;
      }
      VariableCallback localVariableCallback = (VariableCallback)localIterator.next();
      localVariableCallback.setVariable(this);
      N.a().a(localVariableCallback);
    }
  }
  
  final void a()
  {
    Object localObject = i;
    i = aU.a(f);
    if ((i == null) && (localObject == null)) {}
    do
    {
      do
      {
        return;
      } while ((i != null) && (localObject != null) && (i.equals(localObject)) && (n));
      c();
      if ((aU.i()) && (e.startsWith("__Android Resources")) && (j.equals("file")) && (!m)) {
        e();
      }
    } while (aU.i());
    if (Leanplum.hasStarted()) {
      d();
    }
    if (j.equals("file")) {
      if (!g.a())
      {
        localObject = FileManager.a(b, a, (String)h, new aS(this));
        q = false;
        if (localObject != FileManager.DownloadFileResult.DOWNLOADING) {
          break label209;
        }
        m = true;
      }
    }
    for (;;)
    {
      if ((Leanplum.hasStarted()) && (!m)) {
        e();
      }
      if (!Leanplum.hasStarted()) {
        break;
      }
      n = true;
      return;
      label209:
      if (localObject == FileManager.DownloadFileResult.EXISTS_IN_ASSETS) {
        q = true;
      }
    }
  }
  
  public void addFileReadyHandler(VariableCallback<T> paramVariableCallback)
  {
    k.add(paramVariableCallback);
    if ((Leanplum.hasStarted()) && (!m)) {
      e();
    }
  }
  
  public void addValueChangedHandler(VariableCallback<T> paramVariableCallback)
  {
    l.add(paramVariableCallback);
    if (Leanplum.hasStarted()) {
      d();
    }
  }
  
  public int count()
  {
    b();
    Object localObject = aU.a(f);
    if ((localObject instanceof List)) {
      return ((List)localObject).size();
    }
    Leanplum.a(new UnsupportedOperationException("This variable is not a list."));
    return 0;
  }
  
  public InputStream defaultStream()
  {
    if (!j.equals("file")) {
      return null;
    }
    return FileManager.a(b, Boolean.valueOf(o), Boolean.valueOf(q), (String)h, (String)h, p);
  }
  
  public T defaultValue()
  {
    return (T)h;
  }
  
  public String fileValue()
  {
    b();
    if (j.equals("file")) {
      return FileManager.a(a, (String)h, Boolean.valueOf(q));
    }
    return null;
  }
  
  public String kind()
  {
    return j;
  }
  
  public String name()
  {
    return e;
  }
  
  public String[] nameComponents()
  {
    return f;
  }
  
  public Number numberValue()
  {
    b();
    return g;
  }
  
  public Object objectForKeyPath(Object... paramVarArgs)
  {
    b();
    ArrayList localArrayList = new ArrayList();
    String[] arrayOfString = f;
    int i2 = arrayOfString.length;
    int i1 = 0;
    if (i1 >= i2)
    {
      i2 = paramVarArgs.length;
      i1 = 0;
    }
    for (;;)
    {
      if (i1 >= i2)
      {
        return aU.a(localArrayList.toArray(new Object[0]));
        localArrayList.add(arrayOfString[i1]);
        i1 += 1;
        break;
      }
      localArrayList.add(paramVarArgs[i1]);
      i1 += 1;
    }
  }
  
  public int overrideResId()
  {
    return s;
  }
  
  public void removeFileReadyHandler(VariableCallback<T> paramVariableCallback)
  {
    k.remove(paramVariableCallback);
  }
  
  public void removeValueChangedHandler(VariableCallback<T> paramVariableCallback)
  {
    l.remove(paramVariableCallback);
  }
  
  public void setOverrideResId(int paramInt)
  {
    s = paramInt;
  }
  
  public InputStream stream()
  {
    Object localObject;
    if (!j.equals("file")) {
      localObject = null;
    }
    InputStream localInputStream;
    do
    {
      return (InputStream)localObject;
      b();
      localInputStream = FileManager.a(b, Boolean.valueOf(o), Boolean.valueOf(q), fileValue(), (String)h, p);
      localObject = localInputStream;
    } while (localInputStream != null);
    return defaultStream();
  }
  
  public String stringValue()
  {
    b();
    return a;
  }
  
  public final String toString()
  {
    return "Var(" + e + ")=" + i;
  }
  
  public T value()
  {
    b();
    return (T)i;
  }
}

/* Location:
 * Qualified Name:     com.leanplum.Var
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */