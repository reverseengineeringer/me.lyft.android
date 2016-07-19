package bo.app;

import java.util.Iterator;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public final class kj
  extends ki
{
  ke a;
  
  public kj(ke paramke)
  {
    a = paramke;
  }
  
  public final void a(String paramString, Object paramObject1, Object paramObject2, kf paramkf)
  {
    if (((paramObject1 instanceof Number)) && ((paramObject2 instanceof Number))) {
      if (((Number)paramObject1).doubleValue() != ((Number)paramObject2).doubleValue()) {
        paramkf.a(paramString, paramObject1, paramObject2);
      }
    }
    do
    {
      return;
      if (!paramObject1.getClass().isAssignableFrom(paramObject2.getClass())) {
        break;
      }
      if ((paramObject1 instanceof JSONArray))
      {
        e(paramString, (JSONArray)paramObject1, (JSONArray)paramObject2, paramkf);
        return;
      }
      if ((paramObject1 instanceof JSONObject))
      {
        a(paramString, (JSONObject)paramObject1, (JSONObject)paramObject2, paramkf);
        return;
      }
    } while (paramObject1.equals(paramObject2));
    paramkf.a(paramString, paramObject1, paramObject2);
    return;
    paramkf.a(paramString, paramObject1, paramObject2);
  }
  
  public final void a(String paramString, JSONObject paramJSONObject1, JSONObject paramJSONObject2, kf paramkf)
  {
    Object localObject1 = kl.a(paramJSONObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      String str = (String)((Iterator)localObject1).next();
      Object localObject2 = paramJSONObject1.get(str);
      if (paramJSONObject2.has(str))
      {
        Object localObject3 = paramJSONObject2.get(str);
        a(kl.a(paramString, str), localObject2, localObject3, paramkf);
      }
      else
      {
        paramkf.a(paramString, str);
      }
    }
    if (!a.e)
    {
      paramJSONObject2 = kl.a(paramJSONObject2).iterator();
      while (paramJSONObject2.hasNext())
      {
        localObject1 = (String)paramJSONObject2.next();
        if (!paramJSONObject1.has((String)localObject1)) {
          paramkf.b(paramString, localObject1);
        }
      }
    }
  }
  
  public final void e(String paramString, JSONArray paramJSONArray1, JSONArray paramJSONArray2, kf paramkf)
  {
    if (paramJSONArray1.length() != paramJSONArray2.length()) {
      paramkf.a(paramString + "[]: Expected " + paramJSONArray1.length() + " values but got " + paramJSONArray2.length());
    }
    while (paramJSONArray1.length() == 0) {
      return;
    }
    if (a.f)
    {
      c(paramString, paramJSONArray1, paramJSONArray2, paramkf);
      return;
    }
    if (kl.c(paramJSONArray1))
    {
      b(paramString, paramJSONArray1, paramJSONArray2, paramkf);
      return;
    }
    if (kl.d(paramJSONArray1))
    {
      a(paramString, paramJSONArray1, paramJSONArray2, paramkf);
      return;
    }
    d(paramString, paramJSONArray1, paramJSONArray2, paramkf);
  }
}

/* Location:
 * Qualified Name:     bo.app.kj
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */