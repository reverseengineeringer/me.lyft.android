package com.leanplum.annotations;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({java.lang.annotation.ElementType.FIELD})
public @interface Variable
{
  String group() default "";
  
  String name() default "";
}

/* Location:
 * Qualified Name:     com.leanplum.annotations.Variable
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */