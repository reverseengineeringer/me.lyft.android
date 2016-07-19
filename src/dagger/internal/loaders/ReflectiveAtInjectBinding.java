package dagger.internal.loaders;

import dagger.internal.Binding;
import dagger.internal.Binding.InvalidBindingException;
import dagger.internal.Keys;
import dagger.internal.Linker;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Singleton;

public final class ReflectiveAtInjectBinding<T>
  extends Binding<T>
{
  private final Constructor<T> constructor;
  private final Binding<?>[] fieldBindings;
  private final Field[] fields;
  private final String[] keys;
  private final ClassLoader loader;
  private final Binding<?>[] parameterBindings;
  private final Class<?> supertype;
  private Binding<? super T> supertypeBinding;
  
  private ReflectiveAtInjectBinding(String paramString1, String paramString2, boolean paramBoolean, Class<?> paramClass1, Field[] paramArrayOfField, Constructor<T> paramConstructor, int paramInt, Class<?> paramClass2, String[] paramArrayOfString)
  {
    super(paramString1, paramString2, paramBoolean, paramClass1);
    constructor = paramConstructor;
    fields = paramArrayOfField;
    supertype = paramClass2;
    keys = paramArrayOfString;
    parameterBindings = new Binding[paramInt];
    fieldBindings = new Binding[paramArrayOfField.length];
    loader = paramClass1.getClassLoader();
  }
  
  public static <T> Binding<T> create(Class<T> paramClass, boolean paramBoolean)
  {
    boolean bool = paramClass.isAnnotationPresent(Singleton.class);
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    for (Object localObject1 = paramClass; localObject1 != Object.class; localObject1 = ((Class)localObject1).getSuperclass())
    {
      localObject2 = ((Class)localObject1).getDeclaredFields();
      j = localObject2.length;
      i = 0;
      if (i < j)
      {
        localObject4 = localObject2[i];
        if ((!((Field)localObject4).isAnnotationPresent(Inject.class)) || (Modifier.isStatic(((Field)localObject4).getModifiers()))) {}
        for (;;)
        {
          i += 1;
          break;
          if ((((Field)localObject4).getModifiers() & 0x2) != 0) {
            throw new IllegalStateException("Can't inject private field: " + localObject4);
          }
          ((Field)localObject4).setAccessible(true);
          localArrayList2.add(localObject4);
          localArrayList1.add(Keys.get(((Field)localObject4).getGenericType(), ((Field)localObject4).getAnnotations(), localObject4));
        }
      }
    }
    localObject1 = null;
    Object localObject4 = getConstructorsForType(paramClass);
    int j = localObject4.length;
    int i = 0;
    if (i < j)
    {
      localObject2 = localObject4[i];
      if (!((Constructor)localObject2).isAnnotationPresent(Inject.class)) {}
      for (;;)
      {
        i += 1;
        break;
        if (localObject1 != null) {
          throw new Binding.InvalidBindingException(paramClass.getName(), "has too many injectable constructors");
        }
        localObject1 = localObject2;
      }
    }
    Object localObject2 = localObject1;
    if ((localObject1 != null) || (!localArrayList2.isEmpty())) {}
    try
    {
      localObject2 = paramClass.getDeclaredConstructor(new Class[0]);
      while (localObject2 != null) {
        if ((((Constructor)localObject2).getModifiers() & 0x2) != 0)
        {
          throw new IllegalStateException("Can't inject private constructor: " + localObject2);
          localObject2 = localObject1;
          if (paramBoolean) {
            throw new Binding.InvalidBindingException(paramClass.getName(), "has no injectable members. Do you want to add an injectable constructor?");
          }
        }
        else
        {
          localObject4 = Keys.get(paramClass);
          ((Constructor)localObject2).setAccessible(true);
          localObject5 = ((Constructor)localObject2).getGenericParameterTypes();
          int k = localObject5.length;
          localObject1 = localObject4;
          j = k;
          if (k == 0) {
            break label468;
          }
          Annotation[][] arrayOfAnnotation = ((Constructor)localObject2).getParameterAnnotations();
          i = 0;
          for (;;)
          {
            localObject1 = localObject4;
            j = k;
            if (i >= localObject5.length) {
              break;
            }
            localArrayList1.add(Keys.get(localObject5[i], arrayOfAnnotation[i], localObject2));
            i += 1;
          }
        }
      }
      localObject1 = null;
      j = 0;
      if (bool) {
        throw new IllegalArgumentException("No injectable constructor on @Singleton " + paramClass.getName());
      }
      label468:
      Object localObject5 = paramClass.getSuperclass();
      localObject4 = localObject5;
      if (localObject5 != null) {
        if (!Keys.isPlatformType(((Class)localObject5).getName())) {
          break label559;
        }
      }
      for (localObject4 = null;; localObject4 = localObject5)
      {
        return new ReflectiveAtInjectBinding((String)localObject1, Keys.getMembersKey(paramClass), bool, paramClass, (Field[])localArrayList2.toArray(new Field[localArrayList2.size()]), (Constructor)localObject2, j, (Class)localObject4, (String[])localArrayList1.toArray(new String[localArrayList1.size()]));
        label559:
        localArrayList1.add(Keys.getMembersKey((Class)localObject5));
      }
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      for (;;)
      {
        Object localObject3 = localObject1;
      }
    }
  }
  
  private static <T> Constructor<T>[] getConstructorsForType(Class<T> paramClass)
  {
    return (Constructor[])paramClass.getDeclaredConstructors();
  }
  
  public void attach(Linker paramLinker)
  {
    int i = 0;
    int j = 0;
    while (j < fields.length)
    {
      if (fieldBindings[j] == null) {
        fieldBindings[j] = paramLinker.requestBinding(keys[i], fields[j], loader);
      }
      i += 1;
      j += 1;
    }
    int k = i;
    if (constructor != null)
    {
      j = 0;
      for (;;)
      {
        k = i;
        if (j >= parameterBindings.length) {
          break;
        }
        if (parameterBindings[j] == null) {
          parameterBindings[j] = paramLinker.requestBinding(keys[i], constructor, loader);
        }
        i += 1;
        j += 1;
      }
    }
    if ((supertype != null) && (supertypeBinding == null)) {
      supertypeBinding = paramLinker.requestBinding(keys[k], membersKey, loader, false, true);
    }
  }
  
  public T get()
  {
    if (constructor == null) {
      throw new UnsupportedOperationException();
    }
    Object localObject1 = new Object[parameterBindings.length];
    int i = 0;
    while (i < parameterBindings.length)
    {
      localObject1[i] = parameterBindings[i].get();
      i += 1;
    }
    try
    {
      localObject1 = constructor.newInstance((Object[])localObject1);
      injectMembers(localObject1);
      return (T)localObject1;
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      Object localObject2 = localInvocationTargetException.getCause();
      if ((localObject2 instanceof RuntimeException)) {}
      for (localObject2 = (RuntimeException)localObject2;; localObject2 = new RuntimeException((Throwable)localObject2)) {
        throw ((Throwable)localObject2);
      }
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      throw new AssertionError(localIllegalAccessException);
    }
    catch (InstantiationException localInstantiationException)
    {
      throw new RuntimeException(localInstantiationException);
    }
  }
  
  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    if (parameterBindings != null) {
      Collections.addAll(paramSet1, parameterBindings);
    }
    Collections.addAll(paramSet2, fieldBindings);
    if (supertypeBinding != null) {
      paramSet2.add(supertypeBinding);
    }
  }
  
  public void injectMembers(T paramT)
  {
    int i = 0;
    try
    {
      while (i < fields.length)
      {
        fields[i].set(paramT, fieldBindings[i].get());
        i += 1;
      }
      if (supertypeBinding != null) {
        supertypeBinding.injectMembers(paramT);
      }
      return;
    }
    catch (IllegalAccessException paramT)
    {
      throw new AssertionError(paramT);
    }
  }
  
  public String toString()
  {
    if (provideKey != null) {
      return provideKey;
    }
    return membersKey;
  }
}

/* Location:
 * Qualified Name:     dagger.internal.loaders.ReflectiveAtInjectBinding
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */