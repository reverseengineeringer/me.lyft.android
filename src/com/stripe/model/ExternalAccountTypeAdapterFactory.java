package com.stripe.model;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

public class ExternalAccountTypeAdapterFactory
  implements TypeAdapterFactory
{
  public <T> TypeAdapter<T> create(Gson paramGson, final TypeToken<T> paramTypeToken)
  {
    if (!ExternalAccount.class.isAssignableFrom(paramTypeToken.getRawType())) {
      return null;
    }
    paramTypeToken = paramGson.getAdapter(JsonElement.class);
    new TypeAdapter()
    {
      public ExternalAccount read(JsonReader paramAnonymousJsonReader)
        throws IOException
      {
        paramAnonymousJsonReader = ((JsonElement)paramTypeToken.read(paramAnonymousJsonReader)).getAsJsonObject();
        String str = paramAnonymousJsonReader.getAsJsonPrimitive("object").getAsString();
        if (str.equals("alipay_account")) {
          return (ExternalAccount)val$alipayAccountAdapter.fromJsonTree(paramAnonymousJsonReader);
        }
        if (str.equals("bank_account")) {
          return (ExternalAccount)val$bankAccountAdapter.fromJsonTree(paramAnonymousJsonReader);
        }
        if (str.equals("bitcoin_receiver")) {
          return (ExternalAccount)val$bitcoinReceiverAdapter.fromJsonTree(paramAnonymousJsonReader);
        }
        if (str.equals("card")) {
          return (ExternalAccount)val$cardAdapter.fromJsonTree(paramAnonymousJsonReader);
        }
        return (ExternalAccount)val$externalAccountAdapter.fromJsonTree(paramAnonymousJsonReader);
      }
      
      public void write(JsonWriter paramAnonymousJsonWriter, ExternalAccount paramAnonymousExternalAccount)
        throws IOException
      {
        val$externalAccountAdapter.write(paramAnonymousJsonWriter, paramAnonymousExternalAccount);
      }
    }.nullSafe();
  }
}

/* Location:
 * Qualified Name:     com.stripe.model.ExternalAccountTypeAdapterFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */