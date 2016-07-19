package com.google.ads.mediation;

import com.google.android.gms.ads.internal.util.client.zzb;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

@Deprecated
public abstract class MediationServerParameters
{
  public void load(Map<String, String> paramMap)
    throws MediationServerParameters.MappingException
  {
    Object localObject1 = new HashMap();
    Object localObject2 = getClass().getFields();
    int j = localObject2.length;
    int i = 0;
    Object localObject3;
    while (i < j)
    {
      localObject3 = localObject2[i];
      Parameter localParameter = (Parameter)((Field)localObject3).getAnnotation(Parameter.class);
      if (localParameter != null) {
        ((Map)localObject1).put(localParameter.name(), localObject3);
      }
      i += 1;
    }
    if (((Map)localObject1).isEmpty()) {
      zzb.zzcy("No server options fields detected. To suppress this message either add a field with the @Parameter annotation, or override the load() method.");
    }
    paramMap = paramMap.entrySet().iterator();
    Object localObject4;
    while (paramMap.hasNext())
    {
      localObject2 = (Map.Entry)paramMap.next();
      localObject3 = (Field)((Map)localObject1).remove(((Map.Entry)localObject2).getKey());
      if (localObject3 != null)
      {
        try
        {
          ((Field)localObject3).set(this, ((Map.Entry)localObject2).getValue());
        }
        catch (IllegalAccessException localIllegalAccessException)
        {
          localObject2 = (String)((Map.Entry)localObject2).getKey();
          zzb.zzcy(String.valueOf(localObject2).length() + 49 + "Server option \"" + (String)localObject2 + "\" could not be set: Illegal Access");
        }
        catch (IllegalArgumentException localIllegalArgumentException)
        {
          localObject2 = (String)((Map.Entry)localObject2).getKey();
          zzb.zzcy(String.valueOf(localObject2).length() + 43 + "Server option \"" + (String)localObject2 + "\" could not be set: Bad Type");
        }
      }
      else
      {
        localObject4 = (String)((Map.Entry)localObject2).getKey();
        localObject2 = (String)((Map.Entry)localObject2).getValue();
        zzb.zzcw(String.valueOf(localObject4).length() + 31 + String.valueOf(localObject2).length() + "Unexpected server option: " + (String)localObject4 + " = \"" + (String)localObject2 + "\"");
      }
    }
    localObject2 = new StringBuilder();
    localObject1 = ((Map)localObject1).values().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject4 = (Field)((Iterator)localObject1).next();
      if (((Parameter)((Field)localObject4).getAnnotation(Parameter.class)).required())
      {
        paramMap = String.valueOf(((Parameter)((Field)localObject4).getAnnotation(Parameter.class)).name());
        if (paramMap.length() != 0) {}
        for (paramMap = "Required server option missing: ".concat(paramMap);; paramMap = new String("Required server option missing: "))
        {
          zzb.zzcy(paramMap);
          if (((StringBuilder)localObject2).length() > 0) {
            ((StringBuilder)localObject2).append(", ");
          }
          ((StringBuilder)localObject2).append(((Parameter)((Field)localObject4).getAnnotation(Parameter.class)).name());
          break;
        }
      }
    }
    if (((StringBuilder)localObject2).length() > 0)
    {
      paramMap = String.valueOf(((StringBuilder)localObject2).toString());
      if (paramMap.length() != 0) {}
      for (paramMap = "Required server option(s) missing: ".concat(paramMap);; paramMap = new String("Required server option(s) missing: ")) {
        throw new MappingException(paramMap);
      }
    }
    zzaa();
  }
  
  protected void zzaa() {}
  
  public static final class MappingException
    extends Exception
  {
    public MappingException(String paramString)
    {
      super();
    }
  }
  
  @Retention(RetentionPolicy.RUNTIME)
  @Target({java.lang.annotation.ElementType.FIELD})
  protected static @interface Parameter
  {
    String name();
    
    boolean required() default true;
  }
}

/* Location:
 * Qualified Name:     com.google.ads.mediation.MediationServerParameters
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */