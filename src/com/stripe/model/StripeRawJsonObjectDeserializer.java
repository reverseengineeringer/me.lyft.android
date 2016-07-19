package com.stripe.model;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import java.lang.reflect.Type;

public class StripeRawJsonObjectDeserializer
  implements JsonDeserializer<StripeRawJsonObject>
{
  public StripeRawJsonObject deserialize(JsonElement paramJsonElement, Type paramType, JsonDeserializationContext paramJsonDeserializationContext)
    throws JsonParseException
  {
    paramType = new StripeRawJsonObject();
    json = paramJsonElement.getAsJsonObject();
    return paramType;
  }
}

/* Location:
 * Qualified Name:     com.stripe.model.StripeRawJsonObjectDeserializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */