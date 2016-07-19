package dagger.internal;

import java.lang.annotation.Annotation;
import javax.inject.Qualifier;

final class Keys$1
  extends Memoizer<Class<? extends Annotation>, Boolean>
{
  protected Boolean create(Class<? extends Annotation> paramClass)
  {
    return Boolean.valueOf(paramClass.isAnnotationPresent(Qualifier.class));
  }
}

/* Location:
 * Qualified Name:     dagger.internal.Keys.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */