package com.lyft.scoop;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({java.lang.annotation.ElementType.TYPE})
public @interface ExitTransition
{
  Class<? extends ScreenTransition> value();
}

/* Location:
 * Qualified Name:     com.lyft.scoop.ExitTransition
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */