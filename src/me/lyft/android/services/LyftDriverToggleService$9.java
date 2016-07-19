package me.lyft.android.services;

import me.lyft.android.common.Unit;
import me.lyft.android.rx.AsyncCall;

class LyftDriverToggleService$9
  extends AsyncCall<Unit>
{
  LyftDriverToggleService$9(LyftDriverToggleService paramLyftDriverToggleService) {}
  
  public void onFail(Throwable paramThrowable)
  {
    super.onFail(paramThrowable);
    LyftDriverToggleService.access$1200(this$0, "switch_mode_failed");
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.services.LyftDriverToggleService.9
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */