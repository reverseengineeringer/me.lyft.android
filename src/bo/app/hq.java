package bo.app;

import android.content.Context;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class hq
{
  public static gw a(Context paramContext, hk paramhk, long paramLong, int paramInt)
  {
    Object localObject1 = ka.a(paramContext, false);
    Object localObject2 = new File((File)localObject1, "uil-images");
    if ((((File)localObject2).exists()) || (((File)localObject2).mkdir())) {
      localObject1 = localObject2;
    }
    File localFile;
    if ((paramLong > 0L) || (paramInt > 0))
    {
      localObject2 = ka.a(paramContext, true);
      localFile = new File((File)localObject2, "uil-images");
      if ((localFile.exists()) || (localFile.mkdir())) {
        break label130;
      }
    }
    for (;;)
    {
      try
      {
        localObject2 = new hg((File)localObject2, (File)localObject1, paramhk, paramLong, paramInt);
        return (gw)localObject2;
      }
      catch (IOException localIOException)
      {
        jx.a(localIOException);
      }
      return new gy(ka.a(paramContext, true), (File)localObject1, paramhk);
      label130:
      Object localObject3 = localFile;
    }
  }
  
  public static Executor a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt3 == ir.b)
    {
      paramInt3 = 1;
      if (paramInt3 == 0) {
        break label52;
      }
    }
    label52:
    for (Object localObject = new iw();; localObject = new LinkedBlockingQueue())
    {
      localObject = (BlockingQueue)localObject;
      return new ThreadPoolExecutor(paramInt1, paramInt1, 0L, TimeUnit.MILLISECONDS, (BlockingQueue)localObject, a(paramInt2, "uil-pool-"));
      paramInt3 = 0;
      break;
    }
  }
  
  static ThreadFactory a(int paramInt, String paramString)
  {
    return new hr(paramInt, paramString);
  }
}

/* Location:
 * Qualified Name:     bo.app.hq
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */