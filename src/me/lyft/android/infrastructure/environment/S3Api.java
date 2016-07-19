package me.lyft.android.infrastructure.environment;

import com.squareup.okhttp.Request.Builder;
import com.squareup.okhttp.RequestBody;
import java.io.File;
import me.lyft.android.common.Unit;
import me.lyft.android.infrastructure.api.IHttpExecutor;
import rx.Observable;

public class S3Api
  implements IS3Api
{
  private static final String CONFIGS_URL = "http://api.lyft.com.s3.amazonaws.com/servers.json";
  private IHttpExecutor httpExecutor;
  
  public S3Api(IHttpExecutor paramIHttpExecutor)
  {
    httpExecutor = paramIHttpExecutor;
  }
  
  private Request.Builder createRequest()
  {
    return new Request.Builder();
  }
  
  public Observable<ConfigsDTO> getConfigs()
  {
    Request.Builder localBuilder = createRequest().url("http://api.lyft.com.s3.amazonaws.com/servers.json").get();
    return httpExecutor.executeAsync(localBuilder, ConfigsDTO.class);
  }
  
  public Observable<Unit> uploadFile(String paramString, File paramFile)
  {
    paramString = createRequest().url(paramString).put(RequestBody.create(null, paramFile));
    return httpExecutor.executeWithoutResultAsync(paramString);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.environment.S3Api
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */