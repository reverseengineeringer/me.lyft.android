package me.lyft.android.domain.ride;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class CancellationOptionsMapper
{
  @Deprecated
  public static List<CancellationOption> fromMaps(List<Map<String, String>> paramList)
  {
    if (paramList == null)
    {
      paramList = Collections.emptyList();
      return paramList;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramList.iterator();
    for (;;)
    {
      paramList = localArrayList;
      if (!localIterator.hasNext()) {
        break;
      }
      paramList = (Map)localIterator.next();
      localArrayList.add(new CancellationOption((String)paramList.get("id"), (String)paramList.get("string"), (String)paramList.get("status")));
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.ride.CancellationOptionsMapper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */