package com.leanplum;

import android.util.Log;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ActionContext
{
  private String a;
  private String b;
  private Map<String, Object> c;
  private ActionContext d;
  private int e;
  private String f;
  private boolean g = false;
  private boolean h = true;
  private boolean i = false;
  private b j;
  
  ActionContext(String paramString1, Map<String, Object> paramMap, String paramString2)
  {
    a = paramString1;
    c = paramMap;
    b = paramString2;
    e = aU.f();
  }
  
  private static Map<String, Object> a(String paramString)
  {
    Map localMap = (Map)aU.k().get(paramString);
    paramString = localMap;
    if (localMap == null) {
      paramString = new HashMap();
    }
    return paramString;
  }
  
  private void a(Map<String, Object> paramMap1, String paramString, Map<String, Object> paramMap2)
  {
    Object localObject1 = (Map)a(a).get("kinds");
    Iterator localIterator;
    if (localObject1 == null)
    {
      localObject1 = new HashMap();
      localIterator = paramMap1.keySet().iterator();
    }
    for (;;)
    {
      if (!localIterator.hasNext())
      {
        return;
        break;
      }
      String str1 = (String)localIterator.next();
      Object localObject3 = paramMap1.get(str1);
      label96:
      String str2;
      if (paramMap2 != null)
      {
        localObject2 = paramMap2.get(str1);
        str2 = (String)((Map)localObject1).get(paramString + str1);
        if (((str2 != null) && (str2.equals("action"))) || (!(localObject3 instanceof Map))) {
          break label215;
        }
        if (!(localObject2 instanceof Map)) {
          break label209;
        }
      }
      label209:
      for (Object localObject2 = (Map)localObject2;; localObject2 = null)
      {
        a((Map)localObject3, paramString + str1 + ".", (Map)localObject2);
        break;
        localObject2 = null;
        break label96;
      }
      label215:
      if ((str2 != null) && (str2.equals("file")))
      {
        str1 = localObject3.toString();
        if (localObject2 != null) {}
        for (localObject2 = localObject2.toString();; localObject2 = null)
        {
          FileManager.a(false, str1, (String)localObject2, null);
          break;
        }
      }
      if ((str2 == null) || (str2.equals("action")))
      {
        localObject2 = objectNamed(paramString + str1);
        if ((localObject2 instanceof Map))
        {
          localObject2 = (Map)localObject2;
          new ActionContext((String)((Map)localObject2).get("__name__"), (Map)localObject2, b).b();
        }
      }
    }
  }
  
  private Map<String, Object> b(String paramString)
  {
    paramString = objectNamed(paramString);
    if (!(paramString instanceof Map)) {
      return null;
    }
    paramString = (Map)paramString;
    return (Map)aU.a((Map)a((String)paramString.get("__name__")).get("values"), paramString);
  }
  
  private Map<String, Object> e()
  {
    Map localMap = (Map)a(a).get("values");
    Object localObject = localMap;
    if (localMap == null) {
      localObject = new HashMap();
    }
    return (Map<String, Object>)localObject;
  }
  
  final void a()
  {
    g = true;
  }
  
  final void a(b paramb)
  {
    j = paramb;
  }
  
  final void a(boolean paramBoolean)
  {
    h = paramBoolean;
  }
  
  public String actionName()
  {
    return a;
  }
  
  final void b()
  {
    a(c, "", e());
  }
  
  final void b(boolean paramBoolean)
  {
    i = true;
  }
  
  public boolean booleanNamed(String paramString)
  {
    paramString = objectNamed(paramString);
    if ((paramString instanceof Boolean)) {
      return ((Boolean)paramString).booleanValue();
    }
    return Boolean.valueOf(paramString.toString()).booleanValue();
  }
  
  final String c()
  {
    return b;
  }
  
  final boolean d()
  {
    return i;
  }
  
  public void muteFutureMessagesOfSameKind()
  {
    c.a();
    c.c(b);
  }
  
  public Number numberNamed(String paramString)
  {
    paramString = objectNamed(paramString);
    if ((paramString instanceof Number)) {
      return (Number)paramString;
    }
    return Double.valueOf(paramString.toString());
  }
  
  public <T> T objectNamed(String paramString)
  {
    if ((!g) && (aU.f() > e))
    {
      ActionContext localActionContext = d;
      if (localActionContext == null) {
        break label50;
      }
      c = localActionContext.b(f);
    }
    for (;;)
    {
      return (T)aU.a(aU.a(paramString), c);
      label50:
      if (b != null) {
        c = ((Map)((Map)aU.l().get(b)).get("vars"));
      }
    }
  }
  
  public void runActionNamed(String paramString)
  {
    Object localObject = b(paramString);
    if (localObject == null) {
      return;
    }
    localObject = new ActionContext(((Map)localObject).get("__name__").toString(), (Map)localObject, b);
    j = j;
    g = g;
    h = h;
    d = this;
    f = paramString;
    Leanplum.a((ActionContext)localObject);
  }
  
  public void runTrackedActionNamed(String paramString)
  {
    ArrayList localArrayList;
    Object localObject;
    StringBuilder localStringBuilder;
    int k;
    if ((!g.a()) && (b != null) && (h))
    {
      localArrayList = new ArrayList();
      localObject = this;
      if (d != null) {
        break label107;
      }
      localStringBuilder = new StringBuilder();
      k = localArrayList.size() - 1;
    }
    for (;;)
    {
      if (k < -1)
      {
        k = 1;
        if (k != 0)
        {
          localObject = new HashMap();
          ((Map)localObject).put("messageId", b);
          Leanplum.a(localStringBuilder.toString(), 0.0D, null, null, (Map)localObject);
        }
        runActionNamed(paramString);
        return;
        label107:
        localArrayList.add(localObject);
        localObject = d;
        break;
      }
      if (localStringBuilder.length() > 0) {
        localStringBuilder.append(' ');
      }
      if (k >= 0) {}
      for (localObject = getf;; localObject = paramString)
      {
        if (localObject != null) {
          break label173;
        }
        k = 0;
        break;
      }
      label173:
      localStringBuilder.append(((String)localObject).replace(" action", ""));
      k -= 1;
    }
  }
  
  public InputStream streamNamed(String paramString)
  {
    Object localObject3 = null;
    String str = stringNamed(paramString);
    Object localObject2 = paramString.split("\\.");
    Object localObject1 = e();
    int k = 0;
    if (k >= localObject2.length)
    {
      localObject1 = null;
      label34:
      if ((str != null) && (str.length() != 0)) {
        break label136;
      }
      localObject2 = localObject3;
      if (localObject1 != null)
      {
        if (((String)localObject1).length() != 0) {
          break label136;
        }
        localObject2 = localObject3;
      }
    }
    label136:
    do
    {
      return (InputStream)localObject2;
      if (localObject1 == null)
      {
        localObject1 = null;
        break label34;
      }
      if (k == localObject2.length - 1)
      {
        localObject1 = ((Map)localObject1).get(localObject2[k]);
        if (localObject1 == null)
        {
          localObject1 = null;
          break label34;
        }
        localObject1 = localObject1.toString();
        break label34;
      }
      localObject1 = (Map)((Map)localObject1).get(localObject2[k]);
      k += 1;
      break;
      localObject1 = FileManager.a(false, null, null, FileManager.a(str, (String)localObject1, null), (String)localObject1, null);
      localObject2 = localObject1;
    } while (localObject1 != null);
    Log.e("Leanplum", "Could not open stream named " + paramString);
    return (InputStream)localObject1;
  }
  
  public String stringNamed(String paramString)
  {
    paramString = objectNamed(paramString);
    if (paramString == null)
    {
      localObject = null;
      return (String)localObject;
    }
    paramString = paramString.toString();
    if ((j == null) || (paramString == null) || (!paramString.contains("##"))) {
      return paramString;
    }
    Iterator localIterator;
    if (j.a != null)
    {
      localObject = j.a;
      localIterator = ((Map)localObject).keySet().iterator();
      label72:
      if (localIterator.hasNext()) {}
    }
    for (Object localObject = paramString;; localObject = paramString)
    {
      paramString = (String)localObject;
      if (j.b != null) {
        paramString = ((String)localObject).replace("##Previous Value##", j.b.toString());
      }
      localObject = paramString;
      if (j.c == null) {
        break;
      }
      return paramString.replace("##Value##", j.c.toString());
      String str = (String)localIterator.next();
      paramString = paramString.replace("##Parameter " + str + "##", ((Map)localObject).get(str));
      break label72;
    }
  }
  
  public void track(String paramString, double paramDouble, Map<String, Object> paramMap)
  {
    if ((!g.a()) && (b != null))
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("messageId", b);
      Leanplum.a(paramString, 0.0D, null, paramMap, localHashMap);
    }
  }
}

/* Location:
 * Qualified Name:     com.leanplum.ActionContext
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */