package com.stripe.model;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.stripe.net.APIResource;
import java.io.PrintStream;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class EventDataDeserializer
  implements JsonDeserializer<EventData>
{
  static final Map<String, Class> objectMap = new HashMap();
  
  static
  {
    objectMap.put("account", Account.class);
    objectMap.put("charge", Charge.class);
    objectMap.put("discount", Discount.class);
    objectMap.put("customer", Customer.class);
    objectMap.put("invoice", Invoice.class);
    objectMap.put("invoiceitem", InvoiceItem.class);
    objectMap.put("plan", Plan.class);
    objectMap.put("subscription", Subscription.class);
    objectMap.put("token", Token.class);
    objectMap.put("coupon", Coupon.class);
    objectMap.put("transfer", Transfer.class);
    objectMap.put("dispute", Dispute.class);
    objectMap.put("refund", Refund.class);
    objectMap.put("recipient", Recipient.class);
    objectMap.put("summary", Summary.class);
    objectMap.put("fee", Fee.class);
    objectMap.put("bank_account", BankAccount.class);
    objectMap.put("balance", Balance.class);
    objectMap.put("card", Card.class);
    objectMap.put("balance_transaction", BalanceTransaction.class);
  }
  
  private Object[] deserializeJsonArray(JsonArray paramJsonArray)
  {
    Object[] arrayOfObject = new Object[paramJsonArray.size()];
    paramJsonArray = paramJsonArray.iterator();
    int i = 0;
    while (paramJsonArray.hasNext())
    {
      arrayOfObject[i] = deserializeJsonElement((JsonElement)paramJsonArray.next());
      i += 1;
    }
    return arrayOfObject;
  }
  
  private Object deserializeJsonElement(JsonElement paramJsonElement)
  {
    if (paramJsonElement.isJsonNull()) {
      return null;
    }
    if (paramJsonElement.isJsonObject())
    {
      HashMap localHashMap = new HashMap();
      populateMapFromJSONObject(localHashMap, paramJsonElement.getAsJsonObject());
      return localHashMap;
    }
    if (paramJsonElement.isJsonPrimitive()) {
      return deserializeJsonPrimitive(paramJsonElement.getAsJsonPrimitive());
    }
    if (paramJsonElement.isJsonArray()) {
      return deserializeJsonArray(paramJsonElement.getAsJsonArray());
    }
    System.err.println("Unknown JSON element type for element " + paramJsonElement + ". " + "If you're seeing this messaage, it's probably a bug in the Stripe Java " + "library. Please contact us by email at support@stripe.com.");
    return null;
  }
  
  private Object deserializeJsonPrimitive(JsonPrimitive paramJsonPrimitive)
  {
    if (paramJsonPrimitive.isBoolean()) {
      return Boolean.valueOf(paramJsonPrimitive.getAsBoolean());
    }
    if (paramJsonPrimitive.isNumber()) {
      return paramJsonPrimitive.getAsNumber();
    }
    return paramJsonPrimitive.getAsString();
  }
  
  private void populateMapFromJSONObject(Map<String, Object> paramMap, JsonObject paramJsonObject)
  {
    paramJsonObject = paramJsonObject.entrySet().iterator();
    while (paramJsonObject.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramJsonObject.next();
      paramMap.put((String)localEntry.getKey(), deserializeJsonElement((JsonElement)localEntry.getValue()));
    }
  }
  
  public EventData deserialize(JsonElement paramJsonElement, Type paramType, JsonDeserializationContext paramJsonDeserializationContext)
    throws JsonParseException
  {
    paramType = new EventData();
    paramJsonDeserializationContext = paramJsonElement.getAsJsonObject().entrySet().iterator();
    while (paramJsonDeserializationContext.hasNext())
    {
      Object localObject1 = (Map.Entry)paramJsonDeserializationContext.next();
      Object localObject2 = (String)((Map.Entry)localObject1).getKey();
      paramJsonElement = (JsonElement)((Map.Entry)localObject1).getValue();
      if ("previous_attributes".equals(localObject2))
      {
        localObject1 = new HashMap();
        populateMapFromJSONObject((Map)localObject1, paramJsonElement.getAsJsonObject());
        paramType.setPreviousAttributes((Map)localObject1);
      }
      else if ("object".equals(localObject2))
      {
        paramJsonElement = paramJsonElement.getAsJsonObject().get("object").getAsString();
        paramJsonElement = (Class)objectMap.get(paramJsonElement);
        localObject2 = APIResource.GSON;
        localObject1 = (JsonElement)((Map.Entry)localObject1).getValue();
        if (paramJsonElement != null) {}
        for (;;)
        {
          paramType.setObject((StripeObject)((Gson)localObject2).fromJson((JsonElement)localObject1, paramJsonElement));
          break;
          paramJsonElement = StripeRawJsonObject.class;
        }
      }
    }
    return paramType;
  }
}

/* Location:
 * Qualified Name:     com.stripe.model.EventDataDeserializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */