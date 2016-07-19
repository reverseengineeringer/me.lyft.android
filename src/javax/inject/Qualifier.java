package javax.inject;

import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({java.lang.annotation.ElementType.ANNOTATION_TYPE})
public @interface Qualifier {}

/* Location:
 * Qualified Name:     javax.inject.Qualifier
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */