package me.lyft.android.services;

import rx.functions.Action0;
import rx.functions.Action1;

class LyftDriverToggleService$5
  implements Action1<LyftDriverToggleService.DraggingZone>
{
  LyftDriverToggleService$5(LyftDriverToggleService paramLyftDriverToggleService) {}
  
  public void call(LyftDriverToggleService.DraggingZone paramDraggingZone)
  {
    if (paramDraggingZone == LyftDriverToggleService.DraggingZone.DRAG_STARTED) {
      LyftDriverToggleService.access$900(this$0).call();
    }
    do
    {
      return;
      if (paramDraggingZone == LyftDriverToggleService.DraggingZone.DRAG_TO_SWITCH)
      {
        LyftDriverToggleService.access$1000(this$0).call();
        return;
      }
    } while (paramDraggingZone != LyftDriverToggleService.DraggingZone.DRAG_TO_REMOVE);
    LyftDriverToggleService.access$1100(this$0).call();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.services.LyftDriverToggleService.5
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */