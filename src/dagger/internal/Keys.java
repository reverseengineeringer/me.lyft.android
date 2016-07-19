package dagger.internal;

import dagger.Lazy;
import dagger.MembersInjector;
import java.lang.annotation.Annotation;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Set;
import javax.inject.Provider;
import javax.inject.Qualifier;

public final class Keys
{
  private static final Memoizer<Class<? extends Annotation>, Boolean> IS_QUALIFIER_ANNOTATION = new Memoizer()
  {
    protected Boolean create(Class<? extends Annotation> paramAnonymousClass)
    {
      return Boolean.valueOf(paramAnonymousClass.isAnnotationPresent(Qualifier.class));
    }
  };
  private static final String LAZY_PREFIX;
  private static final String MEMBERS_INJECTOR_PREFIX;
  private static final String PROVIDER_PREFIX = Provider.class.getCanonicalName() + "<";
  private static final String SET_PREFIX;
  
  static
  {
    MEMBERS_INJECTOR_PREFIX = MembersInjector.class.getCanonicalName() + "<";
    LAZY_PREFIX = Lazy.class.getCanonicalName() + "<";
    SET_PREFIX = Set.class.getCanonicalName() + "<";
  }
  
  private static Type boxIfPrimitive(Type paramType)
  {
    Object localObject;
    if (paramType == Byte.TYPE) {
      localObject = Byte.class;
    }
    do
    {
      return (Type)localObject;
      if (paramType == Short.TYPE) {
        return Short.class;
      }
      if (paramType == Integer.TYPE) {
        return Integer.class;
      }
      if (paramType == Long.TYPE) {
        return Long.class;
      }
      if (paramType == Character.TYPE) {
        return Character.class;
      }
      if (paramType == Boolean.TYPE) {
        return Boolean.class;
      }
      if (paramType == Float.TYPE) {
        return Float.class;
      }
      if (paramType == Double.TYPE) {
        return Double.class;
      }
      localObject = paramType;
    } while (paramType != Void.TYPE);
    return Void.class;
  }
  
  private static String extractKey(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    return paramString2 + paramString1.substring(paramString3.length() + paramInt, paramString1.length() - 1);
  }
  
  private static Annotation extractQualifier(Annotation[] paramArrayOfAnnotation, Object paramObject)
  {
    Object localObject = null;
    int j = paramArrayOfAnnotation.length;
    int i = 0;
    if (i < j)
    {
      Annotation localAnnotation = paramArrayOfAnnotation[i];
      if (!((Boolean)IS_QUALIFIER_ANNOTATION.get(localAnnotation.annotationType())).booleanValue()) {}
      for (;;)
      {
        i += 1;
        break;
        if (localObject != null) {
          throw new IllegalArgumentException("Too many qualifier annotations on " + paramObject);
        }
        localObject = localAnnotation;
      }
    }
    return (Annotation)localObject;
  }
  
  public static String get(Type paramType)
  {
    return get(paramType, null);
  }
  
  private static String get(Type paramType, Annotation paramAnnotation)
  {
    paramType = boxIfPrimitive(paramType);
    if ((paramAnnotation == null) && ((paramType instanceof Class)) && (!((Class)paramType).isArray())) {
      return ((Class)paramType).getName();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramAnnotation != null) {
      localStringBuilder.append(paramAnnotation).append("/");
    }
    typeToString(paramType, localStringBuilder, true);
    return localStringBuilder.toString();
  }
  
  public static String get(Type paramType, Annotation[] paramArrayOfAnnotation, Object paramObject)
  {
    return get(paramType, extractQualifier(paramArrayOfAnnotation, paramObject));
  }
  
  static String getBuiltInBindingsKey(String paramString)
  {
    int i = startOfType(paramString);
    if (substringStartsWith(paramString, i, PROVIDER_PREFIX)) {
      return extractKey(paramString, i, paramString.substring(0, i), PROVIDER_PREFIX);
    }
    if (substringStartsWith(paramString, i, MEMBERS_INJECTOR_PREFIX)) {
      return extractKey(paramString, i, "members/", MEMBERS_INJECTOR_PREFIX);
    }
    return null;
  }
  
  public static String getClassName(String paramString)
  {
    int i = 0;
    if ((paramString.startsWith("@")) || (paramString.startsWith("members/"))) {
      i = paramString.lastIndexOf('/') + 1;
    }
    if ((paramString.indexOf('<', i) == -1) && (paramString.indexOf('[', i) == -1)) {
      return paramString.substring(i);
    }
    return null;
  }
  
  static String getLazyKey(String paramString)
  {
    int i = startOfType(paramString);
    if (substringStartsWith(paramString, i, LAZY_PREFIX)) {
      return extractKey(paramString, i, paramString.substring(0, i), LAZY_PREFIX);
    }
    return null;
  }
  
  public static String getMembersKey(Class<?> paramClass)
  {
    return "members/".concat(paramClass.getName());
  }
  
  public static String getSetKey(Type paramType, Annotation[] paramArrayOfAnnotation, Object paramObject)
  {
    paramArrayOfAnnotation = extractQualifier(paramArrayOfAnnotation, paramObject);
    paramType = boxIfPrimitive(paramType);
    paramObject = new StringBuilder();
    if (paramArrayOfAnnotation != null) {
      ((StringBuilder)paramObject).append(paramArrayOfAnnotation).append("/");
    }
    ((StringBuilder)paramObject).append(SET_PREFIX);
    typeToString(paramType, (StringBuilder)paramObject, true);
    ((StringBuilder)paramObject).append(">");
    return ((StringBuilder)paramObject).toString();
  }
  
  public static boolean isAnnotated(String paramString)
  {
    return paramString.startsWith("@");
  }
  
  public static boolean isPlatformType(String paramString)
  {
    return (paramString.startsWith("java.")) || (paramString.startsWith("javax.")) || (paramString.startsWith("android."));
  }
  
  private static int startOfType(String paramString)
  {
    if (paramString.startsWith("@")) {
      return paramString.lastIndexOf('/') + 1;
    }
    return 0;
  }
  
  private static boolean substringStartsWith(String paramString1, int paramInt, String paramString2)
  {
    return paramString1.regionMatches(paramInt, paramString2, 0, paramString2.length());
  }
  
  private static void typeToString(Type paramType, StringBuilder paramStringBuilder, boolean paramBoolean)
  {
    if ((paramType instanceof Class))
    {
      paramType = (Class)paramType;
      if (paramType.isArray())
      {
        typeToString(paramType.getComponentType(), paramStringBuilder, false);
        paramStringBuilder.append("[]");
        return;
      }
      if (paramType.isPrimitive())
      {
        if (paramBoolean) {
          throw new UnsupportedOperationException("Uninjectable type " + paramType.getName());
        }
        paramStringBuilder.append(paramType.getName());
        return;
      }
      paramStringBuilder.append(paramType.getName());
      return;
    }
    if ((paramType instanceof ParameterizedType))
    {
      paramType = (ParameterizedType)paramType;
      typeToString(paramType.getRawType(), paramStringBuilder, true);
      paramType = paramType.getActualTypeArguments();
      paramStringBuilder.append("<");
      int i = 0;
      while (i < paramType.length)
      {
        if (i != 0) {
          paramStringBuilder.append(", ");
        }
        typeToString(paramType[i], paramStringBuilder, true);
        i += 1;
      }
      paramStringBuilder.append(">");
      return;
    }
    if ((paramType instanceof GenericArrayType))
    {
      typeToString(((GenericArrayType)paramType).getGenericComponentType(), paramStringBuilder, false);
      paramStringBuilder.append("[]");
      return;
    }
    throw new UnsupportedOperationException("Uninjectable type " + paramType);
  }
}

/* Location:
 * Qualified Name:     dagger.internal.Keys
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */