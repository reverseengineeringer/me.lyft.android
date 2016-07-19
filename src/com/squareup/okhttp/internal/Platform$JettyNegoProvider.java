package com.squareup.okhttp.internal;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.List;

class Platform$JettyNegoProvider
  implements InvocationHandler
{
  private final List<String> protocols;
  private String selected;
  private boolean unsupported;
  
  public Platform$JettyNegoProvider(List<String> paramList)
  {
    protocols = paramList;
  }
  
  public Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
    throws Throwable
  {
    String str = paramMethod.getName();
    Class localClass = paramMethod.getReturnType();
    paramObject = paramArrayOfObject;
    if (paramArrayOfObject == null) {
      paramObject = Util.EMPTY_STRING_ARRAY;
    }
    if ((str.equals("supports")) && (Boolean.TYPE == localClass)) {
      return Boolean.valueOf(true);
    }
    if ((str.equals("unsupported")) && (Void.TYPE == localClass))
    {
      unsupported = true;
      return null;
    }
    if ((str.equals("protocols")) && (paramObject.length == 0)) {
      return protocols;
    }
    if (((str.equals("selectProtocol")) || (str.equals("select"))) && (String.class == localClass) && (paramObject.length == 1) && ((paramObject[0] instanceof List)))
    {
      paramObject = (List)paramObject[0];
      int i = 0;
      int j = ((List)paramObject).size();
      while (i < j)
      {
        if (protocols.contains(((List)paramObject).get(i)))
        {
          paramObject = (String)((List)paramObject).get(i);
          selected = ((String)paramObject);
          return paramObject;
        }
        i += 1;
      }
      paramObject = (String)protocols.get(0);
      selected = ((String)paramObject);
      return paramObject;
    }
    if (((str.equals("protocolSelected")) || (str.equals("selected"))) && (paramObject.length == 1))
    {
      selected = ((String)paramObject[0]);
      return null;
    }
    return paramMethod.invoke(this, (Object[])paramObject);
  }
}

/* Location:
 * Qualified Name:     com.squareup.okhttp.internal.Platform.JettyNegoProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */