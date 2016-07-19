package me.lyft.android.infrastructure.wallet;

import me.lyft.android.rx.ReactiveProperty;
import rx.functions.Action1;

class AndroidPayService$2
  implements Action1<Boolean>
{
  AndroidPayService$2(AndroidPayService paramAndroidPayService) {}
  
  public void call(Boolean paramBoolean)
  {
    AndroidPayService.access$000(this$0).onNext(paramBoolean);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.wallet.AndroidPayService.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */