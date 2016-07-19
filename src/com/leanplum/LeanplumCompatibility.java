package com.leanplum;

import android.text.TextUtils;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LeanplumCompatibility
{
  public static final String CAMPAIGN_CONTENT = "&cc";
  public static final String CAMPAIGN_MEDUIM = "&cm";
  public static final String CAMPAIGN_NAME = "&cn";
  public static final String CAMPAIGN_SOURCE = "&cs";
  public static final String EVENT_ACTION = "&ea";
  public static final String EVENT_CATEGORY = "&ec";
  public static final String EVENT_LABEL = "&el";
  public static final String EVENT_VALUE = "&ev";
  public static final String EXCEPTION_DESCRIPTION = "&exd";
  public static final String ITEM_CATEGORY = "&iv";
  public static final String ITEM_NAME = "&in";
  public static final String SOCIAL_ACTION = "&sa";
  public static final String SOCIAL_NETWORK = "&sn";
  public static final String SOCIAL_TARGET = "&st";
  public static final String TIMING_CATEGORY = "&utc";
  public static final String TIMING_LABEL = "&utl";
  public static final String TIMING_NAME = "&utv";
  public static final String TIMING_VALUE = "&utt";
  public static final String TRANSACTION_AFFILIATION = "&ta";
  public static final String TYPE = "&t";
  
  private static String a(HashMap<String, String> paramHashMap, List<String> paramList)
  {
    LinkedList localLinkedList = new LinkedList();
    paramList = paramList.iterator();
    for (;;)
    {
      if (!paramList.hasNext()) {
        return TextUtils.join(" ", localLinkedList);
      }
      String str = (String)paramList.next();
      if (paramHashMap.get(str) != null)
      {
        localLinkedList.add((String)paramHashMap.get(str));
        paramHashMap.remove(str);
      }
    }
  }
  
  public static void fTrack(String paramString)
  {
    Leanplum.track(paramString);
  }
  
  public static void fTrack(String paramString1, String paramString2, String paramString3)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("errorMessage", paramString2);
    localHashMap.put("errorClass", paramString3);
    Leanplum.track(paramString1 + " error", 0.0D, "", localHashMap);
  }
  
  public static void fTrack(String paramString, HashMap<String, ?> paramHashMap)
  {
    Leanplum.track(paramString, paramHashMap);
  }
  
  public static void fTrack(String paramString, HashMap<String, ?> paramHashMap, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      Leanplum.track(paramString + " begin", 0.0D, "", paramHashMap);
      return;
    }
    Leanplum.track(paramString, 0.0D, "", paramHashMap);
  }
  
  public static void fTrack(String paramString, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      Leanplum.track(paramString + " begin", 0.0D, "", new HashMap());
      return;
    }
    Leanplum.track(paramString, 0.0D, "", new HashMap());
  }
  
  public static void gaTrack(Map<String, String> paramMap)
  {
    HashMap localHashMap = new HashMap(paramMap);
    String str2;
    Object localObject;
    String str1;
    if ((localHashMap.get("&ec") != null) || (localHashMap.get("&ea") != null) || (localHashMap.get("&el") != null))
    {
      str2 = a(localHashMap, Arrays.asList(new String[] { "&ec", "&ea", "&el" }));
      localObject = (String)localHashMap.get("&ev");
      paramMap = (Map<String, String>)localObject;
      str1 = str2;
      if (localObject == null) {
        break label500;
      }
      localHashMap.remove("&ev");
      str1 = str2;
      paramMap = (Map<String, String>)localObject;
    }
    label493:
    label500:
    for (;;)
    {
      localObject = localHashMap.keySet().iterator();
      for (;;)
      {
        if (!((Iterator)localObject).hasNext())
        {
          if (paramMap == null) {
            break label493;
          }
          Leanplum.track(str1, Double.parseDouble(paramMap), localHashMap);
          do
          {
            return;
            if (localHashMap.get("&exd") != null)
            {
              str1 = a(localHashMap, Arrays.asList(new String[] { "&exd", "&t" }));
              paramMap = null;
              break;
            }
            if (localHashMap.get("&ta") != null)
            {
              str1 = a(localHashMap, Arrays.asList(new String[] { "&ta", "&t" }));
              paramMap = null;
              break;
            }
            if ((localHashMap.get("&iv") != null) || (localHashMap.get("&in") != null))
            {
              str1 = a(localHashMap, Arrays.asList(new String[] { "&iv", "&in", "&t" }));
              paramMap = null;
              break;
            }
            if ((localHashMap.get("&sn") != null) || (localHashMap.get("&sa") != null) || (localHashMap.get("&st") != null))
            {
              str1 = a(localHashMap, Arrays.asList(new String[] { "&sn", "&sa", "&st" }));
              paramMap = null;
              break;
            }
            if ((localHashMap.get("&utc") != null) || (localHashMap.get("&utv") != null) || (localHashMap.get("&utl") != null))
            {
              str2 = a(localHashMap, Arrays.asList(new String[] { "&utc", "&utv", "&utl", "&t" }));
              localObject = (String)localHashMap.get("&utt");
              paramMap = (Map<String, String>)localObject;
              str1 = str2;
              if (localObject == null) {
                break label500;
              }
              localHashMap.remove("&utt");
              str1 = str2;
              paramMap = (Map<String, String>)localObject;
              break;
            }
          } while ((localHashMap.get("&cm") != null) || (localHashMap.get("&cc") != null) || (localHashMap.get("&cn") != null) || (localHashMap.get("&cs") == null));
          return;
        }
        str2 = (String)((Iterator)localObject).next();
        if (localHashMap.get(str2) == null) {
          localHashMap.remove(str2);
        }
      }
      Leanplum.track(str1, localHashMap);
      return;
    }
  }
}

/* Location:
 * Qualified Name:     com.leanplum.LeanplumCompatibility
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */