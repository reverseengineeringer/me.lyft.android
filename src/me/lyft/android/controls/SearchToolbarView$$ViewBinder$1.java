package me.lyft.android.controls;

import android.view.View;
import butterknife.internal.DebouncingOnClickListener;

class SearchToolbarView$$ViewBinder$1
  extends DebouncingOnClickListener
{
  SearchToolbarView$$ViewBinder$1(SearchToolbarView..ViewBinder paramViewBinder, SearchToolbarView paramSearchToolbarView) {}
  
  public void doClick(View paramView)
  {
    val$target.onClearClicked();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.controls.SearchToolbarView..ViewBinder.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */