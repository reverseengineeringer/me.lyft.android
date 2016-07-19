package com.google.gson.internal.bind;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.Currency;

final class TypeAdapters$25
  extends TypeAdapter<Currency>
{
  public Currency read(JsonReader paramJsonReader)
    throws IOException
  {
    return Currency.getInstance(paramJsonReader.nextString());
  }
  
  public void write(JsonWriter paramJsonWriter, Currency paramCurrency)
    throws IOException
  {
    paramJsonWriter.value(paramCurrency.getCurrencyCode());
  }
}

/* Location:
 * Qualified Name:     com.google.gson.internal.bind.TypeAdapters.25
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */