package com.stripe.model;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.lang.reflect.Field;

public abstract class StripeObject
{
  public static final Gson PRETTY_PRINT_GSON = new GsonBuilder().setPrettyPrinting().serializeNulls().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).registerTypeAdapter(EventData.class, new EventDataDeserializer()).create();
  
  protected static boolean equals(Object paramObject1, Object paramObject2)
  {
    if (paramObject1 == null) {
      return paramObject2 == null;
    }
    return paramObject1.equals(paramObject2);
  }
  
  private Object getIdString()
  {
    try
    {
      Object localObject = getClass().getDeclaredField("id").get(this);
      return localObject;
    }
    catch (SecurityException localSecurityException)
    {
      return "";
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      return "";
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      return "";
    }
    catch (IllegalAccessException localIllegalAccessException) {}
    return "";
  }
  
  public String toString()
  {
    return String.format("<%s@%s id=%s> JSON: %s", new Object[] { getClass().getName(), Integer.valueOf(System.identityHashCode(this)), getIdString(), PRETTY_PRINT_GSON.toJson(this) });
  }
}

/* Location:
 * Qualified Name:     com.stripe.model.StripeObject
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */