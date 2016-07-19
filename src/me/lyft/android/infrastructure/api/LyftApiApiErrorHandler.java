package me.lyft.android.infrastructure.api;

import com.lyft.android.api.dto.LyftErrorDTO;
import com.squareup.okhttp.Response;
import java.io.IOException;
import me.lyft.android.domain.lyft.LyftError;
import me.lyft.android.infrastructure.lyft.LyftApiException;
import me.lyft.android.infrastructure.lyft.LyftErrorMapper;

public class LyftApiApiErrorHandler
  implements IApiErrorHandler
{
  private final IJsonBodySerializer jsonBodySerializer;
  
  public LyftApiApiErrorHandler(IJsonBodySerializer paramIJsonBodySerializer)
  {
    jsonBodySerializer = paramIJsonBodySerializer;
  }
  
  public void handleUnsuccessfulResponse(Response paramResponse)
    throws IOException
  {
    try
    {
      LyftError localLyftError1 = LyftErrorMapper.fromLyftErrorDTO((LyftErrorDTO)jsonBodySerializer.deserialize(paramResponse, LyftErrorDTO.class));
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
 * Qualified Name:     me.lyft.android.infrastructure.api.LyftApiApiErrorHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */