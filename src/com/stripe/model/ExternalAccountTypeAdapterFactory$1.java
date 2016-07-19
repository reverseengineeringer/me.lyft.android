package com.stripe.model;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

class ExternalAccountTypeAdapterFactory$1
  extends TypeAdapter<ExternalAccount>
{
  ExternalAccountTypeAdapterFactory$1(ExternalAccountTypeAdapterFactory paramExternalAccountTypeAdapterFactory, TypeAdapter paramTypeAdapter1, TypeAdapter paramTypeAdapter2, TypeAdapter paramTypeAdapter3, TypeAdapter paramTypeAdapter4, TypeAdapter paramTypeAdapter5, TypeAdapter paramTypeAdapter6) {}
  
  public ExternalAccount read(JsonReader paramJsonReader)
    throws IOException
  {
    paramJsonReader = ((JsonElement)val$elementAdapter.read(paramJsonReader)).getAsJsonObject();
    String str = paramJsonReader.getAsJsonPrimitive("object").getAsString();
    if (str.equals("alipay_account")) {
      return (ExternalAccount)val$alipayAccountAdapter.fromJsonTree(paramJsonReader);
    }
    if (str.equals("bank_account")) {
      return (ExternalAccount)val$bankAccountAdapter.fromJsonTree(paramJsonReader);
    }
    if (str.equals("bitcoin_receiver")) {
      return (ExternalAccount)val$bitcoinReceiverAdapter.fromJsonTree(paramJsonReader);
    }
    if (str.equals("card")) {
      return (ExternalAccount)val$cardAdapter.fromJsonTree(paramJsonReader);
    }
    return (ExternalAccount)val$externalAccountAdapter.fromJsonTree(paramJsonReader);
  }
  
  public void write(JsonWriter paramJsonWriter, ExternalAccount paramExternalAccount)
    throws IOException
  {
    val$externalAccountAdapter.write(paramJsonWriter, paramExternalAccount);
  }
}

/* Location:
 * Qualified Name:     com.stripe.model.ExternalAccountTypeAdapterFactory.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */