package bo.app;

import com.appboy.models.IPutIntoJson;
import java.util.HashMap;
import java.util.Map;

public enum ad
  implements IPutIntoJson<String>
{
  private static final Map<String, ad> t;
  public final String s;
  
  static
  {
    int i1 = 0;
    a = new ad("LOCATION_RECORDED", 0, "lr");
    b = new ad("CUSTOM_EVENT", 1, "ce");
    c = new ad("PURCHASE", 2, "p");
    d = new ad("PUSH_NOTIFICATION_TRACKING", 3, "pc");
    e = new ad("PUSH_NOTIFICATION_ACTION_TRACKING", 4, "ca");
    f = new ad("INTERNAL", 5, "i");
    g = new ad("INTERNAL_ERROR", 6, "ie");
    h = new ad("CARD_IMPRESSION", 7, "ci");
    i = new ad("CARD_CLICK", 8, "cc");
    j = new ad("USER_TRANSITION", 9, "ut");
    k = new ad("INCREMENT", 10, "inc");
    l = new ad("ADD_TO_CUSTOM_ATTRIBUTE_ARRAY", 11, "add");
    m = new ad("REMOVE_FROM_CUSTOM_ATTRIBUTE_ARRAY", 12, "rem");
    n = new ad("SET_CUSTOM_ATTRIBUTE_ARRAY", 13, "set");
    o = new ad("INAPP_MESSAGE_IMPRESSION", 14, "si");
    p = new ad("INAPP_MESSAGE_CONTROL_IMPRESSION", 15, "iec");
    q = new ad("INAPP_MESSAGE_CLICK", 16, "sc");
    r = new ad("INAPP_MESSAGE_BUTTON_CLICK", 17, "sbc");
    u = new ad[] { a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r };
    HashMap localHashMap = new HashMap();
    ad[] arrayOfad = values();
    int i2 = arrayOfad.length;
    while (i1 < i2)
    {
      ad localad = arrayOfad[i1];
      localHashMap.put(s, localad);
      i1 += 1;
    }
    t = new HashMap(localHashMap);
  }
  
  private ad(String paramString)
  {
    s = paramString;
  }
  
  public static ad a(String paramString)
  {
    if (!t.containsKey(paramString)) {
      throw new IllegalArgumentException("Unknown String Value: " + paramString);
    }
    return (ad)t.get(paramString);
  }
}

/* Location:
 * Qualified Name:     bo.app.ad
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */