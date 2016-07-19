package me.lyft.android.infrastructure.api;

import com.squareup.okhttp.Response;
import java.io.IOException;
import me.lyft.android.domain.lyft.LyftError;
import me.lyft.android.infrastructure.lyft.LyftApiException;

public class S3ApiApiErrorHandler
  implements IApiErrorHandler
{
  private final IJsonBodySerializer jsonBodySerializer;
  
  public S3ApiApiErrorHandler(IJsonBodySerializer paramIJsonBodySerializer)
  {
    jsonBodySerializer = paramIJsonBodySerializer;
  }
  
  public void handleUnsuccessfulResponse(Response paramResponse)
    throws IOException
  {
    try
    {
      LyftError localLyftError1 = (LyftError)jsonBodySerializer.deserialize(paramResponse, LyftError.class);
      throw new LyftApiException(localLyftError1, paramResponse.code());
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        LyftError localLyftError2 = LyftError.empty();
      }
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.api.S3ApiApiErrorHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */