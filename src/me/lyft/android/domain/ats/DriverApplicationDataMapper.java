package me.lyft.android.domain.ats;

import com.lyft.android.api.dto.DriverApplicationDataDTO;
import com.lyft.android.api.dto.RegionDTO;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DriverApplicationDataMapper
{
  private static List<Region> createRegions(List<RegionDTO> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localArrayList.add(RegionMapper.fromRegionDto((RegionDTO)paramList.next()));
    }
    return localArrayList;
  }
  
  public static DriverApplicationData fromDriverApplicationDataDto(DriverApplicationDataDTO paramDriverApplicationDataDTO)
  {
    return new DriverApplicationData(createRegions(regions));
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.ats.DriverApplicationDataMapper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */