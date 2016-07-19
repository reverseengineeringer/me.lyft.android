package me.lyft.android.domain.ats;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import me.lyft.android.common.INullable;
import me.lyft.android.common.Objects;

public class DriverApplicationData
  implements INullable
{
  private final List<Region> regions;
  
  public DriverApplicationData(List<Region> paramList)
  {
    regions = paramList;
  }
  
  public static DriverApplicationData empty()
  {
    return NullDriverApplicationData.getInstance();
  }
  
  public String findRegionLabelByCode(String paramString)
  {
    Iterator localIterator = getRegions().iterator();
    while (localIterator.hasNext())
    {
      Region localRegion = (Region)localIterator.next();
      if (localRegion.getCode().equals(paramString)) {
        return localRegion.getLabel();
      }
    }
    return "";
  }
  
  public List<String> getRegionCodes()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = getRegions().iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(((Region)localIterator.next()).getCode());
    }
    return localArrayList;
  }
  
  public List<String> getRegionLabels()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = getRegions().iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(((Region)localIterator.next()).getLabel());
    }
    return localArrayList;
  }
  
  public List<Region> getRegions()
  {
    return (List)Objects.firstNonNull(regions, new ArrayList());
  }
  
  public boolean isNull()
  {
    return false;
  }
  
  public static class NullDriverApplicationData
    extends DriverApplicationData
  {
    private static final DriverApplicationData INSTANCE = new NullDriverApplicationData();
    
    private NullDriverApplicationData()
    {
      super();
    }
    
    public static DriverApplicationData getInstance()
    {
      return INSTANCE;
    }
    
    public boolean isNull()
    {
      return true;
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.ats.DriverApplicationData
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */