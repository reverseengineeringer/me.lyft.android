package com.leanplum;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Log;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

final class c
{
  static String a = "__Push Notification";
  private static c e;
  private static boolean f = false;
  private Map<String, Map<String, Number>> b;
  private Map<String, Number> c;
  private Map<String, Number> d;
  
  private c()
  {
    Leanplum.onAction(a, new d(this));
    Leanplum.onAction("__Cancel" + a, new e(this));
    d = new HashMap();
    b = new HashMap();
    c = new HashMap();
  }
  
  public static c a()
  {
    try
    {
      if (e == null) {
        e = new c();
      }
      c localc = e;
      return localc;
    }
    finally {}
  }
  
  private static void a(Map<String, Object> paramMap, Set<String> paramSet)
  {
    if (paramMap == null) {}
    for (;;)
    {
      return;
      paramMap = ((List)paramMap.get("children")).iterator();
      while (paramMap.hasNext())
      {
        Map localMap = (Map)paramMap.next();
        String str = (String)localMap.get("subject");
        if ((str.equals("enterRegion")) || (str.equals("exitRegion"))) {
          paramSet.add((String)localMap.get("noun"));
        }
      }
    }
  }
  
  public static void a(Set<String> paramSet1, Set<String> paramSet2)
  {
    Map localMap1 = aU.l();
    Iterator localIterator = localMap1.keySet().iterator();
    Map localMap2;
    do
    {
      if (!localIterator.hasNext()) {
        return;
      }
      localMap2 = (Map)localMap1.get((String)localIterator.next());
      localObject = localMap2.get("action");
    } while (!(localObject instanceof String));
    if (localObject.equals(a)) {}
    for (Object localObject = paramSet2;; localObject = paramSet1)
    {
      a((Map)localMap2.get("whenTriggers"), (Set)localObject);
      a((Map)localMap2.get("unlessTriggers"), (Set)localObject);
      break;
    }
  }
  
  private static boolean a(Object paramObject, String paramString1, String paramString2, b paramb)
  {
    Iterator localIterator;
    if ((paramObject instanceof Map)) {
      localIterator = ((List)((Map)paramObject).get("children")).iterator();
    }
    String str;
    do
    {
      do
      {
        if (!localIterator.hasNext()) {
          return false;
        }
        paramObject = (Map)localIterator.next();
      } while (!((String)((Map)paramObject).get("subject")).equals(paramString1));
      str = (String)((Map)paramObject).get("noun");
    } while (((str != null) || (paramString2 != null)) && (!str.equals(paramString2)));
    paramString1 = (String)((Map)paramObject).get("verb");
    paramObject = (List)((Map)paramObject).get("objects");
    if ("changesTo".equals(paramString1))
    {
      if ((paramb != null) && (paramObject != null)) {
        paramObject = ((List)paramObject).iterator();
      }
      do
      {
        if (!((Iterator)paramObject).hasNext()) {
          return false;
        }
        paramString1 = ((Iterator)paramObject).next();
      } while (((paramString1 != null) || (c != null)) && ((paramString1 == null) || (!paramString1.toString().equalsIgnoreCase(c.toString()))));
      return true;
    }
    if ("changesFromTo".equals(paramString1)) {
      return (paramb != null) && (((List)paramObject).size() == 2) && (((List)paramObject).get(0) != null) && (((List)paramObject).get(1) != null) && (((List)paramObject).get(0).toString().equalsIgnoreCase(b.toString())) && (((List)paramObject).get(1).toString().equalsIgnoreCase(c.toString()));
    }
    if ("triggersWithParameter".equals(paramString1))
    {
      if ((paramb != null) && (((List)paramObject).size() == 2) && (((List)paramObject).get(0) != null) && (((List)paramObject).get(1) != null) && (a != null))
      {
        paramString1 = a.get(((List)paramObject).get(0));
        return (paramString1 != null) && (paramString1.toString().equalsIgnoreCase(((List)paramObject).get(1).toString()));
      }
      return false;
    }
    return true;
  }
  
  public static ag b()
  {
    if (Util.i()) {
      try
      {
        if (Class.forName("com.google.android.gms.location.LocationClient") != null)
        {
          ag localag = (ag)Class.forName("com.leanplum.LocationManagerImpl").getMethod("instance", new Class[0]).invoke(null, new Object[0]);
          return localag;
        }
      }
      catch (Throwable localThrowable)
      {
        if (!f)
        {
          Log.e("Leanplum", "Could not instantiate LocationManager. Google Play Services might be missing.");
          f = true;
        }
      }
    }
    return null;
  }
  
  public static void c(String paramString)
  {
    SharedPreferences.Editor localEditor;
    if (paramString != null)
    {
      localEditor = Leanplum.a().getSharedPreferences("__leanplum_messaging__", 0).edit();
      localEditor.putBoolean(String.format("__leanplum_message_muted_%s", new Object[] { paramString }), true);
    }
    try
    {
      localEditor.apply();
      return;
    }
    catch (NoSuchMethodError paramString)
    {
      localEditor.commit();
    }
  }
  
  private Map<String, Number> d(String paramString)
  {
    Map localMap = (Map)b.get(paramString);
    if (localMap != null) {
      return localMap;
    }
    localMap = a.a(Leanplum.a().getSharedPreferences("__leanplum_messaging__", 0).getString(String.format("__leanplum_message_occurrences_%s", new Object[] { paramString }), "{}"));
    b.put(paramString, localMap);
    return localMap;
  }
  
  private int e(String paramString)
  {
    Number localNumber = (Number)c.get(paramString);
    if (localNumber != null) {
      return localNumber.intValue();
    }
    int i = Leanplum.a().getSharedPreferences("__leanplum_messaging__", 0).getInt(String.format("__leanplum_message_trigger_occurrences_%s", new Object[] { paramString }), 0);
    c.put(paramString, Integer.valueOf(i));
    return i;
  }
  
  public final f a(String paramString1, Map<String, Object> paramMap, String paramString2, String paramString3, b paramb)
  {
    f localf = new f();
    if (Leanplum.a().getSharedPreferences("__leanplum_messaging__", 0).getBoolean(String.format("__leanplum_message_muted_%s", new Object[] { paramString1 }), false)) {
      return localf;
    }
    a = a(paramMap.get("whenTriggers"), paramString2, paramString3, paramb);
    b = a(paramMap.get("unlessTriggers"), paramString2, paramString3, paramb);
    if ((!a) && (!b)) {
      return localf;
    }
    paramMap = paramMap.get("whenLimits");
    if ((paramMap instanceof Map)) {}
    for (paramMap = (Map)paramMap;; paramMap = null)
    {
      boolean bool;
      if (paramMap == null) {
        bool = true;
      }
      int k;
      Iterator localIterator;
      for (;;)
      {
        c = bool;
        return localf;
        paramMap = (List)paramMap.get("children");
        if (paramMap.isEmpty())
        {
          bool = true;
        }
        else
        {
          paramb = d(paramString1);
          k = e(paramString1) + 1;
          localIterator = paramMap.iterator();
          label194:
          if (localIterator.hasNext()) {
            break;
          }
          bool = true;
        }
      }
      paramString2 = (Map)localIterator.next();
      paramString3 = paramString2.get("subject").toString();
      paramMap = paramString2.get("noun").toString();
      String str = paramString2.get("verb").toString();
      int i;
      label306:
      int m;
      if (paramString3.equals("times"))
      {
        paramString2 = (List)paramString2.get("objects");
        if (paramString2.size() > 0)
        {
          i = Integer.parseInt(paramString2.get(0).toString());
          m = Integer.parseInt(paramMap);
          if (!str.equals("limitSession")) {
            break label379;
          }
          paramString2 = (Number)d.get(paramString1);
          paramMap = paramString2;
          if (paramString2 == null) {
            paramMap = Long.valueOf(0L);
          }
          label348:
          if (paramMap.longValue() >= m) {
            break label692;
          }
          i = 1;
        }
        for (;;)
        {
          label362:
          if (i == 0)
          {
            bool = false;
            break;
            i = 0;
            break label306;
            label379:
            if ((paramb == null) || (paramb.isEmpty()))
            {
              i = 1;
            }
            else
            {
              paramMap = (Number)paramb.get("min");
              paramString3 = (Number)paramb.get("max");
              if (paramMap != null) {
                break label763;
              }
              paramMap = Long.valueOf(0L);
            }
          }
        }
      }
      label495:
      label509:
      label603:
      label692:
      label760:
      label763:
      for (;;)
      {
        paramString2 = paramString3;
        if (paramString3 == null) {
          paramString2 = Long.valueOf(0L);
        }
        if (str.equals("limitUser"))
        {
          paramMap = Long.valueOf(paramString2.longValue() - paramMap.longValue() + 1L);
          break label348;
        }
        long l2;
        long l1;
        int j;
        if (str.equals("limitMinute"))
        {
          i = 60;
          l2 = System.currentTimeMillis();
          l1 = paramString2.longValue();
          j = 0;
          if (l1 >= paramMap.longValue()) {
            break label603;
          }
        }
        do
        {
          paramMap = Long.valueOf(0L);
          break;
          if (str.equals("limitHour"))
          {
            i = 3600;
            break label495;
          }
          if (str.equals("limitDay"))
          {
            i = 86400;
            break label495;
          }
          if (str.equals("limitWeek"))
          {
            i = 604800;
            break label495;
          }
          if (!str.equals("limitMonth")) {
            break label495;
          }
          i = 2592000;
          break label495;
          if (!paramb.containsKey(l1)) {
            break label760;
          }
        } while ((l2 - ((Number)paramb.get(l1)).longValue()) / 1000L > i);
        j += 1;
        if (j < m) {}
        for (;;)
        {
          l1 -= 1L;
          break label509;
          i = 0;
          break label362;
          break label194;
          if (paramString3.equals("onNthOccurrence"))
          {
            if (k == Integer.parseInt(paramMap)) {
              break label194;
            }
            bool = false;
            break;
          }
          if (!paramString3.equals("everyNthOccurrence")) {
            break label194;
          }
          i = Integer.parseInt(paramMap);
          if ((i != 0) && (k % i == 0)) {
            break label194;
          }
          bool = false;
          break;
        }
      }
    }
  }
  
  public final void a(String paramString)
  {
    int i = e(paramString) + 1;
    SharedPreferences.Editor localEditor = Leanplum.a().getSharedPreferences("__leanplum_messaging__", 0).edit();
    localEditor.putInt(String.format("__leanplum_message_trigger_occurrences_%s", new Object[] { paramString }), i);
    c.put(paramString, Integer.valueOf(i));
    try
    {
      localEditor.apply();
      return;
    }
    catch (NoSuchMethodError paramString)
    {
      localEditor.commit();
    }
  }
  
  public final void b(String paramString)
  {
    Object localObject1 = new HashMap();
    ((Map)localObject1).put("messageId", paramString);
    Leanplum.a(null, 0.0D, null, null, (Map)localObject1);
    Object localObject2 = (Number)d.get(paramString);
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = Long.valueOf(0L);
    }
    long l = ((Number)localObject1).longValue();
    d.put(paramString, Long.valueOf(l + 1L));
    Map localMap = d(paramString);
    if ((localMap == null) || (localMap.isEmpty()))
    {
      localObject1 = new HashMap();
      ((Map)localObject1).put("min", Long.valueOf(0L));
      ((Map)localObject1).put("max", Long.valueOf(0L));
      ((Map)localObject1).put("0", Long.valueOf(System.currentTimeMillis()));
    }
    for (;;)
    {
      localObject2 = Leanplum.a().getSharedPreferences("__leanplum_messaging__", 0).edit();
      ((SharedPreferences.Editor)localObject2).putString(String.format("__leanplum_message_occurrences_%s", new Object[] { paramString }), a.a((Map)localObject1));
      b.put(paramString, localObject1);
      try
      {
        ((SharedPreferences.Editor)localObject2).apply();
        return;
      }
      catch (NoSuchMethodError paramString)
      {
        Number localNumber;
        ((SharedPreferences.Editor)localObject2).commit();
      }
      localObject2 = (Number)localMap.get("min");
      localNumber = (Number)localMap.get("max");
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = Long.valueOf(0L);
      }
      localObject2 = localNumber;
      if (localNumber == null) {
        localObject2 = Long.valueOf(0L);
      }
      localObject2 = Long.valueOf(((Number)localObject2).longValue() + 1L);
      localMap.put(localObject2, Long.valueOf(System.currentTimeMillis()));
      if (((Number)localObject2).longValue() - ((Number)localObject1).longValue() + 1L > 100L)
      {
        localMap.remove(localObject1);
        localMap.put("min", Long.valueOf(((Number)localObject1).longValue() + 1L));
      }
      localMap.put("max", localObject2);
      localObject1 = localMap;
    }
  }
}

/* Location:
 * Qualified Name:     com.leanplum.c
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */