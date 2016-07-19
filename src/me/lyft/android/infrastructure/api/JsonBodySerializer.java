package me.lyft.android.infrastructure.api;

import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.ResponseBody;
import java.io.IOException;
import me.lyft.android.common.Closeables;
import me.lyft.android.infrastructure.json.IJsonSerializer;

public class JsonBodySerializer
  implements IJsonBodySerializer
{
  private final IJsonSerializer jsonSerializer;
  
  public JsonBodySerializer(IJsonSerializer paramIJsonSerializer)
  {
    jsonSerializer = paramIJsonSerializer;
  }
  
  public <T> T deserialize(Response paramResponse, Class<T> paramClass)
    throws IOException
  {
    paramResponse = paramResponse.body();
    try
    {
      paramClass = jsonSerializer.fromJson(paramResponse.charStream(), paramClass);
      return paramClass;
    }
    finally
    {
      Closeables.closeQuietly(paramResponse);
    }
  }
  
  public RequestBody emptyBody()
  {
    return RequestBody.create(null, new byte[0]);
  }
  
  public RequestBody serialize(Object paramObject)
  {
    return JsonBody.create(jsonSerializer, paramObject);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.api.JsonBodySerializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */