package me.lyft.android.application.constants;

import java.util.List;
import java.util.Map;
import me.lyft.android.domain.ride.CancellationOption;
import me.lyft.android.infrastructure.lyft.constants.Constant;

public abstract interface IConstantsProvider
{
  public abstract <T> T get(Constant<T> paramConstant);
  
  public abstract <T> T get(Constant<T> paramConstant, T paramT);
  
  @Deprecated
  public abstract List<CancellationOption> getCancellationOptions();
  
  @Deprecated
  public abstract Map<String, String> getCheckBundleIds();
  
  public abstract void update(Map<String, Object> paramMap, Priority paramPriority);
}

/* Location:
 * Qualified Name:     me.lyft.android.application.constants.IConstantsProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */