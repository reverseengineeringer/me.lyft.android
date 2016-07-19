package com.threatmetrix.TrustDefenderMobile;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;

class HttpParameterMap
  extends HashMap<String, String>
{
  private static final String TAG = StringUtils.getLogTag(HttpParameterMap.class);
  private HashMap<String, Integer> m_keySpecificLength = new HashMap();
  private int m_postValueLengthLimit = 0;
  
  public HttpParameterMap add(String paramString1, String paramString2)
  {
    add(paramString1, paramString2, false);
    return this;
  }
  
  public HttpParameterMap add(String paramString1, String paramString2, Integer paramInteger)
  {
    m_keySpecificLength.put(paramString1, paramInteger);
    add(paramString1, paramString2, false);
    return this;
  }
  
  public HttpParameterMap add(String paramString1, String paramString2, boolean paramBoolean)
  {
    if ((paramBoolean) && (paramString2 != null) && (!paramString2.isEmpty()))
    {
      put(paramString1, paramString2.toLowerCase(Locale.US));
      return this;
    }
    put(paramString1, paramString2);
    return this;
  }
  
  public Integer getKeySpecificLength(String paramString)
  {
    return (Integer)m_keySpecificLength.get(paramString);
  }
  
  public int getPostValueLengthLimit()
  {
    return m_postValueLengthLimit;
  }
  
  public String getUrlEncodedParamString()
    throws InterruptedException
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject1 = (String)localIterator.next();
      Object localObject2 = (String)get(localObject1);
      if ((localObject2 != null) && (!((String)localObject2).isEmpty()))
      {
        if (localStringBuilder.length() > 0) {
          localStringBuilder.append("&");
        }
        localStringBuilder.append((String)localObject1);
        Integer localInteger = (Integer)m_keySpecificLength.get(localObject1);
        localObject1 = localObject2;
        if (localInteger != null)
        {
          localObject1 = localObject2;
          if (((String)localObject2).length() > localInteger.intValue()) {
            localObject1 = ((String)localObject2).substring(0, localInteger.intValue());
          }
        }
        localObject2 = localObject1;
        if (localInteger == null)
        {
          localObject2 = localObject1;
          if (m_postValueLengthLimit != 0)
          {
            localObject2 = localObject1;
            if (((String)localObject1).length() > m_postValueLengthLimit) {
              localObject2 = ((String)localObject1).substring(0, m_postValueLengthLimit);
            }
          }
        }
        localStringBuilder.append("=");
        localStringBuilder.append(StringUtils.urlEncode((String)localObject2));
      }
    }
    return localStringBuilder.toString();
  }
  
  public void setPostValueLengthLimit(int paramInt)
  {
    m_postValueLengthLimit = paramInt;
  }
}

/* Location:
 * Qualified Name:     com.threatmetrix.TrustDefenderMobile.HttpParameterMap
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */