package com.stripe.model;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import java.lang.reflect.Type;

public class DisputeDataDeserializer
  implements JsonDeserializer<Dispute>
{
  public Dispute deserialize(JsonElement paramJsonElement, Type paramType, JsonDeserializationContext paramJsonDeserializationContext)
    throws JsonParseException
  {
    Gson localGson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create();
    if (paramJsonElement.isJsonNull()) {
      return null;
    }
    if (!paramJsonElement.isJsonObject()) {
      throw new JsonParseException("Dispute type was not an object, which is problematic.");
    }
    JsonObject localJsonObject = paramJsonElement.getAsJsonObject();
    JsonElement localJsonElement = localJsonObject.get("evidence");
    paramJsonDeserializationContext = null;
    EvidenceSubObject localEvidenceSubObject = null;
    if (localJsonElement.isJsonPrimitive())
    {
      paramJsonDeserializationContext = localJsonElement.getAsJsonPrimitive();
      if (!paramJsonDeserializationContext.isString()) {
        throw new JsonParseException("Evidence field on a dispute was a primitive non-string type.");
      }
      paramJsonDeserializationContext = paramJsonDeserializationContext.getAsString();
    }
    do
    {
      for (;;)
      {
        localJsonObject.remove("evidence");
        paramJsonElement = (Dispute)localGson.fromJson(paramJsonElement, paramType);
        paramJsonElement.setEvidence(paramJsonDeserializationContext);
        paramJsonElement.setEvidenceSubObject(localEvidenceSubObject);
        return paramJsonElement;
        if (!localJsonElement.isJsonObject()) {
          break;
        }
        localEvidenceSubObject = (EvidenceSubObject)localGson.fromJson(localJsonElement.getAsJsonObject(), EvidenceSubObject.class);
      }
    } while (localJsonElement.isJsonNull());
    throw new JsonParseException("Evidence field on a dispute was a non-primitive, non-object type.");
  }
}

/* Location:
 * Qualified Name:     com.stripe.model.DisputeDataDeserializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */