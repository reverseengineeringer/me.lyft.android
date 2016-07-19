package com.squareup.okhttp.internal;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class OptionalMethod<T>
{
  private final String methodName;
  private final Class[] methodParams;
  private final Class<?> returnType;
  
  public OptionalMethod(Class<?> paramClass, String paramString, Class... paramVarArgs)
  {
    returnType = paramClass;
    methodName = paramString;
    methodParams = paramVarArgs;
  }
  
  private Method getMethod(Class<?> paramClass)
  {
    Class<?> localClass = null;
    if (methodName != null)
    {
      paramClass = getPublicMethod(paramClass, methodName, methodParams);
      localClass = paramClass;
      if (paramClass != null)
      {
        localClass = paramClass;
        if (returnType != null)
        {
          localClass = paramClass;
          if (!returnType.isAssignableFrom(paramClass.getReturnType())) {
            localClass = null;
          }
        }
      }
    }
    return localClass;
  }
  
  private static Method getPublicMethod(Class<?> paramClass, String paramString, Class[] paramArrayOfClass)
  {
    Class<?> localClass = null;
    try
    {
      paramClass = paramClass.getMethod(paramString, paramArrayOfClass);
      localClass = paramClass;
      int i = paramClass.getModifiers();
      if ((i & 0x1) == 0) {
        paramClass = null;
      }
      return paramClass;
    }
    catch (NoSuchMethodException paramClass) {}
    return localClass;
  }
  
  public Object invoke(T paramT, Object... paramVarArgs)
    throws InvocationTargetException
  {
    Method localMethod = getMethod(paramT.getClass());
    if (localMethod == null) {
      throw new AssertionError("Method " + methodName + " not supported for object " + paramT);
    }
    try
    {
      paramT = localMethod.invoke(paramT, paramVarArgs);
      return paramT;
    }
    catch (IllegalAccessException paramT)
    {
      paramVarArgs = new AssertionError("Unexpectedly could not call: " + localMethod);
      paramVarArgs.initCause(paramT);
      throw paramVarArgs;
    }
  }
  
  public Object invokeOptional(T paramT, Object... paramVarArgs)
    throws InvocationTargetException
  {
    Method localMethod = getMethod(paramT.getClass());
    if (localMethod == null) {
      return null;
    }
    try
    {
      paramT = localMethod.invoke(paramT, paramVarArgs);
      return paramT;
    }
    catch (IllegalAccessException paramT) {}
    return null;
  }
  
  public Object invokeOptionalWithoutCheckedException(T paramT, Object... paramVarArgs)
  {
    try
    {
      paramT = invokeOptional(paramT, paramVarArgs);
      return paramT;
    }
    catch (InvocationTargetException paramT)
    {
      paramT = paramT.getTargetException();
      if ((paramT instanceof RuntimeException)) {
        throw ((RuntimeException)paramT);
      }
      paramVarArgs = new AssertionError("Unexpected exception");
      paramVarArgs.initCause(paramT);
      throw paramVarArgs;
    }
  }
  
  public Object invokeWithoutCheckedException(T paramT, Object... paramVarArgs)
  {
    try
    {
      paramT = invoke(paramT, paramVarArgs);
      return paramT;
    }
    catch (InvocationTargetException paramT)
    {
      paramT = paramT.getTargetException();
      if ((paramT instanceof RuntimeException)) {
        throw ((RuntimeException)paramT);
      }
      paramVarArgs = new AssertionError("Unexpected exception");
      paramVarArgs.initCause(paramT);
      throw paramVarArgs;
    }
  }
  
  public boolean isSupported(T paramT)
  {
    return getMethod(paramT.getClass()) != null;
  }
}

/* Location:
 * Qualified Name:     com.squareup.okhttp.internal.OptionalMethod
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */