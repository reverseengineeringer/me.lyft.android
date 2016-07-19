package com.paypal.android.sdk;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

public class i
{
  private static final String a;
  private static final Map b;
  private static final Set c;
  private Map d = new LinkedHashMap();
  private j e;
  private Class f;
  
  static
  {
    if (!i.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      g = bool;
      a = i.class.getSimpleName();
      b = new HashMap();
      c = new HashSet();
      b.put("zh_CN", "zh-Hans");
      b.put("zh_TW", "zh-Hant_TW");
      b.put("zh_HK", "zh-Hant");
      b.put("en_UK", "en_GB");
      b.put("en_IE", "en_GB");
      b.put("iw_IL", "he");
      b.put("no", "nb");
      c.add("he");
      c.add("ar");
      return;
    }
  }
  
  public i(Class paramClass, List paramList)
  {
    f = paramClass;
    paramClass = paramList.iterator();
    while (paramClass.hasNext())
    {
      paramList = (j)paramClass.next();
      String str = paramList.a();
      if (str == null) {
        throw new RuntimeException("Null localeName");
      }
      if (d.containsKey(str)) {
        throw new RuntimeException("Locale " + str + " already added");
      }
      d.put(str, paramList);
      b(str);
    }
    a(null);
  }
  
  private void b(String paramString)
  {
    j localj = (j)d.get(paramString);
    ArrayList localArrayList = new ArrayList();
    new StringBuilder("Checking locale ").append(paramString);
    Enum[] arrayOfEnum = (Enum[])f.getEnumConstants();
    int j = arrayOfEnum.length;
    int i = 0;
    while (i < j)
    {
      Enum localEnum = arrayOfEnum[i];
      String str = "[" + paramString + "," + localEnum + "]";
      if (localj.a(localEnum, null) == null) {
        localArrayList.add("Missing " + str);
      }
      i += 1;
    }
    paramString = localArrayList.iterator();
    while (paramString.hasNext()) {
      paramString.next();
    }
  }
  
  private j c(String paramString)
  {
    Object localObject3 = null;
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramString != null)
    {
      if (paramString.length() < 2) {
        localObject1 = localObject2;
      }
    }
    else {
      return (j)localObject1;
    }
    localObject2 = localObject3;
    if (b.containsKey(paramString))
    {
      localObject1 = (String)b.get(paramString);
      localObject2 = (j)d.get(localObject1);
      new StringBuilder("Overriding locale specifier ").append(paramString).append(" with ").append((String)localObject1);
    }
    localObject1 = localObject2;
    if (localObject2 == null) {
      if (!paramString.contains("_")) {
        break label166;
      }
    }
    label166:
    for (localObject1 = paramString;; localObject1 = paramString + "_" + Locale.getDefault().getCountry())
    {
      localObject1 = (j)d.get(localObject1);
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = (j)d.get(paramString);
      }
      localObject1 = localObject2;
      if (localObject2 != null) {
        break;
      }
      paramString = paramString.substring(0, 2);
      return (j)d.get(paramString);
    }
  }
  
  public final String a()
  {
    return e.a();
  }
  
  public final String a(Enum paramEnum)
  {
    Object localObject1 = e;
    String str = Locale.getDefault().getCountry().toUpperCase(Locale.US);
    Object localObject2 = ((j)localObject1).a(paramEnum, str);
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      new StringBuilder("Missing localized string for [").append(e.a()).append(",Key.").append(paramEnum.toString()).append("]");
      localObject1 = ((j)d.get("en")).a(paramEnum, str);
    }
    localObject2 = localObject1;
    if (localObject1 == null)
    {
      new StringBuilder("Missing localized string for [en,Key.").append(paramEnum.toString()).append("], so defaulting to keyname");
      localObject2 = paramEnum.toString();
    }
    return (String)localObject2;
  }
  
  public final String a(String paramString, Enum paramEnum)
  {
    String str = e.a(paramString);
    if (str != null) {
      return str;
    }
    return String.format(a(paramEnum), new Object[] { paramString });
  }
  
  public final void a(String paramString)
  {
    j localj = null;
    new StringBuilder("setLanguage(").append(paramString).append(")");
    e = null;
    if (paramString != null) {
      localj = c(paramString);
    }
    Object localObject = localj;
    if (localj == null)
    {
      localObject = Locale.getDefault().toString();
      new StringBuilder().append(paramString).append(" not found.  Attempting to look for ").append((String)localObject);
      localObject = c((String)localObject);
    }
    paramString = (String)localObject;
    if (localObject == null) {
      paramString = (j)d.get("en");
    }
    if ((!g) && (paramString == null)) {
      throw new AssertionError();
    }
    e = paramString;
    if ((!g) && (e == null)) {
      throw new AssertionError();
    }
    new StringBuilder("setting locale to:").append(e.a());
  }
}

/* Location:
 * Qualified Name:     com.paypal.android.sdk.i
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */