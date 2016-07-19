package bo.app;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public abstract class ki
  implements kk
{
  protected static void b(String paramString, JSONArray paramJSONArray1, JSONArray paramJSONArray2, kf paramkf)
  {
    paramJSONArray1 = kl.a(kl.b(paramJSONArray1));
    paramJSONArray2 = kl.a(kl.b(paramJSONArray2));
    Object localObject1 = paramJSONArray1.keySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      if (!paramJSONArray2.containsKey(localObject2)) {
        paramkf.a(paramString + "[]", localObject2);
      } else if (!((Integer)paramJSONArray2.get(localObject2)).equals(paramJSONArray1.get(localObject2))) {
        paramkf.a(paramString + "[]: Expected " + paramJSONArray1.get(localObject2) + " occurrence(s) of " + localObject2 + " but got " + paramJSONArray2.get(localObject2) + " occurrence(s)");
      }
    }
    paramJSONArray2 = paramJSONArray2.keySet().iterator();
    while (paramJSONArray2.hasNext())
    {
      localObject1 = paramJSONArray2.next();
      if (!paramJSONArray1.containsKey(localObject1)) {
        paramkf.b(paramString + "[]", localObject1);
      }
    }
  }
  
  public final kf a(JSONArray paramJSONArray1, JSONArray paramJSONArray2)
  {
    kf localkf = new kf();
    e("", paramJSONArray1, paramJSONArray2, localkf);
    return localkf;
  }
  
  public final kf a(JSONObject paramJSONObject1, JSONObject paramJSONObject2)
  {
    kf localkf = new kf();
    a("", paramJSONObject1, paramJSONObject2, localkf);
    return localkf;
  }
  
  protected final void a(String paramString, JSONArray paramJSONArray1, JSONArray paramJSONArray2, kf paramkf)
  {
    String str = kl.a(paramJSONArray1);
    if ((str == null) || (!kl.a(str, paramJSONArray2))) {
      d(paramString, paramJSONArray1, paramJSONArray2, paramkf);
    }
    for (;;)
    {
      return;
      paramJSONArray1 = kl.a(paramJSONArray1, str);
      paramJSONArray2 = kl.a(paramJSONArray2, str);
      Iterator localIterator = paramJSONArray1.keySet().iterator();
      Object localObject;
      while (localIterator.hasNext())
      {
        localObject = localIterator.next();
        if (!paramJSONArray2.containsKey(localObject))
        {
          paramkf.a(kl.a(paramString, str, localObject), paramJSONArray1.get(localObject));
        }
        else
        {
          JSONObject localJSONObject1 = (JSONObject)paramJSONArray1.get(localObject);
          JSONObject localJSONObject2 = (JSONObject)paramJSONArray2.get(localObject);
          a(kl.a(paramString, str, localObject), localJSONObject1, localJSONObject2, paramkf);
        }
      }
      localIterator = paramJSONArray2.keySet().iterator();
      while (localIterator.hasNext())
      {
        localObject = localIterator.next();
        if (!paramJSONArray1.containsKey(localObject)) {
          paramkf.b(kl.a(paramString, str, localObject), paramJSONArray2.get(localObject));
        }
      }
    }
  }
  
  protected final void c(String paramString, JSONArray paramJSONArray1, JSONArray paramJSONArray2, kf paramkf)
  {
    int i = 0;
    while (i < paramJSONArray1.length())
    {
      Object localObject1 = paramJSONArray1.get(i);
      Object localObject2 = paramJSONArray2.get(i);
      a(paramString + "[" + i + "]", localObject1, localObject2, paramkf);
      i += 1;
    }
  }
  
  protected final void d(String paramString, JSONArray paramJSONArray1, JSONArray paramJSONArray2, kf paramkf)
  {
    HashSet localHashSet = new HashSet();
    int j = 0;
    Object localObject1;
    int i;
    label32:
    Object localObject2;
    if (j < paramJSONArray1.length())
    {
      localObject1 = paramJSONArray1.get(j);
      i = 0;
      if (i >= paramJSONArray2.length()) {
        break label263;
      }
      localObject2 = paramJSONArray2.get(i);
      if ((localHashSet.contains(Integer.valueOf(i))) || (!localObject2.getClass().equals(localObject1.getClass()))) {
        break label245;
      }
      if (!(localObject1 instanceof JSONObject)) {
        break label169;
      }
      if (!aa) {
        break label245;
      }
      localHashSet.add(Integer.valueOf(i));
      i = 1;
    }
    for (;;)
    {
      if (i == 0)
      {
        paramkf.a(paramString + "[" + j + "] Could not find match for element " + localObject1);
        return;
        label169:
        if ((localObject1 instanceof JSONArray))
        {
          if (aa)
          {
            localHashSet.add(Integer.valueOf(i));
            i = 1;
          }
        }
        else if (localObject1.equals(localObject2))
        {
          localHashSet.add(Integer.valueOf(i));
          i = 1;
          continue;
        }
        label245:
        i += 1;
        break label32;
      }
      j += 1;
      break;
      label263:
      i = 0;
    }
  }
}

/* Location:
 * Qualified Name:     bo.app.ki
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */