package dagger;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({java.lang.annotation.ElementType.TYPE})
public @interface Module
{
  Class<?> addsTo() default Void.class;
  
  boolean complete() default true;
  
  Class<?>[] includes() default {};
  
  Class<?>[] injects() default {};
  
  boolean library() default false;
  
  boolean overrides() default false;
  
  Class<?>[] staticInjections() default {};
}

/* Location:
 * Qualified Name:     dagger.Module
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */