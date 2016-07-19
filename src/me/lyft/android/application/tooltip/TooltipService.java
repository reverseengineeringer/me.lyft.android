package me.lyft.android.application.tooltip;

import java.util.HashMap;
import me.lyft.android.ILyftPreferences;
import me.lyft.android.application.constants.Constants;
import me.lyft.android.application.constants.IConstantsProvider;
import me.lyft.android.common.Objects;
import me.lyft.android.domain.tooltips.Tooltip;
import me.lyft.android.infrastructure.lyft.constants.Constant;
import me.lyft.android.logging.L;

public class TooltipService
  implements ITooltipService
{
  private static final String BACKGROUND_COLOR = "backgroundColor";
  private static final int HINT_DURATION_SECONDS = 10;
  private static final String ID = "id";
  private static final int MAX_DISPLAYS_PER_SESSION = 1;
  private static final String NUM_DISPLAYS = "numDisplays";
  private static final String TEXT = "text";
  private IConstantsProvider constantsProvider;
  private final HashMap<String, Tooltip> leanPlumToolTips = new HashMap();
  private ILyftPreferences preferences;
  
  public TooltipService(ILyftPreferences paramILyftPreferences, IConstantsProvider paramIConstantsProvider)
  {
    preferences = paramILyftPreferences;
    constantsProvider = paramIConstantsProvider;
  }
  
  private Tooltip getLeanplumToolTip(Constant<HashMap> paramConstant, int paramInt)
  {
    Object localObject = (HashMap)constantsProvider.get(paramConstant);
    if (localObject == null) {
      return Tooltip.empty();
    }
    if (leanPlumToolTips.containsKey(paramConstant.getKey())) {
      return (Tooltip)leanPlumToolTips.get(paramConstant.getKey());
    }
    try
    {
      String str1 = (String)((HashMap)localObject).get("id");
      String str2 = (String)((HashMap)localObject).get("backgroundColor");
      int i = ((Double)((HashMap)localObject).get("numDisplays")).intValue();
      localObject = new Tooltip(str1, (String)((HashMap)localObject).get("text"), Integer.valueOf(i).intValue(), str2, paramInt);
      ((Tooltip)localObject).setDisplayDuration(10);
      leanPlumToolTips.put(paramConstant.getKey(), localObject);
      return (Tooltip)localObject;
    }
    catch (Exception paramConstant)
    {
      L.w(paramConstant, "Leanplum tooltip parsing exception.", new Object[0]);
    }
    return Tooltip.empty();
  }
  
  public Tooltip getTooltip(String paramString)
  {
    if ("split_fare".equals(paramString)) {
      return getLeanplumToolTip(Constants.PROMOTE_SPLIT_PAY_HINT, 1);
    }
    if ("giftbox".equals(paramString)) {
      return getLeanplumToolTip(Constants.PROMOTE_GIFTBOX_HINT, 1);
    }
    if ("ride_type_tip".equals(paramString)) {
      return getLeanplumToolTip(Constants.RIDE_TYPE_HINT, 1);
    }
    return (Tooltip)Objects.firstNonNull(preferences.getTooltip(paramString), Tooltip.empty());
  }
  
  public void saveTooltip(Tooltip paramTooltip)
  {
    preferences.saveTooltip(paramTooltip);
  }
  
  /* Error */
  public void updateTooltips(java.util.List<com.lyft.android.api.dto.HintDTO> paramList)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnonnull +6 -> 9
    //   6: aload_0
    //   7: monitorexit
    //   8: return
    //   9: new 153	java/util/ArrayList
    //   12: dup
    //   13: aload_1
    //   14: invokeinterface 158 1 0
    //   19: invokespecial 160	java/util/ArrayList:<init>	(I)V
    //   22: astore_3
    //   23: aload_1
    //   24: invokeinterface 158 1 0
    //   29: iconst_1
    //   30: isub
    //   31: istore_2
    //   32: iload_2
    //   33: iflt +48 -> 81
    //   36: aload_1
    //   37: iload_2
    //   38: invokeinterface 163 2 0
    //   43: checkcast 165	com/lyft/android/api/dto/HintDTO
    //   46: astore 4
    //   48: aload_3
    //   49: aload 4
    //   51: aload_0
    //   52: getfield 43	me/lyft/android/application/tooltip/TooltipService:preferences	Lme/lyft/android/ILyftPreferences;
    //   55: aload 4
    //   57: getfield 167	com/lyft/android/api/dto/HintDTO:id	Ljava/lang/String;
    //   60: invokeinterface 140 2 0
    //   65: invokestatic 173	me/lyft/android/domain/tooltips/TooltipsMapper:createTooltip	(Lcom/lyft/android/api/dto/HintDTO;Lme/lyft/android/domain/tooltips/Tooltip;)Lme/lyft/android/domain/tooltips/Tooltip;
    //   68: invokeinterface 176 2 0
    //   73: pop
    //   74: iload_2
    //   75: iconst_1
    //   76: isub
    //   77: istore_2
    //   78: goto -46 -> 32
    //   81: aload_0
    //   82: getfield 43	me/lyft/android/application/tooltip/TooltipService:preferences	Lme/lyft/android/ILyftPreferences;
    //   85: invokeinterface 179 1 0
    //   90: aload_3
    //   91: invokeinterface 183 1 0
    //   96: astore_1
    //   97: aload_1
    //   98: invokeinterface 189 1 0
    //   103: ifeq -97 -> 6
    //   106: aload_0
    //   107: aload_1
    //   108: invokeinterface 193 1 0
    //   113: checkcast 58	me/lyft/android/domain/tooltips/Tooltip
    //   116: invokevirtual 194	me/lyft/android/application/tooltip/TooltipService:saveTooltip	(Lme/lyft/android/domain/tooltips/Tooltip;)V
    //   119: goto -22 -> 97
    //   122: astore_1
    //   123: aload_0
    //   124: monitorexit
    //   125: aload_1
    //   126: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	127	0	this	TooltipService
    //   0	127	1	paramList	java.util.List<com.lyft.android.api.dto.HintDTO>
    //   31	47	2	i	int
    //   22	69	3	localArrayList	java.util.ArrayList
    //   46	10	4	localHintDTO	com.lyft.android.api.dto.HintDTO
    // Exception table:
    //   from	to	target	type
    //   9	32	122	finally
    //   36	74	122	finally
    //   81	97	122	finally
    //   97	119	122	finally
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.tooltip.TooltipService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */