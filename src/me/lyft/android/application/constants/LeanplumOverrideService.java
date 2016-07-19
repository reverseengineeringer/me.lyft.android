package me.lyft.android.application.constants;

import me.lyft.android.persistence.ISimpleRepository;
import rx.Observable;

public class LeanplumOverrideService
  implements ILeanplumOverrideService
{
  private final ISimpleRepository<Boolean> leanplumOverrideRepository;
  
  public LeanplumOverrideService(ISimpleRepository<Boolean> paramISimpleRepository)
  {
    leanplumOverrideRepository = paramISimpleRepository;
  }
  
  public boolean isLeanplumEnabled()
  {
    return ((Boolean)leanplumOverrideRepository.get()).booleanValue();
  }
  
  public Observable<Boolean> observeLeanplumOverride()
  {
    return leanplumOverrideRepository.observe();
  }
  
  public void setLeanplumEnabled(boolean paramBoolean)
  {
    leanplumOverrideRepository.update(Boolean.valueOf(paramBoolean));
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.constants.LeanplumOverrideService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */