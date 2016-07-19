package com.google.gson.internal;

import java.io.Serializable;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;

final class $Gson$Types$ParameterizedTypeImpl
  implements Serializable, ParameterizedType
{
  private static final long serialVersionUID = 0L;
  private final Type ownerType;
  private final Type rawType;
  private final Type[] typeArguments;
  
  public $Gson$Types$ParameterizedTypeImpl(Type paramType1, Type paramType2, Type... paramVarArgs)
  {
    int i;
    if ((paramType2 instanceof Class))
    {
      Class localClass = (Class)paramType2;
      if ((Modifier.isStatic(localClass.getModifiers())) || (localClass.getEnclosingClass() == null))
      {
        i = 1;
        if ((paramType1 != null) || (i != 0)) {
          bool = true;
        }
        .Gson.Preconditions.checkArgument(bool);
      }
    }
    else
    {
      if (paramType1 != null) {
        break label155;
      }
    }
    label155:
    for (paramType1 = null;; paramType1 = .Gson.Types.canonicalize(paramType1))
    {
      ownerType = paramType1;
      rawType = .Gson.Types.canonicalize(paramType2);
      typeArguments = ((Type[])paramVarArgs.clone());
      i = 0;
      while (i < typeArguments.length)
      {
        .Gson.Preconditions.checkNotNull(typeArguments[i]);
        .Gson.Types.checkNotPrimitive(typeArguments[i]);
        typeArguments[i] = .Gson.Types.canonicalize(typeArguments[i]);
        i += 1;
      }
      i = 0;
      break;
    }
  }
  
  public boolean equals(Object paramObject)
  {
    return ((paramObject instanceof ParameterizedType)) && (.Gson.Types.equals(this, (ParameterizedType)paramObject));
  }
  
  public Type[] getActualTypeArguments()
  {
    return (Type[])typeArguments.clone();
  }
  
  public Type getOwnerType()
  {
    return ownerType;
  }
  
  public Type getRawType()
  {
    return rawType;
  }
  
  public int hashCode()
  {
    return Arrays.hashCode(typeArguments) ^ rawType.hashCode() ^ .Gson.Types.hashCodeOrZero(ownerType);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder((typeArguments.length + 1) * 30);
    localStringBuilder.append(.Gson.Types.typeToString(rawType));
    if (typeArguments.length == 0) {
      return localStringBuilder.toString();
    }
    localStringBuilder.append("<").append(.Gson.Types.typeToString(typeArguments[0]));
    int i = 1;
    while (i < typeArguments.length)
    {
      localStringBuilder.append(", ").append(.Gson.Types.typeToString(typeArguments[i]));
      i += 1;
    }
    return ">";
  }
}

/* Location:
 * Qualified Name:     com.google.gson.internal..Gson.Types.ParameterizedTypeImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */