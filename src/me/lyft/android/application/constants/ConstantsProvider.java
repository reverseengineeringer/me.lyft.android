package me.lyft.android.application.constants;

import java.util.Collection;
import java.util.Collections;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import me.lyft.android.common.Objects;
import me.lyft.android.domain.ride.CancellationOption;
import me.lyft.android.domain.ride.CancellationOptionsMapper;
import me.lyft.android.infrastructure.lyft.constants.Constant;

public class ConstantsProvider
  implements IConstantsProvider
{
  private final Map<Priority, Map<String, Object>> constantsByPriority = new EnumMap(Priority.class);
  
  public <T> T get(Constant<T> paramConstant)
  {
    Object localObject2 = null;
    Iterator localIterator = constantsByPriority.values().iterator();
    do
    {
      do
      {
        localObject1 = localObject2;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject1 = (Map)localIterator.next();
      } while (localObject1 == null);
      localObject1 = ((Map)localObject1).get(paramConstant.getKey());
    } while (localObject1 == null);
    Object localObject1 = paramConstant.safeCast(localObject1);
    if (localObject1 != null) {
      return (T)localObject1;
    }
    return (T)paramConstant.getDefaultValue();
  }
  
  public <T> T get(Constant<T> paramConstant, T paramT)
  {
    return (T)Objects.firstNonNull(get(paramConstant), paramT);
  }
  
  public List<CancellationOption> getCancellationOptions()
  {
    Map localMap = (Map)constantsByPriority.get(Priority.PRIMARY);
    if (localMap == null) {
      return Collections.emptyList();
    }
    return CancellationOptionsMapper.fromMaps((List)localMap.get("cancelationOptions"));
  }
  
  public Map<String, String> getCheckBundleIds()
  {
    Map localMap = (Map)constantsByPriority.get(Priority.PRIMARY);
    if (localMap == null) {
      return Collections.emptyMap();
    }
    return (Map)Objects.firstNonNull((Map)localMap.get("checkBundleIds"), Collections.emptyMap());
  }
  
  public void update(Map<String, Object> paramMap, Priority paramPriority)
  {
    constantsByPriority.put(paramPriority, paramMap);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.constants.ConstantsProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */