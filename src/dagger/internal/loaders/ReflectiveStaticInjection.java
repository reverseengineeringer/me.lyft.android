package dagger.internal.loaders;

import dagger.internal.Binding;
import dagger.internal.Keys;
import dagger.internal.Linker;
import dagger.internal.StaticInjection;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

public final class ReflectiveStaticInjection
  extends StaticInjection
{
  private Binding<?>[] bindings;
  private final Field[] fields;
  private final ClassLoader loader;
  
  private ReflectiveStaticInjection(ClassLoader paramClassLoader, Field[] paramArrayOfField)
  {
    fields = paramArrayOfField;
    loader = paramClassLoader;
  }
  
  public static StaticInjection create(Class<?> paramClass)
  {
    ArrayList localArrayList = new ArrayList();
    Field[] arrayOfField = paramClass.getDeclaredFields();
    int j = arrayOfField.length;
    int i = 0;
    while (i < j)
    {
      Field localField = arrayOfField[i];
      if ((Modifier.isStatic(localField.getModifiers())) && (localField.isAnnotationPresent(Inject.class)))
      {
        localField.setAccessible(true);
        localArrayList.add(localField);
      }
      i += 1;
    }
    if (localArrayList.isEmpty()) {
      throw new IllegalArgumentException("No static injections: " + paramClass.getName());
    }
    return new ReflectiveStaticInjection(paramClass.getClassLoader(), (Field[])localArrayList.toArray(new Field[localArrayList.size()]));
  }
  
  public void attach(Linker paramLinker)
  {
    bindings = new Binding[fields.length];
    int i = 0;
    while (i < fields.length)
    {
      Field localField = fields[i];
      String str = Keys.get(localField.getGenericType(), localField.getAnnotations(), localField);
      bindings[i] = paramLinker.requestBinding(str, localField, loader);
      i += 1;
    }
  }
  
  public void inject()
  {
    int i = 0;
    try
    {
      while (i < fields.length)
      {
        fields[i].set(null, bindings[i].get());
        i += 1;
      }
      return;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      throw new AssertionError(localIllegalAccessException);
    }
  }
}

/* Location:
 * Qualified Name:     dagger.internal.loaders.ReflectiveStaticInjection
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */