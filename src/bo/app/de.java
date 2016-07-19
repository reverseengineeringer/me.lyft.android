package bo.app;

import com.appboy.Constants;
import com.appboy.models.IPutIntoJson;
import com.appboy.support.AppboyLogger;
import com.appboy.support.StringUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class de
  implements ct, IPutIntoJson<JSONObject>
{
  private static final String a = String.format("%s.%s", new Object[] { Constants.APPBOY_LOG_TAG_PREFIX, de.class.getName() });
  private final Integer b;
  private final String c;
  private final String d;
  private final String e;
  private final String f;
  private final String g;
  private String h;
  private final di i;
  private final dg j;
  private final String k;
  private final List<dm> l;
  
  public de(Integer paramInteger, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, di paramdi, dg paramdg, String paramString7, List<dm> paramList)
  {
    b = paramInteger;
    c = paramString1;
    d = paramString2;
    e = paramString3;
    f = paramString4;
    g = paramString5;
    h = paramString6;
    i = paramdi;
    j = paramdg;
    k = paramString7;
    l = paramList;
  }
  
  public static de a(JSONObject paramJSONObject)
  {
    Object localObject11 = null;
    Object localObject10 = null;
    Object localObject9 = null;
    Object localObject7 = null;
    Object localObject8 = null;
    Object localObject6 = null;
    Object localObject5 = null;
    Object localObject4 = null;
    Object localObject3 = null;
    Object localObject1 = null;
    Object localObject2 = null;
    ac[] arrayOfac = ac.values();
    int i1 = arrayOfac.length;
    int m = 0;
    if (m < i1)
    {
      Object localObject23 = arrayOfac[m];
      Object localObject12 = localObject11;
      Object localObject13 = localObject10;
      Object localObject14 = localObject9;
      Object localObject15 = localObject7;
      Object localObject16 = localObject8;
      Object localObject17 = localObject6;
      Object localObject18 = localObject5;
      Object localObject19 = localObject4;
      Object localObject20 = localObject3;
      Object localObject21 = localObject1;
      Object localObject22 = localObject2;
      switch (df.a[localObject23.ordinal()])
      {
      default: 
        AppboyLogger.e(a, String.format("Unknown key encountered in Device createFromJson %s", new Object[] { localObject23 }));
        localObject22 = localObject2;
        localObject21 = localObject1;
        localObject20 = localObject3;
        localObject19 = localObject4;
        localObject18 = localObject5;
        localObject17 = localObject6;
        localObject16 = localObject8;
        localObject15 = localObject7;
        localObject14 = localObject9;
        localObject13 = localObject10;
        localObject12 = localObject11;
      }
      do
      {
        do
        {
          for (;;)
          {
            m += 1;
            localObject11 = localObject12;
            localObject10 = localObject13;
            localObject9 = localObject14;
            localObject7 = localObject15;
            localObject8 = localObject16;
            localObject6 = localObject17;
            localObject5 = localObject18;
            localObject4 = localObject19;
            localObject3 = localObject20;
            localObject1 = localObject21;
            localObject2 = localObject22;
            break;
            localObject23 = paramJSONObject.optJSONObject(gm);
            localObject12 = localObject11;
            localObject13 = localObject10;
            localObject14 = localObject9;
            localObject15 = localObject7;
            localObject16 = localObject8;
            localObject17 = localObject6;
            localObject18 = localObject5;
            localObject19 = localObject4;
            localObject20 = localObject3;
            localObject21 = localObject1;
            localObject22 = localObject2;
            if (localObject23 != null)
            {
              localObject17 = ((JSONObject)localObject23).optString(fm);
              localObject16 = ((JSONObject)localObject23).optString(em);
              localObject12 = localObject11;
              localObject13 = localObject10;
              localObject14 = localObject9;
              localObject15 = localObject7;
              localObject18 = localObject5;
              localObject19 = localObject4;
              localObject20 = localObject3;
              localObject21 = localObject1;
              localObject22 = localObject2;
              continue;
              localObject18 = StringUtils.emptyToNull(paramJSONObject.optString(hm));
              localObject12 = localObject11;
              localObject13 = localObject10;
              localObject14 = localObject9;
              localObject15 = localObject7;
              localObject16 = localObject8;
              localObject17 = localObject6;
              localObject19 = localObject4;
              localObject20 = localObject3;
              localObject21 = localObject1;
              localObject22 = localObject2;
              continue;
              localObject23 = paramJSONObject.optJSONObject(jm);
              localObject12 = localObject11;
              localObject13 = localObject10;
              localObject14 = localObject9;
              localObject15 = localObject7;
              localObject16 = localObject8;
              localObject17 = localObject6;
              localObject18 = localObject5;
              localObject19 = localObject4;
              localObject20 = localObject3;
              localObject21 = localObject1;
              localObject22 = localObject2;
              if (localObject23 != null)
              {
                localObject20 = dg.a((JSONObject)localObject23);
                localObject12 = localObject11;
                localObject13 = localObject10;
                localObject14 = localObject9;
                localObject15 = localObject7;
                localObject16 = localObject8;
                localObject17 = localObject6;
                localObject18 = localObject5;
                localObject19 = localObject4;
                localObject21 = localObject1;
                localObject22 = localObject2;
                continue;
                localObject23 = paramJSONObject.optJSONObject(im);
                localObject12 = localObject11;
                localObject13 = localObject10;
                localObject14 = localObject9;
                localObject15 = localObject7;
                localObject16 = localObject8;
                localObject17 = localObject6;
                localObject18 = localObject5;
                localObject19 = localObject4;
                localObject20 = localObject3;
                localObject21 = localObject1;
                localObject22 = localObject2;
                if (localObject23 != null)
                {
                  localObject19 = di.a((JSONObject)localObject23);
                  localObject12 = localObject11;
                  localObject13 = localObject10;
                  localObject14 = localObject9;
                  localObject15 = localObject7;
                  localObject16 = localObject8;
                  localObject17 = localObject6;
                  localObject18 = localObject5;
                  localObject20 = localObject3;
                  localObject21 = localObject1;
                  localObject22 = localObject2;
                  continue;
                  localObject12 = localObject11;
                  localObject13 = localObject10;
                  localObject14 = localObject9;
                  localObject15 = localObject7;
                  localObject16 = localObject8;
                  localObject17 = localObject6;
                  localObject18 = localObject5;
                  localObject19 = localObject4;
                  localObject20 = localObject3;
                  localObject21 = localObject1;
                  localObject22 = localObject2;
                  if (paramJSONObject.has(am))
                  {
                    localObject12 = Integer.valueOf(paramJSONObject.optInt(am));
                    localObject13 = localObject10;
                    localObject14 = localObject9;
                    localObject15 = localObject7;
                    localObject16 = localObject8;
                    localObject17 = localObject6;
                    localObject18 = localObject5;
                    localObject19 = localObject4;
                    localObject20 = localObject3;
                    localObject21 = localObject1;
                    localObject22 = localObject2;
                    continue;
                    localObject13 = StringUtils.emptyToNull(paramJSONObject.optString(bm));
                    localObject12 = localObject11;
                    localObject14 = localObject9;
                    localObject15 = localObject7;
                    localObject16 = localObject8;
                    localObject17 = localObject6;
                    localObject18 = localObject5;
                    localObject19 = localObject4;
                    localObject20 = localObject3;
                    localObject21 = localObject1;
                    localObject22 = localObject2;
                    continue;
                    localObject14 = StringUtils.emptyToNull(paramJSONObject.optString(cm));
                    localObject12 = localObject11;
                    localObject13 = localObject10;
                    localObject15 = localObject7;
                    localObject16 = localObject8;
                    localObject17 = localObject6;
                    localObject18 = localObject5;
                    localObject19 = localObject4;
                    localObject20 = localObject3;
                    localObject21 = localObject1;
                    localObject22 = localObject2;
                    continue;
                    localObject15 = StringUtils.emptyToNull(paramJSONObject.optString(dm));
                    localObject12 = localObject11;
                    localObject13 = localObject10;
                    localObject14 = localObject9;
                    localObject16 = localObject8;
                    localObject17 = localObject6;
                    localObject18 = localObject5;
                    localObject19 = localObject4;
                    localObject20 = localObject3;
                    localObject21 = localObject1;
                    localObject22 = localObject2;
                    continue;
                    localObject21 = StringUtils.emptyToNull(paramJSONObject.optString(km));
                    localObject12 = localObject11;
                    localObject13 = localObject10;
                    localObject14 = localObject9;
                    localObject15 = localObject7;
                    localObject16 = localObject8;
                    localObject17 = localObject6;
                    localObject18 = localObject5;
                    localObject19 = localObject4;
                    localObject20 = localObject3;
                    localObject22 = localObject2;
                  }
                }
              }
            }
          }
          localObject2 = new ArrayList();
          localObject12 = localObject11;
          localObject13 = localObject10;
          localObject14 = localObject9;
          localObject15 = localObject7;
          localObject16 = localObject8;
          localObject17 = localObject6;
          localObject18 = localObject5;
          localObject19 = localObject4;
          localObject20 = localObject3;
          localObject21 = localObject1;
          localObject22 = localObject2;
        } while (!paramJSONObject.has(lm));
        localObject23 = paramJSONObject.optJSONArray(lm);
        localObject12 = localObject11;
        localObject13 = localObject10;
        localObject14 = localObject9;
        localObject15 = localObject7;
        localObject16 = localObject8;
        localObject17 = localObject6;
        localObject18 = localObject5;
        localObject19 = localObject4;
        localObject20 = localObject3;
        localObject21 = localObject1;
        localObject22 = localObject2;
      } while (localObject23 == null);
      int n = 0;
      for (;;)
      {
        localObject12 = localObject11;
        localObject13 = localObject10;
        localObject14 = localObject9;
        localObject15 = localObject7;
        localObject16 = localObject8;
        localObject17 = localObject6;
        localObject18 = localObject5;
        localObject19 = localObject4;
        localObject20 = localObject3;
        localObject21 = localObject1;
        localObject22 = localObject2;
        if (n >= ((JSONArray)localObject23).length()) {
          break;
        }
        ((List)localObject2).add(dm.a(((JSONArray)localObject23).getJSONObject(n)));
        n += 1;
      }
    }
    return new de((Integer)localObject11, (String)localObject10, (String)localObject9, (String)localObject7, (String)localObject8, (String)localObject6, (String)localObject5, (di)localObject4, (dg)localObject3, (String)localObject1, (List)localObject2);
  }
  
  public final JSONObject a()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.putOpt(am, b);
      localJSONObject.putOpt(bm, c);
      localJSONObject.putOpt(cm, d);
      localJSONObject.putOpt(dm, e);
      localJSONObject.putOpt(km, k);
      Object localObject;
      if ((g != null) && (f != null))
      {
        localObject = new JSONObject();
        ((JSONObject)localObject).putOpt(em, f);
        ((JSONObject)localObject).putOpt(fm, g);
        localJSONObject.put(gm, localObject);
      }
      if (!StringUtils.isNullOrBlank(h)) {
        localJSONObject.put(hm, h);
      }
      if (i != null) {
        localJSONObject.putOpt(im, i.a());
      }
      if (j != null) {
        localJSONObject.putOpt(jm, j.a());
      }
      Iterator localIterator;
      if ((l != null) && (!l.isEmpty()))
      {
        localObject = new JSONArray();
        localIterator = l.iterator();
      }
      while (localIterator.hasNext())
      {
        ((JSONArray)localObject).put(((dm)localIterator.next()).a());
        continue;
        return localJSONObject;
      }
    }
    catch (JSONException localJSONException)
    {
      AppboyLogger.e(a, "Caught exception creating device Json.", localJSONException);
    }
    localJSONObject.put(lm, localJSONException);
    return localJSONObject;
  }
  
  public final boolean c()
  {
    return a().length() == 0;
  }
}

/* Location:
 * Qualified Name:     bo.app.de
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */