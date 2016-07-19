package me.lyft.android.infrastructure.api;

import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;
import java.io.IOException;

public abstract interface IJsonBodySerializer
{
  public abstract <T> T deserialize(Response paramResponse, Class<T> paramClass)
    throws IOException;
  
  public abstract RequestBody emptyBody();
  
  public abstract RequestBody serialize(Object paramObject);
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.api.IJsonBodySerializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */