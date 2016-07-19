package me.lyft.android.common;

import java.lang.annotation.Annotation;

public final class ObjectUtils
{
  public static <T extends Annotation> boolean hasAnnotation(Object paramObject, Class<T> paramClass)
  {
    return paramObject.getClass().getAnnotation(paramClass) != null;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.common.ObjectUtils
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */