package me.lyft.android.infrastructure.lyft;

import com.lyft.android.api.dto.LocationDTO;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import me.lyft.android.utils.RandomExtensions;

public class LocationHistory
{
  private int historySize;
  private List<LocationDTO> locations = Collections.synchronizedList(new ArrayList());
  
  public LocationHistory(int paramInt)
  {
    historySize = paramInt;
  }
  
  public void add(LocationDTO paramLocationDTO)
  {
    int i = locations.size();
    if (i >= historySize) {
      locations.remove(RandomExtensions.generateRandom(i - 1));
    }
    locations.add(paramLocationDTO);
  }
  
  public List<LocationDTO> getCopy()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(locations);
    return localArrayList;
  }
  
  public void removeAll(Collection<LocationDTO> paramCollection)
  {
    locations.removeAll(paramCollection);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.lyft.LocationHistory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */