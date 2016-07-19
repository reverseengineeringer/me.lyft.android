package me.lyft.android.analytics.core;

import me.lyft.android.analytics.Analytics;
import me.lyft.android.analytics.core.events.IEvent.Priority;
import me.lyft.android.analytics.core.events.UxEvent;
import me.lyft.android.analytics.core.events.UxEvent.Type;
import me.lyft.android.analytics.definitions.UiElement;

public class UxAnalytics
{
  private final UxEvent uxEvent;
  
  private UxAnalytics(UxEvent.Type paramType, UiElement paramUiElement)
  {
    uxEvent = new UxEvent(paramType, paramUiElement);
  }
  
  public static UxAnalytics dismissed(UiElement paramUiElement)
  {
    return new UxAnalytics(UxEvent.Type.DISMISSED, paramUiElement);
  }
  
  public static UxAnalytics displayed(UiElement paramUiElement)
  {
    return new UxAnalytics(UxEvent.Type.DISPLAYED, paramUiElement);
  }
  
  public static UxAnalytics tapped(UiElement paramUiElement)
  {
    return new UxAnalytics(UxEvent.Type.TAPPED, paramUiElement);
  }
  
  public UxAnalytics setParameter(String paramString)
  {
    uxEvent.setParameter(paramString);
    return this;
  }
  
  public UxAnalytics setParent(String paramString)
  {
    uxEvent.setParent(paramString);
    return this;
  }
  
  public UxAnalytics setPriority(IEvent.Priority paramPriority)
  {
    uxEvent.setPriority(paramPriority);
    return this;
  }
  
  public UxAnalytics setSampleRate(float paramFloat)
  {
    uxEvent.setSampleRate(paramFloat);
    return this;
  }
  
  public UxAnalytics setScreenX(int paramInt)
  {
    uxEvent.setScreenX(paramInt);
    return this;
  }
  
  public UxAnalytics setScreenY(int paramInt)
  {
    uxEvent.setScreenX(paramInt);
    return this;
  }
  
  public UxAnalytics setTag(String paramString)
  {
    uxEvent.setTag(paramString);
    return this;
  }
  
  public UxAnalytics setValue(long paramLong)
  {
    uxEvent.setValue(paramLong);
    return this;
  }
  
  public UxAnalytics setValue(boolean paramBoolean)
  {
    uxEvent.setValue(paramBoolean);
    return this;
  }
  
  public void track()
  {
    Analytics.track(uxEvent);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.analytics.core.UxAnalytics
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */