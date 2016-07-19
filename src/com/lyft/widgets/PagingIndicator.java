package com.lyft.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import java.util.ArrayList;
import java.util.List;

public class PagingIndicator
  extends LinearLayout
{
  private final List<View> views = new ArrayList();
  
  public PagingIndicator(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void selectPosition(int paramInt)
  {
    int i;
    label27:
    View localView;
    if (paramInt >= views.size())
    {
      paramInt = views.size() - 1;
      i = 0;
      if (i >= views.size()) {
        return;
      }
      localView = (View)views.get(i);
      if (paramInt != i) {
        break label78;
      }
    }
    label78:
    for (boolean bool = true;; bool = false)
    {
      localView.setSelected(bool);
      i += 1;
      break label27;
      break;
    }
  }
  
  public void setNumberOfViews(int paramInt)
  {
    if (views.size() == paramInt) {
      return;
    }
    if (views.size() > paramInt) {
      views.clear();
    }
    if (paramInt <= 1) {}
    for (int i = 8;; i = 0)
    {
      setVisibility(i);
      i = views.size();
      while (i < paramInt)
      {
        View localView = LayoutInflater.from(getContext()).inflate(R.layout.view_pager_indicator, this, false);
        views.add(localView);
        addView(localView);
        i += 1;
      }
      break;
    }
  }
}

/* Location:
 * Qualified Name:     com.lyft.widgets.PagingIndicator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */