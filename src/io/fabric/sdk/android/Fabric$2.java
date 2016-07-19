package io.fabric.sdk.android;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;

class Fabric$2
  implements InitializationCallback
{
  final CountDownLatch kitInitializedLatch = new CountDownLatch(val$size);
  
  Fabric$2(Fabric paramFabric, int paramInt) {}
  
  public void failure(Exception paramException)
  {
    Fabric.access$200(this$0).failure(paramException);
  }
  
  public void success(Object paramObject)
  {
    kitInitializedLatch.countDown();
    if (kitInitializedLatch.getCount() == 0L)
    {
      Fabric.access$100(this$0).set(true);
      Fabric.access$200(this$0).success(this$0);
    }
  }
}

/* Location:
 * Qualified Name:     io.fabric.sdk.android.Fabric.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */