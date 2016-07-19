package me.lyft.android.domain.tooltips;

import com.google.gson.annotations.SerializedName;
import me.lyft.android.common.INullable;
import me.lyft.android.common.Objects;

public class Tooltip
  implements INullable
{
  public static final String ACCEPT_BUTTON = "accept_button";
  public static final int ALWAYS_SHOW = 0;
  public static final String ARRIVE_BUTTON = "arrive_button";
  public static final String CONFIRM_ARRIVAL_BUTTON = "confirm_arrival_button";
  public static final String CONFIRM_DROPOFF_BUTTON = "confirm_drop_off";
  public static final String DROPOFF_BUTTON = "dropoff_button";
  public static final String DROPOFF_MODAL_NAVIGATE_BUTTON = "pickup_modal_navigate_button";
  public static final String GIFTBOX = "giftbox";
  public static final String NAVIGATE_BUTTON = "pickup_navigate_button";
  public static final String PICKUP_BUTTON = "pickup_button";
  public static final String RATE_PASSENGER = "star_5_button";
  public static final String RIDE_TYPE = "ride_type_tip";
  public static final String SPLIT_FARE = "split_fare";
  public static final String SUBMIT_RATING_BUTTON = "submit_button";
  public static final String TIMER_STARTED = "timer_started";
  @SerializedName("backgroundColor")
  private String backgroundColor;
  private int displayDuration = -1;
  @SerializedName("id")
  private String id;
  @SerializedName("maxTimesToDisplay")
  private int maxTimesToDisplay;
  private int maxTimesToDisplayPerSession = Integer.MAX_VALUE;
  @SerializedName("text")
  private String text;
  @SerializedName("timesDisplayed")
  private int timesDisplayed;
  private int timesDisplayedCurrentSession;
  
  public Tooltip() {}
  
  public Tooltip(String paramString1, String paramString2, int paramInt1, String paramString3, int paramInt2)
  {
    id = paramString1;
    text = paramString2;
    maxTimesToDisplay = paramInt1;
    backgroundColor = paramString3;
    maxTimesToDisplayPerSession = paramInt2;
  }
  
  public static Tooltip empty()
  {
    return NullTooltip.instance;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof Tooltip)) {}
    do
    {
      return false;
      paramObject = (Tooltip)paramObject;
    } while ((!Objects.equals(getId(), ((Tooltip)paramObject).getId())) || (!Objects.equals(getText(), ((Tooltip)paramObject).getText())));
    return true;
  }
  
  public String getBackgroundColor()
  {
    return backgroundColor;
  }
  
  public int getDisplayDuration()
  {
    return displayDuration;
  }
  
  public String getId()
  {
    return (String)Objects.firstNonNull(id, "");
  }
  
  public int getMaxTimesToDisplay()
  {
    return maxTimesToDisplay;
  }
  
  public String getText()
  {
    return (String)Objects.firstNonNull(text, "");
  }
  
  public int getTimesDisplayed()
  {
    return timesDisplayed;
  }
  
  public int hashCode()
  {
    return getId().hashCode() + getText().hashCode();
  }
  
  public boolean isNull()
  {
    return false;
  }
  
  public void markShown()
  {
    timesDisplayedCurrentSession += 1;
    timesDisplayed += 1;
  }
  
  void setBackgroundColor(String paramString)
  {
    backgroundColor = paramString;
  }
  
  public void setDisplayDuration(int paramInt)
  {
    displayDuration = (paramInt * 1000);
  }
  
  void setId(String paramString)
  {
    id = paramString;
  }
  
  void setMaxTimesToDisplay(int paramInt)
  {
    maxTimesToDisplay = paramInt;
  }
  
  void setText(String paramString)
  {
    text = paramString;
  }
  
  void setTimesDisplayed(int paramInt)
  {
    timesDisplayed = paramInt;
  }
  
  public boolean shouldShow()
  {
    if (maxTimesToDisplay == 0) {}
    while ((timesDisplayedCurrentSession < maxTimesToDisplayPerSession) && (timesDisplayed < maxTimesToDisplay)) {
      return true;
    }
    return false;
  }
  
  public static class NullTooltip
    extends Tooltip
  {
    private static Tooltip instance = new NullTooltip();
    
    public boolean isNull()
    {
      return true;
    }
    
    public boolean shouldShow()
    {
      return false;
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.tooltips.Tooltip
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */