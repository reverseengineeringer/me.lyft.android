package me.lyft.android.infrastructure.leanplum;

import me.lyft.android.application.constants.IConstantsProvider;
import rx.functions.Action1;

class LeanplumService$2
  implements Action1<Boolean>
{
  LeanplumService$2(LeanplumService paramLeanplumService, IConstantsProvider paramIConstantsProvider) {}
  
  public void call(Boolean paramBoolean)
  {
    if (!paramBoolean.booleanValue()) {
      LeanplumService.access$000(val$constantsProvider);
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.leanplum.LeanplumService.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */