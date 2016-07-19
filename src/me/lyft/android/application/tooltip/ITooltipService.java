package me.lyft.android.application.tooltip;

import com.lyft.android.api.dto.HintDTO;
import java.util.List;
import me.lyft.android.domain.tooltips.Tooltip;

public abstract interface ITooltipService
{
  public abstract Tooltip getTooltip(String paramString);
  
  public abstract void saveTooltip(Tooltip paramTooltip);
  
  public abstract void updateTooltips(List<HintDTO> paramList);
}

/* Location:
 * Qualified Name:     me.lyft.android.application.tooltip.ITooltipService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */