package io.fabric.sdk.android.services.concurrency;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface DependsOn
{
  Class<?>[] value();
}

/* Location:
 * Qualified Name:     io.fabric.sdk.android.services.concurrency.DependsOn
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */