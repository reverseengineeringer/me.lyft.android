package bo.app;

import java.util.HashMap;
import java.util.Map;

public enum am
{
  private static final Map<String, am> y;
  
  static
  {
    int i1 = 0;
    a = new am("CUSTOM_EVENT", 0);
    b = new am("LOG_PURCHASE", 1);
    c = new am("LOG_PUSH_NOTIFICATION_OPENED", 2);
    d = new am("SUBMIT_FEEDBACK", 3);
    e = new am("ADD_TO_CUSTOM_ATTRIBUTE_ARRAY", 4);
    f = new am("INCREMENT_CUSTOM_ATTRIBUTE", 5);
    g = new am("REMOVE_FROM_CUSTOM_ATTRIBUTE_ARRAY", 6);
    h = new am("SET_CUSTOM_ATTRIBUTE_ARRAY", 7);
    i = new am("SET_CUSTOM_ATTRIBUTE", 8);
    j = new am("UNSET_CUSTOM_ATTRIBUTE", 9);
    k = new am("SET_CUSTOM_ATTRIBUTE_TO_NOW", 10);
    l = new am("SET_CUSTOM_ATTRIBUTE_TO_SECONDS_FROM_EPOCH", 11);
    m = new am("SET_LAST_KNOWN_LOCATION", 12);
    n = new am("SET_AVATAR_IMAGE_URL", 13);
    o = new am("SET_COUNTRY", 14);
    p = new am("SET_DATE_OF_BIRTH", 15);
    q = new am("SET_EMAIL", 16);
    r = new am("SET_FIRST_NAME", 17);
    s = new am("SET_GENDER", 18);
    t = new am("SET_HOME_CITY", 19);
    u = new am("SET_LAST_NAME", 20);
    v = new am("SET_PHONE_NUMBER", 21);
    w = new am("SEND_WEAR_DEVICE", 22);
    x = new am("UNSUPPORTED_SDK_ACTION", 23);
    z = new am[] { a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x };
    y = new HashMap();
    am[] arrayOfam = values();
    int i2 = arrayOfam.length;
    while (i1 < i2)
    {
      am localam = arrayOfam[i1];
      y.put(localam.name(), localam);
      i1 += 1;
    }
  }
  
  private am() {}
  
  public static am a(String paramString)
  {
    if (!y.containsKey(paramString)) {
      return x;
    }
    return (am)y.get(paramString);
  }
}

/* Location:
 * Qualified Name:     bo.app.am
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */