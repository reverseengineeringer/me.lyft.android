package com.stripe.model;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.List;

public class ChargeRefundCollectionDeserializer
  implements JsonDeserializer<ChargeRefundCollection>
{
  public ChargeRefundCollection deserialize(JsonElement paramJsonElement, Type paramType, JsonDeserializationContext paramJsonDeserializationContext)
    throws JsonParseException
  {
    paramJsonDeserializationContext = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create();
    if (paramJsonElement.isJsonArray())
    {
      paramJsonElement = (List)paramJsonDeserializationContext.fromJson(paramJsonElement, new TypeToken() {}.getType());
      paramType = new ChargeRefundCollection();
      paramType.setData(paramJsonElement);
      paramType.setHasMore(Boolean.valueOf(false));
      paramType.setTotalCount(Integer.valueOf(paramJsonElement.size()));
      return paramType;
    }
    return (ChargeRefundCollection)paramJsonDeserializationContext.fromJson(paramJsonElement, paramType);
  }
}

/* Location:
 * Qualified Name:     com.stripe.model.ChargeRefundCollectionDeserializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */