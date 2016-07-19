package me.lyft.android.infrastructure.api;

import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.RequestBody;
import me.lyft.android.infrastructure.json.IJsonSerializer;

public class JsonBody
{
  public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
  
  public static RequestBody create(IJsonSerializer paramIJsonSerializer, Object paramObject)
  {
    paramIJsonSerializer = paramIJsonSerializer.toJson(paramObject);
    return RequestBody.create(JSON, paramIJsonSerializer);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.api.JsonBody
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */