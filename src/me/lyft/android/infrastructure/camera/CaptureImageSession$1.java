package me.lyft.android.infrastructure.camera;

import java.io.File;
import me.lyft.android.common.AppFlow;
import me.lyft.android.rx.SimpleSubscriber;

class CaptureImageSession$1
  extends SimpleSubscriber<File>
{
  CaptureImageSession$1(CaptureImageSession paramCaptureImageSession) {}
  
  public void onError(Throwable paramThrowable)
  {
    CaptureImageSession.access$100(this$0).resetTo(CaptureImageSession.access$000(this$0));
  }
  
  public void onNext(File paramFile)
  {
    CaptureImageSession.access$100(this$0).resetTo(CaptureImageSession.access$000(this$0));
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.camera.CaptureImageSession.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */