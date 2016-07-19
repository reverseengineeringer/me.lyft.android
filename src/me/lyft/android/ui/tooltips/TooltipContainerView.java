package me.lyft.android.ui.tooltips;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import com.lyft.scoop.dagger.DaggerInjector;
import java.util.HashSet;
import java.util.Set;
import javax.inject.Inject;
import me.lyft.android.application.tooltip.ITooltipService;
import me.lyft.android.common.Preconditions;
import me.lyft.android.domain.tooltips.Tooltip;

public class TooltipContainerView
  extends FrameLayout
{
  private static final int TOOLTIP_ANIMATION_DURATION = 800;
  @Inject
  ITooltipService tooltipService;
  private final Set<Tooltip> tooltipsList = new HashSet();
  
  public TooltipContainerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    DaggerInjector.fromView(this).inject(this);
  }
  
  private void hideVisibleTooltips()
  {
    int j;
    for (int i = 0; i < getChildCount(); i = j + 1)
    {
      j = i;
      if (getChildAt(i).getVisibility() == 0)
      {
        TooltipView localTooltipView = (TooltipView)getChildAt(i);
        tooltipsList.remove(localTooltipView.getTag());
        removeViewAt(i);
        j = i - 1;
      }
    }
  }
  
  private boolean tryToShow(Tooltip paramTooltip, View paramView, int paramInt)
  {
    if (!paramTooltip.shouldShow()) {}
    while (!tooltipsList.add(paramTooltip)) {
      return false;
    }
    TooltipView localTooltipView = (TooltipView)((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(2130903488, this, false);
    addView(localTooltipView);
    localTooltipView.show(paramTooltip, paramView, paramInt);
    paramInt = paramTooltip.getDisplayDuration();
    if (paramInt > 0) {
      localTooltipView.animate().alpha(0.0F).setDuration(800L).setStartDelay(paramInt);
    }
    return true;
  }
  
  public void hideAll()
  {
    removeAllViews();
    tooltipsList.clear();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0) {
      hideVisibleTooltips();
    }
    return false;
  }
  
  public void tryToShowAndMarkShown(String paramString)
  {
    tryToShowAndMarkShown(paramString, null, 17);
  }
  
  public boolean tryToShowAndMarkShown(String paramString, View paramView, int paramInt)
  {
    return tryToShowAndMarkShown(tooltipService.getTooltip(paramString), paramView, paramInt);
  }
  
  public boolean tryToShowAndMarkShown(Tooltip paramTooltip, View paramView, int paramInt)
  {
    if ((paramInt == 48) || (paramInt == 80) || (paramInt == 17)) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool, "Expected gravity values: TOP|BOTTOM|CENTER");
      if (!tryToShow(paramTooltip, paramView, paramInt)) {
        break;
      }
      paramTooltip.markShown();
      tooltipService.saveTooltip(paramTooltip);
      return true;
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.tooltips.TooltipContainerView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */