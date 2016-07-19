package me.lyft.android.domain.shortcuts;

import com.lyft.android.api.dto.ShortcutDTO;
import com.lyft.android.api.dto.UniversalDTO;
import com.lyft.android.api.dto.UserDTO;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import me.lyft.android.domain.location.LocationMapper;

public class ShortcutMapper
{
  public static final String HOME_LABEL = "home";
  public static final String WORK_LABEL = "work";
  
  private static Shortcut fromDTO(ShortcutDTO paramShortcutDTO)
  {
    return Shortcut.create(mapToShortcutType(paramShortcutDTO), LocationMapper.fromPlaceDTO(place));
  }
  
  public static List<Shortcut> fromUniversal(UniversalDTO paramUniversalDTO)
  {
    ArrayList localArrayList = new ArrayList();
    paramUniversalDTO = user;
    if ((paramUniversalDTO != null) && (shortcuts != null))
    {
      paramUniversalDTO = shortcuts.iterator();
      while (paramUniversalDTO.hasNext()) {
        localArrayList.add(fromDTO((ShortcutDTO)paramUniversalDTO.next()));
      }
    }
    return localArrayList;
  }
  
  public static String mapToShortcutLabel(ShortcutType paramShortcutType)
  {
    if (paramShortcutType == ShortcutType.HOME) {
      return "home";
    }
    return "work";
  }
  
  public static ShortcutType mapToShortcutType(ShortcutDTO paramShortcutDTO)
  {
    if ("work".equals(label)) {
      return ShortcutType.WORK;
    }
    return ShortcutType.HOME;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.shortcuts.ShortcutMapper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */