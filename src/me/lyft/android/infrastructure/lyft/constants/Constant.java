package me.lyft.android.infrastructure.lyft.constants;

import me.lyft.android.logging.L;

public class Constant<T>
{
  private final Class<T> clazz;
  private final T defaultValue;
  private final String key;
  
  Constant(String paramString, Class<T> paramClass, T paramT)
  {
    clazz = paramClass;
    key = paramString;
    defaultValue = paramT;
  }
  
  @Deprecated
  Constant(String paramString, T paramT)
  {
    this(paramString, paramT.getClass(), paramT);
  }
  
  public T getDefaultValue()
  {
    return (T)defaultValue;
  }
  
  public String getKey()
  {
    return key;
  }
  
  public T safeCast(Object paramObject)
  {
    if (paramObject != null) {
      try
      {
        Object localObject1 = clazz.cast(paramObject);
        return (T)localObject1;
      }
      catch (ClassCastException localClassCastException1)
      {
        try
        {
          Object localObject2;
          if ((paramObject instanceof Number))
          {
            localObject2 = (Number)paramObject;
            if (clazz == Long.class) {
              return (T)clazz.cast(Long.valueOf(((Number)localObject2).longValue()));
            }
            if (clazz == Double.class) {
              return (T)clazz.cast(Double.valueOf(((Number)localObject2).doubleValue()));
            }
            if (clazz == Integer.class) {
              return (T)clazz.cast(Integer.valueOf(((Number)localObject2).intValue()));
            }
            if (clazz == Float.class) {
              return (T)clazz.cast(Float.valueOf(((Number)localObject2).floatValue()));
            }
          }
          else if (((paramObject instanceof String)) && (clazz.equals(Boolean.class)))
          {
            localObject2 = clazz.cast(Boolean.valueOf(((String)paramObject).toLowerCase().equals("true")));
            return (T)localObject2;
          }
        }
        catch (ClassCastException localClassCastException2)
        {
          L.e(localClassCastException1, "Wrong type (" + paramObject.getClass() + ") received for constant (" + key + ")", new Object[0]);
        }
      }
    }
    return null;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.lyft.constants.Constant
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */