package me.lyft.android.domain.tooltips;

import com.lyft.android.api.dto.HintDTO;
import me.lyft.android.common.Objects;

public class TooltipsMapper
{
  public static Tooltip createTooltip(HintDTO paramHintDTO, Tooltip paramTooltip)
  {
    Tooltip localTooltip = new Tooltip();
    localTooltip.setId(id);
    localTooltip.setText(text);
    localTooltip.setMaxTimesToDisplay(((Integer)Objects.firstNonNull(numDisplays, Integer.valueOf(0))).intValue());
    localTooltip.setBackgroundColor(backgroundColor);
    if (paramTooltip != null) {
      localTooltip.setTimesDisplayed(paramTooltip.getTimesDisplayed());
    }
    return localTooltip;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.tooltips.TooltipsMapper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */