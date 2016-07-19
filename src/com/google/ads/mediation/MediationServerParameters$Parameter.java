package com.google.ads.mediation;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({java.lang.annotation.ElementType.FIELD})
public @interface MediationServerParameters$Parameter
{
  String name();
  
  boolean required() default true;
}

/* Location:
 * Qualified Name:     com.google.ads.mediation.MediationServerParameters.Parameter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */