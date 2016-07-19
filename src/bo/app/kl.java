package bo.app;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import org.json.JSONArray;
import org.json.JSONObject;

public final class kl
{
  private static Integer a = new Integer(1);
  
  public static String a(String paramString1, String paramString2)
  {
    if ("".equals(paramString1)) {
      return paramString2;
    }
    return paramString1 + "." + paramString2;
  }
  
  public static String a(String paramString1, String paramString2, Object paramObject)
  {
    return paramString1 + "[" + paramString2 + "=" + paramObject + "]";
  }
  
  public static String a(JSONArray paramJSONArray)
  {
    Iterator localIterator = a((JSONObject)paramJSONArray.get(0)).iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (a(str, paramJSONArray)) {
        return str;
      }
    }
    return null;
  }
  
  public static <T> Map<T, Integer> a(Collection<T> paramCollection)
  {
    HashMap localHashMap = new HashMap();
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext())
    {
      Object localObject = paramCollection.next();
      Integer localInteger = (Integer)localHashMap.get(localObject);
      if (localInteger == null) {
        localHashMap.put(localObject, a);
      } else {
        localHashMap.put(localObject, new Integer(localInteger.intValue() + 1));
      }
    }
    return localHashMap;
  }
  
  public static Map<Object, JSONObject> a(JSONArray paramJSONArray, String paramString)
  {
    HashMap localHashMap = new HashMap();
    int i = 0;
    while (i < paramJSONArray.length())
    {
      JSONObject localJSONObject = (JSONObject)paramJSONArray.get(i);
      localHashMap.put(localJSONObject.get(paramString), localJSONObject);
      i += 1;
    }
    return localHashMap;
  }
  
  public static Set<String> a(JSONObject paramJSONObject)
  {
    TreeSet localTreeSet = new TreeSet();
    paramJSONObject = paramJSONObject.keys();
    while (paramJSONObject.hasNext()) {
      localTreeSet.add((String)paramJSONObject.next());
    }
    return localTreeSet;
  }
  
  private static boolean a(Object paramObject)
  {
    return (!(paramObject instanceof JSONObject)) && (!(paramObject instanceof JSONArray));
  }
  
  public static boolean a(String paramString, JSONArray paramJSONArray)
  {
    boolean bool2 = false;
    HashSet localHashSet = new HashSet();
    int i = 0;
    while (i < paramJSONArray.length())
    {
      Object localObject = paramJSONArray.get(i);
      bool1 = bool2;
      if (!(localObject instanceof JSONObject)) {
        return bool1;
      }
      localObject = (JSONObject)localObject;
      bool1 = bool2;
      if (!((JSONObject)localObject).has(paramString)) {
        return bool1;
      }
      localObject = ((JSONObject)localObject).get(paramString);
      bool1 = bool2;
      if (!a(localObject)) {
        return bool1;
      }
      bool1 = bool2;
      if (localHashSet.contains(localObject)) {
        return bool1;
      }
      localHashSet.add(localObject);
      i += 1;
    }
    boolean bool1 = true;
    return bool1;
  }
  
  public static List<Object> b(JSONArray paramJSONArray)
  {
    ArrayList localArrayList = new ArrayList(paramJSONArray.length());
    int i = 0;
    while (i < paramJSONArray.length())
    {
      localArrayList.add(paramJSONArray.get(i));
      i += 1;
    }
    return localArrayList;
  }
  
  public static boolean c(JSONArray paramJSONArray)
  {
    int i = 0;
    while (i < paramJSONArray.length())
    {
      if (!a(paramJSONArray.get(i))) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public static boolean d(JSONArray paramJSONArray)
  {
    int i = 0;
    while (i < paramJSONArray.length())
    {
      if (!(paramJSONArray.get(i) instanceof JSONObject)) {
        return false;
      }
      i += 1;
    }
    return true;
  }
}

/* Location:
 * Qualified Name:     bo.app.kl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */