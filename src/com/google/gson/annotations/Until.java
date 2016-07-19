package com.google.gson.annotations;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({java.lang.annotation.ElementType.FIELD, java.lang.annotation.ElementType.TYPE})
public @interface Until
{
  double value();
}

/* Location:
 * Qualified Name:     com.google.gson.annotations.Until
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */