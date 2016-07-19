package com.lyft.scoop;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({java.lang.annotation.ElementType.TYPE})
public @interface Controller
{
  Class<? extends ViewController> value();
}

/* Location:
 * Qualified Name:     com.lyft.scoop.Controller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */