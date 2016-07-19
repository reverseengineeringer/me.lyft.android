package me.lyft.android.infrastructure.camera;

import java.io.File;
import me.lyft.android.logging.L;
import me.lyft.android.utils.Files;
import rx.Observable.OnSubscribe;
import rx.Subscriber;

final class CaptureImageSession$2
  implements Observable.OnSubscribe<File>
{
  CaptureImageSession$2(File paramFile1, File paramFile2) {}
  
  public void call(Subscriber<? super File> paramSubscriber)
  {
    try
    {
      long l = System.currentTimeMillis();
      Files.copy(val$from, val$to);
      paramSubscriber.onNext(val$to);
      paramSubscriber.onCompleted();
      L.i("time to copy: %dms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      return;
    }
    catch (Throwable localThrowable)
    {
      paramSubscriber.onError(localThrowable);
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.camera.CaptureImageSession.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */