package com.paypal.android.sdk;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

public class at
  extends bf
{
  private static final String a = at.class.getSimpleName();
  private static Map b;
  private static Set c;
  private au d;
  
  static
  {
    Object localObject = new HashMap();
    b = (Map)localObject;
    ((Map)localObject).put("c14", "erpg");
    b.put("c25", "page");
    b.put("c26", "link");
    b.put("c27", "pgln");
    b.put("c29", "eccd");
    b.put("c35", "lgin");
    b.put("vers", "vers");
    b.put("c50", "rsta");
    b.put("gn", "pgrp");
    b.put("v49", "mapv");
    b.put("v51", "mcar");
    b.put("v52", "mosv");
    b.put("v53", "mdvs");
    b.put("clid", "clid");
    b.put("apid", "apid");
    b.put("calc", "calc");
    b.put("e", "e");
    b.put("t", "t");
    b.put("g", "g");
    b.put("srce", "srce");
    b.put("vid", "vid");
    b.put("bchn", "bchn");
    b.put("adte", "adte");
    b.put("sv", "sv");
    b.put("dsid", "dsid");
    b.put("bzsr", "bzsr");
    b.put("prid", "prid");
    localObject = new HashSet();
    c = (Set)localObject;
    ((Set)localObject).add("v25");
    c.add("v31");
    c.add("c37");
  }
  
  public at(be parambe, bh parambh, c paramc, String paramString, au paramau)
  {
    super(parambe, parambh, paramc, paramString);
    d = paramau;
    a("Accept", "application/json; charset=utf-8");
    a("Accept-Language", "en_US");
    a("Content-Type", "application/json");
  }
  
  private JSONObject a(Map paramMap)
  {
    JSONObject localJSONObject = new JSONObject();
    Iterator localIterator = paramMap.keySet().iterator();
    label84:
    label107:
    label158:
    while (localIterator.hasNext())
    {
      String str2 = (String)localIterator.next();
      if (!R.b(str2))
      {
        if (!c.contains(str2)) {
          break label107;
        }
        new StringBuilder("SC key ").append(str2).append(" not used in FPTI, skipping");
      }
      for (String str1 = null;; str1 = (String)b.get(str2))
      {
        if (str1 == null) {
          break label158;
        }
        localJSONObject.accumulate(str1, paramMap.get(str2));
        break;
        if (!b.containsKey(str2))
        {
          new StringBuilder("No mapping for SC key ").append(str2).append(", skipping");
          break label84;
        }
      }
    }
    return localJSONObject;
  }
  
  public final String a(be parambe)
  {
    return "https://api.paypal.com/v1/tracking/events";
  }
  
  public final boolean a()
  {
    return true;
  }
  
  public final String b()
  {
    Object localObject1 = R.a(t().d().e());
    String str = d.a;
    Object localObject2 = new JSONObject();
    ((JSONObject)localObject2).accumulate("tracking_visitor_id", localObject1);
    ((JSONObject)localObject2).accumulate("tracking_visit_id", str);
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.accumulate("actor", localObject2);
    localJSONObject.accumulate("channel", "mobile");
    localObject2 = Long.toString(System.currentTimeMillis());
    localJSONObject.accumulate("tracking_event", localObject2);
    d.b.put("t", localObject2);
    d.b.put("dsid", localObject1);
    d.b.put("vid", str);
    localJSONObject.accumulate("event_params", a(d.b));
    localObject1 = new JSONObject();
    ((JSONObject)localObject1).accumulate("events", localJSONObject);
    return ((JSONObject)localObject1).toString();
  }
  
  public final void c() {}
  
  public final void d() {}
  
  public final String e()
  {
    return "mockResponse";
  }
}

/* Location:
 * Qualified Name:     com.paypal.android.sdk.at
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */