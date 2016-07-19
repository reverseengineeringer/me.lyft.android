package me.lyft.android.services;

import android.widget.ImageView;
import me.lyft.android.domain.User;
import rx.functions.Action1;

class LyftDriverToggleService$1
  implements Action1<User>
{
  LyftDriverToggleService$1(LyftDriverToggleService paramLyftDriverToggleService) {}
  
  public void call(User paramUser)
  {
    paramUser.isDispatchable();
    ImageView localImageView = LyftDriverToggleService.access$000(this$0);
    if (paramUser.isDispatchable()) {}
    for (int i = 0;; i = 8)
    {
      localImageView.setVisibility(i);
      return;
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.services.LyftDriverToggleService.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */